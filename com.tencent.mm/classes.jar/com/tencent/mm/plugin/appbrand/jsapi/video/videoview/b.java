package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  protected int mEX;
  protected int mEY;
  protected int mEZ;
  public boolean mEe;
  protected int mFa;
  e.h mwG = e.h.mwR;
  protected int videoHeight;
  protected int videoWidth;
  
  public final void reset()
  {
    this.mEY = 0;
    this.mEX = 0;
    this.videoHeight = 0;
    this.videoWidth = 0;
    this.mFa = 0;
    this.mEZ = 0;
  }
  
  public final boolean y(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(235189);
    if ((this.mEX == paramInt1) && (this.mEY == paramInt2) && (this.videoWidth == paramInt3) && (this.videoHeight == paramInt4))
    {
      AppMethodBeat.o(235189);
      return true;
    }
    this.mEX = paramInt1;
    this.mEY = paramInt2;
    this.videoWidth = paramInt3;
    this.videoHeight = paramInt4;
    float f1 = this.videoWidth * 1.0F / this.videoHeight;
    float f2 = this.mEX * 1.0F / this.mEY;
    if (this.mwG != e.h.mwR) {
      if (this.mwG == e.h.mwT) {
        if (this.mEX < this.mEY)
        {
          this.mFa = ((int)(this.mEX / f1));
          this.mEZ = this.mEX;
          if (this.mFa <= this.mEY) {}
        }
      }
    }
    label657:
    for (;;)
    {
      b localb = this;
      localb.mEZ = ((int)(localb.mEY * f1));
      localb.mFa = localb.mEY;
      for (;;)
      {
        Log.d("MicroMsg.ViewSizeCache", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", new Object[] { Integer.valueOf(this.mEX), Integer.valueOf(this.mEY), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.mEZ), Integer.valueOf(this.mFa), Float.valueOf(f2), Float.valueOf(f1) });
        AppMethodBeat.o(235189);
        return false;
        this.mEZ = ((int)(this.mEY * f1));
        this.mFa = this.mEY;
        if (this.mEZ > this.mEX)
        {
          this.mFa = ((int)(this.mEX / f1));
          this.mEZ = this.mEX;
          continue;
          if (this.mwG == e.h.mwS)
          {
            this.mFa = this.mEY;
            this.mEZ = this.mEX;
          }
          else
          {
            if (this.mwG == e.h.mwU)
            {
              if (this.mEX > this.mEY)
              {
                this.mFa = ((int)(this.mEX / f1));
                this.mEZ = this.mEX;
                if (this.mFa >= this.mEY) {
                  continue;
                }
                break;
              }
              this.mEZ = ((int)(this.mEY * f1));
              this.mFa = this.mEY;
              if (this.mEZ >= this.mEX) {
                continue;
              }
              this.mFa = ((int)(this.mEX / f1));
              this.mEZ = this.mEX;
              continue;
            }
            if (!this.mEe)
            {
              if (this.mEX < this.mEY)
              {
                this.mFa = ((int)(this.mEX / f1));
                this.mEZ = this.mEX;
              }
              else
              {
                this.mEZ = ((int)(this.mEY * f1));
                this.mFa = this.mEY;
              }
            }
            else if (Math.abs(f1 - f2) > 0.05D)
            {
              if (this.mEX < this.mEY)
              {
                this.mFa = ((int)(this.mEX / f1));
                this.mEZ = this.mEX;
              }
              else
              {
                this.mEZ = ((int)(this.mEY * f1));
                this.mFa = this.mEY;
              }
            }
            else
            {
              if (this.mEX <= this.mEY) {
                break label657;
              }
              this.mFa = ((int)(this.mEX / f1));
              this.mEZ = this.mEX;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.b
 * JD-Core Version:    0.7.0.1
 */