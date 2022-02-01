package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.d;
import com.tencent.mm.plugin.appbrand.widget.desktop.d;
import com.tencent.mm.plugin.appbrand.widget.recent.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/utils/AppBrandDesktopItemDecorationHelper;", "", "()V", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a uBl;
  
  static
  {
    AppMethodBeat.i(324261);
    uBl = new a((byte)0);
    AppMethodBeat.o(324261);
  }
  
  public static final float a(RecyclerView paramRecyclerView, float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(324256);
    s.u(paramRecyclerView, "recyclerView");
    paramFloat = a.a(paramRecyclerView, paramFloat, paramInt1, paramInt2, 0, 0);
    AppMethodBeat.o(324256);
    return paramFloat;
  }
  
  public static final float a(RecyclerView paramRecyclerView, float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(324252);
    paramFloat = a.a(paramRecyclerView, paramFloat, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(324252);
    return paramFloat;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/utils/AppBrandDesktopItemDecorationHelper$Companion;", "", "()V", "setupItemDecoration", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "targetMargin", "width", "", "lineGap", "posOffset", "topMargin", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static float a(RecyclerView paramRecyclerView, float paramFloat, int paramInt1, final int paramInt2, int paramInt3, final int paramInt4)
    {
      AppMethodBeat.i(324259);
      s.u(paramRecyclerView, "recyclerView");
      final float f2 = (paramInt1 - 4.0F * f.fz(paramRecyclerView.getContext()) - 2.0F * paramFloat) / 3.0F;
      final float f1;
      if (f2 <= com.tencent.mm.cd.a.bs(paramRecyclerView.getContext(), ba.d.Edge_0_5_A)) {
        f1 = com.tencent.mm.cd.a.br(paramRecyclerView.getContext(), ba.d.Edge_A);
      }
      for (paramFloat = (paramInt1 - 4.0F * f.fz(paramRecyclerView.getContext()) - 2.0F * f1) / 3.0F;; paramFloat = f2)
      {
        final float f6 = paramInt1 / 4.0F;
        float f7 = f.fz(paramRecyclerView.getContext());
        f2 = f6 - f1 - f7;
        final float f3 = paramFloat - f2;
        final float f4 = f6 - f3 - f7;
        final float f5 = paramFloat - f4;
        f6 = f6 - f5 - f7;
        while (paramRecyclerView.getItemDecorationCount() > 0) {
          paramRecyclerView.JL();
        }
        paramRecyclerView.a((RecyclerView.h)new a(paramInt3, paramInt2, paramInt4, f1, f2, f3, f4, f5, f6, paramFloat - f6, f1));
        AppMethodBeat.o(324259);
        return f1;
        f1 = paramFloat;
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/widget/desktop/utils/AppBrandDesktopItemDecorationHelper$Companion$setupItemDecoration$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends RecyclerView.h
    {
      a(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8) {}
      
      public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
      {
        AppMethodBeat.i(324264);
        s.u(paramRect, "outRect");
        s.u(paramView, "view");
        s.u(paramRecyclerView, "parent");
        s.u(params, "state");
        super.a(paramRect, paramView, paramRecyclerView, params);
        int i = RecyclerView.bA(paramView);
        paramView = paramRecyclerView.bj(paramView);
        if ((!(paramView instanceof d)) || ((((d)paramView).caO != 1) && (((d)paramView).caO != 2)))
        {
          paramRect.top = 0;
          paramRect.left = 0;
          paramRect.right = 0;
          AppMethodBeat.o(324264);
          return;
        }
        if (i == -1) {
          i = ((d)paramView).caM;
        }
        for (;;)
        {
          i -= this.uBm;
          if (i / 4 > 0)
          {
            paramRect.top = paramInt2;
            paramRect.bottom = 0;
            switch (i % 4)
            {
            }
          }
          for (;;)
          {
            AppMethodBeat.o(324264);
            return;
            paramRect.top = paramInt4;
            break;
            paramRect.left = ((int)f1);
            paramRect.right = ((int)f2);
            AppMethodBeat.o(324264);
            return;
            paramRect.left = ((int)f3);
            paramRect.right = ((int)f4);
            AppMethodBeat.o(324264);
            return;
            paramRect.left = ((int)f5);
            paramRect.right = ((int)f6);
            AppMethodBeat.o(324264);
            return;
            paramRect.left = ((int)this.uBv);
            paramRect.right = ((int)f1);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.a
 * JD-Core Version:    0.7.0.1
 */