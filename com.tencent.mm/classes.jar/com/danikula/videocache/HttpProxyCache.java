package com.danikula.videocache;

import android.text.TextUtils;
import com.danikula.videocache.file.FileCache;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

class HttpProxyCache
  extends ProxyCache
{
  private static final float NO_CACHE_BARRIER = 0.2F;
  private final FileCache cache;
  private CacheListener listener;
  private final HttpUrlSource source;
  
  public HttpProxyCache(HttpUrlSource paramHttpUrlSource, FileCache paramFileCache)
  {
    super(paramHttpUrlSource, paramFileCache);
    this.cache = paramFileCache;
    this.source = paramHttpUrlSource;
  }
  
  private String format(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(183567);
    paramString = String.format(Locale.US, paramString, paramVarArgs);
    AppMethodBeat.o(183567);
    return paramString;
  }
  
  private boolean isUseCache(GetRequest paramGetRequest)
  {
    AppMethodBeat.i(190275);
    long l1 = this.source.length();
    if (l1 > 0L) {}
    for (int i = 1;; i = 0)
    {
      long l2 = this.cache.available();
      if ((i != 0) && (paramGetRequest.partial) && ((float)paramGetRequest.rangeOffset > (float)l2 + (float)l1 * 0.2F)) {
        break;
      }
      AppMethodBeat.o(190275);
      return true;
    }
    AppMethodBeat.o(190275);
    return false;
  }
  
  private String newResponseHeaders(GetRequest paramGetRequest)
  {
    AppMethodBeat.i(190276);
    String str = this.source.getMime();
    int i;
    long l1;
    label43:
    int j;
    label52:
    long l2;
    label68:
    int k;
    label82:
    Object localObject;
    if (!TextUtils.isEmpty(str))
    {
      i = 1;
      if (!this.cache.isCompleted()) {
        break label248;
      }
      l1 = this.cache.available();
      if (l1 < 0L) {
        break label260;
      }
      j = 1;
      if (!paramGetRequest.partial) {
        break label265;
      }
      l2 = l1 - paramGetRequest.rangeOffset;
      if ((j == 0) || (!paramGetRequest.partial)) {
        break label272;
      }
      k = 1;
      StringBuilder localStringBuilder = new StringBuilder();
      if (!paramGetRequest.partial) {
        break label278;
      }
      localObject = "HTTP/1.1 206 PARTIAL CONTENT\n";
      label102:
      localStringBuilder = localStringBuilder.append((String)localObject).append("Accept-Ranges: bytes\n");
      if (j == 0) {
        break label285;
      }
      localObject = format("Content-Length: %d\n", new Object[] { Long.valueOf(l2) });
      label140:
      localObject = localStringBuilder.append((String)localObject);
      if (k == 0) {
        break label292;
      }
      paramGetRequest = format("Content-Range: bytes %d-%d/%d\n", new Object[] { Long.valueOf(paramGetRequest.rangeOffset), Long.valueOf(l1 - 1L), Long.valueOf(l1) });
      label193:
      localObject = ((StringBuilder)localObject).append(paramGetRequest);
      if (i == 0) {
        break label298;
      }
    }
    label260:
    label265:
    label272:
    label278:
    label285:
    label292:
    label298:
    for (paramGetRequest = format("Content-Type: %s\n", new Object[] { str });; paramGetRequest = "")
    {
      paramGetRequest = paramGetRequest + "\n";
      AppMethodBeat.o(190276);
      return paramGetRequest;
      i = 0;
      break;
      label248:
      l1 = this.source.length();
      break label43;
      j = 0;
      break label52;
      l2 = l1;
      break label68;
      k = 0;
      break label82;
      localObject = "HTTP/1.1 200 OK\n";
      break label102;
      localObject = "";
      break label140;
      paramGetRequest = "";
      break label193;
    }
  }
  
  private void responseWithCache(OutputStream paramOutputStream, long paramLong)
  {
    AppMethodBeat.i(183565);
    byte[] arrayOfByte = new byte[8192];
    for (;;)
    {
      int i = read(arrayOfByte, paramLong, 8192);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
      paramLong += i;
    }
    paramOutputStream.flush();
    AppMethodBeat.o(183565);
  }
  
  private void responseWithoutCache(OutputStream paramOutputStream, long paramLong)
  {
    AppMethodBeat.i(183566);
    HttpUrlSource localHttpUrlSource = new HttpUrlSource(this.source);
    paramLong = (int)paramLong;
    try
    {
      localHttpUrlSource.open(paramLong);
      byte[] arrayOfByte = new byte[8192];
      for (;;)
      {
        int i = localHttpUrlSource.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        paramOutputStream.write(arrayOfByte, 0, i);
      }
      paramOutputStream.flush();
    }
    finally
    {
      localHttpUrlSource.close();
      AppMethodBeat.o(183566);
    }
    localHttpUrlSource.close();
    AppMethodBeat.o(183566);
  }
  
  protected void onCachePercentsAvailableChanged(int paramInt)
  {
    AppMethodBeat.i(183568);
    if (this.listener != null) {
      this.listener.onCacheAvailable(this.cache.file, this.source.getUrl(), paramInt);
    }
    AppMethodBeat.o(183568);
  }
  
  public void processRequest(GetRequest paramGetRequest, Socket paramSocket)
  {
    AppMethodBeat.i(190274);
    paramSocket = new BufferedOutputStream(paramSocket.getOutputStream());
    paramSocket.write(newResponseHeaders(paramGetRequest).getBytes("UTF-8"));
    long l = paramGetRequest.rangeOffset;
    if (isUseCache(paramGetRequest))
    {
      responseWithCache(paramSocket, l);
      AppMethodBeat.o(190274);
      return;
    }
    responseWithoutCache(paramSocket, l);
    AppMethodBeat.o(190274);
  }
  
  public void registerCacheListener(CacheListener paramCacheListener)
  {
    this.listener = paramCacheListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.danikula.videocache.HttpProxyCache
 * JD-Core Version:    0.7.0.1
 */