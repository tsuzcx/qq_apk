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
  private float ayf;
  private float ayg;
  private float dbQ;
  private float dbR;
  private float dco;
  private boolean dcp;
  private boolean dcq;
  public int mColor;
  private Path xN;
  
  public d()
  {
    AppMethodBeat.i(9148);
    this.dcp = true;
    this.dcq = false;
    this.mColor = com.tencent.mm.view.footer.a.LQk[2];
    this.xN = new Path();
    AppMethodBeat.o(9148);
  }
  
  public final a NG()
  {
    return a.dbf;
  }
  
  public final void NH()
  {
    AppMethodBeat.i(9152);
    cl(true);
    AppMethodBeat.o(9152);
  }
  
  public final boolean n(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9150);
    if (!NN())
    {
      AppMethodBeat.o(9150);
      return false;
    }
    if (this.dbv != null) {
      this.dbv.n(paramMotionEvent);
    }
    float[] arrayOfFloat = u(paramMotionEvent.getX(), paramMotionEvent.getY());
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      boolean bool = this.dcp;
      AppMethodBeat.o(9150);
      return bool;
      if (this.dbo.contains((int)arrayOfFloat[0], (int)arrayOfFloat[1]))
      {
        float f = arrayOfFloat[0];
        this.dbQ = f;
        this.ayf = f;
        f = arrayOfFloat[1];
        this.dbR = f;
        this.ayg = f;
      }
      for (this.dcp = true;; this.dcp = false)
      {
        this.dcq = false;
        break;
      }
      if ((this.dcp) && (this.dcq))
      {
        if (NI() == null)
        {
          AppMethodBeat.o(9150);
          return false;
        }
        NI().add(new com.tencent.mm.z.b(new Path(this.xN), this.dbm.getInitScale() / this.dbm.getCurScale(), this.mColor));
        cl(false);
        c.XS().b(g.cSn);
      }
      NQ();
      this.xN.reset();
      this.dcq = false;
      this.dcp = false;
      continue;
      if ((this.dcp) && (this.dcq))
      {
        this.dbQ = this.ayf;
        this.dbR = this.ayg;
        this.ayf = arrayOfFloat[0];
        this.ayg = arrayOfFloat[1];
        this.xN.quadTo(this.dbQ, this.dbR, (this.ayf + this.dbQ) / 2.0F, (this.ayg + this.dbR) / 2.0F);
        NP();
      }
      else if ((this.dcp) && (!this.dcq))
      {
        this.xN.moveTo(arrayOfFloat[0], arrayOfFloat[1]);
        this.dcq = true;
      }
    }
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(9149);
    super.onAlive();
    this.dco = this.dbm.getInitScale();
    AppMethodBeat.o(9149);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9151);
    paramCanvas.save();
    paramCanvas.clipRect(this.dbo);
    d(paramCanvas);
    if (!this.xN.isEmpty()) {
      new com.tencent.mm.z.b(this.xN, this.dbm.getInitScale() / this.dbm.getCurScale(), this.mColor).draw(paramCanvas);
    }
    paramCanvas.restore();
    AppMethodBeat.o(9151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.e.d
 * JD-Core Version:    0.7.0.1
 */