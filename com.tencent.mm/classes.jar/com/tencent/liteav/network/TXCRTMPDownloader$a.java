package com.tencent.liteav.network;

class TXCRTMPDownloader$a
  extends Thread
{
  private long b = 0L;
  private String c;
  private boolean d;
  
  TXCRTMPDownloader$a(TXCRTMPDownloader paramTXCRTMPDownloader, String paramString, boolean paramBoolean)
  {
    super("RTMPDownLoad");
    this.c = paramString;
    this.d = paramBoolean;
  }
  
  public void a()
  {
    try
    {
      if (this.b != 0L) {
        TXCRTMPDownloader.access$300(this.a, this.b);
      }
      return;
    }
    finally {}
  }
  
  public TXCStreamDownloader.DownloadStats b()
  {
    TXCStreamDownloader.DownloadStats localDownloadStats = null;
    try
    {
      if (this.b != 0L) {
        localDownloadStats = TXCRTMPDownloader.access$400(this.a, this.b);
      }
      return localDownloadStats;
    }
    finally {}
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 18	com/tencent/liteav/network/TXCRTMPDownloader$a:a	Lcom/tencent/liteav/network/TXCRTMPDownloader;
    //   7: aload_0
    //   8: getfield 18	com/tencent/liteav/network/TXCRTMPDownloader$a:a	Lcom/tencent/liteav/network/TXCRTMPDownloader;
    //   11: getfield 44	com/tencent/liteav/network/TXCRTMPDownloader:mOriginUrl	Ljava/lang/String;
    //   14: aload_0
    //   15: getfield 27	com/tencent/liteav/network/TXCRTMPDownloader$a:c	Ljava/lang/String;
    //   18: aload_0
    //   19: getfield 29	com/tencent/liteav/network/TXCRTMPDownloader$a:d	Z
    //   22: aload_0
    //   23: getfield 18	com/tencent/liteav/network/TXCRTMPDownloader$a:a	Lcom/tencent/liteav/network/TXCRTMPDownloader;
    //   26: getfield 47	com/tencent/liteav/network/TXCRTMPDownloader:mEnableMessage	Z
    //   29: invokestatic 51	com/tencent/liteav/network/TXCRTMPDownloader:access$000	(Lcom/tencent/liteav/network/TXCRTMPDownloader;Ljava/lang/String;Ljava/lang/String;ZZ)J
    //   32: putfield 25	com/tencent/liteav/network/TXCRTMPDownloader$a:b	J
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_0
    //   38: getfield 18	com/tencent/liteav/network/TXCRTMPDownloader$a:a	Lcom/tencent/liteav/network/TXCRTMPDownloader;
    //   41: aload_0
    //   42: getfield 25	com/tencent/liteav/network/TXCRTMPDownloader$a:b	J
    //   45: invokestatic 54	com/tencent/liteav/network/TXCRTMPDownloader:access$100	(Lcom/tencent/liteav/network/TXCRTMPDownloader;J)V
    //   48: aload_0
    //   49: monitorenter
    //   50: aload_0
    //   51: getfield 18	com/tencent/liteav/network/TXCRTMPDownloader$a:a	Lcom/tencent/liteav/network/TXCRTMPDownloader;
    //   54: aload_0
    //   55: getfield 25	com/tencent/liteav/network/TXCRTMPDownloader$a:b	J
    //   58: invokestatic 57	com/tencent/liteav/network/TXCRTMPDownloader:access$200	(Lcom/tencent/liteav/network/TXCRTMPDownloader;J)V
    //   61: aload_0
    //   62: lconst_0
    //   63: putfield 25	com/tencent/liteav/network/TXCRTMPDownloader$a:b	J
    //   66: aload_0
    //   67: monitorexit
    //   68: return
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	a
    //   69	4	1	localObject1	Object
    //   74	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	37	69	finally
    //   70	72	69	finally
    //   50	68	74	finally
    //   75	77	74	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.network.TXCRTMPDownloader.a
 * JD-Core Version:    0.7.0.1
 */