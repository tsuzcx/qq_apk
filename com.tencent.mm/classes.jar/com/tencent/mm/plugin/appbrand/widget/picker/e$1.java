package com.tencent.mm.plugin.appbrand.widget.picker;

import android.text.Editable;
import android.text.Editable.Factory;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$1
  extends Editable.Factory
{
  public final Editable newEditable(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(126753);
    paramCharSequence = new e.1.1(this, paramCharSequence);
    AppMethodBeat.o(126753);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.e.1
 * JD-Core Version:    0.7.0.1
 */