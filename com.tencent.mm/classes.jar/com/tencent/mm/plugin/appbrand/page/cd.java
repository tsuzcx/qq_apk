package com.tencent.mm.plugin.appbrand.page;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cd
{
  static void a(View paramView1, View paramView2, Canvas paramCanvas)
  {
    boolean bool = true;
    float f2 = 0.0F;
    AppMethodBeat.i(207647);
    if (paramView2.getVisibility() != 0) {}
    while (bool)
    {
      AppMethodBeat.o(207647);
      return;
      if ((paramView2 instanceof cc)) {
        bool = ((cc)paramView2).d(paramCanvas);
      } else if ((paramView2 instanceof ViewGroup)) {
        bool = false;
      } else {
        paramView2.draw(paramCanvas);
      }
    }
    if ((paramView2 instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView2;
      float f1;
      if (paramView1 == paramView2)
      {
        f1 = 0.0F;
        if (paramView1 != paramView2) {
          break label214;
        }
      }
      for (;;)
      {
        paramCanvas.save();
        paramCanvas.translate(f1, f2);
        localViewGroup.draw(paramCanvas);
        int i = 0;
        while (i < localViewGroup.getChildCount())
        {
          paramView2 = localViewGroup.getChildAt(i);
          f1 = paramView2.getLeft();
          f2 = paramView2.getX();
          float f3 = paramView2.getTop();
          float f4 = paramView2.getY();
          paramCanvas.save();
          paramCanvas.translate(f1 + f2, f3 + f4);
          a(paramView1, paramView2, paramCanvas);
          paramCanvas.restore();
          i += 1;
        }
        f1 = localViewGroup.getLeft() + localViewGroup.getX();
        break;
        label214:
        f2 = localViewGroup.getTop() + localViewGroup.getY();
      }
      paramCanvas.restore();
    }
    AppMethodBeat.o(207647);
  }
  
  public static Bitmap cW(View paramView)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.cd
 * JD-Core Version:    0.7.0.1
 */