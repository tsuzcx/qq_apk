package com.tencent.mm.plugin.finder.live;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.l;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.d.b.a;
import com.tencent.mm.plugin.finder.life.UILifecycleObserver;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.view.FinderLiveLayoutManager;
import com.tencent.mm.plugin.finder.live.view.FinderLiveRecyclerView;
import com.tencent.mm.plugin.finder.live.view.FinderLiveVisitorPluginLayout;
import com.tencent.mm.plugin.finder.live.view.i;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.al;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/FinderLiveViewCallback;", "Lcom/tencent/mm/plugin/finder/live/FinderLiveContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "rfLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "lifeCycle", "Landroid/arch/lifecycle/Lifecycle;", "presenter", "Lcom/tencent/mm/plugin/finder/live/FinderLiveContract$Presenter;", "isFromFloat", "", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;Lcom/tencent/mm/ui/MMActivity;Landroid/arch/lifecycle/Lifecycle;Lcom/tencent/mm/plugin/finder/live/FinderLiveContract$Presenter;Z)V", "AUTO_GUIDE_CANCEL", "", "LIVE_HISTORY_GUIDE_HEIGHT", "NEED_SHOW_HISTORY_GUIDE", "hasShowNewGuide", "mainHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getMainHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mainHandler$delegate", "Lkotlin/Lazy;", "multiTaskManager", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskManager;", "onCreateEvent", "recyclerView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLiveRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveRecyclerView;)V", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getRfLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "verticalPageSnapHelper", "Lcom/tencent/mm/plugin/finder/ui/FinderFullPagerSnapHelper;", "viewManager", "Lcom/tencent/mm/plugin/finder/live/FinderLiveViewManager;", "cancelNewGuide", "", "getActivity", "getPresenter", "initMultiTaskData", "initView", "data", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveDataModel;", "isFinish", "keyboardChange", "show", "height", "onActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "onBackPressed", "onCreate", "var1", "Landroid/arch/lifecycle/LifecycleOwner;", "onDestroy", "onInit", "onLoadMoreResult", "pullType", "incrementSize", "onNewIntent", "intent", "onPause", "onPreloadResult", "onResume", "onStart", "onStop", "onUninit", "refreshLayoutAction", "refreshLoadMoreAbility", "setNewGuide", "itemCount", "startLiveVideo", "Companion", "plugin-finder_release"})
public final class FinderLiveViewCallback
  implements UILifecycleObserver, c.b
{
  static final String TAG = "Finder.LiveViewCallback";
  private static boolean ufL;
  public static final a ufM;
  private final MMActivity activity;
  private final bbn reportObj;
  FinderLiveRecyclerView ufA;
  private final int ufB;
  private boolean ufC;
  final int ufD;
  private boolean ufE;
  private i ufF;
  private final kotlin.f ufG;
  private boolean ufH;
  final RefreshLoadMoreLayout ufI;
  private Lifecycle ufJ;
  final c.a ufK;
  private final f ufn;
  private final boolean ufp;
  private final com.tencent.mm.plugin.finder.ui.e ufz;
  
  static
  {
    AppMethodBeat.i(245855);
    ufM = new a((byte)0);
    TAG = "Finder.LiveViewCallback";
    AppMethodBeat.o(245855);
  }
  
  public FinderLiveViewCallback(RefreshLoadMoreLayout paramRefreshLoadMoreLayout, MMActivity paramMMActivity, Lifecycle paramLifecycle, c.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(245854);
    this.ufI = paramRefreshLoadMoreLayout;
    this.activity = paramMMActivity;
    this.ufJ = paramLifecycle;
    this.ufK = parama;
    this.ufp = paramBoolean;
    this.ufz = new com.tencent.mm.plugin.finder.ui.e();
    paramRefreshLoadMoreLayout = this.ufI.getRecyclerView();
    if (paramRefreshLoadMoreLayout == null)
    {
      paramRefreshLoadMoreLayout = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.view.FinderLiveRecyclerView");
      AppMethodBeat.o(245854);
      throw paramRefreshLoadMoreLayout;
    }
    this.ufA = ((FinderLiveRecyclerView)paramRefreshLoadMoreLayout);
    this.ufn = new f((WxRecyclerView)this.ufA);
    paramRefreshLoadMoreLayout = com.tencent.mm.ui.component.a.PRN;
    this.reportObj = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.activity).get(FinderReporterUIC.class)).dIx();
    int i = this.activity.getResources().getDimensionPixelSize(2131165281);
    this.ufB = (au.aD((Context)this.activity) + i);
    this.ufD = 2;
    this.ufG = kotlin.g.ah((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(245854);
  }
  
  private final void deO()
  {
    AppMethodBeat.i(245836);
    this.ufI.setActionCallback((RefreshLoadMoreLayout.a)new e(this));
    AppMethodBeat.o(245836);
  }
  
  private final void deS()
  {
    AppMethodBeat.i(245853);
    Object localObject1 = this.activity.getIntent().getByteArrayExtra("KEY_MULTI_TASK_INFO");
    Object localObject2 = o.ujN;
    localObject2 = o.dfU();
    if (localObject2 != null) {}
    for (localObject1 = new i((Activity)this.activity, (i)localObject2);; localObject1 = new i((Activity)this.activity, (byte[])localObject1))
    {
      this.ufF = ((i)localObject1);
      localObject1 = o.ujN;
      localObject1 = this.ufF;
      if (localObject1 == null) {
        p.btv("multiTaskManager");
      }
      o.a((i)localObject1);
      AppMethodBeat.o(245853);
      return;
    }
  }
  
  final void IY(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(245842);
    Object localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
    if (((Number)com.tencent.mm.plugin.finder.storage.c.dwW().value()).intValue() == 0)
    {
      Log.i(TAG, "FINDER_LIVE_GUIDE_ENABLE false");
      AppMethodBeat.o(245842);
      return;
    }
    if (this.ufE)
    {
      AppMethodBeat.o(245842);
      return;
    }
    this.ufE = true;
    if (paramInt > 1)
    {
      paramInt = 1;
      localObject = y.vXH;
      if ((y.dCU()) || (paramInt == 0)) {
        break label146;
      }
    }
    for (;;)
    {
      this.ufC = bool;
      if (!this.ufC) {
        break label151;
      }
      this.ufA.a((RecyclerView.l)new f(this));
      this.ufA.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new g(this));
      AppMethodBeat.o(245842);
      return;
      paramInt = 0;
      break;
      label146:
      bool = false;
    }
    label151:
    this.ufz.f((RecyclerView)this.ufA);
    AppMethodBeat.o(245842);
  }
  
  public final void MC()
  {
    AppMethodBeat.i(245846);
    Log.i(TAG, "[LiveLifecycle]onInit ".concat(String.valueOf(this)));
    AppMethodBeat.o(245846);
  }
  
  public final void a(int paramInt1, com.tencent.mm.plugin.finder.live.viewmodel.d paramd, int paramInt2)
  {
    AppMethodBeat.i(245843);
    Object localObject2 = TAG;
    Object localObject3 = new StringBuilder("onLoadMoreResult pullType:").append(paramInt1).append(" increment size:").append(paramInt2).append(",init position:");
    if (paramd != null)
    {
      localObject1 = Integer.valueOf(paramd.getInitPos());
      Log.i((String)localObject2, localObject1);
      if (paramInt2 > 0) {
        break label247;
      }
      localObject1 = this.ufI.getFooter$7529eef0();
      if (localObject1 != null)
      {
        localObject1 = ((View)localObject1).findViewById(2131303711);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
      }
      localObject1 = this.ufI.getFooter$7529eef0();
      if (localObject1 != null)
      {
        localObject1 = ((View)localObject1).findViewById(2131303682);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(0);
        }
      }
    }
    for (;;)
    {
      this.ufI.apT(paramInt2);
      if (paramd == null) {
        break label525;
      }
      localObject1 = paramd.uCu;
      if (localObject1 == null) {
        break label525;
      }
      paramInt1 = ((ArrayList)localObject1).size();
      localObject2 = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (paramInt1 <= com.tencent.mm.plugin.finder.storage.c.duZ()) {
        break label327;
      }
      paramInt1 = ((ArrayList)localObject1).size();
      localObject2 = com.tencent.mm.plugin.finder.storage.c.vCb;
      paramInt2 = paramInt1 - com.tencent.mm.plugin.finder.storage.c.duZ();
      paramInt1 = paramInt2;
      while ((paramInt1 > 0) && (paramd.getInitPos() > 0))
      {
        ((ArrayList)localObject1).remove(0);
        paramInt1 -= 1;
        paramd.Jq(paramd.getInitPos() - 1);
      }
      localObject1 = null;
      break;
      label247:
      localObject1 = this.ufI.getFooter$7529eef0();
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
    }
    Object localObject1 = TAG;
    localObject2 = new StringBuilder("max live size:");
    localObject3 = com.tencent.mm.plugin.finder.storage.c.vCb;
    Log.i((String)localObject1, com.tencent.mm.plugin.finder.storage.c.duZ() + ",delete " + (paramInt2 - paramInt1) + " old live data!");
    label327:
    paramInt1 = paramd.getInitPos() + 1;
    boolean bool = deQ();
    if (!bool)
    {
      paramInt2 = paramd.uCu.size();
      if (paramInt1 >= 0) {
        break label414;
      }
    }
    label414:
    while (paramInt2 <= paramInt1)
    {
      Log.i(TAG, "onLoadMoreResult isFinish:" + bool + ", nextPosition:" + paramInt1 + ", size:" + paramd.uCu.size());
      AppMethodBeat.o(245843);
      return;
    }
    paramd = this.ufA.getAdapter();
    if (paramd != null) {
      paramd.notifyDataSetChanged();
    }
    paramd = this.ufA;
    localObject1 = com.tencent.mm.hellhoundlib.b.c.a(paramInt1, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(paramd, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback", "onLoadMoreResult", "(ILcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveDataModel;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    paramd.smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramd, "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback", "onLoadMoreResult", "(ILcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveDataModel;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    AppMethodBeat.o(245843);
    return;
    label525:
    AppMethodBeat.o(245843);
  }
  
  public final void a(final com.tencent.mm.plugin.finder.live.viewmodel.d paramd)
  {
    AppMethodBeat.i(245835);
    p.h(paramd, "data");
    Object localObject = this.ufK;
    if (localObject != null)
    {
      localObject = Boolean.valueOf(((c.a)localObject).deL());
      Log.i(TAG, "load more setting:".concat(String.valueOf(localObject)));
      if (!p.j(localObject, Boolean.FALSE)) {
        break label288;
      }
      this.ufI.setEnableRefresh(false);
      this.ufI.setEnableLoadMore(false);
    }
    int i;
    int j;
    for (;;)
    {
      deP();
      deS();
      localObject = this.ufA.getContext();
      p.g(localObject, "recyclerView.context");
      localObject = new FinderLiveLayoutManager((Context)localObject);
      ((FinderLiveLayoutManager)localObject).uyJ = ((kotlin.g.a.m)new b(this, paramd));
      FinderLiveRecyclerView localFinderLiveRecyclerView = this.ufA;
      localFinderLiveRecyclerView.setAdapter((RecyclerView.a)new b(paramd, this.ufn, this.ufp, this.reportObj));
      localFinderLiveRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
      ((FinderLiveLayoutManager)localObject).uyK = ((kotlin.g.a.a)new c(this));
      localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (((Number)com.tencent.mm.plugin.finder.storage.c.dwW().value()).intValue() != 0)
      {
        localObject = y.vXH;
        if (!y.dCU()) {}
      }
      else
      {
        this.ufz.f((RecyclerView)this.ufA);
      }
      localObject = this.ufJ;
      if (localObject != null) {
        ((Lifecycle)localObject).addObserver((LifecycleObserver)this);
      }
      i = paramd.uCu.size();
      j = paramd.getInitPos();
      if (j >= 0) {
        break label295;
      }
      AppMethodBeat.o(245835);
      return;
      localObject = null;
      break;
      label288:
      deO();
    }
    label295:
    if (i > j)
    {
      localObject = this.ufA.getAdapter();
      if (localObject == null)
      {
        paramd = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.FinderLiveAdapter");
        AppMethodBeat.o(245835);
        throw paramd;
      }
      ((b)localObject).ufl = true;
      localObject = this.ufA;
      paramd = com.tencent.mm.hellhoundlib.b.c.a(paramd.getInitPos(), new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramd.axQ(), "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback", "initView", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveDataModel;)V", "Undefined", "scrollToPosition", "(I)V");
      ((FinderLiveRecyclerView)localObject).scrollToPosition(((Integer)paramd.pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback", "initView", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveDataModel;)V", "Undefined", "scrollToPosition", "(I)V");
    }
    AppMethodBeat.o(245835);
  }
  
  final void deP()
  {
    AppMethodBeat.i(245837);
    Object localObject = this.ufK;
    if (localObject != null) {}
    for (localObject = Boolean.valueOf(((c.a)localObject).deK());; localObject = null)
    {
      Log.i(TAG, "refreshLoadMoreAbility:".concat(String.valueOf(localObject)));
      this.ufI.setEnableNestedScroll(p.j(localObject, Boolean.FALSE) ^ true);
      AppMethodBeat.o(245837);
      return;
    }
  }
  
  final boolean deQ()
  {
    AppMethodBeat.i(245844);
    boolean bool1 = this.activity.isFinishing();
    boolean bool2 = this.activity.isDestroyed();
    AppMethodBeat.o(245844);
    return bool1 | bool2;
  }
  
  public final void deR()
  {
    AppMethodBeat.i(245845);
    Log.i(TAG, "[LiveLifecycle]onUninit ".concat(String.valueOf(this)));
    this.ufn.release();
    AppMethodBeat.o(245845);
  }
  
  final MMHandler getMainHandler()
  {
    AppMethodBeat.i(245834);
    MMHandler localMMHandler = (MMHandler)this.ufG.getValue();
    AppMethodBeat.o(245834);
    return localMMHandler;
  }
  
  public final void keyboardChange(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(245841);
    FinderLiveVisitorPluginLayout localFinderLiveVisitorPluginLayout = this.ufn.ufS;
    if (localFinderLiveVisitorPluginLayout != null)
    {
      localFinderLiveVisitorPluginLayout.keyboardChange(paramBoolean, paramInt);
      AppMethodBeat.o(245841);
      return;
    }
    AppMethodBeat.o(245841);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(245838);
    FinderLiveVisitorPluginLayout localFinderLiveVisitorPluginLayout = this.ufn.ufS;
    if (localFinderLiveVisitorPluginLayout != null)
    {
      localFinderLiveVisitorPluginLayout.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(245838);
      return;
    }
    AppMethodBeat.o(245838);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(245840);
    FinderLiveVisitorPluginLayout localFinderLiveVisitorPluginLayout = this.ufn.ufS;
    if (localFinderLiveVisitorPluginLayout != null)
    {
      boolean bool = localFinderLiveVisitorPluginLayout.onBackPress();
      AppMethodBeat.o(245840);
      return bool;
    }
    AppMethodBeat.o(245840);
    return false;
  }
  
  public final void onCreate(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(245847);
    p.h(paramLifecycleOwner, "var1");
    Log.i(TAG, "[LiveLifecycle]onCreate " + this + ", lifecycleOwner:" + paramLifecycleOwner);
    this.ufH = true;
    AppMethodBeat.o(245847);
  }
  
  public final void onDestroy(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(245852);
    p.h(paramLifecycleOwner, "var1");
    Log.i(TAG, "[LiveLifecycle]onDestroy " + this + ", lifecycleOwner:" + paramLifecycleOwner);
    ufL = false;
    AppMethodBeat.o(245852);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(245839);
    FinderLiveVisitorPluginLayout localFinderLiveVisitorPluginLayout = this.ufn.ufS;
    if (localFinderLiveVisitorPluginLayout != null)
    {
      localFinderLiveVisitorPluginLayout.onNewIntent(paramIntent);
      AppMethodBeat.o(245839);
      return;
    }
    AppMethodBeat.o(245839);
  }
  
  public final void onPause(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(245850);
    p.h(paramLifecycleOwner, "var1");
    Log.i(TAG, "[LiveLifecycle]onPause " + this + ", lifecycleOwner:" + paramLifecycleOwner);
    paramLifecycleOwner = this.ufn.ufS;
    if (paramLifecycleOwner != null) {
      paramLifecycleOwner.pause();
    }
    this.ufH = false;
    AppMethodBeat.o(245850);
  }
  
  public final void onResume(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(245849);
    p.h(paramLifecycleOwner, "var1");
    Log.i(TAG, "[LiveLifecycle]onResume " + this + ", lifecycleOwner:" + paramLifecycleOwner);
    paramLifecycleOwner = this.ufn.ufS;
    if (paramLifecycleOwner != null) {
      paramLifecycleOwner.resume();
    }
    paramLifecycleOwner = this.ufn.ufS;
    int i;
    if (paramLifecycleOwner != null)
    {
      paramLifecycleOwner = paramLifecycleOwner.getVideoOrientationPluginVisiableVisable();
      localObject = this.ufn.ufS;
      if (localObject == null) {
        break label157;
      }
      localObject = ((FinderLiveVisitorPluginLayout)localObject).getContext();
      if (localObject == null) {
        break label157;
      }
      localObject = ((Context)localObject).getResources();
      if (localObject == null) {
        break label157;
      }
      localObject = ((Resources)localObject).getConfiguration();
      if (localObject == null) {
        break label157;
      }
      i = ((Configuration)localObject).orientation;
      if (!this.ufH) {
        break label164;
      }
    }
    label157:
    label164:
    for (Object localObject = s.al.vqM;; localObject = s.al.vqN)
    {
      com.tencent.mm.plugin.finder.report.live.m localm = com.tencent.mm.plugin.finder.report.live.m.vli;
      com.tencent.mm.plugin.finder.report.live.m.a(paramLifecycleOwner, i, (s.al)localObject);
      AppMethodBeat.o(245849);
      return;
      paramLifecycleOwner = null;
      break;
      AppMethodBeat.o(245849);
      return;
    }
  }
  
  public final void onStart(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(245848);
    p.h(paramLifecycleOwner, "var1");
    Log.i(TAG, "[LiveLifecycle]onStart " + this + ", lifecycleOwner:" + paramLifecycleOwner);
    paramLifecycleOwner = k.vkd;
    k.dpl().vlx = true;
    paramLifecycleOwner = o.ujN;
    paramLifecycleOwner = o.dfZ();
    if (paramLifecycleOwner != null) {
      paramLifecycleOwner.uDS = true;
    }
    paramLifecycleOwner = o.ujN;
    paramLifecycleOwner = o.dfZ();
    if (paramLifecycleOwner != null) {
      paramLifecycleOwner.uEv = false;
    }
    paramLifecycleOwner = com.tencent.mm.live.core.core.d.b.hCo;
    paramLifecycleOwner = b.a.aEf();
    Log.i(TAG, "startLiveVideo,float mode:" + paramLifecycleOwner.hAz.isFloatMode() + ", normal mode:" + paramLifecycleOwner.hAz.isNormalMode());
    if (paramLifecycleOwner.hAz.isFloatMode()) {
      paramLifecycleOwner.aBU();
    }
    paramLifecycleOwner = this.ufn.ufS;
    if (paramLifecycleOwner != null)
    {
      paramLifecycleOwner.start();
      AppMethodBeat.o(245848);
      return;
    }
    AppMethodBeat.o(245848);
  }
  
  public final void onStop(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(245851);
    p.h(paramLifecycleOwner, "var1");
    Log.i(TAG, "[LiveLifecycle]onStop " + this + ", lifecycleOwner:" + paramLifecycleOwner);
    paramLifecycleOwner = this.ufn.ufS;
    if (paramLifecycleOwner != null)
    {
      paramLifecycleOwner.stop();
      AppMethodBeat.o(245851);
      return;
    }
    AppMethodBeat.o(245851);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/FinderLiveViewCallback$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "inNewGuideStatus", "", "getInNewGuideStatus", "()Z", "setInNewGuideStatus", "(Z)V", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "pos", "", "child", "Landroid/view/View;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.m<Integer, View, x>
  {
    b(FinderLiveViewCallback paramFinderLiveViewCallback, com.tencent.mm.plugin.finder.live.viewmodel.d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<Integer>
  {
    c(FinderLiveViewCallback paramFinderLiveViewCallback)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<MMHandler>
  {
    d(FinderLiveViewCallback paramFinderLiveViewCallback)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
    static final class a
      implements MMHandler.Callback
    {
      a(FinderLiveViewCallback.d paramd) {}
      
      public final boolean handleMessage(Message paramMessage)
      {
        AppMethodBeat.i(245824);
        if (paramMessage.what == FinderLiveViewCallback.f(this.ufP.ufN))
        {
          paramMessage = FinderLiveViewCallback.ufM;
          FinderLiveViewCallback.nj(false);
          FinderLiveViewCallback.g(this.ufP.ufN).f((RecyclerView)this.ufP.ufN.ufA);
          paramMessage = com.tencent.mm.kernel.g.aAh();
          p.g(paramMessage, "MMKernel.storage()");
          paramMessage.azQ().set(ar.a.OmW, Boolean.TRUE);
        }
        AppMethodBeat.o(245824);
        return true;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$refreshLayoutAction$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder_release"})
  public static final class e
    extends RefreshLoadMoreLayout.a
  {
    public final void ED(int paramInt)
    {
      AppMethodBeat.i(245828);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$refreshLayoutAction$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      super.ED(paramInt);
      localObject = FinderLiveViewCallback.ufM;
      Log.i(FinderLiveViewCallback.access$getTAG$cp(), "onRefreshBegin");
      this.ufN.ufI.apS(0);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$refreshLayoutAction$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(245828);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(245827);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$refreshLayoutAction$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      p.h(paramc, "reason");
      paramc = FinderLiveViewCallback.ufM;
      Log.i(FinderLiveViewCallback.access$getTAG$cp(), "onLoadMoreEnd");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$refreshLayoutAction$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(245827);
    }
    
    public final void cxo()
    {
      Object localObject4 = null;
      AppMethodBeat.i(245826);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$refreshLayoutAction$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      Object localObject1 = this.ufN.ufK;
      Object localObject2;
      label83:
      Object localObject3;
      if (localObject1 != null)
      {
        localObject2 = Boolean.valueOf(((c.a)localObject1).deM());
        localObject1 = FinderLiveViewCallback.ufM;
        Log.i(FinderLiveViewCallback.access$getTAG$cp(), "onLoadMoreBegin flingUpType:".concat(String.valueOf(localObject2)));
        localObject1 = this.ufN.ufI.getFooter$7529eef0();
        if (localObject1 == null) {
          break label190;
        }
        localObject1 = ((View)localObject1).findViewById(2131303711);
        localObject3 = localObject1;
        if (!(localObject1 instanceof MMProcessBar)) {
          localObject3 = null;
        }
        localObject3 = (MMProcessBar)localObject3;
        View localView = this.ufN.ufI.getFooter$7529eef0();
        localObject1 = localObject4;
        if (localView != null) {
          localObject1 = localView.findViewById(2131303682);
        }
        if (!p.j(localObject2, Boolean.TRUE)) {
          break label195;
        }
        if (localObject3 != null) {
          ((MMProcessBar)localObject3).setVisibility(8);
        }
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(0);
        }
        this.ufN.ufI.apT(0);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$refreshLayoutAction$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
        AppMethodBeat.o(245826);
        return;
        localObject2 = null;
        break;
        label190:
        localObject1 = null;
        break label83;
        label195:
        if (localObject3 != null)
        {
          localObject2 = MMApplicationContext.getContext();
          p.g(localObject2, "MMApplicationContext.getContext()");
          ((MMProcessBar)localObject3).setBackground$255f295(((Context)localObject2).getResources().getColor(2131099844));
        }
        if (localObject3 != null) {
          ((MMProcessBar)localObject3).setVisibility(0);
        }
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        localObject1 = this.ufN.ufK;
        if (localObject1 != null) {
          ((c.a)localObject1).boE();
        }
      }
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(245829);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$refreshLayoutAction$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      p.h(paramc, "reason");
      super.onRefreshEnd(paramc);
      paramc = FinderLiveViewCallback.ufM;
      Log.i(FinderLiveViewCallback.access$getTAG$cp(), "onRefreshEnd");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$refreshLayoutAction$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(245829);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$setNewGuide$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
  public static final class f
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(245830);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$setNewGuide$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 1)
      {
        paramRecyclerView.b((RecyclerView.l)this);
        paramRecyclerView = this.ufN;
        paramRecyclerView.getMainHandler().removeMessages(paramRecyclerView.ufD);
        paramRecyclerView.getMainHandler().sendEmptyMessage(paramRecyclerView.ufD);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$setNewGuide$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(245830);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(245831);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt1);
      localb.pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$setNewGuide$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$setNewGuide$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(245831);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$setNewGuide$2", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-finder_release"})
  public static final class g
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(245833);
      this.ufN.ufA.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      com.tencent.mm.ac.d.a(800L, (kotlin.g.a.a)new a(this));
      AppMethodBeat.o(245833);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(FinderLiveViewCallback.g paramg)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.FinderLiveViewCallback
 * JD-Core Version:    0.7.0.1
 */