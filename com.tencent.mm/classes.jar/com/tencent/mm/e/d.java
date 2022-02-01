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
  private float avt;
  private float avu;
  private float cSA;
  private boolean cSB;
  private boolean cSd;
  private float cSe;
  private float cSf;
  public int mColor;
  private Path uW;
  
  public d()
  {
    AppMethodBeat.i(9148);
    this.cSB = true;
    this.cSd = false;
    this.mColor = com.tencent.mm.view.footer.a.HZA[2];
    this.uW = new Path();
    AppMethodBeat.o(9148);
  }
  
  public final a Mb()
  {
    return a.cRs;
  }
  
  public final void Mc()
  {
    AppMethodBeat.i(9152);
    ci(true);
    AppMethodBeat.o(9152);
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(9149);
    super.onAlive();
    this.cSA = this.cRz.getInitScale();
    AppMethodBeat.o(9149);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9151);
    paramCanvas.save();
    paramCanvas.clipRect(this.cRB);
    d(paramCanvas);
    if (!this.uW.isEmpty()) {
      new com.tencent.mm.aa.b(this.uW, this.cRz.getInitScale() / this.cRz.getCurScale(), this.mColor).draw(paramCanvas);
    }
    paramCanvas.restore();
    AppMethodBeat.o(9151);
  }
  
  public final boolean p(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9150);
    if (!Mi())
    {
      AppMethodBeat.o(9150);
      return false;
    }
    if (this.cRI != null) {
      this.cRI.p(paramMotionEvent);
    }
    float[] arrayOfFloat = s(paramMotionEvent.getX(), paramMotionEvent.getY());
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      boolean bool = this.cSB;
      AppMethodBeat.o(9150);
      return bool;
      if (this.cRB.contains((int)arrayOfFloat[0], (int)arrayOfFloat[1]))
      {
        float f = arrayOfFloat[0];
        this.cSe = f;
        this.avt = f;
        f = arrayOfFloat[1];
        this.cSf = f;
        this.avu = f;
      }
      for (this.cSB = true;; this.cSB = false)
      {
        this.cSd = false;
        break;
      }
      if ((this.cSB) && (this.cSd))
      {
        if (Md() == null)
        {
          AppMethodBeat.o(9150);
          return false;
        }
        Md().add(new com.tencent.mm.aa.b(new Path(this.uW), this.cRz.getInitScale() / this.cRz.getCurScale(), this.mColor));
        ci(false);
        c.Uw().b(g.cJs);
      }
      Ml();
      this.uW.reset();
      this.cSd = false;
      this.cSB = false;
      continue;
      if ((this.cSB) && (this.cSd))
      {
        this.cSe = this.avt;
        this.cSf = this.avu;
        this.avt = arrayOfFloat[0];
        this.avu = arrayOfFloat[1];
        this.uW.quadTo(this.cSe, this.cSf, (this.avt + this.cSe) / 2.0F, (this.avu + this.cSf) / 2.0F);
        Mk();
      }
      else if ((this.cSB) && (!this.cSd))
      {
        this.uW.moveTo(arrayOfFloat[0], arrayOfFloat[1]);
        this.cSd = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.e.d
 * JD-Core Version:    0.7.0.1
 */