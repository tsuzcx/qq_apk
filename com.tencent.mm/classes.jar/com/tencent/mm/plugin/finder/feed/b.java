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
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.h;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.hc;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.f;
import com.tencent.mm.plugin.finder.feed.model.d.a;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.model.p;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer;
import com.tencent.mm.plugin.finder.view.FinderCommentFooter;
import com.tencent.mm.plugin.finder.view.FinderCommentFooter.b;
import com.tencent.mm.plugin.finder.view.a.b;
import com.tencent.mm.plugin.finder.view.a.c;
import com.tencent.mm.plugin.finder.view.a.d;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.ahs;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.TouchableLayout.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.d.c;
import com.tencent.mm.view.recyclerview.d.d;
import d.a.j;
import d.g.b.v.c;
import d.g.b.v.e;
import d.o;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "authorMentioned", "", "getAuthorMentioned", "()Z", "setAuthorMentioned", "(Z)V", "blinkRefComment", "canPreload", "getCanPreload", "setCanPreload", "commentChangeEventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderCommentChangeEvent;", "getCommentChangeEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "commentClose", "getCommentClose", "setCommentClose", "commentCount", "", "getCommentCount", "()I", "commentDataObserver", "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentDataObserver$1", "Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentDataObserver$1;", "commentErrorListener", "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentErrorListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentErrorListener$1;", "getContext", "()Landroid/content/Context;", "dataLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentLoader;", "diffDataChangeHelper", "Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$DiffDataChangeHelper;", "value", "downContinue", "setDownContinue", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "hasExpandComment", "getHasExpandComment", "setHasExpandComment", "hitCache", "isDetached", "setDetached", "isSingleMode", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "oldVersion", "onCloseDrawerCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "refCommentId", "", "resources", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "safeMode", "getSafeMode", "setSafeMode", "scene", "getScene", "setScene", "(I)V", "taskExecutor", "Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor;", "getTaskExecutor", "()Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor;", "setTaskExecutor", "(Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor;)V", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "upContinue", "setUpContinue", "useCache", "viewCallback", "Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;)V", "calculateCommentCount", "canExpand", "comment", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "down", "checkDownContinue", "", "checkUpContinue", "deleteComment", "item", "expandLevel2Comments", "rootComment", "expandTopLevel2Comment", "", "respList", "expandWhenRefToLevel2Comment", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getCommentScene", "getCurrentFeed", "getEditText", "Lcom/tencent/mm/ui/widget/MMEditText;", "getEditTextAvatar", "Landroid/widget/ImageView;", "getFirstFriendPos", "getFirstOtherPos", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getRootComment", "rootId", "getRootCommentIndex", "getUserScene", "insertLevel2CommentsAndNotify", "level2Comments", "", "isCommentClose", "isSafeMode", "isWxScene", "keep", "p0", "loadMoreData", "loadMoreLevel2Comments", "mergeLocalLevel2Comments", "localLevel2Comments", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "onAttach", "callback", "builder", "displayScene", "replyCommentObj", "oldVer", "onClickComment", "view", "Landroid/view/View;", "onClickCommentDelete", "onClickMore", "onClickResendComment", "position", "onDetach", "onExpandClick", "onItemClick", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "onItemLongClick", "onLikeComment", "onModeChange", "from", "to", "onRecoverRecyclerViewTrans", "onReply", "sceneForReply", "onScrollIdle", "lastVisiblePosition", "preloadNextPage", "refreshData", "setCommentCountView", "transToDiscoverComment", "Companion", "DiffDataChangeHelper", "plugin-finder_release"})
public final class b
  implements CommentDrawerContract.NPresenter, FinderCommentFooter.b, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>, d.c, d.d
{
  public static final a quK;
  final Context context;
  private boolean dCJ;
  private volatile boolean isDetached;
  private volatile com.tencent.mm.bx.b lastBuffer;
  private long qoE;
  public boolean qqF;
  private boolean qqi;
  private boolean quA;
  private boolean quB;
  private boolean quC;
  private m quD;
  boolean quE;
  private boolean quF;
  boolean quG;
  private e quH;
  private final com.tencent.mm.sdk.b.c<hb> quI;
  private final d quJ;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> quc;
  final com.tencent.mm.plugin.finder.feed.model.d qut;
  private FinderItem quu;
  com.tencent.mm.plugin.finder.view.builder.a quv;
  private b quw;
  private CommentDrawerContract.CloseDrawerCallback qux;
  private boolean quy;
  private boolean quz;
  int scene;
  Dialog tipDialog;
  
  static
  {
    AppMethodBeat.i(165695);
    quK = new a((byte)0);
    AppMethodBeat.o(165695);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(197651);
    this.context = paramContext;
    this.qut = new com.tencent.mm.plugin.finder.feed.model.d();
    this.quc = new CopyOnWriteArraySet();
    this.scene = 2;
    this.quA = true;
    this.qqi = true;
    this.dCJ = true;
    this.isDetached = true;
    this.quH = new e(this);
    this.quI = ((com.tencent.mm.sdk.b.c)new c(this));
    this.quJ = new d(this);
    AppMethodBeat.o(197651);
  }
  
  private final ImageView clV()
  {
    AppMethodBeat.i(165689);
    Object localObject = this.quv;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.a)localObject).csW();
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
    Object localObject = new StringBuilder("calculateCommentCount ").append(this.qut.data.size()).append(", ");
    FinderItem localFinderItem = this.quu;
    if (localFinderItem == null) {
      d.g.b.k.aPZ("feedObj");
    }
    ad.i("Finder.DrawerPresenter", localFinderItem.getCommentCount());
    int i = this.qut.data.size();
    localObject = this.quu;
    if (localObject == null) {
      d.g.b.k.aPZ("feedObj");
    }
    i = Math.max(i, ((FinderItem)localObject).getCommentCount());
    AppMethodBeat.o(165672);
    return i;
  }
  
  private final MMEditText getEditText()
  {
    AppMethodBeat.i(165688);
    Object localObject = this.quv;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.a)localObject).csW();
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
    Object localObject = this.quv;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.a)localObject).getContext();
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
  
  private final void kR(boolean paramBoolean)
  {
    AppMethodBeat.i(165670);
    this.quz = paramBoolean;
    ad.i("Finder.DrawerPresenter", "set upContinue ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(165670);
  }
  
  private final void kS(boolean paramBoolean)
  {
    AppMethodBeat.i(165671);
    this.quA = paramBoolean;
    ad.i("Finder.DrawerPresenter", "set downContinue ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(165671);
  }
  
  private final void kT(final boolean paramBoolean)
  {
    AppMethodBeat.i(165692);
    m localm = this.quD;
    if (localm != null)
    {
      localm.a(new com.tencent.mm.plugin.finder.utils.l((d.g.a.b)new q(this, paramBoolean)));
      AppMethodBeat.o(165692);
      return;
    }
    AppMethodBeat.o(165692);
  }
  
  public final void CD(int paramInt)
  {
    AppMethodBeat.i(178247);
    Object localObject = this.qut.data;
    ad.i("Finder.DrawerPresenter", "preloadNextPage, onScrollIdle, lastVisiblePosition:" + paramInt + ", dataList size:" + ((ArrayList)localObject).size() + ", canPreload:" + this.quE);
    if ((paramInt >= 0) && (paramInt < ((ArrayList)localObject).size()))
    {
      int i = ((ArrayList)localObject).size();
      localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
      if ((i - paramInt <= com.tencent.mm.plugin.finder.storage.b.cpU()) && (this.quE))
      {
        this.quE = false;
        localObject = this.quD;
        if (localObject != null)
        {
          ((m)localObject).a(new com.tencent.mm.plugin.finder.utils.l((d.g.a.b)new p(this)));
          AppMethodBeat.o(178247);
          return;
        }
      }
    }
    AppMethodBeat.o(178247);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    Object localObject1 = null;
    AppMethodBeat.i(165682);
    d.g.b.k.h(parama, "adapter");
    d.g.b.k.h(paramView, "view");
    if (this.qqF)
    {
      AppMethodBeat.o(165682);
      return;
    }
    parama = this.qut.CG(paramInt);
    Object localObject2;
    com.tencent.mm.plugin.finder.storage.k localk;
    if (parama.qDA.cqz())
    {
      localObject2 = this.quv;
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject2).csW();
        if (localObject2 != null)
        {
          localk = parama.qDA;
          if (this.scene != 2) {
            break label363;
          }
          paramInt = 1;
          d.g.b.k.h(localk, "commentObj");
          if (paramInt == 0) {
            break label373;
          }
          parama = ((FinderCommentFooter)localObject2).getResources();
          if (parama == null) {
            break label368;
          }
          com.tencent.mm.plugin.finder.utils.i locali = com.tencent.mm.plugin.finder.utils.i.qTa;
          parama = parama.getString(2131757530, new Object[] { com.tencent.mm.plugin.finder.utils.i.fX(localk.getUsername(), localk.Su()) });
          label150:
          ((FinderCommentFooter)localObject2).u(parama, localk);
          parama = ((FinderCommentFooter)localObject2).qVV;
          if (parama == null) {
            d.g.b.k.aPZ("editText");
          }
          parama.setShowSoftInputOnFocus(true);
          parama = ((FinderCommentFooter)localObject2).qVV;
          if (parama == null) {
            d.g.b.k.aPZ("editText");
          }
          parama.requestFocus();
          ((FinderCommentFooter)localObject2).bV(true);
        }
      }
      localObject2 = new Rect();
      paramView.getGlobalVisibleRect((Rect)localObject2);
      paramInt = ((Rect)localObject2).bottom;
      parama = this.quv;
      if (parama == null) {
        break label419;
      }
      parama = parama.csX();
      label242:
      if (parama == null) {
        d.g.b.k.fvU();
      }
      parama.getGlobalVisibleRect((Rect)localObject2);
      paramInt = ((Rect)localObject2).bottom - paramInt;
      parama = this.quv;
      if (parama == null) {
        break label424;
      }
    }
    label419:
    label424:
    for (parama = parama.csW();; parama = null)
    {
      if (parama == null) {
        d.g.b.k.fvU();
      }
      if (paramInt < parama.getHeight())
      {
        int i = parama.getHeight();
        paramView = this.quv;
        parama = localObject1;
        if (paramView != null)
        {
          paramView = paramView.csX();
          parama = localObject1;
          if (paramView != null) {
            parama = paramView.getRecyclerView();
          }
        }
        if (parama == null) {
          d.g.b.k.fvU();
        }
        parama.animate().translationY(paramInt - i).setDuration(90L).start();
      }
      AppMethodBeat.o(165682);
      return;
      label363:
      paramInt = 0;
      break;
      label368:
      parama = null;
      break label150;
      label373:
      parama = ((FinderCommentFooter)localObject2).getResources();
      if (parama != null) {}
      for (parama = parama.getString(2131757530, new Object[] { localk.Su() });; parama = null)
      {
        ((FinderCommentFooter)localObject2).u(parama, localk);
        break;
      }
      parama = null;
      break label242;
    }
  }
  
  public final void a(View paramView, com.tencent.mm.plugin.finder.model.h paramh)
  {
    AppMethodBeat.i(197648);
    d.g.b.k.h(paramView, "view");
    d.g.b.k.h(paramh, "item");
    paramView = new com.tencent.mm.ui.widget.a.e(paramView.getContext(), 1, false);
    FinderItem localFinderItem = this.quu;
    if (localFinderItem == null) {
      d.g.b.k.aPZ("feedObj");
    }
    paramView.a((n.c)new a.d(paramh, localFinderItem.getUserName()));
    paramView.a((n.d)new a.c(paramh, (d.g.a.b)new b.s(this)));
    paramView.csG();
    AppMethodBeat.o(197648);
  }
  
  public final void a(ImageView paramImageView, int paramInt)
  {
    AppMethodBeat.i(165677);
    d.g.b.k.h(paramImageView, "view");
    paramImageView = this.qut.CG(paramInt);
    Object localObject1 = com.tencent.mm.plugin.finder.upload.action.d.qRR;
    localObject1 = com.tencent.mm.plugin.finder.upload.action.d.crL();
    Object localObject2 = this.quu;
    if (localObject2 == null) {
      d.g.b.k.aPZ("feedObj");
    }
    boolean bool1 = ((com.tencent.mm.plugin.finder.upload.action.d)localObject1).a(((FinderItem)localObject2).getId(), paramImageView.qDA, this.scene);
    ad.i("Finder.DrawerPresenter", "[onLikeComment] position=" + paramInt + " isLike=" + bool1 + " commentObj=" + paramImageView.qDA);
    if (!bool1) {
      bool1 = true;
    }
    boolean bool2;
    int i;
    for (;;)
    {
      if ((this.context instanceof MMActivity))
      {
        localObject1 = com.tencent.mm.ui.component.a.LCX;
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
          localObject1 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)localObject1).get(FinderReporterUIC.class)).fXs();
          localObject2 = com.tencent.mm.plugin.finder.utils.i.qTa;
          localObject2 = this.quu;
          if (localObject2 == null) {
            d.g.b.k.aPZ("feedObj");
          }
          bool2 = com.tencent.mm.plugin.finder.utils.i.ZR(((FinderItem)localObject2).getUserName());
          localObject2 = com.tencent.mm.plugin.finder.storage.b.qJA;
          if (com.tencent.mm.plugin.finder.storage.b.cqa()) {
            break label477;
          }
          localObject2 = com.tencent.mm.plugin.finder.storage.b.qJA;
          if (com.tencent.mm.plugin.finder.storage.b.fUn() != 1) {
            break label477;
          }
          i = 1;
          if ((bool2) && (i == 1))
          {
            if (!bool1) {
              break label485;
            }
            paramImageView.qDA.CS(paramImageView.qDA.field_actionInfo.Dkk.displayFlag | 0x1);
          }
        }
      }
    }
    for (;;)
    {
      localObject2 = p.qDG;
      localObject2 = this.quu;
      if (localObject2 == null) {
        d.g.b.k.aPZ("feedObj");
      }
      long l = ((FinderItem)localObject2).getId();
      localObject2 = this.quu;
      if (localObject2 == null) {
        d.g.b.k.aPZ("feedObj");
      }
      p.a((dzp)localObject1, l, ((FinderItem)localObject2).getObjectNonceId(), paramImageView.qDA, bool1, this.scene, bool2);
      paramImageView = com.tencent.mm.ui.component.a.LCX;
      paramImageView = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this.context).get(FinderReporterUIC.class));
      if (paramImageView != null)
      {
        paramImageView = paramImageView.fSl();
        localObject1 = this.quu;
        if (localObject1 == null) {
          d.g.b.k.aPZ("feedObj");
        }
        paramImageView.BE(((FinderItem)localObject1).getId());
      }
      paramImageView = this.quv;
      if (paramImageView == null) {
        break label511;
      }
      paramImageView = paramImageView.cny();
      if (paramImageView == null) {
        break label511;
      }
      paramImageView = paramImageView.getRecyclerView();
      if (paramImageView == null) {
        break label511;
      }
      paramImageView = paramImageView.getAdapter();
      if (paramImageView == null) {
        break label511;
      }
      paramImageView.b(paramInt, Integer.valueOf(1));
      AppMethodBeat.o(165677);
      return;
      label477:
      i = this.scene;
      break;
      label485:
      paramImageView.qDA.CS(paramImageView.qDA.field_actionInfo.Dkk.displayFlag & 0xFFFFFFFE);
    }
    label511:
    AppMethodBeat.o(165677);
  }
  
  public final void a(final com.tencent.mm.plugin.finder.model.h paramh, final boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(178245);
    d.g.b.k.h(paramh, "rootComment");
    this.quG = true;
    final v.c localc = new v.c();
    Object localObject1 = FinderReporterUIC.Ljl;
    localObject1 = FinderReporterUIC.a.lB(this.context);
    int i;
    if (localObject1 != null)
    {
      i = ((FinderReporterUIC)localObject1).qqE;
      localc.Jhu = i;
      if (!paramBoolean) {
        break label309;
      }
      localObject1 = paramh.qDA.field_actionInfo.Dkk.levelTwoComment;
      if (!bt.gL((List)localObject1)) {
        break label125;
      }
      i = j;
    }
    for (;;)
    {
      if (i == 0) {
        break label249;
      }
      localObject1 = com.tencent.mm.plugin.finder.report.b.qFq;
      com.tencent.mm.plugin.finder.report.b.a(paramh, 1, localc.Jhu);
      AppMethodBeat.o(178245);
      return;
      i = 0;
      break;
      label125:
      Object localObject2 = ((Iterable)this.qut.data).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          long l = ((com.tencent.mm.plugin.finder.model.h)((Iterator)localObject2).next()).qDA.field_actionInfo.Dkk.commentId;
          d.g.b.k.g(localObject1, "level2Comments");
          if (l == ((FinderCommentInfo)((LinkedList)localObject1).getFirst()).commentId)
          {
            i = j;
            break;
          }
        }
      }
      localObject2 = this.quD;
      if (localObject2 != null) {
        ((m)localObject2).a(new com.tencent.mm.plugin.finder.utils.l((d.g.a.b)new g(this, (LinkedList)localObject1, paramh)));
      }
      i = 1;
    }
    label249:
    localObject1 = com.tencent.mm.plugin.finder.report.b.qFq;
    com.tencent.mm.plugin.finder.report.b.a(paramh, 2, localc.Jhu);
    for (;;)
    {
      localObject1 = this.quD;
      if (localObject1 == null) {
        break;
      }
      ((m)localObject1).a(new com.tencent.mm.plugin.finder.utils.l((d.g.a.b)new k(this, paramh, localc, paramBoolean)));
      AppMethodBeat.o(178245);
      return;
      label309:
      localObject1 = com.tencent.mm.plugin.finder.report.b.qFq;
      com.tencent.mm.plugin.finder.report.b.a(paramh, 3, localc.Jhu);
    }
    AppMethodBeat.o(178245);
  }
  
  public final void a(final com.tencent.mm.plugin.finder.view.builder.a parama, FinderItem paramFinderItem, CommentDrawerContract.CloseDrawerCallback paramCloseDrawerCallback, int paramInt, boolean paramBoolean1, long paramLong, com.tencent.mm.plugin.finder.storage.k paramk, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    AppMethodBeat.i(197646);
    d.g.b.k.h(parama, "builder");
    d.g.b.k.h(paramFinderItem, "feedObj");
    this.isDetached = false;
    ad.i("Finder.DrawerPresenter", "onAttach " + paramFinderItem.getId() + ", " + paramInt + ", " + paramBoolean1 + ", " + paramLong);
    this.quv = parama;
    this.quu = paramFinderItem;
    this.quB = paramBoolean1;
    this.scene = paramInt;
    this.qux = paramCloseDrawerCallback;
    this.qoE = paramLong;
    this.dCJ = paramBoolean2;
    this.quC = paramBoolean3;
    this.quD = new m("FinderCommentExecutor");
    paramCloseDrawerCallback = this.quD;
    if (paramCloseDrawerCallback != null) {
      paramCloseDrawerCallback.start();
    }
    localObject1 = this.qut.b(paramFinderItem.getId(), paramLong, paramBoolean2);
    paramCloseDrawerCallback = (com.tencent.mm.plugin.finder.storage.data.c.b)((o)localObject1).first;
    paramBoolean2 = ((Boolean)((o)localObject1).second).booleanValue();
    localc = new v.c();
    localc.Jhu = paramCloseDrawerCallback.pos;
    localObject1 = paramCloseDrawerCallback.lastBuffer;
    paramBoolean3 = paramCloseDrawerCallback.quz;
    boolean bool1 = paramCloseDrawerCallback.quA;
    boolean bool2 = paramCloseDrawerCallback.qKp;
    this.lastBuffer = ((com.tencent.mm.bx.b)localObject1);
    this.quy = paramBoolean2;
    kR(paramBoolean3);
    kS(bool1);
    this.qqi = paramBoolean5;
    this.quE = true;
    this.quF = paramBoolean4;
    this.quG = bool2;
    if (this.quz)
    {
      parama.ln(true);
      parama.csW().setFooterMode(0);
      if (paramLong != 0L) {
        break label780;
      }
      paramCloseDrawerCallback = this.quv;
      if (paramCloseDrawerCallback != null)
      {
        paramCloseDrawerCallback = paramCloseDrawerCallback.csW();
        if (paramCloseDrawerCallback != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.utils.i.qTa;
          paramCloseDrawerCallback.fZ(com.tencent.mm.plugin.finder.utils.i.Dj(this.scene), paramFinderItem.getNickName());
        }
      }
    }
    label780:
    label801:
    label840:
    label969:
    label982:
    for (;;)
    {
      parama.cny().getRecyclerView().setLayoutFrozen(false);
      this.quw = new b(parama.cny().getRecyclerView());
      com.tencent.mm.sdk.b.a.ESL.c(this.quI);
      try
      {
        paramCloseDrawerCallback = parama.cny().getRecyclerView().getAdapter();
        if (paramCloseDrawerCallback != null) {
          paramCloseDrawerCallback.a((RecyclerView.c)this.quJ);
        }
      }
      catch (IllegalStateException paramCloseDrawerCallback)
      {
        for (;;)
        {
          int i;
          int j;
          ad.printErrStackTrace("Finder.DrawerPresenter", (Throwable)paramCloseDrawerCallback, "", new Object[0]);
          continue;
          parama.csV().setText((CharSequence)parama.getContext().getResources().getString(2131759162, new Object[] { com.tencent.mm.plugin.finder.utils.e.fz(this.scene, getCommentCount()) }));
          continue;
          paramCloseDrawerCallback = com.tencent.mm.plugin.finder.api.b.qnX;
          paramCloseDrawerCallback = u.aqO();
          d.g.b.k.g(paramCloseDrawerCallback, "ConfigStorageLogic.getMyFinderUsername()");
          paramCloseDrawerCallback = com.tencent.mm.plugin.finder.api.b.a.YL(paramCloseDrawerCallback);
          if (paramCloseDrawerCallback != null)
          {
            paramk = paramCloseDrawerCallback.cks();
            paramCloseDrawerCallback = paramk;
            if (paramk != null) {}
          }
          else
          {
            paramCloseDrawerCallback = "";
          }
          paramk = com.tencent.mm.plugin.finder.loader.h.qCF;
          paramk = com.tencent.mm.plugin.finder.loader.h.cmV();
          paramCloseDrawerCallback = new com.tencent.mm.plugin.finder.loader.a(paramCloseDrawerCallback);
          localObject1 = clV();
          if (localObject1 == null) {
            d.g.b.k.fvU();
          }
          Object localObject2 = com.tencent.mm.plugin.finder.loader.h.qCF;
          paramk.a(paramCloseDrawerCallback, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.h.a(h.a.qCI));
          continue;
          if ((paramBoolean2) && (localc.Jhu == 0) && (paramLong == 0L) && (!this.quG))
          {
            this.lastBuffer = null;
            kS(true);
            kT(true);
          }
          else
          {
            paramCloseDrawerCallback = this.quv;
            if (paramCloseDrawerCallback != null)
            {
              paramCloseDrawerCallback = paramCloseDrawerCallback.cny();
              if (paramCloseDrawerCallback != null)
              {
                paramCloseDrawerCallback = paramCloseDrawerCallback.getRecyclerView();
                if (paramCloseDrawerCallback != null)
                {
                  paramCloseDrawerCallback = paramCloseDrawerCallback.getAdapter();
                  if (paramCloseDrawerCallback != null) {
                    paramCloseDrawerCallback.notifyDataSetChanged();
                  }
                }
              }
            }
            paramCloseDrawerCallback = this.quv;
            if (paramCloseDrawerCallback != null)
            {
              paramCloseDrawerCallback = paramCloseDrawerCallback.cny();
              if (paramCloseDrawerCallback != null)
              {
                paramCloseDrawerCallback = paramCloseDrawerCallback.getRecyclerView();
                if (paramCloseDrawerCallback != null)
                {
                  paramCloseDrawerCallback.post((Runnable)new n(this, localc));
                  continue;
                  parama.csX().setBackgroundColorRes(2131099819);
                  continue;
                  parama.csX().setSquaresBackgroundResource(2131101053);
                  parama.csX().setBackgroundColorRes(2131101053);
                  parama.getHeaderLayout().setVisibility(8);
                  parama.cny().setVisibility(8);
                  parama = getEditText();
                  if (parama != null) {
                    parama.requestFocus();
                  }
                  if (!this.qqF)
                  {
                    parama = this.quv;
                    if (parama != null)
                    {
                      parama = parama.csW();
                      if (parama != null) {
                        parama.bV(true);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      parama.cny().setActionCallback((RefreshLoadMoreLayout.a)new l(this));
      parama.csW().setModeChangeCallback((FinderCommentFooter.b)this);
      if (getCommentCount() > 0) {
        break label1005;
      }
      parama.csV().setText((CharSequence)parama.getContext().getResources().getString(2131759158));
      parama.csW().getReplyBtn().setOnClickListener((View.OnClickListener)new m(this, parama));
      if (paramk != null)
      {
        paramCloseDrawerCallback = parama.csW();
        localObject1 = com.tencent.mm.plugin.finder.utils.i.qTa;
        localObject1 = com.tencent.mm.plugin.finder.utils.i.Dj(this.scene);
        localObject2 = com.tencent.mm.plugin.finder.utils.i.qTa;
        paramCloseDrawerCallback.e((String)localObject1, com.tencent.mm.plugin.finder.utils.i.fX(paramk.getUsername(), paramk.Su()), paramk);
      }
      if (clV() != null)
      {
        if (paramInt != 2) {
          break label1049;
        }
        com.tencent.mm.ui.f.a.a.c(clV(), u.aqG());
      }
      paramCloseDrawerCallback = this.quv;
      if (paramCloseDrawerCallback != null) {
        paramCloseDrawerCallback.hideLoading();
      }
      if (paramBoolean1) {
        break label1292;
      }
      if ((this.qut.data.size() != 0) || (paramBoolean2)) {
        break label1146;
      }
      kT(true);
      paramCloseDrawerCallback = this.quv;
      if (paramCloseDrawerCallback != null) {
        paramCloseDrawerCallback.showLoading();
      }
      paramCloseDrawerCallback = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (!com.tencent.mm.plugin.finder.storage.b.fUp()) {
        break label1279;
      }
      parama.csX().setBackgroundColorRes(2131101053);
      parama.csX().setSquaresBackgroundResource(2131234854);
      parama.cny().setVisibility(0);
      parama.getHeaderLayout().setVisibility(0);
      if (paramFinderItem.getCommentCount() == 0)
      {
        parama = getEditText();
        if (parama != null) {
          parama.postDelayed((Runnable)new b.r(parama, this), 200L);
        }
      }
      if (!this.quA)
      {
        parama = this.quv;
        if (parama != null)
        {
          parama = parama.cny();
          if (parama != null) {
            RefreshLoadMoreLayout.c(parama);
          }
        }
      }
      this.quH.alive();
      AppMethodBeat.o(197646);
      return;
      parama.ln(false);
      paramCloseDrawerCallback = this.quv;
      if (paramCloseDrawerCallback == null) {
        break;
      }
      paramCloseDrawerCallback = paramCloseDrawerCallback.csX();
      if (paramCloseDrawerCallback == null) {
        break;
      }
      paramCloseDrawerCallback.fiP();
      break;
      paramCloseDrawerCallback = (List)this.qut.data;
      i = 0;
      paramCloseDrawerCallback = paramCloseDrawerCallback.iterator();
      if (paramCloseDrawerCallback.hasNext()) {
        if (((com.tencent.mm.plugin.finder.model.h)paramCloseDrawerCallback.next()).qDA.field_actionInfo.Dkk.commentId == paramLong)
        {
          j = 1;
          if (j == 0) {
            break label969;
          }
        }
      }
      for (;;)
      {
        if (i < 0) {
          break label982;
        }
        localObject2 = (com.tencent.mm.plugin.finder.model.h)this.qut.data.get(i);
        ((com.tencent.mm.plugin.finder.model.h)localObject2).qDy = true;
        paramCloseDrawerCallback = this.quv;
        if (paramCloseDrawerCallback == null) {
          break;
        }
        FinderCommentFooter localFinderCommentFooter = paramCloseDrawerCallback.csW();
        if (localFinderCommentFooter == null) {
          break;
        }
        paramCloseDrawerCallback = com.tencent.mm.plugin.finder.utils.i.qTa;
        String str1 = com.tencent.mm.plugin.finder.utils.i.Dj(this.scene);
        paramCloseDrawerCallback = com.tencent.mm.plugin.finder.utils.i.qTa;
        String str2 = ((com.tencent.mm.plugin.finder.model.h)localObject2).qDA.getUsername();
        localObject1 = ((com.tencent.mm.plugin.finder.model.h)localObject2).qDA.Su();
        paramCloseDrawerCallback = (CommentDrawerContract.CloseDrawerCallback)localObject1;
        if (localObject1 == null) {
          paramCloseDrawerCallback = "";
        }
        localFinderCommentFooter.e(str1, com.tencent.mm.plugin.finder.utils.i.fX(str2, paramCloseDrawerCallback), ((com.tencent.mm.plugin.finder.model.h)localObject2).qDA);
        break;
        j = 0;
        break label840;
        i += 1;
        break label801;
        i = -1;
      }
    }
  }
  
  public final void ae(View paramView, int paramInt)
  {
    AppMethodBeat.i(165681);
    d.g.b.k.h(paramView, "view");
    paramView = this.qut.CG(paramInt).qDA;
    if (paramView.field_state == -1)
    {
      Object localObject = com.tencent.mm.plugin.finder.upload.b.qQD;
      localObject = com.tencent.mm.plugin.finder.upload.b.crx();
      d.g.b.k.h(paramView, "unsentComment");
      ad.i(com.tencent.mm.plugin.finder.upload.b.TAG, "rePost ".concat(String.valueOf(paramView)));
      paramView.field_state = 1;
      paramView.field_canRemove = 0;
      paramView.qB(ce.asQ() / 1000L);
      paramView.field_postTime = ce.asQ();
      paramView.field_tryCount = 0L;
      ((com.tencent.mm.plugin.finder.upload.b)localObject).a(new com.tencent.mm.plugin.finder.upload.a(paramView));
      paramView = this.quv;
      if (paramView != null)
      {
        paramView = paramView.cny();
        if (paramView != null)
        {
          paramView = paramView.getRecyclerView();
          if (paramView != null)
          {
            localObject = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter", "onClickResendComment", "(Landroid/view/View;I)V", "Undefined", "scrollToPosition", "(I)V");
            paramView.ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter", "onClickResendComment", "(Landroid/view/View;I)V", "Undefined", "scrollToPosition", "(I)V");
            AppMethodBeat.o(165681);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(165681);
  }
  
  public final boolean b(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(165683);
    d.g.b.k.h(parama, "adapter");
    d.g.b.k.h(paramView, "view");
    if (this.qqF)
    {
      AppMethodBeat.o(165683);
      return false;
    }
    Object localObject2 = this.qut.CG(paramInt);
    parama = new com.tencent.mm.ui.widget.b.a(this.context);
    Object localObject1 = this.quu;
    if (localObject1 == null) {
      d.g.b.k.aPZ("feedObj");
    }
    localObject1 = ((FinderItem)localObject1).getUserName();
    if (this.scene == 1) {}
    for (;;)
    {
      localObject1 = (View.OnCreateContextMenuListener)new a.b((com.tencent.mm.plugin.finder.model.h)localObject2, (String)localObject1, bool);
      localObject2 = (n.d)new a.c((com.tencent.mm.plugin.finder.model.h)localObject2, (d.g.a.b)new o(this));
      TouchableLayout.a locala = TouchableLayout.HYe;
      paramInt = TouchableLayout.fiK();
      locala = TouchableLayout.HYe;
      parama.a(paramView, 0, 0L, (View.OnCreateContextMenuListener)localObject1, (n.d)localObject2, paramInt, TouchableLayout.fiL());
      AppMethodBeat.o(165683);
      return false;
      bool = false;
    }
  }
  
  public final boolean b(com.tencent.mm.plugin.finder.model.h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(178246);
    d.g.b.k.h(paramh, "comment");
    Object localObject1;
    int i;
    if (paramh.qDA.field_actionInfo.qoB == 0L)
    {
      if (!paramBoolean)
      {
        AppMethodBeat.o(178246);
        return false;
      }
      localObject1 = this.qut;
      d.g.b.k.h(paramh, "root");
      if (paramh.qDA.field_actionInfo.Dkk.commentId != 0L)
      {
        localObject1 = ((Iterable)((com.tencent.mm.plugin.finder.feed.model.d)localObject1).data).iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
        } while (((com.tencent.mm.plugin.finder.model.h)((Iterator)localObject1).next()).qDA.field_actionInfo.qoB != paramh.qDA.field_actionInfo.Dkk.commentId);
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
      localObject1 = this.qut;
      d.g.b.k.h(paramh, "level2Comment");
      Iterator localIterator = ((Iterable)((com.tencent.mm.plugin.finder.feed.model.d)localObject1).data).iterator();
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
            j.fvx();
          }
          localObject2 = (com.tencent.mm.plugin.finder.model.h)localObject2;
          if (com.tencent.mm.plugin.finder.feed.model.d.b((com.tencent.mm.plugin.finder.model.h)localObject2, paramh))
          {
            j = i;
            i = k;
          }
          else if ((j >= 0) && (com.tencent.mm.plugin.finder.feed.model.d.a((com.tencent.mm.plugin.finder.model.h)localObject2, paramh)))
          {
            ad.d(((com.tencent.mm.plugin.finder.feed.model.d)localObject1).TAG, "hasLevel2ItemAfter cur:" + j + ", after:" + i);
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
    if (!this.qut.b(paramh))
    {
      AppMethodBeat.o(178246);
      return true;
    }
    AppMethodBeat.o(178246);
    return false;
  }
  
  public final void c(final com.tencent.mm.plugin.finder.model.h paramh)
  {
    AppMethodBeat.i(165678);
    d.g.b.k.h(paramh, "item");
    final Context localContext = this.context;
    if (localContext != null)
    {
      com.tencent.mm.ui.base.h.a(localContext, 2131759309, 0, (DialogInterface.OnClickListener)new f(this, localContext, paramh), null);
      AppMethodBeat.o(165678);
      return;
    }
    AppMethodBeat.o(165678);
  }
  
  public final int clT()
  {
    return this.scene;
  }
  
  public final FinderItem clU()
  {
    AppMethodBeat.i(165684);
    FinderItem localFinderItem = this.quu;
    if (localFinderItem == null) {
      d.g.b.k.aPZ("feedObj");
    }
    AppMethodBeat.o(165684);
    return localFinderItem;
  }
  
  public final void clW()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(178243);
    Object localObject3;
    if (getCommentCount() <= 0)
    {
      localObject2 = this.quv;
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject2).csV();
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
    localObject1 = this.quv;
    if (localObject1 != null)
    {
      localObject3 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject1).csV();
      if (localObject3 != null)
      {
        Resources localResources = getResources();
        localObject1 = localObject2;
        if (localResources != null) {
          localObject1 = localResources.getString(2131759162, new Object[] { com.tencent.mm.plugin.finder.utils.e.fz(this.scene, getCommentCount()) });
        }
        ((TextView)localObject3).setText((CharSequence)localObject1);
        AppMethodBeat.o(178243);
        return;
      }
    }
    AppMethodBeat.o(178243);
  }
  
  public final RecyclerView.h eC(Context paramContext)
  {
    AppMethodBeat.i(165686);
    d.g.b.k.h(paramContext, "context");
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = ((int)paramContext.getResources().getDimension(2131165299));
    paramContext = (RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.a((Drawable)new ColorDrawable(paramContext.getResources().getColor(2131099678)), (int)paramContext.getResources().getDimension(2131166292), arrayOfInt, (int)paramContext.getResources().getDimension(2131166293));
    AppMethodBeat.o(165686);
    return paramContext;
  }
  
  public final WxRecyclerAdapter<?> eD(Context paramContext)
  {
    AppMethodBeat.i(165685);
    d.g.b.k.h(paramContext, "context");
    paramContext = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.c)new h(this), this.qut.data);
    paramContext.av(false);
    paramContext.Ibo = ((d.c)this);
    paramContext.Ibn = ((d.d)this);
    AppMethodBeat.o(165685);
    return paramContext;
  }
  
  public final int fTh()
  {
    AppMethodBeat.i(197649);
    Object localObject = this.qut.data;
    int i;
    if (!bt.gL((List)localObject))
    {
      localObject = (com.tencent.mm.plugin.finder.model.h)j.iz((List)localObject);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.model.h)localObject).qDA;
        if (localObject != null)
        {
          if (((com.tencent.mm.plugin.finder.storage.k)localObject).fVa() != true) {
            break label71;
          }
          i = 0;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(197649);
      return i;
      i = -1;
      continue;
      label71:
      i = -1;
    }
  }
  
  public final int fTi()
  {
    AppMethodBeat.i(197650);
    Object localObject1 = this.qut.data;
    if (!bt.gL((List)localObject1))
    {
      localObject1 = ((Iterable)localObject1).iterator();
      int i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          j.fvx();
        }
        localObject2 = (com.tencent.mm.plugin.finder.model.h)localObject2;
        if ((((com.tencent.mm.plugin.finder.model.h)localObject2).qDA.field_actionInfo.qoB == 0L) && (!((com.tencent.mm.plugin.finder.model.h)localObject2).qDA.fVa()))
        {
          AppMethodBeat.o(197650);
          return i;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(197650);
    return -1;
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(197647);
    Object localObject = FinderReporterUIC.Ljl;
    localObject = FinderReporterUIC.a.lB(this.context);
    if (localObject != null)
    {
      int i = ((FinderReporterUIC)localObject).qqE;
      AppMethodBeat.o(197647);
      return i;
    }
    AppMethodBeat.o(197647);
    return 0;
  }
  
  public final boolean isCommentClose()
  {
    return this.quF;
  }
  
  public final void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(165673);
    d.g.b.k.h(parama, "p0");
    this.quc.add(parama);
    AppMethodBeat.o(165673);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(165675);
    this.isDetached = true;
    this.quE = false;
    Object localObject1 = this.quD;
    if (localObject1 != null) {
      ((m)localObject1).stop();
    }
    this.quD = null;
    localObject1 = this.quv;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject1).cny();
      if (localObject1 != null)
      {
        localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
        if (localObject1 != null)
        {
          localObject1 = ((RecyclerView)localObject1).getLayoutManager();
          if (!(localObject1 instanceof LinearLayoutManager)) {
            break label306;
          }
          localObject1 = this.quv;
          if (localObject1 == null) {
            break label161;
          }
          localObject1 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject1).cny();
          if (localObject1 == null) {
            break label161;
          }
          localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
          if (localObject1 == null) {
            break label161;
          }
        }
      }
    }
    label161:
    for (localObject1 = ((RecyclerView)localObject1).getLayoutManager();; localObject1 = null)
    {
      if (localObject1 != null) {
        break label167;
      }
      localObject1 = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
      AppMethodBeat.o(165675);
      throw ((Throwable)localObject1);
      localObject1 = null;
      break;
    }
    label167:
    label306:
    for (int i = ((LinearLayoutManager)localObject1).jO();; i = -1)
    {
      localObject1 = this.quv;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject1).csW();
        if (localObject1 != null) {
          ((FinderCommentFooter)localObject1).setFooterMode(0);
        }
      }
      localObject1 = this.quv;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject1).cny();
        if (localObject1 != null)
        {
          localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
          if (localObject1 != null)
          {
            localObject1 = ((RecyclerView)localObject1).getAdapter();
            if (localObject1 != null) {
              ((RecyclerView.a)localObject1).b((RecyclerView.c)this.quJ);
            }
          }
        }
      }
      localObject1 = ((Iterable)this.quc).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((com.tencent.mm.vending.e.a)((Iterator)localObject1).next()).dead();
      }
    }
    this.quc.clear();
    com.tencent.mm.sdk.b.a.ESL.d(this.quI);
    localObject1 = this.quu;
    if (localObject1 == null) {
      d.g.b.k.aPZ("feedObj");
    }
    ((FinderItem)localObject1).setCommentCount(getCommentCount());
    localObject1 = com.tencent.mm.plugin.finder.storage.data.b.qKl;
    localObject1 = this.quu;
    if (localObject1 == null) {
      d.g.b.k.aPZ("feedObj");
    }
    com.tencent.mm.plugin.finder.storage.data.b.a.e((FinderItem)localObject1);
    localObject1 = new StringBuilder("[onDetach] updateFeedCommentCount feedId=");
    Object localObject2 = this.quu;
    if (localObject2 == null) {
      d.g.b.k.aPZ("feedObj");
    }
    ad.i("Finder.DrawerPresenter", ((FinderItem)localObject2).getId() + " commentCount " + getCommentCount());
    localObject1 = this.qux;
    if (localObject1 != null) {
      ((CommentDrawerContract.CloseDrawerCallback)localObject1).o(getCommentCount(), (List)this.qut.data);
    }
    if ((this.quB) || (!this.dCJ))
    {
      this.qut.data.clear();
      this.lastBuffer = null;
      kR(false);
      kS(true);
      localObject1 = getEditText();
      if (localObject1 != null) {
        ((MMEditText)localObject1).setText(null);
      }
      localObject1 = this.quv;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject1).cny();
        if (localObject1 != null) {
          ((RefreshLoadMoreLayout)localObject1).setHasBottomMore(true);
        }
      }
      localObject1 = this.quv;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject1).cny();
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
      localObject1 = this.quv;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject1).cny();
        if (localObject1 != null)
        {
          localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
          if (localObject1 != null) {
            ((RecyclerView)localObject1).setLayoutFrozen(true);
          }
        }
      }
      localObject1 = this.quv;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject1).cny();
        if (localObject1 != null) {
          ((RefreshLoadMoreLayout)localObject1).setActionCallback(null);
        }
      }
      this.quv = null;
      this.quH.dead();
      AppMethodBeat.o(165675);
      return;
    }
    int k = i;
    int j;
    if (this.qoE != 0L)
    {
      localObject1 = ((Iterable)this.qut.data).iterator();
      j = 0;
      label732:
      k = i;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (j < 0) {
          j.fvx();
        }
        localObject2 = (com.tencent.mm.plugin.finder.model.h)localObject2;
        if (((com.tencent.mm.plugin.finder.model.h)localObject2).qDA.field_actionInfo.Dkk.commentId != this.qoE) {
          break label913;
        }
        ((com.tencent.mm.plugin.finder.model.h)localObject2).qDz = false;
        i = j;
      }
    }
    label913:
    for (;;)
    {
      j += 1;
      break label732;
      localObject1 = this.qut;
      localObject2 = this.lastBuffer;
      boolean bool1 = this.quz;
      boolean bool2 = this.quA;
      boolean bool3 = this.quG;
      if ((((com.tencent.mm.plugin.finder.feed.model.d)localObject1).data.size() >= 0) && (k >= 0)) {
        d.a.a(((com.tencent.mm.plugin.finder.feed.model.d)localObject1).qyv, ((com.tencent.mm.plugin.finder.feed.model.d)localObject1).qyw, ((com.tencent.mm.plugin.finder.feed.model.d)localObject1).data);
      }
      ((com.tencent.mm.plugin.finder.feed.model.d)localObject1).data.clear();
      if ((k < 0) || (com.tencent.mm.plugin.finder.feed.model.d.qyx)) {
        break;
      }
      com.tencent.mm.plugin.finder.storage.data.c.qKo.a(((com.tencent.mm.plugin.finder.feed.model.d)localObject1).qyv, ((com.tencent.mm.plugin.finder.feed.model.d)localObject1).qyw, k, (com.tencent.mm.bx.b)localObject2, bool1, bool2, bool3);
      break;
    }
  }
  
  public final void onModeChange(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(165676);
    ad.i("Finder.DrawerPresenter", "[onModeChange] from=" + paramInt1 + " to=" + paramInt2);
    if (paramInt2 == 0)
    {
      Object localObject1 = this.quv;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject1).csX();
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
        localObject1 = this.quv;
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject1).csW();
          if (localObject1 != null)
          {
            Object localObject2 = com.tencent.mm.plugin.finder.utils.i.qTa;
            localObject2 = com.tencent.mm.plugin.finder.utils.i.Dj(this.scene);
            FinderItem localFinderItem = this.quu;
            if (localFinderItem == null) {
              d.g.b.k.aPZ("feedObj");
            }
            ((FinderCommentFooter)localObject1).fZ((String)localObject2, localFinderItem.getNickName());
            AppMethodBeat.o(165676);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(165676);
  }
  
  public final com.tencent.mm.plugin.finder.model.h qa(long paramLong)
  {
    AppMethodBeat.i(178244);
    if (paramLong == 0L)
    {
      AppMethodBeat.o(178244);
      return null;
    }
    Iterator localIterator = ((Iterable)this.qut.data).iterator();
    Object localObject;
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((com.tencent.mm.plugin.finder.model.h)localObject).qDA.field_actionInfo.Dkk.commentId == paramLong)
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
      localObject = (com.tencent.mm.plugin.finder.model.h)localObject;
      AppMethodBeat.o(178244);
      return localObject;
      i = 0;
      break label80;
      label103:
      break;
      localObject = null;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$Companion;", "", "()V", "DEFAULT_INIT_COUNT", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$DiffDataChangeHelper;", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "(Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter;Landroid/support/v7/widget/RecyclerView;)V", "onDeleteChange", "", "commentId", "", "localCommentId", "anim", "", "onInsertChange", "target", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "onSecondaryItemRangeInsert", "rootCommentId", "", "onUpdateChange", "plugin-finder_release"})
  public final class b
  {
    final RecyclerView fPw;
    
    public b()
    {
      AppMethodBeat.i(165628);
      this.fPw = localObject;
      AppMethodBeat.o(165628);
    }
    
    public final void a(long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(178222);
      Object localObject1;
      if (paramLong1 != 0L)
      {
        int m = b.b(b.this).data.size();
        localObject1 = b.b(b.this);
        Object localObject3 = (Iterable)((com.tencent.mm.plugin.finder.feed.model.d)localObject1).data;
        Object localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        int i = 0;
        int j = -1;
        if (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = ((Iterator)localObject3).next();
          if (i < 0) {
            j.fvx();
          }
          com.tencent.mm.plugin.finder.model.h localh = (com.tencent.mm.plugin.finder.model.h)localObject4;
          if (localh.qDA.field_actionInfo.Dkk.commentId == paramLong1) {
            j = i;
          }
          if ((localh.qDA.field_actionInfo.Dkk.commentId == paramLong1) || (localh.qDA.field_actionInfo.qoB == paramLong1)) {}
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
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject1).data.removeAll((Collection)localObject2);
        localObject1 = new o(Integer.valueOf(j), Integer.valueOf(i));
        if ((paramBoolean) && (((Number)((o)localObject1).first).intValue() >= 0))
        {
          i = ((Number)((o)localObject1).first).intValue();
          if (((Number)((o)localObject1).second).intValue() + i <= m)
          {
            localObject2 = this.fPw.getAdapter();
            if (localObject2 != null) {
              ((RecyclerView.a)localObject2).ar(((Number)((o)localObject1).first).intValue(), ((Number)((o)localObject1).second).intValue());
            }
          }
        }
      }
      for (;;)
      {
        localObject1 = this.fPw.getAdapter();
        if (localObject1 == null) {
          break;
        }
        ((RecyclerView.a)localObject1).notifyDataSetChanged();
        AppMethodBeat.o(178222);
        return;
        b.b(b.this).qe(paramLong2);
      }
      AppMethodBeat.o(178222);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentChangeEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderCommentChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class c
    extends com.tencent.mm.sdk.b.c<hb>
  {
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      b(b.c paramc, hb paramhb)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentDataObserver$1", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeRemoved", "plugin-finder_release"})
  public static final class d
    extends RecyclerView.c
  {
    public final void as(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(165634);
      super.as(paramInt1, paramInt2);
      this.quL.clW();
      AppMethodBeat.o(165634);
    }
    
    public final void at(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(165633);
      super.at(paramInt1, paramInt2);
      this.quL.clW();
      AppMethodBeat.o(165633);
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(165636);
      super.au(paramInt1, paramInt2);
      this.quL.clW();
      AppMethodBeat.o(165636);
    }
    
    public final void f(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(165635);
      super.f(paramInt1, paramInt2, paramObject);
      this.quL.clW();
      AppMethodBeat.o(165635);
    }
    
    @SuppressLint({"StringFormatMatches"})
    public final void onChanged()
    {
      AppMethodBeat.i(165632);
      super.onChanged();
      this.quL.clW();
      AppMethodBeat.o(165632);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentErrorListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderCommentErrorEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class e
    extends com.tencent.mm.sdk.b.c<hc>
  {
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(b.e parame, hc paramhc)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      b(b.e parame)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class f
    implements DialogInterface.OnClickListener
  {
    f(b paramb, Context paramContext, com.tencent.mm.plugin.finder.model.h paramh) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(165647);
      paramDialogInterface = this.quL.tipDialog;
      if (paramDialogInterface != null) {
        paramDialogInterface.show();
      }
      Object localObject;
      for (;;)
      {
        localObject = (d.g.a.a)new d(this);
        paramDialogInterface = (d.g.a.a)new b(this, (d.g.a.a)localObject, (d.g.a.a)new c(this));
        if ((!paramh.qDA.cqz()) && (paramh.qDA.field_localCommentId != 0L)) {
          break;
        }
        paramDialogInterface.invoke();
        AppMethodBeat.o(165647);
        return;
        paramDialogInterface = this.quL;
        localObject = localContext;
        localContext.getString(2131755906);
        paramDialogInterface.tipDialog = ((Dialog)com.tencent.mm.ui.base.h.b((Context)localObject, localContext.getString(2131755936), false, (DialogInterface.OnCancelListener)b.f.a.quS));
      }
      paramDialogInterface = com.tencent.mm.plugin.finder.upload.b.qQD;
      paramDialogInterface = com.tencent.mm.plugin.finder.upload.b.crx();
      com.tencent.mm.plugin.finder.storage.k localk = paramh.qDA;
      d.g.b.k.h(localk, "wantDeleteItem");
      paramDialogInterface.qQA.c((com.tencent.mm.loader.g.c)new com.tencent.mm.plugin.finder.upload.a(localk));
      paramDialogInterface = paramDialogInterface.qQA;
      com.tencent.mm.loader.g.c localc = (com.tencent.mm.loader.g.c)new com.tencent.mm.plugin.finder.upload.a(localk);
      d.g.b.k.h(localc, "t");
      Iterator localIterator = ((Iterable)paramDialogInterface.gkN).iterator();
      while (localIterator.hasNext())
      {
        paramDialogInterface = localIterator.next();
        if (d.g.b.k.g(((com.tencent.mm.loader.g.c)((com.tencent.mm.loader.g.g)paramDialogInterface).first).abi(), localc.abi()))
        {
          if ((com.tencent.mm.loader.g.g)paramDialogInterface == null) {
            break label360;
          }
          paramInt = 1;
          label282:
          if (paramInt == 0) {
            break label365;
          }
          ad.i(com.tencent.mm.plugin.finder.upload.b.TAG, "removeWhenNotDoingNetScene " + localk + " is running");
        }
      }
      for (paramInt = 0;; paramInt = 1)
      {
        if (paramInt != 0) {
          break label406;
        }
        paramDialogInterface = this.quL.tipDialog;
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
        ad.i(com.tencent.mm.plugin.finder.upload.b.TAG, "removeWhenNotDoingNetScene ".concat(String.valueOf(localk)));
        ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderActionStorage().qx(localk.field_localCommentId);
      }
      label406:
      ((d.g.a.a)localObject).invoke();
      AppMethodBeat.o(165647);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      b(b.f paramf, d.g.a.a parama1, d.g.a.a parama2)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class c
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      c(b.f paramf)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class d
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      d(b.f paramf)
      {
        super();
      }
      
      @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$deleteComment$1$succCallback$1$1$1"})
      static final class a
        extends d.g.b.l
        implements d.g.a.b<FinderCommentInfo, Boolean>
      {
        a(b.f.d paramd)
        {
          super();
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "task", "Lcom/tencent/mm/plugin/finder/utils/SingleTask;", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.plugin.finder.utils.l, y>
  {
    g(b paramb, LinkedList paramLinkedList, com.tencent.mm.plugin.finder.model.h paramh)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$getAdapter$adapter$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class h
    implements com.tencent.mm.view.recyclerview.c
  {
    public final com.tencent.mm.view.recyclerview.b<?> zm(int paramInt)
    {
      AppMethodBeat.i(165648);
      if (b.i(this.quL))
      {
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.b((CommentDrawerContract.NPresenter)this.quL, true);
        AppMethodBeat.o(165648);
        return localObject;
      }
      Object localObject = com.tencent.mm.plugin.finder.model.h.qDD;
      if (paramInt == com.tencent.mm.plugin.finder.model.h.cmY())
      {
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.b((CommentDrawerContract.NPresenter)this.quL, false);
        AppMethodBeat.o(165648);
        return localObject;
      }
      localObject = com.tencent.mm.plugin.finder.model.h.qDD;
      if (paramInt == com.tencent.mm.plugin.finder.model.h.cmZ())
      {
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.d((CommentDrawerContract.NPresenter)this.quL);
        AppMethodBeat.o(165648);
        return localObject;
      }
      d.g.b.k.fvU();
      AppMethodBeat.o(165648);
      return null;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "task", "Lcom/tencent/mm/plugin/finder/utils/SingleTask;", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.plugin.finder.utils.l, y>
  {
    j(b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "task", "Lcom/tencent/mm/plugin/finder/utils/SingleTask;", "invoke"})
  static final class k
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.plugin.finder.utils.l, y>
  {
    k(b paramb, com.tencent.mm.plugin.finder.model.h paramh, v.c paramc, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder_release"})
  public static final class l
    extends RefreshLoadMoreLayout.a
  {
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(165655);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ado());
      d.g.b.k.h(paramc, "reason");
      super.a(paramc);
      b.d(this.quL);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(165655);
    }
    
    public final void agP(int paramInt)
    {
      AppMethodBeat.i(197643);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.lT(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ado());
      com.tencent.e.h.Iye.aP((Runnable)new b(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(197643);
    }
    
    public final void b(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(165657);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ado());
      d.g.b.k.h(paramc, "reason");
      super.b(paramc);
      b.f(this.quL);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(165657);
    }
    
    public final void bMu()
    {
      AppMethodBeat.i(165654);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.bMu();
      com.tencent.e.h.Iye.aP((Runnable)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(165654);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(b.l paraml) {}
      
      public final void run()
      {
        AppMethodBeat.i(165652);
        b.c(this.qvb.quL);
        AppMethodBeat.o(165652);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(b.l paraml) {}
      
      public final void run()
      {
        AppMethodBeat.i(165653);
        b.e(this.qvb.quL);
        AppMethodBeat.o(165653);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(b paramb, com.tencent.mm.plugin.finder.view.builder.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178230);
      b.a(this.quL, parama.csW().getScene());
      AppMethodBeat.o(178230);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class n
    implements Runnable
  {
    n(b paramb, v.c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(178231);
      if ((localc.Jhu > 0) && (localc.Jhu < b.b(this.quL).data.size()))
      {
        Object localObject = this.quL.quv;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.finder.view.builder.a)localObject).cny();
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
        ((LinearLayoutManager)localObject).af(localc.Jhu, 0);
      }
      AppMethodBeat.o(178231);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "invoke"})
  static final class o
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.plugin.finder.model.h, y>
  {
    o(b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "task", "Lcom/tencent/mm/plugin/finder/utils/SingleTask;", "invoke"})
  static final class p
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.plugin.finder.utils.l, y>
  {
    p(b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "task", "Lcom/tencent/mm/plugin/finder/utils/SingleTask;", "invoke"})
  static final class q
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.plugin.finder.utils.l, y>
  {
    q(b paramb, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.b
 * JD-Core Version:    0.7.0.1
 */