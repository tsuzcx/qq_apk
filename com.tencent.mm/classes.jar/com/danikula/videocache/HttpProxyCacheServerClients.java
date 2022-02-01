package com.danikula.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.danikula.videocache.file.FileCache;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

final class HttpProxyCacheServerClients
{
  private final AtomicInteger clientsCount;
  private final Config config;
  private final List<CacheListener> listeners;
  private volatile HttpProxyCache proxyCache;
  private final CacheListener uiCacheListener;
  private final String url;
  
  public HttpProxyCacheServerClients(String paramString, Config paramConfig)
  {
    AppMethodBeat.i(183580);
    this.clientsCount = new AtomicInteger(0);
    this.listeners = new CopyOnWriteArrayList();
    this.url = ((String)Preconditions.checkNotNull(paramString));
    this.config = ((Config)Preconditions.checkNotNull(paramConfig));
    this.uiCacheListener = new UiListenerHandler(paramString, this.listeners);
    AppMethodBeat.o(183580);
  }
  
  private void finishProcessRequest()
  {
    try
    {
      AppMethodBeat.i(183582);
      if (this.clientsCount.decrementAndGet() <= 0)
      {
        this.proxyCache.shutdown();
        this.proxyCache = null;
      }
      AppMethodBeat.o(183582);
      return;
    }
    finally {}
  }
  
  private HttpProxyCache newHttpProxyCache()
  {
    AppMethodBeat.i(195143);
    HttpProxyCache localHttpProxyCache = new HttpProxyCache(new HttpUrlSource(this.url, this.config.sourceInfoStorage, this.config.headerInjector), new FileCache(this.config.generateCacheFile(this.url), this.config.diskUsage));
    localHttpProxyCache.registerCacheListener(this.uiCacheListener);
    AppMethodBeat.o(195143);
    return localHttpProxyCache;
  }
  
  /* Error */
  private void startProcessRequest()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 117
    //   4: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 74	com/danikula/videocache/HttpProxyCacheServerClients:proxyCache	Lcom/danikula/videocache/HttpProxyCache;
    //   11: ifnonnull +21 -> 32
    //   14: aload_0
    //   15: invokespecial 119	com/danikula/videocache/HttpProxyCacheServerClients:newHttpProxyCache	()Lcom/danikula/videocache/HttpProxyCache;
    //   18: astore_1
    //   19: aload_0
    //   20: aload_1
    //   21: putfield 74	com/danikula/videocache/HttpProxyCacheServerClients:proxyCache	Lcom/danikula/videocache/HttpProxyCache;
    //   24: ldc 117
    //   26: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: getfield 74	com/danikula/videocache/HttpProxyCacheServerClients:proxyCache	Lcom/danikula/videocache/HttpProxyCache;
    //   36: astore_1
    //   37: goto -18 -> 19
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	HttpProxyCacheServerClients
    //   18	19	1	localHttpProxyCache	HttpProxyCache
    //   40	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	40	finally
    //   19	29	40	finally
    //   32	37	40	finally
  }
  
  public final int getClientsCount()
  {
    AppMethodBeat.i(195142);
    int i = this.clientsCount.get();
    AppMethodBeat.o(195142);
    return i;
  }
  
  public final void processRequest(GetRequest paramGetRequest, Socket paramSocket)
  {
    AppMethodBeat.i(195138);
    startProcessRequest();
    try
    {
      this.clientsCount.incrementAndGet();
      this.proxyCache.processRequest(paramGetRequest, paramSocket);
      return;
    }
    finally
    {
      finishProcessRequest();
      AppMethodBeat.o(195138);
    }
  }
  
  public final void registerCacheListener(CacheListener paramCacheListener)
  {
    AppMethodBeat.i(195139);
    this.listeners.add(paramCacheListener);
    AppMethodBeat.o(195139);
  }
  
  public final void shutdown()
  {
    AppMethodBeat.i(195141);
    this.listeners.clear();
    if (this.proxyCache != null)
    {
      this.proxyCache.registerCacheListener(null);
      this.proxyCache.shutdown();
      this.proxyCache = null;
    }
    this.clientsCount.set(0);
    AppMethodBeat.o(195141);
  }
  
  public final void unregisterCacheListener(CacheListener paramCacheListener)
  {
    AppMethodBeat.i(195140);
    this.listeners.remove(paramCacheListener);
    AppMethodBeat.o(195140);
  }
  
  static final class UiListenerHandler
    extends Handler
    implements CacheListener
  {
    private final List<CacheListener> listeners;
    private final String url;
    
    public UiListenerHandler(String paramString, List<CacheListener> paramList)
    {
      super();
      AppMethodBeat.i(183577);
      this.url = paramString;
      this.listeners = paramList;
      AppMethodBeat.o(183577);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(183579);
      Iterator localIterator = this.listeners.iterator();
      while (localIterator.hasNext()) {
        ((CacheListener)localIterator.next()).onCacheAvailable((File)paramMessage.obj, this.url, paramMessage.arg1);
      }
      AppMethodBeat.o(183579);
    }
    
    public final void onCacheAvailable(File paramFile, String paramString, int paramInt)
    {
      AppMethodBeat.i(195137);
      paramString = obtainMessage();
      paramString.arg1 = paramInt;
      paramString.obj = paramFile;
      sendMessage(paramString);
      AppMethodBeat.o(195137);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.danikula.videocache.HttpProxyCacheServerClients
 * JD-Core Version:    0.7.0.1
 */