package com.tencent.mm.plugin.finder.order.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/order/ui/OrderUILogic;", "", "()V", "TAG", "", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initOrderRecyclerView", "", "context", "Landroid/content/Context;", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/order/data/OrderFeed;", "Lkotlin/collections/ArrayList;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d ESR;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(332394);
    ESR = new d();
    TAG = "Finder.OrderUILogic";
    AppMethodBeat.o(332394);
  }
  
  public static void a(Context paramContext, WxRecyclerView paramWxRecyclerView, ArrayList<com.tencent.mm.plugin.finder.order.data.a> paramArrayList)
  {
    AppMethodBeat.i(332382);
    s.u(paramContext, "context");
    s.u(paramWxRecyclerView, "recyclerView");
    s.u(paramArrayList, "dataList");
    paramWxRecyclerView.setLayoutManager((RecyclerView.LayoutManager)new FinderLinearLayoutManager(paramContext));
    WxRecyclerAdapter localWxRecyclerAdapter = new WxRecyclerAdapter((g)new a(), paramArrayList, false);
    paramWxRecyclerView.setAdapter((RecyclerView.a)localWxRecyclerAdapter);
    localWxRecyclerAdapter.agOe = ((i.c)new b(paramArrayList));
    paramWxRecyclerView.a((RecyclerView.h)new c(paramContext));
    AppMethodBeat.o(332382);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/order/ui/OrderUILogic$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements g
  {
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(332379);
      if (paramInt == com.tencent.mm.plugin.finder.order.data.a.class.hashCode())
      {
        localObject = (com.tencent.mm.view.recyclerview.f)new a();
        AppMethodBeat.o(332379);
        return localObject;
      }
      s.checkNotNull(null);
      Object localObject = new kotlin.f();
      AppMethodBeat.o(332379);
      throw ((Throwable)localObject);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/order/ui/OrderUILogic$initOrderRecyclerView$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements i.c<j>
  {
    b(ArrayList<com.tencent.mm.plugin.finder.order.data.a> paramArrayList) {}
    
    private static final String a(com.tencent.mm.plugin.finder.order.data.a parama)
    {
      AppMethodBeat.i(332392);
      s.u(parama, "$feed");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("orderDetailsJson", parama.ESm);
      parama = localJSONObject.toString();
      AppMethodBeat.o(332392);
      return parama;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/order/ui/OrderUILogic$initOrderRecyclerView$2", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.h
  {
    c(Context paramContext) {}
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(332395);
      s.u(paramRect, "outRect");
      s.u(paramView, "view");
      s.u(paramRecyclerView, "parent");
      s.u(params, "state");
      int i = (int)this.$context.getResources().getDimension(p.c.Edge_A);
      int j = (int)this.$context.getResources().getDimension(p.c.finder_0_75_A);
      paramRect.left = i;
      paramRect.right = i;
      paramRect.bottom = j;
      paramRect.top = j;
      AppMethodBeat.o(332395);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.order.ui.d
 * JD-Core Version:    0.7.0.1
 */