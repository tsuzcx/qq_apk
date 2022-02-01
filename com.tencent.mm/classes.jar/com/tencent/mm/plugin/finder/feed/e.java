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
import com.tencent.mm.g.a.hi;
import com.tencent.mm.g.a.hj;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.model.m;
import com.tencent.mm.plugin.finder.model.w;
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
import com.tencent.mm.protocal.protobuf.alh;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "authorMentioned", "", "getAuthorMentioned", "()Z", "setAuthorMentioned", "(Z)V", "blinkRefComment", "canPreload", "getCanPreload", "setCanPreload", "commentChangeEventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderCommentChangeEvent;", "getCommentChangeEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "commentClose", "getCommentClose", "setCommentClose", "commentCount", "", "getCommentCount", "()I", "commentDataObserver", "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentDataObserver$1", "Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentDataObserver$1;", "commentErrorListener", "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentErrorListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentErrorListener$1;", "getContext", "()Landroid/content/Context;", "dataLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentLoader;", "diffDataChangeHelper", "Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$DiffDataChangeHelper;", "value", "downContinue", "setDownContinue", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "setDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;)V", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "hasExpandComment", "getHasExpandComment", "setHasExpandComment", "hitCache", "isDetached", "setDetached", "isSingleMode", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "oldVersion", "onCloseDrawerCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "refCommentId", "", "resources", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "safeMode", "getSafeMode", "setSafeMode", "scene", "getScene", "setScene", "(I)V", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "getTaskExecutor", "()Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "setTaskExecutor", "(Lcom/tencent/mm/loader/loader/SingleTaskExecutor;)V", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "upContinue", "setUpContinue", "useCache", "viewCallback", "Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;)V", "calculateCommentCount", "canExpand", "comment", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "down", "checkDownContinue", "", "checkUpContinue", "deleteComment", "item", "expandLevel2Comments", "rootComment", "expandTopLevel2Comment", "", "respList", "expandWhenRefToLevel2Comment", "filterText", "", "origin", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getCommentScene", "getCurrentFeed", "getEditText", "Lcom/tencent/mm/ui/widget/MMEditText;", "getEditTextAvatar", "Landroid/widget/ImageView;", "getFirstFriendPos", "getFirstOtherPos", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getRootComment", "rootId", "getRootCommentIndex", "getUserScene", "insertLevel2CommentsAndNotify", "level2Comments", "", "isCommentClose", "isSafeMode", "isWxScene", "keep", "p0", "loadMoreData", "loadMoreLevel2Comments", "mergeLocalLevel2Comments", "localLevel2Comments", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "onAttach", "builder", "displayScene", "replyCommentObj", "oldVer", "callback", "onClickComment", "view", "Landroid/view/View;", "onClickCommentDelete", "onClickMore", "onClickResendComment", "position", "onDetach", "onExpandClick", "onItemClick", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "holder", "onItemLongClick", "onLikeComment", "onModeChange", "from", "to", "onRecoverRecyclerViewTrans", "onReply", "sceneForReply", "onScrollIdle", "lastVisiblePosition", "preloadNextPage", "refreshData", "setCommentCountView", "transToDiscoverComment", "Companion", "DiffDataChangeHelper", "plugin-finder_release"})
public final class e
  implements CommentDrawerContract.NPresenter, FinderCommentFooter.b, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>, d.c<com.tencent.mm.view.recyclerview.e>, d.d<com.tencent.mm.view.recyclerview.e>
{
  public static final a rUT;
  final Context context;
  private boolean dMI;
  private volatile boolean isDetached;
  private volatile com.tencent.mm.bx.b lastBuffer;
  private long rIH;
  public boolean rMJ;
  private boolean rMe;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> rTB;
  final com.tencent.mm.plugin.finder.feed.model.c rUD;
  com.tencent.mm.plugin.finder.view.builder.b rUE;
  private b rUF;
  private CommentDrawerContract.CloseDrawerCallback rUG;
  private boolean rUH;
  private boolean rUI;
  private boolean rUJ;
  private boolean rUK;
  private boolean rUL;
  private com.tencent.mm.loader.g.i rUM;
  boolean rUN;
  private boolean rUO;
  boolean rUP;
  private e rUQ;
  private final com.tencent.mm.sdk.b.c<hi> rUR;
  private final d rUS;
  private FinderItem rUg;
  int scene;
  private FinderCommentDrawer sdx;
  Dialog tipDialog;
  
  static
  {
    AppMethodBeat.i(165695);
    rUT = new a((byte)0);
    AppMethodBeat.o(165695);
  }
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(201749);
    this.context = paramContext;
    this.rUD = new com.tencent.mm.plugin.finder.feed.model.c();
    this.rTB = new CopyOnWriteArraySet();
    this.scene = 2;
    this.rUJ = true;
    this.rMe = true;
    this.dMI = true;
    this.isDetached = true;
    this.rUQ = new e(this);
    this.rUR = ((com.tencent.mm.sdk.b.c)new c(this));
    this.rUS = new d(this);
    AppMethodBeat.o(201749);
  }
  
  private final ImageView cBc()
  {
    AppMethodBeat.i(165689);
    Object localObject = this.rUE;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.b)localObject).cNL();
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
    Object localObject = new StringBuilder("calculateCommentCount ").append(this.rUD.data.size()).append(", ");
    FinderItem localFinderItem = this.rUg;
    if (localFinderItem == null) {
      d.g.b.p.bcb("feedObj");
    }
    ad.i("Finder.DrawerPresenter", localFinderItem.getCommentCount());
    int i = this.rUD.data.size();
    localObject = this.rUg;
    if (localObject == null) {
      d.g.b.p.bcb("feedObj");
    }
    i = Math.max(i, ((FinderItem)localObject).getCommentCount());
    AppMethodBeat.o(165672);
    return i;
  }
  
  private final MMEditText getEditText()
  {
    AppMethodBeat.i(165688);
    Object localObject = this.rUE;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.b)localObject).cNL();
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
    Object localObject = this.rUE;
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
    this.rUI = paramBoolean;
    ad.i("Finder.DrawerPresenter", "set upContinue ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(165670);
  }
  
  private final void lQ(boolean paramBoolean)
  {
    AppMethodBeat.i(165671);
    this.rUJ = paramBoolean;
    ad.i("Finder.DrawerPresenter", "set downContinue ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(165671);
  }
  
  private final void lR(final boolean paramBoolean)
  {
    AppMethodBeat.i(165692);
    com.tencent.mm.loader.g.i locali = this.rUM;
    if (locali != null)
    {
      locali.a(new com.tencent.mm.loader.g.h((d.g.a.b)new t(this, paramBoolean)));
      AppMethodBeat.o(165692);
      return;
    }
    AppMethodBeat.o(165692);
  }
  
  public final void Ey(int paramInt)
  {
    AppMethodBeat.i(178247);
    Object localObject = this.rUD.data;
    ad.i("Finder.DrawerPresenter", "preloadNextPage, onScrollIdle, lastVisiblePosition:" + paramInt + ", dataList size:" + ((ArrayList)localObject).size() + ", canPreload:" + this.rUN);
    if ((paramInt >= 0) && (paramInt < ((ArrayList)localObject).size()))
    {
      int i = ((ArrayList)localObject).size();
      localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
      if ((i - paramInt <= com.tencent.mm.plugin.finder.storage.b.cGj()) && (this.rUN))
      {
        this.rUN = false;
        localObject = this.rUM;
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
  
  public final void a(View paramView, m paramm)
  {
    AppMethodBeat.i(201746);
    d.g.b.p.h(paramView, "view");
    d.g.b.p.h(paramm, "item");
    paramView = new com.tencent.mm.ui.widget.a.e(paramView.getContext(), 1, false);
    FinderItem localFinderItem = this.rUg;
    if (localFinderItem == null) {
      d.g.b.p.bcb("feedObj");
    }
    paramView.a((n.d)new a.a(paramm, localFinderItem.getUserName()));
    paramView.a((n.e)new a.d(paramm, (d.g.a.b)new p(this)));
    paramView.cMW();
    AppMethodBeat.o(201746);
  }
  
  public final void a(ImageView paramImageView, int paramInt)
  {
    AppMethodBeat.i(165677);
    d.g.b.p.h(paramImageView, "view");
    if (paramInt < 0)
    {
      ad.i("Finder.DrawerPresenter", "onLikeComment position:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(165677);
      return;
    }
    paramImageView = this.rUD.EB(paramInt);
    Object localObject1 = com.tencent.mm.plugin.finder.upload.action.g.sKi;
    localObject1 = com.tencent.mm.plugin.finder.upload.action.g.cKV();
    Object localObject2 = this.rUg;
    if (localObject2 == null) {
      d.g.b.p.bcb("feedObj");
    }
    boolean bool1 = ((com.tencent.mm.plugin.finder.upload.action.g)localObject1).a(((FinderItem)localObject2).getId(), paramImageView.skh, this.scene);
    ad.i("Finder.DrawerPresenter", "[onLikeComment] position=" + paramInt + " isLike=" + bool1 + " commentObj=" + paramImageView.skh);
    if (!bool1) {
      bool1 = true;
    }
    boolean bool2;
    int i;
    for (;;)
    {
      if ((this.context instanceof MMActivity))
      {
        localObject1 = com.tencent.mm.ui.component.a.KiD;
        localObject1 = this.context;
        if (localObject1 == null)
        {
          paramImageView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(165677);
          throw paramImageView;
          bool1 = false;
        }
        else
        {
          localObject1 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)localObject1).get(FinderReporterUIC.class)).cOu();
          localObject2 = com.tencent.mm.plugin.finder.utils.p.sMo;
          localObject2 = this.rUg;
          if (localObject2 == null) {
            d.g.b.p.bcb("feedObj");
          }
          bool2 = com.tencent.mm.plugin.finder.utils.p.aiX(((FinderItem)localObject2).getUserName());
          localObject2 = com.tencent.mm.plugin.finder.storage.b.sxa;
          if (((Number)com.tencent.mm.plugin.finder.storage.b.cHb().value()).intValue() == 1) {
            break label514;
          }
          localObject2 = com.tencent.mm.plugin.finder.storage.b.sxa;
          if (com.tencent.mm.plugin.finder.storage.b.cGm() != 1) {
            break label514;
          }
          i = 1;
          if ((bool2) && (i == 1))
          {
            if (!bool1) {
              break label522;
            }
            paramImageView.skh.Fp(paramImageView.skh.field_actionInfo.Gla.displayFlag | 0x1);
          }
        }
      }
    }
    for (;;)
    {
      localObject2 = w.skq;
      localObject2 = this.rUg;
      if (localObject2 == null) {
        d.g.b.p.bcb("feedObj");
      }
      long l = ((FinderItem)localObject2).getId();
      localObject2 = this.rUg;
      if (localObject2 == null) {
        d.g.b.p.bcb("feedObj");
      }
      w.a((aqy)localObject1, l, ((FinderItem)localObject2).getObjectNonceId(), paramImageView.skh, bool1, this.scene, bool2);
      paramImageView = com.tencent.mm.ui.component.a.KiD;
      paramImageView = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this.context).get(FinderReporterUIC.class));
      if (paramImageView != null)
      {
        paramImageView = paramImageView.cze();
        localObject1 = this.rUg;
        if (localObject1 == null) {
          d.g.b.p.bcb("feedObj");
        }
        paramImageView.vZ(((FinderItem)localObject1).getId());
      }
      paramImageView = this.rUE;
      if (paramImageView == null) {
        break label548;
      }
      paramImageView = paramImageView.cDf();
      if (paramImageView == null) {
        break label548;
      }
      paramImageView = paramImageView.getRecyclerView();
      if (paramImageView == null) {
        break label548;
      }
      paramImageView = paramImageView.getAdapter();
      if (paramImageView == null) {
        break label548;
      }
      paramImageView.b(paramInt, Integer.valueOf(1));
      AppMethodBeat.o(165677);
      return;
      label514:
      i = this.scene;
      break;
      label522:
      paramImageView.skh.Fp(paramImageView.skh.field_actionInfo.Gla.displayFlag & 0xFFFFFFFE);
    }
    label548:
    AppMethodBeat.o(165677);
  }
  
  public final void a(final m paramm)
  {
    AppMethodBeat.i(165678);
    d.g.b.p.h(paramm, "item");
    final Context localContext = this.context;
    if (localContext != null)
    {
      com.tencent.mm.ui.base.h.a(localContext, 2131759309, 0, (DialogInterface.OnClickListener)new f(this, localContext, paramm), null);
      AppMethodBeat.o(165678);
      return;
    }
    AppMethodBeat.o(165678);
  }
  
  public final void a(final m paramm, final boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(178245);
    d.g.b.p.h(paramm, "rootComment");
    this.rUP = true;
    final y.d locald = new y.d();
    Object localObject1 = FinderReporterUIC.tcM;
    localObject1 = FinderReporterUIC.a.eY(this.context);
    int i;
    if (localObject1 != null)
    {
      i = ((FinderReporterUIC)localObject1).rTD;
      locald.MLT = i;
      if (!paramBoolean) {
        break label309;
      }
      localObject1 = paramm.skh.field_actionInfo.Gla.levelTwoComment;
      if (!bt.hj((List)localObject1)) {
        break label125;
      }
      i = j;
    }
    for (;;)
    {
      if (i == 0) {
        break label249;
      }
      localObject1 = com.tencent.mm.plugin.finder.report.h.soM;
      com.tencent.mm.plugin.finder.report.h.a(paramm, 1, locald.MLT);
      AppMethodBeat.o(178245);
      return;
      i = 0;
      break;
      label125:
      Object localObject2 = ((Iterable)this.rUD.data).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          long l = ((m)((Iterator)localObject2).next()).skh.field_actionInfo.Gla.commentId;
          d.g.b.p.g(localObject1, "level2Comments");
          if (l == ((FinderCommentInfo)((LinkedList)localObject1).getFirst()).commentId)
          {
            i = j;
            break;
          }
        }
      }
      localObject2 = this.rUM;
      if (localObject2 != null) {
        ((com.tencent.mm.loader.g.i)localObject2).a(new com.tencent.mm.loader.g.h((d.g.a.b)new g(this, (LinkedList)localObject1, paramm)));
      }
      i = 1;
    }
    label249:
    localObject1 = com.tencent.mm.plugin.finder.report.h.soM;
    com.tencent.mm.plugin.finder.report.h.a(paramm, 2, locald.MLT);
    for (;;)
    {
      localObject1 = this.rUM;
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.loader.g.i)localObject1).a(new com.tencent.mm.loader.g.h((d.g.a.b)new k(this, paramm, locald, paramBoolean)));
      AppMethodBeat.o(178245);
      return;
      label309:
      localObject1 = com.tencent.mm.plugin.finder.report.h.soM;
      com.tencent.mm.plugin.finder.report.h.a(paramm, 3, locald.MLT);
    }
    AppMethodBeat.o(178245);
  }
  
  public final void a(FinderCommentDrawer paramFinderCommentDrawer, final com.tencent.mm.plugin.finder.view.builder.b paramb, FinderItem paramFinderItem, CommentDrawerContract.CloseDrawerCallback paramCloseDrawerCallback, int paramInt, boolean paramBoolean1, long paramLong, ab paramab, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    AppMethodBeat.i(221460);
    d.g.b.p.h(paramFinderCommentDrawer, "drawer");
    d.g.b.p.h(paramb, "builder");
    d.g.b.p.h(paramFinderItem, "feedObj");
    this.isDetached = false;
    ad.i("Finder.DrawerPresenter", "onAttach " + paramFinderItem.getId() + ", " + paramInt + ", " + paramBoolean1 + ", " + paramLong);
    this.rUE = paramb;
    this.sdx = paramFinderCommentDrawer;
    this.rUg = paramFinderItem;
    this.rUK = paramBoolean1;
    this.scene = paramInt;
    this.rUG = paramCloseDrawerCallback;
    this.rIH = paramLong;
    this.dMI = paramBoolean2;
    this.rUL = paramBoolean3;
    this.rUM = new com.tencent.mm.loader.g.i("FinderCommentExecutor");
    paramFinderCommentDrawer = this.rUM;
    if (paramFinderCommentDrawer != null) {
      paramFinderCommentDrawer.start();
    }
    paramCloseDrawerCallback = this.rUD.b(paramFinderItem.getId(), paramLong, paramBoolean2);
    paramFinderCommentDrawer = (com.tencent.mm.plugin.finder.storage.data.e.b)paramCloseDrawerCallback.first;
    paramBoolean2 = ((Boolean)paramCloseDrawerCallback.second).booleanValue();
    locald = new y.d();
    locald.MLT = paramFinderCommentDrawer.pos;
    paramCloseDrawerCallback = paramFinderCommentDrawer.lastBuffer;
    paramBoolean3 = paramFinderCommentDrawer.rUI;
    boolean bool1 = paramFinderCommentDrawer.rUJ;
    boolean bool2 = paramFinderCommentDrawer.szN;
    this.lastBuffer = paramCloseDrawerCallback;
    this.rUH = paramBoolean2;
    lP(paramBoolean3);
    lQ(bool1);
    this.rMe = paramBoolean5;
    this.rUN = true;
    this.rUO = paramBoolean4;
    this.rUP = bool2;
    if (this.rUI)
    {
      paramb.mt(true);
      paramb.cNL().setFooterMode(0);
      if (paramLong != 0L) {
        break label803;
      }
      paramFinderCommentDrawer = this.rUE;
      if (paramFinderCommentDrawer != null)
      {
        paramFinderCommentDrawer = paramFinderCommentDrawer.cNL();
        if (paramFinderCommentDrawer != null)
        {
          paramCloseDrawerCallback = com.tencent.mm.plugin.finder.utils.p.sMo;
          paramFinderCommentDrawer.gA(com.tencent.mm.plugin.finder.utils.p.FM(this.scene), paramFinderItem.getNickName());
        }
      }
    }
    label803:
    label824:
    label863:
    label992:
    label1005:
    for (;;)
    {
      paramb.cDf().getRecyclerView().setLayoutFrozen(false);
      this.rUF = new b(paramb.cDf().getRecyclerView());
      com.tencent.mm.sdk.b.a.IbL.c(this.rUR);
      try
      {
        paramFinderCommentDrawer = paramb.cDf().getRecyclerView().getAdapter();
        if (paramFinderCommentDrawer != null) {
          paramFinderCommentDrawer.a((RecyclerView.c)this.rUS);
        }
      }
      catch (IllegalStateException paramFinderCommentDrawer)
      {
        for (;;)
        {
          int i;
          int j;
          ad.printErrStackTrace("Finder.DrawerPresenter", (Throwable)paramFinderCommentDrawer, "", new Object[0]);
          continue;
          paramb.cNI().setText((CharSequence)paramb.getContext().getResources().getString(2131759162, new Object[] { com.tencent.mm.plugin.finder.utils.h.fR(this.scene, getCommentCount()) }));
          continue;
          paramFinderCommentDrawer = com.tencent.mm.plugin.finder.api.c.rHn;
          paramFinderCommentDrawer = u.aAu();
          d.g.b.p.g(paramFinderCommentDrawer, "ConfigStorageLogic.getMyFinderUsername()");
          paramFinderCommentDrawer = com.tencent.mm.plugin.finder.api.c.a.agW(paramFinderCommentDrawer);
          if (paramFinderCommentDrawer != null)
          {
            paramCloseDrawerCallback = paramFinderCommentDrawer.cxL();
            paramFinderCommentDrawer = paramCloseDrawerCallback;
            if (paramCloseDrawerCallback != null) {}
          }
          else
          {
            paramFinderCommentDrawer = "";
          }
          paramCloseDrawerCallback = com.tencent.mm.plugin.finder.loader.i.sja;
          paramCloseDrawerCallback = com.tencent.mm.plugin.finder.loader.i.cCC();
          paramFinderCommentDrawer = new com.tencent.mm.plugin.finder.loader.a(paramFinderCommentDrawer);
          paramab = cBc();
          if (paramab == null) {
            d.g.b.p.gfZ();
          }
          Object localObject = com.tencent.mm.plugin.finder.loader.i.sja;
          paramCloseDrawerCallback.a(paramFinderCommentDrawer, paramab, com.tencent.mm.plugin.finder.loader.i.a(i.a.sjd));
          continue;
          if ((paramBoolean2) && (locald.MLT == 0) && (paramLong == 0L) && (!this.rUP))
          {
            this.lastBuffer = null;
            lQ(true);
            lR(true);
          }
          else
          {
            paramFinderCommentDrawer = this.rUE;
            if (paramFinderCommentDrawer != null)
            {
              paramFinderCommentDrawer = paramFinderCommentDrawer.cDf();
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
            paramFinderCommentDrawer = this.rUE;
            if (paramFinderCommentDrawer != null)
            {
              paramFinderCommentDrawer = paramFinderCommentDrawer.cDf();
              if (paramFinderCommentDrawer != null)
              {
                paramFinderCommentDrawer = paramFinderCommentDrawer.getRecyclerView();
                if (paramFinderCommentDrawer != null)
                {
                  paramFinderCommentDrawer.post((Runnable)new o(this, locald));
                  continue;
                  paramb.cNM().setBackgroundColorRes(2131099819);
                  continue;
                  paramb.cNM().setSquaresBackgroundResource(2131101053);
                  paramb.cNM().setBackgroundColorRes(2131101053);
                  paramb.getHeaderLayout().setVisibility(8);
                  paramb.cDf().setVisibility(8);
                  paramFinderCommentDrawer = getEditText();
                  if (paramFinderCommentDrawer != null) {
                    paramFinderCommentDrawer.requestFocus();
                  }
                  if (!this.rMJ)
                  {
                    paramFinderCommentDrawer = this.rUE;
                    if (paramFinderCommentDrawer != null)
                    {
                      paramFinderCommentDrawer = paramFinderCommentDrawer.cNL();
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
      paramb.cDf().setActionCallback((RefreshLoadMoreLayout.a)new m(this));
      paramb.cNL().setModeChangeCallback((FinderCommentFooter.b)this);
      if (getCommentCount() > 0) {
        break label1028;
      }
      paramb.cNI().setText((CharSequence)paramb.getContext().getResources().getString(2131759158));
      paramb.cNL().getReplyBtn().setOnClickListener((View.OnClickListener)new n(this, paramb));
      if (paramab != null)
      {
        paramFinderCommentDrawer = paramb.cNL();
        paramCloseDrawerCallback = com.tencent.mm.plugin.finder.utils.p.sMo;
        paramCloseDrawerCallback = com.tencent.mm.plugin.finder.utils.p.FM(this.scene);
        localObject = com.tencent.mm.plugin.finder.utils.p.sMo;
        paramFinderCommentDrawer.c(paramCloseDrawerCallback, com.tencent.mm.plugin.finder.utils.p.gx(paramab.getUsername(), paramab.VC()), paramab);
      }
      if (cBc() != null)
      {
        if (paramInt != 2) {
          break label1072;
        }
        com.tencent.mm.ui.f.a.a.c(cBc(), u.aAm());
      }
      paramFinderCommentDrawer = this.rUE;
      if (paramFinderCommentDrawer != null) {
        paramFinderCommentDrawer.hideLoading();
      }
      if (paramBoolean1) {
        break label1315;
      }
      if ((this.rUD.data.size() != 0) || (paramBoolean2)) {
        break label1169;
      }
      lR(true);
      paramFinderCommentDrawer = this.rUE;
      if (paramFinderCommentDrawer != null) {
        paramFinderCommentDrawer.showLoading();
      }
      paramFinderCommentDrawer = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cGM().value()).intValue() != 1) {
        break label1302;
      }
      paramb.cNM().setBackgroundColorRes(2131101053);
      paramb.cNM().setSquaresBackgroundResource(2131234858);
      paramb.cDf().setVisibility(0);
      paramb.getHeaderLayout().setVisibility(0);
      if (paramFinderItem.getCommentCount() == 0)
      {
        paramFinderCommentDrawer = getEditText();
        if (paramFinderCommentDrawer != null) {
          paramFinderCommentDrawer.postDelayed((Runnable)new l(paramFinderCommentDrawer, this), 200L);
        }
      }
      if (!this.rUJ)
      {
        paramFinderCommentDrawer = this.rUE;
        if (paramFinderCommentDrawer != null)
        {
          paramFinderCommentDrawer = paramFinderCommentDrawer.cDf();
          if (paramFinderCommentDrawer != null) {
            RefreshLoadMoreLayout.f(paramFinderCommentDrawer);
          }
        }
      }
      this.rUQ.alive();
      AppMethodBeat.o(221460);
      return;
      paramb.mt(false);
      paramFinderCommentDrawer = this.rUE;
      if (paramFinderCommentDrawer == null) {
        break;
      }
      paramFinderCommentDrawer = paramFinderCommentDrawer.cNM();
      if (paramFinderCommentDrawer == null) {
        break;
      }
      paramFinderCommentDrawer.fQm();
      break;
      paramFinderCommentDrawer = (List)this.rUD.data;
      i = 0;
      paramFinderCommentDrawer = paramFinderCommentDrawer.iterator();
      if (paramFinderCommentDrawer.hasNext()) {
        if (((m)paramFinderCommentDrawer.next()).skh.field_actionInfo.Gla.commentId == paramLong)
        {
          j = 1;
          if (j == 0) {
            break label992;
          }
        }
      }
      for (;;)
      {
        if (i < 0) {
          break label1005;
        }
        localObject = (m)this.rUD.data.get(i);
        ((m)localObject).skd = true;
        paramFinderCommentDrawer = this.rUE;
        if (paramFinderCommentDrawer == null) {
          break;
        }
        FinderCommentFooter localFinderCommentFooter = paramFinderCommentDrawer.cNL();
        if (localFinderCommentFooter == null) {
          break;
        }
        paramFinderCommentDrawer = com.tencent.mm.plugin.finder.utils.p.sMo;
        String str1 = com.tencent.mm.plugin.finder.utils.p.FM(this.scene);
        paramFinderCommentDrawer = com.tencent.mm.plugin.finder.utils.p.sMo;
        String str2 = ((m)localObject).skh.getUsername();
        paramCloseDrawerCallback = ((m)localObject).skh.VC();
        paramFinderCommentDrawer = paramCloseDrawerCallback;
        if (paramCloseDrawerCallback == null) {
          paramFinderCommentDrawer = "";
        }
        localFinderCommentFooter.c(str1, com.tencent.mm.plugin.finder.utils.p.gx(str2, paramFinderCommentDrawer), ((m)localObject).skh);
        break;
        j = 0;
        break label863;
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
      ad.i("Finder.DrawerPresenter", "onClickResendComment position:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(165681);
      return;
    }
    paramView = this.rUD.EB(paramInt).skh;
    if (paramView.field_state == -1)
    {
      Object localObject = com.tencent.mm.plugin.finder.upload.b.sID;
      localObject = com.tencent.mm.plugin.finder.upload.b.cKC();
      d.g.b.p.h(paramView, "unsentComment");
      ad.i(com.tencent.mm.plugin.finder.upload.b.TAG, "rePost ".concat(String.valueOf(paramView)));
      paramView.field_state = 1;
      paramView.field_canRemove = 0;
      paramView.wS(cf.aCK() / 1000L);
      paramView.field_postTime = cf.aCK();
      paramView.field_tryCount = 0L;
      ((com.tencent.mm.plugin.finder.upload.b)localObject).a(new com.tencent.mm.plugin.finder.upload.a(paramView));
      paramView = this.rUE;
      if (paramView != null)
      {
        paramView = paramView.cDf();
        if (paramView != null)
        {
          paramView = paramView.getRecyclerView();
          if (paramView != null)
          {
            localObject = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter", "onClickResendComment", "(Landroid/view/View;I)V", "Undefined", "scrollToPosition", "(I)V");
            paramView.ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter", "onClickResendComment", "(Landroid/view/View;I)V", "Undefined", "scrollToPosition", "(I)V");
            AppMethodBeat.o(165681);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(165681);
  }
  
  public final boolean b(m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(178246);
    d.g.b.p.h(paramm, "comment");
    Object localObject1;
    int i;
    if (paramm.skh.field_actionInfo.rID == 0L)
    {
      if (!paramBoolean)
      {
        AppMethodBeat.o(178246);
        return false;
      }
      localObject1 = this.rUD;
      d.g.b.p.h(paramm, "root");
      if (paramm.skh.field_actionInfo.Gla.commentId != 0L)
      {
        localObject1 = ((Iterable)((com.tencent.mm.plugin.finder.feed.model.c)localObject1).data).iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
        } while (((m)((Iterator)localObject1).next()).skh.field_actionInfo.rID != paramm.skh.field_actionInfo.Gla.commentId);
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
      localObject1 = this.rUD;
      d.g.b.p.h(paramm, "level2Comment");
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
            j.gfB();
          }
          localObject2 = (m)localObject2;
          if (com.tencent.mm.plugin.finder.feed.model.c.b((m)localObject2, paramm))
          {
            j = i;
            i = k;
          }
          else if ((j >= 0) && (com.tencent.mm.plugin.finder.feed.model.c.a((m)localObject2, paramm)))
          {
            ad.d(((com.tencent.mm.plugin.finder.feed.model.c)localObject1).TAG, "hasLevel2ItemAfter cur:" + j + ", after:" + i);
          }
        }
      }
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label327;
        }
        AppMethodBeat.o(178246);
        return true;
        i = k;
        break;
      }
      label327:
      AppMethodBeat.o(178246);
      return false;
    }
    if (!this.rUD.c(paramm))
    {
      AppMethodBeat.o(178246);
      return true;
    }
    AppMethodBeat.o(178246);
    return false;
  }
  
  public final int cAZ()
  {
    AppMethodBeat.i(201743);
    Object localObject = FinderReporterUIC.tcM;
    localObject = FinderReporterUIC.a.eY(this.context);
    if (localObject != null)
    {
      int i = ((FinderReporterUIC)localObject).rTD;
      AppMethodBeat.o(201743);
      return i;
    }
    AppMethodBeat.o(201743);
    return 0;
  }
  
  public final int cBa()
  {
    return this.scene;
  }
  
  public final FinderItem cBb()
  {
    AppMethodBeat.i(165684);
    FinderItem localFinderItem = this.rUg;
    if (localFinderItem == null) {
      d.g.b.p.bcb("feedObj");
    }
    AppMethodBeat.o(165684);
    return localFinderItem;
  }
  
  public final void cBd()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(178243);
    Object localObject3;
    if (getCommentCount() <= 0)
    {
      localObject2 = this.rUE;
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject2).cNI();
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
    localObject1 = this.rUE;
    if (localObject1 != null)
    {
      localObject3 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).cNI();
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
  
  public final int cBe()
  {
    AppMethodBeat.i(201747);
    Object localObject = this.rUD.data;
    int i;
    if (!bt.hj((List)localObject))
    {
      localObject = (m)j.jd((List)localObject);
      if (localObject != null)
      {
        localObject = ((m)localObject).skh;
        if (localObject != null)
        {
          if (((ab)localObject).cIP() != true) {
            break label71;
          }
          i = 0;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(201747);
      return i;
      i = -1;
      continue;
      label71:
      i = -1;
    }
  }
  
  public final int cBf()
  {
    AppMethodBeat.i(201748);
    Object localObject1 = this.rUD.data;
    if (!bt.hj((List)localObject1))
    {
      localObject1 = ((Iterable)localObject1).iterator();
      int i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          j.gfB();
        }
        localObject2 = (m)localObject2;
        if ((((m)localObject2).skh.field_actionInfo.rID == 0L) && (!((m)localObject2).skh.cIP()))
        {
          AppMethodBeat.o(201748);
          return i;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(201748);
    return -1;
  }
  
  public final RecyclerView.h eK(Context paramContext)
  {
    AppMethodBeat.i(165686);
    d.g.b.p.h(paramContext, "context");
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = ((int)paramContext.getResources().getDimension(2131165299));
    paramContext = (RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.a((Drawable)new ColorDrawable(paramContext.getResources().getColor(2131099678)), (int)paramContext.getResources().getDimension(2131166292), arrayOfInt, (int)paramContext.getResources().getDimension(2131166293));
    AppMethodBeat.o(165686);
    return paramContext;
  }
  
  public final WxRecyclerAdapter<?> eM(Context paramContext)
  {
    AppMethodBeat.i(165685);
    d.g.b.p.h(paramContext, "context");
    paramContext = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.c)new h(this), this.rUD.data);
    paramContext.av(false);
    paramContext.Lvl = ((d.c)this);
    paramContext.Lvk = ((d.d)this);
    AppMethodBeat.o(165685);
    return paramContext;
  }
  
  public final boolean isCommentClose()
  {
    return this.rUO;
  }
  
  public final void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(165673);
    d.g.b.p.h(parama, "p0");
    this.rTB.add(parama);
    AppMethodBeat.o(165673);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(165675);
    if (this.isDetached)
    {
      ad.i("Finder.DrawerPresenter", "onDetach: can not detach, because it is not attached");
      AppMethodBeat.o(165675);
      return;
    }
    this.isDetached = true;
    this.rUN = false;
    Object localObject1 = this.rUM;
    if (localObject1 != null) {
      ((com.tencent.mm.loader.g.i)localObject1).stop();
    }
    this.rUM = null;
    localObject1 = this.rUE;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).cDf();
      if (localObject1 != null)
      {
        localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
        if (localObject1 != null)
        {
          localObject1 = ((RecyclerView)localObject1).getLayoutManager();
          if (!(localObject1 instanceof LinearLayoutManager)) {
            break label329;
          }
          localObject1 = this.rUE;
          if (localObject1 == null) {
            break label184;
          }
          localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).cDf();
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
      localObject1 = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
      AppMethodBeat.o(165675);
      throw ((Throwable)localObject1);
      localObject1 = null;
      break;
    }
    label190:
    label329:
    for (int i = ((LinearLayoutManager)localObject1).km();; i = -1)
    {
      localObject1 = this.rUE;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).cNL();
        if (localObject1 != null) {
          ((FinderCommentFooter)localObject1).setFooterMode(0);
        }
      }
      localObject1 = this.rUE;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).cDf();
        if (localObject1 != null)
        {
          localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
          if (localObject1 != null)
          {
            localObject1 = ((RecyclerView)localObject1).getAdapter();
            if (localObject1 != null) {
              ((RecyclerView.a)localObject1).b((RecyclerView.c)this.rUS);
            }
          }
        }
      }
      localObject1 = ((Iterable)this.rTB).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((com.tencent.mm.vending.e.a)((Iterator)localObject1).next()).dead();
      }
    }
    this.rTB.clear();
    com.tencent.mm.sdk.b.a.IbL.d(this.rUR);
    localObject1 = this.rUg;
    if (localObject1 == null) {
      d.g.b.p.bcb("feedObj");
    }
    ((FinderItem)localObject1).setCommentCount(getCommentCount());
    localObject1 = com.tencent.mm.plugin.finder.storage.data.d.szI;
    localObject1 = this.rUg;
    if (localObject1 == null) {
      d.g.b.p.bcb("feedObj");
    }
    d.a.f((FinderItem)localObject1);
    localObject1 = new StringBuilder("[onDetach] updateFeedCommentCount feedId=");
    Object localObject2 = this.rUg;
    if (localObject2 == null) {
      d.g.b.p.bcb("feedObj");
    }
    ad.i("Finder.DrawerPresenter", ((FinderItem)localObject2).getId() + " commentCount " + getCommentCount());
    localObject1 = this.rUG;
    if (localObject1 != null) {
      ((CommentDrawerContract.CloseDrawerCallback)localObject1).g(getCommentCount(), (List)this.rUD.data);
    }
    if ((this.rUK) || (!this.dMI))
    {
      this.rUD.data.clear();
      this.lastBuffer = null;
      lP(false);
      lQ(true);
      localObject1 = getEditText();
      if (localObject1 != null) {
        ((MMEditText)localObject1).setText(null);
      }
      localObject1 = this.rUE;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).cDf();
        if (localObject1 != null) {
          ((RefreshLoadMoreLayout)localObject1).setHasBottomMore(true);
        }
      }
      localObject1 = this.rUE;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).cDf();
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
      localObject1 = this.rUE;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).cDf();
        if (localObject1 != null)
        {
          localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
          if (localObject1 != null) {
            ((RecyclerView)localObject1).setLayoutFrozen(true);
          }
        }
      }
      localObject1 = this.rUE;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).cDf();
        if (localObject1 != null) {
          ((RefreshLoadMoreLayout)localObject1).setActionCallback(null);
        }
      }
      this.rUE = null;
      this.rUQ.dead();
      AppMethodBeat.o(165675);
      return;
    }
    int k = i;
    int j;
    if (this.rIH != 0L)
    {
      localObject1 = ((Iterable)this.rUD.data).iterator();
      j = 0;
      label755:
      k = i;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (j < 0) {
          j.gfB();
        }
        localObject2 = (m)localObject2;
        if (((m)localObject2).skh.field_actionInfo.Gla.commentId != this.rIH) {
          break label936;
        }
        ((m)localObject2).ske = false;
        i = j;
      }
    }
    label936:
    for (;;)
    {
      j += 1;
      break label755;
      localObject1 = this.rUD;
      localObject2 = this.lastBuffer;
      boolean bool1 = this.rUI;
      boolean bool2 = this.rUJ;
      boolean bool3 = this.rUP;
      if ((((com.tencent.mm.plugin.finder.feed.model.c)localObject1).data.size() >= 0) && (k >= 0)) {
        com.tencent.mm.plugin.finder.feed.model.c.a.a(((com.tencent.mm.plugin.finder.feed.model.c)localObject1).sbd, ((com.tencent.mm.plugin.finder.feed.model.c)localObject1).sbe, ((com.tencent.mm.plugin.finder.feed.model.c)localObject1).data);
      }
      ((com.tencent.mm.plugin.finder.feed.model.c)localObject1).data.clear();
      if ((k < 0) || (com.tencent.mm.plugin.finder.feed.model.c.sbf)) {
        break;
      }
      com.tencent.mm.plugin.finder.storage.data.e.szM.a(((com.tencent.mm.plugin.finder.feed.model.c)localObject1).sbd, ((com.tencent.mm.plugin.finder.feed.model.c)localObject1).sbe, k, (com.tencent.mm.bx.b)localObject2, bool1, bool2, bool3);
      break;
    }
  }
  
  public final void onModeChange(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(165676);
    ad.i("Finder.DrawerPresenter", "[onModeChange] from=" + paramInt1 + " to=" + paramInt2);
    if (paramInt2 == 0)
    {
      Object localObject1 = this.rUE;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).cNM();
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
        localObject1 = this.rUE;
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).cNL();
          if (localObject1 != null)
          {
            Object localObject2 = com.tencent.mm.plugin.finder.utils.p.sMo;
            localObject2 = com.tencent.mm.plugin.finder.utils.p.FM(this.scene);
            FinderItem localFinderItem = this.rUg;
            if (localFinderItem == null) {
              d.g.b.p.bcb("feedObj");
            }
            ((FinderCommentFooter)localObject1).gA((String)localObject2, localFinderItem.getNickName());
            AppMethodBeat.o(165676);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(165676);
  }
  
  public final m wg(long paramLong)
  {
    AppMethodBeat.i(178244);
    if (paramLong == 0L)
    {
      AppMethodBeat.o(178244);
      return null;
    }
    Iterator localIterator = ((Iterable)this.rUD.data).iterator();
    Object localObject;
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((m)localObject).skh.field_actionInfo.Gla.commentId == paramLong)
      {
        i = 1;
        label80:
        if (i == 0) {
          break label103;
        }
      }
    }
    for (;;)
    {
      localObject = (m)localObject;
      AppMethodBeat.o(178244);
      return localObject;
      i = 0;
      break label80;
      label103:
      break;
      localObject = null;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$Companion;", "", "()V", "DEFAULT_INIT_COUNT", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$DiffDataChangeHelper;", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "(Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter;Landroid/support/v7/widget/RecyclerView;)V", "onDeleteChange", "", "commentId", "", "localCommentId", "anim", "", "onInsertChange", "target", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "onSecondaryItemRangeInsert", "rootCommentId", "", "onUpdateChange", "plugin-finder_release"})
  public final class b
  {
    final RecyclerView gmV;
    
    public b()
    {
      AppMethodBeat.i(165628);
      this.gmV = localObject;
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
            j.gfB();
          }
          m localm = (m)localObject4;
          if (localm.skh.field_actionInfo.Gla.commentId == paramLong1) {
            j = i;
          }
          if ((localm.skh.field_actionInfo.Gla.commentId == paramLong1) || (localm.skh.field_actionInfo.rID == paramLong1)) {}
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
            localObject2 = this.gmV.getAdapter();
            if (localObject2 != null) {
              ((RecyclerView.a)localObject2).as(((Number)((o)localObject1).first).intValue(), ((Number)((o)localObject1).second).intValue());
            }
          }
        }
      }
      for (;;)
      {
        localObject1 = this.gmV.getAdapter();
        if (localObject1 == null) {
          break;
        }
        ((RecyclerView.a)localObject1).notifyDataSetChanged();
        AppMethodBeat.o(178222);
        return;
        e.b(e.this).wi(paramLong2);
      }
      AppMethodBeat.o(178222);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentChangeEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderCommentChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class c
    extends com.tencent.mm.sdk.b.c<hi>
  {
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements d.g.a.a<z>
    {
      b(e.c paramc, hi paramhi)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentDataObserver$1", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeRemoved", "plugin-finder_release"})
  public static final class d
    extends RecyclerView.c
  {
    public final void at(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(165634);
      super.at(paramInt1, paramInt2);
      this.rUU.cBd();
      AppMethodBeat.o(165634);
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(165633);
      super.au(paramInt1, paramInt2);
      this.rUU.cBd();
      AppMethodBeat.o(165633);
    }
    
    public final void av(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(165636);
      super.av(paramInt1, paramInt2);
      this.rUU.cBd();
      AppMethodBeat.o(165636);
    }
    
    public final void f(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(165635);
      super.f(paramInt1, paramInt2, paramObject);
      this.rUU.cBd();
      AppMethodBeat.o(165635);
    }
    
    @SuppressLint({"StringFormatMatches"})
    public final void onChanged()
    {
      AppMethodBeat.i(165632);
      super.onChanged();
      this.rUU.cBd();
      AppMethodBeat.o(165632);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentErrorListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderCommentErrorEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class e
    extends com.tencent.mm.sdk.b.c<hj>
  {
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(e.e parame, hj paramhj)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class f
    implements DialogInterface.OnClickListener
  {
    f(e parame, Context paramContext, m paramm) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(165647);
      paramDialogInterface = this.rUU.tipDialog;
      if (paramDialogInterface != null) {
        paramDialogInterface.show();
      }
      Object localObject;
      for (;;)
      {
        localObject = (d.g.a.a)new d(this);
        paramDialogInterface = (d.g.a.a)new b(this, (d.g.a.a)localObject, (d.g.a.a)new c(this));
        if ((!paramm.skh.cIQ()) && (paramm.skh.field_localCommentId != 0L)) {
          break;
        }
        paramDialogInterface.invoke();
        AppMethodBeat.o(165647);
        return;
        paramDialogInterface = this.rUU;
        localObject = localContext;
        localContext.getString(2131755906);
        paramDialogInterface.tipDialog = ((Dialog)com.tencent.mm.ui.base.h.b((Context)localObject, localContext.getString(2131755936), false, (DialogInterface.OnCancelListener)a.rVb));
      }
      paramDialogInterface = com.tencent.mm.plugin.finder.upload.b.sID;
      paramDialogInterface = com.tencent.mm.plugin.finder.upload.b.cKC();
      ab localab = paramm.skh;
      d.g.b.p.h(localab, "wantDeleteItem");
      paramDialogInterface.sIA.c((com.tencent.mm.loader.g.c)new com.tencent.mm.plugin.finder.upload.a(localab));
      paramDialogInterface = paramDialogInterface.sIA;
      com.tencent.mm.loader.g.c localc = (com.tencent.mm.loader.g.c)new com.tencent.mm.plugin.finder.upload.a(localab);
      d.g.b.p.h(localc, "t");
      Iterator localIterator = ((Iterable)paramDialogInterface.hfp).iterator();
      while (localIterator.hasNext())
      {
        paramDialogInterface = localIterator.next();
        if (d.g.b.p.i(((com.tencent.mm.loader.g.c)((com.tencent.mm.loader.g.g)paramDialogInterface).first).aeK(), localc.aeK()))
        {
          if ((com.tencent.mm.loader.g.g)paramDialogInterface == null) {
            break label360;
          }
          paramInt = 1;
          label282:
          if (paramInt == 0) {
            break label365;
          }
          ad.i(com.tencent.mm.plugin.finder.upload.b.TAG, "removeWhenNotDoingNetScene " + localab + " is running");
        }
      }
      for (paramInt = 0;; paramInt = 1)
      {
        if (paramInt != 0) {
          break label406;
        }
        paramDialogInterface = this.rUU.tipDialog;
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
        ad.i(com.tencent.mm.plugin.finder.upload.b.TAG, "removeWhenNotDoingNetScene ".concat(String.valueOf(localab)));
        ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderActionStorage().wO(localab.field_localCommentId);
      }
      label406:
      ((d.g.a.a)localObject).invoke();
      AppMethodBeat.o(165647);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class a
      implements DialogInterface.OnCancelListener
    {
      public static final a rVb;
      
      static
      {
        AppMethodBeat.i(165642);
        rVb = new a();
        AppMethodBeat.o(165642);
      }
      
      public final void onCancel(DialogInterface paramDialogInterface) {}
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements d.g.a.a<z>
    {
      b(e.f paramf, d.g.a.a parama1, d.g.a.a parama2)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class c
      extends q
      implements d.g.a.a<z>
    {
      c(e.f paramf)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class d
      extends q
      implements d.g.a.a<z>
    {
      d(e.f paramf)
      {
        super();
      }
      
      @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$deleteComment$1$succCallback$1$1$1"})
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
  static final class g
    extends q
    implements d.g.a.b<com.tencent.mm.loader.g.h, z>
  {
    g(e parame, LinkedList paramLinkedList, m paramm)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$getAdapter$adapter$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class h
    implements com.tencent.mm.view.recyclerview.c
  {
    public final com.tencent.mm.view.recyclerview.b<?> AL(int paramInt)
    {
      AppMethodBeat.i(165648);
      if (e.i(this.rUU))
      {
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.e((CommentDrawerContract.NPresenter)this.rUU, true);
        AppMethodBeat.o(165648);
        return localObject;
      }
      Object localObject = m.skk;
      if (paramInt == m.cCJ())
      {
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.e((CommentDrawerContract.NPresenter)this.rUU, false);
        AppMethodBeat.o(165648);
        return localObject;
      }
      localObject = m.skk;
      if (paramInt == m.cCK())
      {
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.g((CommentDrawerContract.NPresenter)this.rUU);
        AppMethodBeat.o(165648);
        return localObject;
      }
      d.g.b.p.gfZ();
      AppMethodBeat.o(165648);
      return null;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
  static final class j
    extends q
    implements d.g.a.b<com.tencent.mm.loader.g.h, z>
  {
    j(e parame)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
  static final class k
    extends q
    implements d.g.a.b<com.tencent.mm.loader.g.h, z>
  {
    k(e parame, m paramm, y.d paramd, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$6$1"})
  static final class l
    implements Runnable
  {
    l(MMEditText paramMMEditText, e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(201738);
      this.rVl.requestFocus();
      if (!jdField_this.rMJ)
      {
        Object localObject = jdField_this.rUE;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.finder.view.builder.b)localObject).cNL();
          if (localObject != null)
          {
            ((FinderCommentFooter)localObject).bY(true);
            AppMethodBeat.o(201738);
            return;
          }
        }
      }
      AppMethodBeat.o(201738);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder_release"})
  public static final class m
    extends RefreshLoadMoreLayout.a
  {
    public final void AM(int paramInt)
    {
      AppMethodBeat.i(201739);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.mr(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ahq());
      com.tencent.e.h.LTJ.aR((Runnable)new b(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(201739);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(165655);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahq());
      d.g.b.p.h(paramc, "reason");
      super.a(paramc);
      e.d(this.rUU);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(165655);
    }
    
    public final void b(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(165657);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahq());
      d.g.b.p.h(paramc, "reason");
      super.b(paramc);
      e.f(this.rUU);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(165657);
    }
    
    public final void bYl()
    {
      AppMethodBeat.i(165654);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.bYl();
      com.tencent.e.h.LTJ.aR((Runnable)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(165654);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(e.m paramm) {}
      
      public final void run()
      {
        AppMethodBeat.i(165652);
        e.c(this.rVm.rUU);
        AppMethodBeat.o(165652);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(e.m paramm) {}
      
      public final void run()
      {
        AppMethodBeat.i(165653);
        e.e(this.rVm.rUU);
        AppMethodBeat.o(165653);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    n(e parame, com.tencent.mm.plugin.finder.view.builder.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178230);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      e.a(this.rUU, paramb.cNL().getScene());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(178230);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class o
    implements Runnable
  {
    o(e parame, y.d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(178231);
      if ((locald.MLT > 0) && (locald.MLT < e.b(this.rUU).data.size()))
      {
        Object localObject = this.rUU.rUE;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.finder.view.builder.b)localObject).cDf();
          if (localObject != null)
          {
            localObject = ((RefreshLoadMoreLayout)localObject).getRecyclerView();
            if (localObject == null) {}
          }
        }
        for (localObject = ((RecyclerView)localObject).getLayoutManager(); localObject == null; localObject = null)
        {
          localObject = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
          AppMethodBeat.o(178231);
          throw ((Throwable)localObject);
        }
        ((LinearLayoutManager)localObject).ag(locald.MLT, 0);
      }
      AppMethodBeat.o(178231);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "invoke"})
  static final class p
    extends q
    implements d.g.a.b<m, z>
  {
    p(e parame)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "invoke"})
  static final class q
    extends q
    implements d.g.a.b<m, z>
  {
    q(e parame)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
  static final class s
    extends q
    implements d.g.a.b<com.tencent.mm.loader.g.h, z>
  {
    s(e parame)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.e
 * JD-Core Version:    0.7.0.1
 */