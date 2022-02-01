package com.tencent.mm.plugin.fingerprint.b.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.plugin.fingerprint.b.c;
import com.tencent.mm.plugin.report.service.h;
import java.util.Map;

public final class g
  extends a
{
  public final void a(Context paramContext, f paramf, b paramb) {}
  
  public final void a(Context paramContext, f paramf, d paramd) {}
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Bundle paramBundle) {}
  
  public final void b(Context paramContext, f paramf, b paramb) {}
  
  public final void cancel() {}
  
  public final boolean ctP()
  {
    return false;
  }
  
  public final Map<String, String> ctX()
  {
    return null;
  }
  
  public final boolean cuo()
  {
    return false;
  }
  
  public final boolean cup()
  {
    return false;
  }
  
  public final boolean cuq()
  {
    return false;
  }
  
  public final boolean cur()
  {
    return false;
  }
  
  public final boolean cus()
  {
    return false;
  }
  
  public final int cut()
  {
    return 0;
  }
  
  public final com.tencent.mm.plugin.fingerprint.d.d cuu()
  {
    return null;
  }
  
  public final boolean cuv()
  {
    return false;
  }
  
  public final boolean eO(Context paramContext)
  {
    return false;
  }
  
  public final boolean eP(Context paramContext)
  {
    return false;
  }
  
  public final void p(Object... paramVarArgs) {}
  
  public final void prepare()
  {
    AppMethodBeat.i(64404);
    if ((com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class) == null)
    {
      c localc = new c();
      localc.a(this);
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.fingerprint.d.a.class, localc);
    }
    if ((ae.fFC.dAy) && (com.tencent.mm.plugin.soter.e.b.dEZ()))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DummyBiometricPayManager", "maybe soter init fail, reinit");
      h.vKh.dB(1104, 42);
      com.tencent.mm.plugin.soter.e.b.a(true, new g.1(this));
    }
    AppMethodBeat.o(64404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.a.g
 * JD-Core Version:    0.7.0.1
 */