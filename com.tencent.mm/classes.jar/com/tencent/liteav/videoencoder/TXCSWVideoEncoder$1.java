package com.tencent.liteav.videoencoder;

import com.tencent.liteav.basic.d.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

class TXCSWVideoEncoder$1
  implements g.a
{
  TXCSWVideoEncoder$1(TXCSWVideoEncoder paramTXCSWVideoEncoder, boolean paramBoolean, int paramInt) {}
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(67412);
    if (this.a)
    {
      TXCSWVideoEncoder.access$200(this.c, TXCSWVideoEncoder.access$000(this.c), this.b, this.c.mOutputWidth, this.c.mOutputHeight, TXCSWVideoEncoder.access$100(this.c));
      AppMethodBeat.o(67412);
      return;
    }
    TXCSWVideoEncoder.access$300(this.c, TXCSWVideoEncoder.access$000(this.c), this.b, this.c.mOutputWidth, this.c.mOutputHeight, TXCSWVideoEncoder.access$100(this.c));
    AppMethodBeat.o(67412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.TXCSWVideoEncoder.1
 * JD-Core Version:    0.7.0.1
 */