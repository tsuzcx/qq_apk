package com.tencent.mm.plugin.appbrand.jsapi.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.a;
import com.tencent.mm.plugin.appbrand.widget.picker.c;
import com.tencent.mm.sdk.platformtools.bo;

final class h$1$1
  implements Runnable
{
  h$1$1(h.1 param1, int paramInt, AppBrandMultiOptionsPicker.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(126356);
    AppBrandMultiOptionsPicker localAppBrandMultiOptionsPicker = (AppBrandMultiOptionsPicker)h.1.a(this.hWS, AppBrandMultiOptionsPicker.class);
    if (localAppBrandMultiOptionsPicker == null)
    {
      this.hWS.l("fail picker not exists", null);
      AppMethodBeat.o(126356);
      return;
    }
    int i = this.hWQ;
    AppBrandMultiOptionsPicker.a locala = this.hWR;
    if ((i >= 0) && (i < localAppBrandMultiOptionsPicker.getPickersCount()) && (locala != null))
    {
      localAppBrandMultiOptionsPicker.setLayoutFrozen(true);
      localAppBrandMultiOptionsPicker.qI(i).setOptionsArray(locala.jsq);
      if (!bo.Q(locala.jsq)) {
        localAppBrandMultiOptionsPicker.qI(i).setValue(locala.selected);
      }
      localAppBrandMultiOptionsPicker.setLayoutFrozen(false);
    }
    this.hWS.l("ok", null);
    AppMethodBeat.o(126356);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.h.1.1
 * JD-Core Version:    0.7.0.1
 */