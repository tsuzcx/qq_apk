package com.danikula.videocache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class Pinger
{
  private static final String PING_REQUEST = "ping";
  private static final String PING_RESPONSE = "ping ok";
  private final String host;
  private final ExecutorService pingExecutor;
  private final int port;
  
  Pinger(String paramString, int paramInt)
  {
    AppMethodBeat.i(215865);
    this.pingExecutor = Executors.newSingleThreadExecutor();
    this.host = ((String)Preconditions.checkNotNull(paramString));
    this.port = paramInt;
    AppMethodBeat.o(215865);
  }
  
  private List<Proxy> getDefaultProxies()
  {
    AppMethodBeat.i(215867);
    try
    {
      List localList = ProxySelector.getDefault().select(new URI(getPingUrl()));
      AppMethodBeat.o(215867);
      return localList;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException(localURISyntaxException);
      AppMethodBeat.o(215867);
      throw localIllegalStateException;
    }
  }
  
  private String getPingUrl()
  {
    AppMethodBeat.i(215871);
    String str = String.format(Locale.US, "http://%s:%d/%s", new Object[] { this.host, Integer.valueOf(this.port), "ping" });
    AppMethodBeat.o(215871);
    return str;
  }
  
  private boolean pingServer()
  {
    AppMethodBeat.i(215870);
    HttpUrlSource localHttpUrlSource = new HttpUrlSource(getPingUrl());
    try
    {
      byte[] arrayOfByte1 = "ping ok".getBytes();
      localHttpUrlSource.open(0L);
      byte[] arrayOfByte2 = new byte[arrayOfByte1.length];
      localHttpUrlSource.read(arrayOfByte2);
      boolean bool = Arrays.equals(arrayOfByte1, arrayOfByte2);
      Logger.info("Ping response: `" + new String(arrayOfByte2) + "`, pinged? " + bool);
      return bool;
    }
    catch (ProxyCacheException localProxyCacheException)
    {
      Logger.error("Error reading ping response");
      return false;
    }
    finally
    {
      localHttpUrlSource.close();
      AppMethodBeat.o(215870);
    }
  }
  
  boolean isPingRequest(String paramString)
  {
    AppMethodBeat.i(215868);
    boolean bool = "ping".equals(paramString);
    AppMethodBeat.o(215868);
    return bool;
  }
  
  boolean ping(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(215866);
    boolean bool;
    if (paramInt1 > 0) {
      bool = true;
    }
    for (;;)
    {
      Preconditions.checkArgument(bool);
      int i;
      if (paramInt2 > 0)
      {
        bool = true;
        Preconditions.checkArgument(bool);
        int j = 0;
        i = paramInt2;
        paramInt2 = j;
        label37:
        if (paramInt2 >= paramInt1) {
          break label158;
        }
      }
      try
      {
        bool = ((Boolean)this.pingExecutor.submit(new PingCallable(null)).get(i, TimeUnit.MILLISECONDS)).booleanValue();
        if (bool)
        {
          AppMethodBeat.o(215866);
          return true;
          bool = false;
          continue;
          bool = false;
        }
      }
      catch (TimeoutException localTimeoutException)
      {
        Logger.warn("Error pinging server (attempt: " + paramInt2 + ", timeout: " + i + "). ");
        i *= 2;
        paramInt2 += 1;
        break label37;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          Logger.error("Error pinging server due to unexpected error");
        }
        Logger.error(String.format(Locale.US, "Error pinging server (attempts: %d, max timeout: %d). If you see this message, please, report at https://github.com/danikula/AndroidVideoCache/issues/134. Default proxies are: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(i / 2), getDefaultProxies() }));
        AppMethodBeat.o(215866);
        return false;
      }
      catch (ExecutionException localExecutionException)
      {
        label150:
        label158:
        break label150;
      }
    }
  }
  
  void responseToPing(Socket paramSocket)
  {
    AppMethodBeat.i(215869);
    paramSocket = paramSocket.getOutputStream();
    paramSocket.write("HTTP/1.1 200 OK\n\n".getBytes());
    paramSocket.write("ping ok".getBytes());
    AppMethodBeat.o(215869);
  }
  
  class PingCallable
    implements Callable<Boolean>
  {
    private PingCallable() {}
    
    public Boolean call()
    {
      AppMethodBeat.i(215863);
      boolean bool = Pinger.access$100(Pinger.this);
      AppMethodBeat.o(215863);
      return Boolean.valueOf(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.danikula.videocache.Pinger
 * JD-Core Version:    0.7.0.1
 */