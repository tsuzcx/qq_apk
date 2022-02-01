package com.tencent.kinda.framework;

import com.tencent.kinda.framework.boot.KindaApp;
import com.tencent.kinda.gen.IAppKinda;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.Log;

class PluginWxKindaApi$4
  implements Runnable
{
  PluginWxKindaApi$4(PluginWxKindaApi paramPluginWxKindaApi) {}
  
  public void run()
  {
    AppMethodBeat.i(292959);
    try
    {
      if ((((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE()) && (KindaApp.isEnabled()))
      {
        ITransmitKvData localITransmitKvData = ITransmitKvData.create();
        localITransmitKvData.putString("foreground", AppForegroundDelegate.fby.cQt);
        localITransmitKvData.putString("emulator", "1");
        KindaApp.appKinda().applicationWillTerminate(localITransmitKvData);
      }
      AppMethodBeat.o(292959);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.PluginWxKindaApi", localException, "", new Object[0]);
      AppMethodBeat.o(292959);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label77:
      break label77;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.kinda.framework.PluginWxKindaApi.4
 * JD-Core Version:    0.7.0.1
 */