package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.widget.NumberPicker;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandTimePicker;
import com.tencent.mm.plugin.appbrand.widget.picker.a;
import com.tencent.mm.plugin.appbrand.widget.picker.b;
import com.tencent.mm.plugin.appbrand.widget.picker.f;

final class j$1
  implements Runnable
{
  j$1(j paramj) {}
  
  public final void run()
  {
    j localj = this.gAd;
    AppBrandTimePicker localAppBrandTimePicker = (AppBrandTimePicker)localj.N(AppBrandTimePicker.class);
    if (localAppBrandTimePicker == null)
    {
      localj.j("fail cant init view", null);
      return;
    }
    a locala = localj.hzI;
    int i = localj.gzX;
    int j = localj.gzY;
    localAppBrandTimePicker.gzX = i;
    localAppBrandTimePicker.gzY = j;
    if ((f.ne(localAppBrandTimePicker.gzX)) && (localAppBrandTimePicker.hAo != null)) {
      localAppBrandTimePicker.hAo.setMinValue(localAppBrandTimePicker.gzX);
    }
    i = localj.gzZ;
    j = localj.gAa;
    localAppBrandTimePicker.gzZ = i;
    localAppBrandTimePicker.gAa = j;
    if ((f.ne(localAppBrandTimePicker.gzZ)) && (localAppBrandTimePicker.hAo != null)) {
      localAppBrandTimePicker.hAo.setMaxValue(localAppBrandTimePicker.gzZ);
    }
    i = localj.gAb;
    j = localj.gAc;
    if ((f.ne(i)) && (f.nd(j)))
    {
      localAppBrandTimePicker.setCurrentHour(Integer.valueOf(i));
      localAppBrandTimePicker.setCurrentMinute(Integer.valueOf(j));
    }
    localAppBrandTimePicker.asR();
    locala.setOnResultListener(new j.2(localj));
    locala.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.j.1
 * JD-Core Version:    0.7.0.1
 */