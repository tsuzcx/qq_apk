package com.tencent.liteav;

import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;
import com.tencent.matrix.trace.core.AppMethodBeat;

class c$11
  implements Runnable
{
  c$11(c paramc) {}
  
  public void run()
  {
    AppMethodBeat.i(67654);
    if (c.e(this.a) != null) {
      c.e(this.a).b(true);
    }
    c.a(this.a, c.b(this.a).width, c.b(this.a).height);
    AppMethodBeat.o(67654);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteav.c.11
 * JD-Core Version:    0.7.0.1
 */