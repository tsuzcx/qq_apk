package com.tencent.liteav.network;

import com.tencent.matrix.trace.core.AppMethodBeat;

class TXCStreamDownloader$1
  implements Runnable
{
  TXCStreamDownloader$1(TXCStreamDownloader paramTXCStreamDownloader) {}
  
  public void run()
  {
    AppMethodBeat.i(67545);
    this.a.stop();
    this.a.start(TXCStreamDownloader.access$000(this.a), TXCStreamDownloader.access$100(this.a), TXCStreamDownloader.access$200(this.a), TXCStreamDownloader.access$300(this.a));
    AppMethodBeat.o(67545);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.network.TXCStreamDownloader.1
 * JD-Core Version:    0.7.0.1
 */