package com.danikula.videocache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicInteger;

class ProxyCache
{
  private static final int MAX_READ_SOURCE_ATTEMPTS = 1;
  private final Cache cache;
  private volatile int percentsAvailable;
  private final AtomicInteger readSourceErrorsCount;
  private final Source source;
  private volatile Thread sourceReaderThread;
  private final Object stopLock;
  private volatile boolean stopped;
  private final Object wc;
  
  public ProxyCache(Source paramSource, Cache paramCache)
  {
    AppMethodBeat.i(183603);
    this.wc = new Object();
    this.stopLock = new Object();
    this.percentsAvailable = -1;
    this.source = ((Source)Preconditions.checkNotNull(paramSource));
    this.cache = ((Cache)Preconditions.checkNotNull(paramCache));
    this.readSourceErrorsCount = new AtomicInteger();
    AppMethodBeat.o(183603);
  }
  
  private void checkReadSourceErrorsCount()
  {
    AppMethodBeat.i(223188);
    int i = this.readSourceErrorsCount.get();
    if (i > 0)
    {
      this.readSourceErrorsCount.set(0);
      ProxyCacheException localProxyCacheException = new ProxyCacheException("Error reading source " + i + " times");
      AppMethodBeat.o(223188);
      throw localProxyCacheException;
    }
    AppMethodBeat.o(223188);
  }
  
  private void closeSource()
  {
    AppMethodBeat.i(183608);
    try
    {
      this.source.close();
      AppMethodBeat.o(183608);
      return;
    }
    catch (ProxyCacheException localProxyCacheException)
    {
      onError(new ProxyCacheException("Error closing source " + this.source, localProxyCacheException));
      AppMethodBeat.o(183608);
    }
  }
  
  private boolean isStopped()
  {
    AppMethodBeat.i(183607);
    if ((Thread.currentThread().isInterrupted()) || (this.stopped))
    {
      AppMethodBeat.o(183607);
      return true;
    }
    AppMethodBeat.o(183607);
    return false;
  }
  
  private void notifyNewCacheDataAvailable(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(183606);
    onCacheAvailable(paramLong1, paramLong2);
    synchronized (this.wc)
    {
      this.wc.notifyAll();
      AppMethodBeat.o(183606);
      return;
    }
  }
  
  private void onSourceRead()
  {
    AppMethodBeat.i(223193);
    this.percentsAvailable = 100;
    onCachePercentsAvailableChanged(this.percentsAvailable);
    AppMethodBeat.o(223193);
  }
  
  private void readSource()
  {
    AppMethodBeat.i(223192);
    long l6 = -1L;
    long l2 = 0L;
    long l1 = l2;
    long l4 = l6;
    long l5 = l6;
    long l3;
    try
    {
      l3 = this.cache.available();
      l1 = l3;
      l4 = l6;
      l2 = l3;
      l5 = l6;
      this.source.open(l3);
      l1 = l3;
      l4 = l6;
      l2 = l3;
      l5 = l6;
      l6 = this.source.length();
      l1 = l3;
      l4 = l6;
      l2 = l3;
      l5 = l6;
      arrayOfByte = new byte[8192];
    }
    catch (Throwable localThrowable)
    {
      byte[] arrayOfByte;
      int i;
      Object localObject1;
      localThrowable = localThrowable;
      l2 = l1;
      l5 = l4;
      this.readSourceErrorsCount.incrementAndGet();
      l2 = l1;
      l5 = l4;
      onError(localThrowable);
      return;
    }
    finally
    {
      closeSource();
      notifyNewCacheDataAvailable(l2, l5);
      AppMethodBeat.o(223192);
    }
    l1 = l3;
    l4 = l6;
    l2 = l3;
    l5 = l6;
    i = this.source.read(arrayOfByte);
    if (i != -1)
    {
      l1 = l3;
      l4 = l6;
      l2 = l3;
      l5 = l6;
      localObject1 = this.stopLock;
      l1 = l3;
      l4 = l6;
      l2 = l3;
      l5 = l6;
    }
    l1 = l3;
    l4 = l6;
    l2 = l3;
    l5 = l6;
    tryComplete();
    l1 = l3;
    l4 = l6;
    l2 = l3;
    l5 = l6;
    onSourceRead();
    closeSource();
    notifyNewCacheDataAvailable(l3, l6);
    AppMethodBeat.o(223192);
  }
  
