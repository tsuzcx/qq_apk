package com.tencent.mm.plugin.appbrand.widget.picker;

import android.text.SpannableStringBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$1$1
  extends SpannableStringBuilder
{
  e$1$1(e.1 param1, CharSequence paramCharSequence)
  {
    super(paramCharSequence);
  }
  
  public final void setSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(126752);
    try
    {
      super.setSpan(paramObject, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(126752);
      return;
    }
    catch (Exception paramObject)
    {
      AppMethodBeat.o(126752);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.e.1.1
 * JD-Core Version:    0.7.0.1
 */