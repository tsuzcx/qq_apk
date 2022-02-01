package com.tencent.mm.plugin.appbrand.jsapi.video.e.b;

import android.net.Uri;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.i;
import com.google.android.exoplayer2.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.InputStream;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/depend_exo/RealInferContentTypeInputStream;", "Ljava/io/InputStream;", "dataSource", "Lcom/google/android/exoplayer2/upstream/DataSource;", "uri", "Landroid/net/Uri;", "(Lcom/google/android/exoplayer2/upstream/DataSource;Landroid/net/Uri;)V", "closed", "", "curInputStream", "curReadPos", "", "expectReadLen", "singleByteArray", "", "close", "", "read", "", "b", "off", "len", "requireInputStream", "resetInputStream", "Companion", "luggage-commons-jsapi-video-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
final class b
  extends InputStream
{
  public static final b.a sFC;
  private final g cLk;
  private boolean closed;
  private long sFD;
  private long sFE;
  private InputStream sFF;
  private final byte[] singleByteArray;
  private final Uri uri;
  
  static
  {
    AppMethodBeat.i(328846);
    sFC = new b.a((byte)0);
    AppMethodBeat.o(328846);
  }
  
  public b(g paramg, Uri paramUri)
  {
    AppMethodBeat.i(328822);
    this.cLk = paramg;
    this.uri = paramUri;
    this.singleByteArray = new byte[1];
    AppMethodBeat.o(328822);
  }
  
  private final InputStream cwD()
  {
    AppMethodBeat.i(328833);
    InputStream localInputStream = this.sFF;
    long l1 = this.sFD;
    long l2 = this.sFE;
    StringBuilder localStringBuilder = new StringBuilder("requireInputStream, curInputStream is ");
    if (localInputStream == null) {}
    for (Object localObject = "null";; localObject = "not null")
    {
      Log.d("MicroMsg.AppBrand.RealInferContentTypeInputStream", (String)localObject + ", curReadPos: " + l1 + ", expectReadLen: " + l2);
      if (localInputStream != null) {
        break label195;
      }
      if (32768L > l1) {
        break;
      }
      Log.i("MicroMsg.AppBrand.RealInferContentTypeInputStream", "requireInputStream, reach max read length");
      AppMethodBeat.o(328833);
      return null;
    }
    if (l1 < l2)
    {
      Log.i("MicroMsg.AppBrand.RealInferContentTypeInputStream", "requireInputStream, end of file");
      AppMethodBeat.o(328833);
      return null;
    }
    this.sFE = l1;
    localObject = new j(this.uri, l1, 1024L, null);
    localObject = (InputStream)new i(this.cLk, (j)localObject);
    this.sFF = ((InputStream)localObject);
    this.sFE += 1024L;
    for (;;)
    {
      AppMethodBeat.o(328833);
      return localObject;
      label195:
      localObject = localInputStream;
    }
  }
  
  private final void cwE()
  {
    AppMethodBeat.i(328840);
    InputStream localInputStream = this.sFF;
    if (localInputStream != null) {
      localInputStream.close();
    }
    this.sFF = null;
    AppMethodBeat.o(328840);
  }
  
  public final void close()
  {
    AppMethodBeat.i(328874);
    Log.d("MicroMsg.AppBrand.RealInferContentTypeInputStream", "close");
    if (!this.closed)
    {
      cwE();
      this.sFD = 0L;
      this.closed = true;
    }
    AppMethodBeat.o(328874);
  }
  
  public final int read()
  {
    AppMethodBeat.i(328853);
    Log.d("MicroMsg.AppBrand.RealInferContentTypeInputStream", "read");
    if (-1 == read(this.singleByteArray))
    {
      AppMethodBeat.o(328853);
      return -1;
    }
    int i = this.singleByteArray[0];
    AppMethodBeat.o(328853);
    return i;
  }
  
  /* Error */
  public final int read(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 167
    //   2: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 105
    //   7: ldc 169
    //   9: invokestatic 126	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: getfield 156	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/b:closed	Z
    //   16: ifne +27 -> 43
    //   19: iconst_1
    //   20: istore_3
    //   21: iload_3
    //   22: invokestatic 175	com/google/android/exoplayer2/i/a:checkState	(Z)V
    //   25: aload_0
    //   26: invokespecial 177	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/b:cwD	()Ljava/io/InputStream;
    //   29: astore 4
    //   31: aload 4
    //   33: ifnonnull +15 -> 48
    //   36: ldc 167
    //   38: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: iconst_m1
    //   42: ireturn
    //   43: iconst_0
    //   44: istore_3
    //   45: goto -24 -> 21
    //   48: aload 4
    //   50: aload_1
    //   51: invokevirtual 178	java/io/InputStream:read	([B)I
    //   54: istore_2
    //   55: iconst_m1
    //   56: iload_2
    //   57: if_icmpne +20 -> 77
    //   60: aload_0
    //   61: invokespecial 158	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/b:cwE	()V
    //   64: aload_0
    //   65: aload_1
    //   66: invokevirtual 164	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/b:read	([B)I
    //   69: istore_2
    //   70: ldc 167
    //   72: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: iload_2
    //   76: ireturn
    //   77: aload_0
    //   78: aload_0
    //   79: getfield 92	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/b:sFD	J
    //   82: iload_2
    //   83: i2l
    //   84: ladd
    //   85: putfield 92	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/b:sFD	J
    //   88: goto -18 -> 70
    //   91: astore_1
    //   92: ldc 105
    //   94: ldc 180
    //   96: aload_1
    //   97: invokestatic 184	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   100: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: ldc 167
    //   105: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: aload_1
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	b
    //   0	110	1	paramArrayOfByte	byte[]
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
    //   2: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 105
    //   7: new 96	java/lang/StringBuilder
    //   10: dup
    //   11: ldc 188
    //   13: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: iload_2
    //   17: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   20: ldc 193
    //   22: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: iload_3
    //   26: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   29: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 126	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_0
    //   36: getfield 156	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/b:closed	Z
    //   39: ifne +29 -> 68
    //   42: iconst_1
    //   43: istore 5
    //   45: iload 5
    //   47: invokestatic 175	com/google/android/exoplayer2/i/a:checkState	(Z)V
    //   50: aload_0
    //   51: invokespecial 177	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/b:cwD	()Ljava/io/InputStream;
    //   54: astore 6
    //   56: aload 6
    //   58: ifnonnull +16 -> 74
    //   61: ldc 186
    //   63: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   91: invokespecial 158	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/b:cwE	()V
    //   94: aload_0
    //   95: aload_1
    //   96: iload_2
    //   97: iload_3
    //   98: invokevirtual 196	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/b:read	([BII)I
    //   101: istore_2
    //   102: ldc 186
    //   104: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: iload_2
    //   108: ireturn
    //   109: aload_0
    //   110: aload_0
    //   111: getfield 92	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/b:sFD	J
    //   114: iload 4
    //   116: i2l
    //   117: ladd
    //   118: putfield 92	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/b:sFD	J
    //   121: iload 4
    //   123: istore_2
    //   124: goto -22 -> 102
    //   127: astore_1
    //   128: ldc 105
    //   130: ldc 198
    //   132: aload_1
    //   133: invokestatic 184	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   136: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: ldc 186
    //   141: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: aload_1
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	b
    //   0	146	1	paramArrayOfByte	byte[]
    //   0	146	2	paramInt1	int
    //   0	146	3	paramInt2	int
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.b.b
 * JD-Core Version:    0.7.0.1
 */