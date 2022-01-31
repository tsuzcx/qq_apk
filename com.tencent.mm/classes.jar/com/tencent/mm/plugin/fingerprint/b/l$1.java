package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.soter.a.d.b;

final class l$1
  implements b
{
  l$1(l paraml, c paramc) {}
  
  public final void aTd()
  {
    y.i("MicroMsg.SoterAuthMgrImp", "alvinluo onStartAuthentication");
  }
  
  public final void aTe()
  {
    l.a(this.klA);
    y.i("MicroMsg.SoterAuthMgrImp", "alvinluo onAuthenticationSucceed");
  }
  
  public final void onAuthenticationCancelled()
  {
    y.i("MicroMsg.SoterAuthMgrImp", "alvinluo onAuthenticationCancelled");
    l.a(this.klA);
  }
  
  public final void onAuthenticationError(int paramInt, CharSequence paramCharSequence)
  {
    y.e("MicroMsg.SoterAuthMgrImp", "alvinluo onAuthenticationError errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramCharSequence });
    l.a(this.klA);
  }
  
  public final void onAuthenticationFailed()
  {
    y.i("MicroMsg.SoterAuthMgrImp", "alvinluo onAuthenticationFailed");
    if (this.klz != null) {
      this.klz.aR(2002, -1);
    }
  }
  
  public final void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence)
  {
    y.i("MicroMsg.SoterAuthMgrImp", "alvinluo onAuthenticationHelp helpCode: %d, helpString: %s", new Object[] { Integer.valueOf(paramInt), paramCharSequence });
    if (this.klz != null) {
      this.klz.aR(2000, -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.l.1
 * JD-Core Version:    0.7.0.1
 */