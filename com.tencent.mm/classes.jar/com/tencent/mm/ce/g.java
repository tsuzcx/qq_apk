package com.tencent.mm.ce;

import android.content.Context;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
  implements com.tencent.mm.pluginsdk.ui.span.f
{
  private static g NLp;
  private int NLo = 300;
  
  public static g gxZ()
  {
    AppMethodBeat.i(104946);
    if (NLp == null) {
      NLp = new g();
    }
    g localg = NLp;
    AppMethodBeat.o(104946);
    return localg;
  }
  
  private SpannableString m(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(104949);
    if ((paramCharSequence == null) || (Util.isNullOrNil(paramCharSequence.toString())))
    {
      paramCharSequence = new SpannableString("");
      AppMethodBeat.o(104949);
      return paramCharSequence;
    }
    if ((paramCharSequence instanceof SpannableString)) {}
    for (paramCharSequence = (SpannableString)paramCharSequence;; paramCharSequence = new SpannableString(paramCharSequence))
    {
      PInt localPInt = new PInt();
      localPInt.value = this.NLo;
      paramCharSequence = b.gxI().a(paramCharSequence, paramInt, localPInt);
      paramCharSequence = f.gxT().b(paramCharSequence, paramInt, localPInt.value);
      AppMethodBeat.o(104949);
      return paramCharSequence;
    }
  }
  
  public final boolean M(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(104951);
    b.gxI();
    boolean bool = b.bia(paramCharSequence.toString());
    AppMethodBeat.o(104951);
    return bool;
  }
  
  public final boolean N(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(104950);
    boolean bool = f.gxT().bif(paramCharSequence.toString());
    AppMethodBeat.o(104950);
    return bool;
  }
  
  public final SpannableString a(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    AppMethodBeat.i(199817);
    if ((paramCharSequence == null) || (Util.isNullOrNil(paramCharSequence.toString())))
    {
      paramContext = new SpannableString("");
      AppMethodBeat.o(199817);
      return paramContext;
    }
    paramContext = b(paramContext, paramCharSequence, (int)paramFloat);
    AppMethodBeat.o(199817);
    return paramContext;
  }
  
  public final SpannableString b(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(199816);
    if ((paramCharSequence == null) || (Util.isNullOrNil(paramCharSequence.toString())))
    {
      paramContext = new SpannableString("");
      AppMethodBeat.o(199816);
      return paramContext;
    }
    paramContext = m(paramCharSequence, paramInt);
    AppMethodBeat.o(199816);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ce.g
 * JD-Core Version:    0.7.0.1
 */