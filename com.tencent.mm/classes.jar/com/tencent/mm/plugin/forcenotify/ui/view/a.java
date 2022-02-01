package com.tencent.mm.plugin.forcenotify.ui.view;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/forcenotify/ui/view/DefaultScaleAnimator;", "Lcom/tencent/mm/plugin/forcenotify/ui/view/StackLayoutManager$LayoutAnimator;", "visibleCount", "", "(I)V", "getVisibleCount", "()I", "doAnimate", "", "view", "Landroid/view/View;", "position", "centerPosition", "progress", "", "prevView", "nextView", "resetViewAnimateProperty", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements StackLayoutManager.c
{
  private final int Hpq;
  
  public a(int paramInt)
  {
    this.Hpq = paramInt;
  }
  
  public final void a(View paramView1, int paramInt1, int paramInt2, float paramFloat, View paramView2)
  {
    AppMethodBeat.i(275006);
    if (paramView1 == null)
    {
      AppMethodBeat.o(275006);
      return;
    }
    paramInt2 = paramInt1 - paramInt2;
    float f1 = 0.0F;
    float f2 = f1;
    if (paramView2 != null)
    {
      f2 = f1;
      if (paramView2.getMeasuredHeight() != 0)
      {
        f2 = f1;
        if (paramView1.getMeasuredHeight() != 0) {
          f2 = paramView2.getScaleY() * paramView2.getMeasuredHeight() * 1.0F / paramView1.getMeasuredHeight();
        }
      }
    }
    paramView1.setVisibility(0);
    if (paramInt2 == 0)
    {
      f1 = 1.0F - (float)(0.2D * paramFloat);
      paramFloat = 1.0F;
      f2 = f1;
    }
    for (;;)
    {
      paramView1.setPivotX(paramView1.getMeasuredWidth() / 2.0F);
      paramView1.setPivotY(0.0F);
      if (paramInt2 != 0)
      {
        paramView1.setScaleX(f1);
        paramView1.setScaleY(f2);
      }
      float f3;
      for (;;)
      {
        paramView1.setAlpha(paramFloat);
        AppMethodBeat.o(275006);
        return;
        double d = Math.pow(0.95D, paramInt2);
        f3 = (float)(d + (Math.pow(0.95D, paramInt2 - 1) - d) * paramFloat);
        f1 = f2;
        if (paramInt2 == 1) {
          f1 = f2 + (1.0F - f2) * paramFloat;
        }
        if (paramInt2 != this.Hpq) {
          break label257;
        }
        if (paramFloat == 0.0F) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 != 0) {
            paramView1.setVisibility(4);
          }
          f2 = f1;
          f1 = f3;
          break;
        }
        paramView1.setScaleX(1.0F);
        paramView1.setScaleY(1.0F);
      }
      label257:
      paramFloat = 1.0F;
      f2 = f1;
      f1 = f3;
    }
  }
  
  public final void hs(View paramView)
  {
    AppMethodBeat.i(275012);
    if (paramView == null)
    {
      AppMethodBeat.o(275012);
      return;
    }
    paramView.setScaleX(1.0F);
    paramView.setScaleY(1.0F);
    paramView.setAlpha(1.0F);
    AppMethodBeat.o(275012);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.view.a
 * JD-Core Version:    0.7.0.1
 */