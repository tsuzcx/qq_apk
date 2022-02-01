package com.google.android.material.a;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends Property<ImageView, Matrix>
{
  private final Matrix aHZ;
  
  public f()
  {
    super(Matrix.class, "imageMatrixProperty");
    AppMethodBeat.i(234214);
    this.aHZ = new Matrix();
    AppMethodBeat.o(234214);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.material.a.f
 * JD-Core Version:    0.7.0.1
 */