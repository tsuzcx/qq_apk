package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/RoundLinearLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "radiusPercent", "", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "setRadius", "percent", "plugin-finder_release"})
public class RoundLinearLayout
  extends LinearLayout
{
  private float sjD;
  
  public RoundLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(202773);
    this.sjD = 0.5F;
    AppMethodBeat.o(202773);
  }
  
  public RoundLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(202774);
    this.sjD = 0.5F;
    AppMethodBeat.o(202774);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(202772);
    p.h(paramCanvas, "canvas");
    Path localPath = new Path();
    float f1 = getWidth();
    float f2 = getHeight();
    float f3 = getWidth();
    float f4 = this.sjD;
    float f5 = getHeight();
    localPath.addRoundRect(0.0F, 0.0F, f1, f2, f4 * f3, this.sjD * f5, Path.Direction.CW);
    paramCanvas.clipPath(localPath);
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(202772);
  }
  
  public final void setRadius(float paramFloat)
  {
    AppMethodBeat.i(202771);
    if ((paramFloat >= 0.0F) && (paramFloat <= 0.5F))
    {
      this.sjD = paramFloat;
      invalidate();
    }
    AppMethodBeat.o(202771);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.RoundLinearLayout
 * JD-Core Version:    0.7.0.1
 */