package com.d.a.a;

import android.location.Location;

final class i
{
  static i aWq;
  double aWr;
  double aWs;
  float aWt;
  float aWu;
  float aWv;
  float aWw;
  float aWx;
  float aWy;
  boolean aWz = false;
  
  final void a(double paramDouble1, double paramDouble2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float[] arrayOfFloat = new float[1];
    if (paramDouble2 > 179.0D)
    {
      d = -1.E-005D;
      Location.distanceBetween(paramDouble1, paramDouble2, paramDouble1, paramDouble2 + d, arrayOfFloat);
      this.aWy = arrayOfFloat[0];
      if (paramDouble1 <= 89.0D) {
        break label119;
      }
    }
    label119:
    for (double d = -1.E-005D;; d = 1.E-005D)
    {
      Location.distanceBetween(d + paramDouble1, paramDouble2, paramDouble1, paramDouble2, arrayOfFloat);
      this.aWx = arrayOfFloat[0];
      this.aWr = paramDouble1;
      this.aWs = paramDouble2;
      this.aWt = paramFloat2;
      this.aWu = paramFloat3;
      this.aWw = paramFloat1;
      this.aWv = paramFloat4;
      this.aWz = true;
      return;
      d = 1.E-005D;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.d.a.a.i
 * JD-Core Version:    0.7.0.1
 */