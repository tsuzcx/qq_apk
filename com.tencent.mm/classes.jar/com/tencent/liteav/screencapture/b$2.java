package com.tencent.liteav.screencapture;

import java.util.HashMap;

class b$2
  implements Runnable
{
  b$2(b paramb) {}
  
  public void run()
  {
    synchronized (this.a)
    {
      if (b.b(this.a).size() == 0) {
        b.c(this.a);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.liteav.screencapture.b.2
 * JD-Core Version:    0.7.0.1
 */