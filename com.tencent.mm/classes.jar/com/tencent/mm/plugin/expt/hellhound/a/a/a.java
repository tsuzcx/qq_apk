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
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.dfu;
import com.tencent.mm.protocal.protobuf.dhc;
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
  private int ahF;
  private int mFF;
  private int mScreenHeight;
  private int mScrollState;
  private final int qSR;
  private final int qSS;
  public final Map<String, c> qST;
  public final Map<String, Boolean> qSU;
  private dhc qSV;
  private long qSW;
  private g qSX;
  private f qSY;
  private final com.tencent.mm.plugin.expt.hellhound.a.a.a.b qSZ;
  private final String qTa;
  private String qTb;
  public int qTc;
  private boolean qTd;
  private boolean qTe;
  private WeakReference<ViewGroup> qTf;
  private int qTg;
  private int qTh;
  private int qTi;
  private WeakReference<LinearLayoutManager> qTj;
  private int qTk;
  private long qTl;
  private long qTm;
  private String qTn;
  private int qTo;
  private WindowManager qTp;
  
  public a(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(169282);
    this.mScrollState = 0;
    this.qSU = new HashMap();
    this.qSW = 0L;
    this.qTd = false;
    this.qTe = false;
    this.qTf = null;
    this.qTg = -1;
    this.qTh = 0;
    this.qTi = 0;
    this.qTj = null;
    this.qTk = -1;
    this.qTl = 0L;
    this.qTm = -1L;
    this.qTn = "";
    this.ahF = -1;
    this.mFF = -1;
    this.mScreenHeight = 0;
    this.qTo = 0;
    this.qTp = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.qSZ = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject);
      this.qSR = ViewConfiguration.get(aj.getContext()).getScaledTouchSlop();
      this.qST = new HashMap();
      this.qSS = paramInt;
      this.qTa = paramString1;
      this.qTb = paramString2;
      this.qTc = -1;
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
      this.qTl = 0L;
    }
    for (boolean bool = true;; bool = j(paramViewGroup, paramInt2))
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
    if (this.qSX.qTy <= 0L)
    {
      this.qSX.qTy = paramLong;
      if (this.qSY != null)
      {
        this.qSY.startTime = paramLong;
        if (this.qSS == 0) {}
      }
    }
    else
    {
      a(paramViewGroup, paramInt1, paramInt2, paramLong, true);
    }
    if (this.qSX.qTA > 0L)
    {
      this.qSX.qTB = paramLong;
      if (this.qSV != null)
      {
        paramLong = this.qSX.qTB;
        long l = this.qSX.qTA;
        paramViewGroup = this.qSV;
        paramViewGroup.HvB = (paramLong - l + paramViewGroup.HvB);
      }
      this.qSX.coH();
    }
    AppMethodBeat.o(186065);
  }
  
  private void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(169296);
    if ((paramViewGroup == null) || (this.qSY == null))
    {
      AppMethodBeat.o(169296);
      return;
    }
    this.qTe = false;
    if (this.qSY.startTime > 0L)
    {
      this.qSY.endTime = paramLong;
      long l = this.qSY.endTime - this.qSY.startTime;
      Object localObject1;
      if (l <= 0L)
      {
        if (this.qTd) {
          this.qTd = false;
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
      this.qSU.clear();
      double d = l / paramInt1;
      paramViewGroup = ((Map)localObject1).entrySet().iterator();
      while (paramViewGroup.hasNext())
      {
        Object localObject2 = (Map.Entry)paramViewGroup.next();
        localObject1 = (c)((Map.Entry)localObject2).getKey();
        if (((Boolean)((Map.Entry)localObject2).getValue()).booleanValue())
        {
          this.qSU.put(((c)localObject1).qTx.feedId, Boolean.valueOf(((c)localObject1).qTx.isAd));
          if (this.qST.containsKey(((c)localObject1).qTx.feedId))
          {
            localObject2 = (c)this.qST.get(((c)localObject1).qTx.feedId);
            if (localObject2 != null)
            {
              dfu localdfu = ((c)localObject2).qTx;
              localdfu.Huj += d;
              localdfu = ((c)localObject2).qTx;
              localdfu.Huk += l;
              a((c)localObject2, (c)localObject1);
              this.qST.put(((c)localObject1).qTx.feedId, localObject2);
              ((c)localObject2).qTx.likeCount = ((c)localObject1).qTx.likeCount;
              ((c)localObject2).qTx.commentCount = ((c)localObject1).qTx.commentCount;
              ((c)localObject2).qTx.userName = ((c)localObject1).qTx.userName;
              ((c)localObject2).qTx.bVF = ((c)localObject1).qTx.bVF;
              ((c)localObject2).qTx.isAd = ((c)localObject1).qTx.isAd;
            }
          }
          else
          {
            ((c)localObject1).qTx.Huj = d;
            ((c)localObject1).qTx.Huk = l;
            this.qST.put(((c)localObject1).qTx.feedId, localObject1);
          }
        }
      }
      if (paramBoolean)
      {
        this.qSY.startTime = paramLong;
        AppMethodBeat.o(169296);
        return;
      }
      this.qSY.startTime = 0L;
    }
    AppMethodBeat.o(169296);
  }
  
  private static void a(c paramc1, c paramc2)
  {
    paramc1.qTx.y = paramc2.qTx.y;
    paramc1.qTx.height = paramc2.qTx.height;
    paramc1.qTx.vi = paramc2.qTx.vi;
    paramc1.qTx.Aob = paramc2.qTx.Aob;
    paramc1.qTx.ltB = paramc2.qTx.ltB;
    paramc1.qTx.Hug = paramc2.qTx.Hug;
  }
  
  private com.tencent.mm.vending.j.c<c, Boolean> ac(View paramView, int paramInt)
  {
    AppMethodBeat.i(210363);
    Object localObject1 = this.qSZ.ad(paramView, paramInt);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      AppMethodBeat.o(210363);
      return null;
    }
    Object localObject2 = new PInt();
    Object localObject4 = new PInt();
    this.qSZ.a(paramView, (PInt)localObject2, (PInt)localObject4, paramInt);
    Object localObject3 = dV(paramView);
    int i = ((Integer)((com.tencent.mm.vending.j.b)localObject3).get(0)).intValue();
    int j = ((Integer)((com.tencent.mm.vending.j.c)localObject3).get(1)).intValue();
    localObject3 = new c();
    ((c)localObject3).qTx = new dfu();
    ((c)localObject3).qTx.feedId = ((String)localObject1);
    ((c)localObject3).qTx.likeCount = ((PInt)localObject2).value;
    ((c)localObject3).qTx.commentCount = ((PInt)localObject4).value;
    localObject2 = this.qSZ.ae(paramView, paramInt);
    localObject4 = ((c)localObject3).qTx;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    ((dfu)localObject4).userName = ((String)localObject1);
    localObject2 = this.qSZ.af(paramView, paramInt);
    localObject4 = ((c)localObject3).qTx;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    ((dfu)localObject4).bVF = ((String)localObject1);
    ((c)localObject3).qTx.isAd = this.qSZ.dX(paramView);
    ((c)localObject3).qTx.y = i;
    ((c)localObject3).qTx.height = j;
    ((c)localObject3).qTx.ltB = this.qTo;
    ((c)localObject3).qTx.Hug = (this.qTo - this.mScreenHeight);
    ((c)localObject3).qTx.yYM = this.mFF;
    paramView = ((c)localObject3).qTx;
    if (this.ahF <= 0) {}
    for (i = 144;; i = this.ahF)
    {
      paramView.sFm = i;
      ((c)localObject3).qTx.vi = this.mScrollState;
      ((c)localObject3).qTx.Aob = this.qTi;
      ((c)localObject3).position = paramInt;
      paramView = com.tencent.mm.vending.j.a.N(localObject3, Boolean.valueOf(((c)localObject3).CZ(this.qSS)));
      AppMethodBeat.o(210363);
      return paramView;
    }
  }
  
  private void ad(Activity paramActivity)
  {
    AppMethodBeat.i(169284);
    this.mScrollState = 0;
    af(paramActivity);
    ag(paramActivity);
    cox();
    AppMethodBeat.o(169284);
  }
  
  private void ae(Activity paramActivity)
  {
    AppMethodBeat.i(210360);
    this.mScrollState = 0;
    af(paramActivity);
    ag(paramActivity);
    coy();
    AppMethodBeat.o(210360);
  }
  
  private void af(Activity paramActivity)
  {
    AppMethodBeat.i(169303);
    if (this.mFF > 0)
    {
      AppMethodBeat.o(169303);
      return;
    }
    paramActivity = paramActivity.getResources();
    this.mFF = paramActivity.getDimensionPixelSize(paramActivity.getIdentifier("status_bar_height", "dimen", "android"));
    if (this.mFF <= 0) {
      this.mFF = paramActivity.getDimensionPixelSize(2131166269);
    }
    AppMethodBeat.o(169303);
  }
  
  @SuppressLint({"ObsoleteSdkInt"})
  private void ag(Activity paramActivity)
  {
    AppMethodBeat.i(169304);
    try
    {
      if (this.qTp == null) {
        this.qTp = ((WindowManager)aj.getContext().getSystemService("window"));
      }
      localObject = this.qTp.getDefaultDisplay();
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
    this.qTo = localPoint.y;
    AppMethodBeat.o(169304);
  }
  
  private void b(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186064);
    if (this.qSX == null)
    {
      AppMethodBeat.o(186064);
      return;
    }
    long l = System.currentTimeMillis();
    if (this.qSX.qTC <= 0L) {
      this.qSX.qTC = l;
    }
    if ((coE()) || (this.mScrollState == 0))
    {
      a(paramViewGroup, paramInt1, paramInt2, l);
      AppMethodBeat.o(186064);
      return;
    }
    if ((this.qSS == 0) && (this.qTc != -1))
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
    if (this.qSX.qTy > 0L)
    {
      this.qSX.qTz = paramLong;
      if (this.qSV != null)
      {
        long l1 = this.qSX.qTz;
        long l2 = this.qSX.qTy;
        dhc localdhc = this.qSV;
        localdhc.HvA = (l1 - l2 + localdhc.HvA);
      }
      this.qSX.coG();
      a(paramViewGroup, paramInt1, paramInt2, paramLong, false);
    }
    if (this.qSX.qTA <= 0L) {
      this.qSX.qTA = paramLong;
    }
    AppMethodBeat.o(186066);
  }
  
  private com.tencent.mm.vending.j.c<Map<c, Boolean>, Integer> c(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(169297);
    if (this.qSS == 0)
    {
      paramViewGroup = i(paramViewGroup, paramInt2);
      AppMethodBeat.o(169297);
      return paramViewGroup;
    }
    paramViewGroup = d(paramViewGroup, paramInt1, paramInt2);
    AppMethodBeat.o(169297);
    return paramViewGroup;
  }
  
  private void coA()
  {
    AppMethodBeat.i(169288);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(169280);
        a.a(a.this);
        a.this.fS(this.kgO, this.qTr);
        AppMethodBeat.o(169280);
      }
    });
    AppMethodBeat.o(169288);
  }
  
  private void coB()
  {
    AppMethodBeat.i(169289);
    if (this.qSX == null)
    {
      AppMethodBeat.o(169289);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2;
    long l3;
    Object localObject;
    if (this.qSX.qTy > 0L)
    {
      this.qSX.qTz = l1;
      if (this.qSV != null)
      {
        l2 = this.qSX.qTz;
        l3 = this.qSX.qTy;
        localObject = this.qSV;
        ((dhc)localObject).HvA = (l2 - l3 + ((dhc)localObject).HvA);
      }
      this.qSX.coG();
      if (this.qTf != null)
      {
        localObject = (ViewGroup)this.qTf.get();
        if (localObject != null) {
          a((ViewGroup)localObject, this.qTg, this.qTh, l1, false);
        }
      }
    }
    if (this.qSX.qTA > 0L)
    {
      this.qSX.qTB = l1;
      if (this.qSV == null) {
        break label296;
      }
      l2 = this.qSX.qTB;
      l3 = this.qSX.qTA;
      localObject = this.qSV;
      ((dhc)localObject).HvB = (l2 - l3 + ((dhc)localObject).HvB);
    }
    for (;;)
    {
      this.qSX.coH();
      if (this.qSX.qTC > 0L)
      {
        this.qSX.qTD = l1;
        if (this.qSV != null)
        {
          l1 = this.qSX.qTD;
          l2 = this.qSX.qTC;
          localObject = this.qSV;
          ((dhc)localObject).Hvz = (l1 - l2 + ((dhc)localObject).Hvz);
        }
        localObject = this.qSX;
        ((g)localObject).qTC = 0L;
        ((g)localObject).qTD = 0L;
      }
      AppMethodBeat.o(169289);
      return;
      label296:
      ad.e("HABBYGE-MALI.FeedMonitor", "_stopComputeTimelineSliceTime mSnsTimeline is NULL 2");
    }
  }
  
  private void coC()
  {
    AppMethodBeat.i(169290);
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.cnY();
    ad.i("HABBYGE-MALI.FeedMonitor", "stopMonitor, activityMethod: %s", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(169290);
      return;
      coB();
      AppMethodBeat.o(169290);
      return;
      coz();
      AppMethodBeat.o(169290);
      return;
      coB();
      this.qSW = System.currentTimeMillis();
    }
  }
  
  private void coD()
  {
    AppMethodBeat.i(210362);
    this.qTe = false;
    coz();
    AppMethodBeat.o(210362);
  }
  
  private boolean coE()
  {
    return this.qTl <= 1000L;
  }
  
  private void coF()
  {
    AppMethodBeat.i(169305);
    if (this.qST != null) {
      this.qST.clear();
    }
    this.qTp = null;
    if (this.qTf != null)
    {
      this.qTf.clear();
      this.qTf = null;
    }
    AppMethodBeat.o(169305);
  }
  
  private void cox()
  {
    AppMethodBeat.i(169285);
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.cnY();
    ad.i("HABBYGE-MALI.FeedMonitor", "startMonitor activityMethod: %d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(169285);
      return;
      fS(com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE().cpH(), com.tencent.mm.plugin.expt.hellhound.a.f.a.d.cpL());
      this.qTd = true;
      AppMethodBeat.o(169285);
      return;
      this.qTd = true;
      ViewGroup localViewGroup;
      if (this.qTf != null)
      {
        localViewGroup = (ViewGroup)this.qTf.get();
        if (localViewGroup != null) {
          a(localViewGroup, this.qTg, this.qTh);
        }
      }
      AppMethodBeat.o(169285);
      return;
      if (System.currentTimeMillis() - this.qSW > 30000L)
      {
        ad.i("HABBYGE-MALI.FeedMonitor", "_handleActivityMethod.BACK_2_FRONT: New Session");
        coA();
        AppMethodBeat.o(169285);
        return;
      }
      this.qTd = true;
      if (this.qTf != null)
      {
        localViewGroup = (ViewGroup)this.qTf.get();
        if (localViewGroup != null) {
          a(localViewGroup, this.qTg, this.qTh);
        }
      }
    }
  }
  
  private void coy()
  {
    AppMethodBeat.i(210361);
    fS(com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE().cpH(), com.tencent.mm.plugin.expt.hellhound.a.f.a.d.cpL());
    this.qTd = true;
    this.qTe = true;
    if (this.qTf != null)
    {
      ViewGroup localViewGroup = (ViewGroup)this.qTf.get();
      if (localViewGroup != null) {
        a(localViewGroup, Math.max(this.qTg, 0), Math.max(this.qTh, 1));
      }
    }
    AppMethodBeat.o(210361);
  }
  
  private void coz()
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
  
  private com.tencent.mm.vending.j.c<Map<c, Boolean>, Integer> d(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
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
          localObject1 = ac((View)localObject1, j);
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
        if (this.qTj != null)
        {
          localObject2 = (LinearLayoutManager)this.qTj.get();
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = (LinearLayoutManager)((RecyclerView)paramViewGroup).getLayoutManager();
          if (localObject1 == null) {
            break label255;
          }
          this.qTj = new WeakReference(localObject1);
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
            paramViewGroup = com.tencent.mm.vending.j.a.N(localHashMap, Integer.valueOf(i));
            AppMethodBeat.o(185576);
            return paramViewGroup;
          }
        }
        break label54;
      }
    }
  }
  
  private com.tencent.mm.vending.j.c<Integer, Integer> dV(View paramView)
  {
    AppMethodBeat.i(169300);
    if (this.qSS == 0) {}
    for (int i = paramView.getHeight();; i = Math.max(paramView.getMeasuredHeight(), paramView.getHeight()))
    {
      paramView = com.tencent.mm.vending.j.a.N(Integer.valueOf(Math.min(dW(paramView), (int)paramView.getY())), Integer.valueOf(i));
      AppMethodBeat.o(169300);
      return paramView;
    }
  }
  
  private static int dW(View paramView)
  {
    AppMethodBeat.i(169301);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[1];
    AppMethodBeat.o(169301);
    return i;
  }
  
  private com.tencent.mm.vending.j.c<Map<c, Boolean>, Integer> i(ViewGroup paramViewGroup, int paramInt)
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
      localObject = ac((View)localObject, i);
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
      paramViewGroup = com.tencent.mm.vending.j.a.N(localHashMap, Integer.valueOf(paramInt));
      AppMethodBeat.o(185575);
      return paramViewGroup;
    }
  }
  
  private boolean j(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(169299);
    paramViewGroup = k(paramViewGroup, paramInt);
    if (paramViewGroup == null)
    {
      AppMethodBeat.o(169299);
      return true;
    }
    String str = this.qSZ.ad(paramViewGroup, paramInt - 1);
    if (str == null)
    {
      AppMethodBeat.o(169299);
      return true;
    }
    if (!str.equals(this.qTn))
    {
      this.qTk = dW(paramViewGroup);
      this.qTm = System.currentTimeMillis();
      this.qTn = str;
      AppMethodBeat.o(169299);
      return true;
    }
    paramInt = dW(paramViewGroup);
    int i = Math.abs(paramInt - this.qTk);
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.qTm;
    if ((l2 > 0L) && (i > this.qSR))
    {
      this.qTl = (i * 1000L / l2);
      this.qTk = paramInt;
      this.qTm = l1;
      AppMethodBeat.o(169299);
      return true;
    }
    AppMethodBeat.o(169299);
    return false;
  }
  
  private static View k(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(169302);
    Object localObject1 = null;
    Object localObject2;
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
      AppMethodBeat.o(169302);
      return localObject1;
      if ((paramViewGroup instanceof RecyclerView))
      {
        localObject2 = (LinearLayoutManager)((RecyclerView)paramViewGroup).getLayoutManager();
        if (localObject2 != null)
        {
          localObject1 = ((LinearLayoutManager)localObject2).bY(((LinearLayoutManager)localObject2).ko());
          if (localObject1 == null)
          {
            localObject2 = paramViewGroup.getChildAt(((LinearLayoutManager)localObject2).ko());
            localObject1 = localObject2;
            if (localObject2 != null) {}
          }
        }
        else
        {
          localObject1 = paramViewGroup.getChildAt(paramInt - 1);
        }
      }
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
      ad(paramActivity);
      AppMethodBeat.o(169283);
      return;
      coC();
      AppMethodBeat.o(169283);
      return;
      coz();
      AppMethodBeat.o(169283);
      return;
      coF();
      AppMethodBeat.o(169283);
      return;
      ae(paramActivity);
      AppMethodBeat.o(169283);
      return;
      coD();
    }
  }
  
  public final void a(Activity paramActivity, ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(169291);
    if ((paramViewGroup instanceof RecyclerView)) {
      this.qSZ.setRecyclerView((RecyclerView)paramViewGroup);
    }
    if ((this.qTf == null) || (this.qTf.get() == null)) {
      this.qTf = new WeakReference(paramViewGroup);
    }
    this.qTg = paramInt1;
    this.qTh = paramInt2;
    if (this.mScrollState == 1) {}
    for (;;)
    {
      try
      {
        if (Math.abs(paramInt3) > this.qSR)
        {
          if (paramInt3 <= 0) {
            continue;
          }
          this.qTi = -1;
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
        this.qTi = 1;
        continue;
        if ((this.mScrollState == 0) && (this.ahF <= 0) && (paramActivity != null)) {
          try
          {
            if ((paramActivity instanceof AppCompatActivity))
            {
              paramActivity = ((AppCompatActivity)paramActivity).getSupportActionBar();
              if (paramActivity != null) {
                this.ahF = paramActivity.getCustomView().getHeight();
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
  
  final void fS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(169286);
    this.qSV = new dhc();
    this.qSV.Hvz = 0L;
    this.qSV.hIG = this.qTa;
    this.qSV.HvD = this.qTb;
    dhc localdhc = this.qSV;
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    localdhc.dyV = str;
    this.qSV.dxa = paramString2;
    ad.i("HABBYGE-MALI.FeedMonitor", "initTimelineParams: %s, %s", new Object[] { this.qSV.dyV, this.qSV.dxa });
    this.qSV.HvA = 0L;
    this.qSV.HvB = 0L;
    this.qST.clear();
    this.qSX = new g();
    this.qSY = new f();
    AppMethodBeat.o(169286);
  }
  
  public final void h(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(186062);
    this.mScrollState = paramInt;
    if ((this.qTf == null) || (this.qTf.get() == null)) {
      this.qTf = new WeakReference(paramViewGroup);
    }
    if ((paramViewGroup instanceof RecyclerView)) {
      this.qSZ.setRecyclerView((RecyclerView)paramViewGroup);
    }
    if (paramInt == 0) {
      this.qTi = 0;
    }
    if ((this.qSS == 0) && (paramInt != 2)) {
      this.qTc = -1;
    }
    if (this.qTe)
    {
      this.qTe = false;
      a(paramViewGroup, Math.max(this.qTg, 0), Math.max(this.qTh, 1), System.currentTimeMillis(), true);
    }
    AppMethodBeat.o(186062);
  }
  
  public final void kY(boolean paramBoolean)
  {
    AppMethodBeat.i(186061);
    ViewGroup localViewGroup;
    int j;
    if (this.qTf != null)
    {
      localViewGroup = (ViewGroup)this.qTf.get();
      if (localViewGroup != null)
      {
        j = localViewGroup.getChildCount();
        if (!paramBoolean) {
          break label57;
        }
      }
    }
    label57:
    for (int i = 0;; i = this.qTg)
    {
      b(localViewGroup, i, j);
      AppMethodBeat.o(186061);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.a
 * JD-Core Version:    0.7.0.1
 */