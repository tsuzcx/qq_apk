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
  private Rect bCT;
  private List<k> cNT;
  private g cNX;
  private e cNY;
  private Canvas cNZ;
  j cOa;
  Paint cOb;
  c cOc;
  private char[] cOd;
  private Rect cOe;
  Paint.FontMetrics cOf;
  
  h(e parame, g paramg)
  {
    AppMethodBeat.i(140032);
    this.cOd = new char[1];
    this.bCT = new Rect();
    this.cOe = new Rect();
    this.cNT = new ArrayList();
    this.cOf = new Paint.FontMetrics();
    this.cNY = parame;
    this.cNZ = new Canvas(this.cNY.cNH);
    this.cNX = paramg;
    this.cOb = new Paint(1);
    this.cOb.setTextAlign(Paint.Align.LEFT);
    this.cOb.setColor(-1);
    AppMethodBeat.o(140032);
  }
  
  private float A(char paramChar)
  {
    AppMethodBeat.i(140034);
    this.cOd[0] = paramChar;
    this.cOb.getTextBounds(this.cOd, 0, 1, this.bCT);
    float f = this.cOb.measureText(this.cOd, 0, 1);
    f = Math.max(this.bCT.width(), f);
    AppMethodBeat.o(140034);
    return f + 1.0F;
  }
  
  static float F(List<k> paramList)
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
        f = localk.cOu + f;
      }
    }
    AppMethodBeat.o(140040);
    return f;
  }
  
  private boolean Vk()
  {
    if (this.cOa == null) {
      return false;
    }
    return this.cOa.cOl;
  }
  
  private boolean Vl()
  {
    AppMethodBeat.i(175886);
    if (this.cOa == null)
    {
      AppMethodBeat.o(175886);
      return false;
    }
    boolean bool = this.cOa.cOm.Vl();
    AppMethodBeat.o(175886);
    return bool;
  }
  
  private boolean Vm()
  {
    AppMethodBeat.i(140038);
    if (this.cOa == null)
    {
      AppMethodBeat.o(140038);
      return false;
    }
    boolean bool = this.cOa.cOm.Vm();
    AppMethodBeat.o(140038);
    return bool;
  }
  
  private void a(char paramChar, Rect paramRect, k paramk, Paint paramPaint)
  {
    AppMethodBeat.i(140037);
    if ((paramPaint == null) || (paramk == null) || (paramRect == null))
    {
      AppMethodBeat.o(140037);
      return;
    }
    this.cOd[0] = paramChar;
    this.cNZ.save();
    this.cNZ.clipRect(paramRect);
    this.cNZ.drawText(this.cOd, 0, 1, paramRect.left - paramk.cOv, paramRect.top + paramk.height - this.cOf.bottom - 1.0F, paramPaint);
    this.cNZ.restore();
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
    paramk.cOu = paramInt1;
    paramk.cOv = 0.0F;
    paramk.w(paramInt1, paramInt2);
    if (Vm())
    {
      float f = (float)Math.ceil(paramInt1 * 0.5F);
      paramk.cOv -= f / 2.0F;
      paramk.width = (f + paramk.width);
    }
    if (Vk())
    {
      paramk.cOv -= this.cOa.strokeWidth / 2.0F;
      paramk.width += this.cOa.strokeWidth;
    }
    if (Vl())
    {
      paramk.cOv -= 1.0F;
      paramk.width += 2.0F;
    }
    AppMethodBeat.o(140035);
  }
  
  private void a(k paramk, Rect paramRect)
  {
    AppMethodBeat.i(140036);
    paramk.l(paramRect.left / this.cNY.width(), paramRect.top / this.cNY.height(), paramRect.right / this.cNY.width(), paramRect.bottom / this.cNY.height());
    AppMethodBeat.o(140036);
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
    k localk = this.cNX.cNR.Vj();
    localk.cOu = paramInt1;
    localk.cOv = 0.0F;
    this.cNY.b(paramInt1, paramInt2, this.bCT);
    Rect localRect = this.bCT;
    if ((localRect.left < 0) || (localRect.right < 0) || (localRect.width() <= 0) || (localRect.height() <= 0))
    {
      AppMethodBeat.o(140039);
      return null;
    }
    localk.w(paramInt1, paramInt2);
    localk.l(localRect.left / this.cNY.width(), localRect.top / this.cNY.height(), localRect.right / this.cNY.width(), localRect.bottom / this.cNY.height());
    localk.cOA = true;
    this.cNZ.save();
    this.cNZ.clipRect(localRect);
    paramDrawable.setBounds(localRect);
    paramDrawable.draw(this.cNZ);
    this.cNZ.restore();
    AppMethodBeat.o(140039);
    return localk;
  }
  
  final k z(char paramChar)
  {
    AppMethodBeat.i(140033);
    k localk = this.cNX.cNR.Vj();
    localk.cOA = false;
    int i = (int)Math.ceil(this.cOf.bottom - this.cOf.ascent);
    a(localk, (int)Math.ceil(A(paramChar)), i);
    if (!this.cNY.b((int)Math.ceil(localk.width), (int)Math.ceil(localk.height), this.bCT))
    {
      AppMethodBeat.o(140033);
      return null;
    }
    a(localk, this.bCT);
    a(paramChar, this.bCT, localk, this.cOb);
    AppMethodBeat.o(140033);
    return localk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.h
 * JD-Core Version:    0.7.0.1
 */