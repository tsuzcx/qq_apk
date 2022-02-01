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
import com.tencent.mm.protocal.protobuf.dgo;
import com.tencent.mm.protocal.protobuf.dhw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
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
  private int mKJ;
  private int mScreenHeight;
  private int mScrollState;
  private final int raP;
  private final int raQ;
  public final Map<String, c> raR;
  public final Map<String, Boolean> raS;
  private dhw raT;
  private long raU;
  private g raV;
  private f raW;
  private final com.tencent.mm.plugin.expt.hellhound.a.a.a.b raX;
  private final String raY;
  private String raZ;
  public int rba;
  private boolean rbb;
  private boolean rbc;
  private WeakReference<ViewGroup> rbd;
  private int rbe;
  private int rbf;
  private int rbg;
  private WeakReference<LinearLayoutManager> rbh;
  private int rbi;
  private long rbj;
  private long rbk;
  private String rbl;
  private int rbm;
  private WindowManager rbn;
  
  public a(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(169282);
    this.mScrollState = 0;
    this.raS = new HashMap();
    this.raU = 0L;
    this.rbb = false;
    this.rbc = false;
    this.rbd = null;
    this.rbe = -1;
    this.rbf = 0;
    this.rbg = 0;
    this.rbh = null;
    this.rbi = -1;
    this.rbj = 0L;
    this.rbk = -1L;
    this.rbl = "";
    this.ahF = -1;
    this.mKJ = -1;
    this.mScreenHeight = 0;
    this.rbm = 0;
    this.rbn = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.raX = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject);
      this.raP = ViewConfiguration.get(ak.getContext()).getScaledTouchSlop();
      this.raR = new HashMap();
      this.raQ = paramInt;
      this.raY = paramString1;
      this.raZ = paramString2;
      this.rba = -1;
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
      this.rbj = 0L;
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
    if (this.raV.rbw <= 0L)
    {
      this.raV.rbw = paramLong;
      if (this.raW != null)
      {
        this.raW.startTime = paramLong;
        if (this.raQ == 0) {}
      }
    }
    else
    {
      a(paramViewGroup, paramInt1, paramInt2, paramLong, true);
    }
    if (this.raV.rby > 0L)
    {
      this.raV.rbz = paramLong;
      if (this.raT != null)
      {
        paramLong = this.raV.rbz;
        long l = this.raV.rby;
        paramViewGroup = this.raT;
        paramViewGroup.HPe = (paramLong - l + paramViewGroup.HPe);
      }
      this.raV.cqj();
    }
    AppMethodBeat.o(186065);
  }
  
  private void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(169296);
    if ((paramViewGroup == null) || (this.raW == null))
    {
      AppMethodBeat.o(169296);
      return;
    }
    this.rbc = false;
    if (this.raW.startTime > 0L)
    {
      this.raW.endTime = paramLong;
      long l = this.raW.endTime - this.raW.startTime;
      Object localObject1;
      if (l <= 0L)
      {
        if (this.rbb) {
          this.rbb = false;
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
      this.raS.clear();
      double d = l / paramInt1;
      paramViewGroup = ((Map)localObject1).entrySet().iterator();
      while (paramViewGroup.hasNext())
      {
        Object localObject2 = (Map.Entry)paramViewGroup.next();
        localObject1 = (c)((Map.Entry)localObject2).getKey();
        if (((Boolean)((Map.Entry)localObject2).getValue()).booleanValue())
        {
          this.raS.put(((c)localObject1).rbv.feedId, Boolean.valueOf(((c)localObject1).rbv.isAd));
          if (this.raR.containsKey(((c)localObject1).rbv.feedId))
          {
            localObject2 = (c)this.raR.get(((c)localObject1).rbv.feedId);
            if (localObject2 != null)
            {
              dgo localdgo = ((c)localObject2).rbv;
              localdgo.HNM += d;
              localdgo = ((c)localObject2).rbv;
              localdgo.HNN += l;
              a((c)localObject2, (c)localObject1);
              this.raR.put(((c)localObject1).rbv.feedId, localObject2);
              ((c)localObject2).rbv.likeCount = ((c)localObject1).rbv.likeCount;
              ((c)localObject2).rbv.commentCount = ((c)localObject1).rbv.commentCount;
              ((c)localObject2).rbv.userName = ((c)localObject1).rbv.userName;
              ((c)localObject2).rbv.bVF = ((c)localObject1).rbv.bVF;
              ((c)localObject2).rbv.isAd = ((c)localObject1).rbv.isAd;
            }
          }
          else
          {
            ((c)localObject1).rbv.HNM = d;
            ((c)localObject1).rbv.HNN = l;
            this.raR.put(((c)localObject1).rbv.feedId, localObject1);
          }
        }
      }
      if (paramBoolean)
      {
        this.raW.startTime = paramLong;
        AppMethodBeat.o(169296);
        return;
      }
      this.raW.startTime = 0L;
    }
    AppMethodBeat.o(169296);
  }
  
  private static void a(c paramc1, c paramc2)
  {
    paramc1.rbv.y = paramc2.rbv.y;
    paramc1.rbv.height = paramc2.rbv.height;
    paramc1.rbv.vi = paramc2.rbv.vi;
    paramc1.rbv.AFo = paramc2.rbv.AFo;
    paramc1.rbv.lya = paramc2.rbv.lya;
    paramc1.rbv.HNJ = paramc2.rbv.HNJ;
  }
  
  private com.tencent.mm.vending.j.c<c, Boolean> ac(View paramView, int paramInt)
  {
    AppMethodBeat.i(196023);
    Object localObject1 = this.raX.ad(paramView, paramInt);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      AppMethodBeat.o(196023);
      return null;
    }
    Object localObject2 = new PInt();
    Object localObject4 = new PInt();
    this.raX.a(paramView, (PInt)localObject2, (PInt)localObject4, paramInt);
    Object localObject3 = dV(paramView);
    int i = ((Integer)((com.tencent.mm.vending.j.b)localObject3).get(0)).intValue();
    int j = ((Integer)((com.tencent.mm.vending.j.c)localObject3).get(1)).intValue();
    localObject3 = new c();
    ((c)localObject3).rbv = new dgo();
    ((c)localObject3).rbv.feedId = ((String)localObject1);
    ((c)localObject3).rbv.likeCount = ((PInt)localObject2).value;
    ((c)localObject3).rbv.commentCount = ((PInt)localObject4).value;
    localObject2 = this.raX.ae(paramView, paramInt);
    localObject4 = ((c)localObject3).rbv;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    ((dgo)localObject4).userName = ((String)localObject1);
    localObject2 = this.raX.af(paramView, paramInt);
    localObject4 = ((c)localObject3).rbv;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    ((dgo)localObject4).bVF = ((String)localObject1);
    ((c)localObject3).rbv.isAd = this.raX.dX(paramView);
    ((c)localObject3).rbv.y = i;
    ((c)localObject3).rbv.height = j;
    ((c)localObject3).rbv.lya = this.rbm;
    ((c)localObject3).rbv.HNJ = (this.rbm - this.mScreenHeight);
    ((c)localObject3).rbv.zpn = this.mKJ;
    paramView = ((c)localObject3).rbv;
    if (this.ahF <= 0) {}
    for (i = 144;; i = this.ahF)
    {
      paramView.sQl = i;
      ((c)localObject3).rbv.vi = this.mScrollState;
      ((c)localObject3).rbv.AFo = this.rbg;
      ((c)localObject3).position = paramInt;
      paramView = com.tencent.mm.vending.j.a.N(localObject3, Boolean.valueOf(((c)localObject3).Dm(this.raQ)));
      AppMethodBeat.o(196023);
      return paramView;
    }
  }
  
  private void ae(Activity paramActivity)
  {
    AppMethodBeat.i(169284);
    this.mScrollState = 0;
    ag(paramActivity);
    ah(paramActivity);
    cpZ();
    AppMethodBeat.o(169284);
  }
  
  private void af(Activity paramActivity)
  {
    AppMethodBeat.i(196020);
    this.mScrollState = 0;
    ag(paramActivity);
    ah(paramActivity);
    cqa();
    AppMethodBeat.o(196020);
  }
  
  private void ag(Activity paramActivity)
  {
    AppMethodBeat.i(169303);
    if (this.mKJ > 0)
    {
      AppMethodBeat.o(169303);
      return;
    }
    paramActivity = paramActivity.getResources();
    this.mKJ = paramActivity.getDimensionPixelSize(paramActivity.getIdentifier("status_bar_height", "dimen", "android"));
    if (this.mKJ <= 0) {
      this.mKJ = paramActivity.getDimensionPixelSize(2131166269);
    }
    AppMethodBeat.o(169303);
  }
  
  @SuppressLint({"ObsoleteSdkInt"})
  private void ah(Activity paramActivity)
  {
    AppMethodBeat.i(169304);
    try
    {
      if (this.rbn == null) {
        this.rbn = ((WindowManager)ak.getContext().getSystemService("window"));
      }
      localObject = this.rbn.getDefaultDisplay();
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
    this.rbm = localPoint.y;
    AppMethodBeat.o(169304);
  }
  
  private void b(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186064);
    if (this.raV == null)
    {
      AppMethodBeat.o(186064);
      return;
    }
    long l = System.currentTimeMillis();
    if (this.raV.rbA <= 0L) {
      this.raV.rbA = l;
    }
    if ((cqg()) || (this.mScrollState == 0))
    {
      a(paramViewGroup, paramInt1, paramInt2, l);
      AppMethodBeat.o(186064);
      return;
    }
    if ((this.raQ == 0) && (this.rba != -1))
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
    if (this.raV.rbw > 0L)
    {
      this.raV.rbx = paramLong;
      if (this.raT != null)
      {
        long l1 = this.raV.rbx;
        long l2 = this.raV.rbw;
        dhw localdhw = this.raT;
        localdhw.HPd = (l1 - l2 + localdhw.HPd);
      }
      this.raV.cqi();
      a(paramViewGroup, paramInt1, paramInt2, paramLong, false);
    }
    if (this.raV.rby <= 0L) {
      this.raV.rby = paramLong;
    }
    AppMethodBeat.o(186066);
  }
  
  private com.tencent.mm.vending.j.c<Map<c, Boolean>, Integer> c(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(169297);
    if (this.raQ == 0)
    {
      paramViewGroup = i(paramViewGroup, paramInt2);
      AppMethodBeat.o(169297);
      return paramViewGroup;
    }
    paramViewGroup = d(paramViewGroup, paramInt1, paramInt2);
    AppMethodBeat.o(169297);
    return paramViewGroup;
  }
  
  private void cpZ()
  {
    AppMethodBeat.i(169285);
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.cpA();
    ae.i("HABBYGE-MALI.FeedMonitor", "startMonitor activityMethod: %d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(169285);
      return;
      fX(com.tencent.mm.plugin.expt.hellhound.a.f.b.crg().crj(), com.tencent.mm.plugin.expt.hellhound.a.f.a.d.crn());
      this.rbb = true;
      AppMethodBeat.o(169285);
      return;
      this.rbb = true;
      ViewGroup localViewGroup;
      if (this.rbd != null)
      {
        localViewGroup = (ViewGroup)this.rbd.get();
        if (localViewGroup != null) {
          a(localViewGroup, this.rbe, this.rbf);
        }
      }
      AppMethodBeat.o(169285);
      return;
      if (System.currentTimeMillis() - this.raU > 30000L)
      {
        ae.i("HABBYGE-MALI.FeedMonitor", "_handleActivityMethod.BACK_2_FRONT: New Session");
        cqc();
        AppMethodBeat.o(169285);
        return;
      }
      this.rbb = true;
      if (this.rbd != null)
      {
        localViewGroup = (ViewGroup)this.rbd.get();
        if (localViewGroup != null) {
          a(localViewGroup, this.rbe, this.rbf);
        }
      }
    }
  }
  
  private void cqa()
  {
    AppMethodBeat.i(196021);
    fX(com.tencent.mm.plugin.expt.hellhound.a.f.b.crg().crj(), com.tencent.mm.plugin.expt.hellhound.a.f.a.d.crn());
    this.rbb = true;
    this.rbc = true;
    if (this.rbd != null)
    {
      ViewGroup localViewGroup = (ViewGroup)this.rbd.get();
      if (localViewGroup != null) {
        a(localViewGroup, Math.max(this.rbe, 0), Math.max(this.rbf, 1));
      }
    }
    AppMethodBeat.o(196021);
  }
  
  private void cqb()
  {
    AppMethodBeat.i(169287);
    ar.f(new Runnable()
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
  
  private void cqc()
  {
    AppMethodBeat.i(169288);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(169280);
        a.a(a.this);
        a.this.fX(this.kke, this.rbp);
        AppMethodBeat.o(169280);
      }
    });
    AppMethodBeat.o(169288);
  }
  
  private void cqd()
  {
    AppMethodBeat.i(169289);
    if (this.raV == null)
    {
      AppMethodBeat.o(169289);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2;
    long l3;
    Object localObject;
    if (this.raV.rbw > 0L)
    {
      this.raV.rbx = l1;
      if (this.raT != null)
      {
        l2 = this.raV.rbx;
        l3 = this.raV.rbw;
        localObject = this.raT;
        ((dhw)localObject).HPd = (l2 - l3 + ((dhw)localObject).HPd);
      }
      this.raV.cqi();
      if (this.rbd != null)
      {
        localObject = (ViewGroup)this.rbd.get();
        if (localObject != null) {
          a((ViewGroup)localObject, this.rbe, this.rbf, l1, false);
        }
      }
    }
    if (this.raV.rby > 0L)
    {
      this.raV.rbz = l1;
      if (this.raT == null) {
        break label296;
      }
      l2 = this.raV.rbz;
      l3 = this.raV.rby;
      localObject = this.raT;
      ((dhw)localObject).HPe = (l2 - l3 + ((dhw)localObject).HPe);
    }
    for (;;)
    {
      this.raV.cqj();
      if (this.raV.rbA > 0L)
      {
        this.raV.rbB = l1;
        if (this.raT != null)
        {
          l1 = this.raV.rbB;
          l2 = this.raV.rbA;
          localObject = this.raT;
          ((dhw)localObject).HPc = (l1 - l2 + ((dhw)localObject).HPc);
        }
        localObject = this.raV;
        ((g)localObject).rbA = 0L;
        ((g)localObject).rbB = 0L;
      }
      AppMethodBeat.o(169289);
      return;
      label296:
      ae.e("HABBYGE-MALI.FeedMonitor", "_stopComputeTimelineSliceTime mSnsTimeline is NULL 2");
    }
  }
  
  private void cqe()
  {
    AppMethodBeat.i(169290);
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.cpA();
    ae.i("HABBYGE-MALI.FeedMonitor", "stopMonitor, activityMethod: %s", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(169290);
      return;
      cqd();
      AppMethodBeat.o(169290);
      return;
      cqb();
      AppMethodBeat.o(169290);
      return;
      cqd();
      this.raU = System.currentTimeMillis();
    }
  }
  
  private void cqf()
  {
    AppMethodBeat.i(196022);
    this.rbc = false;
    cqb();
    AppMethodBeat.o(196022);
  }
  
  private boolean cqg()
  {
    return this.rbj <= 1000L;
  }
  
  private void cqh()
  {
    AppMethodBeat.i(169305);
    if (this.raR != null) {
      this.raR.clear();
    }
    this.rbn = null;
    if (this.rbd != null)
    {
      this.rbd.clear();
      this.rbd = null;
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
        if (this.rbh != null)
        {
          localObject2 = (LinearLayoutManager)this.rbh.get();
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = (LinearLayoutManager)((RecyclerView)paramViewGroup).getLayoutManager();
          if (localObject1 == null) {
            break label255;
          }
          this.rbh = new WeakReference(localObject1);
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
    if (this.raQ == 0) {}
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
    String str = this.raX.ad(paramViewGroup, paramInt - 1);
    if (str == null)
    {
      AppMethodBeat.o(169299);
      return true;
    }
    if (!str.equals(this.rbl))
    {
      this.rbi = dW(paramViewGroup);
      this.rbk = System.currentTimeMillis();
      this.rbl = str;
      AppMethodBeat.o(169299);
      return true;
    }
    paramInt = dW(paramViewGroup);
    int i = Math.abs(paramInt - this.rbi);
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.rbk;
    if ((l2 > 0L) && (i > this.raP))
    {
      this.rbj = (i * 1000L / l2);
      this.rbi = paramInt;
      this.rbk = l1;
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
      ae(paramActivity);
      AppMethodBeat.o(169283);
      return;
      cqe();
      AppMethodBeat.o(169283);
      return;
      cqb();
      AppMethodBeat.o(169283);
      return;
      cqh();
      AppMethodBeat.o(169283);
      return;
      af(paramActivity);
      AppMethodBeat.o(169283);
      return;
      cqf();
    }
  }
  
  public final void a(Activity paramActivity, ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(169291);
    if ((paramViewGroup instanceof RecyclerView)) {
      this.raX.setRecyclerView((RecyclerView)paramViewGroup);
    }
    if ((this.rbd == null) || (this.rbd.get() == null)) {
      this.rbd = new WeakReference(paramViewGroup);
    }
    this.rbe = paramInt1;
    this.rbf = paramInt2;
    if (this.mScrollState == 1) {}
    for (;;)
    {
      try
      {
        if (Math.abs(paramInt3) > this.raP)
        {
          if (paramInt3 <= 0) {
            continue;
          }
          this.rbg = -1;
        }
      }
      catch (Exception paramActivity)
      {
        ae.printErrStackTrace("HABBYGE-MALI.FeedMonitor", paramActivity, "scrollingState, crash: %s", new Object[] { paramActivity.getMessage() });
        continue;
      }
      a(paramViewGroup, paramInt1, paramInt2);
      AppMethodBeat.o(169291);
      return;
      if (paramInt3 < 0)
      {
        this.rbg = 1;
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
            ae.printErrStackTrace("HABBYGE-MALI.FeedMonitor", paramActivity, "initBarHeight", new Object[0]);
          }
        }
      }
    }
  }
  
  final void fX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(169286);
    this.raT = new dhw();
    this.raT.HPc = 0L;
    this.raT.hLz = this.raY;
    this.raT.HPg = this.raZ;
    dhw localdhw = this.raT;
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    localdhw.dAa = str;
    this.raT.dyf = paramString2;
    ae.i("HABBYGE-MALI.FeedMonitor", "initTimelineParams: %s, %s", new Object[] { this.raT.dAa, this.raT.dyf });
    this.raT.HPd = 0L;
    this.raT.HPe = 0L;
    this.raR.clear();
    this.raV = new g();
    this.raW = new f();
    AppMethodBeat.o(169286);
  }
  
  public final void h(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(186062);
    this.mScrollState = paramInt;
    if ((this.rbd == null) || (this.rbd.get() == null)) {
      this.rbd = new WeakReference(paramViewGroup);
    }
    if ((paramViewGroup instanceof RecyclerView)) {
      this.raX.setRecyclerView((RecyclerView)paramViewGroup);
    }
    if (paramInt == 0) {
      this.rbg = 0;
    }
    if ((this.raQ == 0) && (paramInt != 2)) {
      this.rba = -1;
    }
    if (this.rbc)
    {
      this.rbc = false;
      a(paramViewGroup, Math.max(this.rbe, 0), Math.max(this.rbf, 1), System.currentTimeMillis(), true);
    }
    AppMethodBeat.o(186062);
  }
  
  public final void kY(boolean paramBoolean)
  {
    AppMethodBeat.i(186061);
    ViewGroup localViewGroup;
    int j;
    if (this.rbd != null)
    {
      localViewGroup = (ViewGroup)this.rbd.get();
      if (localViewGroup != null)
      {
        j = localViewGroup.getChildCount();
        if (!paramBoolean) {
          break label57;
        }
      }
    }
    label57:
    for (int i = 0;; i = this.rbe)
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