  /* Error */
  private void readSourceAsync()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 189
    //   4: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 191	com/danikula/videocache/ProxyCache:sourceReaderThread	Ljava/lang/Thread;
    //   11: ifnull +95 -> 106
    //   14: aload_0
    //   15: getfield 191	com/danikula/videocache/ProxyCache:sourceReaderThread	Ljava/lang/Thread;
    //   18: invokevirtual 195	java/lang/Thread:getState	()Ljava/lang/Thread$State;
    //   21: getstatic 201	java/lang/Thread$State:TERMINATED	Ljava/lang/Thread$State;
    //   24: if_acmpeq +82 -> 106
    //   27: iconst_1
    //   28: istore_1
    //   29: aload_0
    //   30: getfield 136	com/danikula/videocache/ProxyCache:stopped	Z
    //   33: ifne +65 -> 98
    //   36: aload_0
    //   37: getfield 58	com/danikula/videocache/ProxyCache:cache	Lcom/danikula/videocache/Cache;
    //   40: invokeinterface 204 1 0
    //   45: ifne +53 -> 98
    //   48: iload_1
    //   49: ifne +49 -> 98
    //   52: aload_0
    //   53: new 127	java/lang/Thread
    //   56: dup
    //   57: new 8	com/danikula/videocache/ProxyCache$SourceReaderRunnable
    //   60: dup
    //   61: aload_0
    //   62: aconst_null
    //   63: invokespecial 207	com/danikula/videocache/ProxyCache$SourceReaderRunnable:<init>	(Lcom/danikula/videocache/ProxyCache;Lcom/danikula/videocache/ProxyCache$1;)V
    //   66: new 86	java/lang/StringBuilder
    //   69: dup
    //   70: ldc 209
    //   72: invokespecial 91	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   75: aload_0
    //   76: getfield 54	com/danikula/videocache/ProxyCache:source	Lcom/danikula/videocache/Source;
    //   79: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokespecial 212	java/lang/Thread:<init>	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   88: putfield 191	com/danikula/videocache/ProxyCache:sourceReaderThread	Ljava/lang/Thread;
    //   91: aload_0
    //   92: getfield 191	com/danikula/videocache/ProxyCache:sourceReaderThread	Ljava/lang/Thread;
    //   95: invokevirtual 215	java/lang/Thread:start	()V
    //   98: ldc 189
    //   100: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: aload_0
    //   104: monitorexit
    //   105: return
    //   106: iconst_0
    //   107: istore_1
    //   108: goto -79 -> 29
    //   111: astore_2
    //   112: aload_0
    //   113: monitorexit
    //   114: aload_2
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	ProxyCache
    //   28	80	1	i	int
    //   111	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	27	111	finally
    //   29	48	111	finally
    //   52	98	111	finally
    //   98	103	111	finally
  }
  
  private void tryComplete()
  {
    AppMethodBeat.i(223194);
    synchronized (this.stopLock)
    {
      if ((!isStopped()) && (this.cache.available() == this.source.length())) {
        this.cache.complete();
      }
      AppMethodBeat.o(223194);
      return;
    }
  }
  
  private void waitForSourceData()
  {
    AppMethodBeat.i(223190);
    synchronized (this.wc)
    {
      try
      {
        this.wc.wait(1000L);
        AppMethodBeat.o(223190);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        ProxyCacheException localProxyCacheException = new ProxyCacheException("Waiting source data is interrupted!", localInterruptedException);
        AppMethodBeat.o(223190);
        throw localProxyCacheException;
      }
    }
  }
  
  protected void onCacheAvailable(long paramLong1, long paramLong2)
  {
    int k = 1;
    AppMethodBeat.i(223191);
    int i;
    label26:
    int j;
    if (paramLong2 == 0L)
    {
      i = 1;
      if (i == 0) {
        break label78;
      }
      i = 100;
      if (i == this.percentsAvailable) {
        break label92;
      }
      j = 1;
      label38:
      if (paramLong2 < 0L) {
        break label98;
      }
    }
    for (;;)
    {
      if ((k != 0) && (j != 0)) {
        onCachePercentsAvailableChanged(i);
      }
      this.percentsAvailable = i;
      AppMethodBeat.o(223191);
      return;
      i = 0;
      break;
      label78:
      i = (int)((float)paramLong1 / (float)paramLong2 * 100.0F);
      break label26;
      label92:
      j = 0;
      break label38;
      label98:
      k = 0;
    }
  }
  
  protected void onCachePercentsAvailableChanged(int paramInt) {}
  
  protected final void onError(Throwable paramThrowable)
  {
    AppMethodBeat.i(183609);
    if ((paramThrowable instanceof InterruptedProxyCacheException))
    {
      Logger.debug("ProxyCache is interrupted");
      AppMethodBeat.o(183609);
      return;
    }
    Logger.error("ProxyCache error");
    AppMethodBeat.o(183609);
  }
  
  public int read(byte[] paramArrayOfByte, long paramLong, int paramInt)
  {
    AppMethodBeat.i(223187);
    ProxyCacheUtils.assertBuffer(paramArrayOfByte, paramLong, paramInt);
    while ((!this.cache.isCompleted()) && (this.cache.available() < paramInt + paramLong) && (!this.stopped))
    {
      readSourceAsync();
      waitForSourceData();
      checkReadSourceErrorsCount();
    }
    paramInt = this.cache.read(paramArrayOfByte, paramLong, paramInt);
    if ((this.cache.isCompleted()) && (this.percentsAvailable != 100))
    {
      this.percentsAvailable = 100;
      onCachePercentsAvailableChanged(100);
    }
    AppMethodBeat.o(223187);
    return paramInt;
  }
  
  public void shutdown()
  {
    AppMethodBeat.i(223189);
    synchronized (this.stopLock)
    {
      Logger.debug("Shutdown proxy for " + this.source);
      try
      {
        this.stopped = true;
        if (this.sourceReaderThread != null) {
          this.sourceReaderThread.interrupt();
        }
        this.cache.close();
      }
      catch (ProxyCacheException localProxyCacheException)
      {
        for (;;)
        {
          onError(localProxyCacheException);
        }
      }
      AppMethodBeat.o(223189);
      return;
    }
  }
  
  class SourceReaderRunnable
    implements Runnable
  {
    private SourceReaderRunnable() {}
    
    public void run()
    {
      AppMethodBeat.i(183602);
      ProxyCache.access$100(ProxyCache.this);
      AppMethodBeat.o(183602);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.danikula.videocache.ProxyCache
 * JD-Core Version:    0.7.0.1
 */