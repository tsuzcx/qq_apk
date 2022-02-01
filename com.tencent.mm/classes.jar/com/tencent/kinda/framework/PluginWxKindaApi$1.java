package com.tencent.kinda.framework;

import com.tencent.kinda.framework.boot.KindaApp;
import com.tencent.kinda.gen.IAppKinda;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.Log;

class PluginWxKindaApi$1
  implements Runnable
{
  PluginWxKindaApi$1(PluginWxKindaApi paramPluginWxKindaApi) {}
  
  public void run()
  {
    AppMethodBeat.i(292954);
    try
    {
      if ((((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE()) && (KindaApp.isEnabled())) {
        KindaApp.appKinda().applicationRestart();
      }
      AppMethodBeat.o(292954);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.PluginWxKindaApi", localException, "", new Object[0]);
      AppMethodBeat.o(292954);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label39:
      break label39;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.kinda.framework.PluginWxKindaApi.1
 * JD-Core Version:    0.7.0.1
 */