package com.tencent.mm.plugin.appbrand.jsapi.video.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class b
  implements d
{
  protected String TAG = "CacheDataSink";
  private final long djb;
  protected long dje;
  protected long djf;
  protected u file;
  private BufferedOutputStream outputStream;
  protected long qHg = -1L;
  private final a sAS;
  protected g sAT;
  private OutputStream sAU;
  protected c sAV = c.sBU;
  public String sAW = "";
  
  public b(a parama, long paramLong)
  {
    this.sAS = parama;
    this.djb = paramLong;
  }
  
  private void Up()
  {
    AppMethodBeat.i(328311);
    cvJ();
    h.log(4, getLogTag(), "start cache " + ah.v(this.file.jKT()));
    this.sAU = y.ap(this.file);
    this.outputStream = new BufferedOutputStream(this.sAU);
    this.dje = 0L;
    AppMethodBeat.o(328311);
  }
  
  /* Error */
  private void Uq()
  {
    // Byte code:
    //   0: ldc 131
    //   2: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 122	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:outputStream	Ljava/io/BufferedOutputStream;
    //   9: ifnonnull +19 -> 28
    //   12: iconst_4
    //   13: aload_0
    //   14: invokespecial 73	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:getLogTag	()Ljava/lang/String;
    //   17: ldc 133
    //   19: invokestatic 107	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   22: ldc 131
    //   24: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: return
    //   28: aload_0
    //   29: getfield 122	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:outputStream	Ljava/io/BufferedOutputStream;
    //   32: invokevirtual 136	java/io/BufferedOutputStream:flush	()V
    //   35: aload_0
    //   36: getfield 122	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:outputStream	Ljava/io/BufferedOutputStream;
    //   39: astore_1
    //   40: aload_1
    //   41: invokevirtual 141	java/io/OutputStream:close	()V
    //   44: aload_0
    //   45: invokespecial 144	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:cvK	()V
    //   48: iconst_4
    //   49: aload_0
    //   50: invokespecial 73	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:getLogTag	()Ljava/lang/String;
    //   53: new 75	java/lang/StringBuilder
    //   56: dup
    //   57: ldc 146
    //   59: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   62: aload_0
    //   63: getfield 82	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:file	Lcom/tencent/mm/vfs/u;
    //   66: invokevirtual 88	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   69: invokestatic 94	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   72: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc 148
    //   77: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_0
    //   81: getfield 82	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:file	Lcom/tencent/mm/vfs/u;
    //   84: invokevirtual 152	com/tencent/mm/vfs/u:length	()J
    //   87: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   90: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 107	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   96: aload_0
    //   97: aconst_null
    //   98: putfield 115	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:sAU	Ljava/io/OutputStream;
    //   101: aload_0
    //   102: aconst_null
    //   103: putfield 122	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:outputStream	Ljava/io/BufferedOutputStream;
    //   106: aload_0
    //   107: aconst_null
    //   108: putfield 82	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:file	Lcom/tencent/mm/vfs/u;
    //   111: ldc 131
    //   113: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: return
    //   117: astore_1
    //   118: aload_0
    //   119: getfield 122	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:outputStream	Ljava/io/BufferedOutputStream;
    //   122: astore_2
    //   123: aload_2
    //   124: invokevirtual 141	java/io/OutputStream:close	()V
    //   127: aload_0
    //   128: getfield 82	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:file	Lcom/tencent/mm/vfs/u;
    //   131: invokevirtual 159	com/tencent/mm/vfs/u:diJ	()Z
    //   134: pop
    //   135: bipush 6
    //   137: aload_0
    //   138: invokespecial 73	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:getLogTag	()Ljava/lang/String;
    //   141: new 75	java/lang/StringBuilder
    //   144: dup
    //   145: ldc 161
    //   147: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   150: aload_0
    //   151: getfield 82	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:file	Lcom/tencent/mm/vfs/u;
    //   154: invokevirtual 88	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   157: invokestatic 94	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   160: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 107	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   169: aload_0
    //   170: aconst_null
    //   171: putfield 115	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:sAU	Ljava/io/OutputStream;
    //   174: aload_0
    //   175: aconst_null
    //   176: putfield 122	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:outputStream	Ljava/io/BufferedOutputStream;
    //   179: aload_0
    //   180: aconst_null
    //   181: putfield 82	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:file	Lcom/tencent/mm/vfs/u;
    //   184: ldc 131
    //   186: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private void cvJ()
  {
    AppMethodBeat.i(328294);
    this.file = this.sAS.a(this.sAT.key, this.sAT.absoluteStreamPosition + this.djf, this.qHg, this.sAV, Math.min(this.sAT.length - this.djf, this.djb));
    AppMethodBeat.o(328294);
  }
  
  private void cvK()
  {
    AppMethodBeat.i(328301);
    this.sAS.z(this.file);
    AppMethodBeat.o(328301);
  }
  
  private String getLogTag()
  {
    AppMethodBeat.i(328329);
    String str = this.sAW + this.TAG;
    AppMethodBeat.o(328329);
    return str;
  }
  
  public final d a(g paramg, long paramLong, c paramc)
  {
    AppMethodBeat.i(328340);
    if (paramg.length != -1L) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a.checkState(bool);
      this.qHg = paramLong;
      this.sAV = paramc;
      try
      {
        this.sAT = paramg;
        this.djf = 0L;
        Up();
        AppMethodBeat.o(328340);
        return this;
      }
      catch (IOException paramg)
      {
        paramg = new a(paramg);
        AppMethodBeat.o(328340);
        throw paramg;
      }
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(328360);
    try
    {
      Uq();
      h.log(4, getLogTag(), "close outputStream, " + String.format("total cached %d bytes", new Object[] { Long.valueOf(this.djf) }));
      AppMethodBeat.o(328360);
      return;
    }
    catch (IOException localIOException)
    {
      a locala = new a(localIOException);
      AppMethodBeat.o(328360);
      throw locala;
    }
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(328352);
    int i = 0;
    while (i < paramInt2) {
      try
      {
        if (this.dje == this.djb)
        {
          Uq();
          Up();
        }
        int j = (int)Math.min(paramInt2 - i, this.djb - this.dje);
        this.outputStream.write(paramArrayOfByte, paramInt1 + i, j);
        i += j;
        this.dje += j;
        this.djf += j;
      }
      catch (IOException paramArrayOfByte)
      {
        paramArrayOfByte = new a(paramArrayOfByte);
        AppMethodBeat.o(328352);
        throw paramArrayOfByte;
      }
    }
    AppMethodBeat.o(328352);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.a.b
 * JD-Core Version:    0.7.0.1
 */