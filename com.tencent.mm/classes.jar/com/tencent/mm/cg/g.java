package com.tencent.mm.cg;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.bt;

public final class g
  implements e
{
  private static g Fba;
  private int FaZ = 300;
  
  public static g eIa()
  {
    AppMethodBeat.i(104946);
    if (Fba == null) {
      Fba = new g();
    }
    g localg = Fba;
    AppMethodBeat.o(104946);
    return localg;
  }
  
  private SpannableString p(CharSequence paramCharSequence, int paramInt)
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
      localPInt.value = this.FaZ;
      paramCharSequence = b.eHL().a(paramCharSequence, paramInt, localPInt);
      paramCharSequence = f.eHV().b(paramCharSequence, paramInt, localPInt.value);
      AppMethodBeat.o(104949);
      return paramCharSequence;
    }
  }
  
  public final boolean J(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(104951);
    b.eHL();
    boolean bool = b.aGK(paramCharSequence.toString());
    AppMethodBeat.o(104951);
    return bool;
  }
  
  public final boolean K(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(104950);
    boolean bool = f.eHV().aGP(paramCharSequence.toString());
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
    paramCharSequence = o(paramCharSequence, (int)paramFloat);
    AppMethodBeat.o(104948);
    return paramCharSequence;
  }
  
  public final SpannableString o(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(104947);
    if ((paramCharSequence == null) || (bt.isNullOrNil(paramCharSequence.toString())))
    {
      paramCharSequence = new SpannableString("");
      AppMethodBeat.o(104947);
      return paramCharSequence;
    }
    paramCharSequence = p(paramCharSequence, paramInt);
    AppMethodBeat.o(104947);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.cg.g
 * JD-Core Version:    0.7.0.1
 */