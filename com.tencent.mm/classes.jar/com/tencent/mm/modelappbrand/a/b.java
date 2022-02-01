package com.tencent.mm.modelappbrand.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
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
  private static boolean lyK;
  private static String lyR;
  private static g lyS;
  private final Map<k, String> lyL;
  private final Map<String, k> lyM;
  private final Map<Integer, String> lyN;
  public final e lyO;
  final b.l lyP;
  private final i lyQ;
  
  static
  {
    AppMethodBeat.i(131403);
    q localq2 = q.Q(MMApplicationContext.getContext().getExternalCacheDir());
    q localq1 = localq2;
    if (localq2 == null) {
      localq1 = q.Q(MMApplicationContext.getContext().getCacheDir());
    }
    if (localq1 != null) {
      SZ(localq1.bOF());
    }
    lyS = g.lzm;
    AppMethodBeat.o(131403);
  }
  
  private b()
  {
    AppMethodBeat.i(131383);
    this.lyL = new ConcurrentHashMap();
    this.lyM = new ConcurrentHashMap();
    this.lyN = new ConcurrentHashMap();
    this.lyP = new b.d();
    this.lyQ = new b.b((byte)0);
    this.lyO = new e(new MMHandler("AppBrandSimpleImageLoaderDiskIOHandlerThread"), (byte)0);
    AppMethodBeat.o(131383);
  }
  
  /* Error */
  private byte[] SY(String paramString)
  {
    // Byte code:
    //   0: ldc 177
    //   2: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 183	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifeq +10 -> 19
    //   12: ldc 177
    //   14: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: aconst_null
    //   18: areturn
    //   19: aload_0
    //   20: getfield 158	com/tencent/mm/modelappbrand/a/b:lyQ	Lcom/tencent/mm/modelappbrand/a/b$i;
    //   23: new 72	com/tencent/mm/modelappbrand/a/b$q
    //   26: dup
    //   27: aload_1
    //   28: iconst_0
    //   29: invokespecial 186	com/tencent/mm/modelappbrand/a/b$q:<init>	(Ljava/lang/String;B)V
    //   32: getfield 189	com/tencent/mm/modelappbrand/a/b$q:lzC	Ljava/lang/String;
    //   35: invokeinterface 193 2 0
    //   40: astore 4
    //   42: aload 4
    //   44: ifnonnull +20 -> 64
    //   47: aload 4
    //   49: ifnull +8 -> 57
    //   52: aload 4
    //   54: invokevirtual 198	java/io/InputStream:close	()V
    //   57: ldc 177
    //   59: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: aconst_null
    //   63: areturn
    //   64: aload 4
    //   66: invokestatic 204	org/apache/commons/a/d:toByteArray	(Ljava/io/InputStream;)[B
    //   69: astore_2
    //   70: aload 4
    //   72: ifnull +8 -> 80
    //   75: aload 4
    //   77: invokevirtual 198	java/io/InputStream:close	()V
    //   80: ldc 177
    //   82: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: aload_2
    //   86: areturn
    //   87: astore_3
    //   88: ldc 177
    //   90: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aload_3
    //   94: athrow
    //   95: astore_2
    //   96: aload 4
    //   98: ifnull +12 -> 110
    //   101: aload_3
    //   102: ifnull +49 -> 151
    //   105: aload 4
    //   107: invokevirtual 198	java/io/InputStream:close	()V
    //   110: ldc 177
    //   112: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: aload_2
    //   116: athrow
    //   117: astore_2
    //   118: ldc 206
    //   120: ldc 208
    //   122: iconst_1
    //   123: anewarray 4	java/lang/Object
    //   126: dup
    //   127: iconst_0
    //   128: aload_1
    //   129: aastore
    //   130: invokestatic 213	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   133: ldc 177
    //   135: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: aconst_null
    //   139: areturn
    //   140: astore 4
    //   142: aload_3
    //   143: aload 4
    //   145: invokevirtual 217	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   148: goto -38 -> 110
    //   151: aload 4
    //   153: invokevirtual 198	java/io/InputStream:close	()V
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
  
  public static void SZ(String paramString)
  {
    AppMethodBeat.i(176003);
    String str = paramString;
    if (!paramString.endsWith("/")) {
      str = paramString + "/";
    }
    paramString = str + "wxacache/";
    lyR = paramString;
    u.bBD(paramString);
    AppMethodBeat.o(176003);
  }
  
  private static String Ta(String paramString)
  {
    AppMethodBeat.i(131396);
    String str = null;
    if (!Util.isNullOrNil(paramString)) {
      str = g.getMessageDigest(paramString.getBytes());
    }
    AppMethodBeat.o(131396);
    return str;
  }
  
  private String a(ImageView paramImageView, String paramString, Drawable paramDrawable, h paramh, f paramf)
  {
    AppMethodBeat.i(230586);
    if (paramImageView == null)
    {
      AppMethodBeat.o(230586);
      return null;
    }
    d(paramImageView);
    if (Util.isNullOrNil(paramString))
    {
      if (paramDrawable != null) {
        paramImageView.setImageDrawable(paramDrawable);
      }
      AppMethodBeat.o(230586);
      return null;
    }
    paramDrawable = new b.2(this, paramImageView, this, paramString, paramDrawable);
    paramString = a(paramDrawable, paramString, paramh, paramf);
    if (!paramDrawable.lzp) {
      this.lyN.put(Integer.valueOf(paramImageView.hashCode()), bc(b(paramDrawable), paramString));
    }
    AppMethodBeat.o(230586);
    return paramString;
  }
  
  private static String a(String paramString, h paramh, f paramf)
  {
    AppMethodBeat.i(131395);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    if (paramh != null)
    {
      localStringBuilder.append("|transformation:");
      localStringBuilder.append(paramh.key());
    }
    if (paramf != null)
    {
      localStringBuilder.append("|decoder:");
      localStringBuilder.append(paramf.key());
    }
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(131395);
    return paramString;
  }
  
  public static void a(g paramg)
  {
    synchronized (b.o.lzA)
    {
      lyS = paramg;
      return;
    }
  }
  
  private static String b(k paramk)
  {
    AppMethodBeat.i(230587);
    paramk = paramk.key() + "@" + paramk.hashCode();
    AppMethodBeat.o(230587);
    return paramk;
  }
  
  private String b(final k paramk, final String paramString, final h paramh, final f paramf)
  {
    AppMethodBeat.i(230578);
    if (paramk == null)
    {
      AppMethodBeat.o(230578);
      return null;
    }
    if (Util.isNullOrNil(paramString))
    {
      paramk.bhr();
      AppMethodBeat.o(230578);
      return null;
    }
    try
    {
      if ("null".equals(Uri.parse(paramString).getHost()))
      {
        paramk.bhr();
        AppMethodBeat.o(230578);
        return null;
      }
    }
    catch (Exception localException)
    {
      Log.d("Luggage.AppBrandSimpleImageLoader", "load before start LoadTask url %s", new Object[] { paramString });
      String str = b(paramk);
      paramf = new n(paramString, null, paramh, this, this.lyP, this.lyQ, paramf, str);
      paramh = paramf.bhu();
      paramk = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(131336);
          Object localObject1 = b.this;
          Object localObject2 = paramh;
          localObject2 = ((b)localObject1).lyP.LI((String)localObject2);
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (!((Bitmap)localObject2).isRecycled()) {}
          }
          else
          {
            localObject1 = null;
          }
          if (localObject1 != null)
          {
            paramk.G((Bitmap)localObject1);
            Log.d("Luggage.AppBrandSimpleImageLoader", "load already cached, url %s, bitmap %s", new Object[] { paramString, localObject1 });
            AppMethodBeat.o(131336);
            return;
          }
          localObject1 = paramf.bht();
          b.c(b.this).put(paramk, localObject1);
          b.d(b.this).put(localObject1, paramk);
          paramk.bhq();
          localObject1 = paramf;
          b.a(((b.n)localObject1).lzn).post(new b.n.2((b.n)localObject1));
          AppMethodBeat.o(131336);
        }
      };
      if (!MMHandlerThread.isMainThread()) {
        break label158;
      }
    }
    paramk.run();
    for (;;)
    {
      AppMethodBeat.o(230578);
      return paramh;
      label158:
      MMHandlerThread.postToMainThread(paramk);
    }
  }
  
  private static String bc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(131394);
    paramString1 = paramString1 + paramString2;
    AppMethodBeat.o(131394);
    return paramString1;
  }
  
  public static b bhh()
  {
    return b.o.lzA;
  }
  
  private static g bhi()
  {
    synchronized (b.o.lzA)
    {
      g localg = lyS;
      return localg;
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
    paramImageView = (String)this.lyN.remove(Integer.valueOf(paramImageView.hashCode()));
    if (paramImageView == null)
    {
      AppMethodBeat.o(131384);
      return;
    }
    a((k)this.lyM.get(paramImageView));
    AppMethodBeat.o(131384);
  }
  
  public static void gf(boolean paramBoolean)
  {
    AppMethodBeat.i(230567);
    Log.i("Luggage.AppBrandSimpleImageLoader", "enableCheckServerTrustedIssueFixer, isEnable: ".concat(String.valueOf(paramBoolean)));
    lyK = paramBoolean;
    AppMethodBeat.o(230567);
  }
  
  public final String SX(String paramString)
  {
    AppMethodBeat.i(131387);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(131387);
      return null;
    }
    paramString = a(new c(), paramString, null);
    AppMethodBeat.o(131387);
    return paramString;
  }
  
  public final void Tb(String paramString)
  {
    AppMethodBeat.i(131397);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(131397);
      return;
    }
    paramString = Ta(paramString);
    if (this.lyO.Ti(paramString))
    {
      AppMethodBeat.o(131397);
      return;
    }
    this.lyQ.ho(paramString);
    AppMethodBeat.o(131397);
  }
  
  public final void Tc(String paramString)
  {
    AppMethodBeat.i(161227);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(161227);
      return;
    }
    this.lyP.Tg(paramString);
    AppMethodBeat.o(161227);
  }
  
  /* Error */
  public final Bitmap a(String paramString, f paramf)
  {
    // Byte code:
    //   0: ldc_w 465
    //   3: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 183	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifeq +11 -> 21
    //   13: ldc_w 465
    //   16: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aconst_null
    //   20: areturn
    //   21: aload_1
    //   22: aconst_null
    //   23: aload_2
    //   24: invokestatic 389	com/tencent/mm/modelappbrand/a/b:a	(Ljava/lang/String;Lcom/tencent/mm/modelappbrand/a/b$h;Lcom/tencent/mm/modelappbrand/a/b$f;)Ljava/lang/String;
    //   27: astore 5
    //   29: aload_0
    //   30: getfield 153	com/tencent/mm/modelappbrand/a/b:lyP	Lcom/tencent/mm/modelappbrand/a/b$l;
    //   33: aload 5
    //   35: invokeinterface 469 2 0
    //   40: astore 4
    //   42: aload 4
    //   44: ifnull +12 -> 56
    //   47: ldc_w 465
    //   50: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aload 4
    //   55: areturn
    //   56: aload_1
    //   57: ldc_w 471
    //   60: invokevirtual 474	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   63: istore_3
    //   64: iload_3
    //   65: ifeq +45 -> 110
    //   68: aload_1
    //   69: invokestatic 475	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   72: astore_1
    //   73: aload_1
    //   74: ifnonnull +53 -> 127
    //   77: aload_1
    //   78: invokestatic 479	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   81: ldc_w 465
    //   84: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aconst_null
    //   88: areturn
    //   89: astore_1
    //   90: ldc 206
    //   92: ldc_w 481
    //   95: invokestatic 483	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aconst_null
    //   99: invokestatic 479	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   102: ldc_w 465
    //   105: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: aconst_null
    //   109: areturn
    //   110: aload_0
    //   111: getfield 158	com/tencent/mm/modelappbrand/a/b:lyQ	Lcom/tencent/mm/modelappbrand/a/b$i;
    //   114: aload_1
    //   115: invokestatic 261	com/tencent/mm/modelappbrand/a/b:Ta	(Ljava/lang/String;)Ljava/lang/String;
    //   118: invokeinterface 193 2 0
    //   123: astore_1
    //   124: goto -51 -> 73
    //   127: aload_2
    //   128: ifnull +45 -> 173
    //   131: aload_1
    //   132: astore 4
    //   134: aload_2
    //   135: aload_1
    //   136: invokeinterface 487 2 0
    //   141: astore_2
    //   142: aload_2
    //   143: ifnull +18 -> 161
    //   146: aload_1
    //   147: astore 4
    //   149: aload_0
    //   150: getfield 153	com/tencent/mm/modelappbrand/a/b:lyP	Lcom/tencent/mm/modelappbrand/a/b$l;
    //   153: aload 5
    //   155: aload_2
    //   156: invokeinterface 490 3 0
    //   161: aload_1
    //   162: invokestatic 479	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   165: ldc_w 465
    //   168: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: aload_2
    //   172: areturn
    //   173: aload_1
    //   174: astore 4
    //   176: invokestatic 413	com/tencent/mm/modelappbrand/a/b:bhi	()Lcom/tencent/mm/modelappbrand/a/b$g;
    //   179: aload_1
    //   180: invokeinterface 493 2 0
    //   185: astore_2
    //   186: goto -44 -> 142
    //   189: astore_2
    //   190: aconst_null
    //   191: astore_1
    //   192: aload_1
    //   193: astore 4
    //   195: ldc 206
    //   197: aload_2
    //   198: ldc_w 495
    //   201: iconst_0
    //   202: anewarray 4	java/lang/Object
    //   205: invokestatic 499	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   208: aload_1
    //   209: invokestatic 479	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   212: ldc_w 465
    //   215: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   218: aconst_null
    //   219: areturn
    //   220: astore_1
    //   221: aconst_null
    //   222: astore 4
    //   224: aload 4
    //   226: invokestatic 479	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   229: ldc_w 465
    //   232: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final String a(ImageView paramImageView, String paramString, f paramf)
  {
    AppMethodBeat.i(230583);
    paramImageView = a(paramImageView, paramString, null, null, paramf);
    AppMethodBeat.o(230583);
    return paramImageView;
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
    AppMethodBeat.i(230574);
    if (paramk == null)
    {
      AppMethodBeat.o(230574);
      return;
    }
    paramk = (String)this.lyL.remove(paramk);
    if (!Util.isNullOrNil(paramk)) {
      this.lyM.remove(paramk);
    }
    AppMethodBeat.o(230574);
  }
  
  public final void a(final String paramString, final j paramj)
  {
    AppMethodBeat.i(183777);
    byte[] arrayOfByte = SY(paramString);
    if ((arrayOfByte != null) && (arrayOfByte.length != 0))
    {
      paramj.at(arrayOfByte);
      AppMethodBeat.o(183777);
      return;
    }
    b(new k()
    {
      public final void G(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(131339);
        m.clV().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(131338);
            byte[] arrayOfByte = b.a(b.this, b.3.this.val$url);
            if (b.3.this.lzc != null) {
              b.3.this.lzc.at(arrayOfByte);
            }
            AppMethodBeat.o(131338);
          }
        });
        AppMethodBeat.o(131339);
      }
      
      public final void bhq() {}
      
      public final void bhr()
      {
        AppMethodBeat.i(131340);
        if (paramj != null) {
          paramj.at(null);
        }
        AppMethodBeat.o(131340);
      }
      
      public final String key()
      {
        return "BytesLoadTarget";
      }
    }, paramString, null, null);
    AppMethodBeat.o(183777);
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(161226);
    this.lyP.clear();
    AppMethodBeat.o(161226);
  }
  
  public final class a
    implements b.e.a, Runnable
  {
    private boolean mCanceled = false;
    
    final void bhn()
    {
      AppMethodBeat.i(230967);
      b.a(this.lyW).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(230206);
          b.a(b.a.this.lyW).Tk(b.a.this.lyX.lzC);
          b.a(b.a.this.lyW).Th(b.a.this.lyX.lzC);
          AppMethodBeat.o(230206);
        }
      });
      AppMethodBeat.o(230967);
    }
    
    public final void bho()
    {
      AppMethodBeat.i(230972);
      if (this.mCanceled)
      {
        AppMethodBeat.o(230972);
        return;
      }
      try
      {
        InputStream localInputStream = b.b(this.lyW).Tf(this.lyX.lzC);
        if (localInputStream != null)
        {
          if (this.lyY != null) {
            this.lyY.apply(localInputStream);
          }
          bhn();
          AppMethodBeat.o(230972);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        Log.e("Luggage.AppBrandSimpleImageLoader", "loadIntoDiskCache diskCache.openRead failed, url=%s, e=%s", new Object[] { this.val$url, localThrowable });
        if (this.lyY != null) {
          this.lyY.apply(null);
        }
        bhn();
        AppMethodBeat.o(230972);
        return;
      }
      com.tencent.e.h.ZvG.be(new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "AppBrandSimpleImageLoaderDownloadThread";
        }
        
        public final void run()
        {
          AppMethodBeat.i(229791);
          b.n.a(b.a.this.lyX, b.a.this.lyZ, b.b(b.a.this.lyW));
          if (b.a.this.lyY != null) {}
          try
          {
            b.a.this.lyY.apply(b.b(b.a.this.lyW).Tf(b.a.this.lyX.lzC));
            label80:
            b.a.this.bhn();
            AppMethodBeat.o(229791);
            return;
          }
          catch (Throwable localThrowable)
          {
            break label80;
          }
        }
      });
      AppMethodBeat.o(230972);
    }
    
    public final void bhp()
    {
      this.mCanceled = true;
    }
    
    public final void run()
    {
      AppMethodBeat.i(230969);
      if (b.a(this.lyW).Ti(this.lyX.lzC))
      {
        b.a(this.lyW).a(this.lyX.lzC, this);
        AppMethodBeat.o(230969);
        return;
      }
      b.a(this.lyW).Tj(this.lyX.lzC);
      bho();
      AppMethodBeat.o(230969);
    }
  }
  
  public static class c
    implements b.k
  {
    public void G(Bitmap paramBitmap) {}
    
    public final void bhq() {}
    
    public final void bhr() {}
    
    public final String key()
    {
      return "DefaultLoadTarget";
    }
  }
  
  public static final class e
  {
    public final MMHandler lzj;
    private final Map<String, List<a>> lzk;
    private final Map<String, Boolean> lzl;
    
    private e(MMHandler paramMMHandler)
    {
      AppMethodBeat.i(131355);
      this.lzk = new HashMap();
      this.lzl = new HashMap();
      this.lzj = paramMMHandler;
      AppMethodBeat.o(131355);
    }
    
    final void Th(String paramString)
    {
      AppMethodBeat.i(131356);
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(131356);
        return;
      }
      paramString = (List)this.lzk.remove(paramString);
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(131356);
        return;
      }
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        ((a)paramString.next()).bho();
      }
      AppMethodBeat.o(131356);
    }
    
    final boolean Ti(String paramString)
    {
      AppMethodBeat.i(131357);
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(131357);
        return false;
      }
      boolean bool = this.lzl.containsKey(paramString);
      AppMethodBeat.o(131357);
      return bool;
    }
    
    final void Tj(String paramString)
    {
      AppMethodBeat.i(230156);
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(230156);
        return;
      }
      this.lzl.put(paramString, Boolean.TRUE);
      AppMethodBeat.o(230156);
    }
    
    final void Tk(String paramString)
    {
      AppMethodBeat.i(131358);
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(131358);
        return;
      }
      this.lzl.remove(paramString);
      AppMethodBeat.o(131358);
    }
    
    final void Tl(String paramString)
    {
      AppMethodBeat.i(131360);
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(131360);
        return;
      }
      paramString = (List)this.lzk.remove(paramString);
      if (!Util.isNullOrNil(paramString))
      {
        Iterator localIterator = paramString.iterator();
        while (localIterator.hasNext()) {
          ((a)localIterator.next()).bhp();
        }
        paramString.clear();
      }
      AppMethodBeat.o(131360);
    }
    
    final void a(String paramString, a parama)
    {
      AppMethodBeat.i(230161);
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(230161);
        return;
      }
      List localList = (List)this.lzk.get(paramString);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new LinkedList();
        this.lzk.put(paramString, localObject);
      }
      ((List)localObject).add(parama);
      AppMethodBeat.o(230161);
    }
    
    final void b(String paramString, a parama)
    {
      AppMethodBeat.i(131359);
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(131359);
        return;
      }
      paramString = (List)this.lzk.get(paramString);
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
      this.lzj.post(paramRunnable);
      AppMethodBeat.o(131361);
    }
    
    static abstract interface a
    {
      public abstract void bho();
      
      public abstract void bhp();
    }
  }
  
  public static abstract interface f
    extends c
  {
    public abstract Bitmap u(InputStream paramInputStream);
  }
  
  public static abstract interface g
  {
    public static final g lzm = new g()
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
    public abstract Bitmap H(Bitmap paramBitmap);
  }
  
  public static abstract interface i
  {
    public abstract OutputStream Te(String paramString);
    
    public abstract InputStream Tf(String paramString);
    
    public abstract boolean ho(String paramString);
  }
  
  public static abstract interface j
  {
    public abstract void at(byte[] paramArrayOfByte);
  }
  
  public static abstract interface k
    extends c
  {
    public abstract void G(Bitmap paramBitmap);
    
    public abstract void bhq();
    
    public abstract void bhr();
    
    public abstract String key();
  }
  
  static final class n
    implements b.e.a
  {
    final b.i lyQ;
    final b lzn;
    final b.q lzq;
    private final b.h lzr;
    final b.l lzs;
    private final b.f lzt;
    private final String lzu;
    boolean lzv;
    final Map<String, String> mHeaders;
    
    public n(String paramString1, Map<String, String> paramMap, b.h paramh, b paramb, b.l paraml, b.i parami, b.f paramf, String paramString2)
    {
      AppMethodBeat.i(230092);
      this.lzv = true;
      this.lzq = new b.q(paramString1, (byte)0);
      this.mHeaders = null;
      this.lzr = paramh;
      this.lzn = paramb;
      this.lzs = paraml;
      this.lyQ = parami;
      this.lzt = paramf;
      this.lzu = paramString2;
      AppMethodBeat.o(230092);
    }
    
    private Bitmap I(Bitmap paramBitmap)
    {
      AppMethodBeat.i(131378);
      paramBitmap = this.lzr.H(paramBitmap);
      AppMethodBeat.o(131378);
      return paramBitmap;
    }
    
    private void J(Bitmap paramBitmap)
    {
      boolean bool2 = false;
      AppMethodBeat.i(131379);
      if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        Log.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "postLoadInWorkerThread bitmap ok %b", new Object[] { Boolean.valueOf(bool1) });
        final Bitmap localBitmap = paramBitmap;
        if (this.lzr != null)
        {
          localBitmap = paramBitmap;
          if (paramBitmap != null)
          {
            localBitmap = paramBitmap;
            if (!paramBitmap.isRecycled())
            {
              localBitmap = I(paramBitmap);
              Log.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "postLoadInWorkerThread, transform bmp, origin %s, transformed %s", new Object[] { paramBitmap, localBitmap });
              if (localBitmap != paramBitmap) {
                this.lzs.E(paramBitmap);
              }
            }
          }
        }
        bool1 = bool2;
        if (localBitmap != null)
        {
          bool1 = bool2;
          if (!localBitmap.isRecycled()) {
            bool1 = true;
          }
        }
        Log.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "postLoadInWorkerThread before post to main thread, bitmap %s, ok %b", new Object[] { localBitmap, Boolean.valueOf(bool1) });
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(131369);
            b.n.this.lzs.put(b.n.this.bhu(), localBitmap);
            b.n localn = b.n.this;
            Object localObject = localBitmap;
            if ((localObject == null) || (((Bitmap)localObject).isRecycled()))
            {
              Log.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "postLoadInMainThread, onLoadFailed bmp %s", new Object[] { localObject });
              localObject = (b.k)b.d(localn.lzn).remove(localn.bht());
              if (localObject != null)
              {
                ((b.k)localObject).bhr();
                b.c(localn.lzn).remove(localObject);
              }
              AppMethodBeat.o(131369);
              return;
            }
            Log.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "postLoadInMainThread, onBitmapLoaded bmp %s", new Object[] { localObject });
            localn.G((Bitmap)localObject);
            AppMethodBeat.o(131369);
          }
        });
        AppMethodBeat.o(131379);
        return;
      }
    }
    
    /* Error */
    static void a(b.q paramq, Map<String, String> paramMap, b.i parami)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 4
      //   3: ldc 139
      //   5: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: aload_0
      //   9: aload_1
      //   10: invokevirtual 143	com/tencent/mm/modelappbrand/a/b$q:w	(Ljava/util/Map;)Ljava/io/InputStream;
      //   13: astore 5
      //   15: aload 5
      //   17: ifnull +211 -> 228
      //   20: aload_2
      //   21: aload_0
      //   22: getfield 146	com/tencent/mm/modelappbrand/a/b$q:lzC	Ljava/lang/String;
      //   25: invokeinterface 152 2 0
      //   30: astore 6
      //   32: aload 6
      //   34: ifnull +60 -> 94
      //   37: aload 5
      //   39: aload 6
      //   41: sipush 16384
      //   44: invokestatic 157	org/apache/commons/a/d:a	(Ljava/io/InputStream;Ljava/io/OutputStream;I)J
      //   47: pop2
      //   48: aload 6
      //   50: invokevirtual 162	java/io/OutputStream:flush	()V
      //   53: ldc 98
      //   55: ldc 164
      //   57: iconst_1
      //   58: anewarray 4	java/lang/Object
      //   61: dup
      //   62: iconst_0
      //   63: aload_0
      //   64: aastore
      //   65: invokestatic 166	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   68: aload 6
      //   70: ifnull +8 -> 78
      //   73: aload 6
      //   75: invokevirtual 169	java/io/OutputStream:close	()V
      //   78: aload 5
      //   80: ifnull +185 -> 265
      //   83: aload 5
      //   85: invokevirtual 172	java/io/InputStream:close	()V
      //   88: ldc 139
      //   90: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   93: return
      //   94: ldc 98
      //   96: ldc 174
      //   98: iconst_1
      //   99: anewarray 4	java/lang/Object
      //   102: dup
      //   103: iconst_0
      //   104: aload_0
      //   105: aastore
      //   106: invokestatic 177	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   109: goto -41 -> 68
      //   112: astore_3
      //   113: ldc 139
      //   115: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   118: aload_3
      //   119: athrow
      //   120: astore_1
      //   121: aload 6
      //   123: ifnull +12 -> 135
      //   126: aload_3
      //   127: ifnull +93 -> 220
      //   130: aload 6
      //   132: invokevirtual 169	java/io/OutputStream:close	()V
      //   135: ldc 139
      //   137: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   140: aload_1
      //   141: athrow
      //   142: astore_3
      //   143: ldc 139
      //   145: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   148: aload_3
      //   149: athrow
      //   150: astore_1
      //   151: aload 5
      //   153: ifnull +12 -> 165
      //   156: aload_3
      //   157: ifnull +100 -> 257
      //   160: aload 5
      //   162: invokevirtual 172	java/io/InputStream:close	()V
      //   165: ldc 139
      //   167: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   170: aload_1
      //   171: athrow
      //   172: astore_1
      //   173: ldc 98
      //   175: ldc 179
      //   177: iconst_2
      //   178: anewarray 4	java/lang/Object
      //   181: dup
      //   182: iconst_0
      //   183: aload_0
      //   184: aastore
      //   185: dup
      //   186: iconst_1
      //   187: aload_1
      //   188: aastore
      //   189: invokestatic 177	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   192: aload_2
      //   193: aload_0
      //   194: getfield 146	com/tencent/mm/modelappbrand/a/b$q:lzC	Ljava/lang/String;
      //   197: invokeinterface 183 2 0
      //   202: pop
      //   203: ldc 139
      //   205: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   208: return
      //   209: astore 6
      //   211: aload_3
      //   212: aload 6
      //   214: invokevirtual 187	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
      //   217: goto -82 -> 135
      //   220: aload 6
      //   222: invokevirtual 169	java/io/OutputStream:close	()V
      //   225: goto -90 -> 135
      //   228: ldc 98
      //   230: ldc 189
      //   232: iconst_1
      //   233: anewarray 4	java/lang/Object
      //   236: dup
      //   237: iconst_0
      //   238: aload_0
      //   239: aastore
      //   240: invokestatic 177	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   243: goto -165 -> 78
      //   246: astore 4
      //   248: aload_3
      //   249: aload 4
      //   251: invokevirtual 187	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
      //   254: goto -89 -> 165
      //   257: aload 5
      //   259: invokevirtual 172	java/io/InputStream:close	()V
      //   262: goto -97 -> 165
      //   265: ldc 139
      //   267: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   270: return
      //   271: astore_1
      //   272: aconst_null
      //   273: astore_3
      //   274: goto -153 -> 121
      //   277: astore_1
      //   278: aload 4
      //   280: astore_3
      //   281: goto -130 -> 151
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	284	0	paramq	b.q
      //   0	284	1	paramMap	Map<String, String>
      //   0	284	2	parami	b.i
      //   112	15	3	localThrowable1	Throwable
      //   142	107	3	localThrowable2	Throwable
      //   273	8	3	localThrowable3	Throwable
      //   1	1	4	localObject	Object
      //   246	33	4	localThrowable4	Throwable
      //   13	245	5	localInputStream	InputStream
      //   30	101	6	localOutputStream	OutputStream
      //   209	12	6	localThrowable5	Throwable
      // Exception table:
      //   from	to	target	type
      //   37	68	112	java/lang/Throwable
      //   94	109	112	java/lang/Throwable
      //   113	120	120	finally
      //   20	32	142	java/lang/Throwable
      //   73	78	142	java/lang/Throwable
      //   135	142	142	java/lang/Throwable
      //   211	217	142	java/lang/Throwable
      //   220	225	142	java/lang/Throwable
      //   228	243	142	java/lang/Throwable
      //   143	150	150	finally
      //   8	15	172	java/io/IOException
      //   83	93	172	java/io/IOException
      //   160	165	172	java/io/IOException
      //   165	172	172	java/io/IOException
      //   248	254	172	java/io/IOException
      //   257	262	172	java/io/IOException
      //   130	135	209	java/lang/Throwable
      //   160	165	246	java/lang/Throwable
      //   37	68	271	finally
      //   94	109	271	finally
      //   20	32	277	finally
      //   73	78	277	finally
      //   130	135	277	finally
      //   135	142	277	finally
      //   211	217	277	finally
      //   220	225	277	finally
      //   228	243	277	finally
    }
    
    private Bitmap bhw()
    {
      Object localObject1 = null;
      AppMethodBeat.i(131380);
      if (!b.bhk())
      {
        Log.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, sdcard unavailable");
        localObject1 = new d.c();
        AppMethodBeat.o(131380);
        throw ((Throwable)localObject1);
      }
      Object localObject2 = this.lyQ.Tf(this.lzq.lzC);
      if (localObject2 == null)
      {
        Log.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, null from disk, tryDownload %b", new Object[] { Boolean.valueOf(this.lzv) });
        if (this.lzv) {
          com.tencent.e.h.ZvG.be(new com.tencent.e.i.h()
          {
            public final String getKey()
            {
              return "AppBrandSimpleImageLoaderDownloadThread";
            }
            
            public final void run()
            {
              AppMethodBeat.i(131371);
              b.n.a(b.n.this.lzq, b.n.this.mHeaders, b.n.this.lyQ);
              b.a(b.n.this.lzn).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(131370);
                  b.n.this.lzv = false;
                  b.n.this.bhv();
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
        localObject2 = v((InputStream)localObject2);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("Luggage.AppBrandSimpleImageLoader.LoadTask", localException, " decode ", new Object[0]);
        }
        Log.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, decode failed, bmp %s", new Object[] { localObject1 });
        localObject1 = new d.a();
        AppMethodBeat.o(131380);
        throw ((Throwable)localObject1);
      }
      if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
      {
        Log.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, decoded bmp %s, size %d KB, url %s", new Object[] { localObject1, Integer.valueOf(androidx.core.graphics.a.c((Bitmap)localObject1) / 1024), this.lzq });
        AppMethodBeat.o(131380);
        return localObject1;
        b.a(this.lzn).Tl(this.lzq.lzC);
        b.a(this.lzn).Tk(this.lzq.lzC);
        localObject1 = new d.b();
        AppMethodBeat.o(131380);
        throw ((Throwable)localObject1);
      }
      label264:
      AppMethodBeat.o(131380);
      return null;
    }
    
    private Bitmap v(InputStream paramInputStream)
    {
      AppMethodBeat.i(131381);
      try
      {
        if (this.lzt != null)
        {
          localBitmap = this.lzt.u(paramInputStream);
          return localBitmap;
        }
        Bitmap localBitmap = b.bhl().decodeStream(paramInputStream);
        return localBitmap;
      }
      finally
      {
        Util.qualityClose(paramInputStream);
        AppMethodBeat.o(131381);
      }
    }
    
    final void G(Bitmap paramBitmap)
    {
      AppMethodBeat.i(131377);
      b.k localk = (b.k)b.d(this.lzn).remove(bht());
      if (localk != null)
      {
        localk.G(paramBitmap);
        b.c(this.lzn).remove(localk);
      }
      AppMethodBeat.o(131377);
    }
    
    public final void bho()
    {
      AppMethodBeat.i(131375);
      final Bitmap localBitmap = this.lzs.LI(bhu());
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        Log.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "before actually doIOJob, same keyForMemory bitmap already exists, key %s", new Object[] { bhu() });
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(131367);
            b.n.this.G(localBitmap);
            AppMethodBeat.o(131367);
          }
        });
        AppMethodBeat.o(131375);
        return;
      }
      if (b.a(this.lzn).Ti(this.lzq.lzC))
      {
        b.a(this.lzn).a(this.lzq.lzC, this);
        Log.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "already has job processing, make this job pending, key %s", new Object[] { this.lzq.lzC });
        AppMethodBeat.o(131375);
        return;
      }
      b.a(this.lzn).Tj(this.lzq.lzC);
      bhv();
      AppMethodBeat.o(131375);
    }
    
    public final void bhp()
    {
      AppMethodBeat.i(131376);
      b.k localk = (b.k)b.d(this.lzn).remove(bht());
      if (localk != null) {
        b.c(this.lzn).remove(localk);
      }
      AppMethodBeat.o(131376);
    }
    
    final String bht()
    {
      AppMethodBeat.i(131372);
      String str = b.bd(this.lzu, bhu());
      AppMethodBeat.o(131372);
      return str;
    }
    
    final String bhu()
    {
      AppMethodBeat.i(131373);
      String str = b.b(this.lzq.toString(), this.lzr, this.lzt);
      AppMethodBeat.o(131373);
      return str;
    }
    
    final void bhv()
    {
      AppMethodBeat.i(131374);
      try
      {
        Bitmap localBitmap = bhw();
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          b.a(this.lzn).Tk(this.lzq.lzC);
          b.a(this.lzn).b(this.lzq.lzC, this);
          J(localBitmap);
          b.a(this.lzn).Th(this.lzq.lzC);
        }
        AppMethodBeat.o(131374);
        return;
      }
      catch (d locald)
      {
        Log.d("Luggage.AppBrandSimpleImageLoader.LoadTask", " doIOJobImpl, exp %s", new Object[] { locald });
        b.a(this.lzn).Tk(this.lzq.lzC);
        b.a(this.lzn).Tl(this.lzq.lzC);
        J(null);
        if ((locald instanceof d.a)) {
          b.b(this.lzn).ho(this.lzq.lzC);
        }
        AppMethodBeat.o(131374);
        return;
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("Luggage.AppBrandSimpleImageLoader.LoadTask", localIOException, " doIOJobImpl, io exp ", new Object[0]);
        b.a(this.lzn).Tk(this.lzq.lzC);
        b.a(this.lzn).b(this.lzq.lzC, this);
        b.a(this.lzn).Th(this.lzq.lzC);
        if ((localIOException instanceof FileNotFoundException)) {
          J(null);
        }
        AppMethodBeat.o(131374);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b
 * JD-Core Version:    0.7.0.1
 */