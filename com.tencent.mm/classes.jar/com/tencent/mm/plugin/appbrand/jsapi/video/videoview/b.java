package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  protected int pvg;
  d.h sAm = d.h.sAr;
  public boolean sIB;
  protected int sJv;
  protected int sJw;
  protected int sJx;
  protected int videoHeight;
  protected int videoWidth;
  
  public final boolean G(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(328913);
    if ((this.sJv == paramInt1) && (this.pvg == paramInt2) && (this.videoWidth == paramInt3) && (this.videoHeight == paramInt4))
    {
      AppMethodBeat.o(328913);
      return true;
    }
    this.sJv = paramInt1;
    this.pvg = paramInt2;
    this.videoWidth = paramInt3;
    this.videoHeight = paramInt4;
    float f1 = this.videoWidth * 1.0F / this.videoHeight;
    float f2 = this.sJv * 1.0F / this.pvg;
    if (this.sAm != d.h.sAr) {
      if (this.sAm == d.h.sAt) {
        if (this.sJv < this.pvg)
        {
          this.sJx = ((int)(this.sJv / f1));
          this.sJw = this.sJv;
          if (this.sJx <= this.pvg) {}
        }
      }
    }
    label657:
    for (;;)
    {
      b localb = this;
      localb.sJw = ((int)(localb.pvg * f1));
      localb.sJx = localb.pvg;
      for (;;)
      {
        Log.d("MicroMsg.ViewSizeCache", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", new Object[] { Integer.valueOf(this.sJv), Integer.valueOf(this.pvg), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.sJw), Integer.valueOf(this.sJx), Float.valueOf(f2), Float.valueOf(f1) });
        AppMethodBeat.o(328913);
        return false;
        this.sJw = ((int)(this.pvg * f1));
        this.sJx = this.pvg;
        if (this.sJw > this.sJv)
        {
          this.sJx = ((int)(this.sJv / f1));
          this.sJw = this.sJv;
          continue;
          if (this.sAm == d.h.sAs)
          {
            this.sJx = this.pvg;
            this.sJw = this.sJv;
          }
          else
          {
            if (this.sAm == d.h.sAu)
            {
              if (this.sJv > this.pvg)
              {
                this.sJx = ((int)(this.sJv / f1));
                this.sJw = this.sJv;
                if (this.sJx >= this.pvg) {
                  continue;
                }
                break;
              }
              this.sJw = ((int)(this.pvg * f1));
              this.sJx = this.pvg;
              if (this.sJw >= this.sJv) {
                continue;
              }
              this.sJx = ((int)(this.sJv / f1));
              this.sJw = this.sJv;
              continue;
            }
            if (!this.sIB)
            {
              if (this.sJv < this.pvg)
              {
                this.sJx = ((int)(this.sJv / f1));
                this.sJw = this.sJv;
              }
              else
              {
                this.sJw = ((int)(this.pvg * f1));
                this.sJx = this.pvg;
              }
            }
            else if (Math.abs(f1 - f2) > 0.05D)
            {
              if (this.sJv < this.pvg)
              {
                this.sJx = ((int)(this.sJv / f1));
                this.sJw = this.sJv;
              }
              else
              {
                this.sJw = ((int)(this.pvg * f1));
                this.sJx = this.pvg;
              }
            }
            else
            {
              if (this.sJv <= this.pvg) {
                break label657;
              }
              this.sJx = ((int)(this.sJv / f1));
              this.sJw = this.sJv;
            }
          }
        }
      }
    }
  }
  
  public final void reset()
  {
    this.pvg = 0;
    this.sJv = 0;
    this.videoHeight = 0;
    this.videoWidth = 0;
    this.sJx = 0;
    this.sJw = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.b
 * JD-Core Version:    0.7.0.1
 */