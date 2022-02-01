package com.tencent.mm.plugin.fingerprint.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.soter.a.a;

final class g$1
  implements com.tencent.mm.plugin.soter.d.g
{
  g$1(g paramg) {}
  
  public final void aU(int paramInt, String paramString)
  {
    AppMethodBeat.i(64403);
    if (a.fnk())
    {
      ad.i("MicroMsg.DummyBiometricPayManager", "init success: %s", new Object[] { Integer.valueOf(paramInt) });
      paramString = new j();
      paramString.prepare();
      com.tencent.mm.kernel.g.b(i.class, paramString);
      AppMethodBeat.o(64403);
      return;
    }
    ad.i("MicroMsg.DummyBiometricPayManager", "init failed: %s, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    h.vKh.dB(1104, 43);
    AppMethodBeat.o(64403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.a.g.1
 * JD-Core Version:    0.7.0.1
 */