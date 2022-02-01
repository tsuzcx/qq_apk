package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/RCLinearLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "cornerDp", "", "getCornerDp", "()F", "radiusArray", "", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "plugin-finder_release"})
public class RCLinearLayout
  extends LinearLayout
{
  private final float tOp;
  private final float[] tOq;
  
  public RCLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(166006);
    this.tOp = (a.fromDPToPix(getContext(), 4) * 1.0F);
    this.tOq = new float[] { this.tOp, this.tOp, this.tOp, this.tOp, this.tOp, this.tOp, this.tOp, this.tOp };
    AppMethodBeat.o(166006);
  }
  
  public RCLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(166007);
    this.tOp = (a.fromDPToPix(getContext(), 4) * 1.0F);
    this.tOq = new float[] { this.tOp, this.tOp, this.tOp, this.tOp, this.tOp, this.tOp, this.tOp, this.tOp };
    AppMethodBeat.o(166007);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(166005);
    p.h(paramCanvas, "canvas");
    Path localPath = new Path();
    localPath.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), this.tOq, Path.Direction.CW);
    paramCanvas.clipPath(localPath);
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(166005);
  }
  
  public final float getCornerDp()
  {
    return this.tOp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.RCLinearLayout
 * JD-Core Version:    0.7.0.1
 */