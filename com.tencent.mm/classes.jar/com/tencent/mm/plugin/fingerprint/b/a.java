package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.t;
import com.tencent.mm.g.a.od;
import com.tencent.mm.g.a.od.a;
import com.tencent.mm.g.a.od.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class a
  implements com.tencent.mm.plugin.fingerprint.d.a
{
  protected i tgx;
  
  public final void a(od paramod, int paramInt, String paramString)
  {
    ad.i("MicroMsg.BaseFingerprintImp", "hy: onOpenFingerprintAuthFailed");
    if ((paramod != null) && (paramod.dBW.dCa != null))
    {
      paramod.dBX = new od.b();
      paramod.dBX.errCode = paramInt;
      paramod.dBX.dvf = "";
      paramod.dBX.dvg = "";
      paramod.dBX.errMsg = paramString;
      paramod.dBX.dCc = type();
      paramod.dBW.dCa.run();
    }
  }
  
  public final void a(i parami)
  {
    this.tgx = parami;
  }
  
  public final void cPn()
  {
    ad.i("MicroMsg.BaseFingerprintImp", "showFingerPrintEntrance");
    if ((cPo()) && (!cPu())) {
      ad.e("MicroMsg.BaseFingerprintImp", "the fingerprint is open ready, but system has none Finger print ids!");
    }
    do
    {
      return;
      if ((cPr()) && (!cPC()))
      {
        ad.e("MicroMsg.BaseFingerprintImp", "the faceid is open ready, but system has none face ids!");
        return;
      }
    } while (ae.gcI.gaY == 1);
    ad.e("MicroMsg.BaseFingerprintImp", "hy: device info not support");
  }
  
  public final boolean cPo()
  {
    return ((i)g.ab(i.class)).cPN();
  }
  
  public boolean cPp()
  {
    return false;
  }
  
  public boolean cPq()
  {
    return false;
  }
  
  public final boolean cPr()
  {
    return ((i)g.ab(i.class)).cPO();
  }
  
  public String cPs()
  {
    return "";
  }
  
  public final void my(boolean paramBoolean)
  {
    ad.i("MicroMsg.BaseFingerprintImp", "hy: set isOpenFp: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ((i)g.ab(i.class)).mE(paramBoolean);
  }
  
  public final void mz(boolean paramBoolean)
  {
    ad.i("MicroMsg.BaseFingerprintImp", "set is open faceid: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    ((i)g.ab(i.class)).mF(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.a
 * JD-Core Version:    0.7.0.1
 */