package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.sdk.platformtools.ab;

final class j$1
  implements a
{
  j$1(j paramj) {}
  
  public final void aC(int paramInt, String paramString)
  {
    AppMethodBeat.i(41489);
    ab.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: pre processing done. errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (paramInt == 0)
    {
      this.mGi.hM(false);
      AppMethodBeat.o(41489);
      return;
    }
    this.mGi.S(1, "");
    AppMethodBeat.o(41489);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.j.1
 * JD-Core Version:    0.7.0.1
 */