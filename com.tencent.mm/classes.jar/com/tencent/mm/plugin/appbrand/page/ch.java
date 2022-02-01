package com.tencent.mm.plugin.appbrand.page;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ch
{
  static void a(View paramView1, View paramView2, Canvas paramCanvas)
  {
    boolean bool = true;
    AppMethodBeat.i(325032);
    if (paramView2.getVisibility() != 0) {}
    while (bool)
    {
      AppMethodBeat.o(325032);
      return;
      if ((paramView2 instanceof cg)) {
        bool = ((cg)paramView2).g(paramCanvas);
      } else if ((paramView2 instanceof ViewGroup)) {
        bool = false;
      } else {
        paramView2.draw(paramCanvas);
      }
    }
    if ((paramView2 instanceof ViewGroup))
    {
      paramView2 = (ViewGroup)paramView2;
      paramView2.draw(paramCanvas);
      int i = 0;
      while (i < paramView2.getChildCount())
      {
        View localView = paramView2.getChildAt(i);
        float f1 = localView.getX();
        float f2 = localView.getY();
        paramCanvas.save();
        paramCanvas.translate(f1, f2);
        a(paramView1, localView, paramCanvas);
        paramCanvas.restore();
        i += 1;
      }
    }
    AppMethodBeat.o(325032);
  }
  
  public static Bitmap dD(View paramView)
  {
    AppMethodBeat.i(140770);
    if ((paramView.getWidth() <= 0) || (paramView.getHeight() <= 0))
    {
      AppMethodBeat.o(140770);
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
    a(paramView, paramView, new Canvas(localBitmap));
    AppMethodBeat.o(140770);
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ch
 * JD-Core Version:    0.7.0.1
 */