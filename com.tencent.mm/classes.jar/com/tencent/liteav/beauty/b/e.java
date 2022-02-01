package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class e
  extends s
{
  private int A;
  private float[] B;
  private int x;
  private int y;
  private int z;
  
  public void b(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(15040);
    float[] arrayOfFloat = new float[3];
    arrayOfFloat[0] = ((float)(0.2989D * paramArrayOfFloat[0] + 0.5866D * paramArrayOfFloat[1] + 0.1145D * paramArrayOfFloat[2]));
    arrayOfFloat[1] = ((float)(0.7132D * (paramArrayOfFloat[0] - arrayOfFloat[0])));
    arrayOfFloat[2] = ((float)(0.5647D * (paramArrayOfFloat[2] - arrayOfFloat[0])));
    b(this.y, arrayOfFloat);
    AppMethodBeat.o(15040);
  }
  
  public void c()
  {
    AppMethodBeat.i(15039);
    super.c();
    this.x = GLES20.glGetUniformLocation(p(), "screenMode");
    this.y = GLES20.glGetUniformLocation(p(), "screenReplaceColor");
    this.z = GLES20.glGetUniformLocation(p(), "screenMirrorX");
    this.A = GLES20.glGetUniformLocation(p(), "screenMirrorY");
    b(this.B);
    AppMethodBeat.o(15039);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.e
 * JD-Core Version:    0.7.0.1
 */