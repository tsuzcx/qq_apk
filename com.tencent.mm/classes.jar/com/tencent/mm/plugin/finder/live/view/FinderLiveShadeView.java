package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a.c;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShadeView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgColor", "getBgColor", "()I", "setBgColor", "(I)V", "value", "Landroid/graphics/Rect;", "highLightRect", "getHighLightRect", "()Landroid/graphics/Rect;", "setHighLightRect", "(Landroid/graphics/Rect;)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "plugin-finder_release"})
public final class FinderLiveShadeView
  extends View
{
  private int bgColor;
  private Rect yVD;
  
  public FinderLiveShadeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  public FinderLiveShadeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(288042);
    this.bgColor = paramContext.getResources().getColor(a.c.BW_0_Alpha_0_8);
    AppMethodBeat.o(288042);
  }
  
  public final int getBgColor()
  {
    return this.bgColor;
  }
  
  public final Rect getHighLightRect()
  {
    return this.yVD;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(288041);
    super.onDraw(paramCanvas);
    Rect localRect = this.yVD;
    if (localRect != null)
    {
      if (paramCanvas != null) {
        paramCanvas.clipRect(localRect, Region.Op.DIFFERENCE);
      }
      if (paramCanvas != null)
      {
        paramCanvas.drawColor(this.bgColor);
        AppMethodBeat.o(288041);
        return;
      }
      AppMethodBeat.o(288041);
      return;
    }
    AppMethodBeat.o(288041);
  }
  
  public final void setBgColor(int paramInt)
  {
    this.bgColor = paramInt;
  }
  
  public final void setHighLightRect(Rect paramRect)
  {
    AppMethodBeat.i(288040);
    this.yVD = paramRect;
    invalidate();
    AppMethodBeat.o(288040);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveShadeView
 * JD-Core Version:    0.7.0.1
 */