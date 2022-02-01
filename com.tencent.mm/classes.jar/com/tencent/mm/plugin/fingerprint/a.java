package com.tencent.mm.plugin.fingerprint;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.fingerprint.b.b;
import com.tencent.mm.plugin.fingerprint.b.f;
import com.tencent.mm.plugin.fingerprint.b.h;
import com.tencent.mm.plugin.fingerprint.b.j;
import com.tencent.mm.plugin.fingerprint.b.n;
import com.tencent.mm.plugin.fingerprint.b.q;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class a
  implements bd
{
  private n wEn;
  private com.tencent.mm.plugin.fingerprint.b.i wEo;
  private j wEp;
  private b wEq;
  private com.tencent.mm.plugin.fingerprint.b.e wEr;
  private f wEs;
  
  static
  {
    AppMethodBeat.i(64216);
    com.tencent.mm.wallet_core.a.j("FingerprintAuth", com.tencent.mm.plugin.fingerprint.ui.a.class);
    AppMethodBeat.o(64216);
  }
  
  public a()
  {
    AppMethodBeat.i(64213);
    this.wEn = new n();
    this.wEo = new com.tencent.mm.plugin.fingerprint.b.i();
    this.wEp = new j();
    this.wEq = new b();
    this.wEr = new com.tencent.mm.plugin.fingerprint.b.e();
    this.wEs = new f();
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
    EventCenter.instance.addListener(this.wEn);
    EventCenter.instance.addListener(this.wEo);
    EventCenter.instance.addListener(this.wEp);
    EventCenter.instance.addListener(this.wEq);
    EventCenter.instance.addListener(this.wEr);
    EventCenter.instance.addListener(this.wEs);
    g.a(h.class, new com.tencent.mm.kernel.c.e(new q()));
    AppMethodBeat.o(64214);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(64215);
    EventCenter.instance.removeListener(this.wEn);
    this.wEo.release();
    EventCenter.instance.removeListener(this.wEo);
    EventCenter.instance.removeListener(this.wEp);
    EventCenter.instance.removeListener(this.wEq);
    EventCenter.instance.removeListener(this.wEr);
    ((com.tencent.mm.plugin.fingerprint.b.a.i)g.af(com.tencent.mm.plugin.fingerprint.b.a.i.class)).cancel();
    EventCenter.instance.removeListener(this.wEs);
    g.ag(h.class);
    AppMethodBeat.o(64215);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.a
 * JD-Core Version:    0.7.0.1
 */