package com.tencent.mm.plugin.appbrand.openmaterial;

import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
final class g$a
  implements Runnable
{
  g$a(TextView paramTextView, n paramn) {}
  
  public final void run()
  {
    AppMethodBeat.i(275187);
    int i = this.qmI.getWidth() - this.qmI.getPaddingLeft() - this.qmI.getPaddingRight();
    Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "setText, lineWidth: ".concat(String.valueOf(i)));
    Object localObject = this.qmI.getPaint();
    p.j(localObject, "paint");
    localObject = new StaticLayout((CharSequence)this.qmJ.qmU, (TextPaint)localObject, i, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
    if (((StaticLayout)localObject).getLineCount() <= 0) {
      Log.w("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "getFirstLineEndPos, lineCount(" + ((StaticLayout)localObject).getLineCount() + ") is illegal");
    }
    for (i = 0;; i = ((StaticLayout)localObject).getLineEnd(0))
    {
      Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "setText, firstLineEndPos: ".concat(String.valueOf(i)));
      int j = this.qmJ.qmU.length();
      if ((i > 0) && (j >= i)) {
        break;
      }
      this.qmI.setText((CharSequence)this.qmJ.qmT);
      AppMethodBeat.o(275187);
      return;
    }
    if (i == this.qmJ.qmU.length()) {}
    String str;
    for (localObject = this.qmJ.qmU;; localObject = str + "…")
    {
      localObject = (String)localObject + "\n" + this.qmJ.qmV;
      Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "setText, functionName2Show: ".concat(String.valueOf(localObject)));
      this.qmI.setText((CharSequence)localObject);
      AppMethodBeat.o(275187);
      return;
      localObject = new StringBuilder();
      str = this.qmJ.qmU;
      if (str == null)
      {
        localObject = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(275187);
        throw ((Throwable)localObject);
      }
      str = str.substring(0, i - 1);
      p.j(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.g.a
 * JD-Core Version:    0.7.0.1
 */