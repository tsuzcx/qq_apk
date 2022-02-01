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
  private static final b mHt;
  
  static
  {
    AppMethodBeat.i(136677);
    mHt = new b()
    {
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
      
      public final b.a tR(int paramAnonymousInt)
      {
        return null;
      }
    };
    AppMethodBeat.o(136677);
  }
  
  public static b bAU()
  {
    AppMethodBeat.i(136676);
    b localb = (b)e.K(b.class);
    if (localb == null)
    {
      localb = mHt;
      AppMethodBeat.o(136676);
      return localb;
    }
    AppMethodBeat.o(136676);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.a.a
 * JD-Core Version:    0.7.0.1
 */