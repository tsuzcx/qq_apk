package com.tencent.mm.plugin.appbrand.jsapi.aa.e;

import com.tencent.luggage.k.a.a.b.b.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class g
  implements f
{
  private String kAI;
  private float kAJ;
  private float kAK;
  private int kvn;
  private int kvo;
  private int kvp;
  private int kvq;
  private int videoHeight;
  private int videoWidth;
  
  public final float FG()
  {
    return this.kAJ;
  }
  
  public final float FH()
  {
    return this.kAK;
  }
  
  public final boolean a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(139600);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.SameLayer.AppBrandVideoScaleHandler", "calculateScale, scale type is null");
      AppMethodBeat.o(139600);
      return false;
    }
    if ((paramInt1 == 0) || (paramInt2 == 0) || (paramInt3 == 0) || (paramInt4 == 0))
    {
      ad.w("MicroMsg.SameLayer.AppBrandVideoScaleHandler", "calculateScale, width or height is 0");
      AppMethodBeat.o(139600);
      return false;
    }
    if ((paramString.equalsIgnoreCase(this.kAI)) && (this.kvn == paramInt1) && (this.kvo == paramInt2) && (this.videoWidth == paramInt3) && (this.videoHeight == paramInt4))
    {
      ad.w("MicroMsg.SameLayer.AppBrandVideoScaleHandler", "calculateScale, same as last calculated");
      AppMethodBeat.o(139600);
      return true;
    }
    this.kAI = paramString;
    this.kvn = paramInt1;
    this.kvo = paramInt2;
    this.videoWidth = paramInt3;
    this.videoHeight = paramInt4;
    float f1 = this.videoWidth * 1.0F / this.videoHeight;
    float f2 = this.kvn * 1.0F / this.kvo;
    if (this.kAI.equalsIgnoreCase("contain")) {
      if (this.kvn < this.kvo)
      {
        this.kvq = ((int)(this.kvn / f1));
        this.kvp = this.kvn;
        if (this.kvq <= this.kvo) {}
      }
    }
    label698:
    for (;;)
    {
      paramString = this;
      paramString.kvp = ((int)(f1 * paramString.kvo));
      paramString.kvq = paramString.kvo;
      for (;;)
      {
        this.kAJ = (this.kvp * 1.0F / this.kvn);
        this.kAK = (this.kvq * 1.0F / this.kvo);
        ad.d("MicroMsg.SameLayer.AppBrandVideoScaleHandler", "calculateScale, screen[%d, %d], video[%d, %d], measure[%d, %d], scale[%f, %f]", new Object[] { Integer.valueOf(this.kvn), Integer.valueOf(this.kvo), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.kvp), Integer.valueOf(this.kvq), Float.valueOf(this.kAJ), Float.valueOf(this.kAK) });
        AppMethodBeat.o(139600);
        return true;
        this.kvp = ((int)(this.kvo * f1));
        this.kvq = this.kvo;
        if (this.kvp > this.kvn)
        {
          this.kvq = ((int)(this.kvn / f1));
          this.kvp = this.kvn;
          continue;
          if (this.kAI.equalsIgnoreCase("fill"))
          {
            this.kvq = this.kvo;
            this.kvp = this.kvn;
          }
          else
          {
            if (this.kAI.equalsIgnoreCase("cover"))
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
            if (Math.abs(f1 - f2) > 0.05D)
            {
              if (this.kvn < this.kvo)
              {
                this.kvq = ((int)(this.kvn / f1));
                this.kvp = this.kvn;
              }
              else
              {
                this.kvp = ((int)(f1 * this.kvo));
                this.kvq = this.kvo;
              }
            }
            else
            {
              if (this.kvn <= this.kvo) {
                break label698;
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.e.g
 * JD-Core Version:    0.7.0.1
 */