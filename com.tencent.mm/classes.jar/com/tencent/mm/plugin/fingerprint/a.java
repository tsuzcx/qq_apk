package com.tencent.mm.plugin.fingerprint;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.fingerprint.b.b;
import com.tencent.mm.plugin.fingerprint.b.f;
import com.tencent.mm.plugin.fingerprint.b.h;
import com.tencent.mm.plugin.fingerprint.b.j;
import com.tencent.mm.plugin.fingerprint.b.n;
import com.tencent.mm.plugin.fingerprint.b.q;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class a
  implements az
{
  private n tqG;
  private com.tencent.mm.plugin.fingerprint.b.i tqH;
  private j tqI;
  private b tqJ;
  private com.tencent.mm.plugin.fingerprint.b.e tqK;
  private f tqL;
  
  static
  {
    AppMethodBeat.i(64216);
    com.tencent.mm.wallet_core.a.i("FingerprintAuth", com.tencent.mm.plugin.fingerprint.ui.a.class);
    AppMethodBeat.o(64216);
  }
  
  public a()
  {
    AppMethodBeat.i(64213);
    this.tqG = new n();
    this.tqH = new com.tencent.mm.plugin.fingerprint.b.i();
    this.tqI = new j();
    this.tqJ = new b();
    this.tqK = new com.tencent.mm.plugin.fingerprint.b.e();
    this.tqL = new f();
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
    com.tencent.mm.sdk.b.a.IvT.c(this.tqG);
    com.tencent.mm.sdk.b.a.IvT.c(this.tqH);
    com.tencent.mm.sdk.b.a.IvT.c(this.tqI);
    com.tencent.mm.sdk.b.a.IvT.c(this.tqJ);
    com.tencent.mm.sdk.b.a.IvT.c(this.tqK);
    com.tencent.mm.sdk.b.a.IvT.c(this.tqL);
    g.a(h.class, new com.tencent.mm.kernel.c.e(new q()));
    AppMethodBeat.o(64214);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(64215);
    com.tencent.mm.sdk.b.a.IvT.d(this.tqG);
    this.tqH.release();
    com.tencent.mm.sdk.b.a.IvT.d(this.tqH);
    com.tencent.mm.sdk.b.a.IvT.d(this.tqI);
    com.tencent.mm.sdk.b.a.IvT.d(this.tqJ);
    com.tencent.mm.sdk.b.a.IvT.d(this.tqK);
    ((com.tencent.mm.plugin.fingerprint.b.a.i)g.ab(com.tencent.mm.plugin.fingerprint.b.a.i.class)).cancel();
    com.tencent.mm.sdk.b.a.IvT.d(this.tqL);
    g.ac(h.class);
    AppMethodBeat.o(64215);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.a
 * JD-Core Version:    0.7.0.1
 */