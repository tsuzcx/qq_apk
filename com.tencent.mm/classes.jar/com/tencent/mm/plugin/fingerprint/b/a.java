package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.compatible.deviceinfo.t;
import com.tencent.mm.g.a.oe;
import com.tencent.mm.g.a.oe.a;
import com.tencent.mm.g.a.oe.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.a.i;

public abstract class a
  implements com.tencent.mm.plugin.fingerprint.d.a
{
  protected i trq;
  
  public final void a(oe paramoe, int paramInt, String paramString)
  {
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BaseFingerprintImp", "hy: onOpenFingerprintAuthFailed");
    if ((paramoe != null) && (paramoe.dDb.dDf != null))
    {
      paramoe.dDc = new oe.b();
      paramoe.dDc.errCode = paramInt;
      paramoe.dDc.dwk = "";
      paramoe.dDc.dwl = "";
      paramoe.dDc.errMsg = paramString;
      paramoe.dDc.dDh = type();
      paramoe.dDb.dDf.run();
    }
  }
  
  public final void a(i parami)
  {
    this.trq = parami;
  }
  
  public final void cRS()
  {
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BaseFingerprintImp", "showFingerPrintEntrance");
    if ((cRT()) && (!cRZ())) {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.BaseFingerprintImp", "the fingerprint is open ready, but system has none Finger print ids!");
    }
    do
    {
      return;
      if ((cRW()) && (!cSh()))
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.BaseFingerprintImp", "the faceid is open ready, but system has none face ids!");
        return;
      }
    } while (com.tencent.mm.compatible.deviceinfo.ae.geQ.gdg == 1);
    com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.BaseFingerprintImp", "hy: device info not support");
  }
  
  public final boolean cRT()
  {
    return ((i)g.ab(i.class)).cSs();
  }
  
  public boolean cRU()
  {
    return false;
  }
  
  public boolean cRV()
  {
    return false;
  }
  
  public final boolean cRW()
  {
    return ((i)g.ab(i.class)).cSt();
  }
  
  public String cRX()
  {
    return "";
  }
  
  public final void mC(boolean paramBoolean)
  {
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BaseFingerprintImp", "hy: set isOpenFp: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ((i)g.ab(i.class)).mI(paramBoolean);
  }
  
  public final void mD(boolean paramBoolean)
  {
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BaseFingerprintImp", "set is open faceid: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    ((i)g.ab(i.class)).mJ(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.a
 * JD-Core Version:    0.7.0.1
 */