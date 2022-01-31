package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.EditText;
import com.tencent.mm.plugin.appbrand.widget.input.d.c;
import com.tencent.mm.plugin.appbrand.widget.input.d.g;
import com.tencent.mm.plugin.appbrand.widget.input.d.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

 enum b
{
  static <Input extends EditText,  extends aa> void a(Input paramInput, int paramInt1, int paramInt2)
  {
    if ((paramInput == null) || (paramInput.getEditableText() == null))
    {
      y.w("MicroMsg.AppBrandInputCommStyleHelper", "applySelection, invalid input %s", new Object[] { paramInput });
      return;
    }
    if (paramInt1 <= -2) {
      paramInt1 = paramInput.getSelectionStart();
    }
    label137:
    for (;;)
    {
      if (paramInt2 <= -2) {
        paramInt2 = paramInput.getSelectionEnd();
      }
      for (;;)
      {
        int i = paramInt1;
        if (paramInt1 > paramInt2) {
          i = paramInt2;
        }
        Selection.removeSelection(paramInput.getEditableText());
        paramInput.setSelection(i, paramInt2);
        return;
        if ((paramInt1 != -1) && (paramInt1 <= paramInput.getText().length())) {
          break label137;
        }
        paramInt1 = paramInput.getText().length();
        break;
        if ((paramInt2 == -1) || (paramInt2 > paramInput.getText().length())) {
          paramInt2 = paramInput.getText().length();
        }
      }
    }
  }
  
  static <Input extends EditText,  extends aa> void a(Input paramInput, h paramh)
  {
    if ((paramInput == null) || (paramh == null)) {
      return;
    }
    if ((paramh.hyG != null) && (paramh.hyG.floatValue() != paramInput.getTextSize())) {
      paramInput.setTextSize(paramh.hyG.floatValue());
    }
    if (paramh.hyF != null) {
      paramInput.setTextColor(paramh.hyF.intValue());
    }
    aa localaa;
    if (paramh.hyE != null)
    {
      if ((paramInput.getBackground() == null) || (!(paramInput.getBackground() instanceof ColorDrawable)) || (((ColorDrawable)paramInput.getBackground()).getColor() != paramh.hyE.intValue())) {
        paramInput.setBackground(new ColorDrawable(paramh.hyE.intValue()));
      }
      if (!bk.bl(paramh.hyI))
      {
        localObject = new SpannableStringBuilder(paramh.hyI);
        i = paramh.hyI.length();
        ((SpannableStringBuilder)localObject).setSpan(new StyleSpan(c.xd(paramh.hyJ).style), 0, i, 18);
        if (paramh.hyL != null) {
          ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(paramh.hyL.intValue()), 0, i, 18);
        }
        if (paramh.hyK != null) {
          ((SpannableStringBuilder)localObject).setSpan(new AbsoluteSizeSpan(paramh.hyK.intValue(), false), 0, i, 18);
        }
        paramInput.setHint((CharSequence)localObject);
      }
      if (paramh.fLT != null)
      {
        localObject = Typeface.create("sans-serif", c.xd(paramh.fLT).style);
        if (localObject != null) {
          paramInput.setTypeface((Typeface)localObject);
        }
      }
      Object localObject = g.xe(paramh.fMb);
      localaa = (aa)paramInput;
      if (localaa != null) {}
      switch (com.tencent.mm.plugin.appbrand.widget.input.d.g.1.hzc[localObject.ordinal()])
      {
      default: 
        label328:
        if (!ai.f(paramh.hyN)) {
          break;
        }
      }
    }
    for (int i = 8;; i = 0)
    {
      paramInput.setVisibility(i);
      ((aa)paramInput).setFixed(ai.f(paramh.hyR));
      return;
      paramInput.setBackground(null);
      break;
      localaa.asl();
      break label328;
      localaa.asm();
      break label328;
      localaa.asn();
      break label328;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.b
 * JD-Core Version:    0.7.0.1
 */