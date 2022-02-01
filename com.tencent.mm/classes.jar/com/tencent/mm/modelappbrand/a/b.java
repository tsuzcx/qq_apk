package com.tencent.mm.modelappbrand.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.appbrand.z.m;
import com.tencent.mm.plugin.appbrand.z.m.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.q;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class b
{
  private static String hKP;
  private static g hKQ;
  private final Map<k, String> hKJ;
  private final Map<String, k> hKK;
  private final Map<Integer, String> hKL;
  public final e hKM;
  private final l hKN;
  private final i hKO;
  
  static
  {
    AppMethodBeat.i(131403);
    com.tencent.mm.vfs.e locale2 = com.tencent.mm.vfs.e.X(aj.getContext().getExternalCacheDir());
    com.tencent.mm.vfs.e locale1 = locale2;
    if (locale2 == null) {
      locale1 = com.tencent.mm.vfs.e.X(aj.getContext().getCacheDir());
    }
    if (locale1 != null) {
      Cu(q.B(locale1.fOK()));
    }
    hKQ = g.hLk;
    AppMethodBeat.o(131403);
  }
  
  private b()
  {
    AppMethodBeat.i(131383);
    this.hKJ = new ConcurrentHashMap();
    this.hKK = new ConcurrentHashMap();
    this.hKL = new ConcurrentHashMap();
    this.hKN = new b.d();
    this.hKO = new b((byte)0);
    this.hKM = new e(new ap("AppBrandSimpleImageLoaderDiskIOHandlerThread"), (byte)0);
    AppMethodBeat.o(131383);
  }
  
  /* Error */
  private byte[] Ct(String paramString)
  {
    // Byte code:
    //   0: ldc 185
    //   2: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 191	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifeq +10 -> 19
    //   12: ldc 185
    //   14: invokestatic 144	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: aconst_null
    //   18: areturn
    //   19: aload_0
    //   20: getfield 166	com/tencent/mm/modelappbrand/a/b:hKO	Lcom/tencent/mm/modelappbrand/a/b$i;
    //   23: new 74	com/tencent/mm/modelappbrand/a/b$p
    //   26: dup
    //   27: aload_1
    //   28: iconst_0
    //   29: invokespecial 194	com/tencent/mm/modelappbrand/a/b$p:<init>	(Ljava/lang/String;B)V
    //   32: getfield 197	com/tencent/mm/modelappbrand/a/b$p:hLz	Ljava/lang/String;
    //   35: invokeinterface 201 2 0
    //   40: astore 4
    //   42: aload 4
    //   44: ifnonnull +20 -> 64
    //   47: aload 4
    //   49: ifnull +8 -> 57
    //   52: aload 4
    //   54: invokevirtual 206	java/io/InputStream:close	()V
    //   57: ldc 185
    //   59: invokestatic 144	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: aconst_null
    //   63: areturn
    //   64: aload 4
    //   66: invokestatic 212	org/apache/commons/a/e:toByteArray	(Ljava/io/InputStream;)[B
    //   69: astore_2
    //   70: aload 4
    //   72: ifnull +8 -> 80
    //   75: aload 4
    //   77: invokevirtual 206	java/io/InputStream:close	()V
    //   80: ldc 185
    //   82: invokestatic 144	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: aload_2
    //   86: areturn
    //   87: astore_3
    //   88: ldc 185
    //   90: invokestatic 144	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aload_3
    //   94: athrow
    //   95: astore_2
    //   96: aload 4
    //   98: ifnull +12 -> 110
    //   101: aload_3
    //   102: ifnull +49 -> 151
    //   105: aload 4
    //   107: invokevirtual 206	java/io/InputStream:close	()V
    //   110: ldc 185
    //   112: invokestatic 144	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: aload_2
    //   116: athrow
    //   117: astore_2
    //   118: ldc 214
    //   120: ldc 216
    //   122: iconst_1
    //   123: anewarray 4	java/lang/Object
    //   126: dup
    //   127: iconst_0
    //   128: aload_1
    //   129: aastore
    //   130: invokestatic 221	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   133: ldc 185
    //   135: invokestatic 144	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: aconst_null
    //   139: areturn
    //   140: astore 4
    //   142: aload_3
    //   143: aload 4
    //   145: invokevirtual 225	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   148: goto -38 -> 110
    //   151: aload 4
    //   153: invokevirtual 206	java/io/InputStream:close	()V
    //   156: goto -46 -> 110
    //   159: astore_2
    //   160: aconst_null
    //   161: astore_3
    //   162: goto -66 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	b
    //   0	165	1	paramString	String
    //   69	17	2	arrayOfByte	byte[]
    //   95	21	2	localObject1	Object
    //   117	1	2	localIOException	IOException
    //   159	1	2	localObject2	Object
    //   87	56	3	localThrowable1	Throwable
    //   161	1	3	localObject3	Object
    //   40	66	4	localInputStream	InputStream
    //   140	12	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   64	70	87	java/lang/Throwable
    //   88	95	95	finally
    //   19	42	117	java/io/IOException
    //   52	57	117	java/io/IOException
    //   75	80	117	java/io/IOException
    //   105	110	117	java/io/IOException
    //   110	117	117	java/io/IOException
    //   142	148	117	java/io/IOException
    //   151	156	117	java/io/IOException
    //   105	110	140	java/lang/Throwable
    //   64	70	159	finally
  }
  
  public static void Cu(String paramString)
  {
    AppMethodBeat.i(176003);
    String str = paramString;
    if (!paramString.endsWith("/")) {
      str = paramString + "/";
    }
    paramString = str + "wxacache/";
    hKP = paramString;
    com.tencent.mm.vfs.i.aYg(paramString);
    AppMethodBeat.o(176003);
  }
  
  private static String Cv(String paramString)
  {
    AppMethodBeat.i(131396);
    String str = null;
    if (!bt.isNullOrNil(paramString)) {
      str = g.getMessageDigest(paramString.getBytes());
    }
    AppMethodBeat.o(131396);
    return str;
  }
  
  private static String a(String paramString, b.h paramh, f paramf)
  {
    AppMethodBeat.i(131395);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    if (paramh != null)
    {
      localStringBuilder.append("|transformation:");
      localStringBuilder.append(paramh.BM());
    }
    if (paramf != null)
    {
      localStringBuilder.append("|decoder:");
      localStringBuilder.append(paramf.BM());
    }
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(131395);
    return paramString;
  }
  
  public static void a(g paramg)
  {
    synchronized (o.hLx)
    {
      hKQ = paramg;
      return;
    }
  }
  
  public static b aDV()
  {
    return o.hLx;
  }
  
  private static g aDW()
  {
    synchronized (o.hLx)
    {
      g localg = hKQ;
      return localg;
    }
  }
  
  private static String aU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(131394);
    paramString1 = paramString1 + paramString2;
    AppMethodBeat.o(131394);
    return paramString1;
  }
  
  private String b(final k paramk, final String paramString, final b.h paramh, final f paramf)
  {
    AppMethodBeat.i(199394);
    if (paramk == null)
    {
      AppMethodBeat.o(199394);
      return null;
    }
    if (bt.isNullOrNil(paramString))
    {
      paramk.ox();
      AppMethodBeat.o(199394);
      return null;
    }
    try
    {
      if ("null".equals(Uri.parse(paramString).getHost()))
      {
        paramk.ox();
        AppMethodBeat.o(199394);
        return null;
      }
    }
    catch (Exception localException)
    {
      ad.d("Luggage.AppBrandSimpleImageLoader", "load before start LoadTask url %s", new Object[] { paramString });
      String str = paramk.BM() + "@" + paramk.hashCode();
      paramf = new n(paramString, paramh, this, this.hKN, this.hKO, paramf, str);
      paramh = paramf.aEg();
      paramk = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(131336);
          Object localObject = b.this.Cr(paramh);
          if (localObject != null)
          {
            paramk.E((Bitmap)localObject);
            ad.d("Luggage.AppBrandSimpleImageLoader", "load already cached, url %s, bitmap %s", new Object[] { paramString, localObject });
            AppMethodBeat.o(131336);
            return;
          }
          localObject = paramf.aEf();
          b.c(b.this).put(paramk, localObject);
          b.d(b.this).put(localObject, paramk);
          paramk.aEd();
          localObject = paramf;
          b.a(((b.n)localObject).hLl).post(new b.n.2((b.n)localObject));
          AppMethodBeat.o(131336);
        }
      };
      if (!aq.isMainThread()) {
        break label185;
      }
    }
    paramk.run();
    for (;;)
    {
      AppMethodBeat.o(199394);
      return paramh;
      label185:
      aq.f(paramk);
    }
  }
  
  private void d(ImageView paramImageView)
  {
    AppMethodBeat.i(131384);
    if (paramImageView == null)
    {
      AppMethodBeat.o(131384);
      return;
    }
    paramImageView = (String)this.hKL.remove(Integer.valueOf(paramImageView.hashCode()));
    if (paramImageView == null)
    {
      AppMethodBeat.o(131384);
      return;
    }
    a((k)this.hKK.get(paramImageView));
    AppMethodBeat.o(131384);
  }
  
  public final Bitmap Cr(String paramString)
  {
    AppMethodBeat.i(131385);
    paramString = this.hKN.vT(paramString);
    if ((paramString == null) || (paramString.isRecycled()))
    {
      AppMethodBeat.o(131385);
      return null;
    }
    AppMethodBeat.o(131385);
    return paramString;
  }
  
  public final String Cs(String paramString)
  {
    AppMethodBeat.i(131387);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(131387);
      return null;
    }
    paramString = a(new c(), paramString, null);
    AppMethodBeat.o(131387);
    return paramString;
  }
  
  public final void Cw(String paramString)
  {
    AppMethodBeat.i(131397);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(131397);
      return;
    }
    paramString = Cv(paramString);
    if (this.hKM.CD(paramString))
    {
      AppMethodBeat.o(131397);
      return;
    }
    this.hKO.CA(paramString);
    AppMethodBeat.o(131397);
  }
  
  public final void Cx(String paramString)
  {
    AppMethodBeat.i(161227);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(161227);
      return;
    }
    this.hKN.CB(paramString);
    AppMethodBeat.o(161227);
  }
  
  /* Error */
  public final Bitmap a(String paramString, f paramf)
  {
    // Byte code:
    //   0: ldc_w 438
    //   3: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 191	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifeq +11 -> 21
    //   13: ldc_w 438
    //   16: invokestatic 144	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aconst_null
    //   20: areturn
    //   21: aload_1
    //   22: aconst_null
    //   23: aload_2
    //   24: invokestatic 383	com/tencent/mm/modelappbrand/a/b:a	(Ljava/lang/String;Lcom/tencent/mm/modelappbrand/a/b$h;Lcom/tencent/mm/modelappbrand/a/b$f;)Ljava/lang/String;
    //   27: astore 5
    //   29: aload_0
    //   30: getfield 161	com/tencent/mm/modelappbrand/a/b:hKN	Lcom/tencent/mm/modelappbrand/a/b$l;
    //   33: aload 5
    //   35: invokeinterface 410 2 0
    //   40: astore 4
    //   42: aload 4
    //   44: ifnull +12 -> 56
    //   47: ldc_w 438
    //   50: invokestatic 144	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aload 4
    //   55: areturn
    //   56: aload_1
    //   57: ldc_w 440
    //   60: invokevirtual 443	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   63: istore_3
    //   64: iload_3
    //   65: ifeq +45 -> 110
    //   68: aload_1
    //   69: invokestatic 444	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   72: astore_1
    //   73: aload_1
    //   74: ifnonnull +53 -> 127
    //   77: aload_1
    //   78: invokestatic 447	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   81: ldc_w 438
    //   84: invokestatic 144	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aconst_null
    //   88: areturn
    //   89: astore_1
    //   90: ldc 214
    //   92: ldc_w 449
    //   95: invokestatic 452	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aconst_null
    //   99: invokestatic 447	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   102: ldc_w 438
    //   105: invokestatic 144	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: aconst_null
    //   109: areturn
    //   110: aload_0
    //   111: getfield 166	com/tencent/mm/modelappbrand/a/b:hKO	Lcom/tencent/mm/modelappbrand/a/b$i;
    //   114: aload_1
    //   115: invokestatic 270	com/tencent/mm/modelappbrand/a/b:Cv	(Ljava/lang/String;)Ljava/lang/String;
    //   118: invokeinterface 201 2 0
    //   123: astore_1
    //   124: goto -51 -> 73
    //   127: aload_2
    //   128: ifnull +45 -> 173
    //   131: aload_1
    //   132: astore 4
    //   134: aload_2
    //   135: aload_1
    //   136: invokeinterface 456 2 0
    //   141: astore_2
    //   142: aload_2
    //   143: ifnull +18 -> 161
    //   146: aload_1
    //   147: astore 4
    //   149: aload_0
    //   150: getfield 161	com/tencent/mm/modelappbrand/a/b:hKN	Lcom/tencent/mm/modelappbrand/a/b$l;
    //   153: aload 5
    //   155: aload_2
    //   156: invokeinterface 460 3 0
    //   161: aload_1
    //   162: invokestatic 447	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   165: ldc_w 438
    //   168: invokestatic 144	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: aload_2
    //   172: areturn
    //   173: aload_1
    //   174: astore 4
    //   176: invokestatic 312	com/tencent/mm/modelappbrand/a/b:aDW	()Lcom/tencent/mm/modelappbrand/a/b$g;
    //   179: aload_1
    //   180: invokeinterface 463 2 0
    //   185: astore_2
    //   186: goto -44 -> 142
    //   189: astore_2
    //   190: aconst_null
    //   191: astore_1
    //   192: aload_1
    //   193: astore 4
    //   195: ldc 214
    //   197: aload_2
    //   198: ldc_w 465
    //   201: iconst_0
    //   202: anewarray 4	java/lang/Object
    //   205: invokestatic 469	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   208: aload_1
    //   209: invokestatic 447	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   212: ldc_w 438
    //   215: invokestatic 144	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   218: aconst_null
    //   219: areturn
    //   220: astore_1
    //   221: aconst_null
    //   222: astore 4
    //   224: aload 4
    //   226: invokestatic 447	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   229: ldc_w 438
    //   232: invokestatic 144	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: aload_1
    //   236: athrow
    //   237: astore_1
    //   238: goto -14 -> 224
    //   241: astore_2
    //   242: goto -50 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	b
    //   0	245	1	paramString	String
    //   0	245	2	paramf	f
    //   63	2	3	bool	boolean
    //   40	185	4	localObject	Object
    //   27	127	5	str	String
    // Exception table:
    //   from	to	target	type
    //   68	73	89	java/io/FileNotFoundException
    //   56	64	189	java/lang/Exception
    //   68	73	189	java/lang/Exception
    //   90	98	189	java/lang/Exception
    //   110	124	189	java/lang/Exception
    //   56	64	220	finally
    //   68	73	220	finally
    //   90	98	220	finally
    //   110	124	220	finally
    //   134	142	237	finally
    //   149	161	237	finally
    //   176	186	237	finally
    //   195	208	237	finally
    //   134	142	241	java/lang/Exception
    //   149	161	241	java/lang/Exception
    //   176	186	241	java/lang/Exception
  }
  
  public final String a(ImageView paramImageView, String paramString, int paramInt, b.h paramh)
  {
    AppMethodBeat.i(131390);
    if (paramImageView == null)
    {
      AppMethodBeat.o(131390);
      return null;
    }
    paramImageView = a(paramImageView, paramString, paramImageView.getContext().getResources().getDrawable(paramInt), paramh);
    AppMethodBeat.o(131390);
    return paramImageView;
  }
  
  public final String a(ImageView paramImageView, String paramString, Drawable paramDrawable, b.h paramh)
  {
    AppMethodBeat.i(131391);
    paramImageView = a(paramImageView, paramString, paramDrawable, paramh, null);
    AppMethodBeat.o(131391);
    return paramImageView;
  }
  
  public final String a(ImageView paramImageView, String paramString, Drawable paramDrawable, b.h paramh, f paramf)
  {
    AppMethodBeat.i(131392);
    if (paramImageView == null)
    {
      AppMethodBeat.o(131392);
      return null;
    }
    d(paramImageView);
    if (bt.isNullOrNil(paramString))
    {
      if (paramDrawable != null) {
        paramImageView.setImageDrawable(paramDrawable);
      }
      AppMethodBeat.o(131392);
      return null;
    }
    paramDrawable = new b.2(this, paramImageView, this, paramDrawable);
    paramString = a(paramDrawable, paramString, paramh, paramf);
    if (!paramDrawable.hLm) {
      this.hKL.put(Integer.valueOf(paramImageView.hashCode()), aU(paramDrawable.key, paramString));
    }
    AppMethodBeat.o(131392);
    return paramString;
  }
  
  public final String a(k paramk, String paramString, b.h paramh)
  {
    AppMethodBeat.i(131389);
    paramk = a(paramk, paramString, paramh, null);
    AppMethodBeat.o(131389);
    return paramk;
  }
  
  public final String a(k paramk, String paramString, b.h paramh, f paramf)
  {
    AppMethodBeat.i(131388);
    paramk = b(paramk, paramString, paramh, paramf);
    AppMethodBeat.o(131388);
    return paramk;
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(199393);
    if (paramk == null)
    {
      AppMethodBeat.o(199393);
      return;
    }
    paramk = (String)this.hKJ.remove(paramk);
    if (!bt.isNullOrNil(paramk)) {
      this.hKK.remove(paramk);
    }
    AppMethodBeat.o(199393);
  }
  
  public final void a(final String paramString, final j paramj)
  {
    AppMethodBeat.i(183777);
    byte[] arrayOfByte = Ct(paramString);
    if ((arrayOfByte != null) && (arrayOfByte.length != 0))
    {
      paramj.V(arrayOfByte);
      AppMethodBeat.o(183777);
      return;
    }
    b(new k()
    {
      public final String BM()
      {
        return "BytesLoadTarget";
      }
      
      public final void E(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(131339);
        m.bBp().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(131338);
            byte[] arrayOfByte = b.a(b.this, b.3.this.val$url);
            if (b.3.this.hLa != null) {
              b.3.this.hLa.V(arrayOfByte);
            }
            AppMethodBeat.o(131338);
          }
        });
        AppMethodBeat.o(131339);
      }
      
      public final void aEd() {}
      
      public final void ox()
      {
        AppMethodBeat.i(131340);
        if (paramj != null) {
          paramj.V(null);
        }
        AppMethodBeat.o(131340);
      }
    }, paramString, null, null);
    AppMethodBeat.o(183777);
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(161226);
    this.hKN.clear();
    AppMethodBeat.o(161226);
  }
  
  public final class a
    implements b.e.a, Runnable
  {
    private boolean mCanceled = false;
    
    final void aEa()
    {
      AppMethodBeat.i(199381);
      b.a(this.hKU).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(199379);
          b.a(b.a.this.hKU).CF(b.a.this.hKV.hLz);
          b.a(b.a.this.hKU).CC(b.a.this.hKV.hLz);
          AppMethodBeat.o(199379);
        }
      });
      AppMethodBeat.o(199381);
    }
    
    public final void aEb()
    {
      AppMethodBeat.i(199383);
      if (this.mCanceled)
      {
        AppMethodBeat.o(199383);
        return;
      }
      try
      {
        InputStream localInputStream = b.b(this.hKU).openRead(this.hKV.hLz);
        if (localInputStream != null)
        {
          if (this.hKW != null) {
            this.hKW.apply(localInputStream);
          }
          aEa();
          AppMethodBeat.o(199383);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        ad.e("Luggage.AppBrandSimpleImageLoader", "loadIntoDiskCache diskCache.openRead failed, url=%s, e=%s", new Object[] { this.val$url, localThrowable });
        if (this.hKW != null) {
          this.hKW.apply(null);
        }
        aEa();
        AppMethodBeat.o(199383);
        return;
      }
      com.tencent.e.h.LTJ.aR(new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "AppBrandSimpleImageLoaderDownloadThread";
        }
        
        public final void run()
        {
          AppMethodBeat.i(199380);
          b.n.a(b.a.this.hKV, b.a.this.hKX, b.b(b.a.this.hKU));
          if (b.a.this.hKW != null) {}
          try
          {
            b.a.this.hKW.apply(b.b(b.a.this.hKU).openRead(b.a.this.hKV.hLz));
            label80:
            b.a.this.aEa();
            AppMethodBeat.o(199380);
            return;
          }
          catch (Throwable localThrowable)
          {
            break label80;
          }
        }
      });
      AppMethodBeat.o(199383);
    }
    
    public final void aEc()
    {
      this.mCanceled = true;
    }
    
    public final void run()
    {
      AppMethodBeat.i(199382);
      if (b.a(this.hKU).CD(this.hKV.hLz))
      {
        b.a(this.hKU).a(this.hKV.hLz, this);
        AppMethodBeat.o(199382);
        return;
      }
      b.a(this.hKU).CE(this.hKV.hLz);
      aEb();
      AppMethodBeat.o(199382);
    }
  }
  
  static final class b
    implements b.i
  {
    public final boolean CA(String paramString)
    {
      AppMethodBeat.i(131344);
      if ((!bt.isNullOrNil(paramString)) && (com.tencent.mm.vfs.i.deleteFile(b.aDX() + paramString)))
      {
        AppMethodBeat.o(131344);
        return true;
      }
      AppMethodBeat.o(131344);
      return false;
    }
    
    public final OutputStream Cz(String paramString)
    {
      AppMethodBeat.i(131342);
      try
      {
        if ((!com.tencent.mm.vfs.i.aYg(b.aDX())) && (!new com.tencent.mm.vfs.e(b.aDX()).isDirectory()))
        {
          com.tencent.mm.vfs.i.deleteFile(b.aDX());
          com.tencent.mm.vfs.i.aYg(b.aDX());
        }
        localObject = b.aDX() + paramString;
        str = (String)localObject + ".wlock";
        com.tencent.mm.vfs.i.deleteFile(str);
        com.tencent.mm.vfs.i.cZ(str, true);
        com.tencent.mm.vfs.i.f(str, new byte[1], 1);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          try
          {
            final String str;
            com.tencent.mm.vfs.i.deleteFile((String)localObject);
            com.tencent.mm.vfs.i.cZ((String)localObject, true);
            Object localObject = new BufferedOutputStream(com.tencent.mm.vfs.i.cX((String)localObject, false))
            {
              public final void flush()
              {
                try
                {
                  AppMethodBeat.i(131341);
                  super.flush();
                  com.tencent.mm.vfs.i.deleteFile(str);
                  AppMethodBeat.o(131341);
                  return;
                }
                finally
                {
                  localObject = finally;
                  throw localObject;
                }
              }
            };
            AppMethodBeat.o(131342);
            return localObject;
          }
          catch (IOException localIOException)
          {
            ad.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", localIOException, "openWrite fileName %s, parent exists[%b]", new Object[] { paramString, Boolean.valueOf(com.tencent.mm.vfs.i.fv(b.aDX())) });
            AppMethodBeat.o(131342);
          }
          localThrowable = localThrowable;
          ad.e("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", "openWrite mkdirs e=%s", new Object[] { localThrowable });
        }
      }
      return null;
    }
    
    public final InputStream openRead(String paramString)
    {
      AppMethodBeat.i(131343);
      Object localObject = b.aDX() + paramString;
      if (com.tencent.mm.vfs.i.fv((String)localObject + ".wlock"))
      {
        AppMethodBeat.o(131343);
        return null;
      }
      try
      {
        localObject = com.tencent.mm.vfs.i.openRead((String)localObject);
        AppMethodBeat.o(131343);
        return localObject;
      }
      catch (IOException localIOException)
      {
        ad.d("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", "openRead fileName %s, e %s", new Object[] { paramString, localIOException });
        AppMethodBeat.o(131343);
      }
      return null;
    }
  }
  
  public static class c
    implements b.k
  {
    public final String BM()
    {
      return "DefaultLoadTarget";
    }
    
    public void E(Bitmap paramBitmap) {}
    
    public final void aEd() {}
    
    public final void ox() {}
  }
  
  public static final class e
  {
    public final ap hLh;
    private final Map<String, List<a>> hLi;
    private final Map<String, Boolean> hLj;
    
    private e(ap paramap)
    {
      AppMethodBeat.i(131355);
      this.hLi = new HashMap();
      this.hLj = new HashMap();
      this.hLh = paramap;
      AppMethodBeat.o(131355);
    }
    
    final void CC(String paramString)
    {
      AppMethodBeat.i(131356);
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(131356);
        return;
      }
      paramString = (List)this.hLi.remove(paramString);
      if (bt.hj(paramString))
      {
        AppMethodBeat.o(131356);
        return;
      }
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        ((a)paramString.next()).aEb();
      }
      AppMethodBeat.o(131356);
    }
    
    final boolean CD(String paramString)
    {
      AppMethodBeat.i(131357);
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(131357);
        return false;
      }
      boolean bool = this.hLj.containsKey(paramString);
      AppMethodBeat.o(131357);
      return bool;
    }
    
    final void CE(String paramString)
    {
      AppMethodBeat.i(199385);
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(199385);
        return;
      }
      this.hLj.put(paramString, Boolean.TRUE);
      AppMethodBeat.o(199385);
    }
    
    final void CF(String paramString)
    {
      AppMethodBeat.i(131358);
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(131358);
        return;
      }
      this.hLj.remove(paramString);
      AppMethodBeat.o(131358);
    }
    
    final void CG(String paramString)
    {
      AppMethodBeat.i(131360);
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(131360);
        return;
      }
      paramString = (List)this.hLi.remove(paramString);
      if (!bt.hj(paramString))
      {
        Iterator localIterator = paramString.iterator();
        while (localIterator.hasNext()) {
          ((a)localIterator.next()).aEc();
        }
        paramString.clear();
      }
      AppMethodBeat.o(131360);
    }
    
    final void a(String paramString, a parama)
    {
      AppMethodBeat.i(199386);
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(199386);
        return;
      }
      List localList = (List)this.hLi.get(paramString);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new LinkedList();
        this.hLi.put(paramString, localObject);
      }
      ((List)localObject).add(parama);
      AppMethodBeat.o(199386);
    }
    
    final void b(String paramString, a parama)
    {
      AppMethodBeat.i(131359);
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(131359);
        return;
      }
      paramString = (List)this.hLi.get(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(131359);
        return;
      }
      paramString.remove(parama);
      AppMethodBeat.o(131359);
    }
    
    final void post(Runnable paramRunnable)
    {
      AppMethodBeat.i(131361);
      this.hLh.post(paramRunnable);
      AppMethodBeat.o(131361);
    }
    
    static abstract interface a
    {
      public abstract void aEb();
      
      public abstract void aEc();
    }
  }
  
  public static abstract interface f
    extends c
  {
    public abstract Bitmap x(InputStream paramInputStream);
  }
  
  public static abstract interface g
  {
    public static final g hLk = new g()
    {
      public final Bitmap decodeStream(InputStream paramAnonymousInputStream)
      {
        AppMethodBeat.i(176002);
        paramAnonymousInputStream = BitmapFactory.decodeStream(paramAnonymousInputStream);
        AppMethodBeat.o(176002);
        return paramAnonymousInputStream;
      }
    };
    
    public abstract Bitmap decodeStream(InputStream paramInputStream);
  }
  
  public static abstract interface i
  {
    public abstract boolean CA(String paramString);
    
    public abstract OutputStream Cz(String paramString);
    
    public abstract InputStream openRead(String paramString);
  }
  
  public static abstract interface j
  {
    public abstract void V(byte[] paramArrayOfByte);
  }
  
  public static abstract interface k
    extends c
  {
    public abstract String BM();
    
    public abstract void E(Bitmap paramBitmap);
    
    public abstract void aEd();
    
    public abstract void ox();
  }
  
  public static abstract interface l
  {
    public abstract void CB(String paramString);
    
    public abstract void clear();
    
    public abstract void f(Bitmap paramBitmap);
    
    public abstract void put(String paramString, Bitmap paramBitmap);
    
    public abstract void remove(String paramString);
    
    public abstract Bitmap vT(String paramString);
  }
  
  static final class n
    implements b.e.a
  {
    final b.i hKO;
    final b hLl;
    final b.p hLn;
    private final b.h hLo;
    private final b.l hLp;
    private final b.f hLq;
    private final String hLr;
    boolean hLs;
    final Map<String, String> mHeaders;
    
    public n(String paramString1, b.h paramh, b paramb, b.l paraml, b.i parami, b.f paramf, String paramString2)
    {
      AppMethodBeat.i(199387);
      this.hLs = true;
      this.hLn = new b.p(paramString1, (byte)0);
      this.mHeaders = null;
      this.hLo = paramh;
      this.hLl = paramb;
      this.hLp = paraml;
      this.hKO = parami;
      this.hLq = paramf;
      this.hLr = paramString2;
      AppMethodBeat.o(199387);
    }
    
    private Bitmap G(Bitmap paramBitmap)
    {
      AppMethodBeat.i(131378);
      paramBitmap = this.hLo.F(paramBitmap);
      AppMethodBeat.o(131378);
      return paramBitmap;
    }
    
    private void H(Bitmap paramBitmap)
    {
      boolean bool2 = false;
      AppMethodBeat.i(131379);
      if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        ad.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "postLoadInWorkerThread bitmap ok %b", new Object[] { Boolean.valueOf(bool1) });
        final Bitmap localBitmap = paramBitmap;
        if (this.hLo != null)
        {
          localBitmap = paramBitmap;
          if (paramBitmap != null)
          {
            localBitmap = paramBitmap;
            if (!paramBitmap.isRecycled())
            {
              localBitmap = G(paramBitmap);
              ad.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "postLoadInWorkerThread, transform bmp, origin %s, transformed %s", new Object[] { paramBitmap, localBitmap });
              if (localBitmap != paramBitmap) {
                this.hLp.f(paramBitmap);
              }
            }
          }
        }
        this.hLp.put(aEg(), localBitmap);
        bool1 = bool2;
        if (localBitmap != null)
        {
          bool1 = bool2;
          if (!localBitmap.isRecycled()) {
            bool1 = true;
          }
        }
        ad.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "postLoadInWorkerThread before post to main thread, bitmap %s, ok %b", new Object[] { localBitmap, Boolean.valueOf(bool1) });
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(131369);
            b.n localn = b.n.this;
            Object localObject = localBitmap;
            if ((localObject == null) || (((Bitmap)localObject).isRecycled()))
            {
              ad.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "postLoadInMainThread, onLoadFailed bmp %s", new Object[] { localObject });
              localObject = (b.k)b.d(localn.hLl).remove(localn.aEf());
              if (localObject != null)
              {
                ((b.k)localObject).ox();
                b.c(localn.hLl).remove(localObject);
              }
              AppMethodBeat.o(131369);
              return;
            }
            ad.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "postLoadInMainThread, onBitmapLoaded bmp %s", new Object[] { localObject });
            localn.E((Bitmap)localObject);
            AppMethodBeat.o(131369);
          }
        });
        AppMethodBeat.o(131379);
        return;
      }
    }
    
    /* Error */
    static void a(b.p paramp, Map<String, String> paramMap, b.i parami)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 4
      //   3: ldc 145
      //   5: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: aload_0
      //   9: aload_1
      //   10: invokevirtual 149	com/tencent/mm/modelappbrand/a/b$p:u	(Ljava/util/Map;)Ljava/io/InputStream;
      //   13: astore 5
      //   15: aload 5
      //   17: ifnull +196 -> 213
      //   20: aload_2
      //   21: aload_0
      //   22: getfield 152	com/tencent/mm/modelappbrand/a/b$p:hLz	Ljava/lang/String;
      //   25: invokeinterface 158 2 0
      //   30: astore 6
      //   32: aload 6
      //   34: ifnull +45 -> 79
      //   37: aload 5
      //   39: aload 6
      //   41: sipush 16384
      //   44: invokestatic 163	org/apache/commons/a/e:a	(Ljava/io/InputStream;Ljava/io/OutputStream;I)J
      //   47: pop2
      //   48: aload 6
      //   50: invokevirtual 168	java/io/OutputStream:flush	()V
      //   53: aload 6
      //   55: ifnull +8 -> 63
      //   58: aload 6
      //   60: invokevirtual 171	java/io/OutputStream:close	()V
      //   63: aload 5
      //   65: ifnull +185 -> 250
      //   68: aload 5
      //   70: invokevirtual 174	java/io/InputStream:close	()V
      //   73: ldc 145
      //   75: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   78: return
      //   79: ldc 97
      //   81: ldc 176
      //   83: iconst_1
      //   84: anewarray 4	java/lang/Object
      //   87: dup
      //   88: iconst_0
      //   89: aload_0
      //   90: aastore
      //   91: invokestatic 179	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   94: goto -41 -> 53
      //   97: astore_3
      //   98: ldc 145
      //   100: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   103: aload_3
      //   104: athrow
      //   105: astore_1
      //   106: aload 6
      //   108: ifnull +12 -> 120
      //   111: aload_3
      //   112: ifnull +93 -> 205
      //   115: aload 6
      //   117: invokevirtual 171	java/io/OutputStream:close	()V
      //   120: ldc 145
      //   122: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   125: aload_1
      //   126: athrow
      //   127: astore_3
      //   128: ldc 145
      //   130: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   133: aload_3
      //   134: athrow
      //   135: astore_1
      //   136: aload 5
      //   138: ifnull +12 -> 150
      //   141: aload_3
      //   142: ifnull +100 -> 242
      //   145: aload 5
      //   147: invokevirtual 174	java/io/InputStream:close	()V
      //   150: ldc 145
      //   152: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   155: aload_1
      //   156: athrow
      //   157: astore_1
      //   158: ldc 97
      //   160: ldc 181
      //   162: iconst_2
      //   163: anewarray 4	java/lang/Object
      //   166: dup
      //   167: iconst_0
      //   168: aload_0
      //   169: aastore
      //   170: dup
      //   171: iconst_1
      //   172: aload_1
      //   173: aastore
      //   174: invokestatic 179	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   177: aload_2
      //   178: aload_0
      //   179: getfield 152	com/tencent/mm/modelappbrand/a/b$p:hLz	Ljava/lang/String;
      //   182: invokeinterface 185 2 0
      //   187: pop
      //   188: ldc 145
      //   190: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   193: return
      //   194: astore 6
      //   196: aload_3
      //   197: aload 6
      //   199: invokevirtual 189	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
      //   202: goto -82 -> 120
      //   205: aload 6
      //   207: invokevirtual 171	java/io/OutputStream:close	()V
      //   210: goto -90 -> 120
      //   213: ldc 97
      //   215: ldc 191
      //   217: iconst_1
      //   218: anewarray 4	java/lang/Object
      //   221: dup
      //   222: iconst_0
      //   223: aload_0
      //   224: aastore
      //   225: invokestatic 179	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   228: goto -165 -> 63
      //   231: astore 4
      //   233: aload_3
      //   234: aload 4
      //   236: invokevirtual 189	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
      //   239: goto -89 -> 150
      //   242: aload 5
      //   244: invokevirtual 174	java/io/InputStream:close	()V
      //   247: goto -97 -> 150
      //   250: ldc 145
      //   252: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   255: return
      //   256: astore_1
      //   257: aconst_null
      //   258: astore_3
      //   259: goto -153 -> 106
      //   262: astore_1
      //   263: aload 4
      //   265: astore_3
      //   266: goto -130 -> 136
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	269	0	paramp	b.p
      //   0	269	1	paramMap	Map<String, String>
      //   0	269	2	parami	b.i
      //   97	15	3	localThrowable1	Throwable
      //   127	107	3	localThrowable2	Throwable
      //   258	8	3	localThrowable3	Throwable
      //   1	1	4	localObject	Object
      //   231	33	4	localThrowable4	Throwable
      //   13	230	5	localInputStream	InputStream
      //   30	86	6	localOutputStream	OutputStream
      //   194	12	6	localThrowable5	Throwable
      // Exception table:
      //   from	to	target	type
      //   37	53	97	java/lang/Throwable
      //   79	94	97	java/lang/Throwable
      //   98	105	105	finally
      //   20	32	127	java/lang/Throwable
      //   58	63	127	java/lang/Throwable
      //   120	127	127	java/lang/Throwable
      //   196	202	127	java/lang/Throwable
      //   205	210	127	java/lang/Throwable
      //   213	228	127	java/lang/Throwable
      //   128	135	135	finally
      //   8	15	157	java/io/IOException
      //   68	78	157	java/io/IOException
      //   145	150	157	java/io/IOException
      //   150	157	157	java/io/IOException
      //   233	239	157	java/io/IOException
      //   242	247	157	java/io/IOException
      //   115	120	194	java/lang/Throwable
      //   145	150	231	java/lang/Throwable
      //   37	53	256	finally
      //   79	94	256	finally
      //   20	32	262	finally
      //   58	63	262	finally
      //   115	120	262	finally
      //   120	127	262	finally
      //   196	202	262	finally
      //   205	210	262	finally
      //   213	228	262	finally
    }
    
    private Bitmap aEi()
    {
      Object localObject1 = null;
      AppMethodBeat.i(131380);
      if (!b.aDY())
      {
        ad.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, sdcard unavailable");
        localObject1 = new d.c();
        AppMethodBeat.o(131380);
        throw ((Throwable)localObject1);
      }
      Object localObject2 = this.hKO.openRead(this.hLn.hLz);
      if (localObject2 == null)
      {
        ad.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, null from disk, tryDownload %b", new Object[] { Boolean.valueOf(this.hLs) });
        if (this.hLs) {
          com.tencent.e.h.LTJ.aR(new com.tencent.e.i.h()
          {
            public final String getKey()
            {
              return "AppBrandSimpleImageLoaderDownloadThread";
            }
            
            public final void run()
            {
              AppMethodBeat.i(131371);
              b.n.a(b.n.this.hLn, b.n.this.mHeaders, b.n.this.hKO);
              b.a(b.n.this.hLl).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(131370);
                  b.n.this.hLs = false;
                  b.n.this.aEh();
                  AppMethodBeat.o(131370);
                }
              });
              AppMethodBeat.o(131371);
            }
          });
        }
      }
      else
      {
        if (localObject2 == null) {
          break label264;
        }
      }
      try
      {
        localObject2 = y((InputStream)localObject2);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.printErrStackTrace("Luggage.AppBrandSimpleImageLoader.LoadTask", localException, " decode ", new Object[0]);
        }
        ad.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, decode failed, bmp %s", new Object[] { localObject1 });
        localObject1 = new d.a();
        AppMethodBeat.o(131380);
        throw ((Throwable)localObject1);
      }
      if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
      {
        ad.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, decoded bmp %s, size %d KB, url %s", new Object[] { localObject1, Integer.valueOf(android.support.v4.graphics.a.c((Bitmap)localObject1) / 1024), this.hLn });
        AppMethodBeat.o(131380);
        return localObject1;
        b.a(this.hLl).CG(this.hLn.hLz);
        b.a(this.hLl).CF(this.hLn.hLz);
        localObject1 = new d.b();
        AppMethodBeat.o(131380);
        throw ((Throwable)localObject1);
      }
      label264:
      AppMethodBeat.o(131380);
      return null;
    }
    
    private Bitmap y(InputStream paramInputStream)
    {
      AppMethodBeat.i(131381);
      try
      {
        if (this.hLq != null)
        {
          localBitmap = this.hLq.x(paramInputStream);
          return localBitmap;
        }
        Bitmap localBitmap = b.aDZ().decodeStream(paramInputStream);
        return localBitmap;
      }
      finally
      {
        bt.d(paramInputStream);
        AppMethodBeat.o(131381);
      }
    }
    
    final void E(Bitmap paramBitmap)
    {
      AppMethodBeat.i(131377);
      b.k localk = (b.k)b.d(this.hLl).remove(aEf());
      if (localk != null)
      {
        localk.E(paramBitmap);
        b.c(this.hLl).remove(localk);
      }
      AppMethodBeat.o(131377);
    }
    
    public final void aEb()
    {
      AppMethodBeat.i(131375);
      final Bitmap localBitmap = this.hLp.vT(aEg());
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        ad.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "before actually doIOJob, same keyForMemory bitmap already exists, key %s", new Object[] { aEg() });
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(131367);
            b.n.this.E(localBitmap);
            AppMethodBeat.o(131367);
          }
        });
        AppMethodBeat.o(131375);
        return;
      }
      if (b.a(this.hLl).CD(this.hLn.hLz))
      {
        b.a(this.hLl).a(this.hLn.hLz, this);
        ad.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "already has job processing, make this job pending, key %s", new Object[] { this.hLn.hLz });
        AppMethodBeat.o(131375);
        return;
      }
      b.a(this.hLl).CE(this.hLn.hLz);
      aEh();
      AppMethodBeat.o(131375);
    }
    
    public final void aEc()
    {
      AppMethodBeat.i(131376);
      b.k localk = (b.k)b.d(this.hLl).remove(aEf());
      if (localk != null) {
        b.c(this.hLl).remove(localk);
      }
      AppMethodBeat.o(131376);
    }
    
    final String aEf()
    {
      AppMethodBeat.i(131372);
      String str = b.aV(this.hLr, aEg());
      AppMethodBeat.o(131372);
      return str;
    }
    
    final String aEg()
    {
      AppMethodBeat.i(131373);
      String str = b.b(this.hLn.toString(), this.hLo, this.hLq);
      AppMethodBeat.o(131373);
      return str;
    }
    
    final void aEh()
    {
      AppMethodBeat.i(131374);
      try
      {
        Bitmap localBitmap = aEi();
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          b.a(this.hLl).CF(this.hLn.hLz);
          b.a(this.hLl).b(this.hLn.hLz, this);
          H(localBitmap);
          b.a(this.hLl).CC(this.hLn.hLz);
        }
        AppMethodBeat.o(131374);
        return;
      }
      catch (d locald)
      {
        ad.d("Luggage.AppBrandSimpleImageLoader.LoadTask", " doIOJobImpl, exp %s", new Object[] { locald });
        b.a(this.hLl).CF(this.hLn.hLz);
        b.a(this.hLl).CG(this.hLn.hLz);
        H(null);
        if ((locald instanceof d.a)) {
          b.b(this.hLl).CA(this.hLn.hLz);
        }
        AppMethodBeat.o(131374);
        return;
      }
      catch (IOException localIOException)
      {
        ad.printErrStackTrace("Luggage.AppBrandSimpleImageLoader.LoadTask", localIOException, " doIOJobImpl, io exp ", new Object[0]);
        b.a(this.hLl).CF(this.hLn.hLz);
        b.a(this.hLl).b(this.hLn.hLz, this);
        b.a(this.hLl).CC(this.hLn.hLz);
        if ((localIOException instanceof FileNotFoundException)) {
          H(null);
        }
        AppMethodBeat.o(131374);
      }
    }
  }
  
  static final class o
  {
    static final b hLx;
    
    static
    {
      AppMethodBeat.i(131382);
      hLx = new b((byte)0);
      AppMethodBeat.o(131382);
    }
  }
  
  public static final class p
  {
    private final String hLy;
    public final String hLz;
    
    private p(String paramString)
    {
      AppMethodBeat.i(199390);
      if (TextUtils.isEmpty(paramString))
      {
        paramString = new IllegalArgumentException();
        AppMethodBeat.o(199390);
        throw paramString;
      }
      this.hLy = paramString;
      this.hLz = b.Cy(paramString);
      AppMethodBeat.o(199390);
    }
    
    private static void a(HttpURLConnection paramHttpURLConnection, Map<String, String> paramMap)
    {
      AppMethodBeat.i(199392);
      if (paramMap != null)
      {
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          ad.i("Luggage.AppBrandSimpleImageLoader", "setHeaders, header: %s: %s", new Object[] { localEntry.getKey(), localEntry.getValue() });
          paramHttpURLConnection.setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
        }
      }
      AppMethodBeat.o(199392);
    }
    
    public final String toString()
    {
      return this.hLy;
    }
    
    /* Error */
    final InputStream u(final Map<String, String> paramMap)
    {
      // Byte code:
      //   0: ldc 113
      //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 38	com/tencent/mm/modelappbrand/a/b$p:hLy	Ljava/lang/String;
      //   9: ldc 115
      //   11: invokevirtual 119	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   14: ifne +15 -> 29
      //   17: aload_0
      //   18: getfield 38	com/tencent/mm/modelappbrand/a/b$p:hLy	Ljava/lang/String;
      //   21: ldc 121
      //   23: invokevirtual 119	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   26: ifeq +45 -> 71
      //   29: aload_0
      //   30: getfield 38	com/tencent/mm/modelappbrand/a/b$p:hLy	Ljava/lang/String;
      //   33: invokestatic 127	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
      //   36: astore_1
      //   37: ldc 113
      //   39: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   42: aload_1
      //   43: areturn
      //   44: astore_1
      //   45: ldc 77
      //   47: aload_1
      //   48: ldc 129
      //   50: iconst_1
      //   51: anewarray 4	java/lang/Object
      //   54: dup
      //   55: iconst_0
      //   56: aload_0
      //   57: getfield 38	com/tencent/mm/modelappbrand/a/b$p:hLy	Ljava/lang/String;
      //   60: aastore
      //   61: invokestatic 133	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   64: ldc 113
      //   66: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   69: aload_1
      //   70: athrow
      //   71: new 135	java/net/URL
      //   74: dup
      //   75: aload_0
      //   76: getfield 38	com/tencent/mm/modelappbrand/a/b$p:hLy	Ljava/lang/String;
      //   79: invokespecial 136	java/net/URL:<init>	(Ljava/lang/String;)V
      //   82: invokevirtual 140	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   85: checkcast 94	java/net/HttpURLConnection
      //   88: astore_3
      //   89: aload_3
      //   90: aload_1
      //   91: invokestatic 142	com/tencent/mm/modelappbrand/a/b$p:a	(Ljava/net/HttpURLConnection;Ljava/util/Map;)V
      //   94: aload_3
      //   95: invokevirtual 146	java/net/HttpURLConnection:getResponseCode	()I
      //   98: sipush 301
      //   101: if_icmpeq +15 -> 116
      //   104: aload_3
      //   105: astore_2
      //   106: aload_3
      //   107: invokevirtual 146	java/net/HttpURLConnection:getResponseCode	()I
      //   110: sipush 302
      //   113: if_icmpne +112 -> 225
      //   116: aload_3
      //   117: ldc 148
      //   119: invokevirtual 151	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   122: astore_2
      //   123: aload_3
      //   124: invokevirtual 155	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   127: invokevirtual 160	java/io/InputStream:close	()V
      //   130: aload_3
      //   131: invokevirtual 163	java/net/HttpURLConnection:disconnect	()V
      //   134: aload_2
      //   135: invokestatic 168	android/webkit/URLUtil:isAboutUrl	(Ljava/lang/String;)Z
      //   138: ifne +10 -> 148
      //   141: aload_2
      //   142: invokestatic 171	android/webkit/URLUtil:isNetworkUrl	(Ljava/lang/String;)Z
      //   145: ifne +55 -> 200
      //   148: new 173	java/net/MalformedURLException
      //   151: dup
      //   152: ldc 175
      //   154: iconst_2
      //   155: anewarray 4	java/lang/Object
      //   158: dup
      //   159: iconst_0
      //   160: aload_0
      //   161: getfield 38	com/tencent/mm/modelappbrand/a/b$p:hLy	Ljava/lang/String;
      //   164: aastore
      //   165: dup
      //   166: iconst_1
      //   167: aload_2
      //   168: aastore
      //   169: invokestatic 179	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   172: invokespecial 180	java/net/MalformedURLException:<init>	(Ljava/lang/String;)V
      //   175: astore_1
      //   176: ldc 113
      //   178: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   181: aload_1
      //   182: athrow
      //   183: astore_1
      //   184: new 182	java/io/IOException
      //   187: dup
      //   188: aload_1
      //   189: invokespecial 185	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
      //   192: astore_1
      //   193: ldc 113
      //   195: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   198: aload_1
      //   199: athrow
      //   200: new 135	java/net/URL
      //   203: dup
      //   204: aload_2
      //   205: invokespecial 136	java/net/URL:<init>	(Ljava/lang/String;)V
      //   208: invokevirtual 140	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   211: checkcast 94	java/net/HttpURLConnection
      //   214: astore_2
      //   215: aload_2
      //   216: iconst_0
      //   217: invokevirtual 189	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
      //   220: aload_2
      //   221: aload_1
      //   222: invokestatic 142	com/tencent/mm/modelappbrand/a/b$p:a	(Ljava/net/HttpURLConnection;Ljava/util/Map;)V
      //   225: new 191	com/tencent/mm/plugin/appbrand/z/i
      //   228: dup
      //   229: aload_2
      //   230: invokespecial 194	com/tencent/mm/plugin/appbrand/z/i:<init>	(Ljava/lang/Object;)V
      //   233: astore_1
      //   234: new 9	com/tencent/mm/modelappbrand/a/b$p$1
      //   237: dup
      //   238: aload_0
      //   239: aload_2
      //   240: invokevirtual 155	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   243: aload_1
      //   244: invokespecial 197	com/tencent/mm/modelappbrand/a/b$p$1:<init>	(Lcom/tencent/mm/modelappbrand/a/b$p;Ljava/io/InputStream;Lcom/tencent/mm/plugin/appbrand/z/i;)V
      //   247: astore_1
      //   248: ldc 113
      //   250: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   253: aload_1
      //   254: areturn
      //   255: astore_1
      //   256: new 182	java/io/IOException
      //   259: dup
      //   260: aload_1
      //   261: invokespecial 185	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
      //   264: astore_1
      //   265: ldc 113
      //   267: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   270: aload_1
      //   271: athrow
      //   272: astore_3
      //   273: goto -139 -> 134
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	276	0	this	p
      //   0	276	1	paramMap	Map<String, String>
      //   105	135	2	localObject	Object
      //   88	43	3	localHttpURLConnection	HttpURLConnection
      //   272	1	3	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   29	37	44	java/io/FileNotFoundException
      //   94	104	183	java/lang/ArrayIndexOutOfBoundsException
      //   106	116	183	java/lang/ArrayIndexOutOfBoundsException
      //   116	123	183	java/lang/ArrayIndexOutOfBoundsException
      //   123	134	183	java/lang/ArrayIndexOutOfBoundsException
      //   134	148	183	java/lang/ArrayIndexOutOfBoundsException
      //   148	183	183	java/lang/ArrayIndexOutOfBoundsException
      //   200	225	183	java/lang/ArrayIndexOutOfBoundsException
      //   225	248	183	java/lang/ArrayIndexOutOfBoundsException
      //   94	104	255	java/lang/Exception
      //   106	116	255	java/lang/Exception
      //   116	123	255	java/lang/Exception
      //   123	134	255	java/lang/Exception
      //   134	148	255	java/lang/Exception
      //   148	183	255	java/lang/Exception
      //   200	225	255	java/lang/Exception
      //   225	248	255	java/lang/Exception
      //   123	134	272	java/lang/Throwable
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b
 * JD-Core Version:    0.7.0.1
 */