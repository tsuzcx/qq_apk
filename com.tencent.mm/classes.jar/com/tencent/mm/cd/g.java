package com.tencent.mm.cd;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.d.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.bo;

public final class g
  implements d
{
  private static g yuX;
  private int yuW = 300;
  
  public static g dvk()
  {
    AppMethodBeat.i(62691);
    if (yuX == null) {
      yuX = new g();
    }
    g localg = yuX;
    AppMethodBeat.o(62691);
    return localg;
  }
  
  private SpannableString q(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(62694);
    if ((paramCharSequence == null) || (bo.isNullOrNil(paramCharSequence.toString())))
    {
      paramCharSequence = new SpannableString("");
      AppMethodBeat.o(62694);
      return paramCharSequence;
    }
    if ((paramCharSequence instanceof SpannableString)) {}
    for (paramCharSequence = (SpannableString)paramCharSequence;; paramCharSequence = new SpannableString(paramCharSequence))
    {
      PInt localPInt = new PInt();
      localPInt.value = this.yuW;
      paramCharSequence = b.duW().a(paramCharSequence, paramInt, localPInt);
      paramCharSequence = f.dvf().b(paramCharSequence, paramInt, localPInt.value);
      AppMethodBeat.o(62694);
      return paramCharSequence;
    }
  }
  
  public final boolean E(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(62696);
    b.duW();
    boolean bool = b.aqB(paramCharSequence.toString());
    AppMethodBeat.o(62696);
    return bool;
  }
  
  public final boolean F(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(62695);
    boolean bool = f.dvf().aqD(paramCharSequence.toString());
    AppMethodBeat.o(62695);
    return bool;
  }
  
  public final SpannableString b(CharSequence paramCharSequence, float paramFloat)
  {
    AppMethodBeat.i(62693);
    if ((paramCharSequence == null) || (bo.isNullOrNil(paramCharSequence.toString())))
    {
      paramCharSequence = new SpannableString("");
      AppMethodBeat.o(62693);
      return paramCharSequence;
    }
    paramCharSequence = p(paramCharSequence, (int)paramFloat);
    AppMethodBeat.o(62693);
    return paramCharSequence;
  }
  
  public final SpannableString p(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(62692);
    if ((paramCharSequence == null) || (bo.isNullOrNil(paramCharSequence.toString())))
    {
      paramCharSequence = new SpannableString("");
      AppMethodBeat.o(62692);
      return paramCharSequence;
    }
    paramCharSequence = q(paramCharSequence, paramInt);
    AppMethodBeat.o(62692);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.cd.g
 * JD-Core Version:    0.7.0.1
 */