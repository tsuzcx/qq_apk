package com.tencent.liteav.beauty.b;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.liteav.basic.d.f;

class l$1
  implements Runnable
{
  l$1(l paraml, Bitmap paramBitmap1, Bitmap paramBitmap2) {}
  
  public void run()
  {
    l.a(this.c, this.a);
    l.b(this.c, this.b);
    if (this.a != null)
    {
      l.a(this.c, f.a(this.a, l.a(this.c), false));
      l.b(this.c)[0] = 1.0F;
    }
    while (this.b != null)
    {
      l.b(this.c, f.a(this.b, l.c(this.c), false));
      l.b(this.c)[1] = 1.0F;
      return;
      if (l.a(this.c) != -1) {
        GLES20.glDeleteTextures(1, new int[] { l.a(this.c) }, 0);
      }
      l.a(this.c, -1);
      l.b(this.c)[0] = 0.0F;
    }
    if (l.c(this.c) != -1) {
      GLES20.glDeleteTextures(1, new int[] { l.c(this.c) }, 0);
    }
    l.b(this.c, -1);
    l.b(this.c)[1] = 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.l.1
 * JD-Core Version:    0.7.0.1
 */