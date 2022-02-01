package com.tencent.mm.plugin.appbrand.jsapi.video.e.b;

import android.net.Uri;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.InputStream;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/RealInferContentTypeInputStream;", "Ljava/io/InputStream;", "dataSource", "Lcom/google/android/exoplayer2/upstream/DataSource;", "uri", "Landroid/net/Uri;", "(Lcom/google/android/exoplayer2/upstream/DataSource;Landroid/net/Uri;)V", "closed", "", "curInputStream", "curPos", "", "singleByteArray", "", "close", "", "read", "", "b", "off", "len", "requireInputStream", "resetInputStream", "Companion", "luggage-commons-jsapi-video-ext_release"})
final class j
  extends InputStream
{
  public static final j.a pBG;
  private final g aRo;
  private final byte[] bop;
  private boolean closed;
  private long pBE;
  private InputStream pBF;
  private final Uri uri;
  
  static
  {
    AppMethodBeat.i(227199);
    pBG = new j.a((byte)0);
    AppMethodBeat.o(227199);
  }
  
  public j(g paramg, Uri paramUri)
  {
    AppMethodBeat.i(227198);
    this.aRo = paramg;
    this.uri = paramUri;
    this.bop = new byte[1];
    AppMethodBeat.o(227198);
  }
  
  private final InputStream bWI()
  {
    AppMethodBeat.i(227194);
    InputStream localInputStream = this.pBF;
    long l = this.pBE;
    StringBuilder localStringBuilder = new StringBuilder("requireInputStream, curInputStream is ");
    if (localInputStream == null) {}
    for (Object localObject = "null";; localObject = "not null")
    {
      Log.d("MicroMsg.AppBrand.RealInferContentTypeInputStream", (String)localObject + ", curPos: " + l);
      if (32768L > l) {
        break;
      }
      Log.i("MicroMsg.AppBrand.RealInferContentTypeInputStream", "requireInputStream, reach max read length");
      AppMethodBeat.o(227194);
      return null;
    }
    if (0L != l % 1024L)
    {
      Log.i("MicroMsg.AppBrand.RealInferContentTypeInputStream", "requireInputStream, end of file");
      AppMethodBeat.o(227194);
      return null;
    }
    if (localInputStream == null)
    {
      localObject = new com.google.android.exoplayer2.h.j(this.uri, l, 1024L, null);
      localObject = (InputStream)new i(this.aRo, (com.google.android.exoplayer2.h.j)localObject);
      this.pBF = ((InputStream)localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(227194);
      return localObject;
      localObject = localInputStream;
    }
  }
  
  private final void bWJ()
  {
    AppMethodBeat.i(227195);
    InputStream localInputStream = this.pBF;
    if (localInputStream != null) {
      localInputStream.close();
    }
    this.pBF = null;
    AppMethodBeat.o(227195);
  }
  
  public final void close()
  {
    AppMethodBeat.i(227192);
    Log.d("MicroMsg.AppBrand.RealInferContentTypeInputStream", "close");
    if (!this.closed)
    {
      bWJ();
      this.pBE = 0L;
      this.closed = true;
    }
    AppMethodBeat.o(227192);
  }
  
  public final int read()
  {
    AppMethodBeat.i(227175);
    Log.d("MicroMsg.AppBrand.RealInferContentTypeInputStream", "read");
    if (-1 == read(this.bop))
    {
      AppMethodBeat.o(227175);
      return -1;
    }
    int i = this.bop[0];
    AppMethodBeat.o(227175);
    return i;
  }
  
  /* Error */
  public final int read(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 159
    //   2: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 99
    //   7: ldc 161
    //   9: invokestatic 118	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: getfield 148	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/j:closed	Z
    //   16: ifne +27 -> 43
    //   19: iconst_1
    //   20: istore_3
    //   21: iload_3
    //   22: invokestatic 167	com/google/android/exoplayer2/i/a:checkState	(Z)V
    //   25: aload_0
    //   26: invokespecial 169	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/j:bWI	()Ljava/io/InputStream;
    //   29: astore 4
    //   31: aload 4
    //   33: ifnonnull +15 -> 48
    //   36: ldc 159
    //   38: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: iconst_m1
    //   42: ireturn
    //   43: iconst_0
    //   44: istore_3
    //   45: goto -24 -> 21
    //   48: aload 4
    //   50: aload_1
    //   51: invokevirtual 170	java/io/InputStream:read	([B)I
    //   54: istore_2
    //   55: iconst_m1
    //   56: iload_2
    //   57: if_icmpne +20 -> 77
    //   60: aload_0
    //   61: invokespecial 150	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/j:bWJ	()V
    //   64: aload_0
    //   65: aload_1
    //   66: invokevirtual 156	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/j:read	([B)I
    //   69: istore_2
    //   70: ldc 159
    //   72: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: iload_2
    //   76: ireturn
    //   77: aload_0
    //   78: aload_0
    //   79: getfield 88	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/j:pBE	J
    //   82: iload_2
    //   83: i2l
    //   84: ladd
    //   85: putfield 88	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/j:pBE	J
    //   88: goto -18 -> 70
    //   91: astore_1
    //   92: ldc 99
    //   94: ldc 172
    //   96: aload_1
    //   97: invokestatic 178	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   100: invokevirtual 182	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   103: invokestatic 124	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: aload_1
    //   107: checkcast 184	java/lang/Throwable
    //   110: astore_1
    //   111: ldc 159
    //   113: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: aload_1
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	j
    //   0	118	1	paramArrayOfByte	byte[]
    //   54	29	2	i	int
    //   20	25	3	bool	boolean
    //   29	20	4	localInputStream	InputStream
    // Exception table:
    //   from	to	target	type
    //   48	55	91	java/io/IOException
    //   60	70	91	java/io/IOException
    //   77	88	91	java/io/IOException
  }
  
  /* Error */
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc 186
    //   2: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 99
    //   7: new 90	java/lang/StringBuilder
    //   10: dup
    //   11: ldc 188
    //   13: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: iload_2
    //   17: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   20: ldc 193
    //   22: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: iload_3
    //   26: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   29: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 118	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_0
    //   36: getfield 148	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/j:closed	Z
    //   39: ifne +29 -> 68
    //   42: iconst_1
    //   43: istore 5
    //   45: iload 5
    //   47: invokestatic 167	com/google/android/exoplayer2/i/a:checkState	(Z)V
    //   50: aload_0
    //   51: invokespecial 169	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/j:bWI	()Ljava/io/InputStream;
    //   54: astore 6
    //   56: aload 6
    //   58: ifnonnull +16 -> 74
    //   61: ldc 186
    //   63: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: iconst_m1
    //   67: ireturn
    //   68: iconst_0
    //   69: istore 5
    //   71: goto -26 -> 45
    //   74: aload 6
    //   76: aload_1
    //   77: iload_2
    //   78: iload_3
    //   79: invokevirtual 195	java/io/InputStream:read	([BII)I
    //   82: istore 4
    //   84: iconst_m1
    //   85: iload 4
    //   87: if_icmpne +22 -> 109
    //   90: aload_0
    //   91: invokespecial 150	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/j:bWJ	()V
    //   94: aload_0
    //   95: aload_1
    //   96: iload_2
    //   97: iload_3
    //   98: invokevirtual 196	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/j:read	([BII)I
    //   101: istore_2
    //   102: ldc 186
    //   104: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: iload_2
    //   108: ireturn
    //   109: aload_0
    //   110: aload_0
    //   111: getfield 88	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/j:pBE	J
    //   114: iload 4
    //   116: i2l
    //   117: ladd
    //   118: putfield 88	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/j:pBE	J
    //   121: iload 4
    //   123: istore_2
    //   124: goto -22 -> 102
    //   127: astore_1
    //   128: ldc 99
    //   130: ldc 198
    //   132: aload_1
    //   133: invokestatic 178	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   136: invokevirtual 182	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   139: invokestatic 124	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: aload_1
    //   143: checkcast 184	java/lang/Throwable
    //   146: astore_1
    //   147: ldc 186
    //   149: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aload_1
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	j
    //   0	154	1	paramArrayOfByte	byte[]
    //   0	154	2	paramInt1	int
    //   0	154	3	paramInt2	int
    //   82	40	4	i	int
    //   43	27	5	bool	boolean
    //   54	21	6	localInputStream	InputStream
    // Exception table:
    //   from	to	target	type
    //   74	84	127	java/io/IOException
    //   90	102	127	java/io/IOException
    //   109	121	127	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.b.j
 * JD-Core Version:    0.7.0.1
 */