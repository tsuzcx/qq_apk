package androidx.compose.ui.m.a;

import android.text.Layout.Alignment;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/android/StaticLayoutParams;", "", "text", "", "start", "", "end", "paint", "Landroid/text/TextPaint;", "width", "textDir", "Landroid/text/TextDirectionHeuristic;", "alignment", "Landroid/text/Layout$Alignment;", "maxLines", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "ellipsizedWidth", "lineSpacingMultiplier", "", "lineSpacingExtra", "justificationMode", "includePadding", "", "useFallbackLineSpacing", "breakStrategy", "hyphenationFrequency", "leftIndents", "", "rightIndents", "(Ljava/lang/CharSequence;IILandroid/text/TextPaint;ILandroid/text/TextDirectionHeuristic;Landroid/text/Layout$Alignment;ILandroid/text/TextUtils$TruncateAt;IFFIZZII[I[I)V", "getAlignment", "()Landroid/text/Layout$Alignment;", "getBreakStrategy", "()I", "getEllipsize", "()Landroid/text/TextUtils$TruncateAt;", "getEllipsizedWidth", "getEnd", "getHyphenationFrequency", "getIncludePadding", "()Z", "getJustificationMode", "getLeftIndents", "()[I", "getLineSpacingExtra", "()F", "getLineSpacingMultiplier", "getMaxLines", "getPaint", "()Landroid/text/TextPaint;", "getRightIndents", "getStart", "getText", "()Ljava/lang/CharSequence;", "getTextDir", "()Landroid/text/TextDirectionHeuristic;", "getUseFallbackLineSpacing", "getWidth", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
final class l
{
  final CharSequence bba;
  final TextPaint bbb;
  final TextDirectionHeuristic bbc;
  final Layout.Alignment bbd;
  final TextUtils.TruncateAt bbe;
  final int bbf;
  final float bbg;
  final float bbh;
  final int bbi;
  final boolean bbj;
  final boolean bbk;
  final int bbl;
  final int bbm;
  final int[] bbn;
  final int[] bbo;
  final int end;
  final int maxLines;
  final int start;
  final int width;
  
  public l(CharSequence paramCharSequence, int paramInt1, TextPaint paramTextPaint, int paramInt2, TextDirectionHeuristic paramTextDirectionHeuristic, Layout.Alignment paramAlignment, int paramInt3, TextUtils.TruncateAt paramTruncateAt, int paramInt4, float paramFloat1, float paramFloat2, int paramInt5, boolean paramBoolean, int paramInt6, int paramInt7, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(205210);
    this.bba = paramCharSequence;
    this.start = 0;
    this.end = paramInt1;
    this.bbb = paramTextPaint;
    this.width = paramInt2;
    this.bbc = paramTextDirectionHeuristic;
    this.bbd = paramAlignment;
    this.maxLines = paramInt3;
    this.bbe = paramTruncateAt;
    this.bbf = paramInt4;
    this.bbg = paramFloat1;
    this.bbh = paramFloat2;
    this.bbi = paramInt5;
    this.bbj = paramBoolean;
    this.bbk = true;
    this.bbl = paramInt6;
    this.bbm = paramInt7;
    this.bbn = paramArrayOfInt1;
    this.bbo = paramArrayOfInt2;
    paramInt1 = this.end;
    paramInt2 = this.start;
    if (paramInt2 >= 0) {
      if (paramInt2 <= paramInt1) {
        paramInt1 = 1;
      }
    }
    while (paramInt1 == 0)
    {
      paramCharSequence = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
      AppMethodBeat.o(205210);
      throw paramCharSequence;
      paramInt1 = 0;
      continue;
      paramInt1 = 0;
    }
    paramInt1 = this.bba.length();
    paramInt2 = this.end;
    if (paramInt2 >= 0) {
      if (paramInt2 <= paramInt1) {
        paramInt1 = 1;
      }
    }
    while (paramInt1 == 0)
    {
      paramCharSequence = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
      AppMethodBeat.o(205210);
      throw paramCharSequence;
      paramInt1 = 0;
      continue;
      paramInt1 = 0;
    }
    if (this.maxLines >= 0) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      paramCharSequence = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
      AppMethodBeat.o(205210);
      throw paramCharSequence;
    }
    if (this.width >= 0) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      paramCharSequence = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
      AppMethodBeat.o(205210);
      throw paramCharSequence;
    }
    if (this.bbf >= 0) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      paramCharSequence = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
      AppMethodBeat.o(205210);
      throw paramCharSequence;
    }
    if (this.bbg >= 0.0F) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      paramCharSequence = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
      AppMethodBeat.o(205210);
      throw paramCharSequence;
    }
    AppMethodBeat.o(205210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.compose.ui.m.a.l
 * JD-Core Version:    0.7.0.1
 */