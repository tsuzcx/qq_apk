package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import com.tencent.e.i;
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
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.Future;
import junit.framework.Assert;

public final class u
{
  private static Vector<WeakReference<a>> mEs;
  private static LinkedList<a> mEt;
  
  static
  {
    AppMethodBeat.i(151414);
    mEs = new Vector();
    mEt = new LinkedList();
    AppMethodBeat.o(151414);
  }
  
  public static Bitmap ZS(String paramString)
  {
    AppMethodBeat.i(151408);
    paramString = b.ZS(paramString);
    AppMethodBeat.o(151408);
    return paramString;
  }
  
  public static Bitmap ZT(String paramString)
  {
    AppMethodBeat.i(151410);
    paramString = b.ZT(paramString);
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
    f localf = com.tencent.mm.kernel.h.aHG();
    if (localf.kcR == null) {
      localf.kcR = Boolean.valueOf(localf.isSDCardAvailable());
    }
    while (!localf.kcR.booleanValue())
    {
      params = params.bvu();
      AppMethodBeat.o(151407);
      return params;
      long l = System.currentTimeMillis() - localf.kcT;
      if ((l <= 0L) || (l >= 1000L))
      {
        f.a locala = localf.kcS;
        if ((locala.fuk != null) && (!locala.fuk.isDone())) {
          locala.fuk.cancel(false);
        }
        com.tencent.e.h.ZvG.o(localf.kcS, 1000L);
        localf.kcT = System.currentTimeMillis();
      }
    }
    params = b.a(b.mEu, params);
    AppMethodBeat.o(151407);
    return params;
  }
  
  public static boolean a(a parama)
  {
    AppMethodBeat.i(151404);
    boolean bool = mEs.add(new WeakReference(parama));
    AppMethodBeat.o(151404);
    return bool;
  }
  
  private static boolean b(s params)
  {
    AppMethodBeat.i(151411);
    if ((params == null) || (Util.isNullOrNil(params.bvr())))
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
    mEt.remove(parama);
    boolean bool = mEt.add(parama);
    AppMethodBeat.o(151405);
    return bool;
  }
  
  public static boolean c(a parama)
  {
    AppMethodBeat.i(151406);
    boolean bool = mEt.remove(parama);
    AppMethodBeat.o(151406);
    return bool;
  }
  
