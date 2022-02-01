package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.h;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
{
  e.h knE = e.h.knP;
  public boolean kuu;
  protected int kvn;
  protected int kvo;
  protected int kvp;
  protected int kvq;
  protected int videoHeight;
  protected int videoWidth;
  
  public final void reset()
  {
    this.kvo = 0;
    this.kvn = 0;
    this.videoHeight = 0;
    this.videoWidth = 0;
    this.kvq = 0;
    this.kvp = 0;
  }
  
  public final boolean x(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(194321);
    if ((this.kvn == paramInt1) && (this.kvo == paramInt2) && (this.videoWidth == paramInt3) && (this.videoHeight == paramInt4))
    {
      AppMethodBeat.o(194321);
      return true;
    }
    this.kvn = paramInt1;
    this.kvo = paramInt2;
    this.videoWidth = paramInt3;
    this.videoHeight = paramInt4;
    float f1 = this.videoWidth * 1.0F / this.videoHeight;
    float f2 = this.kvn * 1.0F / this.kvo;
    if (this.knE != e.h.knP) {
      if (this.knE == e.h.knR) {
        if (this.kvn < this.kvo)
        {
          this.kvq = ((int)(this.kvn / f1));
          this.kvp = this.kvn;
          if (this.kvq <= this.kvo) {}
        }
      }
    }
    label657:
    for (;;)
    {
      b localb = this;
      localb.kvp = ((int)(localb.kvo * f1));
      localb.kvq = localb.kvo;
      for (;;)
      {
        ad.d("MicroMsg.ViewSizeCache", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", new Object[] { Integer.valueOf(this.kvn), Integer.valueOf(this.kvo), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.kvp), Integer.valueOf(this.kvq), Float.valueOf(f2), Float.valueOf(f1) });
        AppMethodBeat.o(194321);
        return false;
        this.kvp = ((int)(this.kvo * f1));
        this.kvq = this.kvo;
        if (this.kvp > this.kvn)
        {
          this.kvq = ((int)(this.kvn / f1));
          this.kvp = this.kvn;
          continue;
          if (this.knE == e.h.knQ)
          {
            this.kvq = this.kvo;
            this.kvp = this.kvn;
          }
          else
          {
            if (this.knE == e.h.knS)
            {
              if (this.kvn > this.kvo)
              {
                this.kvq = ((int)(this.kvn / f1));
                this.kvp = this.kvn;
                if (this.kvq >= this.kvo) {
                  continue;
                }
                break;
              }
              this.kvp = ((int)(this.kvo * f1));
              this.kvq = this.kvo;
              if (this.kvp >= this.kvn) {
                continue;
              }
              this.kvq = ((int)(this.kvn / f1));
              this.kvp = this.kvn;
              continue;
            }
            if (!this.kuu)
            {
              if (this.kvn < this.kvo)
              {
                this.kvq = ((int)(this.kvn / f1));
                this.kvp = this.kvn;
              }
              else
              {
                this.kvp = ((int)(this.kvo * f1));
                this.kvq = this.kvo;
              }
            }
            else if (Math.abs(f1 - f2) > 0.05D)
            {
              if (this.kvn < this.kvo)
              {
                this.kvq = ((int)(this.kvn / f1));
                this.kvp = this.kvn;
              }
              else
              {
                this.kvp = ((int)(this.kvo * f1));
                this.kvq = this.kvo;
              }
            }
            else
            {
              if (this.kvn <= this.kvo) {
                break label657;
              }
              this.kvq = ((int)(this.kvn / f1));
              this.kvp = this.kvn;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.b
 * JD-Core Version:    0.7.0.1
 */