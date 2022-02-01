package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.co;

final class c$a
  implements m<IPCVoid, IPCString>
{
  private static IPCString cBD()
  {
    AppMethodBeat.i(146141);
    try
    {
      Log.i("MicroMsg.Record.AppBrandRecordClientService", "ipc updateDeviceInfo");
      IPCString localIPCString1 = new IPCString(h.baE().bao().jcN());
      AppMethodBeat.o(146141);
      return localIPCString1;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.Record.AppBrandRecordClientService", localException, "ipc updateDeviceInfo task", new Object[0]);
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