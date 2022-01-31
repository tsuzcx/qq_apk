package com.tencent.liteav.renderer;

import android.opengl.GLES20;

class d$2
  implements Runnable
{
  d$2(d paramd, int paramInt) {}
  
  public void run()
  {
    d.b(this.b, this.a);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glClear(16640);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.renderer.d.2
 * JD-Core Version:    0.7.0.1
 */