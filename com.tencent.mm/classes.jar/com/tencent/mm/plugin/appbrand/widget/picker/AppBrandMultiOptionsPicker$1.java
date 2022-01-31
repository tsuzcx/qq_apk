package com.tencent.mm.plugin.appbrand.widget.picker;

import com.tencent.luggage.c.a.a.c;

final class AppBrandMultiOptionsPicker$1
  implements YANumberPicker.b
{
  AppBrandMultiOptionsPicker$1(AppBrandMultiOptionsPicker paramAppBrandMultiOptionsPicker) {}
  
  public final void a(YANumberPicker paramYANumberPicker, int paramInt)
  {
    if (AppBrandMultiOptionsPicker.a(this.hzZ) != null)
    {
      int i = ((Integer)paramYANumberPicker.getTag(a.c.app_brand_multi_options_picker_view_index_tag)).intValue();
      paramYANumberPicker = AppBrandMultiOptionsPicker.a(this.hzZ);
      if (paramYANumberPicker.hAl != null) {
        paramYANumberPicker.hAl.aR(new int[] { i, paramInt });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.1
 * JD-Core Version:    0.7.0.1
 */