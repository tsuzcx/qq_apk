package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.d;
import com.tencent.mm.plugin.appbrand.jsapi.ac.c.a;
import java.util.Objects;

final class a
  implements c.a
{
  private static final ThreadLocal<TextPaint> lSO;
  private final TextPaint Ol;
  final d lSP;
  private com.tencent.mm.plugin.appbrand.widget.h.a lSQ;
  private final Resources mResources;
  private CharSequence mText;
  
  static
  {
    AppMethodBeat.i(193660);
    lSO = new ThreadLocal() {};
    AppMethodBeat.o(193660);
  }
  
  public a(Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(193650);
    this.mText = "";
    this.mResources = paramResources;
    this.Ol = ((TextPaint)Objects.requireNonNull(lSO.get()));
    this.mText = "";
    this.lSP = d.a(this.mText, this.Ol, paramInt);
    AppMethodBeat.o(193650);
  }
  
  private void bGi()
  {
    AppMethodBeat.i(193659);
    if (this.lSQ == null)
    {
      this.lSP.C(this.mText);
      AppMethodBeat.o(193659);
      return;
    }
    SpannableString localSpannableString = new SpannableString(this.mText);
    localSpannableString.setSpan(this.lSQ, 0, localSpannableString.length(), 18);
    this.lSP.C(localSpannableString);
    AppMethodBeat.o(193659);
  }
  
  public final float getTextSize()
  {
    AppMethodBeat.i(193657);
    float f = this.Ol.getTextSize();
    AppMethodBeat.o(193657);
    return f;
  }
  
  public final void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(193654);
    this.lSP.a(paramTruncateAt);
    AppMethodBeat.o(193654);
  }
  
  public final void setFakeBoldText(boolean paramBoolean)
  {
    AppMethodBeat.i(193653);
    this.Ol.setFakeBoldText(paramBoolean);
    AppMethodBeat.o(193653);
  }
  
  public final void setGravity(int paramInt)
  {
    this.lSP.gravity = paramInt;
  }
  
  public final void setLineHeight(int paramInt)
  {
    AppMethodBeat.i(193658);
    if ((this.lSQ == null) || (this.lSQ.aX(paramInt)))
    {
      this.lSQ = new com.tencent.mm.plugin.appbrand.widget.h.a(paramInt, 16);
      bGi();
    }
    AppMethodBeat.o(193658);
  }
  
  public final void setSingleLine(boolean paramBoolean)
  {
    AppMethodBeat.i(193655);
    if (paramBoolean)
    {
      this.lSP.qi(1);
      AppMethodBeat.o(193655);
      return;
    }
    this.lSP.qi(2147483647);
    AppMethodBeat.o(193655);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(193656);
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    if (!localObject.equals(this.mText))
    {
      this.mText = ((CharSequence)localObject);
      bGi();
    }
    AppMethodBeat.o(193656);
  }
  
  public final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(193651);
    this.Ol.setColor(paramInt);
    AppMethodBeat.o(193651);
  }
  
  public final void setTextSize(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(193652);
    this.Ol.setTextSize(TypedValue.applyDimension(paramInt, paramFloat, this.mResources.getDisplayMetrics()));
    AppMethodBeat.o(193652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.a
 * JD-Core Version:    0.7.0.1
 */