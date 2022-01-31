package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPicker;
import com.tencent.mm.plugin.appbrand.widget.picker.a;
import com.tencent.mm.plugin.appbrand.widget.picker.b;

final class i$2
  implements Runnable
{
  i$2(i parami, String[] paramArrayOfString, int paramInt) {}
  
  public final void run()
  {
    i locali = this.gzS;
    String[] arrayOfString = this.gzT;
    int i = this.gzU;
    AppBrandOptionsPicker localAppBrandOptionsPicker = (AppBrandOptionsPicker)locali.N(AppBrandOptionsPicker.class);
    if (localAppBrandOptionsPicker == null)
    {
      locali.j("fail cant init view", null);
      return;
    }
    a locala = locali.hzI;
    locala.post(new i.3(locali, locala));
    localAppBrandOptionsPicker.setOptionsArray(arrayOfString);
    localAppBrandOptionsPicker.setValue(i);
    locala.setOnResultListener(new i.4(locali, locala, localAppBrandOptionsPicker));
    locala.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.i.2
 * JD-Core Version:    0.7.0.1
 */