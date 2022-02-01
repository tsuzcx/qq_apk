package com.tencent.mm.plugin.editor.model.nativenote.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  implements LeadingMarginSpan, g<Boolean>, h<Boolean>
{
  private static Path qTc = null;
  private final int qTd;
  public boolean qTe;
  
  private d(int paramInt, boolean paramBoolean)
  {
    this.qTd = paramInt;
    this.qTe = paramBoolean;
  }
  
  public d(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(181932);
    this.qTd = paramInt;
    if ((paramBoolean1) && (paramBoolean3) && (!paramBoolean2)) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      this.qTe = paramBoolean1;
      if (qTc == null) {
        qTc = new Path();
      }
      AppMethodBeat.o(181932);
      return;
    }
  }
  
  public final void drawLeadingMargin(Canvas paramCanvas, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, CharSequence paramCharSequence, int paramInt6, int paramInt7, boolean paramBoolean, Layout paramLayout)
  {
    AppMethodBeat.i(181933);
    paramCharSequence = (Spanned)paramCharSequence;
    if ((!this.qTe) && (paramCharSequence.getSpanStart(this) == paramInt6))
    {
      paramCharSequence = paramPaint.getStyle();
      paramPaint.setStyle(Paint.Style.FILL);
      qTc.reset();
      qTc.addCircle(0.0F, 0.0F, 6.0F, Path.Direction.CW);
      paramLayout = paramPaint.getFontMetricsInt();
      paramInt3 = paramLayout.descent;
      paramInt3 = (paramLayout.ascent + (paramInt3 + paramInt4 + paramInt4)) / 2;
      paramCanvas.save();
      paramCanvas.translate(paramInt2 * 6 + paramInt1, paramInt3);
      paramCanvas.drawPath(qTc, paramPaint);
      paramCanvas.restore();
      paramPaint.setStyle(paramCharSequence);
    }
    AppMethodBeat.o(181933);
  }
  
  public final int getLeadingMargin(boolean paramBoolean)
  {
    if (this.qTe) {
      return 0;
    }
    return this.qTd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.spans.d
 * JD-Core Version:    0.7.0.1
 */