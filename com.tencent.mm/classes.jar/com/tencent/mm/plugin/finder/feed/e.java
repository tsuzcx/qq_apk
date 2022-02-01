package com.tencent.mm.plugin.finder.feed;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.h;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hj;
import com.tencent.mm.g.a.hk;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.model.n;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.finder.storage.data.d.a;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer;
import com.tencent.mm.plugin.finder.view.FinderCommentFooter;
import com.tencent.mm.plugin.finder.view.FinderCommentFooter.b;
import com.tencent.mm.plugin.finder.view.a.a;
import com.tencent.mm.plugin.finder.view.a.d;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.alr;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.d.c;
import com.tencent.mm.view.recyclerview.d.d;
import d.a.j;
import d.g.b.q;
import d.g.b.y.d;
import d.g.b.y.f;
import d.l;
import d.o;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "authorMentioned", "", "getAuthorMentioned", "()Z", "setAuthorMentioned", "(Z)V", "blinkRefComment", "canPreload", "getCanPreload", "setCanPreload", "commentChangeEventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderCommentChangeEvent;", "getCommentChangeEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "commentClose", "getCommentClose", "setCommentClose", "commentCount", "", "getCommentCount", "()I", "commentDataObserver", "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentDataObserver$1", "Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentDataObserver$1;", "commentErrorListener", "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentErrorListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentErrorListener$1;", "getContext", "()Landroid/content/Context;", "dataLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentLoader;", "diffDataChangeHelper", "Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$DiffDataChangeHelper;", "value", "downContinue", "setDownContinue", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "setDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;)V", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "hasExpandComment", "getHasExpandComment", "setHasExpandComment", "hitCache", "isDetached", "setDetached", "isSingleMode", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "oldVersion", "onCloseDrawerCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "refCommentId", "", "resources", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "safeMode", "getSafeMode", "setSafeMode", "scene", "getScene", "setScene", "(I)V", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "getTaskExecutor", "()Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "setTaskExecutor", "(Lcom/tencent/mm/loader/loader/SingleTaskExecutor;)V", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "upContinue", "setUpContinue", "useCache", "viewCallback", "Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;)V", "calculateCommentCount", "canExpand", "comment", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "down", "checkDownContinue", "", "checkUpContinue", "deleteComment", "item", "expandLevel2Comments", "rootComment", "expandTopLevel2Comment", "", "respList", "expandWhenRefToLevel2Comment", "filterText", "", "origin", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getCommentScene", "getCurrentFeed", "getEditText", "Lcom/tencent/mm/ui/widget/MMEditText;", "getEditTextAvatar", "Landroid/widget/ImageView;", "getFirstFriendPos", "getFirstOtherPos", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getRootComment", "rootId", "getRootCommentIndex", "getUserScene", "insertLevel2CommentsAndNotify", "level2Comments", "", "isCommentClose", "isSafeMode", "isWxScene", "keep", "p0", "loadMoreData", "loadMoreLevel2Comments", "mergeLocalLevel2Comments", "localLevel2Comments", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "onAttach", "builder", "displayScene", "replyCommentObj", "oldVer", "callback", "onClickComment", "view", "Landroid/view/View;", "onClickCommentDelete", "onClickMore", "onClickResendComment", "position", "onDetach", "onExpandClick", "onItemClick", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "holder", "onItemLongClick", "onLikeComment", "onModeChange", "from", "to", "onRecoverRecyclerViewTrans", "onReply", "sceneForReply", "onScrollIdle", "lastVisiblePosition", "preloadNextPage", "refreshData", "setCommentCountView", "transToDiscoverComment", "Companion", "DiffDataChangeHelper", "plugin-finder_release"})
public final class e
  implements CommentDrawerContract.NPresenter, FinderCommentFooter.b, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>, d.c<com.tencent.mm.view.recyclerview.e>, d.d<com.tencent.mm.view.recyclerview.e>
{
  public static final e.a sdy;
  final Context context;
  private boolean dNY;
  private volatile boolean isDetached;
  private volatile com.tencent.mm.bw.b lastBuffer;
  private long rQR;
  public boolean rUX;
  private boolean rUr;
  private FinderItem scK;
  int scene;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> scf;
  final com.tencent.mm.plugin.finder.feed.model.c sdh;
  com.tencent.mm.plugin.finder.view.builder.b sdi;
  private b sdj;
  private CommentDrawerContract.CloseDrawerCallback sdk;
  private boolean sdl;
  private boolean sdm;
  private boolean sdn;
  private boolean sdo;
  private boolean sdp;
  private com.tencent.mm.loader.g.i sdq;
  boolean sdr;
  private boolean sds;
  boolean sdt;
  private FinderCommentDrawer sdu;
  private e sdv;
  private final com.tencent.mm.sdk.b.c<hj> sdw;
  private final d sdx;
  Dialog tipDialog;
  
  static
  {
    AppMethodBeat.i(165695);
    sdy = new e.a((byte)0);
    AppMethodBeat.o(165695);
  }
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(202208);
    this.context = paramContext;
    this.sdh = new com.tencent.mm.plugin.finder.feed.model.c();
    this.scf = new CopyOnWriteArraySet();
    this.scene = 2;
    this.sdn = true;
    this.rUr = true;
    this.dNY = true;
    this.isDetached = true;
    this.sdv = new e(this);
    this.sdw = ((com.tencent.mm.sdk.b.c)new c(this));
    this.sdx = new d(this);
    AppMethodBeat.o(202208);
  }
  
  private final ImageView cCO()
  {
    AppMethodBeat.i(165689);
    Object localObject = this.sdi;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.b)localObject).cQv();
      if (localObject != null)
      {
        localObject = ((FinderCommentFooter)localObject).getAvatarView();
        AppMethodBeat.o(165689);
        return localObject;
      }
    }
    AppMethodBeat.o(165689);
    return null;
  }
  
  private final int getCommentCount()
  {
    AppMethodBeat.i(165672);
    Object localObject = new StringBuilder("calculateCommentCount ").append(this.sdh.data.size()).append(", ");
    FinderItem localFinderItem = this.scK;
    if (localFinderItem == null) {
      d.g.b.p.bdF("feedObj");
    }
    ae.i("Finder.DrawerPresenter", localFinderItem.getCommentCount());
    int i = this.sdh.data.size();
    localObject = this.scK;
    if (localObject == null) {
      d.g.b.p.bdF("feedObj");
    }
    i = Math.max(i, ((FinderItem)localObject).getCommentCount());
    AppMethodBeat.o(165672);
    return i;
  }
  
  private final MMEditText getEditText()
  {
    AppMethodBeat.i(165688);
    Object localObject = this.sdi;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.b)localObject).cQv();
      if (localObject != null)
      {
        localObject = ((FinderCommentFooter)localObject).getEditText();
        AppMethodBeat.o(165688);
        return localObject;
      }
    }
    AppMethodBeat.o(165688);
    return null;
  }
  
  private final Resources getResources()
  {
    AppMethodBeat.i(165691);
    Object localObject = this.sdi;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.b)localObject).getContext();
      if (localObject != null)
      {
        localObject = ((Context)localObject).getResources();
        AppMethodBeat.o(165691);
        return localObject;
      }
    }
    AppMethodBeat.o(165691);
    return null;
  }
  
  private final void lP(boolean paramBoolean)
  {
    AppMethodBeat.i(165670);
    this.sdm = paramBoolean;
    ae.i("Finder.DrawerPresenter", "set upContinue ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(165670);
  }
  
  private final void lQ(boolean paramBoolean)
  {
    AppMethodBeat.i(165671);
    this.sdn = paramBoolean;
    ae.i("Finder.DrawerPresenter", "set downContinue ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(165671);
  }
  
  private final void lR(final boolean paramBoolean)
  {
    AppMethodBeat.i(165692);
    com.tencent.mm.loader.g.i locali = this.sdq;
    if (locali != null)
    {
      locali.a(new com.tencent.mm.loader.g.h((d.g.a.b)new t(this, paramBoolean)));
      AppMethodBeat.o(165692);
      return;
    }
    AppMethodBeat.o(165692);
  }
  
  public final void EL(int paramInt)
  {
    AppMethodBeat.i(178247);
    Object localObject = this.sdh.data;
    ae.i("Finder.DrawerPresenter", "preloadNextPage, onScrollIdle, lastVisiblePosition:" + paramInt + ", dataList size:" + ((ArrayList)localObject).size() + ", canPreload:" + this.sdr);
    if ((paramInt >= 0) && (paramInt < ((ArrayList)localObject).size()))
    {
      int i = ((ArrayList)localObject).size();
      localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
      if ((i - paramInt <= com.tencent.mm.plugin.finder.storage.b.cIg()) && (this.sdr))
      {
        this.sdr = false;
        localObject = this.sdq;
        if (localObject != null)
        {
          ((com.tencent.mm.loader.g.i)localObject).a(new com.tencent.mm.loader.g.h((d.g.a.b)new s(this)));
          AppMethodBeat.o(178247);
          return;
        }
      }
    }
    AppMethodBeat.o(178247);
  }
  
  public final void a(View paramView, n paramn)
  {
    AppMethodBeat.i(202205);
    d.g.b.p.h(paramView, "view");
    d.g.b.p.h(paramn, "item");
    paramView = new com.tencent.mm.ui.widget.a.e(paramView.getContext(), 1, false);
    FinderItem localFinderItem = this.scK;
    if (localFinderItem == null) {
      d.g.b.p.bdF("feedObj");
    }
    paramView.a((n.d)new a.a(paramn, localFinderItem.getUserName()));
    paramView.a((n.e)new a.d(paramn, (d.g.a.b)new p(this)));
    paramView.cPF();
    AppMethodBeat.o(202205);
  }
  
  public final void a(ImageView paramImageView, int paramInt)
  {
    AppMethodBeat.i(165677);
    d.g.b.p.h(paramImageView, "view");
    if (paramInt < 0)
    {
      ae.i("Finder.DrawerPresenter", "onLikeComment position:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(165677);
      return;
    }
    paramImageView = this.sdh.EO(paramInt);
    Object localObject1 = com.tencent.mm.plugin.finder.upload.action.g.sVv;
    localObject1 = com.tencent.mm.plugin.finder.upload.action.g.cNz();
    Object localObject2 = this.scK;
    if (localObject2 == null) {
      d.g.b.p.bdF("feedObj");
    }
    boolean bool1 = ((com.tencent.mm.plugin.finder.upload.action.g)localObject1).a(((FinderItem)localObject2).getId(), paramImageView.ste, this.scene);
    ae.i("Finder.DrawerPresenter", "[onLikeComment] position=" + paramInt + " isLike=" + bool1 + " commentObj=" + paramImageView.ste);
    if (!bool1) {
      bool1 = true;
    }
    boolean bool2;
    int i;
    for (;;)
    {
      if ((this.context instanceof MMActivity))
      {
        localObject1 = com.tencent.mm.ui.component.a.KEX;
        localObject1 = this.context;
        if (localObject1 == null)
        {
          paramImageView = new d.v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(165677);
          throw paramImageView;
          bool1 = false;
        }
        else
        {
          localObject1 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)localObject1).get(FinderReporterUIC.class)).cQZ();
          localObject2 = com.tencent.mm.plugin.finder.utils.p.sXz;
          localObject2 = this.scK;
          if (localObject2 == null) {
            d.g.b.p.bdF("feedObj");
          }
          bool2 = com.tencent.mm.plugin.finder.utils.p.ajU(((FinderItem)localObject2).getUserName());
          localObject2 = com.tencent.mm.plugin.finder.storage.b.sHP;
          if (((Number)com.tencent.mm.plugin.finder.storage.b.cJa().value()).intValue() == 1) {
            break label511;
          }
          localObject2 = com.tencent.mm.plugin.finder.storage.b.sHP;
          if (com.tencent.mm.plugin.finder.storage.b.cIj() != 1) {
            break label511;
          }
          i = 1;
          if ((bool2) && (i == 1))
          {
            if (!bool1) {
              break label519;
            }
            paramImageView.ste.FM(paramImageView.ste.cLl().displayFlag | 0x1);
          }
        }
      }
    }
    for (;;)
    {
      localObject2 = x.stn;
      localObject2 = this.scK;
      if (localObject2 == null) {
        d.g.b.p.bdF("feedObj");
      }
      long l = ((FinderItem)localObject2).getId();
      localObject2 = this.scK;
      if (localObject2 == null) {
        d.g.b.p.bdF("feedObj");
      }
      x.a((arn)localObject1, l, ((FinderItem)localObject2).getObjectNonceId(), paramImageView.ste, bool1, this.scene, bool2);
      paramImageView = com.tencent.mm.ui.component.a.KEX;
      paramImageView = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this.context).get(FinderReporterUIC.class));
      if (paramImageView != null)
      {
        paramImageView = paramImageView.cAI();
        localObject1 = this.scK;
        if (localObject1 == null) {
          d.g.b.p.bdF("feedObj");
        }
        paramImageView.wp(((FinderItem)localObject1).getId());
      }
      paramImageView = this.sdi;
      if (paramImageView == null) {
        break label542;
      }
      paramImageView = paramImageView.cEX();
      if (paramImageView == null) {
        break label542;
      }
      paramImageView = paramImageView.getRecyclerView();
      if (paramImageView == null) {
        break label542;
      }
      paramImageView = paramImageView.getAdapter();
      if (paramImageView == null) {
        break label542;
      }
      paramImageView.b(paramInt, Integer.valueOf(1));
      AppMethodBeat.o(165677);
      return;
      label511:
      i = this.scene;
      break;
      label519:
      paramImageView.ste.FM(paramImageView.ste.cLl().displayFlag & 0xFFFFFFFE);
    }
    label542:
    AppMethodBeat.o(165677);
  }
  
  public final void a(final n paramn)
  {
    AppMethodBeat.i(165678);
    d.g.b.p.h(paramn, "item");
    final Context localContext = this.context;
    if (localContext != null)
    {
      com.tencent.mm.ui.base.h.a(localContext, 2131759309, 0, (DialogInterface.OnClickListener)new f(this, localContext, paramn), null);
      AppMethodBeat.o(165678);
      return;
    }
    AppMethodBeat.o(165678);
  }
  
  public final void a(final n paramn, final boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(178245);
    d.g.b.p.h(paramn, "rootComment");
    this.sdt = true;
    final y.d locald = new y.d();
    Object localObject1 = FinderReporterUIC.tnG;
    localObject1 = FinderReporterUIC.a.fc(this.context);
    int i;
    if (localObject1 != null)
    {
      i = ((FinderReporterUIC)localObject1).sch;
      locald.NiW = i;
      if (!paramBoolean) {
        break label303;
      }
      localObject1 = paramn.ste.cLl().levelTwoComment;
      if (!bu.ht((List)localObject1)) {
        break label122;
      }
      i = j;
    }
    for (;;)
    {
      if (i == 0) {
        break label243;
      }
      localObject1 = com.tencent.mm.plugin.finder.report.i.syT;
      com.tencent.mm.plugin.finder.report.i.a(paramn, 1, locald.NiW);
      AppMethodBeat.o(178245);
      return;
      i = 0;
      break;
      label122:
      Object localObject2 = ((Iterable)this.sdh.data).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          long l = ((n)((Iterator)localObject2).next()).ste.cLl().commentId;
          d.g.b.p.g(localObject1, "level2Comments");
          if (l == ((FinderCommentInfo)((LinkedList)localObject1).getFirst()).commentId)
          {
            i = j;
            break;
          }
        }
      }
      localObject2 = this.sdq;
      if (localObject2 != null) {
        ((com.tencent.mm.loader.g.i)localObject2).a(new com.tencent.mm.loader.g.h((d.g.a.b)new g(this, (LinkedList)localObject1, paramn)));
      }
      i = 1;
    }
    label243:
    localObject1 = com.tencent.mm.plugin.finder.report.i.syT;
    com.tencent.mm.plugin.finder.report.i.a(paramn, 2, locald.NiW);
    for (;;)
    {
      localObject1 = this.sdq;
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.loader.g.i)localObject1).a(new com.tencent.mm.loader.g.h((d.g.a.b)new k(this, paramn, locald, paramBoolean)));
      AppMethodBeat.o(178245);
      return;
      label303:
      localObject1 = com.tencent.mm.plugin.finder.report.i.syT;
      com.tencent.mm.plugin.finder.report.i.a(paramn, 3, locald.NiW);
    }
    AppMethodBeat.o(178245);
  }
  
  public final void a(FinderCommentDrawer paramFinderCommentDrawer, final com.tencent.mm.plugin.finder.view.builder.b paramb, FinderItem paramFinderItem, CommentDrawerContract.CloseDrawerCallback paramCloseDrawerCallback, int paramInt, boolean paramBoolean1, long paramLong, ab paramab, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    AppMethodBeat.i(202201);
    d.g.b.p.h(paramFinderCommentDrawer, "drawer");
    d.g.b.p.h(paramb, "builder");
    d.g.b.p.h(paramFinderItem, "feedObj");
    this.isDetached = false;
    ae.i("Finder.DrawerPresenter", "onAttach " + paramFinderItem.getId() + ", " + paramInt + ", " + paramBoolean1 + ", " + paramLong);
    this.sdi = paramb;
    this.sdu = paramFinderCommentDrawer;
    this.scK = paramFinderItem;
    this.sdo = paramBoolean1;
    this.scene = paramInt;
    this.sdk = paramCloseDrawerCallback;
    this.rQR = paramLong;
    this.dNY = paramBoolean2;
    this.sdp = paramBoolean3;
    this.sdq = new com.tencent.mm.loader.g.i("FinderCommentExecutor");
    paramFinderCommentDrawer = this.sdq;
    if (paramFinderCommentDrawer != null) {
      paramFinderCommentDrawer.start();
    }
    paramCloseDrawerCallback = this.sdh.b(paramFinderItem.getId(), paramLong, paramBoolean2);
    paramFinderCommentDrawer = (com.tencent.mm.plugin.finder.storage.data.e.b)paramCloseDrawerCallback.first;
    paramBoolean2 = ((Boolean)paramCloseDrawerCallback.second).booleanValue();
    locald = new y.d();
    locald.NiW = paramFinderCommentDrawer.pos;
    paramCloseDrawerCallback = paramFinderCommentDrawer.lastBuffer;
    paramBoolean3 = paramFinderCommentDrawer.sdm;
    boolean bool1 = paramFinderCommentDrawer.sdn;
    boolean bool2 = paramFinderCommentDrawer.sKK;
    this.lastBuffer = paramCloseDrawerCallback;
    this.sdl = paramBoolean2;
    lP(paramBoolean3);
    lQ(bool1);
    this.rUr = paramBoolean5;
    this.sdr = true;
    this.sds = paramBoolean4;
    this.sdt = bool2;
    if (this.sdm)
    {
      paramb.my(true);
      paramb.cQv().setFooterMode(0);
      if (paramLong != 0L) {
        break label803;
      }
      paramFinderCommentDrawer = this.sdi;
      if (paramFinderCommentDrawer != null)
      {
        paramFinderCommentDrawer = paramFinderCommentDrawer.cQv();
        if (paramFinderCommentDrawer != null)
        {
          paramCloseDrawerCallback = com.tencent.mm.plugin.finder.utils.p.sXz;
          paramFinderCommentDrawer.gF(com.tencent.mm.plugin.finder.utils.p.Gk(this.scene), paramFinderItem.getNickName());
        }
      }
    }
    label803:
    label824:
    label860:
    label989:
    label1002:
    for (;;)
    {
      paramb.cEX().getRecyclerView().setLayoutFrozen(false);
      this.sdj = new b(paramb.cEX().getRecyclerView());
      com.tencent.mm.sdk.b.a.IvT.c(this.sdw);
      try
      {
        paramFinderCommentDrawer = paramb.cEX().getRecyclerView().getAdapter();
        if (paramFinderCommentDrawer != null) {
          paramFinderCommentDrawer.a((RecyclerView.c)this.sdx);
        }
      }
      catch (IllegalStateException paramFinderCommentDrawer)
      {
        for (;;)
        {
          int i;
          int j;
          ae.printErrStackTrace("Finder.DrawerPresenter", (Throwable)paramFinderCommentDrawer, "", new Object[0]);
          continue;
          paramb.cQs().setText((CharSequence)paramb.getContext().getResources().getString(2131759162, new Object[] { com.tencent.mm.plugin.finder.utils.h.fR(this.scene, getCommentCount()) }));
          continue;
          paramFinderCommentDrawer = com.tencent.mm.plugin.finder.api.c.rPy;
          paramFinderCommentDrawer = com.tencent.mm.plugin.finder.api.c.a.ahT(com.tencent.mm.model.v.aAK());
          if (paramFinderCommentDrawer != null)
          {
            paramCloseDrawerCallback = paramFinderCommentDrawer.czm();
            paramFinderCommentDrawer = paramCloseDrawerCallback;
            if (paramCloseDrawerCallback != null) {}
          }
          else
          {
            paramFinderCommentDrawer = "";
          }
          paramCloseDrawerCallback = com.tencent.mm.plugin.finder.loader.i.srW;
          paramCloseDrawerCallback = com.tencent.mm.plugin.finder.loader.i.cEo();
          paramFinderCommentDrawer = new com.tencent.mm.plugin.finder.loader.a(paramFinderCommentDrawer);
          paramab = cCO();
          if (paramab == null) {
            d.g.b.p.gkB();
          }
          Object localObject = com.tencent.mm.plugin.finder.loader.i.srW;
          paramCloseDrawerCallback.a(paramFinderCommentDrawer, paramab, com.tencent.mm.plugin.finder.loader.i.a(i.a.srZ));
          continue;
          if ((paramBoolean2) && (locald.NiW == 0) && (paramLong == 0L) && (!this.sdt))
          {
            this.lastBuffer = null;
            lQ(true);
            lR(true);
          }
          else
          {
            paramFinderCommentDrawer = this.sdi;
            if (paramFinderCommentDrawer != null)
            {
              paramFinderCommentDrawer = paramFinderCommentDrawer.cEX();
              if (paramFinderCommentDrawer != null)
              {
                paramFinderCommentDrawer = paramFinderCommentDrawer.getRecyclerView();
                if (paramFinderCommentDrawer != null)
                {
                  paramFinderCommentDrawer = paramFinderCommentDrawer.getAdapter();
                  if (paramFinderCommentDrawer != null) {
                    paramFinderCommentDrawer.notifyDataSetChanged();
                  }
                }
              }
            }
            paramFinderCommentDrawer = this.sdi;
            if (paramFinderCommentDrawer != null)
            {
              paramFinderCommentDrawer = paramFinderCommentDrawer.cEX();
              if (paramFinderCommentDrawer != null)
              {
                paramFinderCommentDrawer = paramFinderCommentDrawer.getRecyclerView();
                if (paramFinderCommentDrawer != null)
                {
                  paramFinderCommentDrawer.post((Runnable)new o(this, locald));
                  continue;
                  paramb.cQw().setBackgroundColorRes(2131099819);
                  continue;
                  paramb.cQw().setSquaresBackgroundResource(2131101053);
                  paramb.cQw().setBackgroundColorRes(2131101053);
                  paramb.getHeaderLayout().setVisibility(8);
                  paramb.cEX().setVisibility(8);
                  paramFinderCommentDrawer = getEditText();
                  if (paramFinderCommentDrawer != null) {
                    paramFinderCommentDrawer.requestFocus();
                  }
                  if (!this.rUX)
                  {
                    paramFinderCommentDrawer = this.sdi;
                    if (paramFinderCommentDrawer != null)
                    {
                      paramFinderCommentDrawer = paramFinderCommentDrawer.cQv();
                      if (paramFinderCommentDrawer != null) {
                        paramFinderCommentDrawer.bY(true);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      paramb.cEX().setActionCallback((RefreshLoadMoreLayout.a)new m(this));
      paramb.cQv().setModeChangeCallback((FinderCommentFooter.b)this);
      if (getCommentCount() > 0) {
        break label1025;
      }
      paramb.cQs().setText((CharSequence)paramb.getContext().getResources().getString(2131759158));
      paramb.cQv().getReplyBtn().setOnClickListener((View.OnClickListener)new n(this, paramb));
      if (paramab != null)
      {
        paramFinderCommentDrawer = paramb.cQv();
        paramCloseDrawerCallback = com.tencent.mm.plugin.finder.utils.p.sXz;
        paramCloseDrawerCallback = com.tencent.mm.plugin.finder.utils.p.Gk(this.scene);
        localObject = com.tencent.mm.plugin.finder.utils.p.sXz;
        paramFinderCommentDrawer.c(paramCloseDrawerCallback, com.tencent.mm.plugin.finder.utils.p.gC(paramab.getUsername(), paramab.VK()), paramab);
      }
      if (cCO() != null)
      {
        if (paramInt != 2) {
          break label1069;
        }
        com.tencent.mm.ui.f.a.a.c(cCO(), com.tencent.mm.model.v.aAC());
      }
      paramFinderCommentDrawer = this.sdi;
      if (paramFinderCommentDrawer != null) {
        paramFinderCommentDrawer.hideLoading();
      }
      if (paramBoolean1) {
        break label1303;
      }
      if ((this.sdh.data.size() != 0) || (paramBoolean2)) {
        break label1157;
      }
      lR(true);
      paramFinderCommentDrawer = this.sdi;
      if (paramFinderCommentDrawer != null) {
        paramFinderCommentDrawer.showLoading();
      }
      paramFinderCommentDrawer = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cIL().value()).intValue() != 1) {
        break label1290;
      }
      paramb.cQw().setBackgroundColorRes(2131101053);
      paramb.cQw().setSquaresBackgroundResource(2131234858);
      paramb.cEX().setVisibility(0);
      paramb.getHeaderLayout().setVisibility(0);
      if (paramFinderItem.getCommentCount() == 0)
      {
        paramFinderCommentDrawer = getEditText();
        if (paramFinderCommentDrawer != null) {
          paramFinderCommentDrawer.postDelayed((Runnable)new l(paramFinderCommentDrawer, this), 200L);
        }
      }
      if (!this.sdn)
      {
        paramFinderCommentDrawer = this.sdi;
        if (paramFinderCommentDrawer != null)
        {
          paramFinderCommentDrawer = paramFinderCommentDrawer.cEX();
          if (paramFinderCommentDrawer != null) {
            RefreshLoadMoreLayout.f(paramFinderCommentDrawer);
          }
        }
      }
      this.sdv.alive();
      AppMethodBeat.o(202201);
      return;
      paramb.my(false);
      paramFinderCommentDrawer = this.sdi;
      if (paramFinderCommentDrawer == null) {
        break;
      }
      paramFinderCommentDrawer = paramFinderCommentDrawer.cQw();
      if (paramFinderCommentDrawer == null) {
        break;
      }
      paramFinderCommentDrawer.fUI();
      break;
      paramFinderCommentDrawer = (List)this.sdh.data;
      i = 0;
      paramFinderCommentDrawer = paramFinderCommentDrawer.iterator();
      if (paramFinderCommentDrawer.hasNext()) {
        if (((n)paramFinderCommentDrawer.next()).ste.cLl().commentId == paramLong)
        {
          j = 1;
          if (j == 0) {
            break label989;
          }
        }
      }
      for (;;)
      {
        if (i < 0) {
          break label1002;
        }
        localObject = (n)this.sdh.data.get(i);
        ((n)localObject).sta = true;
        paramFinderCommentDrawer = this.sdi;
        if (paramFinderCommentDrawer == null) {
          break;
        }
        FinderCommentFooter localFinderCommentFooter = paramFinderCommentDrawer.cQv();
        if (localFinderCommentFooter == null) {
          break;
        }
        paramFinderCommentDrawer = com.tencent.mm.plugin.finder.utils.p.sXz;
        String str1 = com.tencent.mm.plugin.finder.utils.p.Gk(this.scene);
        paramFinderCommentDrawer = com.tencent.mm.plugin.finder.utils.p.sXz;
        String str2 = ((n)localObject).ste.getUsername();
        paramCloseDrawerCallback = ((n)localObject).ste.VK();
        paramFinderCommentDrawer = paramCloseDrawerCallback;
        if (paramCloseDrawerCallback == null) {
          paramFinderCommentDrawer = "";
        }
        localFinderCommentFooter.c(str1, com.tencent.mm.plugin.finder.utils.p.gC(str2, paramFinderCommentDrawer), ((n)localObject).ste);
        break;
        j = 0;
        break label860;
        i += 1;
        break label824;
        i = -1;
      }
    }
  }
  
  public final void ag(View paramView, int paramInt)
  {
    AppMethodBeat.i(165681);
    d.g.b.p.h(paramView, "view");
    if (paramInt < 0)
    {
      ae.i("Finder.DrawerPresenter", "onClickResendComment position:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(165681);
      return;
    }
    paramView = this.sdh.EO(paramInt).ste;
    if (paramView.field_state == -1)
    {
      Object localObject = com.tencent.mm.plugin.finder.upload.b.sTP;
      localObject = com.tencent.mm.plugin.finder.upload.b.cNg();
      d.g.b.p.h(paramView, "unsentComment");
      ae.i(com.tencent.mm.plugin.finder.upload.b.TAG, "rePost ".concat(String.valueOf(paramView)));
      paramView.field_state = 1;
      paramView.field_canRemove = 0;
      paramView.xj(ch.aDa() / 1000L);
      paramView.field_postTime = ch.aDa();
      paramView.field_tryCount = 0L;
      ((com.tencent.mm.plugin.finder.upload.b)localObject).a(new com.tencent.mm.plugin.finder.upload.a(paramView));
      paramView = this.sdi;
      if (paramView != null)
      {
        paramView = paramView.cEX();
        if (paramView != null)
        {
          paramView = paramView.getRecyclerView();
          if (paramView != null)
          {
            localObject = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter", "onClickResendComment", "(Landroid/view/View;I)V", "Undefined", "scrollToPosition", "(I)V");
            paramView.ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter", "onClickResendComment", "(Landroid/view/View;I)V", "Undefined", "scrollToPosition", "(I)V");
            AppMethodBeat.o(165681);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(165681);
  }
  
  public final boolean b(n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(178246);
    d.g.b.p.h(paramn, "comment");
    Object localObject1;
    int i;
    if (paramn.ste.field_actionInfo.rQN == 0L)
    {
      if (!paramBoolean)
      {
        AppMethodBeat.o(178246);
        return false;
      }
      localObject1 = this.sdh;
      d.g.b.p.h(paramn, "root");
      if (paramn.ste.cLl().commentId != 0L)
      {
        localObject1 = ((Iterable)((com.tencent.mm.plugin.finder.feed.model.c)localObject1).data).iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
        } while (((n)((Iterator)localObject1).next()).ste.field_actionInfo.rQN != paramn.ste.cLl().commentId);
      }
      for (i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(178246);
        return true;
      }
      AppMethodBeat.o(178246);
      return false;
    }
    if (paramBoolean)
    {
      localObject1 = this.sdh;
      d.g.b.p.h(paramn, "level2Comment");
      Iterator localIterator = ((Iterable)((com.tencent.mm.plugin.finder.feed.model.c)localObject1).data).iterator();
      i = 0;
      int j = -1;
      int k;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Object localObject2 = localIterator.next();
          k = i + 1;
          if (i < 0) {
            j.gkd();
          }
          localObject2 = (n)localObject2;
          if (com.tencent.mm.plugin.finder.feed.model.c.b((n)localObject2, paramn))
          {
            j = i;
            i = k;
          }
          else if ((j >= 0) && (com.tencent.mm.plugin.finder.feed.model.c.a((n)localObject2, paramn)))
          {
            ae.d(((com.tencent.mm.plugin.finder.feed.model.c)localObject1).TAG, "hasLevel2ItemAfter cur:" + j + ", after:" + i);
          }
        }
      }
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label321;
        }
        AppMethodBeat.o(178246);
        return true;
        i = k;
        break;
      }
      label321:
      AppMethodBeat.o(178246);
      return false;
    }
    if (!this.sdh.c(paramn))
    {
      AppMethodBeat.o(178246);
      return true;
    }
    AppMethodBeat.o(178246);
    return false;
  }
  
  public final int cCL()
  {
    AppMethodBeat.i(202202);
    Object localObject = FinderReporterUIC.tnG;
    localObject = FinderReporterUIC.a.fc(this.context);
    if (localObject != null)
    {
      int i = ((FinderReporterUIC)localObject).sch;
      AppMethodBeat.o(202202);
      return i;
    }
    AppMethodBeat.o(202202);
    return 0;
  }
  
  public final int cCM()
  {
    return this.scene;
  }
  
  public final FinderItem cCN()
  {
    AppMethodBeat.i(165684);
    FinderItem localFinderItem = this.scK;
    if (localFinderItem == null) {
      d.g.b.p.bdF("feedObj");
    }
    AppMethodBeat.o(165684);
    return localFinderItem;
  }
  
  public final void cCP()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(178243);
    Object localObject3;
    if (getCommentCount() <= 0)
    {
      localObject2 = this.sdi;
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject2).cQs();
        if (localObject2 != null)
        {
          localObject3 = getResources();
          if (localObject3 != null) {
            localObject1 = ((Resources)localObject3).getString(2131759158);
          }
          ((TextView)localObject2).setText((CharSequence)localObject1);
          AppMethodBeat.o(178243);
          return;
        }
      }
      AppMethodBeat.o(178243);
      return;
    }
    localObject1 = this.sdi;
    if (localObject1 != null)
    {
      localObject3 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).cQs();
      if (localObject3 != null)
      {
        Resources localResources = getResources();
        localObject1 = localObject2;
        if (localResources != null) {
          localObject1 = localResources.getString(2131759162, new Object[] { String.valueOf(getCommentCount()) });
        }
        ((TextView)localObject3).setText((CharSequence)localObject1);
        AppMethodBeat.o(178243);
        return;
      }
    }
    AppMethodBeat.o(178243);
  }
  
  public final int cCQ()
  {
    AppMethodBeat.i(202206);
    Object localObject = this.sdh.data;
    int i;
    if (!bu.ht((List)localObject))
    {
      localObject = (n)j.jm((List)localObject);
      if (localObject != null)
      {
        localObject = ((n)localObject).ste;
        if (localObject != null)
        {
          if (((ab)localObject).cLr() != true) {
            break label71;
          }
          i = 0;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(202206);
      return i;
      i = -1;
      continue;
      label71:
      i = -1;
    }
  }
  
  public final int cCR()
  {
    AppMethodBeat.i(202207);
    Object localObject1 = this.sdh.data;
    if (!bu.ht((List)localObject1))
    {
      localObject1 = ((Iterable)localObject1).iterator();
      int i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          j.gkd();
        }
        localObject2 = (n)localObject2;
        if ((((n)localObject2).ste.field_actionInfo.rQN == 0L) && (!((n)localObject2).ste.cLr()))
        {
          AppMethodBeat.o(202207);
          return i;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(202207);
    return -1;
  }
  
  public final RecyclerView.h eO(Context paramContext)
  {
    AppMethodBeat.i(165686);
    d.g.b.p.h(paramContext, "context");
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = ((int)paramContext.getResources().getDimension(2131165299));
    paramContext = (RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.a((Drawable)new ColorDrawable(paramContext.getResources().getColor(2131099678)), (int)paramContext.getResources().getDimension(2131166292), arrayOfInt, (int)paramContext.getResources().getDimension(2131166293));
    AppMethodBeat.o(165686);
    return paramContext;
  }
  
  public final WxRecyclerAdapter<?> eQ(Context paramContext)
  {
    AppMethodBeat.i(165685);
    d.g.b.p.h(paramContext, "context");
    paramContext = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.c)new h(this), this.sdh.data);
    paramContext.av(false);
    paramContext.LRY = ((d.c)this);
    paramContext.LRX = ((d.d)this);
    AppMethodBeat.o(165685);
    return paramContext;
  }
  
  public final boolean isCommentClose()
  {
    return this.sds;
  }
  
  public final void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(165673);
    d.g.b.p.h(parama, "p0");
    this.scf.add(parama);
    AppMethodBeat.o(165673);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(165675);
    if (this.isDetached)
    {
      ae.i("Finder.DrawerPresenter", "onDetach: can not detach, because it is not attached");
      AppMethodBeat.o(165675);
      return;
    }
    this.isDetached = true;
    this.sdr = false;
    Object localObject1 = this.sdq;
    if (localObject1 != null) {
      ((com.tencent.mm.loader.g.i)localObject1).stop();
    }
    this.sdq = null;
    localObject1 = this.sdi;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).cEX();
      if (localObject1 != null)
      {
        localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
        if (localObject1 != null)
        {
          localObject1 = ((RecyclerView)localObject1).getLayoutManager();
          if (!(localObject1 instanceof LinearLayoutManager)) {
            break label329;
          }
          localObject1 = this.sdi;
          if (localObject1 == null) {
            break label184;
          }
          localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).cEX();
          if (localObject1 == null) {
            break label184;
          }
          localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
          if (localObject1 == null) {
            break label184;
          }
        }
      }
    }
    label184:
    for (localObject1 = ((RecyclerView)localObject1).getLayoutManager();; localObject1 = null)
    {
      if (localObject1 != null) {
        break label190;
      }
      localObject1 = new d.v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
      AppMethodBeat.o(165675);
      throw ((Throwable)localObject1);
      localObject1 = null;
      break;
    }
    label190:
    label329:
    for (int i = ((LinearLayoutManager)localObject1).km();; i = -1)
    {
      localObject1 = this.sdi;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).cQv();
        if (localObject1 != null) {
          ((FinderCommentFooter)localObject1).setFooterMode(0);
        }
      }
      localObject1 = this.sdi;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).cEX();
        if (localObject1 != null)
        {
          localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
          if (localObject1 != null)
          {
            localObject1 = ((RecyclerView)localObject1).getAdapter();
            if (localObject1 != null) {
              ((RecyclerView.a)localObject1).b((RecyclerView.c)this.sdx);
            }
          }
        }
      }
      localObject1 = ((Iterable)this.scf).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((com.tencent.mm.vending.e.a)((Iterator)localObject1).next()).dead();
      }
    }
    this.scf.clear();
    com.tencent.mm.sdk.b.a.IvT.d(this.sdw);
    localObject1 = this.scK;
    if (localObject1 == null) {
      d.g.b.p.bdF("feedObj");
    }
    ((FinderItem)localObject1).setCommentCount(getCommentCount());
    localObject1 = com.tencent.mm.plugin.finder.storage.data.d.sKD;
    localObject1 = this.scK;
    if (localObject1 == null) {
      d.g.b.p.bdF("feedObj");
    }
    d.a.f((FinderItem)localObject1);
    localObject1 = new StringBuilder("[onDetach] updateFeedCommentCount feedId=");
    Object localObject2 = this.scK;
    if (localObject2 == null) {
      d.g.b.p.bdF("feedObj");
    }
    ae.i("Finder.DrawerPresenter", ((FinderItem)localObject2).getId() + " commentCount " + getCommentCount());
    localObject1 = this.sdk;
    if (localObject1 != null) {
      ((CommentDrawerContract.CloseDrawerCallback)localObject1).g(getCommentCount(), (List)this.sdh.data);
    }
    if ((this.sdo) || (!this.dNY))
    {
      this.sdh.data.clear();
      this.lastBuffer = null;
      lP(false);
      lQ(true);
      localObject1 = getEditText();
      if (localObject1 != null) {
        ((MMEditText)localObject1).setText(null);
      }
      localObject1 = this.sdi;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).cEX();
        if (localObject1 != null) {
          ((RefreshLoadMoreLayout)localObject1).setHasBottomMore(true);
        }
      }
      localObject1 = this.sdi;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).cEX();
        if (localObject1 != null)
        {
          localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
          if (localObject1 != null)
          {
            localObject1 = ((RecyclerView)localObject1).getAdapter();
            if (localObject1 != null) {
              ((RecyclerView.a)localObject1).notifyDataSetChanged();
            }
          }
        }
      }
      localObject1 = this.sdi;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).cEX();
        if (localObject1 != null)
        {
          localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
          if (localObject1 != null) {
            ((RecyclerView)localObject1).setLayoutFrozen(true);
          }
        }
      }
      localObject1 = this.sdi;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).cEX();
        if (localObject1 != null) {
          ((RefreshLoadMoreLayout)localObject1).setActionCallback(null);
        }
      }
      this.sdi = null;
      this.sdv.dead();
      AppMethodBeat.o(165675);
      return;
    }
    int k = i;
    int j;
    if (this.rQR != 0L)
    {
      localObject1 = ((Iterable)this.sdh.data).iterator();
      j = 0;
      label755:
      k = i;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (j < 0) {
          j.gkd();
        }
        localObject2 = (n)localObject2;
        if (((n)localObject2).ste.cLl().commentId != this.rQR) {
          break label933;
        }
        ((n)localObject2).stb = false;
        i = j;
      }
    }
    label933:
    for (;;)
    {
      j += 1;
      break label755;
      localObject1 = this.sdh;
      localObject2 = this.lastBuffer;
      boolean bool1 = this.sdm;
      boolean bool2 = this.sdn;
      boolean bool3 = this.sdt;
      if ((((com.tencent.mm.plugin.finder.feed.model.c)localObject1).data.size() >= 0) && (k >= 0)) {
        com.tencent.mm.plugin.finder.feed.model.c.a.a(((com.tencent.mm.plugin.finder.feed.model.c)localObject1).sjS, ((com.tencent.mm.plugin.finder.feed.model.c)localObject1).sjT, ((com.tencent.mm.plugin.finder.feed.model.c)localObject1).data);
      }
      ((com.tencent.mm.plugin.finder.feed.model.c)localObject1).data.clear();
      if ((k < 0) || (com.tencent.mm.plugin.finder.feed.model.c.sjU)) {
        break;
      }
      com.tencent.mm.plugin.finder.storage.data.e.sKJ.a(((com.tencent.mm.plugin.finder.feed.model.c)localObject1).sjS, ((com.tencent.mm.plugin.finder.feed.model.c)localObject1).sjT, k, (com.tencent.mm.bw.b)localObject2, bool1, bool2, bool3);
      break;
    }
  }
  
  public final void onModeChange(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(165676);
    ae.i("Finder.DrawerPresenter", "[onModeChange] from=" + paramInt1 + " to=" + paramInt2);
    if (paramInt2 == 0)
    {
      Object localObject1 = this.sdi;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).cQw();
        if (localObject1 != null)
        {
          localObject1 = ((FinderCommentDrawer)localObject1).getRecyclerView();
          if (localObject1 != null)
          {
            localObject1 = ((RecyclerView)localObject1).animate();
            if (localObject1 != null)
            {
              localObject1 = ((ViewPropertyAnimator)localObject1).translationY(0.0F);
              if (localObject1 != null)
              {
                localObject1 = ((ViewPropertyAnimator)localObject1).setDuration(180L);
                if (localObject1 != null) {
                  ((ViewPropertyAnimator)localObject1).start();
                }
              }
            }
          }
        }
      }
      if (this.isDetached)
      {
        localObject1 = this.sdi;
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).cQv();
          if (localObject1 != null)
          {
            Object localObject2 = com.tencent.mm.plugin.finder.utils.p.sXz;
            localObject2 = com.tencent.mm.plugin.finder.utils.p.Gk(this.scene);
            FinderItem localFinderItem = this.scK;
            if (localFinderItem == null) {
              d.g.b.p.bdF("feedObj");
            }
            ((FinderCommentFooter)localObject1).gF((String)localObject2, localFinderItem.getNickName());
            AppMethodBeat.o(165676);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(165676);
  }
  
  public final n ww(long paramLong)
  {
    AppMethodBeat.i(178244);
    if (paramLong == 0L)
    {
      AppMethodBeat.o(178244);
      return null;
    }
    Iterator localIterator = ((Iterable)this.sdh.data).iterator();
    Object localObject;
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((n)localObject).ste.cLl().commentId == paramLong)
      {
        i = 1;
        label77:
        if (i == 0) {
          break label100;
        }
      }
    }
    for (;;)
    {
      localObject = (n)localObject;
      AppMethodBeat.o(178244);
      return localObject;
      i = 0;
      break label77;
      label100:
      break;
      localObject = null;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$DiffDataChangeHelper;", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "(Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter;Landroid/support/v7/widget/RecyclerView;)V", "onDeleteChange", "", "commentId", "", "localCommentId", "anim", "", "onInsertChange", "target", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "onSecondaryItemRangeInsert", "rootCommentId", "", "onUpdateChange", "plugin-finder_release"})
  public final class b
  {
    final RecyclerView gpr;
    
    public b()
    {
      AppMethodBeat.i(165628);
      this.gpr = localObject;
      AppMethodBeat.o(165628);
    }
    
    public final void a(long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(178222);
      Object localObject1;
      if (paramLong1 != 0L)
      {
        int m = e.b(e.this).data.size();
        localObject1 = e.b(e.this);
        Object localObject3 = (Iterable)((com.tencent.mm.plugin.finder.feed.model.c)localObject1).data;
        Object localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        int i = 0;
        int j = -1;
        if (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = ((Iterator)localObject3).next();
          if (i < 0) {
            j.gkd();
          }
          n localn = (n)localObject4;
          if (localn.ste.cLl().commentId == paramLong1) {
            j = i;
          }
          if ((localn.ste.cLl().commentId == paramLong1) || (localn.ste.field_actionInfo.rQN == paramLong1)) {}
          for (int k = 1;; k = 0)
          {
            if (k != 0) {
              ((Collection)localObject2).add(localObject4);
            }
            i += 1;
            break;
          }
        }
        localObject2 = (List)localObject2;
        i = ((List)localObject2).size();
        ((com.tencent.mm.plugin.finder.feed.model.c)localObject1).data.removeAll((Collection)localObject2);
        localObject1 = new o(Integer.valueOf(j), Integer.valueOf(i));
        if ((paramBoolean) && (((Number)((o)localObject1).first).intValue() >= 0))
        {
          i = ((Number)((o)localObject1).first).intValue();
          if (((Number)((o)localObject1).second).intValue() + i <= m)
          {
            localObject2 = this.gpr.getAdapter();
            if (localObject2 != null) {
              ((RecyclerView.a)localObject2).as(((Number)((o)localObject1).first).intValue(), ((Number)((o)localObject1).second).intValue());
            }
          }
        }
      }
      for (;;)
      {
        localObject1 = this.gpr.getAdapter();
        if (localObject1 == null) {
          break;
        }
        ((RecyclerView.a)localObject1).notifyDataSetChanged();
        AppMethodBeat.o(178222);
        return;
        e.b(e.this).wy(paramLong2);
      }
      AppMethodBeat.o(178222);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentChangeEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderCommentChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class c
    extends com.tencent.mm.sdk.b.c<hj>
  {
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements d.g.a.a<z>
    {
      b(e.c paramc, hj paramhj)
      {
        super();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentDataObserver$1", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeRemoved", "plugin-finder_release"})
  public static final class d
    extends RecyclerView.c
  {
    public final void at(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(165634);
      super.at(paramInt1, paramInt2);
      this.sdz.cCP();
      AppMethodBeat.o(165634);
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(165633);
      super.au(paramInt1, paramInt2);
      this.sdz.cCP();
      AppMethodBeat.o(165633);
    }
    
    public final void av(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(165636);
      super.av(paramInt1, paramInt2);
      this.sdz.cCP();
      AppMethodBeat.o(165636);
    }
    
    public final void f(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(165635);
      super.f(paramInt1, paramInt2, paramObject);
      this.sdz.cCP();
      AppMethodBeat.o(165635);
    }
    
    @SuppressLint({"StringFormatMatches"})
    public final void onChanged()
    {
      AppMethodBeat.i(165632);
      super.onChanged();
      this.sdz.cCP();
      AppMethodBeat.o(165632);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentErrorListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderCommentErrorEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class e
    extends com.tencent.mm.sdk.b.c<hk>
  {
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(e.e parame, hk paramhk)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements d.g.a.a<z>
    {
      b(e.e parame)
      {
        super();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class f
    implements DialogInterface.OnClickListener
  {
    f(e parame, Context paramContext, n paramn) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(165647);
      paramDialogInterface = this.sdz.tipDialog;
      if (paramDialogInterface != null) {
        paramDialogInterface.show();
      }
      Object localObject;
      for (;;)
      {
        localObject = (d.g.a.a)new d(this);
        paramDialogInterface = (d.g.a.a)new b(this, (d.g.a.a)localObject, (d.g.a.a)new c(this));
        if ((!paramn.ste.cLs()) && (paramn.ste.field_localCommentId != 0L)) {
          break;
        }
        paramDialogInterface.invoke();
        AppMethodBeat.o(165647);
        return;
        paramDialogInterface = this.sdz;
        localObject = localContext;
        localContext.getString(2131755906);
        paramDialogInterface.tipDialog = ((Dialog)com.tencent.mm.ui.base.h.b((Context)localObject, localContext.getString(2131755936), false, (DialogInterface.OnCancelListener)a.sdG));
      }
      paramDialogInterface = com.tencent.mm.plugin.finder.upload.b.sTP;
      paramDialogInterface = com.tencent.mm.plugin.finder.upload.b.cNg();
      ab localab = paramn.ste;
      d.g.b.p.h(localab, "wantDeleteItem");
      paramDialogInterface.sTM.c((com.tencent.mm.loader.g.c)new com.tencent.mm.plugin.finder.upload.a(localab));
      paramDialogInterface = paramDialogInterface.sTM;
      com.tencent.mm.loader.g.c localc = (com.tencent.mm.loader.g.c)new com.tencent.mm.plugin.finder.upload.a(localab);
      d.g.b.p.h(localc, "t");
      Iterator localIterator = ((Iterable)paramDialogInterface.hid).iterator();
      while (localIterator.hasNext())
      {
        paramDialogInterface = localIterator.next();
        if (d.g.b.p.i(((com.tencent.mm.loader.g.c)((com.tencent.mm.loader.g.g)paramDialogInterface).first).aeW(), localc.aeW()))
        {
          if ((com.tencent.mm.loader.g.g)paramDialogInterface == null) {
            break label360;
          }
          paramInt = 1;
          label282:
          if (paramInt == 0) {
            break label365;
          }
          ae.i(com.tencent.mm.plugin.finder.upload.b.TAG, "removeWhenNotDoingNetScene " + localab + " is running");
        }
      }
      for (paramInt = 0;; paramInt = 1)
      {
        if (paramInt != 0) {
          break label406;
        }
        paramDialogInterface = this.sdz.tipDialog;
        if (paramDialogInterface != null) {
          paramDialogInterface.dismiss();
        }
        t.makeText(localContext, 2131759311, 0).show();
        AppMethodBeat.o(165647);
        return;
        paramDialogInterface = null;
        break;
        label360:
        paramInt = 0;
        break label282;
        label365:
        ae.i(com.tencent.mm.plugin.finder.upload.b.TAG, "removeWhenNotDoingNetScene ".concat(String.valueOf(localab)));
        ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderActionStorage().xf(localab.field_localCommentId);
      }
      label406:
      ((d.g.a.a)localObject).invoke();
      AppMethodBeat.o(165647);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class a
      implements DialogInterface.OnCancelListener
    {
      public static final a sdG;
      
      static
      {
        AppMethodBeat.i(165642);
        sdG = new a();
        AppMethodBeat.o(165642);
      }
      
      public final void onCancel(DialogInterface paramDialogInterface) {}
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements d.g.a.a<z>
    {
      b(e.f paramf, d.g.a.a parama1, d.g.a.a parama2)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class c
      extends q
      implements d.g.a.a<z>
    {
      c(e.f paramf)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class d
      extends q
      implements d.g.a.a<z>
    {
      d(e.f paramf)
      {
        super();
      }
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$deleteComment$1$succCallback$1$1$1"})
      static final class a
        extends q
        implements d.g.a.b<FinderCommentInfo, Boolean>
      {
        a(e.f.d paramd)
        {
          super();
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
  static final class g
    extends q
    implements d.g.a.b<com.tencent.mm.loader.g.h, z>
  {
    g(e parame, LinkedList paramLinkedList, n paramn)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$getAdapter$adapter$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class h
    implements com.tencent.mm.view.recyclerview.c
  {
    public final com.tencent.mm.view.recyclerview.b<?> AX(int paramInt)
    {
      AppMethodBeat.i(165648);
      if (e.i(this.sdz))
      {
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.e((CommentDrawerContract.NPresenter)this.sdz, true);
        AppMethodBeat.o(165648);
        return localObject;
      }
      Object localObject = n.sth;
      if (paramInt == n.cEw())
      {
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.e((CommentDrawerContract.NPresenter)this.sdz, false);
        AppMethodBeat.o(165648);
        return localObject;
      }
      localObject = n.sth;
      if (paramInt == n.cEx())
      {
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.g((CommentDrawerContract.NPresenter)this.sdz);
        AppMethodBeat.o(165648);
        return localObject;
      }
      d.g.b.p.gkB();
      AppMethodBeat.o(165648);
      return null;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
  static final class j
    extends q
    implements d.g.a.b<com.tencent.mm.loader.g.h, z>
  {
    j(e parame)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
  static final class k
    extends q
    implements d.g.a.b<com.tencent.mm.loader.g.h, z>
  {
    k(e parame, n paramn, y.d paramd, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$6$1"})
  static final class l
    implements Runnable
  {
    l(MMEditText paramMMEditText, e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(202197);
      this.sdR.requestFocus();
      if (!jdField_this.rUX)
      {
        Object localObject = jdField_this.sdi;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.finder.view.builder.b)localObject).cQv();
          if (localObject != null)
          {
            ((FinderCommentFooter)localObject).bY(true);
            AppMethodBeat.o(202197);
            return;
          }
        }
      }
      AppMethodBeat.o(202197);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder_release"})
  public static final class m
    extends RefreshLoadMoreLayout.a
  {
    public final void AY(int paramInt)
    {
      AppMethodBeat.i(202198);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.mu(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ahF());
      com.tencent.e.h.MqF.aO((Runnable)new b(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(202198);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(165655);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahF());
      d.g.b.p.h(paramc, "reason");
      super.a(paramc);
      e.d(this.sdz);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(165655);
    }
    
    public final void b(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(165657);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahF());
      d.g.b.p.h(paramc, "reason");
      super.b(paramc);
      e.f(this.sdz);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(165657);
    }
    
    public final void bZA()
    {
      AppMethodBeat.i(165654);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.bZA();
      com.tencent.e.h.MqF.aO((Runnable)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(165654);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(e.m paramm) {}
      
      public final void run()
      {
        AppMethodBeat.i(165652);
        e.c(this.sdS.sdz);
        AppMethodBeat.o(165652);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(e.m paramm) {}
      
      public final void run()
      {
        AppMethodBeat.i(165653);
        e.e(this.sdS.sdz);
        AppMethodBeat.o(165653);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    n(e parame, com.tencent.mm.plugin.finder.view.builder.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178230);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      e.a(this.sdz, paramb.cQv().getScene());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(178230);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class o
    implements Runnable
  {
    o(e parame, y.d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(178231);
      if ((locald.NiW > 0) && (locald.NiW < e.b(this.sdz).data.size()))
      {
        Object localObject = this.sdz.sdi;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.finder.view.builder.b)localObject).cEX();
          if (localObject != null)
          {
            localObject = ((RefreshLoadMoreLayout)localObject).getRecyclerView();
            if (localObject == null) {}
          }
        }
        for (localObject = ((RecyclerView)localObject).getLayoutManager(); localObject == null; localObject = null)
        {
          localObject = new d.v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
          AppMethodBeat.o(178231);
          throw ((Throwable)localObject);
        }
        ((LinearLayoutManager)localObject).ag(locald.NiW, 0);
      }
      AppMethodBeat.o(178231);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "invoke"})
  static final class p
    extends q
    implements d.g.a.b<n, z>
  {
    p(e parame)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "invoke"})
  static final class q
    extends q
    implements d.g.a.b<n, z>
  {
    q(e parame)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
  static final class s
    extends q
    implements d.g.a.b<com.tencent.mm.loader.g.h, z>
  {
    s(e parame)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
  static final class t
    extends q
    implements d.g.a.b<com.tencent.mm.loader.g.h, z>
  {
    t(e parame, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.e
 * JD-Core Version:    0.7.0.1
 */