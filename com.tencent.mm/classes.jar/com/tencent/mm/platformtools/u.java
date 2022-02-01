package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.be.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.Future;
import junit.framework.Assert;

public final class u
{
  private static Vector<WeakReference<u.a>> hUn;
  private static LinkedList<u.a> hUo;
  
  static
  {
    AppMethodBeat.i(151414);
    hUn = new Vector();
    hUo = new LinkedList();
    AppMethodBeat.o(151414);
  }
  
  public static Bitmap BA(String paramString)
  {
    AppMethodBeat.i(151408);
    paramString = b.BA(paramString);
    AppMethodBeat.o(151408);
    return paramString;
  }
  
  public static Bitmap BB(String paramString)
  {
    AppMethodBeat.i(151410);
    paramString = b.BB(paramString);
    AppMethodBeat.o(151410);
    return paramString;
  }
  
  public static Bitmap a(s params)
  {
    AppMethodBeat.i(151407);
    if (!b(params))
    {
      AppMethodBeat.o(151407);
      return null;
    }
    e locale = g.afB();
    if (locale.gdl == null) {
      locale.gdl = Boolean.valueOf(locale.isSDCardAvailable());
    }
    while (!locale.gdl.booleanValue())
    {
      params = params.aGD();
      AppMethodBeat.o(151407);
      return params;
      long l = System.currentTimeMillis() - locale.gdn;
      if ((l <= 0L) || (l >= 1000L))
      {
        e.a locala = locale.gdm;
        if ((locala.daz != null) && (!locala.daz.isDone())) {
          locala.daz.cancel(false);
        }
        h.Iye.q(locale.gdm, 1000L);
        locale.gdn = System.currentTimeMillis();
      }
    }
    if (params.aGC())
    {
      params = b.a(b.hUp, params);
      AppMethodBeat.o(151407);
      return params;
    }
    params = b.b(b.hUp, params);
    AppMethodBeat.o(151407);
    return params;
  }
  
  public static boolean a(u.a parama)
  {
    AppMethodBeat.i(151404);
    boolean bool = hUn.add(new WeakReference(parama));
    AppMethodBeat.o(151404);
    return bool;
  }
  
  private static boolean b(s params)
  {
    AppMethodBeat.i(151411);
    if ((params == null) || (bt.isNullOrNil(params.aGz())))
    {
      AppMethodBeat.o(151411);
      return false;
    }
    AppMethodBeat.o(151411);
    return true;
  }
  
  public static boolean b(u.a parama)
  {
    AppMethodBeat.i(151405);
    hUo.remove(parama);
    boolean bool = hUo.add(parama);
    AppMethodBeat.o(151405);
    return bool;
  }
  
  public static boolean c(u.a parama)
  {
    AppMethodBeat.i(151406);
    boolean bool = hUo.remove(parama);
    AppMethodBeat.o(151406);
    return bool;
  }
  
