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
  c cyA;
  private char[] cyB;
  private Rect cyC;
  Paint.FontMetrics cyD;
  private List<k> cyr;
  private g cyv;
  private e cyw;
  private Canvas cyx;
  j cyy;
  Paint cyz;
  private Rect lm;
  
  h(e parame, g paramg)
  {
    AppMethodBeat.i(140032);
    this.cyB = new char[1];
    this.lm = new Rect();
    this.cyC = new Rect();
    this.cyr = new ArrayList();
    this.cyD = new Paint.FontMetrics();
    this.cyw = parame;
    this.cyx = new Canvas(this.cyw.cyf);
    this.cyv = paramg;
    this.cyz = new Paint(1);
    this.cyz.setTextAlign(Paint.Align.LEFT);
    this.cyz.setColor(-1);
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
        f = localk.cyS + f;
      }
    }
    AppMethodBeat.o(140040);
    return f;
  }
  
  private boolean HD()
  {
    if (this.cyy == null) {
      return false;
    }
    return this.cyy.cyJ;
  }
  
  private void a(char paramChar, Rect paramRect, k paramk, Paint paramPaint)
  {
    AppMethodBeat.i(140037);
    if ((paramPaint == null) || (paramk == null) || (paramRect == null))
    {
      AppMethodBeat.o(140037);
      return;
    }
    this.cyB[0] = paramChar;
    this.cyx.save();
    this.cyx.clipRect(paramRect);
    this.cyx.drawText(this.cyB, 0, 1, paramRect.left - paramk.cyT, paramRect.top + paramk.height - this.cyD.descent - 1.0F, paramPaint);
    this.cyx.restore();
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
    paramk.cyS = paramInt1;
    paramk.cyT = 0.0F;
    paramk.t(paramInt1, paramInt2);
    if (isItalic())
    {
      float f = (float)Math.ceil(paramInt1 * 0.5F);
      paramk.cyT -= f / 2.0F;
      paramk.width = (f + paramk.width);
    }
    if (HD())
    {
      paramk.cyT -= this.cyy.strokeWidth / 2.0F;
      paramk.width += this.cyy.strokeWidth;
    }
    if (isBold())
    {
      paramk.cyT -= 1.0F;
      paramk.width += 2.0F;
    }
    AppMethodBeat.o(140035);
  }
  
  private void a(k paramk, Rect paramRect)
  {
    AppMethodBeat.i(140036);
    paramk.k(paramRect.left / this.cyw.width(), paramRect.top / this.cyw.height(), paramRect.right / this.cyw.width(), paramRect.bottom / this.cyw.height());
    AppMethodBeat.o(140036);
  }
  
  private boolean isBold()
  {
    AppMethodBeat.i(175886);
    if (this.cyy == null)
    {
      AppMethodBeat.o(175886);
      return false;
    }
    boolean bool = this.cyy.cyK.isBold();
    AppMethodBeat.o(175886);
    return bool;
  }
  
  private boolean isItalic()
  {
    AppMethodBeat.i(140038);
    if (this.cyy == null)
    {
      AppMethodBeat.o(140038);
      return false;
    }
    boolean bool = this.cyy.cyK.isItalic();
    AppMethodBeat.o(140038);
    return bool;
  }
  
  private float v(char paramChar)
  {
    AppMethodBeat.i(140034);
    this.cyB[0] = paramChar;
    this.cyz.getTextBounds(this.cyB, 0, 1, this.lm);
    float f = this.cyz.measureText(this.cyB, 0, 1);
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
    k localk = this.cyv.cyp.HC();
    localk.cyS = paramInt1;
    localk.cyT = 0.0F;
    this.cyw.b(paramInt1, paramInt2, this.lm);
    Rect localRect = this.lm;
    if ((localRect.left < 0) || (localRect.right < 0) || (localRect.width() <= 0) || (localRect.height() <= 0))
    {
      AppMethodBeat.o(140039);
      return null;
    }
    localk.t(paramInt1, paramInt2);
    localk.k(localRect.left / this.cyw.width(), localRect.top / this.cyw.height(), localRect.right / this.cyw.width(), localRect.bottom / this.cyw.height());
    localk.cyY = true;
    this.cyx.save();
    this.cyx.clipRect(localRect);
    paramDrawable.setBounds(localRect);
    paramDrawable.draw(this.cyx);
    this.cyx.restore();
    AppMethodBeat.o(140039);
    return localk;
  }
  
  final k u(char paramChar)
  {
    AppMethodBeat.i(140033);
    k localk = this.cyv.cyp.HC();
    localk.cyY = false;
    int i = (int)Math.ceil(this.cyD.descent - this.cyD.ascent);
    a(localk, (int)Math.ceil(v(paramChar)), i);
    if (!this.cyw.b((int)Math.ceil(localk.width), (int)Math.ceil(localk.height), this.lm))
    {
      AppMethodBeat.o(140033);
      return null;
    }
    a(localk, this.lm);
    a(paramChar, this.lm, localk, this.cyz);
    AppMethodBeat.o(140033);
    return localk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.h
 * JD-Core Version:    0.7.0.1
 */