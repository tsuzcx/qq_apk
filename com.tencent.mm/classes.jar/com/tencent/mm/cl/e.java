package com.tencent.mm.cl;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/smiley/EmojiSpan;", "Lcom/tencent/mm/ui/widget/FixImageSpan;", "drawable", "Landroid/graphics/drawable/Drawable;", "isWxEmoji", "", "start", "", "end", "(Landroid/graphics/drawable/Drawable;ZII)V", "alpha", "drawRect", "Landroid/graphics/RectF;", "getEnd", "()I", "isSetAlpha", "()Z", "getStart", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getDrawRect", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "setAlpha", "Companion", "plugin-emojisdk_release"})
public final class e
  extends a
{
  private static boolean UYv;
  public static final a UYw;
  public final RectF HXh;
  private boolean UYt;
  public final boolean UYu;
  private int alpha;
  public final int end;
  public final int start;
  
  static
  {
    AppMethodBeat.i(227428);
    UYw = new a((byte)0);
    AppMethodBeat.o(227428);
  }
  
  public e(Drawable paramDrawable, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(paramDrawable, 0);
    AppMethodBeat.i(227427);
    this.UYu = paramBoolean;
    this.start = paramInt1;
    this.end = paramInt2;
    this.HXh = new RectF();
    this.alpha = 255;
    AppMethodBeat.o(227427);
  }
  
  public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    AppMethodBeat.i(227424);
    p.k(paramCanvas, "canvas");
    p.k(paramPaint, "paint");
    paramCharSequence = getDrawable();
    paramCanvas.save();
    Paint.FontMetricsInt localFontMetricsInt = paramPaint.getFontMetricsInt();
    paramInt1 = localFontMetricsInt.descent;
    paramInt2 = localFontMetricsInt.ascent;
    float f = localFontMetricsInt.descent + paramInt4 - (paramInt1 - paramInt2) / 2;
    p.j(paramCharSequence, "drawable");
    f -= (paramCharSequence.getBounds().bottom - paramCharSequence.getBounds().top) / 2.0F;
    paramCanvas.translate(paramFloat, f);
    this.HXh.set(paramFloat, f, paramCharSequence.getBounds().width() + paramFloat, paramCharSequence.getBounds().height() + f);
    paramInt2 = paramCharSequence.getAlpha();
    if (this.UYt) {}
    for (paramInt1 = this.alpha;; paramInt1 = paramPaint.getAlpha())
    {
      if ((paramInt1 == 0) && (paramInt2 != paramInt1)) {
        paramCharSequence.setAlpha(paramInt1);
      }
      paramCharSequence.draw(paramCanvas);
      paramCharSequence.setAlpha(paramInt2);
      paramCanvas.restore();
      if (UYv)
      {
        paramCanvas.save();
        paramInt1 = paramPaint.getColor();
        paramCharSequence = paramPaint.getStyle();
        paramPaint.setColor(-65536);
        paramPaint.setStyle(Paint.Style.STROKE);
        paramCanvas.drawRect(this.HXh, paramPaint);
        paramPaint.setColor(paramInt1);
        paramPaint.setStyle(paramCharSequence);
      }
      AppMethodBeat.o(227424);
      return;
    }
  }
  
  public final int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    AppMethodBeat.i(227417);
    p.k(paramPaint, "paint");
    paramCharSequence = getDrawable();
    p.j(paramCharSequence, "drawable");
    Rect localRect = paramCharSequence.getBounds();
    p.j(localRect, "drawable.bounds");
    paramPaint = paramPaint.getFontMetricsInt();
    paramInt1 = localRect.width();
    if (paramPaint != null)
    {
      paramInt1 = Math.abs(paramPaint.descent - paramPaint.ascent);
      paramCharSequence.setBounds(0, 0, paramInt1, paramInt1);
      paramInt2 = paramCharSequence.getBounds().width();
      paramInt1 = paramInt2;
      if (paramFontMetricsInt != null)
      {
        paramFontMetricsInt.ascent = paramPaint.ascent;
        paramFontMetricsInt.descent = paramPaint.descent;
        paramFontMetricsInt.top = paramPaint.top;
        paramFontMetricsInt.bottom = paramPaint.bottom;
        paramInt1 = paramInt2;
      }
    }
    AppMethodBeat.o(227417);
    return paramInt1;
  }
  
  public final void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(227413);
    this.alpha = Math.round(255.0F * paramFloat);
    if (paramFloat != 1.0F) {}
    for (boolean bool = true;; bool = false)
    {
      this.UYt = bool;
      AppMethodBeat.o(227413);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/smiley/EmojiSpan$Companion;", "", "()V", "DRAW_DEBUG", "", "DRAW_DEBUG$annotations", "getDRAW_DEBUG", "()Z", "setDRAW_DEBUG", "(Z)V", "plugin-emojisdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.cl.e
 * JD-Core Version:    0.7.0.1
 */