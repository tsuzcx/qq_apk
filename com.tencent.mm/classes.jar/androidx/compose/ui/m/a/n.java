package androidx.compose.ui.m.a;

import android.text.BoringLayout.Metrics;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/android/TextLayout;", "", "charSequence", "", "width", "", "textPaint", "Landroid/text/TextPaint;", "alignment", "", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "textDirectionHeuristic", "lineSpacingMultiplier", "lineSpacingExtra", "includePadding", "", "maxLines", "breakStrategy", "hyphenationFrequency", "justificationMode", "leftIndents", "", "rightIndents", "layoutIntrinsics", "Landroidx/compose/ui/text/android/LayoutIntrinsics;", "(Ljava/lang/CharSequence;FLandroid/text/TextPaint;ILandroid/text/TextUtils$TruncateAt;IFFZIIII[I[ILandroidx/compose/ui/text/android/LayoutIntrinsics;)V", "didExceedMaxLines", "getDidExceedMaxLines", "()Z", "height", "getHeight", "()I", "layout", "Landroid/text/Layout;", "getLayout$annotations", "()V", "getLayout", "()Landroid/text/Layout;", "getLayoutIntrinsics", "()Landroidx/compose/ui/text/android/LayoutIntrinsics;", "lineCount", "getLineCount", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "()F", "minIntrinsicWidth", "getMinIntrinsicWidth", "text", "getText", "()Ljava/lang/CharSequence;", "getLineBaseline", "line", "getLineBottom", "getLineEllipsisCount", "lineIndex", "getLineEllipsisOffset", "getLineEnd", "getLineForOffset", "offset", "getLineForVertical", "vertical", "getLineHeight", "getLineLeft", "getLineRight", "getLineStart", "getLineTop", "getLineVisibleEnd", "getLineWidth", "getOffsetForHorizontal", "horizontal", "getParagraphDirection", "getPrimaryHorizontal", "getSecondaryHorizontal", "getSelectionPath", "", "start", "end", "dest", "Landroid/graphics/Path;", "isEllipsisApplied", "isLineEllipsized", "isRtlCharAt", "paint", "canvas", "Landroid/graphics/Canvas;", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
{
  public final boolean aYO;
  public final int aYP;
  private final c bbs;
  public final Layout bbt;
  
  private n(CharSequence paramCharSequence, float paramFloat, TextPaint paramTextPaint, int paramInt1, TextUtils.TruncateAt paramTruncateAt, int paramInt2, int paramInt3, int paramInt4, c paramc)
  {
    AppMethodBeat.i(205217);
    this.bbs = paramc;
    int i = paramCharSequence.length();
    paramc = o.dw(paramInt2);
    Object localObject1 = m.bbp;
    localObject1 = m.dq(paramInt1);
    Object localObject2;
    if ((paramCharSequence instanceof Spanned)) {
      if (((Spanned)paramCharSequence).nextSpanTransition(-1, i, androidx.compose.ui.m.a.b.a.class) < i)
      {
        paramInt1 = 1;
        localObject2 = this.bbs.AU();
        paramInt2 = (int)(float)Math.ceil(paramFloat);
        if ((localObject2 == null) || (this.bbs.AG() > paramFloat) || (paramInt1 != 0)) {
          break label250;
        }
        paramc = a.baJ;
        paramTextPaint = (Layout)a.a(paramCharSequence, paramTextPaint, paramInt2, (BoringLayout.Metrics)localObject2, (Layout.Alignment)localObject1, true, paramTruncateAt, paramInt2);
        label155:
        this.bbt = paramTextPaint;
        this.aYP = Math.min(this.bbt.getLineCount(), paramInt3);
        if ((this.aYP < paramInt3) || ((this.bbt.getEllipsisCount(this.aYP - 1) <= 0) && (this.bbt.getLineEnd(this.aYP - 1) == paramCharSequence.length()))) {
          break label299;
        }
      }
    }
    label299:
    for (boolean bool = true;; bool = false)
    {
      this.aYO = bool;
      AppMethodBeat.o(205217);
      return;
      paramInt1 = 0;
      break;
      paramInt1 = 0;
      break;
      label250:
      localObject2 = f.baT;
      paramTextPaint = (Layout)f.a(paramCharSequence, paramCharSequence.length(), paramTextPaint, paramInt2, paramc, (Layout.Alignment)localObject1, paramInt3, paramTruncateAt, (int)(float)Math.ceil(paramFloat), 1.0F, 0.0F, paramInt4, true, 0, 0, null, null);
      break label155;
    }
  }
  
  public final int di(int paramInt)
  {
    AppMethodBeat.i(205255);
    paramInt = this.bbt.getLineForOffset(paramInt);
    AppMethodBeat.o(205255);
    return paramInt;
  }
  
  public final float dj(int paramInt)
  {
    AppMethodBeat.i(205226);
    float f = this.bbt.getLineTop(paramInt);
    AppMethodBeat.o(205226);
    return f;
  }
  
  public final float dr(int paramInt)
  {
    AppMethodBeat.i(205229);
    float f = this.bbt.getLineBottom(paramInt);
    AppMethodBeat.o(205229);
    return f;
  }
  
  public final float ds(int paramInt)
  {
    AppMethodBeat.i(205235);
    float f = this.bbt.getLineBaseline(paramInt);
    AppMethodBeat.o(205235);
    return f;
  }
  
  public final int dt(int paramInt)
  {
    AppMethodBeat.i(205245);
    if (this.bbt.getEllipsisStart(paramInt) == 0)
    {
      paramInt = this.bbt.getLineEnd(paramInt);
      AppMethodBeat.o(205245);
      return paramInt;
    }
    paramInt = this.bbt.getText().length();
    AppMethodBeat.o(205245);
    return paramInt;
  }
  
  public final int du(int paramInt)
  {
    AppMethodBeat.i(205251);
    paramInt = this.bbt.getLineForVertical(paramInt);
    AppMethodBeat.o(205251);
    return paramInt;
  }
  
  public final float dv(int paramInt)
  {
    AppMethodBeat.i(205254);
    float f = this.bbt.getPrimaryHorizontal(paramInt);
    AppMethodBeat.o(205254);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.a.n
 * JD-Core Version:    0.7.0.1
 */