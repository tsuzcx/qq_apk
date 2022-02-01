package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.view.recyclerview.a;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderVerticalLineConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "()V", "lineHeight", "", "getLineHeight", "()I", "setLineHeight", "(I)V", "lineWidth", "getLineWidth", "setLineWidth", "marginLeft", "getMarginLeft", "setMarginLeft", "marginRight", "getMarginRight", "setMarginRight", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"})
public final class ct
  extends e<a>
{
  public int lineHeight;
  public int xpS = 1;
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(250924);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    paramRecyclerView = parami.amk.findViewById(b.f.line_view);
    p.j(paramRecyclerView, "lineView");
    parami = paramRecyclerView.getLayoutParams();
    if (parami == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(250924);
      throw paramRecyclerView;
    }
    parami = (FrameLayout.LayoutParams)parami;
    parami.width = this.xpS;
    parami.height = this.lineHeight;
    paramRecyclerView.setLayoutParams((ViewGroup.LayoutParams)parami);
    AppMethodBeat.o(250924);
  }
  
  public final void a(i parami, a parama, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(250928);
    p.k(parami, "holder");
    p.k(parama, "item");
    AppMethodBeat.o(250928);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_vertical_line_convert_layout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ct
 * JD-Core Version:    0.7.0.1
 */