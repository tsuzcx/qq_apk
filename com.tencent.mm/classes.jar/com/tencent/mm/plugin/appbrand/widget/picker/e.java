package com.tencent.mm.plugin.appbrand.widget.picker;

import android.text.Editable;
import android.text.Editable.Factory;
import android.text.SpannableStringBuilder;
import android.widget.EditText;
import android.widget.NumberPicker;
import com.tencent.mm.compatible.loader.c;

final class e
{
  static void a(NumberPicker paramNumberPicker)
  {
    if (paramNumberPicker == null) {}
    for (;;)
    {
      return;
      try
      {
        paramNumberPicker = (EditText)new c(paramNumberPicker, "mInputText", null).get();
        if (paramNumberPicker != null)
        {
          paramNumberPicker.setEditableFactory(new Editable.Factory()
          {
            public final Editable newEditable(CharSequence paramAnonymousCharSequence)
            {
              new SpannableStringBuilder(paramAnonymousCharSequence)
              {
                public final void setSpan(Object paramAnonymous2Object, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
                {
                  try
                  {
                    super.setSpan(paramAnonymous2Object, paramAnonymous2Int1, paramAnonymous2Int2, paramAnonymous2Int3);
                    return;
                  }
                  catch (Exception paramAnonymous2Object) {}
                }
              };
            }
          });
          return;
        }
      }
      catch (Exception paramNumberPicker) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.e
 * JD-Core Version:    0.7.0.1
 */