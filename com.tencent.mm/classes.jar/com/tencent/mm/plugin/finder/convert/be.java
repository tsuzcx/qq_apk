package com.tencent.mm.plugin.finder.convert;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.b;
import com.tencent.mm.ui.ao;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderMoreSimilarTopicConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseLocalFeed;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public class be
  extends e<b>
{
  private static int tEQ;
  public static final a tER;
  
  static
  {
    AppMethodBeat.i(243188);
    tER = new a((byte)0);
    tEQ = -2;
    AppMethodBeat.o(243188);
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(243185);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    paramh.setTag(Integer.valueOf(tEQ));
    paramh.aus.setTag(Integer.valueOf(tEQ));
    paramRecyclerView = (TextView)paramh.Mn(2131301491);
    p.g(paramRecyclerView, "tipsTv");
    ao.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    AppMethodBeat.o(243185);
  }
  
  public void a(h paramh, b paramb, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(243186);
    p.h(paramh, "holder");
    p.h(paramb, "item");
    AppMethodBeat.o(243186);
  }
  
  public final int getLayoutId()
  {
    return 2131494519;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderMoreSimilarTopicConvert$Companion;", "", "()V", "VIEW_TYPE_MORE_SIMILAR", "", "getVIEW_TYPE_MORE_SIMILAR", "()I", "setVIEW_TYPE_MORE_SIMILAR", "(I)V", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.be
 * JD-Core Version:    0.7.0.1
 */