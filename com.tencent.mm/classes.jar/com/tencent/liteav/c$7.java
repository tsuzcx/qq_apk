package com.tencent.liteav;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

class c$7
  implements Runnable
{
  c$7(c paramc, Bitmap paramBitmap, int paramInt1, int paramInt2, ByteBuffer paramByteBuffer) {}
  
  public void run()
  {
    try
    {
      int i = this.a.getWidth();
      int j = this.a.getHeight();
      com.tencent.liteav.basic.d.a locala = com.tencent.liteav.basic.util.a.a(i, j, this.b, this.c);
      c.f(this.e).a(locala);
      c.f(this.e).a(false);
      c.f(this.e).a(this.b, this.c);
      c.f(this.e).a(0);
      c.f(this.e).a(this.d.array(), i, j, 0, 2, 0);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.liteav.c.7
 * JD-Core Version:    0.7.0.1
 */