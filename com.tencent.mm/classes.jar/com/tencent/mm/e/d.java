package com.tencent.mm.e;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.i;
import com.tencent.mm.cache.c;
import com.tencent.mm.cache.f;

public final class d
  extends b
{
  private Path cja;
  private float hpU;
  private boolean hpV;
  private boolean hpW;
  private float hpx;
  private float hpy;
  public int mColor;
  private float wT;
  private float wU;
  
  public d()
  {
    AppMethodBeat.i(9148);
    this.hpV = true;
    this.hpW = false;
    this.mColor = com.tencent.mm.view.footer.a.agLQ[2];
    this.cja = new Path();
    AppMethodBeat.o(9148);
  }
  
  public final a aEy()
  {
    return a.hoK;
  }
  
  public final void aEz()
  {
    AppMethodBeat.i(9152);
    ec(true);
    AppMethodBeat.o(9152);
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(9149);
    super.onAlive();
    this.hpU = this.hoR.getInitScale();
    AppMethodBeat.o(9149);
  }
  
  public final boolean onDispatchTouch(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9150);
    if (!aEF())
    {
      AppMethodBeat.o(9150);
      return false;
    }
    if (this.hpb != null) {
      this.hpb.onDispatchTouch(paramMotionEvent);
    }
    float[] arrayOfFloat = ad(paramMotionEvent.getX(), paramMotionEvent.getY());
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      boolean bool = this.hpV;
      AppMethodBeat.o(9150);
      return bool;
      if (getAliveRect().contains((int)arrayOfFloat[0], (int)arrayOfFloat[1]))
      {
        float f = arrayOfFloat[0];
        this.hpx = f;
        this.wT = f;
        f = arrayOfFloat[1];
        this.hpy = f;
        this.wU = f;
      }
      for (this.hpV = true;; this.hpV = false)
      {
        this.hpW = false;
        break;
      }
      if ((this.hpV) && (this.hpW))
      {
        if (aEA() == null)
        {
          AppMethodBeat.o(9150);
          return false;
        }
        aEA().add(new com.tencent.mm.ab.b(new Path(this.cja), this.hoR.getInitScale() / this.hoR.getCurScale(), this.mColor));
        ec(false);
        c.aLA().b(i.hdO);
      }
      aEI();
      this.cja.reset();
      this.hpW = false;
      this.hpV = false;
      continue;
      if ((this.hpV) && (this.hpW))
      {
        this.hpx = this.wT;
        this.hpy = this.wU;
        this.wT = arrayOfFloat[0];
        this.wU = arrayOfFloat[1];
        this.cja.quadTo(this.hpx, this.hpy, (this.wT + this.hpx) / 2.0F, (this.wU + this.hpy) / 2.0F);
        aEH();
      }
      else if ((this.hpV) && (!this.hpW))
      {
        this.cja.moveTo(arrayOfFloat[0], arrayOfFloat[1]);
        this.hpW = true;
      }
    }
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9151);
    paramCanvas.save();
    paramCanvas.clipRect(getAliveRect());
    h(paramCanvas);
    if (!this.cja.isEmpty()) {
      new com.tencent.mm.ab.b(this.cja, this.hoR.getInitScale() / this.hoR.getCurScale(), this.mColor).draw(paramCanvas);
    }
    paramCanvas.restore();
    AppMethodBeat.o(9151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.e.d
 * JD-Core Version:    0.7.0.1
 */