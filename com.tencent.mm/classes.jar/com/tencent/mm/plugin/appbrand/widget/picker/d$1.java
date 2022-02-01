package com.tencent.mm.plugin.appbrand.widget.picker;

import android.text.Editable;
import android.text.Editable.Factory;
import android.text.SpannableStringBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$1
  extends Editable.Factory
{
  public final Editable newEditable(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(138085);
    paramCharSequence = new SpannableStringBuilder(paramCharSequence)
    {
      public final void setSpan(Object paramAnonymousObject, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(138084);
        try
        {
          super.setSpan(paramAnonymousObject, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
          AppMethodBeat.o(138084);
          return;
        }
        catch (Exception paramAnonymousObject)
        {
          AppMethodBeat.o(138084);
        }
      }
    };
    AppMethodBeat.o(138085);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.d.1
 * JD-Core Version:    0.7.0.1
 */