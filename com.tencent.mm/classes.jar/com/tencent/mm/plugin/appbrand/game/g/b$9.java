package com.tencent.mm.plugin.appbrand.game.g;

import com.hilive.mediasdk.InvokeEvent.IEAnalysis;
import com.hilive.mediasdk.MediaSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b$9
  implements Runnable
{
  public b$9(b paramb, String paramString, d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(143233);
    InvokeEvent.IEAnalysis localIEAnalysis = new InvokeEvent.IEAnalysis();
    localIEAnalysis.filePath = this.val$filePath;
    MediaSdk.getInstance().fileAnalysis(localIEAnalysis, new b.9.1(this));
    AppMethodBeat.o(143233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.g.b.9
 * JD-Core Version:    0.7.0.1
 */