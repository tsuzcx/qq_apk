package com.tencent.mm.plugin.appbrand.jsapi.ai.e;

import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
  implements f
{
  private int pEj;
  private int pEk;
  private int pEl;
  private int pEm;
  private String pLZ;
  private float pMa;
  private float pMb;
  private int videoHeight;
  private int videoWidth;
  
  public final float Uo()
  {
    return this.pMa;
  }
  
  public final float Up()
  {
    return this.pMb;
  }
  
  public final boolean a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(139600);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.SameLayer.AppBrandVideoScaleHandler", "calculateScale, scale type is null");
      AppMethodBeat.o(139600);
      return false;
    }
    if ((paramInt1 == 0) || (paramInt2 == 0) || (paramInt3 == 0) || (paramInt4 == 0))
    {
      Log.w("MicroMsg.SameLayer.AppBrandVideoScaleHandler", "calculateScale, width or height is 0");
      AppMethodBeat.o(139600);
      return false;
    }
    if ((paramString.equalsIgnoreCase(this.pLZ)) && (this.pEj == paramInt1) && (this.pEk == paramInt2) && (this.videoWidth == paramInt3) && (this.videoHeight == paramInt4))
    {
      Log.w("MicroMsg.SameLayer.AppBrandVideoScaleHandler", "calculateScale, same as last calculated");
      AppMethodBeat.o(139600);
      return true;
    }
    this.pLZ = paramString;
    this.pEj = paramInt1;
    this.pEk = paramInt2;
    this.videoWidth = paramInt3;
    this.videoHeight = paramInt4;
    float f1 = this.videoWidth * 1.0F / this.videoHeight;
    float f2 = this.pEj * 1.0F / this.pEk;
    if (this.pLZ.equalsIgnoreCase("contain")) {
      if (this.pEj < this.pEk)
      {
        this.pEm = ((int)(this.pEj / f1));
        this.pEl = this.pEj;
        if (this.pEm <= this.pEk) {}
      }
    }
    label698:
    for (;;)
    {
      paramString = this;
      paramString.pEl = ((int)(f1 * paramString.pEk));
      paramString.pEm = paramString.pEk;
      for (;;)
      {
        this.pMa = (this.pEl * 1.0F / this.pEj);
        this.pMb = (this.pEm * 1.0F / this.pEk);
        Log.d("MicroMsg.SameLayer.AppBrandVideoScaleHandler", "calculateScale, screen[%d, %d], video[%d, %d], measure[%d, %d], scale[%f, %f]", new Object[] { Integer.valueOf(this.pEj), Integer.valueOf(this.pEk), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.pEl), Integer.valueOf(this.pEm), Float.valueOf(this.pMa), Float.valueOf(this.pMb) });
        AppMethodBeat.o(139600);
        return true;
        this.pEl = ((int)(this.pEk * f1));
        this.pEm = this.pEk;
        if (this.pEl > this.pEj)
        {
          this.pEm = ((int)(this.pEj / f1));
          this.pEl = this.pEj;
          continue;
          if (this.pLZ.equalsIgnoreCase("fill"))
          {
            this.pEm = this.pEk;
            this.pEl = this.pEj;
          }
          else
          {
            if (this.pLZ.equalsIgnoreCase("cover"))
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
            if (Math.abs(f1 - f2) > 0.05D)
            {
              if (this.pEj < this.pEk)
              {
                this.pEm = ((int)(this.pEj / f1));
                this.pEl = this.pEj;
              }
              else
              {
                this.pEl = ((int)(f1 * this.pEk));
                this.pEm = this.pEk;
              }
            }
            else
            {
              if (this.pEj <= this.pEk) {
                break label698;
              }
              this.pEm = ((int)(this.pEj / f1));
              this.pEl = this.pEj;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.e.g
 * JD-Core Version:    0.7.0.1
 */