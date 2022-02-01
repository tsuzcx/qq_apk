package androidx.compose.ui.m.a.b;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.text.style.ReplacementSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/android/style/PlaceholderSpan;", "Landroid/text/style/ReplacementSpan;", "width", "", "widthUnit", "", "height", "heightUnit", "pxPerSp", "verticalAlign", "(FIFIFI)V", "<set-?>", "Landroid/graphics/Paint$FontMetricsInt;", "fontMetrics", "getFontMetrics", "()Landroid/graphics/Paint$FontMetricsInt;", "heightPx", "getHeightPx", "()I", "isLaidOut", "", "getVerticalAlign", "widthPx", "getWidthPx", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fm", "Companion", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends ReplacementSpan
{
  public static final f.a bbA;
  private final int bbB;
  private final int bbC;
  private final float bbD;
  public final int bbE;
  private Paint.FontMetricsInt bbF;
  private int bbG;
  private int bbH;
  private boolean bbI;
  private final float height;
  private final float width;
  
  static
  {
    AppMethodBeat.i(205213);
    bbA = new f.a((byte)0);
    AppMethodBeat.o(205213);
  }
  
  public final Paint.FontMetricsInt AZ()
  {
    AppMethodBeat.i(205218);
    Paint.FontMetricsInt localFontMetricsInt = this.bbF;
    if (localFontMetricsInt != null)
    {
      AppMethodBeat.o(205218);
      return localFontMetricsInt;
    }
    s.bIx("fontMetrics");
    AppMethodBeat.o(205218);
    return null;
  }
  
  public final int Ba()
  {
    AppMethodBeat.i(205222);
    if (!this.bbI)
    {
      Throwable localThrowable = (Throwable)new IllegalStateException("PlaceholderSpan is not laid out yet.".toString());
      AppMethodBeat.o(205222);
      throw localThrowable;
    }
    int i = this.bbG;
    AppMethodBeat.o(205222);
    return i;
  }
  
  public final int Bb()
  {
    AppMethodBeat.i(205225);
    if (!this.bbI)
    {
      Throwable localThrowable = (Throwable)new IllegalStateException("PlaceholderSpan is not laid out yet.".toString());
      AppMethodBeat.o(205225);
      throw localThrowable;
    }
    int i = this.bbH;
    AppMethodBeat.o(205225);
    return i;
  }
  
  public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    AppMethodBeat.i(205238);
    s.u(paramCanvas, "canvas");
    s.u(paramPaint, "paint");
    AppMethodBeat.o(205238);
  }
  
  public final int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    paramInt1 = 1;
    AppMethodBeat.i(205231);
    s.u(paramPaint, "paint");
    this.bbI = true;
    float f2 = paramPaint.getTextSize();
    paramPaint = paramPaint.getFontMetricsInt();
    s.s(paramPaint, "paint.fontMetricsInt");
    this.bbF = paramPaint;
    if (AZ().descent > AZ().ascent) {}
    while (paramInt1 == 0)
    {
      paramPaint = (Throwable)new IllegalArgumentException("Invalid fontMetrics: line height can not be negative.".toString());
      AppMethodBeat.o(205231);
      throw paramPaint;
      paramInt1 = 0;
    }
    switch (this.bbB)
    {
    default: 
      paramPaint = new IllegalArgumentException("Unsupported unit.");
      AppMethodBeat.o(205231);
      throw paramPaint;
    }
    for (float f1 = this.width * this.bbD;; f1 = this.width * f2)
    {
      this.bbG = ((int)(float)Math.ceil(f1));
      switch (this.bbC)
      {
      default: 
        paramPaint = new IllegalArgumentException("Unsupported unit.");
        AppMethodBeat.o(205231);
        throw paramPaint;
      }
    }
    for (paramInt1 = (int)(float)Math.ceil(this.height * this.bbD);; paramInt1 = (int)(float)Math.ceil(this.height * f2))
    {
      this.bbH = paramInt1;
      if (paramFontMetricsInt == null) {
        break;
      }
      paramFontMetricsInt.ascent = AZ().ascent;
      paramFontMetricsInt.descent = AZ().descent;
      paramFontMetricsInt.leading = AZ().leading;
      switch (this.bbE)
      {
      default: 
        paramPaint = new IllegalArgumentException("Unknown verticalAlign.");
        AppMethodBeat.o(205231);
        throw paramPaint;
      }
    }
    if (paramFontMetricsInt.ascent + Bb() > paramFontMetricsInt.descent) {
      paramFontMetricsInt.descent = (paramFontMetricsInt.ascent + Bb());
    }
    for (;;)
    {
      paramFontMetricsInt.top = Math.min(AZ().top, paramFontMetricsInt.ascent);
      paramFontMetricsInt.bottom = Math.max(AZ().bottom, paramFontMetricsInt.descent);
      paramInt1 = Ba();
      AppMethodBeat.o(205231);
      return paramInt1;
      if (paramFontMetricsInt.ascent > paramFontMetricsInt.descent - Bb())
      {
        paramFontMetricsInt.ascent = (paramFontMetricsInt.descent - Bb());
        continue;
        if (paramFontMetricsInt.descent - paramFontMetricsInt.ascent < Bb())
        {
          paramFontMetricsInt.ascent -= (Bb() - (paramFontMetricsInt.descent - paramFontMetricsInt.ascent)) / 2;
          paramFontMetricsInt.descent = (paramFontMetricsInt.ascent + Bb());
          continue;
          if (paramFontMetricsInt.ascent > -Bb()) {
            paramFontMetricsInt.ascent = (-Bb());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.a.b.f
 * JD-Core Version:    0.7.0.1
 */