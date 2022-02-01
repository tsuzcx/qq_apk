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
  private String Ipr;
  private int Ips;
  private int Ipt;
  private int Ipu;
  private int Ipv;
  private int bgColor;
  private int radius;
  private int textColor;
  private int textSize;
  
  public a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    super((Drawable)localObject, 1);
    AppMethodBeat.i(276326);
    this.Ipr = paramString;
    this.bgColor = paramInt1;
    this.textColor = paramInt2;
    this.textSize = paramInt3;
    this.radius = paramInt4;
    this.Ips = paramInt5;
    this.Ipt = paramInt6;
    this.Ipu = paramInt7;
    this.Ipv = paramInt8;
    AppMethodBeat.o(276326);
  }
  
  public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    AppMethodBeat.i(276338);
    try
    {
      paramInt3 = paramPaint.getColor();
      float f = paramPaint.getTextSize();
      paramPaint.setTextSize(this.textSize);
      paramPaint.setAntiAlias(true);
      paramPaint.setColor(this.bgColor);
      paramCharSequence = new RectF();
      paramCharSequence.left = paramFloat;
      paramCharSequence.top = (paramInt4 + paramPaint.ascent() - this.Ipu);
      paramCharSequence.right = (paramPaint.measureText(this.Ipr, paramInt1, paramInt2) + paramFloat + this.Ips + this.Ipt);
      paramCharSequence.bottom = (paramInt4 + paramPaint.descent() + this.Ipv);
      paramCanvas.drawRoundRect(paramCharSequence, this.radius, this.radius, paramPaint);
      paramPaint.setColor(this.textColor);
      paramCanvas.drawText(this.Ipr, paramInt1, paramInt2, paramFloat + this.Ips, paramInt4, paramPaint);
      paramPaint.setColor(paramInt3);
      paramPaint.setTextSize(f);
      AppMethodBeat.o(276338);
      return;
    }
    catch (Exception paramCanvas)
    {
      AppMethodBeat.o(276338);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.a
 * JD-Core Version:    0.7.0.1
 */