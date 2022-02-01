package com.google.android.material.a;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  implements TypeEvaluator<Matrix>
{
  private final float[] buv;
  private final float[] buw;
  private final Matrix bux;
  
  public g()
  {
    AppMethodBeat.i(234225);
    this.buv = new float[9];
    this.buw = new float[9];
    this.bux = new Matrix();
    AppMethodBeat.o(234225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.material.a.g
 * JD-Core Version:    0.7.0.1
 */