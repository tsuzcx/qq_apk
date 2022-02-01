package com.tencent.mm.plugin.fingerprint.b.a;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public abstract class a
  implements i
{
  public final boolean cPN()
  {
    return d.cPH();
  }
  
  public final boolean cPO()
  {
    return ((Boolean)g.ajC().ajl().get(al.a.IEg, Boolean.FALSE)).booleanValue();
  }
  
  public final void mE(boolean paramBoolean)
  {
    ad.i("MicroMsg.AbstractBiometricPayManager", "hy: set isOpenFp: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    d.mA(paramBoolean);
  }
  
  public final void mF(boolean paramBoolean)
  {
    ad.i("MicroMsg.AbstractBiometricPayManager", "set is open faceid: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    g.ajC().ajl().set(al.a.IEg, Boolean.valueOf(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.a.a
 * JD-Core Version:    0.7.0.1
 */