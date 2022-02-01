package com.tencent.mm.plugin.appbrand.jsapi.video.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class b
  implements d
{
  protected String TAG = "CacheDataSink";
  private final long bFU;
  protected long bFW;
  protected long bFX;
  protected o file;
  protected long kNt = -1L;
  private final a mxs;
  protected g mxt;
  private OutputStream mxu;
  protected c mxv = c.myu;
  public String mxw = "";
  private BufferedOutputStream outputStream;
  
  public b(a parama, long paramLong)
  {
    this.mxs = parama;
    this.bFU = paramLong;
  }
  
  private void bJM()
  {
    AppMethodBeat.i(234664);
    this.file = this.mxs.a(this.mxt.key, this.mxt.bEP + this.bFX, this.kNt, this.mxv, Math.min(this.mxt.length - this.bFX, this.bFU));
    AppMethodBeat.o(234664);
  }
  
  private void bJN()
  {
    AppMethodBeat.i(234665);
    this.mxs.A(this.file);
    AppMethodBeat.o(234665);
  }
  
  private String getLogTag()
  {
    AppMethodBeat.i(234668);
    String str = this.mxw + this.TAG;
    AppMethodBeat.o(234668);
    return str;
  }
  
  private void wO()
  {
    AppMethodBeat.i(234666);
    bJM();
    h.log(4, getLogTag(), "start cache " + aa.z(this.file.her()));
    this.mxu = s.ap(this.file);
    this.outputStream = new BufferedOutputStream(this.mxu);
    this.bFW = 0L;
    AppMethodBeat.o(234666);
  }
  
  /* Error */
  private void wP()
  {
    // Byte code:
    //   0: ldc 166
    //   2: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 160	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:outputStream	Ljava/io/BufferedOutputStream;
    //   9: ifnonnull +19 -> 28
    //   12: iconst_4
    //   13: aload_0
    //   14: invokespecial 122	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:getLogTag	()Ljava/lang/String;
    //   17: ldc 168
    //   19: invokestatic 145	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   22: ldc 166
    //   24: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: return
    //   28: aload_0
    //   29: getfield 160	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:outputStream	Ljava/io/BufferedOutputStream;
    //   32: invokevirtual 171	java/io/BufferedOutputStream:flush	()V
    //   35: aload_0
    //   36: getfield 160	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:outputStream	Ljava/io/BufferedOutputStream;
    //   39: astore_1
    //   40: aload_1
    //   41: invokevirtual 176	java/io/OutputStream:close	()V
    //   44: aload_0
    //   45: invokespecial 178	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:bJN	()V
    //   48: iconst_4
    //   49: aload_0
    //   50: invokespecial 122	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:getLogTag	()Ljava/lang/String;
    //   53: new 108	java/lang/StringBuilder
    //   56: dup
    //   57: ldc 180
    //   59: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   62: aload_0
    //   63: getfield 94	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:file	Lcom/tencent/mm/vfs/o;
    //   66: invokevirtual 133	com/tencent/mm/vfs/o:her	()Landroid/net/Uri;
    //   69: invokestatic 139	com/tencent/mm/vfs/aa:z	(Landroid/net/Uri;)Ljava/lang/String;
    //   72: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc 182
    //   77: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_0
    //   81: getfield 94	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:file	Lcom/tencent/mm/vfs/o;
    //   84: invokevirtual 185	com/tencent/mm/vfs/o:length	()J
    //   87: invokevirtual 188	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   90: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 145	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   96: aload_0
    //   97: aconst_null
    //   98: putfield 153	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:mxu	Ljava/io/OutputStream;
    //   101: aload_0
    //   102: aconst_null
    //   103: putfield 160	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:outputStream	Ljava/io/BufferedOutputStream;
    //   106: aload_0
    //   107: aconst_null
    //   108: putfield 94	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:file	Lcom/tencent/mm/vfs/o;
    //   111: ldc 166
    //   113: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: return
    //   117: astore_1
    //   118: aload_0
    //   119: getfield 160	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:outputStream	Ljava/io/BufferedOutputStream;
    //   122: astore_2
    //   123: aload_2
    //   124: invokevirtual 176	java/io/OutputStream:close	()V
    //   127: aload_0
    //   128: getfield 94	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:file	Lcom/tencent/mm/vfs/o;
    //   131: invokevirtual 192	com/tencent/mm/vfs/o:delete	()Z
    //   134: pop
    //   135: bipush 6
    //   137: aload_0
    //   138: invokespecial 122	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:getLogTag	()Ljava/lang/String;
    //   141: new 108	java/lang/StringBuilder
    //   144: dup
    //   145: ldc 194
    //   147: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   150: aload_0
    //   151: getfield 94	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:file	Lcom/tencent/mm/vfs/o;
    //   154: invokevirtual 133	com/tencent/mm/vfs/o:her	()Landroid/net/Uri;
    //   157: invokestatic 139	com/tencent/mm/vfs/aa:z	(Landroid/net/Uri;)Ljava/lang/String;
    //   160: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 145	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   169: aload_0
    //   170: aconst_null
    //   171: putfield 153	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:mxu	Ljava/io/OutputStream;
    //   174: aload_0
    //   175: aconst_null
    //   176: putfield 160	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:outputStream	Ljava/io/BufferedOutputStream;
    //   179: aload_0
    //   180: aconst_null
    //   181: putfield 94	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:file	Lcom/tencent/mm/vfs/o;
    //   184: ldc 166
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
    AppMethodBeat.i(234661);
    if (paramg.length != -1L) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a.checkState(bool);
      this.kNt = paramLong;
      this.mxv = paramc;
      try
      {
        this.mxt = paramg;
        this.bFX = 0L;
        wO();
        AppMethodBeat.o(234661);
        return this;
      }
      catch (IOException paramg)
      {
        paramg = new a(paramg);
        AppMethodBeat.o(234661);
        throw paramg;
      }
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(234663);
    try
    {
      wP();
      h.log(4, getLogTag(), "close outputStream, " + String.format("total cached %d bytes", new Object[] { Long.valueOf(this.bFX) }));
      AppMethodBeat.o(234663);
      return;
    }
    catch (IOException localIOException)
    {
      a locala = new a(localIOException);
      AppMethodBeat.o(234663);
      throw locala;
    }
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(234662);
    int i = 0;
    while (i < paramInt2) {
      try
      {
        if (this.bFW == this.bFU)
        {
          wP();
          wO();
        }
        int j = (int)Math.min(paramInt2 - i, this.bFU - this.bFW);
        this.outputStream.write(paramArrayOfByte, paramInt1 + i, j);
        i += j;
        this.bFW += j;
        this.bFX += j;
      }
      catch (IOException paramArrayOfByte)
      {
        paramArrayOfByte = new a(paramArrayOfByte);
        AppMethodBeat.o(234662);
        throw paramArrayOfByte;
      }
    }
    AppMethodBeat.o(234662);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.a.b
 * JD-Core Version:    0.7.0.1
 */