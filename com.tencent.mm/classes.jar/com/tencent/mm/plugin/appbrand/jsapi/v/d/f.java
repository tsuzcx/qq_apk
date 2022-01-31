package com.tencent.mm.plugin.appbrand.jsapi.v.d;

import com.tencent.luggage.xweb_ext.extendplugin.component.video.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class f
  implements e
{
  private int iiW;
  private int iiX;
  private int iiY;
  private int iiZ;
  private String ija;
  private float ijb;
  private float ijc;
  private int videoHeight;
  private int videoWidth;
  
  public final boolean a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(140078);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.AppBrand.SameLayer.AppBrandVideoScaleHandler", "calculateScale, scale type is null");
      AppMethodBeat.o(140078);
      return false;
    }
    if ((paramInt1 == 0) || (paramInt2 == 0) || (paramInt3 == 0) || (paramInt4 == 0))
    {
      ab.w("MicroMsg.AppBrand.SameLayer.AppBrandVideoScaleHandler", "calculateScale, width or height is 0");
      AppMethodBeat.o(140078);
      return false;
    }
    if ((paramString.equalsIgnoreCase(this.ija)) && (this.iiW == paramInt1) && (this.iiX == paramInt2) && (this.videoWidth == paramInt3) && (this.videoHeight == paramInt4))
    {
      ab.w("MicroMsg.AppBrand.SameLayer.AppBrandVideoScaleHandler", "calculateScale, same as last calculated");
      AppMethodBeat.o(140078);
      return true;
    }
    this.ija = paramString;
    this.iiW = paramInt1;
    this.iiX = paramInt2;
    this.videoWidth = paramInt3;
    this.videoHeight = paramInt4;
    float f1 = this.videoWidth * 1.0F / this.videoHeight;
    float f2 = this.iiW * 1.0F / this.iiX;
    if (this.ija.equalsIgnoreCase("contain")) {
      if (this.iiW < this.iiX)
      {
        this.iiZ = ((int)(this.iiW / f1));
        this.iiY = this.iiW;
        if (this.iiZ <= this.iiX) {}
      }
    }
    label698:
    for (;;)
    {
      paramString = this;
      paramString.iiY = ((int)(f1 * paramString.iiX));
      paramString.iiZ = paramString.iiX;
      for (;;)
      {
        this.ijb = (this.iiY * 1.0F / this.iiW);
        this.ijc = (this.iiZ * 1.0F / this.iiX);
        ab.d("MicroMsg.AppBrand.SameLayer.AppBrandVideoScaleHandler", "calculateScale, screen[%d, %d], video[%d, %d], measure[%d, %d], scale[%f, %f]", new Object[] { Integer.valueOf(this.iiW), Integer.valueOf(this.iiX), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.iiY), Integer.valueOf(this.iiZ), Float.valueOf(this.ijb), Float.valueOf(this.ijc) });
        AppMethodBeat.o(140078);
        return true;
        this.iiY = ((int)(this.iiX * f1));
        this.iiZ = this.iiX;
        if (this.iiY > this.iiW)
        {
          this.iiZ = ((int)(this.iiW / f1));
          this.iiY = this.iiW;
          continue;
          if (this.ija.equalsIgnoreCase("fill"))
          {
            this.iiZ = this.iiX;
            this.iiY = this.iiW;
          }
          else
          {
            if (this.ija.equalsIgnoreCase("cover"))
            {
              if (this.iiW > this.iiX)
              {
                this.iiZ = ((int)(this.iiW / f1));
                this.iiY = this.iiW;
                if (this.iiZ >= this.iiX) {
                  continue;
                }
                break;
              }
              this.iiY = ((int)(this.iiX * f1));
              this.iiZ = this.iiX;
              if (this.iiY >= this.iiW) {
                continue;
              }
              this.iiZ = ((int)(this.iiW / f1));
              this.iiY = this.iiW;
              continue;
            }
            if (Math.abs(f1 - f2) > 0.05D)
            {
              if (this.iiW < this.iiX)
              {
                this.iiZ = ((int)(this.iiW / f1));
                this.iiY = this.iiW;
              }
              else
              {
                this.iiY = ((int)(f1 * this.iiX));
                this.iiZ = this.iiX;
              }
            }
            else
            {
              if (this.iiW <= this.iiX) {
                break label698;
              }
              this.iiZ = ((int)(this.iiW / f1));
              this.iiY = this.iiW;
            }
          }
        }
      }
    }
  }
  
  public final float xU()
  {
    return this.ijb;
  }
  
  public final float xV()
  {
    return this.ijc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.d.f
 * JD-Core Version:    0.7.0.1
 */