package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class o$13$1
  implements Runnable
{
  o$13$1(o.13 param13) {}
  
  public final void run()
  {
    AppMethodBeat.i(135532);
    if ((!bo.isNullOrNil(o.d(this.kLW.kLI))) && (o.e(this.kLW.kLI) != o.d.kMl))
    {
      o.f(this.kLW.kLI).reset(o.d(this.kLW.kLI));
      o.f(this.kLW.kLI).a(o.d(this.kLW.kLI), new o.13.1.1(this));
      AppMethodBeat.o(135532);
      return;
    }
    ab.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room now");
    AppMethodBeat.o(135532);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.o.13.1
 * JD-Core Version:    0.7.0.1
 */