package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.h;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
{
  e.h llB = e.h.llM;
  public boolean lsI;
  protected int ltA;
  protected int ltB;
  protected int ltC;
  protected int ltD;
  protected int videoHeight;
  protected int videoWidth;
  
  public final void reset()
  {
    this.ltB = 0;
    this.ltA = 0;
    this.videoHeight = 0;
    this.videoWidth = 0;
    this.ltD = 0;
    this.ltC = 0;
  }
  
  public final boolean y(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(206480);
    if ((this.ltA == paramInt1) && (this.ltB == paramInt2) && (this.videoWidth == paramInt3) && (this.videoHeight == paramInt4))
    {
      AppMethodBeat.o(206480);
      return true;
    }
    this.ltA = paramInt1;
    this.ltB = paramInt2;
    this.videoWidth = paramInt3;
    this.videoHeight = paramInt4;
    float f1 = this.videoWidth * 1.0F / this.videoHeight;
    float f2 = this.ltA * 1.0F / this.ltB;
    if (this.llB != e.h.llM) {
      if (this.llB == e.h.llO) {
        if (this.ltA < this.ltB)
        {
          this.ltD = ((int)(this.ltA / f1));
          this.ltC = this.ltA;
          if (this.ltD <= this.ltB) {}
        }
      }
    }
    label657:
    for (;;)
    {
      b localb = this;
      localb.ltC = ((int)(localb.ltB * f1));
      localb.ltD = localb.ltB;
      for (;;)
      {
        ad.d("MicroMsg.ViewSizeCache", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", new Object[] { Integer.valueOf(this.ltA), Integer.valueOf(this.ltB), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.ltC), Integer.valueOf(this.ltD), Float.valueOf(f2), Float.valueOf(f1) });
        AppMethodBeat.o(206480);
        return false;
        this.ltC = ((int)(this.ltB * f1));
        this.ltD = this.ltB;
        if (this.ltC > this.ltA)
        {
          this.ltD = ((int)(this.ltA / f1));
          this.ltC = this.ltA;
          continue;
          if (this.llB == e.h.llN)
          {
            this.ltD = this.ltB;
            this.ltC = this.ltA;
          }
          else
          {
            if (this.llB == e.h.llP)
            {
              if (this.ltA > this.ltB)
              {
                this.ltD = ((int)(this.ltA / f1));
                this.ltC = this.ltA;
                if (this.ltD >= this.ltB) {
                  continue;
                }
                break;
              }
              this.ltC = ((int)(this.ltB * f1));
              this.ltD = this.ltB;
              if (this.ltC >= this.ltA) {
                continue;
              }
              this.ltD = ((int)(this.ltA / f1));
              this.ltC = this.ltA;
              continue;
            }
            if (!this.lsI)
            {
              if (this.ltA < this.ltB)
              {
                this.ltD = ((int)(this.ltA / f1));
                this.ltC = this.ltA;
              }
              else
              {
                this.ltC = ((int)(this.ltB * f1));
                this.ltD = this.ltB;
              }
            }
            else if (Math.abs(f1 - f2) > 0.05D)
            {
              if (this.ltA < this.ltB)
              {
                this.ltD = ((int)(this.ltA / f1));
                this.ltC = this.ltA;
              }
              else
              {
                this.ltC = ((int)(this.ltB * f1));
                this.ltD = this.ltB;
              }
            }
            else
            {
              if (this.ltA <= this.ltB) {
                break label657;
              }
              this.ltD = ((int)(this.ltA / f1));
              this.ltC = this.ltA;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.b
 * JD-Core Version:    0.7.0.1
 */