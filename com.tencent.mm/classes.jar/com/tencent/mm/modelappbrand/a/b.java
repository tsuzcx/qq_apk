package com.tencent.mm.modelappbrand.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.appbrand.y.m;
import com.tencent.mm.plugin.appbrand.y.m.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b
{
  private static String hNI;
  private static b.g hNJ;
  private final Map<k, String> hNC;
  private final Map<String, k> hND;
  private final Map<Integer, String> hNE;
  public final e hNF;
  private final b.l hNG;
  private final i hNH;
  
  static
  {
    AppMethodBeat.i(131403);
    k localk2 = k.W(ak.getContext().getExternalCacheDir());
    k localk1 = localk2;
    if (localk2 == null) {
      localk1 = k.W(ak.getContext().getCacheDir());
    }
    if (localk1 != null) {
      CW(w.B(localk1.fTh()));
    }
    hNJ = b.g.hOd;
    AppMethodBeat.o(131403);
  }
  
  private b()
  {
    AppMethodBeat.i(131383);
    this.hNC = new ConcurrentHashMap();
    this.hND = new ConcurrentHashMap();
    this.hNE = new ConcurrentHashMap();
    this.hNG = new b.d();
    this.hNH = new b.b((byte)0);
    this.hNF = new e(new aq("AppBrandSimpleImageLoaderDiskIOHandlerThread"), (byte)0);
    AppMethodBeat.o(131383);
  }
  
  /* Error */
  private byte[] CV(String paramString)
  {
    // Byte code:
    //   0: ldc 176
    //   2: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 182	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifeq +10 -> 19
    //   12: ldc 176
    //   14: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: aconst_null
    //   18: areturn
    //   19: aload_0
    //   20: getfield 157	com/tencent/mm/modelappbrand/a/b:hNH	Lcom/tencent/mm/modelappbrand/a/b$i;
    //   23: new 68	com/tencent/mm/modelappbrand/a/b$p
    //   26: dup
    //   27: aload_1
    //   28: iconst_0
    //   29: invokespecial 185	com/tencent/mm/modelappbrand/a/b$p:<init>	(Ljava/lang/String;B)V
    //   32: getfield 188	com/tencent/mm/modelappbrand/a/b$p:hOs	Ljava/lang/String;
    //   35: invokeinterface 192 2 0
    //   40: astore 4
    //   42: aload 4
    //   44: ifnonnull +20 -> 64
    //   47: aload 4
    //   49: ifnull +8 -> 57
    //   52: aload 4
    //   54: invokevirtual 197	java/io/InputStream:close	()V
    //   57: ldc 176
    //   59: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: aconst_null
    //   63: areturn
    //   64: aload 4
    //   66: invokestatic 203	org/apache/commons/a/e:toByteArray	(Ljava/io/InputStream;)[B
    //   69: astore_2
    //   70: aload 4
    //   72: ifnull +8 -> 80
    //   75: aload 4
    //   77: invokevirtual 197	java/io/InputStream:close	()V
    //   80: ldc 176
    //   82: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: aload_2
    //   86: areturn
    //   87: astore_3
    //   88: ldc 176
    //   90: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aload_3
    //   94: athrow
    //   95: astore_2
    //   96: aload 4
    //   98: ifnull +12 -> 110
    //   101: aload_3
    //   102: ifnull +49 -> 151
    //   105: aload 4
    //   107: invokevirtual 197	java/io/InputStream:close	()V
    //   110: ldc 176
    //   112: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: aload_2
    //   116: athrow
    //   117: astore_2
    //   118: ldc 205
    //   120: ldc 207
    //   122: iconst_1
    //   123: anewarray 4	java/lang/Object
    //   126: dup
    //   127: iconst_0
    //   128: aload_1
    //   129: aastore
    //   130: invokestatic 212	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   133: ldc 176
    //   135: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: aconst_null
    //   139: areturn
    //   140: astore 4
    //   142: aload_3
    //   143: aload 4
    //   145: invokevirtual 216	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   148: goto -38 -> 110
    //   151: aload 4
    //   153: invokevirtual 197	java/io/InputStream:close	()V
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
  
  public static void CW(String paramString)
  {
    AppMethodBeat.i(176003);
    String str = paramString;
    if (!paramString.endsWith("/")) {
      str = paramString + "/";
    }
    paramString = str + "wxacache/";
    hNI = paramString;
    o.aZI(paramString);
    AppMethodBeat.o(176003);
  }
  
  private static String CX(String paramString)
  {
    AppMethodBeat.i(131396);
    String str = null;
    if (!bu.isNullOrNil(paramString)) {
      str = g.getMessageDigest(paramString.getBytes());
    }
    AppMethodBeat.o(131396);
    return str;
  }
  
  private static String a(String paramString, h paramh, f paramf)
  {
    AppMethodBeat.i(131395);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    if (paramh != null)
    {
      localStringBuilder.append("|transformation:");
      localStringBuilder.append(paramh.BN());
    }
    if (paramf != null)
    {
      localStringBuilder.append("|decoder:");
      localStringBuilder.append(paramf.BN());
    }
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(131395);
    return paramString;
  }
  
  public static void a(b.g paramg)
  {
    synchronized (o.hOq)
    {
      hNJ = paramg;
      return;
    }
  }
  
  public static b aEl()
  {
    return o.hOq;
  }
  
  private static b.g aEm()
  {
    synchronized (o.hOq)
    {
      b.g localg = hNJ;
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
  
  private String b(final k paramk, final String paramString, final h paramh, final f paramf)
  {
    AppMethodBeat.i(200125);
    if (paramk == null)
    {
      AppMethodBeat.o(200125);
      return null;
    }
    if (bu.isNullOrNil(paramString))
    {
      paramk.ox();
      AppMethodBeat.o(200125);
      return null;
    }
    try
    {
      if ("null".equals(Uri.parse(paramString).getHost()))
      {
        paramk.ox();
        AppMethodBeat.o(200125);
        return null;
      }
    }
    catch (Exception localException)
    {
      ae.d("Luggage.AppBrandSimpleImageLoader", "load before start LoadTask url %s", new Object[] { paramString });
      String str = paramk.BN() + "@" + paramk.hashCode();
      paramf = new n(paramString, paramh, this, this.hNG, this.hNH, paramf, str);
      paramh = paramf.aEw();
      paramk = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(131336);
          Object localObject = b.this.CT(paramh);
          if (localObject != null)
          {
            paramk.F((Bitmap)localObject);
            ae.d("Luggage.AppBrandSimpleImageLoader", "load already cached, url %s, bitmap %s", new Object[] { paramString, localObject });
            AppMethodBeat.o(131336);
            return;
          }
          localObject = paramf.aEv();
          b.c(b.this).put(paramk, localObject);
          b.d(b.this).put(localObject, paramk);
          paramk.aEt();
          localObject = paramf;
          b.a(((b.n)localObject).hOe).post(new b.n.2((b.n)localObject));
          AppMethodBeat.o(131336);
        }
      };
      if (!ar.isMainThread()) {
        break label185;
      }
    }
    paramk.run();
    for (;;)
    {
      AppMethodBeat.o(200125);
      return paramh;
      label185:
      ar.f(paramk);
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
    paramImageView = (String)this.hNE.remove(Integer.valueOf(paramImageView.hashCode()));
    if (paramImageView == null)
    {
      AppMethodBeat.o(131384);
      return;
    }
    a((k)this.hND.get(paramImageView));
    AppMethodBeat.o(131384);
  }
  
  public final Bitmap CT(String paramString)
  {
    AppMethodBeat.i(131385);
    paramString = this.hNG.wA(paramString);
    if ((paramString == null) || (paramString.isRecycled()))
    {
      AppMethodBeat.o(131385);
      return null;
    }
    AppMethodBeat.o(131385);
    return paramString;
  }
  
  public final String CU(String paramString)
  {
    AppMethodBeat.i(131387);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(131387);
      return null;
    }
    paramString = a(new c(), paramString, null);
    AppMethodBeat.o(131387);
    return paramString;
  }
  
  public final void CY(String paramString)
  {
    AppMethodBeat.i(131397);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(131397);
      return;
    }
    paramString = CX(paramString);
    if (this.hNF.Df(paramString))
    {
      AppMethodBeat.o(131397);
      return;
    }
    this.hNH.Dc(paramString);
    AppMethodBeat.o(131397);
  }
  
  public final void CZ(String paramString)
  {
    AppMethodBeat.i(161227);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(161227);
      return;
    }
    this.hNG.Dd(paramString);
    AppMethodBeat.o(161227);
  }
  
  /* Error */
  public final Bitmap a(String paramString, f paramf)
  {
    // Byte code:
    //   0: ldc_w 430
    //   3: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 182	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifeq +11 -> 21
    //   13: ldc_w 430
    //   16: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aconst_null
    //   20: areturn
    //   21: aload_1
    //   22: aconst_null
    //   23: aload_2
    //   24: invokestatic 375	com/tencent/mm/modelappbrand/a/b:a	(Ljava/lang/String;Lcom/tencent/mm/modelappbrand/a/b$h;Lcom/tencent/mm/modelappbrand/a/b$f;)Ljava/lang/String;
    //   27: astore 5
    //   29: aload_0
    //   30: getfield 152	com/tencent/mm/modelappbrand/a/b:hNG	Lcom/tencent/mm/modelappbrand/a/b$l;
    //   33: aload 5
    //   35: invokeinterface 402 2 0
    //   40: astore 4
    //   42: aload 4
    //   44: ifnull +12 -> 56
    //   47: ldc_w 430
    //   50: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aload 4
    //   55: areturn
    //   56: aload_1
    //   57: ldc_w 432
    //   60: invokevirtual 435	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   63: istore_3
    //   64: iload_3
    //   65: ifeq +45 -> 110
    //   68: aload_1
    //   69: invokestatic 436	com/tencent/mm/vfs/o:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   72: astore_1
    //   73: aload_1
    //   74: ifnonnull +53 -> 127
    //   77: aload_1
    //   78: invokestatic 439	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   81: ldc_w 430
    //   84: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aconst_null
    //   88: areturn
    //   89: astore_1
    //   90: ldc 205
    //   92: ldc_w 441
    //   95: invokestatic 444	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aconst_null
    //   99: invokestatic 439	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   102: ldc_w 430
    //   105: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: aconst_null
    //   109: areturn
    //   110: aload_0
    //   111: getfield 157	com/tencent/mm/modelappbrand/a/b:hNH	Lcom/tencent/mm/modelappbrand/a/b$i;
    //   114: aload_1
    //   115: invokestatic 261	com/tencent/mm/modelappbrand/a/b:CX	(Ljava/lang/String;)Ljava/lang/String;
    //   118: invokeinterface 192 2 0
    //   123: astore_1
    //   124: goto -51 -> 73
    //   127: aload_2
    //   128: ifnull +45 -> 173
    //   131: aload_1
    //   132: astore 4
    //   134: aload_2
    //   135: aload_1
    //   136: invokeinterface 448 2 0
    //   141: astore_2
    //   142: aload_2
    //   143: ifnull +18 -> 161
    //   146: aload_1
    //   147: astore 4
    //   149: aload_0
    //   150: getfield 152	com/tencent/mm/modelappbrand/a/b:hNG	Lcom/tencent/mm/modelappbrand/a/b$l;
    //   153: aload 5
    //   155: aload_2
    //   156: invokeinterface 452 3 0
    //   161: aload_1
    //   162: invokestatic 439	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   165: ldc_w 430
    //   168: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: aload_2
    //   172: areturn
    //   173: aload_1
    //   174: astore 4
    //   176: invokestatic 303	com/tencent/mm/modelappbrand/a/b:aEm	()Lcom/tencent/mm/modelappbrand/a/b$g;
    //   179: aload_1
    //   180: invokeinterface 455 2 0
    //   185: astore_2
    //   186: goto -44 -> 142
    //   189: astore_2
    //   190: aconst_null
    //   191: astore_1
    //   192: aload_1
    //   193: astore 4
    //   195: ldc 205
    //   197: aload_2
    //   198: ldc_w 457
    //   201: iconst_0
    //   202: anewarray 4	java/lang/Object
    //   205: invokestatic 461	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   208: aload_1
    //   209: invokestatic 439	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   212: ldc_w 430
    //   215: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   218: aconst_null
    //   219: areturn
    //   220: astore_1
    //   221: aconst_null
    //   222: astore 4
    //   224: aload 4
    //   226: invokestatic 439	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   229: ldc_w 430
    //   232: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final String a(ImageView paramImageView, String paramString, Drawable paramDrawable, h paramh, f paramf)
  {
    AppMethodBeat.i(131392);
    if (paramImageView == null)
    {
      AppMethodBeat.o(131392);
      return null;
    }
    d(paramImageView);
    if (bu.isNullOrNil(paramString))
    {
      if (paramDrawable != null) {
        paramImageView.setImageDrawable(paramDrawable);
      }
      AppMethodBeat.o(131392);
      return null;
    }
    paramDrawable = new b.2(this, paramImageView, this, paramDrawable);
    paramString = a(paramDrawable, paramString, paramh, paramf);
    if (!paramDrawable.hOf) {
      this.hNE.put(Integer.valueOf(paramImageView.hashCode()), aU(paramDrawable.key, paramString));
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
    AppMethodBeat.i(200124);
    if (paramk == null)
    {
      AppMethodBeat.o(200124);
      return;
    }
    paramk = (String)this.hNC.remove(paramk);
    if (!bu.isNullOrNil(paramk)) {
      this.hND.remove(paramk);
    }
    AppMethodBeat.o(200124);
  }
  
  public final void a(final String paramString, final j paramj)
  {
    AppMethodBeat.i(183777);
    byte[] arrayOfByte = CV(paramString);
    if ((arrayOfByte != null) && (arrayOfByte.length != 0))
    {
      paramj.V(arrayOfByte);
      AppMethodBeat.o(183777);
      return;
    }
    b(new k()
    {
      public final String BN()
      {
        return "BytesLoadTarget";
      }
      
      public final void F(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(131339);
        m.bCj().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(131338);
            byte[] arrayOfByte = b.a(b.this, b.3.this.val$url);
            if (b.3.this.hNT != null) {
              b.3.this.hNT.V(arrayOfByte);
            }
            AppMethodBeat.o(131338);
          }
        });
        AppMethodBeat.o(131339);
      }
      
      public final void aEt() {}
      
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
    this.hNG.clear();
    AppMethodBeat.o(161226);
  }
  
  public final class a
    implements b.e.a, Runnable
  {
    private boolean mCanceled = false;
    
    final void aEq()
    {
      AppMethodBeat.i(200112);
      b.a(this.hNN).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(200110);
          b.a(b.a.this.hNN).Dh(b.a.this.hNO.hOs);
          b.a(b.a.this.hNN).De(b.a.this.hNO.hOs);
          AppMethodBeat.o(200110);
        }
      });
      AppMethodBeat.o(200112);
    }
    
    public final void aEr()
    {
      AppMethodBeat.i(200114);
      if (this.mCanceled)
      {
        AppMethodBeat.o(200114);
        return;
      }
      try
      {
        InputStream localInputStream = b.b(this.hNN).openRead(this.hNO.hOs);
        if (localInputStream != null)
        {
          if (this.hNP != null) {
            this.hNP.apply(localInputStream);
          }
          aEq();
          AppMethodBeat.o(200114);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        ae.e("Luggage.AppBrandSimpleImageLoader", "loadIntoDiskCache diskCache.openRead failed, url=%s, e=%s", new Object[] { this.val$url, localThrowable });
        if (this.hNP != null) {
          this.hNP.apply(null);
        }
        aEq();
        AppMethodBeat.o(200114);
        return;
      }
      com.tencent.e.h.MqF.aO(new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "AppBrandSimpleImageLoaderDownloadThread";
        }
        
        public final void run()
        {
          AppMethodBeat.i(200111);
          b.n.a(b.a.this.hNO, b.a.this.hNQ, b.b(b.a.this.hNN));
          if (b.a.this.hNP != null) {}
          try
          {
            b.a.this.hNP.apply(b.b(b.a.this.hNN).openRead(b.a.this.hNO.hOs));
            label80:
            b.a.this.aEq();
            AppMethodBeat.o(200111);
            return;
          }
          catch (Throwable localThrowable)
          {
            break label80;
          }
        }
      });
      AppMethodBeat.o(200114);
    }
    
    public final void aEs()
    {
      this.mCanceled = true;
    }
    
    public final void run()
    {
      AppMethodBeat.i(200113);
      if (b.a(this.hNN).Df(this.hNO.hOs))
      {
        b.a(this.hNN).a(this.hNO.hOs, this);
        AppMethodBeat.o(200113);
        return;
      }
      b.a(this.hNN).Dg(this.hNO.hOs);
      aEr();
      AppMethodBeat.o(200113);
    }
  }
  
  public static class c
    implements b.k
  {
    public final String BN()
    {
      return "DefaultLoadTarget";
    }
    
    public void F(Bitmap paramBitmap) {}
    
    public final void aEt() {}
    
    public final void ox() {}
  }
  
  public static final class e
  {
    public final aq hOa;
    private final Map<String, List<a>> hOb;
    private final Map<String, Boolean> hOc;
    
    private e(aq paramaq)
    {
      AppMethodBeat.i(131355);
      this.hOb = new HashMap();
      this.hOc = new HashMap();
      this.hOa = paramaq;
      AppMethodBeat.o(131355);
    }
    
    final void De(String paramString)
    {
      AppMethodBeat.i(131356);
      if (bu.isNullOrNil(paramString))
      {
        AppMethodBeat.o(131356);
        return;
      }
      paramString = (List)this.hOb.remove(paramString);
      if (bu.ht(paramString))
      {
        AppMethodBeat.o(131356);
        return;
      }
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        ((a)paramString.next()).aEr();
      }
      AppMethodBeat.o(131356);
    }
    
    final boolean Df(String paramString)
    {
      AppMethodBeat.i(131357);
      if (bu.isNullOrNil(paramString))
      {
        AppMethodBeat.o(131357);
        return false;
      }
      boolean bool = this.hOc.containsKey(paramString);
      AppMethodBeat.o(131357);
      return bool;
    }
    
    final void Dg(String paramString)
    {
      AppMethodBeat.i(200116);
      if (bu.isNullOrNil(paramString))
      {
        AppMethodBeat.o(200116);
        return;
      }
      this.hOc.put(paramString, Boolean.TRUE);
      AppMethodBeat.o(200116);
    }
    
    final void Dh(String paramString)
    {
      AppMethodBeat.i(131358);
      if (bu.isNullOrNil(paramString))
      {
        AppMethodBeat.o(131358);
        return;
      }
      this.hOc.remove(paramString);
      AppMethodBeat.o(131358);
    }
    
    final void Di(String paramString)
    {
      AppMethodBeat.i(131360);
      if (bu.isNullOrNil(paramString))
      {
        AppMethodBeat.o(131360);
        return;
      }
      paramString = (List)this.hOb.remove(paramString);
      if (!bu.ht(paramString))
      {
        Iterator localIterator = paramString.iterator();
        while (localIterator.hasNext()) {
          ((a)localIterator.next()).aEs();
        }
        paramString.clear();
      }
      AppMethodBeat.o(131360);
    }
    
    final void a(String paramString, a parama)
    {
      AppMethodBeat.i(200117);
      if (bu.isNullOrNil(paramString))
      {
        AppMethodBeat.o(200117);
        return;
      }
      List localList = (List)this.hOb.get(paramString);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new LinkedList();
        this.hOb.put(paramString, localObject);
      }
      ((List)localObject).add(parama);
      AppMethodBeat.o(200117);
    }
    
    final void b(String paramString, a parama)
    {
      AppMethodBeat.i(131359);
      if (bu.isNullOrNil(paramString))
      {
        AppMethodBeat.o(131359);
        return;
      }
      paramString = (List)this.hOb.get(paramString);
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
      this.hOa.post(paramRunnable);
      AppMethodBeat.o(131361);
    }
    
    static abstract interface a
    {
      public abstract void aEr();
      
      public abstract void aEs();
    }
  }
  
  public static abstract interface f
    extends c
  {
    public abstract Bitmap x(InputStream paramInputStream);
  }
  
  public static abstract interface h
    extends c
  {
    public abstract Bitmap G(Bitmap paramBitmap);
  }
  
  public static abstract interface i
  {
    public abstract OutputStream Db(String paramString);
    
    public abstract boolean Dc(String paramString);
    
    public abstract InputStream openRead(String paramString);
  }
  
  public static abstract interface j
  {
    public abstract void V(byte[] paramArrayOfByte);
  }
  
  public static abstract interface k
    extends c
  {
    public abstract String BN();
    
    public abstract void F(Bitmap paramBitmap);
    
    public abstract void aEt();
    
    public abstract void ox();
  }
  
  static final class n
    implements b.e.a
  {
    final b.i hNH;
    final b hOe;
    final b.p hOg;
    private final b.h hOh;
    private final b.l hOi;
    private final b.f hOj;
    private final String hOk;
    boolean hOl;
    final Map<String, String> mHeaders;
    
    public n(String paramString1, b.h paramh, b paramb, b.l paraml, b.i parami, b.f paramf, String paramString2)
    {
      AppMethodBeat.i(200118);
      this.hOl = true;
      this.hOg = new b.p(paramString1, (byte)0);
      this.mHeaders = null;
      this.hOh = paramh;
      this.hOe = paramb;
      this.hOi = paraml;
      this.hNH = parami;
      this.hOj = paramf;
      this.hOk = paramString2;
      AppMethodBeat.o(200118);
    }
    
    private Bitmap H(Bitmap paramBitmap)
    {
      AppMethodBeat.i(131378);
      paramBitmap = this.hOh.G(paramBitmap);
      AppMethodBeat.o(131378);
      return paramBitmap;
    }
    
    private void I(Bitmap paramBitmap)
    {
      boolean bool2 = false;
      AppMethodBeat.i(131379);
      if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        ae.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "postLoadInWorkerThread bitmap ok %b", new Object[] { Boolean.valueOf(bool1) });
        final Bitmap localBitmap = paramBitmap;
        if (this.hOh != null)
        {
          localBitmap = paramBitmap;
          if (paramBitmap != null)
          {
            localBitmap = paramBitmap;
            if (!paramBitmap.isRecycled())
            {
              localBitmap = H(paramBitmap);
              ae.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "postLoadInWorkerThread, transform bmp, origin %s, transformed %s", new Object[] { paramBitmap, localBitmap });
              if (localBitmap != paramBitmap) {
                this.hOi.f(paramBitmap);
              }
            }
          }
        }
        this.hOi.put(aEw(), localBitmap);
        bool1 = bool2;
        if (localBitmap != null)
        {
          bool1 = bool2;
          if (!localBitmap.isRecycled()) {
            bool1 = true;
          }
        }
        ae.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "postLoadInWorkerThread before post to main thread, bitmap %s, ok %b", new Object[] { localBitmap, Boolean.valueOf(bool1) });
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(131369);
            b.n localn = b.n.this;
            Object localObject = localBitmap;
            if ((localObject == null) || (((Bitmap)localObject).isRecycled()))
            {
              ae.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "postLoadInMainThread, onLoadFailed bmp %s", new Object[] { localObject });
              localObject = (b.k)b.d(localn.hOe).remove(localn.aEv());
              if (localObject != null)
              {
                ((b.k)localObject).ox();
                b.c(localn.hOe).remove(localObject);
              }
              AppMethodBeat.o(131369);
              return;
            }
            ae.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "postLoadInMainThread, onBitmapLoaded bmp %s", new Object[] { localObject });
            localn.F((Bitmap)localObject);
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
      //   10: invokevirtual 149	com/tencent/mm/modelappbrand/a/b$p:B	(Ljava/util/Map;)Ljava/io/InputStream;
      //   13: astore 5
      //   15: aload 5
      //   17: ifnull +196 -> 213
      //   20: aload_2
      //   21: aload_0
      //   22: getfield 152	com/tencent/mm/modelappbrand/a/b$p:hOs	Ljava/lang/String;
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
      //   91: invokestatic 179	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
      //   174: invokestatic 179	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   177: aload_2
      //   178: aload_0
      //   179: getfield 152	com/tencent/mm/modelappbrand/a/b$p:hOs	Ljava/lang/String;
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
      //   225: invokestatic 179	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    
    private Bitmap aEy()
    {
      Object localObject1 = null;
      AppMethodBeat.i(131380);
      if (!b.aEo())
      {
        ae.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, sdcard unavailable");
        localObject1 = new d.c();
        AppMethodBeat.o(131380);
        throw ((Throwable)localObject1);
      }
      Object localObject2 = this.hNH.openRead(this.hOg.hOs);
      if (localObject2 == null)
      {
        ae.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, null from disk, tryDownload %b", new Object[] { Boolean.valueOf(this.hOl) });
        if (this.hOl) {
          com.tencent.e.h.MqF.aO(new com.tencent.e.i.h()
          {
            public final String getKey()
            {
              return "AppBrandSimpleImageLoaderDownloadThread";
            }
            
            public final void run()
            {
              AppMethodBeat.i(131371);
              b.n.a(b.n.this.hOg, b.n.this.mHeaders, b.n.this.hNH);
              b.a(b.n.this.hOe).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(131370);
                  b.n.this.hOl = false;
                  b.n.this.aEx();
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
          ae.printErrStackTrace("Luggage.AppBrandSimpleImageLoader.LoadTask", localException, " decode ", new Object[0]);
        }
        ae.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, decode failed, bmp %s", new Object[] { localObject1 });
        localObject1 = new d.a();
        AppMethodBeat.o(131380);
        throw ((Throwable)localObject1);
      }
      if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
      {
        ae.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, decoded bmp %s, size %d KB, url %s", new Object[] { localObject1, Integer.valueOf(android.support.v4.graphics.a.c((Bitmap)localObject1) / 1024), this.hOg });
        AppMethodBeat.o(131380);
        return localObject1;
        b.a(this.hOe).Di(this.hOg.hOs);
        b.a(this.hOe).Dh(this.hOg.hOs);
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
        if (this.hOj != null)
        {
          localBitmap = this.hOj.x(paramInputStream);
          return localBitmap;
        }
        Bitmap localBitmap = b.aEp().decodeStream(paramInputStream);
        return localBitmap;
      }
      finally
      {
        bu.d(paramInputStream);
        AppMethodBeat.o(131381);
      }
    }
    
    final void F(Bitmap paramBitmap)
    {
      AppMethodBeat.i(131377);
      b.k localk = (b.k)b.d(this.hOe).remove(aEv());
      if (localk != null)
      {
        localk.F(paramBitmap);
        b.c(this.hOe).remove(localk);
      }
      AppMethodBeat.o(131377);
    }
    
    public final void aEr()
    {
      AppMethodBeat.i(131375);
      final Bitmap localBitmap = this.hOi.wA(aEw());
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        ae.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "before actually doIOJob, same keyForMemory bitmap already exists, key %s", new Object[] { aEw() });
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(131367);
            b.n.this.F(localBitmap);
            AppMethodBeat.o(131367);
          }
        });
        AppMethodBeat.o(131375);
        return;
      }
      if (b.a(this.hOe).Df(this.hOg.hOs))
      {
        b.a(this.hOe).a(this.hOg.hOs, this);
        ae.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "already has job processing, make this job pending, key %s", new Object[] { this.hOg.hOs });
        AppMethodBeat.o(131375);
        return;
      }
      b.a(this.hOe).Dg(this.hOg.hOs);
      aEx();
      AppMethodBeat.o(131375);
    }
    
    public final void aEs()
    {
      AppMethodBeat.i(131376);
      b.k localk = (b.k)b.d(this.hOe).remove(aEv());
      if (localk != null) {
        b.c(this.hOe).remove(localk);
      }
      AppMethodBeat.o(131376);
    }
    
    final String aEv()
    {
      AppMethodBeat.i(131372);
      String str = b.aV(this.hOk, aEw());
      AppMethodBeat.o(131372);
      return str;
    }
    
    final String aEw()
    {
      AppMethodBeat.i(131373);
      String str = b.b(this.hOg.toString(), this.hOh, this.hOj);
      AppMethodBeat.o(131373);
      return str;
    }
    
    final void aEx()
    {
      AppMethodBeat.i(131374);
      try
      {
        Bitmap localBitmap = aEy();
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          b.a(this.hOe).Dh(this.hOg.hOs);
          b.a(this.hOe).b(this.hOg.hOs, this);
          I(localBitmap);
          b.a(this.hOe).De(this.hOg.hOs);
        }
        AppMethodBeat.o(131374);
        return;
      }
      catch (d locald)
      {
        ae.d("Luggage.AppBrandSimpleImageLoader.LoadTask", " doIOJobImpl, exp %s", new Object[] { locald });
        b.a(this.hOe).Dh(this.hOg.hOs);
        b.a(this.hOe).Di(this.hOg.hOs);
        I(null);
        if ((locald instanceof d.a)) {
          b.b(this.hOe).Dc(this.hOg.hOs);
        }
        AppMethodBeat.o(131374);
        return;
      }
      catch (IOException localIOException)
      {
        ae.printErrStackTrace("Luggage.AppBrandSimpleImageLoader.LoadTask", localIOException, " doIOJobImpl, io exp ", new Object[0]);
        b.a(this.hOe).Dh(this.hOg.hOs);
        b.a(this.hOe).b(this.hOg.hOs, this);
        b.a(this.hOe).De(this.hOg.hOs);
        if ((localIOException instanceof FileNotFoundException)) {
          I(null);
        }
        AppMethodBeat.o(131374);
      }
    }
  }
  
  static final class o
  {
    static final b hOq;
    
    static
    {
      AppMethodBeat.i(131382);
      hOq = new b((byte)0);
      AppMethodBeat.o(131382);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b
 * JD-Core Version:    0.7.0.1
 */