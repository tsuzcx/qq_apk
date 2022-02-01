package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.HardTouchableLayout;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderFeedBubbleTipsLayout;", "Lcom/tencent/mm/view/HardTouchableLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "temLocation1", "", "temLocation2", "getView", "T", "Landroid/view/View;", "viewId", "(I)Landroid/view/View;", "moveViewAboveLikeTargetView", "", "view", "targetView", "onLayout", "changed", "", "left", "top", "right", "bottom", "plugin-finder_release"})
public final class FinderFeedBubbleTipsLayout
  extends HardTouchableLayout
{
  private final int[] wme;
  private final int[] wmf;
  
  public FinderFeedBubbleTipsLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(254796);
    this.wme = new int[2];
    this.wmf = new int[2];
    AppMethodBeat.o(254796);
  }
  
  public FinderFeedBubbleTipsLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(254797);
    this.wme = new int[2];
    this.wmf = new int[2];
    AppMethodBeat.o(254797);
  }
  
  private <T extends View> T Mn(int paramInt)
  {
    AppMethodBeat.i(254795);
    View localView = findViewById(paramInt);
    if (localView != null)
    {
      AppMethodBeat.o(254795);
      return localView;
    }
    AppMethodBeat.o(254795);
    return null;
  }
  
  private final void k(View paramView1, View paramView2)
  {
    AppMethodBeat.i(254794);
    if (paramView1 != null)
    {
      int i;
      if (paramView1.getVisibility() == 0)
      {
        i = 1;
        if (i == 0) {
          break label94;
        }
      }
      for (;;)
      {
        if (paramView1 != null)
        {
          if (paramView2 != null)
          {
            paramView2.getLocationInWindow(this.wme);
            getLocationInWindow(this.wmf);
            i = this.wme[1] - this.wmf[1];
            if (i > 0) {
              paramView1.layout(paramView1.getLeft(), i - paramView1.getHeight(), paramView1.getRight(), i);
            }
            AppMethodBeat.o(254794);
            return;
            i = 0;
            break;
            label94:
            paramView1 = null;
            continue;
          }
          AppMethodBeat.o(254794);
          return;
        }
      }
    }
    AppMethodBeat.o(254794);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 1;
    AppMethodBeat.i(254793);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    View localView1 = Mn(2131306267);
    View localView2;
    if (localView1 != null)
    {
      localView2 = Mn(2131306272);
      if ((localView2 != null) && (localView2.getVisibility() == 0))
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label140;
        }
        label59:
        if (localView1 == null) {
          break label146;
        }
        label64:
        if (localView1 != null) {
          break label163;
        }
        localView2 = ((FinderFeedBubbleTipsLayout)this).Mn(2131297154);
        if (localView2 == null) {
          break label163;
        }
        if (localView2.getVisibility() != 0) {
          break label152;
        }
        paramInt1 = i;
        label96:
        if (paramInt1 == 0) {
          break label157;
        }
        label100:
        if (localView2 == null) {
          break label163;
        }
      }
    }
    for (;;)
    {
      k(Mn(2131301471), localView2);
      k(Mn(2131301408), localView2);
      AppMethodBeat.o(254793);
      return;
      paramInt1 = 0;
      break;
      label140:
      localView1 = null;
      break label59;
      label146:
      localView1 = null;
      break label64;
      label152:
      paramInt1 = 0;
      break label96;
      label157:
      localView2 = null;
      break label100;
      label163:
      localView2 = localView1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderFeedBubbleTipsLayout
 * JD-Core Version:    0.7.0.1
 */