package com.tencent.mm.modelappbrand.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.HandlerThread;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b
{
  private static final String fqs;
  private final Map<b.i, String> fqm;
  private final Map<String, b.i> fqn;
  private final Map<Integer, String> fqo;
  private final b.d fqp;
  private final b.j fqq;
  private final g fqr;
  
  static
  {
    AppMethodBeat.i(77381);
    String str2 = com.tencent.mm.compatible.util.e.eQz;
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    str1 = str1 + "wxacache/";
    fqs = str1;
    com.tencent.mm.vfs.e.um(str1);
    AppMethodBeat.o(77381);
  }
  
  private b()
  {
    AppMethodBeat.i(77361);
    this.fqm = new ConcurrentHashMap();
    this.fqn = new ConcurrentHashMap();
    this.fqo = new ConcurrentHashMap();
    this.fqq = new b.c();
    this.fqr = new b.a((byte)0);
    this.fqp = new b.d(new ak(new al("AppBrandSimpleImageLoaderDiskIOHandlerThread").oNc.getLooper()), (byte)0);
    AppMethodBeat.o(77361);
  }
  
  private static String a(String paramString, b.f paramf, e parame)
  {
    AppMethodBeat.i(77373);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    if (paramf != null)
    {
      localStringBuilder.append("|transformation:");
      localStringBuilder.append(paramf.tX());
    }
    if (parame != null)
    {
      localStringBuilder.append("|decoder:");
      localStringBuilder.append(parame.tX());
    }
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(77373);
    return paramString;
  }
  
  public static b acD()
  {
    return b.m.fqT;
  }
  
  private static String av(String paramString1, String paramString2)
  {
    AppMethodBeat.i(77372);
    paramString1 = paramString1 + paramString2;
    AppMethodBeat.o(77372);
    return paramString1;
  }
  
  private void f(ImageView paramImageView)
  {
    AppMethodBeat.i(77362);
    if (paramImageView == null)
    {
      AppMethodBeat.o(77362);
      return;
    }
    paramImageView = (String)this.fqo.remove(Integer.valueOf(paramImageView.hashCode()));
    if (paramImageView == null)
    {
      AppMethodBeat.o(77362);
      return;
    }
    paramImageView = (b.i)this.fqn.get(paramImageView);
    if (paramImageView == null)
    {
      AppMethodBeat.o(77362);
      return;
    }
    paramImageView = (String)this.fqm.remove(paramImageView);
    if (!bo.isNullOrNil(paramImageView)) {
      this.fqn.remove(paramImageView);
    }
    AppMethodBeat.o(77362);
  }
  
  private static String qz(String paramString)
  {
    AppMethodBeat.i(77374);
    String str = null;
    if (!bo.isNullOrNil(paramString)) {
      str = g.w(paramString.getBytes());
    }
    AppMethodBeat.o(77374);
    return str;
  }
  
  /* Error */
  public final Bitmap a(String paramString, e parame)
  {
    // Byte code:
    //   0: ldc 240
    //   2: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 217	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifeq +10 -> 19
    //   12: ldc 240
    //   14: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: aconst_null
    //   18: areturn
    //   19: aload_1
    //   20: aconst_null
    //   21: aload_2
    //   22: invokestatic 186	com/tencent/mm/modelappbrand/a/b:a	(Ljava/lang/String;Lcom/tencent/mm/modelappbrand/a/b$f;Lcom/tencent/mm/modelappbrand/a/b$e;)Ljava/lang/String;
    //   25: astore 5
    //   27: aload_0
    //   28: getfield 109	com/tencent/mm/modelappbrand/a/b:fqq	Lcom/tencent/mm/modelappbrand/a/b$j;
    //   31: aload 5
    //   33: invokeinterface 244 2 0
    //   38: astore 4
    //   40: aload 4
    //   42: ifnull +11 -> 53
    //   45: ldc 240
    //   47: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload 4
    //   52: areturn
    //   53: aload_1
    //   54: ldc 246
    //   56: invokevirtual 249	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   59: istore_3
    //   60: iload_3
    //   61: ifeq +74 -> 135
    //   64: aload_1
    //   65: invokestatic 253	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   68: astore_1
    //   69: aload_2
    //   70: ifnull +82 -> 152
    //   73: aload_1
    //   74: astore 4
    //   76: aload_2
    //   77: aload_1
    //   78: invokeinterface 257 2 0
    //   83: astore_2
    //   84: aload_2
    //   85: ifnull +18 -> 103
    //   88: aload_1
    //   89: astore 4
    //   91: aload_0
    //   92: getfield 109	com/tencent/mm/modelappbrand/a/b:fqq	Lcom/tencent/mm/modelappbrand/a/b$j;
    //   95: aload 5
    //   97: aload_2
    //   98: invokeinterface 260 3 0
    //   103: aload_1
    //   104: invokestatic 263	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   107: ldc 240
    //   109: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: aload_2
    //   113: areturn
    //   114: astore_1
    //   115: ldc_w 265
    //   118: ldc_w 267
    //   121: invokestatic 272	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: aconst_null
    //   125: invokestatic 263	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   128: ldc 240
    //   130: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: aconst_null
    //   134: areturn
    //   135: aload_0
    //   136: getfield 114	com/tencent/mm/modelappbrand/a/b:fqr	Lcom/tencent/mm/modelappbrand/a/b$g;
    //   139: aload_1
    //   140: invokestatic 223	com/tencent/mm/modelappbrand/a/b:qz	(Ljava/lang/String;)Ljava/lang/String;
    //   143: invokeinterface 273 2 0
    //   148: astore_1
    //   149: goto -80 -> 69
    //   152: aload_1
    //   153: astore 4
    //   155: aload_1
    //   156: invokestatic 278	com/tencent/mm/sdk/platformtools/d:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   159: astore_2
    //   160: goto -76 -> 84
    //   163: astore_2
    //   164: aconst_null
    //   165: astore_1
    //   166: aload_1
    //   167: astore 4
    //   169: ldc_w 265
    //   172: aload_2
    //   173: ldc_w 280
    //   176: iconst_0
    //   177: anewarray 4	java/lang/Object
    //   180: invokestatic 284	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   183: aload_1
    //   184: invokestatic 263	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   187: ldc 240
    //   189: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   192: aconst_null
    //   193: areturn
    //   194: astore_1
    //   195: aconst_null
    //   196: astore 4
    //   198: aload 4
    //   200: invokestatic 263	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   203: ldc 240
    //   205: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: aload_1
    //   209: athrow
    //   210: astore_1
    //   211: goto -13 -> 198
    //   214: astore_2
    //   215: goto -49 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	b
    //   0	218	1	paramString	String
    //   0	218	2	parame	e
    //   59	2	3	bool	boolean
    //   38	161	4	localObject	Object
    //   25	71	5	str	String
    // Exception table:
    //   from	to	target	type
    //   64	69	114	java/io/FileNotFoundException
    //   53	60	163	java/lang/Exception
    //   64	69	163	java/lang/Exception
    //   115	124	163	java/lang/Exception
    //   135	149	163	java/lang/Exception
    //   53	60	194	finally
    //   64	69	194	finally
    //   115	124	194	finally
    //   135	149	194	finally
    //   76	84	210	finally
    //   91	103	210	finally
    //   155	160	210	finally
    //   169	183	210	finally
    //   76	84	214	java/lang/Exception
    //   91	103	214	java/lang/Exception
    //   155	160	214	java/lang/Exception
  }
  
  public final String a(ImageView paramImageView, String paramString, int paramInt, b.f paramf)
  {
    AppMethodBeat.i(77368);
    if (paramImageView == null)
    {
      AppMethodBeat.o(77368);
      return null;
    }
    paramImageView = a(paramImageView, paramString, paramImageView.getContext().getResources().getDrawable(paramInt), paramf);
    AppMethodBeat.o(77368);
    return paramImageView;
  }
  
  public final String a(ImageView paramImageView, String paramString, Drawable paramDrawable, b.f paramf)
  {
    AppMethodBeat.i(77369);
    paramImageView = a(paramImageView, paramString, paramDrawable, paramf, null);
    AppMethodBeat.o(77369);
    return paramImageView;
  }
  
  public final String a(ImageView paramImageView, String paramString, Drawable paramDrawable, b.f paramf, e parame)
  {
    AppMethodBeat.i(77370);
    if (paramImageView == null)
    {
      AppMethodBeat.o(77370);
      return null;
    }
    f(paramImageView);
    if (bo.isNullOrNil(paramString))
    {
      if (paramDrawable != null) {
        paramImageView.setImageDrawable(paramDrawable);
      }
      AppMethodBeat.o(77370);
      return null;
    }
    paramDrawable = new b.2(this, paramImageView, this, paramDrawable);
    paramString = a(paramDrawable, paramString, paramf, parame);
    if (!paramDrawable.fqI) {
      this.fqo.put(Integer.valueOf(paramImageView.hashCode()), av(paramDrawable.key, paramString));
    }
    AppMethodBeat.o(77370);
    return paramString;
  }
  
  public final String a(b.i parami, String paramString, b.f paramf)
  {
    AppMethodBeat.i(77367);
    parami = a(parami, paramString, paramf, null);
    AppMethodBeat.o(77367);
    return parami;
  }
  
  public final String a(b.i parami, String paramString, b.f paramf, e parame)
  {
    AppMethodBeat.i(77366);
    if (parami == null)
    {
      AppMethodBeat.o(77366);
      return null;
    }
    if (bo.isNullOrNil(paramString))
    {
      parami.acH();
      AppMethodBeat.o(77366);
      return null;
    }
    try
    {
      if ("null".equals(Uri.parse(paramString).getHost()))
      {
        parami.acH();
        AppMethodBeat.o(77366);
        return null;
      }
    }
    catch (Exception localException)
    {
      ab.d("MicroMsg.AppBrandSimpleImageLoader", "load before start LoadTask url %s", new Object[] { paramString });
      parame = new b.l(paramString, paramf, this, this.fqq, this.fqr, parame, parami.tX(), (byte)0);
      paramf = parame.acM();
      parami = new b.1(this, paramf, parami, paramString, parame);
      if (!al.isMainThread()) {
        break label157;
      }
    }
    parami.run();
    for (;;)
    {
      AppMethodBeat.o(77366);
      return paramf;
      label157:
      al.d(parami);
    }
  }
  
  public final void qA(String paramString)
  {
    AppMethodBeat.i(77375);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(77375);
      return;
    }
    paramString = qz(paramString);
    if (this.fqp.qF(paramString))
    {
      AppMethodBeat.o(77375);
      return;
    }
    this.fqr.qD(paramString);
    AppMethodBeat.o(77375);
  }
  
  public final Bitmap qw(String paramString)
  {
    AppMethodBeat.i(77363);
    paramString = this.fqq.lK(paramString);
    if ((paramString == null) || (paramString.isRecycled()))
    {
      AppMethodBeat.o(77363);
      return null;
    }
    AppMethodBeat.o(77363);
    return paramString;
  }
  
  public final String qx(String paramString)
  {
    AppMethodBeat.i(77365);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(77365);
      return null;
    }
    paramString = a(new b.b(), paramString, null);
    AppMethodBeat.o(77365);
    return paramString;
  }
  
  /* Error */
  public final byte[] qy(String paramString)
  {
    // Byte code:
    //   0: ldc_w 407
    //   3: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 217	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifeq +11 -> 21
    //   13: ldc_w 407
    //   16: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aconst_null
    //   20: areturn
    //   21: aload_1
    //   22: ldc 246
    //   24: invokevirtual 249	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   27: istore_2
    //   28: iload_2
    //   29: ifeq +51 -> 80
    //   32: aload_1
    //   33: invokestatic 253	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   36: astore_1
    //   37: aload_1
    //   38: astore_3
    //   39: aload_1
    //   40: invokestatic 412	com/tencent/luggage/g/i:g	(Ljava/io/InputStream;)[B
    //   43: astore 4
    //   45: aload_1
    //   46: invokestatic 263	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   49: ldc_w 407
    //   52: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: aload 4
    //   57: areturn
    //   58: astore_1
    //   59: ldc_w 265
    //   62: ldc_w 267
    //   65: invokestatic 272	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: aconst_null
    //   69: invokestatic 263	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   72: ldc_w 407
    //   75: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aconst_null
    //   79: areturn
    //   80: aload_0
    //   81: getfield 114	com/tencent/mm/modelappbrand/a/b:fqr	Lcom/tencent/mm/modelappbrand/a/b$g;
    //   84: aload_1
    //   85: invokestatic 223	com/tencent/mm/modelappbrand/a/b:qz	(Ljava/lang/String;)Ljava/lang/String;
    //   88: invokeinterface 273 2 0
    //   93: astore_1
    //   94: goto -57 -> 37
    //   97: astore 4
    //   99: aconst_null
    //   100: astore_1
    //   101: aload_1
    //   102: astore_3
    //   103: ldc_w 265
    //   106: aload 4
    //   108: ldc_w 280
    //   111: iconst_0
    //   112: anewarray 4	java/lang/Object
    //   115: invokestatic 284	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   118: aload_1
    //   119: invokestatic 263	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   122: ldc_w 407
    //   125: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aconst_null
    //   129: areturn
    //   130: astore_1
    //   131: aconst_null
    //   132: astore_3
    //   133: aload_3
    //   134: invokestatic 263	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   137: ldc_w 407
    //   140: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: aload_1
    //   144: athrow
    //   145: astore_1
    //   146: goto -13 -> 133
    //   149: astore 4
    //   151: goto -50 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	b
    //   0	154	1	paramString	String
    //   27	2	2	bool	boolean
    //   38	96	3	str	String
    //   43	13	4	arrayOfByte	byte[]
    //   97	10	4	localException1	Exception
    //   149	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   32	37	58	java/io/FileNotFoundException
    //   21	28	97	java/lang/Exception
    //   32	37	97	java/lang/Exception
    //   59	68	97	java/lang/Exception
    //   80	94	97	java/lang/Exception
    //   21	28	130	finally
    //   32	37	130	finally
    //   59	68	130	finally
    //   80	94	130	finally
    //   39	45	145	finally
    //   103	118	145	finally
    //   39	45	149	java/lang/Exception
  }
  
  public static abstract interface e
    extends c
  {
    public abstract Bitmap r(InputStream paramInputStream);
  }
  
  public static abstract interface g
  {
    public abstract InputStream openRead(String paramString);
    
    public abstract OutputStream qC(String paramString);
    
    public abstract boolean qD(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b
 * JD-Core Version:    0.7.0.1
 */