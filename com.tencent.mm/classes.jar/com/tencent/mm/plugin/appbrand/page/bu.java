package com.tencent.mm.plugin.appbrand.page;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bu
{
  public static void a(View paramView, Canvas paramCanvas)
  {
    AppMethodBeat.i(140769);
    boolean bool;
    if (paramView.getVisibility() != 0) {
      bool = true;
    }
    while (bool)
    {
      AppMethodBeat.o(140769);
      return;
      if ((paramView instanceof bt))
      {
        bool = ((bt)paramView).c(paramCanvas);
      }
      else
      {
        paramView.draw(paramCanvas);
        bool = false;
      }
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        a(paramView.getChildAt(i), paramCanvas);
        i += 1;
      }
    }
    AppMethodBeat.o(140769);
  }
  
  public static Bitmap cJ(View paramView)
  {
    AppMethodBeat.i(140770);
    if ((paramView.getWidth() <= 0) || (paramView.getHeight() <= 0))
    {
      AppMethodBeat.o(140770);
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
    a(paramView, new Canvas(localBitmap));
    AppMethodBeat.o(140770);
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bu
 * JD-Core Version:    0.7.0.1
 */