  public static Bitmap y(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(151409);
    paramString = b.y(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(151409);
    return paramString;
  }
  
  public static abstract interface a
  {
    public abstract void k(String paramString, Bitmap paramBitmap);
  }
  
  static enum b
  {
    private static DisplayMetrics metrics;
    private Map<String, u.b.c> mEv;
    private Map<String, WeakReference<Bitmap>> mEw;
    private QueueWorkerThread mEx;
    private QueueWorkerThread mEy;
    
    static
    {
      AppMethodBeat.i(151403);
      mEu = new b("INSTANCE");
      mEz = new b[] { mEu };
      metrics = null;
      AppMethodBeat.o(151403);
    }
    
    private b()
    {
      AppMethodBeat.i(151391);
      this.mEv = new HashMap();
      this.mEw = new HashMap();
      this.mEx = null;
      this.mEy = null;
      AppMethodBeat.o(151391);
    }
    
    public static Bitmap ZS(String paramString)
    {
      AppMethodBeat.i(151397);
      DisplayMetrics localDisplayMetrics = getDefaultDisplayMetrics();
      paramString = y(paramString, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
      AppMethodBeat.o(151397);
      return paramString;
    }
    
    public static Bitmap ZT(String paramString)
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
    
    private void b(s params, Bitmap paramBitmap)
    {
      AppMethodBeat.i(151394);
      Assert.assertTrue("picture strategy here must be validity", u.c(params));
      String str = params.getCacheKey();
      if (this.mEw.containsKey(str)) {}
      for (params = (Bitmap)((WeakReference)this.mEw.get(str)).get();; params = null)
      {
        if ((params == null) || (params.isRecycled()))
        {
          this.mEw.remove(str);
          this.mEw.put(str, new WeakReference(paramBitmap));
        }
        AppMethodBeat.o(151394);
        return;
      }
    }
    
    private Bitmap d(s params)
    {
      AppMethodBeat.i(151392);
      Assert.assertTrue("picture strategy here must be validity", u.c(params));
      String str = params.bvr();
      u.b.c localc = (u.b.c)this.mEv.get(str);
      Object localObject = localc;
      if (localc == null) {
        localObject = new u.b.c();
      }
      if (((u.b.c)localObject).mEC) {
        if (((u.b.c)localObject).mED >= 3)
        {
          if (Util.secondsToNow(((u.b.c)localObject).mEE) < 120L)
          {
            Log.w("MicroMsg.MMPictureLogic", "download fail interval less than %d s for %s", new Object[] { Integer.valueOf(120), str });
            AppMethodBeat.o(151392);
            return null;
          }
          ((u.b.c)localObject).mED = 0;
          ((u.b.c)localObject).mEC = false;
          ((u.b.c)localObject).mEE = ((int)Util.nowSecond());
          this.mEv.put(str, localObject);
          label143:
          if (!params.bvt()) {
            break label369;
          }
          localObject = params.bvp();
          if (localObject == null) {
            break label300;
          }
        }
      }
      label300:
      for (localObject = ((s.b)localObject).ZQ(params.bvq());; localObject = ZS(params.bvq()))
      {
        if (localObject == null) {
          break label313;
        }
        params = a(params, (Bitmap)localObject);
        this.mEv.remove(str);
        AppMethodBeat.o(151392);
        return params;
        ((u.b.c)localObject).mED += 1;
        break;
        if (Util.secondsToNow(((u.b.c)localObject).mEE) < 120L)
        {
          Log.d("MicroMsg.MMPictureLogic", "downloading interval less than %d s for %s", new Object[] { Integer.valueOf(120), str });
          AppMethodBeat.o(151392);
          return null;
        }
        ((u.b.c)localObject).mED += 1;
        ((u.b.c)localObject).mEE = ((int)Util.nowSecond());
        this.mEv.put(str, localObject);
        break label143;
      }
      label313:
      if ((this.mEx == null) || (this.mEx.isDead())) {
        this.mEx = new QueueWorkerThread(1, "readerapp-pic-logic-download", 3);
      }
      this.mEx.add(new a(params));
      AppMethodBeat.o(151392);
      return null;
      label369:
      if ((this.mEy == null) || (this.mEy.isDead())) {
        this.mEy = new QueueWorkerThread(1, "readerapp-pic-logic-reader", 1);
      }
      this.mEy.add(new b(params));
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
    
    public static Bitmap y(String paramString, int paramInt1, int paramInt2)
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
    
    protected final Bitmap a(s params, Bitmap paramBitmap)
    {
      AppMethodBeat.i(151393);
      Assert.assertTrue("picture strategy here must be validity", u.c(params));
      Bitmap localBitmap;
      if (paramBitmap != null)
      {
        localBitmap = params.a(paramBitmap, s.a.mEq, params.bvq());
        if ((localBitmap != paramBitmap) && (!paramBitmap.isRecycled()))
        {
          Log.i("MicroMsg.MMPictureLogic", "recycle bitmap:%s", new Object[] { paramBitmap.toString() });
          paramBitmap.recycle();
        }
        b(params, localBitmap);
      }
      for (params = localBitmap;; params = paramBitmap)
      {
        AppMethodBeat.o(151393);
        return params;
        params.a(s.a.mEq);
      }
    }
    
    static final class a
      implements QueueWorkerThread.ThreadObject
    {
      private Bitmap lAx;
      private int mEA;
      private s mEB;
      
      public a(s params)
      {
        AppMethodBeat.i(151382);
        this.mEA = 0;
        this.lAx = null;
        if (!u.c(params))
        {
          params = new IllegalArgumentException("from net, picture strategy here must be validity");
          AppMethodBeat.o(151382);
          throw params;
        }
        this.mEB = params;
        AppMethodBeat.o(151382);
      }
      
      /* Error */
      public final boolean doInBackground()
      {
        // Byte code:
        //   0: ldc 58
        //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: getfield 50	com/tencent/mm/platformtools/u$b$a:mEB	Lcom/tencent/mm/platformtools/s;
        //   9: ifnonnull +17 -> 26
        //   12: ldc 60
        //   14: ldc 62
        //   16: invokestatic 68	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   19: ldc 58
        //   21: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   24: iconst_1
        //   25: ireturn
        //   26: aload_0
        //   27: getfield 50	com/tencent/mm/platformtools/u$b$a:mEB	Lcom/tencent/mm/platformtools/s;
        //   30: invokeinterface 73 1 0
        //   35: new 75	com/tencent/mm/vfs/q
        //   38: dup
        //   39: aload_0
        //   40: getfield 50	com/tencent/mm/platformtools/u$b$a:mEB	Lcom/tencent/mm/platformtools/s;
        //   43: invokeinterface 79 1 0
        //   48: invokespecial 80	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
        //   51: astore 6
        //   53: new 82	java/lang/StringBuilder
        //   56: dup
        //   57: invokespecial 83	java/lang/StringBuilder:<init>	()V
        //   60: aload 6
        //   62: invokevirtual 86	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
        //   65: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   68: ldc 92
        //   70: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   73: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   76: invokestatic 101	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
        //   79: astore_2
        //   80: aload_0
        //   81: getfield 50	com/tencent/mm/platformtools/u$b$a:mEB	Lcom/tencent/mm/platformtools/s;
        //   84: invokeinterface 104 1 0
        //   89: aconst_null
        //   90: invokestatic 109	com/tencent/mm/network/d:a	(Ljava/lang/String;Lcom/tencent/mm/network/d$b;)Lcom/tencent/mm/network/x;
        //   93: astore 7
        //   95: invokestatic 114	com/tencent/mm/ay/t:bmq	()Z
        //   98: ifeq +46 -> 144
        //   101: aload_0
        //   102: getfield 50	com/tencent/mm/platformtools/u$b$a:mEB	Lcom/tencent/mm/platformtools/s;
        //   105: invokeinterface 104 1 0
        //   110: invokestatic 118	com/tencent/mm/ay/t:fX	(Ljava/lang/String;)Z
        //   113: ifeq +31 -> 144
        //   116: getstatic 123	com/tencent/mm/protocal/d:RAD	I
        //   119: invokestatic 127	com/tencent/mm/ay/t:wu	(I)Ljava/lang/String;
        //   122: astore_3
        //   123: ldc 60
        //   125: ldc 129
        //   127: iconst_1
        //   128: anewarray 4	java/lang/Object
        //   131: dup
        //   132: iconst_0
        //   133: aload_3
        //   134: aastore
        //   135: invokestatic 133	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   138: aload 7
        //   140: aload_3
        //   141: invokevirtual 138	com/tencent/mm/network/x:Zw	(Ljava/lang/String;)V
        //   144: aload 7
        //   146: sipush 10000
        //   149: invokevirtual 141	com/tencent/mm/network/x:xz	(I)V
        //   152: aload 7
        //   154: sipush 20000
        //   157: invokevirtual 144	com/tencent/mm/network/x:xA	(I)V
        //   160: aload 7
        //   162: ldc 146
        //   164: invokevirtual 149	com/tencent/mm/network/x:Zu	(Ljava/lang/String;)V
        //   167: aload 7
        //   169: invokestatic 152	com/tencent/mm/network/d:a	(Lcom/tencent/mm/network/y;)I
        //   172: ifne +873 -> 1045
        //   175: aload 7
        //   177: invokevirtual 156	com/tencent/mm/network/x:getInputStream	()Ljava/io/InputStream;
        //   180: astore_3
        //   181: aload_3
        //   182: astore 5
        //   184: aload_2
        //   185: astore 4
        //   187: ldc 60
        //   189: ldc 158
        //   191: iconst_1
        //   192: anewarray 4	java/lang/Object
        //   195: dup
        //   196: iconst_0
        //   197: aload 7
        //   199: getfield 162	com/tencent/mm/network/x:connection	Ljava/net/HttpURLConnection;
        //   202: invokevirtual 167	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
        //   205: aastore
        //   206: invokestatic 133	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   209: aload_3
        //   210: ifnonnull +114 -> 324
        //   213: aload_3
        //   214: astore 5
        //   216: aload_2
        //   217: astore 4
        //   219: ldc 60
        //   221: ldc 169
        //   223: iconst_1
        //   224: anewarray 4	java/lang/Object
        //   227: dup
        //   228: iconst_0
        //   229: aload_0
        //   230: getfield 50	com/tencent/mm/platformtools/u$b$a:mEB	Lcom/tencent/mm/platformtools/s;
        //   233: invokeinterface 104 1 0
        //   238: aastore
        //   239: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   242: aload_3
        //   243: astore 5
        //   245: aload_2
        //   246: astore 4
        //   248: aload_0
        //   249: getfield 50	com/tencent/mm/platformtools/u$b$a:mEB	Lcom/tencent/mm/platformtools/s;
        //   252: invokeinterface 175 1 0
        //   257: aload_3
        //   258: ifnull +7 -> 265
        //   261: aload_3
        //   262: invokevirtual 180	java/io/InputStream:close	()V
        //   265: aload_2
        //   266: ifnull +7 -> 273
        //   269: aload_2
        //   270: invokevirtual 183	java/io/OutputStream:close	()V
        //   273: ldc 58
        //   275: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   278: iconst_1
        //   279: ireturn
        //   280: astore_3
        //   281: ldc 60
        //   283: ldc 185
        //   285: iconst_1
        //   286: anewarray 4	java/lang/Object
        //   289: dup
        //   290: iconst_0
        //   291: aload_3
        //   292: invokestatic 191	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   295: aastore
        //   296: invokestatic 193	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   299: goto -34 -> 265
        //   302: astore_2
        //   303: ldc 60
        //   305: ldc 185
        //   307: iconst_1
        //   308: anewarray 4	java/lang/Object
        //   311: dup
        //   312: iconst_0
        //   313: aload_2
        //   314: invokestatic 191	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   317: aastore
        //   318: invokestatic 193	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   321: goto -48 -> 273
        //   324: aload_3
        //   325: astore 5
        //   327: aload_2
        //   328: astore 4
        //   330: sipush 1024
        //   333: newarray byte
        //   335: astore 7
        //   337: aload_3
        //   338: astore 5
        //   340: aload_2
        //   341: astore 4
        //   343: aload_3
        //   344: aload 7
        //   346: invokevirtual 197	java/io/InputStream:read	([B)I
        //   349: istore_1
        //   350: iload_1
        //   351: iconst_m1
        //   352: if_icmpeq +130 -> 482
        //   355: aload_3
        //   356: astore 5
        //   358: aload_2
        //   359: astore 4
        //   361: aload_0
        //   362: aload_0
        //   363: getfield 32	com/tencent/mm/platformtools/u$b$a:mEA	I
        //   366: iload_1
        //   367: iadd
        //   368: putfield 32	com/tencent/mm/platformtools/u$b$a:mEA	I
        //   371: aload_3
        //   372: astore 5
        //   374: aload_2
        //   375: astore 4
        //   377: aload_2
        //   378: aload 7
        //   380: iconst_0
        //   381: iload_1
        //   382: invokevirtual 201	java/io/OutputStream:write	([BII)V
        //   385: goto -48 -> 337
        //   388: astore 6
        //   390: aload_3
        //   391: astore 5
        //   393: aload_2
        //   394: astore 4
        //   396: ldc 60
        //   398: ldc 185
        //   400: iconst_1
        //   401: anewarray 4	java/lang/Object
        //   404: dup
        //   405: iconst_0
        //   406: aload 6
        //   408: invokestatic 191	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   411: aastore
        //   412: invokestatic 193	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   415: aload_3
        //   416: astore 5
        //   418: aload_2
        //   419: astore 4
        //   421: ldc 60
        //   423: ldc 203
        //   425: iconst_1
        //   426: anewarray 4	java/lang/Object
        //   429: dup
        //   430: iconst_0
        //   431: aload_0
        //   432: getfield 50	com/tencent/mm/platformtools/u$b$a:mEB	Lcom/tencent/mm/platformtools/s;
        //   435: invokeinterface 104 1 0
        //   440: aastore
        //   441: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   444: aload_3
        //   445: astore 5
        //   447: aload_2
        //   448: astore 4
        //   450: aload_0
        //   451: getfield 50	com/tencent/mm/platformtools/u$b$a:mEB	Lcom/tencent/mm/platformtools/s;
        //   454: invokeinterface 175 1 0
        //   459: aload_3
        //   460: ifnull +7 -> 467
        //   463: aload_3
        //   464: invokevirtual 180	java/io/InputStream:close	()V
        //   467: aload_2
        //   468: ifnull +7 -> 475
        //   471: aload_2
        //   472: invokevirtual 183	java/io/OutputStream:close	()V
        //   475: ldc 58
        //   477: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   480: iconst_1
        //   481: ireturn
        //   482: aload_3
        //   483: astore 5
        //   485: aload_2
        //   486: astore 4
        //   488: ldc 60
        //   490: ldc 205
        //   492: iconst_2
        //   493: anewarray 4	java/lang/Object
        //   496: dup
        //   497: iconst_0
        //   498: aload_0
        //   499: getfield 50	com/tencent/mm/platformtools/u$b$a:mEB	Lcom/tencent/mm/platformtools/s;
        //   502: invokeinterface 104 1 0
        //   507: aastore
        //   508: dup
        //   509: iconst_1
        //   510: aload_0
        //   511: getfield 32	com/tencent/mm/platformtools/u$b$a:mEA	I
        //   514: invokestatic 211	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   517: aastore
        //   518: invokestatic 213	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   521: aload_3
        //   522: astore 5
        //   524: aload_2
        //   525: astore 4
        //   527: aload_0
        //   528: getfield 50	com/tencent/mm/platformtools/u$b$a:mEB	Lcom/tencent/mm/platformtools/s;
        //   531: invokeinterface 175 1 0
        //   536: aload_3
        //   537: ifnull +7 -> 544
        //   540: aload_3
        //   541: invokevirtual 180	java/io/InputStream:close	()V
        //   544: aload_2
        //   545: ifnull +7 -> 552
        //   548: aload_2
        //   549: invokevirtual 183	java/io/OutputStream:close	()V
        //   552: new 82	java/lang/StringBuilder
        //   555: dup
        //   556: invokespecial 83	java/lang/StringBuilder:<init>	()V
        //   559: aload 6
        //   561: invokevirtual 86	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
        //   564: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   567: ldc 92
        //   569: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   572: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   575: invokestatic 217	com/tencent/mm/vfs/u:buc	(Ljava/lang/String;)Ljava/lang/String;
        //   578: pop
        //   579: aload_0
        //   580: getfield 50	com/tencent/mm/platformtools/u$b$a:mEB	Lcom/tencent/mm/platformtools/s;
        //   583: invokeinterface 221 1 0
        //   588: astore_2
        //   589: aload_2
        //   590: ifnull +330 -> 920
        //   593: aload_2
        //   594: new 82	java/lang/StringBuilder
        //   597: dup
        //   598: invokespecial 83	java/lang/StringBuilder:<init>	()V
        //   601: aload 6
        //   603: invokevirtual 86	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
        //   606: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   609: ldc 92
        //   611: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   614: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   617: invokeinterface 227 2 0
        //   622: astore_3
        //   623: aload_3
        //   624: ifnull +326 -> 950
        //   627: aload_0
        //   628: getfield 50	com/tencent/mm/platformtools/u$b$a:mEB	Lcom/tencent/mm/platformtools/s;
        //   631: aload_3
        //   632: getstatic 233	com/tencent/mm/platformtools/s$a:mEp	Lcom/tencent/mm/platformtools/s$a;
        //   635: new 82	java/lang/StringBuilder
        //   638: dup
        //   639: invokespecial 83	java/lang/StringBuilder:<init>	()V
        //   642: aload 6
        //   644: invokevirtual 86	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
        //   647: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   650: ldc 92
        //   652: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   655: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   658: invokeinterface 236 4 0
        //   663: astore_2
        //   664: aload_2
        //   665: aload_3
        //   666: if_acmpeq +32 -> 698
        //   669: aload_3
        //   670: invokevirtual 241	android/graphics/Bitmap:isRecycled	()Z
        //   673: ifne +25 -> 698
        //   676: ldc 60
        //   678: ldc 243
        //   680: iconst_1
        //   681: anewarray 4	java/lang/Object
        //   684: dup
        //   685: iconst_0
        //   686: aload_3
        //   687: invokevirtual 244	java/lang/Object:toString	()Ljava/lang/String;
        //   690: aastore
        //   691: invokestatic 213	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   694: aload_3
        //   695: invokevirtual 247	android/graphics/Bitmap:recycle	()V
        //   698: getstatic 251	com/tencent/mm/platformtools/u$b:mEu	Lcom/tencent/mm/platformtools/u$b;
        //   701: aload_0
        //   702: getfield 50	com/tencent/mm/platformtools/u$b$a:mEB	Lcom/tencent/mm/platformtools/s;
        //   705: aload_2
        //   706: invokestatic 254	com/tencent/mm/platformtools/u$b:a	(Lcom/tencent/mm/platformtools/u$b;Lcom/tencent/mm/platformtools/s;Landroid/graphics/Bitmap;)V
        //   709: new 75	com/tencent/mm/vfs/q
        //   712: dup
        //   713: new 82	java/lang/StringBuilder
        //   716: dup
        //   717: invokespecial 83	java/lang/StringBuilder:<init>	()V
        //   720: aload 6
        //   722: invokevirtual 86	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
        //   725: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   728: ldc 92
        //   730: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   733: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   736: invokespecial 80	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
        //   739: invokevirtual 257	com/tencent/mm/vfs/q:cFq	()Z
        //   742: pop
        //   743: aload_0
        //   744: aload_2
        //   745: putfield 34	com/tencent/mm/platformtools/u$b$a:lAx	Landroid/graphics/Bitmap;
        //   748: ldc 58
        //   750: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   753: iconst_1
        //   754: ireturn
        //   755: astore_3
        //   756: ldc 60
        //   758: ldc 185
        //   760: iconst_1
        //   761: anewarray 4	java/lang/Object
        //   764: dup
        //   765: iconst_0
        //   766: aload_3
        //   767: invokestatic 191	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   770: aastore
        //   771: invokestatic 193	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   774: goto -230 -> 544
        //   777: astore_2
        //   778: ldc 60
        //   780: ldc 185
        //   782: iconst_1
        //   783: anewarray 4	java/lang/Object
        //   786: dup
        //   787: iconst_0
        //   788: aload_2
        //   789: invokestatic 191	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   792: aastore
        //   793: invokestatic 193	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   796: goto -244 -> 552
        //   799: astore_3
        //   800: ldc 60
        //   802: ldc 185
        //   804: iconst_1
        //   805: anewarray 4	java/lang/Object
        //   808: dup
        //   809: iconst_0
        //   810: aload_3
        //   811: invokestatic 191	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   814: aastore
        //   815: invokestatic 193	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   818: goto -351 -> 467
        //   821: astore_2
        //   822: ldc 60
        //   824: ldc 185
        //   826: iconst_1
        //   827: anewarray 4	java/lang/Object
        //   830: dup
        //   831: iconst_0
        //   832: aload_2
        //   833: invokestatic 191	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   836: aastore
        //   837: invokestatic 193	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   840: goto -365 -> 475
        //   843: astore_3
        //   844: aconst_null
        //   845: astore 5
        //   847: aconst_null
        //   848: astore_2
        //   849: aload 5
        //   851: ifnull +8 -> 859
        //   854: aload 5
        //   856: invokevirtual 180	java/io/InputStream:close	()V
        //   859: aload_2
        //   860: ifnull +7 -> 867
        //   863: aload_2
        //   864: invokevirtual 183	java/io/OutputStream:close	()V
        //   867: ldc 58
        //   869: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   872: aload_3
        //   873: athrow
        //   874: astore 4
        //   876: ldc 60
        //   878: ldc 185
        //   880: iconst_1
        //   881: anewarray 4	java/lang/Object
        //   884: dup
        //   885: iconst_0
        //   886: aload 4
        //   888: invokestatic 191	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   891: aastore
        //   892: invokestatic 193	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   895: goto -36 -> 859
        //   898: astore_2
        //   899: ldc 60
        //   901: ldc 185
        //   903: iconst_1
        //   904: anewarray 4	java/lang/Object
        //   907: dup
        //   908: iconst_0
        //   909: aload_2
        //   910: invokestatic 191	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   913: aastore
        //   914: invokestatic 193	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   917: goto -50 -> 867
        //   920: new 82	java/lang/StringBuilder
        //   923: dup
        //   924: invokespecial 83	java/lang/StringBuilder:<init>	()V
        //   927: aload 6
        //   929: invokevirtual 86	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
        //   932: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   935: ldc 92
        //   937: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   940: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   943: invokestatic 260	com/tencent/mm/platformtools/u$b:ZS	(Ljava/lang/String;)Landroid/graphics/Bitmap;
        //   946: astore_3
        //   947: goto -324 -> 623
        //   950: aload_0
        //   951: getfield 50	com/tencent/mm/platformtools/u$b$a:mEB	Lcom/tencent/mm/platformtools/s;
        //   954: getstatic 233	com/tencent/mm/platformtools/s$a:mEp	Lcom/tencent/mm/platformtools/s$a;
        //   957: invokeinterface 263 2 0
        //   962: aconst_null
        //   963: astore_2
        //   964: goto -300 -> 664
        //   967: astore_2
        //   968: ldc 60
        //   970: ldc_w 265
        //   973: iconst_1
        //   974: anewarray 4	java/lang/Object
        //   977: dup
        //   978: iconst_0
        //   979: aload_0
        //   980: getfield 50	com/tencent/mm/platformtools/u$b$a:mEB	Lcom/tencent/mm/platformtools/s;
        //   983: invokeinterface 104 1 0
        //   988: aastore
        //   989: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   992: ldc 60
        //   994: ldc 185
        //   996: iconst_1
        //   997: anewarray 4	java/lang/Object
        //   1000: dup
        //   1001: iconst_0
        //   1002: aload_2
        //   1003: invokestatic 191	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   1006: aastore
        //   1007: invokestatic 193	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   1010: aconst_null
        //   1011: astore_2
        //   1012: goto -269 -> 743
        //   1015: astore_3
        //   1016: aconst_null
        //   1017: astore 5
        //   1019: goto -170 -> 849
        //   1022: astore_3
        //   1023: aload 4
        //   1025: astore_2
        //   1026: goto -177 -> 849
        //   1029: astore 6
        //   1031: aconst_null
        //   1032: astore_3
        //   1033: aconst_null
        //   1034: astore_2
        //   1035: goto -645 -> 390
        //   1038: astore 6
        //   1040: aconst_null
        //   1041: astore_3
        //   1042: goto -652 -> 390
        //   1045: aconst_null
        //   1046: astore_3
        //   1047: goto -866 -> 181
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	1050	0	this	a
        //   349	33	1	i	int
        //   79	191	2	localOutputStream	java.io.OutputStream
        //   302	247	2	localIOException1	java.io.IOException
        //   588	157	2	localObject1	Object
        //   777	12	2	localIOException2	java.io.IOException
        //   821	12	2	localIOException3	java.io.IOException
        //   848	16	2	localObject2	Object
        //   898	12	2	localIOException4	java.io.IOException
        //   963	1	2	localObject3	Object
        //   967	36	2	localException1	Exception
        //   1011	24	2	localObject4	Object
        //   122	140	3	localObject5	Object
        //   280	261	3	localIOException5	java.io.IOException
        //   622	73	3	localBitmap1	Bitmap
        //   755	12	3	localIOException6	java.io.IOException
        //   799	12	3	localIOException7	java.io.IOException
        //   843	30	3	localObject6	Object
        //   946	1	3	localBitmap2	Bitmap
        //   1015	1	3	localObject7	Object
        //   1022	1	3	localObject8	Object
        //   1032	15	3	localObject9	Object
        //   185	341	4	localObject10	Object
        //   874	150	4	localIOException8	java.io.IOException
        //   182	836	5	localObject11	Object
        //   51	10	6	localq	com.tencent.mm.vfs.q
        //   388	540	6	localException2	Exception
        //   1029	1	6	localException3	Exception
        //   1038	1	6	localException4	Exception
        //   93	286	7	localObject12	Object
        // Exception table:
        //   from	to	target	type
        //   261	265	280	java/io/IOException
        //   269	273	302	java/io/IOException
        //   187	209	388	java/lang/Exception
        //   219	242	388	java/lang/Exception
        //   248	257	388	java/lang/Exception
        //   330	337	388	java/lang/Exception
        //   343	350	388	java/lang/Exception
        //   361	371	388	java/lang/Exception
        //   377	385	388	java/lang/Exception
        //   488	521	388	java/lang/Exception
        //   527	536	388	java/lang/Exception
        //   540	544	755	java/io/IOException
        //   548	552	777	java/io/IOException
        //   463	467	799	java/io/IOException
        //   471	475	821	java/io/IOException
        //   26	80	843	finally
        //   854	859	874	java/io/IOException
        //   863	867	898	java/io/IOException
        //   552	589	967	java/lang/Exception
        //   593	623	967	java/lang/Exception
        //   627	664	967	java/lang/Exception
        //   669	698	967	java/lang/Exception
        //   698	743	967	java/lang/Exception
        //   920	947	967	java/lang/Exception
        //   950	962	967	java/lang/Exception
        //   80	144	1015	finally
        //   144	181	1015	finally
        //   187	209	1022	finally
        //   219	242	1022	finally
        //   248	257	1022	finally
        //   330	337	1022	finally
        //   343	350	1022	finally
        //   361	371	1022	finally
        //   377	385	1022	finally
        //   396	415	1022	finally
        //   421	444	1022	finally
        //   450	459	1022	finally
        //   488	521	1022	finally
        //   527	536	1022	finally
        //   26	80	1029	java/lang/Exception
        //   80	144	1038	java/lang/Exception
        //   144	181	1038	java/lang/Exception
      }
      
      public final boolean onPostExecute()
      {
        AppMethodBeat.i(151384);
        try
        {
          az.a.lts.dH(this.mEA, 0);
          u.b.a(u.b.mEu, this.mEB.bvr(), this.mEB.bvs(), this.lAx);
          this.lAx = null;
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
      public Bitmap lAx;
      private s mEB;
      
      public b(s params)
      {
        AppMethodBeat.i(151385);
        this.lAx = null;
        if (!u.c(params))
        {
          params = new IllegalArgumentException("from sdcard, picture strategy here must be validity");
          AppMethodBeat.o(151385);
          throw params;
        }
        this.mEB = params;
        AppMethodBeat.o(151385);
      }
      
      public final boolean doInBackground()
      {
        boolean bool = false;
        AppMethodBeat.i(151386);
        this.lAx = u.b.ZS(this.mEB.bvq());
        if (this.lAx != null) {
          this.lAx = u.b.mEu.a(this.mEB, this.lAx);
        }
        String str1 = this.mEB.bvr();
        String str2 = this.mEB.bvq();
        if (this.lAx != null) {
          bool = true;
        }
        Log.v("MicroMsg.MMPictureLogic", "get url[%s] from[%s] result[%B]", new Object[] { str1, str2, Boolean.valueOf(bool) });
        AppMethodBeat.o(151386);
        return true;
      }
      
      public final boolean onPostExecute()
      {
        AppMethodBeat.i(151387);
        if (this.lAx == null)
        {
          Log.d("MicroMsg.MMPictureLogic", "can not find bitmap on sdCard, url=%s, try to download it", new Object[] { this.mEB.bvr() });
          if ((u.b.a(u.b.mEu) == null) || (u.b.a(u.b.mEu).isDead())) {
            u.b.a(u.b.mEu, new QueueWorkerThread(1, "readerapp-pic-logic-download", 3));
          }
          u.b.a(u.b.mEu).add(new u.b.a(this.mEB));
        }
        for (;;)
        {
          AppMethodBeat.o(151387);
          return false;
          u.b.a(u.b.mEu, this.mEB.bvr(), this.mEB.bvs(), this.lAx);
          this.lAx = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.platformtools.u
 * JD-Core Version:    0.7.0.1
 */