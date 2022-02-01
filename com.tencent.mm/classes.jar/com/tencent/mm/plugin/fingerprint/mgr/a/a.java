package com.tencent.mm.plugin.fingerprint.mgr.a;

import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fingerprint.mgr.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public abstract class a
  implements i
{
  public final boolean ftP()
  {
    return c.ftJ();
  }
  
  public final boolean ftQ()
  {
    return ((Boolean)h.baE().ban().get(at.a.acXc, Boolean.FALSE)).booleanValue();
  }
  
  public final void vA(boolean paramBoolean)
  {
    Log.i("MicroMsg.AbstractBiometricPayManager", "hy: set isOpenFp: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    c.vw(paramBoolean);
  }
  
  public final void vB(boolean paramBoolean)
  {
    Log.i("MicroMsg.AbstractBiometricPayManager", "set is open faceid: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    h.baE().ban().set(at.a.acXc, Boolean.valueOf(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.mgr.a.a
 * JD-Core Version:    0.7.0.1
 */