package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.soter.core.c.j;
import java.security.Signature;

public enum p
{
  public String wFE = null;
  String wFL = null;
  public boolean wFM = false;
  private Signature wFN = null;
  public j wFO = null;
  
  static
  {
    AppMethodBeat.i(64392);
    wFK = new p("IML");
    wFP = new p[] { wFK };
    AppMethodBeat.o(64392);
  }
  
  private p() {}
  
  public final void reset()
  {
    AppMethodBeat.i(64391);
    Log.i("MicroMsg.WalletFingerprintVerifyManager", "hy: start reset");
    this.wFN = null;
    this.wFE = null;
    this.wFM = false;
    this.wFL = "";
    AppMethodBeat.o(64391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.p
 * JD-Core Version:    0.7.0.1
 */