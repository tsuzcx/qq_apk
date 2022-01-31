package com.tencent.mm.plugin.expt.hellhound.a.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cdy;
import com.tencent.mm.protocal.protobuf.cfg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class d
{
  private static volatile d mbe;
  private int XO;
  private int iPy;
  private AbsListView leN;
  private WindowManager lnU;
  private long mLastTimestamp;
  private int mScreenHeight;
  private int mScrollState;
  private Class<?> mbA;
  private Field mbB;
  private Field mbC;
  private Field mbD;
  private Field mbE;
  private Field mbF;
  private int mbG;
  private Class<?> mbf;
  private Field mbg;
  private Method mbh;
  private Field mbi;
  private AbsListView.OnScrollListener mbj;
  private d.a mbk;
  private int mbl;
  private Class<?> mbm;
  private Map<String, a> mbn;
  private cfg mbo;
  private long mbq;
  private e mbr;
  private c mbs;
  private int mbt;
  private Field mbu;
  private int mbv;
  private int mbw;
  private int mbx;
  private long mby;
  private String mbz;
  
  @SuppressLint({"NewApi"})
  private d()
  {
    AppMethodBeat.i(73469);
    this.mbq = 0L;
    this.mScrollState = 0;
    this.leN = null;
    this.mbt = 0;
    this.mbv = 0;
    this.mbw = 0;
    this.mbx = -1;
    this.mby = 0L;
    this.mLastTimestamp = -1L;
    this.mbz = "";
    this.XO = -1;
    this.iPy = -1;
    this.mScreenHeight = 0;
    this.mbG = 0;
    this.lnU = null;
    this.mbl = ViewConfiguration.get(ah.getContext()).getScaledTouchSlop();
    try
    {
      this.mbf = Class.forName("com.tencent.mm.plugin.sns.ui.SnsTimeLineUI");
      this.mbi = this.mbf.getDeclaredField("mUIAction");
      this.mbi.setAccessible(true);
      this.mbh = Class.forName("com.tencent.mm.plugin.sns.ui.SnsUIAction").getDeclaredMethod("getSnsListView", new Class[0]);
      this.mbh.setAccessible(true);
      this.mbg = AbsListView.class.getDeclaredField("mOnScrollListener");
      this.mbg.setAccessible(true);
      this.mbm = Class.forName("com.tencent.mm.plugin.sns.ui.AdFrameLayout");
      this.mbu = AbsListView.class.getDeclaredField("mMotionY");
      this.mbu.setAccessible(true);
      this.mbA = Class.forName("com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem$BaseViewHolder");
      this.mbB = this.mbA.getDeclaredField("timeLineObject");
      this.mbB.setAccessible(true);
      this.mbC = Class.forName("com.tencent.mm.protocal.protobuf.TimeLineObject").getDeclaredField("Id");
      this.mbC.setAccessible(true);
      this.mbD = this.mbA.getDeclaredField("snsobj");
      this.mbD.setAccessible(true);
      Class localClass = Class.forName("com.tencent.mm.protocal.protobuf.SnsObject");
      this.mbF = localClass.getDeclaredField("CommentUserList");
      this.mbF.setAccessible(true);
      this.mbE = localClass.getDeclaredField("LikeCount");
      this.mbE.setAccessible(true);
      this.mbk = new d.a(this, (byte)0);
      this.mbn = new HashMap();
      AppMethodBeat.o(73469);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("TimelineMonitor", localException, "habbyge-mali, TimelineMonitor OnScrollListener", new Object[0]);
      }
    }
  }
  
  private void R(Activity paramActivity)
  {
    AppMethodBeat.i(73475);
    ab.i("TimelineMonitor", "habbyge-mali, restoreScrollListener");
    try
    {
      paramActivity = this.mbi.get(paramActivity);
      paramActivity = (ListView)this.mbh.invoke(paramActivity, new Object[0]);
      this.mbg.set(paramActivity, this.mbj);
      AppMethodBeat.o(73475);
      return;
    }
    catch (Exception paramActivity)
    {
      ab.printErrStackTrace("TimelineMonitor", paramActivity, "habbyge-mali, restoreScrollListener", new Object[0]);
      AppMethodBeat.o(73475);
    }
  }
  
  private com.tencent.mm.vending.j.c<Map<a, Boolean>, Integer> a(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(73477);
    HashMap localHashMap = new HashMap();
    int i = paramInt - 1;
    paramInt = 0;
    if (i >= 0)
    {
      Object localObject = paramAbsListView.getChildAt(i);
      if (!this.mbm.isInstance(localObject)) {
        break label119;
      }
      localObject = dm((View)localObject);
      boolean bool = ((Boolean)((com.tencent.mm.vending.j.c)localObject).get(1)).booleanValue();
      localHashMap.put(((com.tencent.mm.vending.j.b)localObject).get(0), Boolean.valueOf(bool));
      if (!bool) {
        break label119;
      }
      paramInt += 1;
    }
    label119:
    for (;;)
    {
      i -= 1;
      break;
      paramAbsListView = com.tencent.mm.vending.j.a.C(localHashMap, Integer.valueOf(paramInt));
      AppMethodBeat.o(73477);
      return paramAbsListView;
    }
  }
  
  public static void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(73470);
    if (!"com.tencent.mm.plugin.sns.ui.SnsTimeLineUI".equals(paramString))
    {
      AppMethodBeat.o(73470);
      return;
    }
    if (!com.tencent.mm.plugin.expt.hellhound.a.brq())
    {
      AppMethodBeat.o(73470);
      return;
    }
    d locald = bsx();
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(73470);
      return;
      ab.i("TimelineMonitor", "habbyge-mali, TimelineMonitor.startMonitor");
      locald.mScrollState = 0;
      if (locald.iPy <= 0)
      {
        paramString = paramActivity.getResources();
        locald.iPy = paramString.getDimensionPixelSize(paramString.getIdentifier("status_bar_height", "dimen", "android"));
        if (locald.iPy <= 0) {
          locald.iPy = paramString.getDimensionPixelSize(2131428403);
        }
        ab.i("TimelineMonitor", "habbyge-mali, initStatusBarHeight: " + locald.iPy);
      }
      try
      {
        if (locald.lnU == null) {
          locald.lnU = ((WindowManager)ah.getContext().getSystemService("window"));
        }
        paramString = locald.lnU.getDefaultDisplay();
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Point localPoint1;
          Point localPoint2;
          paramString = paramActivity.getWindowManager().getDefaultDisplay();
          continue;
          locald.bsy();
          continue;
          ab.d("TimelineMonitor", "habbyge-mali, ActivityActionWrapper.FINISH_ACTIVITY");
          continue;
          if (System.currentTimeMillis() - locald.mbq > 30000L)
          {
            ab.i("TimelineMonitor", "habbyge-mali, _handleActivityMethod.BACK_2_FRONT: New Session");
            locald.bsz();
            locald.bsy();
          }
          else
          {
            ab.i("TimelineMonitor", "habbyge-mali, _handleActivityMethod.BACK_2_FRONT: Old Session");
          }
        }
        locald.mbk.activity = paramActivity;
        try
        {
          paramString = locald.mbi.get(paramActivity);
          paramString = (ListView)locald.mbh.invoke(paramString, new Object[0]);
          locald.mbj = ((AbsListView.OnScrollListener)locald.mbg.get(paramString));
          if (!(locald.mbj instanceof d.a)) {
            break label524;
          }
          ab.i("TimelineMonitor", "habbyge-mali, mOldScrollListener is OnProxyScrollListener !!");
          AppMethodBeat.o(73470);
          return;
          ab.i("TimelineMonitor", "habbyge-mali, oldScrollListener: " + locald.mbj);
          paramString.setOnScrollListener(locald.mbk);
          AppMethodBeat.o(73470);
          return;
        }
        catch (Exception paramString)
        {
          ab.printErrStackTrace("TimelineMonitor", paramString, "habbyge-mali, setProxyScrollListener", new Object[0]);
          AppMethodBeat.o(73470);
          return;
        }
      }
      localPoint1 = new Point();
      if (Build.VERSION.SDK_INT >= 13) {
        paramString.getSize(localPoint1);
      }
      localPoint2 = new Point();
      if (Build.VERSION.SDK_INT >= 17) {
        paramString.getRealSize(localPoint2);
      }
      locald.mScreenHeight = localPoint1.y;
      locald.mbG = localPoint2.y;
      ab.i("TimelineMonitor", "habbyge-mali, initScreenHeight = " + locald.mScreenHeight + " / " + locald.mbG);
      paramInt = com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.brJ();
      ab.i("TimelineMonitor", "habbyge-mali, startMonitor activityMethod: ".concat(String.valueOf(paramInt)));
      switch (paramInt)
      {
      default: 
        if ((paramActivity == null) || (paramActivity.isFinishing()))
        {
          AppMethodBeat.o(73470);
          return;
        }
        break;
      }
      label524:
      ab.i("TimelineMonitor", "habbyge-mali, stopMonitor");
      for (;;)
      {
        try
        {
          paramInt = com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.brJ();
          switch (paramInt)
          {
          default: 
            return;
          }
        }
        finally
        {
          locald.R(paramActivity);
          if (locald.mbk == null) {
            continue;
          }
          locald.mbk.activity = null;
          AppMethodBeat.o(73470);
        }
        ab.i("TimelineMonitor", "habbyge-mali, stopMonitor.START_ACTIVITY");
        locald.bsA();
        continue;
        ab.i("TimelineMonitor", "habbyge-mali, stopMonitor.FINISH_ACTIVITY");
        locald.bsz();
        continue;
        locald.bsA();
        locald.mbq = System.currentTimeMillis();
        ab.i("TimelineMonitor", "habbyge-mali, stopMonitor.FRONT_2_BACK");
      }
      AppMethodBeat.o(73470);
      return;
      ab.i("TimelineMonitor", "habbyge-mali, TimelineMonitor, freeOnDestroy !");
      locald.mbf = null;
      locald.mbj = null;
      locald.mbk = null;
      if (locald.mbn != null) {
        locald.mbn.clear();
      }
      locald.mbo = null;
      locald.lnU = null;
      locald.leN = null;
      mbe = null;
      AppMethodBeat.o(73470);
      return;
      locald.bsz();
    }
  }
  
  /* Error */
  private void a(View paramView, PInt paramPInt1, PInt paramPInt2)
  {
    // Byte code:
    //   0: ldc_w 493
    //   3: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_3
    //   7: iconst_0
    //   8: putfield 497	com/tencent/mm/pointers/PInt:value	I
    //   11: aload_2
    //   12: iconst_0
    //   13: putfield 497	com/tencent/mm/pointers/PInt:value	I
    //   16: aload_1
    //   17: invokevirtual 503	android/view/View:getTag	()Ljava/lang/Object;
    //   20: astore_1
    //   21: aload_1
    //   22: ifnonnull +10 -> 32
    //   25: ldc_w 493
    //   28: invokestatic 220	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: return
    //   32: aload_0
    //   33: getfield 197	com/tencent/mm/plugin/expt/hellhound/a/c/d:mbD	Ljava/lang/reflect/Field;
    //   36: astore 7
    //   38: aload 7
    //   40: ifnonnull +10 -> 50
    //   43: ldc_w 493
    //   46: invokestatic 220	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: return
    //   50: aload_0
    //   51: getfield 197	com/tencent/mm/plugin/expt/hellhound/a/c/d:mbD	Ljava/lang/reflect/Field;
    //   54: aload_1
    //   55: invokevirtual 243	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   58: astore_1
    //   59: aload_1
    //   60: ifnull +103 -> 163
    //   63: aload_0
    //   64: getfield 207	com/tencent/mm/plugin/expt/hellhound/a/c/d:mbE	Ljava/lang/reflect/Field;
    //   67: aload_1
    //   68: invokevirtual 243	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   71: checkcast 298	java/lang/Integer
    //   74: invokevirtual 506	java/lang/Integer:intValue	()I
    //   77: istore 4
    //   79: aload_0
    //   80: getfield 203	com/tencent/mm/plugin/expt/hellhound/a/c/d:mbF	Ljava/lang/reflect/Field;
    //   83: aload_1
    //   84: invokevirtual 243	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   87: checkcast 508	java/util/LinkedList
    //   90: astore_1
    //   91: iload 4
    //   93: istore 5
    //   95: aload_1
    //   96: ifnull +57 -> 153
    //   99: aload_1
    //   100: invokevirtual 511	java/util/LinkedList:size	()I
    //   103: istore 6
    //   105: iload 4
    //   107: istore 5
    //   109: iload 6
    //   111: istore 4
    //   113: aload_2
    //   114: iload 5
    //   116: putfield 497	com/tencent/mm/pointers/PInt:value	I
    //   119: aload_3
    //   120: iload 4
    //   122: putfield 497	com/tencent/mm/pointers/PInt:value	I
    //   125: ldc_w 493
    //   128: invokestatic 220	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: return
    //   132: astore_1
    //   133: iconst_0
    //   134: istore 4
    //   136: ldc 222
    //   138: aload_1
    //   139: ldc_w 513
    //   142: iconst_0
    //   143: anewarray 4	java/lang/Object
    //   146: invokestatic 230	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   149: iload 4
    //   151: istore 5
    //   153: iconst_0
    //   154: istore 4
    //   156: goto -43 -> 113
    //   159: astore_1
    //   160: goto -24 -> 136
    //   163: iconst_0
    //   164: istore 4
    //   166: iconst_0
    //   167: istore 5
    //   169: goto -56 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	d
    //   0	172	1	paramView	View
    //   0	172	2	paramPInt1	PInt
    //   0	172	3	paramPInt2	PInt
    //   77	88	4	i	int
    //   93	75	5	j	int
    //   103	7	6	k	int
    //   36	3	7	localField	Field
    // Exception table:
    //   from	to	target	type
    //   32	38	132	java/lang/Exception
    //   50	59	132	java/lang/Exception
    //   63	79	132	java/lang/Exception
    //   79	91	159	java/lang/Exception
    //   99	105	159	java/lang/Exception
  }
  
  private void a(AbsListView paramAbsListView, int paramInt, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(73476);
    if (paramAbsListView == null)
    {
      AppMethodBeat.o(73476);
      return;
    }
    if (this.mbs.startTime > 0L)
    {
      this.mbs.endTime = paramLong;
      long l = this.mbs.endTime - this.mbs.startTime;
      if (l <= 0L)
      {
        AppMethodBeat.o(73476);
        return;
      }
      paramAbsListView = a(paramAbsListView, paramInt);
      Object localObject1 = (Map)paramAbsListView.get(0);
      paramInt = ((Integer)paramAbsListView.get(1)).intValue();
      if (paramInt <= 0)
      {
        AppMethodBeat.o(73476);
        return;
      }
      double d = l / paramInt;
      paramAbsListView = ((Map)localObject1).entrySet().iterator();
      while (paramAbsListView.hasNext())
      {
        Object localObject2 = (Map.Entry)paramAbsListView.next();
        localObject1 = (a)((Map.Entry)localObject2).getKey();
        if (((Boolean)((Map.Entry)localObject2).getValue()).booleanValue()) {
          if (this.mbn.containsKey(((a)localObject1).mbc.feedId))
          {
            localObject2 = (a)this.mbn.get(((a)localObject1).mbc.feedId);
            if (localObject2 != null)
            {
              cdy localcdy = ((a)localObject2).mbc;
              localcdy.xOz += d;
              localcdy = ((a)localObject2).mbc;
              localcdy.xOA += l;
              a((a)localObject2, (a)localObject1);
              this.mbn.put(((a)localObject1).mbc.feedId, localObject2);
              ((a)localObject2).mbc.lPs = ((a)localObject1).mbc.lPs;
              ((a)localObject2).mbc.xOB = ((a)localObject1).mbc.xOB;
            }
          }
          else
          {
            ((a)localObject1).mbc.xOz = d;
            ((a)localObject1).mbc.xOA = l;
            this.mbn.put(((a)localObject1).mbc.feedId, localObject1);
          }
        }
      }
      if (paramBoolean)
      {
        this.mbs.startTime = paramLong;
        AppMethodBeat.o(73476);
        return;
      }
      this.mbs.startTime = 0L;
    }
    AppMethodBeat.o(73476);
  }
  
  private static void a(a parama1, a parama2)
  {
    parama1.mbc.y = parama2.mbc.y;
    parama1.mbc.height = parama2.mbc.height;
    parama1.mbc.lCk = parama2.mbc.lCk;
    parama1.mbc.sbb = parama2.mbc.sbb;
    parama1.mbc.iiX = parama2.mbc.iiX;
    parama1.mbc.xOv = parama2.mbc.xOv;
  }
  
  private void bsA()
  {
    AppMethodBeat.i(73473);
    if (this.mbr == null)
    {
      AppMethodBeat.o(73473);
      return;
    }
    ab.i("TimelineMonitor", "habbyge-mali, _stopComputeTimelineSliceTime");
    if (this.mbr == null)
    {
      AppMethodBeat.o(73473);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2;
    long l3;
    cfg localcfg;
    if (this.mbr.mbJ > 0L)
    {
      this.mbr.mbK = l1;
      if (this.mbo != null)
      {
        l2 = this.mbr.mbK;
        l3 = this.mbr.mbJ;
        localcfg = this.mbo;
        localcfg.xPH = (l2 - l3 + localcfg.xPH);
      }
      this.mbr.bsC();
      a(this.leN, this.mbt, l1, false);
    }
    if (this.mbr.mbL > 0L)
    {
      this.mbr.mbM = l1;
      if (this.mbo != null)
      {
        l2 = this.mbr.mbM;
        l3 = this.mbr.mbL;
        localcfg = this.mbo;
        localcfg.xPI = (l2 - l3 + localcfg.xPI);
        this.mbr.bsD();
      }
    }
    else if (this.mbr.mbN > 0L)
    {
      this.mbr.mbO = l1;
      ab.i("TimelineMonitor", "habbyge-mali, _stopComputeTimelineSliceTime mTimelineTime.endTimeFront = ".concat(String.valueOf(l1)));
      if (this.mbo == null) {
        break label335;
      }
      l1 = this.mbr.mbO;
      l2 = this.mbr.mbN;
      localcfg = this.mbo;
      localcfg.xPG = (l1 - l2 + localcfg.xPG);
      ab.i("TimelineMonitor", "habbyge-mali, _stopComputeTimelineSliceTime mTimelineTime.frontTime = " + this.mbo.xPG);
    }
    for (;;)
    {
      this.mbr.bsE();
      AppMethodBeat.o(73473);
      return;
      ab.e("TimelineMonitor", "habbyge-mali, _stopComputeTimelineSliceTime mSnsTimeline = NULL 2");
      break;
      label335:
      ab.e("TimelineMonitor", "habbyge-mali, _stopComputeTimelineSliceTime mSnsTimeline = NULL 3");
    }
  }
  
  private void bsB()
  {
    AppMethodBeat.i(73474);
    if ((this.mbn == null) || (this.mbn.isEmpty()))
    {
      AppMethodBeat.o(73474);
      return;
    }
    ab.i("TimelineMonitor", "habbyge-mali, _moveMonitoringFeed2ReadyReport");
    Iterator localIterator = this.mbn.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (localObject != null)
      {
        localObject = (a)((Map.Entry)localObject).getValue();
        if ((localObject != null) && (this.mbo != null)) {
          this.mbo.xPJ.add(((a)localObject).mbc);
        }
      }
    }
    this.mbn.clear();
    AppMethodBeat.o(73474);
  }
  
  private static d bsx()
  {
    AppMethodBeat.i(73468);
    if (mbe == null) {}
    try
    {
      if (mbe == null) {
        mbe = new d();
      }
      d locald = mbe;
      AppMethodBeat.o(73468);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(73468);
    }
  }
  
  private void bsy()
  {
    AppMethodBeat.i(73471);
    ab.i("TimelineMonitor", "habbyge-mali, reNewSession");
    this.mbo = new cfg();
    this.mbo.xPG = 0L;
    long l = System.currentTimeMillis();
    this.mbo.czq = "1000".concat(String.valueOf(l));
    this.mbo.xPH = 0L;
    this.mbo.xPI = 0L;
    this.mbn.clear();
    this.mbr = new e();
    this.mbs = new c();
    AppMethodBeat.o(73471);
  }
  
  private void bsz()
  {
    AppMethodBeat.i(73472);
    if (this.mbo == null)
    {
      AppMethodBeat.o(73472);
      return;
    }
    bsA();
    bsB();
    final cfg localcfg = this.mbo;
    this.mbo = null;
    com.tencent.mm.sdk.g.d.ysm.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(73465);
        b.a(localcfg);
        AppMethodBeat.o(73465);
      }
    }, "_reportTimeline");
    AppMethodBeat.o(73472);
  }
  
  private com.tencent.mm.vending.j.c<a, Boolean> dm(View paramView)
  {
    AppMethodBeat.i(73478);
    Object localObject = dp(paramView);
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    a(paramView, localPInt1, localPInt2);
    paramView = dn(paramView);
    int i = ((Integer)paramView.get(0)).intValue();
    int j = ((Integer)paramView.get(1)).intValue();
    paramView = new a();
    paramView.mbc = new cdy();
    paramView.mbc.feedId = ((String)localObject);
    paramView.mbc.lPs = localPInt1.value;
    paramView.mbc.xOB = localPInt2.value;
    paramView.mbc.y = i;
    paramView.mbc.height = j;
    paramView.mbc.iiX = this.mbG;
    paramView.mbc.xOv = (this.mbG - this.mScreenHeight);
    paramView.mbc.qZo = this.iPy;
    localObject = paramView.mbc;
    if (this.XO <= 0) {}
    for (i = 144;; i = this.XO)
    {
      ((cdy)localObject).xOw = i;
      paramView.mbc.lCk = this.mScrollState;
      paramView.mbc.sbb = this.mbw;
      paramView = com.tencent.mm.vending.j.a.C(paramView, Boolean.valueOf(paramView.bsw()));
      AppMethodBeat.o(73478);
      return paramView;
    }
  }
  
  private static com.tencent.mm.vending.j.c<Integer, Integer> dn(View paramView)
  {
    AppMethodBeat.i(73479);
    int i = paramView.getHeight();
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    paramView = com.tencent.mm.vending.j.a.C(Integer.valueOf(arrayOfInt[1]), Integer.valueOf(i));
    AppMethodBeat.o(73479);
    return paramView;
  }
  
  private static int jdMethod_do(View paramView)
  {
    AppMethodBeat.i(73480);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[1];
    AppMethodBeat.o(73480);
    return i;
  }
  
  private String dp(View paramView)
  {
    AppMethodBeat.i(73481);
    paramView = paramView.getTag();
    if (paramView == null)
    {
      AppMethodBeat.o(73481);
      return null;
    }
    try
    {
      boolean bool = this.mbA.isInstance(paramView);
      if (!bool)
      {
        AppMethodBeat.o(73481);
        return null;
      }
      paramView = this.mbB.get(paramView);
      if (paramView == null)
      {
        AppMethodBeat.o(73481);
        return null;
      }
    }
    catch (Exception paramView)
    {
      AppMethodBeat.o(73481);
      return null;
    }
    try
    {
      paramView = (String)this.mbC.get(paramView);
      AppMethodBeat.o(73481);
      return paramView;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        ab.printErrStackTrace("TimelineMonitor", paramView, "habbyge-mali, getFeedParams.feedId: ", new Object[0]);
        paramView = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.c.d
 * JD-Core Version:    0.7.0.1
 */