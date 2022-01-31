package com.tencent.liteav.videoencoder;

import com.tencent.matrix.trace.core.AppMethodBeat;

class a$1
  implements Runnable
{
  a$1(a parama, boolean[] paramArrayOfBoolean, TXSVideoEncoderParam paramTXSVideoEncoderParam) {}
  
  public void run()
  {
    AppMethodBeat.i(67441);
    if (this.c.mInit) {
      a.a(this.c);
    }
    this.a[0] = a.a(this.c, this.b);
    AppMethodBeat.o(67441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.a.1
 * JD-Core Version:    0.7.0.1
 */