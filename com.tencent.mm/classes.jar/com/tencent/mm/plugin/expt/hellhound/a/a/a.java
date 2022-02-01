package com.tencent.mm.plugin.expt.hellhound.a.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.a.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.protocal.protobuf.cwd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  private boolean KEI;
  private WeakReference<LinearLayoutManager> KEJ;
  private int aeU;
  private int lDk;
  private int mScreenHeight;
  private int mScrollState;
  private long pFA;
  private long pFB;
  private String pFC;
  private int pFD;
  private WindowManager pFE;
  private int pFh;
  private int pFi;
  public final Map<String, g> pFj;
  public final Map<String, Boolean> pFk;
  private cwd pFl;
  private long pFm;
  private f pFn;
  private e pFo;
  private com.tencent.mm.plugin.expt.hellhound.a.a.a.b pFp;
  private String pFq;
  private String pFr;
  public int pFs;
  private boolean pFt;
  private ViewGroup pFu;
  private int pFv;
  private int pFw;
  private int pFx;
  private int pFz;
  
  public a(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(169282);
    this.mScrollState = 0;
    this.pFk = new HashMap();
    this.pFm = 0L;
    this.pFt = false;
    this.KEI = false;
    this.pFu = null;
    this.pFv = -1;
    this.pFw = 0;
    this.pFx = 0;
    this.KEJ = null;
    this.pFz = -1;
    this.pFA = 0L;
    this.pFB = -1L;
    this.pFC = "";
    this.aeU = -1;
    this.lDk = -1;
    this.mScreenHeight = 0;
    this.pFD = 0;
    this.pFE = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.pFp = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject);
      this.pFh = ViewConfiguration.get(aj.getContext()).getScaledTouchSlop();
      this.pFj = new HashMap();
      this.pFi = paramInt;
      this.pFq = paramString1;
      this.pFr = paramString2;
      this.pFs = -1;
      AppMethodBeat.o(169282);
      return;
      localObject = new com.tencent.mm.plugin.expt.hellhound.a.a.a.c();
      continue;
      localObject = new com.tencent.mm.plugin.expt.hellhound.a.a.a.a();
    }
  }
  
  private void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186063);
    if (this.mScrollState == 0) {
      this.pFA = 0L;
    }
    for (boolean bool = true;; bool = i(paramViewGroup, paramInt2))
    {
      if (bool) {
        b(paramViewGroup, paramInt1, paramInt2);
      }
      AppMethodBeat.o(186063);
      return;
    }
  }
  
  private void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(186065);
    if (this.pFn.pFJ <= 0L)
    {
      this.pFn.pFJ = paramLong;
      if (this.pFo != null)
      {
        this.pFo.startTime = paramLong;
        if (this.pFi == 0) {}
      }
    }
    else
    {
      a(paramViewGroup, paramInt1, paramInt2, paramLong, true);
    }
    if (this.pFn.pFL > 0L)
    {
      this.pFn.pFM = paramLong;
      if (this.pFl != null)
      {
        paramLong = this.pFn.pFM;
        long l = this.pFn.pFL;
        paramViewGroup = this.pFl;
        paramViewGroup.EnU = (paramLong - l + paramViewGroup.EnU);
      }
      this.pFn.cch();
    }
    AppMethodBeat.o(186065);
  }
  
  private void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(169296);
    if ((paramViewGroup == null) || (this.pFo == null))
    {
      AppMethodBeat.o(169296);
      return;
    }
    this.KEI = false;
    if (this.pFo.startTime > 0L)
    {
      this.pFo.endTime = paramLong;
      long l = this.pFo.endTime - this.pFo.startTime;
      Object localObject1;
      if (l <= 0L)
      {
        if (this.pFt) {
          this.pFt = false;
        }
      }
      else
      {
        paramViewGroup = c(paramViewGroup, paramInt1, paramInt2);
        localObject1 = (Map)paramViewGroup.get(0);
        paramInt1 = ((Integer)paramViewGroup.get(1)).intValue();
        if (paramInt1 > 0) {
          break label130;
        }
        AppMethodBeat.o(169296);
        return;
      }
      AppMethodBeat.o(169296);
      return;
      label130:
      this.pFk.clear();
      double d = l / paramInt1;
      paramViewGroup = ((Map)localObject1).entrySet().iterator();
      while (paramViewGroup.hasNext())
      {
        Object localObject2 = (Map.Entry)paramViewGroup.next();
        localObject1 = (g)((Map.Entry)localObject2).getKey();
        if (((Boolean)((Map.Entry)localObject2).getValue()).booleanValue())
        {
          this.pFk.put(((g)localObject1).KEO.feedId, Boolean.valueOf(((g)localObject1).KEO.isAd));
          if (this.pFj.containsKey(((g)localObject1).KEO.feedId))
          {
            localObject2 = (g)this.pFj.get(((g)localObject1).KEO.feedId);
            if (localObject2 != null)
            {
              cuv localcuv = ((g)localObject2).KEO;
              localcuv.EmC += d;
              localcuv = ((g)localObject2).KEO;
              localcuv.EmD += l;
              a((g)localObject2, (g)localObject1);
              this.pFj.put(((g)localObject1).KEO.feedId, localObject2);
              ((g)localObject2).KEO.likeCount = ((g)localObject1).KEO.likeCount;
              ((g)localObject2).KEO.commentCount = ((g)localObject1).KEO.commentCount;
              ((g)localObject2).KEO.userName = ((g)localObject1).KEO.userName;
              ((g)localObject2).KEO.bNK = ((g)localObject1).KEO.bNK;
              ((g)localObject2).KEO.isAd = ((g)localObject1).KEO.isAd;
            }
          }
          else
          {
            ((g)localObject1).KEO.EmC = d;
            ((g)localObject1).KEO.EmD = l;
            this.pFj.put(((g)localObject1).KEO.feedId, localObject1);
          }
        }
      }
      if (paramBoolean)
      {
        this.pFo.startTime = paramLong;
        AppMethodBeat.o(169296);
        return;
      }
      this.pFo.startTime = 0L;
    }
    AppMethodBeat.o(169296);
  }
  
  private static void a(g paramg1, g paramg2)
  {
    paramg1.KEO.y = paramg2.KEO.y;
    paramg1.KEO.height = paramg2.KEO.height;
    paramg1.KEO.sq = paramg2.KEO.sq;
    paramg1.KEO.xJB = paramg2.KEO.xJB;
    paramg1.KEO.kvo = paramg2.KEO.kvo;
    paramg1.KEO.Emz = paramg2.KEO.Emz;
  }
  
  private com.tencent.mm.vending.j.c<g, Boolean> aa(View paramView, int paramInt)
  {
    AppMethodBeat.i(205383);
    Object localObject1 = this.pFp.ab(paramView, paramInt);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      AppMethodBeat.o(205383);
      return null;
    }
    Object localObject2 = new PInt();
    Object localObject4 = new PInt();
    this.pFp.a(paramView, (PInt)localObject2, (PInt)localObject4, paramInt);
    Object localObject3 = dM(paramView);
    int i = ((Integer)((com.tencent.mm.vending.j.b)localObject3).get(0)).intValue();
    int j = ((Integer)((com.tencent.mm.vending.j.c)localObject3).get(1)).intValue();
    localObject3 = new g();
    ((g)localObject3).KEO = new cuv();
    ((g)localObject3).KEO.feedId = ((String)localObject1);
    ((g)localObject3).KEO.likeCount = ((PInt)localObject2).value;
    ((g)localObject3).KEO.commentCount = ((PInt)localObject4).value;
    localObject2 = this.pFp.ac(paramView, paramInt);
    localObject4 = ((g)localObject3).KEO;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    ((cuv)localObject4).userName = ((String)localObject1);
    localObject2 = this.pFp.ad(paramView, paramInt);
    localObject4 = ((g)localObject3).KEO;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    ((cuv)localObject4).bNK = ((String)localObject1);
    ((g)localObject3).KEO.isAd = this.pFp.dO(paramView);
    ((g)localObject3).KEO.y = i;
    ((g)localObject3).KEO.height = j;
    ((g)localObject3).KEO.kvo = this.pFD;
    ((g)localObject3).KEO.Emz = (this.pFD - this.mScreenHeight);
    ((g)localObject3).KEO.wxW = this.lDk;
    paramView = ((g)localObject3).KEO;
    if (this.aeU <= 0) {}
    for (i = 144;; i = this.aeU)
    {
      paramView.qPe = i;
      ((g)localObject3).KEO.sq = this.mScrollState;
      ((g)localObject3).KEO.xJB = this.pFx;
      ((g)localObject3).position = paramInt;
      paramView = com.tencent.mm.vending.j.a.L(localObject3, Boolean.valueOf(((g)localObject3).agR(this.pFi)));
      AppMethodBeat.o(205383);
      return paramView;
    }
  }
  
  private void ab(Activity paramActivity)
  {
    AppMethodBeat.i(169284);
    this.mScrollState = 0;
    ac(paramActivity);
    ad(paramActivity);
    cbZ();
    AppMethodBeat.o(169284);
  }
  
  private void ac(Activity paramActivity)
  {
    AppMethodBeat.i(169303);
    if (this.lDk > 0)
    {
      AppMethodBeat.o(169303);
      return;
    }
    paramActivity = paramActivity.getResources();
    this.lDk = paramActivity.getDimensionPixelSize(paramActivity.getIdentifier("status_bar_height", "dimen", "android"));
    if (this.lDk <= 0) {
      this.lDk = paramActivity.getDimensionPixelSize(2131166269);
    }
    AppMethodBeat.o(169303);
  }
  
  @SuppressLint({"ObsoleteSdkInt"})
  private void ad(Activity paramActivity)
  {
    AppMethodBeat.i(169304);
    try
    {
      if (this.pFE == null) {
        this.pFE = ((WindowManager)aj.getContext().getSystemService("window"));
      }
      localObject = this.pFE.getDefaultDisplay();
      paramActivity = (Activity)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        Point localPoint;
        paramActivity = paramActivity.getWindowManager().getDefaultDisplay();
      }
    }
    localObject = new Point();
    if (Build.VERSION.SDK_INT >= 13) {
      paramActivity.getSize((Point)localObject);
    }
    localPoint = new Point();
    if (Build.VERSION.SDK_INT >= 17) {
      paramActivity.getRealSize(localPoint);
    }
    this.mScreenHeight = ((Point)localObject).y;
    this.pFD = localPoint.y;
    AppMethodBeat.o(169304);
  }
  
  private void b(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186064);
    if (this.pFn == null)
    {
      AppMethodBeat.o(186064);
      return;
    }
    long l = System.currentTimeMillis();
    if (this.pFn.pFN <= 0L) {
      this.pFn.pFN = l;
    }
    if ((cce()) || (this.mScrollState == 0))
    {
      a(paramViewGroup, paramInt1, paramInt2, l);
      AppMethodBeat.o(186064);
      return;
    }
    if ((this.pFi == 0) && (this.pFs != -1))
    {
      a(paramViewGroup, paramInt1, paramInt2, l);
      AppMethodBeat.o(186064);
      return;
    }
    b(paramViewGroup, paramInt1, paramInt2, l);
    AppMethodBeat.o(186064);
  }
  
  private void b(ViewGroup paramViewGroup, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(186066);
    if (this.pFn.pFJ > 0L)
    {
      this.pFn.pFK = paramLong;
      if (this.pFl != null)
      {
        long l1 = this.pFn.pFK;
        long l2 = this.pFn.pFJ;
        cwd localcwd = this.pFl;
        localcwd.EnT = (l1 - l2 + localcwd.EnT);
      }
      this.pFn.ccg();
      a(paramViewGroup, paramInt1, paramInt2, paramLong, false);
    }
    if (this.pFn.pFL <= 0L) {
      this.pFn.pFL = paramLong;
    }
    AppMethodBeat.o(186066);
  }
  
  private void bu(Activity paramActivity)
  {
    AppMethodBeat.i(205380);
    this.mScrollState = 0;
    ac(paramActivity);
    ad(paramActivity);
    fRp();
    AppMethodBeat.o(205380);
  }
  
  private com.tencent.mm.vending.j.c<Map<g, Boolean>, Integer> c(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(169297);
    if (this.pFi == 0)
    {
      paramViewGroup = h(paramViewGroup, paramInt2);
      AppMethodBeat.o(169297);
      return paramViewGroup;
    }
    paramViewGroup = d(paramViewGroup, paramInt1, paramInt2);
    AppMethodBeat.o(169297);
    return paramViewGroup;
  }
  
  private void cbZ()
  {
    AppMethodBeat.i(169285);
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.cbN();
    ad.i("HABBYGE-MALI.FeedMonitor", "startMonitor activityMethod: %d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(169285);
      return;
      fv(com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH().ccJ(), d.ccN());
      this.pFt = true;
      AppMethodBeat.o(169285);
      return;
      this.pFt = true;
      a(this.pFu, this.pFv, this.pFw);
      AppMethodBeat.o(169285);
      return;
      if (System.currentTimeMillis() - this.pFm > 30000L)
      {
        ad.i("HABBYGE-MALI.FeedMonitor", "_handleActivityMethod.BACK_2_FRONT: New Session");
        ccb();
        AppMethodBeat.o(169285);
        return;
      }
      this.pFt = true;
      a(this.pFu, this.pFv, this.pFw);
    }
  }
  
  private void cca()
  {
    AppMethodBeat.i(169287);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(169279);
        a.a(a.this);
        AppMethodBeat.o(169279);
      }
    });
    AppMethodBeat.o(169287);
  }
  
  private void ccb()
  {
    AppMethodBeat.i(169288);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(169280);
        a.a(a.this);
        a.this.fv(this.jmq, this.pFG);
        AppMethodBeat.o(169280);
      }
    });
    AppMethodBeat.o(169288);
  }
  
  private void ccc()
  {
    AppMethodBeat.i(169289);
    if (this.pFn == null)
    {
      AppMethodBeat.o(169289);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2;
    long l3;
    Object localObject;
    if (this.pFn.pFJ > 0L)
    {
      this.pFn.pFK = l1;
      if (this.pFl != null)
      {
        l2 = this.pFn.pFK;
        l3 = this.pFn.pFJ;
        localObject = this.pFl;
        ((cwd)localObject).EnT = (l2 - l3 + ((cwd)localObject).EnT);
      }
      this.pFn.ccg();
      a(this.pFu, this.pFv, this.pFw, l1, false);
    }
    if (this.pFn.pFL > 0L)
    {
      this.pFn.pFM = l1;
      if (this.pFl == null) {
        break label274;
      }
      l2 = this.pFn.pFM;
      l3 = this.pFn.pFL;
      localObject = this.pFl;
      ((cwd)localObject).EnU = (l2 - l3 + ((cwd)localObject).EnU);
    }
    for (;;)
    {
      this.pFn.cch();
      if (this.pFn.pFN > 0L)
      {
        this.pFn.pFO = l1;
        if (this.pFl != null)
        {
          l1 = this.pFn.pFO;
          l2 = this.pFn.pFN;
          localObject = this.pFl;
          ((cwd)localObject).EnS = (l1 - l2 + ((cwd)localObject).EnS);
        }
        localObject = this.pFn;
        ((f)localObject).pFN = 0L;
        ((f)localObject).pFO = 0L;
      }
      AppMethodBeat.o(169289);
      return;
      label274:
      ad.e("HABBYGE-MALI.FeedMonitor", "_stopComputeTimelineSliceTime mSnsTimeline is NULL 2");
    }
  }
  
  private void ccd()
  {
    AppMethodBeat.i(169290);
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.cbN();
    ad.i("HABBYGE-MALI.FeedMonitor", "stopMonitor, activityMethod: %s", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(169290);
      return;
      ccc();
      AppMethodBeat.o(169290);
      return;
      cca();
      AppMethodBeat.o(169290);
      return;
      ccc();
      this.pFm = System.currentTimeMillis();
    }
  }
  
  private boolean cce()
  {
    return this.pFA <= 1000L;
  }
  
  private void ccf()
  {
    AppMethodBeat.i(169305);
    if (this.pFj != null) {
      this.pFj.clear();
    }
    this.pFE = null;
    this.pFu = null;
    AppMethodBeat.o(169305);
  }
  
  private com.tencent.mm.vending.j.c<Map<g, Boolean>, Integer> d(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(185576);
    HashMap localHashMap = new HashMap();
    if ((paramViewGroup instanceof RecyclerView)) {}
    for (RecyclerView localRecyclerView = (RecyclerView)paramViewGroup;; localRecyclerView = null)
    {
      paramInt2 -= 1;
      int i = 0;
      Object localObject1;
      int j;
      if (paramInt2 >= 0) {
        if (localRecyclerView == null)
        {
          localObject1 = paramViewGroup.getChildAt(paramInt2);
          j = paramInt2;
          label54:
          if (localObject1 == null) {
            break label255;
          }
          localObject1 = aa((View)localObject1, j);
          if (localObject1 == null) {
            break label255;
          }
          boolean bool = ((Boolean)((com.tencent.mm.vending.j.c)localObject1).get(1)).booleanValue();
          localHashMap.put(((com.tencent.mm.vending.j.b)localObject1).get(0), Boolean.valueOf(bool));
          if (!bool) {
            break label255;
          }
          i += 1;
        }
      }
      label255:
      for (;;)
      {
        paramInt2 -= 1;
        break;
        if (this.KEJ != null)
        {
          localObject2 = (LinearLayoutManager)this.KEJ.get();
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = (LinearLayoutManager)((RecyclerView)paramViewGroup).getLayoutManager();
          if (localObject1 == null) {
            break label255;
          }
          this.KEJ = new WeakReference(localObject1);
        }
        j = paramInt1 + paramInt2;
        Object localObject2 = ((LinearLayoutManager)localObject1).bY(j);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = paramViewGroup.getChildAt(paramInt2);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = paramViewGroup.getChildAt(j);
            break label54;
            paramViewGroup = com.tencent.mm.vending.j.a.L(localHashMap, Integer.valueOf(i));
            AppMethodBeat.o(185576);
            return paramViewGroup;
          }
        }
        break label54;
      }
    }
  }
  
  private com.tencent.mm.vending.j.c<Integer, Integer> dM(View paramView)
  {
    AppMethodBeat.i(169300);
    if (this.pFi == 0) {}
    for (int i = paramView.getHeight();; i = Math.max(paramView.getMeasuredHeight(), paramView.getHeight()))
    {
      paramView = com.tencent.mm.vending.j.a.L(Integer.valueOf(Math.min(dN(paramView), (int)paramView.getY())), Integer.valueOf(i));
      AppMethodBeat.o(169300);
      return paramView;
    }
  }
  
  private static int dN(View paramView)
  {
    AppMethodBeat.i(169301);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[1];
    AppMethodBeat.o(169301);
    return i;
  }
  
  private void fRp()
  {
    AppMethodBeat.i(205381);
    fv(com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH().ccJ(), d.ccN());
    this.pFt = true;
    this.KEI = true;
    a(this.pFu, Math.max(this.pFv, 0), Math.max(this.pFw, 1));
    AppMethodBeat.o(205381);
  }
  
  private void fRq()
  {
    AppMethodBeat.i(205382);
    this.KEI = false;
    cca();
    AppMethodBeat.o(205382);
  }
  
  private com.tencent.mm.vending.j.c<Map<g, Boolean>, Integer> h(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(185575);
    HashMap localHashMap = new HashMap();
    int i = paramInt - 1;
    paramInt = 0;
    if (i >= 0)
    {
      Object localObject = paramViewGroup.getChildAt(i);
      if (localObject == null) {
        break label118;
      }
      localObject = aa((View)localObject, i);
      if (localObject == null) {
        break label118;
      }
      boolean bool = ((Boolean)((com.tencent.mm.vending.j.c)localObject).get(1)).booleanValue();
      localHashMap.put(((com.tencent.mm.vending.j.b)localObject).get(0), Boolean.valueOf(bool));
      if (!bool) {
        break label118;
      }
      paramInt += 1;
    }
    label118:
    for (;;)
    {
      i -= 1;
      break;
      paramViewGroup = com.tencent.mm.vending.j.a.L(localHashMap, Integer.valueOf(paramInt));
      AppMethodBeat.o(185575);
      return paramViewGroup;
    }
  }
  
  private boolean i(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(169299);
    paramViewGroup = j(paramViewGroup, paramInt);
    if (paramViewGroup == null)
    {
      AppMethodBeat.o(169299);
      return true;
    }
    String str = this.pFp.ab(paramViewGroup, paramInt - 1);
    if (str == null)
    {
      AppMethodBeat.o(169299);
      return true;
    }
    if (!str.equals(this.pFC))
    {
      this.pFz = dN(paramViewGroup);
      this.pFB = System.currentTimeMillis();
      this.pFC = str;
      AppMethodBeat.o(169299);
      return true;
    }
    paramInt = dN(paramViewGroup);
    int i = Math.abs(paramInt - this.pFz);
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.pFB;
    if ((l2 > 0L) && (i > this.pFh))
    {
      this.pFA = (i * 1000L / l2);
      this.pFz = paramInt;
      this.pFB = l1;
      AppMethodBeat.o(169299);
      return true;
    }
    AppMethodBeat.o(169299);
    return false;
  }
  
  private static View j(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(169302);
    Object localObject2;
    Object localObject1;
    if ((paramViewGroup instanceof AbsListView))
    {
      localObject2 = paramViewGroup.getChildAt(paramInt - 1);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = paramViewGroup.getChildAt(((AbsListView)paramViewGroup).getLastVisiblePosition());
      }
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        AppMethodBeat.o(169302);
        return null;
        if (!(paramViewGroup instanceof RecyclerView)) {
          break label123;
        }
        localObject2 = (LinearLayoutManager)((RecyclerView)paramViewGroup).getLayoutManager();
        if (localObject2 != null)
        {
          localObject1 = ((LinearLayoutManager)localObject2).bY(((LinearLayoutManager)localObject2).jQ());
          if (localObject1 == null)
          {
            localObject2 = paramViewGroup.getChildAt(((LinearLayoutManager)localObject2).jQ());
            localObject1 = localObject2;
            if (localObject2 != null) {
              continue;
            }
          }
        }
        else
        {
          localObject1 = paramViewGroup.getChildAt(paramInt - 1);
        }
      }
      else
      {
        AppMethodBeat.o(169302);
        return localObject1;
      }
      continue;
      label123:
      localObject1 = null;
    }
  }
  
  public final void a(int paramInt, Activity paramActivity)
  {
    AppMethodBeat.i(169283);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(169283);
      return;
      ab(paramActivity);
      AppMethodBeat.o(169283);
      return;
      ccd();
      AppMethodBeat.o(169283);
      return;
      cca();
      AppMethodBeat.o(169283);
      return;
      ccf();
      AppMethodBeat.o(169283);
      return;
      bu(paramActivity);
      AppMethodBeat.o(169283);
      return;
      fRq();
    }
  }
  
  public final void a(Activity paramActivity, ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(169291);
    if ((paramViewGroup instanceof RecyclerView)) {
      this.pFp.setRecyclerView((RecyclerView)paramViewGroup);
    }
    this.pFu = paramViewGroup;
    this.pFv = paramInt1;
    this.pFw = paramInt2;
    if (this.mScrollState == 1) {}
    for (;;)
    {
      try
      {
        if (Math.abs(paramInt3) > this.pFh)
        {
          if (paramInt3 <= 0) {
            continue;
          }
          this.pFx = -1;
        }
      }
      catch (Exception paramActivity)
      {
        ad.printErrStackTrace("HABBYGE-MALI.FeedMonitor", paramActivity, "scrollingState, crash: %s", new Object[] { paramActivity.getMessage() });
        continue;
      }
      a(paramViewGroup, paramInt1, paramInt2);
      AppMethodBeat.o(169291);
      return;
      if (paramInt3 < 0)
      {
        this.pFx = 1;
        continue;
        if ((this.mScrollState == 0) && (this.aeU <= 0) && (paramActivity != null)) {
          try
          {
            if ((paramActivity instanceof AppCompatActivity))
            {
              paramActivity = ((AppCompatActivity)paramActivity).getSupportActionBar();
              if (paramActivity != null) {
                this.aeU = paramActivity.getCustomView().getHeight();
              }
            }
          }
          catch (Exception paramActivity)
          {
            ad.printErrStackTrace("HABBYGE-MALI.FeedMonitor", paramActivity, "initBarHeight", new Object[0]);
          }
        }
      }
    }
  }
  
  final void fv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(169286);
    this.pFl = new cwd();
    this.pFl.EnS = 0L;
    this.pFl.gPO = this.pFq;
    this.pFl.EnW = this.pFr;
    cwd localcwd = this.pFl;
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    localcwd.dpw = str;
    this.pFl.dnF = paramString2;
    ad.i("HABBYGE-MALI.FeedMonitor", "initTimelineParams: %s, %s", new Object[] { this.pFl.dpw, this.pFl.dnF });
    this.pFl.EnT = 0L;
    this.pFl.EnU = 0L;
    this.pFj.clear();
    this.pFn = new f();
    this.pFo = new e();
    AppMethodBeat.o(169286);
  }
  
  public final void g(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(186062);
    this.mScrollState = paramInt;
    this.pFu = paramViewGroup;
    if ((paramViewGroup instanceof RecyclerView)) {
      this.pFp.setRecyclerView((RecyclerView)paramViewGroup);
    }
    if (paramInt == 0) {
      this.pFx = 0;
    }
    if ((this.pFi == 0) && (paramInt != 2)) {
      this.pFs = -1;
    }
    if (this.KEI)
    {
      this.KEI = false;
      a(this.pFu, Math.max(this.pFv, 0), Math.max(this.pFw, 1), System.currentTimeMillis(), true);
    }
    AppMethodBeat.o(186062);
  }
  
  public final void kc(boolean paramBoolean)
  {
    AppMethodBeat.i(186061);
    int j;
    if (this.pFu != null)
    {
      j = this.pFu.getChildCount();
      if (!paramBoolean) {
        break label44;
      }
    }
    label44:
    for (int i = 0;; i = this.pFv)
    {
      b(this.pFu, i, j);
      AppMethodBeat.o(186061);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.a
 * JD-Core Version:    0.7.0.1
 */