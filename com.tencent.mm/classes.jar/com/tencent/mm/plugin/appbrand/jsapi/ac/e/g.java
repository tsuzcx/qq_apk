package com.tencent.mm.plugin.appbrand.jsapi.ac.e;

import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class g
  implements f
{
  private int ltA;
  private int ltB;
  private int ltC;
  private int ltD;
  private String lza;
  private float lzb;
  private float lzc;
  private int videoHeight;
  private int videoWidth;
  
  public final float GI()
  {
    return this.lzb;
  }
  
  public final float GJ()
  {
    return this.lzc;
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
    if ((paramString.equalsIgnoreCase(this.lza)) && (this.ltA == paramInt1) && (this.ltB == paramInt2) && (this.videoWidth == paramInt3) && (this.videoHeight == paramInt4))
    {
      ad.w("MicroMsg.SameLayer.AppBrandVideoScaleHandler", "calculateScale, same as last calculated");
      AppMethodBeat.o(139600);
      return true;
    }
    this.lza = paramString;
    this.ltA = paramInt1;
    this.ltB = paramInt2;
    this.videoWidth = paramInt3;
    this.videoHeight = paramInt4;
    float f1 = this.videoWidth * 1.0F / this.videoHeight;
    float f2 = this.ltA * 1.0F / this.ltB;
    if (this.lza.equalsIgnoreCase("contain")) {
      if (this.ltA < this.ltB)
      {
        this.ltD = ((int)(this.ltA / f1));
        this.ltC = this.ltA;
        if (this.ltD <= this.ltB) {}
      }
    }
    label698:
    for (;;)
    {
      paramString = this;
      paramString.ltC = ((int)(f1 * paramString.ltB));
      paramString.ltD = paramString.ltB;
      for (;;)
      {
        this.lzb = (this.ltC * 1.0F / this.ltA);
        this.lzc = (this.ltD * 1.0F / this.ltB);
        ad.d("MicroMsg.SameLayer.AppBrandVideoScaleHandler", "calculateScale, screen[%d, %d], video[%d, %d], measure[%d, %d], scale[%f, %f]", new Object[] { Integer.valueOf(this.ltA), Integer.valueOf(this.ltB), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.ltC), Integer.valueOf(this.ltD), Float.valueOf(this.lzb), Float.valueOf(this.lzc) });
        AppMethodBeat.o(139600);
        return true;
        this.ltC = ((int)(this.ltB * f1));
        this.ltD = this.ltB;
        if (this.ltC > this.ltA)
        {
          this.ltD = ((int)(this.ltA / f1));
          this.ltC = this.ltA;
          continue;
          if (this.lza.equalsIgnoreCase("fill"))
          {
            this.ltD = this.ltB;
            this.ltC = this.ltA;
          }
          else
          {
            if (this.lza.equalsIgnoreCase("cover"))
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
            if (Math.abs(f1 - f2) > 0.05D)
            {
              if (this.ltA < this.ltB)
              {
                this.ltD = ((int)(this.ltA / f1));
                this.ltC = this.ltA;
              }
              else
              {
                this.ltC = ((int)(f1 * this.ltB));
                this.ltD = this.ltB;
              }
            }
            else
            {
              if (this.ltA <= this.ltB) {
                break label698;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.e.g
 * JD-Core Version:    0.7.0.1
 */