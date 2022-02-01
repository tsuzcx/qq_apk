package com.tencent.mm.e;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.g;
import com.tencent.mm.cache.c;
import com.tencent.mm.cache.f;

public final class d
  extends b
{
  private float awo;
  private float awp;
  private float cPW;
  private boolean cPX;
  private boolean cPY;
  private float cPy;
  private float cPz;
  public int mColor;
  private Path vU;
  
  public d()
  {
    AppMethodBeat.i(9148);
    this.cPX = true;
    this.cPY = false;
    this.mColor = com.tencent.mm.view.footer.a.JAq[2];
    this.vU = new Path();
    AppMethodBeat.o(9148);
  }
  
  public final a LZ()
  {
    return a.cON;
  }
  
  public final void Ma()
  {
    AppMethodBeat.i(9152);
    ck(true);
    AppMethodBeat.o(9152);
  }
  
  public final boolean n(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9150);
    if (!Mg())
    {
      AppMethodBeat.o(9150);
      return false;
    }
    if (this.cPd != null) {
      this.cPd.n(paramMotionEvent);
    }
    float[] arrayOfFloat = s(paramMotionEvent.getX(), paramMotionEvent.getY());
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      boolean bool = this.cPX;
      AppMethodBeat.o(9150);
      return bool;
      if (this.cOW.contains((int)arrayOfFloat[0], (int)arrayOfFloat[1]))
      {
        float f = arrayOfFloat[0];
        this.cPy = f;
        this.awo = f;
        f = arrayOfFloat[1];
        this.cPz = f;
        this.awp = f;
      }
      for (this.cPX = true;; this.cPX = false)
      {
        this.cPY = false;
        break;
      }
      if ((this.cPX) && (this.cPY))
      {
        if (Mb() == null)
        {
          AppMethodBeat.o(9150);
          return false;
        }
        Mb().add(new com.tencent.mm.z.b(new Path(this.vU), this.cOU.getInitScale() / this.cOU.getCurScale(), this.mColor));
        ck(false);
        c.Vr().b(g.cGz);
      }
      Mj();
      this.vU.reset();
      this.cPY = false;
      this.cPX = false;
      continue;
      if ((this.cPX) && (this.cPY))
      {
        this.cPy = this.awo;
        this.cPz = this.awp;
        this.awo = arrayOfFloat[0];
        this.awp = arrayOfFloat[1];
        this.vU.quadTo(this.cPy, this.cPz, (this.awo + this.cPy) / 2.0F, (this.awp + this.cPz) / 2.0F);
        Mi();
      }
      else if ((this.cPX) && (!this.cPY))
      {
        this.vU.moveTo(arrayOfFloat[0], arrayOfFloat[1]);
        this.cPY = true;
      }
    }
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(9149);
    super.onAlive();
    this.cPW = this.cOU.getInitScale();
    AppMethodBeat.o(9149);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9151);
    paramCanvas.save();
    paramCanvas.clipRect(this.cOW);
    d(paramCanvas);
    if (!this.vU.isEmpty()) {
      new com.tencent.mm.z.b(this.vU, this.cOU.getInitScale() / this.cOU.getCurScale(), this.mColor).draw(paramCanvas);
    }
    paramCanvas.restore();
    AppMethodBeat.o(9151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.e.d
 * JD-Core Version:    0.7.0.1
 */