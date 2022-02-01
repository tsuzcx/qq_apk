package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.c;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.convert.v;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.model.cg;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.ar;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ayv;
import com.tencent.mm.protocal.protobuf.bco;
import com.tencent.mm.protocal.protobuf.brk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.i.d;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter;", "Lcom/tencent/mm/plugin/finder/feed/IDrawerPresenter;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "()V", "commentCount", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLike;", "Lkotlin/collections/ArrayList;", "getData", "()Ljava/util/ArrayList;", "value", "", "downContinue", "setDownContinue", "(Z)V", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeedObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeedObj", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "forceShowLikeEdu", "getForceShowLikeEdu", "()Z", "setForceShowLikeEdu", "inMsgUI", "getInMsgUI", "setInMsgUI", "isAttached", "setAttached", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "likeBuffer", "getLikeBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLikeBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "likeDataObserver", "com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$likeDataObserver$1", "Lcom/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$likeDataObserver$1;", "resources", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "selfUsername", "", "kotlin.jvm.PlatformType", "getSelfUsername", "()Ljava/lang/String;", "syncGetImageModel", "Lcom/tencent/mm/plugin/finder/model/SyncGetImageModel;", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "getTaskExecutor", "()Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "setTaskExecutor", "(Lcom/tencent/mm/loader/loader/SingleTaskExecutor;)V", "totalCount", "upContinue", "setUpContinue", "viewCallback", "Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;)V", "canShowLikeEdu", "checkDownContinue", "", "checkUpContinue", "doExtraOnBuildDrawerBody", "view", "Landroid/view/View;", "doExtraTitleChange", "context", "Landroid/content/Context;", "headerLayout", "Landroid/widget/FrameLayout;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getScene", "getTotalItemCount", "isNewsObject", "item", "keep", "p0", "loadMoreData", "onAttach", "builder", "onDetach", "onItemClick", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "position", "holder", "onItemLongClick", "refreshData", "down", "extra", "Lkotlin/Function1;", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "setLikeCountView", "Companion", "SpaceItemDecoration", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class y
  implements bj, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>, i.c<j>, i.d<j>
{
  public static final a AWj;
  private com.tencent.mm.loader.f.h ADY;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> ATq;
  public FinderItem AUj;
  private boolean AUo;
  private boolean AUp;
  final String AWk;
  com.tencent.mm.plugin.finder.view.builder.a AWl;
  private final cg AWm;
  public boolean AWn;
  public boolean AWo;
  private final d AWp;
  final ArrayList<w> data;
  private int lNX;
  private volatile com.tencent.mm.bx.b lastBuffer;
  com.tencent.mm.bx.b likeBuffer;
  private boolean nOG;
  
  static
  {
    AppMethodBeat.i(362743);
    AWj = new a((byte)0);
    AppMethodBeat.o(362743);
  }
  
  public y()
  {
    AppMethodBeat.i(362641);
    this.data = new ArrayList();
    this.AWk = z.bAM();
    this.AUp = true;
    this.AWm = new cg();
    this.ATq = new CopyOnWriteArraySet();
    this.AWp = new d(this);
    AppMethodBeat.o(362641);
  }
  
  private static boolean b(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(362666);
    if (paramFinderItem.getFeedObject().objectType == 1)
    {
      AppMethodBeat.o(362666);
      return true;
    }
    AppMethodBeat.o(362666);
    return false;
  }
  
  private final Resources getResources()
  {
    AppMethodBeat.i(362648);
    Object localObject = this.AWl;
    if (localObject == null)
    {
      AppMethodBeat.o(362648);
      return null;
    }
    localObject = ((com.tencent.mm.plugin.finder.view.builder.a)localObject).getContext();
    if (localObject == null)
    {
      AppMethodBeat.o(362648);
      return null;
    }
    localObject = ((Context)localObject).getResources();
    AppMethodBeat.o(362648);
    return localObject;
  }
  
  private final void pT(boolean paramBoolean)
  {
    AppMethodBeat.i(362653);
    this.AUp = paramBoolean;
    Log.i("Finder.DrawerPresenter", s.X("set downContinue ", Boolean.valueOf(paramBoolean)));
    AppMethodBeat.o(362653);
  }
  
  public void a(Context paramContext, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(362843);
    s.u(paramContext, "context");
    s.u(paramFrameLayout, "headerLayout");
    AppMethodBeat.o(362843);
  }
  
  public void a(com.tencent.mm.plugin.finder.view.builder.a parama, FinderItem paramFinderItem, com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(362763);
    s.u(parama, "builder");
    s.u(paramFinderItem, "feedObj");
    s.u(paramFinderItem, "<set-?>");
    this.AUj = paramFinderItem;
    this.likeBuffer = paramb;
    this.ADY = new com.tencent.mm.loader.f.h("FinderLikeExecutor");
    this.AWl = parama;
    Log.i("Finder.DrawerPresenter", s.X("onAttach ", Long.valueOf(paramFinderItem.getId())));
    paramFinderItem = this.ADY;
    if (paramFinderItem != null) {
      paramFinderItem.start();
    }
    ecj();
    this.data.clear();
    try
    {
      paramFinderItem = parama.getRlLayout().getRecyclerView().getAdapter();
      if (paramFinderItem != null) {
        paramFinderItem.a((RecyclerView.c)this.AWp);
      }
    }
    catch (IllegalStateException paramFinderItem)
    {
      for (;;)
      {
        Log.printErrStackTrace("Finder.DrawerPresenter", (Throwable)paramFinderItem, "", new Object[0]);
      }
    }
    parama.flP();
    paramFinderItem = this.AWl;
    if (paramFinderItem != null)
    {
      paramFinderItem = paramFinderItem.ebI();
      if (paramFinderItem != null) {
        paramFinderItem.jMR();
      }
    }
    parama.getRlLayout().getRecyclerView().setLayoutFrozen(false);
    parama.getRlLayout().setActionCallback((RefreshLoadMoreLayout.b)new f(this));
    parama = this.AWl;
    if (parama != null) {
      parama.hideLoading();
    }
    parama = this.AWl;
    if (parama != null) {
      parama.showLoading();
    }
    ai(null);
    if (!this.AUp)
    {
      parama = this.AWl;
      if (parama != null)
      {
        parama = parama.getRlLayout();
        if (parama != null) {
          RefreshLoadMoreLayout.e(parama);
        }
      }
    }
    this.nOG = true;
    AppMethodBeat.o(362763);
  }
  
  public final void ai(final kotlin.g.a.b<? super LinkedList<bco>, ? extends LinkedList<bco>> paramb)
  {
    AppMethodBeat.i(362781);
    com.tencent.mm.loader.f.h localh = this.ADY;
    if (localh != null) {
      localh.a(new com.tencent.mm.loader.f.g((kotlin.g.a.b)new g(true, this, paramb)));
    }
    AppMethodBeat.o(362781);
  }
  
  public com.tencent.mm.view.recyclerview.g ech()
  {
    AppMethodBeat.i(362809);
    com.tencent.mm.view.recyclerview.g localg = (com.tencent.mm.view.recyclerview.g)new b(this);
    AppMethodBeat.o(362809);
    return localg;
  }
  
  public final int eci()
  {
    return this.lNX;
  }
  
  public final void ecj()
  {
    cg localcg = null;
    AppMethodBeat.i(362798);
    Object localObject1;
    Object localObject2;
    if (this.lNX <= 0)
    {
      localObject1 = this.AWl;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 == null) {
          break label514;
        }
        localObject2 = getResources();
        if (localObject2 != null) {
          break label69;
        }
      }
      label69:
      for (localObject2 = null;; localObject2 = ((Resources)localObject2).getString(e.h.finder_like_title))
      {
        ((TextView)localObject1).setText((CharSequence)localObject2);
        AppMethodBeat.o(362798);
        return;
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject1).fdt();
        break;
      }
    }
    else
    {
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.h.FNM;
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.h.TA(getFeedObj().getFeedObject().objectType);
      boolean bool = cg.a((brk)localObject1);
      int i;
      if (localObject1 != null)
      {
        localObject2 = (CharSequence)((brk)localObject1).ZZt;
        if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
        {
          i = 1;
          if ((i == 0) || (bool)) {
            break label416;
          }
        }
      }
      else
      {
        if (!b(getFeedObj())) {
          break label349;
        }
        localObject1 = this.AWl;
        if (localObject1 != null) {
          break label233;
        }
        localObject1 = null;
        label164:
        localObject2 = this.AWl;
        if (localObject2 != null) {
          break label272;
        }
        localObject1 = "";
        label179:
        localObject2 = (CharSequence)localObject1;
        Log.i("Finder.DrawerPresenter", s.X("no config text:", localObject2));
        localObject1 = this.AWl;
        if (localObject1 != null) {
          break label408;
        }
        localObject1 = localcg;
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          ((TextView)localObject1).setText((CharSequence)localObject2);
          AppMethodBeat.o(362798);
          return;
          i = 0;
          break;
          label233:
          localObject1 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject1).getContext();
          if (localObject1 == null)
          {
            localObject1 = null;
            break label164;
          }
          localObject1 = ((Context)localObject1).getString(e.h.finder_like_title_count_tip, new Object[] { com.tencent.mm.plugin.finder.utils.r.TQ(this.lNX) });
          break label164;
          label272:
          Context localContext = ((com.tencent.mm.plugin.finder.view.builder.a)localObject2).getContext();
          if (localContext == null)
          {
            localObject1 = "";
            break label179;
          }
          localObject2 = ar.Giw;
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = "";
          }
          localObject2 = ar.a(0, (String)localObject2, localContext, true, localContext.getResources().getColor(e.b.FG_0), 0, false, 96);
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label179;
          }
          localObject1 = "";
          break label179;
          label349:
          localObject1 = this.AWl;
          if (localObject1 == null)
          {
            localObject1 = null;
            break label179;
          }
          localObject1 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject1).getContext();
          if (localObject1 == null)
          {
            localObject1 = null;
            break label179;
          }
          localObject1 = ((Context)localObject1).getString(e.h.finder_liked_ui_title, new Object[] { Integer.valueOf(Util.safeParseInt(com.tencent.mm.plugin.finder.utils.r.TQ(this.lNX))) });
          break label179;
          label408:
          localObject1 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject1).fdt();
          continue;
          label416:
          localObject2 = this.AWl;
          if (localObject2 != null)
          {
            localObject2 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject2).fdt();
            if (localObject2 != null)
            {
              localcg = this.AWm;
              localContext = ((TextView)localObject2).getContext();
              s.s(localContext, "context");
              String str = com.tencent.mm.plugin.finder.utils.r.TQ(this.lNX);
              s.s(str, "formatPosterNumber(totalCount)");
              cg.a(localcg, (TextView)localObject2, localContext, str, this.lNX, b(getFeedObj()), (brk)localObject1, ((TextView)localObject2).getContext().getResources().getColor(e.b.FG_0));
            }
          }
        }
      }
    }
    label514:
    AppMethodBeat.o(362798);
  }
  
  public RecyclerView.LayoutManager fT(Context paramContext)
  {
    AppMethodBeat.i(362831);
    s.u(paramContext, "context");
    paramContext = (RecyclerView.LayoutManager)new LinearLayoutManager(1, false);
    AppMethodBeat.o(362831);
    return paramContext;
  }
  
  public void fx(View paramView)
  {
    AppMethodBeat.i(362837);
    s.u(paramView, "view");
    AppMethodBeat.o(362837);
  }
  
  public final FinderItem getFeedObj()
  {
    AppMethodBeat.i(362747);
    FinderItem localFinderItem = this.AUj;
    if (localFinderItem != null)
    {
      AppMethodBeat.o(362747);
      return localFinderItem;
    }
    s.bIx("feedObj");
    AppMethodBeat.o(362747);
    return null;
  }
  
  public int getScene()
  {
    AppMethodBeat.i(362825);
    FinderLikeDrawer.a locala = FinderLikeDrawer.GAf;
    int i = FinderLikeDrawer.fkN();
    AppMethodBeat.o(362825);
    return i;
  }
  
  public RecyclerView.h gl(Context paramContext)
  {
    AppMethodBeat.i(362817);
    s.u(paramContext, "context");
    paramContext = (RecyclerView.h)new c();
    AppMethodBeat.o(362817);
    return paramContext;
  }
  
  public WxRecyclerAdapter<?> gr(Context paramContext)
  {
    AppMethodBeat.i(362789);
    s.u(paramContext, "context");
    paramContext = new WxRecyclerAdapter(ech(), this.data, true);
    paramContext.bf(false);
    paramContext.agOe = ((i.c)this);
    paramContext.agOd = ((i.d)this);
    AppMethodBeat.o(362789);
    return paramContext;
  }
  
  public final boolean isAttached()
  {
    return this.nOG;
  }
  
  public void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(362802);
    this.ATq.add(parama);
    AppMethodBeat.o(362802);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(362773);
    if (!this.nOG)
    {
      Log.i("Finder.DrawerPresenter", "onDetach: cannot detach when have not attached");
      AppMethodBeat.o(362773);
      return;
    }
    this.nOG = false;
    Object localObject = this.ADY;
    if (localObject != null) {
      ((com.tencent.mm.loader.f.h)localObject).stop();
    }
    this.ADY = null;
    localObject = ((Iterable)this.ATq).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.vending.e.a)((Iterator)localObject).next()).dead();
    }
    this.ATq.clear();
    this.data.clear();
    this.lastBuffer = null;
    this.AUo = false;
    Log.i("Finder.DrawerPresenter", s.X("set upContinue ", Boolean.FALSE));
    pT(true);
    localObject = this.AWl;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        ((RefreshLoadMoreLayout)localObject).setHasBottomMore(true);
      }
      localObject = this.AWl;
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
              ((RecyclerView.a)localObject).bZE.notifyChanged();
            }
          }
        }
      }
      localObject = this.AWl;
      if (localObject != null) {
        break label258;
      }
      localObject = null;
      label209:
      if (localObject != null) {
        ((RecyclerView)localObject).setLayoutFrozen(true);
      }
      localObject = this.AWl;
      if (localObject != null) {
        break label280;
      }
    }
    label258:
    label280:
    for (localObject = null;; localObject = ((com.tencent.mm.plugin.finder.view.builder.a)localObject).getRlLayout())
    {
      if (localObject != null) {
        ((RefreshLoadMoreLayout)localObject).setActionCallback(null);
      }
      this.AWl = null;
      AppMethodBeat.o(362773);
      return;
      localObject = ((com.tencent.mm.plugin.finder.view.builder.a)localObject).getRlLayout();
      break;
      localObject = ((com.tencent.mm.plugin.finder.view.builder.a)localObject).getRlLayout();
      if (localObject == null)
      {
        localObject = null;
        break label209;
      }
      localObject = ((RefreshLoadMoreLayout)localObject).getRecyclerView();
      break label209;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.view.recyclerview.g
  {
    b(y paramy) {}
    
    public final f<?> yF(int paramInt)
    {
      AppMethodBeat.i(363492);
      f localf = (f)new v(y.e(this.AWq), (kotlin.g.a.a)new a(this.AWq), (kotlin.g.a.b)new b(this.AWq), (kotlin.g.a.a)new c(this.AWq));
      AppMethodBeat.o(363492);
      return localf;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<Boolean>
    {
      a(y paramy)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "like", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.b<Boolean, ah>
    {
      b(y paramy)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends u
      implements kotlin.g.a.a<ah>
    {
      c(y paramy)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$getItemDecoration$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(363490);
      s.u(paramRect, "outRect");
      s.u(paramView, "view");
      s.u(paramRecyclerView, "parent");
      s.u(params, "state");
      paramRect.set(0, 0, 0, 0);
      AppMethodBeat.o(363490);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$likeDataObserver$1", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeRemoved", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends RecyclerView.c
  {
    d(y paramy) {}
    
    public final void onChanged()
    {
      AppMethodBeat.i(363524);
      super.onChanged();
      this.AWq.ecj();
      AppMethodBeat.o(363524);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(363537);
      super.onItemRangeChanged(paramInt1, paramInt2);
      this.AWq.ecj();
      AppMethodBeat.o(363537);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(363544);
      super.onItemRangeChanged(paramInt1, paramInt2, paramObject);
      this.AWq.ecj();
      AppMethodBeat.o(363544);
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(363531);
      super.onItemRangeInserted(paramInt1, paramInt2);
      this.AWq.ecj();
      AppMethodBeat.o(363531);
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(363553);
      super.onItemRangeRemoved(paramInt1, paramInt2);
      this.AWq.ecj();
      AppMethodBeat.o(363553);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<com.tencent.mm.loader.f.g, ah>
  {
    e(y paramy)
    {
      super();
    }
    
    private static final List a(y paramy, b.a parama)
    {
      AppMethodBeat.i(363532);
      s.u(paramy, "this$0");
      if (parama == null)
      {
        Log.e("Finder.DrawerPresenter", "loadMoreData resp null");
        paramy = (List)new LinkedList();
        AppMethodBeat.o(363532);
        return paramy;
      }
      if ((parama.errType == 0) && (parama.errCode == 0) && (parama.ott != null))
      {
        boolean bool;
        Object localObject1;
        int i;
        if (((ayv)parama.ott).continueFlag == 1)
        {
          bool = true;
          y.a(paramy, bool);
          y.a(paramy, ((ayv)parama.ott).lastBuffer);
          if (y.d(paramy) != null) {
            break label246;
          }
          localObject1 = "null";
          Log.i("Finder.DrawerPresenter", s.X("loadMoreData after lastBuffer ", localObject1));
          if (!y.e(paramy)) {
            break label297;
          }
          i = paramy.getScene();
          localObject1 = FinderLikeDrawer.GAf;
          if (i != FinderLikeDrawer.fkN()) {
            break label297;
          }
          parama = ((ayv)parama.ott).likeList;
          s.s(parama, "it.resp.likeList");
          localObject1 = (Iterable)parama;
          parama = (Collection)new ArrayList();
          localObject1 = ((Iterable)localObject1).iterator();
        }
        label283:
        for (;;)
        {
          label186:
          if (!((Iterator)localObject1).hasNext()) {
            break label285;
          }
          Object localObject2 = ((Iterator)localObject1).next();
          if (!s.p(((bco)localObject2).hLv, paramy.AWk)) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label283;
            }
            parama.add(localObject2);
            break label186;
            bool = false;
            break;
            label246:
            localObject1 = y.d(paramy);
            if (localObject1 == null) {}
            for (localObject1 = null;; localObject1 = ((com.tencent.mm.bx.b)localObject1).toByteArray())
            {
              localObject1 = MD5Util.getMD5String((byte[])localObject1);
              break;
            }
          }
        }
        label285:
        paramy = (List)parama;
        AppMethodBeat.o(363532);
        return paramy;
        label297:
        paramy = (List)((ayv)parama.ott).likeList;
        AppMethodBeat.o(363532);
        return paramy;
      }
      paramy = (List)new LinkedList();
      AppMethodBeat.o(363532);
      return paramy;
    }
    
    private static final ah a(y paramy, com.tencent.mm.loader.f.g paramg, List paramList)
    {
      AppMethodBeat.i(363546);
      s.u(paramy, "this$0");
      s.u(paramg, "$task");
      s.s(paramList, "it");
      int i;
      int j;
      Object localObject1;
      if (!((Collection)paramList).isEmpty())
      {
        i = 1;
        if (i != 0)
        {
          j = paramy.data.size();
          localObject1 = paramList.iterator();
        }
      }
      else
      {
        label58:
        label218:
        label221:
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label223;
          }
          Object localObject3 = (bco)((Iterator)localObject1).next();
          Object localObject2 = ((List)paramy.data).iterator();
          i = 0;
          label96:
          if (((Iterator)localObject2).hasNext()) {
            if (s.p(((w)((Iterator)localObject2).next()).ECH.hLv, ((bco)localObject3).hLv)) {
              if (i < 0) {
                break label218;
              }
            }
          }
          for (i = 1;; i = 0)
          {
            if (i != 0) {
              break label221;
            }
            localObject2 = paramy.data;
            localObject3 = new w((bco)localObject3);
            if ((paramy.likeBuffer != null) && (((w)localObject3).ECH.unreadFlag == 1)) {
              ((w)localObject3).ECz = true;
            }
            ah localah = ah.aiuX;
            ((ArrayList)localObject2).add(localObject3);
            break label58;
            i = 0;
            break;
            i += 1;
            break label96;
            i = -1;
            break label133;
          }
        }
        label133:
        label223:
        localObject1 = paramy.AWl;
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject1).getRlLayout();
          if (localObject1 != null)
          {
            localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
            if (localObject1 != null)
            {
              localObject1 = ((RecyclerView)localObject1).getAdapter();
              if (localObject1 != null) {
                ((RecyclerView.a)localObject1).bA(j, paramy.data.size() - j);
              }
            }
          }
        }
      }
      for (;;)
      {
        localObject1 = new RefreshLoadMoreLayout.d(0);
        ((RefreshLoadMoreLayout.d)localObject1).agJu = y.f(paramy);
        ((RefreshLoadMoreLayout.d)localObject1).agJv = paramList.size();
        if (((RefreshLoadMoreLayout.d)localObject1).agJv > 0) {
          ((RefreshLoadMoreLayout.d)localObject1).pzq = false;
        }
        paramy = paramy.AWl;
        if (paramy != null)
        {
          paramy = paramy.getRlLayout();
          if (paramy != null) {
            paramy.onPreFinishLoadMoreSmooth((RefreshLoadMoreLayout.d)localObject1);
          }
        }
        paramg.a(com.tencent.mm.loader.f.i.nrG);
        paramy = ah.aiuX;
        AppMethodBeat.o(363546);
        return paramy;
        Log.w("Finder.DrawerPresenter", "[loadMoreData] empty!");
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onLoadMoreBegin", "", "loadMoreType", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends RefreshLoadMoreLayout.b
  {
    f(y paramy) {}
    
    private static final void i(y paramy)
    {
      AppMethodBeat.i(363517);
      s.u(paramy, "this$0");
      y.c(paramy);
      AppMethodBeat.o(363517);
    }
    
    public final void a(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(363533);
      s.u(paramd, "reason");
      super.a(paramd);
      y.b(this.AWq);
      AppMethodBeat.o(363533);
    }
    
    public final void qI(int paramInt)
    {
      AppMethodBeat.i(363525);
      super.qI(paramInt);
      com.tencent.threadpool.h.ahAA.bm(new y.f..ExternalSyntheticLambda0(this.AWq));
      AppMethodBeat.o(363525);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<com.tencent.mm.loader.f.g, ah>
  {
    g(boolean paramBoolean, y paramy, kotlin.g.a.b<? super LinkedList<bco>, ? extends LinkedList<bco>> paramb)
    {
      super();
    }
    
    private static final ah a(kotlin.g.a.b paramb, y paramy, boolean paramBoolean, long paramLong, com.tencent.mm.loader.f.g paramg, kotlin.r paramr)
    {
      boolean bool = false;
      AppMethodBeat.i(363548);
      s.u(paramy, "this$0");
      s.u(paramg, "$task");
      label40:
      Object localObject1;
      int i;
      if (paramb == null)
      {
        paramb = null;
        if (paramb != null) {
          break label227;
        }
        paramb = (LinkedList)paramr.bsD;
        localObject1 = paramy.AWl;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.view.builder.a)localObject1).hideLoading();
        }
        if (paramBoolean) {
          break label239;
        }
        localObject1 = paramy.AWl;
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject1).getRlLayout();
          if (localObject1 != null)
          {
            if (paramb != null) {
              break label230;
            }
            i = 0;
            label90:
            ((RefreshLoadMoreLayout)localObject1).aFV(i);
          }
        }
      }
      for (;;)
      {
        if (paramBoolean) {
          y.h(paramy);
        }
        if ((paramb == null) || (paramb.size() <= 0)) {
          break label384;
        }
        paramr = paramb.iterator();
        while (paramr.hasNext())
        {
          Object localObject2 = (bco)paramr.next();
          localObject1 = paramy.data;
          s.s(localObject2, "finderLikeInfo");
          localObject2 = new w((bco)localObject2);
          if ((paramy.likeBuffer != null) && (((w)localObject2).ECH.unreadFlag == 1)) {
            ((w)localObject2).ECz = true;
          }
          ah localah = ah.aiuX;
          ((ArrayList)localObject1).add(localObject2);
        }
        paramb = (LinkedList)paramb.invoke(paramr.bsD);
        break;
        label227:
        break label40;
        label230:
        i = paramb.size();
        break label90;
        label239:
        if (!y.f(paramy))
        {
          localObject1 = paramy.AWl;
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject1).getRlLayout();
            if (localObject1 != null) {
              RefreshLoadMoreLayout.e((RefreshLoadMoreLayout)localObject1);
            }
          }
        }
      }
      paramy = paramy.AWl;
      if (paramy != null)
      {
        paramy = paramy.getRlLayout();
        if (paramy != null)
        {
          paramy = paramy.getRecyclerView();
          if (paramy != null)
          {
            paramy = paramy.getAdapter();
            if (paramy != null) {
              paramy.bZE.notifyChanged();
            }
          }
        }
      }
      for (;;)
      {
        paramy = new StringBuilder("[refreshData] Cost=").append(System.currentTimeMillis() - paramLong).append("ms, succ:");
        paramBoolean = bool;
        if (paramb != null) {
          paramBoolean = true;
        }
        Log.i("Finder.DrawerPresenter", paramBoolean);
        paramg.a(com.tencent.mm.loader.f.i.nrG);
        paramb = ah.aiuX;
        AppMethodBeat.o(363548);
        return paramb;
        label384:
        Log.i("Finder.DrawerPresenter", "refresh header title...");
        paramy.ecj();
        if (paramBoolean)
        {
          paramy.data.clear();
          localObject1 = paramy.AWl;
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject1).getRlLayout();
            if (localObject1 != null)
            {
              localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
              if (localObject1 != null)
              {
                localObject1 = ((RecyclerView)localObject1).getAdapter();
                if (localObject1 != null) {
                  ((RecyclerView.a)localObject1).bZE.notifyChanged();
                }
              }
            }
          }
          if (((Boolean)paramr.bsC).booleanValue())
          {
            paramy = paramy.AWl;
            if (paramy != null)
            {
              paramy.getLoadingLayout().setVisibility(0);
              paramy.getLoadingView().setVisibility(8);
              paramy.fdw().setVisibility(0);
              paramy.fdx().setVisibility(8);
            }
          }
          else
          {
            paramr = paramy.AWl;
            if (paramr != null) {
              paramr.bv((kotlin.g.a.a)new a(paramy));
            }
          }
        }
      }
    }
    
    private static final kotlin.r b(y paramy, b.a parama)
    {
      AppMethodBeat.i(363534);
      s.u(paramy, "this$0");
      if (parama == null)
      {
        Log.e("Finder.DrawerPresenter", "refreshData resp null");
        paramy = new kotlin.r(Boolean.FALSE, null);
        AppMethodBeat.o(363534);
        return paramy;
      }
      if ((parama.errType == 0) && (parama.errCode == 0) && (parama.ott != null))
      {
        y.a(paramy, ((ayv)parama.ott).lastBuffer);
        y.a(paramy, ((ayv)parama.ott).lNX);
        Object localObject2 = new StringBuilder("refreshData lastBuffer ");
        Object localObject1;
        boolean bool;
        label161:
        Object localObject3;
        label199:
        int i;
        if (y.d(paramy) == null)
        {
          localObject1 = "null";
          Log.i("Finder.DrawerPresenter", localObject1 + " totalCount " + y.g(paramy));
          if (((ayv)parama.ott).continueFlag != 1) {
            break label432;
          }
          bool = true;
          y.a(paramy, bool);
          localObject1 = new LinkedList();
          localObject2 = z.bBF();
          localObject3 = new StringBuilder("contact: ");
          if (localObject2 != null) {
            break label437;
          }
          bool = true;
          Log.i("Finder.DrawerPresenter", bool + ", canShowLikeEdu:" + y.e(paramy));
          if (!y.e(paramy)) {
            break label481;
          }
          i = paramy.getScene();
          localObject3 = FinderLikeDrawer.GAf;
          if ((i != FinderLikeDrawer.fkN()) || (localObject2 == null)) {
            break label481;
          }
          localObject3 = new bco();
          ((bco)localObject3).nickName = ((au)localObject2).aSU();
          ((bco)localObject3).hLv = paramy.AWk;
          ((bco)localObject3).AyP = System.currentTimeMillis();
          ((LinkedList)localObject1).add(localObject3);
          parama = ((ayv)parama.ott).likeList;
          s.s(parama, "it.resp.likeList");
          localObject2 = (Iterable)parama;
          parama = (Collection)new ArrayList();
          localObject2 = ((Iterable)localObject2).iterator();
        }
        label432:
        label437:
        label445:
        for (;;)
        {
          label343:
          if (!((Iterator)localObject2).hasNext()) {
            break label447;
          }
          localObject3 = ((Iterator)localObject2).next();
          if (!s.p(((bco)localObject3).hLv, paramy.AWk)) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label445;
            }
            parama.add(localObject3);
            break label343;
            localObject1 = y.d(paramy);
            if (localObject1 == null) {}
            for (localObject1 = null;; localObject1 = ((com.tencent.mm.bx.b)localObject1).toByteArray())
            {
              localObject1 = MD5Util.getMD5String((byte[])localObject1);
              break;
            }
            bool = false;
            break label161;
            bool = false;
            break label199;
          }
        }
        label447:
        ((LinkedList)localObject1).addAll((Collection)parama);
        for (;;)
        {
          paramy = new kotlin.r(Boolean.TRUE, localObject1);
          AppMethodBeat.o(363534);
          return paramy;
          label481:
          ((LinkedList)localObject1).addAll((Collection)((ayv)parama.ott).likeList);
        }
      }
      paramy = new kotlin.r(Boolean.FALSE, null);
      AppMethodBeat.o(363534);
      return paramy;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(y paramy)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.y
 * JD-Core Version:    0.7.0.1
 */