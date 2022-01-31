package com.tencent.liteav.basic.d;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.FloatBuffer;

class g$3
  implements Runnable
{
  g$3(g paramg, int paramInt, float[] paramArrayOfFloat) {}
  
  public void run()
  {
    AppMethodBeat.i(146506);
    GLES20.glUniform2fv(this.a, 1, FloatBuffer.wrap(this.b));
    AppMethodBeat.o(146506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.basic.d.g.3
 * JD-Core Version:    0.7.0.1
 */