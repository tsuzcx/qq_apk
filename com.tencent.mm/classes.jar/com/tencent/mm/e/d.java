package com.tencent.mm.e;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.MotionEvent;

public final class d
  extends b
{
  private float alB;
  private float alC;
  private float bAA;
  private float bAB;
  private float bAW;
  private boolean bAX = true;
  private boolean bAz = false;
  public int mColor = com.tencent.mm.view.footer.a.wxV[2];
  private Path nw = new Path();
  
  public final boolean m(MotionEvent paramMotionEvent)
  {
    if (!tO()) {
      return false;
    }
    float[] arrayOfFloat = A(paramMotionEvent.getX(), paramMotionEvent.getY());
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      return this.bAX;
      if (this.bzX.contains((int)arrayOfFloat[0], (int)arrayOfFloat[1]))
      {
        float f = arrayOfFloat[0];
        this.bAA = f;
        this.alB = f;
        f = arrayOfFloat[1];
        this.bAB = f;
        this.alC = f;
      }
      for (this.bAX = true;; this.bAX = false)
      {
        this.bAz = false;
        break;
      }
      if ((this.bAX) && (this.bAz))
      {
        tI().add(new com.tencent.mm.z.b(new Path(this.nw), this.bAW / this.bzV.getInitScale() / this.bzV.getCurScale(), this.mColor));
        aS(false);
      }
      tR();
      this.nw.reset();
      this.bAz = false;
      this.bAX = false;
      continue;
      if ((this.bAX) && (this.bAz))
      {
        this.bAA = this.alB;
        this.bAB = this.alC;
        this.alB = arrayOfFloat[0];
        this.alC = arrayOfFloat[1];
        this.nw.quadTo(this.bAA, this.bAB, (this.alB + this.bAA) / 2.0F, (this.alC + this.bAB) / 2.0F);
        tQ();
      }
      else if ((this.bAX) && (!this.bAz))
      {
        this.nw.moveTo(arrayOfFloat[0], arrayOfFloat[1]);
        this.bAz = true;
      }
    }
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.clipRect(this.bzX);
    b(paramCanvas);
    if (!this.nw.isEmpty()) {
      new com.tencent.mm.z.b(this.nw, this.bAW / this.bzV.getInitScale() / this.bzV.getCurScale(), this.mColor).draw(paramCanvas);
    }
    paramCanvas.restore();
  }
  
  public final a tG()
  {
    return a.bzP;
  }
  
  public final void tH()
  {
    aS(true);
  }
  
  public final void tJ()
  {
    super.tJ();
    this.bAW = this.bzV.getInitScale();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.e.d
 * JD-Core Version:    0.7.0.1
 */