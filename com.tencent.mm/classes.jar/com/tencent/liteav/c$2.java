package com.tencent.liteav;

import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;

class c$2
  implements Runnable
{
  c$2(c paramc) {}
  
  public void run()
  {
    try
    {
      if ((this.a.a != null) && (c.b(this.a) != null) && (c.g(this.a) != null)) {
        this.a.a.a(c.b(this.a).f(), c.g(this.a), c.a(this.a).t, c.d(this.a).width, c.d(this.a).height);
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.c.2
 * JD-Core Version:    0.7.0.1
 */