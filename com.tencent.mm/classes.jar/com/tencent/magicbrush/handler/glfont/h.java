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
  private List<k> cyY;
  private g czc;
  private e czd;
  private Canvas cze;
  j czf;
  Paint czg;
  c czh;
  private char[] czi;
  private Rect czj;
  Paint.FontMetrics czk;
  private Rect lm;
  
  h(e parame, g paramg)
  {
    AppMethodBeat.i(140032);
    this.czi = new char[1];
    this.lm = new Rect();
    this.czj = new Rect();
    this.cyY = new ArrayList();
    this.czk = new Paint.FontMetrics();
    this.czd = parame;
    this.cze = new Canvas(this.czd.cyM);
    this.czc = paramg;
    this.czg = new Paint(1);
    this.czg.setTextAlign(Paint.Align.LEFT);
    this.czg.setColor(-1);
    AppMethodBeat.o(140032);
  }
  
  static float E(List<k> paramList)
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
        f = localk.czz + f;
      }
    }
    AppMethodBeat.o(140040);
    return f;
  }
  
  private boolean HL()
  {
    if (this.czf == null) {
      return false;
    }
    return this.czf.czq;
  }
  
  private void a(char paramChar, Rect paramRect, k paramk, Paint paramPaint)
  {
    AppMethodBeat.i(140037);
    if ((paramPaint == null) || (paramk == null) || (paramRect == null))
    {
      AppMethodBeat.o(140037);
      return;
    }
    this.czi[0] = paramChar;
    this.cze.save();
    this.cze.clipRect(paramRect);
    this.cze.drawText(this.czi, 0, 1, paramRect.left - paramk.czA, paramRect.top + paramk.height - this.czk.bottom - 1.0F, paramPaint);
    this.cze.restore();
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
    paramk.czz = paramInt1;
    paramk.czA = 0.0F;
    paramk.t(paramInt1, paramInt2);
    if (isItalic())
    {
      float f = (float)Math.ceil(paramInt1 * 0.5F);
      paramk.czA -= f / 2.0F;
      paramk.width = (f + paramk.width);
    }
    if (HL())
    {
      paramk.czA -= this.czf.strokeWidth / 2.0F;
      paramk.width += this.czf.strokeWidth;
    }
    if (isBold())
    {
      paramk.czA -= 1.0F;
      paramk.width += 2.0F;
    }
    AppMethodBeat.o(140035);
  }
  
  private void a(k paramk, Rect paramRect)
  {
    AppMethodBeat.i(140036);
    paramk.k(paramRect.left / this.czd.width(), paramRect.top / this.czd.height(), paramRect.right / this.czd.width(), paramRect.bottom / this.czd.height());
    AppMethodBeat.o(140036);
  }
  
  private boolean isBold()
  {
    AppMethodBeat.i(175886);
    if (this.czf == null)
    {
      AppMethodBeat.o(175886);
      return false;
    }
    boolean bool = this.czf.czr.isBold();
    AppMethodBeat.o(175886);
    return bool;
  }
  
  private boolean isItalic()
  {
    AppMethodBeat.i(140038);
    if (this.czf == null)
    {
      AppMethodBeat.o(140038);
      return false;
    }
    boolean bool = this.czf.czr.isItalic();
    AppMethodBeat.o(140038);
    return bool;
  }
  
  private float v(char paramChar)
  {
    AppMethodBeat.i(140034);
    this.czi[0] = paramChar;
    this.czg.getTextBounds(this.czi, 0, 1, this.lm);
    float f = this.czg.measureText(this.czi, 0, 1);
    f = Math.max(this.lm.width(), f);
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
    k localk = this.czc.cyW.HK();
    localk.czz = paramInt1;
    localk.czA = 0.0F;
    this.czd.b(paramInt1, paramInt2, this.lm);
    Rect localRect = this.lm;
    if ((localRect.left < 0) || (localRect.right < 0) || (localRect.width() <= 0) || (localRect.height() <= 0))
    {
      AppMethodBeat.o(140039);
      return null;
    }
    localk.t(paramInt1, paramInt2);
    localk.k(localRect.left / this.czd.width(), localRect.top / this.czd.height(), localRect.right / this.czd.width(), localRect.bottom / this.czd.height());
    localk.czF = true;
    this.cze.save();
    this.cze.clipRect(localRect);
    paramDrawable.setBounds(localRect);
    paramDrawable.draw(this.cze);
    this.cze.restore();
    AppMethodBeat.o(140039);
    return localk;
  }
  
  final k u(char paramChar)
  {
    AppMethodBeat.i(140033);
    k localk = this.czc.cyW.HK();
    localk.czF = false;
    int i = (int)Math.ceil(this.czk.bottom - this.czk.ascent);
    a(localk, (int)Math.ceil(v(paramChar)), i);
    if (!this.czd.b((int)Math.ceil(localk.width), (int)Math.ceil(localk.height), this.lm))
    {
      AppMethodBeat.o(140033);
      return null;
    }
    a(localk, this.lm);
    a(paramChar, this.lm, localk, this.czg);
    AppMethodBeat.o(140033);
    return localk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.h
 * JD-Core Version:    0.7.0.1
 */