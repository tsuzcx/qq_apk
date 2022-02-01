package com.google.android.material.a;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  implements TypeEvaluator<Matrix>
{
  private final float[] dnA;
  private final Matrix dnB;
  private final float[] dnz;
  
  public g()
  {
    AppMethodBeat.i(209245);
    this.dnz = new float[9];
    this.dnA = new float[9];
    this.dnB = new Matrix();
    AppMethodBeat.o(209245);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.material.a.g
 * JD-Core Version:    0.7.0.1
 */