  public static Bitmap w(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(151409);
    paramString = b.w(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(151409);
    return paramString;
  }
  
  static enum b
  {
    private static DisplayMetrics hUu;
    private Map<String, u.b.c> hUq;
    private Map<String, WeakReference<Bitmap>> hUr;
    private be hUs;
    private be hUt;
    
    static
    {
      AppMethodBeat.i(151403);
      hUp = new b("INSTANCE");
      hUv = new b[] { hUp };
      hUu = null;
      AppMethodBeat.o(151403);
    }
    
    private b()
    {
      AppMethodBeat.i(151391);
      this.hUq = new HashMap();
      this.hUr = new HashMap();
      this.hUs = null;
      this.hUt = null;
      AppMethodBeat.o(151391);
    }
    
    public static Bitmap BA(String paramString)
    {
      AppMethodBeat.i(151397);
      DisplayMetrics localDisplayMetrics = aGH();
      paramString = w(paramString, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
      AppMethodBeat.o(151397);
      return paramString;
    }
    
    public static Bitmap BB(String paramString)
    {
      AppMethodBeat.i(151398);
      if (bt.isNullOrNil(paramString))
      {
        ad.w("MicroMsg.MMPictureLogic", "error input, path is null");
        AppMethodBeat.o(151398);
        return null;
      }
      paramString = f.aF(paramString, 0, 0);
      AppMethodBeat.o(151398);
      return paramString;
    }
    
    private static DisplayMetrics aGH()
    {
      AppMethodBeat.i(151395);
      if (hUu == null) {
        hUu = aj.getContext().getResources().getDisplayMetrics();
      }
      DisplayMetrics localDisplayMetrics = hUu;
      AppMethodBeat.o(151395);
      return localDisplayMetrics;
    }
    
    private void b(s params, Bitmap paramBitmap)
    {
      AppMethodBeat.i(151394);
      Assert.assertTrue("picture strategy here must be validity", u.c(params));
      String str = params.getCacheKey();
      if (this.hUr.containsKey(str)) {}
      for (params = (Bitmap)((WeakReference)this.hUr.get(str)).get();; params = null)
      {
        if ((params == null) || (params.isRecycled()))
        {
          this.hUr.remove(str);
          this.hUr.put(str, new WeakReference(paramBitmap));
        }
        AppMethodBeat.o(151394);
        return;
      }
    }
    
    private Bitmap d(s params)
    {
      AppMethodBeat.i(151392);
      Assert.assertTrue("picture strategy here must be validity", u.c(params));
      String str = params.aGz();
      u.b.c localc = (u.b.c)this.hUq.get(str);
      Object localObject = localc;
      if (localc == null) {
        localObject = new u.b.c();
      }
      if (((u.b.c)localObject).hUy) {
        if (((u.b.c)localObject).hUz >= 3)
        {
          if (bt.lZ(((u.b.c)localObject).hUA) < 120L)
          {
            ad.w("MicroMsg.MMPictureLogic", "download fail interval less than %d s for %s", new Object[] { Integer.valueOf(120), str });
            AppMethodBeat.o(151392);
            return null;
          }
          ((u.b.c)localObject).hUz = 0;
          ((u.b.c)localObject).hUy = false;
          ((u.b.c)localObject).hUA = ((int)bt.aGK());
          this.hUq.put(str, localObject);
          label143:
          if (!params.aGB()) {
            break label369;
          }
          localObject = params.aGx();
          if (localObject == null) {
            break label300;
          }
        }
      }
      label300:
      for (localObject = ((s.b)localObject).By(params.aGy());; localObject = BA(params.aGy()))
      {
        if (localObject == null) {
          break label313;
        }
        params = a(params, (Bitmap)localObject);
        this.hUq.remove(str);
        AppMethodBeat.o(151392);
        return params;
        ((u.b.c)localObject).hUz += 1;
        break;
        if (bt.lZ(((u.b.c)localObject).hUA) < 120L)
        {
          ad.d("MicroMsg.MMPictureLogic", "downloading interval less than %d s for %s", new Object[] { Integer.valueOf(120), str });
          AppMethodBeat.o(151392);
          return null;
        }
        ((u.b.c)localObject).hUz += 1;
        ((u.b.c)localObject).hUA = ((int)bt.aGK());
        this.hUq.put(str, localObject);
        break label143;
      }
      label313:
      if ((this.hUs == null) || (this.hUs.eGm())) {
        this.hUs = new be(1, "readerapp-pic-logic-download", 3);
      }
      this.hUs.c(new a(params));
      AppMethodBeat.o(151392);
      return null;
      label369:
      if ((this.hUt == null) || (this.hUt.eGm())) {
        this.hUt = new be(1, "readerapp-pic-logic-reader", 1);
      }
      this.hUt.c(new b(params));
      AppMethodBeat.o(151392);
      return null;
    }
    
    public static Bitmap w(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(151396);
      if (bt.isNullOrNil(paramString))
      {
        ad.w("MicroMsg.MMPictureLogic", "error input, path is null");
        AppMethodBeat.o(151396);
        return null;
      }
      if ((paramInt1 <= 0) || (paramInt2 <= 0))
      {
        ad.w("MicroMsg.MMPictureLogic", "error input, targetWidth %d, targetHeight %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(151396);
        return null;
      }
      paramString = f.aF(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(151396);
      return paramString;
    }
    
    protected final Bitmap a(s params, Bitmap paramBitmap)
    {
      AppMethodBeat.i(151393);
      Assert.assertTrue("picture strategy here must be validity", u.c(params));
      Bitmap localBitmap;
      if (paramBitmap != null)
      {
        localBitmap = params.a(paramBitmap, s.a.hUl, params.aGy());
        if ((localBitmap != paramBitmap) && (!paramBitmap.isRecycled()))
        {
          ad.i("MicroMsg.MMPictureLogic", "recycle bitmap:%s", new Object[] { paramBitmap.toString() });
          paramBitmap.recycle();
        }
        b(params, localBitmap);
      }
      for (params = localBitmap;; params = paramBitmap)
      {
        AppMethodBeat.o(151393);
        return params;
        params.a(s.a.hUl, null);
      }
    }
    
    static final class a
      implements be.a
    {
      private Bitmap gTB;
      private int hUw;
      private s hUx;
      
      public a(s params)
      {
        AppMethodBeat.i(151382);
        this.hUw = 0;
        this.gTB = null;
        if (!u.c(params))
        {
          params = new IllegalArgumentException("from net, picture strategy here must be validity");
          AppMethodBeat.o(151382);
          throw params;
        }
        this.hUx = params;
        AppMethodBeat.o(151382);
      }
      
      /* Error */
      public final boolean aus()
      {
        // Byte code:
        //   0: ldc 58
        //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: getfield 50	com/tencent/mm/platformtools/u$b$a:hUx	Lcom/tencent/mm/platformtools/s;
        //   9: ifnonnull +17 -> 26
        //   12: ldc 60
        //   14: ldc 62
        //   16: invokestatic 68	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   19: ldc 58
        //   21: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   24: iconst_1
        //   25: ireturn
        //   26: aload_0
        //   27: getfield 50	com/tencent/mm/platformtools/u$b$a:hUx	Lcom/tencent/mm/platformtools/s;
        //   30: invokeinterface 73 1 0
        //   35: new 75	com/tencent/mm/vfs/e
        //   38: dup
        //   39: aload_0
        //   40: getfield 50	com/tencent/mm/platformtools/u$b$a:hUx	Lcom/tencent/mm/platformtools/s;
        //   43: invokeinterface 79 1 0
        //   48: invokespecial 80	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
        //   51: astore 4
        //   53: new 82	java/lang/StringBuilder
        //   56: dup
        //   57: invokespecial 83	java/lang/StringBuilder:<init>	()V
        //   60: aload 4
        //   62: invokevirtual 87	com/tencent/mm/vfs/e:fhU	()Landroid/net/Uri;
        //   65: invokestatic 93	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
        //   68: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   71: ldc 99
        //   73: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   76: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   79: iconst_0
        //   80: invokestatic 108	com/tencent/mm/vfs/i:cM	(Ljava/lang/String;Z)Ljava/io/OutputStream;
        //   83: astore_2
        //   84: aload_0
        //   85: getfield 50	com/tencent/mm/platformtools/u$b$a:hUx	Lcom/tencent/mm/platformtools/s;
        //   88: invokeinterface 111 1 0
        //   93: aconst_null
        //   94: invokestatic 116	com/tencent/mm/network/b:a	(Ljava/lang/String;Lcom/tencent/mm/network/b$b;)Lcom/tencent/mm/network/v;
        //   97: astore 5
        //   99: invokestatic 121	com/tencent/mm/aw/q:ayM	()Z
        //   102: ifeq +46 -> 148
        //   105: aload_0
        //   106: getfield 50	com/tencent/mm/platformtools/u$b$a:hUx	Lcom/tencent/mm/platformtools/s;
        //   109: invokeinterface 111 1 0
        //   114: invokestatic 125	com/tencent/mm/aw/q:dK	(Ljava/lang/String;)Z
        //   117: ifeq +31 -> 148
        //   120: getstatic 130	com/tencent/mm/protocal/d:CpK	I
        //   123: invokestatic 134	com/tencent/mm/aw/q:om	(I)Ljava/lang/String;
        //   126: astore_3
        //   127: ldc 60
        //   129: ldc 136
        //   131: iconst_1
        //   132: anewarray 4	java/lang/Object
        //   135: dup
        //   136: iconst_0
        //   137: aload_3
        //   138: aastore
        //   139: invokestatic 140	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   142: aload 5
        //   144: aload_3
        //   145: invokevirtual 145	com/tencent/mm/network/v:Bc	(Ljava/lang/String;)V
        //   148: aload 5
        //   150: sipush 10000
        //   153: invokevirtual 148	com/tencent/mm/network/v:setConnectTimeout	(I)V
        //   156: aload 5
        //   158: sipush 20000
        //   161: invokevirtual 151	com/tencent/mm/network/v:setReadTimeout	(I)V
        //   164: aload 5
        //   166: ldc 153
        //   168: invokevirtual 156	com/tencent/mm/network/v:setRequestMethod	(Ljava/lang/String;)V
        //   171: aload 5
        //   173: invokestatic 159	com/tencent/mm/network/b:a	(Lcom/tencent/mm/network/w;)I
        //   176: ifne +923 -> 1099
        //   179: aload 5
        //   181: invokevirtual 163	com/tencent/mm/network/v:getInputStream	()Ljava/io/InputStream;
        //   184: astore_3
        //   185: aload_3
        //   186: astore 7
        //   188: aload_2
        //   189: astore 6
        //   191: aload 5
        //   193: getfield 167	com/tencent/mm/network/v:connection	Ljava/net/HttpURLConnection;
        //   196: invokevirtual 172	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
        //   199: astore 5
        //   201: aload_3
        //   202: astore 7
        //   204: aload_2
        //   205: astore 6
        //   207: ldc 60
        //   209: ldc 174
        //   211: iconst_1
        //   212: anewarray 4	java/lang/Object
        //   215: dup
        //   216: iconst_0
        //   217: aload 5
        //   219: aastore
        //   220: invokestatic 140	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   223: aload_3
        //   224: ifnonnull +117 -> 341
        //   227: aload_3
        //   228: astore 7
        //   230: aload_2
        //   231: astore 6
        //   233: ldc 60
        //   235: ldc 176
        //   237: iconst_1
        //   238: anewarray 4	java/lang/Object
        //   241: dup
        //   242: iconst_0
        //   243: aload_0
        //   244: getfield 50	com/tencent/mm/platformtools/u$b$a:hUx	Lcom/tencent/mm/platformtools/s;
        //   247: invokeinterface 111 1 0
        //   252: aastore
        //   253: invokestatic 179	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   256: aload_3
        //   257: astore 7
        //   259: aload_2
        //   260: astore 6
        //   262: aload_0
        //   263: getfield 50	com/tencent/mm/platformtools/u$b$a:hUx	Lcom/tencent/mm/platformtools/s;
        //   266: aload 5
        //   268: iconst_0
        //   269: invokeinterface 183 3 0
        //   274: aload_3
        //   275: ifnull +7 -> 282
        //   278: aload_3
        //   279: invokevirtual 188	java/io/InputStream:close	()V
        //   282: aload_2
        //   283: ifnull +7 -> 290
        //   286: aload_2
        //   287: invokevirtual 191	java/io/OutputStream:close	()V
        //   290: ldc 58
        //   292: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   295: iconst_1
        //   296: ireturn
        //   297: astore_3
        //   298: ldc 60
        //   300: ldc 193
        //   302: iconst_1
        //   303: anewarray 4	java/lang/Object
        //   306: dup
        //   307: iconst_0
        //   308: aload_3
        //   309: invokestatic 199	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   312: aastore
        //   313: invokestatic 201	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   316: goto -34 -> 282
        //   319: astore_2
        //   320: ldc 60
        //   322: ldc 193
        //   324: iconst_1
        //   325: anewarray 4	java/lang/Object
        //   328: dup
        //   329: iconst_0
        //   330: aload_2
        //   331: invokestatic 199	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   334: aastore
        //   335: invokestatic 201	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   338: goto -48 -> 290
        //   341: aload_3
        //   342: astore 7
        //   344: aload_2
        //   345: astore 6
        //   347: sipush 1024
        //   350: newarray byte
        //   352: astore 8
        //   354: aload_3
        //   355: astore 7
        //   357: aload_2
        //   358: astore 6
        //   360: aload_3
        //   361: aload 8
        //   363: invokevirtual 205	java/io/InputStream:read	([B)I
        //   366: istore_1
        //   367: iload_1
        //   368: iconst_m1
        //   369: if_icmpeq +133 -> 502
        //   372: aload_3
        //   373: astore 7
        //   375: aload_2
        //   376: astore 6
        //   378: aload_0
        //   379: aload_0
        //   380: getfield 32	com/tencent/mm/platformtools/u$b$a:hUw	I
        //   383: iload_1
        //   384: iadd
        //   385: putfield 32	com/tencent/mm/platformtools/u$b$a:hUw	I
        //   388: aload_3
        //   389: astore 7
        //   391: aload_2
        //   392: astore 6
        //   394: aload_2
        //   395: aload 8
        //   397: iconst_0
        //   398: iload_1
        //   399: invokevirtual 209	java/io/OutputStream:write	([BII)V
        //   402: goto -48 -> 354
        //   405: astore 4
        //   407: aload_3
        //   408: astore 7
        //   410: aload_2
        //   411: astore 6
        //   413: ldc 60
        //   415: ldc 193
        //   417: iconst_1
        //   418: anewarray 4	java/lang/Object
        //   421: dup
        //   422: iconst_0
        //   423: aload 4
        //   425: invokestatic 199	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   428: aastore
        //   429: invokestatic 201	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   432: aload_3
        //   433: astore 7
        //   435: aload_2
        //   436: astore 6
        //   438: ldc 60
        //   440: ldc 211
        //   442: iconst_1
        //   443: anewarray 4	java/lang/Object
        //   446: dup
        //   447: iconst_0
        //   448: aload_0
        //   449: getfield 50	com/tencent/mm/platformtools/u$b$a:hUx	Lcom/tencent/mm/platformtools/s;
        //   452: invokeinterface 111 1 0
        //   457: aastore
        //   458: invokestatic 179	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   461: aload_3
        //   462: astore 7
        //   464: aload_2
        //   465: astore 6
        //   467: aload_0
        //   468: getfield 50	com/tencent/mm/platformtools/u$b$a:hUx	Lcom/tencent/mm/platformtools/s;
        //   471: aload 5
        //   473: iconst_0
        //   474: invokeinterface 183 3 0
        //   479: aload_3
        //   480: ifnull +7 -> 487
        //   483: aload_3
        //   484: invokevirtual 188	java/io/InputStream:close	()V
        //   487: aload_2
        //   488: ifnull +7 -> 495
        //   491: aload_2
        //   492: invokevirtual 191	java/io/OutputStream:close	()V
        //   495: ldc 58
        //   497: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   500: iconst_1
        //   501: ireturn
        //   502: aload_3
        //   503: astore 7
        //   505: aload_2
        //   506: astore 6
        //   508: ldc 60
        //   510: ldc 213
        //   512: iconst_2
        //   513: anewarray 4	java/lang/Object
        //   516: dup
        //   517: iconst_0
        //   518: aload_0
        //   519: getfield 50	com/tencent/mm/platformtools/u$b$a:hUx	Lcom/tencent/mm/platformtools/s;
        //   522: invokeinterface 111 1 0
        //   527: aastore
        //   528: dup
        //   529: iconst_1
        //   530: aload_0
        //   531: getfield 32	com/tencent/mm/platformtools/u$b$a:hUw	I
        //   534: invokestatic 219	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   537: aastore
        //   538: invokestatic 221	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   541: aload_3
        //   542: astore 7
        //   544: aload_2
        //   545: astore 6
        //   547: aload_0
        //   548: getfield 50	com/tencent/mm/platformtools/u$b$a:hUx	Lcom/tencent/mm/platformtools/s;
        //   551: aload 5
        //   553: iconst_1
        //   554: invokeinterface 183 3 0
        //   559: aload_3
        //   560: ifnull +7 -> 567
        //   563: aload_3
        //   564: invokevirtual 188	java/io/InputStream:close	()V
        //   567: aload_2
        //   568: ifnull +7 -> 575
        //   571: aload_2
        //   572: invokevirtual 191	java/io/OutputStream:close	()V
        //   575: new 82	java/lang/StringBuilder
        //   578: dup
        //   579: invokespecial 83	java/lang/StringBuilder:<init>	()V
        //   582: aload 4
        //   584: invokevirtual 87	com/tencent/mm/vfs/e:fhU	()Landroid/net/Uri;
        //   587: invokestatic 93	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
        //   590: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   593: ldc 99
        //   595: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   598: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   601: invokestatic 225	com/tencent/mm/vfs/i:aEN	(Ljava/lang/String;)Ljava/lang/String;
        //   604: pop
        //   605: aload_0
        //   606: getfield 50	com/tencent/mm/platformtools/u$b$a:hUx	Lcom/tencent/mm/platformtools/s;
        //   609: invokeinterface 229 1 0
        //   614: astore_2
        //   615: aload_2
        //   616: ifnull +339 -> 955
        //   619: aload_2
        //   620: new 82	java/lang/StringBuilder
        //   623: dup
        //   624: invokespecial 83	java/lang/StringBuilder:<init>	()V
        //   627: aload 4
        //   629: invokevirtual 87	com/tencent/mm/vfs/e:fhU	()Landroid/net/Uri;
        //   632: invokestatic 93	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
        //   635: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   638: ldc 99
        //   640: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   643: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   646: invokeinterface 235 2 0
        //   651: astore_3
        //   652: aload_3
        //   653: ifnull +335 -> 988
        //   656: aload_0
        //   657: getfield 50	com/tencent/mm/platformtools/u$b$a:hUx	Lcom/tencent/mm/platformtools/s;
        //   660: aload_3
        //   661: getstatic 241	com/tencent/mm/platformtools/s$a:hUk	Lcom/tencent/mm/platformtools/s$a;
        //   664: new 82	java/lang/StringBuilder
        //   667: dup
        //   668: invokespecial 83	java/lang/StringBuilder:<init>	()V
        //   671: aload 4
        //   673: invokevirtual 87	com/tencent/mm/vfs/e:fhU	()Landroid/net/Uri;
        //   676: invokestatic 93	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
        //   679: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   682: ldc 99
        //   684: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   687: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   690: invokeinterface 244 4 0
        //   695: astore_2
        //   696: aload_2
        //   697: aload_3
        //   698: if_acmpeq +32 -> 730
        //   701: aload_3
        //   702: invokevirtual 249	android/graphics/Bitmap:isRecycled	()Z
        //   705: ifne +25 -> 730
        //   708: ldc 60
        //   710: ldc 251
        //   712: iconst_1
        //   713: anewarray 4	java/lang/Object
        //   716: dup
        //   717: iconst_0
        //   718: aload_3
        //   719: invokevirtual 252	java/lang/Object:toString	()Ljava/lang/String;
        //   722: aastore
        //   723: invokestatic 221	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   726: aload_3
        //   727: invokevirtual 255	android/graphics/Bitmap:recycle	()V
        //   730: getstatic 259	com/tencent/mm/platformtools/u$b:hUp	Lcom/tencent/mm/platformtools/u$b;
        //   733: aload_0
        //   734: getfield 50	com/tencent/mm/platformtools/u$b$a:hUx	Lcom/tencent/mm/platformtools/s;
        //   737: aload_2
        //   738: invokestatic 262	com/tencent/mm/platformtools/u$b:a	(Lcom/tencent/mm/platformtools/u$b;Lcom/tencent/mm/platformtools/s;Landroid/graphics/Bitmap;)V
        //   741: new 75	com/tencent/mm/vfs/e
        //   744: dup
        //   745: new 82	java/lang/StringBuilder
        //   748: dup
        //   749: invokespecial 83	java/lang/StringBuilder:<init>	()V
        //   752: aload 4
        //   754: invokevirtual 87	com/tencent/mm/vfs/e:fhU	()Landroid/net/Uri;
        //   757: invokestatic 93	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
        //   760: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   763: ldc 99
        //   765: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   768: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   771: invokespecial 80	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
        //   774: invokevirtual 265	com/tencent/mm/vfs/e:delete	()Z
        //   777: pop
        //   778: aload_0
        //   779: aload_2
        //   780: putfield 34	com/tencent/mm/platformtools/u$b$a:gTB	Landroid/graphics/Bitmap;
        //   783: ldc 58
        //   785: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   788: iconst_1
        //   789: ireturn
        //   790: astore_3
        //   791: ldc 60
        //   793: ldc 193
        //   795: iconst_1
        //   796: anewarray 4	java/lang/Object
        //   799: dup
        //   800: iconst_0
        //   801: aload_3
        //   802: invokestatic 199	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   805: aastore
        //   806: invokestatic 201	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   809: goto -242 -> 567
        //   812: astore_2
        //   813: ldc 60
        //   815: ldc 193
        //   817: iconst_1
        //   818: anewarray 4	java/lang/Object
        //   821: dup
        //   822: iconst_0
        //   823: aload_2
        //   824: invokestatic 199	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   827: aastore
        //   828: invokestatic 201	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   831: goto -256 -> 575
        //   834: astore_3
        //   835: ldc 60
        //   837: ldc 193
        //   839: iconst_1
        //   840: anewarray 4	java/lang/Object
        //   843: dup
        //   844: iconst_0
        //   845: aload_3
        //   846: invokestatic 199	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   849: aastore
        //   850: invokestatic 201	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   853: goto -366 -> 487
        //   856: astore_2
        //   857: ldc 60
        //   859: ldc 193
        //   861: iconst_1
        //   862: anewarray 4	java/lang/Object
        //   865: dup
        //   866: iconst_0
        //   867: aload_2
        //   868: invokestatic 199	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   871: aastore
        //   872: invokestatic 201	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   875: goto -380 -> 495
        //   878: astore_3
        //   879: aconst_null
        //   880: astore 7
        //   882: aconst_null
        //   883: astore_2
        //   884: aload 7
        //   886: ifnull +8 -> 894
        //   889: aload 7
        //   891: invokevirtual 188	java/io/InputStream:close	()V
        //   894: aload_2
        //   895: ifnull +7 -> 902
        //   898: aload_2
        //   899: invokevirtual 191	java/io/OutputStream:close	()V
        //   902: ldc 58
        //   904: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   907: aload_3
        //   908: athrow
        //   909: astore 4
        //   911: ldc 60
        //   913: ldc 193
        //   915: iconst_1
        //   916: anewarray 4	java/lang/Object
        //   919: dup
        //   920: iconst_0
        //   921: aload 4
        //   923: invokestatic 199	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   926: aastore
        //   927: invokestatic 201	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   930: goto -36 -> 894
        //   933: astore_2
        //   934: ldc 60
        //   936: ldc 193
        //   938: iconst_1
        //   939: anewarray 4	java/lang/Object
        //   942: dup
        //   943: iconst_0
        //   944: aload_2
        //   945: invokestatic 199	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   948: aastore
        //   949: invokestatic 201	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   952: goto -50 -> 902
        //   955: new 82	java/lang/StringBuilder
        //   958: dup
        //   959: invokespecial 83	java/lang/StringBuilder:<init>	()V
        //   962: aload 4
        //   964: invokevirtual 87	com/tencent/mm/vfs/e:fhU	()Landroid/net/Uri;
        //   967: invokestatic 93	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
        //   970: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   973: ldc 99
        //   975: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   978: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   981: invokestatic 268	com/tencent/mm/platformtools/u$b:BA	(Ljava/lang/String;)Landroid/graphics/Bitmap;
        //   984: astore_3
        //   985: goto -333 -> 652
        //   988: aload_0
        //   989: getfield 50	com/tencent/mm/platformtools/u$b$a:hUx	Lcom/tencent/mm/platformtools/s;
        //   992: getstatic 241	com/tencent/mm/platformtools/s$a:hUk	Lcom/tencent/mm/platformtools/s$a;
        //   995: aload 5
        //   997: invokeinterface 271 3 0
        //   1002: aconst_null
        //   1003: astore_2
        //   1004: goto -308 -> 696
        //   1007: astore_2
        //   1008: ldc 60
        //   1010: ldc_w 273
        //   1013: iconst_1
        //   1014: anewarray 4	java/lang/Object
        //   1017: dup
        //   1018: iconst_0
        //   1019: aload_0
        //   1020: getfield 50	com/tencent/mm/platformtools/u$b$a:hUx	Lcom/tencent/mm/platformtools/s;
        //   1023: invokeinterface 111 1 0
        //   1028: aastore
        //   1029: invokestatic 179	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   1032: ldc 60
        //   1034: ldc 193
        //   1036: iconst_1
        //   1037: anewarray 4	java/lang/Object
        //   1040: dup
        //   1041: iconst_0
        //   1042: aload_2
        //   1043: invokestatic 199	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   1046: aastore
        //   1047: invokestatic 201	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   1050: aconst_null
        //   1051: astore_2
        //   1052: goto -274 -> 778
        //   1055: astore_3
        //   1056: aconst_null
        //   1057: astore 7
        //   1059: goto -175 -> 884
        //   1062: astore_3
        //   1063: aload 6
        //   1065: astore_2
        //   1066: goto -182 -> 884
        //   1069: astore 4
        //   1071: aconst_null
        //   1072: astore 5
        //   1074: aconst_null
        //   1075: astore_3
        //   1076: aconst_null
        //   1077: astore_2
        //   1078: goto -671 -> 407
        //   1081: astore 4
        //   1083: aconst_null
        //   1084: astore 5
        //   1086: aconst_null
        //   1087: astore_3
        //   1088: goto -681 -> 407
        //   1091: astore 4
        //   1093: aconst_null
        //   1094: astore 5
        //   1096: goto -689 -> 407
        //   1099: aconst_null
        //   1100: astore_3
        //   1101: goto -916 -> 185
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	1104	0	this	a
        //   366	33	1	i	int
        //   83	204	2	localOutputStream	java.io.OutputStream
        //   319	253	2	localIOException1	java.io.IOException
        //   614	166	2	localObject1	Object
        //   812	12	2	localIOException2	java.io.IOException
        //   856	12	2	localIOException3	java.io.IOException
        //   883	16	2	localObject2	Object
        //   933	12	2	localIOException4	java.io.IOException
        //   1003	1	2	localObject3	Object
        //   1007	36	2	localException1	Exception
        //   1051	27	2	localObject4	Object
        //   126	153	3	localObject5	Object
        //   297	267	3	localIOException5	java.io.IOException
        //   651	76	3	localBitmap1	Bitmap
        //   790	12	3	localIOException6	java.io.IOException
        //   834	12	3	localIOException7	java.io.IOException
        //   878	30	3	localObject6	Object
        //   984	1	3	localBitmap2	Bitmap
        //   1055	1	3	localObject7	Object
        //   1062	1	3	localObject8	Object
        //   1075	26	3	localObject9	Object
        //   51	10	4	locale	com.tencent.mm.vfs.e
        //   405	348	4	localException2	Exception
        //   909	54	4	localIOException8	java.io.IOException
        //   1069	1	4	localException3	Exception
        //   1081	1	4	localException4	Exception
        //   1091	1	4	localException5	Exception
        //   97	998	5	localObject10	Object
        //   189	875	6	localObject11	Object
        //   186	872	7	localObject12	Object
        //   352	44	8	arrayOfByte	byte[]
        // Exception table:
        //   from	to	target	type
        //   278	282	297	java/io/IOException
        //   286	290	319	java/io/IOException
        //   207	223	405	java/lang/Exception
        //   233	256	405	java/lang/Exception
        //   262	274	405	java/lang/Exception
        //   347	354	405	java/lang/Exception
        //   360	367	405	java/lang/Exception
        //   378	388	405	java/lang/Exception
        //   394	402	405	java/lang/Exception
        //   508	541	405	java/lang/Exception
        //   547	559	405	java/lang/Exception
        //   563	567	790	java/io/IOException
        //   571	575	812	java/io/IOException
        //   483	487	834	java/io/IOException
        //   491	495	856	java/io/IOException
        //   26	84	878	finally
        //   889	894	909	java/io/IOException
        //   898	902	933	java/io/IOException
        //   575	615	1007	java/lang/Exception
        //   619	652	1007	java/lang/Exception
        //   656	696	1007	java/lang/Exception
        //   701	730	1007	java/lang/Exception
        //   730	778	1007	java/lang/Exception
        //   955	985	1007	java/lang/Exception
        //   988	1002	1007	java/lang/Exception
        //   84	148	1055	finally
        //   148	185	1055	finally
        //   191	201	1062	finally
        //   207	223	1062	finally
        //   233	256	1062	finally
        //   262	274	1062	finally
        //   347	354	1062	finally
        //   360	367	1062	finally
        //   378	388	1062	finally
        //   394	402	1062	finally
        //   413	432	1062	finally
        //   438	461	1062	finally
        //   467	479	1062	finally
        //   508	541	1062	finally
        //   547	559	1062	finally
        //   26	84	1069	java/lang/Exception
        //   84	148	1081	java/lang/Exception
        //   148	185	1081	java/lang/Exception
        //   191	201	1091	java/lang/Exception
      }
      
      public final boolean aut()
      {
        AppMethodBeat.i(151384);
        try
        {
          ar.a.gMX.cZ(this.hUw, 0);
          u.b.a(u.b.hUp, this.hUx.aGz(), this.hUx.aGA(), this.gTB);
          this.gTB = null;
          AppMethodBeat.o(151384);
          return false;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[] { bt.m(localException) });
          }
        }
      }
    }
    
    static final class b
      implements be.a
    {
      public Bitmap gTB;
      private s hUx;
      
      public b(s params)
      {
        AppMethodBeat.i(151385);
        this.gTB = null;
        if (!u.c(params))
        {
          params = new IllegalArgumentException("from sdcard, picture strategy here must be validity");
          AppMethodBeat.o(151385);
          throw params;
        }
        this.hUx = params;
        AppMethodBeat.o(151385);
      }
      
      public final boolean aus()
      {
        boolean bool = false;
        AppMethodBeat.i(151386);
        this.gTB = u.b.BA(this.hUx.aGy());
        if (this.gTB != null) {
          this.gTB = u.b.hUp.a(this.hUx, this.gTB);
        }
        String str1 = this.hUx.aGz();
        String str2 = this.hUx.aGy();
        if (this.gTB != null) {
          bool = true;
        }
        ad.v("MicroMsg.MMPictureLogic", "get url[%s] from[%s] result[%B]", new Object[] { str1, str2, Boolean.valueOf(bool) });
        AppMethodBeat.o(151386);
        return true;
      }
      
      public final boolean aut()
      {
        AppMethodBeat.i(151387);
        if (this.gTB == null)
        {
          ad.d("MicroMsg.MMPictureLogic", "can not find bitmap on sdCard, url=%s, try to download it", new Object[] { this.hUx.aGz() });
          if ((u.b.a(u.b.hUp) == null) || (u.b.a(u.b.hUp).eGm())) {
            u.b.a(u.b.hUp, new be(1, "readerapp-pic-logic-download", 3));
          }
          u.b.a(u.b.hUp).c(new u.b.a(this.hUx));
        }
        for (;;)
        {
          AppMethodBeat.o(151387);
          return false;
          u.b.a(u.b.hUp, this.hUx.aGz(), this.hUx.aGA(), this.gTB);
          this.gTB = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.platformtools.u
 * JD-Core Version:    0.7.0.1
 */