package com.tencent.luggage.xweb_ext.extendplugin.component.a.a;

import android.os.Handler;
import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class a$21
  implements a.a
{
  a$21(a parama) {}
  
  public final void gF(int paramInt)
  {
    AppMethodBeat.i(138821);
    ae.i(this.csS.getLogTag(), "onBackground, type: ".concat(String.valueOf(paramInt)));
    a locala = this.csS;
    if (locala.csz != null) {
      locala.csz.post(new a.23(locala, paramInt));
    }
    AppMethodBeat.o(138821);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(138822);
    a locala = this.csS;
    if (locala.csz != null) {
      locala.csz.post(new a.24(locala));
    }
    AppMethodBeat.o(138822);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(138820);
    ae.i(this.csS.getLogTag(), "onForeground");
    a locala = this.csS;
    if (locala.csz != null) {
      locala.csz.post(new a.22(locala));
    }
    AppMethodBeat.o(138820);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a.21
 * JD-Core Version:    0.7.0.1
 */