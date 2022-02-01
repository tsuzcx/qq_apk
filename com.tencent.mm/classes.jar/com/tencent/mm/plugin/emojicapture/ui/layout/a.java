package com.tencent.mm.plugin.emojicapture.ui.layout;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/layout/CenterSmoothScroller;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "calculateDxToMakeVisible", "", "view", "Landroid/view/View;", "snapPreference", "calculateDyToMakeVisible", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends o
{
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(881);
    AppMethodBeat.o(881);
  }
  
  public final int I(View paramView, int paramInt)
  {
    AppMethodBeat.i(879);
    s.u(paramView, "view");
    RecyclerView.LayoutManager localLayoutManager = getLayoutManager();
    if ((localLayoutManager == null) || (!localLayoutManager.canScrollVertically()))
    {
      AppMethodBeat.o(879);
      return 0;
    }
    paramInt = (paramView.getTop() + paramView.getBottom()) / 2;
    int i = localLayoutManager.getHeight() / 2;
    AppMethodBeat.o(879);
    return i - paramInt;
  }
  
  public final int J(View paramView, int paramInt)
  {
    AppMethodBeat.i(878);
    s.u(paramView, "view");
    RecyclerView.LayoutManager localLayoutManager = getLayoutManager();
    if ((localLayoutManager == null) || (!localLayoutManager.canScrollHorizontally()))
    {
      AppMethodBeat.o(878);
      return 0;
    }
    paramInt = (paramView.getLeft() + paramView.getRight()) / 2;
    int i = localLayoutManager.getWidth() / 2;
    AppMethodBeat.o(878);
    return i - paramInt;
  }
  
  public final float c(DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(880);
    s.u(paramDisplayMetrics, "displayMetrics");
    float f = 50.0F / paramDisplayMetrics.densityDpi;
    AppMethodBeat.o(880);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.layout.a
 * JD-Core Version:    0.7.0.1
 */