package com.tencent.mm.e;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.view.b.a.b;

final class c$2
  implements a.b
{
  c$2(c paramc) {}
  
  public final void CO()
  {
    AppMethodBeat.i(116151);
    this.cdH.cdv = true;
    Rect localRect;
    if (this.cdH.ccS.dqf() == null)
    {
      localRect = new Rect();
      ab.e("MicroMsg.CropArtist", "getImageBitmap is null!");
    }
    for (;;)
    {
      this.cdH.ccS.dqc().getBaseBoardView().p(localRect);
      c.a(this.cdH, 200L, true, false);
      AppMethodBeat.o(116151);
      return;
      localRect = new Rect(0, 0, this.cdH.ccS.dqf().getWidth(), this.cdH.ccS.dqf().getHeight());
    }
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(116152);
    c.a(this.cdH, false);
    this.cdH.cdv = false;
    c.a(this.cdH);
    com.tencent.mm.y.a.jx(282);
    AppMethodBeat.o(116152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.e.c.2
 * JD-Core Version:    0.7.0.1
 */