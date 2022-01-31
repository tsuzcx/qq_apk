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
import com.tencent.mm.plugin.comm.a.g;
import com.tencent.mm.ui.base.EllipsizeTextView.a;

final class s$2
  implements EllipsizeTextView.a
{
  s$2(s params) {}
  
  public final CharSequence a(TextView paramTextView, CharSequence paramCharSequence, String paramString, int paramInt1, int paramInt2)
  {
    paramString = paramTextView.getContext().getResources().getDrawable(a.g.open_im_main_logo);
    paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
    float f1 = paramString.getIntrinsicWidth();
    float f2 = paramTextView.getPaint().measureText(" ");
    paramTextView = TextUtils.ellipsize(paramCharSequence, paramTextView.getPaint(), paramTextView.getMeasuredWidth() - paramTextView.getCompoundPaddingRight() - paramTextView.getCompoundPaddingLeft() - (f1 + f2), TextUtils.TruncateAt.END);
    paramCharSequence = new SpannableStringBuilder(paramTextView);
    paramCharSequence.append(" ");
    paramCharSequence.setSpan(new ImageSpan(paramString), paramTextView.length(), paramTextView.length() + 1, 33);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.s.2
 * JD-Core Version:    0.7.0.1
 */