package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.t;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.g.a.ma.a;
import com.tencent.mm.g.a.ma.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public abstract class a
  implements l
{
  public final void a(ma paramma, int paramInt, String paramString)
  {
    ab.i("MicroMsg.BaseFingerprintImp", "hy: onOpenFingerprintAuthFailed");
    if ((paramma != null) && (paramma.cCa.cCe != null))
    {
      paramma.cCb = new ma.b();
      paramma.cCb.errCode = paramInt;
      paramma.cCb.cwl = "";
      paramma.cCb.cwm = "";
      paramma.cCb.errMsg = paramString;
      paramma.cCb.cCg = type();
      paramma.cCa.cCe.run();
    }
  }
  
  public final void byR()
  {
    ab.i("MicroMsg.BaseFingerprintImp", "showFingerPrintEntrance");
    if ((e.bzt()) && (!bzb())) {
      ab.e("MicroMsg.BaseFingerprintImp", "the fingerprint is open ready, but system has none Finger print ids!");
    }
    do
    {
      return;
      if ((byV()) && (!bzo()))
      {
        ab.e("MicroMsg.BaseFingerprintImp", "the faceid is open ready, but system has none face ids!");
        return;
      }
    } while (ac.ery.eqB == 1);
    ab.e("MicroMsg.BaseFingerprintImp", "hy: device info not support");
  }
  
  public final boolean byS()
  {
    return e.bzt();
  }
  
  public boolean byT()
  {
    return false;
  }
  
  public boolean byU()
  {
    return false;
  }
  
  public final boolean byV()
  {
    return ((Boolean)g.RL().Ru().get(ac.a.yKx, Boolean.FALSE)).booleanValue();
  }
  
  public String byW()
  {
    return "";
  }
  
  public final void hH(boolean paramBoolean)
  {
    ab.i("MicroMsg.BaseFingerprintImp", "hy: set isOpenFp: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    e.hJ(paramBoolean);
  }
  
  public final void hI(boolean paramBoolean)
  {
    ab.i("MicroMsg.BaseFingerprintImp", "set is open faceid: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    g.RL().Ru().set(ac.a.yKx, Boolean.valueOf(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.a
 * JD-Core Version:    0.7.0.1
 */