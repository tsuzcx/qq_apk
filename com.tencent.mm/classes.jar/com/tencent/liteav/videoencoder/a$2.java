package com.tencent.liteav.videoencoder;

import android.os.Handler;
import com.tencent.liteav.basic.util.b;

class a$2
  implements Runnable
{
  a$2(a parama) {}
  
  public void run()
  {
    if (this.a.mInit)
    {
      a.a(this.a);
      a.b(this.a).a().removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.a.2
 * JD-Core Version:    0.7.0.1
 */