package com.tencent.mm.plugin.fingerprint.b.a;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public abstract class a
  implements i
{
  public final boolean dKn()
  {
    return d.dKh();
  }
  
  public final boolean dKo()
  {
    return ((Boolean)g.aAh().azQ().get(ar.a.Ohd, Boolean.FALSE)).booleanValue();
  }
  
  public final void pp(boolean paramBoolean)
  {
    Log.i("MicroMsg.AbstractBiometricPayManager", "hy: set isOpenFp: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    d.pl(paramBoolean);
  }
  
  public final void pq(boolean paramBoolean)
  {
    Log.i("MicroMsg.AbstractBiometricPayManager", "set is open faceid: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    g.aAh().azQ().set(ar.a.Ohd, Boolean.valueOf(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.a.a
 * JD-Core Version:    0.7.0.1
 */