package com.tencent.mm.plugin.label.ui.widget;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.y;

final class InputClearablePreference$b
  implements InputFilter
{
  public final char[] lCE = { 10, 44, 59, 12289, -244, -229 };
  
  InputClearablePreference$b(InputClearablePreference paramInputClearablePreference) {}
  
  public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    y.d("MicroMsg.Label.InputClearablePreference", "on create tag filter, %s [%d, %d) %s [%d, %d),", new Object[] { paramCharSequence, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramSpanned, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    paramInt4 = paramInt1;
    while (paramInt4 < paramInt2)
    {
      paramSpanned = new char[paramInt2 - paramInt1];
      TextUtils.getChars(paramCharSequence, paramInt1, paramInt2, paramSpanned, 0);
      int j = this.lCE.length;
      int i = 0;
      while (i < j)
      {
        if ((paramSpanned[paramInt4] == ' ') && (paramInt3 == 0) && (paramInt4 == 0)) {
          return "";
        }
        if (paramSpanned[paramInt4] == this.lCE[i])
        {
          this.lCD.hg(true);
          return "";
        }
        i += 1;
      }
      paramInt4 += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.widget.InputClearablePreference.b
 * JD-Core Version:    0.7.0.1
 */