package com.tencent.mm.plugin.appbrand.dynamic.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.sdk.platformtools.aw.a;

final class b$1
  implements aw.a
{
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(121426);
    BaseIPCService localBaseIPCService = j.ahN().xg("com.tencent.mm:support");
    if (localBaseIPCService != null) {
      localBaseIPCService.dy(false);
    }
    AppMethodBeat.o(121426);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.h.b.1
 * JD-Core Version:    0.7.0.1
 */