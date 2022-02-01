package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.au.d;
import com.tencent.mm.plugin.appbrand.widget.recent.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/utils/AppBrandDesktopItemDecorationHelper;", "", "()V", "Companion", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a rra;
  
  static
  {
    AppMethodBeat.i(264100);
    rra = new a((byte)0);
    AppMethodBeat.o(264100);
  }
  
  public static final float a(RecyclerView paramRecyclerView, float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(264102);
    paramFloat = a.a(paramRecyclerView, paramFloat, paramInt1, paramInt2, 0, 0);
    AppMethodBeat.o(264102);
    return paramFloat;
  }
  
  public static final float a(RecyclerView paramRecyclerView, float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(264101);
    paramFloat = a.a(paramRecyclerView, paramFloat, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(264101);
    return paramFloat;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/utils/AppBrandDesktopItemDecorationHelper$Companion;", "", "()V", "setupItemDecoration", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "targetMargin", "width", "", "lineGap", "posOffset", "topMargin", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static float a(RecyclerView paramRecyclerView, float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(268375);
      p.k(paramRecyclerView, "recyclerView");
      float f2 = (paramInt1 - 4.0F * f.eE(paramRecyclerView.getContext()) - 2.0F * paramFloat) / 3.0F;
      float f1;
      if (f2 <= com.tencent.mm.ci.a.aZ(paramRecyclerView.getContext(), au.d.Edge_0_5_A)) {
        f1 = com.tencent.mm.ci.a.aY(paramRecyclerView.getContext(), au.d.Edge_A);
      }
      for (paramFloat = (paramInt1 - 4.0F * f.eE(paramRecyclerView.getContext()) - 2.0F * f1) / 3.0F;; paramFloat = f2)
      {
        float f6 = paramInt1 / 4.0F;
        float f7 = f.eE(paramRecyclerView.getContext());
        f2 = f6 - f1 - f7;
        float f3 = paramFloat - f2;
        float f4 = f6 - f3 - f7;
        float f5 = paramFloat - f4;
        f6 = f6 - f5 - f7;
        while (paramRecyclerView.getItemDecorationCount() > 0) {
          paramRecyclerView.la();
        }
        paramRecyclerView.b((RecyclerView.h)new a.a.a(paramInt3, paramInt2, paramInt4, f1, f2, f3, f4, f5, f6, paramFloat - f6, f1));
        AppMethodBeat.o(268375);
        return f1;
        f1 = paramFloat;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.a
 * JD-Core Version:    0.7.0.1
 */