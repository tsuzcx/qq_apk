package com.tencent.mm.plugin.fingerprint;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.plugin.fingerprint.b.b;
import com.tencent.mm.plugin.fingerprint.b.f;
import com.tencent.mm.plugin.fingerprint.b.j;
import com.tencent.mm.plugin.fingerprint.b.n;
import com.tencent.mm.plugin.fingerprint.b.q;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class a
  implements be
{
  private n Bxk;
  private com.tencent.mm.plugin.fingerprint.b.i Bxl;
  private j Bxm;
  private b Bxn;
  private com.tencent.mm.plugin.fingerprint.b.e Bxo;
  private f Bxp;
  
  static
  {
    AppMethodBeat.i(64216);
    com.tencent.mm.wallet_core.a.j("FingerprintAuth", com.tencent.mm.plugin.fingerprint.ui.a.class);
    AppMethodBeat.o(64216);
  }
  
  public a()
  {
    AppMethodBeat.i(64213);
    this.Bxk = new n();
    this.Bxl = new com.tencent.mm.plugin.fingerprint.b.i();
    this.Bxm = new j();
    this.Bxn = new b();
    this.Bxo = new com.tencent.mm.plugin.fingerprint.b.e();
    this.Bxp = new f();
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
    EventCenter.instance.addListener(this.Bxk);
    EventCenter.instance.addListener(this.Bxl);
    EventCenter.instance.addListener(this.Bxm);
    EventCenter.instance.addListener(this.Bxn);
    EventCenter.instance.addListener(this.Bxo);
    EventCenter.instance.addListener(this.Bxp);
    com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.fingerprint.b.h.class, new com.tencent.mm.kernel.c.e(new q()));
    AppMethodBeat.o(64214);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(64215);
    EventCenter.instance.removeListener(this.Bxk);
    this.Bxl.release();
    EventCenter.instance.removeListener(this.Bxl);
    EventCenter.instance.removeListener(this.Bxm);
    EventCenter.instance.removeListener(this.Bxn);
    EventCenter.instance.removeListener(this.Bxo);
    ((com.tencent.mm.plugin.fingerprint.b.a.i)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.b.a.i.class)).cancel();
    EventCenter.instance.removeListener(this.Bxp);
    com.tencent.mm.kernel.h.af(com.tencent.mm.plugin.fingerprint.b.h.class);
    AppMethodBeat.o(64215);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.a
 * JD-Core Version:    0.7.0.1
 */