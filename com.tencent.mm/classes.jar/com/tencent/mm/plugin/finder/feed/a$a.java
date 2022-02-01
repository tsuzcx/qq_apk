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
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.utils.m.a;
import com.tencent.mm.plugin.finder.video.i;
import com.tencent.mm.plugin.finder.video.i.b;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.f;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.s;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.apn;
import com.tencent.mm.protocal.protobuf.aqa;
import com.tencent.mm.protocal.protobuf.aqb;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.platformtools.ad;
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

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$IProfileTimelinePresenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "commentScene", "", "(Lcom/tencent/mm/ui/MMActivity;I)V", "MENU_ID_CLOSE_COMMENT", "getMENU_ID_CLOSE_COMMENT", "()I", "MENU_ID_DELETE_FEED", "getMENU_ID_DELETE_FEED", "MENU_ID_EXPOSE", "getMENU_ID_EXPOSE", "MENU_ID_OPEN_COMMENT", "getMENU_ID_OPEN_COMMENT", "MENU_ID_REPRINT", "getMENU_ID_REPRINT", "MENU_ID_SHARE_TO_CHAT", "getMENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_FAVORITE", "getMENU_ID_SHARE_TO_FAVORITE", "MENU_ID_SHARE_TO_TIMELINE", "getMENU_ID_SHARE_TO_TIMELINE", "MENU_ID_UNFOLLOW", "getMENU_ID_UNFOLLOW", "MENU_ID_UNINTEREST", "getMENU_ID_UNINTEREST", "TAG", "", "getTAG", "()Ljava/lang/String;", "getCommentScene", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "feedExposeInfoChangeListener", "com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$feedExposeInfoChangeListener$1;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "mediaBannerViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "viewCallback", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "createFirstMenu", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "createSecondMenu", "dealMenuClick", "menuItem", "Landroid/view/MenuItem;", "index", "getActivity", "getCommentDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getCreateSecondMoreMenuListener", "getDataAt", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getMediaBannerRecyclerViewPool", "getMediaBannerViewPool", "getMoreMenuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getVideoCore", "getVideoCoreInitializer", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "getVideoData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "initVideoAbout", "initViewCallback", "isFinderSelfScene", "", "keep", "p0", "loadMoreData", "onAttach", "callback", "onBackPressed", "onDetach", "onFavFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isFav", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onFollow", "isFollow", "onLikeComment", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "isLike", "onLikeFeed", "private", "likeAction", "preIsPrivate", "onLoadMoreEnd", "onRefreshEnd", "onUIPause", "onUIResume", "requestRefresh", "shareFeed", "shareFeedToSns", "plugin-finder_release"})
public abstract class a$a
  implements h, x.a, com.tencent.mm.plugin.finder.presenter.base.a<a.b>, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
{
  private final String TAG;
  public final MMActivity fLP;
  final int orP;
  private final int orV;
  private final int rMA;
  public final i rOe;
  private RecyclerView.n rTA;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> rTB;
  private final d rTC;
  public final int rTD;
  private final int rTs;
  final int rTt;
  private final int rTu;
  private final int rTv;
  final int rTw;
  final int rTx;
  final int rTy;
  public a.b rTz;
  
  private a$a(MMActivity paramMMActivity, int paramInt)
  {
    this.fLP = paramMMActivity;
    this.rTD = paramInt;
    this.TAG = "Finder.FinderLoaderFeedUIContract.Presenter";
    this.rTs = 99;
    this.rMA = 100;
    this.orV = 101;
    this.rTt = 102;
    this.orP = 103;
    this.rTu = 104;
    this.rTv = 105;
    this.rTw = 106;
    this.rTx = 107;
    this.rTy = 108;
    this.rTB = new CopyOnWriteArraySet();
    this.rTA = new RecyclerView.n();
    this.rTA.aC(1, 10);
    this.rTA.aC(2, 10);
    this.rOe = new i();
    this.rTC = new d(this);
  }
  
  public abstract al Ew(int paramInt);
  
  public final n.d a(final BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.widget.a.e parame)
  {
    d.g.b.p.h(paramBaseFinderFeed, "feed");
    d.g.b.p.h(parame, "sheet");
    return (n.d)new e(this, paramBaseFinderFeed);
  }
  
  public void a(a.b paramb)
  {
    d.g.b.p.h(paramb, "callback");
    this.rTz = paramb;
    cAA();
    com.tencent.mm.sdk.b.a.IbL.b((com.tencent.mm.sdk.b.c)this.rTC);
    paramb = this.rOe;
    a.b localb = this.rTz;
    if (localb == null) {
      d.g.b.p.gfZ();
    }
    i.a(paramb, localb.fLP, (i.b)new h(this), 4);
  }
  
  public void a(final BaseFinderFeed paramBaseFinderFeed, MenuItem paramMenuItem, int paramInt)
  {
    d.g.b.p.h(paramBaseFinderFeed, "feed");
    d.g.b.p.h(paramMenuItem, "menuItem");
    ad.i(getTAG(), "getMoreMenuItemSelectedListener feed " + paramBaseFinderFeed + ' ' + paramInt + " menuItem:" + paramMenuItem.getItemId());
    paramInt = paramMenuItem.getItemId();
    if (paramInt == this.rTs)
    {
      paramInt = h(paramBaseFinderFeed);
      if (paramInt >= 0)
      {
        paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.b.saP;
        com.tencent.mm.plugin.finder.feed.logic.b.a((Context)this.fLP, paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getObjectNonceId(), (d.g.a.b)new a(this, paramBaseFinderFeed));
      }
    }
    do
    {
      do
      {
        return;
        ad.i(getTAG(), "[UNINTEREST] pos error ".concat(String.valueOf(paramInt)));
        return;
      } while (paramInt == this.rMA);
      if (paramInt == this.rTt)
      {
        new Bundle();
        m.a.a(m.sLy, this.fLP, paramBaseFinderFeed.feedObject, 3, 4);
        return;
      }
      if (paramInt == this.orP)
      {
        paramMenuItem = m.sLy;
        m.a.a(this.fLP, paramBaseFinderFeed, 0, 12);
        return;
      }
      if (paramInt == this.rTu)
      {
        paramMenuItem = com.tencent.mm.plugin.finder.utils.d.sKW;
        com.tencent.mm.plugin.finder.utils.d.a(paramBaseFinderFeed, this.fLP);
        return;
      }
      if (paramInt == this.orV)
      {
        paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.a.saO;
        com.tencent.mm.plugin.finder.feed.logic.a.i((Context)this.fLP, paramBaseFinderFeed.feedObject.field_id);
        return;
      }
      if (paramInt == this.rTv)
      {
        paramMenuItem = new Intent();
        paramMenuItem.putExtra("postRefMediaList", paramBaseFinderFeed.feedObject.getFeedObject().objectDesc.toByteArray());
        com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sMo;
        paramMenuItem.putExtra("postRefFeedInfo", com.tencent.mm.plugin.finder.utils.p.n(paramBaseFinderFeed).toByteArray());
        paramMenuItem.putExtra("postType", paramBaseFinderFeed.feedObject.getMediaType());
        paramMenuItem.putExtra("key_finder_post_from", 5);
        paramBaseFinderFeed = com.tencent.mm.plugin.finder.utils.a.sKD;
        com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI((Context)this.fLP, paramMenuItem);
        return;
      }
      if (paramInt == this.rTx)
      {
        ((com.tencent.mm.plugin.i.a.l)g.ab(com.tencent.mm.plugin.i.a.l.class)).a(paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getFeedObject(), paramBaseFinderFeed.feedObject.getObjectNonceId(), true, (s)new b(this));
        return;
      }
    } while (paramInt != this.rTw);
    ((com.tencent.mm.plugin.i.a.l)g.ab(com.tencent.mm.plugin.i.a.l.class)).a(paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getFeedObject(), paramBaseFinderFeed.feedObject.getObjectNonceId(), false, (s)new c(this));
  }
  
  public void a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.base.l paraml)
  {
    d.g.b.p.h(paramBaseFinderFeed, "feed");
    d.g.b.p.h(paraml, "menu");
    com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sMo;
    if (!com.tencent.mm.plugin.finder.utils.p.d(paramBaseFinderFeed)) {
      paraml.a(this.orV, (CharSequence)this.fLP.getString(2131761332), 2131690646);
    }
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    d.g.b.p.h(paramBaseFinderFeed, "feed");
    Object localObject1 = com.tencent.mm.ui.component.a.KiD;
    localObject1 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.fLP).get(FinderReporterUIC.class)).cOu();
    Object localObject2 = w.skq;
    localObject2 = paramBaseFinderFeed.feedObject;
    boolean bool = paramBaseFinderFeed.showLikeTips;
    com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sMo;
    w.a((aqy)localObject1, paramInt, (FinderItem)localObject2, paramBoolean1, paramBoolean2, 2, bool, paramBoolean3, com.tencent.mm.plugin.finder.utils.p.j(paramBaseFinderFeed.contact));
  }
  
  public final void a(FinderItem paramFinderItem)
  {
    d.g.b.p.h(paramFinderItem, "feed");
    m.a.a(m.sLy, this.fLP, paramFinderItem, 0, 12);
  }
  
  public final void a(FinderItem paramFinderItem, FinderCommentInfo paramFinderCommentInfo)
  {
    d.g.b.p.h(paramFinderItem, "feed");
    d.g.b.p.h(paramFinderCommentInfo, "comment");
  }
  
  public final void a(FinderItem paramFinderItem, boolean paramBoolean, com.tencent.mm.view.recyclerview.e parame)
  {
    d.g.b.p.h(paramFinderItem, "feed");
    parame = com.tencent.mm.plugin.finder.model.l.sjY;
    com.tencent.mm.plugin.finder.model.l.a(this.fLP, paramFinderItem, paramBoolean);
  }
  
  public abstract void aTt();
  
  public abstract void cAA();
  
  public abstract DataBuffer<al> cAB();
  
  public void cAC() {}
  
  public void cAD() {}
  
  public abstract com.tencent.mm.view.recyclerview.c cAE();
  
  public final RecyclerView.n cAF()
  {
    return this.rTA;
  }
  
  public final com.tencent.mm.plugin.finder.view.e cAG()
  {
    Object localObject = this.rTz;
    if (localObject != null)
    {
      com.tencent.mm.plugin.finder.view.e locale = ((a.b)localObject).cAL();
      localObject = locale;
      if (locale != null) {}
    }
    else
    {
      localObject = new com.tencent.mm.plugin.finder.view.e();
    }
    return localObject;
  }
  
  public boolean cAz()
  {
    return false;
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
    m.a locala = m.sLy;
    m.a.a(this.fLP, paramBaseFinderFeed, 4, 4);
  }
  
  public final MMActivity getActivity()
  {
    return this.fLP;
  }
  
  public String getTAG()
  {
    return this.TAG;
  }
  
  public final i getVideoCore()
  {
    return this.rOe;
  }
  
  public void keep(com.tencent.mm.vending.e.a parama)
  {
    this.rTB.add(parama);
  }
  
  public final void onBackPressed()
  {
    Object localObject = this.rTz;
    if (localObject != null)
    {
      localObject = ((a.b)localObject).cAL();
      if ((localObject != null) && (((com.tencent.mm.plugin.finder.view.e)localObject).cMZ())) {
        ((com.tencent.mm.plugin.finder.view.e)localObject).cMY();
      }
    }
    do
    {
      do
      {
        return;
        localObject = this.rTz;
        if (localObject != null)
        {
          localObject = ((a.b)localObject).rTJ;
          if ((localObject != null) && (((TouchMediaPreviewLayout)localObject).KUd))
          {
            ((TouchMediaPreviewLayout)localObject).fLM();
            return;
          }
        }
        localObject = this.rTz;
        if (localObject != null)
        {
          localObject = ((a.b)localObject).cAM();
          if ((localObject != null) && (((FinderLikeDrawer)localObject).cMZ()))
          {
            ((FinderLikeDrawer)localObject).cMY();
            return;
          }
        }
        localObject = this.rTz;
        if (localObject != null)
        {
          localObject = ((a.b)localObject).cAJ();
          if ((localObject != null) && (((FinderLikeDrawer)localObject).cMZ()))
          {
            ((FinderLikeDrawer)localObject).cMY();
            return;
          }
        }
        localObject = this.rTz;
      } while (localObject == null);
      localObject = ((a.b)localObject).fLP;
    } while (localObject == null);
    ((MMActivity)localObject).finish();
  }
  
  public void onDetach()
  {
    com.tencent.mm.plugin.finder.storage.data.e.szM.clearCache();
    Object localObject = ((Iterable)this.rTB).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.vending.e.a)((Iterator)localObject).next()).dead();
    }
    this.rTB.clear();
    com.tencent.mm.sdk.b.a.IbL.d((com.tencent.mm.sdk.b.c)this.rTC);
    this.rTz = null;
    localObject = this.rTz;
    if (localObject != null)
    {
      localObject = ((a.b)localObject).cAL();
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.view.e)localObject).onDetach();
      }
    }
  }
  
  public final void onUIPause()
  {
    a.b localb = this.rTz;
    if (localb != null) {
      localb.cAL();
    }
  }
  
  public final void onUIResume()
  {
    Object localObject = this.rTz;
    if (localObject != null)
    {
      localObject = ((a.b)localObject).cAL();
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.view.e)localObject).onUIResume();
      }
    }
  }
  
  public abstract void requestRefresh();
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Ljava/util/LinkedList;", "", "subType", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.b<Integer, LinkedList<Long>>
  {
    a(a.a parama, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$dealMenuClick$2", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class b
    implements s<apn>
  {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$dealMenuClick$3", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class c
    implements s<apn>
  {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/view/FinderExposeChangedEventListener;", "tag", "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "getFeedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "notifyAdapter", "", "exposeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExposeInfo;", "plugin-finder_release"})
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
    
    public final void a(long paramLong, aqa paramaqa)
    {
      AppMethodBeat.i(165611);
      Object localObject1 = this.rTE.rTz;
      if (localObject1 != null)
      {
        localObject1 = ((a.b)localObject1).rTF.getRecyclerView();
        if (localObject1 != null)
        {
          Object localObject2 = ((RecyclerView)localObject1).getAdapter();
          if (localObject2 == null)
          {
            paramaqa = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
            AppMethodBeat.o(165611);
            throw paramaqa;
          }
          localObject2 = com.tencent.mm.view.recyclerview.d.c((com.tencent.mm.view.recyclerview.d)localObject2, paramLong);
          if (localObject2 != null)
          {
            int i = ((RecyclerView.w)localObject2).lN();
            localObject1 = ((RecyclerView)localObject1).getAdapter();
            if (localObject1 != null)
            {
              ((RecyclerView.a)localObject1).b(i, new o(Integer.valueOf(1), paramaqa));
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
    
    public final FinderItem wf(long paramLong)
    {
      AppMethodBeat.i(165610);
      Object localObject = this.rTE.rTz;
      if (localObject != null)
      {
        localObject = ((a.b)localObject).rTF.getRecyclerView();
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
            localObject = this.rTE.rTz;
            if (localObject == null) {
              d.g.b.p.gfZ();
            }
            int j = ((a.b)localObject).qYl;
            localObject = this.rTE.Ew(i - j);
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
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class e
    implements n.d
  {
    e(a.a parama, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(165613);
      a.a locala = this.rTE;
      BaseFinderFeed localBaseFinderFeed = paramBaseFinderFeed;
      d.g.b.p.g(paraml, "menu");
      d.g.b.p.h(localBaseFinderFeed, "feed");
      d.g.b.p.h(paraml, "menu");
      Object localObject1 = locala.fLP.getString(2131755893);
      Object localObject2 = locala.fLP.getString(2131766851);
      locala.fLP.getString(2131758845);
      boolean bool2;
      if ((localBaseFinderFeed.feedObject.isOnlySelfSee()) || (localBaseFinderFeed.feedObject.isNotShare()))
      {
        localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
        localObject1 = com.tencent.mm.plugin.finder.utils.p.dx("FinderSafeSelfSeeForward", 2131759344);
        localObject2 = com.tencent.mm.plugin.finder.utils.p.sMo;
        localObject2 = com.tencent.mm.plugin.finder.utils.p.dx("FinderSafeSelfSeeShare", 2131759345);
        com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sMo;
        com.tencent.mm.plugin.finder.utils.p.dx("FinderSafeSelfSeeCollect", 2131759343);
        bool2 = true;
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        paraml.a(locala.rTt, (CharSequence)localObject1, 2131691565, locala.fLP.getResources().getColor(2131099699), bool1);
        paraml.a(locala.orP, (CharSequence)localObject2, 2131689817, 0, bool2);
        paraml = com.tencent.mm.plugin.finder.report.h.soM;
        com.tencent.mm.plugin.finder.report.h.J(localBaseFinderFeed.lP(), locala.rTD);
        paraml = FinderReporterUIC.tcM;
        paraml = FinderReporterUIC.a.eY((Context)locala.fLP);
        if (paraml != null)
        {
          paraml = FinderReporterUIC.b(paraml);
          if (paraml != null)
          {
            paraml.cze().wa(localBaseFinderFeed.lP());
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
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class f
    implements n.d
  {
    f(a.a parama, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(165614);
      a.a locala = this.rTE;
      BaseFinderFeed localBaseFinderFeed = paramBaseFinderFeed;
      d.g.b.p.g(paraml, "menu");
      locala.a(localBaseFinderFeed, paraml);
      AppMethodBeat.o(165614);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class g
    implements n.e
  {
    g(a.a parama, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(165615);
      a.a locala = this.rTE;
      BaseFinderFeed localBaseFinderFeed = paramBaseFinderFeed;
      d.g.b.p.g(paramMenuItem, "menuItem");
      locala.a(localBaseFinderFeed, paramMenuItem, paramInt);
      AppMethodBeat.o(165615);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$getVideoCoreInitializer$1", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "getData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isUseAutoPlay", "", "isUsePreload", "onAttachRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
  public static final class h
    implements i.b
  {
    public final RecyclerView cAH()
    {
      AppMethodBeat.i(165616);
      Object localObject = this.rTE.rTz;
      if (localObject == null) {
        d.g.b.p.gfZ();
      }
      localObject = ((a.b)localObject).rTF.getRecyclerView();
      AppMethodBeat.o(165616);
      return localObject;
    }
    
    public final DataBuffer<al> cAI()
    {
      AppMethodBeat.i(201682);
      DataBuffer localDataBuffer = this.rTE.cAB();
      AppMethodBeat.o(201682);
      return localDataBuffer;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.a.a
 * JD-Core Version:    0.7.0.1
 */