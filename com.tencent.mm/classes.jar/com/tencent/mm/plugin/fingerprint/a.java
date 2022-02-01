package com.tencent.mm.plugin.fingerprint;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.fingerprint.b.b;
import com.tencent.mm.plugin.fingerprint.b.f;
import com.tencent.mm.plugin.fingerprint.b.h;
import com.tencent.mm.plugin.fingerprint.b.j;
import com.tencent.mm.plugin.fingerprint.b.n;
import com.tencent.mm.plugin.fingerprint.b.q;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class a
  implements aw
{
  private n sjl;
  private com.tencent.mm.plugin.fingerprint.b.i sjm;
  private j sjn;
  private b sjo;
  private com.tencent.mm.plugin.fingerprint.b.e sjp;
  private f sjq;
  
  static
  {
    AppMethodBeat.i(64216);
    com.tencent.mm.wallet_core.a.i("FingerprintAuth", com.tencent.mm.plugin.fingerprint.ui.a.class);
    AppMethodBeat.o(64216);
  }
  
  public a()
  {
    AppMethodBeat.i(64213);
    this.sjl = new n();
    this.sjm = new com.tencent.mm.plugin.fingerprint.b.i();
    this.sjn = new j();
    this.sjo = new b();
    this.sjp = new com.tencent.mm.plugin.fingerprint.b.e();
    this.sjq = new f();
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
    com.tencent.mm.sdk.b.a.GpY.c(this.sjl);
    com.tencent.mm.sdk.b.a.GpY.c(this.sjm);
    com.tencent.mm.sdk.b.a.GpY.c(this.sjn);
    com.tencent.mm.sdk.b.a.GpY.c(this.sjo);
    com.tencent.mm.sdk.b.a.GpY.c(this.sjp);
    com.tencent.mm.sdk.b.a.GpY.c(this.sjq);
    g.a(h.class, new com.tencent.mm.kernel.c.e(new q()));
    AppMethodBeat.o(64214);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(64215);
    com.tencent.mm.sdk.b.a.GpY.d(this.sjl);
    this.sjm.release();
    com.tencent.mm.sdk.b.a.GpY.d(this.sjm);
    com.tencent.mm.sdk.b.a.GpY.d(this.sjn);
    com.tencent.mm.sdk.b.a.GpY.d(this.sjo);
    com.tencent.mm.sdk.b.a.GpY.d(this.sjp);
    ((com.tencent.mm.plugin.fingerprint.b.a.i)g.ab(com.tencent.mm.plugin.fingerprint.b.a.i.class)).cancel();
    com.tencent.mm.sdk.b.a.GpY.d(this.sjq);
    g.ac(h.class);
    AppMethodBeat.o(64215);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.a
 * JD-Core Version:    0.7.0.1
 */