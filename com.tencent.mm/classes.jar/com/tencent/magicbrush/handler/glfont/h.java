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
  private Rect aQJ;
  Paint.FontMetrics eJA;
  private List<k> eJo;
  private g eJs;
  private e eJt;
  private Canvas eJu;
  j eJv;
  Paint eJw;
  c eJx;
  private char[] eJy;
  private Rect eJz;
  
  h(e parame, g paramg)
  {
    AppMethodBeat.i(140032);
    this.eJy = new char[1];
    this.aQJ = new Rect();
    this.eJz = new Rect();
    this.eJo = new ArrayList();
    this.eJA = new Paint.FontMetrics();
    this.eJt = parame;
    this.eJu = new Canvas(this.eJt.eJc);
    this.eJs = paramg;
    this.eJw = new Paint(1);
    this.eJw.setTextAlign(Paint.Align.LEFT);
    this.eJw.setColor(-1);
    AppMethodBeat.o(140032);
  }
  
  private void a(char paramChar, Rect paramRect, k paramk, Paint paramPaint)
  {
    AppMethodBeat.i(140037);
    if ((paramPaint == null) || (paramk == null) || (paramRect == null))
    {
      AppMethodBeat.o(140037);
      return;
    }
    this.eJy[0] = paramChar;
    this.eJu.save();
    this.eJu.clipRect(paramRect);
    this.eJu.drawText(this.eJy, 0, 1, paramRect.left - paramk.eJQ, paramRect.top + paramk.height - this.eJA.bottom - 1.0F, paramPaint);
    this.eJu.restore();
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
    paramk.eJP = paramInt1;
    paramk.eJQ = 0.0F;
    paramk.ac(paramInt1, paramInt2);
    if (avP())
    {
      float f = (float)Math.ceil(paramInt1 * 0.5F);
      paramk.eJQ -= f / 2.0F;
      paramk.width = (f + paramk.width);
    }
    if (avN())
    {
      paramk.eJQ -= this.eJv.strokeWidth / 2.0F;
      paramk.width += this.eJv.strokeWidth;
    }
    if (avO())
    {
      paramk.eJQ -= 1.0F;
      paramk.width += 2.0F;
    }
    AppMethodBeat.o(140035);
  }
  
  private void a(k paramk, Rect paramRect)
  {
    AppMethodBeat.i(140036);
    paramk.n(paramRect.left / this.eJt.width(), paramRect.top / this.eJt.height(), paramRect.right / this.eJt.width(), paramRect.bottom / this.eJt.height());
    AppMethodBeat.o(140036);
  }
  
  private boolean avN()
  {
    if (this.eJv == null) {
      return false;
    }
    return this.eJv.eJG;
  }
  
  private boolean avO()
  {
    AppMethodBeat.i(175886);
    if (this.eJv == null)
    {
      AppMethodBeat.o(175886);
      return false;
    }
    boolean bool = this.eJv.eJH.avO();
    AppMethodBeat.o(175886);
    return bool;
  }
  
  private boolean avP()
  {
    AppMethodBeat.i(140038);
    if (this.eJv == null)
    {
      AppMethodBeat.o(140038);
      return false;
    }
    boolean bool = this.eJv.eJH.avP();
    AppMethodBeat.o(140038);
    return bool;
  }
  
  static float bd(List<k> paramList)
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
        f = localk.eJP + f;
      }
    }
    AppMethodBeat.o(140040);
    return f;
  }
  
  private float r(char paramChar)
  {
    AppMethodBeat.i(140034);
    this.eJy[0] = paramChar;
    this.eJw.getTextBounds(this.eJy, 0, 1, this.aQJ);
    float f = this.eJw.measureText(this.eJy, 0, 1);
    f = Math.max(this.aQJ.width(), f);
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
    k localk = this.eJs.eJm.avM();
    localk.eJP = paramInt1;
    localk.eJQ = 0.0F;
    this.eJt.b(paramInt1, paramInt2, this.aQJ);
    Rect localRect = this.aQJ;
    if ((localRect.left < 0) || (localRect.right < 0) || (localRect.width() <= 0) || (localRect.height() <= 0))
    {
      AppMethodBeat.o(140039);
      return null;
    }
    localk.ac(paramInt1, paramInt2);
    localk.n(localRect.left / this.eJt.width(), localRect.top / this.eJt.height(), localRect.right / this.eJt.width(), localRect.bottom / this.eJt.height());
    localk.eJV = true;
    this.eJu.save();
    this.eJu.clipRect(localRect);
    paramDrawable.setBounds(localRect);
    paramDrawable.draw(this.eJu);
    this.eJu.restore();
    AppMethodBeat.o(140039);
    return localk;
  }
  
  final k q(char paramChar)
  {
    AppMethodBeat.i(140033);
    k localk = this.eJs.eJm.avM();
    localk.eJV = false;
    int i = (int)Math.ceil(this.eJA.bottom - this.eJA.ascent);
    a(localk, (int)Math.ceil(r(paramChar)), i);
    if (!this.eJt.b((int)Math.ceil(localk.width), (int)Math.ceil(localk.height), this.aQJ))
    {
      AppMethodBeat.o(140033);
      return null;
    }
    a(localk, this.aQJ);
    a(paramChar, this.aQJ, localk, this.eJw);
    AppMethodBeat.o(140033);
    return localk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.h
 * JD-Core Version:    0.7.0.1
 */