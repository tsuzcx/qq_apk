package com.tencent.kinda.framework.widget.tools;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.tencent.kinda.gen.FontStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ar;

public class KindaFontUtil$KindaTypefaceSpan
  extends MetricAffectingSpan
{
  private String fontName;
  private FontStyle fontStyle;
  
  public KindaFontUtil$KindaTypefaceSpan(String paramString, FontStyle paramFontStyle)
  {
    this.fontName = paramString;
    this.fontStyle = paramFontStyle;
  }
  
  private void updateKindaFont(TextPaint paramTextPaint)
  {
    int j = 0;
    AppMethodBeat.i(264348);
    Typeface localTypeface = KindaFontUtil.getTypeface(this.fontName);
    if (localTypeface != null)
    {
      paramTextPaint.setTypeface(localTypeface);
      AppMethodBeat.o(264348);
      return;
    }
    if (this.fontStyle == FontStyle.MEDIUM)
    {
      ar.a(paramTextPaint, 0.8F);
      AppMethodBeat.o(264348);
      return;
    }
    int i;
    if (this.fontStyle == FontStyle.BOLD)
    {
      i = 1;
      localTypeface = paramTextPaint.getTypeface();
      if (localTypeface != null) {
        break label145;
      }
      label79:
      i = j | i;
      if (localTypeface != null) {
        break label154;
      }
    }
    label145:
    label154:
    for (localTypeface = Typeface.defaultFromStyle(i);; localTypeface = Typeface.create(localTypeface, i))
    {
      i &= (localTypeface.getStyle() ^ 0xFFFFFFFF);
      if ((i & 0x1) != 0) {
        paramTextPaint.setFakeBoldText(true);
      }
      if ((i & 0x2) != 0) {
        paramTextPaint.setTextSkewX(-0.25F);
      }
      paramTextPaint.setTypeface(localTypeface);
      AppMethodBeat.o(264348);
      return;
      i = 0;
      break;
      j = localTypeface.getStyle();
      break label79;
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(264347);
    updateKindaFont(paramTextPaint);
    AppMethodBeat.o(264347);
  }
  
  public void updateMeasureState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(264346);
    updateKindaFont(paramTextPaint);
    AppMethodBeat.o(264346);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.tools.KindaFontUtil.KindaTypefaceSpan
 * JD-Core Version:    0.7.0.1
 */