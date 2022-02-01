package com.b.a.a;

import android.location.Location;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i
{
  static i chY;
  float anchorX;
  float anchorY;
  double chZ;
  double cia;
  float cib;
  float cic;
  float cid;
  float cie;
  boolean cif = false;
  
  final void a(double paramDouble1, double paramDouble2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(88023);
    float[] arrayOfFloat = new float[1];
    if (paramDouble2 > 179.0D)
    {
      d = -1.E-005D;
      Location.distanceBetween(paramDouble1, paramDouble2, paramDouble1, paramDouble2 + d, arrayOfFloat);
      this.cie = arrayOfFloat[0];
      if (paramDouble1 <= 89.0D) {
        break label129;
      }
    }
    label129:
    for (double d = -1.E-005D;; d = 1.E-005D)
    {
      Location.distanceBetween(d + paramDouble1, paramDouble2, paramDouble1, paramDouble2, arrayOfFloat);
      this.cid = arrayOfFloat[0];
      this.chZ = paramDouble1;
      this.cia = paramDouble2;
      this.anchorX = paramFloat2;
      this.anchorY = paramFloat3;
      this.cic = paramFloat1;
      this.cib = paramFloat4;
      this.cif = true;
      AppMethodBeat.o(88023);
      return;
      d = 1.E-005D;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.b.a.a.i
 * JD-Core Version:    0.7.0.1
 */