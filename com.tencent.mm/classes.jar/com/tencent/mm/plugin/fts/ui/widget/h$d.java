package com.tencent.mm.plugin.fts.ui.widget;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.amw;
import com.tencent.mm.protocal.protobuf.epl;
import com.tencent.mm.view.recyclerview.k;
import com.tencent.mm.view.recyclerview.m;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/fts/ui/widget/KeyboardSugLogic$scrollListener$1", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "onScrollStatsChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "data", "Lcom/tencent/mm/view/recyclerview/WxRVData;", "ui-fts_release"})
public final class h$d
  implements m
{
  public final void a(RecyclerView paramRecyclerView, k paramk)
  {
    AppMethodBeat.i(190920);
    p.k(paramRecyclerView, "recyclerView");
    p.k(paramk, "data");
    if (paramk.state == 1) {
      this.BSh.BRZ = true;
    }
    paramRecyclerView = ((Iterable)paramk.YSO).iterator();
    int i = 0;
    while (paramRecyclerView.hasNext())
    {
      paramk = paramRecyclerView.next();
      int j = i + 1;
      if (i < 0) {
        j.iBO();
      }
      paramk = ((com.tencent.mm.view.recyclerview.l)paramk).YSP;
      if (paramk == null)
      {
        paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.fts.ui.widget.KeyboardSugItem");
        AppMethodBeat.o(190920);
        throw paramRecyclerView;
      }
      Object localObject = ((g)paramk).BRY;
      if (localObject != null)
      {
        paramk = new amw();
        paramk.CqR = i;
        paramk.SwV = ((epl)localObject);
        localObject = this.BSh;
        if (this.BSh.BRZ) {}
        for (i = 2;; i = 0)
        {
          h.a((h)localObject, paramk, 1, i);
          i = j;
          break;
        }
      }
      i = j;
    }
    AppMethodBeat.o(190920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.h.d
 * JD-Core Version:    0.7.0.1
 */