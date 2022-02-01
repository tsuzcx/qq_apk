package com.tencent.mm.plugin.finder.convert;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.ui.ao;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderLiveWeCoinHotConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderLiveWeCoinData;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "setRankTv", "rankTv", "Landroid/widget/TextView;", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "plugin-finder_release"})
public final class av
  extends e<am>
{
  private final String TAG = "FinderLiveWeCoinHotConvert";
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(243159);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    paramRecyclerView = (TextView)paramh.Mn(2131301336);
    if (paramRecyclerView != null) {}
    for (paramRecyclerView = paramRecyclerView.getPaint();; paramRecyclerView = null)
    {
      ao.a((Paint)paramRecyclerView, 0.8F);
      AppMethodBeat.o(243159);
      return;
    }
  }
  
  public final int getLayoutId()
  {
    return 2131494485;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.av
 * JD-Core Version:    0.7.0.1
 */