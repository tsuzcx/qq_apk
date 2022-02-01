package com.tencent.mm.e;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;
import com.tencent.mm.cache.c;
import com.tencent.mm.cache.f;

public final class d
  extends b
{
  private Path auD;
  private float flH;
  private boolean flI;
  private boolean flJ;
  private float flk;
  private float fll;
  public int mColor;
  private float vX;
  private float vY;
  
  public d()
  {
    AppMethodBeat.i(9148);
    this.flI = true;
    this.flJ = false;
    this.mColor = com.tencent.mm.view.footer.a.YQk[2];
    this.auD = new Path();
    AppMethodBeat.o(9148);
  }
  
  public final a acy()
  {
    return a.fkx;
  }
  
  public final void acz()
  {
    AppMethodBeat.i(9152);
    dq(true);
    AppMethodBeat.o(9152);
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(9149);
    super.onAlive();
    this.flH = this.fkE.getInitScale();
    AppMethodBeat.o(9149);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9151);
    paramCanvas.save();
    paramCanvas.clipRect(getAliveRect());
    e(paramCanvas);
    if (!this.auD.isEmpty()) {
      new com.tencent.mm.ab.b(this.auD, this.fkE.getInitScale() / this.fkE.getCurScale(), this.mColor).draw(paramCanvas);
    }
    paramCanvas.restore();
    AppMethodBeat.o(9151);
  }
  
  public final boolean q(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9150);
    if (!acF())
    {
      AppMethodBeat.o(9150);
      return false;
    }
    if (this.fkO != null) {
      this.fkO.q(paramMotionEvent);
    }
    float[] arrayOfFloat = x(paramMotionEvent.getX(), paramMotionEvent.getY());
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      boolean bool = this.flI;
      AppMethodBeat.o(9150);
      return bool;
      if (getAliveRect().contains((int)arrayOfFloat[0], (int)arrayOfFloat[1]))
      {
        float f = arrayOfFloat[0];
        this.flk = f;
        this.vX = f;
        f = arrayOfFloat[1];
        this.fll = f;
        this.vY = f;
      }
      for (this.flI = true;; this.flI = false)
      {
        this.flJ = false;
        break;
      }
      if ((this.flI) && (this.flJ))
      {
        if (acA() == null)
        {
          AppMethodBeat.o(9150);
          return false;
        }
        acA().add(new com.tencent.mm.ab.b(new Path(this.auD), this.fkE.getInitScale() / this.fkE.getCurScale(), this.mColor));
        dq(false);
        c.arE().b(h.fan);
      }
      acI();
      this.auD.reset();
      this.flJ = false;
      this.flI = false;
      continue;
      if ((this.flI) && (this.flJ))
      {
        this.flk = this.vX;
        this.fll = this.vY;
        this.vX = arrayOfFloat[0];
        this.vY = arrayOfFloat[1];
        this.auD.quadTo(this.flk, this.fll, (this.vX + this.flk) / 2.0F, (this.vY + this.fll) / 2.0F);
        acH();
      }
      else if ((this.flI) && (!this.flJ))
      {
        this.auD.moveTo(arrayOfFloat[0], arrayOfFloat[1]);
        this.flJ = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.e.d
 * JD-Core Version:    0.7.0.1
 */