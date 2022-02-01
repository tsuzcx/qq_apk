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
  private n raR;
  private com.tencent.mm.plugin.fingerprint.b.i raS;
  private j raT;
  private b raU;
  private com.tencent.mm.plugin.fingerprint.b.e raV;
  private f raW;
  
  static
  {
    AppMethodBeat.i(64216);
    com.tencent.mm.wallet_core.a.i("FingerprintAuth", com.tencent.mm.plugin.fingerprint.ui.a.class);
    AppMethodBeat.o(64216);
  }
  
  public a()
  {
    AppMethodBeat.i(64213);
    this.raR = new n();
    this.raS = new com.tencent.mm.plugin.fingerprint.b.i();
    this.raT = new j();
    this.raU = new b();
    this.raV = new com.tencent.mm.plugin.fingerprint.b.e();
    this.raW = new f();
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
    com.tencent.mm.sdk.b.a.ESL.c(this.raR);
    com.tencent.mm.sdk.b.a.ESL.c(this.raS);
    com.tencent.mm.sdk.b.a.ESL.c(this.raT);
    com.tencent.mm.sdk.b.a.ESL.c(this.raU);
    com.tencent.mm.sdk.b.a.ESL.c(this.raV);
    com.tencent.mm.sdk.b.a.ESL.c(this.raW);
    g.a(h.class, new com.tencent.mm.kernel.c.e(new q()));
    AppMethodBeat.o(64214);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(64215);
    com.tencent.mm.sdk.b.a.ESL.d(this.raR);
    this.raS.release();
    com.tencent.mm.sdk.b.a.ESL.d(this.raS);
    com.tencent.mm.sdk.b.a.ESL.d(this.raT);
    com.tencent.mm.sdk.b.a.ESL.d(this.raU);
    com.tencent.mm.sdk.b.a.ESL.d(this.raV);
    ((com.tencent.mm.plugin.fingerprint.b.a.i)g.ab(com.tencent.mm.plugin.fingerprint.b.a.i.class)).cancel();
    com.tencent.mm.sdk.b.a.ESL.d(this.raW);
    g.ac(h.class);
    AppMethodBeat.o(64215);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.a
 * JD-Core Version:    0.7.0.1
 */