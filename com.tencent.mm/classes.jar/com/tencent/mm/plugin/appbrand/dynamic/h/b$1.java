package com.tencent.mm.plugin.appbrand.dynamic.h;

import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.sdk.platformtools.am.a;

final class b$1
  implements am.a
{
  public final boolean tC()
  {
    BaseIPCService localBaseIPCService = h.BW().fH("com.tencent.mm:support");
    if (localBaseIPCService != null) {
      localBaseIPCService.bB(false);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.h.b.1
 * JD-Core Version:    0.7.0.1
 */