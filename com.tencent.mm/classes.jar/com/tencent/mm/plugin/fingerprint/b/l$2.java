package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.soter.a.a.b;

final class l$2
  implements b
{
  l$2(l paraml) {}
  
  public final void aTd()
  {
    y.i("MicroMsg.SoterAuthMgrImp", "start biometric auth");
  }
  
  public final void aTe()
  {
    y.i("MicroMsg.SoterAuthMgrImp", "auth succeed");
  }
  
  public final void onAuthenticationCancelled()
  {
    y.i("MicroMsg.SoterAuthMgrImp", "auth cancel");
  }
  
  public final void onAuthenticationError(int paramInt, CharSequence paramCharSequence)
  {
    y.i("MicroMsg.SoterAuthMgrImp", "auth error: %s, %s", new Object[] { Integer.valueOf(paramInt), paramCharSequence });
  }
  
  public final void onAuthenticationFailed()
  {
    y.i("MicroMsg.SoterAuthMgrImp", "auth failed");
  }
  
  public final void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence)
  {
    y.i("MicroMsg.SoterAuthMgrImp", "onAuthenticationHelp helpCode: %d, helpString: %s", new Object[] { Integer.valueOf(paramInt), paramCharSequence });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.l.2
 * JD-Core Version:    0.7.0.1
 */