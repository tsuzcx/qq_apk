package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.d;
import com.tencent.mm.plugin.appbrand.jsapi.ah.c.a;
import java.util.Objects;

final class a
  implements c.a
{
  private static final ThreadLocal<TextPaint> rTk;
  private final TextPaint bsk;
  private final Resources mResources;
  private CharSequence mText;
  final d rTl;
  private com.tencent.mm.plugin.appbrand.widget.j.a rTm;
  
  static
  {
    AppMethodBeat.i(327332);
    rTk = new a.1();
    AppMethodBeat.o(327332);
  }
  
  public a(Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(327322);
    this.mText = "";
    this.mResources = paramResources;
    this.bsk = ((TextPaint)Objects.requireNonNull((TextPaint)rTk.get()));
    this.mText = "";
    this.rTl = d.a(this.mText, this.bsk, paramInt);
    AppMethodBeat.o(327322);
  }
  
  private void crW()
  {
    AppMethodBeat.i(327327);
    if (this.rTm == null)
    {
      this.rTl.M(this.mText);
      AppMethodBeat.o(327327);
      return;
    }
    SpannableString localSpannableString = new SpannableString(this.mText);
    localSpannableString.setSpan(this.rTm, 0, localSpannableString.length(), 18);
    this.rTl.M(localSpannableString);
    AppMethodBeat.o(327327);
  }
  
  public final float getTextSize()
  {
    AppMethodBeat.i(327351);
    float f = this.bsk.getTextSize();
    AppMethodBeat.o(327351);
    return f;
  }
  
  public final void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(327343);
    this.rTl.a(paramTruncateAt);
    AppMethodBeat.o(327343);
  }
  
  public final void setFakeBoldText(boolean paramBoolean)
  {
    AppMethodBeat.i(327341);
    this.bsk.setFakeBoldText(paramBoolean);
    AppMethodBeat.o(327341);
  }
  
  public final void setGravity(int paramInt)
  {
    this.rTl.fl = paramInt;
  }
  
  public final void setLineHeight(int paramInt)
  {
    AppMethodBeat.i(327355);
    if ((this.rTm == null) || (this.rTm.cb(paramInt)))
    {
      this.rTm = new com.tencent.mm.plugin.appbrand.widget.j.a(paramInt, 16);
      crW();
    }
    AppMethodBeat.o(327355);
  }
  
  public final void setSingleLine(boolean paramBoolean)
  {
    AppMethodBeat.i(327344);
    if (paramBoolean)
    {
      this.rTl.sF(1);
      AppMethodBeat.o(327344);
      return;
    }
    this.rTl.sF(2147483647);
    AppMethodBeat.o(327344);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(327346);
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    if (!localObject.equals(this.mText))
    {
      this.mText = ((CharSequence)localObject);
      crW();
    }
    AppMethodBeat.o(327346);
  }
  
  public final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(327336);
    this.bsk.setColor(paramInt);
    AppMethodBeat.o(327336);
  }
  
  public final void setTextSize(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(327338);
    this.bsk.setTextSize(TypedValue.applyDimension(paramInt, paramFloat, this.mResources.getDisplayMetrics()));
    AppMethodBeat.o(327338);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.a
 * JD-Core Version:    0.7.0.1
 */