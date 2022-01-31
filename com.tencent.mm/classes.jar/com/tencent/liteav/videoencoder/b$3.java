package com.tencent.liteav.videoencoder;

import com.tencent.liteav.beauty.b.k;
import java.util.LinkedList;

class b$3
  implements Runnable
{
  b$3(b paramb, com.tencent.liteav.basic.d.b paramb1) {}
  
  public void run()
  {
    b.d(this.b).clear();
    if (b.e(this.b) != null) {
      b.e(this.b).stop();
    }
    if (b.b(this.b) != null)
    {
      b.b(this.b).d();
      b.a(this.b, null);
    }
    if (this.a != null) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.b.3
 * JD-Core Version:    0.7.0.1
 */