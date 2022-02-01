package com.tencent.mm.plugin.fingerprint.b.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ad;
import com.tencent.mm.plugin.fingerprint.b.c;
import java.util.Map;

public final class g
  extends a
{
  public final void a(Context paramContext, f paramf, b paramb) {}
  
  public final void a(Context paramContext, f paramf, d paramd) {}
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Bundle paramBundle) {}
  
  public final void b(Context paramContext, f paramf, b paramb) {}
  
  public final boolean cRV()
  {
    return false;
  }
  
  public final com.tencent.mm.plugin.fingerprint.d.d cSA()
  {
    return null;
  }
  
  public final boolean cSB()
  {
    return false;
  }
  
  public final Map<String, String> cSd()
  {
    return null;
  }
  
  public final boolean cSu()
  {
    return false;
  }
  
  public final boolean cSv()
  {
    return false;
  }
  
  public final boolean cSw()
  {
    return false;
  }
  
  public final boolean cSx()
  {
    return false;
  }
  
  public final boolean cSy()
  {
    return false;
  }
  
  public final int cSz()
  {
    return 0;
  }
  
  public final void cancel() {}
  
  public final boolean fi(Context paramContext)
  {
    return false;
  }
  
  public final boolean fj(Context paramContext)
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
    if ((com.tencent.mm.compatible.deviceinfo.ae.geS.dLM) && (com.tencent.mm.plugin.soter.e.b.ejw()))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.DummyBiometricPayManager", "maybe soter init fail, reinit");
      com.tencent.mm.plugin.report.service.g.yxI.dD(1104, 42);
      com.tencent.mm.plugin.soter.e.b.a(true, new com.tencent.mm.plugin.soter.d.g()
      {
        public final void bb(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(64403);
          if (com.tencent.soter.a.a.fZr())
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.DummyBiometricPayManager", "init success: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
            paramAnonymousString = new j();
            paramAnonymousString.prepare();
            com.tencent.mm.kernel.g.b(i.class, paramAnonymousString);
            AppMethodBeat.o(64403);
            return;
          }
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.DummyBiometricPayManager", "init failed: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          com.tencent.mm.plugin.report.service.g.yxI.dD(1104, 43);
          AppMethodBeat.o(64403);
        }
      });
    }
    AppMethodBeat.o(64404);
  }
  
  public final void q(Object... paramVarArgs) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.a.g
 * JD-Core Version:    0.7.0.1
 */