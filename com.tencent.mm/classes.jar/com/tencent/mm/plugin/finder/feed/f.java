package com.tencent.mm.plugin.finder.feed;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.c;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ib;
import com.tencent.mm.f.a.ic;
import com.tencent.mm.f.b.a.ao;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.convert.k;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.feed.model.h.a;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.am;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer;
import com.tencent.mm.plugin.finder.view.FinderCommentFooter;
import com.tencent.mm.plugin.finder.view.FinderCommentFooter.b;
import com.tencent.mm.plugin.finder.view.b.a;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.apk;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.h.c;
import com.tencent.mm.view.recyclerview.h.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.g.b.aa.d;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.o;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "authorMentioned", "", "getAuthorMentioned", "()Z", "setAuthorMentioned", "(Z)V", "blinkRefComment", "canPreload", "getCanPreload", "setCanPreload", "commentChangeEventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderCommentChangeEvent;", "getCommentChangeEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "commentClose", "getCommentClose", "setCommentClose", "commentCount", "", "getCommentCount", "()I", "commentDataObserver", "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentDataObserver$1", "Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentDataObserver$1;", "commentErrorListener", "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentErrorListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentErrorListener$1;", "getContext", "()Landroid/content/Context;", "dataLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentLoader;", "diffDataChangeHelper", "Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$DiffDataChangeHelper;", "value", "downContinue", "setDownContinue", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "setDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;)V", "enterTimeMs", "", "getEnterTimeMs", "()J", "setEnterTimeMs", "(J)V", "exposeScene", "getExposeScene", "setExposeScene", "(I)V", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "hasExpandComment", "getHasExpandComment", "setHasExpandComment", "hitCache", "isDetached", "setDetached", "isSingleMode", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "oldVersion", "onCloseDrawerCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "refCommentId", "resources", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "safeMode", "getSafeMode", "setSafeMode", "scene", "getScene", "setScene", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "getTaskExecutor", "()Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "setTaskExecutor", "(Lcom/tencent/mm/loader/loader/SingleTaskExecutor;)V", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "upContinue", "setUpContinue", "useCache", "viewCallback", "Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;)V", "calculateCommentCount", "canExpand", "comment", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "down", "checkDownContinue", "", "checkUpContinue", "deleteComment", "item", "expandLevel2Comments", "rootComment", "expandTopLevel2Comment", "", "respList", "expandWhenRefToLevel2Comment", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getCommentScene", "getCurrentFeed", "getEditText", "Lcom/tencent/mm/ui/widget/MMEditText;", "getEditTextAvatar", "Landroid/widget/ImageView;", "getFirstFriendPos", "getFirstOtherPos", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getRootComment", "rootId", "getRootCommentIndex", "getUserScene", "insertLevel2CommentsAndNotify", "level2Comments", "", "isCommentClose", "isSafeMode", "isWxScene", "keep", "p0", "loadMoreData", "loadMoreLevel2Comments", "mergeLocalLevel2Comments", "localLevel2Comments", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "onAttach", "builder", "displayScene", "replyCommentObj", "oldVer", "callback", "onClickComment", "view", "Landroid/view/View;", "onClickCommentDelete", "onClickMore", "onClickResendComment", "position", "onDetach", "onExpandClick", "onItemClick", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "holder", "onItemLongClick", "onLikeComment", "onModeChange", "from", "to", "onRecoverRecyclerViewTrans", "onReply", "sceneForReply", "onScrollIdle", "lastVisiblePosition", "preloadNextPage", "refreshData", "setCommentCountView", "transToDiscoverComment", "Companion", "DiffDataChangeHelper", "plugin-finder_release"})
public final class f
  implements CommentDrawerContract.NPresenter, FinderCommentFooter.b, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>, h.c<com.tencent.mm.view.recyclerview.i>, h.d<com.tencent.mm.view.recyclerview.i>
{
  public static final a xwU;
  final Context context;
  private boolean gaj;
  private volatile boolean isDetached;
  private volatile com.tencent.mm.cd.b lastBuffer;
  private boolean mss;
  public boolean safeMode;
  int scene;
  Dialog tipDialog;
  private long wmx;
  private long xbT;
  private com.tencent.mm.loader.g.i xeM;
  private boolean xgY;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> xvE;
  public int xwD;
  final com.tencent.mm.plugin.finder.feed.model.h xwE;
  private FinderItem xwF;
  public com.tencent.mm.plugin.finder.view.builder.b xwG;
  private b xwH;
  private CommentDrawerContract.CloseDrawerCallback xwI;
  private boolean xwJ;
  private boolean xwK;
  private boolean xwL;
  private boolean xwM;
  boolean xwN;
  boolean xwO;
  boolean xwP;
  private FinderCommentDrawer xwQ;
  private e xwR;
  private final IListener<ib> xwS;
  private final d xwT;
  
  static
  {
    AppMethodBeat.i(165695);
    xwU = new a((byte)0);
    AppMethodBeat.o(165695);
  }
  
  public f(Context paramContext)
  {
    AppMethodBeat.i(279573);
    this.context = paramContext;
    this.xwD = 58;
    this.xwE = new com.tencent.mm.plugin.finder.feed.model.h();
    this.xvE = new CopyOnWriteArraySet();
    this.scene = 2;
    this.xwL = true;
    this.xgY = true;
    this.gaj = true;
    this.isDetached = true;
    this.xwR = new e(this);
    this.xwS = ((IListener)new c(this));
    this.xwT = new d(this);
    AppMethodBeat.o(279573);
  }
  
  private final ImageView dsS()
  {
    AppMethodBeat.i(165689);
    Object localObject = this.xwG;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.b)localObject).ejG();
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
    Object localObject = new StringBuilder("calculateCommentCount ").append(this.xwE.data.size()).append(", ");
    FinderItem localFinderItem = this.xwF;
    if (localFinderItem == null) {
      p.bGy("feedObj");
    }
    Log.i("Finder.DrawerPresenter", localFinderItem.getCommentCount());
    int j = this.xwE.data.size();
    if (this.xwE.xGl == null) {}
    for (int i = 0;; i = 1)
    {
      localObject = this.xwF;
      if (localObject == null) {
        p.bGy("feedObj");
      }
      i = Math.max(j - i, ((FinderItem)localObject).getCommentCount());
      AppMethodBeat.o(165672);
      return i;
    }
  }
  
  private final MMEditText getEditText()
  {
    AppMethodBeat.i(165688);
    Object localObject = this.xwG;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.b)localObject).ejG();
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
    Object localObject = this.xwG;
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
  
  private final void oq(boolean paramBoolean)
  {
    AppMethodBeat.i(165670);
    this.xwK = paramBoolean;
    Log.i("Finder.DrawerPresenter", "set upContinue ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(165670);
  }
  
  private final void or(boolean paramBoolean)
  {
    AppMethodBeat.i(165671);
    this.xwL = paramBoolean;
    Log.i("Finder.DrawerPresenter", "set downContinue ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(165671);
  }
  
  private final void os(final boolean paramBoolean)
  {
    AppMethodBeat.i(165692);
    com.tencent.mm.loader.g.i locali = this.xeM;
    if (locali != null)
    {
      locali.a(new com.tencent.mm.loader.g.h((kotlin.g.a.b)new u(this, paramBoolean)));
      AppMethodBeat.o(165692);
      return;
    }
    AppMethodBeat.o(165692);
  }
  
  public final com.tencent.mm.plugin.finder.model.s KR(long paramLong)
  {
    AppMethodBeat.i(178244);
    if (paramLong == 0L)
    {
      AppMethodBeat.o(178244);
      return null;
    }
    Iterator localIterator = ((Iterable)this.xwE.data).iterator();
    Object localObject;
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((com.tencent.mm.plugin.finder.model.s)localObject).zAt.dYY().commentId == paramLong)
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
      localObject = (com.tencent.mm.plugin.finder.model.s)localObject;
      AppMethodBeat.o(178244);
      return localObject;
      i = 0;
      break label77;
      label100:
      break;
      localObject = null;
    }
  }
  
  public final void Mx(int paramInt)
  {
    AppMethodBeat.i(178247);
    Object localObject = this.xwE.data;
    Log.i("Finder.DrawerPresenter", "preloadNextPage, onScrollIdle, lastVisiblePosition:" + paramInt + ", dataList size:" + ((ArrayList)localObject).size() + ", canPreload:" + this.xwN);
    if ((paramInt >= 0) && (paramInt < ((ArrayList)localObject).size()))
    {
      int i = ((ArrayList)localObject).size();
      localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
      if ((i - paramInt <= com.tencent.mm.plugin.finder.storage.d.dTh()) && (this.xwN))
      {
        this.xwN = false;
        localObject = this.xeM;
        if (localObject != null)
        {
          ((com.tencent.mm.loader.g.i)localObject).a(new com.tencent.mm.loader.g.h((kotlin.g.a.b)new t(this)));
          AppMethodBeat.o(178247);
          return;
        }
      }
    }
    AppMethodBeat.o(178247);
  }
  
  public final void a(View paramView, com.tencent.mm.plugin.finder.model.s params)
  {
    AppMethodBeat.i(279569);
    p.k(paramView, "view");
    p.k(params, "item");
    paramView = new com.tencent.mm.ui.widget.a.e(paramView.getContext(), 1, false);
    FinderItem localFinderItem = this.xwF;
    if (localFinderItem == null) {
      p.bGy("feedObj");
    }
    paramView.a((q.f)new b.a(params, localFinderItem.getUserName()));
    paramView.a((q.g)new com.tencent.mm.plugin.finder.view.b.d(params, this.xwD, (kotlin.g.a.b)new q(this)));
    paramView.eik();
    AppMethodBeat.o(279569);
  }
  
  public final void a(ImageView paramImageView, int paramInt)
  {
    AppMethodBeat.i(165677);
    p.k(paramImageView, "view");
    if (paramInt < 0)
    {
      Log.i("Finder.DrawerPresenter", "onLikeComment position:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(165677);
      return;
    }
    paramImageView = this.xwE.ME(paramInt);
    Object localObject1 = com.tencent.mm.plugin.finder.upload.action.l.ACj;
    localObject1 = com.tencent.mm.plugin.finder.upload.action.l.ecG();
    Object localObject2 = this.xwF;
    if (localObject2 == null) {
      p.bGy("feedObj");
    }
    boolean bool1 = ((com.tencent.mm.plugin.finder.upload.action.l)localObject1).a(((FinderItem)localObject2).getId(), paramImageView.zAt, this.scene);
    Log.i("Finder.DrawerPresenter", "[onLikeComment] position=" + paramInt + " isLike=" + bool1 + " commentObj=" + paramImageView.zAt);
    boolean bool2;
    int i;
    if (!bool1)
    {
      bool1 = true;
      if ((this.context instanceof MMFragmentActivity))
      {
        localObject1 = com.tencent.mm.ui.component.g.Xox;
        localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.context).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY();
        localObject2 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        localObject2 = this.xwF;
        if (localObject2 == null) {
          p.bGy("feedObj");
        }
        bool2 = com.tencent.mm.plugin.finder.utils.aj.PE(((FinderItem)localObject2).getUserName());
        localObject2 = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.dUh().aSr()).intValue() == 1) {
          break label509;
        }
        localObject2 = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (com.tencent.mm.plugin.finder.storage.d.dTj() != 1) {
          break label509;
        }
        i = 1;
        label257:
        if ((bool2) && (i == 1))
        {
          if (!bool1) {
            break label517;
          }
          paramImageView.zAt.Qn(paramImageView.zAt.dYY().displayFlag | 0x1);
        }
      }
    }
    for (;;)
    {
      localObject2 = al.zAN;
      localObject2 = this.xwF;
      if (localObject2 == null) {
        p.bGy("feedObj");
      }
      long l = ((FinderItem)localObject2).getId();
      localObject2 = this.xwF;
      if (localObject2 == null) {
        p.bGy("feedObj");
      }
      al.a((bid)localObject1, l, ((FinderItem)localObject2).getObjectNonceId(), paramImageView.zAt, bool1, this.scene, bool2);
      localObject1 = com.tencent.mm.ui.component.g.Xox;
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.b((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.context).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class));
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.event.a)localObject1).dpO();
        localObject2 = this.xwF;
        if (localObject2 == null) {
          p.bGy("feedObj");
        }
        ((a.b)localObject1).KK(((FinderItem)localObject2).getId());
      }
      localObject1 = com.tencent.mm.plugin.finder.utils.z.AEm;
      com.tencent.mm.plugin.finder.utils.z.h(bool1, paramImageView.zAt.dYY().commentId);
      paramImageView = this.xwG;
      if (paramImageView == null) {
        break label540;
      }
      paramImageView = paramImageView.getRlLayout();
      if (paramImageView == null) {
        break label540;
      }
      paramImageView = paramImageView.getRecyclerView();
      if (paramImageView == null) {
        break label540;
      }
      paramImageView = paramImageView.getAdapter();
      if (paramImageView == null) {
        break label540;
      }
      paramImageView.d(paramInt, Integer.valueOf(1));
      AppMethodBeat.o(165677);
      return;
      bool1 = false;
      break;
      label509:
      i = this.scene;
      break label257;
      label517:
      paramImageView.zAt.Qn(paramImageView.zAt.dYY().displayFlag & 0xFFFFFFFE);
    }
    label540:
    AppMethodBeat.o(165677);
  }
  
  public final void a(final com.tencent.mm.plugin.finder.model.s params)
  {
    AppMethodBeat.i(165678);
    p.k(params, "item");
    final Context localContext = this.context;
    if (localContext != null)
    {
      com.tencent.mm.ui.base.h.a(localContext, b.j.finder_profile_confirm_del, 0, (DialogInterface.OnClickListener)new f(this, localContext, params), null);
      AppMethodBeat.o(165678);
      return;
    }
    AppMethodBeat.o(165678);
  }
  
  public final void a(final com.tencent.mm.plugin.finder.model.s params, final boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(178245);
    p.k(params, "rootComment");
    this.xwP = true;
    final aa.d locald = new aa.d();
    Object localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    localObject1 = aj.a.fZ(this.context);
    int i;
    if (localObject1 != null)
    {
      i = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject1).xkX;
      locald.aaBA = i;
      if (!paramBoolean) {
        break label303;
      }
      localObject1 = params.zAt.dYY().levelTwoComment;
      if (!Util.isNullOrNil((List)localObject1)) {
        break label122;
      }
      i = j;
    }
    for (;;)
    {
      if (i == 0) {
        break label243;
      }
      localObject1 = n.zWF;
      n.a(params, 1, locald.aaBA);
      AppMethodBeat.o(178245);
      return;
      i = 0;
      break;
      label122:
      Object localObject2 = ((Iterable)this.xwE.data).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          long l = ((com.tencent.mm.plugin.finder.model.s)((Iterator)localObject2).next()).zAt.dYY().commentId;
          p.j(localObject1, "level2Comments");
          if (l == ((FinderCommentInfo)((LinkedList)localObject1).getFirst()).commentId)
          {
            i = j;
            break;
          }
        }
      }
      localObject2 = this.xeM;
      if (localObject2 != null) {
        ((com.tencent.mm.loader.g.i)localObject2).a(new com.tencent.mm.loader.g.h((kotlin.g.a.b)new g(this, (LinkedList)localObject1, params)));
      }
      i = 1;
    }
    label243:
    localObject1 = n.zWF;
    n.a(params, 2, locald.aaBA);
    for (;;)
    {
      localObject1 = this.xeM;
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.loader.g.i)localObject1).a(new com.tencent.mm.loader.g.h((kotlin.g.a.b)new k(this, params, locald, paramBoolean)));
      AppMethodBeat.o(178245);
      return;
      label303:
      localObject1 = n.zWF;
      n.a(params, 3, locald.aaBA);
    }
    AppMethodBeat.o(178245);
  }
  
  public final void a(FinderCommentDrawer paramFinderCommentDrawer, final com.tencent.mm.plugin.finder.view.builder.b paramb, final FinderItem paramFinderItem, CommentDrawerContract.CloseDrawerCallback paramCloseDrawerCallback, int paramInt, boolean paramBoolean1, long paramLong, am paramam, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    AppMethodBeat.i(279564);
    p.k(paramFinderCommentDrawer, "drawer");
    p.k(paramb, "builder");
    p.k(paramFinderItem, "feedObj");
    this.isDetached = false;
    this.wmx = System.currentTimeMillis();
    Log.i("Finder.DrawerPresenter", "onAttach " + paramFinderItem.getId() + ", " + paramInt + ", " + paramBoolean1 + ", " + paramLong);
    this.xwG = paramb;
    this.xwQ = paramFinderCommentDrawer;
    this.xwF = paramFinderItem;
    this.mss = paramBoolean1;
    this.scene = paramInt;
    this.xwI = paramCloseDrawerCallback;
    this.xbT = paramLong;
    this.gaj = paramBoolean2;
    this.xwM = paramBoolean3;
    this.xeM = new com.tencent.mm.loader.g.i("FinderCommentExecutor");
    paramCloseDrawerCallback = this.xeM;
    if (paramCloseDrawerCallback != null) {
      paramCloseDrawerCallback.start();
    }
    localObject1 = this.xwE.a(paramFinderItem.getId(), paramFinderItem, paramLong, paramBoolean2, paramb.xgX.getCommentScene());
    paramCloseDrawerCallback = (com.tencent.mm.plugin.finder.storage.data.f.b)((o)localObject1).Mx;
    paramBoolean2 = ((Boolean)((o)localObject1).My).booleanValue();
    k = paramCloseDrawerCallback.pos;
    localObject1 = paramCloseDrawerCallback.lastBuffer;
    paramBoolean3 = paramCloseDrawerCallback.xwK;
    boolean bool1 = paramCloseDrawerCallback.xwL;
    boolean bool2 = paramCloseDrawerCallback.Ane;
    this.lastBuffer = ((com.tencent.mm.cd.b)localObject1);
    this.xwJ = paramBoolean2;
    oq(paramBoolean3);
    or(bool1);
    this.xgY = paramBoolean5;
    this.xwN = true;
    this.xwO = paramBoolean4;
    this.xwP = bool2;
    if (this.xwK)
    {
      paramb.rv(true);
      paramb.ejG().setFooterMode(0);
      if (paramLong != 0L) {
        break label858;
      }
      paramCloseDrawerCallback = this.xwG;
      if (paramCloseDrawerCallback != null)
      {
        paramCloseDrawerCallback = paramCloseDrawerCallback.ejG();
        if (paramCloseDrawerCallback != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
          paramCloseDrawerCallback.hy(com.tencent.mm.plugin.finder.utils.aj.QR(this.scene), paramFinderItem.getNickName());
        }
      }
    }
    label914:
    label1051:
    label1064:
    for (;;)
    {
      paramb.getRlLayout().getRecyclerView().setLayoutFrozen(false);
      this.xwH = new b(paramb.getRlLayout().getRecyclerView());
      EventCenter.instance.addListener(this.xwS);
      try
      {
        paramCloseDrawerCallback = paramb.getRlLayout().getRecyclerView().getAdapter();
        if (paramCloseDrawerCallback != null) {
          paramCloseDrawerCallback.a((RecyclerView.c)this.xwT);
        }
      }
      catch (IllegalStateException paramCloseDrawerCallback)
      {
        for (;;)
        {
          int i;
          int j;
          Log.printErrStackTrace("Finder.DrawerPresenter", (Throwable)paramCloseDrawerCallback, "", new Object[0]);
          continue;
          paramb.ejD().setText((CharSequence)paramb.getContext().getResources().getString(b.j.finder_comment_count_tip, new Object[] { m.gY(this.scene, getCommentCount()) }));
          continue;
          paramCloseDrawerCallback = com.tencent.mm.plugin.finder.api.d.wZQ;
          paramCloseDrawerCallback = d.a.aAK(com.tencent.mm.model.z.bdh());
          if (paramCloseDrawerCallback != null)
          {
            paramam = paramCloseDrawerCallback.Mm();
            paramCloseDrawerCallback = paramam;
            if (paramam != null) {}
          }
          else
          {
            paramCloseDrawerCallback = "";
          }
          paramam = com.tencent.mm.plugin.finder.loader.t.ztT;
          paramam = com.tencent.mm.plugin.finder.loader.t.dJh();
          paramCloseDrawerCallback = new com.tencent.mm.plugin.finder.loader.e(paramCloseDrawerCallback);
          localObject1 = dsS();
          if (localObject1 == null) {
            p.iCn();
          }
          Object localObject2 = com.tencent.mm.plugin.finder.loader.t.ztT;
          paramam.a(paramCloseDrawerCallback, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztX));
          continue;
          if ((paramBoolean2) && (k == 0) && (paramLong == 0L) && (!this.xwP))
          {
            this.lastBuffer = null;
            or(true);
            os(true);
          }
          else
          {
            paramCloseDrawerCallback = this.xwG;
            if (paramCloseDrawerCallback != null)
            {
              paramCloseDrawerCallback = paramCloseDrawerCallback.getRlLayout();
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
            paramCloseDrawerCallback = this.xwG;
            if (paramCloseDrawerCallback != null)
            {
              paramCloseDrawerCallback = paramCloseDrawerCallback.getRlLayout();
              if (paramCloseDrawerCallback != null)
              {
                paramCloseDrawerCallback = paramCloseDrawerCallback.getRecyclerView();
                if (paramCloseDrawerCallback != null)
                {
                  paramCloseDrawerCallback.post((Runnable)new p(this, k));
                  continue;
                  paramb.ejH().setBackgroundColorRes(b.c.UN_BW_0_Alpha_0_5);
                  continue;
                  paramb.ejH().setSquaresBackgroundResource(b.c.transparent);
                  paramb.ejH().setBackgroundColorRes(b.c.transparent);
                  paramb.getHeaderLayout().setVisibility(8);
                  paramb.getRlLayout().setVisibility(8);
                  paramFinderCommentDrawer = getEditText();
                  if (paramFinderCommentDrawer != null) {
                    paramFinderCommentDrawer.requestFocus();
                  }
                  if (!this.safeMode)
                  {
                    paramFinderCommentDrawer = this.xwG;
                    if (paramFinderCommentDrawer != null)
                    {
                      paramFinderCommentDrawer = paramFinderCommentDrawer.ejG();
                      if (paramFinderCommentDrawer != null) {
                        paramFinderCommentDrawer.dd(true);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      com.tencent.mm.view.f.a(paramb.getRlLayout().getRecyclerView(), (com.tencent.mm.view.e.a)new m(this, paramFinderItem));
      paramb.getRlLayout().setActionCallback((RefreshLoadMoreLayout.a)new n(this));
      paramb.ejG().setModeChangeCallback((FinderCommentFooter.b)this);
      if (getCommentCount() > 0) {
        break label1089;
      }
      paramb.ejD().setText((CharSequence)paramb.getContext().getResources().getString(b.j.finder_comment));
      paramb.ejG().getReplyBtn().setOnClickListener((View.OnClickListener)new o(this, paramb));
      if (paramam != null)
      {
        paramCloseDrawerCallback = paramb.ejG();
        localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        localObject1 = com.tencent.mm.plugin.finder.utils.aj.QR(this.scene);
        localObject2 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        paramCloseDrawerCallback.e((String)localObject1, com.tencent.mm.plugin.finder.utils.aj.ht(paramam.getUsername(), paramam.getNickname()), paramam);
      }
      if (dsS() != null)
      {
        if (paramInt != 2) {
          break label1133;
        }
        com.tencent.mm.ui.h.a.a.c(dsS(), com.tencent.mm.model.z.bcZ());
      }
      paramCloseDrawerCallback = this.xwG;
      if (paramCloseDrawerCallback != null) {
        paramCloseDrawerCallback.hideLoading();
      }
      if (paramBoolean1) {
        break label1394;
      }
      if (paramBoolean2) {
        break label1230;
      }
      os(true);
      paramCloseDrawerCallback = this.xwG;
      if (paramCloseDrawerCallback != null) {
        paramCloseDrawerCallback.showLoading();
      }
      paramCloseDrawerCallback = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dTG().aSr()).intValue() != 1) {
        break label1381;
      }
      paramb.ejH().setBackgroundColorRes(b.c.transparent);
      paramb.ejH().setSquaresBackgroundResource(b.e.finder_bottom_corner_shape);
      paramb.getRlLayout().setVisibility(0);
      paramb.getHeaderLayout().setVisibility(0);
      if ((paramFinderItem.getCommentCount() == 0) && (paramFinderCommentDrawer.getReason() != 4))
      {
        paramFinderCommentDrawer = getEditText();
        if (paramFinderCommentDrawer != null) {
          paramFinderCommentDrawer.postDelayed((Runnable)new l(paramFinderCommentDrawer, this), 200L);
        }
      }
      if (!this.xwL)
      {
        paramFinderCommentDrawer = this.xwG;
        if (paramFinderCommentDrawer != null)
        {
          paramFinderCommentDrawer = paramFinderCommentDrawer.getRlLayout();
          if (paramFinderCommentDrawer != null) {
            RefreshLoadMoreLayout.e(paramFinderCommentDrawer);
          }
        }
      }
      this.xwR.alive();
      AppMethodBeat.o(279564);
      return;
      paramb.rv(false);
      paramCloseDrawerCallback = this.xwG;
      if (paramCloseDrawerCallback == null) {
        break;
      }
      paramCloseDrawerCallback = paramCloseDrawerCallback.ejH();
      if (paramCloseDrawerCallback == null) {
        break;
      }
      paramCloseDrawerCallback.ihE();
      break;
      label858:
      paramCloseDrawerCallback = (List)this.xwE.data;
      i = 0;
      paramCloseDrawerCallback = paramCloseDrawerCallback.iterator();
      label882:
      if (paramCloseDrawerCallback.hasNext()) {
        if (((com.tencent.mm.plugin.finder.model.s)paramCloseDrawerCallback.next()).mf() == paramLong)
        {
          j = 1;
          if (j == 0) {
            break label1051;
          }
        }
      }
      for (;;)
      {
        if (i < 0) {
          break label1064;
        }
        localObject2 = (com.tencent.mm.plugin.finder.model.s)this.xwE.data.get(i);
        ((com.tencent.mm.plugin.finder.model.s)localObject2).zAp = true;
        paramCloseDrawerCallback = this.xwG;
        if (paramCloseDrawerCallback == null) {
          break;
        }
        FinderCommentFooter localFinderCommentFooter = paramCloseDrawerCallback.ejG();
        if (localFinderCommentFooter == null) {
          break;
        }
        paramCloseDrawerCallback = com.tencent.mm.plugin.finder.utils.aj.AGc;
        String str1 = com.tencent.mm.plugin.finder.utils.aj.QR(this.scene);
        paramCloseDrawerCallback = com.tencent.mm.plugin.finder.utils.aj.AGc;
        String str2 = ((com.tencent.mm.plugin.finder.model.s)localObject2).zAt.getUsername();
        localObject1 = ((com.tencent.mm.plugin.finder.model.s)localObject2).zAt.getNickname();
        paramCloseDrawerCallback = (CommentDrawerContract.CloseDrawerCallback)localObject1;
        if (localObject1 == null) {
          paramCloseDrawerCallback = "";
        }
        localFinderCommentFooter.e(str1, com.tencent.mm.plugin.finder.utils.aj.ht(str2, paramCloseDrawerCallback), ((com.tencent.mm.plugin.finder.model.s)localObject2).zAt);
        break;
        j = 0;
        break label914;
        i += 1;
        break label882;
        i = -1;
      }
    }
  }
  
  public final void ai(View paramView, int paramInt)
  {
    AppMethodBeat.i(165681);
    p.k(paramView, "view");
    if (paramInt < 0)
    {
      Log.i("Finder.DrawerPresenter", "onClickResendComment position:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(165681);
      return;
    }
    paramView = this.xwE.ME(paramInt).zAt;
    if (paramView.field_state == -1)
    {
      Object localObject = com.tencent.mm.plugin.finder.upload.b.Azp;
      localObject = com.tencent.mm.plugin.finder.upload.b.ebZ();
      p.k(paramView, "unsentComment");
      Log.i(com.tencent.mm.plugin.finder.upload.b.TAG, "rePost ".concat(String.valueOf(paramView)));
      paramView.field_state = 1;
      paramView.field_canRemove = 0;
      paramView.ML(cm.bfC() / 1000L);
      paramView.field_postTime = cm.bfC();
      paramView.field_tryCount = 0L;
      ((com.tencent.mm.plugin.finder.upload.b)localObject).a(new com.tencent.mm.plugin.finder.upload.a(paramView));
      paramView = this.xwG;
      if (paramView != null)
      {
        paramView = paramView.getRlLayout();
        if (paramView != null)
        {
          paramView = paramView.getRecyclerView();
          if (paramView != null)
          {
            localObject = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter", "onClickResendComment", "(Landroid/view/View;I)V", "Undefined", "scrollToPosition", "(I)V");
            paramView.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter", "onClickResendComment", "(Landroid/view/View;I)V", "Undefined", "scrollToPosition", "(I)V");
            AppMethodBeat.o(165681);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(165681);
  }
  
  public final boolean b(com.tencent.mm.plugin.finder.model.s params, boolean paramBoolean)
  {
    AppMethodBeat.i(178246);
    p.k(params, "comment");
    Object localObject1;
    int i;
    if (params.zAt.field_actionInfo.xbP == 0L)
    {
      if (!paramBoolean)
      {
        AppMethodBeat.o(178246);
        return false;
      }
      localObject1 = this.xwE;
      p.k(params, "root");
      if (params.mf() != 0L)
      {
        localObject1 = ((Iterable)((com.tencent.mm.plugin.finder.feed.model.h)localObject1).data).iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
        } while (((com.tencent.mm.plugin.finder.model.s)((Iterator)localObject1).next()).zAt.field_actionInfo.xbP != params.mf());
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
      localObject1 = this.xwE;
      p.k(params, "level2Comment");
      Iterator localIterator = ((Iterable)((com.tencent.mm.plugin.finder.feed.model.h)localObject1).data).iterator();
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
            j.iBO();
          }
          localObject2 = (com.tencent.mm.plugin.finder.model.s)localObject2;
          if (com.tencent.mm.plugin.finder.feed.model.h.b((com.tencent.mm.plugin.finder.model.s)localObject2, params))
          {
            j = i;
            i = k;
          }
          else if ((j >= 0) && (com.tencent.mm.plugin.finder.feed.model.h.a((com.tencent.mm.plugin.finder.model.s)localObject2, params)))
          {
            Log.d(((com.tencent.mm.plugin.finder.feed.model.h)localObject1).TAG, "hasLevel2ItemAfter cur:" + j + ", after:" + i);
          }
        }
      }
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label309;
        }
        AppMethodBeat.o(178246);
        return true;
        i = k;
        break;
      }
      label309:
      AppMethodBeat.o(178246);
      return false;
    }
    if (!this.xwE.c(params))
    {
      AppMethodBeat.o(178246);
      return true;
    }
    AppMethodBeat.o(178246);
    return false;
  }
  
  public final int dsQ()
  {
    return this.scene;
  }
  
  public final FinderItem dsR()
  {
    AppMethodBeat.i(165684);
    FinderItem localFinderItem = this.xwF;
    if (localFinderItem == null) {
      p.bGy("feedObj");
    }
    AppMethodBeat.o(165684);
    return localFinderItem;
  }
  
  public final void dsT()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(178243);
    Object localObject3;
    if (getCommentCount() <= 0)
    {
      localObject2 = this.xwG;
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject2).ejD();
        if (localObject2 != null)
        {
          localObject3 = getResources();
          if (localObject3 != null) {
            localObject1 = ((Resources)localObject3).getString(b.j.finder_comment);
          }
          ((TextView)localObject2).setText((CharSequence)localObject1);
          AppMethodBeat.o(178243);
          return;
        }
      }
      AppMethodBeat.o(178243);
      return;
    }
    localObject1 = this.xwG;
    if (localObject1 != null)
    {
      localObject3 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).ejD();
      if (localObject3 != null)
      {
        Resources localResources = getResources();
        localObject1 = localObject2;
        if (localResources != null) {
          localObject1 = localResources.getString(b.j.finder_comment_count_tip, new Object[] { String.valueOf(getCommentCount()) });
        }
        ((TextView)localObject3).setText((CharSequence)localObject1);
        AppMethodBeat.o(178243);
        return;
      }
    }
    AppMethodBeat.o(178243);
  }
  
  public final int dsU()
  {
    AppMethodBeat.i(279571);
    Object localObject = this.xwE.data;
    int i;
    if (!Util.isNullOrNil((List)localObject))
    {
      localObject = (com.tencent.mm.plugin.finder.model.s)j.lp((List)localObject);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.model.s)localObject).zAt;
        if (localObject != null)
        {
          if (((am)localObject).dZe() != true) {
            break label71;
          }
          i = 0;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(279571);
      return i;
      i = -1;
      continue;
      label71:
      i = -1;
    }
  }
  
  public final int dsV()
  {
    AppMethodBeat.i(279572);
    Object localObject1 = this.xwE.data;
    if (!Util.isNullOrNil((List)localObject1))
    {
      localObject1 = ((Iterable)localObject1).iterator();
      int i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          j.iBO();
        }
        localObject2 = (com.tencent.mm.plugin.finder.model.s)localObject2;
        if ((((com.tencent.mm.plugin.finder.model.s)localObject2).zAt.field_actionInfo.xbP == 0L) && (!((com.tencent.mm.plugin.finder.model.s)localObject2).zAt.dZe()))
        {
          AppMethodBeat.o(279572);
          return i;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(279572);
    return -1;
  }
  
  public final RecyclerView.h fn(Context paramContext)
  {
    AppMethodBeat.i(279570);
    p.k(paramContext, "context");
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = ((int)paramContext.getResources().getDimension(com.tencent.mm.plugin.finder.b.d.Edge_7A));
    paramContext = (RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.a((Drawable)new ColorDrawable(paramContext.getResources().getColor(b.c.BW_90)), (int)paramContext.getResources().getDimension(com.tencent.mm.plugin.finder.b.d.feed_detail_divider), arrayOfInt, (int)paramContext.getResources().getDimension(com.tencent.mm.plugin.finder.b.d.feed_detail_divider_last));
    AppMethodBeat.o(279570);
    return paramContext;
  }
  
  public final WxRecyclerAdapter<?> fs(Context paramContext)
  {
    AppMethodBeat.i(165685);
    p.k(paramContext, "context");
    paramContext = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new h(this), this.xwE.data);
    paramContext.aw(false);
    paramContext.YSn = ((h.c)this);
    paramContext.YSm = ((h.d)this);
    AppMethodBeat.o(165685);
    return paramContext;
  }
  
  public final void gA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(165676);
    Log.i("Finder.DrawerPresenter", "[onModeChange] from=" + paramInt1 + " to=" + paramInt2);
    if (paramInt2 == 0)
    {
      Object localObject1 = this.xwG;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).ejH();
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
        localObject1 = this.xwG;
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).ejG();
          if (localObject1 != null)
          {
            Object localObject2 = com.tencent.mm.plugin.finder.utils.aj.AGc;
            localObject2 = com.tencent.mm.plugin.finder.utils.aj.QR(this.scene);
            FinderItem localFinderItem = this.xwF;
            if (localFinderItem == null) {
              p.bGy("feedObj");
            }
            ((FinderCommentFooter)localObject1).hy((String)localObject2, localFinderItem.getNickName());
            AppMethodBeat.o(165676);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(165676);
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(279565);
    Object localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    localObject = aj.a.fZ(this.context);
    if (localObject != null)
    {
      int i = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject).xkX;
      AppMethodBeat.o(279565);
      return i;
    }
    AppMethodBeat.o(279565);
    return 0;
  }
  
  public final boolean isCommentClose()
  {
    return this.xwO;
  }
  
  public final void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(165673);
    p.k(parama, "p0");
    this.xvE.add(parama);
    AppMethodBeat.o(165673);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(165675);
    if (this.isDetached)
    {
      Log.i("Finder.DrawerPresenter", "onDetach: can not detach, because it is not attached");
      AppMethodBeat.o(165675);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    localObject1 = aj.a.fZ(this.context);
    Object localObject3;
    int j;
    if (localObject1 != null)
    {
      localObject2 = n.zWF;
      localObject2 = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject1).sessionId;
      localObject3 = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject1).wmz;
      String str = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject1).wmL;
      j = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject1).xkX;
      localObject1 = this.xwF;
      if (localObject1 == null) {
        p.bGy("feedObj");
      }
      if (localObject1 == null) {
        break label408;
      }
      localObject1 = Long.valueOf(((FinderItem)localObject1).getId());
      long l1 = ((Long)localObject1).longValue();
      long l2 = this.wmx;
      long l3 = System.currentTimeMillis();
      localObject1 = this.xwQ;
      if (localObject1 == null) {
        break label414;
      }
      i = ((FinderCommentDrawer)localObject1).getReason();
      label147:
      n.a((String)localObject2, (String)localObject3, str, j, l1, l2, l3, i);
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      localObject1 = aj.a.fZ(this.context);
      if (localObject1 == null) {
        break label419;
      }
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.c((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject1);
      label190:
      if ((localObject1 instanceof com.tencent.mm.plugin.finder.report.s))
      {
        localObject1 = (com.tencent.mm.plugin.finder.report.s)localObject1;
        localObject2 = com.tencent.mm.plugin.finder.report.g.zUU;
        ((com.tencent.mm.plugin.finder.report.s)localObject1).aEe(com.tencent.mm.plugin.finder.report.g.a.aa(ae.e(new o[] { kotlin.s.M("feedActionType", Integer.valueOf(24)), kotlin.s.M("value", Long.valueOf(System.currentTimeMillis() - this.wmx)) })));
      }
    }
    this.isDetached = true;
    this.xwN = false;
    localObject1 = this.xeM;
    if (localObject1 != null) {
      ((com.tencent.mm.loader.g.i)localObject1).stop();
    }
    this.xeM = null;
    localObject1 = this.xwG;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).getRlLayout();
      if (localObject1 != null)
      {
        localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
        if (localObject1 != null)
        {
          localObject1 = ((RecyclerView)localObject1).getLayoutManager();
          label332:
          if (!(localObject1 instanceof LinearLayoutManager)) {
            break label576;
          }
          localObject1 = this.xwG;
          if (localObject1 == null) {
            break label431;
          }
          localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).getRlLayout();
          if (localObject1 == null) {
            break label431;
          }
          localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
          if (localObject1 == null) {
            break label431;
          }
        }
      }
    }
    label408:
    label414:
    label419:
    label431:
    for (localObject1 = ((RecyclerView)localObject1).getLayoutManager();; localObject1 = null)
    {
      if (localObject1 != null) {
        break label437;
      }
      localObject1 = new kotlin.t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
      AppMethodBeat.o(165675);
      throw ((Throwable)localObject1);
      localObject1 = null;
      break;
      i = 0;
      break label147;
      localObject1 = null;
      break label190;
      localObject1 = null;
      break label332;
    }
    label437:
    label576:
    for (int i = ((LinearLayoutManager)localObject1).kJ();; i = -1)
    {
      localObject1 = this.xwG;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).ejG();
        if (localObject1 != null) {
          ((FinderCommentFooter)localObject1).setFooterMode(0);
        }
      }
      localObject1 = this.xwG;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).getRlLayout();
        if (localObject1 != null)
        {
          localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
          if (localObject1 != null)
          {
            localObject1 = ((RecyclerView)localObject1).getAdapter();
            if (localObject1 != null) {
              ((RecyclerView.a)localObject1).b((RecyclerView.c)this.xwT);
            }
          }
        }
      }
      localObject1 = ((Iterable)this.xvE).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((com.tencent.mm.vending.e.a)((Iterator)localObject1).next()).dead();
      }
    }
    this.xvE.clear();
    EventCenter.instance.removeListener(this.xwS);
    localObject1 = this.xwF;
    if (localObject1 == null) {
      p.bGy("feedObj");
    }
    ((FinderItem)localObject1).setCommentCount(getCommentCount());
    localObject1 = com.tencent.mm.plugin.finder.storage.data.e.AmW;
    localObject1 = this.xwF;
    if (localObject1 == null) {
      p.bGy("feedObj");
    }
    com.tencent.mm.plugin.finder.storage.data.e.a.o((FinderItem)localObject1);
    localObject1 = new StringBuilder("[onDetach] updateFeedCommentCount feedId=");
    Object localObject2 = this.xwF;
    if (localObject2 == null) {
      p.bGy("feedObj");
    }
    Log.i("Finder.DrawerPresenter", ((FinderItem)localObject2).getId() + " commentCount " + getCommentCount());
    localObject1 = this.xwI;
    if (localObject1 != null) {
      ((CommentDrawerContract.CloseDrawerCallback)localObject1).i(getCommentCount(), (List)this.xwE.data);
    }
    if ((this.mss) || (!this.gaj))
    {
      this.xwE.ow(true);
      this.lastBuffer = null;
      oq(false);
      or(true);
      localObject1 = getEditText();
      if (localObject1 != null) {
        ((MMEditText)localObject1).setText(null);
      }
      localObject1 = this.xwG;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).getRlLayout();
        if (localObject1 != null) {
          ((RefreshLoadMoreLayout)localObject1).setHasBottomMore(true);
        }
      }
      localObject1 = this.xwG;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).getRlLayout();
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
      localObject1 = this.xwG;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).getRlLayout();
        if (localObject1 != null)
        {
          localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
          if (localObject1 != null) {
            ((RecyclerView)localObject1).setLayoutFrozen(true);
          }
        }
      }
      localObject1 = this.xwG;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).getRlLayout();
        if (localObject1 != null) {
          ((RefreshLoadMoreLayout)localObject1).setActionCallback(null);
        }
      }
      this.xwG = null;
      this.xwR.dead();
      AppMethodBeat.o(165675);
      return;
    }
    int k = i;
    if (this.xbT != 0L)
    {
      localObject1 = ((Iterable)this.xwE.data).iterator();
      j = 0;
      label1000:
      k = i;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (j < 0) {
          j.iBO();
        }
        localObject2 = (com.tencent.mm.plugin.finder.model.s)localObject2;
        if (((com.tencent.mm.plugin.finder.model.s)localObject2).mf() != this.xbT) {
          break label1201;
        }
        ((com.tencent.mm.plugin.finder.model.s)localObject2).zAq = false;
        i = j;
      }
    }
    label1201:
    for (;;)
    {
      j += 1;
      break label1000;
      localObject1 = this.xwE;
      localObject2 = this.lastBuffer;
      boolean bool1 = this.xwK;
      boolean bool2 = this.xwL;
      boolean bool3 = this.xwP;
      localObject3 = ((com.tencent.mm.plugin.finder.feed.model.h)localObject1).xGl;
      if (localObject3 != null) {
        ((com.tencent.mm.plugin.finder.feed.model.h)localObject1).data.remove(localObject3);
      }
      ((com.tencent.mm.plugin.finder.feed.model.h)localObject1).xGl = null;
      if ((((com.tencent.mm.plugin.finder.feed.model.h)localObject1).data.size() >= 0) && (k >= 0)) {
        h.a.a(((com.tencent.mm.plugin.finder.feed.model.h)localObject1).xGj, ((com.tencent.mm.plugin.finder.feed.model.h)localObject1).xGk, ((com.tencent.mm.plugin.finder.feed.model.h)localObject1).data);
      }
      ((com.tencent.mm.plugin.finder.feed.model.h)localObject1).data.clear();
      if ((k < 0) || (com.tencent.mm.plugin.finder.feed.model.h.xGm)) {
        break;
      }
      com.tencent.mm.plugin.finder.storage.data.f.Anc.a(((com.tencent.mm.plugin.finder.feed.model.h)localObject1).xGj, ((com.tencent.mm.plugin.finder.feed.model.h)localObject1).xGk, k, (com.tencent.mm.cd.b)localObject2, bool1, bool2, bool3);
      break;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$Companion;", "", "()V", "DEFAULT_INIT_COUNT", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$DiffDataChangeHelper;", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "(Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter;Landroidx/recyclerview/widget/RecyclerView;)V", "onDeleteChange", "", "commentId", "", "localCommentId", "anim", "", "onInsertChange", "target", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "onSecondaryItemRangeInsert", "rootCommentId", "", "onUpdateChange", "plugin-finder_release"})
  public final class b
  {
    final RecyclerView jLl;
    
    public b()
    {
      AppMethodBeat.i(271218);
      this.jLl = localObject;
      AppMethodBeat.o(271218);
    }
    
    public final void a(long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(178222);
      Object localObject1;
      if (paramLong1 != 0L)
      {
        int m = f.b(f.this).data.size();
        localObject1 = f.b(f.this);
        Object localObject3 = (Iterable)((com.tencent.mm.plugin.finder.feed.model.h)localObject1).data;
        Object localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        int i = 0;
        int j = -1;
        if (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = ((Iterator)localObject3).next();
          if (i < 0) {
            j.iBO();
          }
          com.tencent.mm.plugin.finder.model.s locals = (com.tencent.mm.plugin.finder.model.s)localObject4;
          if (locals.zAt.dYY().commentId == paramLong1) {
            j = i;
          }
          if ((locals.zAt.dYY().commentId == paramLong1) || (locals.zAt.field_actionInfo.xbP == paramLong1)) {}
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
        ((com.tencent.mm.plugin.finder.feed.model.h)localObject1).data.removeAll((Collection)localObject2);
        localObject1 = new o(Integer.valueOf(j), Integer.valueOf(i));
        if ((paramBoolean) && (((Number)((o)localObject1).Mx).intValue() >= 0))
        {
          i = ((Number)((o)localObject1).Mx).intValue();
          if (((Number)((o)localObject1).My).intValue() + i <= m)
          {
            localObject2 = this.jLl.getAdapter();
            if (localObject2 != null) {
              ((RecyclerView.a)localObject2).aH(((Number)((o)localObject1).Mx).intValue(), ((Number)((o)localObject1).My).intValue());
            }
          }
        }
      }
      for (;;)
      {
        localObject1 = this.jLl.getAdapter();
        if (localObject1 == null) {
          break;
        }
        ((RecyclerView.a)localObject1).notifyDataSetChanged();
        AppMethodBeat.o(178222);
        return;
        f.b(f.this).KW(paramLong2);
      }
      AppMethodBeat.o(178222);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentChangeEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderCommentChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class c
    extends IListener<ib>
  {
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<x>
    {
      b(f.c paramc, ib paramib)
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentDataObserver$1", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeRemoved", "plugin-finder_release"})
  public static final class d
    extends RecyclerView.c
  {
    @SuppressLint({"StringFormatMatches"})
    public final void onChanged()
    {
      AppMethodBeat.i(165632);
      super.onChanged();
      this.xwV.dsT();
      AppMethodBeat.o(165632);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(165634);
      super.onItemRangeChanged(paramInt1, paramInt2);
      this.xwV.dsT();
      AppMethodBeat.o(165634);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(165635);
      super.onItemRangeChanged(paramInt1, paramInt2, paramObject);
      this.xwV.dsT();
      AppMethodBeat.o(165635);
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(165633);
      super.onItemRangeInserted(paramInt1, paramInt2);
      this.xwV.dsT();
      AppMethodBeat.o(165633);
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(165636);
      super.onItemRangeRemoved(paramInt1, paramInt2);
      this.xwV.dsT();
      AppMethodBeat.o(165636);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentErrorListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderCommentErrorEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class e
    extends IListener<ic>
  {
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(f.e parame, ic paramic)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<x>
    {
      b(f.e parame)
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class f
    implements DialogInterface.OnClickListener
  {
    f(f paramf, Context paramContext, com.tencent.mm.plugin.finder.model.s params) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(165647);
      paramDialogInterface = this.xwV.tipDialog;
      if (paramDialogInterface != null) {
        paramDialogInterface.show();
      }
      Object localObject;
      for (;;)
      {
        localObject = (kotlin.g.a.a)new d(this);
        paramDialogInterface = (kotlin.g.a.a)new b(this, (kotlin.g.a.a)localObject, (kotlin.g.a.a)new c(this));
        if ((!params.zAt.dZf()) && (params.zAt.field_localCommentId != 0L)) {
          break;
        }
        paramDialogInterface.invoke();
        AppMethodBeat.o(165647);
        return;
        paramDialogInterface = this.xwV;
        localObject = localContext;
        localContext.getString(b.j.app_tip);
        paramDialogInterface.tipDialog = ((Dialog)com.tencent.mm.ui.base.h.a((Context)localObject, localContext.getString(b.j.app_waiting), false, (DialogInterface.OnCancelListener)a.xxc));
      }
      paramDialogInterface = com.tencent.mm.plugin.finder.upload.b.Azp;
      paramDialogInterface = com.tencent.mm.plugin.finder.upload.b.ebZ();
      am localam = params.zAt;
      p.k(localam, "wantDeleteItem");
      paramDialogInterface.Azm.c((com.tencent.mm.loader.g.c)new com.tencent.mm.plugin.finder.upload.a(localam));
      paramDialogInterface = paramDialogInterface.Azm;
      com.tencent.mm.loader.g.c localc = (com.tencent.mm.loader.g.c)new com.tencent.mm.plugin.finder.upload.a(localam);
      p.k(localc, "t");
      Iterator localIterator = ((Iterable)paramDialogInterface.kPG).iterator();
      while (localIterator.hasNext())
      {
        paramDialogInterface = localIterator.next();
        if (p.h(((com.tencent.mm.loader.g.c)((com.tencent.mm.loader.g.g)paramDialogInterface).Mx).aBG(), localc.aBG()))
        {
          if ((com.tencent.mm.loader.g.g)paramDialogInterface == null) {
            break label363;
          }
          paramInt = 1;
          label284:
          if (paramInt == 0) {
            break label368;
          }
          Log.i(com.tencent.mm.plugin.finder.upload.b.TAG, "removeWhenNotDoingNetScene " + localam + " is running");
        }
      }
      for (paramInt = 0;; paramInt = 1)
      {
        if (paramInt != 0) {
          break label409;
        }
        paramDialogInterface = this.xwV.tipDialog;
        if (paramDialogInterface != null) {
          paramDialogInterface.dismiss();
        }
        w.makeText(localContext, b.j.finder_profile_del_failed_retry, 0).show();
        AppMethodBeat.o(165647);
        return;
        paramDialogInterface = null;
        break;
        label363:
        paramInt = 0;
        break label284;
        label368:
        Log.i(com.tencent.mm.plugin.finder.upload.b.TAG, "removeWhenNotDoingNetScene ".concat(String.valueOf(localam)));
        ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getFinderActionStorage().MF(localam.field_localCommentId);
      }
      label409:
      ((kotlin.g.a.a)localObject).invoke();
      AppMethodBeat.o(165647);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class a
      implements DialogInterface.OnCancelListener
    {
      public static final a xxc;
      
      static
      {
        AppMethodBeat.i(165642);
        xxc = new a();
        AppMethodBeat.o(165642);
      }
      
      public final void onCancel(DialogInterface paramDialogInterface) {}
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<x>
    {
      b(f.f paramf, kotlin.g.a.a parama1, kotlin.g.a.a parama2)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class c
      extends q
      implements kotlin.g.a.a<x>
    {
      c(f.f paramf)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class d
      extends q
      implements kotlin.g.a.a<x>
    {
      d(f.f paramf)
      {
        super();
      }
      
      @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$deleteComment$1$succCallback$1$1$1"})
      static final class a
        extends q
        implements kotlin.g.a.b<FinderCommentInfo, Boolean>
      {
        a(f.f.d paramd)
        {
          super();
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.b<com.tencent.mm.loader.g.h, x>
  {
    g(f paramf, LinkedList paramLinkedList, com.tencent.mm.plugin.finder.model.s params)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$getAdapter$adapter$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class h
    implements com.tencent.mm.view.recyclerview.f
  {
    public final com.tencent.mm.view.recyclerview.e<?> yx(int paramInt)
    {
      AppMethodBeat.i(165648);
      if (f.i(this.xwV))
      {
        localObject = com.tencent.mm.plugin.finder.model.s.zAx;
        if (paramInt == com.tencent.mm.plugin.finder.model.s.dKx())
        {
          localObject = (com.tencent.mm.view.recyclerview.e)new k(this.xwV);
          AppMethodBeat.o(165648);
          return localObject;
        }
        localObject = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.finder.convert.i((CommentDrawerContract.NPresenter)this.xwV, true);
        AppMethodBeat.o(165648);
        return localObject;
      }
      Object localObject = com.tencent.mm.plugin.finder.model.s.zAx;
      if (paramInt == com.tencent.mm.plugin.finder.model.s.dKv())
      {
        localObject = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.finder.convert.i((CommentDrawerContract.NPresenter)this.xwV, false);
        AppMethodBeat.o(165648);
        return localObject;
      }
      localObject = com.tencent.mm.plugin.finder.model.s.zAx;
      if (paramInt == com.tencent.mm.plugin.finder.model.s.dKw())
      {
        localObject = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.finder.convert.l((CommentDrawerContract.NPresenter)this.xwV);
        AppMethodBeat.o(165648);
        return localObject;
      }
      localObject = com.tencent.mm.plugin.finder.model.s.zAx;
      if (paramInt == com.tencent.mm.plugin.finder.model.s.dKx())
      {
        localObject = (com.tencent.mm.view.recyclerview.e)new k(this.xwV);
        AppMethodBeat.o(165648);
        return localObject;
      }
      localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
      com.tencent.mm.plugin.finder.utils.aj.em("Finder.DrawerPresenter", paramInt);
      localObject = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.finder.convert.f();
      AppMethodBeat.o(165648);
      return localObject;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.b<com.tencent.mm.loader.g.h, x>
  {
    j(f paramf)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.b<com.tencent.mm.loader.g.h, x>
  {
    k(f paramf, com.tencent.mm.plugin.finder.model.s params, aa.d paramd, boolean paramBoolean)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$7$1"})
  static final class l
    implements Runnable
  {
    l(MMEditText paramMMEditText, f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(278219);
      this.xxm.requestFocus();
      if ((!jdField_this.safeMode) && (!jdField_this.xwO))
      {
        Object localObject = jdField_this.xwG;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.finder.view.builder.b)localObject).ejG();
          if (localObject != null)
          {
            ((FinderCommentFooter)localObject).dd(true);
            AppMethodBeat.o(278219);
            return;
          }
        }
      }
      AppMethodBeat.o(278219);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "Lcom/tencent/mm/view/ExposeElves$OnRecyclerViewChildExposedListener;", "lastExposeSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getLastExposeSet", "()Ljava/util/HashSet;", "ignoreFlingExposed", "", "onChildExposeChanged", "", "parent", "Landroid/view/View;", "exposedHolders", "", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-finder_release"})
  public static final class m
    extends com.tencent.mm.view.e.a
  {
    private final HashSet<String> xxn;
    
    m(FinderItem paramFinderItem)
    {
      AppMethodBeat.i(289175);
      this.xxn = new HashSet();
      AppMethodBeat.o(289175);
    }
    
    public final void b(View paramView, List<? extends RecyclerView.v> paramList)
    {
      AppMethodBeat.i(289173);
      p.k(paramView, "parent");
      p.k(paramList, "exposedHolders");
      HashSet localHashSet = new HashSet();
      paramView = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      com.tencent.mm.plugin.finder.viewmodel.component.aj localaj = aj.a.fZ(this.xwV.context);
      Iterator localIterator = ((Iterable)paramList).iterator();
      com.tencent.mm.plugin.finder.model.s locals;
      label153:
      String str;
      label165:
      label176:
      int i;
      label187:
      long l;
      ao localao;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          paramView = (RecyclerView.v)localIterator.next();
          if ((paramView instanceof com.tencent.mm.view.recyclerview.i))
          {
            paramList = ((com.tencent.mm.view.recyclerview.i)paramView).ihX();
            paramView = paramList;
            if (!(paramList instanceof com.tencent.mm.plugin.finder.model.s)) {
              paramView = null;
            }
            locals = (com.tencent.mm.plugin.finder.model.s)paramView;
            if (locals != null)
            {
              paramView = String.valueOf(locals.mf());
              localHashSet.add(paramView);
              if (!this.xxn.contains(paramView))
              {
                paramView = n.zWF;
                if (localaj != null)
                {
                  paramView = localaj.sessionId;
                  if (localaj == null) {
                    break label349;
                  }
                  str = localaj.wmL;
                  if (localaj == null) {
                    break label355;
                  }
                  paramList = localaj.wmz;
                  if (localaj == null) {
                    break label360;
                  }
                  i = localaj.xkX;
                  l = paramFinderItem.getFeedObject().id;
                  p.k(locals, "comment");
                  localao = new ao();
                  Object localObject = paramView;
                  if (paramView == null) {
                    localObject = "";
                  }
                  localao.je((String)localObject);
                  if (str != null) {
                    break label450;
                  }
                }
              }
            }
          }
        }
      }
      label450:
      for (paramView = "";; paramView = str)
      {
        localao.jf(paramView);
        if (paramList == null) {}
        for (paramView = "";; paramView = paramList)
        {
          localao.jg(paramView);
          localao.cs(i);
          localao.jh(com.tencent.mm.ae.d.Fw(l));
          i = locals.bAQ();
          paramView = com.tencent.mm.plugin.finder.model.s.zAx;
          if (i == com.tencent.mm.plugin.finder.model.s.dKv())
          {
            localao.ji(com.tencent.mm.ae.d.Fw(locals.zAt.dYY().commentId));
            localao.jj("");
          }
          for (;;)
          {
            localao.bpa();
            n.a((com.tencent.mm.plugin.report.a)localao);
            break;
            paramView = null;
            break label153;
            label349:
            str = null;
            break label165;
            label355:
            paramList = null;
            break label176;
            label360:
            i = 0;
            break label187;
            paramView = com.tencent.mm.plugin.finder.model.s.zAx;
            if (i != com.tencent.mm.plugin.finder.model.s.dKw()) {
              break;
            }
            localao.ji(com.tencent.mm.ae.d.Fw(locals.zAt.field_actionInfo.xbP));
            localao.jj(com.tencent.mm.ae.d.Fw(locals.zAt.dYY().commentId));
          }
          this.xxn.clear();
          this.xxn.addAll((Collection)localHashSet);
          AppMethodBeat.o(289173);
          return;
        }
      }
    }
    
    public final boolean dpC()
    {
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$3", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder_release"})
  public static final class n
    extends RefreshLoadMoreLayout.a
  {
    public final void Ie(int paramInt)
    {
      AppMethodBeat.i(281504);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aFi());
      com.tencent.e.h.ZvG.be((Runnable)new b(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(281504);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(281503);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      p.k(paramc, "reason");
      super.a(paramc);
      f.d(this.xwV);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(281503);
    }
    
    public final void cKQ()
    {
      AppMethodBeat.i(281502);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.cKQ();
      com.tencent.e.h.ZvG.be((Runnable)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(281502);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(281505);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      p.k(paramc, "reason");
      super.onRefreshEnd(paramc);
      f.f(this.xwV);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(281505);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(f.n paramn) {}
      
      public final void run()
      {
        AppMethodBeat.i(278600);
        f.c(this.xxp.xwV);
        AppMethodBeat.o(278600);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(f.n paramn) {}
      
      public final void run()
      {
        AppMethodBeat.i(273870);
        f.e(this.xxp.xwV);
        AppMethodBeat.o(273870);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class o
    implements View.OnClickListener
  {
    o(f paramf, com.tencent.mm.plugin.finder.view.builder.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(281149);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      f.a(this.xwV, paramb.ejG().getScene());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(281149);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class p
    implements Runnable
  {
    p(f paramf, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(286697);
      if ((k > 0) && (k < f.b(this.xwV).data.size()))
      {
        Object localObject = this.xwV.xwG;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.finder.view.builder.b)localObject).getRlLayout();
          if (localObject != null)
          {
            localObject = ((RefreshLoadMoreLayout)localObject).getRecyclerView();
            if (localObject == null) {}
          }
        }
        for (localObject = ((RecyclerView)localObject).getLayoutManager(); localObject == null; localObject = null)
        {
          localObject = new kotlin.t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
          AppMethodBeat.o(286697);
          throw ((Throwable)localObject);
        }
        ((LinearLayoutManager)localObject).au(k, 0);
      }
      AppMethodBeat.o(286697);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "invoke"})
  static final class q
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.model.s, x>
  {
    q(f paramf)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "invoke"})
  static final class r
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.model.s, x>
  {
    r(f paramf)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
  static final class t
    extends q
    implements kotlin.g.a.b<com.tencent.mm.loader.g.h, x>
  {
    t(f paramf)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
  static final class u
    extends q
    implements kotlin.g.a.b<com.tencent.mm.loader.g.h, x>
  {
    u(f paramf, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.f
 * JD-Core Version:    0.7.0.1
 */