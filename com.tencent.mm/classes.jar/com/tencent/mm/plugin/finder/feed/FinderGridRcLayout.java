package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderGridRcLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "cornerDp", "", "getCornerDp", "()F", "radiusArray", "", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "plugin-finder_release"})
public final class FinderGridRcLayout
  extends FrameLayout
{
  private final float tOp;
  private final float[] tOq;
  
  public FinderGridRcLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(243888);
    this.tOp = (a.fromDPToPix(getContext(), 8) * 1.0F);
    this.tOq = new float[] { this.tOp, this.tOp, this.tOp, this.tOp, this.tOp, this.tOp, this.tOp, this.tOp };
    AppMethodBeat.o(243888);
  }
  
  public FinderGridRcLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(243889);
    this.tOp = (a.fromDPToPix(getContext(), 8) * 1.0F);
    this.tOq = new float[] { this.tOp, this.tOp, this.tOp, this.tOp, this.tOp, this.tOp, this.tOp, this.tOp };
    AppMethodBeat.o(243889);
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(243886);
    p.h(paramCanvas, "canvas");
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(243886);
  }
  
  public final float getCornerDp()
  {
    return this.tOp;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(243887);
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1), 1073741824));
    AppMethodBeat.o(243887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.FinderGridRcLayout
 * JD-Core Version:    0.7.0.1
 */