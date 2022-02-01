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
import com.tencent.mm.plugin.appbrand.z.l;
import com.tencent.mm.plugin.appbrand.z.l.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.q;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
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
  private static String hsx;
  private static g hsy;
  private final Map<k, String> hsr;
  private final Map<String, k> hss;
  private final Map<Integer, String> hst;
  public final e hsu;
  private final l hsv;
  private final i hsw;
  
  static
  {
    AppMethodBeat.i(131403);
    com.tencent.mm.vfs.e locale2 = com.tencent.mm.vfs.e.U(ai.getContext().getExternalCacheDir());
    com.tencent.mm.vfs.e locale1 = locale2;
    if (locale2 == null) {
      locale1 = com.tencent.mm.vfs.e.U(ai.getContext().getCacheDir());
    }
    zv(q.B(locale1.fxV()));
    hsy = g.hsS;
    AppMethodBeat.o(131403);
  }
  
  private b()
  {
    AppMethodBeat.i(131383);
    this.hsr = new ConcurrentHashMap();
    this.hss = new ConcurrentHashMap();
    this.hst = new ConcurrentHashMap();
    this.hsv = new b.d();
    this.hsw = new b((byte)0);
    this.hsu = new e(new ao("AppBrandSimpleImageLoaderDiskIOHandlerThread"), (byte)0);
    AppMethodBeat.o(131383);
  }
  
  private static String a(String paramString, h paramh, f paramf)
  {
    AppMethodBeat.i(131395);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    if (paramh != null)
    {
      localStringBuilder.append("|transformation:");
      localStringBuilder.append(paramh.Ap());
    }
    if (paramf != null)
    {
      localStringBuilder.append("|decoder:");
      localStringBuilder.append(paramf.Ap());
    }
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(131395);
    return paramString;
  }
  
  public static void a(g paramg)
  {
    synchronized (o.htf)
    {
      hsy = paramg;
      return;
    }
  }
  
  public static b aAS()
  {
    return o.htf;
  }
  
  private static g aAT()
  {
    synchronized (o.htf)
    {
      g localg = hsy;
      return localg;
    }
  }
  
  private static String aT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(131394);
    paramString1 = paramString1 + paramString2;
    AppMethodBeat.o(131394);
    return paramString1;
  }
  
  private String b(final k paramk, final String paramString, final h paramh, final f paramf)
  {
    AppMethodBeat.i(205013);
    if (paramk == null)
    {
      AppMethodBeat.o(205013);
      return null;
    }
    if (bs.isNullOrNil(paramString))
    {
      paramk.of();
      AppMethodBeat.o(205013);
      return null;
    }
    try
    {
      if ("null".equals(Uri.parse(paramString).getHost()))
      {
        paramk.of();
        AppMethodBeat.o(205013);
        return null;
      }
    }
    catch (Exception localException)
    {
      ac.d("Luggage.AppBrandSimpleImageLoader", "load before start LoadTask url %s", new Object[] { paramString });
      String str = paramk.Ap() + "@" + paramk.hashCode();
      paramf = new n(paramString, paramh, this, this.hsv, this.hsw, paramf, str);
      paramh = paramf.aBd();
      paramk = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(131336);
          Object localObject = b.this.zs(paramh);
          if (localObject != null)
          {
            paramk.E((Bitmap)localObject);
            ac.d("Luggage.AppBrandSimpleImageLoader", "load already cached, url %s, bitmap %s", new Object[] { paramString, localObject });
            AppMethodBeat.o(131336);
            return;
          }
          localObject = paramf.aBc();
          b.c(b.this).put(paramk, localObject);
          b.d(b.this).put(localObject, paramk);
          paramk.aBa();
          localObject = paramf;
          b.a(((b.n)localObject).hsT).post(new b.n.2((b.n)localObject));
          AppMethodBeat.o(131336);
        }
      };
      if (!ap.isMainThread()) {
        break label181;
      }
    }
    paramk.run();
    for (;;)
    {
      AppMethodBeat.o(205013);
      return paramh;
      label181:
      ap.f(paramk);
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
    paramImageView = (String)this.hst.remove(Integer.valueOf(paramImageView.hashCode()));
    if (paramImageView == null)
    {
      AppMethodBeat.o(131384);
      return;
    }
    a((k)this.hss.get(paramImageView));
    AppMethodBeat.o(131384);
  }
  
  /* Error */
  private byte[] zu(String paramString)
  {
    // Byte code:
    //   0: ldc_w 343
    //   3: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 251	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifeq +11 -> 21
    //   13: ldc_w 343
    //   16: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aconst_null
    //   20: areturn
    //   21: aload_0
    //   22: getfield 170	com/tencent/mm/modelappbrand/a/b:hsw	Lcom/tencent/mm/modelappbrand/a/b$i;
    //   25: new 78	com/tencent/mm/modelappbrand/a/b$p
    //   28: dup
    //   29: aload_1
    //   30: iconst_0
    //   31: invokespecial 346	com/tencent/mm/modelappbrand/a/b$p:<init>	(Ljava/lang/String;B)V
    //   34: getfield 349	com/tencent/mm/modelappbrand/a/b$p:hth	Ljava/lang/String;
    //   37: invokeinterface 353 2 0
    //   42: astore 4
    //   44: aload 4
    //   46: ifnonnull +21 -> 67
    //   49: aload 4
    //   51: ifnull +8 -> 59
    //   54: aload 4
    //   56: invokevirtual 358	java/io/InputStream:close	()V
    //   59: ldc_w 343
    //   62: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aconst_null
    //   66: areturn
    //   67: aload 4
    //   69: invokestatic 364	org/apache/commons/a/e:toByteArray	(Ljava/io/InputStream;)[B
    //   72: astore_2
    //   73: aload 4
    //   75: ifnull +8 -> 83
    //   78: aload 4
    //   80: invokevirtual 358	java/io/InputStream:close	()V
    //   83: ldc_w 343
    //   86: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: aload_2
    //   90: areturn
    //   91: astore_3
    //   92: ldc_w 343
    //   95: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: aload_3
    //   99: athrow
    //   100: astore_2
    //   101: aload 4
    //   103: ifnull +12 -> 115
    //   106: aload_3
    //   107: ifnull +53 -> 160
    //   110: aload 4
    //   112: invokevirtual 358	java/io/InputStream:close	()V
    //   115: ldc_w 343
    //   118: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: aload_2
    //   122: athrow
    //   123: astore_2
    //   124: ldc_w 273
    //   127: ldc_w 366
    //   130: iconst_1
    //   131: anewarray 4	java/lang/Object
    //   134: dup
    //   135: iconst_0
    //   136: aload_1
    //   137: aastore
    //   138: invokestatic 368	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   141: ldc_w 343
    //   144: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: aconst_null
    //   148: areturn
    //   149: astore 4
    //   151: aload_3
    //   152: aload 4
    //   154: invokevirtual 372	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   157: goto -42 -> 115
    //   160: aload 4
    //   162: invokevirtual 358	java/io/InputStream:close	()V
    //   165: goto -50 -> 115
    //   168: astore_2
    //   169: aconst_null
    //   170: astore_3
    //   171: goto -70 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	b
    //   0	174	1	paramString	String
    //   72	18	2	arrayOfByte	byte[]
    //   100	22	2	localObject1	Object
    //   123	1	2	localIOException	IOException
    //   168	1	2	localObject2	Object
    //   91	61	3	localThrowable1	Throwable
    //   170	1	3	localObject3	Object
    //   42	69	4	localInputStream	InputStream
    //   149	12	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   67	73	91	java/lang/Throwable
    //   92	100	100	finally
    //   21	44	123	java/io/IOException
    //   54	59	123	java/io/IOException
    //   78	83	123	java/io/IOException
    //   110	115	123	java/io/IOException
    //   115	123	123	java/io/IOException
    //   151	157	123	java/io/IOException
    //   160	165	123	java/io/IOException
    //   110	115	149	java/lang/Throwable
    //   67	73	168	finally
  }
  
  public static void zv(String paramString)
  {
    AppMethodBeat.i(176003);
    String str = paramString;
    if (!paramString.endsWith("/")) {
      str = paramString + "/";
    }
    paramString = str + "wxacache/";
    hsx = paramString;
    com.tencent.mm.vfs.i.aSh(paramString);
    AppMethodBeat.o(176003);
  }
  
  private static String zw(String paramString)
  {
    AppMethodBeat.i(131396);
    String str = null;
    if (!bs.isNullOrNil(paramString)) {
      str = g.getMessageDigest(paramString.getBytes());
    }
    AppMethodBeat.o(131396);
    return str;
  }
  
  /* Error */
  public final Bitmap a(String paramString, f paramf)
  {
    // Byte code:
    //   0: ldc_w 406
    //   3: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 251	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifeq +11 -> 21
    //   13: ldc_w 406
    //   16: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aconst_null
    //   20: areturn
    //   21: aload_1
    //   22: aconst_null
    //   23: aload_2
    //   24: invokestatic 317	com/tencent/mm/modelappbrand/a/b:a	(Ljava/lang/String;Lcom/tencent/mm/modelappbrand/a/b$h;Lcom/tencent/mm/modelappbrand/a/b$f;)Ljava/lang/String;
    //   27: astore 5
    //   29: aload_0
    //   30: getfield 165	com/tencent/mm/modelappbrand/a/b:hsv	Lcom/tencent/mm/modelappbrand/a/b$l;
    //   33: aload 5
    //   35: invokeinterface 410 2 0
    //   40: astore 4
    //   42: aload 4
    //   44: ifnull +12 -> 56
    //   47: ldc_w 406
    //   50: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aload 4
    //   55: areturn
    //   56: aload_1
    //   57: ldc_w 412
    //   60: invokevirtual 415	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   63: istore_3
    //   64: iload_3
    //   65: ifeq +46 -> 111
    //   68: aload_1
    //   69: invokestatic 416	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   72: astore_1
    //   73: aload_1
    //   74: ifnonnull +54 -> 128
    //   77: aload_1
    //   78: invokestatic 419	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   81: ldc_w 406
    //   84: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aconst_null
    //   88: areturn
    //   89: astore_1
    //   90: ldc_w 273
    //   93: ldc_w 421
    //   96: invokestatic 424	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aconst_null
    //   100: invokestatic 419	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   103: ldc_w 406
    //   106: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aconst_null
    //   110: areturn
    //   111: aload_0
    //   112: getfield 170	com/tencent/mm/modelappbrand/a/b:hsw	Lcom/tencent/mm/modelappbrand/a/b$i;
    //   115: aload_1
    //   116: invokestatic 402	com/tencent/mm/modelappbrand/a/b:zw	(Ljava/lang/String;)Ljava/lang/String;
    //   119: invokeinterface 353 2 0
    //   124: astore_1
    //   125: goto -52 -> 73
    //   128: aload_2
    //   129: ifnull +45 -> 174
    //   132: aload_1
    //   133: astore 4
    //   135: aload_2
    //   136: aload_1
    //   137: invokeinterface 428 2 0
    //   142: astore_2
    //   143: aload_2
    //   144: ifnull +18 -> 162
    //   147: aload_1
    //   148: astore 4
    //   150: aload_0
    //   151: getfield 165	com/tencent/mm/modelappbrand/a/b:hsv	Lcom/tencent/mm/modelappbrand/a/b$l;
    //   154: aload 5
    //   156: aload_2
    //   157: invokeinterface 432 3 0
    //   162: aload_1
    //   163: invokestatic 419	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   166: ldc_w 406
    //   169: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   172: aload_2
    //   173: areturn
    //   174: aload_1
    //   175: astore 4
    //   177: invokestatic 233	com/tencent/mm/modelappbrand/a/b:aAT	()Lcom/tencent/mm/modelappbrand/a/b$g;
    //   180: aload_1
    //   181: invokeinterface 435 2 0
    //   186: astore_2
    //   187: goto -44 -> 143
    //   190: astore_2
    //   191: aconst_null
    //   192: astore_1
    //   193: aload_1
    //   194: astore 4
    //   196: ldc_w 273
    //   199: aload_2
    //   200: ldc_w 437
    //   203: iconst_0
    //   204: anewarray 4	java/lang/Object
    //   207: invokestatic 441	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   210: aload_1
    //   211: invokestatic 419	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   214: ldc_w 406
    //   217: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   220: aconst_null
    //   221: areturn
    //   222: astore_1
    //   223: aconst_null
    //   224: astore 4
    //   226: aload 4
    //   228: invokestatic 419	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   231: ldc_w 406
    //   234: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   237: aload_1
    //   238: athrow
    //   239: astore_1
    //   240: goto -14 -> 226
    //   243: astore_2
    //   244: goto -51 -> 193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	this	b
    //   0	247	1	paramString	String
    //   0	247	2	paramf	f
    //   63	2	3	bool	boolean
    //   40	187	4	localObject	Object
    //   27	128	5	str	String
    // Exception table:
    //   from	to	target	type
    //   68	73	89	java/io/FileNotFoundException
    //   56	64	190	java/lang/Exception
    //   68	73	190	java/lang/Exception
    //   90	99	190	java/lang/Exception
    //   111	125	190	java/lang/Exception
    //   56	64	222	finally
    //   68	73	222	finally
    //   90	99	222	finally
    //   111	125	222	finally
    //   135	143	239	finally
    //   150	162	239	finally
    //   177	187	239	finally
    //   196	210	239	finally
    //   135	143	243	java/lang/Exception
    //   150	162	243	java/lang/Exception
    //   177	187	243	java/lang/Exception
  }
  
  public final String a(ImageView paramImageView, String paramString, int paramInt, h paramh)
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
  
  public final String a(ImageView paramImageView, String paramString, Drawable paramDrawable, h paramh)
  {
    AppMethodBeat.i(131391);
    paramImageView = a(paramImageView, paramString, paramDrawable, paramh, null);
    AppMethodBeat.o(131391);
    return paramImageView;
  }
  
  public final String a(ImageView paramImageView, String paramString, final Drawable paramDrawable, h paramh, f paramf)
  {
    AppMethodBeat.i(131392);
    if (paramImageView == null)
    {
      AppMethodBeat.o(131392);
      return null;
    }
    d(paramImageView);
    if (bs.isNullOrNil(paramString))
    {
      if (paramDrawable != null) {
        paramImageView.setImageDrawable(paramDrawable);
      }
      AppMethodBeat.o(131392);
      return null;
    }
    paramDrawable = new m(paramImageView, this, paramDrawable)
    {
      public final void aBa()
      {
        AppMethodBeat.i(131337);
        if ((getImageView() != null) && (paramDrawable != null)) {
          getImageView().setImageDrawable(paramDrawable);
        }
        AppMethodBeat.o(131337);
      }
    };
    paramString = a(paramDrawable, paramString, paramh, paramf);
    if (!paramDrawable.hsU) {
      this.hst.put(Integer.valueOf(paramImageView.hashCode()), aT(paramDrawable.key, paramString));
    }
    AppMethodBeat.o(131392);
    return paramString;
  }
  
  public final String a(k paramk, String paramString, h paramh)
  {
    AppMethodBeat.i(131389);
    paramk = a(paramk, paramString, paramh, null);
    AppMethodBeat.o(131389);
    return paramk;
  }
  
  public final String a(k paramk, String paramString, h paramh, f paramf)
  {
    AppMethodBeat.i(131388);
    paramk = b(paramk, paramString, paramh, paramf);
    AppMethodBeat.o(131388);
    return paramk;
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(205012);
    if (paramk == null)
    {
      AppMethodBeat.o(205012);
      return;
    }
    paramk = (String)this.hsr.remove(paramk);
    if (!bs.isNullOrNil(paramk)) {
      this.hss.remove(paramk);
    }
    AppMethodBeat.o(205012);
  }
  
  public final void a(final String paramString, final j paramj)
  {
    AppMethodBeat.i(183777);
    byte[] arrayOfByte = zu(paramString);
    if ((arrayOfByte != null) && (arrayOfByte.length != 0))
    {
      paramj.W(arrayOfByte);
      AppMethodBeat.o(183777);
      return;
    }
    b(new k()
    {
      public final String Ap()
      {
        return "BytesLoadTarget";
      }
      
      public final void E(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(131339);
        l.bxj().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(131338);
            byte[] arrayOfByte = b.a(b.this, b.3.this.val$url);
            if (b.3.this.hsI != null) {
              b.3.this.hsI.W(arrayOfByte);
            }
            AppMethodBeat.o(131338);
          }
        });
        AppMethodBeat.o(131339);
      }
      
      public final void aBa() {}
      
      public final void of()
      {
        AppMethodBeat.i(131340);
        if (paramj != null) {
          paramj.W(null);
        }
        AppMethodBeat.o(131340);
      }
    }, paramString, null, null);
    AppMethodBeat.o(183777);
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(161226);
    this.hsv.clear();
    AppMethodBeat.o(161226);
  }
  
  public final Bitmap zs(String paramString)
  {
    AppMethodBeat.i(131385);
    paramString = this.hsv.te(paramString);
    if ((paramString == null) || (paramString.isRecycled()))
    {
      AppMethodBeat.o(131385);
      return null;
    }
    AppMethodBeat.o(131385);
    return paramString;
  }
  
  public final String zt(String paramString)
  {
    AppMethodBeat.i(131387);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(131387);
      return null;
    }
    paramString = a(new c(), paramString, null);
    AppMethodBeat.o(131387);
    return paramString;
  }
  
  public final void zx(String paramString)
  {
    AppMethodBeat.i(131397);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(131397);
      return;
    }
    paramString = zw(paramString);
    if (this.hsu.zE(paramString))
    {
      AppMethodBeat.o(131397);
      return;
    }
    this.hsw.zB(paramString);
    AppMethodBeat.o(131397);
  }
  
  public final void zy(String paramString)
  {
    AppMethodBeat.i(161227);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(161227);
      return;
    }
    this.hsv.zC(paramString);
    AppMethodBeat.o(161227);
  }
  
  public final class a
    implements b.e.a, Runnable
  {
    private boolean mCanceled = false;
    
    final void aAX()
    {
      AppMethodBeat.i(205000);
      b.a(this.hsC).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(204998);
          b.a(b.a.this.hsC).zG(b.a.this.hsD.hth);
          b.a(b.a.this.hsC).zD(b.a.this.hsD.hth);
          AppMethodBeat.o(204998);
        }
      });
      AppMethodBeat.o(205000);
    }
    
    public final void aAY()
    {
      AppMethodBeat.i(205002);
      if (this.mCanceled)
      {
        AppMethodBeat.o(205002);
        return;
      }
      try
      {
        InputStream localInputStream = b.b(this.hsC).openRead(this.hsD.hth);
        if (localInputStream != null)
        {
          if (this.hsE != null) {
            this.hsE.apply(localInputStream);
          }
          aAX();
          AppMethodBeat.o(205002);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        ac.e("Luggage.AppBrandSimpleImageLoader", "loadIntoDiskCache diskCache.openRead failed, url=%s, e=%s", new Object[] { this.val$url, localThrowable });
        if (this.hsE != null) {
          this.hsE.apply(null);
        }
        aAX();
        AppMethodBeat.o(205002);
        return;
      }
      com.tencent.e.h.JZN.aS(new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "AppBrandSimpleImageLoaderDownloadThread";
        }
        
        public final void run()
        {
          AppMethodBeat.i(204999);
          b.n.a(b.a.this.hsD, b.a.this.hsF, b.b(b.a.this.hsC));
          if (b.a.this.hsE != null) {}
          try
          {
            b.a.this.hsE.apply(b.b(b.a.this.hsC).openRead(b.a.this.hsD.hth));
            label80:
            b.a.this.aAX();
            AppMethodBeat.o(204999);
            return;
          }
          catch (Throwable localThrowable)
          {
            break label80;
          }
        }
      });
      AppMethodBeat.o(205002);
    }
    
    public final void aAZ()
    {
      this.mCanceled = true;
    }
    
    public final void run()
    {
      AppMethodBeat.i(205001);
      if (b.a(this.hsC).zE(this.hsD.hth))
      {
        b.a(this.hsC).a(this.hsD.hth, this);
        AppMethodBeat.o(205001);
        return;
      }
      b.a(this.hsC).zF(this.hsD.hth);
      aAY();
      AppMethodBeat.o(205001);
    }
  }
  
  static final class b
    implements b.i
  {
    public final InputStream openRead(String paramString)
    {
      AppMethodBeat.i(131343);
      Object localObject = b.aAU() + paramString;
      if (com.tencent.mm.vfs.i.eA((String)localObject + ".wlock"))
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
        ac.d("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", "openRead fileName %s, e %s", new Object[] { paramString, localIOException });
        AppMethodBeat.o(131343);
      }
      return null;
    }
    
    public final OutputStream zA(String paramString)
    {
      AppMethodBeat.i(131342);
      try
      {
        if ((!com.tencent.mm.vfs.i.aSh(b.aAU())) && (!new com.tencent.mm.vfs.e(b.aAU()).isDirectory()))
        {
          com.tencent.mm.vfs.i.deleteFile(b.aAU());
          com.tencent.mm.vfs.i.aSh(b.aAU());
        }
        localObject = b.aAU() + paramString;
        str = (String)localObject + ".wlock";
        com.tencent.mm.vfs.i.deleteFile(str);
        com.tencent.mm.vfs.i.cU(str, true);
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
            com.tencent.mm.vfs.i.cU((String)localObject, true);
            Object localObject = new BufferedOutputStream(com.tencent.mm.vfs.i.cS((String)localObject, false))
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
            ac.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", localIOException, "openWrite fileName %s, parent exists[%b]", new Object[] { paramString, Boolean.valueOf(com.tencent.mm.vfs.i.eA(b.aAU())) });
            AppMethodBeat.o(131342);
          }
          localThrowable = localThrowable;
          ac.e("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", "openWrite mkdirs e=%s", new Object[] { localThrowable });
        }
      }
      return null;
    }
    
    public final boolean zB(String paramString)
    {
      AppMethodBeat.i(131344);
      if ((!bs.isNullOrNil(paramString)) && (com.tencent.mm.vfs.i.deleteFile(b.aAU() + paramString)))
      {
        AppMethodBeat.o(131344);
        return true;
      }
      AppMethodBeat.o(131344);
      return false;
    }
  }
  
  public static class c
    implements b.k
  {
    public final String Ap()
    {
      return "DefaultLoadTarget";
    }
    
    public void E(Bitmap paramBitmap) {}
    
    public final void aBa() {}
    
    public final void of() {}
  }
  
  public static final class e
  {
    public final ao hsP;
    private final Map<String, List<a>> hsQ;
    private final Map<String, Boolean> hsR;
    
    private e(ao paramao)
    {
      AppMethodBeat.i(131355);
      this.hsQ = new HashMap();
      this.hsR = new HashMap();
      this.hsP = paramao;
      AppMethodBeat.o(131355);
    }
    
    final void a(String paramString, a parama)
    {
      AppMethodBeat.i(205005);
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(205005);
        return;
      }
      List localList = (List)this.hsQ.get(paramString);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new LinkedList();
        this.hsQ.put(paramString, localObject);
      }
      ((List)localObject).add(parama);
      AppMethodBeat.o(205005);
    }
    
    final void b(String paramString, a parama)
    {
      AppMethodBeat.i(131359);
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(131359);
        return;
      }
      paramString = (List)this.hsQ.get(paramString);
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
      this.hsP.post(paramRunnable);
      AppMethodBeat.o(131361);
    }
    
    final void zD(String paramString)
    {
      AppMethodBeat.i(131356);
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(131356);
        return;
      }
      paramString = (List)this.hsQ.remove(paramString);
      if (bs.gY(paramString))
      {
        AppMethodBeat.o(131356);
        return;
      }
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        ((a)paramString.next()).aAY();
      }
      AppMethodBeat.o(131356);
    }
    
    final boolean zE(String paramString)
    {
      AppMethodBeat.i(131357);
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(131357);
        return false;
      }
      boolean bool = this.hsR.containsKey(paramString);
      AppMethodBeat.o(131357);
      return bool;
    }
    
    final void zF(String paramString)
    {
      AppMethodBeat.i(205004);
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(205004);
        return;
      }
      this.hsR.put(paramString, Boolean.TRUE);
      AppMethodBeat.o(205004);
    }
    
    final void zG(String paramString)
    {
      AppMethodBeat.i(131358);
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(131358);
        return;
      }
      this.hsR.remove(paramString);
      AppMethodBeat.o(131358);
    }
    
    final void zH(String paramString)
    {
      AppMethodBeat.i(131360);
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(131360);
        return;
      }
      paramString = (List)this.hsQ.remove(paramString);
      if (!bs.gY(paramString))
      {
        Iterator localIterator = paramString.iterator();
        while (localIterator.hasNext()) {
          ((a)localIterator.next()).aAZ();
        }
        paramString.clear();
      }
      AppMethodBeat.o(131360);
    }
    
    static abstract interface a
    {
      public abstract void aAY();
      
      public abstract void aAZ();
    }
  }
  
  public static abstract interface f
    extends c
  {
    public abstract Bitmap t(InputStream paramInputStream);
  }
  
  public static abstract interface g
  {
    public static final g hsS = new g()
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
  
  public static abstract interface h
    extends c
  {
    public abstract Bitmap F(Bitmap paramBitmap);
  }
  
  public static abstract interface i
  {
    public abstract InputStream openRead(String paramString);
    
    public abstract OutputStream zA(String paramString);
    
    public abstract boolean zB(String paramString);
  }
  
  public static abstract interface j
  {
    public abstract void W(byte[] paramArrayOfByte);
  }
  
  public static abstract interface k
    extends c
  {
    public abstract String Ap();
    
    public abstract void E(Bitmap paramBitmap);
    
    public abstract void aBa();
    
    public abstract void of();
  }
  
  public static abstract interface l
  {
    public abstract void clear();
    
    public abstract void f(Bitmap paramBitmap);
    
    public abstract void put(String paramString, Bitmap paramBitmap);
    
    public abstract void remove(String paramString);
    
    public abstract Bitmap te(String paramString);
    
    public abstract void zC(String paramString);
  }
  
  static class m
    implements b.k
  {
    private final b hsT;
    boolean hsU;
    final String key;
    private final WeakReference<ImageView> mn;
    
    private m(ImageView paramImageView, b paramb)
    {
      AppMethodBeat.i(131363);
      this.hsU = false;
      this.mn = new WeakReference(paramImageView);
      this.hsT = paramb;
      this.key = "ImageView";
      AppMethodBeat.o(131363);
    }
    
    private void aBb()
    {
      AppMethodBeat.i(131364);
      if (this.mn.get() != null) {
        b.e(this.hsT).remove(Integer.valueOf(((ImageView)this.mn.get()).hashCode()));
      }
      AppMethodBeat.o(131364);
    }
    
    public final String Ap()
    {
      return this.key;
    }
    
    public final void E(Bitmap paramBitmap)
    {
      AppMethodBeat.i(131365);
      aBb();
      ImageView localImageView = (ImageView)this.mn.get();
      if (localImageView != null)
      {
        if (!ap.isMainThread()) {
          ac.l("Luggage.AppBrandSimpleImageLoader", "onBitmapLoaded invoke in non-main thread!!!", new Object[0]);
        }
        localImageView.setImageDrawable(new f(localImageView.getResources(), paramBitmap));
      }
      this.hsU = true;
      AppMethodBeat.o(131365);
    }
    
    public void aBa() {}
    
    final ImageView getImageView()
    {
      AppMethodBeat.i(131362);
      ImageView localImageView = (ImageView)this.mn.get();
      AppMethodBeat.o(131362);
      return localImageView;
    }
    
    public final void of()
    {
      AppMethodBeat.i(131366);
      aBb();
      AppMethodBeat.o(131366);
    }
  }
  
  static final class n
    implements b.e.a
  {
    final b hsT;
    final b.p hsV;
    private final b.h hsW;
    private final b.l hsX;
    private final b.f hsY;
    private final String hsZ;
    final b.i hsw;
    boolean hta;
    final Map<String, String> mHeaders;
    
    public n(String paramString1, b.h paramh, b paramb, b.l paraml, b.i parami, b.f paramf, String paramString2)
    {
      AppMethodBeat.i(205006);
      this.hta = true;
      this.hsV = new b.p(paramString1, (byte)0);
      this.mHeaders = null;
      this.hsW = paramh;
      this.hsT = paramb;
      this.hsX = paraml;
      this.hsw = parami;
      this.hsY = paramf;
      this.hsZ = paramString2;
      AppMethodBeat.o(205006);
    }
    
    private Bitmap G(Bitmap paramBitmap)
    {
      AppMethodBeat.i(131378);
      paramBitmap = this.hsW.F(paramBitmap);
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
        ac.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "postLoadInWorkerThread bitmap ok %b", new Object[] { Boolean.valueOf(bool1) });
        final Bitmap localBitmap = paramBitmap;
        if (this.hsW != null)
        {
          localBitmap = paramBitmap;
          if (paramBitmap != null)
          {
            localBitmap = paramBitmap;
            if (!paramBitmap.isRecycled())
            {
              localBitmap = G(paramBitmap);
              ac.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "postLoadInWorkerThread, transform bmp, origin %s, transformed %s", new Object[] { paramBitmap, localBitmap });
              if (localBitmap != paramBitmap) {
                this.hsX.f(paramBitmap);
              }
            }
          }
        }
        this.hsX.put(aBd(), localBitmap);
        bool1 = bool2;
        if (localBitmap != null)
        {
          bool1 = bool2;
          if (!localBitmap.isRecycled()) {
            bool1 = true;
          }
        }
        ac.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "postLoadInWorkerThread before post to main thread, bitmap %s, ok %b", new Object[] { localBitmap, Boolean.valueOf(bool1) });
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(131369);
            b.n localn = b.n.this;
            Object localObject = localBitmap;
            if ((localObject == null) || (((Bitmap)localObject).isRecycled()))
            {
              ac.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "postLoadInMainThread, onLoadFailed bmp %s", new Object[] { localObject });
              localObject = (b.k)b.d(localn.hsT).remove(localn.aBc());
              if (localObject != null)
              {
                ((b.k)localObject).of();
                b.c(localn.hsT).remove(localObject);
              }
              AppMethodBeat.o(131369);
              return;
            }
            ac.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "postLoadInMainThread, onBitmapLoaded bmp %s", new Object[] { localObject });
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
      //   10: invokevirtual 149	com/tencent/mm/modelappbrand/a/b$p:t	(Ljava/util/Map;)Ljava/io/InputStream;
      //   13: astore 5
      //   15: aload 5
      //   17: ifnull +196 -> 213
      //   20: aload_2
      //   21: aload_0
      //   22: getfield 152	com/tencent/mm/modelappbrand/a/b$p:hth	Ljava/lang/String;
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
      //   91: invokestatic 179	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
      //   174: invokestatic 179	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   177: aload_2
      //   178: aload_0
      //   179: getfield 152	com/tencent/mm/modelappbrand/a/b$p:hth	Ljava/lang/String;
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
      //   225: invokestatic 179	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    
    private Bitmap aBf()
    {
      Object localObject1 = null;
      AppMethodBeat.i(131380);
      if (!b.aAV())
      {
        ac.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, sdcard unavailable");
        localObject1 = new d.c();
        AppMethodBeat.o(131380);
        throw ((Throwable)localObject1);
      }
      Object localObject2 = this.hsw.openRead(this.hsV.hth);
      if (localObject2 == null)
      {
        ac.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, null from disk, tryDownload %b", new Object[] { Boolean.valueOf(this.hta) });
        if (this.hta) {
          com.tencent.e.h.JZN.aS(new com.tencent.e.i.h()
          {
            public final String getKey()
            {
              return "AppBrandSimpleImageLoaderDownloadThread";
            }
            
            public final void run()
            {
              AppMethodBeat.i(131371);
              b.n.a(b.n.this.hsV, b.n.this.mHeaders, b.n.this.hsw);
              b.a(b.n.this.hsT).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(131370);
                  b.n.this.hta = false;
                  b.n.this.aBe();
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
        localObject2 = u((InputStream)localObject2);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.printErrStackTrace("Luggage.AppBrandSimpleImageLoader.LoadTask", localException, " decode ", new Object[0]);
        }
        ac.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, decode failed, bmp %s", new Object[] { localObject1 });
        localObject1 = new d.a();
        AppMethodBeat.o(131380);
        throw ((Throwable)localObject1);
      }
      if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
      {
        ac.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, decoded bmp %s, size %d KB, url %s", new Object[] { localObject1, Integer.valueOf(android.support.v4.graphics.a.c((Bitmap)localObject1) / 1024), this.hsV });
        AppMethodBeat.o(131380);
        return localObject1;
        b.a(this.hsT).zH(this.hsV.hth);
        b.a(this.hsT).zG(this.hsV.hth);
        localObject1 = new d.b();
        AppMethodBeat.o(131380);
        throw ((Throwable)localObject1);
      }
      label264:
      AppMethodBeat.o(131380);
      return null;
    }
    
    private Bitmap u(InputStream paramInputStream)
    {
      AppMethodBeat.i(131381);
      try
      {
        if (this.hsY != null)
        {
          localBitmap = this.hsY.t(paramInputStream);
          return localBitmap;
        }
        Bitmap localBitmap = b.aAW().decodeStream(paramInputStream);
        return localBitmap;
      }
      finally
      {
        bs.d(paramInputStream);
        AppMethodBeat.o(131381);
      }
    }
    
    final void E(Bitmap paramBitmap)
    {
      AppMethodBeat.i(131377);
      b.k localk = (b.k)b.d(this.hsT).remove(aBc());
      if (localk != null)
      {
        localk.E(paramBitmap);
        b.c(this.hsT).remove(localk);
      }
      AppMethodBeat.o(131377);
    }
    
    public final void aAY()
    {
      AppMethodBeat.i(131375);
      final Bitmap localBitmap = this.hsX.te(aBd());
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        ac.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "before actually doIOJob, same keyForMemory bitmap already exists, key %s", new Object[] { aBd() });
        ap.f(new Runnable()
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
      if (b.a(this.hsT).zE(this.hsV.hth))
      {
        b.a(this.hsT).a(this.hsV.hth, this);
        ac.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "already has job processing, make this job pending, key %s", new Object[] { this.hsV.hth });
        AppMethodBeat.o(131375);
        return;
      }
      b.a(this.hsT).zF(this.hsV.hth);
      aBe();
      AppMethodBeat.o(131375);
    }
    
    public final void aAZ()
    {
      AppMethodBeat.i(131376);
      b.k localk = (b.k)b.d(this.hsT).remove(aBc());
      if (localk != null) {
        b.c(this.hsT).remove(localk);
      }
      AppMethodBeat.o(131376);
    }
    
    final String aBc()
    {
      AppMethodBeat.i(131372);
      String str = b.aU(this.hsZ, aBd());
      AppMethodBeat.o(131372);
      return str;
    }
    
    final String aBd()
    {
      AppMethodBeat.i(131373);
      String str = b.b(this.hsV.toString(), this.hsW, this.hsY);
      AppMethodBeat.o(131373);
      return str;
    }
    
    final void aBe()
    {
      AppMethodBeat.i(131374);
      try
      {
        Bitmap localBitmap = aBf();
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          b.a(this.hsT).zG(this.hsV.hth);
          b.a(this.hsT).b(this.hsV.hth, this);
          H(localBitmap);
          b.a(this.hsT).zD(this.hsV.hth);
        }
        AppMethodBeat.o(131374);
        return;
      }
      catch (d locald)
      {
        ac.d("Luggage.AppBrandSimpleImageLoader.LoadTask", " doIOJobImpl, exp %s", new Object[] { locald });
        b.a(this.hsT).zG(this.hsV.hth);
        b.a(this.hsT).zH(this.hsV.hth);
        H(null);
        if ((locald instanceof d.a)) {
          b.b(this.hsT).zB(this.hsV.hth);
        }
        AppMethodBeat.o(131374);
        return;
      }
      catch (IOException localIOException)
      {
        ac.printErrStackTrace("Luggage.AppBrandSimpleImageLoader.LoadTask", localIOException, " doIOJobImpl, io exp ", new Object[0]);
        b.a(this.hsT).zG(this.hsV.hth);
        b.a(this.hsT).b(this.hsV.hth, this);
        b.a(this.hsT).zD(this.hsV.hth);
        if ((localIOException instanceof FileNotFoundException)) {
          H(null);
        }
        AppMethodBeat.o(131374);
      }
    }
  }
  
  static final class o
  {
    static final b htf;
    
    static
    {
      AppMethodBeat.i(131382);
      htf = new b((byte)0);
      AppMethodBeat.o(131382);
    }
  }
  
  public static final class p
  {
    private final String htg;
    public final String hth;
    
    private p(String paramString)
    {
      AppMethodBeat.i(205009);
      if (TextUtils.isEmpty(paramString))
      {
        paramString = new IllegalArgumentException();
        AppMethodBeat.o(205009);
        throw paramString;
      }
      this.htg = paramString;
      this.hth = b.zz(paramString);
      AppMethodBeat.o(205009);
    }
    
    private static void a(HttpURLConnection paramHttpURLConnection, Map<String, String> paramMap)
    {
      AppMethodBeat.i(205011);
      if (paramMap != null)
      {
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          ac.i("Luggage.AppBrandSimpleImageLoader", "setHeaders, header: %s: %s", new Object[] { localEntry.getKey(), localEntry.getValue() });
          paramHttpURLConnection.setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
        }
      }
      AppMethodBeat.o(205011);
    }
    
    /* Error */
    final InputStream t(final Map<String, String> paramMap)
    {
      // Byte code:
      //   0: ldc 109
      //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 38	com/tencent/mm/modelappbrand/a/b$p:htg	Ljava/lang/String;
      //   9: ldc 111
      //   11: invokevirtual 115	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   14: ifne +15 -> 29
      //   17: aload_0
      //   18: getfield 38	com/tencent/mm/modelappbrand/a/b$p:htg	Ljava/lang/String;
      //   21: ldc 117
      //   23: invokevirtual 115	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   26: ifeq +45 -> 71
      //   29: aload_0
      //   30: getfield 38	com/tencent/mm/modelappbrand/a/b$p:htg	Ljava/lang/String;
      //   33: invokestatic 123	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
      //   36: astore_1
      //   37: ldc 109
      //   39: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   42: aload_1
      //   43: areturn
      //   44: astore_1
      //   45: ldc 77
      //   47: aload_1
      //   48: ldc 125
      //   50: iconst_1
      //   51: anewarray 4	java/lang/Object
      //   54: dup
      //   55: iconst_0
      //   56: aload_0
      //   57: getfield 38	com/tencent/mm/modelappbrand/a/b$p:htg	Ljava/lang/String;
      //   60: aastore
      //   61: invokestatic 129	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   64: ldc 109
      //   66: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   69: aload_1
      //   70: athrow
      //   71: new 131	java/net/URL
      //   74: dup
      //   75: aload_0
      //   76: getfield 38	com/tencent/mm/modelappbrand/a/b$p:htg	Ljava/lang/String;
      //   79: invokespecial 132	java/net/URL:<init>	(Ljava/lang/String;)V
      //   82: invokevirtual 136	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   85: checkcast 94	java/net/HttpURLConnection
      //   88: astore_3
      //   89: aload_3
      //   90: aload_1
      //   91: invokestatic 138	com/tencent/mm/modelappbrand/a/b$p:a	(Ljava/net/HttpURLConnection;Ljava/util/Map;)V
      //   94: aload_3
      //   95: invokevirtual 142	java/net/HttpURLConnection:getResponseCode	()I
      //   98: sipush 301
      //   101: if_icmpeq +15 -> 116
      //   104: aload_3
      //   105: astore_2
      //   106: aload_3
      //   107: invokevirtual 142	java/net/HttpURLConnection:getResponseCode	()I
      //   110: sipush 302
      //   113: if_icmpne +112 -> 225
      //   116: aload_3
      //   117: ldc 144
      //   119: invokevirtual 147	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   122: astore_2
      //   123: aload_3
      //   124: invokevirtual 151	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   127: invokevirtual 156	java/io/InputStream:close	()V
      //   130: aload_3
      //   131: invokevirtual 159	java/net/HttpURLConnection:disconnect	()V
      //   134: aload_2
      //   135: invokestatic 164	android/webkit/URLUtil:isAboutUrl	(Ljava/lang/String;)Z
      //   138: ifne +10 -> 148
      //   141: aload_2
      //   142: invokestatic 167	android/webkit/URLUtil:isNetworkUrl	(Ljava/lang/String;)Z
      //   145: ifne +55 -> 200
      //   148: new 169	java/net/MalformedURLException
      //   151: dup
      //   152: ldc 171
      //   154: iconst_2
      //   155: anewarray 4	java/lang/Object
      //   158: dup
      //   159: iconst_0
      //   160: aload_0
      //   161: getfield 38	com/tencent/mm/modelappbrand/a/b$p:htg	Ljava/lang/String;
      //   164: aastore
      //   165: dup
      //   166: iconst_1
      //   167: aload_2
      //   168: aastore
      //   169: invokestatic 175	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   172: invokespecial 176	java/net/MalformedURLException:<init>	(Ljava/lang/String;)V
      //   175: astore_1
      //   176: ldc 109
      //   178: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   181: aload_1
      //   182: athrow
      //   183: astore_1
      //   184: new 178	java/io/IOException
      //   187: dup
      //   188: aload_1
      //   189: invokespecial 181	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
      //   192: astore_1
      //   193: ldc 109
      //   195: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   198: aload_1
      //   199: athrow
      //   200: new 131	java/net/URL
      //   203: dup
      //   204: aload_2
      //   205: invokespecial 132	java/net/URL:<init>	(Ljava/lang/String;)V
      //   208: invokevirtual 136	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   211: checkcast 94	java/net/HttpURLConnection
      //   214: astore_2
      //   215: aload_2
      //   216: iconst_0
      //   217: invokevirtual 185	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
      //   220: aload_2
      //   221: aload_1
      //   222: invokestatic 138	com/tencent/mm/modelappbrand/a/b$p:a	(Ljava/net/HttpURLConnection;Ljava/util/Map;)V
      //   225: new 187	com/tencent/mm/plugin/appbrand/z/i
      //   228: dup
      //   229: aload_2
      //   230: invokespecial 190	com/tencent/mm/plugin/appbrand/z/i:<init>	(Ljava/lang/Object;)V
      //   233: astore_1
      //   234: new 9	com/tencent/mm/modelappbrand/a/b$p$1
      //   237: dup
      //   238: aload_0
      //   239: aload_2
      //   240: invokevirtual 151	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   243: aload_1
      //   244: invokespecial 193	com/tencent/mm/modelappbrand/a/b$p$1:<init>	(Lcom/tencent/mm/modelappbrand/a/b$p;Ljava/io/InputStream;Lcom/tencent/mm/plugin/appbrand/z/i;)V
      //   247: astore_1
      //   248: ldc 109
      //   250: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   253: aload_1
      //   254: areturn
      //   255: astore_3
      //   256: goto -122 -> 134
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	259	0	this	p
      //   0	259	1	paramMap	Map<String, String>
      //   105	135	2	localObject	Object
      //   88	43	3	localHttpURLConnection	HttpURLConnection
      //   255	1	3	localThrowable	Throwable
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
      //   123	134	255	java/lang/Throwable
    }
    
    public final String toString()
    {
      return this.htg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b
 * JD-Core Version:    0.7.0.1
 */