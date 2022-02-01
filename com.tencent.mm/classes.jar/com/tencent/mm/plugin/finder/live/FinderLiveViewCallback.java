package com.tencent.mm.plugin.finder.live;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.f.a.hu;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.core.core.c.a.a;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.event.recyclerview.FinderRecyclerView.b;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s;
import com.tencent.mm.plugin.finder.live.report.s.l;
import com.tencent.mm.plugin.finder.live.view.FinderLiveLayoutManager;
import com.tencent.mm.plugin.finder.live.view.FinderLiveRecyclerView;
import com.tencent.mm.plugin.finder.live.view.FinderLiveVisitorPluginLayout;
import com.tencent.mm.plugin.finder.utils.ap;
import com.tencent.mm.plugin.finder.utils.ap.c;
import com.tencent.mm.plugin.finder.utils.ar;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bbf;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/FinderLiveViewCallback;", "Lcom/tencent/mm/plugin/finder/live/FinderLiveContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "rfLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "fragment", "Landroidx/fragment/app/Fragment;", "presenter", "Lcom/tencent/mm/plugin/finder/live/FinderLiveContract$Presenter;", "isFromFloat", "", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;Lcom/tencent/mm/ui/MMActivity;Landroidx/fragment/app/Fragment;Lcom/tencent/mm/plugin/finder/live/FinderLiveContract$Presenter;Z)V", "LIVE_HISTORY_GUIDE_HEIGHT", "", "NEED_SHOW_HISTORY_GUIDE", "feedChangeListener", "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$feedChangeListener$1", "Lcom/tencent/mm/plugin/finder/live/FinderLiveViewCallback$feedChangeListener$1;", "getFragment", "()Landroidx/fragment/app/Fragment;", "hasShowNewGuide", "lifeCycle", "Landroidx/lifecycle/Lifecycle;", "liveLayoutManager", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveLayoutManager;", "getLiveLayoutManager", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLiveLayoutManager;", "setLiveLayoutManager", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveLayoutManager;)V", "multiTaskManager", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskManager;", "onCreateEvent", "recyclerView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLiveRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveRecyclerView;)V", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getRfLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "verticalPageSnapHelper", "Lcom/tencent/mm/plugin/finder/ui/FinderFullPagerSnapHelper;", "viewManager", "Lcom/tencent/mm/plugin/finder/live/FinderLiveViewManager;", "cancelNewGuide", "", "showNextTime", "getActivity", "getPresenter", "initMultiTaskData", "initView", "data", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveDataModel;", "isFinish", "keyboardChange", "show", "height", "notifyItemRangeChange", "dataSize", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "notify", "startNotifyPos", "onActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "var1", "Landroidx/lifecycle/LifecycleOwner;", "onDestroy", "onInit", "onLoadMoreResult", "pullType", "oriDataSize", "incrementSize", "onNewIntent", "intent", "onPause", "onPreloadResult", "onResume", "onStart", "onStop", "onUninit", "refreshLayoutAction", "canLoadMore", "canFlingUp", "refreshLoadMoreAbility", "selectItemView", "pos", "fromPageSelected", "forceUpdate", "setNewGuide", "itemCount", "startLiveVideo", "updateLayoutManager", "itemView", "Landroid/view/View;", "itemData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "Companion", "plugin-finder_release"})
public final class FinderLiveViewCallback
  implements com.tencent.mm.plugin.finder.life.b, c.b
{
  private static boolean xWh;
  public static final a xWi;
  final MMActivity activity;
  final Fragment fragment;
  final bid reportObj;
  public final l xUG;
  final boolean xUJ;
  final c.a xUN;
  androidx.lifecycle.h xVW;
  final com.tencent.mm.plugin.finder.ui.e xVX;
  FinderLiveRecyclerView xVY;
  FinderLiveLayoutManager xVZ;
  private final int xWa;
  private boolean xWb;
  private boolean xWc;
  com.tencent.mm.plugin.finder.live.view.e xWd;
  private final b xWe;
  private boolean xWf;
  final RefreshLoadMoreLayout xWg;
  
  static
  {
    AppMethodBeat.i(269435);
    xWi = new a((byte)0);
    AppMethodBeat.o(269435);
  }
  
  public FinderLiveViewCallback(RefreshLoadMoreLayout paramRefreshLoadMoreLayout, MMActivity paramMMActivity, Fragment paramFragment, c.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(269434);
    this.xWg = paramRefreshLoadMoreLayout;
    this.activity = paramMMActivity;
    this.fragment = paramFragment;
    this.xUN = parama;
    this.xUJ = paramBoolean;
    paramRefreshLoadMoreLayout = this.fragment;
    if (paramRefreshLoadMoreLayout != null) {}
    for (paramRefreshLoadMoreLayout = paramRefreshLoadMoreLayout.getLifecycle();; paramRefreshLoadMoreLayout = null)
    {
      this.xVW = paramRefreshLoadMoreLayout;
      this.xVX = new com.tencent.mm.plugin.finder.ui.e();
      paramRefreshLoadMoreLayout = this.xWg.getRecyclerView();
      if (paramRefreshLoadMoreLayout != null) {
        break;
      }
      paramRefreshLoadMoreLayout = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.view.FinderLiveRecyclerView");
      AppMethodBeat.o(269434);
      throw paramRefreshLoadMoreLayout;
    }
    this.xVY = ((FinderLiveRecyclerView)paramRefreshLoadMoreLayout);
    paramRefreshLoadMoreLayout = com.tencent.mm.ui.component.g.Xox;
    this.reportObj = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.activity).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY();
    this.xUG = new l((WxRecyclerView)this.xVY, this.reportObj);
    int i = this.activity.getResources().getDimensionPixelSize(b.d.Edge_12A);
    this.xWa = (ax.aB((Context)this.activity) + i);
    this.xWe = new b(this);
    AppMethodBeat.o(269434);
  }
  
  private final void a(int paramInt, View paramView, com.tencent.mm.plugin.finder.live.viewmodel.data.f paramf, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(269419);
    boolean bool;
    Object localObject1;
    label43:
    FinderLiveVisitorPluginLayout localFinderLiveVisitorPluginLayout;
    label120:
    Object localObject2;
    label212:
    int i;
    if (this.xUG.pos == -1)
    {
      bool = this.xUJ;
      localObject1 = this.xUN;
      if (localObject1 == null) {
        break label1044;
      }
      localObject1 = ((c.a)localObject1).dwh();
      localFinderLiveVisitorPluginLayout = (FinderLiveVisitorPluginLayout)paramView.findViewById(b.f.finder_live_visitor_plugin_layout);
      paramView = new StringBuilder("selectItemView:").append(paramInt).append(" fromFloat:").append(bool).append(", pluginLayout:").append(localFinderLiveVisitorPluginLayout.hashCode()).append(" fromPageSelected:").append(paramBoolean1).append(", liveData is empty:");
      if (localObject1 != null) {
        break label1050;
      }
      paramBoolean1 = true;
      Log.i("Finder.LiveViewCallback", paramBoolean1 + ",forceUpdate:" + paramBoolean2);
      paramView = ar.AIS;
      localObject2 = new StringBuilder();
      Object localObject3 = ar.AIS;
      localObject2 = ar.efV() + localFinderLiveVisitorPluginLayout.getData().zey.getLiveId();
      localObject3 = ap.AIh;
      localObject3 = ap.efh().name;
      if (bool) {
        break label1056;
      }
      paramBoolean1 = true;
      ar.a(paramView, (String)localObject2, (String)localObject3, null, paramBoolean1, false, false, 52);
      localObject3 = this.xUG;
      p.j(localFinderLiveVisitorPluginLayout, "pluginLayout");
      p.k(localFinderLiveVisitorPluginLayout, "newPlugin");
      Log.i("Finder.LiveViewCallback", "before update plugins,pos:" + ((l)localObject3).pos + ' ' + ((l)localObject3).xWt + ' ' + localFinderLiveVisitorPluginLayout);
      i = ((l)localObject3).pos;
      if ((!bool) && (paramf != null))
      {
        paramView = paramf.xWR;
        if (paramView != null)
        {
          paramView = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramView.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
          if ((paramView != null) && (paramView.isLiveStarted() == true))
          {
            paramView = k.yBj;
            s locals = k.dDm();
            localObject2 = paramf.zey.getSessionBuffer();
            paramView = (View)localObject2;
            if (localObject2 == null)
            {
              paramView = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramf.xWR.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zeZ;
              if (paramView == null) {
                break label1062;
              }
              paramView = paramView.sessionBuffer;
            }
            label399:
            localObject2 = paramView;
            if (paramView == null) {
              localObject2 = "";
            }
            p.k(localObject2, "<set-?>");
            locals.yDi = ((String)localObject2);
            com.tencent.mm.plugin.expt.hellhound.a.aww(s.l.yFQ.scene);
            paramView = k.yBj;
            k.dDm().aCC(s.l.yFQ.scene);
            paramView = k.yBj;
            k.dDm().yCG = paramInt;
          }
        }
      }
      paramView = ((l)localObject3).xWt;
      Log.i("Finder.LiveViewCallback", "deactivate plugin pos:" + ((l)localObject3).pos);
      if (paramView != null)
      {
        paramView.reset(false);
        paramView.unMount();
      }
      Log.i("Finder.LiveViewCallback", "after deactivate plugin,thread:" + Thread.currentThread());
      ((l)localObject3).xWt = localFinderLiveVisitorPluginLayout;
      ((l)localObject3).pos = paramInt;
      paramView = ((l)localObject3).xWt;
      Log.i("Finder.LiveViewCallback", "activate plugin pos:" + ((l)localObject3).pos + " data:" + paramf);
      if ((paramf != null) && (paramView != null))
      {
        localObject2 = ah.yhC;
        localObject2 = ah.a(paramf);
        if (localObject2 != null)
        {
          ah.a(ah.yhC, (com.tencent.mm.plugin.finder.live.model.context.a)localObject2, (com.tencent.mm.plugin.finder.live.view.a)paramView, ((l)localObject3).pos, 0, ((l)localObject3).reportObj, 8);
          paramView.activate(paramf, bool, paramBoolean2);
          paramView.mount();
        }
      }
      Log.i("Finder.LiveViewCallback", "after activate plugin!");
      Log.i("Finder.LiveViewCallback", "after update plugins,pos:" + ((l)localObject3).pos);
      com.tencent.e.h.ZvG.be((Runnable)new l.a((l)localObject3, i, paramInt, paramf));
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject1).NU(paramInt);
      }
      paramView = this.xUN;
      label783:
      if (paramView != null)
      {
        paramf = this.xVY.getAdapter();
        if (paramf == null) {
          break label1067;
        }
        i = paramf.getItemCount();
        label751:
        if (!paramView.gC(paramInt, i))
        {
          if (localObject1 == null) {
            break label1073;
          }
          paramView = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject1).zeA;
          if (paramView == null) {
            break label1073;
          }
          paramInt = paramView.size();
          MV(paramInt);
        }
      }
      paramView = ah.yhC;
      paramView = this.xWd;
      if (paramView == null) {
        p.bGy("multiTaskManager");
      }
      ah.a(paramView);
      paramView = ah.yhC;
      localObject1 = ah.dzg();
      if (localObject1 != null)
      {
        paramView = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
        paramView = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
        if (paramView != null)
        {
          localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)paramView.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
          if (localObject2 != null)
          {
            paramf = (bbf)((com.tencent.mm.plugin.finder.live.view.e)localObject1).yVq.get(Long.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject2).liveInfo.liveId));
            paramView = paramf;
            if (paramf == null) {
              paramView = new bbf();
            }
            p.j(paramView, "multiTaskDataMap[it.live…FinderLiveMultiTaskData()");
            paramView = (CharSequence)paramView.key;
            if ((paramView != null) && (paramView.length() != 0)) {
              break label1078;
            }
            paramInt = 1;
            label921:
            if (paramInt == 0) {
              break label1083;
            }
            ((com.tencent.mm.plugin.finder.live.view.e)localObject1).getMainHandler().removeMessages(3);
            paramView = ((com.tencent.mm.plugin.finder.live.view.e)localObject1).getMainHandler();
            paramf = com.tencent.mm.plugin.finder.live.view.e.dFk();
            localObject1 = com.tencent.mm.plugin.finder.live.view.e.yVt;
            paramView.sendEmptyMessageDelayed(3, ((Number)paramf.getValue()).longValue());
          }
        }
      }
    }
    for (;;)
    {
      paramView = ar.AIS;
      paramf = new StringBuilder();
      localObject1 = ar.AIS;
      paramf = ar.efV() + localFinderLiveVisitorPluginLayout.getData().zey.getLiveId();
      localObject1 = ap.AIh;
      ar.a(paramView, paramf, ap.efj().name, null, false, false, false, 60);
      AppMethodBeat.o(269419);
      return;
      bool = false;
      break;
      label1044:
      localObject1 = null;
      break label43;
      label1050:
      paramBoolean1 = false;
      break label120;
      label1056:
      paramBoolean1 = false;
      break label212;
      label1062:
      paramView = null;
      break label399;
      label1067:
      i = 0;
      break label751;
      label1073:
      paramInt = 0;
      break label783;
      label1078:
      paramInt = 0;
      break label921;
      label1083:
      Log.i("FinderLiveMultiTaskManager", "checkAddToHistory: has added, liveId = " + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject2).liveInfo.liveId + ", objectId = " + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject2).xbk);
    }
  }
  
  public static void oD(boolean paramBoolean)
  {
    AppMethodBeat.i(269418);
    if (!xWh)
    {
      AppMethodBeat.o(269418);
      return;
    }
    Log.i("Finder.LiveViewCallback", "cancelNewGuide ".concat(String.valueOf(paramBoolean)));
    xWh = false;
    if (!paramBoolean)
    {
      com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
      p.j(localf, "MMKernel.storage()");
      localf.aHp().set(ar.a.VBX, Boolean.TRUE);
    }
    AppMethodBeat.o(269418);
  }
  
  final void MV(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(269421);
    Object localObject = com.tencent.c.a.a.a.a.a.Zlt;
    if (((Number)com.tencent.c.a.a.a.a.a.ilG().aSr()).intValue() == 0)
    {
      Log.i("Finder.LiveViewCallback", "FINDER_LIVE_GUIDE_ENABLE false");
      AppMethodBeat.o(269421);
      return;
    }
    if (this.xWc)
    {
      AppMethodBeat.o(269421);
      return;
    }
    this.xWc = true;
    if (paramInt > 1)
    {
      paramInt = 1;
      localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if ((com.tencent.mm.plugin.finder.utils.aj.ees()) || (paramInt == 0)) {
        break label146;
      }
    }
    for (;;)
    {
      this.xWb = bool;
      if (!this.xWb) {
        break label151;
      }
      this.xVY.a((RecyclerView.l)new i(this));
      this.xVY.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new j(this));
      AppMethodBeat.o(269421);
      return;
      paramInt = 0;
      break;
      label146:
      bool = false;
    }
    label151:
    this.xVX.a((RecyclerView)this.xVY);
    AppMethodBeat.o(269421);
  }
  
  final void dwJ()
  {
    AppMethodBeat.i(269420);
    Object localObject = this.xUN;
    if (localObject != null) {}
    for (localObject = Boolean.valueOf(((c.a)localObject).dwe());; localObject = null)
    {
      Log.i("Finder.LiveViewCallback", "refreshLoadMoreAbility:".concat(String.valueOf(localObject)));
      this.xWg.setEnableNestedScroll(p.h(localObject, Boolean.FALSE) ^ true);
      AppMethodBeat.o(269420);
      return;
    }
  }
  
  public final void dwK()
  {
    AppMethodBeat.i(269422);
    Log.i("Finder.LiveViewCallback", "[LiveLifecycle]onUninit ".concat(String.valueOf(this)));
    Object localObject = this.xUG;
    Log.i("Finder.LiveViewCallback", "release:" + ((l)localObject).xWt);
    localObject = ((l)localObject).xWt;
    if (localObject != null)
    {
      ((FinderLiveVisitorPluginLayout)localObject).checkMiniWindow();
      ((FinderLiveVisitorPluginLayout)localObject).unMount();
      if (((FinderLiveVisitorPluginLayout)localObject).isManualClosed())
      {
        localObject = com.tencent.mm.live.core.core.c.a.kqk;
        a.a.clear();
      }
      AppMethodBeat.o(269422);
      return;
    }
    AppMethodBeat.o(269422);
  }
  
  public final void onCreate(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(269426);
    p.k(paraml, "var1");
    Log.i("Finder.LiveViewCallback", "[LiveLifecycle]onCreate " + this + ", lifecycleOwner:" + paraml);
    this.xWe.alive();
    this.xWf = true;
    AppMethodBeat.o(269426);
  }
  
  public final void onDestroy(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(269433);
    p.k(paraml, "var1");
    Log.i("Finder.LiveViewCallback", "[LiveLifecycle]onDestroy " + this + ", lifecycleOwner:" + paraml);
    this.xWe.dead();
    xWh = false;
    AppMethodBeat.o(269433);
  }
  
  public final void onPause(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(269431);
    p.k(paraml, "var1");
    Log.i("Finder.LiveViewCallback", "[LiveLifecycle]onPause " + this + ", lifecycleOwner:" + paraml);
    paraml = this.xUG.xWt;
    if (paraml != null) {
      paraml.pause();
    }
    this.xWf = false;
    AppMethodBeat.o(269431);
  }
  
  public final void onResume(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(269430);
    p.k(paraml, "var1");
    Log.i("Finder.LiveViewCallback", "[LiveLifecycle]onResume " + this + ", lifecycleOwner:" + paraml);
    paraml = this.xUG.xWt;
    if (paraml != null) {
      paraml.resume();
    }
    paraml = ah.yhC;
    paraml = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)ah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
    if (paraml != null) {
      paraml.zfn = true;
    }
    paraml = ah.yhC;
    paraml = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)ah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
    if (paraml != null)
    {
      paraml.zfB = false;
      AppMethodBeat.o(269430);
      return;
    }
    AppMethodBeat.o(269430);
  }
  
  public final void onStart(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(269428);
    p.k(paraml, "var1");
    Log.i("Finder.LiveViewCallback", "[LiveLifecycle]onStart " + this + ", lifecycleOwner:" + paraml);
    paraml = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
    paraml = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
    if (paraml != null)
    {
      paraml = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paraml.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if (paraml != null) {
        paraml.zfn = true;
      }
    }
    paraml = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
    paraml = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
    if (paraml != null)
    {
      paraml = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paraml.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if (paraml != null) {
        paraml.zfB = false;
      }
    }
    paraml = ah.yhC;
    paraml = ah.dzA();
    if (paraml != null)
    {
      com.tencent.mm.live.core.core.model.h localh = paraml.knA;
      if ((localh == null) || (localh.isFloatMode() != true)) {}
    }
    for (boolean bool = true;; bool = false)
    {
      Log.i("Finder.LiveViewCallback", "startLiveVideo,float mode:".concat(String.valueOf(bool)));
      if ((bool) && (paraml != null)) {
        paraml.aJz();
      }
      paraml = this.xUG.xWt;
      if (paraml == null) {
        break;
      }
      paraml.start();
      AppMethodBeat.o(269428);
      return;
    }
    AppMethodBeat.o(269428);
  }
  
  public final void onStop(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(269432);
    p.k(paraml, "var1");
    Log.i("Finder.LiveViewCallback", "[LiveLifecycle]onStop " + this + ", lifecycleOwner:" + paraml);
    paraml = this.xUG.xWt;
    if (paraml != null)
    {
      paraml.stop();
      AppMethodBeat.o(269432);
      return;
    }
    AppMethodBeat.o(269432);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/FinderLiveViewCallback$Companion;", "", "()V", "TAG", "", "inNewGuideStatus", "", "getInNewGuideStatus", "()Z", "setInNewGuideStatus", "(Z)V", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$feedChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class b
    extends IListener<hu>
  {
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(FinderLiveViewCallback.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(275812);
        int j = FinderLiveViewCallback.c(this.xWk.xWj).pos;
        Object localObject1 = ah.yhC;
        localObject1 = ah.dwh();
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject1).zeA;
          if (localObject1 == null) {}
        }
        for (int i = ((ArrayList)localObject1).size();; i = 0)
        {
          Log.i("Finder.LiveViewCallback", "TYPE_LIVE_RESTART curPos:" + j + ",size:" + i + '!');
          if (j >= 0) {
            break;
          }
          AppMethodBeat.o(275812);
          return;
        }
        if (i > j)
        {
          localObject1 = this.xWk.xWj.xVZ;
          if (localObject1 != null) {
            FinderLiveLayoutManager.a((FinderLiveLayoutManager)localObject1, false, true, 1);
          }
          localObject1 = ah.yhC;
          localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)ah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject1).liveInfo;
            if (localObject1 != null)
            {
              long l = ((bac)localObject1).liveId;
              localObject1 = ar.AIS;
              Object localObject2 = new StringBuilder();
              Object localObject3 = ar.AIS;
              localObject2 = ar.efV() + l;
              localObject3 = ap.AIh;
              ar.a((ar)localObject1, (String)localObject2, ap.efu().name, null, false, false, false, 60);
              AppMethodBeat.o(275812);
              return;
            }
          }
        }
        AppMethodBeat.o(275812);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "pos", "", "child", "Landroid/view/View;", "forceSelect", "", "invoke", "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$initView$1$1"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.q<Integer, View, Boolean, x>
  {
    c(FinderLiveLayoutManager paramFinderLiveLayoutManager, FinderLiveViewCallback paramFinderLiveViewCallback)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$initView$1$2"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    d(FinderLiveViewCallback paramFinderLiveViewCallback)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$initView$2$1", "Lcom/tencent/mm/plugin/finder/event/recyclerview/FinderRecyclerView$OnPageChangeCallback;", "onPageScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "plugin-finder_release"})
  public static final class e
    implements FinderRecyclerView.b
  {
    e(FinderLiveViewCallback paramFinderLiveViewCallback, com.tencent.mm.plugin.finder.live.viewmodel.data.g paramg) {}
    
    public final void a(RecyclerView paramRecyclerView, int paramInt1, float paramFloat, int paramInt2)
    {
      AppMethodBeat.i(286913);
      p.k(paramRecyclerView, "recyclerView");
      AppMethodBeat.o(286913);
    }
    
    public final void h(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(286914);
      p.k(paramRecyclerView, "recyclerView");
      Log.i("Finder.LiveViewCallback", "selectItemView onPageSelected position:".concat(String.valueOf(paramInt)));
      paramRecyclerView = j.xVS;
      if (j.dwI()) {
        FinderLiveViewCallback.a(this.xWj, paramInt, true, false);
      }
      AppMethodBeat.o(286914);
    }
    
    public final void i(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(286915);
      p.k(paramRecyclerView, "recyclerView");
      AppMethodBeat.o(286915);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(FinderLiveViewCallback paramFinderLiveViewCallback, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(282205);
      FinderLiveRecyclerView localFinderLiveRecyclerView = this.xWj.xVY;
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(this.xAW, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localFinderLiveRecyclerView, locala.aFh(), "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$onLoadMoreResult$2", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      localFinderLiveRecyclerView.smoothScrollToPosition(((Integer)locala.sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localFinderLiveRecyclerView, "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$onLoadMoreResult$2", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      AppMethodBeat.o(282205);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$refreshLayoutAction$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder_release"})
  public static final class h
    extends RefreshLoadMoreLayout.a
  {
    h(boolean paramBoolean1, boolean paramBoolean2) {}
    
    public final void Ie(int paramInt)
    {
      AppMethodBeat.i(267114);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$refreshLayoutAction$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aFi());
      super.Ie(paramInt);
      Log.i("Finder.LiveViewCallback", "onRefreshBegin");
      this.xWj.xWg.azr(0);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$refreshLayoutAction$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(267114);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(267113);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$refreshLayoutAction$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      p.k(paramc, "reason");
      Log.i("Finder.LiveViewCallback", "onLoadMoreEnd");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$refreshLayoutAction$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(267113);
    }
    
    public final void cKQ()
    {
      Object localObject3 = null;
      AppMethodBeat.i(267112);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$refreshLayoutAction$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      Object localObject1 = this.xWj.xWg.azn(b.f.finder_live_load_more_root);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((View)localObject1).findViewById(b.f.loading_progress);
        localObject2 = localObject1;
        if (!(localObject1 instanceof MMProcessBar)) {
          localObject2 = null;
        }
        localObject2 = (MMProcessBar)localObject2;
        View localView = this.xWj.xWg.azn(b.f.finder_live_load_more_root);
        localObject1 = localObject3;
        if (localView != null) {
          localObject1 = localView.findViewById(b.f.load_finish);
        }
        if (!this.xWo) {
          break label204;
        }
        localObject3 = this.xWj.xUN;
        if ((localObject3 != null) && (((c.a)localObject3).czZ() == true))
        {
          if (localObject2 != null)
          {
            int i = b.i.finder_live_icon_location_loading;
            localObject3 = MMApplicationContext.getContext();
            p.j(localObject3, "MMApplicationContext.getContext()");
            ((MMProcessBar)localObject2).mO(i, ((Context)localObject3).getResources().getColor(b.c.White));
          }
          if (localObject2 != null) {
            ((MMProcessBar)localObject2).setVisibility(0);
          }
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(8);
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$refreshLayoutAction$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
        AppMethodBeat.o(267112);
        return;
        localObject1 = null;
        break;
        label204:
        if (this.xWp)
        {
          if (localObject2 != null) {
            ((MMProcessBar)localObject2).setVisibility(8);
          }
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(0);
          }
          this.xWj.xWg.azs(0);
        }
      }
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(267115);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$refreshLayoutAction$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      p.k(paramc, "reason");
      super.onRefreshEnd(paramc);
      Log.i("Finder.LiveViewCallback", "onRefreshEnd");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$refreshLayoutAction$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(267115);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$setNewGuide$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "dragged", "", "dyAmount", "", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "onScrolled", "dx", "dy", "plugin-finder_release"})
  public static final class i
    extends RecyclerView.l
  {
    private boolean xWq;
    private int xWr;
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(267945);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$setNewGuide$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 1)
      {
        FinderLiveViewCallback.a(this.xWj).a(paramRecyclerView);
        this.xWq = true;
      }
      while ((!this.xWq) || (paramInt != 0))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$setNewGuide$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(267945);
        return;
      }
      paramRecyclerView.b((RecyclerView.l)this);
      if (this.xWr <= 0) {}
      for (boolean bool = true;; bool = false)
      {
        FinderLiveViewCallback.oD(bool);
        break;
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(267946);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt1);
      localb.sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$setNewGuide$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      this.xWr += paramInt2;
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$setNewGuide$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(267946);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$setNewGuide$2", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-finder_release"})
  public static final class j
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(277441);
      this.xWj.xVY.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      d.a(800L, (kotlin.g.a.a)new a(this));
      AppMethodBeat.o(277441);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(FinderLiveViewCallback.j paramj)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.FinderLiveViewCallback
 * JD-Core Version:    0.7.0.1
 */