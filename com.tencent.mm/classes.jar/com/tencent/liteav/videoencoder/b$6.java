package com.tencent.liteav.videoencoder;

class b$6
  implements Runnable
{
  b$6(b paramb) {}
  
  public void run()
  {
    b.a(this.a, 1107, "软编切硬编");
    if (b.e(this.a) != null)
    {
      b.e(this.a).setListener(null);
      b.e(this.a).stop();
    }
    b.a(this.a, new a());
    b.a(this.a, 1);
    this.a.setStatusValue(4004, Long.valueOf(b.h(this.a)));
    b.e(this.a).start(b.c(this.a));
    if (b.f(this.a) != null) {
      b.e(this.a).setListener(b.f(this.a));
    }
    if (b.g(this.a) != 0) {
      b.e(this.a).setBitrate(b.g(this.a));
    }
    b.e(this.a).setID(this.a.getID());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.b.6
 * JD-Core Version:    0.7.0.1
 */