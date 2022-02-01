package com.tencent.mm.plugin.fingerprint.b.a;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

public abstract class a
  implements i
{
  public final boolean cum()
  {
    return d.cug();
  }
  
  public final boolean cun()
  {
    return ((Boolean)g.afB().afk().get(ae.a.FtI, Boolean.FALSE)).booleanValue();
  }
  
  public final void lv(boolean paramBoolean)
  {
    ad.i("MicroMsg.AbstractBiometricPayManager", "hy: set isOpenFp: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    d.lr(paramBoolean);
  }
  
  public final void lw(boolean paramBoolean)
  {
    ad.i("MicroMsg.AbstractBiometricPayManager", "set is open faceid: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    g.afB().afk().set(ae.a.FtI, Boolean.valueOf(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.a.a
 * JD-Core Version:    0.7.0.1
 */