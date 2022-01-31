package com.tencent.liteav.basic.d;

import android.opengl.GLES20;
import java.nio.FloatBuffer;

class d$2
  implements Runnable
{
  d$2(d paramd, int paramInt, float[] paramArrayOfFloat) {}
  
  public void run()
  {
    GLES20.glUniform2fv(this.a, 1, FloatBuffer.wrap(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.basic.d.d.2
 * JD-Core Version:    0.7.0.1
 */