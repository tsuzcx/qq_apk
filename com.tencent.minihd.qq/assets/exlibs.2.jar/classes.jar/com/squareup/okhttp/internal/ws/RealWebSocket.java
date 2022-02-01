package com.squareup.okhttp.internal.ws;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.ws.WebSocket;
import com.squareup.okhttp.ws.WebSocketListener;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

public abstract class RealWebSocket
  implements WebSocket
{
  private static final int CLOSE_PROTOCOL_EXCEPTION = 1002;
  private final AtomicBoolean connectionClosed = new AtomicBoolean();
  private final WebSocketListener listener;
  private final WebSocketReader reader;
  private boolean readerSentClose;
  private final WebSocketWriter writer;
  private volatile boolean writerSentClose;
  private boolean writerWantsClose;
  
  public RealWebSocket(boolean paramBoolean, BufferedSource paramBufferedSource, BufferedSink paramBufferedSink, Random paramRandom, final Executor paramExecutor, final WebSocketListener paramWebSocketListener, final String paramString)
  {
    this.listener = paramWebSocketListener;
    this.writer = new WebSocketWriter(paramBoolean, paramBufferedSink, paramRandom);
    this.reader = new WebSocketReader(paramBoolean, paramBufferedSource, new WebSocketReader.FrameCallback()
    {
      public void onClose(final int paramAnonymousInt, final String paramAnonymousString)
      {
        RealWebSocket.access$102(RealWebSocket.this, true);
        paramExecutor.execute(new NamedRunnable("OkHttp %s WebSocket Close Reply", new Object[] { paramString })
        {
          protected void execute()
          {
            RealWebSocket.this.peerClose(paramAnonymousInt, paramAnonymousString);
          }
        });
      }
      
      public void onMessage(ResponseBody paramAnonymousResponseBody)
        throws IOException
      {
        paramWebSocketListener.onMessage(paramAnonymousResponseBody);
      }
      
      public void onPing(final Buffer paramAnonymousBuffer)
      {
        paramExecutor.execute(new NamedRunnable("OkHttp %s WebSocket Pong Reply", new Object[] { paramString })
        {
          protected void execute()
          {
            try
            {
              RealWebSocket.this.writer.writePong(paramAnonymousBuffer);
              return;
            }
            catch (IOException localIOException) {}
          }
        });
      }
      
      public void onPong(Buffer paramAnonymousBuffer)
      {
        paramWebSocketListener.onPong(paramAnonymousBuffer);
      }
    });
  }
  
  private void peerClose(int paramInt, String paramString)
  {
    if (!this.writerSentClose) {}
    try
    {
      this.writer.writeClose(paramInt, paramString);
      label16:
      if (this.connectionClosed.compareAndSet(false, true)) {}
      try
      {
        close();
        label32:
        this.listener.onClose(paramInt, paramString);
        return;
      }
      catch (IOException localIOException1)
      {
        break label32;
      }
    }
    catch (IOException localIOException2)
    {
      break label16;
    }
  }
  
  private void readerErrorClose(IOException paramIOException)
  {
    if ((!this.writerSentClose) && ((paramIOException instanceof ProtocolException))) {}
    try
    {
      this.writer.writeClose(1002, null);
      label25:
      if (this.connectionClosed.compareAndSet(false, true)) {}
      try
      {
        close();
        label41:
        this.listener.onFailure(paramIOException, null);
        return;
      }
      catch (IOException localIOException1)
      {
        break label41;
      }
    }
    catch (IOException localIOException2)
    {
      break label25;
    }
  }
  
  protected abstract void close()
    throws IOException;
  
  public void close(int paramInt, String paramString)
    throws IOException
  {
    if (this.writerSentClose) {
      throw new IllegalStateException("closed");
    }
    this.writerSentClose = true;
    try
    {
      this.writer.writeClose(paramInt, paramString);
      return;
    }
    catch (IOException paramString)
    {
      if (!this.connectionClosed.compareAndSet(false, true)) {}
    }
    try
    {
      close();
      label49:
      throw paramString;
    }
    catch (IOException localIOException)
    {
      break label49;
    }
  }
  
  public boolean readMessage()
  {
    boolean bool1 = false;
    try
    {
      this.reader.processNextFrame();
      boolean bool2 = this.readerSentClose;
      if (!bool2) {
        bool1 = true;
      }
      return bool1;
    }
    catch (IOException localIOException)
    {
      readerErrorClose(localIOException);
    }
    return false;
  }
  
  public void sendMessage(RequestBody paramRequestBody)
    throws IOException
  {
    if (paramRequestBody == null) {
      throw new NullPointerException("message == null");
    }
    if (this.writerSentClose) {
      throw new IllegalStateException("closed");
    }
    if (this.writerWantsClose) {
      throw new IllegalStateException("must call close()");
    }
    Object localObject = paramRequestBody.contentType();
    if (localObject == null) {
      throw new IllegalArgumentException("Message content type was null. Must use WebSocket.TEXT or WebSocket.BINARY.");
    }
    String str = ((MediaType)localObject).subtype();
    if (WebSocket.TEXT.subtype().equals(str)) {}
    for (int i = 1;; i = 2)
    {
      localObject = Okio.buffer(this.writer.newMessageSink(i));
      try
      {
        paramRequestBody.writeTo((BufferedSink)localObject);
        ((BufferedSink)localObject).close();
        return;
      }
      catch (IOException paramRequestBody)
      {
        this.writerWantsClose = true;
        throw paramRequestBody;
      }
      if (!WebSocket.BINARY.subtype().equals(str)) {
        break;
      }
    }
    throw new IllegalArgumentException("Unknown message content type: " + ((MediaType)localObject).type() + "/" + ((MediaType)localObject).subtype() + ". Must use WebSocket.TEXT or WebSocket.BINARY.");
  }
  
  public void sendPing(Buffer paramBuffer)
    throws IOException
  {
    if (this.writerSentClose) {
      throw new IllegalStateException("closed");
    }
    if (this.writerWantsClose) {
      throw new IllegalStateException("must call close()");
    }
    try
    {
      this.writer.writePing(paramBuffer);
      return;
    }
    catch (IOException paramBuffer)
    {
      this.writerWantsClose = true;
      throw paramBuffer;
    }
  }
  
  public void sendPong(Buffer paramBuffer)
    throws IOException
  {
    if (this.writerSentClose) {
      throw new IllegalStateException("closed");
    }
    if (this.writerWantsClose) {
      throw new IllegalStateException("must call close()");
    }
    try
    {
      this.writer.writePong(paramBuffer);
      return;
    }
    catch (IOException paramBuffer)
    {
      this.writerWantsClose = true;
      throw paramBuffer;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.squareup.okhttp.internal.ws.RealWebSocket
 * JD-Core Version:    0.7.0.1
 */