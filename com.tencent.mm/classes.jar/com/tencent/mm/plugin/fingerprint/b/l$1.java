package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.wallet.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.soter.a.d.b;

final class l$1
  implements b
{
  l$1(l paraml, d paramd) {}
  
  public final void bzy()
  {
    AppMethodBeat.i(41499);
    ab.i("MicroMsg.SoterAuthMgrImp", "alvinluo onStartAuthentication");
    AppMethodBeat.o(41499);
  }
  
  public final void bzz()
  {
    AppMethodBeat.i(41501);
    l.a(this.mGo);
    ab.i("MicroMsg.SoterAuthMgrImp", "alvinluo onAuthenticationSucceed");
    AppMethodBeat.o(41501);
  }
  
  public final void onAuthenticationCancelled()
  {
    AppMethodBeat.i(41503);
    ab.i("MicroMsg.SoterAuthMgrImp", "alvinluo onAuthenticationCancelled");
    l.a(this.mGo);
    AppMethodBeat.o(41503);
  }
  
  public final void onAuthenticationError(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(41504);
    ab.e("MicroMsg.SoterAuthMgrImp", "alvinluo onAuthenticationError errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramCharSequence });
    if (10308 == paramInt)
    {
      ab.i("MicroMsg.SoterAuthMgrImp", "py: authentication is frozen, auto cancel now.");
      this.mGo.userCancel();
    }
    l.a(this.mGo);
    AppMethodBeat.o(41504);
  }
  
  public final void onAuthenticationFailed()
  {
    AppMethodBeat.i(41502);
    ab.i("MicroMsg.SoterAuthMgrImp", "alvinluo onAuthenticationFailed");
    if (this.mGn != null) {
      this.mGn.bC(2002, -1);
    }
    AppMethodBeat.o(41502);
  }
  
  public final void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(41500);
    ab.i("MicroMsg.SoterAuthMgrImp", "alvinluo onAuthenticationHelp helpCode: %d, helpString: %s", new Object[] { Integer.valueOf(paramInt), paramCharSequence });
    if (this.mGn != null) {
      this.mGn.bC(2000, -1);
    }
    AppMethodBeat.o(41500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.l.1
 * JD-Core Version:    0.7.0.1
 */