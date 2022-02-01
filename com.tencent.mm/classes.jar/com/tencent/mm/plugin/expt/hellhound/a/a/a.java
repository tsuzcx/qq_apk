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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.dah;
import com.tencent.mm.protocal.protobuf.dbp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  private int afO;
  private int mScreenHeight;
  private int mScrollState;
  private int mfe;
  private final int qjV;
  private final int qjW;
  public final Map<String, c> qjX;
  public final Map<String, Boolean> qjY;
  private dbp qjZ;
  private long qka;
  private g qkb;
  private f qkc;
  private final com.tencent.mm.plugin.expt.hellhound.a.a.a.b qkd;
  private final String qke;
  private String qkf;
  public int qkg;
  private boolean qkh;
  private boolean qki;
  private int qkk;
  private int qkl;
  private int qkm;
  private WeakReference<LinearLayoutManager> qkn;
  private int qko;
  private long qkp;
  private long qkq;
  private String qkr;
  private int qks;
  private WindowManager qkt;
  private WeakReference<ViewGroup> uGG;
  
  public a(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(169282);
    this.mScrollState = 0;
    this.qjY = new HashMap();
    this.qka = 0L;
    this.qkh = false;
    this.qki = false;
    this.uGG = null;
    this.qkk = -1;
    this.qkl = 0;
    this.qkm = 0;
    this.qkn = null;
    this.qko = -1;
    this.qkp = 0L;
    this.qkq = -1L;
    this.qkr = "";
    this.afO = -1;
    this.mfe = -1;
    this.mScreenHeight = 0;
    this.qks = 0;
    this.qkt = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.qkd = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject);
      this.qjV = ViewConfiguration.get(ai.getContext()).getScaledTouchSlop();
      this.qjX = new HashMap();
      this.qjW = paramInt;
      this.qke = paramString1;
      this.qkf = paramString2;
      this.qkg = -1;
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
      this.qkp = 0L;
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
    if (this.qkb.qkC <= 0L)
    {
      this.qkb.qkC = paramLong;
      if (this.qkc != null)
      {
        this.qkc.startTime = paramLong;
        if (this.qjW == 0) {}
      }
    }
    else
    {
      a(paramViewGroup, paramInt1, paramInt2, paramLong, true);
    }
    if (this.qkb.qkE > 0L)
    {
      this.qkb.qkF = paramLong;
      if (this.qjZ != null)
      {
        paramLong = this.qkb.qkF;
        long l = this.qkb.qkE;
        paramViewGroup = this.qjZ;
        paramViewGroup.FKT = (paramLong - l + paramViewGroup.FKT);
      }
      this.qkb.cjv();
    }
    AppMethodBeat.o(186065);
  }
  
  private void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(169296);
    if ((paramViewGroup == null) || (this.qkc == null))
    {
      AppMethodBeat.o(169296);
      return;
    }
    this.qki = false;
    if (this.qkc.startTime > 0L)
    {
      this.qkc.endTime = paramLong;
      long l = this.qkc.endTime - this.qkc.startTime;
      Object localObject1;
      if (l <= 0L)
      {
        if (this.qkh) {
          this.qkh = false;
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
      this.qjY.clear();
      double d = l / paramInt1;
      paramViewGroup = ((Map)localObject1).entrySet().iterator();
      while (paramViewGroup.hasNext())
      {
        Object localObject2 = (Map.Entry)paramViewGroup.next();
        localObject1 = (c)((Map.Entry)localObject2).getKey();
        if (((Boolean)((Map.Entry)localObject2).getValue()).booleanValue())
        {
          this.qjY.put(((c)localObject1).qkB.feedId, Boolean.valueOf(((c)localObject1).qkB.isAd));
          if (this.qjX.containsKey(((c)localObject1).qkB.feedId))
          {
            localObject2 = (c)this.qjX.get(((c)localObject1).qkB.feedId);
            if (localObject2 != null)
            {
              dah localdah = ((c)localObject2).qkB;
              localdah.FJB += d;
              localdah = ((c)localObject2).qkB;
              localdah.FJC += l;
              a((c)localObject2, (c)localObject1);
              this.qjX.put(((c)localObject1).qkB.feedId, localObject2);
              ((c)localObject2).qkB.likeCount = ((c)localObject1).qkB.likeCount;
              ((c)localObject2).qkB.commentCount = ((c)localObject1).qkB.commentCount;
              ((c)localObject2).qkB.userName = ((c)localObject1).qkB.userName;
              ((c)localObject2).qkB.bLs = ((c)localObject1).qkB.bLs;
              ((c)localObject2).qkB.isAd = ((c)localObject1).qkB.isAd;
            }
          }
          else
          {
            ((c)localObject1).qkB.FJB = d;
            ((c)localObject1).qkB.FJC = l;
            this.qjX.put(((c)localObject1).qkB.feedId, localObject1);
          }
        }
      }
      if (paramBoolean)
      {
        this.qkc.startTime = paramLong;
        AppMethodBeat.o(169296);
        return;
      }
      this.qkc.startTime = 0L;
    }
    AppMethodBeat.o(169296);
  }
  
  private static void a(c paramc1, c paramc2)
  {
    paramc1.qkB.y = paramc2.qkB.y;
    paramc1.qkB.height = paramc2.qkB.height;
    paramc1.qkB.tp = paramc2.qkB.tp;
    paramc1.qkB.yWr = paramc2.qkB.yWr;
    paramc1.qkB.kWC = paramc2.qkB.kWC;
    paramc1.qkB.FJy = paramc2.qkB.FJy;
  }
  
  private com.tencent.mm.vending.j.c<c, Boolean> ab(View paramView, int paramInt)
  {
    AppMethodBeat.i(195216);
    Object localObject1 = this.qkd.ac(paramView, paramInt);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      AppMethodBeat.o(195216);
      return null;
    }
    Object localObject2 = new PInt();
    Object localObject4 = new PInt();
    this.qkd.a(paramView, (PInt)localObject2, (PInt)localObject4, paramInt);
    Object localObject3 = dQ(paramView);
    int i = ((Integer)((com.tencent.mm.vending.j.b)localObject3).get(0)).intValue();
    int j = ((Integer)((com.tencent.mm.vending.j.c)localObject3).get(1)).intValue();
    localObject3 = new c();
    ((c)localObject3).qkB = new dah();
    ((c)localObject3).qkB.feedId = ((String)localObject1);
    ((c)localObject3).qkB.likeCount = ((PInt)localObject2).value;
    ((c)localObject3).qkB.commentCount = ((PInt)localObject4).value;
    localObject2 = this.qkd.ad(paramView, paramInt);
    localObject4 = ((c)localObject3).qkB;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    ((dah)localObject4).userName = ((String)localObject1);
    localObject2 = this.qkd.ae(paramView, paramInt);
    localObject4 = ((c)localObject3).qkB;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    ((dah)localObject4).bLs = ((String)localObject1);
    ((c)localObject3).qkB.isAd = this.qkd.dS(paramView);
    ((c)localObject3).qkB.y = i;
    ((c)localObject3).qkB.height = j;
    ((c)localObject3).qkB.kWC = this.qks;
    ((c)localObject3).qkB.FJy = (this.qks - this.mScreenHeight);
    ((c)localObject3).qkB.xJx = this.mfe;
    paramView = ((c)localObject3).qkB;
    if (this.afO <= 0) {}
    for (i = 144;; i = this.afO)
    {
      paramView.rKm = i;
      ((c)localObject3).qkB.tp = this.mScrollState;
      ((c)localObject3).qkB.yWr = this.qkm;
      ((c)localObject3).position = paramInt;
      paramView = com.tencent.mm.vending.j.a.L(localObject3, Boolean.valueOf(((c)localObject3).Cm(this.qjW)));
      AppMethodBeat.o(195216);
      return paramView;
    }
  }
  
  private void ad(Activity paramActivity)
  {
    AppMethodBeat.i(169284);
    this.mScrollState = 0;
    af(paramActivity);
    ag(paramActivity);
    cjl();
    AppMethodBeat.o(169284);
  }
  
  private void ae(Activity paramActivity)
  {
    AppMethodBeat.i(195213);
    this.mScrollState = 0;
    af(paramActivity);
    ag(paramActivity);
    cjm();
    AppMethodBeat.o(195213);
  }
  
  private void af(Activity paramActivity)
  {
    AppMethodBeat.i(169303);
    if (this.mfe > 0)
    {
      AppMethodBeat.o(169303);
      return;
    }
    paramActivity = paramActivity.getResources();
    this.mfe = paramActivity.getDimensionPixelSize(paramActivity.getIdentifier("status_bar_height", "dimen", "android"));
    if (this.mfe <= 0) {
      this.mfe = paramActivity.getDimensionPixelSize(2131166269);
    }
    AppMethodBeat.o(169303);
  }
  
  @SuppressLint({"ObsoleteSdkInt"})
  private void ag(Activity paramActivity)
  {
    AppMethodBeat.i(169304);
    try
    {
      if (this.qkt == null) {
        this.qkt = ((WindowManager)ai.getContext().getSystemService("window"));
      }
      localObject = this.qkt.getDefaultDisplay();
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
    this.qks = localPoint.y;
    AppMethodBeat.o(169304);
  }
  
  private void b(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186064);
    if (this.qkb == null)
    {
      AppMethodBeat.o(186064);
      return;
    }
    long l = System.currentTimeMillis();
    if (this.qkb.qkG <= 0L) {
      this.qkb.qkG = l;
    }
    if ((cjs()) || (this.mScrollState == 0))
    {
      a(paramViewGroup, paramInt1, paramInt2, l);
      AppMethodBeat.o(186064);
      return;
    }
    if ((this.qjW == 0) && (this.qkg != -1))
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
    if (this.qkb.qkC > 0L)
    {
      this.qkb.qkD = paramLong;
      if (this.qjZ != null)
      {
        long l1 = this.qkb.qkD;
        long l2 = this.qkb.qkC;
        dbp localdbp = this.qjZ;
        localdbp.FKS = (l1 - l2 + localdbp.FKS);
      }
      this.qkb.cju();
      a(paramViewGroup, paramInt1, paramInt2, paramLong, false);
    }
    if (this.qkb.qkE <= 0L) {
      this.qkb.qkE = paramLong;
    }
    AppMethodBeat.o(186066);
  }
  
  private com.tencent.mm.vending.j.c<Map<c, Boolean>, Integer> c(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(169297);
    if (this.qjW == 0)
    {
      paramViewGroup = h(paramViewGroup, paramInt2);
      AppMethodBeat.o(169297);
      return paramViewGroup;
    }
    paramViewGroup = d(paramViewGroup, paramInt1, paramInt2);
    AppMethodBeat.o(169297);
    return paramViewGroup;
  }
  
  private void cjl()
  {
    AppMethodBeat.i(169285);
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.ciY();
    ac.i("HABBYGE-MALI.FeedMonitor", "startMonitor activityMethod: %d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(169285);
      return;
      fI(com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp().ckr(), com.tencent.mm.plugin.expt.hellhound.a.f.a.d.ckv());
      this.qkh = true;
      AppMethodBeat.o(169285);
      return;
      this.qkh = true;
      ViewGroup localViewGroup;
      if (this.uGG != null)
      {
        localViewGroup = (ViewGroup)this.uGG.get();
        if (localViewGroup != null) {
          a(localViewGroup, this.qkk, this.qkl);
        }
      }
      AppMethodBeat.o(169285);
      return;
      if (System.currentTimeMillis() - this.qka > 30000L)
      {
        ac.i("HABBYGE-MALI.FeedMonitor", "_handleActivityMethod.BACK_2_FRONT: New Session");
        cjo();
        AppMethodBeat.o(169285);
        return;
      }
      this.qkh = true;
      if (this.uGG != null)
      {
        localViewGroup = (ViewGroup)this.uGG.get();
        if (localViewGroup != null) {
          a(localViewGroup, this.qkk, this.qkl);
        }
      }
    }
  }
  
  private void cjm()
  {
    AppMethodBeat.i(195214);
    fI(com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp().ckr(), com.tencent.mm.plugin.expt.hellhound.a.f.a.d.ckv());
    this.qkh = true;
    this.qki = true;
    if (this.uGG != null)
    {
      ViewGroup localViewGroup = (ViewGroup)this.uGG.get();
      if (localViewGroup != null) {
        a(localViewGroup, Math.max(this.qkk, 0), Math.max(this.qkl, 1));
      }
    }
    AppMethodBeat.o(195214);
  }
  
  private void cjn()
  {
    AppMethodBeat.i(169287);
    ap.f(new Runnable()
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
  
  private void cjo()
  {
    AppMethodBeat.i(169288);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(169280);
        a.a(a.this);
        a.this.fI(this.jMD, this.qkv);
        AppMethodBeat.o(169280);
      }
    });
    AppMethodBeat.o(169288);
  }
  
  private void cjp()
  {
    AppMethodBeat.i(169289);
    if (this.qkb == null)
    {
      AppMethodBeat.o(169289);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2;
    long l3;
    Object localObject;
    if (this.qkb.qkC > 0L)
    {
      this.qkb.qkD = l1;
      if (this.qjZ != null)
      {
        l2 = this.qkb.qkD;
        l3 = this.qkb.qkC;
        localObject = this.qjZ;
        ((dbp)localObject).FKS = (l2 - l3 + ((dbp)localObject).FKS);
      }
      this.qkb.cju();
      if (this.uGG != null)
      {
        localObject = (ViewGroup)this.uGG.get();
        if (localObject != null) {
          a((ViewGroup)localObject, this.qkk, this.qkl, l1, false);
        }
      }
    }
    if (this.qkb.qkE > 0L)
    {
      this.qkb.qkF = l1;
      if (this.qjZ == null) {
        break label296;
      }
      l2 = this.qkb.qkF;
      l3 = this.qkb.qkE;
      localObject = this.qjZ;
      ((dbp)localObject).FKT = (l2 - l3 + ((dbp)localObject).FKT);
    }
    for (;;)
    {
      this.qkb.cjv();
      if (this.qkb.qkG > 0L)
      {
        this.qkb.qkH = l1;
        if (this.qjZ != null)
        {
          l1 = this.qkb.qkH;
          l2 = this.qkb.qkG;
          localObject = this.qjZ;
          ((dbp)localObject).FKR = (l1 - l2 + ((dbp)localObject).FKR);
        }
        localObject = this.qkb;
        ((g)localObject).qkG = 0L;
        ((g)localObject).qkH = 0L;
      }
      AppMethodBeat.o(169289);
      return;
      label296:
      ac.e("HABBYGE-MALI.FeedMonitor", "_stopComputeTimelineSliceTime mSnsTimeline is NULL 2");
    }
  }
  
  private void cjq()
  {
    AppMethodBeat.i(169290);
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.ciY();
    ac.i("HABBYGE-MALI.FeedMonitor", "stopMonitor, activityMethod: %s", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(169290);
      return;
      cjp();
      AppMethodBeat.o(169290);
      return;
      cjn();
      AppMethodBeat.o(169290);
      return;
      cjp();
      this.qka = System.currentTimeMillis();
    }
  }
  
  private void cjr()
  {
    AppMethodBeat.i(195215);
    this.qki = false;
    cjn();
    AppMethodBeat.o(195215);
  }
  
  private boolean cjs()
  {
    return this.qkp <= 1000L;
  }
  
  private void cjt()
  {
    AppMethodBeat.i(169305);
    if (this.qjX != null) {
      this.qjX.clear();
    }
    this.qkt = null;
    if (this.uGG != null)
    {
      this.uGG.clear();
      this.uGG = null;
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
        if (this.qkn != null)
        {
          localObject2 = (LinearLayoutManager)this.qkn.get();
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = (LinearLayoutManager)((RecyclerView)paramViewGroup).getLayoutManager();
          if (localObject1 == null) {
            break label255;
          }
          this.qkn = new WeakReference(localObject1);
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
  
  private com.tencent.mm.vending.j.c<Integer, Integer> dQ(View paramView)
  {
    AppMethodBeat.i(169300);
    if (this.qjW == 0) {}
    for (int i = paramView.getHeight();; i = Math.max(paramView.getMeasuredHeight(), paramView.getHeight()))
    {
      paramView = com.tencent.mm.vending.j.a.L(Integer.valueOf(Math.min(dR(paramView), (int)paramView.getY())), Integer.valueOf(i));
      AppMethodBeat.o(169300);
      return paramView;
    }
  }
  
  private static int dR(View paramView)
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
    String str = this.qkd.ac(paramViewGroup, paramInt - 1);
    if (str == null)
    {
      AppMethodBeat.o(169299);
      return true;
    }
    if (!str.equals(this.qkr))
    {
      this.qko = dR(paramViewGroup);
      this.qkq = System.currentTimeMillis();
      this.qkr = str;
      AppMethodBeat.o(169299);
      return true;
    }
    paramInt = dR(paramViewGroup);
    int i = Math.abs(paramInt - this.qko);
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.qkq;
    if ((l2 > 0L) && (i > this.qjV))
    {
      this.qkp = (i * 1000L / l2);
      this.qko = paramInt;
      this.qkq = l1;
      AppMethodBeat.o(169299);
      return true;
    }
    AppMethodBeat.o(169299);
    return false;
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
          localObject1 = ((LinearLayoutManager)localObject2).bY(((LinearLayoutManager)localObject2).jY());
          if (localObject1 == null)
          {
            localObject2 = paramViewGroup.getChildAt(((LinearLayoutManager)localObject2).jY());
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
      cjq();
      AppMethodBeat.o(169283);
      return;
      cjn();
      AppMethodBeat.o(169283);
      return;
      cjt();
      AppMethodBeat.o(169283);
      return;
      ae(paramActivity);
      AppMethodBeat.o(169283);
      return;
      cjr();
    }
  }
  
  public final void a(Activity paramActivity, ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(169291);
    if ((paramViewGroup instanceof RecyclerView)) {
      this.qkd.setRecyclerView((RecyclerView)paramViewGroup);
    }
    if ((paramViewGroup instanceof RecyclerView)) {
      this.qkd.setRecyclerView((RecyclerView)paramViewGroup);
    }
    this.qkk = paramInt1;
    this.qkl = paramInt2;
    if (this.mScrollState == 1) {}
    for (;;)
    {
      try
      {
        if (Math.abs(paramInt3) > this.qjV)
        {
          if (paramInt3 <= 0) {
            continue;
          }
          this.qkm = -1;
        }
      }
      catch (Exception paramActivity)
      {
        ac.printErrStackTrace("HABBYGE-MALI.FeedMonitor", paramActivity, "scrollingState, crash: %s", new Object[] { paramActivity.getMessage() });
        continue;
      }
      a(paramViewGroup, paramInt1, paramInt2);
      AppMethodBeat.o(169291);
      return;
      if (paramInt3 < 0)
      {
        this.qkm = 1;
        continue;
        if ((this.mScrollState == 0) && (this.afO <= 0) && (paramActivity != null)) {
          try
          {
            if ((paramActivity instanceof AppCompatActivity))
            {
              paramActivity = ((AppCompatActivity)paramActivity).getSupportActionBar();
              if (paramActivity != null) {
                this.afO = paramActivity.getCustomView().getHeight();
              }
            }
          }
          catch (Exception paramActivity)
          {
            ac.printErrStackTrace("HABBYGE-MALI.FeedMonitor", paramActivity, "initBarHeight", new Object[0]);
          }
        }
      }
    }
  }
  
  final void fI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(169286);
    this.qjZ = new dbp();
    this.qjZ.FKR = 0L;
    this.qjZ.hqo = this.qke;
    this.qjZ.FKV = this.qkf;
    dbp localdbp = this.qjZ;
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    localdbp.dnh = str;
    this.qjZ.dln = paramString2;
    ac.i("HABBYGE-MALI.FeedMonitor", "initTimelineParams: %s, %s", new Object[] { this.qjZ.dnh, this.qjZ.dln });
    this.qjZ.FKS = 0L;
    this.qjZ.FKT = 0L;
    this.qjX.clear();
    this.qkb = new g();
    this.qkc = new f();
    AppMethodBeat.o(169286);
  }
  
  public final void g(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(186062);
    this.mScrollState = paramInt;
    if ((this.uGG == null) || (this.uGG.get() == null)) {
      this.uGG = new WeakReference(paramViewGroup);
    }
    if ((paramViewGroup instanceof RecyclerView)) {
      this.qkd.setRecyclerView((RecyclerView)paramViewGroup);
    }
    if (paramInt == 0) {
      this.qkm = 0;
    }
    if ((this.qjW == 0) && (paramInt != 2)) {
      this.qkg = -1;
    }
    if (this.qki)
    {
      this.qki = false;
      a(paramViewGroup, Math.max(this.qkk, 0), Math.max(this.qkl, 1), System.currentTimeMillis(), true);
    }
    AppMethodBeat.o(186062);
  }
  
  public final void kG(boolean paramBoolean)
  {
    AppMethodBeat.i(186061);
    ViewGroup localViewGroup;
    int j;
    if (this.uGG != null)
    {
      localViewGroup = (ViewGroup)this.uGG.get();
      if (localViewGroup != null)
      {
        j = localViewGroup.getChildCount();
        if (!paramBoolean) {
          break label57;
        }
      }
    }
    label57:
    for (int i = 0;; i = this.qkk)
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