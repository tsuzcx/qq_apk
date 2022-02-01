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
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.dzv;
import com.tencent.mm.protocal.protobuf.ebf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  private int mActionBarHeight;
  private int mScreenHeight;
  private int mScreenRealHeight;
  private int mScrollState;
  private int mStatusBarHeight;
  private int mVisibleItemCount;
  private long sBA;
  private String sBB;
  private WindowManager sBC;
  private final int sBg;
  private final int sBh;
  public final Map<String, c> sBi;
  public final Map<String, Boolean> sBj;
  private ebf sBk;
  private long sBl;
  private h sBm;
  private g sBn;
  private final com.tencent.mm.plugin.expt.hellhound.a.a.a.b sBo;
  private final String sBp;
  private String sBq;
  public int sBr;
  private boolean sBs;
  private boolean sBt;
  private WeakReference<ViewGroup> sBu;
  private int sBv;
  private int sBw;
  private WeakReference<LinearLayoutManager> sBx;
  private int sBy;
  private long sBz;
  
  public a(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(169282);
    this.mScrollState = 0;
    this.sBj = new HashMap();
    this.sBl = 0L;
    this.sBs = false;
    this.sBt = false;
    this.sBu = null;
    this.sBv = -1;
    this.mVisibleItemCount = 0;
    this.sBw = 0;
    this.sBx = null;
    this.sBy = -1;
    this.sBz = 0L;
    this.sBA = -1L;
    this.sBB = "";
    this.mActionBarHeight = -1;
    this.mStatusBarHeight = -1;
    this.mScreenHeight = 0;
    this.mScreenRealHeight = 0;
    this.sBC = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.sBo = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject);
      this.sBg = ViewConfiguration.get(MMApplicationContext.getContext()).getScaledTouchSlop();
      this.sBi = new HashMap();
      this.sBh = paramInt;
      this.sBp = paramString1;
      this.sBq = paramString2;
      this.sBr = -1;
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
      this.sBz = 0L;
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
    if (this.sBm.sBV <= 0L)
    {
      this.sBm.sBV = paramLong;
      if (this.sBn != null)
      {
        this.sBn.startTime = paramLong;
        if (this.sBh == 0) {}
      }
    }
    else
    {
      a(paramViewGroup, paramInt1, paramInt2, paramLong, true);
    }
    if (this.sBm.sBX > 0L)
    {
      this.sBm.sBY = paramLong;
      if (this.sBk != null)
      {
        paramLong = this.sBm.sBY;
        long l = this.sBm.sBX;
        paramViewGroup = this.sBk;
        paramViewGroup.NaU = (paramLong - l + paramViewGroup.NaU);
      }
      this.sBm.cOC();
    }
    AppMethodBeat.o(186065);
  }
  
  private void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(169296);
    if ((paramViewGroup == null) || (this.sBn == null))
    {
      AppMethodBeat.o(169296);
      return;
    }
    this.sBt = false;
    if (this.sBn.startTime > 0L)
    {
      this.sBn.endTime = paramLong;
      long l = this.sBn.endTime - this.sBn.startTime;
      Object localObject1;
      if (l <= 0L)
      {
        if (this.sBs) {
          this.sBs = false;
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
      this.sBj.clear();
      double d = l / paramInt1;
      paramViewGroup = ((Map)localObject1).entrySet().iterator();
      while (paramViewGroup.hasNext())
      {
        Object localObject2 = (Map.Entry)paramViewGroup.next();
        localObject1 = (c)((Map.Entry)localObject2).getKey();
        if (((Boolean)((Map.Entry)localObject2).getValue()).booleanValue())
        {
          this.sBj.put(((c)localObject1).sBK.feedId, Boolean.valueOf(((c)localObject1).sBK.isAd));
          if (this.sBi.containsKey(((c)localObject1).sBK.feedId))
          {
            localObject2 = (c)this.sBi.get(((c)localObject1).sBK.feedId);
            if (localObject2 != null)
            {
              dzv localdzv = ((c)localObject2).sBK;
              localdzv.MZt += d;
              localdzv = ((c)localObject2).sBK;
              localdzv.MZu += l;
              a((c)localObject2, (c)localObject1);
              this.sBi.put(((c)localObject1).sBK.feedId, localObject2);
              ((c)localObject2).sBK.likeCount = ((c)localObject1).sBK.likeCount;
              ((c)localObject2).sBK.commentCount = ((c)localObject1).sBK.commentCount;
              ((c)localObject2).sBK.userName = ((c)localObject1).sBK.userName;
              ((c)localObject2).sBK.nickName = ((c)localObject1).sBK.nickName;
              ((c)localObject2).sBK.isAd = ((c)localObject1).sBK.isAd;
            }
          }
          else
          {
            ((c)localObject1).sBK.MZt = d;
            ((c)localObject1).sBK.MZu = l;
            this.sBi.put(((c)localObject1).sBK.feedId, localObject1);
          }
        }
      }
      if (paramBoolean)
      {
        this.sBn.startTime = paramLong;
        AppMethodBeat.o(169296);
        return;
      }
      this.sBn.startTime = 0L;
    }
    AppMethodBeat.o(169296);
  }
  
  private static void a(c paramc1, c paramc2)
  {
    paramc1.sBK.y = paramc2.sBK.y;
    paramc1.sBK.height = paramc2.sBK.height;
    paramc1.sBK.vp = paramc2.sBK.vp;
    paramc1.sBK.EOS = paramc2.sBK.EOS;
    paramc1.sBK.mEY = paramc2.sBK.mEY;
    paramc1.sBK.virtualKeyHeight = paramc2.sBK.virtualKeyHeight;
  }
  
  private com.tencent.mm.vending.j.c<c, Boolean> ab(View paramView, int paramInt)
  {
    AppMethodBeat.i(220453);
    Object localObject1 = this.sBo.ac(paramView, paramInt);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      AppMethodBeat.o(220453);
      return null;
    }
    Object localObject2 = new PInt();
    Object localObject4 = new PInt();
    this.sBo.a(paramView, (PInt)localObject2, (PInt)localObject4, paramInt);
    Object localObject3 = dN(paramView);
    int i = ((Integer)((com.tencent.mm.vending.j.b)localObject3).get(0)).intValue();
    int j = ((Integer)((com.tencent.mm.vending.j.c)localObject3).get(1)).intValue();
    localObject3 = new c();
    ((c)localObject3).sBK = new dzv();
    ((c)localObject3).sBK.feedId = ((String)localObject1);
    ((c)localObject3).sBK.likeCount = ((PInt)localObject2).value;
    ((c)localObject3).sBK.commentCount = ((PInt)localObject4).value;
    localObject2 = this.sBo.ad(paramView, paramInt);
    localObject4 = ((c)localObject3).sBK;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    ((dzv)localObject4).userName = ((String)localObject1);
    localObject2 = this.sBo.ae(paramView, paramInt);
    localObject4 = ((c)localObject3).sBK;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    ((dzv)localObject4).nickName = ((String)localObject1);
    ((c)localObject3).sBK.isAd = this.sBo.dP(paramView);
    ((c)localObject3).sBK.y = i;
    ((c)localObject3).sBK.height = j;
    ((c)localObject3).sBK.mEY = this.mScreenRealHeight;
    ((c)localObject3).sBK.virtualKeyHeight = (this.mScreenRealHeight - this.mScreenHeight);
    ((c)localObject3).sBK.CHZ = this.mStatusBarHeight;
    paramView = ((c)localObject3).sBK;
    if (this.mActionBarHeight <= 0) {}
    for (i = 144;; i = this.mActionBarHeight)
    {
      paramView.udM = i;
      ((c)localObject3).sBK.vp = this.mScrollState;
      ((c)localObject3).sBK.EOS = this.sBw;
      ((c)localObject3).position = paramInt;
      paramView = com.tencent.mm.vending.j.a.Q(localObject3, Boolean.valueOf(((c)localObject3).GX(this.sBh)));
      AppMethodBeat.o(220453);
      return paramView;
    }
  }
  
  private void ac(Activity paramActivity)
  {
    AppMethodBeat.i(169284);
    this.mScrollState = 0;
    initStatusBarHeight(paramActivity);
    initScreenHeight(paramActivity);
    cOs();
    AppMethodBeat.o(169284);
  }
  
  private void ad(Activity paramActivity)
  {
    AppMethodBeat.i(220450);
    this.mScrollState = 0;
    initStatusBarHeight(paramActivity);
    initScreenHeight(paramActivity);
    cOt();
    AppMethodBeat.o(220450);
  }
  
  private void b(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186064);
    if (this.sBm == null)
    {
      AppMethodBeat.o(186064);
      return;
    }
    long l = System.currentTimeMillis();
    if (this.sBm.sBZ <= 0L) {
      this.sBm.sBZ = l;
    }
    if ((cOy()) || (this.mScrollState == 0))
    {
      a(paramViewGroup, paramInt1, paramInt2, l);
      AppMethodBeat.o(186064);
      return;
    }
    if ((this.sBh == 0) && (this.sBr != -1))
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
    if (this.sBm.sBV > 0L)
    {
      this.sBm.sBW = paramLong;
      if (this.sBk != null)
      {
        long l1 = this.sBm.sBW;
        long l2 = this.sBm.sBV;
        ebf localebf = this.sBk;
        localebf.NaT = (l1 - l2 + localebf.NaT);
      }
      this.sBm.cOB();
      a(paramViewGroup, paramInt1, paramInt2, paramLong, false);
    }
    if (this.sBm.sBX <= 0L) {
      this.sBm.sBX = paramLong;
    }
    AppMethodBeat.o(186066);
  }
  
  private com.tencent.mm.vending.j.c<Map<c, Boolean>, Integer> c(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(169297);
    if (this.sBh == 0)
    {
      paramViewGroup = h(paramViewGroup, paramInt2);
      AppMethodBeat.o(169297);
      return paramViewGroup;
    }
    paramViewGroup = d(paramViewGroup, paramInt1, paramInt2);
    AppMethodBeat.o(169297);
    return paramViewGroup;
  }
  
  private void cOs()
  {
    AppMethodBeat.i(169285);
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.cNT();
    Log.i("HABBYGE-MALI.FeedMonitor", "startMonitor activityMethod: %d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(169285);
      return;
      gq(com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().cPR(), d.cPV());
      this.sBs = true;
      AppMethodBeat.o(169285);
      return;
      this.sBs = true;
      ViewGroup localViewGroup;
      if (this.sBu != null)
      {
        localViewGroup = (ViewGroup)this.sBu.get();
        if (localViewGroup != null) {
          a(localViewGroup, this.sBv, this.mVisibleItemCount);
        }
      }
      AppMethodBeat.o(169285);
      return;
      if (System.currentTimeMillis() - this.sBl > 30000L)
      {
        Log.i("HABBYGE-MALI.FeedMonitor", "_handleActivityMethod.BACK_2_FRONT: New Session");
        cOv();
        AppMethodBeat.o(169285);
        return;
      }
      this.sBs = true;
      if (this.sBu != null)
      {
        localViewGroup = (ViewGroup)this.sBu.get();
        if (localViewGroup != null) {
          a(localViewGroup, this.sBv, this.mVisibleItemCount);
        }
      }
    }
  }
  
  private void cOt()
  {
    AppMethodBeat.i(220451);
    gq(com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().cPR(), d.cPV());
    this.sBs = true;
    this.sBt = true;
    if (this.sBu != null)
    {
      ViewGroup localViewGroup = (ViewGroup)this.sBu.get();
      if (localViewGroup != null) {
        a(localViewGroup, Math.max(this.sBv, 0), Math.max(this.mVisibleItemCount, 1));
      }
    }
    AppMethodBeat.o(220451);
  }
  
  private void cOu()
  {
    AppMethodBeat.i(169287);
    MMHandlerThread.postToMainThread(new Runnable()
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
  
  private void cOv()
  {
    AppMethodBeat.i(169288);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(169280);
        a.a(a.this);
        a.this.gq(this.lnN, this.sBE);
        AppMethodBeat.o(169280);
      }
    });
    AppMethodBeat.o(169288);
  }
  
  private void cOw()
  {
    AppMethodBeat.i(169289);
    if (this.sBm == null)
    {
      AppMethodBeat.o(169289);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2;
    long l3;
    Object localObject;
    if (this.sBm.sBV > 0L)
    {
      this.sBm.sBW = l1;
      if (this.sBk != null)
      {
        l2 = this.sBm.sBW;
        l3 = this.sBm.sBV;
        localObject = this.sBk;
        ((ebf)localObject).NaT = (l2 - l3 + ((ebf)localObject).NaT);
      }
      this.sBm.cOB();
      if (this.sBu != null)
      {
        localObject = (ViewGroup)this.sBu.get();
        if (localObject != null) {
          a((ViewGroup)localObject, this.sBv, this.mVisibleItemCount, l1, false);
        }
      }
    }
    if (this.sBm.sBX > 0L)
    {
      this.sBm.sBY = l1;
      if (this.sBk == null) {
        break label296;
      }
      l2 = this.sBm.sBY;
      l3 = this.sBm.sBX;
      localObject = this.sBk;
      ((ebf)localObject).NaU = (l2 - l3 + ((ebf)localObject).NaU);
    }
    for (;;)
    {
      this.sBm.cOC();
      if (this.sBm.sBZ > 0L)
      {
        this.sBm.sCa = l1;
        if (this.sBk != null)
        {
          l1 = this.sBm.sCa;
          l2 = this.sBm.sBZ;
          localObject = this.sBk;
          ((ebf)localObject).NaS = (l1 - l2 + ((ebf)localObject).NaS);
        }
        localObject = this.sBm;
        ((h)localObject).sBZ = 0L;
        ((h)localObject).sCa = 0L;
      }
      AppMethodBeat.o(169289);
      return;
      label296:
      Log.e("HABBYGE-MALI.FeedMonitor", "_stopComputeTimelineSliceTime mSnsTimeline is NULL 2");
    }
  }
  
  private void cOx()
  {
    AppMethodBeat.i(220452);
    this.sBt = false;
    cOu();
    AppMethodBeat.o(220452);
  }
  
  private boolean cOy()
  {
    return this.sBz <= 1000L;
  }
  
  private void cOz()
  {
    AppMethodBeat.i(169305);
    if (this.sBi != null) {
      this.sBi.clear();
    }
    this.sBC = null;
    if (this.sBu != null)
    {
      this.sBu.clear();
      this.sBu = null;
    }
    AppMethodBeat.o(169305);
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
          localObject1 = ab((View)localObject1, j);
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
        if (this.sBx != null)
        {
          localObject2 = (LinearLayoutManager)this.sBx.get();
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = (LinearLayoutManager)((RecyclerView)paramViewGroup).getLayoutManager();
          if (localObject1 == null) {
            break label255;
          }
          this.sBx = new WeakReference(localObject1);
        }
        j = paramInt1 + paramInt2;
        Object localObject2 = ((LinearLayoutManager)localObject1).findViewByPosition(j);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = paramViewGroup.getChildAt(paramInt2);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = paramViewGroup.getChildAt(j);
            break label54;
            paramViewGroup = com.tencent.mm.vending.j.a.Q(localHashMap, Integer.valueOf(i));
            AppMethodBeat.o(185576);
            return paramViewGroup;
          }
        }
        break label54;
      }
    }
  }
  
  private com.tencent.mm.vending.j.c<Integer, Integer> dN(View paramView)
  {
    AppMethodBeat.i(169300);
    if (this.sBh == 0) {}
    for (int i = paramView.getHeight();; i = Math.max(paramView.getMeasuredHeight(), paramView.getHeight()))
    {
      paramView = com.tencent.mm.vending.j.a.Q(Integer.valueOf(Math.min(getY(paramView), (int)paramView.getY())), Integer.valueOf(i));
      AppMethodBeat.o(169300);
      return paramView;
    }
  }
  
  private static int getY(View paramView)
  {
    AppMethodBeat.i(169301);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[1];
    AppMethodBeat.o(169301);
    return i;
  }
  
  private com.tencent.mm.vending.j.c<Map<c, Boolean>, Integer> h(ViewGroup paramViewGroup, int paramInt)
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
      localObject = ab((View)localObject, i);
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
      paramViewGroup = com.tencent.mm.vending.j.a.Q(localHashMap, Integer.valueOf(paramInt));
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
    String str = this.sBo.ac(paramViewGroup, paramInt - 1);
    if (str == null)
    {
      AppMethodBeat.o(169299);
      return true;
    }
    if (!str.equals(this.sBB))
    {
      this.sBy = getY(paramViewGroup);
      this.sBA = System.currentTimeMillis();
      this.sBB = str;
      AppMethodBeat.o(169299);
      return true;
    }
    paramInt = getY(paramViewGroup);
    int i = Math.abs(paramInt - this.sBy);
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.sBA;
    if ((l2 > 0L) && (i > this.sBg))
    {
      this.sBz = (i * 1000L / l2);
      this.sBy = paramInt;
      this.sBA = l1;
      AppMethodBeat.o(169299);
      return true;
    }
    AppMethodBeat.o(169299);
    return false;
  }
  
  @SuppressLint({"ObsoleteSdkInt"})
  private void initScreenHeight(Activity paramActivity)
  {
    AppMethodBeat.i(169304);
    try
    {
      if (this.sBC == null) {
        this.sBC = ((WindowManager)MMApplicationContext.getContext().getSystemService("window"));
      }
      localObject = this.sBC.getDefaultDisplay();
      paramActivity = (Activity)localObject;
    }
    catch (Exception localException)
    {
      Object localObject;
      Point localPoint;
      while (paramActivity != null) {
        paramActivity = paramActivity.getWindowManager().getDefaultDisplay();
      }
      AppMethodBeat.o(169304);
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
    this.mScreenRealHeight = localPoint.y;
    AppMethodBeat.o(169304);
    return;
  }
  
  private void initStatusBarHeight(Activity paramActivity)
  {
    AppMethodBeat.i(169303);
    if (this.mStatusBarHeight > 0)
    {
      AppMethodBeat.o(169303);
      return;
    }
    if (paramActivity == null)
    {
      AppMethodBeat.o(169303);
      return;
    }
    paramActivity = paramActivity.getResources();
    this.mStatusBarHeight = paramActivity.getDimensionPixelSize(paramActivity.getIdentifier("status_bar_height", "dimen", "android"));
    if (this.mStatusBarHeight <= 0) {
      this.mStatusBarHeight = paramActivity.getDimensionPixelSize(2131166312);
    }
    AppMethodBeat.o(169303);
  }
  
  private static View j(ViewGroup paramViewGroup, int paramInt)
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
          localObject1 = ((LinearLayoutManager)localObject2).findViewByPosition(((LinearLayoutManager)localObject2).ku());
          if (localObject1 == null)
          {
            localObject2 = paramViewGroup.getChildAt(((LinearLayoutManager)localObject2).ku());
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
  
  private void stopMonitor()
  {
    AppMethodBeat.i(169290);
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.cNT();
    Log.i("HABBYGE-MALI.FeedMonitor", "stopMonitor, activityMethod: %s", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(169290);
      return;
      cOw();
      AppMethodBeat.o(169290);
      return;
      cOu();
      AppMethodBeat.o(169290);
      return;
      cOw();
      this.sBl = System.currentTimeMillis();
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
      ac(paramActivity);
      AppMethodBeat.o(169283);
      return;
      stopMonitor();
      AppMethodBeat.o(169283);
      return;
      cOu();
      AppMethodBeat.o(169283);
      return;
      cOz();
      AppMethodBeat.o(169283);
      return;
      ad(paramActivity);
      AppMethodBeat.o(169283);
      return;
      cOx();
    }
  }
  
  public final void a(Activity paramActivity, ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(169291);
    if ((paramViewGroup instanceof RecyclerView)) {
      this.sBo.setRecyclerView((RecyclerView)paramViewGroup);
    }
    if ((this.sBu == null) || (this.sBu.get() == null)) {
      this.sBu = new WeakReference(paramViewGroup);
    }
    this.sBv = paramInt1;
    this.mVisibleItemCount = paramInt2;
    if (this.mScrollState == 1) {}
    for (;;)
    {
      try
      {
        if (Math.abs(paramInt3) > this.sBg)
        {
          if (paramInt3 <= 0) {
            continue;
          }
          this.sBw = -1;
        }
      }
      catch (Exception paramActivity)
      {
        Log.printErrStackTrace("HABBYGE-MALI.FeedMonitor", paramActivity, "scrollingState, crash: %s", new Object[] { paramActivity.getMessage() });
        continue;
      }
      a(paramViewGroup, paramInt1, paramInt2);
      AppMethodBeat.o(169291);
      return;
      if (paramInt3 < 0)
      {
        this.sBw = 1;
        continue;
        if ((this.mScrollState == 0) && (this.mActionBarHeight <= 0) && (paramActivity != null)) {
          try
          {
            if ((paramActivity instanceof AppCompatActivity))
            {
              paramActivity = ((AppCompatActivity)paramActivity).getSupportActionBar();
              if (paramActivity != null) {
                this.mActionBarHeight = paramActivity.getCustomView().getHeight();
              }
            }
          }
          catch (Exception paramActivity)
          {
            Log.printErrStackTrace("HABBYGE-MALI.FeedMonitor", paramActivity, "initBarHeight", new Object[0]);
          }
        }
      }
    }
  }
  
  public final void g(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(186062);
    this.mScrollState = paramInt;
    if ((this.sBu == null) || (this.sBu.get() == null)) {
      this.sBu = new WeakReference(paramViewGroup);
    }
    if ((paramViewGroup instanceof RecyclerView)) {
      this.sBo.setRecyclerView((RecyclerView)paramViewGroup);
    }
    if (paramInt == 0) {
      this.sBw = 0;
    }
    if ((this.sBh == 0) && (paramInt != 2)) {
      this.sBr = -1;
    }
    if (this.sBt)
    {
      this.sBt = false;
      a(paramViewGroup, Math.max(this.sBv, 0), Math.max(this.mVisibleItemCount, 1), System.currentTimeMillis(), true);
    }
    AppMethodBeat.o(186062);
  }
  
  final void gq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(169286);
    this.sBk = new ebf();
    this.sBk.NaS = 0L;
    this.sBk.iGB = this.sBp;
    this.sBk.NaW = this.sBq;
    ebf localebf = this.sBk;
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    localebf.dRM = str;
    this.sBk.dPM = paramString2;
    com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEy = this.sBk.dRM;
    Log.i("HABBYGE-MALI.FeedMonitor", "initTimelineParams: %s, %s", new Object[] { this.sBk.dRM, this.sBk.dPM });
    this.sBk.NaT = 0L;
    this.sBk.NaU = 0L;
    this.sBi.clear();
    this.sBm = new h();
    this.sBn = new g();
    AppMethodBeat.o(169286);
  }
  
  public final void mc(boolean paramBoolean)
  {
    AppMethodBeat.i(186061);
    ViewGroup localViewGroup;
    int j;
    if (this.sBu != null)
    {
      localViewGroup = (ViewGroup)this.sBu.get();
      if (localViewGroup != null)
      {
        j = localViewGroup.getChildCount();
        if (!paramBoolean) {
          break label57;
        }
      }
    }
    label57:
    for (int i = 0;; i = this.sBv)
    {
      b(localViewGroup, i, j);
      AppMethodBeat.o(186061);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.a
 * JD-Core Version:    0.7.0.1
 */