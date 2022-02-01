package com.tencent.mm.plugin.appbrand.widget.picker;

import android.widget.EditText;
import android.widget.NumberPicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.c;

final class d
{
  static void a(NumberPicker paramNumberPicker)
  {
    AppMethodBeat.i(138086);
    if (paramNumberPicker == null)
    {
      AppMethodBeat.o(138086);
      return;
    }
    try
    {
      paramNumberPicker = (EditText)new c(paramNumberPicker, "mInputText", null).get();
      if (paramNumberPicker != null) {
        paramNumberPicker.setEditableFactory(new d.1());
      }
      AppMethodBeat.o(138086);
      return;
    }
    catch (Exception paramNumberPicker)
    {
      AppMethodBeat.o(138086);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.d
 * JD-Core Version:    0.7.0.1
 */