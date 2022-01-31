package com.tencent.mm.plugin.fingerprint;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.fingerprint.b.b;
import com.tencent.mm.plugin.fingerprint.b.c;
import com.tencent.mm.plugin.fingerprint.b.f;
import com.tencent.mm.plugin.fingerprint.b.i;
import com.tencent.mm.plugin.fingerprint.b.j;
import com.tencent.mm.plugin.fingerprint.b.k;
import com.tencent.mm.plugin.fingerprint.b.p;
import com.tencent.mm.plugin.fingerprint.b.r;
import java.util.HashMap;

public class a
  implements at
{
  private p mEY;
  private j mEZ;
  private k mFa;
  private b mFb;
  private f mFc;
  private com.tencent.mm.plugin.fingerprint.b.g mFd;
  private c mFe;
  
  static
  {
    AppMethodBeat.i(41353);
    com.tencent.mm.wallet_core.a.h("FingerprintAuth", com.tencent.mm.plugin.fingerprint.ui.a.class);
    AppMethodBeat.o(41353);
  }
  
  public a()
  {
    AppMethodBeat.i(41348);
    this.mEY = new p();
    this.mEZ = new j();
    this.mFa = new k();
    this.mFb = new b();
    this.mFc = new f();
    this.mFd = new com.tencent.mm.plugin.fingerprint.b.g();
    AppMethodBeat.o(41348);
  }
  
  public static a byD()
  {
    AppMethodBeat.i(41349);
    a locala = (a)q.S(a.class);
    AppMethodBeat.o(41349);
    return locala;
  }
  
  public static c byE()
  {
    AppMethodBeat.i(41352);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (byD().mFe == null) {
      byD().mFe = new c();
    }
    c localc = byD().mFe;
    AppMethodBeat.o(41352);
    return localc;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(41350);
    com.tencent.mm.sdk.b.a.ymk.c(this.mEY);
    com.tencent.mm.sdk.b.a.ymk.c(this.mEZ);
    com.tencent.mm.sdk.b.a.ymk.c(this.mFa);
    com.tencent.mm.sdk.b.a.ymk.c(this.mFb);
    com.tencent.mm.sdk.b.a.ymk.c(this.mFc);
    com.tencent.mm.sdk.b.a.ymk.c(this.mFd);
    com.tencent.mm.kernel.g.a(i.class, new e(new r()));
    AppMethodBeat.o(41350);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(41351);
    com.tencent.mm.sdk.b.a.ymk.d(this.mEY);
    this.mEZ.release();
    com.tencent.mm.sdk.b.a.ymk.d(this.mEZ);
    com.tencent.mm.sdk.b.a.ymk.d(this.mFa);
    com.tencent.mm.sdk.b.a.ymk.d(this.mFb);
    com.tencent.mm.sdk.b.a.ymk.d(this.mFc);
    if (this.mFe != null)
    {
      c.abort();
      c.release();
      this.mFe = null;
    }
    com.tencent.mm.sdk.b.a.ymk.d(this.mFd);
    com.tencent.mm.kernel.g.F(i.class);
    AppMethodBeat.o(41351);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.a
 * JD-Core Version:    0.7.0.1
 */