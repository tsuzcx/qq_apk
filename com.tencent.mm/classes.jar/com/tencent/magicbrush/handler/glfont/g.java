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

final class g
{
  private List<j> cqD;
  private f cqH;
  private d cqI;
  private Canvas cqJ;
  i cqK;
  Paint cqL;
  private char[] cqM;
  private Rect cqN;
  Paint.FontMetrics cqO;
  private Rect iw;
  
  g(d paramd, f paramf)
  {
    AppMethodBeat.i(140032);
    this.cqM = new char[1];
    this.iw = new Rect();
    this.cqN = new Rect();
    this.cqD = new ArrayList();
    this.cqO = new Paint.FontMetrics();
    this.cqI = paramd;
    this.cqJ = new Canvas(this.cqI.cqt);
    this.cqH = paramf;
    this.cqL = new Paint(1);
    this.cqL.setTextAlign(Paint.Align.LEFT);
    this.cqL.setColor(-1);
    AppMethodBeat.o(140032);
  }
  
  private boolean Gw()
  {
    if (this.cqK == null) {
      return false;
    }
    return this.cqK.cqS;
  }
  
  static float N(List<j> paramList)
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
      j localj = (j)paramList.next();
      if (localj != null) {
        f = localj.crb + f;
      }
    }
    AppMethodBeat.o(140040);
    return f;
  }
  
  private void a(char paramChar, Rect paramRect, j paramj, Paint paramPaint)
  {
    AppMethodBeat.i(140037);
    if ((paramPaint == null) || (paramj == null) || (paramRect == null))
    {
      AppMethodBeat.o(140037);
      return;
    }
    this.cqM[0] = paramChar;
    this.cqJ.save();
    this.cqJ.clipRect(paramRect);
    this.cqJ.drawText(this.cqM, 0, 1, paramRect.left - paramj.crd, paramRect.top + paramj.height - this.cqO.descent - 1.0F, paramPaint);
    this.cqJ.restore();
    AppMethodBeat.o(140037);
  }
  
  private void a(j paramj, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140035);
    if (paramj == null)
    {
      AppMethodBeat.o(140035);
      return;
    }
    paramj.crb = paramInt1;
    paramj.crd = 0.0F;
    paramj.r(paramInt1, paramInt2);
    if (isItalic())
    {
      float f = (float)Math.ceil(paramInt1 * 0.5F);
      paramj.crd -= f / 2.0F;
      paramj.width = (f + paramj.width);
    }
    if (Gw())
    {
      paramj.crd -= this.cqK.strokeWidth / 2.0F;
      paramj.width += this.cqK.strokeWidth;
    }
    if (isBold())
    {
      paramj.crd -= 1.0F;
      paramj.width += 2.0F;
    }
    AppMethodBeat.o(140035);
  }
  
  private void a(j paramj, Rect paramRect)
  {
    AppMethodBeat.i(140036);
    paramj.i(paramRect.left / this.cqI.width(), paramRect.top / this.cqI.height(), paramRect.right / this.cqI.width(), paramRect.bottom / this.cqI.height());
    AppMethodBeat.o(140036);
  }
  
  private boolean isBold()
  {
    AppMethodBeat.i(175886);
    if (this.cqK == null)
    {
      AppMethodBeat.o(175886);
      return false;
    }
    boolean bool = this.cqK.cqT.isBold();
    AppMethodBeat.o(175886);
    return bool;
  }
  
  private boolean isItalic()
  {
    AppMethodBeat.i(140038);
    if (this.cqK == null)
    {
      AppMethodBeat.o(140038);
      return false;
    }
    boolean bool = this.cqK.cqT.isItalic();
    AppMethodBeat.o(140038);
    return bool;
  }
  
  private float t(char paramChar)
  {
    AppMethodBeat.i(140034);
    this.cqM[0] = paramChar;
    this.cqL.getTextBounds(this.cqM, 0, 1, this.iw);
    float f = this.cqL.measureText(this.cqM, 0, 1);
    f = Math.max(this.iw.width(), f);
    AppMethodBeat.o(140034);
    return f + 1.0F;
  }
  
  final j a(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140039);
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      paramDrawable = new IllegalArgumentException("width or height unexpected");
      AppMethodBeat.o(140039);
      throw paramDrawable;
    }
    j localj = this.cqH.cqB.Gv();
    localj.crb = paramInt1;
    localj.crd = 0.0F;
    this.cqI.b(paramInt1, paramInt2, this.iw);
    Rect localRect = this.iw;
    if ((localRect.left < 0) || (localRect.right < 0) || (localRect.width() <= 0) || (localRect.height() <= 0))
    {
      AppMethodBeat.o(140039);
      return null;
    }
    localj.r(paramInt1, paramInt2);
    localj.i(localRect.left / this.cqI.width(), localRect.top / this.cqI.height(), localRect.right / this.cqI.width(), localRect.bottom / this.cqI.height());
    localj.cri = true;
    this.cqJ.save();
    this.cqJ.clipRect(localRect);
    paramDrawable.setBounds(localRect);
    paramDrawable.draw(this.cqJ);
    this.cqJ.restore();
    AppMethodBeat.o(140039);
    return localj;
  }
  
  final j s(char paramChar)
  {
    AppMethodBeat.i(140033);
    j localj = this.cqH.cqB.Gv();
    localj.cri = false;
    int i = (int)Math.ceil(this.cqO.descent - this.cqO.ascent);
    a(localj, (int)Math.ceil(t(paramChar)), i);
    if (!this.cqI.b((int)Math.ceil(localj.width), (int)Math.ceil(localj.height), this.iw))
    {
      AppMethodBeat.o(140033);
      return null;
    }
    a(localj, this.iw);
    a(paramChar, this.iw, localj, this.cqL);
    AppMethodBeat.o(140033);
    return localj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.g
 * JD-Core Version:    0.7.0.1
 */