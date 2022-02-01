package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.soter.core.c.j;
import java.security.Signature;

public enum p
{
  public String skD = null;
  String skK = null;
  public boolean skL = false;
  private Signature skM = null;
  public j skN = null;
  
  static
  {
    AppMethodBeat.i(64392);
    skJ = new p("IML");
    skO = new p[] { skJ };
    AppMethodBeat.o(64392);
  }
  
  private p() {}
  
  public final void reset()
  {
    AppMethodBeat.i(64391);
    ac.i("MicroMsg.WalletFingerprintVerifyManager", "hy: start reset");
    this.skM = null;
    this.skD = null;
    this.skL = false;
    this.skK = "";
    AppMethodBeat.o(64391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.p
 * JD-Core Version:    0.7.0.1
 */