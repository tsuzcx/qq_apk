package com.tencent.liteav;

import android.view.SurfaceHolder;
import com.tencent.liteav.renderer.d;

class b$4
  implements Runnable
{
  b$4(b paramb, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (b.a(this.c) != null) {
      b.a(this.c).getHolder().setFixedSize(this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.b.4
 * JD-Core Version:    0.7.0.1
 */