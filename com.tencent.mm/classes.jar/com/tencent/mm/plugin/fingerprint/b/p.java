package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.soter.core.c.j;
import java.security.Signature;

public enum p
{
  public String trY = null;
  String tsf = null;
  public boolean tsg = false;
  private Signature tsh = null;
  public j tsi = null;
  
  static
  {
    AppMethodBeat.i(64392);
    tse = new p("IML");
    tsj = new p[] { tse };
    AppMethodBeat.o(64392);
  }
  
  private p() {}
  
  public final void reset()
  {
    AppMethodBeat.i(64391);
    ae.i("MicroMsg.WalletFingerprintVerifyManager", "hy: start reset");
    this.tsh = null;
    this.trY = null;
    this.tsg = false;
    this.tsf = "";
    AppMethodBeat.o(64391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.p
 * JD-Core Version:    0.7.0.1
 */