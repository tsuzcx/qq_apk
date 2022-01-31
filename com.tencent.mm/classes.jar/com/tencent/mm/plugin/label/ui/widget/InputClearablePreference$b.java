package com.tencent.mm.plugin.label.ui.widget;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class InputClearablePreference$b
  implements InputFilter
{
  public final char[] nZQ;
  
  InputClearablePreference$b(InputClearablePreference paramInputClearablePreference)
  {
    AppMethodBeat.i(22707);
    this.nZQ = new char[] { 10, 44, 59, 12289, -244, -229 };
    AppMethodBeat.o(22707);
  }
  
  public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(22708);
    ab.d("MicroMsg.Label.InputClearablePreference", "on create tag filter, %s [%d, %d) %s [%d, %d),", new Object[] { paramCharSequence, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramSpanned, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    paramInt4 = paramInt1;
    while (paramInt4 < paramInt2)
    {
      paramSpanned = new char[paramInt2 - paramInt1];
      TextUtils.getChars(paramCharSequence, paramInt1, paramInt2, paramSpanned, 0);
      int j = this.nZQ.length;
      int i = 0;
      while (i < j)
      {
        if ((paramSpanned[paramInt4] == ' ') && (paramInt3 == 0) && (paramInt4 == 0))
        {
          AppMethodBeat.o(22708);
          return "";
        }
        if (paramSpanned[paramInt4] == this.nZQ[i])
        {
          this.nZP.iQ(true);
          AppMethodBeat.o(22708);
          return "";
        }
        i += 1;
      }
      paramInt4 += 1;
    }
    AppMethodBeat.o(22708);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.widget.InputClearablePreference.b
 * JD-Core Version:    0.7.0.1
 */