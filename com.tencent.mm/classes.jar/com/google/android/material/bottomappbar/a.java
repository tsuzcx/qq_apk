package com.google.android.material.bottomappbar;

import com.google.android.material.h.b;
import com.google.android.material.h.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends b
{
  float bwA;
  float bwB;
  float bwC;
  float bwD;
  float bwz;
  
  public a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(235068);
    this.bwA = paramFloat1;
    this.bwz = paramFloat2;
    this.bwC = paramFloat3;
    if (paramFloat3 < 0.0F)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("cradleVerticalOffset must be positive.");
      AppMethodBeat.o(235068);
      throw localIllegalArgumentException;
    }
    this.bwD = 0.0F;
    AppMethodBeat.o(235068);
  }
  
  public final void a(float paramFloat1, float paramFloat2, d paramd)
  {
    AppMethodBeat.i(235069);
    if (this.bwB == 0.0F)
    {
      paramd.aa(paramFloat1);
      AppMethodBeat.o(235069);
      return;
    }
    float f1 = (this.bwA * 2.0F + this.bwB) / 2.0F;
    float f2 = paramFloat2 * this.bwz;
    float f3 = paramFloat1 / 2.0F + this.bwD;
    paramFloat2 = this.bwC * paramFloat2 + (1.0F - paramFloat2) * f1;
    if (paramFloat2 / f1 >= 1.0F)
    {
      paramd.aa(paramFloat1);
      AppMethodBeat.o(235069);
      return;
    }
    float f4 = f1 + f2;
    float f6 = paramFloat2 + f2;
    float f7 = (float)Math.sqrt(f4 * f4 - f6 * f6);
    f4 = f3 - f7;
    float f5 = f3 + f7;
    f6 = (float)Math.toDegrees(Math.atan(f7 / f6));
    f7 = 90.0F - f6;
    paramd.aa(f4 - f2);
    paramd.b(f4 - f2, 0.0F, f4 + f2, f2 * 2.0F, 270.0F, f6);
    paramd.b(f3 - f1, -f1 - paramFloat2, f3 + f1, f1 - paramFloat2, 180.0F - f7, 2.0F * f7 - 180.0F);
    paramd.b(f5 - f2, 0.0F, f5 + f2, f2 * 2.0F, 270.0F - f6, f6);
    paramd.aa(paramFloat1);
    AppMethodBeat.o(235069);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.bottomappbar.a
 * JD-Core Version:    0.7.0.1
 */