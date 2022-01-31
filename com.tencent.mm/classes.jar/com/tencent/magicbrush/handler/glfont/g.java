package com.tencent.magicbrush.handler.glfont;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class g
{
  private List<j> bJT;
  private f bJX;
  private d bJY;
  private Canvas bJZ;
  Paint bKa;
  private char[] bKb;
  private Rect bKc;
  private Rect bKd;
  Paint.FontMetrics bKe;
  
  g(d paramd, f paramf)
  {
    AppMethodBeat.i(115931);
    this.bKb = new char[1];
    this.bKc = new Rect();
    this.bKd = new Rect();
    this.bJT = new ArrayList();
    this.bKe = new Paint.FontMetrics();
    this.bJY = paramd;
    this.bJZ = new Canvas(this.bJY.bJJ);
    this.bJX = paramf;
    this.bKa = new Paint(1);
    this.bKa.setTextAlign(Paint.Align.LEFT);
    this.bKa.setColor(-1);
    AppMethodBeat.o(115931);
  }
  
  static float C(List<j> paramList)
  {
    AppMethodBeat.i(115939);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(115939);
      return 0.0F;
    }
    paramList = paramList.iterator();
    float f = 0.0F;
    while (paramList.hasNext())
    {
      j localj = (j)paramList.next();
      if (localj != null) {
        f = localj.bKs + f;
      }
    }
    AppMethodBeat.o(115939);
    return f;
  }
  
  private void a(char paramChar, Rect paramRect, j paramj, Paint paramPaint)
  {
    AppMethodBeat.i(115936);
    if ((paramPaint == null) || (paramj == null) || (paramRect == null))
    {
      AppMethodBeat.o(115936);
      return;
    }
    this.bKb[0] = paramChar;
    this.bJZ.save();
    this.bJZ.clipRect(paramRect);
    this.bJZ.drawText(this.bKb, 0, 1, paramRect.left - paramj.bKt, paramRect.top + paramj.height - this.bKe.descent - 1.0F, paramPaint);
    this.bJZ.restore();
    AppMethodBeat.o(115936);
  }
  
  private void a(j paramj, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115934);
    if (paramj == null)
    {
      AppMethodBeat.o(115934);
      return;
    }
    paramj.bKs = paramInt1;
    if (yv())
    {
      paramj.bKt = (-this.bKa.getStrokeWidth() / 2.0F);
      paramj.A(paramInt1 + this.bKa.getStrokeWidth(), paramInt2);
      AppMethodBeat.o(115934);
      return;
    }
    paramj.bKt = 0.0F;
    paramj.A(paramInt1, paramInt2);
    AppMethodBeat.o(115934);
  }
  
  private void a(j paramj, Rect paramRect)
  {
    AppMethodBeat.i(115935);
    paramj.f(paramRect.left / this.bJY.width(), paramRect.top / this.bJY.height(), paramRect.right / this.bJY.width(), paramRect.bottom / this.bJY.height());
    AppMethodBeat.o(115935);
  }
  
  private float s(char paramChar)
  {
    AppMethodBeat.i(115933);
    this.bKb[0] = paramChar;
    this.bKa.getTextBounds(this.bKb, 0, 1, this.bKc);
    float f = this.bKa.measureText(this.bKb, 0, 1);
    f = Math.max(this.bKc.width(), f);
    AppMethodBeat.o(115933);
    return f + 1.0F;
  }
  
  private boolean yv()
  {
    AppMethodBeat.i(115937);
    Paint localPaint = this.bKa;
    if (localPaint == null)
    {
      AppMethodBeat.o(115937);
      return false;
    }
    if ((localPaint.getStyle() == Paint.Style.STROKE) || (localPaint.getStyle() == Paint.Style.FILL_AND_STROKE))
    {
      AppMethodBeat.o(115937);
      return true;
    }
    AppMethodBeat.o(115937);
    return false;
  }
  
  final j a(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115938);
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      paramDrawable = new IllegalArgumentException("width or height unexpected");
      AppMethodBeat.o(115938);
      throw paramDrawable;
    }
    j localj = this.bJX.bJR.yu();
    localj.bKs = paramInt1;
    localj.bKt = 0.0F;
    this.bJY.b(paramInt1, paramInt2, this.bKc);
    Rect localRect = this.bKc;
    if ((localRect.left < 0) || (localRect.right < 0) || (localRect.width() <= 0) || (localRect.height() <= 0))
    {
      AppMethodBeat.o(115938);
      return null;
    }
    localj.A(paramInt1, paramInt2);
    localj.f(localRect.left / this.bJY.width(), localRect.top / this.bJY.height(), localRect.right / this.bJY.width(), localRect.bottom / this.bJY.height());
    localj.bKy = true;
    this.bJZ.save();
    this.bJZ.clipRect(localRect);
    paramDrawable.setBounds(localRect);
    paramDrawable.draw(this.bJZ);
    this.bJZ.restore();
    AppMethodBeat.o(115938);
    return localj;
  }
  
  final j r(char paramChar)
  {
    AppMethodBeat.i(115932);
    j localj = this.bJX.bJR.yu();
    localj.bKy = false;
    int i = (int)Math.ceil(this.bKe.descent - this.bKe.ascent);
    a(localj, (int)Math.ceil(s(paramChar)), i);
    if (!this.bJY.b((int)Math.ceil(localj.width), (int)Math.ceil(localj.height), this.bKc))
    {
      AppMethodBeat.o(115932);
      return null;
    }
    a(localj, this.bKc);
    a(paramChar, this.bKc, localj, this.bKa);
    AppMethodBeat.o(115932);
    return localj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.g
 * JD-Core Version:    0.7.0.1
 */