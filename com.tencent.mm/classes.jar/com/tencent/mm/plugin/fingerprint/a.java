package com.tencent.mm.plugin.fingerprint;

import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.fingerprint.b.b;
import com.tencent.mm.plugin.fingerprint.b.c;
import com.tencent.mm.plugin.fingerprint.b.d;
import com.tencent.mm.plugin.fingerprint.b.f;
import com.tencent.mm.plugin.fingerprint.b.i;
import com.tencent.mm.plugin.fingerprint.b.j;
import com.tencent.mm.plugin.fingerprint.b.l;
import com.tencent.mm.plugin.fingerprint.b.r;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public class a
  implements ar
{
  private com.tencent.mm.plugin.fingerprint.b.p kkk = new com.tencent.mm.plugin.fingerprint.b.p();
  private j kkl = new j();
  private com.tencent.mm.plugin.fingerprint.b.k kkm = new com.tencent.mm.plugin.fingerprint.b.k();
  private b kkn = new b();
  private f kko = new f();
  private com.tencent.mm.plugin.fingerprint.b.g kkp = new com.tencent.mm.plugin.fingerprint.b.g();
  private c kkq;
  
  static
  {
    com.tencent.mm.wallet_core.a.i("FingerprintAuth", com.tencent.mm.plugin.fingerprint.ui.a.class);
  }
  
  public static a aSf()
  {
    return (a)com.tencent.mm.model.p.B(a.class);
  }
  
  public static c aSg()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (aSf().kkq == null) {
      aSf().kkq = new c();
    }
    return aSf().kkq;
  }
  
  private static void aSh()
  {
    if (com.tencent.soter.a.a.cPw()) {}
    for (Object localObject = new l();; localObject = new d())
    {
      ((com.tencent.mm.pluginsdk.k)localObject).aSH();
      com.tencent.mm.kernel.g.a(com.tencent.mm.pluginsdk.k.class, (com.tencent.mm.kernel.c.a)localObject);
      return;
    }
  }
  
  public final void bh(boolean paramBoolean)
  {
    y.i("MicroMsg.SubCoreFingerPrint", "alvinluo SoterWrapperApi isInit: %b in SubCoreFingerprint initTA", new Object[] { Boolean.valueOf(com.tencent.soter.a.c.a.cPy().isInit()) });
    if (!com.tencent.soter.a.c.a.cPy().isInit())
    {
      y.i("MicroMsg.SubCoreFingerPrint", "alvinluo soter is not initialized, do init");
      com.tencent.mm.kernel.g.a(com.tencent.mm.pluginsdk.k.class, new d());
      com.tencent.mm.kernel.g.DS().k(new a.1(this), 1500L);
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.udP.c(this.kkk);
      com.tencent.mm.sdk.b.a.udP.c(this.kkl);
      com.tencent.mm.sdk.b.a.udP.c(this.kkm);
      com.tencent.mm.sdk.b.a.udP.c(this.kkn);
      com.tencent.mm.sdk.b.a.udP.c(this.kko);
      com.tencent.mm.sdk.b.a.udP.c(this.kkp);
      com.tencent.mm.kernel.g.a(i.class, new e(new r()));
      return;
      aSh();
    }
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.kkk);
    this.kkl.release();
    com.tencent.mm.sdk.b.a.udP.d(this.kkl);
    com.tencent.mm.sdk.b.a.udP.d(this.kkm);
    com.tencent.mm.sdk.b.a.udP.d(this.kkn);
    com.tencent.mm.sdk.b.a.udP.d(this.kko);
    if (this.kkq != null)
    {
      c.abort();
      c.release();
      this.kkq = null;
    }
    com.tencent.mm.sdk.b.a.udP.d(this.kkp);
    com.tencent.mm.kernel.g.s(i.class);
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.a
 * JD-Core Version:    0.7.0.1
 */