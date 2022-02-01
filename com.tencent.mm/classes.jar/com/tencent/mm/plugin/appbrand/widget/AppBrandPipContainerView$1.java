package com.tencent.mm.plugin.appbrand.widget;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandPipContainerView$1
  extends ViewOutlineProvider
{
  AppBrandPipContainerView$1(AppBrandPipContainerView paramAppBrandPipContainerView) {}
  
  public final void getOutline(View paramView, Outline paramOutline)
  {
    AppMethodBeat.i(176789);
    paramOutline.setRoundRect(new Rect(0, 0, paramView.getWidth(), paramView.getHeight()), AppBrandPipContainerView.access$000());
    AppMethodBeat.o(176789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView.1
 * JD-Core Version:    0.7.0.1
 */