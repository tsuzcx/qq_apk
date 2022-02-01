package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.soter.core.c.j;
import java.security.Signature;

public enum p
{
  public String rcj = null;
  String rcq = null;
  public boolean rcr = false;
  private Signature rcs = null;
  public j rct = null;
  
  static
  {
    AppMethodBeat.i(64392);
    rcp = new p("IML");
    rcu = new p[] { rcp };
    AppMethodBeat.o(64392);
  }
  
  private p() {}
  
  public final void reset()
  {
    AppMethodBeat.i(64391);
    ad.i("MicroMsg.WalletFingerprintVerifyManager", "hy: start reset");
    this.rcs = null;
    this.rcj = null;
    this.rcr = false;
    this.rcq = "";
    AppMethodBeat.o(64391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.p
 * JD-Core Version:    0.7.0.1
 */