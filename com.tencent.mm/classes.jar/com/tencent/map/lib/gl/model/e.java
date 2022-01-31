package com.tencent.map.lib.gl.model;

import android.opengl.Matrix;

public class e
{
  public float a;
  public float b;
  public float c;
  public float d = 1.0F;
  
  public e() {}
  
  public e(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
  }
  
  public e a(float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat = new float[4];
    Matrix.multiplyMV(arrayOfFloat, 0, paramArrayOfFloat, 0, new float[] { this.a, this.b, this.c, this.d }, 0);
    return new e(arrayOfFloat[0] / arrayOfFloat[3], arrayOfFloat[1] / arrayOfFloat[3], arrayOfFloat[2] / arrayOfFloat[3]);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof e))) {}
    do
    {
      return false;
      paramObject = (e)paramObject;
    } while ((this.a != paramObject.a) || (this.b != paramObject.b) || (this.c != paramObject.c));
    return true;
  }
  
  public String toString()
  {
    return this.a + "," + this.b + "," + this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.map.lib.gl.model.e
 * JD-Core Version:    0.7.0.1
 */