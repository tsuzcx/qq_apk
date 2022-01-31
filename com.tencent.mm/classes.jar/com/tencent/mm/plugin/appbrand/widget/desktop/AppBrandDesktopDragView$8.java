package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandDesktopDragView$8
  implements ValueAnimator.AnimatorUpdateListener
{
  float jdV = 0.0F;
  float jdW = 0.0F;
  
  AppBrandDesktopDragView$8(AppBrandDesktopDragView paramAppBrandDesktopDragView, int paramInt1, int paramInt2) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(133757);
    try
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue("transY")).floatValue();
      this.jdW += f - this.jdV;
      AppBrandDesktopDragView.f(this.jdT).getBackUpFooterRect().top = ((int)(this.jdX + f));
      ab.v("MicroMsg.AppBrandDesktopDragView", "alvinluo transBackFooterAnim totalValue: %f, top: %d", new Object[] { Float.valueOf(this.jdW), Integer.valueOf(AppBrandDesktopDragView.f(this.jdT).getBackUpFooterRect().top) });
      AppBrandDesktopDragView.f(this.jdT).setExtraBottomHeight(this.jdY - (int)this.jdW);
      AppBrandDesktopDragView.f(this.jdT).requestLayout();
      this.jdV = f;
      if (AppBrandDesktopDragView.f(this.jdT).getParent() != null) {
        ((ViewGroup)AppBrandDesktopDragView.f(this.jdT).getParent()).invalidate();
      }
      AppMethodBeat.o(133757);
      return;
    }
    catch (Exception paramValueAnimator)
    {
      AppMethodBeat.o(133757);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView.8
 * JD-Core Version:    0.7.0.1
 */