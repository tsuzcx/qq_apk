package com.tencent.mm.plugin.appbrand.widget.picker;

import android.widget.EditText;
import android.widget.NumberPicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.c;

final class e
{
  static void a(NumberPicker paramNumberPicker)
  {
    AppMethodBeat.i(126754);
    if (paramNumberPicker == null)
    {
      AppMethodBeat.o(126754);
      return;
    }
    try
    {
      paramNumberPicker = (EditText)new c(paramNumberPicker, "mInputText", null).get();
      if (paramNumberPicker != null) {
        paramNumberPicker.setEditableFactory(new e.1());
      }
      AppMethodBeat.o(126754);
      return;
    }
    catch (Exception paramNumberPicker)
    {
      AppMethodBeat.o(126754);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.e
 * JD-Core Version:    0.7.0.1
 */