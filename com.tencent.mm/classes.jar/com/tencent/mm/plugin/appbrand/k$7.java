package com.tencent.mm.plugin.appbrand;

import android.widget.FrameLayout;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.LinkedList;

final class k$7
  implements Runnable
{
  k$7(k paramk, i parami) {}
  
  public final void run()
  {
    AppMethodBeat.i(86716);
    d.i("MicroMsg.AppBrandRuntimeContainer", "dl: removeImpl, cleanupOut.run(), appId[%s]", new Object[] { this.bFh.mAppId });
    this.bFh.cleanup();
    this.gQD.gQy.removeView(this.bFh.gPC);
    this.gQD.gQA.remove(this.bFh.mAppId);
    this.gQD.gQz.remove(this.bFh);
    AppMethodBeat.o(86716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k.7
 * JD-Core Version:    0.7.0.1
 */