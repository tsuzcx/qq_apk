package com.tencent.mm.plugin.finder.live.view.mini;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.ratio.RatioLayout;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/mini/FinderMiniWindowFloatLayout;", "Lcom/tencent/mm/view/ratio/RatioLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "path", "Landroid/graphics/Path;", "radius", "", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "setRadius", "r", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderMiniWindowFloatLayout
  extends RatioLayout
{
  private final Path path;
  private float radius;
  
  public FinderMiniWindowFloatLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(358233);
    this.path = new Path();
    AppMethodBeat.o(358233);
  }
  
  public FinderMiniWindowFloatLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(358238);
    this.path = new Path();
    AppMethodBeat.o(358238);
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(358248);
    s.u(paramCanvas, "canvas");
    if (this.radius <= 0.0F)
    {
      super.dispatchDraw(paramCanvas);
      AppMethodBeat.o(358248);
      return;
    }
    this.path.reset();
    RectF localRectF = new RectF(0.0F, 0.0F, getWidth(), getHeight());
    Path localPath = this.path;
    float f1 = this.radius;
    float f2 = this.radius;
    float f3 = this.radius;
    float f4 = this.radius;
    float f5 = this.radius;
    float f6 = this.radius;
    float f7 = this.radius;
    float f8 = this.radius;
    Path.Direction localDirection = Path.Direction.CCW;
    localPath.addRoundRect(localRectF, new float[] { f1, f2, f3, f4, f5, f6, f7, f8 }, localDirection);
    this.path.close();
    paramCanvas.clipPath(this.path);
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(358248);
  }
  
  public final void setRadius(float paramFloat)
  {
    AppMethodBeat.i(358244);
    this.radius = paramFloat;
    requestLayout();
    AppMethodBeat.o(358244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.mini.FinderMiniWindowFloatLayout
 * JD-Core Version:    0.7.0.1
 */