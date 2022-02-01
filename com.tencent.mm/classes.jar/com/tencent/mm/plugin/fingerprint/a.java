package com.tencent.mm.plugin.fingerprint;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.plugin.fingerprint.b.b;
import com.tencent.mm.plugin.fingerprint.b.f;
import com.tencent.mm.plugin.fingerprint.b.h;
import com.tencent.mm.plugin.fingerprint.b.j;
import com.tencent.mm.plugin.fingerprint.b.n;
import com.tencent.mm.plugin.fingerprint.b.q;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class a
  implements ax
{
  private n tfN;
  private com.tencent.mm.plugin.fingerprint.b.i tfO;
  private j tfP;
  private b tfQ;
  private com.tencent.mm.plugin.fingerprint.b.e tfR;
  private f tfS;
  
  static
  {
    AppMethodBeat.i(64216);
    com.tencent.mm.wallet_core.a.i("FingerprintAuth", com.tencent.mm.plugin.fingerprint.ui.a.class);
    AppMethodBeat.o(64216);
  }
  
  public a()
  {
    AppMethodBeat.i(64213);
    this.tfN = new n();
    this.tfO = new com.tencent.mm.plugin.fingerprint.b.i();
    this.tfP = new j();
    this.tfQ = new b();
    this.tfR = new com.tencent.mm.plugin.fingerprint.b.e();
    this.tfS = new f();
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
    com.tencent.mm.sdk.b.a.IbL.c(this.tfN);
    com.tencent.mm.sdk.b.a.IbL.c(this.tfO);
    com.tencent.mm.sdk.b.a.IbL.c(this.tfP);
    com.tencent.mm.sdk.b.a.IbL.c(this.tfQ);
    com.tencent.mm.sdk.b.a.IbL.c(this.tfR);
    com.tencent.mm.sdk.b.a.IbL.c(this.tfS);
    g.a(h.class, new com.tencent.mm.kernel.c.e(new q()));
    AppMethodBeat.o(64214);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(64215);
    com.tencent.mm.sdk.b.a.IbL.d(this.tfN);
    this.tfO.release();
    com.tencent.mm.sdk.b.a.IbL.d(this.tfO);
    com.tencent.mm.sdk.b.a.IbL.d(this.tfP);
    com.tencent.mm.sdk.b.a.IbL.d(this.tfQ);
    com.tencent.mm.sdk.b.a.IbL.d(this.tfR);
    ((com.tencent.mm.plugin.fingerprint.b.a.i)g.ab(com.tencent.mm.plugin.fingerprint.b.a.i.class)).cancel();
    com.tencent.mm.sdk.b.a.IbL.d(this.tfS);
    g.ac(h.class);
    AppMethodBeat.o(64215);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.a
 * JD-Core Version:    0.7.0.1
 */