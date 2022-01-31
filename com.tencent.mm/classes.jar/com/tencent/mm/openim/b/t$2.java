package com.tencent.mm.openim.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ImageSpan;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.EllipsizeTextView.a;

final class t$2
  implements EllipsizeTextView.a
{
  t$2(t paramt) {}
  
  public final CharSequence a(TextView paramTextView, CharSequence paramCharSequence, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78891);
    paramString = paramTextView.getContext().getResources().getDrawable(2131231831);
    paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
    float f1 = paramString.getIntrinsicWidth();
    float f2 = paramTextView.getPaint().measureText(" ");
    paramTextView = TextUtils.ellipsize(paramCharSequence, paramTextView.getPaint(), paramTextView.getMeasuredWidth() - paramTextView.getCompoundPaddingRight() - paramTextView.getCompoundPaddingLeft() - (f1 + f2), TextUtils.TruncateAt.END);
    paramCharSequence = new SpannableStringBuilder(paramTextView);
    paramCharSequence.append(" ");
    paramCharSequence.setSpan(new ImageSpan(paramString), paramTextView.length(), paramTextView.length() + 1, 33);
    AppMethodBeat.o(78891);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.openim.b.t.2
 * JD-Core Version:    0.7.0.1
 */