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
  private float ayd;
  private float aye;
  private float dsW;
  private boolean dsX;
  private boolean dsY;
  private float dsy;
  private float dsz;
  public int mColor;
  private Path xT;
  
  public d()
  {
    AppMethodBeat.i(9148);
    this.dsX = true;
    this.dsY = false;
    this.mColor = com.tencent.mm.view.footer.a.RoQ[2];
    this.xT = new Path();
    AppMethodBeat.o(9148);
  }
  
  public final a XS()
  {
    return a.drL;
  }
  
  public final void XT()
  {
    AppMethodBeat.i(9152);
    cT(true);
    AppMethodBeat.o(9152);
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(9149);
    super.onAlive();
    this.dsW = this.drS.getInitScale();
    AppMethodBeat.o(9149);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9151);
    paramCanvas.save();
    paramCanvas.clipRect(this.drU);
    d(paramCanvas);
    if (!this.xT.isEmpty()) {
      new com.tencent.mm.z.b(this.xT, this.drS.getInitScale() / this.drS.getCurScale(), this.mColor).draw(paramCanvas);
    }
    paramCanvas.restore();
    AppMethodBeat.o(9151);
  }
  
  public final boolean q(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9150);
    if (!XZ())
    {
      AppMethodBeat.o(9150);
      return false;
    }
    if (this.dsb != null) {
      this.dsb.q(paramMotionEvent);
    }
    float[] arrayOfFloat = v(paramMotionEvent.getX(), paramMotionEvent.getY());
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      boolean bool = this.dsX;
      AppMethodBeat.o(9150);
      return bool;
      if (this.drU.contains((int)arrayOfFloat[0], (int)arrayOfFloat[1]))
      {
        float f = arrayOfFloat[0];
        this.dsy = f;
        this.ayd = f;
        f = arrayOfFloat[1];
        this.dsz = f;
        this.aye = f;
      }
      for (this.dsX = true;; this.dsX = false)
      {
        this.dsY = false;
        break;
      }
      if ((this.dsX) && (this.dsY))
      {
        if (XU() == null)
        {
          AppMethodBeat.o(9150);
          return false;
        }
        XU().add(new com.tencent.mm.z.b(new Path(this.xT), this.drS.getInitScale() / this.drS.getCurScale(), this.mColor));
        cT(false);
        c.alF().b(h.diH);
      }
      Yc();
      this.xT.reset();
      this.dsY = false;
      this.dsX = false;
      continue;
      if ((this.dsX) && (this.dsY))
      {
        this.dsy = this.ayd;
        this.dsz = this.aye;
        this.ayd = arrayOfFloat[0];
        this.aye = arrayOfFloat[1];
        this.xT.quadTo(this.dsy, this.dsz, (this.ayd + this.dsy) / 2.0F, (this.aye + this.dsz) / 2.0F);
        Yb();
      }
      else if ((this.dsX) && (!this.dsY))
      {
        this.xT.moveTo(arrayOfFloat[0], arrayOfFloat[1]);
        this.dsY = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.e.d
 * JD-Core Version:    0.7.0.1
 */