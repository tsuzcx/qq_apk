package com.d.a.a;

import android.location.Location;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i
{
  static i bXr;
  float anchorX;
  float anchorY;
  double bXs;
  double bXt;
  float bXu;
  float bXv;
  float bXw;
  float bXx;
  boolean bXy = false;
  
  final void a(double paramDouble1, double paramDouble2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(88023);
    float[] arrayOfFloat = new float[1];
    if (paramDouble2 > 179.0D)
    {
      d = -1.E-005D;
      Location.distanceBetween(paramDouble1, paramDouble2, paramDouble1, paramDouble2 + d, arrayOfFloat);
      this.bXx = arrayOfFloat[0];
      if (paramDouble1 <= 89.0D) {
        break label129;
      }
    }
    label129:
    for (double d = -1.E-005D;; d = 1.E-005D)
    {
      Location.distanceBetween(d + paramDouble1, paramDouble2, paramDouble1, paramDouble2, arrayOfFloat);
      this.bXw = arrayOfFloat[0];
      this.bXs = paramDouble1;
      this.bXt = paramDouble2;
      this.anchorX = paramFloat2;
      this.anchorY = paramFloat3;
      this.bXv = paramFloat1;
      this.bXu = paramFloat4;
      this.bXy = true;
      AppMethodBeat.o(88023);
      return;
      d = 1.E-005D;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.a.i
 * JD-Core Version:    0.7.0.1
 */