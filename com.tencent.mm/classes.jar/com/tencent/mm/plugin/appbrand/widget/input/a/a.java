package com.tencent.mm.plugin.appbrand.widget.input.a;

import android.content.Context;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableString;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;

public final class a
{
  private static final b uKD;
  
  static
  {
    AppMethodBeat.i(136677);
    uKD = new b()
    {
      public final b.a Ch(int paramAnonymousInt)
      {
        return null;
      }
      
      public final Spannable a(Spannable paramAnonymousSpannable, int paramAnonymousInt, PInt paramAnonymousPInt, Spannable.Factory paramAnonymousFactory)
      {
        return paramAnonymousSpannable;
      }
      
      public final SpannableString a(Context paramAnonymousContext, CharSequence paramAnonymousCharSequence, float paramAnonymousFloat)
      {
        AppMethodBeat.i(177121);
        if (paramAnonymousCharSequence == null)
        {
          AppMethodBeat.o(177121);
          return null;
        }
        paramAnonymousContext = new SpannableString(paramAnonymousCharSequence);
        AppMethodBeat.o(177121);
        return paramAnonymousContext;
      }
    };
    AppMethodBeat.o(136677);
  }
  
  public static b cSb()
  {
    AppMethodBeat.i(136676);
    b localb = (b)e.T(b.class);
    if (localb == null)
    {
      localb = uKD;
      AppMethodBeat.o(136676);
      return localb;
    }
    AppMethodBeat.o(136676);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.a.a
 * JD-Core Version:    0.7.0.1
 */