package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.plugin.bz;
import com.tencent.mm.plugin.finder.live.view.adapter.holder.b.a;
import com.tencent.mm.plugin.finder.live.view.adapter.holder.c;
import com.tencent.mm.plugin.finder.live.view.convert.j;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.q;
import com.tencent.mm.plugin.finder.live.widget.FinderLiveShoppingCouponView;
import com.tencent.mm.plugin.finder.live.widget.FinderLiveShoppingCouponView.a;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.bhl;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMProcessBar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingCouponListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "isAnchor", "", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Landroid/content/Context;ZLcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "actionButtonClickCallback", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingCouponView$Callback;", "getActionButtonClickCallback", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingCouponView$Callback;", "setActionButtonClickCallback", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingCouponView$Callback;)V", "allDataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getAllDataList", "()Ljava/util/LinkedList;", "()Z", "setAnchor", "(Z)V", "isLoadingMore", "notSendingIndexArray", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getNotSendingIndexArray", "()Ljava/util/ArrayList;", "onScrollListener", "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingCouponListAdapter$onScrollListener$1", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingCouponListAdapter$onScrollListener$1;", "plugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin;", "sendingIndexArray", "getSendingIndexArray", "viewTypeArray", "getViewTypeArray", "bindCouponItem", "", "item", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowCouponItem;", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/holder/FinderLiveShoppingCouponViewHolder;", "position", "getItemCount", "getItemViewType", "hasMore", "isAnchorOrAssistant", "itemStateChanged", "loadMoreCouponList", "couponList", "", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "i", "onDetachedFromRecyclerView", "onMount", "onUnmount", "tryTriggerLoadMore", "updateSection", "updateShoppingList", "productList", "realPosToAllDataPos", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ac
  extends RecyclerView.a<RecyclerView.v>
{
  public static final ac.a DSE;
  private final com.tencent.mm.plugin.finder.live.model.context.a CvU;
  private final ArrayList<Integer> DSF;
  private final ArrayList<Integer> DSG;
  private final ArrayList<Integer> DSH;
  public final LinkedList<cc> DSI;
  public bz DSJ;
  public FinderLiveShoppingCouponView.a DSK;
  private final b DSL;
  private final Context context;
  private boolean hKC;
  public boolean isLoadingMore;
  
  static
  {
    AppMethodBeat.i(358874);
    DSE = new ac.a((byte)0);
    AppMethodBeat.o(358874);
  }
  
  public ac(Context paramContext, boolean paramBoolean, com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(358846);
    this.context = paramContext;
    this.hKC = paramBoolean;
    this.CvU = parama;
    this.DSF = new ArrayList();
    this.DSG = new ArrayList();
    this.DSH = new ArrayList();
    this.DSI = new LinkedList();
    this.DSL = new b(this);
    AppMethodBeat.o(358846);
  }
  
  private static final boolean a(ac paramac, RecyclerView paramRecyclerView, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(358864);
    s.u(paramac, "this$0");
    s.u(paramRecyclerView, "$recyclerView");
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(358864);
      return false;
      paramac.x(paramRecyclerView);
    }
  }
  
  private final boolean aWl()
  {
    AppMethodBeat.i(358851);
    boolean bool = ((q)this.CvU.business(q.class)).Eik;
    AppMethodBeat.o(358851);
    return bool;
  }
  
  private static boolean eqc()
  {
    AppMethodBeat.i(358858);
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    boolean bool;
    if (!com.tencent.mm.plugin.finder.live.utils.a.bUx())
    {
      localObject = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
      localObject = com.tencent.mm.plugin.finder.live.model.context.a.emY();
      if (localObject != null) {
        break label40;
      }
      bool = false;
    }
    while (bool)
    {
      AppMethodBeat.o(358858);
      return true;
      label40:
      localObject = (e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(e.class);
      if (localObject == null) {
        bool = false;
      } else {
        bool = ((e)localObject).DUe;
      }
    }
    AppMethodBeat.o(358858);
    return false;
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(358921);
    s.u(paramj, "item");
    if ((eqc()) && (paramj.DVc))
    {
      this.DSI.remove(paramj);
      this.DSI.addFirst(paramj);
      LinkedList localLinkedList = ((q)this.CvU.business(q.class)).Eib;
      if (localLinkedList != null)
      {
        localLinkedList.remove(paramj);
        localLinkedList.addFirst(paramj);
      }
    }
    evQ();
    this.bZE.notifyChanged();
    AppMethodBeat.o(358921);
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(358951);
    s.u(paramViewGroup, "parent");
    switch (paramInt)
    {
    case 2: 
    default: 
      paramViewGroup = LayoutInflater.from(this.context).inflate(p.f.CfD, paramViewGroup, false);
      s.s(paramViewGroup, "from(context).inflate(la…upon_item, parent, false)");
      paramViewGroup = new com.tencent.mm.plugin.finder.live.view.adapter.holder.a(paramViewGroup);
      paramViewGroup.DUd.setCallback(this.DSK);
      paramViewGroup = (RecyclerView.v)paramViewGroup;
      AppMethodBeat.o(358951);
      return paramViewGroup;
    case 0: 
    case 1: 
      paramViewGroup = LayoutInflater.from(this.context).inflate(p.f.CfF, paramViewGroup, false);
      s.s(paramViewGroup, "from(context).inflate(la…ader_item, parent, false)");
      paramViewGroup = (RecyclerView.v)new com.tencent.mm.plugin.finder.live.view.adapter.holder.b(paramViewGroup, eqc());
      AppMethodBeat.o(358951);
      return paramViewGroup;
    }
    paramViewGroup = LayoutInflater.from(this.context).inflate(p.f.CfG, paramViewGroup, false);
    s.s(paramViewGroup, "from(context).inflate(la…load_more, parent, false)");
    paramViewGroup = (RecyclerView.v)new c(paramViewGroup);
    AppMethodBeat.o(358951);
    return paramViewGroup;
  }
  
  public final void d(RecyclerView.v paramv, int paramInt)
  {
    boolean bool1 = true;
    AppMethodBeat.i(358970);
    s.u(paramv, "holder");
    Object localObject1;
    label160:
    Object localObject2;
    label211:
    label246:
    int k;
    int i;
    int j;
    switch (getItemViewType(paramInt))
    {
    default: 
      AppMethodBeat.o(358970);
      return;
    case 0: 
      paramv = (com.tencent.mm.plugin.finder.live.view.adapter.holder.b)paramv;
      localObject1 = com.tencent.mm.cd.a.bt(this.context, p.h.Cst);
      s.s(localObject1, "getString(\n             …ing\n                    )");
      paramv.a((String)localObject1, b.a.DUn, false, false, false);
      AppMethodBeat.o(358970);
      return;
    case 1: 
      paramv = (com.tencent.mm.plugin.finder.live.view.adapter.holder.b)paramv;
      localObject1 = com.tencent.mm.cd.a.bt(this.context, p.h.Csr);
      s.s(localObject1, "getString(\n             …ing\n                    )");
      paramv.a((String)localObject1, b.a.DUn, true, false, false);
      AppMethodBeat.o(358970);
      return;
    case 2: 
      localObject1 = this.DSI;
      if (!this.hKC)
      {
        localObject1 = (j)((LinkedList)localObject1).get(paramInt);
        paramv = (com.tencent.mm.plugin.finder.live.view.adapter.holder.a)paramv;
        localObject2 = paramv.DUd;
        boolean bool2 = eqc();
        if (((f)this.CvU.business(f.class)).liveInfo.liveId == 0L)
        {
          ((FinderLiveShoppingCouponView)localObject2).a((j)localObject1, bool2, bool1);
          paramv = paramv.caK.getLayoutParams();
          localObject1 = this.context;
          if (!eqc()) {
            break label431;
          }
          paramInt = p.c.Bzu;
          paramv.height = com.tencent.mm.cd.a.bs((Context)localObject1, paramInt);
          AppMethodBeat.o(358970);
        }
      }
      else
      {
        if (paramInt < 0) {
          break label460;
        }
        k = 0;
        i = -1;
        j = 1;
        label275:
        localObject2 = (Integer)this.DSF.get(k);
        if (localObject2 == null)
        {
          label294:
          localObject2 = (Integer)this.DSF.get(k);
          if (localObject2 != null) {
            break label343;
          }
          label313:
          i += 1;
          label317:
          if (k != paramInt) {
            break label451;
          }
        }
      }
      break;
    }
    for (;;)
    {
      if (i < 0)
      {
        paramInt = 0;
        break label160;
        if (((Integer)localObject2).intValue() != 0) {
          break label294;
        }
        break label317;
        label343:
        if (((Integer)localObject2).intValue() != 1) {
          break label313;
        }
        i = -1;
        j = 0;
        break label317;
      }
      if (j != 0)
      {
        localObject2 = this.DSG.get(i);
        s.s(localObject2, "sendingIndexArray[relativePos]");
        paramInt = ((Number)localObject2).intValue();
        break label160;
      }
      localObject2 = this.DSH.get(i);
      s.s(localObject2, "notSendingIndexArray[relativePos]");
      paramInt = ((Number)localObject2).intValue();
      break label160;
      bool1 = false;
      break label211;
      label431:
      paramInt = p.c.Bzv;
      break label246;
      ((c)paramv).DUp.jEP();
      break;
      label451:
      k += 1;
      break label275;
      label460:
      i = -1;
      j = 1;
    }
  }
  
  public final void d(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(358908);
    s.u(paramRecyclerView, "recyclerView");
    super.d(paramRecyclerView);
    paramRecyclerView.a((RecyclerView.l)this.DSL);
    paramRecyclerView.setOnTouchListener(new ac..ExternalSyntheticLambda0(this, paramRecyclerView));
    AppMethodBeat.o(358908);
  }
  
  public final void e(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(358915);
    s.u(paramRecyclerView, "recyclerView");
    super.e(paramRecyclerView);
    paramRecyclerView.b((RecyclerView.l)this.DSL);
    AppMethodBeat.o(358915);
  }
  
  public final void evQ()
  {
    int j = 0;
    AppMethodBeat.i(358936);
    this.DSG.clear();
    this.DSH.clear();
    int m = this.DSI.size();
    if (m > 0) {}
    int k;
    for (int i = 0;; i = k)
    {
      k = i + 1;
      if (((j)this.DSI.get(i)).DVc) {
        this.DSG.add(Integer.valueOf(i));
      }
      while (k >= m)
      {
        this.DSF.clear();
        ArrayList localArrayList;
        Object localObject;
        Collection localCollection;
        if (!this.hKC)
        {
          localArrayList = this.DSF;
          localObject = (Iterable)this.DSI;
          localCollection = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
          localObject = ((Iterable)localObject).iterator();
          for (;;)
          {
            if (((Iterator)localObject).hasNext())
            {
              ((Iterator)localObject).next();
              localCollection.add(Integer.valueOf(2));
              continue;
              this.DSH.add(Integer.valueOf(i));
              break;
            }
          }
          localArrayList.addAll((Collection)localCollection);
        }
        for (;;)
        {
          if (aWl()) {
            this.DSF.add(Integer.valueOf(3));
          }
          AppMethodBeat.o(358936);
          return;
          if (!((Collection)this.DSG).isEmpty()) {
            i = 1;
          }
          while (i != 0)
          {
            this.DSF.add(Integer.valueOf(0));
            localArrayList = this.DSF;
            localObject = (Iterable)this.DSG;
            localCollection = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
            localObject = ((Iterable)localObject).iterator();
            for (;;)
            {
              if (((Iterator)localObject).hasNext())
              {
                ((Number)((Iterator)localObject).next()).intValue();
                localCollection.add(Integer.valueOf(2));
                continue;
                i = 0;
                break;
              }
            }
            localArrayList.addAll((Collection)localCollection);
          }
          i = j;
          if (!((Collection)this.DSH).isEmpty()) {
            i = 1;
          }
          if (i != 0)
          {
            this.DSF.add(Integer.valueOf(1));
            localArrayList = this.DSF;
            localObject = (Iterable)this.DSH;
            localCollection = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
            localObject = ((Iterable)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              ((Number)((Iterator)localObject).next()).intValue();
              localCollection.add(Integer.valueOf(2));
            }
            localArrayList.addAll((Collection)localCollection);
          }
        }
      }
    }
  }
  
  public final void gI(List<j> paramList)
  {
    AppMethodBeat.i(358905);
    s.u(paramList, "couponList");
    this.isLoadingMore = false;
    Log.i("Finder.FinderLiveShoppingCouponListAdapter", "before loadMoreCouponList,ori size:" + this.DSI.size() + ",more size:" + paramList.size());
    Object localObject1 = ((Iterable)paramList).iterator();
    while (((Iterator)localObject1).hasNext()) {
      Log.i("Finder.FinderLiveShoppingCouponListAdapter", s.X("load more coupon: ", (j)((Iterator)localObject1).next()));
    }
    int k = this.DSF.size();
    this.DSF.remove(this.DSF.size() - 1);
    if ((!this.DSF.contains(Integer.valueOf(1))) && (this.hKC)) {
      this.DSF.add(Integer.valueOf(1));
    }
    localObject1 = this.DSF;
    Object localObject2 = (Iterable)paramList;
    Collection localCollection = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ((Iterator)localObject2).next();
      localCollection.add(Integer.valueOf(2));
    }
    ((ArrayList)localObject1).addAll((Collection)localCollection);
    int i = this.DSI.size();
    this.DSI.addAll((Collection)paramList);
    localObject1 = ((q)this.CvU.business(q.class)).Eib;
    if (localObject1 != null) {
      ((LinkedList)localObject1).addAll((Collection)paramList);
    }
    int m = this.DSI.size();
    if (i < m) {
      do
      {
        j = i + 1;
        this.DSH.add(Integer.valueOf(i));
        i = j;
      } while (j < m);
    }
    if (aWl()) {
      this.DSF.add(Integer.valueOf(3));
    }
    fX(k - 1);
    int j = paramList.size();
    if (aWl()) {}
    for (i = 1;; i = 0)
    {
      bA(k - 1, i + j);
      AppMethodBeat.o(358905);
      return;
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(358960);
    int i = this.DSF.size();
    AppMethodBeat.o(358960);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(358939);
    Object localObject = this.DSF.get(paramInt);
    s.s(localObject, "viewTypeArray[position]");
    paramInt = ((Number)localObject).intValue();
    AppMethodBeat.o(358939);
    return paramInt;
  }
  
  public final void x(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(358890);
    s.u(paramRecyclerView, "recyclerView");
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if (paramRecyclerView == null)
    {
      paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
      AppMethodBeat.o(358890);
      throw paramRecyclerView;
    }
    if (((LinearLayoutManager)paramRecyclerView).Jw() != this.DSF.size() - 1)
    {
      AppMethodBeat.o(358890);
      return;
    }
    if (!aWl())
    {
      this.isLoadingMore = false;
      AppMethodBeat.o(358890);
      return;
    }
    if (this.isLoadingMore)
    {
      AppMethodBeat.o(358890);
      return;
    }
    this.isLoadingMore = true;
    if (this.DSJ != null)
    {
      paramRecyclerView = bz.getFinderLiveAssistant();
      if (paramRecyclerView != null) {
        paramRecyclerView.a((MMActivity)this.context, (m)new c(this));
      }
    }
    AppMethodBeat.o(358890);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingCouponListAdapter$onScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RecyclerView.l
  {
    b(ac paramac) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(359128);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingCouponListAdapter$onScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      if (paramInt == 0) {
        this.DSM.x(paramRecyclerView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingCouponListAdapter$onScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(359128);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(359133);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingCouponListAdapter$onScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingCouponListAdapter$onScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(359133);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetCouponListResponse;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements m<Boolean, bhl, ah>
  {
    c(ac paramac)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.ac
 * JD-Core Version:    0.7.0.1
 */