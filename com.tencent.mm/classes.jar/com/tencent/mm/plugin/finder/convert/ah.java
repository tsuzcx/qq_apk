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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderMoreSimilarTopicConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseLocalFeed;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public class ah
  extends com.tencent.mm.view.recyclerview.b<com.tencent.mm.plugin.finder.model.b>
{
  private static int rPe;
  public static final a rPf;
  
  static
  {
    AppMethodBeat.i(201447);
    rPf = new a((byte)0);
    rPe = -2;
    AppMethodBeat.o(201447);
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(201444);
    p.h(paramRecyclerView, "recyclerView");
    p.h(parame, "holder");
    parame.setTag(Integer.valueOf(rPe));
    parame.auu.setTag(Integer.valueOf(rPe));
    paramRecyclerView = (TextView)parame.Gd(2131307438);
    p.g(paramRecyclerView, "tipsTv");
    al.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    AppMethodBeat.o(201444);
  }
  
  public void a(e parame, com.tencent.mm.plugin.finder.model.b paramb, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(201445);
    p.h(parame, "holder");
    p.h(paramb, "item");
    AppMethodBeat.o(201445);
  }
  
  public final int getLayoutId()
  {
    return 2131496229;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderMoreSimilarTopicConvert$Companion;", "", "()V", "VIEW_TYPE_MORE_SIMILAR", "", "getVIEW_TYPE_MORE_SIMILAR", "()I", "setVIEW_TYPE_MORE_SIMILAR", "(I)V", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ah
 * JD-Core Version:    0.7.0.1
 */