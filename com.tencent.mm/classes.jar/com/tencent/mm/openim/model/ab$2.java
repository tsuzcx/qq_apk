package com.tencent.mm.openim.model;

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
import com.tencent.mm.plugin.comm.c.g;
import com.tencent.mm.ui.base.EllipsizeTextView.a;

final class ab$2
  implements EllipsizeTextView.a
{
  ab$2(ab paramab) {}
  
  public final CharSequence a(TextView paramTextView, CharSequence paramCharSequence, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(151235);
    paramString = paramTextView.getContext().getResources().getDrawable(c.g.open_im_main_logo);
    paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
    float f1 = paramString.getIntrinsicWidth();
    float f2 = paramTextView.getPaint().measureText(" ");
    paramTextView = TextUtils.ellipsize(paramCharSequence, paramTextView.getPaint(), paramTextView.getMeasuredWidth() - paramTextView.getCompoundPaddingRight() - paramTextView.getCompoundPaddingLeft() - (f1 + f2), TextUtils.TruncateAt.END);
    paramCharSequence = new SpannableStringBuilder(paramTextView);
    paramCharSequence.append(" ");
    paramCharSequence.setSpan(new ImageSpan(paramString), paramTextView.length(), paramTextView.length() + 1, 33);
    AppMethodBeat.o(151235);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.model.ab.2
 * JD-Core Version:    0.7.0.1
 */