package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.soter.core.c.j;
import java.security.Signature;

public enum p
{
  public String ByB = null;
  String ByI = null;
  public boolean ByJ = false;
  private Signature ByK = null;
  public j ByL = null;
  
  static
  {
    AppMethodBeat.i(64392);
    ByH = new p("IML");
    ByM = new p[] { ByH };
    AppMethodBeat.o(64392);
  }
  
  private p() {}
  
  public final void reset()
  {
    AppMethodBeat.i(64391);
    Log.i("MicroMsg.WalletFingerprintVerifyManager", "hy: start reset");
    this.ByK = null;
    this.ByB = null;
    this.ByJ = false;
    this.ByI = "";
    AppMethodBeat.o(64391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.p
 * JD-Core Version:    0.7.0.1
 */