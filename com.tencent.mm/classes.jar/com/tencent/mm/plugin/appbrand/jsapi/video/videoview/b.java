package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public boolean pDp;
  protected int pEj;
  protected int pEk;
  protected int pEl;
  protected int pEm;
  d.h pvg = d.h.pvl;
  protected int videoHeight;
  protected int videoWidth;
  
  public final boolean A(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(230471);
    if ((this.pEj == paramInt1) && (this.pEk == paramInt2) && (this.videoWidth == paramInt3) && (this.videoHeight == paramInt4))
    {
      AppMethodBeat.o(230471);
      return true;
    }
    this.pEj = paramInt1;
    this.pEk = paramInt2;
    this.videoWidth = paramInt3;
    this.videoHeight = paramInt4;
    float f1 = this.videoWidth * 1.0F / this.videoHeight;
    float f2 = this.pEj * 1.0F / this.pEk;
    if (this.pvg != d.h.pvl) {
      if (this.pvg == d.h.pvn) {
        if (this.pEj < this.pEk)
        {
          this.pEm = ((int)(this.pEj / f1));
          this.pEl = this.pEj;
          if (this.pEm <= this.pEk) {}
        }
      }
    }
    label657:
    for (;;)
    {
      b localb = this;
      localb.pEl = ((int)(localb.pEk * f1));
      localb.pEm = localb.pEk;
      for (;;)
      {
        Log.d("MicroMsg.ViewSizeCache", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", new Object[] { Integer.valueOf(this.pEj), Integer.valueOf(this.pEk), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.pEl), Integer.valueOf(this.pEm), Float.valueOf(f2), Float.valueOf(f1) });
        AppMethodBeat.o(230471);
        return false;
        this.pEl = ((int)(this.pEk * f1));
        this.pEm = this.pEk;
        if (this.pEl > this.pEj)
        {
          this.pEm = ((int)(this.pEj / f1));
          this.pEl = this.pEj;
          continue;
          if (this.pvg == d.h.pvm)
          {
            this.pEm = this.pEk;
            this.pEl = this.pEj;
          }
          else
          {
            if (this.pvg == d.h.pvo)
            {
              if (this.pEj > this.pEk)
              {
                this.pEm = ((int)(this.pEj / f1));
                this.pEl = this.pEj;
                if (this.pEm >= this.pEk) {
                  continue;
                }
                break;
              }
              this.pEl = ((int)(this.pEk * f1));
              this.pEm = this.pEk;
              if (this.pEl >= this.pEj) {
                continue;
              }
              this.pEm = ((int)(this.pEj / f1));
              this.pEl = this.pEj;
              continue;
            }
            if (!this.pDp)
            {
              if (this.pEj < this.pEk)
              {
                this.pEm = ((int)(this.pEj / f1));
                this.pEl = this.pEj;
              }
              else
              {
                this.pEl = ((int)(this.pEk * f1));
                this.pEm = this.pEk;
              }
            }
            else if (Math.abs(f1 - f2) > 0.05D)
            {
              if (this.pEj < this.pEk)
              {
                this.pEm = ((int)(this.pEj / f1));
                this.pEl = this.pEj;
              }
              else
              {
                this.pEl = ((int)(this.pEk * f1));
                this.pEm = this.pEk;
              }
            }
            else
            {
              if (this.pEj <= this.pEk) {
                break label657;
              }
              this.pEm = ((int)(this.pEj / f1));
              this.pEl = this.pEj;
            }
          }
        }
      }
    }
  }
  
  public final void reset()
  {
    this.pEk = 0;
    this.pEj = 0;
    this.videoHeight = 0;
    this.videoWidth = 0;
    this.pEm = 0;
    this.pEl = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.b
 * JD-Core Version:    0.7.0.1
 */