package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.plugin.bz;
import com.tencent.mm.plugin.finder.live.view.FinderLiveShoppingPriceView;
import com.tencent.mm.plugin.finder.live.view.FinderLiveShoppingPriceView.b;
import com.tencent.mm.plugin.finder.live.view.adapter.holder.d;
import com.tencent.mm.plugin.finder.model.cc;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingSecondaryGoodsListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "plugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Landroid/content/Context;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "allDataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getAllDataList", "()Ljava/util/LinkedList;", "gotoHalfScreenMiniProgram", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "sourceClick", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "bundle", "", "getGotoHalfScreenMiniProgram", "()Lkotlin/jvm/functions/Function2;", "setGotoHalfScreenMiniProgram", "(Lkotlin/jvm/functions/Function2;)V", "priceViewConfig", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShoppingPriceView$Config;", "getPriceViewConfig", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShoppingPriceView$Config;", "setPriceViewConfig", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShoppingPriceView$Config;)V", "getData", "realPos", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateShoppingList", "productList", "", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public class af
  extends RecyclerView.a<RecyclerView.v>
{
  public static final af.a DTz;
  private final a CvU;
  public final LinkedList<cc> DSI;
  private final bz DSJ;
  public FinderLiveShoppingPriceView.b DSR;
  public m<? super Integer, ? super g, ah> DTk;
  private final Context context;
  private final b nfT;
  
  static
  {
    AppMethodBeat.i(358791);
    DTz = new af.a((byte)0);
    AppMethodBeat.o(358791);
  }
  
  public af(Context paramContext, b paramb, bz parambz, a parama)
  {
    AppMethodBeat.i(358782);
    this.context = paramContext;
    this.nfT = paramb;
    this.DSJ = parambz;
    this.CvU = parama;
    this.DSI = new LinkedList();
    paramContext = FinderLiveShoppingPriceView.DPr;
    this.DSR = FinderLiveShoppingPriceView.evI();
    AppMethodBeat.o(358782);
  }
  
  protected final cc PE(int paramInt)
  {
    AppMethodBeat.i(358797);
    Object localObject = this.DSI.get(paramInt);
    s.s(localObject, "allDataList[realPos]");
    localObject = (cc)localObject;
    AppMethodBeat.o(358797);
    return localObject;
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(358806);
    s.u(paramViewGroup, "parent");
    paramViewGroup = View.inflate(paramViewGroup.getContext(), p.f.CfE, null);
    s.s(paramViewGroup, "inflate(parent.context, …ng_list_goods_item, null)");
    paramViewGroup = (RecyclerView.v)new d(paramViewGroup);
    AppMethodBeat.o(358806);
    return paramViewGroup;
  }
  
  public void d(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(358811);
    s.u(paramv, "holder");
    AppMethodBeat.o(358811);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(358819);
    int i = this.DSI.size();
    AppMethodBeat.o(358819);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.af
 * JD-Core Version:    0.7.0.1
 */