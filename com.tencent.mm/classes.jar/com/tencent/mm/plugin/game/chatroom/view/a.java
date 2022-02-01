package com.tencent.mm.plugin.game.chatroom.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends ImageSpan
{
  private String Cxr;
  private int Cxs;
  private int Cxt;
  private int Cxu;
  private int Cxv;
  private int bgColor;
  private int radius;
  private int textColor;
  private int textSize;
  
  public a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    super((Drawable)localObject, 1);
    AppMethodBeat.i(210931);
    this.Cxr = paramString;
    this.bgColor = paramInt1;
    this.textColor = paramInt2;
    this.textSize = paramInt3;
    this.radius = paramInt4;
    this.Cxs = paramInt5;
    this.Cxt = paramInt6;
    this.Cxu = paramInt7;
    this.Cxv = paramInt8;
    AppMethodBeat.o(210931);
  }
  
  public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    AppMethodBeat.i(210933);
    try
    {
      paramInt3 = paramPaint.getColor();
      float f = paramPaint.getTextSize();
      paramPaint.setTextSize(this.textSize);
      paramPaint.setAntiAlias(true);
      paramPaint.setColor(this.bgColor);
      paramCharSequence = new RectF();
      paramCharSequence.left = paramFloat;
      paramCharSequence.top = (paramInt4 + paramPaint.ascent() - this.Cxu);
      paramCharSequence.right = (paramPaint.measureText(this.Cxr, paramInt1, paramInt2) + paramFloat + this.Cxs + this.Cxt);
      paramCharSequence.bottom = (paramInt4 + paramPaint.descent() + this.Cxv);
      paramCanvas.drawRoundRect(paramCharSequence, this.radius, this.radius, paramPaint);
      paramPaint.setColor(this.textColor);
      paramCanvas.drawText(this.Cxr, paramInt1, paramInt2, paramFloat + this.Cxs, paramInt4, paramPaint);
      paramPaint.setColor(paramInt3);
      paramPaint.setTextSize(f);
      AppMethodBeat.o(210933);
      return;
    }
    catch (Exception paramCanvas)
    {
      AppMethodBeat.o(210933);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.a
 * JD-Core Version:    0.7.0.1
 */