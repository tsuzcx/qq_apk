package com.tencent.luggage.game.page;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.widget.ImageView;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$4
  implements WAGamePageViewContainerLayout.a
{
  h$4(h paramh) {}
  
  public final void a(WAGamePageViewContainerLayout.b paramb1, WAGamePageViewContainerLayout.b paramb2)
  {
    AppMethodBeat.i(140509);
    d.v("Luggage.Game.WAGamePageViewRenderer", "hy: after change. old direction:%s, new direction: %s", new Object[] { paramb1, paramb2 });
    if (h.d(this.bCd) == null)
    {
      d.e("Luggage.Game.WAGamePageViewRenderer", "hy: screenshot is null");
      AppMethodBeat.o(140509);
      return;
    }
    if (((h.a(paramb1)) && (h.a(paramb2))) || ((h.b(paramb1)) && (h.b(paramb2))))
    {
      AppMethodBeat.o(140509);
      return;
    }
    if (h.a(paramb2))
    {
      Matrix localMatrix = new Matrix();
      if (((paramb2 == WAGamePageViewContainerLayout.b.bBP) && (paramb1 == WAGamePageViewContainerLayout.b.bBQ)) || ((paramb2 == WAGamePageViewContainerLayout.b.bBR) && (paramb1 == WAGamePageViewContainerLayout.b.bBS))) {
        localMatrix.postRotate(90.0F);
      }
      for (;;)
      {
        h.e(this.bCd).setVisibility(0);
        h.e(this.bCd).setImageBitmap(Bitmap.createBitmap(h.d(this.bCd), 0, 0, h.d(this.bCd).getWidth(), h.d(this.bCd).getHeight(), localMatrix, true));
        AppMethodBeat.o(140509);
        return;
        localMatrix.postRotate(270.0F);
      }
    }
    h.b(this.bCd).setOnConfigurationChangedListener(null);
    AppMethodBeat.o(140509);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.page.h.4
 * JD-Core Version:    0.7.0.1
 */