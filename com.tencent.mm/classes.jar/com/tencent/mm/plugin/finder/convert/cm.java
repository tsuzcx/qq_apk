package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.a;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderVerticalLineConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "()V", "lineHeight", "", "getLineHeight", "()I", "setLineHeight", "(I)V", "lineWidth", "getLineWidth", "setLineWidth", "marginLeft", "getMarginLeft", "setMarginLeft", "marginRight", "getMarginRight", "setMarginRight", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class cm
  extends e<a>
{
  public int lineHeight;
  public int tHg = 1;
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(243374);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    paramRecyclerView = paramh.aus.findViewById(2131303208);
    p.g(paramRecyclerView, "lineView");
    paramh = paramRecyclerView.getLayoutParams();
    if (paramh == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(243374);
      throw paramRecyclerView;
    }
    paramh = (FrameLayout.LayoutParams)paramh;
    paramh.width = this.tHg;
    paramh.height = this.lineHeight;
    paramRecyclerView.setLayoutParams((ViewGroup.LayoutParams)paramh);
    AppMethodBeat.o(243374);
  }
  
  public final void a(h paramh, a parama, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(243375);
    p.h(paramh, "holder");
    p.h(parama, "item");
    AppMethodBeat.o(243375);
  }
  
  public final int getLayoutId()
  {
    return 2131494669;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.cm
 * JD-Core Version:    0.7.0.1
 */