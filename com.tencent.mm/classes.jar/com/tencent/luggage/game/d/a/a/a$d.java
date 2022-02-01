package com.tencent.luggage.game.d.a.a;

import com.tencent.luggage.sdk.b.a.c.c;
import com.tencent.magicbrush.ui.MagicBrushView.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.sdk.platformtools.ad;

final class a$d
  implements MagicBrushView.c
{
  private boolean firstTime = true;
  
  private a$d(a parama) {}
  
  private void Di()
  {
    AppMethodBeat.i(177433);
    c localc = (c)this.ckh.El();
    if (localc != null)
    {
      ad.i("Luggage.AppBrandGameServiceLogicImp", "hy: on resizeWindow");
      localc.a(new q());
    }
    AppMethodBeat.o(177433);
  }
  
  public final void a(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(130556);
    Di();
    AppMethodBeat.o(130556);
  }
  
  public final void a(Object paramObject, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(178032);
    if (this.firstTime)
    {
      this.firstTime = false;
      AppMethodBeat.o(178032);
      return;
    }
    Di();
    AppMethodBeat.o(178032);
  }
  
  public final void b(Object paramObject, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.game.d.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */