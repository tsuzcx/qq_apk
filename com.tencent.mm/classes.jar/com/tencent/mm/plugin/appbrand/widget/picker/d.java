package com.tencent.mm.plugin.appbrand.widget.picker;

import android.text.Editable;
import android.text.Editable.Factory;
import android.text.SpannableStringBuilder;
import android.widget.EditText;
import android.widget.NumberPicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.b;

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
      paramNumberPicker = (EditText)new b(paramNumberPicker, "mInputText", null).get();
      if (paramNumberPicker != null) {
        paramNumberPicker.setEditableFactory(new Editable.Factory()
        {
          public final Editable newEditable(CharSequence paramAnonymousCharSequence)
          {
            AppMethodBeat.i(138085);
            paramAnonymousCharSequence = new SpannableStringBuilder(paramAnonymousCharSequence)
            {
              public final void setSpan(Object paramAnonymous2Object, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
              {
                AppMethodBeat.i(138084);
                try
                {
                  super.setSpan(paramAnonymous2Object, paramAnonymous2Int1, paramAnonymous2Int2, paramAnonymous2Int3);
                  AppMethodBeat.o(138084);
                  return;
                }
                catch (Exception paramAnonymous2Object)
                {
                  AppMethodBeat.o(138084);
                }
              }
            };
            AppMethodBeat.o(138085);
            return paramAnonymousCharSequence;
          }
        });
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