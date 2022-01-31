package com.tencent.liteav.basic.d;

import android.opengl.GLES20;
import java.nio.FloatBuffer;

class d$3
  implements Runnable
{
  d$3(d paramd, int paramInt, float[] paramArrayOfFloat) {}
  
  public void run()
  {
    GLES20.glUniform3fv(this.a, 1, FloatBuffer.wrap(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.basic.d.d.3
 * JD-Core Version:    0.7.0.1
 */