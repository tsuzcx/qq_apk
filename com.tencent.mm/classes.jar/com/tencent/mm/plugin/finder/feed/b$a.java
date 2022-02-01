package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.w;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.u;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.k.a;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.plugin.finder.video.i;
import com.tencent.mm.plugin.finder.video.i.b;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.amg;
import com.tencent.mm.protocal.protobuf.amp;
import com.tencent.mm.protocal.protobuf.amq;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.o;
import d.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArraySet;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$IProfileTimelinePresenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "commentScene", "", "(Lcom/tencent/mm/ui/MMActivity;I)V", "MENU_ID_CLOSE_COMMENT", "getMENU_ID_CLOSE_COMMENT", "()I", "MENU_ID_DELETE_FEED", "getMENU_ID_DELETE_FEED", "MENU_ID_EXPOSE", "getMENU_ID_EXPOSE", "MENU_ID_OPEN_COMMENT", "getMENU_ID_OPEN_COMMENT", "MENU_ID_REPRINT", "getMENU_ID_REPRINT", "MENU_ID_SHARE_TO_CHAT", "getMENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_FAVORITE", "getMENU_ID_SHARE_TO_FAVORITE", "MENU_ID_SHARE_TO_TIMELINE", "getMENU_ID_SHARE_TO_TIMELINE", "MENU_ID_UNFOLLOW", "getMENU_ID_UNFOLLOW", "MENU_ID_UNINTEREST", "getMENU_ID_UNINTEREST", "TAG", "", "getTAG", "()Ljava/lang/String;", "getCommentScene", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "feedExposeInfoChangeListener", "com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$feedExposeInfoChangeListener$1;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "mediaBannerViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "viewCallback", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "createFirstMenu", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "createSecondMenu", "dealMenuClick", "menuItem", "Landroid/view/MenuItem;", "index", "getActivity", "getCommentDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getCreateSecondMoreMenuListener", "getDataAt", "getMediaBannerRecyclerViewPool", "getMediaBannerViewPool", "getMoreMenuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getVideoCore", "getVideoCoreInitializer", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "getVideoData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "initVideoAbout", "initViewCallback", "isFinderSelfScene", "", "keep", "p0", "loadMoreData", "onAttach", "callback", "onBackPressed", "onDetach", "onFavFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isFav", "onFollow", "isFollow", "onLikeComment", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "isLike", "onLikeFeed", "likeAction", "onUIPause", "onUIResume", "requestRefresh", "shareFeed", "plugin-finder_release"})
public abstract class b$a
  implements g, t.a, com.tencent.mm.plugin.finder.presenter.base.a<b.b>, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
{
  private final String TAG;
  final MMActivity iMV;
  final int nPj;
  private final int nPp;
  private final int raj;
  public final i rbo;
  private final int rfG;
  private final int rfH;
  private final int rfI;
  private final int rfJ;
  final int rfK;
  final int rfL;
  final int rfM;
  public b.b rfN;
  private RecyclerView.n rfO;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> rfP;
  private final d rfQ;
  public final int rfR;
  
  private b$a(MMActivity paramMMActivity, int paramInt)
  {
    this.iMV = paramMMActivity;
    this.rfR = paramInt;
    this.TAG = "Finder.FinderLoaderFeedUIContract.Presenter";
    this.rfG = 99;
    this.raj = 100;
    this.nPp = 101;
    this.rfH = 102;
    this.nPj = 103;
    this.rfI = 104;
    this.rfJ = 105;
    this.rfK = 106;
    this.rfL = 107;
    this.rfM = 108;
    this.rfP = new CopyOnWriteArraySet();
    this.rfO = new RecyclerView.n();
    this.rfO.aB(1, 10);
    this.rfO.aB(2, 10);
    this.rbo = new i();
    this.rfQ = new d(this);
  }
  
  public abstract BaseFinderFeed DD(int paramInt);
  
  public final n.c a(final BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.widget.a.e parame)
  {
    d.g.b.k.h(paramBaseFinderFeed, "feed");
    d.g.b.k.h(parame, "sheet");
    return (n.c)new e(this, paramBaseFinderFeed);
  }
  
  public void a(b.b paramb)
  {
    d.g.b.k.h(paramb, "callback");
    this.rfN = paramb;
    cur();
    com.tencent.mm.sdk.b.a.GpY.b((com.tencent.mm.sdk.b.c)this.rfQ);
    paramb = this.rbo;
    b.b localb = this.rfN;
    if (localb == null) {
      d.g.b.k.fOy();
    }
    i.a(paramb, localb.iMV, (i.b)new h(this), 4);
  }
  
  public void a(final BaseFinderFeed paramBaseFinderFeed, MenuItem paramMenuItem, int paramInt)
  {
    d.g.b.k.h(paramBaseFinderFeed, "feed");
    d.g.b.k.h(paramMenuItem, "menuItem");
    ac.i(getTAG(), "getMoreMenuItemSelectedListener feed " + paramBaseFinderFeed + ' ' + paramInt + " menuItem:" + paramMenuItem.getItemId());
    paramInt = paramMenuItem.getItemId();
    if (paramInt == this.rfG)
    {
      paramInt = f(paramBaseFinderFeed);
      if (paramInt >= 0)
      {
        paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.b.rmm;
        com.tencent.mm.plugin.finder.feed.logic.b.a((Context)this.iMV, paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getObjectNonceId(), (d.g.a.b)new a(this, paramBaseFinderFeed));
      }
    }
    do
    {
      do
      {
        return;
        ac.i(getTAG(), "[UNINTEREST] pos error ".concat(String.valueOf(paramInt)));
        return;
      } while (paramInt == this.raj);
      if (paramInt == this.rfH)
      {
        new Bundle();
        k.a.a(com.tencent.mm.plugin.finder.utils.k.rPa, this.iMV, paramBaseFinderFeed.feedObject);
        return;
      }
      if (paramInt == this.nPj)
      {
        paramMenuItem = com.tencent.mm.plugin.finder.utils.k.rPa;
        k.a.a(this.iMV, paramBaseFinderFeed);
        return;
      }
      if (paramInt == this.rfI)
      {
        paramMenuItem = com.tencent.mm.plugin.finder.utils.c.rOA;
        com.tencent.mm.plugin.finder.utils.c.a(paramBaseFinderFeed, this.iMV);
        return;
      }
      if (paramInt == this.nPp)
      {
        paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.a.rml;
        com.tencent.mm.plugin.finder.feed.logic.a.i((Context)this.iMV, paramBaseFinderFeed.feedObject.field_id);
        return;
      }
      if (paramInt == this.rfJ)
      {
        paramMenuItem = new Intent();
        paramMenuItem.putExtra("postRefMediaList", paramBaseFinderFeed.feedObject.getFeedObject().objectDesc.toByteArray());
        n localn = n.rPN;
        paramMenuItem.putExtra("postRefFeedInfo", n.m(paramBaseFinderFeed).toByteArray());
        paramMenuItem.putExtra("postType", paramBaseFinderFeed.feedObject.getMediaType());
        paramMenuItem.putExtra("key_finder_post_from", 5);
        paramBaseFinderFeed = com.tencent.mm.plugin.finder.utils.a.rOv;
        com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI((Context)this.iMV, paramMenuItem);
        return;
      }
      if (paramInt == this.rfL)
      {
        ((com.tencent.mm.plugin.i.a.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.g.class)).a(paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getFeedObject(), paramBaseFinderFeed.feedObject.getObjectNonceId(), true, (com.tencent.mm.plugin.i.a.k)new b(this));
        return;
      }
    } while (paramInt != this.rfK);
    ((com.tencent.mm.plugin.i.a.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.g.class)).a(paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getFeedObject(), paramBaseFinderFeed.feedObject.getObjectNonceId(), false, (com.tencent.mm.plugin.i.a.k)new c(this));
  }
  
  public void a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.base.l paraml)
  {
    d.g.b.k.h(paramBaseFinderFeed, "feed");
    d.g.b.k.h(paraml, "menu");
    n localn = n.rPN;
    if (!n.l(paramBaseFinderFeed)) {
      paraml.a(this.nPp, (CharSequence)this.iMV.getString(2131761332), 2131690646);
    }
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean, int paramInt)
  {
    d.g.b.k.h(paramBaseFinderFeed, "feed");
    Object localObject = com.tencent.mm.ui.component.a.IrY;
    localObject = ((FinderReporterUIC)com.tencent.mm.ui.component.a.q(this.iMV).get(FinderReporterUIC.class)).cGb();
    u localu = u.ruV;
    u.a((anm)localObject, paramInt, paramBaseFinderFeed.feedObject, paramBoolean, paramBaseFinderFeed.showLikeTips);
  }
  
  public final void a(FinderItem paramFinderItem)
  {
    d.g.b.k.h(paramFinderItem, "feed");
    k.a.a(com.tencent.mm.plugin.finder.utils.k.rPa, this.iMV, paramFinderItem);
  }
  
  public final void a(FinderItem paramFinderItem, FinderCommentInfo paramFinderCommentInfo)
  {
    d.g.b.k.h(paramFinderItem, "feed");
    d.g.b.k.h(paramFinderCommentInfo, "comment");
  }
  
  public final void a(FinderItem paramFinderItem, boolean paramBoolean)
  {
    d.g.b.k.h(paramFinderItem, "feed");
    com.tencent.mm.plugin.finder.model.k localk = com.tencent.mm.plugin.finder.model.k.ruF;
    com.tencent.mm.plugin.finder.model.k.a(this.iMV, paramFinderItem, paramBoolean);
  }
  
  public abstract void aQh();
  
  public boolean cuq()
  {
    return false;
  }
  
  public abstract void cur();
  
  public abstract DataBuffer<BaseFinderFeed> cus();
  
  public abstract com.tencent.mm.view.recyclerview.c cut();
  
  public final RecyclerView.n cuu()
  {
    return this.rfO;
  }
  
  public final com.tencent.mm.plugin.finder.view.d cuv()
  {
    Object localObject = this.rfN;
    if (localObject != null)
    {
      com.tencent.mm.plugin.finder.view.d locald = ((b.b)localObject).cuz();
      localObject = locald;
      if (locald != null) {}
    }
    else
    {
      localObject = new com.tencent.mm.plugin.finder.view.d();
    }
    return localObject;
  }
  
  public final n.c d(final BaseFinderFeed paramBaseFinderFeed)
  {
    d.g.b.k.h(paramBaseFinderFeed, "feed");
    return (n.c)new f(this, paramBaseFinderFeed);
  }
  
  public final n.d e(final BaseFinderFeed paramBaseFinderFeed)
  {
    d.g.b.k.h(paramBaseFinderFeed, "feed");
    return (n.d)new g(this, paramBaseFinderFeed);
  }
  
  public final MMActivity getActivity()
  {
    return this.iMV;
  }
  
  public String getTAG()
  {
    return this.TAG;
  }
  
  public final i getVideoCore()
  {
    return this.rbo;
  }
  
  public void keep(com.tencent.mm.vending.e.a parama)
  {
    this.rfP.add(parama);
  }
  
  public final void onBackPressed()
  {
    Object localObject = this.rfN;
    if (localObject != null)
    {
      localObject = ((b.b)localObject).cuz();
      if ((localObject != null) && (((com.tencent.mm.plugin.finder.view.d)localObject).cEG())) {
        ((com.tencent.mm.plugin.finder.view.d)localObject).cEF();
      }
    }
    do
    {
      do
      {
        return;
        localObject = this.rfN;
        if (localObject != null)
        {
          localObject = ((b.b)localObject).rfY;
          if ((localObject != null) && (((TouchMediaPreviewLayout)localObject).JcV))
          {
            ((TouchMediaPreviewLayout)localObject).fuZ();
            return;
          }
        }
        localObject = this.rfN;
        if (localObject != null)
        {
          localObject = ((b.b)localObject).cuA();
          if ((localObject != null) && (((FinderLikeDrawer)localObject).cEG()))
          {
            ((FinderLikeDrawer)localObject).cEF();
            return;
          }
        }
        localObject = this.rfN;
        if (localObject != null)
        {
          localObject = ((b.b)localObject).rfW;
          if (localObject == null) {
            d.g.b.k.aVY("friendLikeDrawer");
          }
          if ((localObject != null) && (((FinderLikeDrawer)localObject).cEG()))
          {
            ((FinderLikeDrawer)localObject).cEF();
            return;
          }
        }
        localObject = this.rfN;
      } while (localObject == null);
      localObject = ((b.b)localObject).iMV;
    } while (localObject == null);
    ((MMActivity)localObject).finish();
  }
  
  public void onDetach()
  {
    com.tencent.mm.plugin.finder.storage.data.e.rEI.clearCache();
    Object localObject = ((Iterable)this.rfP).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.vending.e.a)((Iterator)localObject).next()).dead();
    }
    this.rfP.clear();
    com.tencent.mm.sdk.b.a.GpY.d((com.tencent.mm.sdk.b.c)this.rfQ);
    this.rfN = null;
    localObject = this.rfN;
    if (localObject != null)
    {
      localObject = ((b.b)localObject).cuz();
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.view.d)localObject).onDetach();
      }
    }
  }
  
  public final void onUIPause()
  {
    b.b localb = this.rfN;
    if (localb != null) {
      localb.cuz();
    }
  }
  
  public final void onUIResume()
  {
    Object localObject = this.rfN;
    if (localObject != null)
    {
      localObject = ((b.b)localObject).cuz();
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.view.d)localObject).onUIResume();
      }
    }
  }
  
  public abstract void requestRefresh();
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Ljava/util/LinkedList;", "", "subType", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.b<Integer, LinkedList<Long>>
  {
    a(b.a parama, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$dealMenuClick$2", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.plugin.i.a.k<amg>
  {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$dealMenuClick$3", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class c
    implements com.tencent.mm.plugin.i.a.k<amg>
  {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/view/FinderExposeChangedEventListener;", "tag", "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "getFeedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "notifyAdapter", "", "exposeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExposeInfo;", "plugin-finder_release"})
  public static final class d
    extends com.tencent.mm.plugin.finder.view.e
  {
    private String tag;
    
    d()
    {
      AppMethodBeat.i(165612);
      this.tag = localObject.getTAG();
      AppMethodBeat.o(165612);
    }
    
    public final void a(long paramLong, amp paramamp)
    {
      AppMethodBeat.i(165611);
      Object localObject1 = this.rfS.rfN;
      if (localObject1 != null)
      {
        localObject1 = ((b.b)localObject1).rfT.getRecyclerView();
        if (localObject1 != null)
        {
          Object localObject2 = ((RecyclerView)localObject1).getAdapter();
          if (localObject2 == null)
          {
            paramamp = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
            AppMethodBeat.o(165611);
            throw paramamp;
          }
          localObject2 = com.tencent.mm.view.recyclerview.d.c((com.tencent.mm.view.recyclerview.d)localObject2, paramLong);
          if (localObject2 != null)
          {
            int i = ((RecyclerView.w)localObject2).lv();
            localObject1 = ((RecyclerView)localObject1).getAdapter();
            if (localObject1 != null)
            {
              ((RecyclerView.a)localObject1).b(i, new o(Integer.valueOf(1), paramamp));
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
    
    public final FinderItem uf(long paramLong)
    {
      AppMethodBeat.i(165610);
      Object localObject = this.rfS.rfN;
      if (localObject != null)
      {
        localObject = ((b.b)localObject).rfT.getRecyclerView();
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
            int i = ((RecyclerView.w)localObject).lv();
            localObject = this.rfS.rfN;
            if (localObject == null) {
              d.g.b.k.fOy();
            }
            int j = ((b.b)localObject).qpm;
            localObject = this.rfS.DD(i - j);
            if (localObject != null)
            {
              localObject = ((BaseFinderFeed)localObject).feedObject;
              AppMethodBeat.o(165610);
              return localObject;
            }
            AppMethodBeat.o(165610);
            return null;
          }
        }
      }
      AppMethodBeat.o(165610);
      return null;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class e
    implements n.c
  {
    e(b.a parama, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(165613);
      b.a locala = this.rfS;
      BaseFinderFeed localBaseFinderFeed = paramBaseFinderFeed;
      d.g.b.k.g(paraml, "menu");
      d.g.b.k.h(localBaseFinderFeed, "feed");
      d.g.b.k.h(paraml, "menu");
      locala.iMV.getString(2131755893);
      Object localObject = locala.iMV.getString(2131755892);
      locala.iMV.getString(2131758845);
      if ((localBaseFinderFeed.feedObject.isOnlySelfSee()) || (localBaseFinderFeed.feedObject.isNotShare()))
      {
        localObject = n.rPN;
        n.dh("FinderSafeSelfSeeForward", 2131759344);
        localObject = n.rPN;
        localObject = n.dh("FinderSafeSelfSeeShare", 2131759345);
        n localn = n.rPN;
        n.dh("FinderSafeSelfSeeCollect", 2131759343);
      }
      for (boolean bool = true;; bool = false)
      {
        paraml.a(locala.nPj, (CharSequence)localObject, 2131689817, 0, bool);
        paraml = com.tencent.mm.plugin.finder.report.d.rxr;
        com.tencent.mm.plugin.finder.report.d.H(localBaseFinderFeed.lx(), locala.rfR);
        paraml = FinderReporterUIC.seQ;
        paraml = FinderReporterUIC.a.eV((Context)locala.iMV);
        if (paraml != null)
        {
          paraml = FinderReporterUIC.b(paraml);
          if (paraml != null)
          {
            paraml.ctb().ud(localBaseFinderFeed.lx());
            AppMethodBeat.o(165613);
            return;
          }
        }
        AppMethodBeat.o(165613);
        return;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class f
    implements n.c
  {
    f(b.a parama, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(165614);
      b.a locala = this.rfS;
      BaseFinderFeed localBaseFinderFeed = paramBaseFinderFeed;
      d.g.b.k.g(paraml, "menu");
      locala.a(localBaseFinderFeed, paraml);
      AppMethodBeat.o(165614);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class g
    implements n.d
  {
    g(b.a parama, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(165615);
      b.a locala = this.rfS;
      BaseFinderFeed localBaseFinderFeed = paramBaseFinderFeed;
      d.g.b.k.g(paramMenuItem, "menuItem");
      locala.a(localBaseFinderFeed, paramMenuItem, paramInt);
      AppMethodBeat.o(165615);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$getVideoCoreInitializer$1", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "getData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "isUseAutoPlay", "", "isUsePreload", "onAttachRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
  public static final class h
    implements i.b
  {
    public final RecyclerView cuw()
    {
      AppMethodBeat.i(165616);
      Object localObject = this.rfS.rfN;
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      localObject = ((b.b)localObject).rfT.getRecyclerView();
      AppMethodBeat.o(165616);
      return localObject;
    }
    
    public final DataBuffer<BaseFinderFeed> cux()
    {
      AppMethodBeat.i(201517);
      DataBuffer localDataBuffer = this.rfS.cus();
      AppMethodBeat.o(201517);
      return localDataBuffer;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.b.a
 * JD-Core Version:    0.7.0.1
 */