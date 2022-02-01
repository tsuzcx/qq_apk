package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.view.recyclerview.a;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderVerticalLineConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "()V", "lineHeight", "", "getLineHeight", "()I", "setLineHeight", "(I)V", "lineWidth", "getLineWidth", "setLineWidth", "marginLeft", "getMarginLeft", "setMarginLeft", "marginRight", "getMarginRight", "setMarginRight", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cw
  extends f<a>
{
  public int AMY = 1;
  public int lineHeight;
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(349845);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    paramRecyclerView = paramj.caK.findViewById(e.e.line_view);
    paramj = paramRecyclerView.getLayoutParams();
    if (paramj == null)
    {
      paramRecyclerView = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(349845);
      throw paramRecyclerView;
    }
    paramj = (FrameLayout.LayoutParams)paramj;
    paramj.width = this.AMY;
    paramj.height = this.lineHeight;
    paramRecyclerView.setLayoutParams((ViewGroup.LayoutParams)paramj);
    AppMethodBeat.o(349845);
  }
  
  public final void a(j paramj, a parama, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(349854);
    s.u(paramj, "holder");
    s.u(parama, "item");
    AppMethodBeat.o(349854);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_vertical_line_convert_layout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.cw
 * JD-Core Version:    0.7.0.1
 */