package com.tencent.mm.plugin.expt.hellhound.ext.a;

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
import com.tencent.mm.plugin.expt.hellhound.ext.a.b.f;
import com.tencent.mm.plugin.expt.hellhound.ext.session.a.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.fed;
import com.tencent.mm.protocal.protobuf.ffn;
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
  private final int zDc;
  private final int zDd;
  public final Map<String, c> zDe;
  public final Map<String, Boolean> zDf;
  private ffn zDg;
  private long zDh;
  private h zDi;
  private g zDj;
  private final com.tencent.mm.plugin.expt.hellhound.ext.a.a.b zDk;
  private final String zDl;
  private String zDm;
  public int zDn;
  private boolean zDo;
  private boolean zDp;
  private WeakReference<ViewGroup> zDq;
  private int zDr;
  private int zDs;
  private WeakReference<LinearLayoutManager> zDt;
  private int zDu;
  private long zDv;
  private long zDw;
  private String zDx;
  private WindowManager zDy;
  
  public a(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(169282);
    this.mScrollState = 0;
    this.zDf = new HashMap();
    this.zDh = 0L;
    this.zDo = false;
    this.zDp = false;
    this.zDq = null;
    this.zDr = -1;
    this.mVisibleItemCount = 0;
    this.zDs = 0;
    this.zDt = null;
    this.zDu = -1;
    this.zDv = 0L;
    this.zDw = -1L;
    this.zDx = "";
    this.mActionBarHeight = -1;
    this.mStatusBarHeight = -1;
    this.mScreenHeight = 0;
    this.mScreenRealHeight = 0;
    this.zDy = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.zDk = ((com.tencent.mm.plugin.expt.hellhound.ext.a.a.b)localObject);
      this.zDc = ViewConfiguration.get(MMApplicationContext.getContext()).getScaledTouchSlop();
      this.zDe = new HashMap();
      this.zDd = paramInt;
      this.zDl = paramString1;
      this.zDm = paramString2;
      this.zDn = -1;
      AppMethodBeat.o(169282);
      return;
      localObject = new com.tencent.mm.plugin.expt.hellhound.ext.a.a.c();
      continue;
      localObject = new com.tencent.mm.plugin.expt.hellhound.ext.a.a.a();
    }
  }
  
  private void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186063);
    if (this.mScrollState == 0) {
      this.zDv = 0L;
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
    if (this.zDi.zDT <= 0L)
    {
      this.zDi.zDT = paramLong;
      if (this.zDj != null)
      {
        this.zDj.startTime = paramLong;
        if (this.zDd == 0) {}
      }
    }
    else
    {
      a(paramViewGroup, paramInt1, paramInt2, paramLong, true);
    }
    if (this.zDi.zDV > 0L)
    {
      this.zDi.zDW = paramLong;
      if (this.zDg != null)
      {
        paramLong = this.zDi.zDW;
        long l = this.zDi.zDV;
        paramViewGroup = this.zDg;
        paramViewGroup.abFv = (paramLong - l + paramViewGroup.abFv);
      }
      this.zDi.dKb();
    }
    AppMethodBeat.o(186065);
  }
  
  private void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(169296);
    if ((paramViewGroup == null) || (this.zDj == null))
    {
      AppMethodBeat.o(169296);
      return;
    }
    this.zDp = false;
    if (this.zDj.startTime > 0L)
    {
      this.zDj.endTime = paramLong;
      long l = this.zDj.endTime - this.zDj.startTime;
      Object localObject1;
      if (l <= 0L)
      {
        if (this.zDo) {
          this.zDo = false;
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
      this.zDf.clear();
      double d = l / paramInt1;
      paramViewGroup = ((Map)localObject1).entrySet().iterator();
      while (paramViewGroup.hasNext())
      {
        Object localObject2 = (Map.Entry)paramViewGroup.next();
        localObject1 = (c)((Map.Entry)localObject2).getKey();
        if (((Boolean)((Map.Entry)localObject2).getValue()).booleanValue())
        {
          this.zDf.put(((c)localObject1).zDG.feedId, Boolean.valueOf(((c)localObject1).zDG.isAd));
          if (this.zDe.containsKey(((c)localObject1).zDG.feedId))
          {
            localObject2 = (c)this.zDe.get(((c)localObject1).zDG.feedId);
            if (localObject2 != null)
            {
              fed localfed = ((c)localObject2).zDG;
              localfed.abDO += d;
              localfed = ((c)localObject2).zDG;
              localfed.abDP += l;
              a((c)localObject2, (c)localObject1);
              this.zDe.put(((c)localObject1).zDG.feedId, localObject2);
              ((c)localObject2).zDG.likeCount = ((c)localObject1).zDG.likeCount;
              ((c)localObject2).zDG.commentCount = ((c)localObject1).zDG.commentCount;
              ((c)localObject2).zDG.userName = ((c)localObject1).zDG.userName;
              ((c)localObject2).zDG.nickName = ((c)localObject1).zDG.nickName;
              ((c)localObject2).zDG.isAd = ((c)localObject1).zDG.isAd;
            }
          }
          else
          {
            ((c)localObject1).zDG.abDO = d;
            ((c)localObject1).zDG.abDP = l;
            this.zDe.put(((c)localObject1).zDG.feedId, localObject1);
          }
        }
      }
      if (paramBoolean)
      {
        this.zDj.startTime = paramLong;
        AppMethodBeat.o(169296);
        return;
      }
      this.zDj.startTime = 0L;
    }
    AppMethodBeat.o(169296);
  }
  
  private static void a(c paramc1, c paramc2)
  {
    paramc1.zDG.y = paramc2.zDG.y;
    paramc1.zDG.height = paramc2.zDG.height;
    paramc1.zDG.dyP = paramc2.zDG.dyP;
    paramc1.zDG.RCV = paramc2.zDG.RCV;
    paramc1.zDG.pvg = paramc2.zDG.pvg;
    paramc1.zDG.virtualKeyHeight = paramc2.zDG.virtualKeyHeight;
  }
  
  private com.tencent.mm.vending.j.c<c, Boolean> ai(View paramView, int paramInt)
  {
    AppMethodBeat.i(300193);
    Object localObject1 = this.zDk.aj(paramView, paramInt);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      AppMethodBeat.o(300193);
      return null;
    }
    Object localObject2 = new PInt();
    Object localObject4 = new PInt();
    this.zDk.a(paramView, (PInt)localObject2, (PInt)localObject4, paramInt);
    Object localObject3 = ff(paramView);
    int i = ((Integer)((com.tencent.mm.vending.j.b)localObject3).get(0)).intValue();
    int j = ((Integer)((com.tencent.mm.vending.j.c)localObject3).get(1)).intValue();
    localObject3 = new c();
    ((c)localObject3).zDG = new fed();
    ((c)localObject3).zDG.feedId = ((String)localObject1);
    ((c)localObject3).zDG.likeCount = ((PInt)localObject2).value;
    ((c)localObject3).zDG.commentCount = ((PInt)localObject4).value;
    localObject2 = this.zDk.ak(paramView, paramInt);
    localObject4 = ((c)localObject3).zDG;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    ((fed)localObject4).userName = ((String)localObject1);
    ((c)localObject3).zDL = ((c)localObject3).zDG.userName;
    localObject2 = this.zDk.al(paramView, paramInt);
    localObject4 = ((c)localObject3).zDG;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    ((fed)localObject4).nickName = ((String)localObject1);
    ((c)localObject3).zDG.isAd = this.zDk.fh(paramView);
    ((c)localObject3).zDG.y = i;
    ((c)localObject3).zDG.height = j;
    ((c)localObject3).zDG.pvg = this.mScreenRealHeight;
    ((c)localObject3).zDG.virtualKeyHeight = (this.mScreenRealHeight - this.mScreenHeight);
    ((c)localObject3).zDG.vpn = this.mStatusBarHeight;
    paramView = ((c)localObject3).zDG;
    if (this.mActionBarHeight <= 0) {}
    for (i = 144;; i = this.mActionBarHeight)
    {
      paramView.BqU = i;
      ((c)localObject3).zDG.dyP = this.mScrollState;
      ((c)localObject3).zDG.RCV = this.zDs;
      ((c)localObject3).position = paramInt;
      paramView = com.tencent.mm.vending.j.a.U(localObject3, Boolean.valueOf(((c)localObject3).LG(this.zDd)));
      AppMethodBeat.o(300193);
      return paramView;
    }
  }
  
  private void al(Activity paramActivity)
  {
    AppMethodBeat.i(169284);
    this.mScrollState = 0;
    initStatusBarHeight(paramActivity);
    initScreenHeight(paramActivity);
    dJS();
    AppMethodBeat.o(169284);
  }
  
  private void am(Activity paramActivity)
  {
    AppMethodBeat.i(300139);
    this.mScrollState = 0;
    initStatusBarHeight(paramActivity);
    initScreenHeight(paramActivity);
    dJT();
    AppMethodBeat.o(300139);
  }
  
  private void b(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186064);
    if (this.zDi == null)
    {
      AppMethodBeat.o(186064);
      return;
    }
    long l = System.currentTimeMillis();
    if (this.zDi.zDX <= 0L) {
      this.zDi.zDX = l;
    }
    if ((dJY()) || (this.mScrollState == 0))
    {
      a(paramViewGroup, paramInt1, paramInt2, l);
      AppMethodBeat.o(186064);
      return;
    }
    if ((this.zDd == 0) && (this.zDn != -1))
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
    if (this.zDi.zDT > 0L)
    {
      this.zDi.zDU = paramLong;
      if (this.zDg != null)
      {
        long l1 = this.zDi.zDU;
        long l2 = this.zDi.zDT;
        ffn localffn = this.zDg;
        localffn.abFu = (l1 - l2 + localffn.abFu);
      }
      this.zDi.dKa();
      a(paramViewGroup, paramInt1, paramInt2, paramLong, false);
    }
    if (this.zDi.zDV <= 0L) {
      this.zDi.zDV = paramLong;
    }
    AppMethodBeat.o(186066);
  }
  
  private com.tencent.mm.vending.j.c<Map<c, Boolean>, Integer> c(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(169297);
    if (this.zDd == 0)
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
            break label258;
          }
          localObject1 = ai((View)localObject1, j);
          if (localObject1 == null) {
            break label258;
          }
          boolean bool = ((Boolean)((com.tencent.mm.vending.j.c)localObject1).get(1)).booleanValue();
          localHashMap.put((c)((com.tencent.mm.vending.j.b)localObject1).get(0), Boolean.valueOf(bool));
          if (!bool) {
            break label258;
          }
          i += 1;
        }
      }
      label258:
      for (;;)
      {
        paramInt2 -= 1;
        break;
        if (this.zDt != null)
        {
          localObject2 = (LinearLayoutManager)this.zDt.get();
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = (LinearLayoutManager)((RecyclerView)paramViewGroup).getLayoutManager();
          if (localObject1 == null) {
            break label258;
          }
          this.zDt = new WeakReference(localObject1);
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
            paramViewGroup = com.tencent.mm.vending.j.a.U(localHashMap, Integer.valueOf(i));
            AppMethodBeat.o(185576);
            return paramViewGroup;
          }
        }
        break label54;
      }
    }
  }
  
  private void dJS()
  {
    AppMethodBeat.i(169285);
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.dJn();
    Log.i("HABBYGE-MALI.FeedMonitor", "startMonitor activityMethod: %d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(169285);
      return;
      hl(com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().dLA(), d.dLE());
      this.zDo = true;
      AppMethodBeat.o(169285);
      return;
      this.zDo = true;
      ViewGroup localViewGroup;
      if (this.zDq != null)
      {
        localViewGroup = (ViewGroup)this.zDq.get();
        if (localViewGroup != null) {
          a(localViewGroup, this.zDr, this.mVisibleItemCount);
        }
      }
      AppMethodBeat.o(169285);
      return;
      if (System.currentTimeMillis() - this.zDh > 30000L)
      {
        Log.i("HABBYGE-MALI.FeedMonitor", "_handleActivityMethod.BACK_2_FRONT: New Session");
        dJV();
        AppMethodBeat.o(169285);
        return;
      }
      this.zDo = true;
      if (this.zDq != null)
      {
        localViewGroup = (ViewGroup)this.zDq.get();
        if (localViewGroup != null) {
          a(localViewGroup, this.zDr, this.mVisibleItemCount);
        }
      }
    }
  }
  
  private void dJT()
  {
    AppMethodBeat.i(300150);
    hl(com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().dLA(), d.dLE());
    this.zDo = true;
    this.zDp = true;
    if (this.zDq != null)
    {
      ViewGroup localViewGroup = (ViewGroup)this.zDq.get();
      if (localViewGroup != null) {
        a(localViewGroup, Math.max(this.zDr, 0), Math.max(this.mVisibleItemCount, 1));
      }
    }
    AppMethodBeat.o(300150);
  }
  
  private void dJU()
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
  
  private void dJV()
  {
    AppMethodBeat.i(169288);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(169280);
        a.a(a.this);
        a.this.hl(this.rma, this.zDA);
        AppMethodBeat.o(169280);
      }
    });
    AppMethodBeat.o(169288);
  }
  
  private void dJW()
  {
    AppMethodBeat.i(169289);
    if (this.zDi == null)
    {
      AppMethodBeat.o(169289);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2;
    long l3;
    Object localObject;
    if (this.zDi.zDT > 0L)
    {
      this.zDi.zDU = l1;
      if (this.zDg != null)
      {
        l2 = this.zDi.zDU;
        l3 = this.zDi.zDT;
        localObject = this.zDg;
        ((ffn)localObject).abFu = (l2 - l3 + ((ffn)localObject).abFu);
      }
      this.zDi.dKa();
      if (this.zDq != null)
      {
        localObject = (ViewGroup)this.zDq.get();
        if (localObject != null) {
          a((ViewGroup)localObject, this.zDr, this.mVisibleItemCount, l1, false);
        }
      }
    }
    if (this.zDi.zDV > 0L)
    {
      this.zDi.zDW = l1;
      if (this.zDg == null) {
        break label296;
      }
      l2 = this.zDi.zDW;
      l3 = this.zDi.zDV;
      localObject = this.zDg;
      ((ffn)localObject).abFv = (l2 - l3 + ((ffn)localObject).abFv);
    }
    for (;;)
    {
      this.zDi.dKb();
      if (this.zDi.zDX > 0L)
      {
        this.zDi.zDY = l1;
        if (this.zDg != null)
        {
          l1 = this.zDi.zDY;
          l2 = this.zDi.zDX;
          localObject = this.zDg;
          ((ffn)localObject).abFt = (l1 - l2 + ((ffn)localObject).abFt);
        }
        localObject = this.zDi;
        ((h)localObject).zDX = 0L;
        ((h)localObject).zDY = 0L;
      }
      AppMethodBeat.o(169289);
      return;
      label296:
      Log.e("HABBYGE-MALI.FeedMonitor", "_stopComputeTimelineSliceTime mSnsTimeline is NULL 2");
    }
  }
  
  private void dJX()
  {
    AppMethodBeat.i(300164);
    this.zDp = false;
    dJU();
    AppMethodBeat.o(300164);
  }
  
  private boolean dJY()
  {
    return this.zDv <= 1000L;
  }
  
  private void dJZ()
  {
    AppMethodBeat.i(169305);
    if (this.zDe != null) {
      this.zDe.clear();
    }
    this.zDy = null;
    if (this.zDq != null)
    {
      this.zDq.clear();
      this.zDq = null;
    }
    AppMethodBeat.o(169305);
  }
  
  private com.tencent.mm.vending.j.c<Integer, Integer> ff(View paramView)
  {
    AppMethodBeat.i(169300);
    if (this.zDd == 0) {}
    for (int i = paramView.getHeight();; i = Math.max(paramView.getMeasuredHeight(), paramView.getHeight()))
    {
      paramView = com.tencent.mm.vending.j.a.U(Integer.valueOf(Math.min(getY(paramView), (int)paramView.getY())), Integer.valueOf(i));
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
        break label121;
      }
      localObject = ai((View)localObject, i);
      if (localObject == null) {
        break label121;
      }
      boolean bool = ((Boolean)((com.tencent.mm.vending.j.c)localObject).get(1)).booleanValue();
      localHashMap.put((c)((com.tencent.mm.vending.j.b)localObject).get(0), Boolean.valueOf(bool));
      if (!bool) {
        break label121;
      }
      paramInt += 1;
    }
    label121:
    for (;;)
    {
      i -= 1;
      break;
      paramViewGroup = com.tencent.mm.vending.j.a.U(localHashMap, Integer.valueOf(paramInt));
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
    String str = this.zDk.aj(paramViewGroup, paramInt - 1);
    if (str == null)
    {
      AppMethodBeat.o(169299);
      return true;
    }
    if (!str.equals(this.zDx))
    {
      this.zDu = getY(paramViewGroup);
      this.zDw = System.currentTimeMillis();
      this.zDx = str;
      AppMethodBeat.o(169299);
      return true;
    }
    paramInt = getY(paramViewGroup);
    int i = Math.abs(paramInt - this.zDu);
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.zDw;
    if ((l2 > 0L) && (i > this.zDc))
    {
      this.zDv = (i * 1000L / l2);
      this.zDu = paramInt;
      this.zDw = l1;
      AppMethodBeat.o(169299);
      return true;
    }
    AppMethodBeat.o(169299);
    return false;
  }
  
  private void initScreenHeight(Activity paramActivity)
  {
    AppMethodBeat.i(169304);
    try
    {
      if (this.zDy == null) {
        this.zDy = ((WindowManager)MMApplicationContext.getContext().getSystemService("window"));
      }
      localObject = this.zDy.getDefaultDisplay();
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
          localObject1 = ((LinearLayoutManager)localObject2).findViewByPosition(((LinearLayoutManager)localObject2).Jw());
          if (localObject1 == null)
          {
            localObject2 = paramViewGroup.getChildAt(((LinearLayoutManager)localObject2).Jw());
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
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.dJn();
    Log.i("HABBYGE-MALI.FeedMonitor", "stopMonitor, activityMethod: %s", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(169290);
      return;
      dJW();
      AppMethodBeat.o(169290);
      return;
      dJU();
      AppMethodBeat.o(169290);
      return;
      dJW();
      this.zDh = System.currentTimeMillis();
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
      al(paramActivity);
      AppMethodBeat.o(169283);
      return;
      stopMonitor();
      AppMethodBeat.o(169283);
      return;
      dJU();
      AppMethodBeat.o(169283);
      return;
      dJZ();
      AppMethodBeat.o(169283);
      return;
      am(paramActivity);
      AppMethodBeat.o(169283);
      return;
      dJX();
    }
  }
  
  public final void a(Activity paramActivity, ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(169291);
    if ((paramViewGroup instanceof RecyclerView)) {
      this.zDk.setRecyclerView((RecyclerView)paramViewGroup);
    }
    if ((this.zDq == null) || (this.zDq.get() == null)) {
      this.zDq = new WeakReference(paramViewGroup);
    }
    this.zDr = paramInt1;
    this.mVisibleItemCount = paramInt2;
    if (this.mScrollState == 1) {}
    for (;;)
    {
      try
      {
        if (Math.abs(paramInt3) > this.zDc)
        {
          if (paramInt3 <= 0) {
            continue;
          }
          this.zDs = -1;
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
        this.zDs = 1;
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
    if ((this.zDq == null) || (this.zDq.get() == null)) {
      this.zDq = new WeakReference(paramViewGroup);
    }
    if ((paramViewGroup instanceof RecyclerView)) {
      this.zDk.setRecyclerView((RecyclerView)paramViewGroup);
    }
    if (paramInt == 0) {
      this.zDs = 0;
    }
    if ((this.zDd == 0) && (paramInt != 2)) {
      this.zDn = -1;
    }
    if (this.zDp)
    {
      this.zDp = false;
      a(paramViewGroup, Math.max(this.zDr, 0), Math.max(this.mVisibleItemCount, 1), System.currentTimeMillis(), true);
    }
    AppMethodBeat.o(186062);
  }
  
  final void hl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(169286);
    this.zDg = new ffn();
    this.zDg.abFt = 0L;
    this.zDg.ooc = this.zDl;
    this.zDg.abFx = this.zDm;
    ffn localffn = this.zDg;
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    localffn.hQR = str;
    this.zDg.hOK = paramString2;
    com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGy = this.zDg.hQR;
    Log.i("HABBYGE-MALI.FeedMonitor", "initTimelineParams: %s, %s", new Object[] { this.zDg.hQR, this.zDg.hOK });
    this.zDg.abFu = 0L;
    this.zDg.abFv = 0L;
    this.zDe.clear();
    this.zDi = new h();
    this.zDj = new g();
    AppMethodBeat.o(169286);
  }
  
  public final void oO(boolean paramBoolean)
  {
    AppMethodBeat.i(186061);
    ViewGroup localViewGroup;
    int j;
    if (this.zDq != null)
    {
      localViewGroup = (ViewGroup)this.zDq.get();
      if (localViewGroup != null)
      {
        j = localViewGroup.getChildCount();
        if (!paramBoolean) {
          break label57;
        }
      }
    }
    label57:
    for (int i = 0;; i = this.zDr)
    {
      b(localViewGroup, i, j);
      AppMethodBeat.o(186061);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.a.a
 * JD-Core Version:    0.7.0.1
 */