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
    if ((paramh.rAr != null) && (paramh.rAr.floatValue() != paramInput.getTextSize())) {
      paramInput.setTextSize(paramh.rAr.floatValue());
    }
    if (paramh.rAq != null) {
      paramInput.setTextColor(paramh.rAq.intValue());
    }
    label155:
    Object localObject;
    af localaf;
    if (paramh.rAp != null)
    {
      if ((paramInput.getBackground() == null) || (!(paramInput.getBackground() instanceof ColorDrawable)) || (((ColorDrawable)paramInput.getBackground()).getColor() != paramh.rAp.intValue())) {
        paramInput.setBackground(new ColorDrawable(paramh.rAp.intValue()));
      }
      if (paramh.rAt != null)
      {
        if (!TextUtils.isEmpty(paramh.rAt)) {
          break label288;
        }
        paramInput.setHint("");
      }
      if (paramh.cOk != null)
      {
        localObject = Typeface.create("sans-serif", c.anE(paramh.cOk).style);
        if (localObject != null) {
          paramInput.setTypeface((Typeface)localObject);
        }
      }
      localObject = g.anF(paramh.nUc);
      localaf = (af)paramInput;
      if (localaf != null) {}
      switch (com.tencent.mm.plugin.appbrand.widget.input.e.g.1.rAO[localObject.ordinal()])
      {
      default: 
        label240:
        if (!an.m(paramh.rAy)) {
          break;
        }
      }
    }
    for (int i = 8;; i = 0)
    {
      paramInput.setVisibility(i);
      ((af)paramInput).setFixed(an.m(paramh.rAC));
      AppMethodBeat.o(136306);
      return;
      paramInput.setBackground(null);
      break;
      label288:
      localObject = new SpannableStringBuilder(paramh.rAt);
      i = paramh.rAt.length();
      ((SpannableStringBuilder)localObject).setSpan(new StyleSpan(c.anE(paramh.rAu).style), 0, i, 18);
      if (paramh.rAw != null) {
        ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(paramh.rAw.intValue()), 0, i, 18);
      }
      if (paramh.rAv != null) {
        ((SpannableStringBuilder)localObject).setSpan(new AbsoluteSizeSpan(paramh.rAv.intValue(), false), 0, i, 18);
      }
      paramInput.setHint((CharSequence)localObject);
      break label155;
      localaf.cpb();
      break label240;
      localaf.cpc();
      break label240;
      localaf.cpd();
      break label240;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.b
 * JD-Core Version:    0.7.0.1
 */