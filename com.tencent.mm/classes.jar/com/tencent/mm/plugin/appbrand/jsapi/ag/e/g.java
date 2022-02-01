package com.tencent.mm.plugin.appbrand.jsapi.ag.e;

import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
  implements f
{
  private int mEX;
  private int mEY;
  private int mEZ;
  private int mFa;
  private String mLh;
  private float mLi;
  private float mLj;
  private int videoHeight;
  private int videoWidth;
  
  public final float QH()
  {
    return this.mLi;
  }
  
  public final float QI()
  {
    return this.mLj;
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
    if ((paramString.equalsIgnoreCase(this.mLh)) && (this.mEX == paramInt1) && (this.mEY == paramInt2) && (this.videoWidth == paramInt3) && (this.videoHeight == paramInt4))
    {
      Log.w("MicroMsg.SameLayer.AppBrandVideoScaleHandler", "calculateScale, same as last calculated");
      AppMethodBeat.o(139600);
      return true;
    }
    this.mLh = paramString;
    this.mEX = paramInt1;
    this.mEY = paramInt2;
    this.videoWidth = paramInt3;
    this.videoHeight = paramInt4;
    float f1 = this.videoWidth * 1.0F / this.videoHeight;
    float f2 = this.mEX * 1.0F / this.mEY;
    if (this.mLh.equalsIgnoreCase("contain")) {
      if (this.mEX < this.mEY)
      {
        this.mFa = ((int)(this.mEX / f1));
        this.mEZ = this.mEX;
        if (this.mFa <= this.mEY) {}
      }
    }
    label698:
    for (;;)
    {
      paramString = this;
      paramString.mEZ = ((int)(f1 * paramString.mEY));
      paramString.mFa = paramString.mEY;
      for (;;)
      {
        this.mLi = (this.mEZ * 1.0F / this.mEX);
        this.mLj = (this.mFa * 1.0F / this.mEY);
        Log.d("MicroMsg.SameLayer.AppBrandVideoScaleHandler", "calculateScale, screen[%d, %d], video[%d, %d], measure[%d, %d], scale[%f, %f]", new Object[] { Integer.valueOf(this.mEX), Integer.valueOf(this.mEY), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.mEZ), Integer.valueOf(this.mFa), Float.valueOf(this.mLi), Float.valueOf(this.mLj) });
        AppMethodBeat.o(139600);
        return true;
        this.mEZ = ((int)(this.mEY * f1));
        this.mFa = this.mEY;
        if (this.mEZ > this.mEX)
        {
          this.mFa = ((int)(this.mEX / f1));
          this.mEZ = this.mEX;
          continue;
          if (this.mLh.equalsIgnoreCase("fill"))
          {
            this.mFa = this.mEY;
            this.mEZ = this.mEX;
          }
          else
          {
            if (this.mLh.equalsIgnoreCase("cover"))
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
            if (Math.abs(f1 - f2) > 0.05D)
            {
              if (this.mEX < this.mEY)
              {
                this.mFa = ((int)(this.mEX / f1));
                this.mEZ = this.mEX;
              }
              else
              {
                this.mEZ = ((int)(f1 * this.mEY));
                this.mFa = this.mEY;
              }
            }
            else
            {
              if (this.mEX <= this.mEY) {
                break label698;
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.e.g
 * JD-Core Version:    0.7.0.1
 */