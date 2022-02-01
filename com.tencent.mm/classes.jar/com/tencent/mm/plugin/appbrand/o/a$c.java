package com.tencent.mm.plugin.appbrand.o;

import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.BackgroundShapeConfig;
import com.tencent.mm.plugin.appbrand.widget.c.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "provide"})
final class a$c
  implements c.a
{
  a$c(HalfScreenConfig paramHalfScreenConfig) {}
  
  public final float[] bOp()
  {
    float f8 = 0.0F;
    HalfScreenConfig.BackgroundShapeConfig localBackgroundShapeConfig = this.mZI.lfp;
    float f1;
    float f2;
    label40:
    float f3;
    label54:
    float f4;
    label69:
    float f5;
    label84:
    float f6;
    if (localBackgroundShapeConfig.lfw)
    {
      f1 = localBackgroundShapeConfig.tt;
      if (!localBackgroundShapeConfig.lfw) {
        break label178;
      }
      f2 = localBackgroundShapeConfig.tt;
      if (!localBackgroundShapeConfig.lfx) {
        break label183;
      }
      f3 = localBackgroundShapeConfig.tt;
      if (!localBackgroundShapeConfig.lfx) {
        break label188;
      }
      f4 = localBackgroundShapeConfig.tt;
      if (!localBackgroundShapeConfig.lfz) {
        break label194;
      }
      f5 = localBackgroundShapeConfig.tt;
      if (!localBackgroundShapeConfig.lfz) {
        break label200;
      }
      f6 = localBackgroundShapeConfig.tt;
      label99:
      if (!localBackgroundShapeConfig.lfy) {
        break label206;
      }
    }
    label178:
    label183:
    label188:
    label194:
    label200:
    label206:
    for (float f7 = localBackgroundShapeConfig.tt;; f7 = 0.0F)
    {
      if (localBackgroundShapeConfig.lfy) {
        f8 = localBackgroundShapeConfig.tt;
      }
      return new float[] { f1, f2, f3, f4, f5, f6, f7, f8 };
      f1 = 0.0F;
      break;
      f2 = 0.0F;
      break label40;
      f3 = 0.0F;
      break label54;
      f4 = 0.0F;
      break label69;
      f5 = 0.0F;
      break label84;
      f6 = 0.0F;
      break label99;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.a.c
 * JD-Core Version:    0.7.0.1
 */