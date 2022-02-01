package com.squareup.okhttp.ws;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.StreamAllocation;
import com.squareup.okhttp.internal.io.RealConnection;
import com.squareup.okhttp.internal.ws.RealWebSocket;
import java.io.IOException;
import java.net.ProtocolException;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okio.ByteString;

public final class WebSocketCall
{
  private final Call call;
  private final String key;
  private final Random random;
  
  WebSocketCall(OkHttpClient paramOkHttpClient, Request paramRequest)
  {
    this(paramOkHttpClient, paramRequest, new SecureRandom());
  }
  
  WebSocketCall(OkHttpClient paramOkHttpClient, Request paramRequest, Random paramRandom)
  {
    if (!"GET".equals(paramRequest.method())) {
      throw new IllegalArgumentException("Request must be GET: " + paramRequest.method());
    }
    this.random = paramRandom;
    byte[] arrayOfByte = new byte[16];
    paramRandom.nextBytes(arrayOfByte);
    this.key = ByteString.of(arrayOfByte).base64();
    paramOkHttpClient = paramOkHttpClient.clone();
    paramOkHttpClient.setProtocols(Collections.singletonList(Protocol.HTTP_1_1));
    this.call = paramOkHttpClient.newCall(paramRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").build());
  }
  
  public static WebSocketCall create(OkHttpClient paramOkHttpClient, Request paramRequest)
  {
    return new WebSocketCall(paramOkHttpClient, paramRequest);
  }
  
  private void createWebSocket(Response paramResponse, WebSocketListener paramWebSocketListener)
    throws IOException
  {
    if (paramResponse.code() != 101)
    {
      Util.closeQuietly(paramResponse.body());
      throw new ProtocolException("Expected HTTP 101 response but was '" + paramResponse.code() + " " + paramResponse.message() + "'");
    }
    Object localObject = paramResponse.header("Connection");
    if (!"Upgrade".equalsIgnoreCase((String)localObject)) {
      throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + (String)localObject + "'");
    }
    localObject = paramResponse.header("Upgrade");
    if (!"websocket".equalsIgnoreCase((String)localObject)) {
      throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + (String)localObject + "'");
    }
    localObject = paramResponse.header("Sec-WebSocket-Accept");
    String str = Util.shaBase64(this.key + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
    if (!str.equals(localObject)) {
      throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + str + "' but was '" + (String)localObject + "'");
    }
    localObject = StreamWebSocket.create(Internal.instance.callEngineGetStreamAllocation(this.call), paramResponse, this.random, paramWebSocketListener);
    paramWebSocketListener.onOpen((WebSocket)localObject, paramResponse);
    while (((RealWebSocket)localObject).readMessage()) {}
  }
  
  public void cancel()
  {
    this.call.cancel();
  }
  
  public void enqueue(final WebSocketListener paramWebSocketListener)
  {
    paramWebSocketListener = new Callback()
    {
      public void onFailure(Request paramAnonymousRequest, IOException paramAnonymousIOException)
      {
        paramWebSocketListener.onFailure(paramAnonymousIOException, null);
      }
      
      public void onResponse(Response paramAnonymousResponse)
        throws IOException
      {
        try
        {
          WebSocketCall.this.createWebSocket(paramAnonymousResponse, paramWebSocketListener);
          return;
        }
        catch (IOException localIOException)
        {
          paramWebSocketListener.onFailure(localIOException, paramAnonymousResponse);
        }
      }
    };
    Internal.instance.callEnqueue(this.call, paramWebSocketListener, true);
  }
  
  private static class StreamWebSocket
    extends RealWebSocket
  {
    private final ExecutorService replyExecutor;
    private final StreamAllocation streamAllocation;
    
    private StreamWebSocket(StreamAllocation paramStreamAllocation, Random paramRandom, ExecutorService paramExecutorService, WebSocketListener paramWebSocketListener, String paramString)
    {
      super(paramStreamAllocation.connection().source, paramStreamAllocation.connection().sink, paramRandom, paramExecutorService, paramWebSocketListener, paramString);
      this.streamAllocation = paramStreamAllocation;
      this.replyExecutor = paramExecutorService;
    }
    
    static RealWebSocket create(StreamAllocation paramStreamAllocation, Response paramResponse, Random paramRandom, WebSocketListener paramWebSocketListener)
    {
      paramResponse = paramResponse.request().urlString();
      ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque(), Util.threadFactory(String.format("OkHttp %s WebSocket", new Object[] { paramResponse }), true));
      localThreadPoolExecutor.allowCoreThreadTimeOut(true);
      return new StreamWebSocket(paramStreamAllocation, paramRandom, localThreadPoolExecutor, paramWebSocketListener, paramResponse);
    }
    
    protected void close()
      throws IOException
    {
      this.replyExecutor.shutdown();
      this.streamAllocation.noNewStreams();
      this.streamAllocation.streamFinished(this.streamAllocation.stream());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.squareup.okhttp.ws.WebSocketCall
 * JD-Core Version:    0.7.0.1
 */