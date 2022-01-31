package com.tencent.liteav.basic.d;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.FloatBuffer;

class g$5
  implements Runnable
{
  g$5(g paramg, int paramInt, float[] paramArrayOfFloat) {}
  
  public void run()
  {
    AppMethodBeat.i(146563);
    GLES20.glUniform4fv(this.a, 1, FloatBuffer.wrap(this.b));
    AppMethodBeat.o(146563);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.basic.d.g.5
 * JD-Core Version:    0.7.0.1
 */