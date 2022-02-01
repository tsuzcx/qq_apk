package com.tencent.mm.cf;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.bt;

public final class g
  implements e
{
  private static g Ikl;
  private int Ikk = 300;
  
  public static g fng()
  {
    AppMethodBeat.i(104946);
    if (Ikl == null) {
      Ikl = new g();
    }
    g localg = Ikl;
    AppMethodBeat.o(104946);
    return localg;
  }
  
  private SpannableString o(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(104949);
    if ((paramCharSequence == null) || (bt.isNullOrNil(paramCharSequence.toString())))
    {
      paramCharSequence = new SpannableString("");
      AppMethodBeat.o(104949);
      return paramCharSequence;
    }
    if ((paramCharSequence instanceof SpannableString)) {}
    for (paramCharSequence = (SpannableString)paramCharSequence;; paramCharSequence = new SpannableString(paramCharSequence))
    {
      PInt localPInt = new PInt();
      localPInt.value = this.Ikk;
      paramCharSequence = b.fmR().a(paramCharSequence, paramInt, localPInt);
      paramCharSequence = f.fnb().b(paramCharSequence, paramInt, localPInt.value);
      AppMethodBeat.o(104949);
      return paramCharSequence;
    }
  }
  
  public final boolean J(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(104951);
    b.fmR();
    boolean bool = b.aRJ(paramCharSequence.toString());
    AppMethodBeat.o(104951);
    return bool;
  }
  
  public final boolean K(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(104950);
    boolean bool = f.fnb().aRO(paramCharSequence.toString());
    AppMethodBeat.o(104950);
    return bool;
  }
  
  public final SpannableString b(CharSequence paramCharSequence, float paramFloat)
  {
    AppMethodBeat.i(104948);
    if ((paramCharSequence == null) || (bt.isNullOrNil(paramCharSequence.toString())))
    {
      paramCharSequence = new SpannableString("");
      AppMethodBeat.o(104948);
      return paramCharSequence;
    }
    paramCharSequence = n(paramCharSequence, (int)paramFloat);
    AppMethodBeat.o(104948);
    return paramCharSequence;
  }
  
  public final SpannableString n(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(104947);
    if ((paramCharSequence == null) || (bt.isNullOrNil(paramCharSequence.toString())))
    {
      paramCharSequence = new SpannableString("");
      AppMethodBeat.o(104947);
      return paramCharSequence;
    }
    paramCharSequence = o(paramCharSequence, paramInt);
    AppMethodBeat.o(104947);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.cf.g
 * JD-Core Version:    0.7.0.1
 */