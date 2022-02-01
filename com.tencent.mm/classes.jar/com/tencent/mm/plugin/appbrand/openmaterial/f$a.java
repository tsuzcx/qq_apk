package com.tencent.mm.plugin.appbrand.openmaterial;

import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
final class f$a
  implements Runnable
{
  f$a(TextView paramTextView, l paraml) {}
  
  public final void run()
  {
    AppMethodBeat.i(229125);
    int i = this.nlf.getWidth() - this.nlf.getPaddingLeft() - this.nlf.getPaddingRight();
    Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "setText, lineWidth: ".concat(String.valueOf(i)));
    Object localObject = this.nlf.getPaint();
    p.g(localObject, "paint");
    localObject = new StaticLayout((CharSequence)this.nlg.line1, (TextPaint)localObject, i, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
    if (((StaticLayout)localObject).getLineCount() <= 0) {
      Log.w("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "getFirstLineEndPos, lineCount(" + ((StaticLayout)localObject).getLineCount() + ") is illegal");
    }
    for (i = 0;; i = ((StaticLayout)localObject).getLineEnd(0))
    {
      Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "setText, firstLineEndPos: ".concat(String.valueOf(i)));
      int j = this.nlg.line1.length();
      if ((i > 0) && (j >= i)) {
        break;
      }
      this.nlf.setText((CharSequence)this.nlg.nll);
      AppMethodBeat.o(229125);
      return;
    }
    if (i == this.nlg.line1.length()) {}
    String str;
    for (localObject = this.nlg.line1;; localObject = str + "…")
    {
      localObject = (String)localObject + "\n" + this.nlg.line2;
      Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "setText, functionName2Show: ".concat(String.valueOf(localObject)));
      this.nlf.setText((CharSequence)localObject);
      AppMethodBeat.o(229125);
      return;
      localObject = new StringBuilder();
      str = this.nlg.line1;
      if (str == null)
      {
        localObject = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(229125);
        throw ((Throwable)localObject);
      }
      str = str.substring(0, i - 1);
      p.g(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.f.a
 * JD-Core Version:    0.7.0.1
 */