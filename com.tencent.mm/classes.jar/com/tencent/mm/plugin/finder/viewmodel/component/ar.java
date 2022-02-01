package com.tencent.mm.plugin.finder.viewmodel.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.cgi.ap;
import com.tencent.mm.plugin.finder.convert.al;
import com.tencent.mm.plugin.finder.convert.al.a;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.feed.ap.a;
import com.tencent.mm.plugin.finder.feed.ap.b;
import com.tencent.mm.plugin.finder.feed.az;
import com.tencent.mm.plugin.finder.feed.ba;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.report.j;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.autoplay.FinderVideoAutoPlayManager;
import com.tencent.mm.protocal.protobuf.aqt;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.TouchableLayout;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "isEnableFullScreenEnjoy", "", "()Z", "isEnableFullScreenEnjoy$delegate", "Lkotlin/Lazy;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;", "tabType", "", "getTabType", "()I", "tabType$delegate", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "findBaseFinderFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "feedId", "", "getFeedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "getLayoutId", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getVideoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "getVisibleFeedByUsername", "username", "", "handleCmd", "", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "selector", "scene", "onActionbarClick", "isDouble", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAutoToLoadMore", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onCreateBefore", "onDestroy", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "Companion", "plugin-finder_release"})
public final class ar
  extends UIComponent
  implements com.tencent.mm.an.i, com.tencent.mm.plugin.finder.api.h
{
  public static final a BoW;
  ap.b xCN;
  ap.a xDV;
  private final kotlin.f xvO;
  private final kotlin.f zVl;
  
  static
  {
    AppMethodBeat.i(269702);
    BoW = new a((byte)0);
    AppMethodBeat.o(269702);
  }
  
  public ar(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(269700);
    this.xvO = kotlin.g.ar((a)new b(this));
    this.zVl = kotlin.g.ar((a)new f(this));
    AppMethodBeat.o(269700);
  }
  
  public ar(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(269701);
    this.xvO = kotlin.g.ar((a)new b(this));
    this.zVl = kotlin.g.ar((a)new f(this));
    AppMethodBeat.o(269701);
  }
  
  private final boolean dsA()
  {
    AppMethodBeat.i(269681);
    boolean bool = ((Boolean)this.xvO.getValue()).booleanValue();
    AppMethodBeat.o(269681);
    return bool;
  }
  
  private final int getTabType()
  {
    AppMethodBeat.i(269683);
    int i = ((Number)this.zVl.getValue()).intValue();
    AppMethodBeat.o(269683);
    return i;
  }
  
  public final void a(aqt paramaqt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(269699);
    p.k(paramaqt, "cmdItem");
    switch (paramaqt.cmdId)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(269699);
      return;
      paramaqt = this.xDV;
      if (paramaqt == null) {
        p.bGy("presenter");
      }
      paramaqt.dto();
    }
  }
  
  public final void ekl()
  {
    AppMethodBeat.i(269689);
    Object localObject1 = this.xCN;
    if (localObject1 == null) {
      p.bGy("viewCallback");
    }
    localObject1 = ((ap.b)localObject1).getRecyclerView().getLayoutManager();
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
      AppMethodBeat.o(269689);
      throw ((Throwable)localObject1);
    }
    int i = ((LinearLayoutManager)localObject1).kJ();
    localObject1 = this.xCN;
    if (localObject1 == null) {
      p.bGy("viewCallback");
    }
    Object localObject2 = ((ap.b)localObject1).getRecyclerView().getLayoutManager();
    localObject1 = localObject2;
    if (!(localObject2 instanceof LinearLayoutManager)) {
      localObject1 = null;
    }
    localObject1 = (LinearLayoutManager)localObject1;
    if (localObject1 != null) {
      ((LinearLayoutManager)localObject1).au(0, 0);
    }
    if (i < 0)
    {
      localObject2 = this.xCN;
      if (localObject2 == null) {
        p.bGy("viewCallback");
      }
      ((ap.b)localObject2).getRecyclerView().post((Runnable)new c((LinearLayoutManager)localObject1));
    }
    localObject1 = this.xCN;
    if (localObject1 == null) {
      p.bGy("viewCallback");
    }
    ((ap.b)localObject1).dtp();
    localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dTQ().aSr()).intValue() == 1)
    {
      localObject1 = aj.Bnu;
      localObject1 = aj.a.fZ((Context)getActivity());
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.report.n.zWF;
        com.tencent.mm.plugin.finder.report.n.a(((aj)localObject1).ekY(), 5, getTabType());
      }
    }
    localObject1 = al.xmH;
    ap.b localb = this.xCN;
    if (localb == null) {
      p.bGy("viewCallback");
    }
    localObject2 = getFragment();
    localObject1 = localObject2;
    if (!(localObject2 instanceof FinderHomeTabFragment)) {
      localObject1 = null;
    }
    localObject1 = (FinderHomeTabFragment)localObject1;
    if (localObject1 != null) {}
    for (i = ((FinderHomeTabFragment)localObject1).fEH;; i = 0)
    {
      al.a.a(localb, i);
      AppMethodBeat.o(269689);
      return;
    }
  }
  
  public final FinderTimelineFeedLoader elz()
  {
    AppMethodBeat.i(269688);
    ap.a locala = this.xDV;
    if (locala == null) {
      p.bGy("presenter");
    }
    Object localObject = locala;
    if (!(locala instanceof az)) {
      localObject = null;
    }
    localObject = (az)localObject;
    if (localObject != null)
    {
      localObject = ((az)localObject).xCg;
      AppMethodBeat.o(269688);
      return localObject;
    }
    AppMethodBeat.o(269688);
    return null;
  }
  
  public final int getLayoutId()
  {
    AppMethodBeat.i(269684);
    if (dsA())
    {
      i = b.g.finder_timeline_fullscreen_ui;
      AppMethodBeat.o(269684);
      return i;
    }
    int i = b.g.finder_timeline_ui;
    AppMethodBeat.o(269684);
    return i;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(269692);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((isUserVisibleFocused()) && (dsA()) && (-1 == paramInt2) && (paramInt1 == 101))
    {
      Object localObject1 = this.xCN;
      if (localObject1 == null) {
        p.bGy("viewCallback");
      }
      localObject1 = ((ap.b)localObject1).getRecyclerView();
      Object localObject2 = ((RecyclerView)localObject1).getLayoutManager();
      if ((localObject2 instanceof LinearLayoutManager))
      {
        localObject2 = ((RecyclerView)localObject1).cK(((LinearLayoutManager)localObject2).kJ());
        localObject1 = localObject2;
        if (!(localObject2 instanceof com.tencent.mm.view.recyclerview.i)) {
          localObject1 = null;
        }
        localObject1 = (com.tencent.mm.view.recyclerview.i)localObject1;
        if (localObject1 != null)
        {
          localObject1 = (FinderVideoLayout)((com.tencent.mm.view.recyclerview.i)localObject1).RD(b.f.finder_banner_video_layout);
          if (localObject1 != null)
          {
            long l1;
            if (paramIntent != null)
            {
              l1 = paramIntent.getLongExtra("KEY_CACHE_OBJECT_ID", -1L);
              if (paramIntent == null) {
                break label243;
              }
            }
            label243:
            for (long l2 = paramIntent.getLongExtra("KEY_VIDEO_START_PLAY_TIME_MS", -1L);; l2 = -1L)
            {
              Log.i("Finder.TimelineUIC", "[onActivityResult] feedId=" + com.tencent.mm.ae.d.Fw(l1) + " seekTime=" + l2);
              if (l2 != -1L) {
                FinderVideoLayout.a((FinderVideoLayout)localObject1, l2, 0, 0.0F, 6);
              }
              AppMethodBeat.o(269692);
              return;
              l1 = -1L;
              break;
            }
          }
        }
      }
    }
    AppMethodBeat.o(269692);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(269691);
    if (isBelongFragment())
    {
      locala = this.xDV;
      if (locala == null) {
        p.bGy("presenter");
      }
      boolean bool = locala.onBackPressed();
      AppMethodBeat.o(269691);
      return bool;
    }
    ap.a locala = this.xDV;
    if (locala == null) {
      p.bGy("presenter");
    }
    if (!locala.onBackPressed())
    {
      getActivity().finish();
      AppMethodBeat.o(269691);
      return true;
    }
    AppMethodBeat.o(269691);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(269686);
    paramBundle = ap.xcn;
    ap.dnQ();
    paramBundle = com.tencent.mm.plugin.finder.upload.b.Azp;
    com.tencent.mm.plugin.finder.upload.b.ebZ().ebY();
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(269686);
      throw paramBundle;
    }
    MMActivity localMMActivity = (MMActivity)paramBundle;
    Object localObject = getFragment();
    paramBundle = (Bundle)localObject;
    if (!(localObject instanceof FinderHomeTabFragment)) {
      paramBundle = null;
    }
    this.xDV = ((ap.a)new az(localMMActivity, (FinderHomeTabFragment)paramBundle));
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(269686);
      throw paramBundle;
    }
    paramBundle = (MMActivity)paramBundle;
    localObject = this.xDV;
    if (localObject == null) {
      p.bGy("presenter");
    }
    this.xCN = ((ap.b)new ba(paramBundle, (ap.a)localObject, getRootView(), getFragment()));
    paramBundle = this.xDV;
    if (paramBundle == null) {
      p.bGy("presenter");
    }
    localObject = this.xCN;
    if (localObject == null) {
      p.bGy("viewCallback");
    }
    paramBundle.onAttach(localObject);
    paramBundle = com.tencent.mm.plugin.finder.upload.g.AAk;
    com.tencent.mm.plugin.finder.upload.g.ecj().eci();
    ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getFinderSyncExtension().a(104, (com.tencent.mm.plugin.finder.api.h)this);
    ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getFinderSyncExtension().a(108, (com.tencent.mm.plugin.finder.api.h)this);
    boolean bool = com.tencent.mm.plugin.finder.utils.aj.a(com.tencent.mm.plugin.finder.utils.aj.AGc, getTabType(), 0, 2);
    paramBundle = (TouchableLayout)getRootView().findViewById(b.f.tabTimelineContainer);
    p.j(paramBundle, "it");
    int i = paramBundle.getPaddingLeft();
    int j = paramBundle.getPaddingRight();
    int k = paramBundle.getPaddingBottom();
    if (!bool)
    {
      int m = ax.getStatusBarHeight((Context)getActivity());
      paramBundle.setPadding(i, ax.ew((Context)getActivity()) + m, j, k);
    }
    if (bool)
    {
      i = ax.getStatusBarHeight((Context)getActivity());
      j = ax.ew((Context)getActivity());
      paramBundle = getRootView().findViewById(b.f.actionBarOverlayLayout);
      p.j(paramBundle, "rootView.findViewById<Vi…d.actionBarOverlayLayout)");
      paramBundle = paramBundle.getLayoutParams();
      if (paramBundle == null)
      {
        paramBundle = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(269686);
        throw paramBundle;
      }
      ((FrameLayout.LayoutParams)paramBundle).topMargin = (i + j);
    }
    AppMethodBeat.o(269686);
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(269687);
    if (!isBelongFragment()) {
      com.tencent.mm.pluginsdk.h.s((MMActivity)getActivity());
    }
    paramBundle = this.xDV;
    if (paramBundle == null) {
      p.bGy("presenter");
    }
    FinderVideoAutoPlayManager localFinderVideoAutoPlayManager = paramBundle.getVideoCore().ANA;
    if (localFinderVideoAutoPlayManager != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramBundle = getFragment();
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getClass();
        if (paramBundle == null) {}
      }
      for (paramBundle = paramBundle.getSimpleName();; paramBundle = null)
      {
        FinderVideoAutoPlayManager.a(localFinderVideoAutoPlayManager, paramBundle + "#onViewFocused", true);
        AppMethodBeat.o(269687);
        return;
      }
    }
    AppMethodBeat.o(269687);
  }
  
  public final void onCreateBefore(Bundle paramBundle)
  {
    AppMethodBeat.i(269685);
    if (!isBelongFragment()) {
      com.tencent.mm.pluginsdk.h.aZ((Activity)getActivity());
    }
    AppMethodBeat.o(269685);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(269698);
    Log.i("Finder.TimelineUIC", "onDestroy");
    ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getFinderSyncExtension().b(104, (com.tencent.mm.plugin.finder.api.h)this);
    ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getFinderSyncExtension().b(108, (com.tencent.mm.plugin.finder.api.h)this);
    Object localObject = this.xDV;
    if (localObject == null) {
      p.bGy("presenter");
    }
    ((ap.a)localObject).onDetach();
    localObject = com.tencent.mm.plugin.finder.model.n.zAi;
    com.tencent.mm.plugin.finder.model.n.release();
    com.tencent.mm.ae.d.h((a)d.BoZ);
    localObject = this.xCN;
    if (localObject == null) {
      p.bGy("viewCallback");
    }
    ((ap.b)localObject).getRecyclerView().setAdapter(null);
    localObject = j.zVy;
    int i = getTabType();
    localObject = aj.Bnu;
    localObject = aj.a.fZ((Context)getActivity());
    if (localObject != null) {}
    for (localObject = ((aj)localObject).ekY();; localObject = null)
    {
      j.e(i, (bid)localObject);
      localObject = j.zVy;
      j.dPv();
      AppMethodBeat.o(269698);
      return;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(269696);
    super.onPause();
    Object localObject = this.xDV;
    if (localObject == null) {
      p.bGy("presenter");
    }
    ((ap.a)localObject).onUIPause();
    localObject = j.zVy;
    j.dPv();
    AppMethodBeat.o(269696);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(269693);
    super.onResume();
    Object localObject = this.xDV;
    if (localObject == null) {
      p.bGy("presenter");
    }
    ((ap.a)localObject).onUIResume();
    localObject = com.tencent.mm.plugin.finder.upload.g.AAk;
    if ((com.tencent.mm.plugin.finder.upload.g.ecl()) && (getTabType() == 3))
    {
      Log.i("Finder.TimelineUIC", "[onResume] shouldScrollToPostingItem");
      localObject = this.xCN;
      if (localObject == null) {
        p.bGy("viewCallback");
      }
      RecyclerView.LayoutManager localLayoutManager = ((ap.b)localObject).getRecyclerView().getLayoutManager();
      localObject = localLayoutManager;
      if (!(localLayoutManager instanceof LinearLayoutManager)) {
        localObject = null;
      }
      localObject = (LinearLayoutManager)localObject;
      if (localObject != null) {
        ((LinearLayoutManager)localObject).au(0, 0);
      }
      localObject = com.tencent.mm.plugin.finder.upload.g.AAk;
      com.tencent.mm.plugin.finder.upload.g.qS(false);
    }
    localObject = j.zVy;
    j.Pq(getTabType());
    AppMethodBeat.o(269693);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(269690);
    Log.i("Finder.TimelineUIC", "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    AppMethodBeat.o(269690);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(269697);
    super.onStop();
    if (getActivity().isFinishing())
    {
      Object localObject = j.zVy;
      int i = getTabType();
      localObject = aj.Bnu;
      localObject = aj.a.fZ((Context)getActivity());
      if (localObject != null) {}
      for (localObject = ((aj)localObject).ekY();; localObject = null)
      {
        j.e(i, (bid)localObject);
        AppMethodBeat.o(269697);
        return;
      }
    }
    j.d(j.zVy, getTabType());
    AppMethodBeat.o(269697);
  }
  
  public final void onUserVisibleFocused()
  {
    int i = 0;
    AppMethodBeat.i(269694);
    super.onUserVisibleFocused();
    Object localObject1 = com.tencent.mm.ui.component.g.Xox;
    com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.b.class);
    getTabType();
    localObject1 = com.tencent.mm.ui.component.g.Xox;
    ((as)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(as.class)).Q((kotlin.g.a.b)ar.e.Bpa);
    localObject1 = this.xDV;
    if (localObject1 == null) {
      p.bGy("presenter");
    }
    Object localObject2 = ((ap.a)localObject1).getVideoCore().ANA;
    Object localObject3;
    boolean bool1;
    if (localObject2 != null)
    {
      localObject3 = new StringBuilder();
      localObject1 = getFragment();
      if (localObject1 != null)
      {
        localObject1 = localObject1.getClass();
        if (localObject1 != null)
        {
          localObject1 = ((Class)localObject1).getSimpleName();
          ((FinderVideoAutoPlayManager)localObject2).g((String)localObject1 + "#onViewFocused", false, true);
        }
      }
    }
    else
    {
      localObject1 = this.xDV;
      if (localObject1 == null) {
        p.bGy("presenter");
      }
      ((ap.a)localObject1).onUserVisibleFocused();
      localObject1 = this.xDV;
      if (localObject1 == null) {
        p.bGy("presenter");
      }
      localObject1 = ((ap.a)localObject1).getActivity();
      if (localObject1 == null) {
        break label628;
      }
      localObject1 = ((MMActivity)localObject1).getIntent();
      if (localObject1 == null) {
        break label628;
      }
      bool1 = ((Intent)localObject1).getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false);
      label235:
      localObject1 = this.xDV;
      if (localObject1 == null) {
        p.bGy("presenter");
      }
      localObject1 = ((ap.a)localObject1).getActivity();
      if (localObject1 != null)
      {
        localObject1 = ((MMActivity)localObject1).getIntent();
        if (localObject1 != null) {
          ((Intent)localObject1).removeExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB");
        }
      }
      localObject1 = com.tencent.mm.kernel.h.ag(PluginFinder.class);
      p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      boolean bool2 = ((PluginFinder)localObject1).getRedDotManager().Mq(getTabType());
      if ((bool1) && (getTabType() == 3)) {
        break label634;
      }
      localObject1 = this.xDV;
      if (localObject1 == null) {
        p.bGy("presenter");
      }
      ((ap.a)localObject1).R(false, true);
      localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
      if ((((Number)com.tencent.mm.plugin.finder.storage.d.dTQ().aSr()).intValue() == 1) && (bool2))
      {
        localObject1 = aj.Bnu;
        localObject1 = aj.a.fZ((Context)getActivity());
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.plugin.finder.report.n.zWF;
          com.tencent.mm.plugin.finder.report.n.b(((aj)localObject1).ekY(), 6);
        }
      }
    }
    label628:
    label634:
    while ((!bool1) || (getTabType() != 3))
    {
      localObject1 = com.tencent.mm.ui.component.g.Xox;
      localObject1 = ((aj)com.tencent.mm.ui.component.g.b(getActivity()).i(aj.class)).RU(getTabType());
      if (localObject1 != null)
      {
        localObject2 = new com.tencent.mm.plugin.finder.event.base.k(getTabType());
        localObject3 = this.xCN;
        if (localObject3 == null) {
          p.bGy("viewCallback");
        }
        localObject3 = ((ap.b)localObject3).getRecyclerView();
        Object localObject4 = ((RecyclerView)localObject3).getLayoutManager();
        if ((localObject4 instanceof LinearLayoutManager))
        {
          int j = ((LinearLayoutManager)localObject4).kJ();
          int k = ((LinearLayoutManager)localObject4).kL();
          localObject4 = com.tencent.mm.plugin.finder.utils.aj.AGc;
          ((com.tencent.mm.plugin.finder.event.base.k)localObject2).xro = com.tencent.mm.plugin.finder.utils.aj.d((RecyclerView)localObject3, j, k).feed;
        }
        ((c)localObject1).b((com.tencent.mm.plugin.finder.event.base.b)localObject2);
      }
      if ((getActivity() instanceof MMFinderUI))
      {
        localObject2 = getActivity();
        localObject1 = localObject2;
        if (!(localObject2 instanceof MMFinderUI)) {
          localObject1 = null;
        }
        localObject1 = (MMFinderUI)localObject1;
        if (localObject1 != null) {
          i = ((MMFinderUI)localObject1).getCommentScene();
        }
        localObject1 = com.tencent.mm.plugin.finder.live.report.k.yBj;
        com.tencent.mm.plugin.finder.live.report.k.dDm().yDe = i;
      }
      AppMethodBeat.o(269694);
      return;
      localObject1 = null;
      break;
      bool1 = false;
      break label235;
    }
    localObject1 = this.xDV;
    if (localObject1 == null) {
      p.bGy("presenter");
    }
    localObject2 = ((ap.a)localObject1).getVideoCore().ANA;
    if (localObject2 != null)
    {
      localObject3 = new StringBuilder();
      localObject1 = getFragment();
      if (localObject1 == null) {
        break label779;
      }
      localObject1 = localObject1.getClass();
      if (localObject1 == null) {
        break label779;
      }
    }
    label779:
    for (localObject1 = ((Class)localObject1).getSimpleName();; localObject1 = null)
    {
      ((FinderVideoAutoPlayManager)localObject2).g((String)localObject1 + "#onAttach", false, true);
      localObject1 = this.xDV;
      if (localObject1 == null) {
        p.bGy("presenter");
      }
      ((ap.a)localObject1).R(true, false);
      Log.i("Finder.TimelineUIC", "[onUserVisibleFocused] pass this check");
      break;
    }
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(269695);
    super.onUserVisibleUnFocused();
    Object localObject = com.tencent.mm.ui.component.g.Xox;
    ((com.tencent.mm.plugin.finder.viewmodel.b)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.b.class)).RH(getTabType());
    localObject = this.xDV;
    if (localObject == null) {
      p.bGy("presenter");
    }
    ((ap.a)localObject).onUserVisibleUnFocused();
    localObject = j.zVy;
    j.Pr(getTabType());
    localObject = j.zVy;
    j.au(getTabType(), true);
    localObject = com.tencent.mm.plugin.finder.report.h.zVd;
    com.tencent.mm.plugin.finder.report.h.dPo();
    AppMethodBeat.o(269695);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements a<Boolean>
  {
    b(ar paramar)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(LinearLayoutManager paramLinearLayoutManager) {}
    
    public final void run()
    {
      AppMethodBeat.i(263124);
      LinearLayoutManager localLinearLayoutManager = this.xDp;
      if (localLinearLayoutManager != null)
      {
        if (this.BoY) {}
        for (int i = 0;; i = 1)
        {
          localLinearLayoutManager.au(i, 0);
          AppMethodBeat.o(263124);
          return;
        }
      }
      AppMethodBeat.o(263124);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements a<x>
  {
    public static final d BoZ;
    
    static
    {
      AppMethodBeat.i(221614);
      BoZ = new d();
      AppMethodBeat.o(221614);
    }
    
    d()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements a<Integer>
  {
    f(ar paramar)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.ar
 * JD-Core Version:    0.7.0.1
 */