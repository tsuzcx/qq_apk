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
import com.tencent.mm.plugin.appbrand.widget.input.d.c;
import com.tencent.mm.plugin.appbrand.widget.input.d.g;
import com.tencent.mm.plugin.appbrand.widget.input.d.h;
import com.tencent.mm.sdk.platformtools.Log;

 enum b
{
  static <Input extends EditText,  extends ab> void a(Input paramInput, int paramInt1, int paramInt2)
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
  
  static <Input extends EditText,  extends ab> void a(Input paramInput, h paramh)
  {
    AppMethodBeat.i(136306);
    if ((paramInput == null) || (paramh == null))
    {
      AppMethodBeat.o(136306);
      return;
    }
    if ((paramh.oxS != null) && (paramh.oxS.floatValue() != paramInput.getTextSize())) {
      paramInput.setTextSize(paramh.oxS.floatValue());
    }
    if (paramh.oxR != null) {
      paramInput.setTextColor(paramh.oxR.intValue());
    }
    label155:
    Object localObject;
    ab localab;
    if (paramh.oxQ != null)
    {
      if ((paramInput.getBackground() == null) || (!(paramInput.getBackground() instanceof ColorDrawable)) || (((ColorDrawable)paramInput.getBackground()).getColor() != paramh.oxQ.intValue())) {
        paramInput.setBackground(new ColorDrawable(paramh.oxQ.intValue()));
      }
      if (paramh.oxU != null)
      {
        if (!TextUtils.isEmpty(paramh.oxU)) {
          break label288;
        }
        paramInput.setHint("");
      }
      if (paramh.cNw != null)
      {
        localObject = Typeface.create("sans-serif", c.agb(paramh.cNw).style);
        if (localObject != null) {
          paramInput.setTypeface((Typeface)localObject);
        }
      }
      localObject = g.agc(paramh.kZR);
      localab = (ab)paramInput;
      if (localab != null) {}
      switch (com.tencent.mm.plugin.appbrand.widget.input.d.g.1.oyo[localObject.ordinal()])
      {
      default: 
        label240:
        if (!aj.i(paramh.oxZ)) {
          break;
        }
      }
    }
    for (int i = 8;; i = 0)
    {
      paramInput.setVisibility(i);
      ((ab)paramInput).setFixed(aj.i(paramh.oyd));
      AppMethodBeat.o(136306);
      return;
      paramInput.setBackground(null);
      break;
      label288:
      localObject = new SpannableStringBuilder(paramh.oxU);
      i = paramh.oxU.length();
      ((SpannableStringBuilder)localObject).setSpan(new StyleSpan(c.agb(paramh.oxV).style), 0, i, 18);
      if (paramh.oxX != null) {
        ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(paramh.oxX.intValue()), 0, i, 18);
      }
      if (paramh.oxW != null) {
        ((SpannableStringBuilder)localObject).setSpan(new AbsoluteSizeSpan(paramh.oxW.intValue(), false), 0, i, 18);
      }
      paramInput.setHint((CharSequence)localObject);
      break label155;
      localab.cbQ();
      break label240;
      localab.cbR();
      break label240;
      localab.cbS();
      break label240;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.b
 * JD-Core Version:    0.7.0.1
 */