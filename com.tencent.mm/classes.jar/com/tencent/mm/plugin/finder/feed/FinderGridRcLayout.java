package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderGridRcLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "cornerDp", "", "getCornerDp", "()F", "radiusArray", "", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "plugin-finder_release"})
public final class FinderGridRcLayout
  extends FrameLayout
{
  private final float rWb;
  private final float[] rWc;
  
  public FinderGridRcLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(201873);
    this.rWb = (a.fromDPToPix(getContext(), 8) * 1.0F);
    this.rWc = new float[] { this.rWb, this.rWb, this.rWb, this.rWb, this.rWb, this.rWb, this.rWb, this.rWb };
    AppMethodBeat.o(201873);
  }
  
  public FinderGridRcLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(201874);
    this.rWb = (a.fromDPToPix(getContext(), 8) * 1.0F);
    this.rWc = new float[] { this.rWb, this.rWb, this.rWb, this.rWb, this.rWb, this.rWb, this.rWb, this.rWb };
    AppMethodBeat.o(201874);
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(201871);
    p.h(paramCanvas, "canvas");
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(201871);
  }
  
  public final float getCornerDp()
  {
    return this.rWb;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(201872);
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1), 1073741824));
    AppMethodBeat.o(201872);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.FinderGridRcLayout
 * JD-Core Version:    0.7.0.1
 */