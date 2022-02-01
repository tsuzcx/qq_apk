package com.tencent.mm.plugin.fingerprint.b.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.plugin.fingerprint.b.c;
import java.util.Map;

public final class g
  extends a
{
  public final void a(Context paramContext, f paramf, b paramb) {}
  
  public final void a(Context paramContext, f paramf, d paramd) {}
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Bundle paramBundle) {}
  
  public final void b(Context paramContext, f paramf, b paramb) {}
  
  public final boolean cPP()
  {
    return false;
  }
  
  public final boolean cPQ()
  {
    return false;
  }
  
  public final boolean cPR()
  {
    return false;
  }
  
  public final boolean cPS()
  {
    return false;
  }
  
  public final boolean cPT()
  {
    return false;
  }
  
  public final int cPU()
  {
    return 0;
  }
  
  public final com.tencent.mm.plugin.fingerprint.d.d cPV()
  {
    return null;
  }
  
  public final boolean cPW()
  {
    return false;
  }
  
  public final boolean cPq()
  {
    return false;
  }
  
  public final Map<String, String> cPy()
  {
    return null;
  }
  
  public final void cancel() {}
  
  public final boolean fe(Context paramContext)
  {
    return false;
  }
  
  public final boolean ff(Context paramContext)
  {
    return false;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(64404);
    if ((com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class) == null)
    {
      c localc = new c();
      localc.a(this);
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.fingerprint.d.a.class, localc);
    }
    if ((ae.gcK.dKx) && (com.tencent.mm.plugin.soter.e.b.efO()))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DummyBiometricPayManager", "maybe soter init fail, reinit");
      com.tencent.mm.plugin.report.service.g.yhR.dD(1104, 42);
      com.tencent.mm.plugin.soter.e.b.a(true, new com.tencent.mm.plugin.soter.d.g()
      {
        public final void bc(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(64403);
          if (com.tencent.soter.a.a.fUS())
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DummyBiometricPayManager", "init success: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
            paramAnonymousString = new j();
            paramAnonymousString.prepare();
            com.tencent.mm.kernel.g.b(i.class, paramAnonymousString);
            AppMethodBeat.o(64403);
            return;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DummyBiometricPayManager", "init failed: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          com.tencent.mm.plugin.report.service.g.yhR.dD(1104, 43);
          AppMethodBeat.o(64403);
        }
      });
    }
    AppMethodBeat.o(64404);
  }
  
  public final void r(Object... paramVarArgs) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.a.g
 * JD-Core Version:    0.7.0.1
 */