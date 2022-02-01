package com.tencent.luggage.game.d.a.a;

import com.tencent.magicbrush.ui.MBViewManager.a;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.utils.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;

final class a$4
  implements MBViewManager.a
{
  a$4(a parama) {}
  
  public final void a(MagicBrushView paramMagicBrushView) {}
  
  public final void b(MagicBrushView paramMagicBrushView)
  {
    AppMethodBeat.i(190404);
    a.e locale = new a.e(this.ckh, (byte)0);
    p.h(locale, "l");
    paramMagicBrushView.cAh.add(locale);
    paramMagicBrushView.a(new a.d(this.ckh, (byte)0));
    AppMethodBeat.o(190404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.game.d.a.a.a.4
 * JD-Core Version:    0.7.0.1
 */