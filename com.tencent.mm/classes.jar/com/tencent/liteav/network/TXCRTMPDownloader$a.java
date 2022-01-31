package com.tencent.liteav.network;

import com.tencent.matrix.trace.core.AppMethodBeat;

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
    AppMethodBeat.i(67531);
    try
    {
      if (this.b != 0L) {
        TXCRTMPDownloader.access$300(this.a, this.b);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(67531);
    }
  }
  
  public TXCStreamDownloader.DownloadStats b()
  {
    AppMethodBeat.i(67532);
    TXCStreamDownloader.DownloadStats localDownloadStats = null;
    try
    {
      if (this.b != 0L) {
        localDownloadStats = TXCRTMPDownloader.access$400(this.a, this.b);
      }
      return localDownloadStats;
    }
    finally
    {
      AppMethodBeat.o(67532);
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 53
    //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: aload_0
    //   9: getfield 18	com/tencent/liteav/network/TXCRTMPDownloader$a:a	Lcom/tencent/liteav/network/TXCRTMPDownloader;
    //   12: aload_0
    //   13: getfield 18	com/tencent/liteav/network/TXCRTMPDownloader$a:a	Lcom/tencent/liteav/network/TXCRTMPDownloader;
    //   16: getfield 56	com/tencent/liteav/network/TXCRTMPDownloader:mUserID	Ljava/lang/String;
    //   19: aload_0
    //   20: getfield 18	com/tencent/liteav/network/TXCRTMPDownloader$a:a	Lcom/tencent/liteav/network/TXCRTMPDownloader;
    //   23: getfield 59	com/tencent/liteav/network/TXCRTMPDownloader:mOriginUrl	Ljava/lang/String;
    //   26: aload_0
    //   27: getfield 27	com/tencent/liteav/network/TXCRTMPDownloader$a:c	Ljava/lang/String;
    //   30: aload_0
    //   31: getfield 29	com/tencent/liteav/network/TXCRTMPDownloader$a:d	Z
    //   34: aload_0
    //   35: getfield 18	com/tencent/liteav/network/TXCRTMPDownloader$a:a	Lcom/tencent/liteav/network/TXCRTMPDownloader;
    //   38: getfield 62	com/tencent/liteav/network/TXCRTMPDownloader:mEnableMessage	Z
    //   41: invokestatic 66	com/tencent/liteav/network/TXCRTMPDownloader:access$000	(Lcom/tencent/liteav/network/TXCRTMPDownloader;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)J
    //   44: putfield 25	com/tencent/liteav/network/TXCRTMPDownloader$a:b	J
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_0
    //   50: getfield 18	com/tencent/liteav/network/TXCRTMPDownloader$a:a	Lcom/tencent/liteav/network/TXCRTMPDownloader;
    //   53: aload_0
    //   54: getfield 25	com/tencent/liteav/network/TXCRTMPDownloader$a:b	J
    //   57: invokestatic 69	com/tencent/liteav/network/TXCRTMPDownloader:access$100	(Lcom/tencent/liteav/network/TXCRTMPDownloader;J)V
    //   60: aload_0
    //   61: monitorenter
    //   62: aload_0
    //   63: getfield 18	com/tencent/liteav/network/TXCRTMPDownloader$a:a	Lcom/tencent/liteav/network/TXCRTMPDownloader;
    //   66: aload_0
    //   67: getfield 25	com/tencent/liteav/network/TXCRTMPDownloader$a:b	J
    //   70: invokestatic 72	com/tencent/liteav/network/TXCRTMPDownloader:access$200	(Lcom/tencent/liteav/network/TXCRTMPDownloader;J)V
    //   73: aload_0
    //   74: lconst_0
    //   75: putfield 25	com/tencent/liteav/network/TXCRTMPDownloader$a:b	J
    //   78: aload_0
    //   79: monitorexit
    //   80: ldc 53
    //   82: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: return
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: ldc 53
    //   91: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aload_1
    //   95: athrow
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: ldc 53
    //   101: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: aload_1
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	a
    //   86	9	1	localObject1	Object
    //   96	9	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   7	49	86	finally
    //   87	89	86	finally
    //   62	80	96	finally
    //   97	99	96	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.network.TXCRTMPDownloader.a
 * JD-Core Version:    0.7.0.1
 */