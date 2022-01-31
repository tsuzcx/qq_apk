package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.soter.a.a;

final class d$1
  implements com.tencent.mm.plugin.soter.d.g
{
  d$1(d paramd) {}
  
  public final void aC(int paramInt, String paramString)
  {
    AppMethodBeat.i(41437);
    if ((paramInt == 0) && (a.dVs()))
    {
      ab.i("MicroMsg.FingerPrintMgrImpl", "After recheck IFingerPrintMgr is now switched to SoterAuthMgrImp");
      paramString = new l();
      paramString.bzc();
      com.tencent.mm.kernel.g.b(com.tencent.mm.pluginsdk.l.class, paramString);
      AppMethodBeat.o(41437);
      return;
    }
    ab.i("MicroMsg.FingerPrintMgrImpl", "After recheck IFingerPrintMgr is still FingerPrintMgrImpl errCode[" + paramInt + "], errMsg[" + paramString + "]");
    AppMethodBeat.o(41437);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.d.1
 * JD-Core Version:    0.7.0.1
 */