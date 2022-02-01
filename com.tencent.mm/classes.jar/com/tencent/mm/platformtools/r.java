package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.f.a;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.e;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.Future;
import junit.framework.Assert;

public final class r
{
  private static Vector<WeakReference<a>> pAV;
  private static LinkedList<a> pAW;
  
  static
  {
    AppMethodBeat.i(151414);
    pAV = new Vector();
    pAW = new LinkedList();
    AppMethodBeat.o(151414);
  }
  
  public static Bitmap C(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(151409);
    paramString = b.C(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(151409);
    return paramString;
  }
  
  public static Bitmap Sg(String paramString)
  {
    AppMethodBeat.i(151408);
    paramString = b.Sg(paramString);
    AppMethodBeat.o(151408);
    return paramString;
  }
  
  public static Bitmap Sh(String paramString)
  {
    AppMethodBeat.i(151410);
    paramString = b.Sh(paramString);
    AppMethodBeat.o(151410);
    return paramString;
  }
  
  public static Bitmap a(p paramp)
  {
    AppMethodBeat.i(151407);
    if (!b(paramp))
    {
      AppMethodBeat.o(151407);
      return null;
    }
    f localf = com.tencent.mm.kernel.h.baE();
    if (localf.mCZ == null) {
      localf.mCZ = Boolean.valueOf(localf.isSDCardAvailable());
    }
    while (!localf.mCZ.booleanValue())
    {
      paramp = paramp.bTH();
      AppMethodBeat.o(151407);
      return paramp;
      long l = System.currentTimeMillis() - localf.mDc;
      if ((l <= 0L) || (l >= 1000L))
      {
        f.a locala = localf.mDa;
        if ((locala.dBj != null) && (!locala.dBj.isDone())) {
          locala.dBj.cancel(false);
        }
        com.tencent.threadpool.h.ahAA.p(localf.mDa, 1000L);
        localf.mDc = System.currentTimeMillis();
      }
    }
    if (paramp.bTG())
    {
      paramp = b.a(b.pAX, paramp);
      AppMethodBeat.o(151407);
      return paramp;
    }
    paramp = b.b(b.pAX, paramp);
    AppMethodBeat.o(151407);
    return paramp;
  }
  
  public static boolean a(a parama)
  {
    AppMethodBeat.i(151404);
    boolean bool = pAV.add(new WeakReference(parama));
    AppMethodBeat.o(151404);
    return bool;
  }
  
  private static boolean b(p paramp)
  {
    AppMethodBeat.i(151411);
    if ((paramp == null) || (Util.isNullOrNil(paramp.bTD())))
    {
      AppMethodBeat.o(151411);
      return false;
    }
    AppMethodBeat.o(151411);
    return true;
  }
  
  public static boolean b(a parama)
  {
    AppMethodBeat.i(151405);
    pAW.remove(parama);
    boolean bool = pAW.add(parama);
    AppMethodBeat.o(151405);
    return bool;
  }
  
  public static boolean c(a parama)
  {
    AppMethodBeat.i(151406);
    boolean bool = pAW.remove(parama);
    AppMethodBeat.o(151406);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract void k(String paramString, Bitmap paramBitmap);
  }
  
  static enum b
  {
    private static DisplayMetrics metrics;
    private Map<String, r.b.c> pAY;
    private Map<String, WeakReference<Bitmap>> pAZ;
    private QueueWorkerThread pBa;
    private QueueWorkerThread pBb;
    
    static
    {
      AppMethodBeat.i(151403);
      pAX = new b("INSTANCE");
      pBc = new b[] { pAX };
      metrics = null;
      AppMethodBeat.o(151403);
    }
    
    private b()
    {
      AppMethodBeat.i(151391);
      this.pAY = new HashMap();
      this.pAZ = new HashMap();
      this.pBa = null;
      this.pBb = null;
      AppMethodBeat.o(151391);
    }
    
    public static Bitmap C(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(151396);
      if (Util.isNullOrNil(paramString))
      {
        Log.w("MicroMsg.MMPictureLogic", "error input, path is null");
        AppMethodBeat.o(151396);
        return null;
      }
      if ((paramInt1 <= 0) || (paramInt2 <= 0))
      {
        Log.w("MicroMsg.MMPictureLogic", "error input, targetWidth %d, targetHeight %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(151396);
        return null;
      }
      paramString = BitmapUtil.getBitmapNative(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(151396);
      return paramString;
    }
    
    public static Bitmap Sg(String paramString)
    {
      AppMethodBeat.i(151397);
      DisplayMetrics localDisplayMetrics = getDefaultDisplayMetrics();
      paramString = C(paramString, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
      AppMethodBeat.o(151397);
      return paramString;
    }
    
    public static Bitmap Sh(String paramString)
    {
      AppMethodBeat.i(151398);
      if (Util.isNullOrNil(paramString))
      {
        Log.w("MicroMsg.MMPictureLogic", "error input, path is null");
        AppMethodBeat.o(151398);
        return null;
      }
      paramString = BitmapUtil.getBitmapNative(paramString, 0, 0);
      AppMethodBeat.o(151398);
      return paramString;
    }
    
    private void b(p paramp, Bitmap paramBitmap)
    {
      AppMethodBeat.i(151394);
      Assert.assertTrue("picture strategy here must be validity", r.c(paramp));
      String str = paramp.getCacheKey();
      if (this.pAZ.containsKey(str)) {}
      for (paramp = (Bitmap)((WeakReference)this.pAZ.get(str)).get();; paramp = null)
      {
        if ((paramp == null) || (paramp.isRecycled()))
        {
          this.pAZ.remove(str);
          this.pAZ.put(str, new WeakReference(paramBitmap));
        }
        AppMethodBeat.o(151394);
        return;
      }
    }
    
    private Bitmap d(p paramp)
    {
      AppMethodBeat.i(151392);
      Assert.assertTrue("picture strategy here must be validity", r.c(paramp));
      String str = paramp.bTD();
      r.b.c localc = (r.b.c)this.pAY.get(str);
      Object localObject = localc;
      if (localc == null) {
        localObject = new r.b.c();
      }
      if (((r.b.c)localObject).pBf) {
        if (((r.b.c)localObject).pBg >= 3)
        {
          if (Util.secondsToNow(((r.b.c)localObject).pBh) < 120L)
          {
            Log.w("MicroMsg.MMPictureLogic", "download fail interval less than %d s for %s", new Object[] { Integer.valueOf(120), str });
            AppMethodBeat.o(151392);
            return null;
          }
          ((r.b.c)localObject).pBg = 0;
          ((r.b.c)localObject).pBf = false;
          ((r.b.c)localObject).pBh = ((int)Util.nowSecond());
          this.pAY.put(str, localObject);
          label143:
          if (!paramp.bTF()) {
            break label369;
          }
          localObject = paramp.bTB();
          if (localObject == null) {
            break label300;
          }
        }
      }
      label300:
      for (localObject = ((p.b)localObject).Se(paramp.bTC());; localObject = Sg(paramp.bTC()))
      {
        if (localObject == null) {
          break label313;
        }
        paramp = a(paramp, (Bitmap)localObject);
        this.pAY.remove(str);
        AppMethodBeat.o(151392);
        return paramp;
        ((r.b.c)localObject).pBg += 1;
        break;
        if (Util.secondsToNow(((r.b.c)localObject).pBh) < 120L)
        {
          Log.d("MicroMsg.MMPictureLogic", "downloading interval less than %d s for %s", new Object[] { Integer.valueOf(120), str });
          AppMethodBeat.o(151392);
          return null;
        }
        ((r.b.c)localObject).pBg += 1;
        ((r.b.c)localObject).pBh = ((int)Util.nowSecond());
        this.pAY.put(str, localObject);
        break label143;
      }
      label313:
      if ((this.pBa == null) || (this.pBa.isDead())) {
        this.pBa = new QueueWorkerThread(1, "readerapp-pic-logic-download", 3);
      }
      this.pBa.add(new a(paramp));
      AppMethodBeat.o(151392);
      return null;
      label369:
      if ((this.pBb == null) || (this.pBb.isDead())) {
        this.pBb = new QueueWorkerThread(1, "readerapp-pic-logic-reader", 1);
      }
      this.pBb.add(new b(paramp));
      AppMethodBeat.o(151392);
      return null;
    }
    
    private static DisplayMetrics getDefaultDisplayMetrics()
    {
      AppMethodBeat.i(151395);
      if (metrics == null) {
        metrics = MMApplicationContext.getContext().getResources().getDisplayMetrics();
      }
      DisplayMetrics localDisplayMetrics = metrics;
      AppMethodBeat.o(151395);
      return localDisplayMetrics;
    }
    
    protected final Bitmap a(p paramp, Bitmap paramBitmap)
    {
      AppMethodBeat.i(151393);
      Assert.assertTrue("picture strategy here must be validity", r.c(paramp));
      Bitmap localBitmap;
      if (paramBitmap != null)
      {
        localBitmap = paramp.a(paramBitmap, p.a.pAT, paramp.bTC());
        if ((localBitmap != paramBitmap) && (!paramBitmap.isRecycled()))
        {
          Log.i("MicroMsg.MMPictureLogic", "recycle bitmap:%s", new Object[] { paramBitmap.toString() });
          paramBitmap.recycle();
        }
        b(paramp, localBitmap);
      }
      for (paramp = localBitmap;; paramp = paramBitmap)
      {
        AppMethodBeat.o(151393);
        return paramp;
        paramp.a(p.a.pAT);
      }
    }
    
    static final class a
      implements QueueWorkerThread.ThreadObject
    {
      private Bitmap orY;
      private int pBd;
      private p pBe;
      
      public a(p paramp)
      {
        AppMethodBeat.i(151382);
        this.pBd = 0;
        this.orY = null;
        if (!r.c(paramp))
        {
          paramp = new IllegalArgumentException("from net, picture strategy here must be validity");
          AppMethodBeat.o(151382);
          throw paramp;
        }
        this.pBe = paramp;
        AppMethodBeat.o(151382);
      }
      
      /* Error */
      public final boolean doInBackground()
      {
        // Byte code:
        //   0: ldc 58
        //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: getfield 50	com/tencent/mm/platformtools/r$b$a:pBe	Lcom/tencent/mm/platformtools/p;
        //   9: ifnonnull +17 -> 26
        //   12: ldc 60
        //   14: ldc 62
        //   16: invokestatic 68	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   19: ldc 58
        //   21: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   24: iconst_1
        //   25: ireturn
        //   26: aload_0
        //   27: getfield 50	com/tencent/mm/platformtools/r$b$a:pBe	Lcom/tencent/mm/platformtools/p;
        //   30: invokeinterface 73 1 0
        //   35: new 75	com/tencent/mm/vfs/u
        //   38: dup
        //   39: aload_0
        //   40: getfield 50	com/tencent/mm/platformtools/r$b$a:pBe	Lcom/tencent/mm/platformtools/p;
        //   43: invokeinterface 79 1 0
        //   48: invokespecial 80	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
        //   51: astore 6
        //   53: new 82	java/lang/StringBuilder
        //   56: dup
        //   57: invokespecial 83	java/lang/StringBuilder:<init>	()V
        //   60: aload 6
        //   62: invokevirtual 87	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
        //   65: invokestatic 93	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
        //   68: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   71: ldc 99
        //   73: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   76: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   79: iconst_0
        //   80: invokestatic 108	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
        //   83: astore_3
        //   84: aload_0
        //   85: getfield 50	com/tencent/mm/platformtools/r$b$a:pBe	Lcom/tencent/mm/platformtools/p;
        //   88: invokeinterface 111 1 0
        //   93: aconst_null
        //   94: invokestatic 116	com/tencent/mm/network/d:a	(Ljava/lang/String;Lcom/tencent/mm/network/d$b;)Lcom/tencent/mm/network/y;
        //   97: astore 7
        //   99: aload 7
        //   101: ifnull +973 -> 1074
        //   104: invokestatic 121	com/tencent/mm/modelimage/u:bKj	()Z
        //   107: ifeq +46 -> 153
        //   110: aload_0
        //   111: getfield 50	com/tencent/mm/platformtools/r$b$a:pBe	Lcom/tencent/mm/platformtools/p;
        //   114: invokeinterface 111 1 0
        //   119: invokestatic 125	com/tencent/mm/modelimage/u:hA	(Ljava/lang/String;)Z
        //   122: ifeq +31 -> 153
        //   125: getstatic 130	com/tencent/mm/protocal/d:Yxh	I
        //   128: invokestatic 134	com/tencent/mm/modelimage/u:wz	(I)Ljava/lang/String;
        //   131: astore_2
        //   132: ldc 60
        //   134: ldc 136
        //   136: iconst_1
        //   137: anewarray 4	java/lang/Object
        //   140: dup
        //   141: iconst_0
        //   142: aload_2
        //   143: aastore
        //   144: invokestatic 140	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   147: aload 7
        //   149: aload_2
        //   150: invokevirtual 145	com/tencent/mm/network/y:Ry	(Ljava/lang/String;)V
        //   153: aload 7
        //   155: sipush 10000
        //   158: invokevirtual 148	com/tencent/mm/network/y:xx	(I)V
        //   161: aload 7
        //   163: sipush 20000
        //   166: invokevirtual 151	com/tencent/mm/network/y:xy	(I)V
        //   169: aload 7
        //   171: ldc 153
        //   173: invokevirtual 156	com/tencent/mm/network/y:Rx	(Ljava/lang/String;)V
        //   176: aload 7
        //   178: invokestatic 159	com/tencent/mm/network/d:a	(Lcom/tencent/mm/network/z;)I
        //   181: ifne +888 -> 1069
        //   184: aload 7
        //   186: invokevirtual 163	com/tencent/mm/network/y:getInputStream	()Ljava/io/InputStream;
        //   189: astore_2
        //   190: aload_2
        //   191: astore 5
        //   193: aload_3
        //   194: astore 4
        //   196: ldc 60
        //   198: ldc 165
        //   200: iconst_1
        //   201: anewarray 4	java/lang/Object
        //   204: dup
        //   205: iconst_0
        //   206: aload 7
        //   208: getfield 169	com/tencent/mm/network/y:connection	Ljava/net/HttpURLConnection;
        //   211: invokevirtual 174	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
        //   214: aastore
        //   215: invokestatic 140	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   218: aload_2
        //   219: ifnonnull +114 -> 333
        //   222: aload_2
        //   223: astore 5
        //   225: aload_3
        //   226: astore 4
        //   228: ldc 60
        //   230: ldc 176
        //   232: iconst_1
        //   233: anewarray 4	java/lang/Object
        //   236: dup
        //   237: iconst_0
        //   238: aload_0
        //   239: getfield 50	com/tencent/mm/platformtools/r$b$a:pBe	Lcom/tencent/mm/platformtools/p;
        //   242: invokeinterface 111 1 0
        //   247: aastore
        //   248: invokestatic 179	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   251: aload_2
        //   252: astore 5
        //   254: aload_3
        //   255: astore 4
        //   257: aload_0
        //   258: getfield 50	com/tencent/mm/platformtools/r$b$a:pBe	Lcom/tencent/mm/platformtools/p;
        //   261: invokeinterface 182 1 0
        //   266: aload_2
        //   267: ifnull +7 -> 274
        //   270: aload_2
        //   271: invokevirtual 187	java/io/InputStream:close	()V
        //   274: aload_3
        //   275: ifnull +7 -> 282
        //   278: aload_3
        //   279: invokevirtual 190	java/io/OutputStream:close	()V
        //   282: ldc 58
        //   284: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   287: iconst_1
        //   288: ireturn
        //   289: astore_2
        //   290: ldc 60
        //   292: ldc 192
        //   294: iconst_1
        //   295: anewarray 4	java/lang/Object
        //   298: dup
        //   299: iconst_0
        //   300: aload_2
        //   301: invokestatic 198	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   304: aastore
        //   305: invokestatic 200	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   308: goto -34 -> 274
        //   311: astore_2
        //   312: ldc 60
        //   314: ldc 192
        //   316: iconst_1
        //   317: anewarray 4	java/lang/Object
        //   320: dup
        //   321: iconst_0
        //   322: aload_2
        //   323: invokestatic 198	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   326: aastore
        //   327: invokestatic 200	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   330: goto -48 -> 282
        //   333: aload_2
        //   334: astore 5
        //   336: aload_3
        //   337: astore 4
        //   339: sipush 1024
        //   342: newarray byte
        //   344: astore 7
        //   346: aload_2
        //   347: astore 5
        //   349: aload_3
        //   350: astore 4
        //   352: aload_2
        //   353: aload 7
        //   355: invokevirtual 204	java/io/InputStream:read	([B)I
        //   358: istore_1
        //   359: iload_1
        //   360: iconst_m1
        //   361: if_icmpeq +130 -> 491
        //   364: aload_2
        //   365: astore 5
        //   367: aload_3
        //   368: astore 4
        //   370: aload_0
        //   371: aload_0
        //   372: getfield 32	com/tencent/mm/platformtools/r$b$a:pBd	I
        //   375: iload_1
        //   376: iadd
        //   377: putfield 32	com/tencent/mm/platformtools/r$b$a:pBd	I
        //   380: aload_2
        //   381: astore 5
        //   383: aload_3
        //   384: astore 4
        //   386: aload_3
        //   387: aload 7
        //   389: iconst_0
        //   390: iload_1
        //   391: invokevirtual 208	java/io/OutputStream:write	([BII)V
        //   394: goto -48 -> 346
        //   397: astore 6
        //   399: aload_2
        //   400: astore 5
        //   402: aload_3
        //   403: astore 4
        //   405: ldc 60
        //   407: ldc 192
        //   409: iconst_1
        //   410: anewarray 4	java/lang/Object
        //   413: dup
        //   414: iconst_0
        //   415: aload 6
        //   417: invokestatic 198	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   420: aastore
        //   421: invokestatic 200	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   424: aload_2
        //   425: astore 5
        //   427: aload_3
        //   428: astore 4
        //   430: ldc 60
        //   432: ldc 210
        //   434: iconst_1
        //   435: anewarray 4	java/lang/Object
        //   438: dup
        //   439: iconst_0
        //   440: aload_0
        //   441: getfield 50	com/tencent/mm/platformtools/r$b$a:pBe	Lcom/tencent/mm/platformtools/p;
        //   444: invokeinterface 111 1 0
        //   449: aastore
        //   450: invokestatic 179	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   453: aload_2
        //   454: astore 5
        //   456: aload_3
        //   457: astore 4
        //   459: aload_0
        //   460: getfield 50	com/tencent/mm/platformtools/r$b$a:pBe	Lcom/tencent/mm/platformtools/p;
        //   463: invokeinterface 182 1 0
        //   468: aload_2
        //   469: ifnull +7 -> 476
        //   472: aload_2
        //   473: invokevirtual 187	java/io/InputStream:close	()V
        //   476: aload_3
        //   477: ifnull +7 -> 484
        //   480: aload_3
        //   481: invokevirtual 190	java/io/OutputStream:close	()V
        //   484: ldc 58
        //   486: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   489: iconst_1
        //   490: ireturn
        //   491: aload_2
        //   492: astore 5
        //   494: aload_3
        //   495: astore 4
        //   497: ldc 60
        //   499: ldc 212
        //   501: iconst_2
        //   502: anewarray 4	java/lang/Object
        //   505: dup
        //   506: iconst_0
        //   507: aload_0
        //   508: getfield 50	com/tencent/mm/platformtools/r$b$a:pBe	Lcom/tencent/mm/platformtools/p;
        //   511: invokeinterface 111 1 0
        //   516: aastore
        //   517: dup
        //   518: iconst_1
        //   519: aload_0
        //   520: getfield 32	com/tencent/mm/platformtools/r$b$a:pBd	I
        //   523: invokestatic 218	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   526: aastore
        //   527: invokestatic 220	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   530: aload_2
        //   531: astore 5
        //   533: aload_3
        //   534: astore 4
        //   536: aload_0
        //   537: getfield 50	com/tencent/mm/platformtools/r$b$a:pBe	Lcom/tencent/mm/platformtools/p;
        //   540: invokeinterface 182 1 0
        //   545: aload_2
        //   546: ifnull +7 -> 553
        //   549: aload_2
        //   550: invokevirtual 187	java/io/InputStream:close	()V
        //   553: aload_3
        //   554: ifnull +7 -> 561
        //   557: aload_3
        //   558: invokevirtual 190	java/io/OutputStream:close	()V
        //   561: new 82	java/lang/StringBuilder
        //   564: dup
        //   565: invokespecial 83	java/lang/StringBuilder:<init>	()V
        //   568: aload 6
        //   570: invokevirtual 87	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
        //   573: invokestatic 93	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
        //   576: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   579: ldc 99
        //   581: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   584: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   587: invokestatic 224	com/tencent/mm/vfs/y:bub	(Ljava/lang/String;)Ljava/lang/String;
        //   590: pop
        //   591: aload_0
        //   592: getfield 50	com/tencent/mm/platformtools/r$b$a:pBe	Lcom/tencent/mm/platformtools/p;
        //   595: invokeinterface 228 1 0
        //   600: astore_2
        //   601: aload_2
        //   602: ifnull +339 -> 941
        //   605: aload_2
        //   606: new 82	java/lang/StringBuilder
        //   609: dup
        //   610: invokespecial 83	java/lang/StringBuilder:<init>	()V
        //   613: aload 6
        //   615: invokevirtual 87	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
        //   618: invokestatic 93	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
        //   621: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   624: ldc 99
        //   626: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   629: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   632: invokeinterface 234 2 0
        //   637: astore_3
        //   638: aload_3
        //   639: ifnull +335 -> 974
        //   642: aload_0
        //   643: getfield 50	com/tencent/mm/platformtools/r$b$a:pBe	Lcom/tencent/mm/platformtools/p;
        //   646: aload_3
        //   647: getstatic 240	com/tencent/mm/platformtools/p$a:pAS	Lcom/tencent/mm/platformtools/p$a;
        //   650: new 82	java/lang/StringBuilder
        //   653: dup
        //   654: invokespecial 83	java/lang/StringBuilder:<init>	()V
        //   657: aload 6
        //   659: invokevirtual 87	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
        //   662: invokestatic 93	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
        //   665: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   668: ldc 99
        //   670: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   673: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   676: invokeinterface 243 4 0
        //   681: astore_2
        //   682: aload_2
        //   683: aload_3
        //   684: if_acmpeq +32 -> 716
        //   687: aload_3
        //   688: invokevirtual 248	android/graphics/Bitmap:isRecycled	()Z
        //   691: ifne +25 -> 716
        //   694: ldc 60
        //   696: ldc 250
        //   698: iconst_1
        //   699: anewarray 4	java/lang/Object
        //   702: dup
        //   703: iconst_0
        //   704: aload_3
        //   705: invokevirtual 251	java/lang/Object:toString	()Ljava/lang/String;
        //   708: aastore
        //   709: invokestatic 220	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   712: aload_3
        //   713: invokevirtual 254	android/graphics/Bitmap:recycle	()V
        //   716: getstatic 258	com/tencent/mm/platformtools/r$b:pAX	Lcom/tencent/mm/platformtools/r$b;
        //   719: aload_0
        //   720: getfield 50	com/tencent/mm/platformtools/r$b$a:pBe	Lcom/tencent/mm/platformtools/p;
        //   723: aload_2
        //   724: invokestatic 261	com/tencent/mm/platformtools/r$b:a	(Lcom/tencent/mm/platformtools/r$b;Lcom/tencent/mm/platformtools/p;Landroid/graphics/Bitmap;)V
        //   727: new 75	com/tencent/mm/vfs/u
        //   730: dup
        //   731: new 82	java/lang/StringBuilder
        //   734: dup
        //   735: invokespecial 83	java/lang/StringBuilder:<init>	()V
        //   738: aload 6
        //   740: invokevirtual 87	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
        //   743: invokestatic 93	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
        //   746: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   749: ldc 99
        //   751: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   754: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   757: invokespecial 80	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
        //   760: invokevirtual 264	com/tencent/mm/vfs/u:diJ	()Z
        //   763: pop
        //   764: aload_0
        //   765: aload_2
        //   766: putfield 34	com/tencent/mm/platformtools/r$b$a:orY	Landroid/graphics/Bitmap;
        //   769: ldc 58
        //   771: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   774: iconst_1
        //   775: ireturn
        //   776: astore_2
        //   777: ldc 60
        //   779: ldc 192
        //   781: iconst_1
        //   782: anewarray 4	java/lang/Object
        //   785: dup
        //   786: iconst_0
        //   787: aload_2
        //   788: invokestatic 198	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   791: aastore
        //   792: invokestatic 200	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   795: goto -242 -> 553
        //   798: astore_2
        //   799: ldc 60
        //   801: ldc 192
        //   803: iconst_1
        //   804: anewarray 4	java/lang/Object
        //   807: dup
        //   808: iconst_0
        //   809: aload_2
        //   810: invokestatic 198	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   813: aastore
        //   814: invokestatic 200	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   817: goto -256 -> 561
        //   820: astore_2
        //   821: ldc 60
        //   823: ldc 192
        //   825: iconst_1
        //   826: anewarray 4	java/lang/Object
        //   829: dup
        //   830: iconst_0
        //   831: aload_2
        //   832: invokestatic 198	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   835: aastore
        //   836: invokestatic 200	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   839: goto -363 -> 476
        //   842: astore_2
        //   843: ldc 60
        //   845: ldc 192
        //   847: iconst_1
        //   848: anewarray 4	java/lang/Object
        //   851: dup
        //   852: iconst_0
        //   853: aload_2
        //   854: invokestatic 198	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   857: aastore
        //   858: invokestatic 200	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   861: goto -377 -> 484
        //   864: astore_2
        //   865: aconst_null
        //   866: astore 5
        //   868: aconst_null
        //   869: astore_3
        //   870: aload 5
        //   872: ifnull +8 -> 880
        //   875: aload 5
        //   877: invokevirtual 187	java/io/InputStream:close	()V
        //   880: aload_3
        //   881: ifnull +7 -> 888
        //   884: aload_3
        //   885: invokevirtual 190	java/io/OutputStream:close	()V
        //   888: ldc 58
        //   890: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   893: aload_2
        //   894: athrow
        //   895: astore 4
        //   897: ldc 60
        //   899: ldc 192
        //   901: iconst_1
        //   902: anewarray 4	java/lang/Object
        //   905: dup
        //   906: iconst_0
        //   907: aload 4
        //   909: invokestatic 198	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   912: aastore
        //   913: invokestatic 200	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   916: goto -36 -> 880
        //   919: astore_3
        //   920: ldc 60
        //   922: ldc 192
        //   924: iconst_1
        //   925: anewarray 4	java/lang/Object
        //   928: dup
        //   929: iconst_0
        //   930: aload_3
        //   931: invokestatic 198	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   934: aastore
        //   935: invokestatic 200	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   938: goto -50 -> 888
        //   941: new 82	java/lang/StringBuilder
        //   944: dup
        //   945: invokespecial 83	java/lang/StringBuilder:<init>	()V
        //   948: aload 6
        //   950: invokevirtual 87	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
        //   953: invokestatic 93	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
        //   956: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   959: ldc 99
        //   961: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   964: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   967: invokestatic 267	com/tencent/mm/platformtools/r$b:Sg	(Ljava/lang/String;)Landroid/graphics/Bitmap;
        //   970: astore_3
        //   971: goto -333 -> 638
        //   974: aload_0
        //   975: getfield 50	com/tencent/mm/platformtools/r$b$a:pBe	Lcom/tencent/mm/platformtools/p;
        //   978: getstatic 240	com/tencent/mm/platformtools/p$a:pAS	Lcom/tencent/mm/platformtools/p$a;
        //   981: invokeinterface 270 2 0
        //   986: aconst_null
        //   987: astore_2
        //   988: goto -306 -> 682
        //   991: astore_2
        //   992: ldc 60
        //   994: ldc_w 272
        //   997: iconst_1
        //   998: anewarray 4	java/lang/Object
        //   1001: dup
        //   1002: iconst_0
        //   1003: aload_0
        //   1004: getfield 50	com/tencent/mm/platformtools/r$b$a:pBe	Lcom/tencent/mm/platformtools/p;
        //   1007: invokeinterface 111 1 0
        //   1012: aastore
        //   1013: invokestatic 179	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   1016: ldc 60
        //   1018: ldc 192
        //   1020: iconst_1
        //   1021: anewarray 4	java/lang/Object
        //   1024: dup
        //   1025: iconst_0
        //   1026: aload_2
        //   1027: invokestatic 198	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   1030: aastore
        //   1031: invokestatic 200	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   1034: aconst_null
        //   1035: astore_2
        //   1036: goto -272 -> 764
        //   1039: astore_2
        //   1040: aconst_null
        //   1041: astore 5
        //   1043: goto -173 -> 870
        //   1046: astore_2
        //   1047: aload 4
        //   1049: astore_3
        //   1050: goto -180 -> 870
        //   1053: astore 6
        //   1055: aconst_null
        //   1056: astore_2
        //   1057: aconst_null
        //   1058: astore_3
        //   1059: goto -660 -> 399
        //   1062: astore 6
        //   1064: aconst_null
        //   1065: astore_2
        //   1066: goto -667 -> 399
        //   1069: aconst_null
        //   1070: astore_2
        //   1071: goto -881 -> 190
        //   1074: aconst_null
        //   1075: astore_2
        //   1076: goto -531 -> 545
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	1079	0	this	a
        //   358	33	1	i	int
        //   131	140	2	localObject1	Object
        //   289	12	2	localIOException1	java.io.IOException
        //   311	239	2	localIOException2	java.io.IOException
        //   600	166	2	localObject2	Object
        //   776	12	2	localIOException3	java.io.IOException
        //   798	12	2	localIOException4	java.io.IOException
        //   820	12	2	localIOException5	java.io.IOException
        //   842	12	2	localIOException6	java.io.IOException
        //   864	30	2	localObject3	Object
        //   987	1	2	localObject4	Object
        //   991	36	2	localException1	Exception
        //   1035	1	2	localObject5	Object
        //   1039	1	2	localObject6	Object
        //   1046	1	2	localObject7	Object
        //   1056	20	2	localObject8	Object
        //   83	802	3	localObject9	Object
        //   919	12	3	localIOException7	java.io.IOException
        //   970	89	3	localObject10	Object
        //   194	341	4	localObject11	Object
        //   895	153	4	localIOException8	java.io.IOException
        //   191	851	5	localObject12	Object
        //   51	10	6	localu	com.tencent.mm.vfs.u
        //   397	552	6	localException2	Exception
        //   1053	1	6	localException3	Exception
        //   1062	1	6	localException4	Exception
        //   97	291	7	localObject13	Object
        // Exception table:
        //   from	to	target	type
        //   270	274	289	java/io/IOException
        //   278	282	311	java/io/IOException
        //   196	218	397	java/lang/Exception
        //   228	251	397	java/lang/Exception
        //   257	266	397	java/lang/Exception
        //   339	346	397	java/lang/Exception
        //   352	359	397	java/lang/Exception
        //   370	380	397	java/lang/Exception
        //   386	394	397	java/lang/Exception
        //   497	530	397	java/lang/Exception
        //   536	545	397	java/lang/Exception
        //   549	553	776	java/io/IOException
        //   557	561	798	java/io/IOException
        //   472	476	820	java/io/IOException
        //   480	484	842	java/io/IOException
        //   26	84	864	finally
        //   875	880	895	java/io/IOException
        //   884	888	919	java/io/IOException
        //   561	601	991	java/lang/Exception
        //   605	638	991	java/lang/Exception
        //   642	682	991	java/lang/Exception
        //   687	716	991	java/lang/Exception
        //   716	764	991	java/lang/Exception
        //   941	971	991	java/lang/Exception
        //   974	986	991	java/lang/Exception
        //   84	99	1039	finally
        //   104	153	1039	finally
        //   153	190	1039	finally
        //   196	218	1046	finally
        //   228	251	1046	finally
        //   257	266	1046	finally
        //   339	346	1046	finally
        //   352	359	1046	finally
        //   370	380	1046	finally
        //   386	394	1046	finally
        //   405	424	1046	finally
        //   430	453	1046	finally
        //   459	468	1046	finally
        //   497	530	1046	finally
        //   536	545	1046	finally
        //   26	84	1053	java/lang/Exception
        //   84	99	1062	java/lang/Exception
        //   104	153	1062	java/lang/Exception
        //   153	190	1062	java/lang/Exception
      }
      
      public final boolean onPostExecute()
      {
        AppMethodBeat.i(151384);
        try
        {
          az.a.okQ.eB(this.pBd, 0);
          r.b.a(r.b.pAX, this.pBe.bTD(), this.pBe.bTE(), this.orY);
          this.orY = null;
          AppMethodBeat.o(151384);
          return false;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
          }
        }
      }
    }
    
    static final class b
      implements QueueWorkerThread.ThreadObject
    {
      public Bitmap orY;
      private p pBe;
      
      public b(p paramp)
      {
        AppMethodBeat.i(151385);
        this.orY = null;
        if (!r.c(paramp))
        {
          paramp = new IllegalArgumentException("from sdcard, picture strategy here must be validity");
          AppMethodBeat.o(151385);
          throw paramp;
        }
        this.pBe = paramp;
        AppMethodBeat.o(151385);
      }
      
      public final boolean doInBackground()
      {
        boolean bool = false;
        AppMethodBeat.i(151386);
        this.orY = r.b.Sg(this.pBe.bTC());
        if (this.orY != null) {
          this.orY = r.b.pAX.a(this.pBe, this.orY);
        }
        String str1 = this.pBe.bTD();
        String str2 = this.pBe.bTC();
        if (this.orY != null) {
          bool = true;
        }
        Log.v("MicroMsg.MMPictureLogic", "get url[%s] from[%s] result[%B]", new Object[] { str1, str2, Boolean.valueOf(bool) });
        AppMethodBeat.o(151386);
        return true;
      }
      
      public final boolean onPostExecute()
      {
        AppMethodBeat.i(151387);
        if (this.orY == null)
        {
          Log.d("MicroMsg.MMPictureLogic", "can not find bitmap on sdCard, url=%s, try to download it", new Object[] { this.pBe.bTD() });
          if ((r.b.a(r.b.pAX) == null) || (r.b.a(r.b.pAX).isDead())) {
            r.b.a(r.b.pAX, new QueueWorkerThread(1, "readerapp-pic-logic-download", 3));
          }
          r.b.a(r.b.pAX).add(new r.b.a(this.pBe));
        }
        for (;;)
        {
          AppMethodBeat.o(151387);
          return false;
          r.b.a(r.b.pAX, this.pBe.bTD(), this.pBe.bTE(), this.orY);
          this.orY = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.platformtools.r
 * JD-Core Version:    0.7.0.1
 */