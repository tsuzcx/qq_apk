package com.tencent.mm.plugin.appbrand.widget.c;

import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.BackgroundShapeConfig;
import com.tencent.mm.plugin.appbrand.widget.d.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "provide"})
final class a$c
  implements d.a
{
  a$c(HalfScreenConfig paramHalfScreenConfig) {}
  
  public final float[] cmV()
  {
    float f8 = 0.0F;
    HalfScreenConfig.BackgroundShapeConfig localBackgroundShapeConfig = this.rsT.nZB;
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
    if (localBackgroundShapeConfig.nZO)
    {
      f1 = localBackgroundShapeConfig.bDI;
      if (!localBackgroundShapeConfig.nZO) {
        break label178;
      }
      f2 = localBackgroundShapeConfig.bDI;
      if (!localBackgroundShapeConfig.nZP) {
        break label183;
      }
      f3 = localBackgroundShapeConfig.bDI;
      if (!localBackgroundShapeConfig.nZP) {
        break label188;
      }
      f4 = localBackgroundShapeConfig.bDI;
      if (!localBackgroundShapeConfig.nZR) {
        break label194;
      }
      f5 = localBackgroundShapeConfig.bDI;
      if (!localBackgroundShapeConfig.nZR) {
        break label200;
      }
      f6 = localBackgroundShapeConfig.bDI;
      label99:
      if (!localBackgroundShapeConfig.nZQ) {
        break label206;
      }
    }
    label178:
    label183:
    label188:
    label194:
    label200:
    label206:
    for (float f7 = localBackgroundShapeConfig.bDI;; f7 = 0.0F)
    {
      if (localBackgroundShapeConfig.nZQ) {
        f8 = localBackgroundShapeConfig.bDI;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.c.a.c
 * JD-Core Version:    0.7.0.1
 */