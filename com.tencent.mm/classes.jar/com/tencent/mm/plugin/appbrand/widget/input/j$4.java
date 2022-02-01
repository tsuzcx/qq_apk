package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.ad.h;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.af;
import com.tencent.mm.plugin.appbrand.page.ad;
import java.lang.ref.WeakReference;

public final class j$4
  implements ai
{
  public j$4(j paramj, WeakReference paramWeakReference, int paramInt) {}
  
  public final void DL(int paramInt)
  {
    AppMethodBeat.i(136383);
    try
    {
      ad localad = (ad)this.oUm.get();
      if (localad == null)
      {
        AppMethodBeat.o(136383);
        return;
      }
      int i = g.Dg(paramInt);
      localad.ct("onKeyboardShow", h.aGm().ak("inputId", this.oUo).ak("height", i).toString());
      new af().a(paramInt, localad.QW(), localad, Integer.valueOf(this.oUo));
      AppMethodBeat.o(136383);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(136383);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.j.4
 * JD-Core Version:    0.7.0.1
 */