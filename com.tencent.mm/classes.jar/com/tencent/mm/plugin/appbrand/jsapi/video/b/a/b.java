package com.tencent.mm.plugin.appbrand.jsapi.video.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class b
  implements d
{
  protected String TAG = "CacheDataSink";
  protected k aXd;
  private final long bFD;
  protected long bFF;
  protected long bFG;
  protected long jLu = -1L;
  private final a lqM;
  protected g lqN;
  private OutputStream lqO;
  protected c lqP = c.lrO;
  public String lqQ = "";
  private BufferedOutputStream outputStream;
  
  public b(a parama, long paramLong)
  {
    this.lqM = parama;
    this.bFD = paramLong;
  }
  
  private void boj()
  {
    AppMethodBeat.i(210995);
    this.aXd = this.lqM.a(this.lqN.key, this.lqN.absoluteStreamPosition + this.bFG, this.jLu, this.lqP, Math.min(this.lqN.length - this.bFG, this.bFD));
    AppMethodBeat.o(210995);
  }
  
  private void bok()
  {
    AppMethodBeat.i(210996);
    this.lqM.B(this.aXd);
    AppMethodBeat.o(210996);
  }
  
  private String getLogTag()
  {
    AppMethodBeat.i(210999);
    String str = this.lqQ + this.TAG;
    AppMethodBeat.o(210999);
    return str;
  }
  
  private void wG()
  {
    AppMethodBeat.i(210997);
    boj();
    h.log(4, getLogTag(), "start cache " + w.B(this.aXd.fTh()));
    this.lqO = o.aj(this.aXd);
    this.outputStream = new BufferedOutputStream(this.lqO);
    this.bFF = 0L;
    AppMethodBeat.o(210997);
  }
  
  /* Error */
  private void wH()
  {
    // Byte code:
    //   0: ldc 165
    //   2: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 159	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:outputStream	Ljava/io/BufferedOutputStream;
    //   9: ifnonnull +19 -> 28
    //   12: iconst_4
    //   13: aload_0
    //   14: invokespecial 122	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:getLogTag	()Ljava/lang/String;
    //   17: ldc 167
    //   19: invokestatic 144	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   22: ldc 165
    //   24: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: return
    //   28: aload_0
    //   29: getfield 159	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:outputStream	Ljava/io/BufferedOutputStream;
    //   32: invokevirtual 170	java/io/BufferedOutputStream:flush	()V
    //   35: aload_0
    //   36: getfield 159	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:outputStream	Ljava/io/BufferedOutputStream;
    //   39: astore_1
    //   40: aload_1
    //   41: invokevirtual 175	java/io/OutputStream:close	()V
    //   44: aload_0
    //   45: invokespecial 177	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:bok	()V
    //   48: iconst_4
    //   49: aload_0
    //   50: invokespecial 122	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:getLogTag	()Ljava/lang/String;
    //   53: new 108	java/lang/StringBuilder
    //   56: dup
    //   57: ldc 179
    //   59: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   62: aload_0
    //   63: getfield 94	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:aXd	Lcom/tencent/mm/vfs/k;
    //   66: invokevirtual 133	com/tencent/mm/vfs/k:fTh	()Landroid/net/Uri;
    //   69: invokestatic 138	com/tencent/mm/vfs/w:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   72: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc 181
    //   77: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_0
    //   81: getfield 94	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:aXd	Lcom/tencent/mm/vfs/k;
    //   84: invokevirtual 184	com/tencent/mm/vfs/k:length	()J
    //   87: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   90: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 144	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   96: aload_0
    //   97: aconst_null
    //   98: putfield 152	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:lqO	Ljava/io/OutputStream;
    //   101: aload_0
    //   102: aconst_null
    //   103: putfield 159	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:outputStream	Ljava/io/BufferedOutputStream;
    //   106: aload_0
    //   107: aconst_null
    //   108: putfield 94	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:aXd	Lcom/tencent/mm/vfs/k;
    //   111: ldc 165
    //   113: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: return
    //   117: astore_1
    //   118: aload_0
    //   119: getfield 159	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:outputStream	Ljava/io/BufferedOutputStream;
    //   122: astore_2
    //   123: aload_2
    //   124: invokevirtual 175	java/io/OutputStream:close	()V
    //   127: aload_0
    //   128: getfield 94	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:aXd	Lcom/tencent/mm/vfs/k;
    //   131: invokevirtual 191	com/tencent/mm/vfs/k:delete	()Z
    //   134: pop
    //   135: bipush 6
    //   137: aload_0
    //   138: invokespecial 122	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:getLogTag	()Ljava/lang/String;
    //   141: new 108	java/lang/StringBuilder
    //   144: dup
    //   145: ldc 193
    //   147: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   150: aload_0
    //   151: getfield 94	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:aXd	Lcom/tencent/mm/vfs/k;
    //   154: invokevirtual 133	com/tencent/mm/vfs/k:fTh	()Landroid/net/Uri;
    //   157: invokestatic 138	com/tencent/mm/vfs/w:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   160: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 144	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   169: aload_0
    //   170: aconst_null
    //   171: putfield 152	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:lqO	Ljava/io/OutputStream;
    //   174: aload_0
    //   175: aconst_null
    //   176: putfield 159	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:outputStream	Ljava/io/BufferedOutputStream;
    //   179: aload_0
    //   180: aconst_null
    //   181: putfield 94	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:aXd	Lcom/tencent/mm/vfs/k;
    //   184: ldc 165
    //   186: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: aload_1
    //   190: athrow
    //   191: astore_1
    //   192: goto -148 -> 44
    //   195: astore_2
    //   196: goto -69 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	b
    //   39	2	1	localBufferedOutputStream1	BufferedOutputStream
    //   117	73	1	localObject	Object
    //   191	1	1	localIOException1	IOException
    //   122	2	2	localBufferedOutputStream2	BufferedOutputStream
    //   195	1	2	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   28	35	117	finally
    //   40	44	191	java/io/IOException
    //   123	127	195	java/io/IOException
  }
  
  public final d a(g paramg, long paramLong, c paramc)
  {
    AppMethodBeat.i(210992);
    if (paramg.length != -1L) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a.checkState(bool);
      this.jLu = paramLong;
      this.lqP = paramc;
      try
      {
        this.lqN = paramg;
        this.bFG = 0L;
        wG();
        AppMethodBeat.o(210992);
        return this;
      }
      catch (IOException paramg)
      {
        paramg = new a(paramg);
        AppMethodBeat.o(210992);
        throw paramg;
      }
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(210994);
    try
    {
      wH();
      h.log(4, getLogTag(), "close outputStream, " + String.format("total cached %d bytes", new Object[] { Long.valueOf(this.bFG) }));
      AppMethodBeat.o(210994);
      return;
    }
    catch (IOException localIOException)
    {
      a locala = new a(localIOException);
      AppMethodBeat.o(210994);
      throw locala;
    }
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210993);
    int i = 0;
    while (i < paramInt2) {
      try
      {
        if (this.bFF == this.bFD)
        {
          wH();
          wG();
        }
        int j = (int)Math.min(paramInt2 - i, this.bFD - this.bFF);
        this.outputStream.write(paramArrayOfByte, paramInt1 + i, j);
        i += j;
        this.bFF += j;
        this.bFG += j;
      }
      catch (IOException paramArrayOfByte)
      {
        paramArrayOfByte = new a(paramArrayOfByte);
        AppMethodBeat.o(210993);
        throw paramArrayOfByte;
      }
    }
    AppMethodBeat.o(210993);
  }
  
  public static final class a
    extends IOException
  {
    public a(IOException paramIOException)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.a.b
 * JD-Core Version:    0.7.0.1
 */