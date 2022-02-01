package com.tencent.mm.plugin.fingerprint.b.a;

import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fingerprint.b.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public abstract class a
  implements i
{
  public final boolean eoM()
  {
    return d.eoG();
  }
  
  public final boolean eoN()
  {
    return ((Boolean)h.aHG().aHp().get(ar.a.Vvt, Boolean.FALSE)).booleanValue();
  }
  
  public final void rJ(boolean paramBoolean)
  {
    Log.i("MicroMsg.AbstractBiometricPayManager", "hy: set isOpenFp: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    d.rF(paramBoolean);
  }
  
  public final void rK(boolean paramBoolean)
  {
    Log.i("MicroMsg.AbstractBiometricPayManager", "set is open faceid: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    h.aHG().aHp().set(ar.a.Vvt, Boolean.valueOf(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.a.a
 * JD-Core Version:    0.7.0.1
 */