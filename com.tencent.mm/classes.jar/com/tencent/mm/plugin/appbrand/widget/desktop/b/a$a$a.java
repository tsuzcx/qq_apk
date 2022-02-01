package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.d;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/widget/desktop/utils/AppBrandDesktopItemDecorationHelper$Companion$setupItemDecoration$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-appbrand-integration_release"})
public final class a$a$a
  extends RecyclerView.h
{
  a$a$a(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8) {}
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(269488);
    p.k(paramRect, "outRect");
    p.k(paramView, "view");
    p.k(paramRecyclerView, "parent");
    p.k(params, "state");
    super.a(paramRect, paramView, paramRecyclerView, params);
    int i = RecyclerView.bh(paramView);
    paramView = paramRecyclerView.aQ(paramView);
    if ((!(paramView instanceof d)) || ((((d)paramView).mg() != 1) && (((d)paramView).mg() != 2)))
    {
      paramRect.top = 0;
      paramRect.left = 0;
      paramRect.right = 0;
      AppMethodBeat.o(269488);
      return;
    }
    if (i == -1) {
      i = ((d)paramView).me();
    }
    for (;;)
    {
      i -= this.rrb;
      if (i / 4 > 0)
      {
        paramRect.top = this.rrc;
        paramRect.bottom = 0;
        switch (i % 4)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(269488);
        return;
        paramRect.top = this.rrd;
        break;
        paramRect.left = ((int)this.rre);
        paramRect.right = ((int)this.rrf);
        AppMethodBeat.o(269488);
        return;
        paramRect.left = ((int)this.rrg);
        paramRect.right = ((int)this.rrh);
        AppMethodBeat.o(269488);
        return;
        paramRect.left = ((int)this.rri);
        paramRect.right = ((int)this.rrj);
        AppMethodBeat.o(269488);
        return;
        paramRect.left = ((int)this.rrk);
        paramRect.right = ((int)this.rrl);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */