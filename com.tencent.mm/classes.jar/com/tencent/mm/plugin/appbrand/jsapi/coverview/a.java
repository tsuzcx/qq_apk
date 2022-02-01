package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.d;
import com.tencent.mm.plugin.appbrand.jsapi.ae.c.a;
import java.util.Objects;

final class a
  implements c.a
{
  private static final ThreadLocal<TextPaint> oPx;
  private final TextPaint Mf;
  private final Resources mResources;
  private CharSequence mText;
  final d oPy;
  private com.tencent.mm.plugin.appbrand.widget.i.a oPz;
  
  static
  {
    AppMethodBeat.i(206890);
    oPx = new a.1();
    AppMethodBeat.o(206890);
  }
  
  public a(Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(206873);
    this.mText = "";
    this.mResources = paramResources;
    this.Mf = ((TextPaint)Objects.requireNonNull(oPx.get()));
    this.mText = "";
    this.oPy = d.a(this.mText, this.Mf, paramInt);
    AppMethodBeat.o(206873);
  }
  
  private void bRS()
  {
    AppMethodBeat.i(206888);
    if (this.oPz == null)
    {
      this.oPy.I(this.mText);
      AppMethodBeat.o(206888);
      return;
    }
    SpannableString localSpannableString = new SpannableString(this.mText);
    localSpannableString.setSpan(this.oPz, 0, localSpannableString.length(), 18);
    this.oPy.I(localSpannableString);
    AppMethodBeat.o(206888);
  }
  
  public final float getTextSize()
  {
    AppMethodBeat.i(206884);
    float f = this.Mf.getTextSize();
    AppMethodBeat.o(206884);
    return f;
  }
  
  public final void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(206878);
    this.oPy.a(paramTruncateAt);
    AppMethodBeat.o(206878);
  }
  
  public final void setFakeBoldText(boolean paramBoolean)
  {
    AppMethodBeat.i(206876);
    this.Mf.setFakeBoldText(paramBoolean);
    AppMethodBeat.o(206876);
  }
  
  public final void setGravity(int paramInt)
  {
    this.oPy.ek = paramInt;
  }
  
  public final void setLineHeight(int paramInt)
  {
    AppMethodBeat.i(206886);
    if ((this.oPz == null) || (this.oPz.aZ(paramInt)))
    {
      this.oPz = new com.tencent.mm.plugin.appbrand.widget.i.a(paramInt, 16);
      bRS();
    }
    AppMethodBeat.o(206886);
  }
  
  public final void setSingleLine(boolean paramBoolean)
  {
    AppMethodBeat.i(206880);
    if (paramBoolean)
    {
      this.oPy.sI(1);
      AppMethodBeat.o(206880);
      return;
    }
    this.oPy.sI(2147483647);
    AppMethodBeat.o(206880);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(206882);
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    if (!localObject.equals(this.mText))
    {
      this.mText = ((CharSequence)localObject);
      bRS();
    }
    AppMethodBeat.o(206882);
  }
  
  public final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(206874);
    this.Mf.setColor(paramInt);
    AppMethodBeat.o(206874);
  }
  
  public final void setTextSize(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(206875);
    this.Mf.setTextSize(TypedValue.applyDimension(paramInt, paramFloat, this.mResources.getDisplayMetrics()));
    AppMethodBeat.o(206875);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.a
 * JD-Core Version:    0.7.0.1
 */