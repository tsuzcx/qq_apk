package com.tencent.mm.plugin.finder.viewmodel.component;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.e;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.plugin.finder.convert.aj;
import com.tencent.mm.plugin.finder.convert.aj.a;
import com.tencent.mm.plugin.finder.feed.ai.a;
import com.tencent.mm.plugin.finder.feed.ai.b;
import com.tencent.mm.plugin.finder.feed.at;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.n;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.utils.y.a;
import com.tencent.mm.plugin.finder.video.FinderVideoAutoPlayManager;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.protocal.protobuf.atn;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "isEnableFullScreenEnjoy", "", "()Z", "isEnableFullScreenEnjoy$delegate", "Lkotlin/Lazy;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;", "tabType", "", "getTabType", "()I", "tabType$delegate", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "findBaseFinderFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "feedId", "", "getLayoutId", "getVisibleFeedByUsername", "username", "", "handleCmd", "", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "selector", "scene", "onActionbarClick", "isDouble", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAutoToLoadMore", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onCreateBefore", "onDestroy", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "requestInsert", "keepUnreadSize", "isPrefetch", "relatedEntranceInfo", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;", "Companion", "plugin-finder_release"})
public final class FinderTimelineUIC
  extends UIComponent
  implements i, com.tencent.mm.plugin.finder.api.f
{
  public static final a wAK;
  private final kotlin.f tLX;
  ai.b tRV;
  private ai.a tTf;
  private final kotlin.f vPc;
  
  static
  {
    AppMethodBeat.i(256034);
    wAK = new a((byte)0);
    AppMethodBeat.o(256034);
  }
  
  public FinderTimelineUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(256033);
    this.tLX = kotlin.g.ah((kotlin.g.a.a)new b(this));
    this.vPc = kotlin.g.ah((kotlin.g.a.a)new g(this));
    AppMethodBeat.o(256033);
  }
  
  public FinderTimelineUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(256032);
    this.tLX = kotlin.g.ah((kotlin.g.a.a)new b(this));
    this.vPc = kotlin.g.ah((kotlin.g.a.a)new g(this));
    AppMethodBeat.o(256032);
  }
  
  private final boolean dck()
  {
    AppMethodBeat.i(256014);
    boolean bool = ((Boolean)this.tLX.getValue()).booleanValue();
    AppMethodBeat.o(256014);
    return bool;
  }
  
  private final int getTabType()
  {
    AppMethodBeat.i(256015);
    int i = ((Number)this.vPc.getValue()).intValue();
    AppMethodBeat.o(256015);
    return i;
  }
  
  public final void a(final long paramLong, int paramInt, final boolean paramBoolean, final atn paramatn)
  {
    int j = 0;
    ai.a locala = null;
    AppMethodBeat.i(256020);
    Object localObject1 = this.tRV;
    if (localObject1 == null) {
      p.btv("viewCallback");
    }
    Object localObject2 = ((ai.b)localObject1).getRecyclerView().getAdapter();
    localObject1 = localObject2;
    if (!(localObject2 instanceof WxRecyclerAdapter)) {
      localObject1 = null;
    }
    localObject1 = (WxRecyclerAdapter)localObject1;
    BaseFinderFeed localBaseFinderFeed;
    LinkedList localLinkedList;
    if (localObject1 != null)
    {
      localObject1 = (com.tencent.mm.view.recyclerview.h)com.tencent.mm.view.recyclerview.g.c((com.tencent.mm.view.recyclerview.g)localObject1, paramLong);
      if (localObject1 == null) {
        break label559;
      }
      localBaseFinderFeed = (BaseFinderFeed)((com.tencent.mm.view.recyclerview.h)localObject1).hgv();
      if (localBaseFinderFeed == null) {
        break label559;
      }
      localLinkedList = new LinkedList();
      localObject1 = this.tRV;
      if (localObject1 == null) {
        p.btv("viewCallback");
      }
      localObject2 = ((ai.b)localObject1).getRecyclerView().getLayoutManager();
      localObject1 = localObject2;
      if (!(localObject2 instanceof LinearLayoutManager)) {
        localObject1 = null;
      }
      localObject1 = (LinearLayoutManager)localObject1;
      if (localObject1 == null) {
        break label335;
      }
    }
    long l;
    label335:
    for (int i = ((LinearLayoutManager)localObject1).ks();; i = 0)
    {
      if (localObject1 != null) {
        j = ((LinearLayoutManager)localObject1).ku();
      }
      localObject1 = y.vXH;
      localObject1 = this.tRV;
      if (localObject1 == null) {
        p.btv("viewCallback");
      }
      l = y.a(((ai.b)localObject1).getRecyclerView(), i, j, null, 8).feedId;
      if (i > j) {
        break label341;
      }
      for (;;)
      {
        localObject1 = this.tRV;
        if (localObject1 == null) {
          p.btv("viewCallback");
        }
        localObject2 = ((ai.b)localObject1).getRecyclerView().ch(i);
        localObject1 = localObject2;
        if (!(localObject2 instanceof com.tencent.mm.view.recyclerview.h)) {
          localObject1 = null;
        }
        localObject1 = (com.tencent.mm.view.recyclerview.h)localObject1;
        if ((localObject1 instanceof com.tencent.mm.view.recyclerview.h))
        {
          localObject1 = ((com.tencent.mm.view.recyclerview.h)localObject1).hgv();
          if ((localObject1 instanceof BaseFinderFeed)) {
            localLinkedList.add(localObject1);
          }
        }
        if (i == j) {
          break;
        }
        i += 1;
      }
      localObject1 = null;
      break;
    }
    label341:
    if (paramLong != l)
    {
      localObject1 = this.tRV;
      if (localObject1 == null) {
        p.btv("viewCallback");
      }
      localObject2 = ((ai.b)localObject1).getRecyclerView().getAdapter();
      localObject1 = localObject2;
      if (!(localObject2 instanceof WxRecyclerAdapter)) {
        localObject1 = null;
      }
      localObject2 = (WxRecyclerAdapter)localObject1;
      localObject1 = locala;
      if (localObject2 != null)
      {
        localObject2 = (com.tencent.mm.view.recyclerview.h)com.tencent.mm.view.recyclerview.g.c((com.tencent.mm.view.recyclerview.g)localObject2, l);
        localObject1 = locala;
        if (localObject2 != null) {
          localObject1 = (BaseFinderFeed)((com.tencent.mm.view.recyclerview.h)localObject2).hgv();
        }
      }
      if (localObject1 != null)
      {
        locala = this.tTf;
        if (locala == null) {
          p.btv("presenter");
        }
        locala.a(localBaseFinderFeed, (BaseFinderFeed)localObject1, paramInt, (List)localLinkedList, paramBoolean, paramatn);
      }
    }
    for (;;)
    {
      localObject1 = MediaPreloadCore.uTV;
      if (MediaPreloadCore.dlF()) {
        d.h((kotlin.g.a.a)new f(localBaseFinderFeed, this, paramLong, paramInt, paramBoolean, paramatn));
      }
      AppMethodBeat.o(256020);
      return;
      localObject1 = this.tTf;
      if (localObject1 == null) {
        p.btv("presenter");
      }
      ((ai.a)localObject1).a(localBaseFinderFeed, localBaseFinderFeed, paramInt, (List)localLinkedList, paramBoolean, paramatn);
    }
    label559:
    AppMethodBeat.o(256020);
  }
  
  public final void a(apf paramapf, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(256031);
    p.h(paramapf, "cmdItem");
    switch (paramapf.cmdId)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(256031);
      return;
      paramapf = this.tTf;
      if (paramapf == null) {
        p.btv("presenter");
      }
      paramapf.dcO();
    }
  }
  
  public final void dHX()
  {
    AppMethodBeat.i(256021);
    Object localObject1 = this.tRV;
    if (localObject1 == null) {
      p.btv("viewCallback");
    }
    localObject1 = ((ai.b)localObject1).getRecyclerView().getLayoutManager();
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
      AppMethodBeat.o(256021);
      throw ((Throwable)localObject1);
    }
    int i = ((LinearLayoutManager)localObject1).ks();
    localObject1 = this.tRV;
    if (localObject1 == null) {
      p.btv("viewCallback");
    }
    Object localObject2 = ((ai.b)localObject1).getRecyclerView().getLayoutManager();
    localObject1 = localObject2;
    if (!(localObject2 instanceof LinearLayoutManager)) {
      localObject1 = null;
    }
    localObject1 = (LinearLayoutManager)localObject1;
    if (localObject1 != null) {
      ((LinearLayoutManager)localObject1).ah(0, 0);
    }
    if (i < 0)
    {
      localObject2 = this.tRV;
      if (localObject2 == null) {
        p.btv("viewCallback");
      }
      ((ai.b)localObject2).getRecyclerView().post((Runnable)new c((LinearLayoutManager)localObject1));
    }
    localObject1 = this.tRV;
    if (localObject1 == null) {
      p.btv("viewCallback");
    }
    ((ai.b)localObject1).dcP();
    localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
    if (((Number)com.tencent.mm.plugin.finder.storage.c.dsx().value()).intValue() == 1)
    {
      localObject1 = FinderReporterUIC.wzC;
      localObject1 = FinderReporterUIC.a.fH((Context)getActivity());
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.a(((FinderReporterUIC)localObject1).dIx(), 5, getTabType());
      }
    }
    localObject1 = aj.tEf;
    ai.b localb = this.tRV;
    if (localb == null) {
      p.btv("viewCallback");
    }
    localObject2 = getFragment();
    localObject1 = localObject2;
    if (!(localObject2 instanceof FinderHomeTabFragment)) {
      localObject1 = null;
    }
    localObject1 = (FinderHomeTabFragment)localObject1;
    if (localObject1 != null) {}
    for (i = ((FinderHomeTabFragment)localObject1).dLS;; i = 0)
    {
      aj.a.a(localb, i);
      AppMethodBeat.o(256021);
      return;
    }
  }
  
  public final int getLayoutId()
  {
    AppMethodBeat.i(256016);
    if (dck())
    {
      AppMethodBeat.o(256016);
      return 2131494650;
    }
    AppMethodBeat.o(256016);
    return 2131494655;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(256024);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((isUserVisibleFocused()) && (dck()) && (-1 == paramInt2) && (paramInt1 == 101))
    {
      Object localObject1 = this.tRV;
      if (localObject1 == null) {
        p.btv("viewCallback");
      }
      localObject1 = ((ai.b)localObject1).getRecyclerView();
      Object localObject2 = ((RecyclerView)localObject1).getLayoutManager();
      if ((localObject2 instanceof LinearLayoutManager))
      {
        localObject2 = ((RecyclerView)localObject1).ch(((LinearLayoutManager)localObject2).ks());
        localObject1 = localObject2;
        if (!(localObject2 instanceof com.tencent.mm.view.recyclerview.h)) {
          localObject1 = null;
        }
        localObject1 = (com.tencent.mm.view.recyclerview.h)localObject1;
        if (localObject1 != null)
        {
          localObject1 = (FinderVideoLayout)((com.tencent.mm.view.recyclerview.h)localObject1).Mn(2131300776);
          if (localObject1 != null)
          {
            long l1;
            if (paramIntent != null)
            {
              l1 = paramIntent.getLongExtra("KEY_CACHE_OBJECT_ID", -1L);
              if (paramIntent == null) {
                break label239;
              }
            }
            label239:
            for (long l2 = paramIntent.getLongExtra("KEY_VIDEO_START_PLAY_TIME_MS", -1L);; l2 = -1L)
            {
              Log.i("Finder.TimelineUIC", "[onActivityResult] feedId=" + d.zs(l1) + " seekTime=" + l2);
              if (l2 != -1L) {
                ((FinderVideoLayout)localObject1).setStartPlayTime(l2);
              }
              AppMethodBeat.o(256024);
              return;
              l1 = -1L;
              break;
            }
          }
        }
      }
    }
    AppMethodBeat.o(256024);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(256023);
    if (isBelongFragment())
    {
      locala = this.tTf;
      if (locala == null) {
        p.btv("presenter");
      }
      boolean bool = locala.onBackPressed();
      AppMethodBeat.o(256023);
      return bool;
    }
    ai.a locala = this.tTf;
    if (locala == null) {
      p.btv("presenter");
    }
    if (!locala.onBackPressed())
    {
      getActivity().finish();
      AppMethodBeat.o(256023);
      return true;
    }
    AppMethodBeat.o(256023);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(256018);
    paramBundle = ao.tuE;
    ao.cYb();
    paramBundle = com.tencent.mm.plugin.finder.upload.b.vRM;
    com.tencent.mm.plugin.finder.upload.b.dAQ().dAP();
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(256018);
      throw paramBundle;
    }
    MMActivity localMMActivity = (MMActivity)paramBundle;
    Object localObject = getFragment();
    paramBundle = (Bundle)localObject;
    if (!(localObject instanceof FinderHomeTabFragment)) {
      paramBundle = null;
    }
    this.tTf = ((ai.a)new at(localMMActivity, (FinderHomeTabFragment)paramBundle));
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(256018);
      throw paramBundle;
    }
    paramBundle = (MMActivity)paramBundle;
    localObject = this.tTf;
    if (localObject == null) {
      p.btv("presenter");
    }
    this.tRV = ((ai.b)new com.tencent.mm.plugin.finder.feed.au(paramBundle, (ai.a)localObject, getRootView(), getFragment()));
    paramBundle = this.tTf;
    if (paramBundle == null) {
      p.btv("presenter");
    }
    localObject = this.tRV;
    if (localObject == null) {
      p.btv("viewCallback");
    }
    paramBundle.onAttach(localObject);
    paramBundle = com.tencent.mm.plugin.finder.upload.g.vSJ;
    com.tencent.mm.plugin.finder.upload.g.dBa().dAZ();
    ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderSyncExtension().a(104, (com.tencent.mm.plugin.finder.api.f)this);
    ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderSyncExtension().a(108, (com.tencent.mm.plugin.finder.api.f)this);
    boolean bool = y.a(y.vXH, getTabType(), 0, 2);
    paramBundle = (TouchableLayout)getRootView().findViewById(2131308825);
    p.g(paramBundle, "it");
    int i = paramBundle.getPaddingLeft();
    int j = paramBundle.getPaddingRight();
    int k = paramBundle.getPaddingBottom();
    if (!bool)
    {
      int m = com.tencent.mm.ui.au.getStatusBarHeight((Context)getActivity());
      paramBundle.setPadding(i, com.tencent.mm.ui.au.eu((Context)getActivity()) + m, j, k);
    }
    if (bool)
    {
      i = com.tencent.mm.ui.au.getStatusBarHeight((Context)getActivity());
      j = com.tencent.mm.ui.au.eu((Context)getActivity());
      paramBundle = getRootView().findViewById(2131296360);
      p.g(paramBundle, "rootView.findViewById<Vi…d.actionBarOverlayLayout)");
      paramBundle = paramBundle.getLayoutParams();
      if (paramBundle == null)
      {
        paramBundle = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(256018);
        throw paramBundle;
      }
      ((FrameLayout.LayoutParams)paramBundle).topMargin = (i + j);
    }
    AppMethodBeat.o(256018);
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(256019);
    if (!isBelongFragment()) {
      com.tencent.mm.pluginsdk.h.r((MMActivity)getActivity());
    }
    paramBundle = this.tTf;
    if (paramBundle == null) {
      p.btv("presenter");
    }
    FinderVideoAutoPlayManager localFinderVideoAutoPlayManager = paramBundle.getVideoCore().weS;
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
        AppMethodBeat.o(256019);
        return;
      }
    }
    AppMethodBeat.o(256019);
  }
  
  public final void onCreateBefore(Bundle paramBundle)
  {
    AppMethodBeat.i(256017);
    if (!isBelongFragment()) {
      com.tencent.mm.pluginsdk.h.aU((Activity)getActivity());
    }
    AppMethodBeat.o(256017);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(256030);
    Log.i("Finder.TimelineUIC", "onDestroy");
    ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderSyncExtension().b(104, (com.tencent.mm.plugin.finder.api.f)this);
    ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderSyncExtension().b(108, (com.tencent.mm.plugin.finder.api.f)this);
    Object localObject = this.tTf;
    if (localObject == null) {
      p.btv("presenter");
    }
    ((ai.a)localObject).onDetach();
    localObject = n.uNU;
    n.release();
    d.i((kotlin.g.a.a)d.wAN);
    localObject = this.tRV;
    if (localObject == null) {
      p.btv("viewCallback");
    }
    ((ai.b)localObject).getRecyclerView().setAdapter(null);
    localObject = com.tencent.mm.plugin.finder.report.h.veu;
    int i = getTabType();
    localObject = FinderReporterUIC.wzC;
    localObject = FinderReporterUIC.a.fH((Context)getActivity());
    if (localObject != null) {}
    for (localObject = ((FinderReporterUIC)localObject).dIx();; localObject = null)
    {
      com.tencent.mm.plugin.finder.report.h.e(i, (bbn)localObject);
      localObject = com.tencent.mm.plugin.finder.report.h.veu;
      com.tencent.mm.plugin.finder.report.h.dnU();
      AppMethodBeat.o(256030);
      return;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(256028);
    super.onPause();
    Object localObject = this.tTf;
    if (localObject == null) {
      p.btv("presenter");
    }
    ((ai.a)localObject).onUIPause();
    localObject = com.tencent.mm.plugin.finder.report.h.veu;
    com.tencent.mm.plugin.finder.report.h.dnU();
    AppMethodBeat.o(256028);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(256025);
    super.onResume();
    Object localObject = this.tTf;
    if (localObject == null) {
      p.btv("presenter");
    }
    ((ai.a)localObject).onUIResume();
    localObject = com.tencent.mm.plugin.finder.upload.g.vSJ;
    if ((com.tencent.mm.plugin.finder.upload.g.dBb()) && (getTabType() == 3))
    {
      Log.i("Finder.TimelineUIC", "[onResume] shouldScrollToPostingItem");
      localObject = this.tRV;
      if (localObject == null) {
        p.btv("viewCallback");
      }
      RecyclerView.LayoutManager localLayoutManager = ((ai.b)localObject).getRecyclerView().getLayoutManager();
      localObject = localLayoutManager;
      if (!(localLayoutManager instanceof LinearLayoutManager)) {
        localObject = null;
      }
      localObject = (LinearLayoutManager)localObject;
      if (localObject != null) {
        ((LinearLayoutManager)localObject).ah(0, 0);
      }
      localObject = com.tencent.mm.plugin.finder.upload.g.vSJ;
      com.tencent.mm.plugin.finder.upload.g.oF(false);
    }
    localObject = com.tencent.mm.plugin.finder.report.h.veu;
    com.tencent.mm.plugin.finder.report.h.Km(getTabType());
    AppMethodBeat.o(256025);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(256022);
    Log.i("Finder.TimelineUIC", "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    AppMethodBeat.o(256022);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(256029);
    super.onStop();
    if (getActivity().isFinishing())
    {
      Object localObject = com.tencent.mm.plugin.finder.report.h.veu;
      int i = getTabType();
      localObject = FinderReporterUIC.wzC;
      localObject = FinderReporterUIC.a.fH((Context)getActivity());
      if (localObject != null) {}
      for (localObject = ((FinderReporterUIC)localObject).dIx();; localObject = null)
      {
        com.tencent.mm.plugin.finder.report.h.e(i, (bbn)localObject);
        AppMethodBeat.o(256029);
        return;
      }
    }
    com.tencent.mm.plugin.finder.report.h.d(com.tencent.mm.plugin.finder.report.h.veu, getTabType());
    AppMethodBeat.o(256029);
  }
  
  public final void onUserVisibleFocused()
  {
    int i = 0;
    AppMethodBeat.i(256026);
    super.onUserVisibleFocused();
    Object localObject1 = com.tencent.mm.ui.component.a.PRN;
    com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
    getTabType();
    localObject1 = com.tencent.mm.ui.component.a.PRN;
    ((FinderVideoRecycler)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoRecycler.class)).J((kotlin.g.a.b)FinderTimelineUIC.e.wAO);
    localObject1 = this.tTf;
    if (localObject1 == null) {
      p.btv("presenter");
    }
    Object localObject2 = ((ai.a)localObject1).getVideoCore().weS;
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
      localObject1 = this.tTf;
      if (localObject1 == null) {
        p.btv("presenter");
      }
      ((ai.a)localObject1).onUserVisibleFocused();
      localObject1 = this.tTf;
      if (localObject1 == null) {
        p.btv("presenter");
      }
      localObject1 = ((ai.a)localObject1).getActivity();
      if (localObject1 == null) {
        break label632;
      }
      localObject1 = ((MMActivity)localObject1).getIntent();
      if (localObject1 == null) {
        break label632;
      }
      bool1 = ((Intent)localObject1).getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false);
      label235:
      localObject1 = this.tTf;
      if (localObject1 == null) {
        p.btv("presenter");
      }
      localObject1 = ((ai.a)localObject1).getActivity();
      if (localObject1 != null)
      {
        localObject1 = ((MMActivity)localObject1).getIntent();
        if (localObject1 != null) {
          ((Intent)localObject1).removeExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB");
        }
      }
      localObject1 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
      p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      boolean bool2 = ((PluginFinder)localObject1).getRedDotManager().Iz(getTabType());
      if ((bool1) && (getTabType() == 3)) {
        break label638;
      }
      localObject1 = this.tTf;
      if (localObject1 == null) {
        p.btv("presenter");
      }
      ((ai.a)localObject1).M(false, true);
      localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
      if ((((Number)com.tencent.mm.plugin.finder.storage.c.dsx().value()).intValue() == 1) && (bool2))
      {
        localObject1 = FinderReporterUIC.wzC;
        localObject1 = FinderReporterUIC.a.fH((Context)getActivity());
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.plugin.finder.report.k.vfA;
          com.tencent.mm.plugin.finder.report.k.a(((FinderReporterUIC)localObject1).dIx(), 6);
        }
      }
    }
    label632:
    label638:
    while ((!bool1) || (getTabType() != 3))
    {
      localObject1 = com.tencent.mm.ui.component.a.PRN;
      localObject1 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(FinderReporterUIC.class)).MA(getTabType());
      if (localObject1 != null)
      {
        localObject2 = new com.tencent.mm.plugin.finder.event.base.k(getTabType());
        localObject3 = this.tRV;
        if (localObject3 == null) {
          p.btv("viewCallback");
        }
        localObject3 = ((ai.b)localObject3).getRecyclerView();
        Object localObject4 = ((RecyclerView)localObject3).getLayoutManager();
        if ((localObject4 instanceof LinearLayoutManager))
        {
          int j = ((LinearLayoutManager)localObject4).ks();
          int k = ((LinearLayoutManager)localObject4).ku();
          localObject4 = y.vXH;
          ((com.tencent.mm.plugin.finder.event.base.k)localObject2).tIF = y.a((RecyclerView)localObject3, j, k, null, 8).feed;
        }
        ((com.tencent.mm.plugin.finder.event.base.c)localObject1).b((com.tencent.mm.plugin.finder.event.base.b)localObject2);
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
        localObject1 = com.tencent.mm.plugin.finder.report.live.k.vkd;
        com.tencent.mm.plugin.finder.report.live.k.dpl().vlR = i;
      }
      AppMethodBeat.o(256026);
      return;
      localObject1 = null;
      break;
      bool1 = false;
      break label235;
    }
    localObject1 = this.tTf;
    if (localObject1 == null) {
      p.btv("presenter");
    }
    localObject2 = ((ai.a)localObject1).getVideoCore().weS;
    if (localObject2 != null)
    {
      localObject3 = new StringBuilder();
      localObject1 = getFragment();
      if (localObject1 == null) {
        break label783;
      }
      localObject1 = localObject1.getClass();
      if (localObject1 == null) {
        break label783;
      }
    }
    label783:
    for (localObject1 = ((Class)localObject1).getSimpleName();; localObject1 = null)
    {
      ((FinderVideoAutoPlayManager)localObject2).g((String)localObject1 + "#onAttach", false, true);
      localObject1 = this.tTf;
      if (localObject1 == null) {
        p.btv("presenter");
      }
      ((ai.a)localObject1).M(true, false);
      Log.i("Finder.TimelineUIC", "[onUserVisibleFocused] pass this check");
      break;
    }
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(256027);
    super.onUserVisibleUnFocused();
    Object localObject = com.tencent.mm.ui.component.a.PRN;
    ((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).Mp(getTabType());
    localObject = this.tTf;
    if (localObject == null) {
      p.btv("presenter");
    }
    ((ai.a)localObject).onUserVisibleUnFocused();
    localObject = com.tencent.mm.plugin.finder.report.h.veu;
    com.tencent.mm.plugin.finder.report.h.Kn(getTabType());
    localObject = com.tencent.mm.plugin.finder.report.h.veu;
    com.tencent.mm.plugin.finder.report.h.ar(getTabType(), true);
    localObject = com.tencent.mm.plugin.finder.report.f.veb;
    com.tencent.mm.plugin.finder.report.f.dnO();
    AppMethodBeat.o(256027);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    b(FinderTimelineUIC paramFinderTimelineUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(LinearLayoutManager paramLinearLayoutManager) {}
    
    public final void run()
    {
      AppMethodBeat.i(256007);
      LinearLayoutManager localLinearLayoutManager = this.tSy;
      if (localLinearLayoutManager != null)
      {
        if (this.wAM) {}
        for (int i = 0;; i = 1)
        {
          localLinearLayoutManager.ah(i, 0);
          AppMethodBeat.o(256007);
          return;
        }
      }
      AppMethodBeat.o(256007);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final d wAN;
    
    static
    {
      AppMethodBeat.i(256009);
      wAN = new d();
      AppMethodBeat.o(256009);
    }
    
    d()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC$requestInsert$1$1"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    f(BaseFinderFeed paramBaseFinderFeed, FinderTimelineUIC paramFinderTimelineUIC, long paramLong, int paramInt, boolean paramBoolean, atn paramatn)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    g(FinderTimelineUIC paramFinderTimelineUIC)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderTimelineUIC
 * JD-Core Version:    0.7.0.1
 */