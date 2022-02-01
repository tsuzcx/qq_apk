package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.c;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShadeView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgColor", "getBgColor", "()I", "setBgColor", "(I)V", "value", "Landroid/graphics/Rect;", "highLightRect", "getHighLightRect", "()Landroid/graphics/Rect;", "setHighLightRect", "(Landroid/graphics/Rect;)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveShadeView
  extends View
{
  private Rect DPq;
  private int bgColor;
  
  public FinderLiveShadeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
    AppMethodBeat.i(358305);
    AppMethodBeat.o(358305);
  }
  
  public FinderLiveShadeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(358291);
    this.bgColor = paramContext.getResources().getColor(a.c.BW_0_Alpha_0_8);
    AppMethodBeat.o(358291);
  }
  
  public final int getBgColor()
  {
    return this.bgColor;
  }
  
  public final Rect getHighLightRect()
  {
    return this.DPq;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(358330);
    super.onDraw(paramCanvas);
    Rect localRect = this.DPq;
    if (localRect != null)
    {
      if (paramCanvas != null) {
        paramCanvas.clipRect(localRect, Region.Op.DIFFERENCE);
      }
      if (paramCanvas != null) {
        paramCanvas.drawColor(getBgColor());
      }
    }
    AppMethodBeat.o(358330);
  }
  
  public final void setBgColor(int paramInt)
  {
    this.bgColor = paramInt;
  }
  
  public final void setHighLightRect(Rect paramRect)
  {
    AppMethodBeat.i(358315);
    this.DPq = paramRect;
    invalidate();
    AppMethodBeat.o(358315);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveShadeView
 * JD-Core Version:    0.7.0.1
 */