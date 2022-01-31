package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.a;
import com.tencent.mm.plugin.appbrand.widget.picker.c;
import com.tencent.mm.sdk.platformtools.bk;

final class h$1$1
  implements Runnable
{
  h$1$1(h.1 param1, int paramInt, AppBrandMultiOptionsPicker.a parama) {}
  
  public final void run()
  {
    AppBrandMultiOptionsPicker localAppBrandMultiOptionsPicker = (AppBrandMultiOptionsPicker)h.1.a(this.gzR, AppBrandMultiOptionsPicker.class);
    if (localAppBrandMultiOptionsPicker == null)
    {
      this.gzR.j("fail picker not exists", null);
      return;
    }
    int i = this.gzP;
    AppBrandMultiOptionsPicker.a locala = this.gzQ;
    if ((i >= 0) && (i < localAppBrandMultiOptionsPicker.getPickersCount()) && (locala != null))
    {
      localAppBrandMultiOptionsPicker.setLayoutFrozen(true);
      localAppBrandMultiOptionsPicker.nb(i).setOptionsArray(locala.hAa);
      if (!bk.H(locala.hAa)) {
        localAppBrandMultiOptionsPicker.nb(i).setValue(locala.hAb);
      }
      localAppBrandMultiOptionsPicker.setLayoutFrozen(false);
    }
    this.gzR.j("ok", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.h.1.1
 * JD-Core Version:    0.7.0.1
 */