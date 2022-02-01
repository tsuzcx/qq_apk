package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.h;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
{
  e.h kOY = e.h.kPj;
  public boolean kVJ;
  protected int kWB;
  protected int kWC;
  protected int kWD;
  protected int kWE;
  protected int videoHeight;
  protected int videoWidth;
  
  public final void reset()
  {
    this.kWC = 0;
    this.kWB = 0;
    this.videoHeight = 0;
    this.videoWidth = 0;
    this.kWE = 0;
    this.kWD = 0;
  }
  
  public final boolean x(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(194666);
    if ((this.kWB == paramInt1) && (this.kWC == paramInt2) && (this.videoWidth == paramInt3) && (this.videoHeight == paramInt4))
    {
      AppMethodBeat.o(194666);
      return true;
    }
    this.kWB = paramInt1;
    this.kWC = paramInt2;
    this.videoWidth = paramInt3;
    this.videoHeight = paramInt4;
    float f1 = this.videoWidth * 1.0F / this.videoHeight;
    float f2 = this.kWB * 1.0F / this.kWC;
    if (this.kOY != e.h.kPj) {
      if (this.kOY == e.h.kPl) {
        if (this.kWB < this.kWC)
        {
          this.kWE = ((int)(this.kWB / f1));
          this.kWD = this.kWB;
          if (this.kWE <= this.kWC) {}
        }
      }
    }
    label657:
    for (;;)
    {
      b localb = this;
      localb.kWD = ((int)(localb.kWC * f1));
      localb.kWE = localb.kWC;
      for (;;)
      {
        ac.d("MicroMsg.ViewSizeCache", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", new Object[] { Integer.valueOf(this.kWB), Integer.valueOf(this.kWC), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.kWD), Integer.valueOf(this.kWE), Float.valueOf(f2), Float.valueOf(f1) });
        AppMethodBeat.o(194666);
        return false;
        this.kWD = ((int)(this.kWC * f1));
        this.kWE = this.kWC;
        if (this.kWD > this.kWB)
        {
          this.kWE = ((int)(this.kWB / f1));
          this.kWD = this.kWB;
          continue;
          if (this.kOY == e.h.kPk)
          {
            this.kWE = this.kWC;
            this.kWD = this.kWB;
          }
          else
          {
            if (this.kOY == e.h.kPm)
            {
              if (this.kWB > this.kWC)
              {
                this.kWE = ((int)(this.kWB / f1));
                this.kWD = this.kWB;
                if (this.kWE >= this.kWC) {
                  continue;
                }
                break;
              }
              this.kWD = ((int)(this.kWC * f1));
              this.kWE = this.kWC;
              if (this.kWD >= this.kWB) {
                continue;
              }
              this.kWE = ((int)(this.kWB / f1));
              this.kWD = this.kWB;
              continue;
            }
            if (!this.kVJ)
            {
              if (this.kWB < this.kWC)
              {
                this.kWE = ((int)(this.kWB / f1));
                this.kWD = this.kWB;
              }
              else
              {
                this.kWD = ((int)(this.kWC * f1));
                this.kWE = this.kWC;
              }
            }
            else if (Math.abs(f1 - f2) > 0.05D)
            {
              if (this.kWB < this.kWC)
              {
                this.kWE = ((int)(this.kWB / f1));
                this.kWD = this.kWB;
              }
              else
              {
                this.kWD = ((int)(this.kWC * f1));
                this.kWE = this.kWC;
              }
            }
            else
            {
              if (this.kWB <= this.kWC) {
                break label657;
              }
              this.kWE = ((int)(this.kWB / f1));
              this.kWD = this.kWB;
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