package com.tencent.mm.plugin.fingerprint.b.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ad;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.plugin.fingerprint.b.c;
import com.tencent.mm.plugin.report.service.h;
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
  
  public final boolean dJQ()
  {
    return false;
  }
  
  public final Map<String, String> dJY()
  {
    return null;
  }
  
  public final boolean dKp()
  {
    return false;
  }
  
  public final boolean dKq()
  {
    return false;
  }
  
  public final boolean dKr()
  {
    return false;
  }
  
  public final boolean dKs()
  {
    return false;
  }
  
  public final boolean dKt()
  {
    return false;
  }
  
  public final int dKu()
  {
    return 0;
  }
  
  public final com.tencent.mm.plugin.fingerprint.d.d dKv()
  {
    return null;
  }
  
  public final boolean dKw()
  {
    return false;
  }
  
  public final boolean fN(Context paramContext)
  {
    return false;
  }
  
  public final boolean fO(Context paramContext)
  {
    return false;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(64404);
    if ((com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fingerprint.d.a.class) == null)
    {
      c localc = new c();
      localc.a(this);
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.fingerprint.d.a.class, localc);
    }
    if ((ae.gKz.edB) && (com.tencent.mm.plugin.soter.e.b.flW()))
    {
      Log.i("MicroMsg.DummyBiometricPayManager", "maybe soter init fail, reinit");
      h.CyF.dN(1104, 42);
      com.tencent.mm.plugin.soter.e.b.a(true, new com.tencent.mm.plugin.soter.d.g()
      {
        public final void bg(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(64403);
          if (com.tencent.soter.a.a.hlC())
          {
            Log.i("MicroMsg.DummyBiometricPayManager", "init success: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
            paramAnonymousString = new j();
            paramAnonymousString.prepare();
            com.tencent.mm.kernel.g.b(i.class, paramAnonymousString);
            AppMethodBeat.o(64403);
            return;
          }
          Log.i("MicroMsg.DummyBiometricPayManager", "init failed: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          h.CyF.dN(1104, 43);
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