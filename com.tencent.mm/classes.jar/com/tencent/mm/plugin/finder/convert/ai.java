package com.tencent.mm.plugin.finder.convert;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.al;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.l;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/convert/FinderMoreSimilarTopicConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseLocalFeed;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public class ai
  extends com.tencent.mm.view.recyclerview.b<com.tencent.mm.plugin.finder.model.b>
{
  private static int rXF;
  public static final ai.a rXG;
  
  static
  {
    AppMethodBeat.i(201889);
    rXG = new ai.a((byte)0);
    rXF = -2;
    AppMethodBeat.o(201889);
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(201886);
    p.h(paramRecyclerView, "recyclerView");
    p.h(parame, "holder");
    parame.setTag(Integer.valueOf(rXF));
    parame.auu.setTag(Integer.valueOf(rXF));
    paramRecyclerView = (TextView)parame.GD(2131307438);
    p.g(paramRecyclerView, "tipsTv");
    al.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    AppMethodBeat.o(201886);
  }
  
  public void a(e parame, com.tencent.mm.plugin.finder.model.b paramb, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(201887);
    p.h(parame, "holder");
    p.h(paramb, "item");
    AppMethodBeat.o(201887);
  }
  
  public final int getLayoutId()
  {
    return 2131496229;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ai
 * JD-Core Version:    0.7.0.1
 */