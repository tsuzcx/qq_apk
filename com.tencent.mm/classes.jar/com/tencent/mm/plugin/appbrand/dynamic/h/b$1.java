package com.tencent.mm.plugin.appbrand.dynamic.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.sdk.platformtools.av.a;

final class b$1
  implements av.a
{
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(121426);
    BaseIPCService localBaseIPCService = j.ahy().wx("com.tencent.mm:support");
    if (localBaseIPCService != null) {
      localBaseIPCService.dx(false);
    }
    AppMethodBeat.o(121426);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.h.b.1
 * JD-Core Version:    0.7.0.1
 */