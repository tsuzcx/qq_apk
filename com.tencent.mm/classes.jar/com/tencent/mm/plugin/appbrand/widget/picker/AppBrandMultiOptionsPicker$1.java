package com.tencent.mm.plugin.appbrand.widget.picker;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandMultiOptionsPicker$1
  implements YANumberPicker.b
{
  AppBrandMultiOptionsPicker$1(AppBrandMultiOptionsPicker paramAppBrandMultiOptionsPicker) {}
  
  public final void a(YANumberPicker paramYANumberPicker, int paramInt)
  {
    AppMethodBeat.i(126702);
    if (AppBrandMultiOptionsPicker.a(this.jsp) != null)
    {
      int i = ((Integer)paramYANumberPicker.getTag(2131820564)).intValue();
      paramYANumberPicker = AppBrandMultiOptionsPicker.a(this.jsp);
      if (paramYANumberPicker.jsA != null) {
        paramYANumberPicker.jsA.bl(new int[] { i, paramInt });
      }
    }
    AppMethodBeat.o(126702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.1
 * JD-Core Version:    0.7.0.1
 */