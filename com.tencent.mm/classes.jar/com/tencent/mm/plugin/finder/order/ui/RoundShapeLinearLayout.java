package com.tencent.mm.plugin.finder.order.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/order/ui/RoundShapeLinearLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "path", "Landroid/graphics/Path;", "radiusPercent", "", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public class RoundShapeLinearLayout
  extends LinearLayout
{
  private float BbN;
  private final Path path;
  
  public RoundShapeLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(332411);
    this.BbN = 0.5F;
    this.path = new Path();
    AppMethodBeat.o(332411);
  }
  
  public RoundShapeLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(332415);
    this.BbN = 0.5F;
    this.path = new Path();
    AppMethodBeat.o(332415);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(332421);
    s.u(paramCanvas, "canvas");
    this.path.reset();
    Path localPath = this.path;
    float f1 = getWidth();
    float f2 = getHeight();
    float f3 = getWidth();
    float f4 = this.BbN;
    float f5 = getHeight();
    localPath.addRoundRect(0.0F, 0.0F, f1, f2, f4 * f3, this.BbN * f5, Path.Direction.CW);
    paramCanvas.clipPath(this.path);
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(332421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.order.ui.RoundShapeLinearLayout
 * JD-Core Version:    0.7.0.1
 */