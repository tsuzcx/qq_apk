package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import kotlin.Metadata;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderActionBarLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttrs", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "compareLeftPos", "leftFirst", "leftSecond", "onLayout", "", "changed", "", "l", "t", "r", "b", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderActionBarLayout
  extends LinearLayout
{
  public FinderActionBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(345611);
    AppMethodBeat.o(345611);
  }
  
  public FinderActionBarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(345619);
    AppMethodBeat.o(345619);
  }
  
  private static int iE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(345625);
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      paramInt1 = k.qv(paramInt1, paramInt2);
      AppMethodBeat.o(345625);
      return paramInt1;
    }
    if (paramInt2 > 0)
    {
      AppMethodBeat.o(345625);
      return paramInt2;
    }
    AppMethodBeat.o(345625);
    return paramInt1;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(345632);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    View localView1 = findViewById(e.e.tabLayoutContainer);
    if (localView1 == null)
    {
      AppMethodBeat.o(345632);
      return;
    }
    View localView2 = findViewById(e.e.lbsEntranceLayout);
    if (localView2 == null)
    {
      AppMethodBeat.o(345632);
      return;
    }
    View localView3 = findViewById(e.e.searchEntranceLayout);
    if (localView3 == null)
    {
      AppMethodBeat.o(345632);
      return;
    }
    View localView4 = findViewById(e.e.splitEntranceLayout);
    if (localView4 == null)
    {
      AppMethodBeat.o(345632);
      return;
    }
    if ((localView2.getVisibility() != 8) || (localView3.getVisibility() != 8) || (localView4.getVisibility() != 8))
    {
      paramInt1 = 1;
      paramInt4 = iE(iE(localView2.getLeft(), localView3.getLeft()), localView4.getLeft());
      paramInt2 = (getMeasuredWidth() - localView1.getMeasuredWidth()) / 2;
      paramInt3 = localView1.getMeasuredWidth() + paramInt2;
      if ((paramInt1 == 0) || (paramInt3 <= paramInt4)) {
        break label227;
      }
      paramInt1 = paramInt3 - paramInt4;
      paramInt2 -= paramInt1;
    }
    label227:
    for (paramInt1 = paramInt3 - paramInt1;; paramInt1 = paramInt3)
    {
      localView1.layout(paramInt2, localView1.getTop(), paramInt1, localView1.getBottom());
      AppMethodBeat.o(345632);
      return;
      paramInt1 = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderActionBarLayout
 * JD-Core Version:    0.7.0.1
 */