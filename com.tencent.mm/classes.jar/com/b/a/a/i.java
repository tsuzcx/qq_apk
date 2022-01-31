package com.b.a.a;

import android.location.Location;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i
{
  static i bmX;
  double bmY;
  double bmZ;
  float bna;
  float bnb;
  float bnc;
  float bnd;
  float bne;
  float bnf;
  boolean bng = false;
  
  final void a(double paramDouble1, double paramDouble2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(55678);
    float[] arrayOfFloat = new float[1];
    if (paramDouble2 > 179.0D)
    {
      d = -1.E-005D;
      Location.distanceBetween(paramDouble1, paramDouble2, paramDouble1, paramDouble2 + d, arrayOfFloat);
      this.bnf = arrayOfFloat[0];
      if (paramDouble1 <= 89.0D) {
        break label129;
      }
    }
    label129:
    for (double d = -1.E-005D;; d = 1.E-005D)
    {
      Location.distanceBetween(d + paramDouble1, paramDouble2, paramDouble1, paramDouble2, arrayOfFloat);
      this.bne = arrayOfFloat[0];
      this.bmY = paramDouble1;
      this.bmZ = paramDouble2;
      this.bna = paramFloat2;
      this.bnb = paramFloat3;
      this.bnd = paramFloat1;
      this.bnc = paramFloat4;
      this.bng = true;
      AppMethodBeat.o(55678);
      return;
      d = 1.E-005D;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.b.a.a.i
 * JD-Core Version:    0.7.0.1
 */