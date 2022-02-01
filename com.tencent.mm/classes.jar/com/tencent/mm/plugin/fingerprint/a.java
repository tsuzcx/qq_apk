package com.tencent.mm.plugin.fingerprint;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.plugin.fingerprint.mgr.CloseFingerPrintEventListener;
import com.tencent.mm.plugin.fingerprint.mgr.GenFingerPrintRsaKeyEventListener;
import com.tencent.mm.plugin.fingerprint.mgr.GetWcPaySignEventListener;
import com.tencent.mm.plugin.fingerprint.mgr.OpenFingerPrintAuthEventListener;
import com.tencent.mm.plugin.fingerprint.mgr.ReleaseFingerPrintAuthEventListener;
import com.tencent.mm.plugin.fingerprint.mgr.SupportFingerPrintEventListener;
import com.tencent.mm.plugin.fingerprint.mgr.a.i;
import com.tencent.mm.plugin.fingerprint.mgr.k;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class a
  implements be
{
  private SupportFingerPrintEventListener HeN;
  private OpenFingerPrintAuthEventListener HeO;
  private ReleaseFingerPrintAuthEventListener HeP;
  private CloseFingerPrintEventListener HeQ;
  private GenFingerPrintRsaKeyEventListener HeR;
  private GetWcPaySignEventListener HeS;
  
  static
  {
    AppMethodBeat.i(64216);
    com.tencent.mm.wallet_core.a.n("FingerprintAuth", com.tencent.mm.plugin.fingerprint.ui.a.class);
    AppMethodBeat.o(64216);
  }
  
  public a()
  {
    AppMethodBeat.i(64213);
    this.HeN = new SupportFingerPrintEventListener();
    this.HeO = new OpenFingerPrintAuthEventListener();
    this.HeP = new ReleaseFingerPrintAuthEventListener();
    this.HeQ = new CloseFingerPrintEventListener();
    this.HeR = new GenFingerPrintRsaKeyEventListener();
    this.HeS = new GetWcPaySignEventListener();
    AppMethodBeat.o(64213);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(64214);
    this.HeN.alive();
    this.HeO.alive();
    this.HeP.alive();
    this.HeQ.alive();
    this.HeR.alive();
    this.HeS.alive();
    h.a(com.tencent.mm.plugin.fingerprint.mgr.e.class, new com.tencent.mm.kernel.c.e(new k()));
    AppMethodBeat.o(64214);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(64215);
    this.HeN.dead();
    this.HeO.release();
    this.HeO.dead();
    this.HeP.dead();
    this.HeQ.dead();
    this.HeR.dead();
    ((i)h.ax(i.class)).cancel();
    this.HeS.dead();
    h.ay(com.tencent.mm.plugin.fingerprint.mgr.e.class);
    AppMethodBeat.o(64215);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.a
 * JD-Core Version:    0.7.0.1
 */