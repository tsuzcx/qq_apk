package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.finder.b.l;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/RCLinearLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "cornerDp", "", "radiusArray", "", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "initAttribute", "defStyle", "plugin-finder_release"})
public class RCLinearLayout
  extends LinearLayout
{
  private float xyP;
  private float[] xyQ;
  
  public RCLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(166006);
    this.xyP = (a.fromDPToPix(getContext(), 4) * 1.0F);
    this.xyQ = new float[] { this.xyP, this.xyP, this.xyP, this.xyP, this.xyP, this.xyP, this.xyP, this.xyP };
    if (paramAttributeSet != null)
    {
      b(paramAttributeSet, 0);
      AppMethodBeat.o(166006);
      return;
    }
    AppMethodBeat.o(166006);
  }
  
  public RCLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(166007);
    this.xyP = (a.fromDPToPix(getContext(), 4) * 1.0F);
    this.xyQ = new float[] { this.xyP, this.xyP, this.xyP, this.xyP, this.xyP, this.xyP, this.xyP, this.xyP };
    if (paramAttributeSet != null)
    {
      b(paramAttributeSet, paramInt);
      AppMethodBeat.o(166007);
      return;
    }
    AppMethodBeat.o(166007);
  }
  
  private final void b(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(285056);
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, b.l.RCLinearLayout, paramInt, 0);
      if (paramAttributeSet.hasValue(b.l.RCLinearLayout_radius))
      {
        this.xyP = ((int)paramAttributeSet.getDimension(b.l.RCLinearLayout_radius, a.fromDPToPix(getContext(), 4) * 1.0F));
        this.xyQ = new float[] { this.xyP, this.xyP, this.xyP, this.xyP, this.xyP, this.xyP, this.xyP, this.xyP };
        Log.i("RCLinearLayout", "initAttribute cornerDp:" + this.xyP);
      }
      paramAttributeSet.recycle();
    }
    AppMethodBeat.o(285056);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(166005);
    p.k(paramCanvas, "canvas");
    Path localPath = new Path();
    localPath.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), this.xyQ, Path.Direction.CW);
    paramCanvas.clipPath(localPath);
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(166005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.RCLinearLayout
 * JD-Core Version:    0.7.0.1
 */