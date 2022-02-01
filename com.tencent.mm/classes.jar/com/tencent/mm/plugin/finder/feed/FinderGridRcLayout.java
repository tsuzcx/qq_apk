package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderGridRcLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "cornerDp", "", "getCornerDp", "()F", "radiusArray", "", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "plugin-finder_release"})
public final class FinderGridRcLayout
  extends FrameLayout
{
  private final float seI;
  private final float[] seJ;
  
  public FinderGridRcLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(202333);
    this.seI = (a.fromDPToPix(getContext(), 8) * 1.0F);
    this.seJ = new float[] { this.seI, this.seI, this.seI, this.seI, this.seI, this.seI, this.seI, this.seI };
    AppMethodBeat.o(202333);
  }
  
  public FinderGridRcLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(202334);
    this.seI = (a.fromDPToPix(getContext(), 8) * 1.0F);
    this.seJ = new float[] { this.seI, this.seI, this.seI, this.seI, this.seI, this.seI, this.seI, this.seI };
    AppMethodBeat.o(202334);
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(202331);
    p.h(paramCanvas, "canvas");
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(202331);
  }
  
  public final float getCornerDp()
  {
    return this.seI;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202332);
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1), 1073741824));
    AppMethodBeat.o(202332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.FinderGridRcLayout
 * JD-Core Version:    0.7.0.1
 */