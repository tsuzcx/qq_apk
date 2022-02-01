package com.tencent.mm.plugin.finder.convert;

import android.graphics.Paint;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.model.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderLiveWeCoinHotConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderLiveWeCoinData;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "setRankTv", "rankTv", "Landroid/widget/TextView;", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "plugin-finder_release"})
public final class ax
  extends e<ao>
{
  private final String TAG = "FinderLiveWeCoinHotConvert";
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(274327);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    paramRecyclerView = (TextView)parami.RD(b.f.finder_live_wecoin_hot_rank_tv);
    if (paramRecyclerView != null) {}
    for (paramRecyclerView = paramRecyclerView.getPaint();; paramRecyclerView = null)
    {
      ar.a((Paint)paramRecyclerView, 0.8F);
      AppMethodBeat.o(274327);
      return;
    }
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_live_wecoin_hot_item_ui;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ax
 * JD-Core Version:    0.7.0.1
 */