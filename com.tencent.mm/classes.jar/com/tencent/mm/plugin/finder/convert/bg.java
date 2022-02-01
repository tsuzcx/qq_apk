package com.tencent.mm.plugin.finder.convert;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.finder.feed.ab;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout;
import com.tencent.mm.ui.al;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "tabType", "", "(I)V", "getTabType", "()I", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class bg
  extends com.tencent.mm.view.recyclerview.b<ab>
{
  public static final bg.a rYp;
  private final int dvm;
  
  static
  {
    AppMethodBeat.i(201930);
    rYp = new bg.a((byte)0);
    AppMethodBeat.o(201930);
  }
  
  public bg(int paramInt)
  {
    this.dvm = paramInt;
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(201928);
    p.h(paramRecyclerView, "recyclerView");
    p.h(parame, "holder");
    paramRecyclerView = parame.auu;
    p.g(paramRecyclerView, "holder.itemView");
    paramRecyclerView = (TextView)paramRecyclerView.findViewById(2131305902);
    p.g(paramRecyclerView, "holder.itemView.title");
    al.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    paramRecyclerView = parame.auu;
    p.g(paramRecyclerView, "holder.itemView");
    paramRecyclerView = (TextView)paramRecyclerView.findViewById(2131308343);
    p.g(paramRecyclerView, "holder.itemView.linkTitle");
    al.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    paramRecyclerView = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cKE().value()).intValue() == 1)
    {
      paramRecyclerView = parame.auu;
      p.g(paramRecyclerView, "holder.itemView");
      paramRecyclerView = (FinderFoldedScrollLayout)paramRecyclerView.findViewById(2131308490);
      p.g(paramRecyclerView, "holder.itemView.foldedScrollLayout");
      paramRecyclerView = paramRecyclerView.getLayoutParams();
      parame = parame.auu;
      p.g(parame, "holder.itemView");
      paramRecyclerView.height = a.fromDPToPix(parame.getContext(), 416);
      AppMethodBeat.o(201928);
      return;
    }
    paramRecyclerView = parame.auu;
    p.g(paramRecyclerView, "holder.itemView");
    paramRecyclerView = (FinderFoldedScrollLayout)paramRecyclerView.findViewById(2131308490);
    p.g(paramRecyclerView, "holder.itemView.foldedScrollLayout");
    paramRecyclerView = paramRecyclerView.getLayoutParams();
    parame = parame.auu;
    p.g(parame, "holder.itemView");
    paramRecyclerView.height = a.fromDPToPix(parame.getContext(), 240);
    AppMethodBeat.o(201928);
  }
  
  public final int getLayoutId()
  {
    return 2131496427;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.bg
 * JD-Core Version:    0.7.0.1
 */