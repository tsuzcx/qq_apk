package com.tencent.mm.cl;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Util;

public final class h
  implements f
{
  private static h UYV;
  public int UYU = 300;
  
  private Spannable a(Context paramContext, Spannable paramSpannable, int paramInt)
  {
    AppMethodBeat.i(226224);
    if ((paramSpannable == null) || (Util.isNullOrNil(paramSpannable.toString())))
    {
      paramContext = new SpannableString("");
      AppMethodBeat.o(226224);
      return paramContext;
    }
    paramContext = new PInt();
    paramContext.value = this.UYU;
    paramSpannable = b.htF().a(paramSpannable, paramInt, paramContext);
    paramContext = g.htS().a(paramSpannable, paramInt, paramContext.value);
    AppMethodBeat.o(226224);
    return paramContext;
  }
  
  public static h htZ()
  {
    AppMethodBeat.i(104946);
    if (UYV == null) {
      UYV = new h();
    }
    h localh = UYV;
    AppMethodBeat.o(104946);
    return localh;
  }
  
  public final boolean V(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(104951);
    b.htF();
    boolean bool = b.but(paramCharSequence.toString());
    AppMethodBeat.o(104951);
    return bool;
  }
  
  public final boolean W(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(104950);
    boolean bool = g.htS().bux(paramCharSequence.toString());
    AppMethodBeat.o(104950);
    return bool;
  }
  
  public final SpannableString a(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    AppMethodBeat.i(226219);
    if ((paramCharSequence == null) || (Util.isNullOrNil(paramCharSequence.toString())))
    {
      paramContext = new SpannableString("");
      AppMethodBeat.o(226219);
      return paramContext;
    }
    if ((paramCharSequence instanceof SpannableString)) {}
    for (paramCharSequence = (SpannableString)paramCharSequence;; paramCharSequence = new SpannableString(paramCharSequence))
    {
      paramContext = (SpannableString)a(paramContext, paramCharSequence, (int)paramFloat);
      AppMethodBeat.o(226219);
      return paramContext;
    }
  }
  
  public final CharSequence a(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(226215);
    if ((paramCharSequence == null) || (Util.isNullOrNil(paramCharSequence.toString())))
    {
      paramContext = new SpannableString("");
      AppMethodBeat.o(226215);
      return paramContext;
    }
    if ((paramCharSequence instanceof Spannable)) {}
    for (paramCharSequence = (Spannable)paramCharSequence;; paramCharSequence = new SpannableString(paramCharSequence))
    {
      paramContext = a(paramContext, paramCharSequence, paramInt);
      AppMethodBeat.o(226215);
      return paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.cl.h
 * JD-Core Version:    0.7.0.1
 */