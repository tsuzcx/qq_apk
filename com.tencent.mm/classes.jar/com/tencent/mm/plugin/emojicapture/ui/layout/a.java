package com.tencent.mm.plugin.emojicapture.ui.layout;

import android.content.Context;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/ui/layout/CenterSmoothScroller;", "Landroid/support/v7/widget/LinearSmoothScroller;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "calculateDxToMakeVisible", "", "view", "Landroid/view/View;", "snapPreference", "calculateDyToMakeVisible", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-emojicapture_release"})
public final class a
  extends ae
{
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(881);
    AppMethodBeat.o(881);
  }
  
  public final int E(View paramView, int paramInt)
  {
    AppMethodBeat.i(879);
    p.h(paramView, "view");
    RecyclerView.i locali = getLayoutManager();
    if ((locali == null) || (!locali.kd()))
    {
      AppMethodBeat.o(879);
      return 0;
    }
    paramInt = (paramView.getTop() + paramView.getBottom()) / 2;
    int i = locali.getHeight() / 2;
    AppMethodBeat.o(879);
    return i - paramInt;
  }
  
  public final int F(View paramView, int paramInt)
  {
    AppMethodBeat.i(878);
    p.h(paramView, "view");
    RecyclerView.i locali = getLayoutManager();
    if ((locali == null) || (!locali.kc()))
    {
      AppMethodBeat.o(878);
      return 0;
    }
    paramInt = (paramView.getLeft() + paramView.getRight()) / 2;
    int i = locali.getWidth() / 2;
    AppMethodBeat.o(878);
    return i - paramInt;
  }
  
  public final float a(DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(880);
    p.h(paramDisplayMetrics, "displayMetrics");
    float f = 50.0F / paramDisplayMetrics.densityDpi;
    AppMethodBeat.o(880);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.layout.a
 * JD-Core Version:    0.7.0.1
 */