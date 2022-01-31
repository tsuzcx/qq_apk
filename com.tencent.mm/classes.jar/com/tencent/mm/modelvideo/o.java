package com.tencent.mm.modelvideo;

import android.os.HandlerThread;
import com.tencent.mm.ah.e.d;
import com.tencent.mm.ak.f;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.HashMap;

public class o
  implements ar
{
  private static HashMap<Integer, h.d> dgp;
  private static ai eHp = null;
  private static ah eHq = null;
  private volatile v eHi = new v();
  private volatile t eHj;
  private volatile x eHk;
  private volatile y.a eHl = null;
  private volatile l eHm = null;
  private volatile k eHn = null;
  private volatile m eHo = null;
  private com.tencent.mm.ak.e eHr = null;
  private i eHs = null;
  private p eHt = new p();
  
  static
  {
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("VIDEOINFO_TABLE".hashCode()), new o.1());
    dgp.put(Integer.valueOf("VIDEOPLAYHISTORY_TABLE".hashCode()), new o.2());
    dgp.put(Integer.valueOf("SIGHTDRAFTSINFO_TABLE".hashCode()), new h.d()
    {
      public final String[] rK()
      {
        return l.dXp;
      }
    });
  }
  
  public static o Sq()
  {
    return (o)com.tencent.mm.model.p.B(o.class);
  }
  
  public static t Sr()
  {
    try
    {
      if (!g.DK()) {
        throw new b();
      }
    }
    finally {}
    if (Sq().eHj == null) {
      Sq().eHj = new t(g.DP().dKu);
    }
    t localt = Sq().eHj;
    return localt;
  }
  
  public static com.tencent.mm.ak.e Ss()
  {
    g.DN().CX();
    if (Sq().eHr == null) {
      Sq().eHr = new com.tencent.mm.ak.e();
    }
    if (f.Ne().eiA == null) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        f.Ne().eiA = Sq().eHr;
      }
      return Sq().eHr;
    }
  }
  
  public static i St()
  {
    g.DN().CX();
    if (Sq().eHs == null) {
      Sq().eHs = new i();
    }
    return Sq().eHs;
  }
  
  public static x Su()
  {
    if (!g.DK()) {
      throw new b();
    }
    if (Sq().eHk == null) {
      Sq().eHk = new x(g.DP().dKu);
    }
    return Sq().eHk;
  }
  
  public static l Sv()
  {
    try
    {
      if (!g.DK()) {
        throw new b();
      }
    }
    finally {}
    if (Sq().eHm == null) {
      Sq().eHm = new l(g.DP().dKu);
    }
    l locall = Sq().eHm;
    return locall;
  }
  
  public static y.a Sw()
  {
    if (!g.DK()) {
      throw new b();
    }
    if (Sq().eHl == null) {
      Sq().eHl = new y.a();
    }
    return Sq().eHl;
  }
  
  public static m Sx()
  {
    if (!g.DK()) {
      throw new b();
    }
    if (Sq().eHo == null) {
      Sq().eHo = new m();
    }
    return Sq().eHo;
  }
  
  private static void Sy()
  {
    boolean bool2 = false;
    if ((eHq != null) && (eHp != null)) {
      return;
    }
    boolean bool1;
    if (eHq != null)
    {
      bool1 = true;
      if (eHp != null) {
        bool2 = true;
      }
      y.w("MicroMsg.SubCoreVideo", "check decoder thread available fail, handler[%B] thread[%B] stack[%s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), bk.csb() });
      if (eHq != null) {
        eHq.removeCallbacksAndMessages(null);
      }
      if (eHp == null) {
        break label114;
      }
      eHp.a(null);
    }
    for (;;)
    {
      eHq = new ah(eHp.mnU.getLooper());
      return;
      bool1 = false;
      break;
      label114:
      eHp = new ai("Short-Video-Decoder-Thread-" + System.currentTimeMillis());
    }
  }
  
  public static boolean g(Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable == null) {
      return false;
    }
    Sy();
    if (paramLong > 0L) {
      eHq.postDelayed(paramRunnable, paramLong);
    }
    for (;;)
    {
      return true;
      eHq.post(paramRunnable);
    }
  }
  
  public static String getAccVideoPath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    g.DQ();
    return g.DP().dKt + "video/";
  }
  
  public static boolean q(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return true;
    }
    Sy();
    if (eHq == null)
    {
      y.e("MicroMsg.SubCoreVideo", "short video decoder handler is null");
      return false;
    }
    eHq.removeCallbacks(paramRunnable);
    return true;
  }
  
  public final void bh(boolean paramBoolean)
  {
    y.i("MicroMsg.SubCoreVideo", "%d onAccountPostReset ", new Object[] { Integer.valueOf(hashCode()) });
    Sw().a(this.eHt);
    e.d.a(Integer.valueOf(43), this.eHi);
    e.d.a(Integer.valueOf(44), this.eHi);
    e.d.a(Integer.valueOf(62), this.eHi);
    if (eHq != null) {
      eHq.removeCallbacksAndMessages(null);
    }
    g.DS().O(new o.4(this));
    File localFile = new File(k.Sl());
    if ((!localFile.exists()) || (!localFile.isDirectory())) {
      localFile.mkdirs();
    }
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  /* Error */
  public final void onAccountRelease()
  {
    // Byte code:
    //   0: ldc 197
    //   2: ldc_w 356
    //   5: iconst_1
    //   6: anewarray 4	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: aload_0
    //   12: invokevirtual 305	java/lang/Object:hashCode	()I
    //   15: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   18: aastore
    //   19: invokestatic 308	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   22: invokestatic 310	com/tencent/mm/modelvideo/o:Sw	()Lcom/tencent/mm/modelvideo/y$a;
    //   25: aload_0
    //   26: getfield 101	com/tencent/mm/modelvideo/o:eHt	Lcom/tencent/mm/modelvideo/p;
    //   29: invokevirtual 359	com/tencent/mm/modelvideo/y$a:b	(Lcom/tencent/mm/modelvideo/w;)V
    //   32: invokestatic 122	com/tencent/mm/modelvideo/o:Sq	()Lcom/tencent/mm/modelvideo/o;
    //   35: getfield 86	com/tencent/mm/modelvideo/o:eHl	Lcom/tencent/mm/modelvideo/y$a;
    //   38: ifnull +76 -> 114
    //   41: invokestatic 122	com/tencent/mm/modelvideo/o:Sq	()Lcom/tencent/mm/modelvideo/o;
    //   44: getfield 86	com/tencent/mm/modelvideo/o:eHl	Lcom/tencent/mm/modelvideo/y$a;
    //   47: astore_1
    //   48: aload_1
    //   49: iconst_0
    //   50: putfield 363	com/tencent/mm/modelvideo/y$a:bDY	I
    //   53: aload_1
    //   54: getfield 367	com/tencent/mm/modelvideo/y$a:eIr	Lcom/tencent/mm/modelvideo/d;
    //   57: ifnull +13 -> 70
    //   60: invokestatic 371	com/tencent/mm/kernel/g:Dk	()Lcom/tencent/mm/ah/p;
    //   63: aload_1
    //   64: getfield 367	com/tencent/mm/modelvideo/y$a:eIr	Lcom/tencent/mm/modelvideo/d;
    //   67: invokevirtual 377	com/tencent/mm/ah/p:c	(Lcom/tencent/mm/ah/m;)V
    //   70: aload_1
    //   71: getfield 381	com/tencent/mm/modelvideo/y$a:eIs	Lcom/tencent/mm/modelvideo/g;
    //   74: ifnull +13 -> 87
    //   77: invokestatic 371	com/tencent/mm/kernel/g:Dk	()Lcom/tencent/mm/ah/p;
    //   80: aload_1
    //   81: getfield 381	com/tencent/mm/modelvideo/y$a:eIs	Lcom/tencent/mm/modelvideo/g;
    //   84: invokevirtual 377	com/tencent/mm/ah/p:c	(Lcom/tencent/mm/ah/m;)V
    //   87: invokestatic 371	com/tencent/mm/kernel/g:Dk	()Lcom/tencent/mm/ah/p;
    //   90: sipush 149
    //   93: aload_1
    //   94: invokevirtual 384	com/tencent/mm/ah/p:b	(ILcom/tencent/mm/ah/f;)V
    //   97: invokestatic 371	com/tencent/mm/kernel/g:Dk	()Lcom/tencent/mm/ah/p;
    //   100: sipush 150
    //   103: aload_1
    //   104: invokevirtual 384	com/tencent/mm/ah/p:b	(ILcom/tencent/mm/ah/f;)V
    //   107: invokestatic 386	com/tencent/mm/modelvideo/o:Sr	()Lcom/tencent/mm/modelvideo/t;
    //   110: aload_1
    //   111: invokevirtual 389	com/tencent/mm/modelvideo/t:a	(Lcom/tencent/mm/modelvideo/t$a;)V
    //   114: invokestatic 122	com/tencent/mm/modelvideo/o:Sq	()Lcom/tencent/mm/modelvideo/o;
    //   117: getfield 92	com/tencent/mm/modelvideo/o:eHo	Lcom/tencent/mm/modelvideo/m;
    //   120: ifnull +56 -> 176
    //   123: invokestatic 122	com/tencent/mm/modelvideo/o:Sq	()Lcom/tencent/mm/modelvideo/o;
    //   126: getfield 92	com/tencent/mm/modelvideo/o:eHo	Lcom/tencent/mm/modelvideo/m;
    //   129: astore_1
    //   130: aload_1
    //   131: iconst_0
    //   132: putfield 390	com/tencent/mm/modelvideo/m:bDY	I
    //   135: ldc_w 392
    //   138: ldc_w 394
    //   141: iconst_1
    //   142: anewarray 4	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: aload_1
    //   148: getfield 397	com/tencent/mm/modelvideo/m:eGM	Ljava/lang/String;
    //   151: aastore
    //   152: invokestatic 308	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: aload_1
    //   156: getfield 397	com/tencent/mm/modelvideo/m:eGM	Ljava/lang/String;
    //   159: invokestatic 401	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   162: ifne +14 -> 176
    //   165: invokestatic 405	com/tencent/mm/ak/f:Nd	()Lcom/tencent/mm/ak/b;
    //   168: aload_1
    //   169: getfield 397	com/tencent/mm/modelvideo/m:eGM	Ljava/lang/String;
    //   172: invokevirtual 410	com/tencent/mm/ak/b:lL	(Ljava/lang/String;)Z
    //   175: pop
    //   176: invokestatic 122	com/tencent/mm/modelvideo/o:Sq	()Lcom/tencent/mm/modelvideo/o;
    //   179: getfield 96	com/tencent/mm/modelvideo/o:eHs	Lcom/tencent/mm/modelvideo/i;
    //   182: ifnull +21 -> 203
    //   185: invokestatic 122	com/tencent/mm/modelvideo/o:Sq	()Lcom/tencent/mm/modelvideo/o;
    //   188: getfield 96	com/tencent/mm/modelvideo/o:eHs	Lcom/tencent/mm/modelvideo/i;
    //   191: astore_1
    //   192: aload_1
    //   193: invokevirtual 413	com/tencent/mm/modelvideo/i:stopDownload	()V
    //   196: aload_1
    //   197: getfield 417	com/tencent/mm/modelvideo/i:eGw	Ljava/util/LinkedList;
    //   200: invokevirtual 422	java/util/LinkedList:clear	()V
    //   203: invokestatic 122	com/tencent/mm/modelvideo/o:Sq	()Lcom/tencent/mm/modelvideo/o;
    //   206: getfield 94	com/tencent/mm/modelvideo/o:eHr	Lcom/tencent/mm/ak/e;
    //   209: ifnull +20 -> 229
    //   212: invokestatic 122	com/tencent/mm/modelvideo/o:Sq	()Lcom/tencent/mm/modelvideo/o;
    //   215: getfield 94	com/tencent/mm/modelvideo/o:eHr	Lcom/tencent/mm/ak/e;
    //   218: astore_1
    //   219: invokestatic 371	com/tencent/mm/kernel/g:Dk	()Lcom/tencent/mm/ah/p;
    //   222: sipush 379
    //   225: aload_1
    //   226: invokevirtual 384	com/tencent/mm/ah/p:b	(ILcom/tencent/mm/ah/f;)V
    //   229: bipush 43
    //   231: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   234: aload_0
    //   235: getfield 84	com/tencent/mm/modelvideo/o:eHi	Lcom/tencent/mm/modelvideo/v;
    //   238: invokestatic 424	com/tencent/mm/ah/e$d:b	(Ljava/lang/Object;Lcom/tencent/mm/ah/e;)V
    //   241: bipush 44
    //   243: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   246: aload_0
    //   247: getfield 84	com/tencent/mm/modelvideo/o:eHi	Lcom/tencent/mm/modelvideo/v;
    //   250: invokestatic 424	com/tencent/mm/ah/e$d:b	(Ljava/lang/Object;Lcom/tencent/mm/ah/e;)V
    //   253: bipush 62
    //   255: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   258: aload_0
    //   259: getfield 84	com/tencent/mm/modelvideo/o:eHi	Lcom/tencent/mm/modelvideo/v;
    //   262: invokestatic 424	com/tencent/mm/ah/e$d:b	(Ljava/lang/Object;Lcom/tencent/mm/ah/e;)V
    //   265: getstatic 41	com/tencent/mm/modelvideo/o:eHq	Lcom/tencent/mm/sdk/platformtools/ah;
    //   268: ifnull +10 -> 278
    //   271: getstatic 41	com/tencent/mm/modelvideo/o:eHq	Lcom/tencent/mm/sdk/platformtools/ah;
    //   274: aconst_null
    //   275: invokevirtual 222	com/tencent/mm/sdk/platformtools/ah:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   278: invokestatic 310	com/tencent/mm/modelvideo/o:Sw	()Lcom/tencent/mm/modelvideo/y$a;
    //   281: astore_1
    //   282: ldc_w 426
    //   285: ldc_w 428
    //   288: iconst_1
    //   289: anewarray 4	java/lang/Object
    //   292: dup
    //   293: iconst_0
    //   294: aload_1
    //   295: getfield 431	com/tencent/mm/modelvideo/y$a:eIl	Landroid/os/HandlerThread;
    //   298: aastore
    //   299: invokestatic 308	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   302: aload_1
    //   303: getfield 431	com/tencent/mm/modelvideo/y$a:eIl	Landroid/os/HandlerThread;
    //   306: astore_2
    //   307: aload_2
    //   308: ifnull +26 -> 334
    //   311: aload_1
    //   312: getfield 431	com/tencent/mm/modelvideo/y$a:eIl	Landroid/os/HandlerThread;
    //   315: invokevirtual 434	android/os/HandlerThread:quit	()Z
    //   318: pop
    //   319: aload_1
    //   320: iconst_0
    //   321: putfield 438	com/tencent/mm/modelvideo/y$a:eIn	Z
    //   324: aload_1
    //   325: aconst_null
    //   326: putfield 441	com/tencent/mm/modelvideo/y$a:eIm	Lcom/tencent/mm/sdk/platformtools/ah;
    //   329: aload_1
    //   330: aconst_null
    //   331: putfield 431	com/tencent/mm/modelvideo/y$a:eIl	Landroid/os/HandlerThread;
    //   334: return
    //   335: astore_1
    //   336: ldc 197
    //   338: aload_1
    //   339: ldc_w 443
    //   342: iconst_0
    //   343: anewarray 4	java/lang/Object
    //   346: invokestatic 447	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   349: goto -120 -> 229
    //   352: astore_1
    //   353: ldc_w 426
    //   356: ldc_w 449
    //   359: iconst_1
    //   360: anewarray 4	java/lang/Object
    //   363: dup
    //   364: iconst_0
    //   365: aload_1
    //   366: invokevirtual 452	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   369: aastore
    //   370: invokestatic 454	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   373: return
    //   374: astore_1
    //   375: ldc 197
    //   377: ldc_w 456
    //   380: iconst_1
    //   381: anewarray 4	java/lang/Object
    //   384: dup
    //   385: iconst_0
    //   386: aload_1
    //   387: invokevirtual 452	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   390: aastore
    //   391: invokestatic 454	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   394: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	395	0	this	o
    //   47	283	1	localObject	Object
    //   335	4	1	localException1	java.lang.Exception
    //   352	14	1	localException2	java.lang.Exception
    //   374	13	1	localException3	java.lang.Exception
    //   306	2	2	localHandlerThread	HandlerThread
    // Exception table:
    //   from	to	target	type
    //   32	70	335	java/lang/Exception
    //   70	87	335	java/lang/Exception
    //   87	114	335	java/lang/Exception
    //   114	176	335	java/lang/Exception
    //   176	203	335	java/lang/Exception
    //   203	229	335	java/lang/Exception
    //   311	334	352	java/lang/Exception
    //   278	307	374	java/lang/Exception
    //   353	373	374	java/lang/Exception
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return dgp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvideo.o
 * JD-Core Version:    0.7.0.1
 */