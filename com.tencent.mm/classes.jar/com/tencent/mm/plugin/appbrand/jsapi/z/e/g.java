package com.tencent.mm.plugin.appbrand.jsapi.z.e;

import com.tencent.luggage.k.a.a.b.b.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class g
  implements f
{
  private int kWB;
  private int kWC;
  private int kWD;
  private int kWE;
  private String lca;
  private float lcb;
  private float lcc;
  private int videoHeight;
  private int videoWidth;
  
  public final float Fo()
  {
    return this.lcb;
  }
  
  public final float Fp()
  {
    return this.lcc;
  }
  
  public final boolean a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(139600);
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.SameLayer.AppBrandVideoScaleHandler", "calculateScale, scale type is null");
      AppMethodBeat.o(139600);
      return false;
    }
    if ((paramInt1 == 0) || (paramInt2 == 0) || (paramInt3 == 0) || (paramInt4 == 0))
    {
      ac.w("MicroMsg.SameLayer.AppBrandVideoScaleHandler", "calculateScale, width or height is 0");
      AppMethodBeat.o(139600);
      return false;
    }
    if ((paramString.equalsIgnoreCase(this.lca)) && (this.kWB == paramInt1) && (this.kWC == paramInt2) && (this.videoWidth == paramInt3) && (this.videoHeight == paramInt4))
    {
      ac.w("MicroMsg.SameLayer.AppBrandVideoScaleHandler", "calculateScale, same as last calculated");
      AppMethodBeat.o(139600);
      return true;
    }
    this.lca = paramString;
    this.kWB = paramInt1;
    this.kWC = paramInt2;
    this.videoWidth = paramInt3;
    this.videoHeight = paramInt4;
    float f1 = this.videoWidth * 1.0F / this.videoHeight;
    float f2 = this.kWB * 1.0F / this.kWC;
    if (this.lca.equalsIgnoreCase("contain")) {
      if (this.kWB < this.kWC)
      {
        this.kWE = ((int)(this.kWB / f1));
        this.kWD = this.kWB;
        if (this.kWE <= this.kWC) {}
      }
    }
    label698:
    for (;;)
    {
      paramString = this;
      paramString.kWD = ((int)(f1 * paramString.kWC));
      paramString.kWE = paramString.kWC;
      for (;;)
      {
        this.lcb = (this.kWD * 1.0F / this.kWB);
        this.lcc = (this.kWE * 1.0F / this.kWC);
        ac.d("MicroMsg.SameLayer.AppBrandVideoScaleHandler", "calculateScale, screen[%d, %d], video[%d, %d], measure[%d, %d], scale[%f, %f]", new Object[] { Integer.valueOf(this.kWB), Integer.valueOf(this.kWC), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.kWD), Integer.valueOf(this.kWE), Float.valueOf(this.lcb), Float.valueOf(this.lcc) });
        AppMethodBeat.o(139600);
        return true;
        this.kWD = ((int)(this.kWC * f1));
        this.kWE = this.kWC;
        if (this.kWD > this.kWB)
        {
          this.kWE = ((int)(this.kWB / f1));
          this.kWD = this.kWB;
          continue;
          if (this.lca.equalsIgnoreCase("fill"))
          {
            this.kWE = this.kWC;
            this.kWD = this.kWB;
          }
          else
          {
            if (this.lca.equalsIgnoreCase("cover"))
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
            if (Math.abs(f1 - f2) > 0.05D)
            {
              if (this.kWB < this.kWC)
              {
                this.kWE = ((int)(this.kWB / f1));
                this.kWD = this.kWB;
              }
              else
              {
                this.kWD = ((int)(f1 * this.kWC));
                this.kWE = this.kWC;
              }
            }
            else
            {
              if (this.kWB <= this.kWC) {
                break label698;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.e.g
 * JD-Core Version:    0.7.0.1
 */