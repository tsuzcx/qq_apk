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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hd;
import com.tencent.mm.g.a.he;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e.b;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.plugin.finder.utils.q;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer;
import com.tencent.mm.plugin.finder.view.FinderCommentFooter;
import com.tencent.mm.plugin.finder.view.FinderCommentFooter.b;
import com.tencent.mm.plugin.finder.view.a.a;
import com.tencent.mm.plugin.finder.view.a.c;
import com.tencent.mm.plugin.finder.view.a.d;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.air;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.TouchableLayout.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.a.j;
import d.g.b.k;
import d.g.b.v.d;
import d.g.b.v.f;
import d.o;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "authorMentioned", "", "getAuthorMentioned", "()Z", "setAuthorMentioned", "(Z)V", "blinkRefComment", "canPreload", "getCanPreload", "setCanPreload", "commentChangeEventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderCommentChangeEvent;", "getCommentChangeEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "commentClose", "getCommentClose", "setCommentClose", "commentCount", "", "getCommentCount", "()I", "commentDataObserver", "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentDataObserver$1", "Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentDataObserver$1;", "commentErrorListener", "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentErrorListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentErrorListener$1;", "getContext", "()Landroid/content/Context;", "dataLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentLoader;", "diffDataChangeHelper", "Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$DiffDataChangeHelper;", "value", "downContinue", "setDownContinue", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "hasExpandComment", "getHasExpandComment", "setHasExpandComment", "hitCache", "isDetached", "setDetached", "isSingleMode", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "oldVersion", "onCloseDrawerCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "refCommentId", "", "resources", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "safeMode", "getSafeMode", "setSafeMode", "scene", "getScene", "setScene", "(I)V", "taskExecutor", "Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor;", "getTaskExecutor", "()Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor;", "setTaskExecutor", "(Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor;)V", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "upContinue", "setUpContinue", "useCache", "viewCallback", "Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;)V", "calculateCommentCount", "canExpand", "comment", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "down", "checkDownContinue", "", "checkUpContinue", "deleteComment", "item", "expandLevel2Comments", "rootComment", "expandTopLevel2Comment", "", "respList", "expandWhenRefToLevel2Comment", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getCommentScene", "getCurrentFeed", "getEditText", "Lcom/tencent/mm/ui/widget/MMEditText;", "getEditTextAvatar", "Landroid/widget/ImageView;", "getFirstFriendPos", "getFirstOtherPos", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getRootComment", "rootId", "getRootCommentIndex", "getUserScene", "insertLevel2CommentsAndNotify", "level2Comments", "", "isCommentClose", "isSafeMode", "isWxScene", "keep", "p0", "loadMoreData", "loadMoreLevel2Comments", "mergeLocalLevel2Comments", "localLevel2Comments", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "onAttach", "callback", "builder", "displayScene", "replyCommentObj", "oldVer", "onClickComment", "view", "Landroid/view/View;", "onClickCommentDelete", "onClickMore", "onClickResendComment", "position", "onDetach", "onExpandClick", "onItemClick", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "onItemLongClick", "onLikeComment", "onModeChange", "from", "to", "onRecoverRecyclerViewTrans", "onReply", "sceneForReply", "onScrollIdle", "lastVisiblePosition", "preloadNextPage", "refreshData", "setCommentCountView", "transToDiscoverComment", "Companion", "DiffDataChangeHelper", "plugin-finder_release"})
public final class d
  implements CommentDrawerContract.NPresenter, FinderCommentFooter.b, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>, com.tencent.mm.view.recyclerview.d.c, com.tencent.mm.view.recyclerview.d.d
{
  public static final d.a rgM;
  final Context context;
  private boolean dAv;
  private volatile boolean isDetached;
  private volatile com.tencent.mm.bw.b lastBuffer;
  private long qXy;
  private boolean qZP;
  public boolean ran;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> rfP;
  private boolean rgA;
  private boolean rgB;
  private boolean rgC;
  private boolean rgD;
  private boolean rgE;
  private r rgF;
  boolean rgG;
  private boolean rgH;
  boolean rgI;
  private e rgJ;
  private final com.tencent.mm.sdk.b.c<hd> rgK;
  private final d rgL;
  final com.tencent.mm.plugin.finder.feed.model.b rgv;
  private FinderItem rgw;
  com.tencent.mm.plugin.finder.view.builder.b rgx;
  private b rgy;
  private CommentDrawerContract.CloseDrawerCallback rgz;
  int scene;
  Dialog tipDialog;
  
  static
  {
    AppMethodBeat.i(165695);
    rgM = new d.a((byte)0);
    AppMethodBeat.o(165695);
  }
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(201548);
    this.context = paramContext;
    this.rgv = new com.tencent.mm.plugin.finder.feed.model.b();
    this.rfP = new CopyOnWriteArraySet();
    this.scene = 2;
    this.rgC = true;
    this.qZP = true;
    this.dAv = true;
    this.isDetached = true;
    this.rgJ = new e(this);
    this.rgK = ((com.tencent.mm.sdk.b.c)new c(this));
    this.rgL = new d(this);
    AppMethodBeat.o(201548);
  }
  
  private final ImageView cuL()
  {
    AppMethodBeat.i(165689);
    Object localObject = this.rgx;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.b)localObject).cFo();
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
    Object localObject = new StringBuilder("calculateCommentCount ").append(this.rgv.data.size()).append(", ");
    FinderItem localFinderItem = this.rgw;
    if (localFinderItem == null) {
      k.aVY("feedObj");
    }
    ac.i("Finder.DrawerPresenter", localFinderItem.getCommentCount());
    int i = this.rgv.data.size();
    localObject = this.rgw;
    if (localObject == null) {
      k.aVY("feedObj");
    }
    i = Math.max(i, ((FinderItem)localObject).getCommentCount());
    AppMethodBeat.o(165672);
    return i;
  }
  
  private final MMEditText getEditText()
  {
    AppMethodBeat.i(165688);
    Object localObject = this.rgx;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.b)localObject).cFo();
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
    Object localObject = this.rgx;
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
  
  private final void lu(boolean paramBoolean)
  {
    AppMethodBeat.i(165670);
    this.rgB = paramBoolean;
    ac.i("Finder.DrawerPresenter", "set upContinue ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(165670);
  }
  
  private final void lv(boolean paramBoolean)
  {
    AppMethodBeat.i(165671);
    this.rgC = paramBoolean;
    ac.i("Finder.DrawerPresenter", "set downContinue ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(165671);
  }
  
  private final void lw(final boolean paramBoolean)
  {
    AppMethodBeat.i(165692);
    r localr = this.rgF;
    if (localr != null)
    {
      localr.a(new q((d.g.a.b)new t(this, paramBoolean)));
      AppMethodBeat.o(165692);
      return;
    }
    AppMethodBeat.o(165692);
  }
  
  public final void DF(int paramInt)
  {
    AppMethodBeat.i(178247);
    Object localObject = this.rgv.data;
    ac.i("Finder.DrawerPresenter", "preloadNextPage, onScrollIdle, lastVisiblePosition:" + paramInt + ", dataList size:" + ((ArrayList)localObject).size() + ", canPreload:" + this.rgG);
    if ((paramInt >= 0) && (paramInt < ((ArrayList)localObject).size()))
    {
      int i = ((ArrayList)localObject).size();
      localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
      if ((i - paramInt <= com.tencent.mm.plugin.finder.storage.b.czw()) && (this.rgG))
      {
        this.rgG = false;
        localObject = this.rgF;
        if (localObject != null)
        {
          ((r)localObject).a(new q((d.g.a.b)new s(this)));
          AppMethodBeat.o(178247);
          return;
        }
      }
    }
    AppMethodBeat.o(178247);
  }
  
  public final void a(View paramView, com.tencent.mm.plugin.finder.model.l paraml)
  {
    AppMethodBeat.i(201545);
    k.h(paramView, "view");
    k.h(paraml, "item");
    paramView = new com.tencent.mm.ui.widget.a.e(paramView.getContext(), 1, false);
    FinderItem localFinderItem = this.rgw;
    if (localFinderItem == null) {
      k.aVY("feedObj");
    }
    paramView.a((n.c)new a.a(paraml, localFinderItem.getUserName()));
    paramView.a((n.d)new a.d(paraml, (d.g.a.b)new p(this)));
    paramView.cED();
    AppMethodBeat.o(201545);
  }
  
  public final void a(ImageView paramImageView, int paramInt)
  {
    AppMethodBeat.i(165677);
    k.h(paramImageView, "view");
    paramImageView = this.rgv.DI(paramInt);
    Object localObject1 = com.tencent.mm.plugin.finder.upload.action.g.rOb;
    localObject1 = com.tencent.mm.plugin.finder.upload.action.g.cCH();
    Object localObject2 = this.rgw;
    if (localObject2 == null) {
      k.aVY("feedObj");
    }
    boolean bool1 = ((com.tencent.mm.plugin.finder.upload.action.g)localObject1).a(((FinderItem)localObject2).getId(), paramImageView.ruO, this.scene);
    ac.i("Finder.DrawerPresenter", "[onLikeComment] position=" + paramInt + " isLike=" + bool1 + " commentObj=" + paramImageView.ruO);
    if (!bool1) {
      bool1 = true;
    }
    boolean bool2;
    int i;
    for (;;)
    {
      if ((this.context instanceof MMActivity))
      {
        localObject1 = com.tencent.mm.ui.component.a.IrY;
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
          localObject1 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.q((MMActivity)localObject1).get(FinderReporterUIC.class)).cGb();
          localObject2 = n.rPN;
          localObject2 = this.rgw;
          if (localObject2 == null) {
            k.aVY("feedObj");
          }
          bool2 = n.aeD(((FinderItem)localObject2).getUserName());
          localObject2 = com.tencent.mm.plugin.finder.storage.b.rCU;
          if (com.tencent.mm.plugin.finder.storage.b.czB()) {
            break label477;
          }
          localObject2 = com.tencent.mm.plugin.finder.storage.b.rCU;
          if (com.tencent.mm.plugin.finder.storage.b.czC() != 1) {
            break label477;
          }
          i = 1;
          if ((bool2) && (i == 1))
          {
            if (!bool1) {
              break label485;
            }
            paramImageView.ruO.Ei(paramImageView.ruO.field_actionInfo.EDq.displayFlag | 0x1);
          }
        }
      }
    }
    for (;;)
    {
      localObject2 = com.tencent.mm.plugin.finder.model.u.ruV;
      localObject2 = this.rgw;
      if (localObject2 == null) {
        k.aVY("feedObj");
      }
      long l = ((FinderItem)localObject2).getId();
      localObject2 = this.rgw;
      if (localObject2 == null) {
        k.aVY("feedObj");
      }
      com.tencent.mm.plugin.finder.model.u.a((anm)localObject1, l, ((FinderItem)localObject2).getObjectNonceId(), paramImageView.ruO, bool1, this.scene, bool2);
      paramImageView = com.tencent.mm.ui.component.a.IrY;
      paramImageView = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.q((MMActivity)this.context).get(FinderReporterUIC.class));
      if (paramImageView != null)
      {
        paramImageView = paramImageView.ctb();
        localObject1 = this.rgw;
        if (localObject1 == null) {
          k.aVY("feedObj");
        }
        paramImageView.uc(((FinderItem)localObject1).getId());
      }
      paramImageView = this.rgx;
      if (paramImageView == null) {
        break label511;
      }
      paramImageView = paramImageView.cwM();
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
      paramImageView.ruO.Ei(paramImageView.ruO.field_actionInfo.EDq.displayFlag & 0xFFFFFFFE);
    }
    label511:
    AppMethodBeat.o(165677);
  }
  
  public final void a(final com.tencent.mm.plugin.finder.model.l paraml)
  {
    AppMethodBeat.i(165678);
    k.h(paraml, "item");
    final Context localContext = this.context;
    if (localContext != null)
    {
      com.tencent.mm.ui.base.h.a(localContext, 2131759309, 0, (DialogInterface.OnClickListener)new f(this, localContext, paraml), null);
      AppMethodBeat.o(165678);
      return;
    }
    AppMethodBeat.o(165678);
  }
  
  public final void a(final com.tencent.mm.plugin.finder.model.l paraml, final boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(178245);
    k.h(paraml, "rootComment");
    this.rgI = true;
    final v.d locald = new v.d();
    Object localObject1 = FinderReporterUIC.seQ;
    localObject1 = FinderReporterUIC.a.eV(this.context);
    int i;
    if (localObject1 != null)
    {
      i = ((FinderReporterUIC)localObject1).rfR;
      locald.KUO = i;
      if (!paramBoolean) {
        break label309;
      }
      localObject1 = paraml.ruO.field_actionInfo.EDq.levelTwoComment;
      if (!bs.gY((List)localObject1)) {
        break label125;
      }
      i = j;
    }
    for (;;)
    {
      if (i == 0) {
        break label249;
      }
      localObject1 = com.tencent.mm.plugin.finder.report.d.rxr;
      com.tencent.mm.plugin.finder.report.d.a(paraml, 1, locald.KUO);
      AppMethodBeat.o(178245);
      return;
      i = 0;
      break;
      label125:
      Object localObject2 = ((Iterable)this.rgv.data).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          long l = ((com.tencent.mm.plugin.finder.model.l)((Iterator)localObject2).next()).ruO.field_actionInfo.EDq.commentId;
          k.g(localObject1, "level2Comments");
          if (l == ((FinderCommentInfo)((LinkedList)localObject1).getFirst()).commentId)
          {
            i = j;
            break;
          }
        }
      }
      localObject2 = this.rgF;
      if (localObject2 != null) {
        ((r)localObject2).a(new q((d.g.a.b)new g(this, (LinkedList)localObject1, paraml)));
      }
      i = 1;
    }
    label249:
    localObject1 = com.tencent.mm.plugin.finder.report.d.rxr;
    com.tencent.mm.plugin.finder.report.d.a(paraml, 2, locald.KUO);
    for (;;)
    {
      localObject1 = this.rgF;
      if (localObject1 == null) {
        break;
      }
      ((r)localObject1).a(new q((d.g.a.b)new k(this, paraml, locald, paramBoolean)));
      AppMethodBeat.o(178245);
      return;
      label309:
      localObject1 = com.tencent.mm.plugin.finder.report.d.rxr;
      com.tencent.mm.plugin.finder.report.d.a(paraml, 3, locald.KUO);
    }
    AppMethodBeat.o(178245);
  }
  
  public final void a(final com.tencent.mm.plugin.finder.view.builder.b paramb, FinderItem paramFinderItem, CommentDrawerContract.CloseDrawerCallback paramCloseDrawerCallback, int paramInt, boolean paramBoolean1, long paramLong, com.tencent.mm.plugin.finder.storage.t paramt, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    AppMethodBeat.i(201543);
    k.h(paramb, "builder");
    k.h(paramFinderItem, "feedObj");
    this.isDetached = false;
    ac.i("Finder.DrawerPresenter", "onAttach " + paramFinderItem.getId() + ", " + paramInt + ", " + paramBoolean1 + ", " + paramLong);
    this.rgx = paramb;
    this.rgw = paramFinderItem;
    this.rgD = paramBoolean1;
    this.scene = paramInt;
    this.rgz = paramCloseDrawerCallback;
    this.qXy = paramLong;
    this.dAv = paramBoolean2;
    this.rgE = paramBoolean3;
    this.rgF = new r("FinderCommentExecutor");
    paramCloseDrawerCallback = this.rgF;
    if (paramCloseDrawerCallback != null) {
      paramCloseDrawerCallback.start();
    }
    localObject1 = this.rgv.b(paramFinderItem.getId(), paramLong, paramBoolean2);
    paramCloseDrawerCallback = (e.b)((o)localObject1).first;
    paramBoolean2 = ((Boolean)((o)localObject1).second).booleanValue();
    locald = new v.d();
    locald.KUO = paramCloseDrawerCallback.pos;
    localObject1 = paramCloseDrawerCallback.lastBuffer;
    paramBoolean3 = paramCloseDrawerCallback.rgB;
    boolean bool1 = paramCloseDrawerCallback.rgC;
    boolean bool2 = paramCloseDrawerCallback.rEJ;
    this.lastBuffer = ((com.tencent.mm.bw.b)localObject1);
    this.rgA = paramBoolean2;
    lu(paramBoolean3);
    lv(bool1);
    this.qZP = paramBoolean5;
    this.rgG = true;
    this.rgH = paramBoolean4;
    this.rgI = bool2;
    if (this.rgB)
    {
      paramb.mb(true);
      paramb.cFo().setFooterMode(0);
      if (paramLong != 0L) {
        break label780;
      }
      paramCloseDrawerCallback = this.rgx;
      if (paramCloseDrawerCallback != null)
      {
        paramCloseDrawerCallback = paramCloseDrawerCallback.cFo();
        if (paramCloseDrawerCallback != null)
        {
          localObject1 = n.rPN;
          paramCloseDrawerCallback.gp(n.EC(this.scene), paramFinderItem.getNickName());
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
      paramb.cwM().getRecyclerView().setLayoutFrozen(false);
      this.rgy = new b(paramb.cwM().getRecyclerView());
      com.tencent.mm.sdk.b.a.GpY.c(this.rgK);
      try
      {
        paramCloseDrawerCallback = paramb.cwM().getRecyclerView().getAdapter();
        if (paramCloseDrawerCallback != null) {
          paramCloseDrawerCallback.a((RecyclerView.c)this.rgL);
        }
      }
      catch (IllegalStateException paramCloseDrawerCallback)
      {
        for (;;)
        {
          int i;
          int j;
          ac.printErrStackTrace("Finder.DrawerPresenter", (Throwable)paramCloseDrawerCallback, "", new Object[0]);
          continue;
          paramb.cFm().setText((CharSequence)paramb.getContext().getResources().getString(2131759162, new Object[] { com.tencent.mm.plugin.finder.utils.g.fD(this.scene, getCommentCount()) }));
          continue;
          paramCloseDrawerCallback = com.tencent.mm.plugin.finder.api.b.qWt;
          paramCloseDrawerCallback = com.tencent.mm.model.u.axE();
          k.g(paramCloseDrawerCallback, "ConfigStorageLogic.getMyFinderUsername()");
          paramCloseDrawerCallback = com.tencent.mm.plugin.finder.api.b.a.adh(paramCloseDrawerCallback);
          if (paramCloseDrawerCallback != null)
          {
            paramt = paramCloseDrawerCallback.crZ();
            paramCloseDrawerCallback = paramt;
            if (paramt != null) {}
          }
          else
          {
            paramCloseDrawerCallback = "";
          }
          paramt = com.tencent.mm.plugin.finder.loader.h.rtK;
          paramt = com.tencent.mm.plugin.finder.loader.h.cwo();
          paramCloseDrawerCallback = new com.tencent.mm.plugin.finder.loader.a(paramCloseDrawerCallback);
          localObject1 = cuL();
          if (localObject1 == null) {
            k.fOy();
          }
          Object localObject2 = com.tencent.mm.plugin.finder.loader.h.rtK;
          paramt.a(paramCloseDrawerCallback, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.h.a(h.a.rtN));
          continue;
          if ((paramBoolean2) && (locald.KUO == 0) && (paramLong == 0L) && (!this.rgI))
          {
            this.lastBuffer = null;
            lv(true);
            lw(true);
          }
          else
          {
            paramCloseDrawerCallback = this.rgx;
            if (paramCloseDrawerCallback != null)
            {
              paramCloseDrawerCallback = paramCloseDrawerCallback.cwM();
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
            paramCloseDrawerCallback = this.rgx;
            if (paramCloseDrawerCallback != null)
            {
              paramCloseDrawerCallback = paramCloseDrawerCallback.cwM();
              if (paramCloseDrawerCallback != null)
              {
                paramCloseDrawerCallback = paramCloseDrawerCallback.getRecyclerView();
                if (paramCloseDrawerCallback != null)
                {
                  paramCloseDrawerCallback.post((Runnable)new o(this, locald));
                  continue;
                  paramb.cFp().setBackgroundColorRes(2131099819);
                  continue;
                  paramb.cFp().setSquaresBackgroundResource(2131101053);
                  paramb.cFp().setBackgroundColorRes(2131101053);
                  paramb.getHeaderLayout().setVisibility(8);
                  paramb.cwM().setVisibility(8);
                  paramb = getEditText();
                  if (paramb != null) {
                    paramb.requestFocus();
                  }
                  if (!this.ran)
                  {
                    paramb = this.rgx;
                    if (paramb != null)
                    {
                      paramb = paramb.cFo();
                      if (paramb != null) {
                        paramb.bW(true);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      paramb.cwM().setActionCallback((RefreshLoadMoreLayout.a)new m(this));
      paramb.cFo().setModeChangeCallback((FinderCommentFooter.b)this);
      if (getCommentCount() > 0) {
        break label1005;
      }
      paramb.cFm().setText((CharSequence)paramb.getContext().getResources().getString(2131759158));
      paramb.cFo().getReplyBtn().setOnClickListener((View.OnClickListener)new n(this, paramb));
      if (paramt != null)
      {
        paramCloseDrawerCallback = paramb.cFo();
        localObject1 = n.rPN;
        localObject1 = n.EC(this.scene);
        localObject2 = n.rPN;
        paramCloseDrawerCallback.c((String)localObject1, n.gm(paramt.getUsername(), paramt.Tn()), paramt);
      }
      if (cuL() != null)
      {
        if (paramInt != 2) {
          break label1049;
        }
        com.tencent.mm.ui.f.a.a.c(cuL(), com.tencent.mm.model.u.axw());
      }
      paramCloseDrawerCallback = this.rgx;
      if (paramCloseDrawerCallback != null) {
        paramCloseDrawerCallback.hideLoading();
      }
      if (paramBoolean1) {
        break label1292;
      }
      if ((this.rgv.data.size() != 0) || (paramBoolean2)) {
        break label1146;
      }
      lw(true);
      paramCloseDrawerCallback = this.rgx;
      if (paramCloseDrawerCallback != null) {
        paramCloseDrawerCallback.showLoading();
      }
      paramCloseDrawerCallback = com.tencent.mm.plugin.finder.storage.b.rCU;
      if (!com.tencent.mm.plugin.finder.storage.b.czM()) {
        break label1279;
      }
      paramb.cFp().setBackgroundColorRes(2131101053);
      paramb.cFp().setSquaresBackgroundResource(2131234858);
      paramb.cwM().setVisibility(0);
      paramb.getHeaderLayout().setVisibility(0);
      if (paramFinderItem.getCommentCount() == 0)
      {
        paramb = getEditText();
        if (paramb != null) {
          paramb.postDelayed((Runnable)new l(paramb, this), 200L);
        }
      }
      if (!this.rgC)
      {
        paramb = this.rgx;
        if (paramb != null)
        {
          paramb = paramb.cwM();
          if (paramb != null) {
            RefreshLoadMoreLayout.f(paramb);
          }
        }
      }
      this.rgJ.alive();
      AppMethodBeat.o(201543);
      return;
      paramb.mb(false);
      paramCloseDrawerCallback = this.rgx;
      if (paramCloseDrawerCallback == null) {
        break;
      }
      paramCloseDrawerCallback = paramCloseDrawerCallback.cFp();
      if (paramCloseDrawerCallback == null) {
        break;
      }
      paramCloseDrawerCallback.fzd();
      break;
      paramCloseDrawerCallback = (List)this.rgv.data;
      i = 0;
      paramCloseDrawerCallback = paramCloseDrawerCallback.iterator();
      if (paramCloseDrawerCallback.hasNext()) {
        if (((com.tencent.mm.plugin.finder.model.l)paramCloseDrawerCallback.next()).ruO.field_actionInfo.EDq.commentId == paramLong)
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
        localObject2 = (com.tencent.mm.plugin.finder.model.l)this.rgv.data.get(i);
        ((com.tencent.mm.plugin.finder.model.l)localObject2).ruK = true;
        paramCloseDrawerCallback = this.rgx;
        if (paramCloseDrawerCallback == null) {
          break;
        }
        FinderCommentFooter localFinderCommentFooter = paramCloseDrawerCallback.cFo();
        if (localFinderCommentFooter == null) {
          break;
        }
        paramCloseDrawerCallback = n.rPN;
        String str1 = n.EC(this.scene);
        paramCloseDrawerCallback = n.rPN;
        String str2 = ((com.tencent.mm.plugin.finder.model.l)localObject2).ruO.getUsername();
        localObject1 = ((com.tencent.mm.plugin.finder.model.l)localObject2).ruO.Tn();
        paramCloseDrawerCallback = (CommentDrawerContract.CloseDrawerCallback)localObject1;
        if (localObject1 == null) {
          paramCloseDrawerCallback = "";
        }
        localFinderCommentFooter.c(str1, n.gm(str2, paramCloseDrawerCallback), ((com.tencent.mm.plugin.finder.model.l)localObject2).ruO);
        break;
        j = 0;
        break label840;
        i += 1;
        break label801;
        i = -1;
      }
    }
  }
  
  public final void af(View paramView, int paramInt)
  {
    AppMethodBeat.i(165681);
    k.h(paramView, "view");
    paramView = this.rgv.DI(paramInt).ruO;
    if (paramView.field_state == -1)
    {
      Object localObject = com.tencent.mm.plugin.finder.upload.b.rMB;
      localObject = com.tencent.mm.plugin.finder.upload.b.cCr();
      k.h(paramView, "unsentComment");
      ac.i(com.tencent.mm.plugin.finder.upload.b.TAG, "rePost ".concat(String.valueOf(paramView)));
      paramView.field_state = 1;
      paramView.field_canRemove = 0;
      paramView.uR(ce.azH() / 1000L);
      paramView.field_postTime = ce.azH();
      paramView.field_tryCount = 0L;
      ((com.tencent.mm.plugin.finder.upload.b)localObject).a(new com.tencent.mm.plugin.finder.upload.a(paramView));
      paramView = this.rgx;
      if (paramView != null)
      {
        paramView = paramView.cwM();
        if (paramView != null)
        {
          paramView = paramView.getRecyclerView();
          if (paramView != null)
          {
            localObject = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter", "onClickResendComment", "(Landroid/view/View;I)V", "Undefined", "scrollToPosition", "(I)V");
            paramView.ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter", "onClickResendComment", "(Landroid/view/View;I)V", "Undefined", "scrollToPosition", "(I)V");
            AppMethodBeat.o(165681);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(165681);
  }
  
  public final void b(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    Object localObject1 = null;
    AppMethodBeat.i(165682);
    k.h(parama, "adapter");
    k.h(paramView, "view");
    if (this.ran)
    {
      AppMethodBeat.o(165682);
      return;
    }
    parama = this.rgv.DI(paramInt);
    Object localObject2;
    com.tencent.mm.plugin.finder.storage.t localt;
    if (parama.ruO.cAU())
    {
      localObject2 = this.rgx;
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject2).cFo();
        if (localObject2 != null)
        {
          localt = parama.ruO;
          if (this.scene != 2) {
            break label363;
          }
          paramInt = 1;
          k.h(localt, "commentObj");
          if (paramInt == 0) {
            break label373;
          }
          parama = ((FinderCommentFooter)localObject2).getResources();
          if (parama == null) {
            break label368;
          }
          n localn = n.rPN;
          parama = parama.getString(2131757530, new Object[] { n.gm(localt.getUsername(), localt.Tn()) });
          label150:
          ((FinderCommentFooter)localObject2).t(parama, localt);
          parama = ((FinderCommentFooter)localObject2).rWm;
          if (parama == null) {
            k.aVY("editText");
          }
          parama.setShowSoftInputOnFocus(true);
          parama = ((FinderCommentFooter)localObject2).rWm;
          if (parama == null) {
            k.aVY("editText");
          }
          parama.requestFocus();
          ((FinderCommentFooter)localObject2).bW(true);
        }
      }
      localObject2 = new Rect();
      paramView.getGlobalVisibleRect((Rect)localObject2);
      paramInt = ((Rect)localObject2).bottom;
      parama = this.rgx;
      if (parama == null) {
        break label419;
      }
      parama = parama.cFp();
      label242:
      if (parama == null) {
        k.fOy();
      }
      parama.getGlobalVisibleRect((Rect)localObject2);
      paramInt = ((Rect)localObject2).bottom - paramInt;
      parama = this.rgx;
      if (parama == null) {
        break label424;
      }
    }
    label419:
    label424:
    for (parama = parama.cFo();; parama = null)
    {
      if (parama == null) {
        k.fOy();
      }
      if (paramInt < parama.getHeight())
      {
        int i = parama.getHeight();
        paramView = this.rgx;
        parama = localObject1;
        if (paramView != null)
        {
          paramView = paramView.cFp();
          parama = localObject1;
          if (paramView != null) {
            parama = paramView.getRecyclerView();
          }
        }
        if (parama == null) {
          k.fOy();
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
      for (parama = parama.getString(2131757530, new Object[] { localt.Tn() });; parama = null)
      {
        ((FinderCommentFooter)localObject2).t(parama, localt);
        break;
      }
      parama = null;
      break label242;
    }
  }
  
  public final boolean b(com.tencent.mm.plugin.finder.model.l paraml, boolean paramBoolean)
  {
    AppMethodBeat.i(178246);
    k.h(paraml, "comment");
    Object localObject1;
    int i;
    if (paraml.ruO.field_actionInfo.qXu == 0L)
    {
      if (!paramBoolean)
      {
        AppMethodBeat.o(178246);
        return false;
      }
      localObject1 = this.rgv;
      k.h(paraml, "root");
      if (paraml.ruO.field_actionInfo.EDq.commentId != 0L)
      {
        localObject1 = ((Iterable)((com.tencent.mm.plugin.finder.feed.model.b)localObject1).data).iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
        } while (((com.tencent.mm.plugin.finder.model.l)((Iterator)localObject1).next()).ruO.field_actionInfo.qXu != paraml.ruO.field_actionInfo.EDq.commentId);
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
      localObject1 = this.rgv;
      k.h(paraml, "level2Comment");
      Iterator localIterator = ((Iterable)((com.tencent.mm.plugin.finder.feed.model.b)localObject1).data).iterator();
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
            j.fOc();
          }
          localObject2 = (com.tencent.mm.plugin.finder.model.l)localObject2;
          if (com.tencent.mm.plugin.finder.feed.model.b.b((com.tencent.mm.plugin.finder.model.l)localObject2, paraml))
          {
            j = i;
            i = k;
          }
          else if ((j >= 0) && (com.tencent.mm.plugin.finder.feed.model.b.a((com.tencent.mm.plugin.finder.model.l)localObject2, paraml)))
          {
            ac.d(((com.tencent.mm.plugin.finder.feed.model.b)localObject1).TAG, "hasLevel2ItemAfter cur:" + j + ", after:" + i);
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
    if (!this.rgv.c(paraml))
    {
      AppMethodBeat.o(178246);
      return true;
    }
    AppMethodBeat.o(178246);
    return false;
  }
  
  public final boolean c(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(165683);
    k.h(parama, "adapter");
    k.h(paramView, "view");
    if (this.ran)
    {
      AppMethodBeat.o(165683);
      return false;
    }
    Object localObject2 = this.rgv.DI(paramInt);
    parama = new com.tencent.mm.ui.widget.b.a(this.context);
    Object localObject1 = this.rgw;
    if (localObject1 == null) {
      k.aVY("feedObj");
    }
    localObject1 = ((FinderItem)localObject1).getUserName();
    if (this.scene == 1) {}
    for (;;)
    {
      localObject1 = (View.OnCreateContextMenuListener)new a.c((com.tencent.mm.plugin.finder.model.l)localObject2, (String)localObject1, bool);
      localObject2 = (n.d)new a.d((com.tencent.mm.plugin.finder.model.l)localObject2, (d.g.a.b)new q(this));
      TouchableLayout.a locala = TouchableLayout.JyS;
      paramInt = TouchableLayout.fyY();
      locala = TouchableLayout.JyS;
      parama.a(paramView, 0, 0L, (View.OnCreateContextMenuListener)localObject1, (n.d)localObject2, paramInt, TouchableLayout.fyZ());
      AppMethodBeat.o(165683);
      return false;
      bool = false;
    }
  }
  
  public final int cuI()
  {
    AppMethodBeat.i(201544);
    Object localObject = FinderReporterUIC.seQ;
    localObject = FinderReporterUIC.a.eV(this.context);
    if (localObject != null)
    {
      int i = ((FinderReporterUIC)localObject).rfR;
      AppMethodBeat.o(201544);
      return i;
    }
    AppMethodBeat.o(201544);
    return 0;
  }
  
  public final int cuJ()
  {
    return this.scene;
  }
  
  public final FinderItem cuK()
  {
    AppMethodBeat.i(165684);
    FinderItem localFinderItem = this.rgw;
    if (localFinderItem == null) {
      k.aVY("feedObj");
    }
    AppMethodBeat.o(165684);
    return localFinderItem;
  }
  
  public final void cuM()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(178243);
    Object localObject3;
    if (getCommentCount() <= 0)
    {
      localObject2 = this.rgx;
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject2).cFm();
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
    localObject1 = this.rgx;
    if (localObject1 != null)
    {
      localObject3 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).cFm();
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
  
  public final int cuN()
  {
    AppMethodBeat.i(201546);
    Object localObject = this.rgv.data;
    int i;
    if (!bs.gY((List)localObject))
    {
      localObject = (com.tencent.mm.plugin.finder.model.l)j.iP((List)localObject);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.model.l)localObject).ruO;
        if (localObject != null)
        {
          if (((com.tencent.mm.plugin.finder.storage.t)localObject).cAT() != true) {
            break label71;
          }
          i = 0;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(201546);
      return i;
      i = -1;
      continue;
      label71:
      i = -1;
    }
  }
  
  public final int cuO()
  {
    AppMethodBeat.i(201547);
    Object localObject1 = this.rgv.data;
    if (!bs.gY((List)localObject1))
    {
      localObject1 = ((Iterable)localObject1).iterator();
      int i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          j.fOc();
        }
        localObject2 = (com.tencent.mm.plugin.finder.model.l)localObject2;
        if ((((com.tencent.mm.plugin.finder.model.l)localObject2).ruO.field_actionInfo.qXu == 0L) && (!((com.tencent.mm.plugin.finder.model.l)localObject2).ruO.cAT()))
        {
          AppMethodBeat.o(201547);
          return i;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(201547);
    return -1;
  }
  
  public final RecyclerView.h eK(Context paramContext)
  {
    AppMethodBeat.i(165686);
    k.h(paramContext, "context");
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = ((int)paramContext.getResources().getDimension(2131165299));
    paramContext = (RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.a((Drawable)new ColorDrawable(paramContext.getResources().getColor(2131099678)), (int)paramContext.getResources().getDimension(2131166292), arrayOfInt, (int)paramContext.getResources().getDimension(2131166293));
    AppMethodBeat.o(165686);
    return paramContext;
  }
  
  public final WxRecyclerAdapter<?> eM(Context paramContext)
  {
    AppMethodBeat.i(165685);
    k.h(paramContext, "context");
    paramContext = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.c)new h(this), this.rgv.data);
    paramContext.av(false);
    paramContext.JCe = ((com.tencent.mm.view.recyclerview.d.c)this);
    paramContext.JCd = ((com.tencent.mm.view.recyclerview.d.d)this);
    AppMethodBeat.o(165685);
    return paramContext;
  }
  
  public final boolean isCommentClose()
  {
    return this.rgH;
  }
  
  public final void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(165673);
    k.h(parama, "p0");
    this.rfP.add(parama);
    AppMethodBeat.o(165673);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(165675);
    if (this.isDetached)
    {
      ac.w("Finder.DrawerPresenter", "onDetach: can not detach, because it is not attached");
      AppMethodBeat.o(165675);
      return;
    }
    this.isDetached = true;
    this.rgG = false;
    Object localObject1 = this.rgF;
    if (localObject1 != null) {
      ((r)localObject1).stop();
    }
    this.rgF = null;
    localObject1 = this.rgx;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).cwM();
      if (localObject1 != null)
      {
        localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
        if (localObject1 != null)
        {
          localObject1 = ((RecyclerView)localObject1).getLayoutManager();
          if (!(localObject1 instanceof LinearLayoutManager)) {
            break label329;
          }
          localObject1 = this.rgx;
          if (localObject1 == null) {
            break label184;
          }
          localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).cwM();
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
    for (int i = ((LinearLayoutManager)localObject1).jW();; i = -1)
    {
      localObject1 = this.rgx;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).cFo();
        if (localObject1 != null) {
          ((FinderCommentFooter)localObject1).setFooterMode(0);
        }
      }
      localObject1 = this.rgx;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).cwM();
        if (localObject1 != null)
        {
          localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
          if (localObject1 != null)
          {
            localObject1 = ((RecyclerView)localObject1).getAdapter();
            if (localObject1 != null) {
              ((RecyclerView.a)localObject1).b((RecyclerView.c)this.rgL);
            }
          }
        }
      }
      localObject1 = ((Iterable)this.rfP).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((com.tencent.mm.vending.e.a)((Iterator)localObject1).next()).dead();
      }
    }
    this.rfP.clear();
    com.tencent.mm.sdk.b.a.GpY.d(this.rgK);
    localObject1 = this.rgw;
    if (localObject1 == null) {
      k.aVY("feedObj");
    }
    ((FinderItem)localObject1).setCommentCount(getCommentCount());
    localObject1 = com.tencent.mm.plugin.finder.storage.data.d.rEF;
    localObject1 = this.rgw;
    if (localObject1 == null) {
      k.aVY("feedObj");
    }
    com.tencent.mm.plugin.finder.storage.data.d.a.f((FinderItem)localObject1);
    localObject1 = new StringBuilder("[onDetach] updateFeedCommentCount feedId=");
    Object localObject2 = this.rgw;
    if (localObject2 == null) {
      k.aVY("feedObj");
    }
    ac.i("Finder.DrawerPresenter", ((FinderItem)localObject2).getId() + " commentCount " + getCommentCount());
    localObject1 = this.rgz;
    if (localObject1 != null) {
      ((CommentDrawerContract.CloseDrawerCallback)localObject1).g(getCommentCount(), (List)this.rgv.data);
    }
    if ((this.rgD) || (!this.dAv))
    {
      this.rgv.data.clear();
      this.lastBuffer = null;
      lu(false);
      lv(true);
      localObject1 = getEditText();
      if (localObject1 != null) {
        ((MMEditText)localObject1).setText(null);
      }
      localObject1 = this.rgx;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).cwM();
        if (localObject1 != null) {
          ((RefreshLoadMoreLayout)localObject1).setHasBottomMore(true);
        }
      }
      localObject1 = this.rgx;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).cwM();
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
      localObject1 = this.rgx;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).cwM();
        if (localObject1 != null)
        {
          localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
          if (localObject1 != null) {
            ((RecyclerView)localObject1).setLayoutFrozen(true);
          }
        }
      }
      localObject1 = this.rgx;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).cwM();
        if (localObject1 != null) {
          ((RefreshLoadMoreLayout)localObject1).setActionCallback(null);
        }
      }
      this.rgx = null;
      this.rgJ.dead();
      AppMethodBeat.o(165675);
      return;
    }
    int k = i;
    int j;
    if (this.qXy != 0L)
    {
      localObject1 = ((Iterable)this.rgv.data).iterator();
      j = 0;
      label755:
      k = i;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (j < 0) {
          j.fOc();
        }
        localObject2 = (com.tencent.mm.plugin.finder.model.l)localObject2;
        if (((com.tencent.mm.plugin.finder.model.l)localObject2).ruO.field_actionInfo.EDq.commentId != this.qXy) {
          break label936;
        }
        ((com.tencent.mm.plugin.finder.model.l)localObject2).ruL = false;
        i = j;
      }
    }
    label936:
    for (;;)
    {
      j += 1;
      break label755;
      localObject1 = this.rgv;
      localObject2 = this.lastBuffer;
      boolean bool1 = this.rgB;
      boolean bool2 = this.rgC;
      boolean bool3 = this.rgI;
      if ((((com.tencent.mm.plugin.finder.feed.model.b)localObject1).data.size() >= 0) && (k >= 0)) {
        com.tencent.mm.plugin.finder.feed.model.b.a.a(((com.tencent.mm.plugin.finder.feed.model.b)localObject1).rmx, ((com.tencent.mm.plugin.finder.feed.model.b)localObject1).rmy, ((com.tencent.mm.plugin.finder.feed.model.b)localObject1).data);
      }
      ((com.tencent.mm.plugin.finder.feed.model.b)localObject1).data.clear();
      if ((k < 0) || (com.tencent.mm.plugin.finder.feed.model.b.rmz)) {
        break;
      }
      com.tencent.mm.plugin.finder.storage.data.e.rEI.a(((com.tencent.mm.plugin.finder.feed.model.b)localObject1).rmx, ((com.tencent.mm.plugin.finder.feed.model.b)localObject1).rmy, k, (com.tencent.mm.bw.b)localObject2, bool1, bool2, bool3);
      break;
    }
  }
  
  public final void onModeChange(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(165676);
    ac.i("Finder.DrawerPresenter", "[onModeChange] from=" + paramInt1 + " to=" + paramInt2);
    if (paramInt2 == 0)
    {
      Object localObject1 = this.rgx;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).cFp();
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
        localObject1 = this.rgx;
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).cFo();
          if (localObject1 != null)
          {
            Object localObject2 = n.rPN;
            localObject2 = n.EC(this.scene);
            FinderItem localFinderItem = this.rgw;
            if (localFinderItem == null) {
              k.aVY("feedObj");
            }
            ((FinderCommentFooter)localObject1).gp((String)localObject2, localFinderItem.getNickName());
            AppMethodBeat.o(165676);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(165676);
  }
  
  public final com.tencent.mm.plugin.finder.model.l ug(long paramLong)
  {
    AppMethodBeat.i(178244);
    if (paramLong == 0L)
    {
      AppMethodBeat.o(178244);
      return null;
    }
    Iterator localIterator = ((Iterable)this.rgv.data).iterator();
    Object localObject;
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((com.tencent.mm.plugin.finder.model.l)localObject).ruO.field_actionInfo.EDq.commentId == paramLong)
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
      localObject = (com.tencent.mm.plugin.finder.model.l)localObject;
      AppMethodBeat.o(178244);
      return localObject;
      i = 0;
      break label80;
      label103:
      break;
      localObject = null;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$DiffDataChangeHelper;", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "(Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter;Landroid/support/v7/widget/RecyclerView;)V", "onDeleteChange", "", "commentId", "", "localCommentId", "anim", "", "onInsertChange", "target", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "onSecondaryItemRangeInsert", "rootCommentId", "", "onUpdateChange", "plugin-finder_release"})
  public final class b
  {
    final RecyclerView fTr;
    
    public b()
    {
      AppMethodBeat.i(165628);
      this.fTr = localObject;
      AppMethodBeat.o(165628);
    }
    
    public final void a(long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(178222);
      Object localObject1;
      if (paramLong1 != 0L)
      {
        int m = d.b(d.this).data.size();
        localObject1 = d.b(d.this);
        Object localObject3 = (Iterable)((com.tencent.mm.plugin.finder.feed.model.b)localObject1).data;
        Object localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        int i = 0;
        int j = -1;
        if (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = ((Iterator)localObject3).next();
          if (i < 0) {
            j.fOc();
          }
          com.tencent.mm.plugin.finder.model.l locall = (com.tencent.mm.plugin.finder.model.l)localObject4;
          if (locall.ruO.field_actionInfo.EDq.commentId == paramLong1) {
            j = i;
          }
          if ((locall.ruO.field_actionInfo.EDq.commentId == paramLong1) || (locall.ruO.field_actionInfo.qXu == paramLong1)) {}
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
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject1).data.removeAll((Collection)localObject2);
        localObject1 = new o(Integer.valueOf(j), Integer.valueOf(i));
        if ((paramBoolean) && (((Number)((o)localObject1).first).intValue() >= 0))
        {
          i = ((Number)((o)localObject1).first).intValue();
          if (((Number)((o)localObject1).second).intValue() + i <= m)
          {
            localObject2 = this.fTr.getAdapter();
            if (localObject2 != null) {
              ((RecyclerView.a)localObject2).ar(((Number)((o)localObject1).first).intValue(), ((Number)((o)localObject1).second).intValue());
            }
          }
        }
      }
      for (;;)
      {
        localObject1 = this.fTr.getAdapter();
        if (localObject1 == null) {
          break;
        }
        ((RecyclerView.a)localObject1).notifyDataSetChanged();
        AppMethodBeat.o(178222);
        return;
        d.b(d.this).uk(paramLong2);
      }
      AppMethodBeat.o(178222);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentChangeEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderCommentChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class c
    extends com.tencent.mm.sdk.b.c<hd>
  {
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      b(d.c paramc, hd paramhd)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentDataObserver$1", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeRemoved", "plugin-finder_release"})
  public static final class d
    extends RecyclerView.c
  {
    public final void as(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(165634);
      super.as(paramInt1, paramInt2);
      this.rgN.cuM();
      AppMethodBeat.o(165634);
    }
    
    public final void at(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(165633);
      super.at(paramInt1, paramInt2);
      this.rgN.cuM();
      AppMethodBeat.o(165633);
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(165636);
      super.au(paramInt1, paramInt2);
      this.rgN.cuM();
      AppMethodBeat.o(165636);
    }
    
    public final void f(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(165635);
      super.f(paramInt1, paramInt2, paramObject);
      this.rgN.cuM();
      AppMethodBeat.o(165635);
    }
    
    @SuppressLint({"StringFormatMatches"})
    public final void onChanged()
    {
      AppMethodBeat.i(165632);
      super.onChanged();
      this.rgN.cuM();
      AppMethodBeat.o(165632);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentErrorListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderCommentErrorEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class e
    extends com.tencent.mm.sdk.b.c<he>
  {
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(d.e parame, he paramhe)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      b(d.e parame)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class f
    implements DialogInterface.OnClickListener
  {
    f(d paramd, Context paramContext, com.tencent.mm.plugin.finder.model.l paraml) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(165647);
      paramDialogInterface = this.rgN.tipDialog;
      if (paramDialogInterface != null) {
        paramDialogInterface.show();
      }
      Object localObject;
      for (;;)
      {
        localObject = (d.g.a.a)new d(this);
        paramDialogInterface = (d.g.a.a)new b(this, (d.g.a.a)localObject, (d.g.a.a)new c(this));
        if ((!paraml.ruO.cAU()) && (paraml.ruO.field_localCommentId != 0L)) {
          break;
        }
        paramDialogInterface.invoke();
        AppMethodBeat.o(165647);
        return;
        paramDialogInterface = this.rgN;
        localObject = localContext;
        localContext.getString(2131755906);
        paramDialogInterface.tipDialog = ((Dialog)com.tencent.mm.ui.base.h.b((Context)localObject, localContext.getString(2131755936), false, (DialogInterface.OnCancelListener)d.f.a.rgU));
      }
      paramDialogInterface = com.tencent.mm.plugin.finder.upload.b.rMB;
      paramDialogInterface = com.tencent.mm.plugin.finder.upload.b.cCr();
      com.tencent.mm.plugin.finder.storage.t localt = paraml.ruO;
      k.h(localt, "wantDeleteItem");
      paramDialogInterface.rMy.c((com.tencent.mm.loader.g.c)new com.tencent.mm.plugin.finder.upload.a(localt));
      paramDialogInterface = paramDialogInterface.rMy;
      com.tencent.mm.loader.g.c localc = (com.tencent.mm.loader.g.c)new com.tencent.mm.plugin.finder.upload.a(localt);
      k.h(localc, "t");
      Iterator localIterator = ((Iterable)paramDialogInterface.gLA).iterator();
      while (localIterator.hasNext())
      {
        paramDialogInterface = localIterator.next();
        if (k.g(((com.tencent.mm.loader.g.c)((com.tencent.mm.loader.g.g)paramDialogInterface).first).acg(), localc.acg()))
        {
          if ((com.tencent.mm.loader.g.g)paramDialogInterface == null) {
            break label360;
          }
          paramInt = 1;
          label282:
          if (paramInt == 0) {
            break label365;
          }
          ac.i(com.tencent.mm.plugin.finder.upload.b.TAG, "removeWhenNotDoingNetScene " + localt + " is running");
        }
      }
      for (paramInt = 0;; paramInt = 1)
      {
        if (paramInt != 0) {
          break label406;
        }
        paramDialogInterface = this.rgN.tipDialog;
        if (paramDialogInterface != null) {
          paramDialogInterface.dismiss();
        }
        com.tencent.mm.ui.base.t.makeText(localContext, 2131759311, 0).show();
        AppMethodBeat.o(165647);
        return;
        paramDialogInterface = null;
        break;
        label360:
        paramInt = 0;
        break label282;
        label365:
        ac.i(com.tencent.mm.plugin.finder.upload.b.TAG, "removeWhenNotDoingNetScene ".concat(String.valueOf(localt)));
        ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderActionStorage().uN(localt.field_localCommentId);
      }
      label406:
      ((d.g.a.a)localObject).invoke();
      AppMethodBeat.o(165647);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      b(d.f paramf, d.g.a.a parama1, d.g.a.a parama2)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class c
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      c(d.f paramf)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class d
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      d(d.f paramf)
      {
        super();
      }
      
      @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$deleteComment$1$succCallback$1$1$1"})
      static final class a
        extends d.g.b.l
        implements d.g.a.b<FinderCommentInfo, Boolean>
      {
        a(d.f.d paramd)
        {
          super();
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "task", "Lcom/tencent/mm/plugin/finder/utils/SingleTask;", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.b<q, y>
  {
    g(d paramd, LinkedList paramLinkedList, com.tencent.mm.plugin.finder.model.l paraml)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$getAdapter$adapter$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class h
    implements com.tencent.mm.view.recyclerview.c
  {
    public final com.tencent.mm.view.recyclerview.b<?> Ac(int paramInt)
    {
      AppMethodBeat.i(165648);
      if (d.i(this.rgN))
      {
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.d((CommentDrawerContract.NPresenter)this.rgN, true);
        AppMethodBeat.o(165648);
        return localObject;
      }
      Object localObject = com.tencent.mm.plugin.finder.model.l.ruR;
      if (paramInt == com.tencent.mm.plugin.finder.model.l.cwt())
      {
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.d((CommentDrawerContract.NPresenter)this.rgN, false);
        AppMethodBeat.o(165648);
        return localObject;
      }
      localObject = com.tencent.mm.plugin.finder.model.l.ruR;
      if (paramInt == com.tencent.mm.plugin.finder.model.l.cwu())
      {
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.f((CommentDrawerContract.NPresenter)this.rgN);
        AppMethodBeat.o(165648);
        return localObject;
      }
      k.fOy();
      AppMethodBeat.o(165648);
      return null;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "task", "Lcom/tencent/mm/plugin/finder/utils/SingleTask;", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.b<q, y>
  {
    j(d paramd)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "task", "Lcom/tencent/mm/plugin/finder/utils/SingleTask;", "invoke"})
  static final class k
    extends d.g.b.l
    implements d.g.a.b<q, y>
  {
    k(d paramd, com.tencent.mm.plugin.finder.model.l paraml, v.d paramd1, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$6$1"})
  static final class l
    implements Runnable
  {
    l(MMEditText paramMMEditText, d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(201539);
      this.rhe.requestFocus();
      if (!jdField_this.ran)
      {
        Object localObject = jdField_this.rgx;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.finder.view.builder.b)localObject).cFo();
          if (localObject != null)
          {
            ((FinderCommentFooter)localObject).bW(true);
            AppMethodBeat.o(201539);
            return;
          }
        }
      }
      AppMethodBeat.o(201539);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder_release"})
  public static final class m
    extends RefreshLoadMoreLayout.a
  {
    public final void Ad(int paramInt)
    {
      AppMethodBeat.i(201540);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.lS(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aeE());
      com.tencent.e.h.JZN.aS((Runnable)new b(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(201540);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(165655);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aeE());
      k.h(paramc, "reason");
      super.a(paramc);
      d.d(this.rgN);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(165655);
    }
    
    public final void b(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(165657);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aeE());
      k.h(paramc, "reason");
      super.b(paramc);
      d.f(this.rgN);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(165657);
    }
    
    public final void bTG()
    {
      AppMethodBeat.i(165654);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.bTG();
      com.tencent.e.h.JZN.aS((Runnable)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(165654);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(d.m paramm) {}
      
      public final void run()
      {
        AppMethodBeat.i(165652);
        d.c(this.rhf.rgN);
        AppMethodBeat.o(165652);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(d.m paramm) {}
      
      public final void run()
      {
        AppMethodBeat.i(165653);
        d.e(this.rhf.rgN);
        AppMethodBeat.o(165653);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    n(d paramd, com.tencent.mm.plugin.finder.view.builder.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178230);
      d.a(this.rgN, paramb.cFo().getScene());
      AppMethodBeat.o(178230);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class o
    implements Runnable
  {
    o(d paramd, v.d paramd1) {}
    
    public final void run()
    {
      AppMethodBeat.i(178231);
      if ((locald.KUO > 0) && (locald.KUO < d.b(this.rgN).data.size()))
      {
        Object localObject = this.rgN.rgx;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.finder.view.builder.b)localObject).cwM();
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
        ((LinearLayoutManager)localObject).af(locald.KUO, 0);
      }
      AppMethodBeat.o(178231);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "invoke"})
  static final class p
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.plugin.finder.model.l, y>
  {
    p(d paramd)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "invoke"})
  static final class q
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.plugin.finder.model.l, y>
  {
    q(d paramd)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "task", "Lcom/tencent/mm/plugin/finder/utils/SingleTask;", "invoke"})
  static final class s
    extends d.g.b.l
    implements d.g.a.b<q, y>
  {
    s(d paramd)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "task", "Lcom/tencent/mm/plugin/finder/utils/SingleTask;", "invoke"})
  static final class t
    extends d.g.b.l
    implements d.g.a.b<q, y>
  {
    t(d paramd, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.d
 * JD-Core Version:    0.7.0.1
 */