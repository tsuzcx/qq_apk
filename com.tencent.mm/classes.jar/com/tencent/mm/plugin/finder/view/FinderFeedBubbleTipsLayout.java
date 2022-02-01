package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderFeedBubbleTipsLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "temLocation1", "", "temLocation2", "views", "Landroid/util/SparseArray;", "Landroid/view/View;", "getView", "T", "viewId", "(I)Landroid/view/View;", "moveViewAboveLikeTargetView", "", "view", "targetView", "onLayout", "changed", "", "left", "top", "right", "bottom", "plugin-finder_release"})
public final class FinderFeedBubbleTipsLayout
  extends FrameLayout
{
  private final int[] sTR;
  private final int[] sTS;
  private final SparseArray<View> sTT;
  
  public FinderFeedBubbleTipsLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(205116);
    this.sTR = new int[2];
    this.sTS = new int[2];
    this.sTT = new SparseArray();
    AppMethodBeat.o(205116);
  }
  
  public FinderFeedBubbleTipsLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(205117);
    this.sTR = new int[2];
    this.sTS = new int[2];
    this.sTT = new SparseArray();
    AppMethodBeat.o(205117);
  }
  
  private <T extends View> T Gd(int paramInt)
  {
    AppMethodBeat.i(205115);
    View localView2 = (View)this.sTT.get(paramInt);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView2 = findViewById(paramInt);
      localView1 = localView2;
      if (localView2 != null)
      {
        this.sTT.put(paramInt, localView2);
        localView1 = localView2;
      }
    }
    if (localView1 != null)
    {
      AppMethodBeat.o(205115);
      return localView1;
    }
    AppMethodBeat.o(205115);
    return null;
  }
  
  private final void j(View paramView1, View paramView2)
  {
    AppMethodBeat.i(205114);
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
            paramView2.getLocationInWindow(this.sTR);
            getLocationInWindow(this.sTS);
            i = this.sTR[1] - this.sTS[1];
            if (i > 0) {
              paramView1.layout(paramView1.getLeft(), i - paramView1.getHeight(), paramView1.getRight(), i);
            }
            AppMethodBeat.o(205114);
            return;
            i = 0;
            break;
            label94:
            paramView1 = null;
            continue;
          }
          AppMethodBeat.o(205114);
          return;
        }
      }
    }
    AppMethodBeat.o(205114);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 1;
    AppMethodBeat.i(205113);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    View localView1 = Gd(2131308184);
    View localView2;
    if (localView1 != null)
    {
      localView2 = Gd(2131303506);
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
        localView2 = ((FinderFeedBubbleTipsLayout)this).Gd(2131297023);
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
      j(Gd(2131308110), localView2);
      j(Gd(2131308309), localView2);
      AppMethodBeat.o(205113);
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