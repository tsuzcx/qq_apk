package com.google.android.material.bottomappbar;

import com.google.android.material.h.b;
import com.google.android.material.h.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends b
{
  float dpC;
  float dpD;
  float dpE;
  float dpF;
  float dpG;
  
  public a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(209506);
    this.dpD = paramFloat1;
    this.dpC = paramFloat2;
    this.dpF = paramFloat3;
    if (paramFloat3 < 0.0F)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("cradleVerticalOffset must be positive.");
      AppMethodBeat.o(209506);
      throw localIllegalArgumentException;
    }
    this.dpG = 0.0F;
    AppMethodBeat.o(209506);
  }
  
  public final void a(float paramFloat1, float paramFloat2, d paramd)
  {
    AppMethodBeat.i(209522);
    if (this.dpE == 0.0F)
    {
      paramd.bb(paramFloat1);
      AppMethodBeat.o(209522);
      return;
    }
    float f1 = (this.dpD * 2.0F + this.dpE) / 2.0F;
    float f2 = paramFloat2 * this.dpC;
    float f3 = paramFloat1 / 2.0F + this.dpG;
    paramFloat2 = this.dpF * paramFloat2 + (1.0F - paramFloat2) * f1;
    if (paramFloat2 / f1 >= 1.0F)
    {
      paramd.bb(paramFloat1);
      AppMethodBeat.o(209522);
      return;
    }
    float f4 = f1 + f2;
    float f6 = paramFloat2 + f2;
    float f7 = (float)Math.sqrt(f4 * f4 - f6 * f6);
    f4 = f3 - f7;
    float f5 = f3 + f7;
    f6 = (float)Math.toDegrees(Math.atan(f7 / f6));
    f7 = 90.0F - f6;
    paramd.bb(f4 - f2);
    paramd.d(f4 - f2, 0.0F, f4 + f2, f2 * 2.0F, 270.0F, f6);
    paramd.d(f3 - f1, -f1 - paramFloat2, f3 + f1, f1 - paramFloat2, 180.0F - f7, 2.0F * f7 - 180.0F);
    paramd.d(f5 - f2, 0.0F, f5 + f2, f2 * 2.0F, 270.0F - f6, f6);
    paramd.bb(paramFloat1);
    AppMethodBeat.o(209522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.bottomappbar.a
 * JD-Core Version:    0.7.0.1
 */