package com.tencent.mm.plugin.finder.nearby.live;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.findersdk.receiver.HeadsetReceiver;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.h.e;
import java.util.ArrayList;
import java.util.HashSet;
import kotlin.g.b.aa.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter;", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$Presenter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "by_pass", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Ljava/lang/String;)V", "autoPlayManager", "Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager;", "getBy_pass", "()Ljava/lang/String;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "emptyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderEmptyData;", "feedLoader", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader;)V", "firstAttach", "", "fragment", "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "setFragment", "(Landroidx/fragment/app/Fragment;)V", "initLastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getInitLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setInitLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "isFirstOnResume", "isFirstOnUserVisibleFocused", "isOnResume", "isOnUserVisibleFocused", "isRequestingLbs", "lastOnPauseHasPermission", "lastResponseBuffer", "nearbyRVPositionHelper", "Lcom/tencent/mm/plugin/finder/nearby/base/NearbyRVPositionHelper;", "nextPagePreload", "Lcom/tencent/mm/plugin/finder/nearby/preload/nextpage/NearbyNextPagePreload;", "refreshPullType", "", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "getTabInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "setTabInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;)V", "targetPageForceRefreshFlag", "getTargetPageForceRefreshFlag", "()Z", "setTargetPageForceRefreshFlag", "(Z)V", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "viewActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "viewCallback", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$ViewCallback;)V", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "checkAutoPlay", "checkCache", "invokeSource", "checkEmptyHeader", "r", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "checkPermission", "checkTryRequestFirstPageAgain", "createFeedLoader", "disposeRedDot", "findFirstPosition", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getAutoPlayManager", "getCommentScene", "getFileCacheFlag", "getHeaderInfo", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "getLocalTypeFlag", "getMemoryCacheFlag", "getReportContextObj", "getTabType", "handleRequestNoPermission", "onActionbarClick", "isDouble", "onAttach", "callback", "targetTabPageLastBuffer", "onDetach", "onFinishing", "onLoadMore", "onRefresh", "onRefreshEnd", "reason", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onStart", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "requestFirstPage", "requestLocationPermission", "requestRefresh", "requestRefreshForPermission", "Companion", "plugin-finder-nearby_release"})
public class e
  implements b.a<bu>
{
  public static final a zEu;
  private final MMActivity activity;
  private com.tencent.mm.plugin.finder.model.g emptyData;
  private boolean firstAttach;
  protected Fragment fragment;
  private boolean isRequestingLbs;
  private com.tencent.mm.plugin.finder.nearby.preload.nextpage.a nextPagePreload;
  private final com.tencent.mm.plugin.finder.viewmodel.b tlCache;
  private com.tencent.mm.cd.b xJg;
  protected final bid xbu;
  private int zDT;
  protected bcz zDU;
  private com.tencent.mm.cd.b zDX;
  private final String zDZ;
  boolean zEj;
  public b.b<bu> zEk;
  private com.tencent.mm.plugin.finder.nearby.base.d zEl;
  private com.tencent.mm.plugin.finder.nearby.live.play.c zEm;
  NearbyLiveFeedLoader zEn;
  private com.tencent.mm.view.j zEo;
  private boolean zEp;
  private boolean zEq;
  private boolean zEr;
  private boolean zEs;
  private boolean zEt;
  
  static
  {
    AppMethodBeat.i(203855);
    zEu = new a((byte)0);
    AppMethodBeat.o(203855);
  }
  
  public e(MMActivity paramMMActivity, bid parambid, String paramString)
  {
    AppMethodBeat.i(203849);
    this.activity = paramMMActivity;
    this.xbu = parambid;
    this.zDZ = paramString;
    paramMMActivity = com.tencent.mm.ui.component.g.Xox;
    paramMMActivity = com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.b.class);
    p.j(paramMMActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.tlCache = ((com.tencent.mm.plugin.finder.viewmodel.b)paramMMActivity);
    this.zEo = ((com.tencent.mm.view.j)new l(this));
    this.emptyData = new com.tencent.mm.plugin.finder.model.g();
    this.zEq = true;
    this.zEs = true;
    AppMethodBeat.o(203849);
  }
  
  private final void B(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(203839);
    if ((paramBoolean) && (this.tlCache.OO(dLB())))
    {
      Log.w("Finder.NearbyLivePresenter", "checkAutoPlay " + paramString + " return for checkCache:" + paramBoolean + " memoryCacheFlag:" + dLB());
      AppMethodBeat.o(203839);
      return;
    }
    if (!this.zEr)
    {
      Log.i("Finder.NearbyLivePresenter", "checkAutoPlay " + paramString + " return for isOnResume:" + this.zEr + " memoryCacheFlag:" + dLB());
      AppMethodBeat.o(203839);
      return;
    }
    if (!this.zEp)
    {
      Log.i("Finder.NearbyLivePresenter", "checkAutoPlay " + paramString + " return for isOnUserVisibleFocused:" + this.zEp + " memoryCacheFlag:" + dLB());
      AppMethodBeat.o(203839);
      return;
    }
    Log.i("Finder.NearbyLivePresenter", "checkAutoPlay " + paramString + " memoryCacheFlag:" + dLB());
    paramString = this.zEm;
    if (paramString != null)
    {
      paramString.dLN();
      AppMethodBeat.o(203839);
      return;
    }
    AppMethodBeat.o(203839);
  }
  
  private final void aDz(String paramString)
  {
    AppMethodBeat.i(203846);
    Log.i("Finder.NearbyLivePresenter", "disposeRedDot from ".concat(String.valueOf(paramString)));
    Object localObject = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
    if (com.tencent.mm.plugin.finder.nearby.abtest.a.dLo())
    {
      localObject = this.zDU;
      if ((localObject != null) && (((bcz)localObject).SOa == 88889))
      {
        Log.i("Finder.NearbyLivePresenter", "disposeRedDot from " + paramString + " return for 同城直播.");
        AppMethodBeat.o(203846);
        return;
      }
    }
    localObject = com.tencent.mm.plugin.finder.nearby.live.square.page.a.zGC;
    if (com.tencent.mm.plugin.finder.nearby.live.square.page.a.Ov(getCommentScene()))
    {
      Log.i("Finder.NearbyLivePresenter", "disposeRedDot from " + paramString + " return for in operation game.");
      AppMethodBeat.o(203846);
      return;
    }
    localObject = com.tencent.mm.kernel.h.ag(PluginFinder.class);
    p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)localObject).getRedDotManager().aBd("NearbyLiveTab");
    localObject = com.tencent.mm.kernel.h.ag(PluginFinder.class);
    p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)localObject).getRedDotManager().gW("NearbyLiveTab", paramString);
    AppMethodBeat.o(203846);
  }
  
  private final void checkEmptyHeader(final RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(203825);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this, paramc));
    AppMethodBeat.o(203825);
  }
  
  private int dLA()
  {
    AppMethodBeat.i(203817);
    Object localObject = this.zDU;
    if (localObject != null)
    {
      com.tencent.mm.plugin.finder.nearby.live.square.page.a locala = com.tencent.mm.plugin.finder.nearby.live.square.page.a.zGC;
      getCommentScene();
      i = com.tencent.mm.plugin.finder.nearby.live.square.page.a.Ou(((bcz)localObject).SOa);
      AppMethodBeat.o(203817);
      return i;
    }
    localObject = com.tencent.mm.plugin.finder.nearby.live.square.page.a.zGC;
    getCommentScene();
    int i = com.tencent.mm.plugin.finder.nearby.live.square.page.a.Ou(dLz());
    AppMethodBeat.o(203817);
    return i;
  }
  
  private final NearbyLiveFeedLoader dLC()
  {
    AppMethodBeat.i(203824);
    Object localObject = new aa.a();
    ((aa.a)localObject).aaBx = this.tlCache.OO(dLB());
    Log.i("Finder.NearbyLivePresenter", "createFeedLoader canTimelineRefresh=" + ((aa.a)localObject).aaBx + " memoryCacheFlag:" + dLB());
    NearbyLivePresenter.createFeedLoader.1 local1 = new NearbyLivePresenter.createFeedLoader.1(this, this.xbu, getCommentScene(), getTabType(), dLz(), this.zDZ);
    local1.setInitDone((com.tencent.mm.plugin.finder.feed.model.internal.j)new d(local1, this, (aa.a)localObject));
    local1.fetchEndCallback = ((kotlin.g.a.b)new e(local1, this, (aa.a)localObject));
    localObject = (NearbyLiveFeedLoader)local1;
    AppMethodBeat.o(203824);
    return localObject;
  }
  
  private final void dLD()
  {
    AppMethodBeat.i(203834);
    com.tencent.mm.plugin.finder.nearby.live.base.a locala = com.tencent.mm.plugin.finder.nearby.live.base.a.zEO;
    this.zEt = com.tencent.mm.plugin.finder.nearby.live.base.a.a("checkOnPauseDataIsEmpty", this.zDU, getCommentScene());
    AppMethodBeat.o(203834);
  }
  
  private final void dLE()
  {
    StringBuilder localStringBuilder1 = null;
    StringBuilder localStringBuilder2 = null;
    AppMethodBeat.i(203836);
    Object localObject = this.zDU;
    bcz localbcz;
    if ((localObject == null) || (((bcz)localObject).SOa != 88889))
    {
      localStringBuilder1 = new StringBuilder("shouldTryRequestFirstPageAgain return for tab:");
      localObject = this.zDU;
      if (localObject != null) {}
      for (localObject = Integer.valueOf(((bcz)localObject).SOa);; localObject = null)
      {
        localStringBuilder1 = localStringBuilder1.append(localObject).append('-');
        localbcz = this.zDU;
        localObject = localStringBuilder2;
        if (localbcz != null) {
          localObject = localbcz.SOb;
        }
        Log.i("Finder.NearbyLivePresenter", (String)localObject);
        AppMethodBeat.o(203836);
        return;
      }
    }
    if (!this.zEr)
    {
      Log.i("Finder.NearbyLivePresenter", "shouldTryRequestFirstPageAgain return for isOnResume:" + this.zEr + " memoryCacheFlag:" + dLB());
      AppMethodBeat.o(203836);
      return;
    }
    if (!this.zEp)
    {
      Log.i("Finder.NearbyLivePresenter", "shouldTryRequestFirstPageAgain return for isOnUserVisibleFocused:" + this.zEp + " memoryCacheFlag:" + dLB());
      AppMethodBeat.o(203836);
      return;
    }
    if (this.zEt)
    {
      Log.i("Finder.NearbyLivePresenter", "shouldTryRequestFirstPageAgain return for lastOnPauseHasPermission:" + this.zEt);
      AppMethodBeat.o(203836);
      return;
    }
    localObject = com.tencent.mm.plugin.finder.nearby.live.base.a.zEO;
    if (!com.tencent.mm.plugin.finder.nearby.live.base.a.a("requestFirstPage", this.zDU, getCommentScene()))
    {
      Log.i("Finder.NearbyLivePresenter", "shouldTryRequestFirstPageAgain return for canLoadNearbyCityFeeds.");
      AppMethodBeat.o(203836);
      return;
    }
    localStringBuilder2 = new StringBuilder("shouldTryRequestFirstPageAgain requestInit tab:");
    localObject = this.zDU;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((bcz)localObject).SOa);; localObject = null)
    {
      localStringBuilder2 = localStringBuilder2.append(localObject).append('-');
      localbcz = this.zDU;
      localObject = localStringBuilder1;
      if (localbcz != null) {
        localObject = localbcz.SOb;
      }
      Log.i("Finder.NearbyLivePresenter", (String)localObject);
      localObject = this.zEn;
      if (localObject == null) {
        p.iCn();
      }
      ((NearbyLiveFeedLoader)localObject).a(dLB(), dLA(), this.zDU);
      AppMethodBeat.o(203836);
      return;
    }
  }
  
  public final void KT(long paramLong)
  {
    AppMethodBeat.i(203819);
    Object localObject = com.tencent.mm.plugin.finder.nearby.trace.c.zJD;
    com.tencent.mm.plugin.finder.nearby.trace.c.dMD().aGV("startFetchLives");
    localObject = this.zEk;
    if (localObject == null) {
      p.bGy("viewCallback");
    }
    localObject = ((b.b)localObject).dtq();
    ((RefreshLoadMoreLayout)localObject).postDelayed((Runnable)new b((RefreshLoadMoreLayout)localObject), paramLong);
    AppMethodBeat.o(203819);
  }
  
  public final void a(b.b<bu> paramb)
  {
    AppMethodBeat.i(203820);
    p.k(paramb, "callback");
    a(paramb, false, null);
    AppMethodBeat.o(203820);
  }
  
  public final void a(b.b<bu> paramb, boolean paramBoolean, com.tencent.mm.cd.b paramb1)
  {
    int i = 0;
    AppMethodBeat.i(203822);
    p.k(paramb, "callback");
    Log.i("Finder.NearbyLivePresenter", "onAttach targetPageForceRefreshFlag:" + paramBoolean + " targetTabPageLastBuffer:" + paramb1);
    this.zEn = dLC();
    this.xJg = paramb1;
    this.zEj = paramBoolean;
    if (paramBoolean)
    {
      new com.tencent.mm.plugin.finder.nearby.preload.cache.a();
      com.tencent.mm.plugin.finder.nearby.preload.cache.a.OA(dLB());
    }
    this.zEk = paramb;
    paramb = this.zEk;
    if (paramb == null) {
      p.bGy("viewCallback");
    }
    paramb1 = this.zEn;
    if (paramb1 == null) {
      p.iCn();
    }
    paramb.ab((ArrayList)paramb1.getDataListJustForAdapter());
    paramb = this.zEn;
    if (paramb != null) {
      paramb.register(this.zEo);
    }
    paramb = this.zEk;
    if (paramb == null) {
      p.bGy("viewCallback");
    }
    paramb = paramb.getRecyclerView();
    if (paramb != null)
    {
      paramb.a((RecyclerView.l)new g(this));
      paramb1 = com.tencent.mm.plugin.finder.nearby.report.a.zIZ;
      com.tencent.mm.plugin.finder.nearby.report.a.OD(this.xbu.xkX);
      paramb1 = (Context)this.activity;
      Object localObject = this.zEn;
      if (localObject == null) {
        p.iCn();
      }
      localObject = (ArrayList)((NearbyLiveFeedLoader)localObject).getDataListJustForAdapter();
      bcz localbcz = this.zDU;
      if (localbcz != null) {}
      for (paramBoolean = localbcz.SOf;; paramBoolean = false)
      {
        localbcz = this.zDU;
        if (localbcz != null) {
          i = localbcz.SOa;
        }
        this.zEm = new com.tencent.mm.plugin.finder.nearby.live.play.c(paramb1, paramb, (ArrayList)localObject, paramBoolean, i);
        paramb1 = this.zEm;
        if (paramb1 != null) {
          paramb1.lT();
        }
        paramb1 = com.tencent.mm.ui.component.g.Xox;
        ((com.tencent.mm.plugin.finder.nearby.live.play.f)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.nearby.live.play.f.class)).a((AppCompatActivity)this.activity);
        if (!(paramb.getAdapter() instanceof WxRecyclerAdapter)) {
          break label399;
        }
        paramb = paramb.getAdapter();
        if (paramb != null) {
          break;
        }
        paramb = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerAdapter<*>");
        AppMethodBeat.o(203822);
        throw paramb;
      }
      paramb1 = (WxRecyclerAdapter)paramb;
      paramb = this.zEm;
      if (paramb == null) {
        break label552;
      }
    }
    label399:
    label552:
    for (paramb = paramb.zFk;; paramb = null)
    {
      paramb1.YSo = ((h.e)paramb);
      paramb = this.zEk;
      if (paramb == null) {
        p.bGy("viewCallback");
      }
      if ((paramb.getRecyclerView() != null) && (this.zEn != null))
      {
        paramb = this.zEk;
        if (paramb == null) {
          p.bGy("viewCallback");
        }
        paramb = paramb.getRecyclerView();
        if (paramb == null) {
          p.iCn();
        }
        paramb1 = this.zEn;
        if (paramb1 == null) {
          p.iCn();
        }
        this.nextPagePreload = new com.tencent.mm.plugin.finder.nearby.preload.nextpage.a(paramb, (BaseFeedLoader)paramb1, this.zDU, getCommentScene());
        paramb = this.zEk;
        if (paramb == null) {
          p.bGy("viewCallback");
        }
        paramb = paramb.getRecyclerView();
        if (paramb == null) {
          p.iCn();
        }
        this.zEl = new com.tencent.mm.plugin.finder.nearby.base.d(paramb);
      }
      dLD();
      this.firstAttach = true;
      AppMethodBeat.o(203822);
      return;
    }
  }
  
  public final int dLB()
  {
    AppMethodBeat.i(203818);
    Object localObject = this.zDU;
    if (localObject != null)
    {
      com.tencent.mm.plugin.finder.nearby.live.square.page.a locala = com.tencent.mm.plugin.finder.nearby.live.square.page.a.zGC;
      getCommentScene();
      i = com.tencent.mm.plugin.finder.nearby.live.square.page.a.Ou(((bcz)localObject).SOa);
      AppMethodBeat.o(203818);
      return i;
    }
    localObject = com.tencent.mm.plugin.finder.nearby.live.square.page.a.zGC;
    getCommentScene();
    int i = com.tencent.mm.plugin.finder.nearby.live.square.page.a.Ou(dLz());
    AppMethodBeat.o(203818);
    return i;
  }
  
  public final com.tencent.mm.plugin.finder.nearby.live.play.c dLx()
  {
    return this.zEm;
  }
  
  public final b.b<bu> dLy()
  {
    AppMethodBeat.i(203784);
    b.b localb = this.zEk;
    if (localb == null) {
      p.bGy("viewCallback");
    }
    AppMethodBeat.o(203784);
    return localb;
  }
  
  protected int dLz()
  {
    return 15;
  }
  
  public int getCommentScene()
  {
    return 76;
  }
  
  protected int getTabType()
  {
    return 1001;
  }
  
  public final void onActionbarClick(boolean paramBoolean)
  {
    AppMethodBeat.i(203808);
    Object localObject1 = this.zEk;
    if (localObject1 == null) {
      p.bGy("viewCallback");
    }
    localObject1 = ((b.b)localObject1).getRecyclerView();
    if (localObject1 == null)
    {
      AppMethodBeat.o(203808);
      return;
    }
    Object localObject2 = ((RecyclerView)localObject1).getLayoutManager();
    int i;
    if ((localObject2 instanceof StaggeredGridLayoutManager))
    {
      int[] arrayOfInt = new int[2];
      ((StaggeredGridLayoutManager)localObject2).k(arrayOfInt);
      i = arrayOfInt[0];
      Log.i("Finder.TimelineLbsPresenter", "[onActionbarClick] position=" + i + " isDouble=" + paramBoolean);
      if (!paramBoolean) {
        break label328;
      }
      if (i > 12) {
        break label240;
      }
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
      ((RecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
    }
    for (;;)
    {
      if (i > 12) {
        break label321;
      }
      KT(20L);
      AppMethodBeat.o(203808);
      return;
      if ((localObject2 instanceof LinearLayoutManager))
      {
        i = ((LinearLayoutManager)localObject2).kJ();
        break;
      }
      i = 0;
      break;
      label240:
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject1).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
    }
    label321:
    KT(600L);
    label328:
    AppMethodBeat.o(203808);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(203823);
    Object localObject = this.zEn;
    if (localObject != null) {
      ((NearbyLiveFeedLoader)localObject).unregister(this.zEo);
    }
    localObject = this.zEn;
    if (localObject == null) {
      p.iCn();
    }
    if (((NearbyLiveFeedLoader)localObject).getDataListJustForAdapter().size() > 0)
    {
      localObject = com.tencent.mm.ui.component.g.Xox;
      ((com.tencent.mm.plugin.finder.viewmodel.b)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.b.class)).RH(dLB());
    }
    localObject = this.zEm;
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.finder.nearby.live.play.c)localObject).dLP();
      ((com.tencent.mm.plugin.finder.nearby.live.play.c)localObject).zFm.clear();
      ((com.tencent.mm.plugin.finder.nearby.live.play.c)localObject).zFi.gd(((com.tencent.mm.plugin.finder.nearby.live.play.c)localObject).context);
    }
    this.firstAttach = false;
    AppMethodBeat.o(203823);
  }
  
  public final void onFinishing()
  {
    AppMethodBeat.i(203804);
    Object localObject = this.zEl;
    int i;
    if (localObject != null)
    {
      i = ((com.tencent.mm.plugin.finder.nearby.base.d)localObject).position;
      localObject = this.zEl;
      if (localObject == null) {
        break label197;
      }
    }
    label197:
    for (int j = ((com.tencent.mm.plugin.finder.nearby.base.d)localObject).offset;; j = 0)
    {
      localObject = this.zEn;
      if (localObject == null) {
        p.iCn();
      }
      int k = ((NearbyLiveFeedLoader)localObject).getDataListJustForAdapter().size();
      int m = dLB();
      Log.i("Finder.NearbyLivePresenter", "[onFinishing] memoryCacheFlag:" + m + " position:" + i + " offset:" + j + " size:" + k + " lastBuffer:" + this.zDX);
      if (k > 0)
      {
        localObject = this.tlCache;
        NearbyLiveFeedLoader localNearbyLiveFeedLoader = this.zEn;
        if (localNearbyLiveFeedLoader == null) {
          p.iCn();
        }
        com.tencent.mm.plugin.finder.viewmodel.b.a((com.tencent.mm.plugin.finder.viewmodel.b)localObject, m, i, j, (ArrayList)localNearbyLiveFeedLoader.getDataListJustForAdapter(), null, this.zDX, false, 80);
      }
      AppMethodBeat.o(203804);
      return;
      i = 0;
      break;
    }
  }
  
  public final void onLoadMore()
  {
    AppMethodBeat.i(203797);
    Object localObject = this.nextPagePreload;
    if ((localObject != null) && (((com.tencent.mm.plugin.finder.nearby.preload.nextpage.a)localObject).rHi == true))
    {
      Log.i("Finder.NearbyLivePresenter", "onLoadMore return for is preloading.");
      AppMethodBeat.o(203797);
      return;
    }
    localObject = this.zEn;
    if (localObject != null)
    {
      ((NearbyLiveFeedLoader)localObject).a(this.zDU);
      AppMethodBeat.o(203797);
      return;
    }
    AppMethodBeat.o(203797);
  }
  
  public final void onRefresh()
  {
    AppMethodBeat.i(203789);
    Object localObject = this.zDU;
    if ((localObject != null) && (((bcz)localObject).SOa == 88889))
    {
      localObject = com.tencent.mm.plugin.finder.utils.q.ADH;
      com.tencent.mm.plugin.finder.utils.q.a((kotlin.g.a.a)new i(this), (kotlin.g.a.a)new j(this), (kotlin.g.a.a)new k(this));
      AppMethodBeat.o(203789);
      return;
    }
    requestRefresh();
    AppMethodBeat.o(203789);
  }
  
  public void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(203795);
    p.k(paramc, "reason");
    Object localObject = com.tencent.mm.plugin.finder.nearby.trace.c.zJD;
    com.tencent.mm.plugin.finder.nearby.trace.c.dMD().fp("onRefreshEnd");
    localObject = com.tencent.mm.plugin.finder.nearby.trace.b.zJB;
    localObject = com.tencent.mm.plugin.finder.nearby.trace.b.a.OL(dLB());
    ((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).zJz = System.currentTimeMillis();
    Log.i("NearbyTimeConsumingHelper-" + ((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).fEH, "onVisible->onRefreshEnd:" + (((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).zJz - ((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).zJt) + " \nonAttach->startFetch:" + (((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).zJu - ((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).zJt) + " \nstartFetch->startCgi:" + (((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).zJv - ((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).zJu) + " \nstartCgi->onCgiBack:" + (((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).zJw - ((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).zJv) + " \nonCgiBack->onFetchDone:" + (((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).zJx - ((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).zJw) + " \nonFetchDone->onViewUpdate:" + (((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).zJy - ((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).zJx) + " \nonViewUpdate->onRefreshEnd:" + (((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).zJz - ((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).zJy));
    ((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).zJt = 0L;
    ((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).zJu = 0L;
    ((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).zJv = 0L;
    ((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).zJw = 0L;
    ((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).zJx = 0L;
    ((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).zJy = 0L;
    ((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).zJz = 0L;
    if (paramc.YNG <= 0)
    {
      localObject = this.zEk;
      if (localObject == null) {
        p.bGy("viewCallback");
      }
      ((b.b)localObject).dtq().c(0L, (kotlin.g.a.a)h.zEC);
    }
    if (paramc.YNF)
    {
      localObject = this.zEk;
      if (localObject == null) {
        p.bGy("viewCallback");
      }
      localObject = ((b.b)localObject).dtq();
      if (localObject == null) {
        break label633;
      }
      localObject = Boolean.valueOf(((RefreshLoadMoreLayout)localObject).YNq);
      if (!((Boolean)localObject).booleanValue())
      {
        localObject = this.zEk;
        if (localObject == null) {
          p.bGy("viewCallback");
        }
        localObject = ((b.b)localObject).dtq();
        if (localObject != null) {
          ((RefreshLoadMoreLayout)localObject).setHasBottomMore(true);
        }
        localObject = this.zEk;
        if (localObject == null) {
          p.bGy("viewCallback");
        }
        localObject = ((b.b)localObject).dtq();
        if (localObject != null)
        {
          localObject = ((RefreshLoadMoreLayout)localObject).getLoadMoreFooter();
          if (localObject != null)
          {
            localObject = (TextView)((View)localObject).findViewById(a.g.load_more_footer_tip_tv);
            if (localObject != null) {
              ((TextView)localObject).setVisibility(0);
            }
          }
        }
        localObject = this.zEk;
        if (localObject == null) {
          p.bGy("viewCallback");
        }
        localObject = ((b.b)localObject).dtq();
        if (localObject != null)
        {
          localObject = ((RefreshLoadMoreLayout)localObject).getLoadMoreFooter();
          if (localObject != null)
          {
            localObject = ((View)localObject).findViewById(a.g.load_more_footer_end_layout);
            if (localObject != null) {
              ((View)localObject).setVisibility(8);
            }
          }
        }
      }
      localObject = this.zEk;
      if (localObject == null) {
        p.bGy("viewCallback");
      }
      localObject = ((b.b)localObject).dtq();
      if (localObject == null) {
        break label638;
      }
    }
    label633:
    label638:
    for (localObject = Boolean.valueOf(((RefreshLoadMoreLayout)localObject).getEnableLoadMore());; localObject = null)
    {
      if (!((Boolean)localObject).booleanValue())
      {
        localObject = this.zEk;
        if (localObject == null) {
          p.bGy("viewCallback");
        }
        localObject = ((b.b)localObject).dtq();
        if (localObject != null) {
          ((RefreshLoadMoreLayout)localObject).setEnableLoadMore(true);
        }
        localObject = this.zEk;
        if (localObject == null) {
          p.bGy("viewCallback");
        }
        localObject = ((b.b)localObject).dtq();
        if (localObject != null)
        {
          View localView = ad.kS((Context)this.activity).inflate(b.g.load_more_footer, null);
          p.j(localView, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
          ((RefreshLoadMoreLayout)localObject).setLoadMoreFooter(localView);
        }
      }
      checkEmptyHeader(paramc);
      aDz("onRefreshEnd");
      localObject = this.nextPagePreload;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.nearby.preload.nextpage.a)localObject).pT(paramc.YNF);
      }
      B(false, "onRefreshEnd");
      AppMethodBeat.o(203795);
      return;
      localObject = null;
      break;
    }
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(203844);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    Log.i("Finder.NearbyLivePresenter", "onRequestPermissionsResult requestCode:" + paramInt + " grantResults[0]:" + paramArrayOfInt[0]);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(203844);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        dLE();
        AppMethodBeat.o(203844);
        return;
      }
      Log.i("Finder.NearbyLivePresenter", "onRequestPermissionsResult return for grant.");
    }
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(203831);
    this.zEr = true;
    Log.i("Finder.NearbyLivePresenter", "onStart memoryCacheFlag:" + dLB());
    if (!this.zEs) {
      dLE();
    }
    B(this.zEs, "onStart");
    this.zEs = false;
    AppMethodBeat.o(203831);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(203833);
    this.zEr = false;
    Log.i("Finder.NearbyLivePresenter", "onStop memoryCacheFlag:" + dLB());
    com.tencent.mm.plugin.finder.nearby.live.play.c localc = this.zEm;
    if (localc != null) {
      localc.zFm.clear();
    }
    localc = this.zEm;
    if (localc != null) {
      localc.dLP();
    }
    dLD();
    AppMethodBeat.o(203833);
  }
  
  public final void onUserVisibleFocused()
  {
    Object localObject2 = null;
    AppMethodBeat.i(203827);
    Log.i("Finder.NearbyLivePresenter", "onUserVisibleFocused memoryCacheFlag:" + dLB());
    this.zEp = true;
    Object localObject1 = com.tencent.mm.plugin.finder.nearby.trace.b.zJB;
    com.tencent.mm.plugin.finder.nearby.trace.b.a.OL(dLB()).zJt = System.currentTimeMillis();
    if (this.zEq)
    {
      localObject1 = com.tencent.mm.plugin.finder.nearby.live.base.a.zEO;
      if (!com.tencent.mm.plugin.finder.nearby.live.base.a.a("requestFirstPage", this.zDU, getCommentScene())) {
        break label262;
      }
      localObject1 = this.zEn;
      if (localObject1 == null) {
        p.iCn();
      }
      ((NearbyLiveFeedLoader)localObject1).a(dLB(), dLA(), this.zDU);
    }
    bid localbid;
    bcz localbcz;
    label161:
    label239:
    do
    {
      localObject1 = com.tencent.mm.plugin.finder.nearby.preload.a.zIv;
      localbid = this.xbu;
      localbcz = this.zDU;
      p.k(localbid, "contextObj");
      StringBuilder localStringBuilder = new StringBuilder("onEnterLiveSquareTabPage tab:[");
      if (localbcz == null) {
        break;
      }
      localObject1 = Integer.valueOf(localbcz.SOa);
      localStringBuilder = localStringBuilder.append(localObject1).append(", ");
      localObject1 = localObject2;
      if (localbcz != null) {
        localObject1 = localbcz.SOb;
      }
      Log.i("NearbyPreloadManager", (String)localObject1 + ']');
      if (com.tencent.mm.plugin.finder.nearby.preload.a.dMn()) {
        break label511;
      }
      Log.w("NearbyPreloadManager", "onEnterLiveSquareTabPage return for enableNearbyLivePagesPreload:" + com.tencent.mm.plugin.finder.nearby.preload.a.dMn());
      B(this.zEq, "onUserVisibleFocused");
      this.zEq = false;
      AppMethodBeat.o(203827);
      return;
      localObject1 = new RefreshLoadMoreLayout.c(0);
      ((RefreshLoadMoreLayout.c)localObject1).YND = -2;
      checkEmptyHeader((RefreshLoadMoreLayout.c)localObject1);
      localObject1 = this.zDU;
    } while ((localObject1 == null) || (((bcz)localObject1).SOa != 88889));
    label262:
    localObject1 = com.tencent.mm.kernel.h.aHG();
    p.j(localObject1, "MMKernel.storage()");
    localObject1 = ((com.tencent.mm.kernel.f)localObject1).aHp().get(274436);
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(203827);
      throw ((Throwable)localObject1);
    }
    boolean bool;
    if (com.tencent.mm.az.b.WF((String)localObject1))
    {
      bool = com.tencent.mm.pluginsdk.permission.b.o((Context)this.activity, "android.permission.ACCESS_FINE_LOCATION");
      if (bool) {
        break label628;
      }
      localObject1 = com.tencent.mm.kernel.h.aHG();
      p.j(localObject1, "MMKernel.storage()");
      if (!((com.tencent.mm.kernel.f)localObject1).aHp().getBoolean(ar.a.VvE, false)) {
        com.tencent.mm.plugin.account.sdk.b.a.b((Context)this.activity, this.activity.getString(b.j.location_use_scene_gdpr_url, new Object[] { LocaleUtil.getApplicationLanguage() }), 30764, true);
      }
    }
    label628:
    for (;;)
    {
      Log.i("Finder.NearbyLivePresenter", "requestLocationPermission checkLocation:".concat(String.valueOf(bool)));
      break;
      com.tencent.mm.pluginsdk.permission.b.b((Activity)this.activity, "android.permission.ACCESS_FINE_LOCATION", 153);
      continue;
      bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)this.activity, new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 153, null, null);
      continue;
      localObject1 = null;
      break label161;
      label511:
      if (localbcz != null)
      {
        Log.i("NearbyPreloadManager", "onEnterLiveSquareTabPage startPreload preTab:" + localbcz.SOe + " nextTab:" + localbcz.SOd);
        if (localbcz.SOd)
        {
          localObject1 = com.tencent.mm.plugin.finder.nearby.preload.a.zIv;
          com.tencent.mm.plugin.finder.nearby.preload.a.a(localbid, com.tencent.mm.plugin.finder.nearby.preload.a.b(localbcz, com.tencent.mm.plugin.finder.nearby.preload.a.zIs), "preloadNextTab");
        }
        if (!localbcz.SOe) {
          break label239;
        }
        localObject1 = com.tencent.mm.plugin.finder.nearby.preload.a.zIv;
        com.tencent.mm.plugin.finder.nearby.preload.a.a(localbid, com.tencent.mm.plugin.finder.nearby.preload.a.a(localbcz, com.tencent.mm.plugin.finder.nearby.preload.a.zIs), "preloadPreTab");
        break label239;
      }
      Log.w("NearbyPreloadManager", "onEnterLiveSquareTabPage return for null");
      break label239;
    }
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(203829);
    Log.i("Finder.NearbyLivePresenter", "onUserVisibleUnFocused memoryCacheFlag:" + dLB());
    this.zEp = false;
    com.tencent.mm.plugin.finder.nearby.live.play.c localc = this.zEm;
    if (localc != null) {
      localc.zFm.clear();
    }
    localc = this.zEm;
    if (localc != null)
    {
      localc.dLP();
      AppMethodBeat.o(203829);
      return;
    }
    AppMethodBeat.o(203829);
  }
  
  protected final void requestRefresh()
  {
    AppMethodBeat.i(203816);
    Log.i("Finder.NearbyLivePresenter", "requestRefresh");
    NearbyLiveFeedLoader localNearbyLiveFeedLoader = this.zEn;
    if (localNearbyLiveFeedLoader == null) {
      p.iCn();
    }
    localNearbyLiveFeedLoader.a(this.zDU, this.zDT, this.xJg, this.zEj);
    this.zDT = 1;
    this.zEj = false;
    this.xJg = null;
    AppMethodBeat.o(203816);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(RefreshLoadMoreLayout paramRefreshLoadMoreLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(199723);
      this.$rlLayout.Id(this.$isSilence);
      AppMethodBeat.o(199723);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    c(e parame, RefreshLoadMoreLayout.c paramc)
    {
      super();
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$checkEmptyHeader$1$1$1$1", "com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$checkEmptyHeader$1$$special$$inlined$let$lambda$1"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(bcz parambcz1, bcz parambcz2, e.c paramc, RefreshLoadMoreLayout.c paramc1)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$createFeedLoader$2$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder-nearby_release"})
  public static final class d
    implements com.tencent.mm.plugin.finder.feed.model.internal.j
  {
    d(NearbyLivePresenter.createFeedLoader.1 param1, e parame, aa.a parama) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(201971);
      this.zEA.aaBx = e.c(jdField_this).OO(jdField_this.dLB());
      Log.i("Finder.NearbyLivePresenter", "[initData] canTimelineRefresh=" + this.zEA.aaBx + " targetPageForceRefreshFlag:" + jdField_this.zEj + ", incrementCount=" + paramInt + " memoryCacheFlag:" + jdField_this.dLB());
      if ((this.zEA.aaBx) || (jdField_this.zEj))
      {
        e.a(jdField_this, 0);
        jdField_this.KT(0L);
      }
      for (;;)
      {
        Object localObject = e.f(jdField_this);
        if (localObject == null) {
          break;
        }
        ((com.tencent.mm.plugin.finder.nearby.preload.nextpage.a)localObject).zIU = true;
        AppMethodBeat.o(201971);
        return;
        e.a(jdField_this, 1);
        com.tencent.mm.plugin.finder.viewmodel.b.a locala = e.c(jdField_this).RI(jdField_this.dLB());
        final int i = locala.Bgy;
        final int j = locala.Bgz;
        Log.i(this.zEz.getTAG(), "[initData] canTimelineRefresh " + this.zEA.aaBx + " fromPreload:" + locala.BgC + " lastPos=" + i + " fromTopPixel=" + j);
        localObject = e.d(jdField_this);
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.finder.nearby.base.d)localObject).position = i;
          ((com.tencent.mm.plugin.finder.nearby.base.d)localObject).offset = j;
        }
        RecyclerView localRecyclerView = jdField_this.dLy().getRecyclerView();
        if (localRecyclerView != null) {}
        for (localObject = localRecyclerView.getLayoutManager();; localObject = null)
        {
          if ((localObject instanceof StaggeredGridLayoutManager))
          {
            ((StaggeredGridLayoutManager)localObject).au(i, j);
            localRecyclerView.post((Runnable)new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(199905);
                ((StaggeredGridLayoutManager)this.$layoutManager).au(i, j);
                e.a(this.zEB.zEv, "IInitDone");
                AppMethodBeat.o(199905);
              }
            });
          }
          if (paramInt <= 0) {
            e.e(jdField_this);
          }
          if (!locala.BgC) {
            break label400;
          }
          e.b(jdField_this, "fromPreload");
          localObject = com.tencent.mm.plugin.finder.nearby.trace.c.zJD;
          com.tencent.mm.plugin.finder.nearby.trace.c.dMD().fp("onHitPreloadEnd");
          break;
        }
        label400:
        localObject = com.tencent.mm.plugin.finder.nearby.trace.c.zJD;
        com.tencent.mm.plugin.finder.nearby.trace.c.dMD().fp("onHitCache");
      }
      AppMethodBeat.o(201971);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$createFeedLoader$2$2"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.b<IResponse<bu>, x>
  {
    e(NearbyLivePresenter.createFeedLoader.1 param1, e parame, aa.a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(199401);
      RefreshLoadMoreLayout.c localc = new RefreshLoadMoreLayout.c(0);
      localc.YND = -2;
      this.zEv.dLy().dtq().j(localc);
      AppMethodBeat.o(199401);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$onAttach$1$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder-nearby_release"})
  public static final class g
    extends RecyclerView.l
  {
    g(e parame) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(201116);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$onAttach$$inlined$let$lambda$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$onAttach$$inlined$let$lambda$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(201116);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201112);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$onAttach$$inlined$let$lambda$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      localObject = k.yBj;
      k.a(paramRecyclerView, s.t.yGN, String.valueOf(this.zEv.getCommentScene()), com.tencent.mm.plugin.finder.live.report.c.yAh, -100, -100);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$onAttach$$inlined$let$lambda$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(201112);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final h zEC;
    
    static
    {
      AppMethodBeat.i(201029);
      zEC = new h();
      AppMethodBeat.o(201029);
    }
    
    h()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    i(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    j(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    k(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$viewActionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder-nearby_release"})
  public static final class l
    implements com.tencent.mm.view.j
  {
    private WxRecyclerAdapter<?> getAdapter()
    {
      AppMethodBeat.i(200436);
      Object localObject1 = this.zEv.dLy().getRecyclerView();
      if (localObject1 != null) {}
      for (localObject1 = ((RecyclerView)localObject1).getAdapter();; localObject1 = null)
      {
        Object localObject2 = localObject1;
        if (!(localObject1 instanceof WxRecyclerAdapter)) {
          localObject2 = null;
        }
        localObject1 = (WxRecyclerAdapter)localObject2;
        AppMethodBeat.o(200436);
        return localObject1;
      }
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(200437);
      Object localObject = this.zEv.dLy();
      if (localObject != null)
      {
        localObject = ((b.b)localObject).dtq();
        if (localObject != null) {
          ((RefreshLoadMoreLayout)localObject).onChanged();
        }
      }
      localObject = com.tencent.mm.plugin.finder.nearby.preload.a.zIv;
      com.tencent.mm.plugin.finder.nearby.preload.a.a(this.zEv.xbu, this.zEv.zDU);
      localObject = com.tencent.mm.plugin.finder.nearby.trace.b.zJB;
      com.tencent.mm.plugin.finder.nearby.trace.b.a.OL(this.zEv.dLB()).zJy = System.currentTimeMillis();
      localObject = com.tencent.mm.plugin.finder.nearby.trace.c.zJD;
      com.tencent.mm.plugin.finder.nearby.trace.c.dMD().aGV("recyclerOnChange");
      AppMethodBeat.o(200437);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(200438);
      Object localObject = this.zEv.dLy();
      if (localObject != null)
      {
        localObject = ((b.b)localObject).dtq();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.YSk.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).onItemRangeChanged(i + paramInt1, paramInt2);
            AppMethodBeat.o(200438);
            return;
          }
        }
      }
      AppMethodBeat.o(200438);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(200439);
      Object localObject = this.zEv.dLy();
      if (localObject != null)
      {
        localObject = ((b.b)localObject).dtq();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.YSk.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).onItemRangeChanged(i + paramInt1, paramInt2, paramObject);
            AppMethodBeat.o(200439);
            return;
          }
        }
      }
      AppMethodBeat.o(200439);
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(200441);
      Object localObject = this.zEv.dLy();
      WxRecyclerAdapter localWxRecyclerAdapter;
      if (localObject != null)
      {
        localObject = ((b.b)localObject).dtq();
        if (localObject != null)
        {
          localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter == null) {
            break label124;
          }
        }
      }
      label124:
      for (int i = localWxRecyclerAdapter.YSk.size();; i = 0)
      {
        ((RefreshLoadMoreLayout)localObject).onItemRangeInserted(i + paramInt1, paramInt2);
        localObject = com.tencent.mm.plugin.finder.nearby.preload.a.zIv;
        com.tencent.mm.plugin.finder.nearby.preload.a.a(this.zEv.xbu, this.zEv.zDU);
        localObject = com.tencent.mm.plugin.finder.nearby.trace.b.zJB;
        com.tencent.mm.plugin.finder.nearby.trace.b.a.OL(this.zEv.dLB()).zJy = System.currentTimeMillis();
        localObject = com.tencent.mm.plugin.finder.nearby.trace.c.zJD;
        com.tencent.mm.plugin.finder.nearby.trace.c.dMD().aGV("recyclerOnInsert");
        AppMethodBeat.o(200441);
        return;
      }
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(200446);
      Object localObject = this.zEv.dLy();
      if (localObject != null)
      {
        localObject = ((b.b)localObject).dtq();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.YSk.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).onItemRangeRemoved(i + paramInt1, paramInt2);
            AppMethodBeat.o(200446);
            return;
          }
        }
      }
      AppMethodBeat.o(200446);
    }
    
    public final void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(200449);
      p.k(paramc, "reason");
      this.zEv.dLy().dtq().onPreFinishLoadMore(paramc);
      AppMethodBeat.o(200449);
    }
    
    public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(200454);
      p.k(paramc, "reason");
      this.zEv.dLy().dtq().onPreFinishLoadMoreSmooth(paramc);
      com.tencent.mm.plugin.finder.nearby.preload.nextpage.a locala = e.f(this.zEv);
      if (locala != null)
      {
        locala.pT(paramc.YNF);
        AppMethodBeat.o(200454);
        return;
      }
      AppMethodBeat.o(200454);
    }
    
    public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(200447);
      p.k(paramc, "reason");
      this.zEv.dLy().dtq().onPreFinishRefresh(paramc);
      AppMethodBeat.o(200447);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.e
 * JD-Core Version:    0.7.0.1
 */