package com.tencent.mm.plugin.fingerprint.b.a;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

public abstract class a
  implements i
{
  public final boolean cHy()
  {
    return d.cHs();
  }
  
  public final boolean cHz()
  {
    return ((Boolean)g.agR().agA().get(ah.a.GRC, Boolean.FALSE)).booleanValue();
  }
  
  public final void mn(boolean paramBoolean)
  {
    ac.i("MicroMsg.AbstractBiometricPayManager", "hy: set isOpenFp: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    d.mj(paramBoolean);
  }
  
  public final void mo(boolean paramBoolean)
  {
    ac.i("MicroMsg.AbstractBiometricPayManager", "set is open faceid: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    g.agR().agA().set(ah.a.GRC, Boolean.valueOf(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.a.a
 * JD-Core Version:    0.7.0.1
 */