package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.cd;

final class c$a
  implements k<IPCVoid, IPCString>
{
  private static IPCString btq()
  {
    AppMethodBeat.i(146141);
    try
    {
      ae.i("MicroMsg.Record.AppBrandRecordClientService", "ipc updateDeviceInfo");
      IPCString localIPCString1 = new IPCString(g.ajR().ajB().fwI());
      AppMethodBeat.o(146141);
      return localIPCString1;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.Record.AppBrandRecordClientService", localException, "ipc updateDeviceInfo task", new Object[0]);
      IPCString localIPCString2 = new IPCString("");
      AppMethodBeat.o(146141);
      return localIPCString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.c.a
 * JD-Core Version:    0.7.0.1
 */