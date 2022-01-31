package com.tencent.liteav.videoencoder;

import com.tencent.matrix.trace.core.AppMethodBeat;

class b$6
  implements Runnable
{
  b$6(b paramb) {}
  
  public void run()
  {
    AppMethodBeat.i(67445);
    b.a(this.a, 1107, "软编切硬编");
    if (b.d(this.a) != null)
    {
      b.d(this.a).setListener(null);
      b.d(this.a).stop();
    }
    b.a(this.a, new a());
    b.a(this.a, 1);
    this.a.setStatusValue(4007, Long.valueOf(b.g(this.a)));
    b.d(this.a).start(b.h(this.a));
    if (b.e(this.a) != null) {
      b.d(this.a).setListener(b.e(this.a));
    }
    if (b.f(this.a) != 0) {
      b.d(this.a).setBitrate(b.f(this.a));
    }
    b.d(this.a).setID(this.a.getID());
    AppMethodBeat.o(67445);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.b.6
 * JD-Core Version:    0.7.0.1
 */