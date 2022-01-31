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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.d.c;
import com.tencent.mm.plugin.appbrand.widget.input.d.g;
import com.tencent.mm.plugin.appbrand.widget.input.d.h;
import com.tencent.mm.sdk.platformtools.bo;

 enum b
{
  static <Input extends EditText,  extends ab> void a(Input paramInput, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(123576);
    if ((paramInput == null) || (paramInput.getEditableText() == null))
    {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.AppBrandInputCommStyleHelper", "applySelection, invalid input %s", new Object[] { paramInput });
      AppMethodBeat.o(123576);
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
        AppMethodBeat.o(123576);
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
  
  static <Input extends EditText,  extends ab> void a(Input paramInput, h paramh)
  {
    AppMethodBeat.i(123575);
    if ((paramInput == null) || (paramh == null))
    {
      AppMethodBeat.o(123575);
      return;
    }
    if ((paramh.jqQ != null) && (paramh.jqQ.floatValue() != paramInput.getTextSize())) {
      paramInput.setTextSize(paramh.jqQ.floatValue());
    }
    if (paramh.jqP != null) {
      paramInput.setTextColor(paramh.jqP.intValue());
    }
    ab localab;
    if (paramh.jqO != null)
    {
      if ((paramInput.getBackground() == null) || (!(paramInput.getBackground() instanceof ColorDrawable)) || (((ColorDrawable)paramInput.getBackground()).getColor() != paramh.jqO.intValue())) {
        paramInput.setBackground(new ColorDrawable(paramh.jqO.intValue()));
      }
      if (!bo.isNullOrNil(paramh.jqS))
      {
        localObject = new SpannableStringBuilder(paramh.jqS);
        i = paramh.jqS.length();
        ((SpannableStringBuilder)localObject).setSpan(new StyleSpan(c.FQ(paramh.jqT).style), 0, i, 18);
        if (paramh.jqV != null) {
          ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(paramh.jqV.intValue()), 0, i, 18);
        }
        if (paramh.jqU != null) {
          ((SpannableStringBuilder)localObject).setSpan(new AbsoluteSizeSpan(paramh.jqU.intValue(), false), 0, i, 18);
        }
        paramInput.setHint((CharSequence)localObject);
      }
      if (paramh.hfd != null)
      {
        localObject = Typeface.create("sans-serif", c.FQ(paramh.hfd).style);
        if (localObject != null) {
          paramInput.setTypeface((Typeface)localObject);
        }
      }
      Object localObject = g.FR(paramh.hfl);
      localab = (ab)paramInput;
      if (localab != null) {}
      switch (com.tencent.mm.plugin.appbrand.widget.input.d.g.1.jrm[localObject.ordinal()])
      {
      default: 
        label336:
        if (!aj.g(paramh.jqX)) {
          break;
        }
      }
    }
    for (int i = 8;; i = 0)
    {
      paramInput.setVisibility(i);
      ((ab)paramInput).setFixed(aj.g(paramh.jrb));
      AppMethodBeat.o(123575);
      return;
      paramInput.setBackground(null);
      break;
      localab.aRq();
      break label336;
      localab.aRr();
      break label336;
      localab.aRs();
      break label336;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.b
 * JD-Core Version:    0.7.0.1
 */