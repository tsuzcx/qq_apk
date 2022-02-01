package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.h;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
{
  e.h lqa = e.h.lqm;
  protected int lxZ;
  public boolean lxh;
  protected int lya;
  protected int lyb;
  protected int lyc;
  protected int videoHeight;
  protected int videoWidth;
  
  public final void reset()
  {
    this.lya = 0;
    this.lxZ = 0;
    this.videoHeight = 0;
    this.videoWidth = 0;
    this.lyc = 0;
    this.lyb = 0;
  }
  
  public final boolean y(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(211510);
    if ((this.lxZ == paramInt1) && (this.lya == paramInt2) && (this.videoWidth == paramInt3) && (this.videoHeight == paramInt4))
    {
      AppMethodBeat.o(211510);
      return true;
    }
    this.lxZ = paramInt1;
    this.lya = paramInt2;
    this.videoWidth = paramInt3;
    this.videoHeight = paramInt4;
    float f1 = this.videoWidth * 1.0F / this.videoHeight;
    float f2 = this.lxZ * 1.0F / this.lya;
    if (this.lqa != e.h.lqm) {
      if (this.lqa == e.h.lqo) {
        if (this.lxZ < this.lya)
        {
          this.lyc = ((int)(this.lxZ / f1));
          this.lyb = this.lxZ;
          if (this.lyc <= this.lya) {}
        }
      }
    }
    label657:
    for (;;)
    {
      b localb = this;
      localb.lyb = ((int)(localb.lya * f1));
      localb.lyc = localb.lya;
      for (;;)
      {
        ae.d("MicroMsg.ViewSizeCache", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", new Object[] { Integer.valueOf(this.lxZ), Integer.valueOf(this.lya), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.lyb), Integer.valueOf(this.lyc), Float.valueOf(f2), Float.valueOf(f1) });
        AppMethodBeat.o(211510);
        return false;
        this.lyb = ((int)(this.lya * f1));
        this.lyc = this.lya;
        if (this.lyb > this.lxZ)
        {
          this.lyc = ((int)(this.lxZ / f1));
          this.lyb = this.lxZ;
          continue;
          if (this.lqa == e.h.lqn)
          {
            this.lyc = this.lya;
            this.lyb = this.lxZ;
          }
          else
          {
            if (this.lqa == e.h.lqp)
            {
              if (this.lxZ > this.lya)
              {
                this.lyc = ((int)(this.lxZ / f1));
                this.lyb = this.lxZ;
                if (this.lyc >= this.lya) {
                  continue;
                }
                break;
              }
              this.lyb = ((int)(this.lya * f1));
              this.lyc = this.lya;
              if (this.lyb >= this.lxZ) {
                continue;
              }
              this.lyc = ((int)(this.lxZ / f1));
              this.lyb = this.lxZ;
              continue;
            }
            if (!this.lxh)
            {
              if (this.lxZ < this.lya)
              {
                this.lyc = ((int)(this.lxZ / f1));
                this.lyb = this.lxZ;
              }
              else
              {
                this.lyb = ((int)(this.lya * f1));
                this.lyc = this.lya;
              }
            }
            else if (Math.abs(f1 - f2) > 0.05D)
            {
              if (this.lxZ < this.lya)
              {
                this.lyc = ((int)(this.lxZ / f1));
                this.lyb = this.lxZ;
              }
              else
              {
                this.lyb = ((int)(this.lya * f1));
                this.lyc = this.lya;
              }
            }
            else
            {
              if (this.lxZ <= this.lya) {
                break label657;
              }
              this.lyc = ((int)(this.lxZ / f1));
              this.lyb = this.lxZ;
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