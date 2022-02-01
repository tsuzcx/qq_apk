package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/RoundLinearLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "radiusPercent", "", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "setRadius", "percent", "plugin-finder_release"})
public class RoundLinearLayout
  extends LinearLayout
{
  private float tUd;
  
  public RoundLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(244509);
    this.tUd = 0.5F;
    AppMethodBeat.o(244509);
  }
  
  public RoundLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(244510);
    this.tUd = 0.5F;
    AppMethodBeat.o(244510);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(244508);
    p.h(paramCanvas, "canvas");
    Path localPath = new Path();
    float f1 = getWidth();
    float f2 = getHeight();
    float f3 = getWidth();
    float f4 = this.tUd;
    float f5 = getHeight();
    localPath.addRoundRect(0.0F, 0.0F, f1, f2, f4 * f3, this.tUd * f5, Path.Direction.CW);
    paramCanvas.clipPath(localPath);
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(244508);
  }
  
  public final void setRadius(float paramFloat)
  {
    AppMethodBeat.i(244507);
    if ((paramFloat >= 0.0F) && (paramFloat <= 0.5F))
    {
      this.tUd = paramFloat;
      invalidate();
    }
    AppMethodBeat.o(244507);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.RoundLinearLayout
 * JD-Core Version:    0.7.0.1
 */