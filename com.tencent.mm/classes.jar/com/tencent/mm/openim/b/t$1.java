package com.tencent.mm.openim.b;

import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.TextAppearanceSpan;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.ui.base.EllipsizeTextView.a;

final class t$1
  implements EllipsizeTextView.a
{
  t$1(t paramt) {}
  
  public final CharSequence a(TextView paramTextView, CharSequence paramCharSequence, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78890);
    float f = paramTextView.getPaint().measureText(" ".concat(String.valueOf(paramString)));
    int i = paramTextView.getMeasuredWidth() - paramTextView.getCompoundPaddingRight() - paramTextView.getCompoundPaddingLeft();
    if (f >= i * 0.6D)
    {
      paramCharSequence = TextUtils.ellipsize(paramCharSequence, paramTextView.getPaint(), (float)(i * 0.4D), TextUtils.TruncateAt.END);
      f = paramTextView.getPaint().measureText(paramCharSequence.toString());
      paramString = TextUtils.ellipsize(paramString, paramTextView.getPaint(), i - f - 20.0F, TextUtils.TruncateAt.END);
    }
    for (;;)
    {
      SpannableString localSpannableString = j.b(paramTextView.getContext(), paramCharSequence + " " + paramString);
      paramTextView = a.l(paramTextView.getContext(), paramInt1);
      localSpannableString.setSpan(new TextAppearanceSpan(null, 0, paramInt2, paramTextView, paramTextView), paramCharSequence.length() + 1, paramCharSequence.length() + 1 + paramString.length(), 33);
      AppMethodBeat.o(78890);
      return localSpannableString;
      paramCharSequence = TextUtils.ellipsize(paramCharSequence, paramTextView.getPaint(), i - f, TextUtils.TruncateAt.END);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.openim.b.t.1
 * JD-Core Version:    0.7.0.1
 */