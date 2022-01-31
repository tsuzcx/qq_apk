package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$4
  implements a.a
{
  a$4(a parama) {}
  
  public final void fx(int paramInt)
  {
    AppMethodBeat.i(154413);
    a locala = this.bHR;
    ab.i(locala.xo(), "*** handler(%s) handleWebViewBackground, type:%d", new Object[] { locala.tX(), Integer.valueOf(paramInt) });
    locala.bHP = true;
    new a.6(locala, paramInt).run();
    AppMethodBeat.o(154413);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(154414);
    a locala = this.bHR;
    ab.i(locala.xo(), "*** handler(%s) handleWebViewDestroy", new Object[] { locala.tX() });
    locala.release();
    AppMethodBeat.o(154414);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(154412);
    a locala = this.bHR;
    ab.i(locala.xo(), "*** handler(%s) handleWebViewForeground", new Object[] { locala.tX() });
    locala.bHP = false;
    new a.5(locala).run();
    AppMethodBeat.o(154412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.a.4
 * JD-Core Version:    0.7.0.1
 */