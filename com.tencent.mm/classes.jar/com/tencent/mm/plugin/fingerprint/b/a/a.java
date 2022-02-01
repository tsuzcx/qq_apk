package com.tencent.mm.plugin.fingerprint.b.a;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

public abstract class a
  implements i
{
  public final boolean cSs()
  {
    return d.cSm();
  }
  
  public final boolean cSt()
  {
    return ((Boolean)g.ajR().ajA().get(am.a.IYG, Boolean.FALSE)).booleanValue();
  }
  
  public final void mI(boolean paramBoolean)
  {
    ae.i("MicroMsg.AbstractBiometricPayManager", "hy: set isOpenFp: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    d.mE(paramBoolean);
  }
  
  public final void mJ(boolean paramBoolean)
  {
    ae.i("MicroMsg.AbstractBiometricPayManager", "set is open faceid: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    g.ajR().ajA().set(am.a.IYG, Boolean.valueOf(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.a.a
 * JD-Core Version:    0.7.0.1
 */