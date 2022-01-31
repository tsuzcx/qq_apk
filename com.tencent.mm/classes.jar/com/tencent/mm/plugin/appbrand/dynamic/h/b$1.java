package com.tencent.mm.plugin.appbrand.dynamic.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.sdk.platformtools.ap.a;

final class b$1
  implements ap.a
{
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(10945);
    BaseIPCService localBaseIPCService = h.PN().mc("com.tencent.mm:support");
    if (localBaseIPCService != null) {
      localBaseIPCService.cr(false);
    }
    AppMethodBeat.o(10945);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.h.b.1
 * JD-Core Version:    0.7.0.1
 */