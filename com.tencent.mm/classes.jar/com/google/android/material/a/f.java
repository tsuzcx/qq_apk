package com.google.android.material.a;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends Property<ImageView, Matrix>
{
  private final Matrix matrix;
  
  public f()
  {
    super(Matrix.class, "imageMatrixProperty");
    AppMethodBeat.i(209237);
    this.matrix = new Matrix();
    AppMethodBeat.o(209237);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.material.a.f
 * JD-Core Version:    0.7.0.1
 */