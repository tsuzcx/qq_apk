package com.tencent.mm.plugin.finder.convert;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.model.bw;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderProfileShopConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderShopFeed;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cf
  extends f<bw>
{
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(349736);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    paramRecyclerView = (TextView)paramj.UH(e.e.product_price_tv);
    if (paramRecyclerView != null)
    {
      paramj = aw.Gjk;
      aw.f(paramRecyclerView, false);
    }
    AppMethodBeat.o(349736);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_profile_shop_item;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.cf
 * JD-Core Version:    0.7.0.1
 */