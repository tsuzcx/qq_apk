package com.tencent.mm.e;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cache.c;

public final class d
  extends b
{
  private float anT;
  private float anU;
  private float cdT;
  private boolean cdU;
  private boolean cdw;
  private float cdx;
  private float cdy;
  public int mColor;
  private Path ou;
  
  public d()
  {
    AppMethodBeat.i(116178);
    this.cdU = true;
    this.cdw = false;
    this.mColor = com.tencent.mm.view.footer.a.ATm[2];
    this.ou = new Path();
    AppMethodBeat.o(116178);
  }
  
  public final void CA()
  {
    AppMethodBeat.i(116182);
    bt(true);
    AppMethodBeat.o(116182);
  }
  
  public final a Cz()
  {
    return a.ccM;
  }
  
  public final boolean o(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(116180);
    if (!CG())
    {
      AppMethodBeat.o(116180);
      return false;
    }
    if (this.cdb != null) {
      this.cdb.o(paramMotionEvent);
    }
    float[] arrayOfFloat = B(paramMotionEvent.getX(), paramMotionEvent.getY());
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      boolean bool = this.cdU;
      AppMethodBeat.o(116180);
      return bool;
      if (this.ccU.contains((int)arrayOfFloat[0], (int)arrayOfFloat[1]))
      {
        float f = arrayOfFloat[0];
        this.cdx = f;
        this.anT = f;
        f = arrayOfFloat[1];
        this.cdy = f;
        this.anU = f;
      }
      for (this.cdU = true;; this.cdU = false)
      {
        this.cdw = false;
        break;
      }
      if ((this.cdU) && (this.cdw))
      {
        if (CB() == null)
        {
          AppMethodBeat.o(116180);
          return false;
        }
        CB().add(new com.tencent.mm.y.b(new Path(this.ou), this.cdT / this.ccS.getInitScale() / this.ccS.getCurScale(), this.mColor));
        bt(false);
        c.Jg().b(com.tencent.mm.api.e.bVW);
      }
      CJ();
      this.ou.reset();
      this.cdw = false;
      this.cdU = false;
      continue;
      if ((this.cdU) && (this.cdw))
      {
        this.cdx = this.anT;
        this.cdy = this.anU;
        this.anT = arrayOfFloat[0];
        this.anU = arrayOfFloat[1];
        this.ou.quadTo(this.cdx, this.cdy, (this.anT + this.cdx) / 2.0F, (this.anU + this.cdy) / 2.0F);
        CI();
      }
      else if ((this.cdU) && (!this.cdw))
      {
        this.ou.moveTo(arrayOfFloat[0], arrayOfFloat[1]);
        this.cdw = true;
      }
    }
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(116181);
    paramCanvas.save();
    paramCanvas.clipRect(this.ccU);
    b(paramCanvas);
    if (!this.ou.isEmpty()) {
      new com.tencent.mm.y.b(this.ou, this.cdT / this.ccS.getInitScale() / this.ccS.getCurScale(), this.mColor).draw(paramCanvas);
    }
    paramCanvas.restore();
    AppMethodBeat.o(116181);
  }
  
  public final void zy()
  {
    AppMethodBeat.i(116179);
    super.zy();
    this.cdT = this.ccS.getInitScale();
    AppMethodBeat.o(116179);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.e.d
 * JD-Core Version:    0.7.0.1
 */