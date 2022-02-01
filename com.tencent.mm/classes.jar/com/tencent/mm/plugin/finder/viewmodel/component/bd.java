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
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.bj;
import com.tencent.mm.plugin.finder.convert.ag;
import com.tencent.mm.plugin.finder.convert.ag.a;
import com.tencent.mm.plugin.finder.convert.cn;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.feed.aw.a;
import com.tencent.mm.plugin.finder.feed.aw.a.a;
import com.tencent.mm.plugin.finder.feed.aw.b;
import com.tencent.mm.plugin.finder.feed.aw.b.a;
import com.tencent.mm.plugin.finder.feed.bg;
import com.tencent.mm.plugin.finder.feed.bh;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.autoplay.FinderVideoAutoPlayManager;
import com.tencent.mm.plugin.finder.viewmodel.d.a;
import com.tencent.mm.plugin.finder.viewmodel.d.d;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "isFromShareToTimeline", "", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;", "tabType", "", "getTabType", "()I", "tabType$delegate", "Lkotlin/Lazy;", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "autoFlingToRefresh", "", "checkSeek", "intent", "Landroid/content/Intent;", "findBaseFinderFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "feedId", "", "getCurPosition", "getFeedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "getLayoutId", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getVideoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "getVisibleFeedByUsername", "username", "", "handleCmd", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "selector", "scene", "onActionbarClick", "isDouble", "onActivityResult", "requestCode", "resultCode", "data", "onAutoToLoadMore", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onCreateBefore", "onDestroy", "onNewIntent", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bd
  extends UIComponent
  implements com.tencent.mm.am.h, com.tencent.mm.plugin.finder.api.k
{
  public static final a GVA;
  private static boolean GVB;
  private aw.a AIY;
  aw.b AZO;
  private final com.tencent.mm.plugin.finder.viewmodel.d AZj;
  private boolean Btk;
  private final kotlin.j Fqc;
  
  static
  {
    AppMethodBeat.i(338411);
    GVA = new a((byte)0);
    AppMethodBeat.o(338411);
  }
  
  public bd(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(338357);
    paramAppCompatActivity = com.tencent.mm.ui.component.k.aeZF;
    paramAppCompatActivity = com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class);
    kotlin.g.b.s.s(paramAppCompatActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.AZj = ((com.tencent.mm.plugin.finder.viewmodel.d)paramAppCompatActivity);
    this.Fqc = kotlin.k.cm((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(338357);
  }
  
  public bd(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(338368);
    paramFragment = com.tencent.mm.ui.component.k.aeZF;
    paramFragment = com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class);
    kotlin.g.b.s.s(paramFragment, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.AZj = ((com.tencent.mm.plugin.finder.viewmodel.d)paramFragment);
    this.Fqc = kotlin.k.cm((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(338368);
  }
  
  private static final void a(LinearLayoutManager paramLinearLayoutManager, boolean paramBoolean)
  {
    AppMethodBeat.i(338390);
    if (paramLinearLayoutManager != null) {
      if (!paramBoolean) {
        break label27;
      }
    }
    label27:
    for (int i = 0;; i = 1)
    {
      paramLinearLayoutManager.bo(i, 0);
      AppMethodBeat.o(338390);
      return;
    }
  }
  
  private final int getCurPosition()
  {
    AppMethodBeat.i(338380);
    aw.a locala = this.AIY;
    Object localObject = locala;
    if (locala == null)
    {
      kotlin.g.b.s.bIx("presenter");
      localObject = null;
    }
    if ((localObject instanceof bg)) {}
    for (localObject = (bg)localObject; localObject == null; localObject = null)
    {
      AppMethodBeat.o(338380);
      return 0;
    }
    int i = ((bg)localObject).dYO();
    AppMethodBeat.o(338380);
    return i;
  }
  
  private final int getTabType()
  {
    AppMethodBeat.i(338374);
    int i = ((Number)this.Fqc.getValue()).intValue();
    AppMethodBeat.o(338374);
    return i;
  }
  
  public final void a(auw paramauw, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(338593);
    kotlin.g.b.s.u(paramauw, "cmdItem");
    if (paramauw.cmdId == 108)
    {
      aw.a locala = this.AIY;
      paramauw = locala;
      if (locala == null)
      {
        kotlin.g.b.s.bIx("presenter");
        paramauw = null;
      }
      paramauw.ecA();
    }
    AppMethodBeat.o(338593);
  }
  
  public final void aR(Intent paramIntent)
  {
    float f = 1.0F;
    long l2 = -1L;
    AppMethodBeat.i(338520);
    if (!isUserVisibleFocused())
    {
      AppMethodBeat.o(338520);
      return;
    }
    Object localObject2 = this.AZO;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("viewCallback");
      localObject1 = null;
    }
    localObject1 = ((aw.b)localObject1).getRecyclerView();
    localObject2 = ((RecyclerView)localObject1).getLayoutManager();
    long l1;
    if ((localObject2 instanceof LinearLayoutManager))
    {
      localObject1 = ((RecyclerView)localObject1).fU(((LinearLayoutManager)localObject2).Ju());
      if ((localObject1 instanceof com.tencent.mm.view.recyclerview.j))
      {
        localObject1 = (com.tencent.mm.view.recyclerview.j)localObject1;
        if (paramIntent != null) {
          break label233;
        }
        l1 = -1L;
        label111:
        if (paramIntent != null) {
          break label248;
        }
        label115:
        if ((localObject1 == null) || (((RecyclerView.v)localObject1).caO != 4)) {
          break label263;
        }
        i = 1;
        label131:
        if (i == 0) {
          break label280;
        }
        localObject1 = (FinderVideoLayout)((com.tencent.mm.view.recyclerview.j)localObject1).UH(e.e.finder_banner_video_layout);
        if (localObject1 == null) {
          break label376;
        }
        if (paramIntent != null) {
          break label268;
        }
      }
      for (;;)
      {
        Log.i("Finder.TimelineUIC", "[checkSeek] video feedId=" + com.tencent.mm.ae.d.hF(l2) + " seekTime=" + l1 + " speedRatio=" + f);
        if (l1 > 0L) {
          ((FinderVideoLayout)localObject1).a(l1, 3, f);
        }
        AppMethodBeat.o(338520);
        return;
        localObject1 = null;
        break;
        label233:
        l1 = paramIntent.getLongExtra("KEY_VIDEO_START_PLAY_TIME_MS", -1L);
        break label111;
        label248:
        l2 = paramIntent.getLongExtra("KEY_CACHE_OBJECT_ID", -1L);
        break label115;
        label263:
        i = 0;
        break label131;
        label268:
        f = paramIntent.getFloatExtra("KEY_VIDEO_PLAY_SPEED_RATIO", 1.0F);
      }
      label280:
      if ((localObject1 == null) || (((RecyclerView.v)localObject1).caO != 2)) {
        break label382;
      }
    }
    label376:
    label382:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.i("Finder.TimelineUIC", "[checkSeek] photo feedId=" + com.tencent.mm.ae.d.hF(l2) + " seekTime=" + l1);
        if (l1 > 0L)
        {
          paramIntent = (FinderImgFeedMusicTag)((com.tencent.mm.view.recyclerview.j)localObject1).UH(e.e.bgm_iv);
          if (paramIntent != null)
          {
            paramIntent = paramIntent.getPlayer();
            if (paramIntent != null) {
              paramIntent.seekTo(l1);
            }
          }
        }
      }
      AppMethodBeat.o(338520);
      return;
    }
  }
  
  public final void fnc()
  {
    AppMethodBeat.i(338485);
    Object localObject2 = this.AZO;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("viewCallback");
      localObject1 = null;
    }
    localObject1 = ((aw.b)localObject1).getRecyclerView().getLayoutManager();
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
      AppMethodBeat.o(338485);
      throw ((Throwable)localObject1);
    }
    int i = ((LinearLayoutManager)localObject1).Ju();
    localObject2 = this.AZO;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("viewCallback");
      localObject1 = null;
    }
    localObject1 = ((aw.b)localObject1).getRecyclerView().getLayoutManager();
    if ((localObject1 instanceof LinearLayoutManager))
    {
      localObject1 = (LinearLayoutManager)localObject1;
      if (localObject1 != null) {
        ((LinearLayoutManager)localObject1).bo(0, 0);
      }
      if (i < 0)
      {
        aw.b localb = this.AZO;
        localObject2 = localb;
        if (localb == null)
        {
          kotlin.g.b.s.bIx("viewCallback");
          localObject2 = null;
        }
        ((aw.b)localObject2).getRecyclerView().post(new bd..ExternalSyntheticLambda0((LinearLayoutManager)localObject1, true));
      }
      localObject2 = this.AZO;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("viewCallback");
        localObject1 = null;
      }
      aw.b.a.a((aw.b)localObject1, 150L);
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eSi().bmg()).intValue() == 1)
      {
        localObject1 = as.GSQ;
        localObject1 = as.a.hu((Context)getActivity());
        if (localObject1 != null)
        {
          localObject2 = z.FrZ;
          z.a(((as)localObject1).fou(), 5, getTabType());
        }
      }
      localObject1 = ag.AKO;
      localObject1 = this.AZO;
      if (localObject1 != null) {
        break label299;
      }
      kotlin.g.b.s.bIx("viewCallback");
      localObject1 = null;
      label259:
      localObject2 = getFragment();
      if (!(localObject2 instanceof FinderHomeTabFragment)) {
        break label302;
      }
      localObject2 = (FinderHomeTabFragment)localObject2;
      label276:
      if (localObject2 != null) {
        break label307;
      }
    }
    label299:
    label302:
    label307:
    for (i = 0;; i = ((FinderHomeTabFragment)localObject2).hJx)
    {
      ag.a.a((aw.b)localObject1, i);
      AppMethodBeat.o(338485);
      return;
      localObject1 = null;
      break;
      break label259;
      localObject2 = null;
      break label276;
    }
  }
  
  public final FinderTimelineFeedLoader fpq()
  {
    AppMethodBeat.i(338469);
    aw.a locala = this.AIY;
    Object localObject = locala;
    if (locala == null)
    {
      kotlin.g.b.s.bIx("presenter");
      localObject = null;
    }
    if ((localObject instanceof bg)) {}
    for (localObject = (bg)localObject; localObject == null; localObject = null)
    {
      AppMethodBeat.o(338469);
      return null;
    }
    localObject = ((bg)localObject).AZs;
    AppMethodBeat.o(338469);
    return localObject;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_timeline_fullscreen_ui;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(338476);
    aw.b localb = this.AZO;
    Object localObject = localb;
    if (localb == null)
    {
      kotlin.g.b.s.bIx("viewCallback");
      localObject = null;
    }
    localObject = ((aw.b)localObject).getRecyclerView();
    AppMethodBeat.o(338476);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.finder.video.l getVideoCore()
  {
    AppMethodBeat.i(338462);
    aw.a locala = this.AIY;
    Object localObject = locala;
    if (locala == null)
    {
      kotlin.g.b.s.bIx("presenter");
      localObject = null;
    }
    localObject = ((aw.a)localObject).getVideoCore();
    AppMethodBeat.o(338462);
    return localObject;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(338507);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((isUserVisibleFocused()) && (-1 == paramInt2) && (paramInt1 == 101)) {
      aR(paramIntent);
    }
    AppMethodBeat.o(338507);
  }
  
  public final boolean onBackPressed()
  {
    aw.a locala2 = null;
    aw.a locala1 = null;
    AppMethodBeat.i(338500);
    if (isBelongFragment())
    {
      locala2 = this.AIY;
      if (locala2 == null) {
        kotlin.g.b.s.bIx("presenter");
      }
      for (;;)
      {
        boolean bool = locala1.onBackPressed();
        AppMethodBeat.o(338500);
        return bool;
        locala1 = locala2;
      }
    }
    locala1 = this.AIY;
    if (locala1 == null)
    {
      kotlin.g.b.s.bIx("presenter");
      locala1 = locala2;
    }
    while (!locala1.onBackPressed())
    {
      getActivity().finish();
      AppMethodBeat.o(338500);
      return true;
    }
    AppMethodBeat.o(338500);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject2 = null;
    AppMethodBeat.i(338441);
    paramBundle = bj.ABo;
    bj.dVw();
    paramBundle = com.tencent.mm.plugin.finder.upload.b.Gbu;
    com.tencent.mm.plugin.finder.upload.b.fdT().fdz();
    paramBundle = cn.AMo;
    Object localObject1;
    if (cn.getTabType() == getTabType())
    {
      paramBundle = cn.AMo;
      paramBundle = cn.dXZ();
      MMActivity localMMActivity = (MMActivity)getActivity();
      localObject1 = getFragment();
      if (!(localObject1 instanceof FinderHomeTabFragment)) {
        break label328;
      }
      localObject1 = (FinderHomeTabFragment)localObject1;
      label78:
      this.AIY = ((aw.a)new bg(localMMActivity, (FinderHomeTabFragment)localObject1, paramBundle));
      localMMActivity = (MMActivity)getActivity();
      localObject1 = this.AIY;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("presenter");
        paramBundle = null;
      }
      this.AZO = ((aw.b)new bh(localMMActivity, paramBundle, getRootView(), getFragment()));
      localObject1 = this.AIY;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("presenter");
        paramBundle = null;
      }
      localObject1 = this.AZO;
      if (localObject1 != null) {
        break label334;
      }
      kotlin.g.b.s.bIx("viewCallback");
      localObject1 = localObject2;
    }
    int i;
    int j;
    label328:
    label334:
    for (;;)
    {
      paramBundle.onAttach(localObject1);
      ((com.tencent.mm.plugin.finder.publish.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.finder.publish.c.class)).finderPostManager().eKX();
      ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFinderSyncExtension().a(104, (com.tencent.mm.plugin.finder.api.k)this);
      ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFinderSyncExtension().a(108, (com.tencent.mm.plugin.finder.api.k)this);
      i = bf.getStatusBarHeight((Context)getActivity());
      j = bf.fs((Context)getActivity());
      paramBundle = getRootView().findViewById(e.e.actionBarOverlayLayout).getLayoutParams();
      if (paramBundle != null) {
        break label337;
      }
      paramBundle = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(338441);
      throw paramBundle;
      paramBundle = null;
      break;
      localObject1 = null;
      break label78;
    }
    label337:
    ((FrameLayout.LayoutParams)paramBundle).topMargin = (i + j);
    if (getIntent().getIntExtra("FROM_SCENE_KEY", 2) == 6) {}
    for (boolean bool = true;; bool = false)
    {
      this.Btk = bool;
      AppMethodBeat.o(338441);
      return;
    }
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(338451);
    if (!isBelongFragment()) {
      com.tencent.mm.pluginsdk.h.x((MMActivity)getActivity());
    }
    paramBundle = getFragment();
    int i;
    label70:
    Object localObject2;
    if ((paramBundle instanceof FinderHomeTabFragment))
    {
      paramBundle = (FinderHomeTabFragment)paramBundle;
      if (paramBundle == null) {
        break label280;
      }
      paramBundle = paramBundle.EHy;
      if ((paramBundle == null) || (paramBundle.getBoolean("IsFirstEnterTab", false) != true)) {
        break label280;
      }
      i = 1;
      if ((i != 0) && (getIntent().getBooleanExtra("KEY_ROUTE_TO_TOPIC", false)))
      {
        boolean bool = this.AZj.Rp(getTabType());
        Log.i("Finder.TimelineUIC", "[onCreateAfter] is go to topic, tabType=" + getTabType() + " isAutoRefresh=" + bool);
        localObject2 = this.AIY;
        paramBundle = (Bundle)localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("presenter");
          paramBundle = null;
        }
        paramBundle.a(true, true, 0L);
        paramBundle = com.tencent.mm.ui.component.k.aeZF;
        paramBundle = ((com.tencent.mm.plugin.finder.viewmodel.d)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class)).UV(getTabType());
        paramBundle.GKz = System.currentTimeMillis();
        paramBundle.a(d.d.GKO);
      }
      localObject2 = this.AIY;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("presenter");
        paramBundle = null;
      }
      localObject2 = paramBundle.getVideoCore().GpZ;
      if (localObject2 != null)
      {
        paramBundle = getFragment();
        if (paramBundle != null) {
          break label285;
        }
        paramBundle = localObject1;
      }
    }
    for (;;)
    {
      FinderVideoAutoPlayManager.a((FinderVideoAutoPlayManager)localObject2, kotlin.g.b.s.X(paramBundle, "#onViewFocused"), true);
      AppMethodBeat.o(338451);
      return;
      paramBundle = null;
      break;
      label280:
      i = 0;
      break label70;
      label285:
      Class localClass = paramBundle.getClass();
      paramBundle = localObject1;
      if (localClass != null) {
        paramBundle = localClass.getSimpleName();
      }
    }
  }
  
  public final void onCreateBefore(Bundle paramBundle)
  {
    AppMethodBeat.i(338427);
    if (!isBelongFragment()) {
      com.tencent.mm.pluginsdk.h.bE((Activity)getActivity());
    }
    AppMethodBeat.o(338427);
  }
  
  public final void onDestroy()
  {
    Object localObject2 = null;
    AppMethodBeat.i(338588);
    Log.i("Finder.TimelineUIC", "onDestroy");
    ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFinderSyncExtension().b(104, (com.tencent.mm.plugin.finder.api.k)this);
    ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFinderSyncExtension().b(108, (com.tencent.mm.plugin.finder.api.k)this);
    Object localObject3 = this.AIY;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("presenter");
      localObject1 = null;
    }
    ((aw.a)localObject1).onDetach();
    localObject1 = com.tencent.mm.plugin.finder.model.o.ECp;
    com.tencent.mm.plugin.finder.model.o.release();
    com.tencent.mm.ae.d.B((kotlin.g.a.a)b.GVC);
    localObject3 = this.AZO;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("viewCallback");
      localObject1 = null;
    }
    ((aw.b)localObject1).getRecyclerView().setAdapter(null);
    localObject1 = com.tencent.mm.plugin.finder.report.s.Fqv;
    int i = getTabType();
    localObject1 = as.GSQ;
    localObject1 = as.a.hu((Context)getActivity());
    if (localObject1 == null) {}
    for (localObject1 = localObject2;; localObject1 = ((as)localObject1).fou())
    {
      com.tencent.mm.plugin.finder.report.s.e(i, (bui)localObject1);
      localObject1 = com.tencent.mm.plugin.finder.report.s.Fqv;
      com.tencent.mm.plugin.finder.report.s.eMP();
      AppMethodBeat.o(338588);
      return;
    }
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    Object localObject2 = null;
    AppMethodBeat.i(338537);
    super.onNewIntent(paramIntent);
    if (paramIntent == null)
    {
      AppMethodBeat.o(338537);
      return;
    }
    aR(paramIntent);
    if (paramIntent.getIntExtra("KEY_TARGET_TAB_TYPE", 0) != getTabType())
    {
      AppMethodBeat.o(338537);
      return;
    }
    Object localObject1 = paramIntent.getStringExtra("KEY_BY_PASS_INFO");
    int j = paramIntent.getIntExtra("KEY_BY_PASS_INFO_TYPE", 0);
    int k = paramIntent.getIntExtra("KEY_SOURCE_TYPE", 0);
    long l = paramIntent.getLongExtra("KEY_OBJECT_ID", 0L);
    paramIntent = paramIntent.getStringExtra("KEY_OBJECT_NONCE_ID");
    int i;
    if (paramIntent == null)
    {
      paramIntent = "";
      com.tencent.mm.plugin.finder.cgi.fetcher.d locald = new com.tencent.mm.plugin.finder.cgi.fetcher.d();
      if (localObject1 != null)
      {
        if (((CharSequence)localObject1).length() != 0) {
          break label280;
        }
        i = 1;
        label135:
        if (i != 0) {
          break label285;
        }
        i = 1;
        label141:
        if (i == 0) {
          break label290;
        }
        label145:
        if (localObject1 != null)
        {
          localObject1 = ((String)localObject1).getBytes(kotlin.n.d.UTF_8);
          kotlin.g.b.s.s(localObject1, "(this as java.lang.String).getBytes(charset)");
          locald.AEB = new com.tencent.mm.bx.b((byte[])localObject1);
        }
      }
      locald.AEC = Integer.valueOf(j);
      locald.sourceType = k;
      locald.hKN = l;
      locald.setNonceId(paramIntent);
      localObject1 = this.AIY;
      paramIntent = (Intent)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("presenter");
        paramIntent = null;
      }
      paramIntent.ecB().Bjb.AEF = locald;
      paramIntent = this.AIY;
      if (paramIntent != null) {
        break label296;
      }
      kotlin.g.b.s.bIx("presenter");
      paramIntent = localObject2;
    }
    label280:
    label285:
    label290:
    label296:
    for (;;)
    {
      aw.a.a.a(paramIntent, true, true);
      AppMethodBeat.o(338537);
      return;
      break;
      i = 0;
      break label135;
      i = 0;
      break label141;
      localObject1 = null;
      break label145;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(338571);
    super.onPause();
    aw.a locala = this.AIY;
    Object localObject = locala;
    if (locala == null)
    {
      kotlin.g.b.s.bIx("presenter");
      localObject = null;
    }
    ((aw.a)localObject).onUIPause();
    localObject = com.tencent.mm.plugin.finder.report.s.Fqv;
    com.tencent.mm.plugin.finder.report.s.eMP();
    localObject = com.tencent.mm.plugin.finder.report.o.FpJ;
    localObject = (Context)getContext();
    int i = getTabType();
    int j = getCurPosition();
    kotlin.g.b.s.u(localObject, "context");
    if ((!com.tencent.mm.plugin.finder.report.o.cng()) && (i == com.tencent.mm.plugin.finder.report.o.hJx)) {
      com.tencent.mm.plugin.finder.report.o.g((Context)localObject, i, j);
    }
    AppMethodBeat.o(338571);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(338526);
    super.onResume();
    Object localObject2 = this.AIY;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("presenter");
      localObject1 = null;
    }
    ((aw.a)localObject1).onUIResume();
    if ((GVB) && (getTabType() == 3))
    {
      Log.i("Finder.TimelineUIC", "[onResume] shouldScrollToPostingItem");
      localObject2 = this.AZO;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("viewCallback");
        localObject1 = null;
      }
      localObject1 = ((aw.b)localObject1).getRecyclerView().getLayoutManager();
      if (!(localObject1 instanceof LinearLayoutManager)) {
        break label197;
      }
    }
    label197:
    for (localObject1 = (LinearLayoutManager)localObject1;; localObject1 = null)
    {
      if (localObject1 != null) {
        ((LinearLayoutManager)localObject1).bo(0, 0);
      }
      GVB = false;
      localObject1 = com.tencent.mm.plugin.finder.report.s.Fqv;
      com.tencent.mm.plugin.finder.report.s.St(getTabType());
      localObject1 = com.tencent.mm.plugin.finder.report.o.FpJ;
      localObject2 = (Context)getContext();
      int i = getTabType();
      int j = getCurPosition();
      kotlin.g.b.s.u(localObject2, "context");
      if (!com.tencent.mm.plugin.finder.report.o.cng())
      {
        if ((i == com.tencent.mm.plugin.finder.report.o.hJx) && (!com.tencent.mm.plugin.finder.report.o.AuP)) {
          ((com.tencent.mm.plugin.finder.report.o)localObject1).f((Context)localObject2, i, j);
        }
        com.tencent.mm.plugin.finder.report.o.AuP = false;
      }
      AppMethodBeat.o(338526);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(338491);
    Log.i("Finder.TimelineUIC", "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    AppMethodBeat.o(338491);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(338580);
    super.onStop();
    if (getActivity().isFinishing())
    {
      Object localObject = com.tencent.mm.plugin.finder.report.s.Fqv;
      int i = getTabType();
      localObject = as.GSQ;
      localObject = as.a.hu((Context)getActivity());
      if (localObject == null) {}
      for (localObject = null;; localObject = ((as)localObject).fou())
      {
        com.tencent.mm.plugin.finder.report.s.e(i, (bui)localObject);
        AppMethodBeat.o(338580);
        return;
      }
    }
    com.tencent.mm.plugin.finder.report.s.d(com.tencent.mm.plugin.finder.report.s.Fqv, getTabType());
    AppMethodBeat.o(338580);
  }
  
  public final void onUserVisibleFocused()
  {
    Object localObject2 = null;
    AppMethodBeat.i(338559);
    super.onUserVisibleFocused();
    if ((!this.Btk) || (getTabType() != 4))
    {
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class);
      getTabType();
    }
    Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
    ((be)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(be.class)).aw((kotlin.g.a.b)bd.c.GVD);
    Object localObject3 = this.AIY;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("presenter");
      localObject1 = null;
    }
    localObject3 = ((aw.a)localObject1).getVideoCore().GpZ;
    boolean bool1;
    label215:
    boolean bool2;
    label312:
    boolean bool3;
    label409:
    boolean bool4;
    if (localObject3 != null)
    {
      localObject1 = getFragment();
      if (localObject1 == null)
      {
        localObject1 = null;
        ((FinderVideoAutoPlayManager)localObject3).i(kotlin.g.b.s.X((String)localObject1, "#onViewFocused"), false, true);
      }
    }
    else
    {
      localObject3 = this.AIY;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("presenter");
        localObject1 = null;
      }
      ((aw.a)localObject1).onUserVisibleFocused();
      localObject3 = this.AIY;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("presenter");
        localObject1 = null;
      }
      localObject1 = ((aw.a)localObject1).getActivity();
      if (localObject1 != null) {
        break label1024;
      }
      bool1 = false;
      localObject3 = this.AIY;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("presenter");
        localObject1 = null;
      }
      localObject1 = ((aw.a)localObject1).getActivity();
      if (localObject1 != null)
      {
        localObject1 = ((MMActivity)localObject1).getIntent();
        if (localObject1 != null) {
          ((Intent)localObject1).removeExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB");
        }
      }
      localObject3 = this.AIY;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("presenter");
        localObject1 = null;
      }
      localObject1 = ((aw.a)localObject1).getActivity();
      if (localObject1 != null) {
        break label1054;
      }
      bool2 = false;
      localObject3 = this.AIY;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("presenter");
        localObject1 = null;
      }
      localObject1 = ((aw.a)localObject1).getActivity();
      if (localObject1 != null)
      {
        localObject1 = ((MMActivity)localObject1).getIntent();
        if (localObject1 != null) {
          ((Intent)localObject1).removeExtra("KEY_FINDER_IS_NEED_REFRESH_TAB");
        }
      }
      localObject3 = this.AIY;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("presenter");
        localObject1 = null;
      }
      localObject1 = ((aw.a)localObject1).getActivity();
      if (localObject1 != null) {
        break label1086;
      }
      bool3 = false;
      localObject3 = this.AIY;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("presenter");
        localObject1 = null;
      }
      localObject1 = ((aw.a)localObject1).getActivity();
      if (localObject1 != null)
      {
        localObject1 = ((MMActivity)localObject1).getIntent();
        if (localObject1 != null) {
          ((Intent)localObject1).removeExtra("KEY_FORCE_NOT_REFRESH_FIRST_TIME");
        }
      }
      if (bool3) {
        break label1321;
      }
      bool4 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Nw(getTabType());
      if ((bool1) && (getTabType() == 3)) {
        break label1118;
      }
      localObject3 = this.AIY;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("presenter");
        localObject1 = null;
      }
      bool1 = aw.a.a.a((aw.a)localObject1, false, true);
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if ((((Number)com.tencent.mm.plugin.finder.storage.d.eSi().bmg()).intValue() != 1) || (!bool4)) {
        break label1326;
      }
      localObject1 = as.GSQ;
      localObject1 = as.a.hu((Context)getActivity());
      if (localObject1 == null) {
        break label1326;
      }
      localObject3 = z.FrZ;
      z.b(((as)localObject1).fou(), 6);
    }
    label776:
    label783:
    label1054:
    label1321:
    label1326:
    for (;;)
    {
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      Object localObject4 = ((as)com.tencent.mm.ui.component.k.d(getActivity()).q(as.class)).Vm(getTabType());
      int i;
      if (localObject4 != null)
      {
        com.tencent.mm.plugin.finder.event.base.l locall = new com.tencent.mm.plugin.finder.event.base.l(getTabType());
        localObject3 = this.AZO;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          kotlin.g.b.s.bIx("viewCallback");
          localObject1 = null;
        }
        localObject1 = ((aw.b)localObject1).getRecyclerView();
        localObject3 = ((RecyclerView)localObject1).getLayoutManager();
        if ((localObject3 instanceof LinearLayoutManager))
        {
          i = ((LinearLayoutManager)localObject3).Ju();
          int j = ((LinearLayoutManager)localObject3).Jw();
          localObject3 = av.GiL;
          locall.AOy = av.d((RecyclerView)localObject1, i, j).feed;
        }
        localObject1 = ah.aiuX;
        ((com.tencent.mm.plugin.finder.event.base.c)localObject4).b((com.tencent.mm.plugin.finder.event.base.b)locall);
      }
      if ((getActivity() instanceof MMFinderUI))
      {
        localObject1 = getActivity();
        if ((localObject1 instanceof MMFinderUI))
        {
          localObject1 = (MMFinderUI)localObject1;
          if (localObject1 != null) {
            break label1277;
          }
          i = 0;
          ((ce)com.tencent.mm.kernel.h.ax(ce.class)).etm().DpX = i;
        }
      }
      else
      {
        com.tencent.mm.plugin.finder.report.o.FpJ.f((Context)getContext(), getTabType(), getCurPosition());
        localObject1 = this.AIY;
        if (localObject1 != null) {
          break label1286;
        }
        kotlin.g.b.s.bIx("presenter");
        localObject1 = null;
        label841:
        if (bool1) {
          break label1289;
        }
        bool4 = true;
        label848:
        ((aw.a)localObject1).pY(bool4);
        if (!bool1)
        {
          localObject3 = this.AIY;
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            kotlin.g.b.s.bIx("presenter");
            localObject1 = null;
          }
          localObject3 = ((aw.a)localObject1).getVideoCore().GpZ;
          if (localObject3 != null)
          {
            localObject1 = getFragment();
            if (localObject1 != null) {
              break label1295;
            }
            localObject1 = localObject2;
          }
        }
      }
      for (;;)
      {
        ((FinderVideoAutoPlayManager)localObject3).i(kotlin.g.b.s.X((String)localObject1, "#onAttach"), false, true);
        Log.i("Finder.TimelineUIC", "[onUserVisibleFocused] tabType=" + getTabType() + " isAutoFlintToRefresh=" + bool1 + " forceNotRefreshFirstTime=" + bool3 + " isNeedRefresh=" + bool2);
        AppMethodBeat.o(338559);
        return;
        localObject1 = localObject1.getClass();
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject1 = ((Class)localObject1).getSimpleName();
        break;
        localObject1 = ((MMActivity)localObject1).getIntent();
        if (localObject1 == null)
        {
          bool1 = false;
          break label215;
        }
        bool1 = ((Intent)localObject1).getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false);
        break label215;
        localObject1 = ((MMActivity)localObject1).getIntent();
        if (localObject1 == null)
        {
          bool2 = false;
          break label312;
        }
        bool2 = ((Intent)localObject1).getBooleanExtra("KEY_FINDER_IS_NEED_REFRESH_TAB", false);
        break label312;
        label1086:
        localObject1 = ((MMActivity)localObject1).getIntent();
        if (localObject1 == null)
        {
          bool3 = false;
          break label409;
        }
        bool3 = ((Intent)localObject1).getBooleanExtra("KEY_FORCE_NOT_REFRESH_FIRST_TIME", false);
        break label409;
        label1118:
        if ((!bool1) || (getTabType() != 3)) {
          break label1321;
        }
        localObject3 = this.AIY;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          kotlin.g.b.s.bIx("presenter");
          localObject1 = null;
        }
        localObject3 = ((aw.a)localObject1).getVideoCore().GpZ;
        if (localObject3 != null)
        {
          localObject1 = getFragment();
          if (localObject1 != null) {
            break label1243;
          }
          localObject1 = null;
        }
        for (;;)
        {
          ((FinderVideoAutoPlayManager)localObject3).i(kotlin.g.b.s.X((String)localObject1, "#onAttach"), false, true);
          localObject3 = this.AIY;
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            kotlin.g.b.s.bIx("presenter");
            localObject1 = null;
          }
          bool1 = aw.a.a.a((aw.a)localObject1, true, bool2);
          Log.i("Finder.TimelineUIC", "[onUserVisibleFocused] pass this check");
          break;
          label1243:
          localObject1 = localObject1.getClass();
          if (localObject1 == null) {
            localObject1 = null;
          } else {
            localObject1 = ((Class)localObject1).getSimpleName();
          }
        }
        localObject1 = null;
        break label776;
        label1277:
        i = ((MMFinderUI)localObject1).getCommentScene();
        break label783;
        break label841;
        bool4 = false;
        break label848;
        localObject4 = localObject1.getClass();
        localObject1 = localObject2;
        if (localObject4 != null) {
          localObject1 = ((Class)localObject4).getSimpleName();
        }
      }
      bool1 = false;
    }
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(338564);
    super.onUserVisibleUnFocused();
    Object localObject;
    if ((!this.Btk) || (getTabType() != 4))
    {
      localObject = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.plugin.finder.viewmodel.d)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class)).UT(getTabType());
    }
    for (;;)
    {
      aw.a locala = this.AIY;
      localObject = locala;
      if (locala == null)
      {
        kotlin.g.b.s.bIx("presenter");
        localObject = null;
      }
      ((aw.a)localObject).onUserVisibleUnFocused();
      localObject = com.tencent.mm.plugin.finder.report.s.Fqv;
      com.tencent.mm.plugin.finder.report.s.Sv(getTabType());
      localObject = com.tencent.mm.plugin.finder.report.s.Fqv;
      com.tencent.mm.plugin.finder.report.s.aO(getTabType(), true);
      localObject = com.tencent.mm.plugin.finder.report.p.FpQ;
      com.tencent.mm.plugin.finder.report.p.eMB();
      localObject = com.tencent.mm.plugin.finder.report.o.FpJ;
      com.tencent.mm.plugin.finder.report.o.g((Context)getContext(), getTabType(), getCurPosition());
      AppMethodBeat.o(338564);
      return;
      localObject = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.plugin.finder.viewmodel.d)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class)).UU(getTabType());
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC$Companion;", "", "()V", "TAG", "", "shouldScrollToPostingItem", "", "getShouldScrollToPostingItem", "()Z", "setShouldScrollToPostingItem", "(Z)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    public static final b GVC;
    
    static
    {
      AppMethodBeat.i(337885);
      GVC = new b();
      AppMethodBeat.o(337885);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<Integer>
  {
    d(bd parambd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.bd
 * JD-Core Version:    0.7.0.1
 */