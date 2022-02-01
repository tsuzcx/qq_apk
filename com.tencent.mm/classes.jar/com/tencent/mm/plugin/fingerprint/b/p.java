package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.soter.core.c.j;
import java.security.Signature;

public enum p
{
  public String thf = null;
  String thm = null;
  public boolean thn = false;
  private Signature tho = null;
  public j thp = null;
  
  static
  {
    AppMethodBeat.i(64392);
    thl = new p("IML");
    thq = new p[] { thl };
    AppMethodBeat.o(64392);
  }
  
  private p() {}
  
  public final void reset()
  {
    AppMethodBeat.i(64391);
    ad.i("MicroMsg.WalletFingerprintVerifyManager", "hy: start reset");
    this.tho = null;
    this.thf = null;
    this.thn = false;
    this.thm = "";
    AppMethodBeat.o(64391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.p
 * JD-Core Version:    0.7.0.1
 */