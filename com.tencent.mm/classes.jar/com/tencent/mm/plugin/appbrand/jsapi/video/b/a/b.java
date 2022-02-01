package com.tencent.mm.plugin.appbrand.jsapi.video.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class b
  implements d
{
  protected String TAG = "CacheDataSink";
  protected long bpA;
  protected long bpB;
  private final long bpy;
  protected q file;
  protected long nHt = -1L;
  private BufferedOutputStream outputStream;
  private final a pvM;
  protected g pvN;
  private OutputStream pvO;
  protected c pvP = c.pwO;
  public String pvQ = "";
  
  public b(a parama, long paramLong)
  {
    this.pvM = parama;
    this.bpy = paramLong;
  }
  
  private void bVv()
  {
    AppMethodBeat.i(230697);
    this.file = this.pvM.a(this.pvN.key, this.pvN.bos + this.bpB, this.nHt, this.pvP, Math.min(this.pvN.aFL - this.bpB, this.bpy));
    AppMethodBeat.o(230697);
  }
  
  private void bVw()
  {
    AppMethodBeat.i(230700);
    this.pvM.z(this.file);
    AppMethodBeat.o(230700);
  }
  
  private String getLogTag()
  {
    AppMethodBeat.i(230711);
    String str = this.pvQ + this.TAG;
    AppMethodBeat.o(230711);
    return str;
  }
  
  private void uQ()
  {
    AppMethodBeat.i(230703);
    bVv();
    h.log(4, getLogTag(), "start cache " + this.file.bOF());
    this.pvO = u.an(this.file);
    this.outputStream = new BufferedOutputStream(this.pvO);
    this.bpA = 0L;
    AppMethodBeat.o(230703);
  }
  
  /* Error */
  private void uR()
  {
    // Byte code:
    //   0: ldc 159
    //   2: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 153	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:outputStream	Ljava/io/BufferedOutputStream;
    //   9: ifnonnull +19 -> 28
    //   12: iconst_4
    //   13: aload_0
    //   14: invokespecial 122	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:getLogTag	()Ljava/lang/String;
    //   17: ldc 161
    //   19: invokestatic 138	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   22: ldc 159
    //   24: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: return
    //   28: aload_0
    //   29: getfield 153	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:outputStream	Ljava/io/BufferedOutputStream;
    //   32: invokevirtual 164	java/io/BufferedOutputStream:flush	()V
    //   35: aload_0
    //   36: getfield 153	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:outputStream	Ljava/io/BufferedOutputStream;
    //   39: astore_1
    //   40: aload_1
    //   41: invokevirtual 169	java/io/OutputStream:close	()V
    //   44: aload_0
    //   45: invokespecial 171	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:bVw	()V
    //   48: iconst_4
    //   49: aload_0
    //   50: invokespecial 122	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:getLogTag	()Ljava/lang/String;
    //   53: new 108	java/lang/StringBuilder
    //   56: dup
    //   57: ldc 173
    //   59: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   62: aload_0
    //   63: getfield 94	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:file	Lcom/tencent/mm/vfs/q;
    //   66: invokevirtual 132	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   69: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc 175
    //   74: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_0
    //   78: getfield 94	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:file	Lcom/tencent/mm/vfs/q;
    //   81: invokevirtual 179	com/tencent/mm/vfs/q:length	()J
    //   84: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   87: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 138	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   93: aload_0
    //   94: aconst_null
    //   95: putfield 146	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:pvO	Ljava/io/OutputStream;
    //   98: aload_0
    //   99: aconst_null
    //   100: putfield 153	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:outputStream	Ljava/io/BufferedOutputStream;
    //   103: aload_0
    //   104: aconst_null
    //   105: putfield 94	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:file	Lcom/tencent/mm/vfs/q;
    //   108: ldc 159
    //   110: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: return
    //   114: astore_1
    //   115: aload_0
    //   116: getfield 153	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:outputStream	Ljava/io/BufferedOutputStream;
    //   119: astore_2
    //   120: aload_2
    //   121: invokevirtual 169	java/io/OutputStream:close	()V
    //   124: aload_0
    //   125: getfield 94	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:file	Lcom/tencent/mm/vfs/q;
    //   128: invokevirtual 186	com/tencent/mm/vfs/q:cFq	()Z
    //   131: pop
    //   132: bipush 6
    //   134: aload_0
    //   135: invokespecial 122	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:getLogTag	()Ljava/lang/String;
    //   138: new 108	java/lang/StringBuilder
    //   141: dup
    //   142: ldc 188
    //   144: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   147: aload_0
    //   148: getfield 94	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:file	Lcom/tencent/mm/vfs/q;
    //   151: invokevirtual 132	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   154: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 138	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   163: aload_0
    //   164: aconst_null
    //   165: putfield 146	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:pvO	Ljava/io/OutputStream;
    //   168: aload_0
    //   169: aconst_null
    //   170: putfield 153	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:outputStream	Ljava/io/BufferedOutputStream;
    //   173: aload_0
    //   174: aconst_null
    //   175: putfield 94	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/b:file	Lcom/tencent/mm/vfs/q;
    //   178: ldc 159
    //   180: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: aload_1
    //   184: athrow
    //   185: astore_1
    //   186: goto -142 -> 44
    //   189: astore_2
    //   190: goto -66 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	b
    //   39	2	1	localBufferedOutputStream1	BufferedOutputStream
    //   114	70	1	localObject	Object
    //   185	1	1	localIOException1	IOException
    //   119	2	2	localBufferedOutputStream2	BufferedOutputStream
    //   189	1	2	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   28	35	114	finally
    //   40	44	185	java/io/IOException
    //   120	124	189	java/io/IOException
  }
  
  public final d a(g paramg, long paramLong, c paramc)
  {
    AppMethodBeat.i(230692);
    if (paramg.aFL != -1L) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a.checkState(bool);
      this.nHt = paramLong;
      this.pvP = paramc;
      try
      {
        this.pvN = paramg;
        this.bpB = 0L;
        uQ();
        AppMethodBeat.o(230692);
        return this;
      }
      catch (IOException paramg)
      {
        paramg = new a(paramg);
        AppMethodBeat.o(230692);
        throw paramg;
      }
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(230695);
    try
    {
      uR();
      h.log(4, getLogTag(), "close outputStream, " + String.format("total cached %d bytes", new Object[] { Long.valueOf(this.bpB) }));
      AppMethodBeat.o(230695);
      return;
    }
    catch (IOException localIOException)
    {
      a locala = new a(localIOException);
      AppMethodBeat.o(230695);
      throw locala;
    }
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(230694);
    int i = 0;
    while (i < paramInt2) {
      try
      {
        if (this.bpA == this.bpy)
        {
          uR();
          uQ();
        }
        int j = (int)Math.min(paramInt2 - i, this.bpy - this.bpA);
        this.outputStream.write(paramArrayOfByte, paramInt1 + i, j);
        i += j;
        this.bpA += j;
        this.bpB += j;
      }
      catch (IOException paramArrayOfByte)
      {
        paramArrayOfByte = new a(paramArrayOfByte);
        AppMethodBeat.o(230694);
        throw paramArrayOfByte;
      }
    }
    AppMethodBeat.o(230694);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.a.b
 * JD-Core Version:    0.7.0.1
 */