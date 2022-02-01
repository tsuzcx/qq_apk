package com.tencent.mm.plugin.finder.live;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.p;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.r;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.o;
import com.tencent.d.a.a.a.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ja;
import com.tencent.mm.autogen.a.ja.a;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.plugin.finder.event.recyclerview.FinderRecyclerView.b;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.report.q.y;
import com.tencent.mm.plugin.finder.live.view.FinderLiveLayoutManager;
import com.tencent.mm.plugin.finder.live.view.FinderLiveLayoutManager.a;
import com.tencent.mm.plugin.finder.live.view.FinderLiveRecyclerView;
import com.tencent.mm.plugin.finder.live.view.FinderLiveVisitorPluginLayout;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.utils.bb.a;
import com.tencent.mm.plugin.finder.utils.bb.c;
import com.tencent.mm.plugin.finder.utils.bd;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.bg;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/FinderLiveViewCallback;", "Lcom/tencent/mm/plugin/finder/live/FinderLiveContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "rfLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "liveContainer", "Landroid/view/View;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "fragment", "Landroidx/fragment/app/Fragment;", "presenter", "Lcom/tencent/mm/plugin/finder/live/FinderLiveContract$Presenter;", "isFromFloat", "", "autoScrollToNext", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;Landroid/view/View;Lcom/tencent/mm/ui/MMActivity;Landroidx/fragment/app/Fragment;Lcom/tencent/mm/plugin/finder/live/FinderLiveContract$Presenter;ZZ)V", "LIVE_HISTORY_GUIDE_HEIGHT", "", "LIVE_LOAD_MORE_GUIDE_HEIGHT", "getAutoScrollToNext", "()Z", "confettiBitmapManager", "Lcom/tencent/mm/plugin/finder/live/widget/manager/ConfettiBitmapManager;", "getConfettiBitmapManager", "()Lcom/tencent/mm/plugin/finder/live/widget/manager/ConfettiBitmapManager;", "confettiBitmapManager$delegate", "Lkotlin/Lazy;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getFragment", "()Landroidx/fragment/app/Fragment;", "hasNewGuideScrollReport", "hasShowNewGuide", "isDragged", "isShowFirst", "isStartScroll", "lastExecuteHistoryReportLiveId", "", "lastFirstVisible", "lastLastVisible", "lastPlayPos", "lifeCycle", "Landroidx/lifecycle/Lifecycle;", "getLiveContainer", "()Landroid/view/View;", "liveLayoutManager", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveLayoutManager;", "getLiveLayoutManager", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLiveLayoutManager;", "setLiveLayoutManager", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveLayoutManager;)V", "multiTaskManager", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskManager;", "recyclerView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLiveRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveRecyclerView;)V", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getRfLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "scrollLock", "selectedLiveId", "verticalPageSnapHelper", "Lcom/tencent/mm/plugin/finder/ui/FinderFullPagerSnapHelper;", "getVerticalPageSnapHelper", "()Lcom/tencent/mm/plugin/finder/ui/FinderFullPagerSnapHelper;", "verticalPageSnapHelper$delegate", "viewManager", "Lcom/tencent/mm/plugin/finder/live/FinderLiveViewManager;", "attachSnapHelperToRV", "", "detachSnapHelperToRV", "executeInsertHistories", "getActivity", "getIFinderLiveCommonAdapter", "Lcom/tencent/mm/plugin/finder/live/model/service/IFinderLiveCommonAdapter;", "getPresenter", "getRLLayout", "initMultiTaskData", "initView", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveDataModel;", "initPos", "clickLiveId", "isFinish", "isHistoriesLivingCanShow", "", "lives", "", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isSupportPrePlay", "keyboardChange", "show", "height", "notifyItemInsertOrder", "dataSize", "notifyPos", "upIncrementSize", "downIncrementSize", "notifyListTailReplace", "lastItemPos", "incrementSize", "notifyLiveSwitch", "position", "notifySelectItem", "itemData", "pos", "notifyViewHideFinderNewGuide", "viewPos", "notifyViewShowFinderNewGuide", "isHistoryGuide", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "var1", "Landroidx/lifecycle/LifecycleOwner;", "onDestroy", "onInit", "onLoadMoreResult", "oriDataSize", "onNewIntent", "intent", "onOrderResult", "onPause", "onPreloadResult", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onStart", "onStop", "onUninit", "refreshLayoutAction", "canLoadMore", "canFlingUp", "refreshLoadMoreAbility", "reportBlurBgElevation", "reportHistoryLivingEvent", "live", "isHistoryLive", "reportScrollEvent", "isLoadMore", "isExposure", "restartLive", "selectItemView", "fromPageSelected", "forceUpdate", "setNewGuide", "itemCount", "isRealHistory", "setScrollGuideStatusDone", "smoothScrollToPosition", "totalScrollTime", "startLiveVideo", "startPrePlay", "stopPrePlay", "stopTheWorld", "updateLayoutManager", "pluginLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout;", "Companion", "LiveScroller", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveViewCallback
  implements com.tencent.mm.plugin.finder.life.b, c.b
{
  public static final FinderLiveViewCallback.a BwC;
  private static int BwZ;
  private int AmK;
  private final boolean BvI;
  final c.a BvQ;
  final RefreshLoadMoreLayout BwD;
  final View BwE;
  private final boolean BwF;
  private androidx.lifecycle.j BwG;
  private final kotlin.j BwH;
  FinderLiveRecyclerView BwI;
  FinderLiveLayoutManager BwJ;
  public final i BwK;
  private final kotlin.j BwL;
  private final int BwM;
  private final int BwN;
  private boolean BwO;
  private boolean BwP;
  private com.tencent.mm.plugin.finder.live.view.e BwQ;
  private boolean BwR;
  private boolean BwS;
  private int BwT;
  private int BwU;
  private boolean BwV;
  private long BwW;
  private boolean BwX;
  private long BwY;
  private final MMActivity activity;
  private kotlinx.coroutines.aq coroutineScope;
  private final Fragment fragment;
  private final bui reportObj;
  
  static
  {
    AppMethodBeat.i(351097);
    BwC = new FinderLiveViewCallback.a((byte)0);
    AppMethodBeat.o(351097);
  }
  
  public FinderLiveViewCallback(RefreshLoadMoreLayout paramRefreshLoadMoreLayout, View paramView, MMActivity paramMMActivity, Fragment paramFragment, c.a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(350796);
    this.BwD = paramRefreshLoadMoreLayout;
    this.BwE = paramView;
    this.activity = paramMMActivity;
    this.fragment = paramFragment;
    this.BvQ = parama;
    this.BvI = paramBoolean1;
    this.BwF = paramBoolean2;
    this.coroutineScope = kotlinx.coroutines.ar.kBZ();
    paramRefreshLoadMoreLayout = this.fragment;
    if (paramRefreshLoadMoreLayout == null) {}
    for (paramRefreshLoadMoreLayout = null;; paramRefreshLoadMoreLayout = paramRefreshLoadMoreLayout.getLifecycle())
    {
      this.BwG = paramRefreshLoadMoreLayout;
      this.BwH = kotlin.k.cm((kotlin.g.a.a)p.Bxp);
      this.BwI = ((FinderLiveRecyclerView)this.BwD.getRecyclerView());
      paramRefreshLoadMoreLayout = com.tencent.mm.ui.component.k.aeZF;
      this.reportObj = ((bn)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.activity).cq(bn.class)).fou();
      this.BwK = new i(this.reportObj);
      this.BwL = kotlin.k.cm((kotlin.g.a.a)new c(this));
      int i = this.activity.getResources().getDimensionPixelSize(p.c.Edge_17A);
      int j = this.activity.getResources().getDimensionPixelSize(p.c.Edge_2A);
      this.BwM = (bf.getStatusBarHeight((Context)this.activity) + (j + i));
      i = this.activity.getResources().getDimensionPixelSize(p.c.Edge_17A);
      this.BwN = (bf.bk((Context)this.activity) + i);
      this.BwR = true;
      this.AmK = -1;
      this.BwT = -1;
      this.BwU = -1;
      this.BwY = -1L;
      AppMethodBeat.o(350796);
      return;
    }
  }
  
  private static final void a(FinderLiveViewCallback paramFinderLiveViewCallback)
  {
    AppMethodBeat.i(350858);
    s.u(paramFinderLiveViewCallback, "this$0");
    RecyclerView.a locala = paramFinderLiveViewCallback.BwI.getAdapter();
    if (locala == null) {}
    for (int i = 0;; i = locala.getItemCount())
    {
      if (i > 1) {
        paramFinderLiveViewCallback.hz(1, 600);
      }
      AppMethodBeat.o(350858);
      return;
    }
  }
  
  private static final void a(FinderLiveViewCallback paramFinderLiveViewCallback, long paramLong, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(350850);
    s.u(paramFinderLiveViewCallback, "this$0");
    s.u(paramString, "$liveIdStr");
    ja localja = new ja();
    Object localObject = paramFinderLiveViewCallback.BvQ;
    if (localObject == null)
    {
      localja.hKF.source = i;
      localObject = localja.hKF;
      if (i != 4) {
        break label211;
      }
      paramFinderLiveViewCallback = paramFinderLiveViewCallback.BvQ;
      if (paramFinderLiveViewCallback == null) {
        break label211;
      }
      paramFinderLiveViewCallback = paramFinderLiveViewCallback.egD();
      if (paramFinderLiveViewCallback == null) {
        break label211;
      }
      paramFinderLiveViewCallback = paramFinderLiveViewCallback.CFl;
      if (paramFinderLiveViewCallback == null) {
        break label211;
      }
      paramFinderLiveViewCallback = (String)paramFinderLiveViewCallback.get(Long.valueOf(paramLong));
      if (paramFinderLiveViewCallback == null) {
        break label211;
      }
    }
    for (;;)
    {
      ((ja.a)localObject).liveId = paramFinderLiveViewCallback;
      localja.publish();
      Log.i("Finder.FinderLiveViewCallback", "notifyLiveSwitch data.liveId:" + localja.hKF.liveId + ", liveId:" + paramString + ", source:" + localja.hKF.source);
      AppMethodBeat.o(350850);
      return;
      localObject = ((c.a)localObject).egD();
      if (localObject == null) {
        break;
      }
      i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject).mRN;
      break;
      label211:
      paramFinderLiveViewCallback = paramString;
    }
  }
  
  private final void aB(int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(350837);
    Log.i("Finder.FinderLiveViewCallback", "#setNewGuide itemCount=" + paramInt + " isRealHistory=" + paramBoolean);
    Object localObject;
    if (paramBoolean)
    {
      localObject = com.tencent.d.a.a.a.a.a.ahiX;
      if (((Number)com.tencent.d.a.a.a.a.a.jSi().bmg()).intValue() == 0)
      {
        Log.i("Finder.FinderLiveViewCallback", "#setNewGuide FINDER_LIVE_REAL_HISTORY_GUIDE_ENABLE false, return");
        AppMethodBeat.o(350837);
      }
    }
    else if (!paramBoolean)
    {
      localObject = com.tencent.d.a.a.a.a.a.ahiX;
      if (((Number)com.tencent.d.a.a.a.a.a.jSh().bmg()).intValue() == 0)
      {
        Log.i("Finder.FinderLiveViewCallback", "#setNewGuide FINDER_LIVE_GUIDE_ENABLE false, return");
        AppMethodBeat.o(350837);
        return;
      }
    }
    if (paramBoolean)
    {
      localObject = aw.Gjk;
      if (!aw.fgs())
      {
        Log.i("Finder.FinderLiveViewCallback", "#setNewGuide is show history guide but more guide not showed, return");
        AppMethodBeat.o(350837);
        return;
      }
    }
    if (paramBoolean)
    {
      localObject = aw.Gjk;
      if (aw.fgt())
      {
        Log.i("Finder.FinderLiveViewCallback", "#setNewGuide you was showed, return");
        AppMethodBeat.o(350837);
      }
    }
    else
    {
      localObject = aw.Gjk;
      if (aw.fgs())
      {
        Log.i("Finder.FinderLiveViewCallback", "#setNewGuide you was showed, return");
        AppMethodBeat.o(350837);
        return;
      }
    }
    if (paramBoolean) {
      paramInt = 1;
    }
    while (paramInt == 0)
    {
      Log.i("Finder.FinderLiveViewCallback", "#setNewGuide isCanBeShow is false, return");
      AppMethodBeat.o(350837);
      return;
      if (paramInt > 1) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
    }
    if (this.BwO)
    {
      Log.i("Finder.FinderLiveViewCallback", "#setNewGuide hasShowNewGuide is true, return");
      AppMethodBeat.o(350837);
      return;
    }
    this.BwO = true;
    Log.i("Finder.FinderLiveViewCallback", "#setNewGuide finally come in!!!");
    this.BwI.a((RecyclerView.l)new m(this, paramBoolean));
    this.BwI.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new n(this, paramBoolean));
    AppMethodBeat.o(350837);
  }
  
  private static final void b(FinderLiveViewCallback paramFinderLiveViewCallback)
  {
    AppMethodBeat.i(350867);
    s.u(paramFinderLiveViewCallback, "this$0");
    int j = paramFinderLiveViewCallback.BwK.pos;
    Object localObject = aj.CGT;
    localObject = aj.egD();
    int i;
    if (localObject == null)
    {
      i = 0;
      Log.i("Finder.FinderLiveViewCallback", "restartLive curPos:" + j + ",size:" + i + '!');
      if (j < 0) {
        break label216;
      }
      if (j >= i) {
        break label211;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        paramFinderLiveViewCallback = paramFinderLiveViewCallback.BwJ;
        if (paramFinderLiveViewCallback != null) {
          FinderLiveLayoutManager.a(paramFinderLiveViewCallback, false, true, 1);
        }
        paramFinderLiveViewCallback = aj.CGT;
        paramFinderLiveViewCallback = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
        if (paramFinderLiveViewCallback != null)
        {
          paramFinderLiveViewCallback = paramFinderLiveViewCallback.liveInfo;
          if (paramFinderLiveViewCallback != null)
          {
            long l = paramFinderLiveViewCallback.liveId;
            paramFinderLiveViewCallback = bd.Gli;
            localObject = s.X(bd.fhS(), Long.valueOf(l));
            bb.a locala = com.tencent.mm.plugin.finder.utils.bb.GjM;
            bd.a(paramFinderLiveViewCallback, (String)localObject, com.tencent.mm.plugin.finder.utils.bb.fhr().name, null, false, false, false, 60);
          }
        }
      }
      AppMethodBeat.o(350867);
      return;
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject).Ebx;
      if (localObject == null)
      {
        i = 0;
        break;
      }
      i = ((ArrayList)localObject).size();
      break;
      label211:
      i = 0;
      continue;
      label216:
      i = 0;
    }
  }
  
  private static final void b(FinderLiveViewCallback paramFinderLiveViewCallback, int paramInt)
  {
    AppMethodBeat.i(350873);
    s.u(paramFinderLiveViewCallback, "this$0");
    paramFinderLiveViewCallback = paramFinderLiveViewCallback.BwI;
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(paramFinderLiveViewCallback, locala.aYi(), "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback", "onLoadMoreResult$lambda-16", "(Lcom/tencent/mm/plugin/finder/live/FinderLiveViewCallback;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    paramFinderLiveViewCallback.smoothScrollToPosition(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramFinderLiveViewCallback, "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback", "onLoadMoreResult$lambda-16", "(Lcom/tencent/mm/plugin/finder/live/FinderLiveViewCallback;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    AppMethodBeat.o(350873);
  }
  
  private final boolean efT()
  {
    AppMethodBeat.i(350842);
    boolean bool1 = this.activity.isFinishing();
    boolean bool2 = this.activity.isDestroyed();
    AppMethodBeat.o(350842);
    return bool1 | bool2;
  }
  
  private final com.tencent.mm.plugin.finder.ui.e eha()
  {
    AppMethodBeat.i(350808);
    com.tencent.mm.plugin.finder.ui.e locale = (com.tencent.mm.plugin.finder.ui.e)this.BwH.getValue();
    AppMethodBeat.o(350808);
    return locale;
  }
  
  private final void ehb()
  {
    AppMethodBeat.i(350829);
    Object localObject = this.BvQ;
    RefreshLoadMoreLayout localRefreshLoadMoreLayout;
    if (localObject == null)
    {
      localObject = null;
      Log.i("Finder.FinderLiveViewCallback", s.X("refreshLoadMoreAbility:", localObject));
      localRefreshLoadMoreLayout = this.BwD;
      if (s.p(localObject, Boolean.FALSE)) {
        break label72;
      }
    }
    label72:
    for (boolean bool = true;; bool = false)
    {
      localRefreshLoadMoreLayout.setEnableNestedScroll(bool);
      AppMethodBeat.o(350829);
      return;
      localObject = Boolean.valueOf(((c.a)localObject).egA());
      break;
    }
  }
  
  private final void hz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(350820);
    b localb = new b(paramInt2);
    localb.cag = paramInt1;
    RecyclerView.LayoutManager localLayoutManager = this.BwI.getLayoutManager();
    if (localLayoutManager != null) {
      localLayoutManager.startSmoothScroll((RecyclerView.r)localb);
    }
    AppMethodBeat.o(350820);
  }
  
  public static void qj(boolean paramBoolean)
  {
    AppMethodBeat.i(350813);
    if (BwZ == 0)
    {
      AppMethodBeat.o(350813);
      return;
    }
    Log.i("Finder.FinderLiveViewCallback", s.X("#cancelNewGuide isRealHistory=", Boolean.valueOf(paramBoolean)));
    BwZ = 0;
    if (paramBoolean)
    {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adew, Boolean.TRUE);
      AppMethodBeat.o(350813);
      return;
    }
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adev, Boolean.TRUE);
    AppMethodBeat.o(350813);
  }
  
  public final void X(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(351127);
    Log.i("Finder.FinderLiveViewCallback", "reportScrollEvent isLoadMore=" + paramBoolean1 + " isExposure=" + paramBoolean2);
    if ((!paramBoolean2) && (this.BwP))
    {
      AppMethodBeat.o(351127);
      return;
    }
    if (!paramBoolean2) {
      this.BwP = true;
    }
    com.tencent.mm.plugin.finder.live.report.k.Doi.ac(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(351127);
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.viewmodel.data.g paramg, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(351168);
    Object localObject;
    int i;
    label20:
    int j;
    if (paramg == null)
    {
      localObject = null;
      if (paramg != null) {
        break label284;
      }
      i = 0;
      Log.i("Finder.FinderLiveViewCallback", "onPreloadResult increment size:" + paramInt2 + ", dataSize:" + i + ", cur position:" + localObject + ",lastItemPos:" + paramInt1);
      ehb();
      boolean bool1 = efT();
      int k = paramInt1 + 1;
      paramg = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      boolean bool2 = com.tencent.mm.plugin.finder.live.utils.a.bj((Context)this.activity);
      if (!bool1)
      {
        if (k < 0) {
          break label314;
        }
        if (k >= i) {
          break label308;
        }
        j = 1;
        label126:
        if ((j != 0) && (bool2))
        {
          paramg = this.BwI.getAdapter();
          if (paramg != null) {
            paramg.by(k, i);
          }
        }
      }
      localObject = new StringBuilder("notifyListTailReplace isFinish:").append(bool1).append(",lastItemPos:").append(paramInt1).append(",nextPosition:").append(k).append(",incrementSize:").append(paramInt2).append(", size:").append(i).append(", isPortrait:").append(bool2).append(", scrollState:");
      paramg = this.BwJ;
      if (paramg != null) {
        break label320;
      }
    }
    label284:
    label308:
    label314:
    label320:
    for (paramg = null;; paramg = Integer.valueOf(paramg.dyP))
    {
      Log.i("Finder.FinderLiveViewCallback", paramg);
      aB(i, false);
      AppMethodBeat.o(351168);
      return;
      localObject = Integer.valueOf(paramg.getCurPos());
      break;
      paramg = paramg.Ebx;
      if (paramg == null)
      {
        i = 0;
        break label20;
      }
      i = paramg.size();
      break label20;
      j = 0;
      break label126;
      j = 0;
      break label126;
    }
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.viewmodel.data.g paramg, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(351185);
    Object localObject;
    int i;
    label20:
    int j;
    if (paramg == null)
    {
      localObject = null;
      if (paramg != null) {
        break label351;
      }
      i = 0;
      Log.i("Finder.FinderLiveViewCallback", "onOrderResult notifyPos:" + paramInt1 + ", upIncrementSize size:" + paramInt2 + ", downIncrementSize size:" + paramInt3 + ", dataSize:" + i + ", cur position:" + localObject);
      ehb();
      boolean bool1 = efT();
      paramg = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      boolean bool2 = com.tencent.mm.plugin.finder.live.utils.a.bj((Context)this.activity);
      if (!bool1)
      {
        j = paramInt1 + 1;
        if (j < 0) {
          break label381;
        }
        if (j >= i) {
          break label375;
        }
        j = 1;
        label137:
        if ((j != 0) && (bool2) && (paramInt3 > 0))
        {
          paramg = this.BwI.getAdapter();
          if (paramg != null) {
            paramg.bA(paramInt1 + 1, paramInt3);
          }
        }
      }
      if (!bool1)
      {
        if (paramInt1 < 0) {
          break label393;
        }
        if (paramInt1 >= i) {
          break label387;
        }
        j = 1;
        label191:
        if ((j != 0) && (bool2) && (paramInt2 > 0))
        {
          paramg = this.BwI.getAdapter();
          if (paramg != null) {
            paramg.bA(paramInt1, paramInt2);
          }
        }
      }
      localObject = new StringBuilder("notifyItemRangeChange isFinish:").append(bool1).append(", notifyPos:").append(paramInt1).append(", upIncrementSize:").append(paramInt2).append(", downIncrementSize:").append(paramInt3).append(", size:").append(i).append(", isPortrait:").append(bool2).append(", scrollState:");
      paramg = this.BwJ;
      if (paramg != null) {
        break label399;
      }
    }
    label387:
    label393:
    label399:
    for (paramg = null;; paramg = Integer.valueOf(paramg.dyP))
    {
      Log.i("Finder.FinderLiveViewCallback", paramg);
      aB(i, false);
      AppMethodBeat.o(351185);
      return;
      localObject = Integer.valueOf(paramg.getCurPos());
      break;
      label351:
      paramg = paramg.Ebx;
      if (paramg == null)
      {
        i = 0;
        break label20;
      }
      i = paramg.size();
      break label20;
      label375:
      j = 0;
      break label137;
      label381:
      j = 0;
      break label137;
      j = 0;
      break label191;
      j = 0;
      break label191;
    }
  }
  
  public final void a(final com.tencent.mm.plugin.finder.live.viewmodel.data.g paramg, int paramInt, long paramLong)
  {
    AppMethodBeat.i(351151);
    s.u(paramg, "liveData");
    Object localObject1 = this.BvQ;
    label41:
    int i;
    label174:
    label216:
    final boolean bool1;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = this.BvQ;
      if (localObject2 != null) {
        break label721;
      }
      localObject2 = null;
      localObject3 = new StringBuilder("load more setting,canLoadMore:").append(localObject1).append(",canFlingUp:").append(localObject2).append(" enablePreloadRvFeed:");
      g.a locala = g.Bwn;
      Log.i("Finder.FinderLiveViewCallback", g.egZ());
      if ((s.p(localObject1, Boolean.TRUE)) || (s.p(localObject2, Boolean.TRUE))) {
        break label736;
      }
      this.BwD.setEnableLoadMore(false);
      localObject1 = d.BvP;
      long l = d.egJ();
      localObject1 = paramg.exW();
      if (localObject1 == null) {
        break label797;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.f)localObject1).Ebr;
      if ((localObject1 == null) || (l != ((LiveConfig)localObject1).mIH)) {
        break label797;
      }
      i = 1;
      if (i == 0) {
        ehb();
      }
      localObject3 = this.activity.getIntent().getByteArrayExtra("KEY_MULTI_TASK_INFO");
      localObject1 = aj.CGT;
      localObject1 = aj.elo();
      if (localObject1 != null) {
        break label803;
      }
      localObject1 = null;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new com.tencent.mm.plugin.finder.live.view.e((Activity)this.activity, (byte[])localObject3);
      }
      this.BwQ = ((com.tencent.mm.plugin.finder.live.view.e)localObject2);
      localObject1 = aj.CGT;
      localObject2 = this.BwQ;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("multiTaskManager");
        localObject1 = null;
      }
      aj.a((com.tencent.mm.plugin.finder.live.view.e)localObject1);
      localObject1 = this.BwI.getContext();
      s.s(localObject1, "recyclerView.context");
      this.BwJ = new FinderLiveLayoutManager((Context)localObject1, 1);
      localObject1 = this.BwJ;
      if (localObject1 != null)
      {
        ((FinderLiveLayoutManager)localObject1).DNT = ((kotlin.g.a.q)new e(this, (FinderLiveLayoutManager)localObject1));
        ((FinderLiveLayoutManager)localObject1).DNU = ((kotlin.g.a.a)new f(this));
      }
      localObject1 = this.BwI;
      ((FinderLiveRecyclerView)localObject1).setHasFixedSize(true);
      bool1 = this.activity.getIntent().getBooleanExtra("LAUNCH_WITH_ANIM", false);
      ((FinderLiveRecyclerView)localObject1).setAdapter((RecyclerView.a)new b(this.fragment, paramg, this.BvI, this, this.reportObj, paramLong, bool1));
      ((FinderLiveRecyclerView)localObject1).a((LinearLayoutManager)this.BwJ);
      ((RecyclerView)localObject1).a((RecyclerView.h)new g());
      ((FinderLiveRecyclerView)localObject1).a((RecyclerView.l)new h(this));
      ((FinderLiveRecyclerView)localObject1).setPageChangeListener((FinderRecyclerView.b)new i(this, (FinderLiveRecyclerView)localObject1));
      ehc();
      localObject1 = this.BwG;
      if (localObject1 != null) {
        ((androidx.lifecycle.j)localObject1).addObserver((p)this);
      }
      if (paramInt < 0) {
        break label830;
      }
      if (paramInt >= paramg.Ebx.size()) {
        break label824;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject1 = this.BwI;
        localObject2 = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback", "initView", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveDataModel;IJ)V", "Undefined", "scrollToPosition", "(I)V");
        ((FinderLiveRecyclerView)localObject1).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback", "initView", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveDataModel;IJ)V", "Undefined", "scrollToPosition", "(I)V");
      }
      if (!this.BvI)
      {
        Log.i("Finder.FinderLiveViewCallback", "#executeInsertHistories");
        kotlinx.coroutines.j.a(this.coroutineScope, null, null, (m)new d(this, null), 3);
      }
      localObject1 = com.tencent.d.a.a.a.a.a.ahiX;
      if (((Number)com.tencent.d.a.a.a.a.a.jUH().bmg()).intValue() != 0) {
        break label1062;
      }
      localObject1 = this.BwE.getParent();
      if (localObject1 != null) {
        break label836;
      }
      paramg = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(351151);
      throw paramg;
      localObject1 = Boolean.valueOf(((c.a)localObject1).egB());
      break;
      label721:
      localObject2 = Boolean.valueOf(((c.a)localObject2).egC());
      break label41;
      label736:
      if (localObject1 == null)
      {
        bool1 = false;
        label744:
        if (localObject2 != null) {
          break label787;
        }
      }
      label787:
      for (final boolean bool2 = false;; bool2 = ((Boolean)localObject2).booleanValue())
      {
        this.BwD.setActionCallback((RefreshLoadMoreLayout.b)new l(this, bool1, bool2));
        break;
        bool1 = ((Boolean)localObject1).booleanValue();
        break label744;
      }
      label797:
      i = 0;
      break label174;
      label803:
      localObject1 = new com.tencent.mm.plugin.finder.live.view.e((Activity)this.activity, (com.tencent.mm.plugin.finder.live.view.e)localObject1);
      break label216;
      label824:
      i = 0;
      continue;
      label830:
      i = 0;
    }
    label836:
    Object localObject3 = (FrameLayout)localObject1;
    localObject1 = new com.tencent.mm.plugin.finder.live.sidebar.c(this.BwE);
    Object localObject2 = (ViewGroup)localObject3;
    paramg = (com.tencent.mm.plugin.finder.live.sidebar.c.b)new j((FrameLayout)localObject3, this, (com.tencent.mm.plugin.finder.live.sidebar.c)localObject1, paramg);
    s.u(localObject2, "parent");
    s.u(paramg, "listener");
    ((com.tencent.mm.plugin.finder.live.sidebar.c)localObject1).DGn = new com.tencent.mm.plugin.finder.view.sidebar.a((com.tencent.mm.plugin.finder.view.sidebar.a.a)((com.tencent.mm.plugin.finder.live.sidebar.c)localObject1).DGt, (ViewGroup)localObject2, p.f.CfN);
    localObject2 = ((ViewGroup)localObject2).getContext();
    s.s(localObject2, "parent.context");
    s.u(localObject2, "<set-?>");
    ((com.tencent.mm.plugin.finder.live.sidebar.c)localObject1).context = ((Context)localObject2);
    ((com.tencent.mm.plugin.finder.live.sidebar.c)localObject1).DGp = paramg;
    paramg = com.tencent.mm.ui.component.k.aeZF;
    paramg = this.BwE.getContext();
    s.s(paramg, "liveContainer.context");
    ((com.tencent.mm.plugin.finder.live.sidebar.d)com.tencent.mm.ui.component.k.nq(paramg).q(com.tencent.mm.plugin.finder.live.sidebar.d.class)).DGE = ((com.tencent.mm.plugin.finder.live.sidebar.c)localObject1);
    paramg = com.tencent.mm.ui.component.k.aeZF;
    paramg = this.BwE.getContext();
    s.s(paramg, "liveContainer.context");
    localObject1 = (com.tencent.mm.plugin.finder.live.sidebar.d)com.tencent.mm.ui.component.k.nq(paramg).q(com.tencent.mm.plugin.finder.live.sidebar.d.class);
    paramg = this.BvQ;
    if ((paramg instanceof g)) {}
    for (paramg = (g)paramg;; paramg = null)
    {
      ((com.tencent.mm.plugin.finder.live.sidebar.d)localObject1).DGF = paramg;
      AppMethodBeat.o(351151);
      return;
    }
    label1062:
    Log.i("Finder.FinderLiveViewCallback", "init view live side bar switch is close!");
    AppMethodBeat.o(351151);
  }
  
  public final void b(com.tencent.mm.plugin.finder.live.viewmodel.data.g paramg, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    int i = 0;
    AppMethodBeat.i(351204);
    StringBuilder localStringBuilder = new StringBuilder("onLoadMoreResult increment size:").append(paramInt2).append(", oriDataSize:").append(paramInt1).append(", init position:");
    Object localObject1;
    label91:
    label124:
    boolean bool;
    if (paramg == null)
    {
      localObject1 = null;
      Log.i("Finder.FinderLiveViewCallback", localObject1);
      if (paramInt2 > 0) {
        break label341;
      }
      localObject1 = this.BwD.aFR(p.e.BNl);
      if (localObject1 != null) {
        break label315;
      }
      localObject1 = null;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      localObject1 = this.BwD.aFR(p.e.BNl);
      if (localObject1 != null) {
        break label328;
      }
      localObject1 = localObject2;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      label135:
      if ((paramInt2 > 0) && (paramg != null))
      {
        paramg = paramg.Ebx;
        if (paramg != null)
        {
          int j = paramg.size() - paramInt2;
          if (j < 0) {
            break label373;
          }
          if (j >= paramg.size()) {
            break label368;
          }
          paramInt1 = 1;
          label176:
          if (paramInt1 != 0)
          {
            paramg = this.BwI.getAdapter();
            if (paramg != null) {
              paramg.bA(j, paramInt2);
            }
          }
        }
      }
      paramg = new RefreshLoadMoreLayout.d(-1);
      paramg.agJv = paramInt2;
      if (paramg.agJu) {
        break label378;
      }
      bool = true;
      label223:
      paramg.pzq = bool;
      this.BwD.onPreFinishLoadMoreSmooth(paramg);
      if (paramg.agJu)
      {
        paramg = this.BwJ;
        if (paramg != null) {
          break label384;
        }
        paramInt1 = -1;
        label255:
        paramInt2 = paramInt1 + 1;
        paramg = this.BwI.getAdapter();
        if (paramg != null) {
          break label392;
        }
      }
    }
    label384:
    label392:
    for (paramInt1 = i;; paramInt1 = paramg.getItemCount())
    {
      if (paramInt2 < paramInt1) {
        this.BwI.post(new FinderLiveViewCallback..ExternalSyntheticLambda2(this, paramInt2));
      }
      AppMethodBeat.o(351204);
      return;
      localObject1 = Integer.valueOf(paramg.getCurPos());
      break;
      label315:
      localObject1 = ((View)localObject1).findViewById(p.e.loading_progress);
      break label91;
      label328:
      localObject1 = ((View)localObject1).findViewById(p.e.load_finish);
      break label124;
      label341:
      localObject1 = this.BwD.aFR(p.e.BNl);
      if (localObject1 == null) {
        break label135;
      }
      ((View)localObject1).setVisibility(8);
      break label135;
      label368:
      paramInt1 = 0;
      break label176;
      label373:
      paramInt1 = 0;
      break label176;
      label378:
      bool = false;
      break label223;
      paramInt1 = paramg.Ju();
      break label255;
    }
  }
  
  public final RefreshLoadMoreLayout egG()
  {
    return this.BwD;
  }
  
  public final void egH()
  {
    AppMethodBeat.i(351164);
    this.BwI.post(new FinderLiveViewCallback..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(351164);
  }
  
  public final void ehc()
  {
    AppMethodBeat.i(351193);
    Log.i("Finder.FinderLiveViewCallback", "#attachSnapHelperToRV");
    eha().a((RecyclerView)this.BwI);
    AppMethodBeat.o(351193);
  }
  
  public final void ehd()
  {
    AppMethodBeat.i(351208);
    Log.i("Finder.FinderLiveViewCallback", s.X("[LiveLifecycle]onUninit ", this));
    Object localObject = this.BwK;
    Log.i(((i)localObject).TAG, s.X("release:", ((i)localObject).Bxq));
    ((i)localObject).released = true;
    localObject = ((i)localObject).Bxq;
    if (localObject != null)
    {
      ((FinderLiveVisitorPluginLayout)localObject).checkMiniWindow();
      ((FinderLiveVisitorPluginLayout)localObject).unMount();
      if (((FinderLiveVisitorPluginLayout)localObject).isManualClosed())
      {
        localObject = com.tencent.mm.live.core.core.f.a.mUf;
        com.tencent.mm.live.core.core.f.a.a.clear();
      }
    }
    AppMethodBeat.o(351208);
  }
  
  public final com.tencent.mm.plugin.finder.live.model.service.a getIFinderLiveCommonAdapter()
  {
    AppMethodBeat.i(351261);
    Object localObject = this.BwK.Bxq;
    if (localObject == null)
    {
      AppMethodBeat.o(351261);
      return null;
    }
    localObject = ((FinderLiveVisitorPluginLayout)localObject).getIFinderLiveCommonAdapter();
    AppMethodBeat.o(351261);
    return localObject;
  }
  
  public final void onCreate(androidx.lifecycle.q paramq)
  {
    AppMethodBeat.i(351213);
    s.u(paramq, "var1");
    Log.i("Finder.FinderLiveViewCallback", "[LiveLifecycle]onCreate " + this + ", lifecycleOwner:" + paramq);
    AppMethodBeat.o(351213);
  }
  
  public final void onDestroy(androidx.lifecycle.q paramq)
  {
    AppMethodBeat.i(351256);
    s.u(paramq, "var1");
    Log.i("Finder.FinderLiveViewCallback", "[LiveLifecycle]onDestroy " + this + ", lifecycleOwner:" + paramq);
    this.BwJ = null;
    kotlinx.coroutines.ar.a(this.coroutineScope, null);
    BwZ = 0;
    paramq = com.tencent.mm.ui.component.k.aeZF;
    paramq = this.BwD.getContext();
    s.s(paramq, "rfLayout.context");
    ((com.tencent.mm.plugin.finder.live.sidebar.d)com.tencent.mm.ui.component.k.nq(paramq).q(com.tencent.mm.plugin.finder.live.sidebar.d.class)).rT(false);
    paramq = com.tencent.mm.ui.component.k.aeZF;
    paramq = this.BwD.getContext();
    s.s(paramq, "rfLayout.context");
    if (s.p(((com.tencent.mm.plugin.finder.live.sidebar.d)com.tencent.mm.ui.component.k.nq(paramq).q(com.tencent.mm.plugin.finder.live.sidebar.d.class)).DGF, this.BvQ))
    {
      paramq = com.tencent.mm.ui.component.k.aeZF;
      paramq = this.BwD.getContext();
      s.s(paramq, "rfLayout.context");
      ((com.tencent.mm.plugin.finder.live.sidebar.d)com.tencent.mm.ui.component.k.nq(paramq).q(com.tencent.mm.plugin.finder.live.sidebar.d.class)).DGE = null;
      paramq = com.tencent.mm.ui.component.k.aeZF;
      paramq = this.BwD.getContext();
      s.s(paramq, "rfLayout.context");
      ((com.tencent.mm.plugin.finder.live.sidebar.d)com.tencent.mm.ui.component.k.nq(paramq).q(com.tencent.mm.plugin.finder.live.sidebar.d.class)).DGF = null;
    }
    AppMethodBeat.o(351256);
  }
  
  public final void onPause(androidx.lifecycle.q paramq)
  {
    AppMethodBeat.i(351244);
    s.u(paramq, "var1");
    Log.i("Finder.FinderLiveViewCallback", "[LiveLifecycle]onPause " + this + ", lifecycleOwner:" + paramq);
    paramq = this.BwK.Bxq;
    if (paramq != null) {
      paramq.pause();
    }
    AppMethodBeat.o(351244);
  }
  
  public final void onResume(androidx.lifecycle.q paramq)
  {
    AppMethodBeat.i(351236);
    s.u(paramq, "var1");
    Log.i("Finder.FinderLiveViewCallback", "[LiveLifecycle]onResume " + this + ", lifecycleOwner:" + paramq);
    paramq = this.BwK.Bxq;
    if (paramq != null) {
      paramq.resume();
    }
    paramq = aj.CGT;
    paramq = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
    if (paramq != null) {
      paramq.EcI = true;
    }
    paramq = aj.CGT;
    paramq = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
    if (paramq != null) {
      paramq.Eda = false;
    }
    AppMethodBeat.o(351236);
  }
  
  public final void onStart(androidx.lifecycle.q paramq)
  {
    AppMethodBeat.i(351229);
    s.u(paramq, "var1");
    Log.i("Finder.FinderLiveViewCallback", "[LiveLifecycle]onStart " + this + ", lifecycleOwner:" + paramq);
    paramq = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
    int i;
    if (com.tencent.mm.plugin.finder.live.model.context.a.emY() != null)
    {
      paramq = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
      paramq = com.tencent.mm.plugin.finder.live.model.context.a.emY();
      if (paramq == null) {
        break label246;
      }
      paramq = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if ((paramq == null) || (paramq.isLiveStarted())) {
        break label246;
      }
      i = 1;
      if (i == 0) {}
    }
    else
    {
      paramq = com.tencent.mm.plugin.finder.live.report.j.Dob;
      com.tencent.mm.plugin.finder.live.report.j.Doc.DpA = true;
    }
    paramq = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
    paramq = com.tencent.mm.plugin.finder.live.model.context.a.emY();
    label121:
    Object localObject;
    if (paramq == null)
    {
      paramq = null;
      if (paramq != null) {
        paramq.EcI = true;
      }
      paramq = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
      paramq = com.tencent.mm.plugin.finder.live.model.context.a.emY();
      if (paramq != null) {
        break label265;
      }
      paramq = null;
      label144:
      if (paramq != null) {
        paramq.Eda = false;
      }
      paramq = aj.CGT;
      paramq = aj.elL();
      if (paramq == null) {
        break label279;
      }
      localObject = paramq.mRB;
      if ((localObject == null) || (((com.tencent.mm.live.core.core.model.i)localObject).isFloatMode() != true)) {
        break label279;
      }
    }
    label265:
    label279:
    for (boolean bool = true;; bool = false)
    {
      Log.i("Finder.FinderLiveViewCallback", s.X("startLiveVideo,float mode:", Boolean.valueOf(bool)));
      if (bool)
      {
        localObject = com.tencent.mm.plugin.finder.live.model.ar.CIh;
        com.tencent.mm.plugin.finder.live.model.ar.emj();
        if (paramq != null) {
          paramq.bcg();
        }
      }
      paramq = this.BwK.Bxq;
      if (paramq != null) {
        paramq.start();
      }
      AppMethodBeat.o(351229);
      return;
      label246:
      i = 0;
      break;
      paramq = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      break label121;
      paramq = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      break label144;
    }
  }
  
  public final void onStop(androidx.lifecycle.q paramq)
  {
    AppMethodBeat.i(351250);
    s.u(paramq, "var1");
    Log.i("Finder.FinderLiveViewCallback", "[LiveLifecycle]onStop " + this + ", lifecycleOwner:" + paramq);
    paramq = this.BwK.Bxq;
    if (paramq != null) {
      paramq.stop();
    }
    AppMethodBeat.o(351250);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/FinderLiveViewCallback$LiveScroller;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "totalTime", "", "(Lcom/tencent/mm/plugin/finder/live/FinderLiveViewCallback;I)V", "getTotalTime", "()I", "calculateDtToFit", "viewStart", "viewEnd", "boxStart", "boxEnd", "snapPreference", "calculateTimeForDeceleration", "dx", "calculateTimeForScrolling", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends o
  {
    private final int hHO;
    
    public b()
    {
      super();
      AppMethodBeat.i(350903);
      int i;
      this.hHO = i;
      AppMethodBeat.o(350903);
    }
    
    public final int fO(int paramInt)
    {
      AppMethodBeat.i(350921);
      if (this.hHO > 0)
      {
        paramInt = this.hHO;
        AppMethodBeat.o(350921);
        return paramInt;
      }
      paramInt = super.fO(paramInt);
      AppMethodBeat.o(350921);
      return paramInt;
    }
    
    public final int fP(int paramInt)
    {
      AppMethodBeat.i(350915);
      if (this.hHO > 0)
      {
        paramInt = this.hHO;
        AppMethodBeat.o(350915);
        return paramInt;
      }
      paramInt = super.fP(paramInt);
      AppMethodBeat.o(350915);
      return paramInt;
    }
    
    public final int g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      AppMethodBeat.i(350910);
      paramInt1 = super.g(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
      if (paramInt1 > 0)
      {
        locala = FinderLiveLayoutManager.DNR;
        paramInt2 = FinderLiveLayoutManager.evr();
        AppMethodBeat.o(350910);
        return paramInt1 - paramInt2;
      }
      FinderLiveLayoutManager.a locala = FinderLiveLayoutManager.DNR;
      paramInt2 = FinderLiveLayoutManager.evr();
      AppMethodBeat.o(350910);
      return paramInt1 + paramInt2;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/widget/manager/ConfettiBitmapManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.live.widget.manager.a>
  {
    c(FinderLiveViewCallback paramFinderLiveViewCallback)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.k
    implements m<kotlinx.coroutines.aq, kotlin.d.d<? super ah>, Object>
  {
    Object Uf;
    int label;
    
    d(FinderLiveViewCallback paramFinderLiveViewCallback, kotlin.d.d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(350928);
      paramd = new d(this.Bxa, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(350928);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(350920);
      Object localObject3 = kotlin.d.a.a.aiwj;
      Object localObject1;
      Object localObject2;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(350920);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (kotlinx.coroutines.aq)this.L$0;
        localObject1 = com.tencent.mm.plugin.finder.live.viewmodel.data.l.EbO;
        localObject1 = com.tencent.mm.plugin.finder.live.viewmodel.data.l.eyc();
        if (((List)localObject1).isEmpty())
        {
          Log.i("Finder.FinderLiveViewCallback", "#executeInsertHistories historiesLive is empty");
          paramObject = ah.aiuX;
          AppMethodBeat.o(350920);
          return paramObject;
        }
        localObject2 = (kotlin.d.d)this;
        this.L$0 = paramObject;
        this.Uf = localObject1;
        this.label = 1;
        if (kotlinx.coroutines.bb.e(1000L, (kotlin.d.d)localObject2) == localObject3)
        {
          AppMethodBeat.o(350920);
          return localObject3;
        }
        break;
      case 1: 
        localObject1 = (List)this.Uf;
        localObject2 = (kotlinx.coroutines.aq)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject2;
      }
      for (;;)
      {
        localObject2 = (kotlin.d.f)bg.kCi();
        localObject1 = (m)new a(this.Bxa, (List)localObject1, null);
        kotlin.d.d locald = (kotlin.d.d)this;
        this.L$0 = paramObject;
        this.Uf = null;
        this.label = 2;
        localObject2 = kotlinx.coroutines.l.a((kotlin.d.f)localObject2, (m)localObject1, locald);
        localObject1 = localObject2;
        if (localObject2 == localObject3)
        {
          AppMethodBeat.o(350920);
          return localObject3;
          localObject2 = (kotlinx.coroutines.aq)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          localObject1 = paramObject;
          paramObject = localObject2;
        }
        localObject1 = (List)localObject1;
        if (!kotlinx.coroutines.ar.a(paramObject))
        {
          paramObject = ah.aiuX;
          AppMethodBeat.o(350920);
          return paramObject;
        }
        paramObject = com.tencent.mm.ui.component.k.aeZF;
        paramObject = this.Bxa.BwD.getContext();
        s.s(paramObject, "rfLayout.context");
        if (((com.tencent.mm.plugin.finder.live.sidebar.d)com.tencent.mm.ui.component.k.nq(paramObject).q(com.tencent.mm.plugin.finder.live.sidebar.d.class)).DGD)
        {
          Log.i("Finder.FinderLiveViewCallback", "#executeInsertHistories inSideBarStatus, return");
          paramObject = ah.aiuX;
          AppMethodBeat.o(350920);
          return paramObject;
        }
        paramObject = FinderLiveViewCallback.d(this.Bxa);
        if (paramObject != null)
        {
          paramObject = paramObject.egD();
          if (paramObject != null)
          {
            localObject2 = this.Bxa;
            s.u(localObject1, "histories");
            localObject3 = com.tencent.mm.plugin.finder.live.viewmodel.data.g.w((List)paramObject.Ebx, (List)localObject1);
            paramObject.Ebx.addAll(0, (Collection)localObject3);
            paramObject.Ebw.clear();
            paramObject.Ebw.addAll((Collection)localObject1);
            Log.i(paramObject.TAG, "#appendHistoriesLiveData histories=" + ((List)localObject1).size() + ", after filter size " + ((List)localObject3).size() + ", now liveDataList.size=" + paramObject.Ebx.size());
            int i = ((List)localObject3).size();
            if (i > 0)
            {
              localObject3 = ((FinderLiveViewCallback)localObject2).BwI.getAdapter();
              if (localObject3 != null) {
                ((RecyclerView.a)localObject3).bA(0, i);
              }
              FinderLiveViewCallback.c((FinderLiveViewCallback)localObject2, paramObject.Ebx.size());
              Log.i("Finder.FinderLiveViewCallback", "#executeInsertHistories append " + i + " done");
              FinderLiveViewCallback.gk((List)localObject1);
            }
          }
        }
        paramObject = ah.aiuX;
        AppMethodBeat.o(350920);
        return paramObject;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.d.b.a.k
      implements m<kotlinx.coroutines.aq, kotlin.d.d<? super List<com.tencent.mm.plugin.finder.live.viewmodel.data.f>>, Object>
    {
      int label;
      
      a(FinderLiveViewCallback paramFinderLiveViewCallback, List<com.tencent.mm.plugin.finder.live.viewmodel.data.f> paramList, kotlin.d.d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(350805);
        paramObject = (kotlin.d.d)new a(this.Bxa, this.Bxb, paramd);
        AppMethodBeat.o(350805);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(350801);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(350801);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = this.Bxa;
          Object localObject = this.Bxb;
          kotlin.d.d locald = (kotlin.d.d)this;
          this.label = 1;
          localObject = FinderLiveViewCallback.a(paramObject, (List)localObject, locald);
          paramObject = localObject;
          if (localObject == locala)
          {
            AppMethodBeat.o(350801);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = (Map)paramObject;
        Log.i("Finder.FinderLiveViewCallback", s.X("#executeInsertHistories statusResult=", FinderLiveViewCallback.ak(paramObject)));
        paramObject = FinderLiveViewCallback.a(this.Bxb, paramObject);
        AppMethodBeat.o(350801);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "pos", "", "child", "Landroid/view/View;", "forceSelect", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.q<Integer, View, Boolean, ah>
  {
    e(FinderLiveViewCallback paramFinderLiveViewCallback, FinderLiveLayoutManager paramFinderLiveLayoutManager)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    f(FinderLiveViewCallback paramFinderLiveViewCallback)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$initView$2$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(350871);
      s.u(paramRect, "outRect");
      s.u(paramView, "view");
      s.u(paramRecyclerView, "parent");
      s.u(params, "state");
      paramRect.left = 0;
      paramRect.right = 0;
      paramRect.top = 0;
      paramView = FinderLiveLayoutManager.DNR;
      paramRect.bottom = FinderLiveLayoutManager.evr();
      AppMethodBeat.o(350871);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$initView$2$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    extends RecyclerView.l
  {
    h(FinderLiveViewCallback paramFinderLiveViewCallback) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(350876);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$initView$2$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      Log.i("Finder.FinderLiveViewCallback", s.X("lxltest onScrollStateChanged:", Integer.valueOf(paramInt)));
      if ((FinderLiveViewCallback.i(this.Bxa)) && (paramInt == 0))
      {
        FinderLiveViewCallback.a(this.Bxa, false);
        paramRecyclerView = this.Bxa.BwJ;
        if (paramRecyclerView != null) {
          FinderLiveLayoutManager.a(paramRecyclerView, true, false, 2);
        }
      }
      paramRecyclerView = com.tencent.mm.ui.component.k.aeZF;
      paramRecyclerView = this.Bxa.BwE.getContext();
      s.s(paramRecyclerView, "liveContainer.context");
      if (((com.tencent.mm.plugin.finder.live.sidebar.d)com.tencent.mm.ui.component.k.nq(paramRecyclerView).q(com.tencent.mm.plugin.finder.live.sidebar.d.class)).DGD)
      {
        if (paramInt != 0) {
          break label207;
        }
        paramRecyclerView = com.tencent.mm.ui.component.k.aeZF;
        paramRecyclerView = this.Bxa.BwE.getContext();
        s.s(paramRecyclerView, "liveContainer.context");
        paramRecyclerView = ((com.tencent.mm.plugin.finder.live.sidebar.d)com.tencent.mm.ui.component.k.nq(paramRecyclerView).q(com.tencent.mm.plugin.finder.live.sidebar.d.class)).DGE;
        if (paramRecyclerView != null) {
          paramRecyclerView.Po(0);
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$initView$2$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(350876);
        return;
        label207:
        paramRecyclerView = com.tencent.mm.ui.component.k.aeZF;
        paramRecyclerView = this.Bxa.BwE.getContext();
        s.s(paramRecyclerView, "liveContainer.context");
        paramRecyclerView = ((com.tencent.mm.plugin.finder.live.sidebar.d)com.tencent.mm.ui.component.k.nq(paramRecyclerView).q(com.tencent.mm.plugin.finder.live.sidebar.d.class)).DGE;
        if (paramRecyclerView != null) {
          paramRecyclerView.Po(8);
        }
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(350881);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$initView$2$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$initView$2$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(350881);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$initView$2$3", "Lcom/tencent/mm/plugin/finder/event/recyclerview/FinderRecyclerView$OnPageChangeCallback;", "onPageScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements FinderRecyclerView.b
  {
    i(FinderLiveViewCallback paramFinderLiveViewCallback, FinderLiveRecyclerView paramFinderLiveRecyclerView) {}
    
    public final void a(RecyclerView paramRecyclerView, int paramInt1, float paramFloat, int paramInt2)
    {
      AppMethodBeat.i(350885);
      s.u(paramRecyclerView, "recyclerView");
      if (FinderLiveViewCallback.i(this.Bxa))
      {
        AppMethodBeat.o(350885);
        return;
      }
      Object localObject = this.Bxa.BwJ;
      FinderLiveRecyclerView localFinderLiveRecyclerView;
      if (localObject != null)
      {
        paramRecyclerView = this.Bxa;
        localFinderLiveRecyclerView = this.Bxd;
        paramInt1 = ((FinderLiveLayoutManager)localObject).Ju();
        paramInt2 = ((FinderLiveLayoutManager)localObject).Jw();
        localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if ((com.tencent.mm.plugin.finder.live.utils.a.euC()) && (FinderLiveViewCallback.q(paramRecyclerView)) && (paramInt1 != paramInt2))
        {
          if (paramInt1 >= FinderLiveViewCallback.r(paramRecyclerView)) {
            break label176;
          }
          if (paramInt2 < FinderLiveViewCallback.s(paramRecyclerView)) {
            FinderLiveViewCallback.f(paramRecyclerView, FinderLiveViewCallback.s(paramRecyclerView));
          }
          FinderLiveViewCallback.h(paramRecyclerView, paramInt1);
          FinderLiveViewCallback.i(paramRecyclerView, FinderLiveViewCallback.p(paramRecyclerView));
        }
      }
      for (;;)
      {
        if ((paramInt1 != paramInt2) && ((paramInt1 < FinderLiveViewCallback.r(paramRecyclerView)) || (paramInt2 > FinderLiveViewCallback.s(paramRecyclerView)))) {
          FinderLiveViewCallback.a(paramRecyclerView, localFinderLiveRecyclerView, paramInt1, paramInt2);
        }
        FinderLiveViewCallback.j(paramRecyclerView, paramInt1);
        FinderLiveViewCallback.k(paramRecyclerView, paramInt2);
        AppMethodBeat.o(350885);
        return;
        label176:
        if (paramInt2 > FinderLiveViewCallback.s(paramRecyclerView))
        {
          if (paramInt1 > FinderLiveViewCallback.r(paramRecyclerView)) {
            FinderLiveViewCallback.f(paramRecyclerView, FinderLiveViewCallback.r(paramRecyclerView));
          }
          FinderLiveViewCallback.h(paramRecyclerView, paramInt2);
          FinderLiveViewCallback.i(paramRecyclerView, FinderLiveViewCallback.p(paramRecyclerView));
        }
      }
    }
    
    public final void j(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(350892);
      s.u(paramRecyclerView, "recyclerView");
      if (FinderLiveViewCallback.i(this.Bxa))
      {
        AppMethodBeat.o(350892);
        return;
      }
      Log.i("Finder.FinderLiveViewCallback", s.X("selectItemView onPageSelected position:", Integer.valueOf(paramInt)));
      paramRecyclerView = com.tencent.mm.plugin.finder.report.r.Fqi;
      com.tencent.mm.plugin.finder.report.r.c(false, FinderLiveViewCallback.k(this.Bxa), 1);
      FinderLiveViewCallback.l(this.Bxa);
      FinderLiveViewCallback.m(this.Bxa);
      AppMethodBeat.o(350892);
    }
    
    public final void k(RecyclerView paramRecyclerView, int paramInt)
    {
      int i = -1;
      AppMethodBeat.i(350901);
      s.u(paramRecyclerView, "recyclerView");
      if (FinderLiveViewCallback.i(this.Bxa))
      {
        AppMethodBeat.o(350901);
        return;
      }
      if (paramInt == 1)
      {
        FinderLiveViewCallback.n(this.Bxa);
        paramRecyclerView = com.tencent.mm.plugin.finder.report.r.Fqi;
        if (com.tencent.mm.plugin.finder.report.r.eML())
        {
          com.tencent.mm.plugin.finder.report.r.Fqo = false;
          paramRecyclerView = com.tencent.mm.plugin.finder.report.r.Fql;
          if (paramRecyclerView != null) {
            paramRecyclerView.Fqu = SystemClock.elapsedRealtime();
          }
          com.tencent.mm.plugin.finder.report.r.Fqk = 2L;
        }
      }
      if (paramInt == 0)
      {
        paramRecyclerView = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if (com.tencent.mm.plugin.finder.live.utils.a.euC())
        {
          paramRecyclerView = this.Bxa.BwJ;
          if (paramRecyclerView != null) {
            break label220;
          }
          paramInt = -1;
          paramRecyclerView = this.Bxa.BwJ;
          if (paramRecyclerView != null) {
            break label228;
          }
        }
      }
      for (;;)
      {
        if (FinderLiveViewCallback.o(this.Bxa))
        {
          Log.i("Finder.FinderLiveViewCallback", "firstVisiblePos:" + paramInt + " lastVisiblePos:" + i + " lastPlayPos: " + FinderLiveViewCallback.p(this.Bxa));
          if ((paramInt == i) && (paramInt != FinderLiveViewCallback.p(this.Bxa))) {
            FinderLiveViewCallback.f(this.Bxa, FinderLiveViewCallback.p(this.Bxa));
          }
        }
        if (paramInt == i) {
          FinderLiveViewCallback.g(this.Bxa, paramInt);
        }
        AppMethodBeat.o(350901);
        return;
        label220:
        paramInt = paramRecyclerView.Ju();
        break;
        label228:
        i = paramRecyclerView.Jw();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$initView$3", "Lcom/tencent/mm/plugin/finder/live/sidebar/FinderLiveSideBar$Listener;", "normalTopMargin", "", "getNormalTopMargin", "()F", "targetTopMargin", "getTargetTopMargin", "notifyLayoutChanged", "", "width", "", "height", "onDragFinished", "show", "", "onDragProgress", "percent", "onDragStarted", "toShow", "onLoadNextPage", "position", "size", "onSelectLive", "fromPos", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    implements com.tencent.mm.plugin.finder.live.sidebar.c.b
  {
    private final float Bxe;
    private final float Bxf;
    
    j(FrameLayout paramFrameLayout, FinderLiveViewCallback paramFinderLiveViewCallback, com.tencent.mm.plugin.finder.live.sidebar.c paramc, com.tencent.mm.plugin.finder.live.viewmodel.data.g paramg)
    {
      AppMethodBeat.i(350877);
      this.Bxe = this.Bxg.getContext().getResources().getDimension(p.c.Edge_5A);
      this.Bxf = this.Bxg.getContext().getResources().getDimension(p.c.Edge_0_5_A);
      AppMethodBeat.o(350877);
    }
    
    private static final void a(int paramInt, FinderLiveViewCallback paramFinderLiveViewCallback)
    {
      AppMethodBeat.i(350911);
      s.u(paramFinderLiveViewCallback, "this$0");
      Log.i("Finder.FinderLiveViewCallback", s.X("lxltest onSelectLive step2 pos:", Integer.valueOf(paramInt)));
      FinderLiveViewCallback.a(paramFinderLiveViewCallback, paramInt);
      AppMethodBeat.o(350911);
    }
    
    private static final void b(FinderLiveViewCallback paramFinderLiveViewCallback, boolean paramBoolean)
    {
      AppMethodBeat.i(350890);
      s.u(paramFinderLiveViewCallback, "this$0");
      paramFinderLiveViewCallback = FinderLiveViewCallback.d(paramFinderLiveViewCallback);
      if (paramFinderLiveViewCallback != null) {
        paramFinderLiveViewCallback.qi(paramBoolean);
      }
      AppMethodBeat.o(350890);
    }
    
    private static final void c(FinderLiveViewCallback paramFinderLiveViewCallback, boolean paramBoolean)
    {
      AppMethodBeat.i(350894);
      s.u(paramFinderLiveViewCallback, "this$0");
      paramFinderLiveViewCallback = FinderLiveViewCallback.d(paramFinderLiveViewCallback);
      if (paramFinderLiveViewCallback != null) {
        paramFinderLiveViewCallback.qi(paramBoolean);
      }
      AppMethodBeat.o(350894);
    }
    
    private final void hB(int paramInt1, int paramInt2)
    {
      Object localObject1 = null;
      AppMethodBeat.i(350884);
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        Object localObject2 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
        localObject2 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
        boolean bool;
        if (localObject2 == null)
        {
          bool = false;
          if (!bool) {
            break label194;
          }
          localObject2 = FinderLiveViewCallback.c(jdField_this).Bxq;
          if (localObject2 != null)
          {
            localObject1 = FinderLiveViewCallback.c(jdField_this).Bxq;
            if (localObject1 != null) {
              break label184;
            }
            localObject1 = null;
            label74:
            ((FinderLiveVisitorPluginLayout)localObject2).notifyRoomPKMicUserChange((JSONObject)localObject1, true, new kotlin.r(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)));
          }
        }
        for (;;)
        {
          localObject1 = FinderLiveViewCallback.c(jdField_this).Bxq;
          if (localObject1 == null) {
            break label342;
          }
          localObject1 = ((FinderLiveVisitorPluginLayout)localObject1).getStartUIC();
          if (localObject1 == null) {
            break label342;
          }
          ((com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.b)localObject1).d(new kotlin.r(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)));
          AppMethodBeat.o(350884);
          return;
          localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
          if (localObject2 == null)
          {
            bool = false;
            break;
          }
          bool = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject2).EfM;
          break;
          label184:
          localObject1 = ((FinderLiveVisitorPluginLayout)localObject1).getLastMicData();
          break label74;
          label194:
          localObject2 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
          localObject2 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
          if (localObject2 == null) {}
          for (;;)
          {
            if (localObject1 == null) {
              break label282;
            }
            localObject1 = FinderLiveViewCallback.c(jdField_this).Bxq;
            if (localObject1 == null) {
              break;
            }
            ((FinderLiveVisitorPluginLayout)localObject1).notifyPKMicUserChange(false, new kotlin.r(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)));
            break;
            localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
            if (localObject2 != null) {
              localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject2).Efv;
            }
          }
          label282:
          localObject1 = FinderLiveViewCallback.c(jdField_this).Bxq;
          if (localObject1 != null) {
            ((FinderLiveVisitorPluginLayout)localObject1).notifyAudienceMicUserChange(false, new kotlin.r(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)));
          }
        }
      }
      this.Bxg.post(new FinderLiveViewCallback.j..ExternalSyntheticLambda1(jdField_this));
      label342:
      AppMethodBeat.o(350884);
    }
    
    private static final void u(FinderLiveViewCallback paramFinderLiveViewCallback)
    {
      Object localObject1 = null;
      AppMethodBeat.i(350904);
      s.u(paramFinderLiveViewCallback, "this$0");
      Object localObject2 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
      localObject2 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
      boolean bool;
      if (localObject2 == null)
      {
        bool = false;
        if (!bool) {
          break label131;
        }
        localObject2 = FinderLiveViewCallback.c(paramFinderLiveViewCallback).Bxq;
        if (localObject2 != null)
        {
          localObject1 = FinderLiveViewCallback.c(paramFinderLiveViewCallback).Bxq;
          if (localObject1 != null) {
            break label123;
          }
          localObject1 = null;
          label57:
          ((FinderLiveVisitorPluginLayout)localObject2).notifyRoomPKMicUserChange((JSONObject)localObject1, true, null);
        }
      }
      for (;;)
      {
        paramFinderLiveViewCallback = FinderLiveViewCallback.c(paramFinderLiveViewCallback).Bxq;
        if (paramFinderLiveViewCallback != null)
        {
          paramFinderLiveViewCallback = paramFinderLiveViewCallback.getStartUIC();
          if (paramFinderLiveViewCallback != null) {
            com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.b.a(paramFinderLiveViewCallback);
          }
        }
        AppMethodBeat.o(350904);
        return;
        localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
        if (localObject2 == null)
        {
          bool = false;
          break;
        }
        bool = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject2).EfM;
        break;
        label123:
        localObject1 = ((FinderLiveVisitorPluginLayout)localObject1).getLastMicData();
        break label57;
        label131:
        localObject2 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
        localObject2 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
        if (localObject2 == null) {}
        for (;;)
        {
          if (localObject1 == null) {
            break label189;
          }
          localObject1 = FinderLiveViewCallback.c(paramFinderLiveViewCallback).Bxq;
          if (localObject1 == null) {
            break;
          }
          ((FinderLiveVisitorPluginLayout)localObject1).notifyPKMicUserChange(false);
          break;
          localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
          if (localObject2 != null) {
            localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject2).Efv;
          }
        }
        label189:
        localObject1 = FinderLiveViewCallback.c(paramFinderLiveViewCallback).Bxq;
        if (localObject1 != null) {
          ((FinderLiveVisitorPluginLayout)localObject1).notifyAudienceMicUserChange(false);
        }
      }
    }
    
    public final void c(float paramFloat, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(350945);
      Log.i("Finder.FinderLiveViewCallback", "sidebar onDragProgress percent:" + paramFloat + ", width:" + paramInt1 + ", height:" + paramInt2);
      hB(paramInt1, paramInt2);
      Object localObject = FinderLiveViewCallback.c(jdField_this).Bxq;
      if (localObject == null)
      {
        localObject = null;
        if (localObject != null) {
          break label175;
        }
        localObject = null;
        label82:
        if (!(localObject instanceof RelativeLayout.LayoutParams)) {
          break label185;
        }
      }
      label175:
      label185:
      for (localObject = (RelativeLayout.LayoutParams)localObject;; localObject = null)
      {
        if (localObject != null) {
          ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)((this.Bxf - this.Bxe) * paramFloat + this.Bxe));
        }
        localObject = jdField_this.BwI.getLayoutManager();
        if (localObject != null) {
          break label191;
        }
        localObject = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(350945);
        throw ((Throwable)localObject);
        localObject = ((FinderLiveVisitorPluginLayout)localObject).findViewById(p.e.BTU);
        break;
        localObject = ((View)localObject).getLayoutParams();
        break label82;
      }
      label191:
      ((LinearLayoutManager)localObject).bo(FinderLiveViewCallback.c(jdField_this).pos, 0);
      AppMethodBeat.o(350945);
    }
    
    public final void hA(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(350967);
      Log.i("Finder.FinderLiveViewCallback", "onLoadNextPage position:" + paramInt1 + ", size:" + paramInt2);
      c.a locala = jdField_this.BvQ;
      if (locala != null)
      {
        aj localaj = aj.CGT;
        locala.a(paramInt1, paramInt2, aj.elr());
      }
      AppMethodBeat.o(350967);
    }
    
    public final void hC(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(350980);
      Log.i("Finder.FinderLiveViewCallback", "lxltest onSelectLive fromPos:" + paramInt2 + ", to:" + paramInt1);
      int i;
      label82:
      label105:
      Object localObject;
      if (paramInt1 >= 0) {
        if (paramInt1 < paramg.Ebx.size())
        {
          i = 1;
          if (i != 0)
          {
            if (paramInt2 < 0) {
              break label328;
            }
            if (paramInt2 >= paramg.Ebx.size()) {
              break label323;
            }
            i = 1;
            if ((i == 0) || (Math.abs(paramInt2 - paramInt1) <= 1)) {
              break label347;
            }
            if (paramInt1 <= paramInt2) {
              break label333;
            }
            i = paramInt1 - 1;
            Log.i("Finder.FinderLiveViewCallback", s.X("lxltest onSelectLive step1 pos:", Integer.valueOf(i)));
            FinderLiveViewCallback.a(jdField_this, true);
            localObject = jdField_this.BwI;
            if (paramInt1 <= paramInt2) {
              break label340;
            }
            paramInt2 = paramInt1 - 1;
            label146:
            com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt2, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$initView$3", "onSelectLive", "(II)V", "Undefined", "scrollToPosition", "(I)V");
            ((FinderLiveRecyclerView)localObject).scrollToPosition(((Integer)locala.sb(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$initView$3", "onSelectLive", "(II)V", "Undefined", "scrollToPosition", "(I)V");
            jdField_this.BwI.post(new FinderLiveViewCallback.j..ExternalSyntheticLambda0(paramInt1, jdField_this));
          }
        }
      }
      for (;;)
      {
        localObject = com.tencent.mm.ui.component.k.aeZF;
        localObject = jdField_this.BwE.getContext();
        s.s(localObject, "liveContainer.context");
        localObject = ((com.tencent.mm.plugin.finder.live.sidebar.d)com.tencent.mm.ui.component.k.nq((Context)localObject).q(com.tencent.mm.plugin.finder.live.sidebar.d.class)).DGE;
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.live.sidebar.c)localObject).Po(8);
        }
        AppMethodBeat.o(350980);
        return;
        i = 0;
        break;
        i = 0;
        break;
        label323:
        i = 0;
        break label82;
        label328:
        i = 0;
        break label82;
        label333:
        i = paramInt1 + 1;
        break label105;
        label340:
        paramInt2 = paramInt1 + 1;
        break label146;
        label347:
        Log.i("Finder.FinderLiveViewCallback", s.X("lxltest onSelectLive step3 pos:", Integer.valueOf(paramInt1)));
        FinderLiveViewCallback.a(jdField_this, paramInt1);
      }
    }
    
    public final void qk(boolean paramBoolean)
    {
      AppMethodBeat.i(350941);
      Log.i("Finder.FinderLiveViewCallback", s.X("sidebar onDragStarted toShow:", Boolean.valueOf(paramBoolean)));
      if (paramBoolean)
      {
        localObject = FinderLiveViewCallback.c(jdField_this).Bxq;
        if (localObject != null) {
          ((FinderLiveVisitorPluginLayout)localObject).clearForSideBar();
        }
        localObject = jdField_this.BwI.getAdapter();
        if (!(localObject instanceof b)) {
          break label95;
        }
      }
      label95:
      for (Object localObject = (b)localObject;; localObject = null)
      {
        if (localObject != null) {
          ((b)localObject).P(true, "onDragStarted");
        }
        this.Bxh.Po(8);
        AppMethodBeat.o(350941);
        return;
      }
    }
    
    public final void ql(boolean paramBoolean)
    {
      AppMethodBeat.i(350959);
      Log.i("Finder.FinderLiveViewCallback", s.X("sidebar onDragFinished show:", Boolean.valueOf(paramBoolean)));
      Object localObject;
      if (!paramBoolean)
      {
        jdField_this.BwD.setCanRefresh(true);
        localObject = FinderLiveViewCallback.c(jdField_this).Bxq;
        if (localObject != null) {
          ((FinderLiveVisitorPluginLayout)localObject).showForSideBar();
        }
        localObject = jdField_this.BwI.getAdapter();
        if ((localObject instanceof b))
        {
          localObject = (b)localObject;
          if (localObject != null) {
            ((b)localObject).P(false, "onDragFinished");
          }
          jdField_this.BwI.post(new FinderLiveViewCallback.j..ExternalSyntheticLambda3(jdField_this, paramBoolean));
          this.Bxh.Po(8);
          localObject = jdField_this.BwI.getAdapter();
          if (!(localObject instanceof b)) {
            break label181;
          }
          localObject = (b)localObject;
          label145:
          if (localObject != null) {
            b.a(FinderLiveViewCallback.c(jdField_this).Bxq, false);
          }
        }
      }
      label275:
      for (;;)
      {
        hB(0, 0);
        AppMethodBeat.o(350959);
        return;
        localObject = null;
        break;
        label181:
        localObject = null;
        break label145;
        jdField_this.BwD.setCanRefresh(false);
        jdField_this.BwI.post(new FinderLiveViewCallback.j..ExternalSyntheticLambda2(jdField_this, paramBoolean));
        this.Bxh.Po(0);
        localObject = jdField_this.BwI.getAdapter();
        if ((localObject instanceof b)) {}
        for (localObject = (b)localObject;; localObject = null)
        {
          if (localObject == null) {
            break label275;
          }
          b.a(FinderLiveViewCallback.c(jdField_this).Bxq, true);
          break;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$isHistoriesLivingCanShow$2$2", "Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$FinderBatchLiveStatusCallback;", "onBatchLiveStatusCallback", "", "liveInfoMap", "", "", "", "intervalSec", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    implements b.c
  {
    k(kotlin.d.d<? super Map<Long, Integer>> paramd) {}
    
    public final void e(Map<Long, Integer> paramMap, int paramInt)
    {
      AppMethodBeat.i(350887);
      s.u(paramMap, "liveInfoMap");
      kotlin.d.d locald = this.msc;
      Result.Companion localCompanion = Result.Companion;
      locald.resumeWith(Result.constructor-impl(paramMap));
      AppMethodBeat.o(350887);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$refreshLayoutAction$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onLoadMoreBegin", "", "loadMoreType", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class l
    extends RefreshLoadMoreLayout.b
  {
    l(FinderLiveViewCallback paramFinderLiveViewCallback, boolean paramBoolean1, boolean paramBoolean2) {}
    
    private static final void v(FinderLiveViewCallback paramFinderLiveViewCallback)
    {
      AppMethodBeat.i(350891);
      s.u(paramFinderLiveViewCallback, "this$0");
      paramFinderLiveViewCallback.BwD.aFV(0);
      AppMethodBeat.o(350891);
    }
    
    public final void IH(int paramInt)
    {
      AppMethodBeat.i(350919);
      super.IH(paramInt);
      Log.i("Finder.FinderLiveViewCallback", "onRefreshBegin");
      this.Bxa.BwD.post(new FinderLiveViewCallback.l..ExternalSyntheticLambda0(this.Bxa));
      com.tencent.mm.plugin.finder.live.report.k localk = com.tencent.mm.plugin.finder.live.report.k.Doi;
      com.tencent.mm.plugin.finder.live.report.k.a(q.y.Dxt);
      AppMethodBeat.o(350919);
    }
    
    public final void a(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(350913);
      s.u(paramd, "reason");
      Log.i("Finder.FinderLiveViewCallback", "onLoadMoreEnd");
      AppMethodBeat.o(350913);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(350927);
      s.u(paramd, "reason");
      super.onRefreshEnd(paramd);
      Log.i("Finder.FinderLiveViewCallback", "onRefreshEnd");
      AppMethodBeat.o(350927);
    }
    
    public final void qI(int paramInt)
    {
      paramInt = 1;
      View localView = null;
      AppMethodBeat.i(350907);
      Object localObject1 = this.Bxa.BwD.aFR(p.e.BNl);
      label41:
      Object localObject2;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (!(localObject1 instanceof MMProcessBar)) {
          break label163;
        }
        localObject1 = (MMProcessBar)localObject1;
        localObject2 = this.Bxa.BwD.aFR(p.e.BNl);
        if (localObject2 != null) {
          break label168;
        }
        label61:
        if (!bool1) {
          break label185;
        }
        localObject2 = this.Bxa.BvQ;
        if ((localObject2 == null) || (((c.a)localObject2).dcT() != true)) {
          break label180;
        }
      }
      for (;;)
      {
        if (paramInt == 0) {
          break label229;
        }
        if (localObject1 != null) {
          ((MMProcessBar)localObject1).oH(p.g.finder_live_icon_location_loading, MMApplicationContext.getContext().getResources().getColor(p.b.White));
        }
        if (localObject1 != null) {
          ((MMProcessBar)localObject1).setVisibility(0);
        }
        if (localView != null) {
          localView.setVisibility(8);
        }
        Log.i("Finder.FinderLiveViewCallback", "load more progress bar is show");
        AppMethodBeat.o(350907);
        return;
        localObject1 = ((View)localObject1).findViewById(p.e.loading_progress);
        break;
        label163:
        localObject1 = null;
        break label41;
        label168:
        localView = ((View)localObject2).findViewById(p.e.load_finish);
        break label61;
        label180:
        paramInt = 0;
      }
      label185:
      if (bool2)
      {
        if (localObject1 != null) {
          ((MMProcessBar)localObject1).setVisibility(8);
        }
        if (localView != null) {
          localView.setVisibility(0);
        }
        this.Bxa.BwD.aFW(0);
        Log.i("Finder.FinderLiveViewCallback", "live list load finish is show");
      }
      label229:
      AppMethodBeat.o(350907);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$setNewGuide$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "dyAmount", "", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "onScrolled", "dx", "dy", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class m
    extends RecyclerView.l
  {
    private int Bxl;
    
    m(FinderLiveViewCallback paramFinderLiveViewCallback, boolean paramBoolean) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(350900);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$setNewGuide$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 1)
      {
        this.Bxa.ehc();
        paramRecyclerView.b((RecyclerView.l)this);
        paramRecyclerView = FinderLiveViewCallback.BwC;
        if (FinderLiveViewCallback.ehe() != 0)
        {
          if (!paramBoolean) {
            break label169;
          }
          if (FinderLiveViewCallback.c(this.Bxa).pos != 0) {
            FinderLiveViewCallback.d(this.Bxa, FinderLiveViewCallback.c(this.Bxa).pos - 1);
          }
        }
        FinderLiveViewCallback.qj(paramBoolean);
        paramRecyclerView = this.Bxa;
        if (paramBoolean) {
          break label191;
        }
      }
      label169:
      label191:
      for (boolean bool = true;; bool = false)
      {
        paramRecyclerView.X(bool, false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$setNewGuide$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(350900);
        return;
        FinderLiveViewCallback.d(this.Bxa, FinderLiveViewCallback.c(this.Bxa).pos + 1);
        break;
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(350906);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$setNewGuide$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      this.Bxl += paramInt2;
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$setNewGuide$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(350906);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$setNewGuide$2", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class n
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    n(FinderLiveViewCallback paramFinderLiveViewCallback, boolean paramBoolean) {}
    
    public final void onGlobalLayout()
    {
      int k = 0;
      Object localObject3 = null;
      AppMethodBeat.i(350902);
      Object localObject1 = this.Bxa.BwI.getAdapter();
      label45:
      com.tencent.mm.plugin.finder.live.viewmodel.data.business.e locale;
      label53:
      label60:
      boolean bool1;
      if ((localObject1 instanceof b))
      {
        localObject1 = (b)localObject1;
        if (localObject1 != null) {
          break label170;
        }
        localObject1 = null;
        if (localObject1 != null) {
          break label208;
        }
        locale = null;
        if (locale != null) {
          break label223;
        }
        i = 0;
        bool1 = com.tencent.mm.ae.d.ee(i, 8);
        if (localObject1 != null) {
          break label232;
        }
        localObject1 = localObject3;
        label77:
        if (localObject1 == null) {
          break label385;
        }
      }
      label385:
      for (int i = 1;; i = 0) {
        for (;;)
        {
          int j = k;
          if (locale != null)
          {
            j = k;
            if (locale.isLiveStarted() == true) {
              j = 1;
            }
          }
          if ((j != 0) && (!bool1) && (i == 0))
          {
            this.Bxa.BwI.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
            com.tencent.mm.ae.d.a(800L, (kotlin.g.a.a)new a(this.Bxa, paramBoolean));
          }
          AppMethodBeat.o(350902);
          return;
          localObject1 = null;
          break;
          label170:
          localObject1 = ((b)localObject1).Ox(FinderLiveViewCallback.c(this.Bxa).pos);
          if (localObject1 == null)
          {
            localObject1 = null;
            break label45;
          }
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.f)localObject1).BxG;
          break label45;
          label208:
          locale = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
          break label53;
          label223:
          i = locale.EcS;
          break label60;
          label232:
          ??? = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
          localObject1 = localObject3;
          if (??? == null) {
            break label77;
          }
          ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)???).Efw;
          localObject1 = localObject3;
          if (??? == null) {
            break label77;
          }
          synchronized ((Iterable)???)
          {
            Iterator localIterator = ((Iterable)???).iterator();
            label288:
            if (localIterator.hasNext())
            {
              localObject3 = localIterator.next();
              String str = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject3).mXL;
              if (locale == null) {}
              for (localObject1 = null;; localObject1 = locale.eyF())
              {
                boolean bool2 = Util.isEqual(str, (String)localObject1);
                if (!bool2) {
                  break label288;
                }
                localObject1 = localObject3;
                localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject1;
                break;
              }
            }
            localObject1 = null;
          }
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(FinderLiveViewCallback paramFinderLiveViewCallback, boolean paramBoolean)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/ui/FinderFullPagerSnapHelper;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.ui.e>
  {
    public static final p Bxp;
    
    static
    {
      AppMethodBeat.i(350856);
      Bxp = new p();
      AppMethodBeat.o(350856);
    }
    
    p()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.FinderLiveViewCallback
 * JD-Core Version:    0.7.0.1
 */