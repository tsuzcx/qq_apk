package com.tencent.mm.live.core.mini;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/mini/LiveMiniViewOutlineProvider;", "Landroid/view/ViewOutlineProvider;", "radius", "", "(F)V", "getRadius", "()F", "setRadius", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends ViewOutlineProvider
{
  private float radius;
  
  public d(float paramFloat)
  {
    this.radius = paramFloat;
  }
  
  public final void getOutline(View paramView, Outline paramOutline)
  {
    AppMethodBeat.i(247623);
    Rect localRect = new Rect();
    if (paramView != null) {
      paramView.getDrawingRect(localRect);
    }
    paramView = new Rect(0, 0, localRect.right - localRect.left + 0, localRect.bottom - localRect.top + 0);
    if (paramOutline != null) {
      paramOutline.setRoundRect(paramView, this.radius);
    }
    AppMethodBeat.o(247623);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.mini.d
 * JD-Core Version:    0.7.0.1
 */