package com.tencent.liteav.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;

class TXCLiveBGMPlayer$2
  implements Runnable
{
  TXCLiveBGMPlayer$2(TXCLiveBGMPlayer paramTXCLiveBGMPlayer, e parame, int paramInt) {}
  
  public void run()
  {
    AppMethodBeat.i(66708);
    if (this.a != null) {
      this.a.onPlayEnd(this.b);
    }
    AppMethodBeat.o(66708);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.audio.TXCLiveBGMPlayer.2
 * JD-Core Version:    0.7.0.1
 */