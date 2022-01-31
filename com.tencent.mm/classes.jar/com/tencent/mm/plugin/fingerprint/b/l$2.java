package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.soter.a.a.b;

final class l$2
  implements b
{
  l$2(l paraml) {}
  
  public final void bzy()
  {
    AppMethodBeat.i(41505);
    ab.i("MicroMsg.SoterAuthMgrImp", "start biometric auth");
    AppMethodBeat.o(41505);
  }
  
  public final void bzz()
  {
    AppMethodBeat.i(41507);
    ab.i("MicroMsg.SoterAuthMgrImp", "auth succeed");
    AppMethodBeat.o(41507);
  }
  
  public final void onAuthenticationCancelled()
  {
    AppMethodBeat.i(41509);
    ab.i("MicroMsg.SoterAuthMgrImp", "auth cancel");
    AppMethodBeat.o(41509);
  }
  
  public final void onAuthenticationError(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(41510);
    ab.i("MicroMsg.SoterAuthMgrImp", "auth error: %s, %s", new Object[] { Integer.valueOf(paramInt), paramCharSequence });
    AppMethodBeat.o(41510);
  }
  
  public final void onAuthenticationFailed()
  {
    AppMethodBeat.i(41508);
    ab.i("MicroMsg.SoterAuthMgrImp", "auth failed");
    AppMethodBeat.o(41508);
  }
  
  public final void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(41506);
    ab.i("MicroMsg.SoterAuthMgrImp", "onAuthenticationHelp helpCode: %d, helpString: %s", new Object[] { Integer.valueOf(paramInt), paramCharSequence });
    AppMethodBeat.o(41506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.l.2
 * JD-Core Version:    0.7.0.1
 */