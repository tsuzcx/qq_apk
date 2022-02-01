package com.tencent.mm.live.core.mini;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/mini/LiveMiniViewOutlineProvider;", "Landroid/view/ViewOutlineProvider;", "radius", "", "(F)V", "getRadius", "()F", "setRadius", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "plugin-core_release"})
public final class e
  extends ViewOutlineProvider
{
  private float radius;
  
  public e(float paramFloat)
  {
    this.radius = paramFloat;
  }
  
  public final void getOutline(View paramView, Outline paramOutline)
  {
    AppMethodBeat.i(196596);
    Rect localRect = new Rect();
    if (paramView != null) {
      paramView.getDrawingRect(localRect);
    }
    paramView = new Rect(0, 0, localRect.right - localRect.left + 0, localRect.bottom - localRect.top + 0);
    if (paramOutline != null)
    {
      paramOutline.setRoundRect(paramView, this.radius);
      AppMethodBeat.o(196596);
      return;
    }
    AppMethodBeat.o(196596);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.mini.e
 * JD-Core Version:    0.7.0.1
 */