package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r;

final class f$2
  implements l.a
{
  f$2(f paramf, r paramr) {}
  
  public final void Cc(String paramString)
  {
    AppMethodBeat.i(74741);
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(74741);
      return;
      if (!paramString.equals("StateListening")) {
        break;
      }
      i = 0;
      break;
      if (!paramString.equals("StateNotListening")) {
        break;
      }
      i = 1;
      break;
      if (!paramString.equals("StateSuspend")) {
        break;
      }
      i = 2;
      break;
      this.hNc.hNb.A(this.bAW.getRuntime());
      AppMethodBeat.o(74741);
      return;
      this.hNc.hNb.aDg();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.f.2
 * JD-Core Version:    0.7.0.1
 */