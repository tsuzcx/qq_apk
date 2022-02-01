package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/AppBrandParallelTaskReporter;", "", "()V", "ID", "", "KEY_DOWNLOAD_FAIL", "KEY_GET_DOWNLOAD_URL", "KEY_GET_LAUNCH", "KEY_HIT_DOWNLOAD_URL", "KEY_HIT_LAUNCH_AFTER_WAIT", "KEY_HIT_LAUNCH_WITHOUT_WAIT", "KEY_NO_CONTACT", "TAG", "", "report", "", "idKey", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b tdL;
  
  static
  {
    AppMethodBeat.i(175194);
    tdL = new b();
    AppMethodBeat.o(175194);
  }
  
  public static final void rG(int paramInt)
  {
    AppMethodBeat.i(175193);
    Log.i("MicroMsg.AppBrandParallelTaskReporter", "report: key = [%d]", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt < 0) || (paramInt > 255))
    {
      AppMethodBeat.o(175193);
      return;
    }
    h.OAn.kJ(1248, paramInt);
    AppMethodBeat.o(175193);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.b
 * JD-Core Version:    0.7.0.1
 */