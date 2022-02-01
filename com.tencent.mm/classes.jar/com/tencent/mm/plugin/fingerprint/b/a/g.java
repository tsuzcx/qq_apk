package com.tencent.mm.plugin.fingerprint.b.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.plugin.fingerprint.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

public final class g
  extends a
{
  public final void a(Context paramContext, f paramf, b paramb) {}
  
  public final void a(Context paramContext, f paramf, d paramd) {}
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Bundle paramBundle) {}
  
  public final void b(Context paramContext, f paramf, b paramb) {}
  
  public final void cancel() {}
  
  public final boolean eoP()
  {
    return false;
  }
  
  public final boolean eoQ()
  {
    return false;
  }
  
  public final boolean eoR()
  {
    return false;
  }
  
  public final boolean eoS()
  {
    return false;
  }
  
  public final int eoT()
  {
    return 0;
  }
  
  public final com.tencent.mm.plugin.fingerprint.d.d eoU()
  {
    return null;
  }
  
  public final boolean eoV()
  {
    return false;
  }
  
  public final boolean eop()
  {
    return false;
  }
  
  public final Map<String, String> eox()
  {
    return null;
  }
  
  public final boolean gh(Context paramContext)
  {
    return false;
  }
  
  public final boolean gi(Context paramContext)
  {
    return false;
  }
  
  public final boolean isSupport()
  {
    return false;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(64404);
    if ((com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.d.a.class) == null)
    {
      c localc = new c();
      localc.a(this);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.fingerprint.d.a.class, localc);
    }
    if ((af.juN.fXK) && (com.tencent.mm.plugin.soter.e.b.gas()))
    {
      Log.i("MicroMsg.DummyBiometricPayManager", "maybe soter init fail, reinit");
      com.tencent.mm.plugin.report.service.h.IzE.el(1104, 42);
      com.tencent.mm.plugin.soter.e.b.a(true, new com.tencent.mm.plugin.soter.d.g()
      {
        public final void bh(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(64403);
          if (com.tencent.soter.a.a.ipb())
          {
            Log.i("MicroMsg.DummyBiometricPayManager", "init success: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
            paramAnonymousString = new j();
            paramAnonymousString.prepare();
            com.tencent.mm.kernel.h.b(i.class, paramAnonymousString);
            AppMethodBeat.o(64403);
            return;
          }
          Log.i("MicroMsg.DummyBiometricPayManager", "init failed: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          com.tencent.mm.plugin.report.service.h.IzE.el(1104, 43);
          AppMethodBeat.o(64403);
        }
      });
    }
    AppMethodBeat.o(64404);
  }
  
  public final void q(Object... paramVarArgs) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.a.g
 * JD-Core Version:    0.7.0.1
 */