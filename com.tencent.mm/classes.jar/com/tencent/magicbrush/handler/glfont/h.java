package com.tencent.magicbrush.handler.glfont;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class h
{
  private List<k> cNf;
  private g cNj;
  private e cNk;
  private Canvas cNl;
  j cNm;
  Paint cNn;
  c cNo;
  private char[] cNp;
  private Rect cNq;
  Paint.FontMetrics cNr;
  private Rect lo;
  
  h(e parame, g paramg)
  {
    AppMethodBeat.i(140032);
    this.cNp = new char[1];
    this.lo = new Rect();
    this.cNq = new Rect();
    this.cNf = new ArrayList();
    this.cNr = new Paint.FontMetrics();
    this.cNk = parame;
    this.cNl = new Canvas(this.cNk.cMT);
    this.cNj = paramg;
    this.cNn = new Paint(1);
    this.cNn.setTextAlign(Paint.Align.LEFT);
    this.cNn.setColor(-1);
    AppMethodBeat.o(140032);
  }
  
  static float I(List<k> paramList)
  {
    AppMethodBeat.i(140040);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(140040);
      return 0.0F;
    }
    paramList = paramList.iterator();
    float f = 0.0F;
    while (paramList.hasNext())
    {
      k localk = (k)paramList.next();
      if (localk != null) {
        f = localk.cNG + f;
      }
    }
    AppMethodBeat.o(140040);
    return f;
  }
  
  private boolean RA()
  {
    if (this.cNm == null) {
      return false;
    }
    return this.cNm.cNx;
  }
  
  private void a(char paramChar, Rect paramRect, k paramk, Paint paramPaint)
  {
    AppMethodBeat.i(140037);
    if ((paramPaint == null) || (paramk == null) || (paramRect == null))
    {
      AppMethodBeat.o(140037);
      return;
    }
    this.cNp[0] = paramChar;
    this.cNl.save();
    this.cNl.clipRect(paramRect);
    this.cNl.drawText(this.cNp, 0, 1, paramRect.left - paramk.cNH, paramRect.top + paramk.height - this.cNr.bottom - 1.0F, paramPaint);
    this.cNl.restore();
    AppMethodBeat.o(140037);
  }
  
  private void a(k paramk, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140035);
    if (paramk == null)
    {
      AppMethodBeat.o(140035);
      return;
    }
    paramk.cNG = paramInt1;
    paramk.cNH = 0.0F;
    paramk.u(paramInt1, paramInt2);
    if (isItalic())
    {
      float f = (float)Math.ceil(paramInt1 * 0.5F);
      paramk.cNH -= f / 2.0F;
      paramk.width = (f + paramk.width);
    }
    if (RA())
    {
      paramk.cNH -= this.cNm.strokeWidth / 2.0F;
      paramk.width += this.cNm.strokeWidth;
    }
    if (isBold())
    {
      paramk.cNH -= 1.0F;
      paramk.width += 2.0F;
    }
    AppMethodBeat.o(140035);
  }
  
  private void a(k paramk, Rect paramRect)
  {
    AppMethodBeat.i(140036);
    paramk.k(paramRect.left / this.cNk.width(), paramRect.top / this.cNk.height(), paramRect.right / this.cNk.width(), paramRect.bottom / this.cNk.height());
    AppMethodBeat.o(140036);
  }
  
  private boolean isBold()
  {
    AppMethodBeat.i(175886);
    if (this.cNm == null)
    {
      AppMethodBeat.o(175886);
      return false;
    }
    boolean bool = this.cNm.cNy.isBold();
    AppMethodBeat.o(175886);
    return bool;
  }
  
  private boolean isItalic()
  {
    AppMethodBeat.i(140038);
    if (this.cNm == null)
    {
      AppMethodBeat.o(140038);
      return false;
    }
    boolean bool = this.cNm.cNy.isItalic();
    AppMethodBeat.o(140038);
    return bool;
  }
  
  private float v(char paramChar)
  {
    AppMethodBeat.i(140034);
    this.cNp[0] = paramChar;
    this.cNn.getTextBounds(this.cNp, 0, 1, this.lo);
    float f = this.cNn.measureText(this.cNp, 0, 1);
    f = Math.max(this.lo.width(), f);
    AppMethodBeat.o(140034);
    return f + 1.0F;
  }
  
  final k a(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140039);
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      paramDrawable = new IllegalArgumentException("width or height unexpected");
      AppMethodBeat.o(140039);
      throw paramDrawable;
    }
    k localk = this.cNj.cNd.Rz();
    localk.cNG = paramInt1;
    localk.cNH = 0.0F;
    this.cNk.b(paramInt1, paramInt2, this.lo);
    Rect localRect = this.lo;
    if ((localRect.left < 0) || (localRect.right < 0) || (localRect.width() <= 0) || (localRect.height() <= 0))
    {
      AppMethodBeat.o(140039);
      return null;
    }
    localk.u(paramInt1, paramInt2);
    localk.k(localRect.left / this.cNk.width(), localRect.top / this.cNk.height(), localRect.right / this.cNk.width(), localRect.bottom / this.cNk.height());
    localk.cNM = true;
    this.cNl.save();
    this.cNl.clipRect(localRect);
    paramDrawable.setBounds(localRect);
    paramDrawable.draw(this.cNl);
    this.cNl.restore();
    AppMethodBeat.o(140039);
    return localk;
  }
  
  final k u(char paramChar)
  {
    AppMethodBeat.i(140033);
    k localk = this.cNj.cNd.Rz();
    localk.cNM = false;
    int i = (int)Math.ceil(this.cNr.bottom - this.cNr.ascent);
    a(localk, (int)Math.ceil(v(paramChar)), i);
    if (!this.cNk.b((int)Math.ceil(localk.width), (int)Math.ceil(localk.height), this.lo))
    {
      AppMethodBeat.o(140033);
      return null;
    }
    a(localk, this.lo);
    a(paramChar, this.lo, localk, this.cNn);
    AppMethodBeat.o(140033);
    return localk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.h
 * JD-Core Version:    0.7.0.1
 */