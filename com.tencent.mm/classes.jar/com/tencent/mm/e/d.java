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
  private float daO;
  private float daP;
  private float dbm;
  private boolean dbn;
  private boolean dbo;
  public int mColor;
  private Path xN;
  
  public d()
  {
    AppMethodBeat.i(9148);
    this.dbn = true;
    this.dbo = false;
    this.mColor = com.tencent.mm.view.footer.a.Ltx[2];
    this.xN = new Path();
    AppMethodBeat.o(9148);
  }
  
  public final a NI()
  {
    return a.dad;
  }
  
  public final void NJ()
  {
    AppMethodBeat.i(9152);
    cl(true);
    AppMethodBeat.o(9152);
  }
  
  public final boolean n(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9150);
    if (!NP())
    {
      AppMethodBeat.o(9150);
      return false;
    }
    if (this.dat != null) {
      this.dat.n(paramMotionEvent);
    }
    float[] arrayOfFloat = u(paramMotionEvent.getX(), paramMotionEvent.getY());
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      boolean bool = this.dbn;
      AppMethodBeat.o(9150);
      return bool;
      if (this.dam.contains((int)arrayOfFloat[0], (int)arrayOfFloat[1]))
      {
        float f = arrayOfFloat[0];
        this.daO = f;
        this.ayf = f;
        f = arrayOfFloat[1];
        this.daP = f;
        this.ayg = f;
      }
      for (this.dbn = true;; this.dbn = false)
      {
        this.dbo = false;
        break;
      }
      if ((this.dbn) && (this.dbo))
      {
        if (NK() == null)
        {
          AppMethodBeat.o(9150);
          return false;
        }
        NK().add(new com.tencent.mm.aa.b(new Path(this.xN), this.dak.getInitScale() / this.dak.getCurScale(), this.mColor));
        cl(false);
        c.XI().b(g.cRD);
      }
      NS();
      this.xN.reset();
      this.dbo = false;
      this.dbn = false;
      continue;
      if ((this.dbn) && (this.dbo))
      {
        this.daO = this.ayf;
        this.daP = this.ayg;
        this.ayf = arrayOfFloat[0];
        this.ayg = arrayOfFloat[1];
        this.xN.quadTo(this.daO, this.daP, (this.ayf + this.daO) / 2.0F, (this.ayg + this.daP) / 2.0F);
        NR();
      }
      else if ((this.dbn) && (!this.dbo))
      {
        this.xN.moveTo(arrayOfFloat[0], arrayOfFloat[1]);
        this.dbo = true;
      }
    }
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(9149);
    super.onAlive();
    this.dbm = this.dak.getInitScale();
    AppMethodBeat.o(9149);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9151);
    paramCanvas.save();
    paramCanvas.clipRect(this.dam);
    d(paramCanvas);
    if (!this.xN.isEmpty()) {
      new com.tencent.mm.aa.b(this.xN, this.dak.getInitScale() / this.dak.getCurScale(), this.mColor).draw(paramCanvas);
    }
    paramCanvas.restore();
    AppMethodBeat.o(9151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.e.d
 * JD-Core Version:    0.7.0.1
 */