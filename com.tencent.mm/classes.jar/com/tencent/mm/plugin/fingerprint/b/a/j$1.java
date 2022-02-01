package com.tencent.mm.plugin.fingerprint.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.d.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.soter.a.a;

final class j$1
  implements g
{
  j$1(j paramj) {}
  
  public final void aU(int paramInt, String paramString)
  {
    AppMethodBeat.i(64424);
    if ((paramInt == 0) && (a.fnk()))
    {
      ad.i("MicroMsg.SoterBiometricPayManager", "init success: %s", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(64424);
      return;
    }
    ad.i("MicroMsg.SoterBiometricPayManager", "init failed: %s, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    AppMethodBeat.o(64424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.a.j.1
 * JD-Core Version:    0.7.0.1
 */