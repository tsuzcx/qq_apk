package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;

public class e
  extends q
{
  private int A;
  private float[] B;
  private int x;
  private int y;
  private int z;
  
  public void b(float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat = new float[3];
    arrayOfFloat[0] = ((float)(0.2989D * paramArrayOfFloat[0] + 0.5866D * paramArrayOfFloat[1] + 0.1145D * paramArrayOfFloat[2]));
    arrayOfFloat[1] = ((float)(0.7132D * (paramArrayOfFloat[0] - arrayOfFloat[0])));
    arrayOfFloat[2] = ((float)(0.5647D * (paramArrayOfFloat[2] - arrayOfFloat[0])));
    b(this.y, arrayOfFloat);
  }
  
  public void c()
  {
    super.c();
    this.x = GLES20.glGetUniformLocation(p(), "screenMode");
    this.y = GLES20.glGetUniformLocation(p(), "screenReplaceColor");
    this.z = GLES20.glGetUniformLocation(p(), "screenMirrorX");
    this.A = GLES20.glGetUniformLocation(p(), "screenMirrorY");
    b(this.B);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.e
 * JD-Core Version:    0.7.0.1
 */