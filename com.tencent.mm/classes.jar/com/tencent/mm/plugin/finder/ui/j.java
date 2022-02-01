package com.tencent.mm.plugin.finder.ui;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.jm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.cgi.bh;
import com.tencent.mm.plugin.finder.convert.bu;
import com.tencent.mm.plugin.finder.convert.q;
import com.tencent.mm.plugin.finder.convert.t;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.ae.a;
import com.tencent.mm.plugin.finder.feed.ae.b;
import com.tencent.mm.plugin.finder.feed.b.a;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.bg;
import com.tencent.mm.plugin.finder.feed.i;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedShareRelativeListLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ak;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.model.v;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.video.l;
import com.tencent.mm.plugin.finder.view.ContactUninterestEventListener;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.ac;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.RefreshLoadMoreLayout.k;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.an;
import kotlin.g.b.u;
import kotlin.n.n;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/ShareRelPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter;", "scene", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "safeMode", "", "tabType", "isPreview", "(ILcom/tencent/mm/ui/MMActivity;ZIZ)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "contactUninterestListener", "Lcom/tencent/mm/plugin/finder/view/ContactUninterestEventListener;", "feedProgressListener", "com/tencent/mm/plugin/finder/ui/ShareRelPresenter$feedProgressListener$1", "Lcom/tencent/mm/plugin/finder/ui/ShareRelPresenter$feedProgressListener$1;", "isAllFeedShowAdFollowBtn", "()Z", "setAllFeedShowAdFollowBtn", "(Z)V", "setPreview", "mCommentScene", "mFeedId", "", "Ljava/lang/Long;", "mIsFirstNoInterest", "getMIsFirstNoInterest", "setMIsFirstNoInterest", "mNoInterestFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "mNoInterestPosition", "onBindMoreConvert", "Lkotlin/Function1;", "Landroid/view/View;", "", "getOnBindMoreConvert", "()Lkotlin/jvm/functions/Function1;", "setOnBindMoreConvert", "(Lkotlin/jvm/functions/Function1;)V", "shareGuideEventListenerList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderShareGuideShowEvent;", "getShareGuideEventListenerList", "()Ljava/util/LinkedList;", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "consumeBackPressed", "createFirstMenu", "feed", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "from", "createSecondMenu", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "handleNoInterest", "index", "isSelf", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "onFollow", "isFollow", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshEnd", "setAllFeedShowBigAdFollowBtn", "setCommentScene", "setFeedId", "id", "smoothScrollToNextPosition", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends com.tencent.mm.plugin.finder.feed.j.a
{
  private ContactUninterestEventListener AYg;
  kotlin.g.a.b<? super View, kotlin.ah> FVS;
  final LinkedList<IListener<jm>> FVT;
  Long FVU;
  int FVV;
  private int FVW;
  private BaseFinderFeed FVX;
  boolean FVY;
  public boolean FVZ;
  private final ShareRelPresenter.feedProgressListener.1 FWa;
  String TAG;
  boolean isPreview;
  
  public j(int paramInt1, MMActivity paramMMActivity, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    super(paramInt1, paramMMActivity, paramBoolean1, paramInt2, (byte)0);
    AppMethodBeat.i(346388);
    this.isPreview = paramBoolean2;
    this.TAG = "Finder.FinderShareFeedDetailUI";
    this.FVT = new LinkedList();
    this.FVU = Long.valueOf(0L);
    this.FVW = -1;
    this.FWa = new ShareRelPresenter.feedProgressListener.1(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(346388);
  }
  
  private static final void a(j paramj)
  {
    AppMethodBeat.i(346405);
    kotlin.g.b.s.u(paramj, "this$0");
    com.tencent.mm.plugin.finder.report.s locals = com.tencent.mm.plugin.finder.report.s.Fqv;
    com.tencent.mm.plugin.finder.report.s.Ss(paramj.hJx);
    AppMethodBeat.o(346405);
  }
  
  private static boolean e(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(346397);
    paramBaseFinderFeed = paramBaseFinderFeed.contact;
    if (paramBaseFinderFeed == null) {}
    for (paramBaseFinderFeed = null;; paramBaseFinderFeed = paramBaseFinderFeed.field_username)
    {
      boolean bool = n.T(paramBaseFinderFeed, z.bAW(), false);
      AppMethodBeat.o(346397);
      return bool;
    }
  }
  
  private static final void t(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(346411);
    kotlin.g.b.s.u(paramRecyclerView, "$recyclerView");
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(paramRecyclerView, locala.aYi(), "com/tencent/mm/plugin/finder/ui/ShareRelPresenter", "smoothScrollToNextPosition$lambda-5", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    paramRecyclerView.smoothScrollToPosition(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramRecyclerView, "com/tencent/mm/plugin/finder/ui/ShareRelPresenter", "smoothScrollToNextPosition$lambda-5", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    AppMethodBeat.o(346411);
  }
  
  public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, ae.b paramb)
  {
    AppMethodBeat.i(346485);
    kotlin.g.b.s.u(paramBaseFinderFeedLoader, "model");
    kotlin.g.b.s.u(paramb, "callback");
    super.a(paramBaseFinderFeedLoader, paramb);
    paramBaseFinderFeedLoader = this.ALH;
    if (paramBaseFinderFeedLoader != null)
    {
      this.AYg = new ContactUninterestEventListener(paramBaseFinderFeedLoader);
      paramBaseFinderFeedLoader = this.AYg;
      if (paramBaseFinderFeedLoader != null) {
        paramBaseFinderFeedLoader.alive();
      }
    }
    paramb.ATx.getRecyclerView().post(new j..ExternalSyntheticLambda1(this));
    this.FWa.alive();
    paramb.ATx.getRecyclerView().a((RecyclerView.l)new c(paramb, this));
    AppMethodBeat.o(346485);
  }
  
  public final void a(final BaseFinderFeed paramBaseFinderFeed, final int paramInt)
  {
    View localView = null;
    AppMethodBeat.i(346540);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    int i = h(paramBaseFinderFeed);
    if (i >= 0)
    {
      Object localObject = ecc();
      final boolean bool;
      if (localObject == null)
      {
        i = 0;
        if (i <= 1) {
          break label248;
        }
        bool = true;
        label51:
        localObject = com.tencent.mm.plugin.finder.feed.logic.c.Bep;
        com.tencent.mm.plugin.finder.feed.logic.c.a((Context)this.lzt, paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getObjectNonceId(), (kotlin.g.a.b)new b(this, paramBaseFinderFeed, paramInt, bool));
        if (bool) {
          break label277;
        }
        paramBaseFinderFeed = this.ATo;
        if (paramBaseFinderFeed != null) {
          break label254;
        }
        paramBaseFinderFeed = localView;
        label112:
        if (paramBaseFinderFeed != null) {
          paramBaseFinderFeed.setVisibility(0);
        }
        paramBaseFinderFeed = this.ATo;
        if (paramBaseFinderFeed != null)
        {
          paramBaseFinderFeed = paramBaseFinderFeed.ATx;
          if (paramBaseFinderFeed != null)
          {
            localView = paramBaseFinderFeed.agIU;
            if (localView != null)
            {
              float f1 = paramBaseFinderFeed.getTranslationY();
              float f2 = localView.getHeight();
              paramBaseFinderFeed.animate().cancel();
              paramBaseFinderFeed.animate().translationY(-(f2 + f1)).setDuration(240L).setListener((Animator.AnimatorListener)new RefreshLoadMoreLayout.k(paramBaseFinderFeed)).start();
            }
          }
        }
      }
      label277:
      label320:
      for (;;)
      {
        aa.y((Context)this.lzt, this.lzt.getResources().getString(e.h.finder_reduce_recommendation), e.g.icons_filled_done);
        AppMethodBeat.o(346540);
        return;
        i = ((ArrayList)localObject).size();
        break;
        label248:
        bool = false;
        break label51;
        label254:
        localObject = paramBaseFinderFeed.ATx;
        paramBaseFinderFeed = localView;
        if (localObject == null) {
          break label112;
        }
        paramBaseFinderFeed = ((RefreshLoadMoreLayout)localObject).getLoadMoreFooter();
        break label112;
        paramBaseFinderFeed = this.ATo;
        if (paramBaseFinderFeed == null) {
          paramBaseFinderFeed = null;
        }
        for (;;)
        {
          if (paramBaseFinderFeed == null) {
            break label320;
          }
          paramBaseFinderFeed.setVisibility(4);
          break;
          paramBaseFinderFeed = paramBaseFinderFeed.ATx;
          if (paramBaseFinderFeed == null) {
            paramBaseFinderFeed = null;
          } else {
            paramBaseFinderFeed = paramBaseFinderFeed.getLoadMoreFooter();
          }
        }
      }
    }
    Log.i(this.TAG, kotlin.g.b.s.X("[UNINTEREST] pos error ", Integer.valueOf(i)));
    AppMethodBeat.o(346540);
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.base.s params, int paramInt)
  {
    AppMethodBeat.i(346520);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(params, "menu");
    super.a(paramBaseFinderFeed, params, paramInt);
    if (this.isPreview)
    {
      params.removeItem(ebl());
      params.removeItem(ebv());
    }
    AppMethodBeat.o(346520);
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.base.s params, com.tencent.mm.ui.widget.a.f paramf, com.tencent.mm.view.recyclerview.j paramj)
  {
    AppMethodBeat.i(346530);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(params, "menu");
    kotlin.g.b.s.u(paramf, "sheet");
    kotlin.g.b.s.u(paramj, "holder");
    super.a(paramBaseFinderFeed, params, paramf, paramj);
    long l;
    if (!e(paramBaseFinderFeed))
    {
      paramf = this.FVU;
      l = paramBaseFinderFeed.feedObject.getId();
      if (paramf != null) {
        break label134;
      }
    }
    for (;;)
    {
      paramf = bg.AZN;
      params.a(bg.ecU(), (CharSequence)this.lzt.getString(e.h.more_menu_unlike), e.g.finder_feed_dislike);
      label134:
      do
      {
        if ((this.isPreview) && (!e(paramBaseFinderFeed)))
        {
          params.removeItem(ebk());
          params.removeItem(ebj());
        }
        AppMethodBeat.o(346530);
        return;
        if (paramf.longValue() != l) {
          break;
        }
      } while (this.FVV != 16);
    }
  }
  
  public final void a(RefreshLoadMoreLayout.d<Object> paramd)
  {
    Object localObject1 = null;
    AppMethodBeat.i(346509);
    kotlin.g.b.s.u(paramd, "reason");
    com.tencent.mm.plugin.finder.report.s.a(com.tencent.mm.plugin.finder.report.s.Fqv, this.hJx, false, null, 12);
    Object localObject2;
    Object localObject3;
    if ((paramd.agJw) && (paramd.agJu))
    {
      localObject2 = this.ATo;
      if (localObject2 != null)
      {
        localObject2 = ((b.b)localObject2).ATx.getRecyclerView();
        if (localObject2 != null)
        {
          localObject3 = ((RecyclerView)localObject2).getLayoutManager();
          if (localObject3 == null)
          {
            paramd = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
            AppMethodBeat.o(346509);
            throw paramd;
          }
          int i = ((FinderLinearLayoutManager)localObject3).Ju() + 1;
          Log.i(this.TAG, kotlin.g.b.s.X("[smoothScrollToNextPosition] nextPosition=", Integer.valueOf(i)));
          ((RecyclerView)localObject2).post(new j..ExternalSyntheticLambda0((RecyclerView)localObject2, i));
        }
      }
    }
    if (paramd.agJu)
    {
      paramd = k.aeZF;
      localObject2 = (ac)k.d((AppCompatActivity)this.lzt).q(ac.class);
      paramd = this.ATo;
      if (paramd != null) {
        break label230;
      }
      paramd = null;
      ((ac)localObject2).setRecyclerView(paramd);
      paramd = this.ALH;
      if (paramd != null) {
        break label241;
      }
      paramd = localObject1;
    }
    for (;;)
    {
      ((ac)localObject2).l(paramd);
      kotlin.g.b.s.s(localObject2, "uic");
      ac.a((ac)localObject2);
      AppMethodBeat.o(346509);
      return;
      label230:
      paramd = paramd.ATx.getRecyclerView();
      break;
      label241:
      localObject3 = paramd.getDataListJustForAdapter();
      paramd = localObject1;
      if (localObject3 != null) {
        paramd = (cc)p.ae((List)localObject3, 1);
      }
    }
  }
  
  public final g dUK()
  {
    AppMethodBeat.i(346481);
    g localg = (g)new a(this);
    AppMethodBeat.o(346481);
    return localg;
  }
  
  public final void eby()
  {
    AppMethodBeat.i(346499);
    com.tencent.mm.plugin.finder.report.s locals = com.tencent.mm.plugin.finder.report.s.Fqv;
    int i = this.hJx;
    k localk = k.aeZF;
    com.tencent.mm.plugin.finder.report.s.a(locals, i, false, ((as)k.d((AppCompatActivity)this.lzt).q(as.class)).fou(), 8);
    AppMethodBeat.o(346499);
  }
  
  public final void f(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(346475);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    boolean bool = this.lzt.getIntent().getBooleanExtra("is_from_ad", false);
    Object localObject1 = k.aeZF;
    localObject1 = ((as)k.d((AppCompatActivity)this.lzt).q(as.class)).fou();
    Object localObject2 = ak.ECS;
    localObject2 = (Context)this.lzt;
    bh localbh = bh.ABm;
    int j = bh.dVr();
    int i;
    if (bool)
    {
      i = 22;
      ak.a((Context)localObject2, (bui)localObject1, paramBaseFinderFeed, j, false, true, i);
      localObject1 = com.tencent.mm.plugin.finder.api.d.AwY;
      paramBaseFinderFeed = paramBaseFinderFeed.contact;
      if (paramBaseFinderFeed != null) {
        break label143;
      }
      paramBaseFinderFeed = "";
    }
    for (;;)
    {
      localObject1 = m.Axk;
      d.a.et(paramBaseFinderFeed, m.dUG());
      AppMethodBeat.o(346475);
      return;
      i = 0;
      break;
      label143:
      localObject1 = paramBaseFinderFeed.getUsername();
      paramBaseFinderFeed = (BaseFinderFeed)localObject1;
      if (localObject1 == null) {
        paramBaseFinderFeed = "";
      }
    }
  }
  
  public final void fcm()
  {
    AppMethodBeat.i(346459);
    Object localObject;
    int i;
    if (!this.FVZ)
    {
      localObject = this.ATo;
      if (localObject != null) {
        break label92;
      }
      i = 0;
    }
    for (;;)
    {
      if (i > 0)
      {
        localObject = this.ATo;
        if (localObject != null)
        {
          localObject = ((b.b)localObject).ATx.getRecyclerView();
          if (localObject != null)
          {
            localObject = ((RecyclerView)localObject).getAdapter();
            if (localObject != null) {
              ((RecyclerView.a)localObject).e(0, i, new r(Integer.valueOf(25), Integer.valueOf(0)));
            }
          }
        }
      }
      this.FVZ = true;
      AppMethodBeat.o(346459);
      return;
      label92:
      localObject = ((b.b)localObject).ATx.getRecyclerView();
      if (localObject == null)
      {
        i = 0;
      }
      else
      {
        localObject = ((RecyclerView)localObject).getAdapter();
        if (localObject == null) {
          i = 0;
        } else {
          i = ((RecyclerView.a)localObject).getItemCount();
        }
      }
    }
  }
  
  public final boolean fcn()
  {
    AppMethodBeat.i(346517);
    Object localObject = this.ATo;
    if (localObject != null)
    {
      localObject = ((b.b)localObject).ebH();
      if ((localObject != null) && (((com.tencent.mm.plugin.finder.view.f)localObject).fkp()))
      {
        ((com.tencent.mm.plugin.finder.view.f)localObject).fdh();
        AppMethodBeat.o(346517);
        return true;
      }
    }
    localObject = this.ATo;
    if (localObject != null)
    {
      localObject = ((b.b)localObject).ATB;
      if ((localObject != null) && (((TouchMediaPreviewLayout)localObject).afVJ))
      {
        ((TouchMediaPreviewLayout)localObject).jFh();
        AppMethodBeat.o(346517);
        return true;
      }
    }
    localObject = this.ATo;
    if (localObject != null)
    {
      localObject = ((b.b)localObject).ebI();
      if ((localObject != null) && (((FinderLikeDrawer)localObject).fkp()))
      {
        ((FinderLikeDrawer)localObject).fdh();
        AppMethodBeat.o(346517);
        return true;
      }
    }
    localObject = this.ATo;
    if (localObject != null)
    {
      localObject = ((b.b)localObject).ebF();
      if ((localObject != null) && (((FinderLikeDrawer)localObject).fkp()))
      {
        ((FinderLikeDrawer)localObject).fdh();
        AppMethodBeat.o(346517);
        return true;
      }
    }
    AppMethodBeat.o(346517);
    return false;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(346493);
    super.onDetach();
    Object localObject = this.AYg;
    if (localObject != null) {
      ((ContactUninterestEventListener)localObject).dead();
    }
    this.FWa.dead();
    localObject = ((Iterable)this.FVT).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IListener)((Iterator)localObject).next()).dead();
    }
    AppMethodBeat.o(346493);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "addListener", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements g
  {
    a(j paramj) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(346379);
      if (paramInt == 2016)
      {
        localObject = this.FWb.ALH;
        if (localObject == null)
        {
          localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderFeedShareRelativeListLoader");
          AppMethodBeat.o(346379);
          throw ((Throwable)localObject);
        }
        List localList = ((FinderFeedShareRelativeListLoader)localObject).ALr;
        localObject = as.GSQ;
        localObject = as.a.hu((Context)this.FWb.lzt);
        if (localObject == null) {}
        for (localObject = null;; localObject = ((as)localObject).fou())
        {
          localObject = (com.tencent.mm.view.recyclerview.f)new bu((bui)localObject, this.FWb.hJx, localList);
          AppMethodBeat.o(346379);
          return localObject;
        }
      }
      Object localObject = j.b(this.FWb).yF(paramInt);
      boolean bool;
      if ((localObject instanceof t))
      {
        localObject = this.FWb.AJn;
        bool = this.FWb.safeMode;
        paramInt = this.FWb.hJx;
        localObject = (com.tencent.mm.view.recyclerview.f)new a(this.FWb, this, (l)localObject, bool, paramInt);
        AppMethodBeat.o(346379);
        return localObject;
      }
      if ((localObject instanceof q))
      {
        bool = this.FWb.safeMode;
        paramInt = this.FWb.hJx;
        localObject = (com.tencent.mm.view.recyclerview.f)new b(this.FWb, bool, paramInt);
        AppMethodBeat.o(346379);
        return localObject;
      }
      AppMethodBeat.o(346379);
      return localObject;
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullVideoConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedVideo;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "onClickToShare", "it", "Landroid/view/View;", "from", "openCommentDrawer", "isSingleMode", "refCommentId", "", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "customBottom", "reason", "isOnlyShowDesc", "blinkDuration", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends t
    {
      a(j paramj, j.a parama, l paraml, boolean paramBoolean, int paramInt)
      {
        super((i)paramj, paramBoolean, paramInt);
        AppMethodBeat.i(346586);
        AppMethodBeat.o(346586);
      }
      
      public final void a(com.tencent.mm.view.recyclerview.j paramj, com.tencent.mm.plugin.finder.model.ah paramah, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(346599);
        kotlin.g.b.s.u(paramj, "holder");
        kotlin.g.b.s.u(paramah, "item");
        super.a(paramj, paramah, paramInt1, paramInt2, paramBoolean, paramList);
        if (this.FWb.isPreview)
        {
          paramah = com.tencent.mm.plugin.finder.feed.logic.d.Beq;
          com.tencent.mm.plugin.finder.feed.logic.d.w(paramj);
        }
        paramah = jdField_this;
        kotlin.g.b.s.u(paramj, "holder");
        paramInt2 = e.e.finder_share_guide_listener_tag;
        if (paramj.caK.getTag(paramInt2) == null)
        {
          paramList = com.tencent.mm.app.f.hfK;
          paramList = new ShareRelPresenter.buildItemCoverts.1.addListener.1(paramInt1, paramah.FWb, paramj, paramList);
          paramj.caK.setTag(paramInt2, paramList);
          paramah.FWb.FVT.add(paramList);
          paramList.alive();
        }
        AppMethodBeat.o(346599);
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$2", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullImageConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "onClickToShare", "it", "Landroid/view/View;", "from", "openCommentDrawer", "isSingleMode", "refCommentId", "", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "customBottom", "reason", "isOnlyShowDesc", "blinkDuration", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      extends q
    {
      b(j paramj, boolean paramBoolean, int paramInt)
      {
        super(paramBoolean, paramInt);
        AppMethodBeat.i(346576);
        AppMethodBeat.o(346576);
      }
      
      private void a(com.tencent.mm.view.recyclerview.j paramj, v paramv, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(346583);
        kotlin.g.b.s.u(paramj, "holder");
        kotlin.g.b.s.u(paramv, "item");
        super.a(paramj, (BaseFinderFeed)paramv, paramInt1, paramInt2, paramBoolean, paramList);
        if (this.FWb.isPreview)
        {
          paramv = com.tencent.mm.plugin.finder.feed.logic.d.Beq;
          com.tencent.mm.plugin.finder.feed.logic.d.w(paramj);
        }
        AppMethodBeat.o(346583);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "", "subType", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Integer, List<? extends Long>>
  {
    b(j paramj, BaseFinderFeed paramBaseFinderFeed, int paramInt, boolean paramBoolean)
    {
      super();
    }
    
    private List<Long> NJ(int paramInt)
    {
      AppMethodBeat.i(346347);
      LinkedList localLinkedList = new LinkedList();
      Object localObject2 = new LinkedList();
      ??? = this.FWb;
      Object localObject3 = paramBaseFinderFeed;
      ??? = ((j)???).ecc();
      if (??? != null) {}
      for (;;)
      {
        Object localObject5;
        int i;
        synchronized ((Iterable)???)
        {
          localObject5 = ((Iterable)???).iterator();
          i = 0;
          Object localObject6;
          if (((Iterator)localObject5).hasNext())
          {
            localObject6 = ((Iterator)localObject5).next();
            if (i < 0) {
              p.kkW();
            }
            localObject6 = (cc)localObject6;
            if ((!(localObject6 instanceof BaseFinderFeed)) || (((BaseFinderFeed)localObject6).feedObject.getId() != ((BaseFinderFeed)localObject3).feedObject.getId())) {
              break label478;
            }
            ((LinkedList)localObject2).add(0, new r(Integer.valueOf(i), localObject6));
            break label478;
          }
          localObject3 = kotlin.ah.aiuX;
          ??? = (Iterable)localObject2;
          localObject2 = this.FWb;
          i = paramInt;
          boolean bool = bool;
          localObject3 = paramBaseFinderFeed;
          ??? = ((Iterable)???).iterator();
          if (!((Iterator)???).hasNext()) {
            break label463;
          }
          localObject5 = (r)((Iterator)???).next();
          Log.i(((j)localObject2).TAG, "[not interested] removeAt " + i + " subType=" + paramInt + ' ' + ((BaseFinderFeed)((r)localObject5).bsD).feedObject);
          localLinkedList.add(Long.valueOf(((BaseFinderFeed)((r)localObject5).bsD).feedObject.getCreateTime()));
          if (bool)
          {
            localObject6 = ((ae.a)localObject2).ALH;
            if (localObject6 != null)
            {
              localObject6 = ((BaseFinderFeedLoader)localObject6).getDataListJustForAdapter();
              if (localObject6 != null) {
                ((DataBuffer)localObject6).remove(((r)localObject5).bsD);
              }
            }
            localObject6 = ((b.a)localObject2).ATo;
            if (localObject6 != null)
            {
              localObject6 = ((b.b)localObject6).getAdapter();
              if (localObject6 != null) {
                ((WxRecyclerAdapter)localObject6).fX(((Number)((r)localObject5).bsC).intValue());
              }
            }
            localObject5 = j.e((j)localObject2);
            long l = ((BaseFinderFeed)localObject3).feedObject.getId();
            if ((localObject5 == null) || (((Long)localObject5).longValue() != l)) {
              continue;
            }
            ((j)localObject2).FVY = true;
          }
        }
        j.a((j)localObject2, (BaseFinderFeed)((r)localObject5).bsD);
        j.a((j)localObject2, ((Number)((r)localObject5).bsC).intValue());
        continue;
        label463:
        List localList = (List)localObject1;
        AppMethodBeat.o(346347);
        return localList;
        label478:
        i += 1;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$onAttach$3", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.l
  {
    c(ae.b paramb, j paramj) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(346349);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/ShareRelPresenter$onAttach$3", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 0)
      {
        paramRecyclerView = this.FWe.ATx.getRecyclerView().getLayoutManager();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
          AppMethodBeat.o(346349);
          throw paramRecyclerView;
        }
        paramInt = ((LinearLayoutManager)paramRecyclerView).Ju();
        paramRecyclerView = this.FWe.ATx.getRecyclerView().getLayoutManager();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
          AppMethodBeat.o(346349);
          throw paramRecyclerView;
        }
        int i = ((LinearLayoutManager)paramRecyclerView).Jw();
        if ((j.c(jdField_this) != -1) && (j.d(jdField_this) != null) && (paramInt != j.c(jdField_this)) && (paramInt == i))
        {
          paramRecyclerView = jdField_this.ALH;
          if (paramRecyclerView != null)
          {
            paramRecyclerView = paramRecyclerView.getDataListJustForAdapter();
            if (paramRecyclerView != null)
            {
              paramRecyclerView = (Collection)paramRecyclerView;
              localObject = j.d(jdField_this);
              an.hA(paramRecyclerView).remove(localObject);
            }
          }
          paramRecyclerView = jdField_this.ATo;
          if (paramRecyclerView != null)
          {
            paramRecyclerView = paramRecyclerView.getAdapter();
            if (paramRecyclerView != null) {
              paramRecyclerView.fX(j.c(jdField_this));
            }
          }
          j.a(jdField_this, -1);
          j.a(jdField_this, null);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/ShareRelPresenter$onAttach$3", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(346349);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(346360);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/ShareRelPresenter$onAttach$3", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/ShareRelPresenter$onAttach$3", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(346360);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.j
 * JD-Core Version:    0.7.0.1
 */