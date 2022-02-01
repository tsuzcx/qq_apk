package com.tencent.mm.plugin.finder.profile.uic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.q;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams;
import com.tencent.d.a.a.a.b.b.k;
import com.tencent.d.a.a.a.b.b.k.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ic;
import com.tencent.mm.autogen.a.ie;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.f.a;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader.State;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.live.report.q.n;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.profile.FinderTopicFilterView;
import com.tencent.mm.plugin.finder.report.v;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.FinderRefreshLayout;
import com.tencent.mm.plugin.finder.view.FinderRefreshLayout.b;
import com.tencent.mm.plugin.finder.view.refresh.FinderLoaderMoreFooter;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bgr;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bmi;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.i;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.refreshLayout.WxRefreshLayout;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFragmentUIC;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "FILTER_VIEW_TYPE", "", "getFILTER_VIEW_TYPE", "()I", "actionCallback", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$ViewActionCallback;", "getActionCallback", "()Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$ViewActionCallback;", "actionCallback$delegate", "Lkotlin/Lazy;", "decoratedBounds", "Landroid/graphics/Rect;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "feedLoader$delegate", "feedProgressListener", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$feedProgressListener$1", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$feedProgressListener$1;", "filterContract", "Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterContract;", "filterContractView", "Landroid/view/View;", "isLastItemVisible", "", "layoutConfig", "Lcom/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig;", "getLayoutConfig", "()Lcom/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig;", "layoutConfig$delegate", "mHellOnScrollListener", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$mHellOnScrollListener$1", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$mHellOnScrollListener$1;", "mainFlowLayout", "Landroid/widget/FrameLayout;", "nowPosition", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "kotlin.jvm.PlatformType", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "recyclerView$delegate", "rlLayout", "Lcom/tencent/mm/plugin/finder/view/FinderRefreshLayout;", "getRlLayout", "()Lcom/tencent/mm/plugin/finder/view/FinderRefreshLayout;", "rlLayout$delegate", "state", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader$State;", "getState", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader$State;", "stateLayout", "getLayoutId", "initFilterView", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isLastItemBottomVisible", "target", "Landroidx/recyclerview/widget/RecyclerView;", "jumpProfileTimeline", "pos", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "jumpToLive", "jumpToSnsAlbumPicker", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "req2JustWatched", "setTopicFilterView", "Companion", "ViewActionCallback", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderProfileFeedUIC
  extends g
{
  public static final a Fdw;
  private final int AUO;
  private com.tencent.mm.plugin.finder.profile.e AUR;
  private final kotlin.j AYa;
  private final kotlin.j BaO;
  private final kotlin.j CNQ;
  private final kotlin.j FcO;
  private final kotlin.j FcQ;
  private FrameLayout FcY;
  private final feedProgressListener.1 FdA;
  private final Rect FdB;
  private final f FdC;
  private int Fdo;
  private boolean Fdx;
  private FrameLayout Fdy;
  private View Fdz;
  
  static
  {
    AppMethodBeat.i(349227);
    Fdw = new a((byte)0);
    AppMethodBeat.o(349227);
  }
  
  public FinderProfileFeedUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(349000);
    this.AYa = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.FcO = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.BaO = kotlin.k.cm((kotlin.g.a.a)new t(paramFragment));
    this.CNQ = kotlin.k.cm((kotlin.g.a.a)new s(paramFragment));
    this.FcQ = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.Fdo = -1;
    this.AUO = 10000001;
    this.FdA = new IListener(com.tencent.mm.app.f.hfK) {};
    this.FdB = new Rect();
    this.FdC = new f(this);
    AppMethodBeat.o(349000);
  }
  
  private final b getActionCallback()
  {
    AppMethodBeat.i(349031);
    b localb = (b)this.FcQ.getValue();
    AppMethodBeat.o(349031);
    return localb;
  }
  
  private final com.tencent.mm.plugin.finder.profile.a getLayoutConfig()
  {
    AppMethodBeat.i(349009);
    com.tencent.mm.plugin.finder.profile.a locala = (com.tencent.mm.plugin.finder.profile.a)this.FcO.getValue();
    AppMethodBeat.o(349009);
    return locala;
  }
  
  private final WxRecyclerView getRecyclerView()
  {
    AppMethodBeat.i(349023);
    WxRecyclerView localWxRecyclerView = (WxRecyclerView)this.CNQ.getValue();
    AppMethodBeat.o(349023);
    return localWxRecyclerView;
  }
  
  private final FinderRefreshLayout getRlLayout()
  {
    AppMethodBeat.i(349017);
    FinderRefreshLayout localFinderRefreshLayout = (FinderRefreshLayout)this.BaO.getValue();
    AppMethodBeat.o(349017);
    return localFinderRefreshLayout;
  }
  
  private final void initFilterView(WxRecyclerAdapter<cc> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(349053);
    if (((bw)h.ax(bw.class)).aBu())
    {
      AppMethodBeat.o(349053);
      return;
    }
    com.tencent.mm.plugin.finder.profile.e locale = this.AUR;
    Object localObject = locale;
    if (locale == null)
    {
      s.bIx("filterContract");
      localObject = null;
    }
    localObject = com.tencent.mm.plugin.finder.profile.e.a((com.tencent.mm.plugin.finder.profile.e)localObject);
    i.a((i)paramWxRecyclerAdapter, (View)localObject, getFILTER_VIEW_TYPE());
    paramWxRecyclerAdapter = ah.aiuX;
    this.Fdz = ((View)localObject);
    AppMethodBeat.o(349053);
  }
  
  private final boolean isLastItemBottomVisible(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(349106);
    Object localObject = paramRecyclerView.getLayoutManager();
    int[] arrayOfInt;
    int k;
    int j;
    int i;
    if ((localObject instanceof StaggeredGridLayoutManager))
    {
      arrayOfInt = ((StaggeredGridLayoutManager)localObject).o(null);
      s.s(arrayOfInt, "lastVisibleInfo");
      k = arrayOfInt.length;
      j = 0;
      i = 0;
      if (j < k)
      {
        if (arrayOfInt[j] != ((StaggeredGridLayoutManager)localObject).getItemCount() - 1) {
          break label287;
        }
        i = 1;
      }
    }
    label287:
    for (;;)
    {
      j += 1;
      break;
      if (i != 0)
      {
        j = arrayOfInt.length;
        i = 0;
        while (i < j)
        {
          k = arrayOfInt[i];
          if (k != -1)
          {
            View localView = ((StaggeredGridLayoutManager)localObject).findViewByPosition(k);
            if (localView != null)
            {
              RecyclerView.getDecoratedBoundsWithMargins(localView, this.FdB);
              if (this.FdB.bottom > paramRecyclerView.getHeight())
              {
                AppMethodBeat.o(349106);
                return false;
              }
            }
          }
          i += 1;
        }
        AppMethodBeat.o(349106);
        return true;
        if ((localObject instanceof LinearLayoutManager))
        {
          i = ((LinearLayoutManager)localObject).Jw();
          if (i == ((LinearLayoutManager)localObject).getItemCount() - 1)
          {
            localObject = ((LinearLayoutManager)localObject).findViewByPosition(i);
            if (localObject != null)
            {
              RecyclerView.getDecoratedBoundsWithMargins((View)localObject, this.FdB);
              if (this.FdB.bottom <= paramRecyclerView.getHeight())
              {
                ((View)localObject).getHitRect(this.FdB);
                if (this.FdB.bottom <= paramRecyclerView.getHeight())
                {
                  AppMethodBeat.o(349106);
                  return true;
                }
                AppMethodBeat.o(349106);
                return false;
              }
            }
          }
        }
      }
      AppMethodBeat.o(349106);
      return false;
    }
  }
  
  private final void jumpProfileTimeline(int paramInt, BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(349066);
    Intent localIntent = new Intent();
    BaseFeedLoader.saveCache$default((BaseFeedLoader)getFeedLoader(), localIntent, paramInt, null, 4, null);
    localIntent.putExtra("KEY_FROM_TOPIC_ID", getFeedLoader().getCurTopicId());
    localIntent.putExtra("finder_username", getUsername());
    localIntent.putExtra("KEY_FINDER_SELF_FLAG", isSelfFlag());
    Object localObject = getFragment();
    if (localObject == null) {
      localObject = null;
    }
    for (;;)
    {
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        localIntent.putExtra("key_click_tab_context_id", ((com.tencent.d.a.b.a.e)h.az(com.tencent.d.a.b.a.e.class)).getNearbyTabLifecycleReporter().eGM());
      }
      localObject = as.GSQ;
      as.a.a((Context)getActivity(), localIntent, 0L, 0, false, 124);
      localIntent.putExtra("KEY_FINDER_FEEDID", paramBaseFinderFeed.feedObject.getId());
      localObject = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.T((Context)getActivity(), localIntent);
      localObject = com.tencent.mm.plugin.finder.report.z.FrZ;
      com.tencent.mm.plugin.finder.report.z.ab(paramBaseFinderFeed.bZA(), 1);
      AppMethodBeat.o(349066);
      return;
      localObject = ((Fragment)localObject).getActivity();
      if (localObject == null)
      {
        localObject = null;
      }
      else
      {
        com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
        localObject = ((as)com.tencent.mm.ui.component.k.nq((Context)localObject).q(as.class)).zIB;
      }
    }
  }
  
  private final void jumpToLive(BaseFinderFeed paramBaseFinderFeed, int paramInt)
  {
    AppMethodBeat.i(349085);
    Object localObject4;
    long l1;
    Object localObject2;
    Object localObject3;
    if (Util.isEqual(paramBaseFinderFeed.feedObject.getFeedObject().username, com.tencent.mm.model.z.bAW()))
    {
      localObject1 = h.ax(com.tencent.mm.plugin.f.class);
      s.s(localObject1, "service(IActivityRouter::class.java)");
      localObject4 = (com.tencent.mm.plugin.f)localObject1;
      localObject5 = (Context)getActivity();
      l1 = paramBaseFinderFeed.feedObject.getFeedObject().id;
      localObject2 = paramBaseFinderFeed.feedObject.getFeedObject().objectNonceId;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject3 = paramBaseFinderFeed.feedObject.getFeedObject().liveInfo;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = new bip();
      }
      f.a.a((com.tencent.mm.plugin.f)localObject4, (Context)localObject5, l1, (String)localObject1, (bip)localObject2, null, null, null, null, null, paramBaseFinderFeed.getSessionBuffer(), null, null, 7152);
      AppMethodBeat.o(349085);
      return;
    }
    ((ce)h.ax(ce.class)).a(paramBaseFinderFeed, paramInt, q.w.DwU, q.n.Dtx.scene);
    Object localObject5 = new Intent();
    Object localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().liveInfo;
    com.tencent.mm.plugin.f localf;
    Context localContext;
    long l2;
    label332:
    String str1;
    label409:
    String str2;
    label432:
    label449:
    int i;
    if (localObject1 == null)
    {
      paramInt = 0;
      ((Intent)localObject5).putExtra("KEY_ENTER_LIVE_PARAM_VR_LIVE_TYPE", paramInt);
      localObject1 = b.k.ahpq;
      ((Intent)localObject5).putExtra("KEY_ENTER_LIVE_PARAM_LIVE_EVENT_SOURCE", b.k.a.jWl());
      localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().liveInfo;
      if (localObject1 != null)
      {
        localObject1 = ((bip)localObject1).ZSn;
        if (localObject1 != null) {
          ((Intent)localObject5).putExtra("KEY_ENTER_LIVE_PARAM_LIVE_EVENT_INFO", ((bgr)localObject1).toByteArray());
        }
      }
      localf = (com.tencent.mm.plugin.f)com.tencent.mm.plugin.finder.utils.a.GfO;
      localContext = (Context)getActivity();
      l2 = paramBaseFinderFeed.feedObject.getFeedObject().id;
      localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().liveInfo;
      if (localObject1 != null) {
        break label540;
      }
      l1 = 0L;
      localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().username;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().objectNonceId;
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = "";
      }
      str1 = paramBaseFinderFeed.feedObject.getDescription();
      localObject1 = paramBaseFinderFeed.feedObject.getLiveInfo();
      if (localObject1 != null) {
        break label550;
      }
      paramInt = 0;
      str2 = paramBaseFinderFeed.getSessionBuffer();
      localObject1 = paramBaseFinderFeed.feedObject.getLiveInfo();
      if (localObject1 != null) {
        break label559;
      }
      localObject4 = null;
      localObject1 = paramBaseFinderFeed.feedObject.getLiveInfo();
      if (localObject1 != null) {
        break label569;
      }
      localObject1 = null;
      com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
      i = ((as)com.tencent.mm.ui.component.k.d(getActivity()).q(as.class)).AJo;
      paramBaseFinderFeed = paramBaseFinderFeed.feedObject.getLiveInfo();
      if (paramBaseFinderFeed != null) {
        break label600;
      }
      paramBaseFinderFeed = null;
    }
    for (;;)
    {
      f.a.a(localf, (Intent)localObject5, localContext, l2, l1, (String)localObject2, (String)localObject3, str1, "", paramInt, str2, null, (String)localObject4, (Integer)localObject1, i, paramBaseFinderFeed, false, 33792);
      AppMethodBeat.o(349085);
      return;
      paramInt = ((bip)localObject1).ZSl;
      break;
      label540:
      l1 = ((bip)localObject1).liveId;
      break label332;
      label550:
      paramInt = ((bip)localObject1).ZRR;
      break label409;
      label559:
      localObject4 = ((bip)localObject1).mIE;
      break label432;
      label569:
      localObject1 = ((bip)localObject1).ZRQ;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label449;
      }
      localObject1 = Integer.valueOf(((bmi)localObject1).mNn);
      break label449;
      label600:
      paramBaseFinderFeed = paramBaseFinderFeed.ZOg;
      if (paramBaseFinderFeed == null) {
        paramBaseFinderFeed = null;
      } else {
        paramBaseFinderFeed = paramBaseFinderFeed.toByteArray();
      }
    }
  }
  
  private final void jumpToSnsAlbumPicker()
  {
    AppMethodBeat.i(349094);
    Object localObject1 = new StringBuilder();
    h.baC();
    localObject1 = com.tencent.mm.kernel.b.aZs() + '_' + Util.nowMilliSecond();
    Object localObject2 = v.FrN;
    v.azP((String)localObject1);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_finder_post_id", (String)localObject1);
    localObject1 = as.GSQ;
    localObject1 = as.a.hu((Context)getActivity());
    if (localObject1 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      localIntent.putExtra("key_finder_context_id", (String)localObject1);
      localObject1 = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.ay((Context)getContext(), localIntent);
      AppMethodBeat.o(349094);
      return;
      localObject1 = ((as)localObject1).fou();
      if (localObject1 == null)
      {
        localObject1 = "";
      }
      else
      {
        localObject2 = ((bui)localObject1).zIO;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
    }
  }
  
  private static final void onResume$lambda-7(FinderProfileFeedUIC paramFinderProfileFeedUIC)
  {
    AppMethodBeat.i(349114);
    s.u(paramFinderProfileFeedUIC, "this$0");
    paramFinderProfileFeedUIC = paramFinderProfileFeedUIC.getRecyclerView().getLayoutManager();
    if (paramFinderProfileFeedUIC != null)
    {
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramFinderProfileFeedUIC.getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramFinderProfileFeedUIC, locala.aYi(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC", "onResume$lambda-7", "(Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC;)V", "Undefined", "scrollToPosition", "(I)V");
      paramFinderProfileFeedUIC.scrollToPosition(((Integer)locala.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramFinderProfileFeedUIC, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC", "onResume$lambda-7", "(Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC;)V", "Undefined", "scrollToPosition", "(I)V");
    }
    AppMethodBeat.o(349114);
  }
  
  private final void setTopicFilterView()
  {
    AppMethodBeat.i(349041);
    com.tencent.mm.plugin.finder.profile.e locale = this.AUR;
    Object localObject = locale;
    if (locale == null)
    {
      s.bIx("filterContract");
      localObject = null;
    }
    localObject = ((com.tencent.mm.plugin.finder.profile.e)localObject).FaE;
    if (localObject != null) {
      ((FinderTopicFilterView)localObject).setPadding(0, (int)getResources().getDimension(e.c.Edge_1_5_A), 0, (int)getResources().getDimension(e.c.Edge_0_5_A));
    }
    AppMethodBeat.o(349041);
  }
  
  public final int getFILTER_VIEW_TYPE()
  {
    return this.AUO;
  }
  
  public final FinderProfileFeedLoader getFeedLoader()
  {
    AppMethodBeat.i(349244);
    FinderProfileFeedLoader localFinderProfileFeedLoader = (FinderProfileFeedLoader)this.AYa.getValue();
    AppMethodBeat.o(349244);
    return localFinderProfileFeedLoader;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_profile_feed_ui_v2;
  }
  
  public final FinderProfileFeedLoader.State getState()
  {
    AppMethodBeat.i(349259);
    FinderProfileFeedLoader.State localState = getFeedLoader().getState();
    AppMethodBeat.o(349259);
    return localState;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(349291);
    super.onCreate(paramBundle);
    this.FdA.alive();
    Object localObject2 = getFeedLoader();
    Object localObject1 = getIntent().getStringExtra("KEY_FINDER_PROFILE_UI_REQUEST_LIST_POSITION");
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = "";
    }
    ((FinderProfileFeedLoader)localObject2).setLiveNoticeId(paramBundle);
    getFeedLoader().setJustWathcedCallback((kotlin.g.a.b)new g(this));
    getFeedLoader().setReadFeedId(Long.valueOf(getIntent().getLongExtra("finder_read_feed_id", -1L)));
    getFeedLoader().register((com.tencent.mm.view.k)getActionCallback());
    paramBundle = getFragment();
    label197:
    int i;
    if (paramBundle == null)
    {
      paramBundle = null;
      this.FcY = paramBundle;
      paramBundle = getFragment();
      if (paramBundle != null) {
        break label784;
      }
      paramBundle = null;
      this.Fdy = paramBundle;
      getRlLayout().setOnSimpleAction((com.tencent.mm.view.refreshLayout.d.b)new k(this));
      if (!isSelfFlag()) {
        break label814;
      }
      paramBundle = new FinderLoaderMoreFooter((Context)getActivity());
      paramBundle.UM(e.f.jump_sns_album_picker_footer);
      getRlLayout().a((com.tencent.mm.view.refreshLayout.b.b)paramBundle);
      paramBundle = (Activity)getActivity();
      localObject1 = getFeedLoader().getTopicFilterList();
      localObject2 = getUsername();
      s.checkNotNull(localObject2);
      s.s(localObject2, "username!!");
      this.AUR = new com.tencent.mm.plugin.finder.profile.e(paramBundle, (ArrayList)localObject1, (String)localObject2);
      getRecyclerView().setLayoutManager(getLayoutConfig().fT((Context)getActivity()));
      getRecyclerView().a(getLayoutConfig().getItemDecoration());
      getRecyclerView().setRecycledViewPool(getLayoutConfig().j((MMActivity)getActivity()));
      paramBundle = getRecyclerView();
      localObject1 = new l(this, getLayoutConfig().ech(), getFeedLoader().getDataList());
      ((i)localObject1).agOe = ((i.c)new m(this, (l)localObject1));
      if (((Collection)getFeedLoader().getTopicFilterList()).isEmpty()) {
        break label851;
      }
      i = 1;
      label367:
      if (i != 0) {
        initFilterView((WxRecyclerAdapter)localObject1);
      }
      localObject2 = ah.aiuX;
      paramBundle.setAdapter((RecyclerView.a)localObject1);
      paramBundle = this.AUR;
      if (paramBundle != null) {
        break label856;
      }
      s.bIx("filterContract");
      paramBundle = null;
    }
    label784:
    label814:
    label851:
    label856:
    for (;;)
    {
      paramBundle.FaF = ((m)new n(this));
      getFeedLoader().setOnFilterDataChanged((kotlin.g.a.a)new o(this));
      paramBundle = this.FcY;
      if (paramBundle != null) {
        paramBundle.setBackgroundResource(e.d.finder_profile_gradient_bg);
      }
      getFeedLoader().setInitDone((com.tencent.mm.plugin.finder.feed.model.internal.j)new p(this));
      getFeedLoader().setCantShowBtn((kotlin.g.a.a)new q(this));
      getFeedLoader().setFetchEndCallback((kotlin.g.a.b)new r(this));
      getFeedLoader().setHandleStickyEvent((kotlin.g.a.b)new h(this));
      getFeedLoader().setClickToLoadJustWatch((kotlin.g.a.b)new i(this));
      getFeedLoader().setJustWatchingCallback((kotlin.g.a.b)new j(this));
      BaseFeedLoader.requestInit$default((BaseFeedLoader)getFeedLoader(), false, 1, null);
      getFeedLoader().requestRefresh();
      paramBundle = getRlLayout();
      s.s(paramBundle, "rlLayout");
      WxRefreshLayout.c((WxRefreshLayout)paramBundle);
      getRecyclerView().a((RecyclerView.l)this.FdC);
      paramBundle = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eWk().bmg()).intValue() == 1)
      {
        paramBundle = getRecyclerView();
        localObject1 = getRlLayout();
        s.s(localObject1, "rlLayout");
        paramBundle.a((RecyclerView.l)new com.tencent.mm.plugin.finder.feed.component.g("Finder.ProfileFeedUIC", (WxRefreshLayout)localObject1));
      }
      paramBundle = com.tencent.mm.ui.component.k.aeZF;
      paramBundle = (e)com.tencent.mm.ui.component.k.nq((Context)getContext()).q(e.class);
      localObject1 = getRecyclerView();
      s.s(localObject1, "recyclerView");
      localObject1 = (RecyclerView)localObject1;
      s.u(localObject1, "profileRecyclerView");
      paramBundle.mkw = ((RecyclerView)localObject1);
      paramBundle.Fdn = true;
      paramBundle.eIY().setVisibility(4);
      paramBundle.eJd();
      AppMethodBeat.o(349291);
      return;
      paramBundle = paramBundle.getView();
      if (paramBundle == null) {}
      for (paramBundle = null;; paramBundle = paramBundle.findViewById(e.e.profile_loading_state_container))
      {
        paramBundle = (FrameLayout)paramBundle;
        break;
      }
      paramBundle = paramBundle.getView();
      if (paramBundle == null) {}
      for (paramBundle = null;; paramBundle = paramBundle.findViewById(e.e.main_flow_layout))
      {
        paramBundle = (FrameLayout)paramBundle;
        break;
      }
      paramBundle = new FinderLoaderMoreFooter((Context)getActivity());
      paramBundle.UM(e.f.load_more_footer);
      getRlLayout().a((com.tencent.mm.view.refreshLayout.b.b)paramBundle);
      break label197;
      i = 0;
      break label367;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(349305);
    super.onDestroy();
    getFeedLoader().unregister((com.tencent.mm.view.k)getActionCallback());
    this.FdA.dead();
    getRecyclerView().b((RecyclerView.l)this.FdC);
    com.tencent.mm.plugin.finder.report.z localz = com.tencent.mm.plugin.finder.report.z.FrZ;
    com.tencent.mm.plugin.finder.report.z.tO(false);
    localz = com.tencent.mm.plugin.finder.report.z.FrZ;
    com.tencent.mm.plugin.finder.report.z.tN(false);
    AppMethodBeat.o(349305);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(349329);
    super.onPause();
    ((ce)h.ax(ce.class)).b((RecyclerView)getRecyclerView(), q.w.DwP, q.n.Dtx.scene, com.tencent.mm.plugin.finder.live.report.d.Dng);
    WxRecyclerView localWxRecyclerView = getRecyclerView();
    s.s(localWxRecyclerView, "recyclerView");
    if (isLastItemBottomVisible((RecyclerView)localWxRecyclerView)) {
      this.Fdx = true;
    }
    AppMethodBeat.o(349329);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(349318);
    super.onResume();
    ((ce)h.ax(ce.class)).b((RecyclerView)getRecyclerView(), q.w.DwP, q.n.Dtx.scene, com.tencent.mm.plugin.finder.live.report.d.Dnf);
    Log.i("Finder.ProfileFeedUIC", s.X("isLastItemVisible :", Boolean.valueOf(this.Fdx)));
    if (this.Fdx) {
      getRecyclerView().post(new FinderProfileFeedUIC..ExternalSyntheticLambda0(this));
    }
    this.Fdx = false;
    Object localObject;
    if (getFeedLoader().getSize() > 0)
    {
      localObject = getRlLayout().getLoadMoreFooter();
      if (localObject == null) {
        break label315;
      }
      localObject = ((com.tencent.mm.view.refreshLayout.b.b)localObject).getView();
      if ((localObject == null) || (((View)localObject).getVisibility() != 0)) {
        break label315;
      }
      i = 1;
      if (i != 0)
      {
        localObject = getRlLayout().getLoadMoreFooter();
        if (localObject == null) {
          break label320;
        }
        localObject = ((com.tencent.mm.view.refreshLayout.b.b)localObject).getView();
        if (localObject == null) {
          break label320;
        }
        localObject = ((View)localObject).findViewById(e.e.jump_sns_album_picker_footer_rl);
        if ((localObject == null) || (((View)localObject).getVisibility() != 0)) {
          break label320;
        }
        i = 1;
        label180:
        if (i != 0)
        {
          localObject = com.tencent.mm.plugin.finder.report.z.FrZ;
          com.tencent.mm.plugin.finder.report.z.tN(true);
          localObject = com.tencent.mm.plugin.finder.report.z.FrZ;
          com.tencent.mm.plugin.finder.report.z.tO(true);
          localObject = com.tencent.mm.plugin.finder.report.z.FrZ;
          com.tencent.mm.plugin.finder.report.z.f((Context)getContext(), false, true);
        }
      }
    }
    if ((getFeedLoader().getSize() == 0) && (getFeedLoader().getState() == FinderProfileFeedLoader.State.LOADED))
    {
      localObject = this.FcY;
      if (localObject == null) {
        break label325;
      }
      localObject = (RelativeLayout)((FrameLayout)localObject).findViewById(e.e.tips_pick_from_sns_album_rl);
      if ((localObject == null) || (((RelativeLayout)localObject).getVisibility() != 0)) {
        break label325;
      }
    }
    label315:
    label320:
    label325:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = com.tencent.mm.plugin.finder.report.z.FrZ;
        com.tencent.mm.plugin.finder.report.z.tO(false);
        localObject = com.tencent.mm.plugin.finder.report.z.FrZ;
        com.tencent.mm.plugin.finder.report.z.tN(true);
        localObject = com.tencent.mm.plugin.finder.report.z.FrZ;
        com.tencent.mm.plugin.finder.report.z.f((Context)getContext(), false, false);
      }
      AppMethodBeat.o(349318);
      return;
      i = 0;
      break;
      i = 0;
      break label180;
    }
  }
  
  public final void req2JustWatched()
  {
    AppMethodBeat.i(349296);
    FinderProfileFeedLoader localFinderProfileFeedLoader = getFeedLoader();
    if (localFinderProfileFeedLoader != null) {
      localFinderProfileFeedLoader.req2JustWatched();
    }
    setTopicFilterView();
    AppMethodBeat.o(349296);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$ViewActionCallback;", "Lcom/tencent/mm/plugin/finder/view/FinderRefreshLayout$BaseViewActionCallback;", "rlLayout", "Lcom/tencent/mm/plugin/finder/view/FinderRefreshLayout;", "(Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC;Lcom/tencent/mm/plugin/finder/view/FinderRefreshLayout;)V", "getHeaderCount", "", "updateState", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends FinderRefreshLayout.b
  {
    public b()
    {
      super();
      AppMethodBeat.i(348746);
      AppMethodBeat.o(348746);
    }
    
    public final void evt()
    {
      AppMethodBeat.i(348750);
      com.tencent.mm.ae.d.a(0L, (kotlin.g.a.a)new a(FinderProfileFeedUIC.this, this));
      AppMethodBeat.o(348750);
    }
    
    public final int getHeaderCount()
    {
      AppMethodBeat.i(348757);
      Object localObject = FinderProfileFeedUIC.access$getRecyclerView(FinderProfileFeedUIC.this).getAdapter();
      if ((localObject instanceof WxRecyclerAdapter)) {}
      for (localObject = (WxRecyclerAdapter)localObject; localObject == null; localObject = null)
      {
        AppMethodBeat.o(348757);
        return 0;
      }
      int i = ((i)localObject).agOb.size();
      AppMethodBeat.o(348757);
      return i;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(FinderProfileFeedUIC paramFinderProfileFeedUIC, FinderProfileFeedUIC.b paramb)
      {
        super();
      }
      
      private static final void a(RelativeLayout paramRelativeLayout, FinderProfileFeedUIC paramFinderProfileFeedUIC, View paramView)
      {
        AppMethodBeat.i(348935);
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramRelativeLayout);
        localb.cH(paramFinderProfileFeedUIC);
        localb.cH(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$ViewActionCallback$updateState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
        s.u(paramFinderProfileFeedUIC, "this$0");
        paramView = com.tencent.mm.plugin.finder.report.z.FrZ;
        paramRelativeLayout = paramRelativeLayout.getContext();
        s.s(paramRelativeLayout, "context");
        com.tencent.mm.plugin.finder.report.z.f(paramRelativeLayout, true, false);
        paramRelativeLayout = new StringBuilder();
        h.baC();
        paramRelativeLayout = com.tencent.mm.kernel.b.aZs() + '_' + Util.nowMilliSecond();
        paramView = v.FrN;
        v.aP(13, false);
        paramView = v.FrN;
        v.azR(paramRelativeLayout);
        FinderProfileFeedUIC.access$jumpToSnsAlbumPicker(paramFinderProfileFeedUIC);
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$ViewActionCallback$updateState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(348935);
      }
      
      private static final void a(FinderProfileFeedUIC paramFinderProfileFeedUIC, FinderProfileFeedUIC.b paramb, View paramView)
      {
        AppMethodBeat.i(348942);
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramFinderProfileFeedUIC);
        localb.cH(paramb);
        localb.cH(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$ViewActionCallback$updateState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
        s.u(paramFinderProfileFeedUIC, "this$0");
        s.u(paramb, "this$1");
        FinderProfileFeedUIC.access$getFeedLoader(paramFinderProfileFeedUIC).requestRefresh();
        WxRefreshLayout.c((WxRefreshLayout)paramb.GCb);
        paramb.evt();
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$ViewActionCallback$updateState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(348942);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$ViewActionCallback;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<FinderProfileFeedUIC.b>
  {
    c(FinderProfileFeedUIC paramFinderProfileFeedUIC)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<FinderProfileFeedLoader>
  {
    d(FinderProfileFeedUIC paramFinderProfileFeedUIC)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.profile.a>
  {
    e(FinderProfileFeedUIC paramFinderProfileFeedUIC)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$mHellOnScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recycleView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends RecyclerView.l
  {
    f(FinderProfileFeedUIC paramFinderProfileFeedUIC) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(348809);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$mHellOnScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$mHellOnScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(348809);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(348801);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$mHellOnScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      s.u(paramRecyclerView, "recycleView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager");
        AppMethodBeat.o(348801);
        throw paramRecyclerView;
      }
      paramRecyclerView = ((StaggeredGridLayoutManager)paramRecyclerView).o(null);
      FinderProfileFeedUIC.access$setNowPosition$p(this.FdD, Math.max(paramRecyclerView[0], paramRecyclerView[1]));
      paramRecyclerView = com.tencent.mm.ui.component.k.aeZF;
      paramRecyclerView = (e)com.tencent.mm.ui.component.k.nq((Context)this.FdD.getContext()).q(e.class);
      paramRecyclerView.Fdo = FinderProfileFeedUIC.access$getNowPosition$p(this.FdD);
      paramRecyclerView.eJd();
      ((ce)h.ax(ce.class)).b((RecyclerView)FinderProfileFeedUIC.access$getRecyclerView(this.FdD), q.w.DwP, q.n.Dtx.scene, com.tencent.mm.plugin.finder.live.report.d.Dne);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$mHellOnScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(348801);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "index", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<Integer, ah>
  {
    g(FinderProfileFeedUIC paramFinderProfileFeedUIC)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/autogen/events/FeedStickyEvent;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.b<ie, ah>
  {
    h(FinderProfileFeedUIC paramFinderProfileFeedUIC)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "callback", "Lkotlin/Function0;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.b<kotlin.g.a.a<? extends ah>, ah>
  {
    i(FinderProfileFeedUIC paramFinderProfileFeedUIC)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "respSize", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.b<Integer, ah>
  {
    j(FinderProfileFeedUIC paramFinderProfileFeedUIC)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$2", "Lcom/tencent/mm/view/refreshLayout/listener/OnRefreshAction;", "onLoadMore", "", "onRefresh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    implements com.tencent.mm.view.refreshLayout.d.b
  {
    k(FinderProfileFeedUIC paramFinderProfileFeedUIC) {}
    
    public final void onLoadMore()
    {
      AppMethodBeat.i(348783);
      BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)FinderProfileFeedUIC.access$getFeedLoader(this.FdD), false, 1, null);
      AppMethodBeat.o(348783);
    }
    
    public final void onRefresh() {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$3", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onViewAttachedToWindow", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class l
    extends WxRecyclerAdapter<cc>
  {
    l(FinderProfileFeedUIC paramFinderProfileFeedUIC, com.tencent.mm.view.recyclerview.g paramg, DataBuffer<cc> paramDataBuffer)
    {
      super((ArrayList)paramDataBuffer);
      AppMethodBeat.i(348733);
      AppMethodBeat.o(348733);
    }
    
    public final void v(com.tencent.mm.view.recyclerview.j paramj)
    {
      AppMethodBeat.i(348743);
      s.u(paramj, "holder");
      super.v(paramj);
      Object localObject = paramj.caK.getLayoutParams();
      if ((localObject != null) && ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)))
      {
        localObject = (StaggeredGridLayoutManager.LayoutParams)localObject;
        if (paramj.caO != this.FdD.getFILTER_VIEW_TYPE()) {
          break label67;
        }
      }
      label67:
      for (boolean bool = true;; bool = false)
      {
        ((StaggeredGridLayoutManager.LayoutParams)localObject).cbB = bool;
        AppMethodBeat.o(348743);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$4$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "pos", "", "holder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class m
    implements i.c<com.tencent.mm.view.recyclerview.j>
  {
    m(FinderProfileFeedUIC paramFinderProfileFeedUIC, FinderProfileFeedUIC.l paraml) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "item", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "selected", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements m<bxv, Boolean, ah>
  {
    n(FinderProfileFeedUIC paramFinderProfileFeedUIC)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements kotlin.g.a.a<ah>
  {
    o(FinderProfileFeedUIC paramFinderProfileFeedUIC)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$7", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class p
    implements com.tencent.mm.plugin.finder.feed.model.internal.j
  {
    p(FinderProfileFeedUIC paramFinderProfileFeedUIC) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(348717);
      FinderProfileFeedUIC.access$getActionCallback(this.FdD).evt();
      AppMethodBeat.o(348717);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends u
    implements kotlin.g.a.a<ah>
  {
    q(FinderProfileFeedUIC paramFinderProfileFeedUIC)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "resp", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends u
    implements kotlin.g.a.b<IResponse<cc>, ah>
  {
    r(FinderProfileFeedUIC paramFinderProfileFeedUIC)
    {
      super();
    }
    
    private static final void a(View paramView1, FinderProfileFeedUIC paramFinderProfileFeedUIC, View paramView2)
    {
      AppMethodBeat.i(348719);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramView1);
      localb.cH(paramFinderProfileFeedUIC);
      localb.cH(paramView2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramView1, "$this_apply");
      s.u(paramFinderProfileFeedUIC, "this$0");
      paramView2 = com.tencent.mm.plugin.finder.report.z.FrZ;
      paramView1 = paramView1.getContext();
      s.s(paramView1, "context");
      com.tencent.mm.plugin.finder.report.z.f(paramView1, true, true);
      paramView1 = new StringBuilder();
      h.baC();
      paramView1 = com.tencent.mm.kernel.b.aZs() + '_' + Util.nowMilliSecond();
      paramView2 = v.FrN;
      v.aP(13, false);
      paramView2 = v.FrN;
      v.azR(paramView1);
      FinderProfileFeedUIC.access$jumpToSnsAlbumPicker(paramFinderProfileFeedUIC);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileFeedUIC$onCreate$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(348719);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class s
    extends u
    implements kotlin.g.a.a<WxRecyclerView>
  {
    s(Fragment paramFragment)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/view/FinderRefreshLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class t
    extends u
    implements kotlin.g.a.a<FinderRefreshLayout>
  {
    t(Fragment paramFragment)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.FinderProfileFeedUIC
 * JD-Core Version:    0.7.0.1
 */