package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.e.c;
import com.tencent.mm.plugin.appbrand.widget.input.e.g;
import com.tencent.mm.plugin.appbrand.widget.input.e.h;
import com.tencent.mm.sdk.platformtools.Log;

 enum b
{
  static <Input extends EditText,  extends af> void a(Input paramInput, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(136307);
    if ((paramInput == null) || (paramInput.getEditableText() == null))
    {
      Log.w("MicroMsg.AppBrandInputCommStyleHelper", "applySelection, invalid input %s", new Object[] { paramInput });
      AppMethodBeat.o(136307);
      return;
    }
    if (paramInt1 <= -2) {
      paramInt1 = paramInput.getSelectionStart();
    }
    label152:
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
        AppMethodBeat.o(136307);
        return;
        if ((paramInt1 != -1) && (paramInt1 <= paramInput.getText().length())) {
          break label152;
        }
        paramInt1 = paramInput.getText().length();
        break;
        if ((paramInt2 == -1) || (paramInt2 > paramInput.getText().length())) {
          paramInt2 = paramInput.getText().length();
        }
      }
    }
  }
  
  static <Input extends EditText,  extends af> void a(Input paramInput, h paramh)
  {
    AppMethodBeat.i(136306);
    if ((paramInput == null) || (paramh == null))
    {
      AppMethodBeat.o(136306);
      return;
    }
    if ((paramh.uLH != null) && (paramh.uLH.floatValue() != paramInput.getTextSize())) {
      paramInput.setTextSize(paramh.uLH.floatValue());
    }
    if (paramh.uLG != null) {
      paramInput.setTextColor(paramh.uLG.intValue());
    }
    label155:
    Object localObject;
    af localaf;
    if (paramh.uLF != null)
    {
      if ((paramInput.getBackground() == null) || (!(paramInput.getBackground() instanceof ColorDrawable)) || (((ColorDrawable)paramInput.getBackground()).getColor() != paramh.uLF.intValue())) {
        paramInput.setBackground(new ColorDrawable(paramh.uLF.intValue()));
      }
      if (paramh.uLJ != null)
      {
        if (!TextUtils.isEmpty(paramh.uLJ)) {
          break label288;
        }
        paramInput.setHint("");
      }
      if (paramh.eJF != null)
      {
        localObject = Typeface.create("sans-serif", c.ahc(paramh.eJF).style);
        if (localObject != null) {
          paramInput.setTypeface((Typeface)localObject);
        }
      }
      localObject = g.ahd(paramh.qTN);
      localaf = (af)paramInput;
      if (localaf != null) {}
      switch (com.tencent.mm.plugin.appbrand.widget.input.e.g.1.uMe[localObject.ordinal()])
      {
      default: 
        label240:
        if (!an.o(paramh.uLO)) {
          break;
        }
      }
    }
    for (int i = 8;; i = 0)
    {
      paramInput.setVisibility(i);
      ((af)paramInput).setFixed(an.o(paramh.uLS));
      AppMethodBeat.o(136306);
      return;
      paramInput.setBackground(null);
      break;
      label288:
      localObject = new SpannableStringBuilder(paramh.uLJ);
      i = paramh.uLJ.length();
      ((SpannableStringBuilder)localObject).setSpan(new StyleSpan(c.ahc(paramh.uLK).style), 0, i, 18);
      if (paramh.uLM != null) {
        ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(paramh.uLM.intValue()), 0, i, 18);
      }
      if (paramh.uLL != null) {
        ((SpannableStringBuilder)localObject).setSpan(new AbsoluteSizeSpan(paramh.uLL.intValue(), false), 0, i, 18);
      }
      paramInput.setHint((CharSequence)localObject);
      break label155;
      localaf.cRE();
      break label240;
      localaf.cRF();
      break label240;
      localaf.cRG();
      break label240;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.b
 * JD-Core Version:    0.7.0.1
 */