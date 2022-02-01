package com.tencent.mm.plugin.appbrand.widget.input.a;

import android.content.Context;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;

final class a$1
  implements b
{
  public final Spannable a(Spannable paramSpannable, int paramInt, PInt paramPInt, Spannable.Factory paramFactory)
  {
    return paramSpannable;
  }
  
  public final SpannableString a(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    AppMethodBeat.i(177121);
    if (paramCharSequence == null)
    {
      AppMethodBeat.o(177121);
      return null;
    }
    paramContext = new SpannableString(paramCharSequence);
    AppMethodBeat.o(177121);
    return paramContext;
  }
  
  public final b.a uv(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.a.a.1
 * JD-Core Version:    0.7.0.1
 */