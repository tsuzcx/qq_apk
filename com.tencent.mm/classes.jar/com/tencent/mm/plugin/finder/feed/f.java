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
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.mm.g.a.hs;
import com.tencent.mm.g.a.ht;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.model.aj;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.utils.ao;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer;
import com.tencent.mm.plugin.finder.view.FinderCommentFooter;
import com.tencent.mm.plugin.finder.view.FinderCommentFooter.b;
import com.tencent.mm.plugin.finder.view.a.a;
import com.tencent.mm.plugin.finder.view.a.d;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.aoh;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g.c;
import com.tencent.mm.view.recyclerview.g.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.d;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "authorMentioned", "", "getAuthorMentioned", "()Z", "setAuthorMentioned", "(Z)V", "blinkRefComment", "canPreload", "getCanPreload", "setCanPreload", "commentChangeEventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderCommentChangeEvent;", "getCommentChangeEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "commentClose", "getCommentClose", "setCommentClose", "commentCount", "", "getCommentCount", "()I", "commentDataObserver", "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentDataObserver$1", "Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentDataObserver$1;", "commentErrorListener", "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentErrorListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentErrorListener$1;", "getContext", "()Landroid/content/Context;", "dataLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentLoader;", "diffDataChangeHelper", "Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$DiffDataChangeHelper;", "value", "downContinue", "setDownContinue", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "setDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;)V", "enterTimeMs", "", "getEnterTimeMs", "()J", "setEnterTimeMs", "(J)V", "exposeScene", "getExposeScene", "setExposeScene", "(I)V", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "hasExpandComment", "getHasExpandComment", "setHasExpandComment", "hitCache", "isDetached", "setDetached", "isSingleMode", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "oldVersion", "onCloseDrawerCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "refCommentId", "resources", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "safeMode", "getSafeMode", "setSafeMode", "scene", "getScene", "setScene", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "getTaskExecutor", "()Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "setTaskExecutor", "(Lcom/tencent/mm/loader/loader/SingleTaskExecutor;)V", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "upContinue", "setUpContinue", "useCache", "viewCallback", "Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;)V", "calculateCommentCount", "canExpand", "comment", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "down", "checkDownContinue", "", "checkUpContinue", "deleteComment", "item", "expandLevel2Comments", "rootComment", "expandTopLevel2Comment", "", "respList", "expandWhenRefToLevel2Comment", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getCommentScene", "getCurrentFeed", "getEditText", "Lcom/tencent/mm/ui/widget/MMEditText;", "getEditTextAvatar", "Landroid/widget/ImageView;", "getFirstFriendPos", "getFirstOtherPos", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getRootComment", "rootId", "getRootCommentIndex", "getUserScene", "insertLevel2CommentsAndNotify", "level2Comments", "", "isCommentClose", "isSafeMode", "isWxScene", "keep", "p0", "loadMoreData", "loadMoreLevel2Comments", "mergeLocalLevel2Comments", "localLevel2Comments", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "onAttach", "builder", "displayScene", "replyCommentObj", "oldVer", "callback", "onClickComment", "view", "Landroid/view/View;", "onClickCommentDelete", "onClickMore", "onClickResendComment", "position", "onDetach", "onExpandClick", "onItemClick", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "holder", "onItemLongClick", "onLikeComment", "onModeChange", "from", "to", "onRecoverRecyclerViewTrans", "onReply", "sceneForReply", "onScrollIdle", "lastVisiblePosition", "preloadNextPage", "refreshData", "setCommentCountView", "transToDiscoverComment", "Companion", "DiffDataChangeHelper", "plugin-finder_release"})
public final class f
  implements CommentDrawerContract.NPresenter, FinderCommentFooter.b, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>, g.c<com.tencent.mm.view.recyclerview.h>, g.d<com.tencent.mm.view.recyclerview.h>
{
  public static final a tNf;
  final Context context;
  private boolean efT;
  private volatile boolean isDetached;
  private volatile com.tencent.mm.bw.b lastBuffer;
  private long sGC;
  int scene;
  public boolean tAj;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> tLP;
  public int tMM;
  final com.tencent.mm.plugin.finder.feed.model.c tMN;
  private FinderItem tMO;
  public com.tencent.mm.plugin.finder.view.builder.b tMP;
  private b tMQ;
  private CommentDrawerContract.CloseDrawerCallback tMR;
  private boolean tMS;
  private boolean tMT;
  private boolean tMU;
  private boolean tMV;
  private boolean tMW;
  private com.tencent.mm.loader.g.i tMX;
  boolean tMY;
  private boolean tMZ;
  boolean tNa;
  private FinderCommentDrawer tNb;
  private e tNc;
  private final IListener<hs> tNd;
  private final d tNe;
  Dialog tipDialog;
  private long tuj;
  private boolean tzn;
  
  static
  {
    AppMethodBeat.i(165695);
    tNf = new a((byte)0);
    AppMethodBeat.o(165695);
  }
  
  public f(Context paramContext)
  {
    AppMethodBeat.i(243753);
    this.context = paramContext;
    this.tMM = 58;
    this.tMN = new com.tencent.mm.plugin.finder.feed.model.c();
    this.tLP = new CopyOnWriteArraySet();
    this.scene = 2;
    this.tMU = true;
    this.tzn = true;
    this.efT = true;
    this.isDetached = true;
    this.tNc = new e(this);
    this.tNd = ((IListener)new c(this));
    this.tNe = new d(this);
    AppMethodBeat.o(243753);
  }
  
  private final ImageView dcC()
  {
    AppMethodBeat.i(165689);
    Object localObject = this.tMP;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.b)localObject).dHv();
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
    Object localObject = new StringBuilder("calculateCommentCount ").append(this.tMN.data.size()).append(", ");
    FinderItem localFinderItem = this.tMO;
    if (localFinderItem == null) {
      p.btv("feedObj");
    }
    Log.i("Finder.DrawerPresenter", localFinderItem.getCommentCount());
    int j = this.tMN.data.size();
    if (this.tMN.tUL == null) {}
    for (int i = 0;; i = 1)
    {
      localObject = this.tMO;
      if (localObject == null) {
        p.btv("feedObj");
      }
      i = Math.max(j - i, ((FinderItem)localObject).getCommentCount());
      AppMethodBeat.o(165672);
      return i;
    }
  }
  
  private final MMEditText getEditText()
  {
    AppMethodBeat.i(165688);
    Object localObject = this.tMP;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.b)localObject).dHv();
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
    Object localObject = this.tMP;
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
  
  private final void mW(boolean paramBoolean)
  {
    AppMethodBeat.i(165670);
    this.tMT = paramBoolean;
    Log.i("Finder.DrawerPresenter", "set upContinue ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(165670);
  }
  
  private final void mX(boolean paramBoolean)
  {
    AppMethodBeat.i(165671);
    this.tMU = paramBoolean;
    Log.i("Finder.DrawerPresenter", "set downContinue ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(165671);
  }
  
  private final void mY(final boolean paramBoolean)
  {
    AppMethodBeat.i(165692);
    com.tencent.mm.loader.g.i locali = this.tMX;
    if (locali != null)
    {
      locali.a(new com.tencent.mm.loader.g.h((kotlin.g.a.b)new t(this, paramBoolean)));
      AppMethodBeat.o(165692);
      return;
    }
    AppMethodBeat.o(165692);
  }
  
  public final s EC(long paramLong)
  {
    AppMethodBeat.i(178244);
    if (paramLong == 0L)
    {
      AppMethodBeat.o(178244);
      return null;
    }
    Iterator localIterator = ((Iterable)this.tMN.data).iterator();
    Object localObject;
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((s)localObject).uOf.dyb().commentId == paramLong)
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
      localObject = (s)localObject;
      AppMethodBeat.o(178244);
      return localObject;
      i = 0;
      break label77;
      label100:
      break;
      localObject = null;
    }
  }
  
  public final void IG(int paramInt)
  {
    AppMethodBeat.i(178247);
    Object localObject = this.tMN.data;
    Log.i("Finder.DrawerPresenter", "preloadNextPage, onScrollIdle, lastVisiblePosition:" + paramInt + ", dataList size:" + ((ArrayList)localObject).size() + ", canPreload:" + this.tMY);
    if ((paramInt >= 0) && (paramInt < ((ArrayList)localObject).size()))
    {
      int i = ((ArrayList)localObject).size();
      localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
      if ((i - paramInt <= com.tencent.mm.plugin.finder.storage.c.drR()) && (this.tMY))
      {
        this.tMY = false;
        localObject = this.tMX;
        if (localObject != null)
        {
          ((com.tencent.mm.loader.g.i)localObject).a(new com.tencent.mm.loader.g.h((kotlin.g.a.b)new s(this)));
          AppMethodBeat.o(178247);
          return;
        }
      }
    }
    AppMethodBeat.o(178247);
  }
  
  public final void a(View paramView, s params)
  {
    AppMethodBeat.i(243750);
    p.h(paramView, "view");
    p.h(params, "item");
    paramView = new com.tencent.mm.ui.widget.a.e(paramView.getContext(), 1, false);
    FinderItem localFinderItem = this.tMO;
    if (localFinderItem == null) {
      p.btv("feedObj");
    }
    paramView.a((o.f)new a.a(params, localFinderItem.getUserName()));
    paramView.a((o.g)new a.d(params, this.tMM, (kotlin.g.a.b)new p(this)));
    paramView.dGm();
    AppMethodBeat.o(243750);
  }
  
  public final void a(ImageView paramImageView, int paramInt)
  {
    AppMethodBeat.i(165677);
    p.h(paramImageView, "view");
    if (paramInt < 0)
    {
      Log.i("Finder.DrawerPresenter", "onLikeComment position:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(165677);
      return;
    }
    paramImageView = this.tMN.IL(paramInt);
    Object localObject1 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
    localObject1 = com.tencent.mm.plugin.finder.upload.action.j.dBt();
    Object localObject2 = this.tMO;
    if (localObject2 == null) {
      p.btv("feedObj");
    }
    boolean bool1 = ((com.tencent.mm.plugin.finder.upload.action.j)localObject1).a(((FinderItem)localObject2).getId(), paramImageView.uOf, this.scene);
    Log.i("Finder.DrawerPresenter", "[onLikeComment] position=" + paramInt + " isLike=" + bool1 + " commentObj=" + paramImageView.uOf);
    boolean bool2;
    int i;
    if (!bool1)
    {
      bool1 = true;
      if ((this.context instanceof MMFragmentActivity))
      {
        localObject1 = com.tencent.mm.ui.component.a.PRN;
        localObject1 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.context).get(FinderReporterUIC.class)).dIx();
        localObject2 = y.vXH;
        localObject2 = this.tMO;
        if (localObject2 == null) {
          p.btv("feedObj");
        }
        bool2 = y.In(((FinderItem)localObject2).getUserName());
        localObject2 = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (((Number)com.tencent.mm.plugin.finder.storage.c.dsP().value()).intValue() == 1) {
          break label509;
        }
        localObject2 = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.drT() != 1) {
          break label509;
        }
        i = 1;
        label257:
        if ((bool2) && (i == 1))
        {
          if (!bool1) {
            break label517;
          }
          paramImageView.uOf.Lb(paramImageView.uOf.dyb().displayFlag | 0x1);
        }
      }
    }
    for (;;)
    {
      localObject2 = aj.uOw;
      localObject2 = this.tMO;
      if (localObject2 == null) {
        p.btv("feedObj");
      }
      long l = ((FinderItem)localObject2).getId();
      localObject2 = this.tMO;
      if (localObject2 == null) {
        p.btv("feedObj");
      }
      aj.a((bbn)localObject1, l, ((FinderItem)localObject2).getObjectNonceId(), paramImageView.uOf, bool1, this.scene, bool2);
      localObject1 = com.tencent.mm.ui.component.a.PRN;
      localObject1 = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.context).get(FinderReporterUIC.class));
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.event.a)localObject1).cZR();
        localObject2 = this.tMO;
        if (localObject2 == null) {
          p.btv("feedObj");
        }
        ((a.b)localObject1).Ev(((FinderItem)localObject2).getId());
      }
      localObject1 = ao.UpX;
      ao.m(bool1, paramImageView.uOf.dyb().commentId);
      paramImageView = this.tMP;
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
      paramImageView.b(paramInt, Integer.valueOf(1));
      AppMethodBeat.o(165677);
      return;
      bool1 = false;
      break;
      label509:
      i = this.scene;
      break label257;
      label517:
      paramImageView.uOf.Lb(paramImageView.uOf.dyb().displayFlag & 0xFFFFFFFE);
    }
    label540:
    AppMethodBeat.o(165677);
  }
  
  public final void a(final s params)
  {
    AppMethodBeat.i(165678);
    p.h(params, "item");
    final Context localContext = this.context;
    if (localContext != null)
    {
      com.tencent.mm.ui.base.h.a(localContext, 2131760453, 0, (DialogInterface.OnClickListener)new f(this, localContext, params), null);
      AppMethodBeat.o(165678);
      return;
    }
    AppMethodBeat.o(165678);
  }
  
  public final void a(final s params, final boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(178245);
    p.h(params, "rootComment");
    this.tNa = true;
    final z.d locald = new z.d();
    Object localObject1 = FinderReporterUIC.wzC;
    localObject1 = FinderReporterUIC.a.fH(this.context);
    int i;
    if (localObject1 != null)
    {
      i = ((FinderReporterUIC)localObject1).tCE;
      locald.SYE = i;
      if (!paramBoolean) {
        break label303;
      }
      localObject1 = params.uOf.dyb().levelTwoComment;
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
      localObject1 = com.tencent.mm.plugin.finder.report.k.vfA;
      com.tencent.mm.plugin.finder.report.k.a(params, 1, locald.SYE);
      AppMethodBeat.o(178245);
      return;
      i = 0;
      break;
      label122:
      Object localObject2 = ((Iterable)this.tMN.data).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          long l = ((s)((Iterator)localObject2).next()).uOf.dyb().commentId;
          p.g(localObject1, "level2Comments");
          if (l == ((FinderCommentInfo)((LinkedList)localObject1).getFirst()).commentId)
          {
            i = j;
            break;
          }
        }
      }
      localObject2 = this.tMX;
      if (localObject2 != null) {
        ((com.tencent.mm.loader.g.i)localObject2).a(new com.tencent.mm.loader.g.h((kotlin.g.a.b)new g(this, (LinkedList)localObject1, params)));
      }
      i = 1;
    }
    label243:
    localObject1 = com.tencent.mm.plugin.finder.report.k.vfA;
    com.tencent.mm.plugin.finder.report.k.a(params, 2, locald.SYE);
    for (;;)
    {
      localObject1 = this.tMX;
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.loader.g.i)localObject1).a(new com.tencent.mm.loader.g.h((kotlin.g.a.b)new k(this, params, locald, paramBoolean)));
      AppMethodBeat.o(178245);
      return;
      label303:
      localObject1 = com.tencent.mm.plugin.finder.report.k.vfA;
      com.tencent.mm.plugin.finder.report.k.a(params, 3, locald.SYE);
    }
    AppMethodBeat.o(178245);
  }
  
  public final void a(FinderCommentDrawer paramFinderCommentDrawer, final com.tencent.mm.plugin.finder.view.builder.b paramb, FinderItem paramFinderItem, CommentDrawerContract.CloseDrawerCallback paramCloseDrawerCallback, int paramInt, boolean paramBoolean1, long paramLong, an paraman, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    AppMethodBeat.i(243746);
    p.h(paramFinderCommentDrawer, "drawer");
    p.h(paramb, "builder");
    p.h(paramFinderItem, "feedObj");
    this.isDetached = false;
    this.sGC = System.currentTimeMillis();
    Log.i("Finder.DrawerPresenter", "onAttach " + paramFinderItem.getId() + ", " + paramInt + ", " + paramBoolean1 + ", " + paramLong);
    this.tMP = paramb;
    this.tNb = paramFinderCommentDrawer;
    this.tMO = paramFinderItem;
    this.tMV = paramBoolean1;
    this.scene = paramInt;
    this.tMR = paramCloseDrawerCallback;
    this.tuj = paramLong;
    this.efT = paramBoolean2;
    this.tMW = paramBoolean3;
    this.tMX = new com.tencent.mm.loader.g.i("FinderCommentExecutor");
    paramCloseDrawerCallback = this.tMX;
    if (paramCloseDrawerCallback != null) {
      paramCloseDrawerCallback.start();
    }
    localObject1 = this.tMN.a(paramFinderItem.getId(), paramFinderItem, paramLong, paramBoolean2, paramb.tzm.getCommentScene());
    paramCloseDrawerCallback = (com.tencent.mm.plugin.finder.storage.data.f.b)((o)localObject1).first;
    paramBoolean2 = ((Boolean)((o)localObject1).second).booleanValue();
    k = paramCloseDrawerCallback.pos;
    localObject1 = paramCloseDrawerCallback.lastBuffer;
    paramBoolean3 = paramCloseDrawerCallback.tMT;
    boolean bool1 = paramCloseDrawerCallback.tMU;
    boolean bool2 = paramCloseDrawerCallback.vGe;
    this.lastBuffer = ((com.tencent.mm.bw.b)localObject1);
    this.tMS = paramBoolean2;
    mW(paramBoolean3);
    mX(bool1);
    this.tzn = paramBoolean5;
    this.tMY = true;
    this.tMZ = paramBoolean4;
    this.tNa = bool2;
    if (this.tMT)
    {
      paramb.pb(true);
      paramb.dHv().setFooterMode(0);
      if (paramLong != 0L) {
        break label836;
      }
      paramCloseDrawerCallback = this.tMP;
      if (paramCloseDrawerCallback != null)
      {
        paramCloseDrawerCallback = paramCloseDrawerCallback.dHv();
        if (paramCloseDrawerCallback != null)
        {
          localObject1 = y.vXH;
          paramCloseDrawerCallback.hk(y.LD(this.scene), paramFinderItem.getNickName());
        }
      }
    }
    label1029:
    label1042:
    for (;;)
    {
      paramb.getRlLayout().getRecyclerView().setLayoutFrozen(false);
      this.tMQ = new b(paramb.getRlLayout().getRecyclerView());
      EventCenter.instance.addListener(this.tNd);
      try
      {
        paramCloseDrawerCallback = paramb.getRlLayout().getRecyclerView().getAdapter();
        if (paramCloseDrawerCallback != null) {
          paramCloseDrawerCallback.a((RecyclerView.c)this.tNe);
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
          paramb.dHs().setText((CharSequence)paramb.getContext().getResources().getString(2131759595, new Object[] { com.tencent.mm.plugin.finder.utils.k.gm(this.scene, getCommentCount()) }));
          continue;
          paramCloseDrawerCallback = com.tencent.mm.plugin.finder.api.c.tsp;
          paramCloseDrawerCallback = com.tencent.mm.plugin.finder.api.c.a.asG(z.aUg());
          if (paramCloseDrawerCallback != null)
          {
            paraman = paramCloseDrawerCallback.cXH();
            paramCloseDrawerCallback = paraman;
            if (paraman != null) {}
          }
          else
          {
            paramCloseDrawerCallback = "";
          }
          paraman = m.uJa;
          paraman = m.dka();
          paramCloseDrawerCallback = new com.tencent.mm.plugin.finder.loader.a(paramCloseDrawerCallback);
          localObject1 = dcC();
          if (localObject1 == null) {
            p.hyc();
          }
          Object localObject2 = m.uJa;
          paraman.a(paramCloseDrawerCallback, (ImageView)localObject1, m.a(m.a.uJe));
          continue;
          if ((paramBoolean2) && (k == 0) && (paramLong == 0L) && (!this.tNa))
          {
            this.lastBuffer = null;
            mX(true);
            mY(true);
          }
          else
          {
            paramCloseDrawerCallback = this.tMP;
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
            paramCloseDrawerCallback = this.tMP;
            if (paramCloseDrawerCallback != null)
            {
              paramCloseDrawerCallback = paramCloseDrawerCallback.getRlLayout();
              if (paramCloseDrawerCallback != null)
              {
                paramCloseDrawerCallback = paramCloseDrawerCallback.getRecyclerView();
                if (paramCloseDrawerCallback != null)
                {
                  paramCloseDrawerCallback.post((Runnable)new o(this, k));
                  continue;
                  paramb.dHw().setBackgroundColorRes(2131099835);
                  continue;
                  paramb.dHw().setSquaresBackgroundResource(2131101287);
                  paramb.dHw().setBackgroundColorRes(2131101287);
                  paramb.getHeaderLayout().setVisibility(8);
                  paramb.getRlLayout().setVisibility(8);
                  paramFinderCommentDrawer = getEditText();
                  if (paramFinderCommentDrawer != null) {
                    paramFinderCommentDrawer.requestFocus();
                  }
                  if (!this.tAj)
                  {
                    paramFinderCommentDrawer = this.tMP;
                    if (paramFinderCommentDrawer != null)
                    {
                      paramFinderCommentDrawer = paramFinderCommentDrawer.dHv();
                      if (paramFinderCommentDrawer != null) {
                        paramFinderCommentDrawer.cH(true);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      paramb.getRlLayout().setActionCallback((RefreshLoadMoreLayout.a)new m(this));
      paramb.dHv().setModeChangeCallback((FinderCommentFooter.b)this);
      if (getCommentCount() > 0) {
        break label1067;
      }
      paramb.dHs().setText((CharSequence)paramb.getContext().getResources().getString(2131759589));
      paramb.dHv().getReplyBtn().setOnClickListener((View.OnClickListener)new n(this, paramb));
      if (paraman != null)
      {
        paramCloseDrawerCallback = paramb.dHv();
        localObject1 = y.vXH;
        localObject1 = y.LD(this.scene);
        localObject2 = y.vXH;
        paramCloseDrawerCallback.e((String)localObject1, y.hf(paraman.getUsername(), paraman.getNickname()), paraman);
      }
      if (dcC() != null)
      {
        if (paramInt != 2) {
          break label1111;
        }
        com.tencent.mm.ui.g.a.a.c(dcC(), z.aTY());
      }
      paramCloseDrawerCallback = this.tMP;
      if (paramCloseDrawerCallback != null) {
        paramCloseDrawerCallback.hideLoading();
      }
      if (paramBoolean1) {
        break label1372;
      }
      if (paramBoolean2) {
        break label1208;
      }
      mY(true);
      paramCloseDrawerCallback = this.tMP;
      if (paramCloseDrawerCallback != null) {
        paramCloseDrawerCallback.showLoading();
      }
      paramCloseDrawerCallback = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (((Number)com.tencent.mm.plugin.finder.storage.c.dsr().value()).intValue() != 1) {
        break label1359;
      }
      paramb.dHw().setBackgroundColorRes(2131101287);
      paramb.dHw().setSquaresBackgroundResource(2131232477);
      paramb.getRlLayout().setVisibility(0);
      paramb.getHeaderLayout().setVisibility(0);
      if ((paramFinderItem.getCommentCount() == 0) && (paramFinderCommentDrawer.getReason() != 4))
      {
        paramFinderCommentDrawer = getEditText();
        if (paramFinderCommentDrawer != null) {
          paramFinderCommentDrawer.postDelayed((Runnable)new l(paramFinderCommentDrawer, this), 200L);
        }
      }
      if (!this.tMU)
      {
        paramFinderCommentDrawer = this.tMP;
        if (paramFinderCommentDrawer != null)
        {
          paramFinderCommentDrawer = paramFinderCommentDrawer.getRlLayout();
          if (paramFinderCommentDrawer != null) {
            RefreshLoadMoreLayout.e(paramFinderCommentDrawer);
          }
        }
      }
      this.tNc.alive();
      AppMethodBeat.o(243746);
      return;
      paramb.pb(false);
      paramCloseDrawerCallback = this.tMP;
      if (paramCloseDrawerCallback == null) {
        break;
      }
      paramCloseDrawerCallback = paramCloseDrawerCallback.dHw();
      if (paramCloseDrawerCallback == null) {
        break;
      }
      paramCloseDrawerCallback.hge();
      break;
      label836:
      paramCloseDrawerCallback = (List)this.tMN.data;
      i = 0;
      paramCloseDrawerCallback = paramCloseDrawerCallback.iterator();
      label860:
      if (paramCloseDrawerCallback.hasNext()) {
        if (((s)paramCloseDrawerCallback.next()).lT() == paramLong)
        {
          j = 1;
          label892:
          if (j == 0) {
            break label1029;
          }
        }
      }
      for (;;)
      {
        if (i < 0) {
          break label1042;
        }
        localObject2 = (s)this.tMN.data.get(i);
        ((s)localObject2).uOb = true;
        paramCloseDrawerCallback = this.tMP;
        if (paramCloseDrawerCallback == null) {
          break;
        }
        FinderCommentFooter localFinderCommentFooter = paramCloseDrawerCallback.dHv();
        if (localFinderCommentFooter == null) {
          break;
        }
        paramCloseDrawerCallback = y.vXH;
        String str1 = y.LD(this.scene);
        paramCloseDrawerCallback = y.vXH;
        String str2 = ((s)localObject2).uOf.getUsername();
        localObject1 = ((s)localObject2).uOf.getNickname();
        paramCloseDrawerCallback = (CommentDrawerContract.CloseDrawerCallback)localObject1;
        if (localObject1 == null) {
          paramCloseDrawerCallback = "";
        }
        localFinderCommentFooter.e(str1, y.hf(str2, paramCloseDrawerCallback), ((s)localObject2).uOf);
        break;
        j = 0;
        break label892;
        i += 1;
        break label860;
        i = -1;
      }
    }
  }
  
  public final void af(View paramView, int paramInt)
  {
    AppMethodBeat.i(165681);
    p.h(paramView, "view");
    if (paramInt < 0)
    {
      Log.i("Finder.DrawerPresenter", "onClickResendComment position:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(165681);
      return;
    }
    paramView = this.tMN.IL(paramInt).uOf;
    if (paramView.field_state == -1)
    {
      Object localObject = com.tencent.mm.plugin.finder.upload.b.vRM;
      localObject = com.tencent.mm.plugin.finder.upload.b.dAQ();
      p.h(paramView, "unsentComment");
      Log.i(com.tencent.mm.plugin.finder.upload.b.TAG, "rePost ".concat(String.valueOf(paramView)));
      paramView.field_state = 1;
      paramView.field_canRemove = 0;
      paramView.FC(cl.aWy() / 1000L);
      paramView.field_postTime = cl.aWy();
      paramView.field_tryCount = 0L;
      ((com.tencent.mm.plugin.finder.upload.b)localObject).a(new com.tencent.mm.plugin.finder.upload.a(paramView));
      paramView = this.tMP;
      if (paramView != null)
      {
        paramView = paramView.getRlLayout();
        if (paramView != null)
        {
          paramView = paramView.getRecyclerView();
          if (paramView != null)
          {
            localObject = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter", "onClickResendComment", "(Landroid/view/View;I)V", "Undefined", "scrollToPosition", "(I)V");
            paramView.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter", "onClickResendComment", "(Landroid/view/View;I)V", "Undefined", "scrollToPosition", "(I)V");
            AppMethodBeat.o(165681);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(165681);
  }
  
  public final boolean b(s params, boolean paramBoolean)
  {
    AppMethodBeat.i(178246);
    p.h(params, "comment");
    Object localObject1;
    int i;
    if (params.uOf.field_actionInfo.tuf == 0L)
    {
      if (!paramBoolean)
      {
        AppMethodBeat.o(178246);
        return false;
      }
      localObject1 = this.tMN;
      p.h(params, "root");
      if (params.lT() != 0L)
      {
        localObject1 = ((Iterable)((com.tencent.mm.plugin.finder.feed.model.c)localObject1).data).iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
        } while (((s)((Iterator)localObject1).next()).uOf.field_actionInfo.tuf != params.lT());
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
      localObject1 = this.tMN;
      p.h(params, "level2Comment");
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
            kotlin.a.j.hxH();
          }
          localObject2 = (s)localObject2;
          if (com.tencent.mm.plugin.finder.feed.model.c.b((s)localObject2, params))
          {
            j = i;
            i = k;
          }
          else if ((j >= 0) && (com.tencent.mm.plugin.finder.feed.model.c.a((s)localObject2, params)))
          {
            Log.d(((com.tencent.mm.plugin.finder.feed.model.c)localObject1).TAG, "hasLevel2ItemAfter cur:" + j + ", after:" + i);
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
    if (!this.tMN.c(params))
    {
      AppMethodBeat.o(178246);
      return true;
    }
    AppMethodBeat.o(178246);
    return false;
  }
  
  public final int dcA()
  {
    return this.scene;
  }
  
  public final FinderItem dcB()
  {
    AppMethodBeat.i(165684);
    FinderItem localFinderItem = this.tMO;
    if (localFinderItem == null) {
      p.btv("feedObj");
    }
    AppMethodBeat.o(165684);
    return localFinderItem;
  }
  
  public final void dcD()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(178243);
    Object localObject3;
    if (getCommentCount() <= 0)
    {
      localObject2 = this.tMP;
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject2).dHs();
        if (localObject2 != null)
        {
          localObject3 = getResources();
          if (localObject3 != null) {
            localObject1 = ((Resources)localObject3).getString(2131759589);
          }
          ((TextView)localObject2).setText((CharSequence)localObject1);
          AppMethodBeat.o(178243);
          return;
        }
      }
      AppMethodBeat.o(178243);
      return;
    }
    localObject1 = this.tMP;
    if (localObject1 != null)
    {
      localObject3 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).dHs();
      if (localObject3 != null)
      {
        Resources localResources = getResources();
        localObject1 = localObject2;
        if (localResources != null) {
          localObject1 = localResources.getString(2131759595, new Object[] { String.valueOf(getCommentCount()) });
        }
        ((TextView)localObject3).setText((CharSequence)localObject1);
        AppMethodBeat.o(178243);
        return;
      }
    }
    AppMethodBeat.o(178243);
  }
  
  public final int dcE()
  {
    AppMethodBeat.i(243751);
    Object localObject = this.tMN.data;
    int i;
    if (!Util.isNullOrNil((List)localObject))
    {
      localObject = (s)kotlin.a.j.kt((List)localObject);
      if (localObject != null)
      {
        localObject = ((s)localObject).uOf;
        if (localObject != null)
        {
          if (((an)localObject).dyh() != true) {
            break label71;
          }
          i = 0;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(243751);
      return i;
      i = -1;
      continue;
      label71:
      i = -1;
    }
  }
  
  public final int dcF()
  {
    AppMethodBeat.i(243752);
    Object localObject1 = this.tMN.data;
    if (!Util.isNullOrNil((List)localObject1))
    {
      localObject1 = ((Iterable)localObject1).iterator();
      int i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          kotlin.a.j.hxH();
        }
        localObject2 = (s)localObject2;
        if ((((s)localObject2).uOf.field_actionInfo.tuf == 0L) && (!((s)localObject2).uOf.dyh()))
        {
          AppMethodBeat.o(243752);
          return i;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(243752);
    return -1;
  }
  
  public final RecyclerView.h fi(Context paramContext)
  {
    AppMethodBeat.i(165686);
    p.h(paramContext, "context");
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = ((int)paramContext.getResources().getDimension(2131165310));
    paramContext = (RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.a((Drawable)new ColorDrawable(paramContext.getResources().getColor(2131099687)), (int)paramContext.getResources().getDimension(2131166339), arrayOfInt, (int)paramContext.getResources().getDimension(2131166340));
    AppMethodBeat.o(165686);
    return paramContext;
  }
  
  public final WxRecyclerAdapter<?> fm(Context paramContext)
  {
    AppMethodBeat.i(165685);
    p.h(paramContext, "context");
    paramContext = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new h(this), this.tMN.data);
    paramContext.au(false);
    paramContext.RqP = ((g.c)this);
    paramContext.RqO = ((g.d)this);
    AppMethodBeat.o(165685);
    return paramContext;
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(243747);
    Object localObject = FinderReporterUIC.wzC;
    localObject = FinderReporterUIC.a.fH(this.context);
    if (localObject != null)
    {
      int i = ((FinderReporterUIC)localObject).tCE;
      AppMethodBeat.o(243747);
      return i;
    }
    AppMethodBeat.o(243747);
    return 0;
  }
  
  public final boolean isCommentClose()
  {
    return this.tMZ;
  }
  
  public final void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(165673);
    p.h(parama, "p0");
    this.tLP.add(parama);
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
    Object localObject1 = FinderReporterUIC.wzC;
    localObject1 = FinderReporterUIC.a.fH(this.context);
    Object localObject3;
    int j;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.finder.report.k.vfA;
      localObject2 = ((FinderReporterUIC)localObject1).sessionId;
      localObject3 = ((FinderReporterUIC)localObject1).sGE;
      String str = ((FinderReporterUIC)localObject1).sGQ;
      j = ((FinderReporterUIC)localObject1).tCE;
      localObject1 = this.tMO;
      if (localObject1 == null) {
        p.btv("feedObj");
      }
      if (localObject1 != null)
      {
        localObject1 = Long.valueOf(((FinderItem)localObject1).getId());
        long l1 = ((Long)localObject1).longValue();
        long l2 = this.sGC;
        long l3 = System.currentTimeMillis();
        localObject1 = this.tNb;
        if (localObject1 == null) {
          break label319;
        }
        i = ((FinderCommentDrawer)localObject1).getReason();
        label147:
        com.tencent.mm.plugin.finder.report.k.a((String)localObject2, (String)localObject3, str, j, l1, l2, l3, i);
      }
    }
    else
    {
      this.isDetached = true;
      this.tMY = false;
      localObject1 = this.tMX;
      if (localObject1 != null) {
        ((com.tencent.mm.loader.g.i)localObject1).stop();
      }
      this.tMX = null;
      localObject1 = this.tMP;
      if (localObject1 == null) {
        break label324;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).getRlLayout();
      if (localObject1 == null) {
        break label324;
      }
      localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
      if (localObject1 == null) {
        break label324;
      }
      localObject1 = ((RecyclerView)localObject1).getLayoutManager();
      label237:
      if (!(localObject1 instanceof LinearLayoutManager)) {
        break label475;
      }
      localObject1 = this.tMP;
      if (localObject1 == null) {
        break label330;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).getRlLayout();
      if (localObject1 == null) {
        break label330;
      }
      localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
      if (localObject1 == null) {
        break label330;
      }
    }
    label319:
    label324:
    label330:
    for (localObject1 = ((RecyclerView)localObject1).getLayoutManager();; localObject1 = null)
    {
      if (localObject1 != null) {
        break label336;
      }
      localObject1 = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
      AppMethodBeat.o(165675);
      throw ((Throwable)localObject1);
      localObject1 = null;
      break;
      i = 0;
      break label147;
      localObject1 = null;
      break label237;
    }
    label336:
    label475:
    for (int i = ((LinearLayoutManager)localObject1).ks();; i = -1)
    {
      localObject1 = this.tMP;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).dHv();
        if (localObject1 != null) {
          ((FinderCommentFooter)localObject1).setFooterMode(0);
        }
      }
      localObject1 = this.tMP;
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
              ((RecyclerView.a)localObject1).b((RecyclerView.c)this.tNe);
            }
          }
        }
      }
      localObject1 = ((Iterable)this.tLP).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((com.tencent.mm.vending.e.a)((Iterator)localObject1).next()).dead();
      }
    }
    this.tLP.clear();
    EventCenter.instance.removeListener(this.tNd);
    localObject1 = this.tMO;
    if (localObject1 == null) {
      p.btv("feedObj");
    }
    ((FinderItem)localObject1).setCommentCount(getCommentCount());
    localObject1 = com.tencent.mm.plugin.finder.storage.data.e.vFX;
    localObject1 = this.tMO;
    if (localObject1 == null) {
      p.btv("feedObj");
    }
    e.a.n((FinderItem)localObject1);
    localObject1 = new StringBuilder("[onDetach] updateFeedCommentCount feedId=");
    Object localObject2 = this.tMO;
    if (localObject2 == null) {
      p.btv("feedObj");
    }
    Log.i("Finder.DrawerPresenter", ((FinderItem)localObject2).getId() + " commentCount " + getCommentCount());
    localObject1 = this.tMR;
    if (localObject1 != null) {
      ((CommentDrawerContract.CloseDrawerCallback)localObject1).g(getCommentCount(), (List)this.tMN.data);
    }
    if ((this.tMV) || (!this.efT))
    {
      this.tMN.nc(true);
      this.lastBuffer = null;
      mW(false);
      mX(true);
      localObject1 = getEditText();
      if (localObject1 != null) {
        ((MMEditText)localObject1).setText(null);
      }
      localObject1 = this.tMP;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).getRlLayout();
        if (localObject1 != null) {
          ((RefreshLoadMoreLayout)localObject1).setHasBottomMore(true);
        }
      }
      localObject1 = this.tMP;
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
      localObject1 = this.tMP;
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
      localObject1 = this.tMP;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).getRlLayout();
        if (localObject1 != null) {
          ((RefreshLoadMoreLayout)localObject1).setActionCallback(null);
        }
      }
      this.tMP = null;
      this.tNc.dead();
      AppMethodBeat.o(165675);
      return;
    }
    int k = i;
    if (this.tuj != 0L)
    {
      localObject1 = ((Iterable)this.tMN.data).iterator();
      j = 0;
      label899:
      k = i;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (j < 0) {
          kotlin.a.j.hxH();
        }
        localObject2 = (s)localObject2;
        if (((s)localObject2).lT() != this.tuj) {
          break label1100;
        }
        ((s)localObject2).uOc = false;
        i = j;
      }
    }
    label1100:
    for (;;)
    {
      j += 1;
      break label899;
      localObject1 = this.tMN;
      localObject2 = this.lastBuffer;
      boolean bool1 = this.tMT;
      boolean bool2 = this.tMU;
      boolean bool3 = this.tNa;
      localObject3 = ((com.tencent.mm.plugin.finder.feed.model.c)localObject1).tUL;
      if (localObject3 != null) {
        ((com.tencent.mm.plugin.finder.feed.model.c)localObject1).data.remove(localObject3);
      }
      ((com.tencent.mm.plugin.finder.feed.model.c)localObject1).tUL = null;
      if ((((com.tencent.mm.plugin.finder.feed.model.c)localObject1).data.size() >= 0) && (k >= 0)) {
        com.tencent.mm.plugin.finder.feed.model.c.a.a(((com.tencent.mm.plugin.finder.feed.model.c)localObject1).tUJ, ((com.tencent.mm.plugin.finder.feed.model.c)localObject1).tUK, ((com.tencent.mm.plugin.finder.feed.model.c)localObject1).data);
      }
      ((com.tencent.mm.plugin.finder.feed.model.c)localObject1).data.clear();
      if ((k < 0) || (com.tencent.mm.plugin.finder.feed.model.c.tUM)) {
        break;
      }
      com.tencent.mm.plugin.finder.storage.data.f.vGd.a(((com.tencent.mm.plugin.finder.feed.model.c)localObject1).tUJ, ((com.tencent.mm.plugin.finder.feed.model.c)localObject1).tUK, k, (com.tencent.mm.bw.b)localObject2, bool1, bool2, bool3);
      break;
    }
  }
  
  public final void onModeChange(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(165676);
    Log.i("Finder.DrawerPresenter", "[onModeChange] from=" + paramInt1 + " to=" + paramInt2);
    if (paramInt2 == 0)
    {
      Object localObject1 = this.tMP;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).dHw();
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
        localObject1 = this.tMP;
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).dHv();
          if (localObject1 != null)
          {
            Object localObject2 = y.vXH;
            localObject2 = y.LD(this.scene);
            FinderItem localFinderItem = this.tMO;
            if (localFinderItem == null) {
              p.btv("feedObj");
            }
            ((FinderCommentFooter)localObject1).hk((String)localObject2, localFinderItem.getNickName());
            AppMethodBeat.o(165676);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(165676);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$Companion;", "", "()V", "DEFAULT_INIT_COUNT", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$DiffDataChangeHelper;", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "(Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter;Landroid/support/v7/widget/RecyclerView;)V", "onDeleteChange", "", "commentId", "", "localCommentId", "anim", "", "onInsertChange", "target", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "onSecondaryItemRangeInsert", "rootCommentId", "", "onUpdateChange", "plugin-finder_release"})
  public final class b
  {
    final RecyclerView hak;
    
    public b()
    {
      AppMethodBeat.i(165628);
      this.hak = localObject;
      AppMethodBeat.o(165628);
    }
    
    public final void a(long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(178222);
      Object localObject1;
      if (paramLong1 != 0L)
      {
        int m = f.b(f.this).data.size();
        localObject1 = f.b(f.this);
        Object localObject3 = (Iterable)((com.tencent.mm.plugin.finder.feed.model.c)localObject1).data;
        Object localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        int i = 0;
        int j = -1;
        if (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = ((Iterator)localObject3).next();
          if (i < 0) {
            kotlin.a.j.hxH();
          }
          s locals = (s)localObject4;
          if (locals.uOf.dyb().commentId == paramLong1) {
            j = i;
          }
          if ((locals.uOf.dyb().commentId == paramLong1) || (locals.uOf.field_actionInfo.tuf == paramLong1)) {}
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
            localObject2 = this.hak.getAdapter();
            if (localObject2 != null) {
              ((RecyclerView.a)localObject2).at(((Number)((o)localObject1).first).intValue(), ((Number)((o)localObject1).second).intValue());
            }
          }
        }
      }
      for (;;)
      {
        localObject1 = this.hak.getAdapter();
        if (localObject1 == null) {
          break;
        }
        ((RecyclerView.a)localObject1).notifyDataSetChanged();
        AppMethodBeat.o(178222);
        return;
        f.b(f.this).EE(paramLong2);
      }
      AppMethodBeat.o(178222);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentChangeEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderCommentChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class c
    extends IListener<hs>
  {
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<x>
    {
      b(f.c paramc, hs paramhs)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentDataObserver$1", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeRemoved", "plugin-finder_release"})
  public static final class d
    extends RecyclerView.c
  {
    @SuppressLint({"StringFormatMatches"})
    public final void onChanged()
    {
      AppMethodBeat.i(165632);
      super.onChanged();
      this.tNg.dcD();
      AppMethodBeat.o(165632);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(165634);
      super.onItemRangeChanged(paramInt1, paramInt2);
      this.tNg.dcD();
      AppMethodBeat.o(165634);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(165635);
      super.onItemRangeChanged(paramInt1, paramInt2, paramObject);
      this.tNg.dcD();
      AppMethodBeat.o(165635);
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(165633);
      super.onItemRangeInserted(paramInt1, paramInt2);
      this.tNg.dcD();
      AppMethodBeat.o(165633);
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(165636);
      super.onItemRangeRemoved(paramInt1, paramInt2);
      this.tNg.dcD();
      AppMethodBeat.o(165636);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentErrorListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderCommentErrorEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class e
    extends IListener<ht>
  {
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(f.e parame, ht paramht)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class f
    implements DialogInterface.OnClickListener
  {
    f(f paramf, Context paramContext, s params) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(165647);
      paramDialogInterface = this.tNg.tipDialog;
      if (paramDialogInterface != null) {
        paramDialogInterface.show();
      }
      Object localObject;
      for (;;)
      {
        localObject = (kotlin.g.a.a)new d(this);
        paramDialogInterface = (kotlin.g.a.a)new b(this, (kotlin.g.a.a)localObject, (kotlin.g.a.a)new c(this));
        if ((!params.uOf.dyi()) && (params.uOf.field_localCommentId != 0L)) {
          break;
        }
        paramDialogInterface.invoke();
        AppMethodBeat.o(165647);
        return;
        paramDialogInterface = this.tNg;
        localObject = localContext;
        localContext.getString(2131755998);
        paramDialogInterface.tipDialog = ((Dialog)com.tencent.mm.ui.base.h.a((Context)localObject, localContext.getString(2131756029), false, (DialogInterface.OnCancelListener)a.tNn));
      }
      paramDialogInterface = com.tencent.mm.plugin.finder.upload.b.vRM;
      paramDialogInterface = com.tencent.mm.plugin.finder.upload.b.dAQ();
      an localan = params.uOf;
      p.h(localan, "wantDeleteItem");
      paramDialogInterface.vRJ.d((com.tencent.mm.loader.g.c)new com.tencent.mm.plugin.finder.upload.a(localan));
      paramDialogInterface = paramDialogInterface.vRJ;
      com.tencent.mm.loader.g.c localc = (com.tencent.mm.loader.g.c)new com.tencent.mm.plugin.finder.upload.a(localan);
      p.h(localc, "t");
      Iterator localIterator = ((Iterable)paramDialogInterface.iba).iterator();
      while (localIterator.hasNext())
      {
        paramDialogInterface = localIterator.next();
        if (p.j(((com.tencent.mm.loader.g.c)((com.tencent.mm.loader.g.g)paramDialogInterface).first).auK(), localc.auK()))
        {
          if ((com.tencent.mm.loader.g.g)paramDialogInterface == null) {
            break label360;
          }
          paramInt = 1;
          label282:
          if (paramInt == 0) {
            break label365;
          }
          Log.i(com.tencent.mm.plugin.finder.upload.b.TAG, "removeWhenNotDoingNetScene " + localan + " is running");
        }
      }
      for (paramInt = 0;; paramInt = 1)
      {
        if (paramInt != 0) {
          break label406;
        }
        paramDialogInterface = this.tNg.tipDialog;
        if (paramDialogInterface != null) {
          paramDialogInterface.dismiss();
        }
        u.makeText(localContext, 2131760455, 0).show();
        AppMethodBeat.o(165647);
        return;
        paramDialogInterface = null;
        break;
        label360:
        paramInt = 0;
        break label282;
        label365:
        Log.i(com.tencent.mm.plugin.finder.upload.b.TAG, "removeWhenNotDoingNetScene ".concat(String.valueOf(localan)));
        ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderActionStorage().Fw(localan.field_localCommentId);
      }
      label406:
      ((kotlin.g.a.a)localObject).invoke();
      AppMethodBeat.o(165647);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class a
      implements DialogInterface.OnCancelListener
    {
      public static final a tNn;
      
      static
      {
        AppMethodBeat.i(165642);
        tNn = new a();
        AppMethodBeat.o(165642);
      }
      
      public final void onCancel(DialogInterface paramDialogInterface) {}
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<x>
    {
      b(f.f paramf, kotlin.g.a.a parama1, kotlin.g.a.a parama2)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class c
      extends q
      implements kotlin.g.a.a<x>
    {
      c(f.f paramf)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class d
      extends q
      implements kotlin.g.a.a<x>
    {
      d(f.f paramf)
      {
        super();
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$deleteComment$1$succCallback$1$1$1"})
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.b<com.tencent.mm.loader.g.h, x>
  {
    g(f paramf, LinkedList paramLinkedList, s params)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$getAdapter$adapter$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class h
    implements com.tencent.mm.view.recyclerview.f
  {
    public final com.tencent.mm.view.recyclerview.e<?> EC(int paramInt)
    {
      AppMethodBeat.i(165648);
      if (f.i(this.tNg))
      {
        localObject = s.uOj;
        if (paramInt == s.dkA())
        {
          localObject = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.finder.convert.j(this.tNg);
          AppMethodBeat.o(165648);
          return localObject;
        }
        localObject = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.finder.convert.h((CommentDrawerContract.NPresenter)this.tNg, true);
        AppMethodBeat.o(165648);
        return localObject;
      }
      Object localObject = s.uOj;
      if (paramInt == s.dky())
      {
        localObject = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.finder.convert.h((CommentDrawerContract.NPresenter)this.tNg, false);
        AppMethodBeat.o(165648);
        return localObject;
      }
      localObject = s.uOj;
      if (paramInt == s.dkz())
      {
        localObject = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.finder.convert.k((CommentDrawerContract.NPresenter)this.tNg);
        AppMethodBeat.o(165648);
        return localObject;
      }
      localObject = s.uOj;
      if (paramInt == s.dkA())
      {
        localObject = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.finder.convert.j(this.tNg);
        AppMethodBeat.o(165648);
        return localObject;
      }
      localObject = y.vXH;
      y.dQ("Finder.DrawerPresenter", paramInt);
      localObject = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.finder.convert.f();
      AppMethodBeat.o(165648);
      return localObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.b<com.tencent.mm.loader.g.h, x>
  {
    j(f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.b<com.tencent.mm.loader.g.h, x>
  {
    k(f paramf, s params, z.d paramd, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$6$1"})
  static final class l
    implements Runnable
  {
    l(MMEditText paramMMEditText, f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(243742);
      this.tNx.requestFocus();
      if (!jdField_this.tAj)
      {
        Object localObject = jdField_this.tMP;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.finder.view.builder.b)localObject).dHv();
          if (localObject != null)
          {
            ((FinderCommentFooter)localObject).cH(true);
            AppMethodBeat.o(243742);
            return;
          }
        }
      }
      AppMethodBeat.o(243742);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder_release"})
  public static final class m
    extends RefreshLoadMoreLayout.a
  {
    public final void ED(int paramInt)
    {
      AppMethodBeat.i(243743);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.axR());
      com.tencent.f.h.RTc.aX((Runnable)new b(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(243743);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(165655);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      p.h(paramc, "reason");
      super.a(paramc);
      f.d(this.tNg);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(165655);
    }
    
    public final void cxo()
    {
      AppMethodBeat.i(165654);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.cxo();
      com.tencent.f.h.RTc.aX((Runnable)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(165654);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(165657);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      p.h(paramc, "reason");
      super.onRefreshEnd(paramc);
      f.f(this.tNg);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(165657);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(f.m paramm) {}
      
      public final void run()
      {
        AppMethodBeat.i(165652);
        f.c(this.tNy.tNg);
        AppMethodBeat.o(165652);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(f.m paramm) {}
      
      public final void run()
      {
        AppMethodBeat.i(165653);
        f.e(this.tNy.tNg);
        AppMethodBeat.o(165653);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    n(f paramf, com.tencent.mm.plugin.finder.view.builder.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178230);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      f.a(this.tNg, paramb.dHv().getScene());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(178230);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class o
    implements Runnable
  {
    o(f paramf, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(178231);
      if ((k > 0) && (k < f.b(this.tNg).data.size()))
      {
        Object localObject = this.tNg.tMP;
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
          localObject = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
          AppMethodBeat.o(178231);
          throw ((Throwable)localObject);
        }
        ((LinearLayoutManager)localObject).ah(k, 0);
      }
      AppMethodBeat.o(178231);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "invoke"})
  static final class p
    extends q
    implements kotlin.g.a.b<s, x>
  {
    p(f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "invoke"})
  static final class q
    extends q
    implements kotlin.g.a.b<s, x>
  {
    q(f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
  static final class s
    extends q
    implements kotlin.g.a.b<com.tencent.mm.loader.g.h, x>
  {
    s(f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
  static final class t
    extends q
    implements kotlin.g.a.b<com.tencent.mm.loader.g.h, x>
  {
    t(f paramf, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.f
 * JD-Core Version:    0.7.0.1
 */