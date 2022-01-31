package com.tencent.mm.openim.b;

import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.TextAppearanceSpan;
import android.widget.TextView;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.ui.base.EllipsizeTextView.a;

final class s$1
  implements EllipsizeTextView.a
{
  s$1(s params) {}
  
  public final CharSequence a(TextView paramTextView, CharSequence paramCharSequence, String paramString, int paramInt1, int paramInt2)
  {
    float f = paramTextView.getPaint().measureText(" " + paramString);
    paramCharSequence = TextUtils.ellipsize(paramCharSequence, paramTextView.getPaint(), paramTextView.getMeasuredWidth() - paramTextView.getCompoundPaddingRight() - paramTextView.getCompoundPaddingLeft() - f, TextUtils.TruncateAt.END);
    SpannableString localSpannableString = j.b(paramTextView.getContext(), paramCharSequence + " " + paramString);
    paramTextView = a.h(paramTextView.getContext(), paramInt1);
    localSpannableString.setSpan(new TextAppearanceSpan(null, 0, paramInt2, paramTextView, paramTextView), paramCharSequence.length() + 1, paramCharSequence.length() + 1 + paramString.length(), 33);
    return localSpannableString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.b.s.1
 * JD-Core Version:    0.7.0.1
 */