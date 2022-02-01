package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/AppBrandParallelTaskReporter;", "", "()V", "ID", "", "KEY_DOWNLOAD_FAIL", "KEY_GET_DOWNLOAD_URL", "KEY_GET_LAUNCH", "KEY_HIT_DOWNLOAD_URL", "KEY_HIT_LAUNCH_AFTER_WAIT", "KEY_HIT_LAUNCH_WITHOUT_WAIT", "KEY_NO_CONTACT", "TAG", "", "report", "", "idKey", "plugin-appbrand-integration_release"})
public final class b
{
  public static final b lRq;
  
  static
  {
    AppMethodBeat.i(175194);
    lRq = new b();
    AppMethodBeat.o(175194);
  }
  
  public static final void md(int paramInt)
  {
    AppMethodBeat.i(175193);
    ae.i("MicroMsg.AppBrandParallelTaskReporter", "report: key = [%d]", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt < 0) || (paramInt > 255))
    {
      AppMethodBeat.o(175193);
      return;
    }
    g.yxI.dD(1248, paramInt);
    AppMethodBeat.o(175193);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.b
 * JD-Core Version:    0.7.0.1
 */