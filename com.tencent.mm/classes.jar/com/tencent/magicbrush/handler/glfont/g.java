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
  private List<j> cnK;
  private f cnO;
  private d cnP;
  private Canvas cnQ;
  i cnR;
  Paint cnS;
  private char[] cnT;
  private Rect cnU;
  Paint.FontMetrics cnV;
  private Rect jv;
  
  g(d paramd, f paramf)
  {
    AppMethodBeat.i(140032);
    this.cnT = new char[1];
    this.jv = new Rect();
    this.cnU = new Rect();
    this.cnK = new ArrayList();
    this.cnV = new Paint.FontMetrics();
    this.cnP = paramd;
    this.cnQ = new Canvas(this.cnP.cnA);
    this.cnO = paramf;
    this.cnS = new Paint(1);
    this.cnS.setTextAlign(Paint.Align.LEFT);
    this.cnS.setColor(-1);
    AppMethodBeat.o(140032);
  }
  
  static float E(List<j> paramList)
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
        f = localj.coi + f;
      }
    }
    AppMethodBeat.o(140040);
    return f;
  }
  
  private boolean Gi()
  {
    if (this.cnR == null) {
      return false;
    }
    return this.cnR.cnZ;
  }
  
  private void a(char paramChar, Rect paramRect, j paramj, Paint paramPaint)
  {
    AppMethodBeat.i(140037);
    if ((paramPaint == null) || (paramj == null) || (paramRect == null))
    {
      AppMethodBeat.o(140037);
      return;
    }
    this.cnT[0] = paramChar;
    this.cnQ.save();
    this.cnQ.clipRect(paramRect);
    this.cnQ.drawText(this.cnT, 0, 1, paramRect.left - paramj.coj, paramRect.top + paramj.height - this.cnV.descent - 1.0F, paramPaint);
    this.cnQ.restore();
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
    paramj.coi = paramInt1;
    paramj.coj = 0.0F;
    paramj.r(paramInt1, paramInt2);
    if (isItalic())
    {
      float f = (float)Math.ceil(paramInt1 * 0.5F);
      paramj.coj -= f / 2.0F;
      paramj.width = (f + paramj.width);
    }
    if (Gi())
    {
      paramj.coj -= this.cnR.strokeWidth / 2.0F;
      paramj.width += this.cnR.strokeWidth;
    }
    if (isBold())
    {
      paramj.coj -= 1.0F;
      paramj.width += 2.0F;
    }
    AppMethodBeat.o(140035);
  }
  
  private void a(j paramj, Rect paramRect)
  {
    AppMethodBeat.i(140036);
    paramj.i(paramRect.left / this.cnP.width(), paramRect.top / this.cnP.height(), paramRect.right / this.cnP.width(), paramRect.bottom / this.cnP.height());
    AppMethodBeat.o(140036);
  }
  
  private boolean isBold()
  {
    AppMethodBeat.i(175886);
    if (this.cnR == null)
    {
      AppMethodBeat.o(175886);
      return false;
    }
    boolean bool = this.cnR.coa.isBold();
    AppMethodBeat.o(175886);
    return bool;
  }
  
  private boolean isItalic()
  {
    AppMethodBeat.i(140038);
    if (this.cnR == null)
    {
      AppMethodBeat.o(140038);
      return false;
    }
    boolean bool = this.cnR.coa.isItalic();
    AppMethodBeat.o(140038);
    return bool;
  }
  
  private float t(char paramChar)
  {
    AppMethodBeat.i(140034);
    this.cnT[0] = paramChar;
    this.cnS.getTextBounds(this.cnT, 0, 1, this.jv);
    float f = this.cnS.measureText(this.cnT, 0, 1);
    f = Math.max(this.jv.width(), f);
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
    j localj = this.cnO.cnI.Gh();
    localj.coi = paramInt1;
    localj.coj = 0.0F;
    this.cnP.b(paramInt1, paramInt2, this.jv);
    Rect localRect = this.jv;
    if ((localRect.left < 0) || (localRect.right < 0) || (localRect.width() <= 0) || (localRect.height() <= 0))
    {
      AppMethodBeat.o(140039);
      return null;
    }
    localj.r(paramInt1, paramInt2);
    localj.i(localRect.left / this.cnP.width(), localRect.top / this.cnP.height(), localRect.right / this.cnP.width(), localRect.bottom / this.cnP.height());
    localj.coo = true;
    this.cnQ.save();
    this.cnQ.clipRect(localRect);
    paramDrawable.setBounds(localRect);
    paramDrawable.draw(this.cnQ);
    this.cnQ.restore();
    AppMethodBeat.o(140039);
    return localj;
  }
  
  final j s(char paramChar)
  {
    AppMethodBeat.i(140033);
    j localj = this.cnO.cnI.Gh();
    localj.coo = false;
    int i = (int)Math.ceil(this.cnV.descent - this.cnV.ascent);
    a(localj, (int)Math.ceil(t(paramChar)), i);
    if (!this.cnP.b((int)Math.ceil(localj.width), (int)Math.ceil(localj.height), this.jv))
    {
      AppMethodBeat.o(140033);
      return null;
    }
    a(localj, this.jv);
    a(paramChar, this.jv, localj, this.cnS);
    AppMethodBeat.o(140033);
    return localj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.g
 * JD-Core Version:    0.7.0.1
 */