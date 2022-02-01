package com.tencent.mm.plugin.appbrand.jsapi.ad.e;

import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class g
  implements f
{
  private float lDA;
  private String lDy;
  private float lDz;
  private int lxZ;
  private int lya;
  private int lyb;
  private int lyc;
  private int videoHeight;
  private int videoWidth;
  
  public final float GO()
  {
    return this.lDz;
  }
  
  public final float GP()
  {
    return this.lDA;
  }
  
  public final boolean a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(139600);
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.SameLayer.AppBrandVideoScaleHandler", "calculateScale, scale type is null");
      AppMethodBeat.o(139600);
      return false;
    }
    if ((paramInt1 == 0) || (paramInt2 == 0) || (paramInt3 == 0) || (paramInt4 == 0))
    {
      ae.w("MicroMsg.SameLayer.AppBrandVideoScaleHandler", "calculateScale, width or height is 0");
      AppMethodBeat.o(139600);
      return false;
    }
    if ((paramString.equalsIgnoreCase(this.lDy)) && (this.lxZ == paramInt1) && (this.lya == paramInt2) && (this.videoWidth == paramInt3) && (this.videoHeight == paramInt4))
    {
      ae.w("MicroMsg.SameLayer.AppBrandVideoScaleHandler", "calculateScale, same as last calculated");
      AppMethodBeat.o(139600);
      return true;
    }
    this.lDy = paramString;
    this.lxZ = paramInt1;
    this.lya = paramInt2;
    this.videoWidth = paramInt3;
    this.videoHeight = paramInt4;
    float f1 = this.videoWidth * 1.0F / this.videoHeight;
    float f2 = this.lxZ * 1.0F / this.lya;
    if (this.lDy.equalsIgnoreCase("contain")) {
      if (this.lxZ < this.lya)
      {
        this.lyc = ((int)(this.lxZ / f1));
        this.lyb = this.lxZ;
        if (this.lyc <= this.lya) {}
      }
    }
    label698:
    for (;;)
    {
      paramString = this;
      paramString.lyb = ((int)(f1 * paramString.lya));
      paramString.lyc = paramString.lya;
      for (;;)
      {
        this.lDz = (this.lyb * 1.0F / this.lxZ);
        this.lDA = (this.lyc * 1.0F / this.lya);
        ae.d("MicroMsg.SameLayer.AppBrandVideoScaleHandler", "calculateScale, screen[%d, %d], video[%d, %d], measure[%d, %d], scale[%f, %f]", new Object[] { Integer.valueOf(this.lxZ), Integer.valueOf(this.lya), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.lyb), Integer.valueOf(this.lyc), Float.valueOf(this.lDz), Float.valueOf(this.lDA) });
        AppMethodBeat.o(139600);
        return true;
        this.lyb = ((int)(this.lya * f1));
        this.lyc = this.lya;
        if (this.lyb > this.lxZ)
        {
          this.lyc = ((int)(this.lxZ / f1));
          this.lyb = this.lxZ;
          continue;
          if (this.lDy.equalsIgnoreCase("fill"))
          {
            this.lyc = this.lya;
            this.lyb = this.lxZ;
          }
          else
          {
            if (this.lDy.equalsIgnoreCase("cover"))
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
            if (Math.abs(f1 - f2) > 0.05D)
            {
              if (this.lxZ < this.lya)
              {
                this.lyc = ((int)(this.lxZ / f1));
                this.lyb = this.lxZ;
              }
              else
              {
                this.lyb = ((int)(f1 * this.lya));
                this.lyc = this.lya;
              }
            }
            else
            {
              if (this.lxZ <= this.lya) {
                break label698;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.e.g
 * JD-Core Version:    0.7.0.1
 */