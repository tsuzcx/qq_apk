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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/RoundLinearLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "plugin-finder_release"})
public class RoundLinearLayout
  extends LinearLayout
{
  public RoundLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(202307);
    AppMethodBeat.o(202307);
  }
  
  public RoundLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(202308);
    AppMethodBeat.o(202308);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(202306);
    p.h(paramCanvas, "canvas");
    Path localPath = new Path();
    localPath.addCircle(getWidth() / 2.0F, getHeight() / 2.0F, getWidth() / 2.0F, Path.Direction.CW);
    paramCanvas.clipPath(localPath);
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(202306);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.RoundLinearLayout
 * JD-Core Version:    0.7.0.1
 */