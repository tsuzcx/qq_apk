package com.tencent.mm.plugin.finder.feed;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.convert.w;
import com.tencent.mm.plugin.finder.model.v;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.g;
import com.tencent.mm.plugin.finder.utils.k;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aul;
import com.tencent.mm.protocal.protobuf.azu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g.c;
import com.tencent.mm.view.recyclerview.g.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter;", "Lcom/tencent/mm/plugin/finder/feed/IDrawerPresenter;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "()V", "commentCount", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLike;", "Lkotlin/collections/ArrayList;", "getData", "()Ljava/util/ArrayList;", "value", "", "downContinue", "setDownContinue", "(Z)V", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeedObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeedObj", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "forceShowLikeEdu", "getForceShowLikeEdu", "()Z", "setForceShowLikeEdu", "inMsgUI", "getInMsgUI", "setInMsgUI", "isAttached", "setAttached", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "likeBuffer", "getLikeBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLikeBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "likeDataObserver", "com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$likeDataObserver$1", "Lcom/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$likeDataObserver$1;", "resources", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "selfUsername", "", "kotlin.jvm.PlatformType", "getSelfUsername", "()Ljava/lang/String;", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "getTaskExecutor", "()Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "setTaskExecutor", "(Lcom/tencent/mm/loader/loader/SingleTaskExecutor;)V", "totalCount", "upContinue", "setUpContinue", "viewCallback", "Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;)V", "canShowLikeEdu", "checkDownContinue", "", "checkUpContinue", "doExtraOnBuildDrawerBody", "view", "Landroid/view/View;", "doExtraTitleChange", "context", "Landroid/content/Context;", "headerLayout", "Landroid/widget/FrameLayout;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "getScene", "getTotalItemCount", "keep", "p0", "loadMoreData", "onAttach", "builder", "onDetach", "onItemClick", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "position", "holder", "onItemLongClick", "refreshData", "down", "extra", "Lkotlin/Function1;", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "setLikeCountView", "Companion", "SpaceItemDecoration", "plugin-finder_release"})
public class t
  implements aw, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>, g.c<com.tencent.mm.view.recyclerview.h>, g.d<com.tencent.mm.view.recyclerview.h>
{
  public static final a tOB;
  final ArrayList<v> data;
  private int gAZ;
  boolean iuM;
  private volatile com.tencent.mm.bw.b lastBuffer;
  com.tencent.mm.bw.b likeBuffer;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> tLP;
  public FinderItem tMO;
  private boolean tMT;
  private boolean tMU;
  private com.tencent.mm.loader.g.i tMX;
  private final d tOA;
  final String tOw;
  com.tencent.mm.plugin.finder.view.builder.a tOx;
  public boolean tOy;
  public boolean tOz;
  
  static
  {
    AppMethodBeat.i(243964);
    tOB = new a((byte)0);
    AppMethodBeat.o(243964);
  }
  
  public t()
  {
    AppMethodBeat.i(243963);
    this.data = new ArrayList();
    this.tOw = z.aTY();
    this.tMU = true;
    this.tLP = new CopyOnWriteArraySet();
    this.tOA = new d(this);
    AppMethodBeat.o(243963);
  }
  
  private final Resources getResources()
  {
    AppMethodBeat.i(243946);
    Object localObject = this.tOx;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.a)localObject).getContext();
      if (localObject != null)
      {
        localObject = ((Context)localObject).getResources();
        AppMethodBeat.o(243946);
        return localObject;
      }
    }
    AppMethodBeat.o(243946);
    return null;
  }
  
  private final void mX(boolean paramBoolean)
  {
    AppMethodBeat.i(243947);
    this.tMU = paramBoolean;
    Log.i("Finder.DrawerPresenter", "set downContinue ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(243947);
  }
  
  public final void A(final kotlin.g.a.b<? super LinkedList<aul>, ? extends LinkedList<aul>> paramb)
  {
    AppMethodBeat.i(243950);
    com.tencent.mm.loader.g.i locali = this.tMX;
    if (locali != null)
    {
      locali.a(new com.tencent.mm.loader.g.h((kotlin.g.a.b)new g(this, true, paramb)));
      AppMethodBeat.o(243950);
      return;
    }
    AppMethodBeat.o(243950);
  }
  
  public void a(Context paramContext, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(243962);
    p.h(paramContext, "context");
    p.h(paramFrameLayout, "headerLayout");
    AppMethodBeat.o(243962);
  }
  
  public void a(com.tencent.mm.plugin.finder.view.builder.a parama, FinderItem paramFinderItem, com.tencent.mm.bw.b paramb)
  {
    AppMethodBeat.i(243948);
    p.h(parama, "builder");
    p.h(paramFinderItem, "feedObj");
    this.tMO = paramFinderItem;
    this.likeBuffer = paramb;
    this.tMX = new com.tencent.mm.loader.g.i("FinderLikeExecutor");
    this.tOx = parama;
    Log.i("Finder.DrawerPresenter", "onAttach " + paramFinderItem.getId());
    paramFinderItem = this.tMX;
    if (paramFinderItem != null) {
      paramFinderItem.start();
    }
    dcM();
    this.data.clear();
    try
    {
      paramFinderItem = parama.getRlLayout().getRecyclerView().getAdapter();
      if (paramFinderItem != null) {
        paramFinderItem.a((RecyclerView.c)this.tOA);
      }
    }
    catch (IllegalStateException paramFinderItem)
    {
      for (;;)
      {
        Log.printErrStackTrace("Finder.DrawerPresenter", (Throwable)paramFinderItem, "", new Object[0]);
      }
    }
    parama.dHt();
    paramFinderItem = this.tOx;
    if (paramFinderItem != null)
    {
      paramFinderItem = paramFinderItem.dcn();
      if (paramFinderItem != null) {
        paramFinderItem.hge();
      }
    }
    parama.getRlLayout().getRecyclerView().setLayoutFrozen(false);
    parama.getRlLayout().setActionCallback((RefreshLoadMoreLayout.a)new f(this));
    parama = this.tOx;
    if (parama != null) {
      parama.hideLoading();
    }
    parama = this.tOx;
    if (parama != null) {
      parama.showLoading();
    }
    A(null);
    if (!this.tMU)
    {
      parama = this.tOx;
      if (parama != null)
      {
        parama = parama.getRlLayout();
        if (parama != null) {
          RefreshLoadMoreLayout.e(parama);
        }
      }
    }
    this.iuM = true;
    AppMethodBeat.o(243948);
  }
  
  public void dV(View paramView)
  {
    AppMethodBeat.i(243961);
    p.h(paramView, "view");
    AppMethodBeat.o(243961);
  }
  
  public f dcK()
  {
    AppMethodBeat.i(243957);
    f localf = (f)new b(this);
    AppMethodBeat.o(243957);
    return localf;
  }
  
  public final int dcL()
  {
    return this.gAZ;
  }
  
  public final void dcM()
  {
    AppMethodBeat.i(243953);
    Object localObject2;
    if (this.gAZ <= 0)
    {
      localObject1 = this.tOx;
      if (localObject1 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject1).dHs();
        if (localObject2 != null)
        {
          localObject1 = getResources();
          if (localObject1 != null) {}
          for (localObject1 = ((Resources)localObject1).getString(2131759844);; localObject1 = null)
          {
            ((TextView)localObject2).setText((CharSequence)localObject1);
            AppMethodBeat.o(243953);
            return;
          }
        }
      }
      AppMethodBeat.o(243953);
      return;
    }
    Object localObject1 = g.vGW;
    localObject1 = this.tMO;
    if (localObject1 == null) {
      p.btv("feedObj");
    }
    localObject1 = g.Lj(((FinderItem)localObject1).getFeedObject().objectType);
    int i;
    if (localObject1 != null)
    {
      localObject2 = (CharSequence)((azu)localObject1).LJA;
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
      localObject1 = this.tOx;
      if (localObject1 == null) {
        break label214;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject1).getContext();
      if (localObject1 == null) {
        break label214;
      }
      localObject1 = ((Context)localObject1).getString(2131759845, new Object[] { k.Lw(this.gAZ) });
    }
    for (;;)
    {
      localObject2 = this.tOx;
      if (localObject2 == null) {
        break label247;
      }
      localObject2 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject2).dHs();
      if (localObject2 == null) {
        break label247;
      }
      ((TextView)localObject2).setText((CharSequence)localObject1);
      AppMethodBeat.o(243953);
      return;
      i = 0;
      break;
      label214:
      localObject1 = null;
      continue;
      label219:
      localObject1 = k.Lw(this.gAZ) + ((azu)localObject1).LJA;
    }
    label247:
    AppMethodBeat.o(243953);
  }
  
  public RecyclerView.LayoutManager eS(Context paramContext)
  {
    AppMethodBeat.i(243960);
    p.h(paramContext, "context");
    paramContext = (RecyclerView.LayoutManager)new LinearLayoutManager(1, false);
    AppMethodBeat.o(243960);
    return paramContext;
  }
  
  public RecyclerView.h fi(Context paramContext)
  {
    AppMethodBeat.i(243958);
    p.h(paramContext, "context");
    paramContext = (RecyclerView.h)new c();
    AppMethodBeat.o(243958);
    return paramContext;
  }
  
  public WxRecyclerAdapter<?> fm(Context paramContext)
  {
    AppMethodBeat.i(243952);
    p.h(paramContext, "context");
    paramContext = new WxRecyclerAdapter(dcK(), this.data, true);
    paramContext.au(false);
    paramContext.RqP = ((g.c)this);
    paramContext.RqO = ((g.d)this);
    AppMethodBeat.o(243952);
    return paramContext;
  }
  
  public final FinderItem getFeedObj()
  {
    AppMethodBeat.i(243945);
    FinderItem localFinderItem = this.tMO;
    if (localFinderItem == null) {
      p.btv("feedObj");
    }
    AppMethodBeat.o(243945);
    return localFinderItem;
  }
  
  public int getScene()
  {
    AppMethodBeat.i(243959);
    FinderLikeDrawer.a locala = FinderLikeDrawer.wnm;
    int i = FinderLikeDrawer.dGQ();
    AppMethodBeat.o(243959);
    return i;
  }
  
  public void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(243956);
    this.tLP.add(parama);
    AppMethodBeat.o(243956);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(243949);
    if (!this.iuM)
    {
      Log.i("Finder.DrawerPresenter", "onDetach: cannot detach when have not attached");
      AppMethodBeat.o(243949);
      return;
    }
    this.iuM = false;
    Object localObject = this.tMX;
    if (localObject != null) {
      ((com.tencent.mm.loader.g.i)localObject).stop();
    }
    this.tMX = null;
    localObject = ((Iterable)this.tLP).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.vending.e.a)((Iterator)localObject).next()).dead();
    }
    this.tLP.clear();
    this.data.clear();
    this.lastBuffer = null;
    this.tMT = false;
    Log.i("Finder.DrawerPresenter", "set upContinue false");
    mX(true);
    localObject = this.tOx;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.a)localObject).getRlLayout();
      if (localObject != null) {
        ((RefreshLoadMoreLayout)localObject).setHasBottomMore(true);
      }
    }
    localObject = this.tOx;
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
    localObject = this.tOx;
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
    localObject = this.tOx;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.a)localObject).getRlLayout();
      if (localObject != null) {
        ((RefreshLoadMoreLayout)localObject).setActionCallback(null);
      }
    }
    this.tOx = null;
    AppMethodBeat.o(243949);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class b
    implements f
  {
    public final e<?> EC(int paramInt)
    {
      AppMethodBeat.i(243926);
      e locale = (e)new w(t.f(this.tOC), (kotlin.g.a.a)new a(this), (kotlin.g.a.b)new b(this), (kotlin.g.a.a)new c(this));
      AppMethodBeat.o(243926);
      return locale;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<Boolean>
    {
      a(t.b paramb)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "like", "", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.b<Boolean, x>
    {
      b(t.b paramb)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class c
      extends q
      implements kotlin.g.a.a<x>
    {
      c(t.b paramb)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$getItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(243927);
      p.h(paramRect, "outRect");
      p.h(paramView, "view");
      p.h(paramRecyclerView, "parent");
      p.h(params, "state");
      paramRect.set(0, 0, 0, 0);
      AppMethodBeat.o(243927);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$likeDataObserver$1", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeRemoved", "plugin-finder_release"})
  public static final class d
    extends RecyclerView.c
  {
    @SuppressLint({"StringFormatMatches"})
    public final void onChanged()
    {
      AppMethodBeat.i(243928);
      super.onChanged();
      this.tOC.dcM();
      AppMethodBeat.o(243928);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(243930);
      super.onItemRangeChanged(paramInt1, paramInt2);
      this.tOC.dcM();
      AppMethodBeat.o(243930);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(243931);
      super.onItemRangeChanged(paramInt1, paramInt2, paramObject);
      this.tOC.dcM();
      AppMethodBeat.o(243931);
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(243929);
      super.onItemRangeInserted(paramInt1, paramInt2);
      this.tOC.dcM();
      AppMethodBeat.o(243929);
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(243932);
      super.onItemRangeRemoved(paramInt1, paramInt2);
      this.tOC.dcM();
      AppMethodBeat.o(243932);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b<com.tencent.mm.loader.g.h, x>
  {
    e(t paramt)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
  public static final class f
    extends RefreshLoadMoreLayout.a
  {
    public final void ED(int paramInt)
    {
      AppMethodBeat.i(243939);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.axR());
      super.ED(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(243939);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(243938);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      p.h(paramc, "reason");
      super.a(paramc);
      t.c(this.tOC);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(243938);
    }
    
    public final void cxo()
    {
      AppMethodBeat.i(243937);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.cxo();
      com.tencent.f.h.RTc.aX((Runnable)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(243937);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(243940);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      super.onRefreshEnd(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(243940);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(t.f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(243936);
        t.b(this.tOF.tOC);
        AppMethodBeat.o(243936);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.b<com.tencent.mm.loader.g.h, x>
  {
    g(t paramt, boolean paramBoolean, kotlin.g.a.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.t
 * JD-Core Version:    0.7.0.1
 */