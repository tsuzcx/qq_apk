package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.t;
import com.tencent.mm.g.a.nm;
import com.tencent.mm.g.a.nm.a;
import com.tencent.mm.g.a.nm.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class a
  implements com.tencent.mm.plugin.fingerprint.d.a
{
  protected i rbB;
  
  public final void a(nm paramnm, int paramInt, String paramString)
  {
    ad.i("MicroMsg.BaseFingerprintImp", "hy: onOpenFingerprintAuthFailed");
    if ((paramnm != null) && (paramnm.dsz.dsD != null))
    {
      paramnm.dsA = new nm.b();
      paramnm.dsA.errCode = paramInt;
      paramnm.dsA.dlK = "";
      paramnm.dsA.dlL = "";
      paramnm.dsA.errMsg = paramString;
      paramnm.dsA.dsF = type();
      paramnm.dsz.dsD.run();
    }
  }
  
  public final void a(i parami)
  {
    this.rbB = parami;
  }
  
  public final void ctM()
  {
    ad.i("MicroMsg.BaseFingerprintImp", "showFingerPrintEntrance");
    if ((ctN()) && (!ctT())) {
      ad.e("MicroMsg.BaseFingerprintImp", "the fingerprint is open ready, but system has none Finger print ids!");
    }
    do
    {
      return;
      if ((ctQ()) && (!cub()))
      {
        ad.e("MicroMsg.BaseFingerprintImp", "the faceid is open ready, but system has none face ids!");
        return;
      }
    } while (ae.fFA.fDR == 1);
    ad.e("MicroMsg.BaseFingerprintImp", "hy: device info not support");
  }
  
  public final boolean ctN()
  {
    return ((i)g.ab(i.class)).cum();
  }
  
  public boolean ctO()
  {
    return false;
  }
  
  public boolean ctP()
  {
    return false;
  }
  
  public final boolean ctQ()
  {
    return ((i)g.ab(i.class)).cun();
  }
  
  public String ctR()
  {
    return "";
  }
  
  public final void lp(boolean paramBoolean)
  {
    ad.i("MicroMsg.BaseFingerprintImp", "hy: set isOpenFp: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ((i)g.ab(i.class)).lv(paramBoolean);
  }
  
  public final void lq(boolean paramBoolean)
  {
    ad.i("MicroMsg.BaseFingerprintImp", "set is open faceid: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    ((i)g.ab(i.class)).lw(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.a
 * JD-Core Version:    0.7.0.1
 */