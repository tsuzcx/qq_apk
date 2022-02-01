package com.tencent.mm.plugin.fingerprint.mgr.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.af;
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
  
  public final Map<String, String> ftA()
  {
    return null;
  }
  
  public final boolean ftR()
  {
    return false;
  }
  
  public final boolean ftS()
  {
    return false;
  }
  
  public final boolean ftT()
  {
    return false;
  }
  
  public final boolean ftU()
  {
    return false;
  }
  
  public final int ftV()
  {
    return 0;
  }
  
  public final com.tencent.mm.plugin.fingerprint.c.d ftW()
  {
    return null;
  }
  
  public final boolean ftX()
  {
    return false;
  }
  
  public final boolean fts()
  {
    return false;
  }
  
  public final boolean hC(Context paramContext)
  {
    return false;
  }
  
  public final boolean hD(Context paramContext)
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
    if ((com.tencent.mm.plugin.fingerprint.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.c.a.class) == null)
    {
      com.tencent.mm.plugin.fingerprint.mgr.b localb = new com.tencent.mm.plugin.fingerprint.mgr.b();
      localb.a(this);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.fingerprint.c.a.class, localb);
    }
    if ((af.lYe.idL) && (com.tencent.mm.plugin.soter.d.b.htJ()))
    {
      Log.i("MicroMsg.DummyBiometricPayManager", "maybe soter init fail, reinit");
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1104, 42);
      com.tencent.mm.plugin.soter.d.b.a(true, new com.tencent.mm.plugin.soter.model.d()
      {
        public final void bL(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(64403);
          if (com.tencent.soter.a.a.jYp())
          {
            Log.i("MicroMsg.DummyBiometricPayManager", "init success: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
            paramAnonymousString = new j();
            paramAnonymousString.prepare();
            com.tencent.mm.kernel.h.b(i.class, paramAnonymousString);
            AppMethodBeat.o(64403);
            return;
          }
          Log.i("MicroMsg.DummyBiometricPayManager", "init failed: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1104, 43);
          AppMethodBeat.o(64403);
        }
      });
    }
    AppMethodBeat.o(64404);
  }
  
  public final void s(Object... paramVarArgs) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.mgr.a.g
 * JD-Core Version:    0.7.0.1
 */