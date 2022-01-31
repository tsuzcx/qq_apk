package com.tencent.mm.cd;

import android.text.SpannableString;
import com.tencent.mm.pluginsdk.ui.d.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.bk;

public final class g
  implements d
{
  private static g ult;
  private int uls = 300;
  
  public static g csM()
  {
    if (ult == null) {
      ult = new g();
    }
    return ult;
  }
  
  public final SpannableString a(CharSequence paramCharSequence, float paramFloat)
  {
    if ((paramCharSequence == null) || (bk.bl(paramCharSequence.toString()))) {
      return new SpannableString("");
    }
    return g(paramCharSequence, (int)paramFloat);
  }
  
  public final SpannableString g(CharSequence paramCharSequence, int paramInt)
  {
    if ((paramCharSequence == null) || (bk.bl(paramCharSequence.toString()))) {
      return new SpannableString("");
    }
    if ((paramCharSequence == null) || (bk.bl(paramCharSequence.toString()))) {
      return new SpannableString("");
    }
    if ((paramCharSequence instanceof SpannableString)) {}
    for (paramCharSequence = (SpannableString)paramCharSequence;; paramCharSequence = new SpannableString(paramCharSequence))
    {
      PInt localPInt = new PInt();
      localPInt.value = this.uls;
      paramCharSequence = b.csC().a(paramCharSequence, paramInt, localPInt);
      return f.csI().b(paramCharSequence, paramInt, localPInt.value);
    }
  }
  
  public final boolean v(CharSequence paramCharSequence)
  {
    b.csC();
    return b.aas(paramCharSequence.toString());
  }
  
  public final boolean w(CharSequence paramCharSequence)
  {
    return f.csI().aau(paramCharSequence.toString()) != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.cd.g
 * JD-Core Version:    0.7.0.1
 */