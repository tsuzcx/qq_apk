package com.tencent.liteav.videoencoder;

import com.tencent.matrix.trace.core.AppMethodBeat;

class b$5
  implements Runnable
{
  b$5(b paramb) {}
  
  public void run()
  {
    AppMethodBeat.i(67436);
    if (b.d(this.a) != null) {
      b.d(this.a).setBitrate(b.f(this.a));
    }
    AppMethodBeat.o(67436);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.b.5
 * JD-Core Version:    0.7.0.1
 */