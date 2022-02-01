package com.tencent.mm.plugin.finder.feed;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.c;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.model.v;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.g;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awr;
import com.tencent.mm.protocal.protobuf.bfz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.h.c;
import com.tencent.mm.view.recyclerview.h.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter;", "Lcom/tencent/mm/plugin/finder/feed/IDrawerPresenter;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "()V", "commentCount", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLike;", "Lkotlin/collections/ArrayList;", "getData", "()Ljava/util/ArrayList;", "value", "", "downContinue", "setDownContinue", "(Z)V", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeedObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeedObj", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "forceShowLikeEdu", "getForceShowLikeEdu", "()Z", "setForceShowLikeEdu", "inMsgUI", "getInMsgUI", "setInMsgUI", "isAttached", "setAttached", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "likeBuffer", "getLikeBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLikeBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "likeDataObserver", "com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$likeDataObserver$1", "Lcom/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$likeDataObserver$1;", "resources", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "selfUsername", "", "kotlin.jvm.PlatformType", "getSelfUsername", "()Ljava/lang/String;", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "getTaskExecutor", "()Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "setTaskExecutor", "(Lcom/tencent/mm/loader/loader/SingleTaskExecutor;)V", "totalCount", "upContinue", "setUpContinue", "viewCallback", "Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;)V", "canShowLikeEdu", "checkDownContinue", "", "checkUpContinue", "doExtraOnBuildDrawerBody", "view", "Landroid/view/View;", "doExtraTitleChange", "context", "Landroid/content/Context;", "headerLayout", "Landroid/widget/FrameLayout;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getScene", "getTotalItemCount", "keep", "p0", "loadMoreData", "onAttach", "builder", "onDetach", "onItemClick", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "position", "holder", "onItemLongClick", "refreshData", "down", "extra", "Lkotlin/Function1;", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "setLikeCountView", "Companion", "SpaceItemDecoration", "plugin-finder_release"})
public class x
  implements bc, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>, h.c<com.tencent.mm.view.recyclerview.i>, h.d<com.tencent.mm.view.recyclerview.i>
{
  public static final a xzb;
  final ArrayList<v> data;
  private int jlf;
  private volatile com.tencent.mm.cd.b lastBuffer;
  com.tencent.mm.cd.b likeBuffer;
  private boolean ljV;
  private com.tencent.mm.loader.g.i xeM;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> xvE;
  public FinderItem xwF;
  private boolean xwK;
  private boolean xwL;
  final String xyW;
  com.tencent.mm.plugin.finder.view.builder.a xyX;
  public boolean xyY;
  public boolean xyZ;
  private final d xza;
  
  static
  {
    AppMethodBeat.i(290646);
    xzb = new a((byte)0);
    AppMethodBeat.o(290646);
  }
  
  public x()
  {
    AppMethodBeat.i(290645);
    this.data = new ArrayList();
    this.xyW = z.bcZ();
    this.xwL = true;
    this.xvE = new CopyOnWriteArraySet();
    this.xza = new d(this);
    AppMethodBeat.o(290645);
  }
  
  private final Resources getResources()
  {
    AppMethodBeat.i(290628);
    Object localObject = this.xyX;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.a)localObject).getContext();
      if (localObject != null)
      {
        localObject = ((Context)localObject).getResources();
        AppMethodBeat.o(290628);
        return localObject;
      }
    }
    AppMethodBeat.o(290628);
    return null;
  }
  
  private final void or(boolean paramBoolean)
  {
    AppMethodBeat.i(290629);
    this.xwL = paramBoolean;
    Log.i("Finder.DrawerPresenter", "set downContinue ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(290629);
  }
  
  public final void F(final kotlin.g.a.b<? super LinkedList<awr>, ? extends LinkedList<awr>> paramb)
  {
    AppMethodBeat.i(290632);
    com.tencent.mm.loader.g.i locali = this.xeM;
    if (locali != null)
    {
      locali.a(new com.tencent.mm.loader.g.h((kotlin.g.a.b)new g(this, true, paramb)));
      AppMethodBeat.o(290632);
      return;
    }
    AppMethodBeat.o(290632);
  }
  
  public void a(Context paramContext, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(290644);
    p.k(paramContext, "context");
    p.k(paramFrameLayout, "headerLayout");
    AppMethodBeat.o(290644);
  }
  
  public void a(com.tencent.mm.plugin.finder.view.builder.a parama, FinderItem paramFinderItem, com.tencent.mm.cd.b paramb)
  {
    AppMethodBeat.i(290630);
    p.k(parama, "builder");
    p.k(paramFinderItem, "feedObj");
    this.xwF = paramFinderItem;
    this.likeBuffer = paramb;
    this.xeM = new com.tencent.mm.loader.g.i("FinderLikeExecutor");
    this.xyX = parama;
    Log.i("Finder.DrawerPresenter", "onAttach " + paramFinderItem.getId());
    paramFinderItem = this.xeM;
    if (paramFinderItem != null) {
      paramFinderItem.start();
    }
    dti();
    this.data.clear();
    try
    {
      paramFinderItem = parama.getRlLayout().getRecyclerView().getAdapter();
      if (paramFinderItem != null) {
        paramFinderItem.a((RecyclerView.c)this.xza);
      }
    }
    catch (IllegalStateException paramFinderItem)
    {
      for (;;)
      {
        Log.printErrStackTrace("Finder.DrawerPresenter", (Throwable)paramFinderItem, "", new Object[0]);
      }
    }
    parama.ejE();
    paramFinderItem = this.xyX;
    if (paramFinderItem != null)
    {
      paramFinderItem = paramFinderItem.dsD();
      if (paramFinderItem != null) {
        paramFinderItem.ihE();
      }
    }
    parama.getRlLayout().getRecyclerView().setLayoutFrozen(false);
    parama.getRlLayout().setActionCallback((RefreshLoadMoreLayout.a)new f(this));
    parama = this.xyX;
    if (parama != null) {
      parama.hideLoading();
    }
    parama = this.xyX;
    if (parama != null) {
      parama.showLoading();
    }
    F(null);
    if (!this.xwL)
    {
      parama = this.xyX;
      if (parama != null)
      {
        parama = parama.getRlLayout();
        if (parama != null) {
          RefreshLoadMoreLayout.e(parama);
        }
      }
    }
    this.ljV = true;
    AppMethodBeat.o(290630);
  }
  
  public f dtg()
  {
    AppMethodBeat.i(290639);
    f localf = (f)new b(this);
    AppMethodBeat.o(290639);
    return localf;
  }
  
  public final int dth()
  {
    return this.jlf;
  }
  
  public final void dti()
  {
    AppMethodBeat.i(290635);
    Object localObject2;
    if (this.jlf <= 0)
    {
      localObject1 = this.xyX;
      if (localObject1 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject1).ejD();
        if (localObject2 != null)
        {
          localObject1 = getResources();
          if (localObject1 != null) {}
          for (localObject1 = ((Resources)localObject1).getString(b.j.finder_like_title);; localObject1 = null)
          {
            ((TextView)localObject2).setText((CharSequence)localObject1);
            AppMethodBeat.o(290635);
            return;
          }
        }
      }
      AppMethodBeat.o(290635);
      return;
    }
    Object localObject1 = g.AnT;
    localObject1 = this.xwF;
    if (localObject1 == null) {
      p.bGy("feedObj");
    }
    localObject1 = g.Qt(((FinderItem)localObject1).getFeedObject().objectType);
    int i;
    if (localObject1 != null)
    {
      localObject2 = (CharSequence)((bfz)localObject1).SQG;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
      {
        i = 1;
        if (i == 0) {
          break label219;
        }
      }
    }
    else
    {
      localObject1 = this.xyX;
      if (localObject1 == null) {
        break label214;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject1).getContext();
      if (localObject1 == null) {
        break label214;
      }
      localObject1 = ((Context)localObject1).getString(b.j.finder_like_title_count_tip, new Object[] { m.QG(this.jlf) });
    }
    for (;;)
    {
      localObject2 = this.xyX;
      if (localObject2 == null) {
        break label247;
      }
      localObject2 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject2).ejD();
      if (localObject2 == null) {
        break label247;
      }
      ((TextView)localObject2).setText((CharSequence)localObject1);
      AppMethodBeat.o(290635);
      return;
      i = 0;
      break;
      label214:
      localObject1 = null;
      continue;
      label219:
      localObject1 = m.QG(this.jlf) + ((bfz)localObject1).SQG;
    }
    label247:
    AppMethodBeat.o(290635);
  }
  
  public RecyclerView.LayoutManager eW(Context paramContext)
  {
    AppMethodBeat.i(290642);
    p.k(paramContext, "context");
    paramContext = (RecyclerView.LayoutManager)new LinearLayoutManager(1, false);
    AppMethodBeat.o(290642);
    return paramContext;
  }
  
  public void ev(View paramView)
  {
    AppMethodBeat.i(290643);
    p.k(paramView, "view");
    AppMethodBeat.o(290643);
  }
  
  public RecyclerView.h fn(Context paramContext)
  {
    AppMethodBeat.i(290640);
    p.k(paramContext, "context");
    paramContext = (RecyclerView.h)new x.c();
    AppMethodBeat.o(290640);
    return paramContext;
  }
  
  public WxRecyclerAdapter<?> fs(Context paramContext)
  {
    AppMethodBeat.i(290634);
    p.k(paramContext, "context");
    paramContext = new WxRecyclerAdapter(dtg(), this.data, true);
    paramContext.aw(false);
    paramContext.YSn = ((h.c)this);
    paramContext.YSm = ((h.d)this);
    AppMethodBeat.o(290634);
    return paramContext;
  }
  
  public final FinderItem getFeedObj()
  {
    AppMethodBeat.i(290626);
    FinderItem localFinderItem = this.xwF;
    if (localFinderItem == null) {
      p.bGy("feedObj");
    }
    AppMethodBeat.o(290626);
    return localFinderItem;
  }
  
  public int getScene()
  {
    AppMethodBeat.i(290641);
    FinderLikeDrawer.a locala = FinderLikeDrawer.AYs;
    int i = FinderLikeDrawer.eiP();
    AppMethodBeat.o(290641);
    return i;
  }
  
  public final boolean isAttached()
  {
    return this.ljV;
  }
  
  public void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(290638);
    this.xvE.add(parama);
    AppMethodBeat.o(290638);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(290631);
    if (!this.ljV)
    {
      Log.i("Finder.DrawerPresenter", "onDetach: cannot detach when have not attached");
      AppMethodBeat.o(290631);
      return;
    }
    this.ljV = false;
    Object localObject = this.xeM;
    if (localObject != null) {
      ((com.tencent.mm.loader.g.i)localObject).stop();
    }
    this.xeM = null;
    localObject = ((Iterable)this.xvE).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.vending.e.a)((Iterator)localObject).next()).dead();
    }
    this.xvE.clear();
    this.data.clear();
    this.lastBuffer = null;
    this.xwK = false;
    Log.i("Finder.DrawerPresenter", "set upContinue false");
    or(true);
    localObject = this.xyX;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.a)localObject).getRlLayout();
      if (localObject != null) {
        ((RefreshLoadMoreLayout)localObject).setHasBottomMore(true);
      }
    }
    localObject = this.xyX;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.a)localObject).getRlLayout();
      if (localObject != null)
      {
        localObject = ((RefreshLoadMoreLayout)localObject).getRecyclerView();
        if (localObject != null)
        {
          localObject = ((RecyclerView)localObject).getAdapter();
          if (localObject != null) {
            ((RecyclerView.a)localObject).notifyDataSetChanged();
          }
        }
      }
    }
    localObject = this.xyX;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.a)localObject).getRlLayout();
      if (localObject != null)
      {
        localObject = ((RefreshLoadMoreLayout)localObject).getRecyclerView();
        if (localObject != null) {
          ((RecyclerView)localObject).setLayoutFrozen(true);
        }
      }
    }
    localObject = this.xyX;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.a)localObject).getRlLayout();
      if (localObject != null) {
        ((RefreshLoadMoreLayout)localObject).setActionCallback(null);
      }
    }
    this.xyX = null;
    AppMethodBeat.o(290631);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class b
    implements f
  {
    public final e<?> yx(int paramInt)
    {
      AppMethodBeat.i(279085);
      e locale = (e)new com.tencent.mm.plugin.finder.convert.x(x.f(this.xzc), (kotlin.g.a.a)new a(this), (kotlin.g.a.b)new b(this), (kotlin.g.a.a)new c(this));
      AppMethodBeat.o(279085);
      return locale;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<Boolean>
    {
      a(x.b paramb)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "like", "", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.b<Boolean, kotlin.x>
    {
      b(x.b paramb)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class c
      extends q
      implements kotlin.g.a.a<kotlin.x>
    {
      c(x.b paramb)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$likeDataObserver$1", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeRemoved", "plugin-finder_release"})
  public static final class d
    extends RecyclerView.c
  {
    @SuppressLint({"StringFormatMatches"})
    public final void onChanged()
    {
      AppMethodBeat.i(278780);
      super.onChanged();
      this.xzc.dti();
      AppMethodBeat.o(278780);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(278782);
      super.onItemRangeChanged(paramInt1, paramInt2);
      this.xzc.dti();
      AppMethodBeat.o(278782);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(278783);
      super.onItemRangeChanged(paramInt1, paramInt2, paramObject);
      this.xzc.dti();
      AppMethodBeat.o(278783);
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(278781);
      super.onItemRangeInserted(paramInt1, paramInt2);
      this.xzc.dti();
      AppMethodBeat.o(278781);
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(278784);
      super.onItemRangeRemoved(paramInt1, paramInt2);
      this.xzc.dti();
      AppMethodBeat.o(278784);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b<com.tencent.mm.loader.g.h, kotlin.x>
  {
    e(x paramx)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
  public static final class f
    extends RefreshLoadMoreLayout.a
  {
    public final void Ie(int paramInt)
    {
      AppMethodBeat.i(237855);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aFi());
      super.Ie(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(237855);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(237853);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      p.k(paramc, "reason");
      super.a(paramc);
      x.c(this.xzc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(237853);
    }
    
    public final void cKQ()
    {
      AppMethodBeat.i(237851);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.cKQ();
      com.tencent.e.h.ZvG.be((Runnable)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(237851);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(237857);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      super.onRefreshEnd(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(237857);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(x.f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(286484);
        x.b(this.xzf.xzc);
        AppMethodBeat.o(286484);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.b<com.tencent.mm.loader.g.h, kotlin.x>
  {
    g(x paramx, boolean paramBoolean, kotlin.g.a.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.x
 * JD-Core Version:    0.7.0.1
 */