package com.tencent.mm.plugin.fingerprint.mgr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.security.Signature;

public enum j
{
  public String Hgd = null;
  String Hgk = null;
  public boolean Hgl = false;
  private Signature Hgm = null;
  public com.tencent.soter.core.c.j Hgn = null;
  
  static
  {
    AppMethodBeat.i(64392);
    Hgj = new j("IML");
    Hgo = new j[] { Hgj };
    AppMethodBeat.o(64392);
  }
  
  private j() {}
  
  public final void reset()
  {
    AppMethodBeat.i(64391);
    Log.i("MicroMsg.WalletFingerprintVerifyManager", "hy: start reset");
    this.Hgm = null;
    this.Hgd = null;
    this.Hgl = false;
    this.Hgk = "";
    AppMethodBeat.o(64391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.mgr.j
 * JD-Core Version:    0.7.0.1
 */