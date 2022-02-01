package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.w;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.m.a;
import com.tencent.mm.plugin.finder.video.i.b;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.f;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.s;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aqa;
import com.tencent.mm.protocal.protobuf.aqn;
import com.tencent.mm.protocal.protobuf.aqq;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.g.b.q;
import d.o;
import d.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArraySet;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$IProfileTimelinePresenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "commentScene", "", "(Lcom/tencent/mm/ui/MMActivity;I)V", "MENU_ID_CLOSE_COMMENT", "getMENU_ID_CLOSE_COMMENT", "()I", "MENU_ID_DELETE_FEED", "getMENU_ID_DELETE_FEED", "MENU_ID_EXPOSE", "getMENU_ID_EXPOSE", "MENU_ID_OPEN_COMMENT", "getMENU_ID_OPEN_COMMENT", "MENU_ID_REPRINT", "getMENU_ID_REPRINT", "MENU_ID_SHARE_TO_CHAT", "getMENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_FAVORITE", "getMENU_ID_SHARE_TO_FAVORITE", "MENU_ID_SHARE_TO_TIMELINE", "getMENU_ID_SHARE_TO_TIMELINE", "MENU_ID_UNFOLLOW", "getMENU_ID_UNFOLLOW", "MENU_ID_UNINTEREST", "getMENU_ID_UNINTEREST", "TAG", "", "getTAG", "()Ljava/lang/String;", "getCommentScene", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "feedExposeInfoChangeListener", "com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$feedExposeInfoChangeListener$1;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "mediaBannerViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "viewCallback", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "createFirstMenu", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "createSecondMenu", "dealMenuClick", "menuItem", "Landroid/view/MenuItem;", "index", "getActivity", "getCommentDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getCreateSecondMoreMenuListener", "getDataAt", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getMediaBannerRecyclerViewPool", "getMediaBannerViewPool", "getMoreMenuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getVideoCore", "getVideoCoreInitializer", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "getVideoData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "initVideoAbout", "initViewCallback", "isFinderSelfScene", "", "keep", "p0", "loadMoreData", "onAttach", "callback", "onBackPressed", "onDetach", "onFavFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isFav", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onFollow", "isFollow", "onLikeComment", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "isLike", "onLikeFeed", "private", "likeAction", "preIsPrivate", "onLoadMoreEnd", "onRefreshEnd", "onUIPause", "onUIResume", "requestRefresh", "shareFeed", "shareFeedToSns", "plugin-finder_release"})
public abstract class a$a
  implements h, x.a, com.tencent.mm.plugin.finder.presenter.base.a<a.b>, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
{
  private final String TAG;
  public final MMActivity fNT;
  final int oyq;
  private final int oyw;
  private final int rUN;
  public final com.tencent.mm.plugin.finder.video.i rWB;
  private final int sbW;
  final int sbX;
  private final int sbY;
  private final int sbZ;
  final int sca;
  final int scb;
  final int scc;
  public a.b scd;
  private RecyclerView.n sce;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> scf;
  private final d scg;
  public final int sch;
  
  private a$a(MMActivity paramMMActivity, int paramInt)
  {
    this.fNT = paramMMActivity;
    this.sch = paramInt;
    this.TAG = "Finder.FinderLoaderFeedUIContract.Presenter";
    this.sbW = 99;
    this.rUN = 100;
    this.oyw = 101;
    this.sbX = 102;
    this.oyq = 103;
    this.sbY = 104;
    this.sbZ = 105;
    this.sca = 106;
    this.scb = 107;
    this.scc = 108;
    this.scf = new CopyOnWriteArraySet();
    this.sce = new RecyclerView.n();
    this.sce.aC(1, 10);
    this.sce.aC(2, 10);
    this.rWB = new com.tencent.mm.plugin.finder.video.i();
    this.scg = new d(this);
  }
  
  public abstract am EJ(int paramInt);
  
  public final n.d a(final BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.widget.a.e parame)
  {
    d.g.b.p.h(paramBaseFinderFeed, "feed");
    d.g.b.p.h(parame, "sheet");
    return (n.d)new e(this, paramBaseFinderFeed);
  }
  
  public void a(a.b paramb)
  {
    d.g.b.p.h(paramb, "callback");
    this.scd = paramb;
    cCm();
    com.tencent.mm.sdk.b.a.IvT.b((com.tencent.mm.sdk.b.c)this.scg);
    paramb = this.rWB;
    a.b localb = this.scd;
    if (localb == null) {
      d.g.b.p.gkB();
    }
    com.tencent.mm.plugin.finder.video.i.a(paramb, localb.fNT, (i.b)new h(this), 4);
  }
  
  public void a(final BaseFinderFeed paramBaseFinderFeed, MenuItem paramMenuItem, int paramInt)
  {
    d.g.b.p.h(paramBaseFinderFeed, "feed");
    d.g.b.p.h(paramMenuItem, "menuItem");
    ae.i(getTAG(), "getMoreMenuItemSelectedListener feed " + paramBaseFinderFeed + ' ' + paramInt + " menuItem:" + paramMenuItem.getItemId());
    paramInt = paramMenuItem.getItemId();
    if (paramInt == this.sbW)
    {
      paramInt = h(paramBaseFinderFeed);
      if (paramInt >= 0)
      {
        paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.b.sjF;
        com.tencent.mm.plugin.finder.feed.logic.b.a((Context)this.fNT, paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getObjectNonceId(), (d.g.a.b)new a(this, paramBaseFinderFeed));
      }
    }
    do
    {
      do
      {
        return;
        ae.i(getTAG(), "[UNINTEREST] pos error ".concat(String.valueOf(paramInt)));
        return;
      } while (paramInt == this.rUN);
      if (paramInt == this.sbX)
      {
        new Bundle();
        m.a.a(com.tencent.mm.plugin.finder.utils.m.sWJ, this.fNT, paramBaseFinderFeed.feedObject, 3, 4);
        return;
      }
      if (paramInt == this.oyq)
      {
        paramMenuItem = com.tencent.mm.plugin.finder.utils.m.sWJ;
        m.a.a(this.fNT, paramBaseFinderFeed, 0, 12);
        return;
      }
      if (paramInt == this.sbY)
      {
        paramMenuItem = com.tencent.mm.plugin.finder.utils.d.sWi;
        com.tencent.mm.plugin.finder.utils.d.a(paramBaseFinderFeed, this.fNT);
        return;
      }
      if (paramInt == this.oyw)
      {
        paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.a.sjE;
        com.tencent.mm.plugin.finder.feed.logic.a.i((Context)this.fNT, paramBaseFinderFeed.feedObject.field_id);
        return;
      }
      if (paramInt == this.sbZ)
      {
        Intent localIntent = new Intent();
        paramMenuItem = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
        if (paramMenuItem != null) {}
        for (paramMenuItem = paramMenuItem.toByteArray();; paramMenuItem = null)
        {
          localIntent.putExtra("postRefMediaList", paramMenuItem);
          paramMenuItem = com.tencent.mm.plugin.finder.utils.p.sXz;
          localIntent.putExtra("postRefFeedInfo", com.tencent.mm.plugin.finder.utils.p.n(paramBaseFinderFeed).toByteArray());
          localIntent.putExtra("postType", paramBaseFinderFeed.feedObject.getMediaType());
          localIntent.putExtra("key_finder_post_from", 5);
          paramBaseFinderFeed = com.tencent.mm.plugin.finder.utils.a.sVQ;
          com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI((Context)this.fNT, localIntent);
          return;
        }
      }
      if (paramInt == this.scb)
      {
        ((com.tencent.mm.plugin.i.a.l)g.ab(com.tencent.mm.plugin.i.a.l.class)).a(paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getFeedObject(), paramBaseFinderFeed.feedObject.getObjectNonceId(), true, (s)new b(this));
        return;
      }
    } while (paramInt != this.sca);
    ((com.tencent.mm.plugin.i.a.l)g.ab(com.tencent.mm.plugin.i.a.l.class)).a(paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getFeedObject(), paramBaseFinderFeed.feedObject.getObjectNonceId(), false, (s)new c(this));
  }
  
  public void a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.base.l paraml)
  {
    d.g.b.p.h(paramBaseFinderFeed, "feed");
    d.g.b.p.h(paraml, "menu");
    com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sXz;
    if (!com.tencent.mm.plugin.finder.utils.p.d(paramBaseFinderFeed)) {
      paraml.a(this.oyw, (CharSequence)this.fNT.getString(2131761332), 2131690646);
    }
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    d.g.b.p.h(paramBaseFinderFeed, "feed");
    Object localObject1 = com.tencent.mm.ui.component.a.KEX;
    localObject1 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.fNT).get(FinderReporterUIC.class)).cQZ();
    Object localObject2 = x.stn;
    localObject2 = paramBaseFinderFeed.feedObject;
    boolean bool = paramBaseFinderFeed.showLikeTips;
    com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sXz;
    x.a((arn)localObject1, paramInt, (FinderItem)localObject2, paramBoolean1, paramBoolean2, 2, bool, paramBoolean3, com.tencent.mm.plugin.finder.utils.p.j(paramBaseFinderFeed.contact));
  }
  
  public final void a(FinderItem paramFinderItem)
  {
    d.g.b.p.h(paramFinderItem, "feed");
    m.a.a(com.tencent.mm.plugin.finder.utils.m.sWJ, this.fNT, paramFinderItem, 0, 12);
  }
  
  public final void a(FinderItem paramFinderItem, FinderCommentInfo paramFinderCommentInfo)
  {
    d.g.b.p.h(paramFinderItem, "feed");
    d.g.b.p.h(paramFinderCommentInfo, "comment");
  }
  
  public final void a(FinderItem paramFinderItem, boolean paramBoolean, com.tencent.mm.view.recyclerview.e parame)
  {
    d.g.b.p.h(paramFinderItem, "feed");
    parame = com.tencent.mm.plugin.finder.model.m.ssV;
    com.tencent.mm.plugin.finder.model.m.a(this.fNT, paramFinderItem, paramBoolean);
  }
  
  public abstract void aTS();
  
  public boolean cCl()
  {
    return false;
  }
  
  public abstract void cCm();
  
  public abstract DataBuffer<am> cCn();
  
  public void cCo() {}
  
  public void cCp() {}
  
  public abstract com.tencent.mm.view.recyclerview.c cCq();
  
  public final RecyclerView.n cCr()
  {
    return this.sce;
  }
  
  public final com.tencent.mm.plugin.finder.view.e cCs()
  {
    Object localObject = this.scd;
    if (localObject != null)
    {
      com.tencent.mm.plugin.finder.view.e locale = ((a.b)localObject).cCx();
      localObject = locale;
      if (locale != null) {}
    }
    else
    {
      localObject = new com.tencent.mm.plugin.finder.view.e();
    }
    return localObject;
  }
  
  public final n.d e(final BaseFinderFeed paramBaseFinderFeed)
  {
    d.g.b.p.h(paramBaseFinderFeed, "feed");
    return (n.d)new f(this, paramBaseFinderFeed);
  }
  
  public final n.e f(final BaseFinderFeed paramBaseFinderFeed)
  {
    d.g.b.p.h(paramBaseFinderFeed, "feed");
    return (n.e)new g(this, paramBaseFinderFeed);
  }
  
  public final void g(BaseFinderFeed paramBaseFinderFeed)
  {
    d.g.b.p.h(paramBaseFinderFeed, "feed");
    m.a locala = com.tencent.mm.plugin.finder.utils.m.sWJ;
    m.a.a(this.fNT, paramBaseFinderFeed, 4, 4);
  }
  
  public final MMActivity getActivity()
  {
    return this.fNT;
  }
  
  public String getTAG()
  {
    return this.TAG;
  }
  
  public final com.tencent.mm.plugin.finder.video.i getVideoCore()
  {
    return this.rWB;
  }
  
  public void keep(com.tencent.mm.vending.e.a parama)
  {
    this.scf.add(parama);
  }
  
  public final void onBackPressed()
  {
    Object localObject = this.scd;
    if (localObject != null)
    {
      localObject = ((a.b)localObject).cCx();
      if ((localObject != null) && (((com.tencent.mm.plugin.finder.view.e)localObject).cPI())) {
        ((com.tencent.mm.plugin.finder.view.e)localObject).cPH();
      }
    }
    do
    {
      do
      {
        return;
        localObject = this.scd;
        if (localObject != null)
        {
          localObject = ((a.b)localObject).scn;
          if ((localObject != null) && (((TouchMediaPreviewLayout)localObject).LqB))
          {
            ((TouchMediaPreviewLayout)localObject).fQg();
            return;
          }
        }
        localObject = this.scd;
        if (localObject != null)
        {
          localObject = ((a.b)localObject).cCy();
          if ((localObject != null) && (((FinderLikeDrawer)localObject).cPI()))
          {
            ((FinderLikeDrawer)localObject).cPH();
            return;
          }
        }
        localObject = this.scd;
        if (localObject != null)
        {
          localObject = ((a.b)localObject).cCv();
          if ((localObject != null) && (((FinderLikeDrawer)localObject).cPI()))
          {
            ((FinderLikeDrawer)localObject).cPH();
            return;
          }
        }
        localObject = this.scd;
      } while (localObject == null);
      localObject = ((a.b)localObject).fNT;
    } while (localObject == null);
    ((MMActivity)localObject).finish();
  }
  
  public void onDetach()
  {
    com.tencent.mm.plugin.finder.storage.data.e.sKJ.clearCache();
    Object localObject = ((Iterable)this.scf).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.vending.e.a)((Iterator)localObject).next()).dead();
    }
    this.scf.clear();
    com.tencent.mm.sdk.b.a.IvT.d((com.tencent.mm.sdk.b.c)this.scg);
    this.scd = null;
    localObject = this.scd;
    if (localObject != null)
    {
      localObject = ((a.b)localObject).cCx();
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.view.e)localObject).onDetach();
      }
    }
  }
  
  public final void onUIPause()
  {
    a.b localb = this.scd;
    if (localb != null) {
      localb.cCx();
    }
  }
  
  public final void onUIResume()
  {
    Object localObject = this.scd;
    if (localObject != null)
    {
      localObject = ((a.b)localObject).cCx();
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.view.e)localObject).onUIResume();
      }
    }
  }
  
  public abstract void requestRefresh();
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Ljava/util/LinkedList;", "", "subType", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.b<Integer, LinkedList<Long>>
  {
    a(a.a parama, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$dealMenuClick$2", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class b
    implements s<aqa>
  {}
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$dealMenuClick$3", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class c
    implements s<aqa>
  {}
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/view/FinderExposeChangedEventListener;", "tag", "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "getFeedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "notifyAdapter", "", "exposeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExposeInfo;", "plugin-finder_release"})
  public static final class d
    extends f
  {
    private String tag;
    
    d()
    {
      AppMethodBeat.i(165612);
      this.tag = localObject.getTAG();
      AppMethodBeat.o(165612);
    }
    
    public final void a(long paramLong, aqn paramaqn)
    {
      AppMethodBeat.i(165611);
      Object localObject1 = this.sci.scd;
      if (localObject1 != null)
      {
        localObject1 = ((a.b)localObject1).scj.getRecyclerView();
        if (localObject1 != null)
        {
          Object localObject2 = ((RecyclerView)localObject1).getAdapter();
          if (localObject2 == null)
          {
            paramaqn = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
            AppMethodBeat.o(165611);
            throw paramaqn;
          }
          localObject2 = com.tencent.mm.view.recyclerview.d.c((com.tencent.mm.view.recyclerview.d)localObject2, paramLong);
          if (localObject2 != null)
          {
            int i = ((RecyclerView.w)localObject2).lN();
            localObject1 = ((RecyclerView)localObject1).getAdapter();
            if (localObject1 != null)
            {
              ((RecyclerView.a)localObject1).b(i, new o(Integer.valueOf(1), paramaqn));
              AppMethodBeat.o(165611);
              return;
            }
            AppMethodBeat.o(165611);
            return;
          }
          AppMethodBeat.o(165611);
          return;
        }
      }
      AppMethodBeat.o(165611);
    }
    
    public final String getTag()
    {
      return this.tag;
    }
    
    public final FinderItem wv(long paramLong)
    {
      AppMethodBeat.i(165610);
      Object localObject = this.sci.scd;
      if (localObject != null)
      {
        localObject = ((a.b)localObject).scj.getRecyclerView();
        if (localObject != null)
        {
          localObject = ((RecyclerView)localObject).getAdapter();
          if (localObject == null)
          {
            localObject = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
            AppMethodBeat.o(165610);
            throw ((Throwable)localObject);
          }
          localObject = com.tencent.mm.view.recyclerview.d.c((com.tencent.mm.view.recyclerview.d)localObject, paramLong);
          if (localObject != null)
          {
            int i = ((RecyclerView.w)localObject).lN();
            localObject = this.sci.scd;
            if (localObject == null) {
              d.g.b.p.gkB();
            }
            int j = ((a.b)localObject).rgr;
            localObject = this.sci.EJ(i - j);
            if ((localObject instanceof BaseFinderFeed))
            {
              localObject = ((BaseFinderFeed)localObject).feedObject;
              AppMethodBeat.o(165610);
              return localObject;
            }
          }
        }
      }
      AppMethodBeat.o(165610);
      return null;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class e
    implements n.d
  {
    e(a.a parama, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(165613);
      a.a locala = this.sci;
      BaseFinderFeed localBaseFinderFeed = paramBaseFinderFeed;
      d.g.b.p.g(paraml, "menu");
      d.g.b.p.h(localBaseFinderFeed, "feed");
      d.g.b.p.h(paraml, "menu");
      Object localObject1 = locala.fNT.getString(2131755893);
      Object localObject2 = locala.fNT.getString(2131766851);
      locala.fNT.getString(2131758845);
      boolean bool2;
      if ((localBaseFinderFeed.feedObject.isOnlySelfSee()) || (localBaseFinderFeed.feedObject.isNotShare()))
      {
        localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
        localObject1 = com.tencent.mm.plugin.finder.utils.p.dC("FinderSafeSelfSeeForward", 2131759344);
        localObject2 = com.tencent.mm.plugin.finder.utils.p.sXz;
        localObject2 = com.tencent.mm.plugin.finder.utils.p.dC("FinderSafeSelfSeeShare", 2131759345);
        com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sXz;
        com.tencent.mm.plugin.finder.utils.p.dC("FinderSafeSelfSeeCollect", 2131759343);
        bool2 = true;
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        paraml.a(locala.sbX, (CharSequence)localObject1, 2131691565, locala.fNT.getResources().getColor(2131099699), bool1);
        paraml.a(locala.oyq, (CharSequence)localObject2, 2131689817, 0, bool2);
        paraml = com.tencent.mm.plugin.finder.report.i.syT;
        com.tencent.mm.plugin.finder.report.i.J(localBaseFinderFeed.lP(), locala.sch);
        paraml = FinderReporterUIC.tnG;
        paraml = FinderReporterUIC.a.fc((Context)locala.fNT);
        if (paraml != null)
        {
          paraml = FinderReporterUIC.b(paraml);
          if (paraml != null)
          {
            paraml.cAI().wq(localBaseFinderFeed.lP());
            AppMethodBeat.o(165613);
            return;
          }
        }
        AppMethodBeat.o(165613);
        return;
        bool2 = false;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class f
    implements n.d
  {
    f(a.a parama, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(165614);
      a.a locala = this.sci;
      BaseFinderFeed localBaseFinderFeed = paramBaseFinderFeed;
      d.g.b.p.g(paraml, "menu");
      locala.a(localBaseFinderFeed, paraml);
      AppMethodBeat.o(165614);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class g
    implements n.e
  {
    g(a.a parama, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(165615);
      a.a locala = this.sci;
      BaseFinderFeed localBaseFinderFeed = paramBaseFinderFeed;
      d.g.b.p.g(paramMenuItem, "menuItem");
      locala.a(localBaseFinderFeed, paramMenuItem, paramInt);
      AppMethodBeat.o(165615);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$getVideoCoreInitializer$1", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "getData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isUseAutoPlay", "", "isUsePreload", "onAttachRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
  public static final class h
    implements i.b
  {
    public final RecyclerView cCt()
    {
      AppMethodBeat.i(165616);
      Object localObject = this.sci.scd;
      if (localObject == null) {
        d.g.b.p.gkB();
      }
      localObject = ((a.b)localObject).scj.getRecyclerView();
      AppMethodBeat.o(165616);
      return localObject;
    }
    
    public final DataBuffer<am> cCu()
    {
      AppMethodBeat.i(202141);
      DataBuffer localDataBuffer = this.sci.cCn();
      AppMethodBeat.o(202141);
      return localDataBuffer;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.a.a
 * JD-Core Version:    0.7.0.1
 */