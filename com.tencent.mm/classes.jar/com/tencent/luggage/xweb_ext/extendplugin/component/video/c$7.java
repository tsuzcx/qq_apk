package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class c$7
  implements Runnable
{
  c$7(c paramc) {}
  
  public final void run()
  {
    boolean bool = false;
    AppMethodBeat.i(138953);
    c localc = this.cJF;
    Log.i(localc.getLogTag(), "*** handler(%s) handleWebViewForeground", new Object[] { localc.Lb() });
    localc.cJs = false;
    if (!localc.cER)
    {
      bool = localc.Qo();
      localc.cET = null;
    }
    c.8 local8 = new c.8(localc, bool);
    Log.d(localc.getLogTag(), "handleWebViewForeground, isRuntimeInBackground: " + localc.cER);
    if ((!localc.cER) && (localc.isPlaying()) && (!localc.cJm)) {
      h.RTc.aV(new c.9(localc));
    }
    if (!localc.Qr())
    {
      Log.i(localc.getLogTag(), "handleWebViewForeground, resume playing");
      local8.run();
    }
    AppMethodBeat.o(138953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.c.7
 * JD-Core Version:    0.7.0.1
 */