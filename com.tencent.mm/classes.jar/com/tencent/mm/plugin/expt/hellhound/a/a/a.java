package com.tencent.mm.plugin.expt.hellhound.a.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.hellhound.a.f.a.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.ejv;
import com.tencent.mm.protocal.protobuf.elf;
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
  private final int wha;
  private final int whb;
  public final Map<String, c> whc;
  public final Map<String, Boolean> whd;
  private elf whe;
  private long whf;
  private h whg;
  private g whh;
  private final com.tencent.mm.plugin.expt.hellhound.a.a.a.b whi;
  private final String whj;
  private String whk;
  public int whl;
  private boolean whm;
  private boolean whn;
  private WeakReference<ViewGroup> who;
  private int whp;
  private int whq;
  private WeakReference<LinearLayoutManager> whr;
  private int whs;
  private long wht;
  private long whu;
  private String whv;
  private WindowManager whw;
  
  public a(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(169282);
    this.mScrollState = 0;
    this.whd = new HashMap();
    this.whf = 0L;
    this.whm = false;
    this.whn = false;
    this.who = null;
    this.whp = -1;
    this.mVisibleItemCount = 0;
    this.whq = 0;
    this.whr = null;
    this.whs = -1;
    this.wht = 0L;
    this.whu = -1L;
    this.whv = "";
    this.mActionBarHeight = -1;
    this.mStatusBarHeight = -1;
    this.mScreenHeight = 0;
    this.mScreenRealHeight = 0;
    this.whw = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.whi = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject);
      this.wha = ViewConfiguration.get(MMApplicationContext.getContext()).getScaledTouchSlop();
      this.whc = new HashMap();
      this.whb = paramInt;
      this.whj = paramString1;
      this.whk = paramString2;
      this.whl = -1;
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
      this.wht = 0L;
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
    if (this.whg.whQ <= 0L)
    {
      this.whg.whQ = paramLong;
      if (this.whh != null)
      {
        this.whh.startTime = paramLong;
        if (this.whb == 0) {}
      }
    }
    else
    {
      a(paramViewGroup, paramInt1, paramInt2, paramLong, true);
    }
    if (this.whg.whS > 0L)
    {
      this.whg.whT = paramLong;
      if (this.whe != null)
      {
        paramLong = this.whg.whT;
        long l = this.whg.whS;
        paramViewGroup = this.whe;
        paramViewGroup.Uno = (paramLong - l + paramViewGroup.Uno);
      }
      this.whg.ddu();
    }
    AppMethodBeat.o(186065);
  }
  
  private void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(169296);
    if ((paramViewGroup == null) || (this.whh == null))
    {
      AppMethodBeat.o(169296);
      return;
    }
    this.whn = false;
    if (this.whh.startTime > 0L)
    {
      this.whh.endTime = paramLong;
      long l = this.whh.endTime - this.whh.startTime;
      Object localObject1;
      if (l <= 0L)
      {
        if (this.whm) {
          this.whm = false;
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
      this.whd.clear();
      double d = l / paramInt1;
      paramViewGroup = ((Map)localObject1).entrySet().iterator();
      while (paramViewGroup.hasNext())
      {
        Object localObject2 = (Map.Entry)paramViewGroup.next();
        localObject1 = (c)((Map.Entry)localObject2).getKey();
        if (((Boolean)((Map.Entry)localObject2).getValue()).booleanValue())
        {
          this.whd.put(((c)localObject1).whE.feedId, Boolean.valueOf(((c)localObject1).whE.isAd));
          if (this.whc.containsKey(((c)localObject1).whE.feedId))
          {
            localObject2 = (c)this.whc.get(((c)localObject1).whE.feedId);
            if (localObject2 != null)
            {
              ejv localejv = ((c)localObject2).whE;
              localejv.UlN += d;
              localejv = ((c)localObject2).whE;
              localejv.UlO += l;
              a((c)localObject2, (c)localObject1);
              this.whc.put(((c)localObject1).whE.feedId, localObject2);
              ((c)localObject2).whE.likeCount = ((c)localObject1).whE.likeCount;
              ((c)localObject2).whE.commentCount = ((c)localObject1).whE.commentCount;
              ((c)localObject2).whE.userName = ((c)localObject1).whE.userName;
              ((c)localObject2).whE.nickName = ((c)localObject1).whE.nickName;
              ((c)localObject2).whE.isAd = ((c)localObject1).whE.isAd;
            }
          }
          else
          {
            ((c)localObject1).whE.UlN = d;
            ((c)localObject1).whE.UlO = l;
            this.whc.put(((c)localObject1).whE.feedId, localObject1);
          }
        }
      }
      if (paramBoolean)
      {
        this.whh.startTime = paramLong;
        AppMethodBeat.o(169296);
        return;
      }
      this.whh.startTime = 0L;
    }
    AppMethodBeat.o(169296);
  }
  
  private static void a(c paramc1, c paramc2)
  {
    paramc1.whE.y = paramc2.whE.y;
    paramc1.whE.height = paramc2.whE.height;
    paramc1.whE.bFP = paramc2.whE.bFP;
    paramc1.whE.LcN = paramc2.whE.LcN;
    paramc1.whE.pEk = paramc2.whE.pEk;
    paramc1.whE.virtualKeyHeight = paramc2.whE.virtualKeyHeight;
  }
  
  private com.tencent.mm.vending.j.c<c, Boolean> ad(View paramView, int paramInt)
  {
    AppMethodBeat.i(251136);
    Object localObject1 = this.whi.ae(paramView, paramInt);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      AppMethodBeat.o(251136);
      return null;
    }
    Object localObject2 = new PInt();
    Object localObject4 = new PInt();
    this.whi.a(paramView, (PInt)localObject2, (PInt)localObject4, paramInt);
    Object localObject3 = el(paramView);
    int i = ((Integer)((com.tencent.mm.vending.j.b)localObject3).get(0)).intValue();
    int j = ((Integer)((com.tencent.mm.vending.j.c)localObject3).get(1)).intValue();
    localObject3 = new c();
    ((c)localObject3).whE = new ejv();
    ((c)localObject3).whE.feedId = ((String)localObject1);
    ((c)localObject3).whE.likeCount = ((PInt)localObject2).value;
    ((c)localObject3).whE.commentCount = ((PInt)localObject4).value;
    localObject2 = this.whi.af(paramView, paramInt);
    localObject4 = ((c)localObject3).whE;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    ((ejv)localObject4).userName = ((String)localObject1);
    localObject2 = this.whi.ag(paramView, paramInt);
    localObject4 = ((c)localObject3).whE;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    ((ejv)localObject4).nickName = ((String)localObject1);
    ((c)localObject3).whE.isAd = this.whi.en(paramView);
    ((c)localObject3).whE.y = i;
    ((c)localObject3).whE.height = j;
    ((c)localObject3).whE.pEk = this.mScreenRealHeight;
    ((c)localObject3).whE.virtualKeyHeight = (this.mScreenRealHeight - this.mScreenHeight);
    ((c)localObject3).whE.INC = this.mStatusBarHeight;
    paramView = ((c)localObject3).whE;
    if (this.mActionBarHeight <= 0) {}
    for (i = 144;; i = this.mActionBarHeight)
    {
      paramView.xRu = i;
      ((c)localObject3).whE.bFP = this.mScrollState;
      ((c)localObject3).whE.LcN = this.whq;
      ((c)localObject3).position = paramInt;
      paramView = com.tencent.mm.vending.j.a.J(localObject3, Boolean.valueOf(((c)localObject3).KH(this.whb)));
      AppMethodBeat.o(251136);
      return paramView;
    }
  }
  
  private void ad(Activity paramActivity)
  {
    AppMethodBeat.i(169284);
    this.mScrollState = 0;
    initStatusBarHeight(paramActivity);
    initScreenHeight(paramActivity);
    ddk();
    AppMethodBeat.o(169284);
  }
  
  private void ae(Activity paramActivity)
  {
    AppMethodBeat.i(251109);
    this.mScrollState = 0;
    initStatusBarHeight(paramActivity);
    initScreenHeight(paramActivity);
    ddl();
    AppMethodBeat.o(251109);
  }
  
  private void b(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186064);
    if (this.whg == null)
    {
      AppMethodBeat.o(186064);
      return;
    }
    long l = System.currentTimeMillis();
    if (this.whg.whU <= 0L) {
      this.whg.whU = l;
    }
    if ((ddq()) || (this.mScrollState == 0))
    {
      a(paramViewGroup, paramInt1, paramInt2, l);
      AppMethodBeat.o(186064);
      return;
    }
    if ((this.whb == 0) && (this.whl != -1))
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
    if (this.whg.whQ > 0L)
    {
      this.whg.whR = paramLong;
      if (this.whe != null)
      {
        long l1 = this.whg.whR;
        long l2 = this.whg.whQ;
        elf localelf = this.whe;
        localelf.Unn = (l1 - l2 + localelf.Unn);
      }
      this.whg.ddt();
      a(paramViewGroup, paramInt1, paramInt2, paramLong, false);
    }
    if (this.whg.whS <= 0L) {
      this.whg.whS = paramLong;
    }
    AppMethodBeat.o(186066);
  }
  
  private com.tencent.mm.vending.j.c<Map<c, Boolean>, Integer> c(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(169297);
    if (this.whb == 0)
    {
      paramViewGroup = h(paramViewGroup, paramInt2);
      AppMethodBeat.o(169297);
      return paramViewGroup;
    }
    paramViewGroup = d(paramViewGroup, paramInt1, paramInt2);
    AppMethodBeat.o(169297);
    return paramViewGroup;
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
          localObject1 = ad((View)localObject1, j);
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
        if (this.whr != null)
        {
          localObject2 = (LinearLayoutManager)this.whr.get();
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = (LinearLayoutManager)((RecyclerView)paramViewGroup).getLayoutManager();
          if (localObject1 == null) {
            break label255;
          }
          this.whr = new WeakReference(localObject1);
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
            paramViewGroup = com.tencent.mm.vending.j.a.J(localHashMap, Integer.valueOf(i));
            AppMethodBeat.o(185576);
            return paramViewGroup;
          }
        }
        break label54;
      }
    }
  }
  
  private void ddk()
  {
    AppMethodBeat.i(169285);
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.dcL();
    Log.i("HABBYGE-MALI.FeedMonitor", "startMonitor activityMethod: %d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(169285);
      return;
      gE(com.tencent.mm.plugin.expt.hellhound.a.f.b.deI().deL(), d.deP());
      this.whm = true;
      AppMethodBeat.o(169285);
      return;
      this.whm = true;
      ViewGroup localViewGroup;
      if (this.who != null)
      {
        localViewGroup = (ViewGroup)this.who.get();
        if (localViewGroup != null) {
          a(localViewGroup, this.whp, this.mVisibleItemCount);
        }
      }
      AppMethodBeat.o(169285);
      return;
      if (System.currentTimeMillis() - this.whf > 30000L)
      {
        Log.i("HABBYGE-MALI.FeedMonitor", "_handleActivityMethod.BACK_2_FRONT: New Session");
        ddn();
        AppMethodBeat.o(169285);
        return;
      }
      this.whm = true;
      if (this.who != null)
      {
        localViewGroup = (ViewGroup)this.who.get();
        if (localViewGroup != null) {
          a(localViewGroup, this.whp, this.mVisibleItemCount);
        }
      }
    }
  }
  
  private void ddl()
  {
    AppMethodBeat.i(251113);
    gE(com.tencent.mm.plugin.expt.hellhound.a.f.b.deI().deL(), d.deP());
    this.whm = true;
    this.whn = true;
    if (this.who != null)
    {
      ViewGroup localViewGroup = (ViewGroup)this.who.get();
      if (localViewGroup != null) {
        a(localViewGroup, Math.max(this.whp, 0), Math.max(this.mVisibleItemCount, 1));
      }
    }
    AppMethodBeat.o(251113);
  }
  
  private void ddm()
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
  
  private void ddn()
  {
    AppMethodBeat.i(169288);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(169280);
        a.a(a.this);
        a.this.gE(this.oiy, this.why);
        AppMethodBeat.o(169280);
      }
    });
    AppMethodBeat.o(169288);
  }
  
  private void ddo()
  {
    AppMethodBeat.i(169289);
    if (this.whg == null)
    {
      AppMethodBeat.o(169289);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2;
    long l3;
    Object localObject;
    if (this.whg.whQ > 0L)
    {
      this.whg.whR = l1;
      if (this.whe != null)
      {
        l2 = this.whg.whR;
        l3 = this.whg.whQ;
        localObject = this.whe;
        ((elf)localObject).Unn = (l2 - l3 + ((elf)localObject).Unn);
      }
      this.whg.ddt();
      if (this.who != null)
      {
        localObject = (ViewGroup)this.who.get();
        if (localObject != null) {
          a((ViewGroup)localObject, this.whp, this.mVisibleItemCount, l1, false);
        }
      }
    }
    if (this.whg.whS > 0L)
    {
      this.whg.whT = l1;
      if (this.whe == null) {
        break label296;
      }
      l2 = this.whg.whT;
      l3 = this.whg.whS;
      localObject = this.whe;
      ((elf)localObject).Uno = (l2 - l3 + ((elf)localObject).Uno);
    }
    for (;;)
    {
      this.whg.ddu();
      if (this.whg.whU > 0L)
      {
        this.whg.whV = l1;
        if (this.whe != null)
        {
          l1 = this.whg.whV;
          l2 = this.whg.whU;
          localObject = this.whe;
          ((elf)localObject).Unm = (l1 - l2 + ((elf)localObject).Unm);
        }
        localObject = this.whg;
        ((h)localObject).whU = 0L;
        ((h)localObject).whV = 0L;
      }
      AppMethodBeat.o(169289);
      return;
      label296:
      Log.e("HABBYGE-MALI.FeedMonitor", "_stopComputeTimelineSliceTime mSnsTimeline is NULL 2");
    }
  }
  
  private void ddp()
  {
    AppMethodBeat.i(251120);
    this.whn = false;
    ddm();
    AppMethodBeat.o(251120);
  }
  
  private boolean ddq()
  {
    return this.wht <= 1000L;
  }
  
  private void ddr()
  {
    AppMethodBeat.i(169305);
    if (this.whc != null) {
      this.whc.clear();
    }
    this.whw = null;
    if (this.who != null)
    {
      this.who.clear();
      this.who = null;
    }
    AppMethodBeat.o(169305);
  }
  
  private com.tencent.mm.vending.j.c<Integer, Integer> el(View paramView)
  {
    AppMethodBeat.i(169300);
    if (this.whb == 0) {}
    for (int i = paramView.getHeight();; i = Math.max(paramView.getMeasuredHeight(), paramView.getHeight()))
    {
      paramView = com.tencent.mm.vending.j.a.J(Integer.valueOf(Math.min(getY(paramView), (int)paramView.getY())), Integer.valueOf(i));
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
      localObject = ad((View)localObject, i);
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
      paramViewGroup = com.tencent.mm.vending.j.a.J(localHashMap, Integer.valueOf(paramInt));
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
    String str = this.whi.ae(paramViewGroup, paramInt - 1);
    if (str == null)
    {
      AppMethodBeat.o(169299);
      return true;
    }
    if (!str.equals(this.whv))
    {
      this.whs = getY(paramViewGroup);
      this.whu = System.currentTimeMillis();
      this.whv = str;
      AppMethodBeat.o(169299);
      return true;
    }
    paramInt = getY(paramViewGroup);
    int i = Math.abs(paramInt - this.whs);
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.whu;
    if ((l2 > 0L) && (i > this.wha))
    {
      this.wht = (i * 1000L / l2);
      this.whs = paramInt;
      this.whu = l1;
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
      if (this.whw == null) {
        this.whw = ((WindowManager)MMApplicationContext.getContext().getSystemService("window"));
      }
      localObject = this.whw.getDefaultDisplay();
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
      this.mStatusBarHeight = paramActivity.getDimensionPixelSize(b.b.expt_sns_statusbar_height);
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
          localObject1 = ((LinearLayoutManager)localObject2).findViewByPosition(((LinearLayoutManager)localObject2).kL());
          if (localObject1 == null)
          {
            localObject2 = paramViewGroup.getChildAt(((LinearLayoutManager)localObject2).kL());
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
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.dcL();
    Log.i("HABBYGE-MALI.FeedMonitor", "stopMonitor, activityMethod: %s", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(169290);
      return;
      ddo();
      AppMethodBeat.o(169290);
      return;
      ddm();
      AppMethodBeat.o(169290);
      return;
      ddo();
      this.whf = System.currentTimeMillis();
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
      stopMonitor();
      AppMethodBeat.o(169283);
      return;
      ddm();
      AppMethodBeat.o(169283);
      return;
      ddr();
      AppMethodBeat.o(169283);
      return;
      ae(paramActivity);
      AppMethodBeat.o(169283);
      return;
      ddp();
    }
  }
  
  public final void a(Activity paramActivity, ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(169291);
    if ((paramViewGroup instanceof RecyclerView)) {
      this.whi.setRecyclerView((RecyclerView)paramViewGroup);
    }
    if ((this.who == null) || (this.who.get() == null)) {
      this.who = new WeakReference(paramViewGroup);
    }
    this.whp = paramInt1;
    this.mVisibleItemCount = paramInt2;
    if (this.mScrollState == 1) {}
    for (;;)
    {
      try
      {
        if (Math.abs(paramInt3) > this.wha)
        {
          if (paramInt3 <= 0) {
            continue;
          }
          this.whq = -1;
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
        this.whq = 1;
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
    if ((this.who == null) || (this.who.get() == null)) {
      this.who = new WeakReference(paramViewGroup);
    }
    if ((paramViewGroup instanceof RecyclerView)) {
      this.whi.setRecyclerView((RecyclerView)paramViewGroup);
    }
    if (paramInt == 0) {
      this.whq = 0;
    }
    if ((this.whb == 0) && (paramInt != 2)) {
      this.whl = -1;
    }
    if (this.whn)
    {
      this.whn = false;
      a(paramViewGroup, Math.max(this.whp, 0), Math.max(this.mVisibleItemCount, 1), System.currentTimeMillis(), true);
    }
    AppMethodBeat.o(186062);
  }
  
  final void gE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(169286);
    this.whe = new elf();
    this.whe.Unm = 0L;
    this.whe.lwD = this.whj;
    this.whe.Unq = this.whk;
    elf localelf = this.whe;
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    localelf.fLj = str;
    this.whe.fJc = paramString2;
    com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkt = this.whe.fLj;
    Log.i("HABBYGE-MALI.FeedMonitor", "initTimelineParams: %s, %s", new Object[] { this.whe.fLj, this.whe.fJc });
    this.whe.Unn = 0L;
    this.whe.Uno = 0L;
    this.whc.clear();
    this.whg = new h();
    this.whh = new g();
    AppMethodBeat.o(169286);
  }
  
  public final void no(boolean paramBoolean)
  {
    AppMethodBeat.i(186061);
    ViewGroup localViewGroup;
    int j;
    if (this.who != null)
    {
      localViewGroup = (ViewGroup)this.who.get();
      if (localViewGroup != null)
      {
        j = localViewGroup.getChildCount();
        if (!paramBoolean) {
          break label57;
        }
      }
    }
    label57:
    for (int i = 0;; i = this.whp)
    {
      b(localViewGroup, i, j);
      AppMethodBeat.o(186061);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.a
 * JD-Core Version:    0.7.0.1
 */