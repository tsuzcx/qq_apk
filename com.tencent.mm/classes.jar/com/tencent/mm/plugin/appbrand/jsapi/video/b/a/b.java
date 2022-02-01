package com.tencent.mm.plugin.appbrand.jsapi.video.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class b
  implements d
{
  protected String TAG = "CacheDataSink";
  private final long bxG;
  protected long bxI;
  protected long bxJ;
  protected long iOo = -1L;
  private final a kos;
  protected e kot;
  protected g kou;
  private OutputStream kov;
  protected c kow = c.kpv;
  public String kox = "";
  private BufferedOutputStream outputStream;
  
  public b(a parama, long paramLong)
  {
    this.kos = parama;
    this.bxG = paramLong;
  }
  
  private String EE()
  {
    AppMethodBeat.i(193813);
    String str = this.kox + this.TAG;
    AppMethodBeat.o(193813);
    return str;
  }
  
  private void bcT()
  {
    AppMethodBeat.i(193809);
    this.kot = this.kos.a(this.kou.key, this.kou.bwz + this.bxJ, this.iOo, this.kow, Math.min(this.kou.length - this.bxJ, this.bxG));
    AppMethodBeat.o(193809);
  }
  
  private void bcU()
  {
    AppMethodBeat.i(193810);
    this.kos.C(this.kot);
    AppMethodBeat.o(193810);
  }
  
  private void vs()
  {
    AppMethodBeat.i(193811);
    bcT();
    h.log(4, EE(), "start cache " + q.B(this.kot.fhU()));
    this.kov = i.ai(this.kot);
    this.outputStream = new BufferedOutputStream(this.kov);
    this.bxI = 0L;
    AppMethodBeat.o(193811);
  }
  
  /* Error */
  private void vt()
  {
    // Byte code:
    //   0: ldc 166
    //   2: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 160	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:outputStream	Ljava/io/BufferedOutputStream;
    //   9: ifnonnull +19 -> 28
    //   12: iconst_4
    //   13: aload_0
    //   14: invokespecial 122	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:EE	()Ljava/lang/String;
    //   17: ldc 168
    //   19: invokestatic 145	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   22: ldc 166
    //   24: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   45: invokespecial 178	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:bcU	()V
    //   48: iconst_4
    //   49: aload_0
    //   50: invokespecial 122	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:EE	()Ljava/lang/String;
    //   53: new 69	java/lang/StringBuilder
    //   56: dup
    //   57: ldc 180
    //   59: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   62: aload_0
    //   63: getfield 110	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:kot	Lcom/tencent/mm/vfs/e;
    //   66: invokevirtual 133	com/tencent/mm/vfs/e:fhU	()Landroid/net/Uri;
    //   69: invokestatic 139	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   72: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc 182
    //   77: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_0
    //   81: getfield 110	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:kot	Lcom/tencent/mm/vfs/e;
    //   84: invokevirtual 185	com/tencent/mm/vfs/e:length	()J
    //   87: invokevirtual 188	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   90: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 145	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   96: aload_0
    //   97: aconst_null
    //   98: putfield 153	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:kov	Ljava/io/OutputStream;
    //   101: aload_0
    //   102: aconst_null
    //   103: putfield 160	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:outputStream	Ljava/io/BufferedOutputStream;
    //   106: aload_0
    //   107: aconst_null
    //   108: putfield 110	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:kot	Lcom/tencent/mm/vfs/e;
    //   111: ldc 166
    //   113: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: return
    //   117: astore_1
    //   118: aload_0
    //   119: getfield 160	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:outputStream	Ljava/io/BufferedOutputStream;
    //   122: astore_2
    //   123: aload_2
    //   124: invokevirtual 176	java/io/OutputStream:close	()V
    //   127: aload_0
    //   128: getfield 110	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:kot	Lcom/tencent/mm/vfs/e;
    //   131: invokevirtual 192	com/tencent/mm/vfs/e:delete	()Z
    //   134: pop
    //   135: bipush 6
    //   137: aload_0
    //   138: invokespecial 122	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:EE	()Ljava/lang/String;
    //   141: new 69	java/lang/StringBuilder
    //   144: dup
    //   145: ldc 194
    //   147: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   150: aload_0
    //   151: getfield 110	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:kot	Lcom/tencent/mm/vfs/e;
    //   154: invokevirtual 133	com/tencent/mm/vfs/e:fhU	()Landroid/net/Uri;
    //   157: invokestatic 139	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   160: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 145	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   169: aload_0
    //   170: aconst_null
    //   171: putfield 153	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:kov	Ljava/io/OutputStream;
    //   174: aload_0
    //   175: aconst_null
    //   176: putfield 160	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:outputStream	Ljava/io/BufferedOutputStream;
    //   179: aload_0
    //   180: aconst_null
    //   181: putfield 110	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:kot	Lcom/tencent/mm/vfs/e;
    //   184: ldc 166
    //   186: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(193806);
    if (paramg.length != -1L) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a.checkState(bool);
      this.iOo = paramLong;
      this.kow = paramc;
      try
      {
        this.kou = paramg;
        this.bxJ = 0L;
        vs();
        AppMethodBeat.o(193806);
        return this;
      }
      catch (IOException paramg)
      {
        paramg = new a(paramg);
        AppMethodBeat.o(193806);
        throw paramg;
      }
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(193808);
    try
    {
      vt();
      h.log(4, EE(), "close outputStream, " + String.format("total cached %d bytes", new Object[] { Long.valueOf(this.bxJ) }));
      AppMethodBeat.o(193808);
      return;
    }
    catch (IOException localIOException)
    {
      a locala = new a(localIOException);
      AppMethodBeat.o(193808);
      throw locala;
    }
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193807);
    int i = 0;
    while (i < paramInt2) {
      try
      {
        if (this.bxI == this.bxG)
        {
          vt();
          vs();
        }
        int j = (int)Math.min(paramInt2 - i, this.bxG - this.bxI);
        this.outputStream.write(paramArrayOfByte, paramInt1 + i, j);
        i += j;
        this.bxI += j;
        this.bxJ += j;
      }
      catch (IOException paramArrayOfByte)
      {
        paramArrayOfByte = new a(paramArrayOfByte);
        AppMethodBeat.o(193807);
        throw paramArrayOfByte;
      }
    }
    AppMethodBeat.o(193807);
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