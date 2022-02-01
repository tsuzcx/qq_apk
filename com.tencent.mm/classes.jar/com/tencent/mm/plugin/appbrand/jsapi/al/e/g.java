package com.tencent.mm.plugin.appbrand.jsapi.al.e;

import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
  implements f
{
  private int pvg;
  private int sJv;
  private int sJw;
  private int sJx;
  private String sQP;
  public float sQQ;
  public float sQR;
  private int videoHeight;
  private int videoWidth;
  
  private void at(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(327164);
    if (Math.abs(paramFloat1 - paramFloat2) > 0.05D)
    {
      if (this.sJv < this.pvg)
      {
        this.sJx = ((int)(this.sJv / paramFloat1));
        this.sJw = this.sJv;
        AppMethodBeat.o(327164);
        return;
      }
      this.sJw = ((int)(this.pvg * paramFloat1));
      this.sJx = this.pvg;
      AppMethodBeat.o(327164);
      return;
    }
    if (this.sJv > this.pvg)
    {
      this.sJx = ((int)(this.sJv / paramFloat1));
      this.sJw = this.sJv;
      AppMethodBeat.o(327164);
      return;
    }
    this.sJw = ((int)(this.pvg * paramFloat1));
    this.sJx = this.pvg;
    AppMethodBeat.o(327164);
  }
  
  private void bO(float paramFloat)
  {
    if (this.sJv < this.pvg)
    {
      this.sJx = ((int)(this.sJv / paramFloat));
      this.sJw = this.sJv;
      if (this.sJx > this.pvg)
      {
        this.sJw = ((int)(this.pvg * paramFloat));
        this.sJx = this.pvg;
      }
    }
    do
    {
      return;
      this.sJw = ((int)(this.pvg * paramFloat));
      this.sJx = this.pvg;
    } while (this.sJw <= this.sJv);
    this.sJx = ((int)(this.sJv / paramFloat));
    this.sJw = this.sJv;
  }
  
  private void bP(float paramFloat)
  {
    if (this.sJv > this.pvg)
    {
      this.sJx = ((int)(this.sJv / paramFloat));
      this.sJw = this.sJv;
      if (this.sJx < this.pvg)
      {
        this.sJw = ((int)(this.pvg * paramFloat));
        this.sJx = this.pvg;
      }
    }
    do
    {
      return;
      this.sJw = ((int)(this.pvg * paramFloat));
      this.sJx = this.pvg;
    } while (this.sJw >= this.sJv);
    this.sJx = ((int)(this.sJv / paramFloat));
    this.sJw = this.sJv;
  }
  
  private void cyT()
  {
    this.sJx = this.pvg;
    this.sJw = this.sJv;
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
    if ((paramString.equalsIgnoreCase(this.sQP)) && (this.sJv == paramInt1) && (this.pvg == paramInt2) && (this.videoWidth == paramInt3) && (this.videoHeight == paramInt4))
    {
      Log.w("MicroMsg.SameLayer.AppBrandVideoScaleHandler", "calculateScale, same as last calculated");
      AppMethodBeat.o(139600);
      return true;
    }
    this.sQP = paramString;
    this.sJv = paramInt1;
    this.pvg = paramInt2;
    this.videoWidth = paramInt3;
    this.videoHeight = paramInt4;
    float f1 = this.videoWidth * 1.0F / this.videoHeight;
    float f2 = this.sJv * 1.0F / this.pvg;
    if (this.sQP.equalsIgnoreCase("contain")) {
      bO(f1);
    }
    for (;;)
    {
      this.sQQ = (this.sJw * 1.0F / this.sJv);
      this.sQR = (this.sJx * 1.0F / this.pvg);
      Log.d("MicroMsg.SameLayer.AppBrandVideoScaleHandler", "calculateScale, screen[%d, %d], video[%d, %d], measure[%d, %d], scale[%f, %f]", new Object[] { Integer.valueOf(this.sJv), Integer.valueOf(this.pvg), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.sJw), Integer.valueOf(this.sJx), Float.valueOf(this.sQQ), Float.valueOf(this.sQR) });
      AppMethodBeat.o(139600);
      return true;
      if (this.sQP.equalsIgnoreCase("fill")) {
        cyT();
      } else if (this.sQP.equalsIgnoreCase("cover")) {
        bP(f1);
      } else {
        at(f1, f2);
      }
    }
  }
  
  public final float auR()
  {
    return this.sQQ;
  }
  
  public final float auS()
  {
    return this.sQR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.e.g
 * JD-Core Version:    0.7.0.1
 */