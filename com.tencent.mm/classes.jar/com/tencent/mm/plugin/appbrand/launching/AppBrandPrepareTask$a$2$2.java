package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cd;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandPrepareTask$a$2$2
  extends c<cd>
{
  AppBrandPrepareTask$a$2$2(AppBrandPrepareTask.a.2 param2)
  {
    AppMethodBeat.i(131743);
    this.__eventId = cd.class.getName().hashCode();
    AppMethodBeat.o(131743);
  }
  
  private boolean a(cd paramcd)
  {
    AppMethodBeat.i(131744);
    if (paramcd != null)
    {
      dead();
      ab.i("MicroMsg.AppBrandPrepareTask", "prepareCall account notifyAllDone, start real prepare");
    }
    this.ikg.ike.aGK();
    AppMethodBeat.o(131744);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.a.2.2
 * JD-Core Version:    0.7.0.1
 */