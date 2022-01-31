package com.tencent.mm.plugin.appbrand.page;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(14)
public final class bj
{
  public static void a(Canvas paramCanvas, View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(91121);
    if (paramView.getVisibility() != 0)
    {
      AppMethodBeat.o(91121);
      return;
    }
    if ((paramView instanceof TextureView))
    {
      paramView = ((TextureView)paramView).getBitmap(paramView.getWidth(), paramView.getHeight());
      if ((paramView != null) && (!paramView.isRecycled())) {
        paramCanvas.drawBitmap(paramView, paramFloat1, paramFloat2, null);
      }
      AppMethodBeat.o(91121);
      return;
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        View localView = paramView.getChildAt(i);
        a(paramCanvas, localView, localView.getX() + paramFloat1, localView.getY() + paramFloat2);
        i += 1;
      }
      AppMethodBeat.o(91121);
      return;
    }
    paramCanvas.save();
    paramCanvas.translate(paramFloat1, paramFloat2);
    paramView.draw(paramCanvas);
    paramCanvas.restore();
    AppMethodBeat.o(91121);
  }
  
  public static boolean i(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(91122);
    if ((paramViewGroup == null) || (paramViewGroup.getChildCount() == 0))
    {
      AppMethodBeat.o(91122);
      return false;
    }
    int j = paramViewGroup.getChildCount();
    int i = 0;
    boolean bool1 = false;
    boolean bool2;
    for (;;)
    {
      bool2 = bool1;
      if (i >= j) {
        break;
      }
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof TextureView)) {
        bool1 = true;
      }
      if ((localView instanceof ViewGroup)) {
        bool1 = i((ViewGroup)localView);
      }
      bool2 = bool1;
      if (bool1) {
        break;
      }
      i += 1;
    }
    AppMethodBeat.o(91122);
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bj
 * JD-Core Version:    0.7.0.1
 */