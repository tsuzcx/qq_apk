package com.tencent.mapsdk.internal;

import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fz
{
  public float a;
  public float b;
  public float c;
  public float d = 1.0F;
  
  public fz() {}
  
  public fz(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
  }
  
  private fz a(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(221927);
    float[] arrayOfFloat = new float[4];
    Matrix.multiplyMV(arrayOfFloat, 0, paramArrayOfFloat, 0, new float[] { this.a, this.b, this.c, this.d }, 0);
    paramArrayOfFloat = new fz(arrayOfFloat[0] / arrayOfFloat[3], arrayOfFloat[1] / arrayOfFloat[3], arrayOfFloat[2] / arrayOfFloat[3]);
    AppMethodBeat.o(221927);
    return paramArrayOfFloat;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof fz)) {}
    do
    {
      return false;
      paramObject = (fz)paramObject;
    } while ((this.a != paramObject.a) || (this.b != paramObject.b) || (this.c != paramObject.c));
    return true;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(221934);
    String str = this.a + "," + this.b + "," + this.c;
    AppMethodBeat.o(221934);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.internal.fz
 * JD-Core Version:    0.7.0.1
 */