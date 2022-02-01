package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.t;
import com.tencent.mm.f.a.pt;
import com.tencent.mm.f.a.pt.a;
import com.tencent.mm.f.a.pt.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class a
  implements com.tencent.mm.plugin.fingerprint.d.a
{
  protected i BxU;
  
  public final void a(pt parampt, int paramInt, String paramString)
  {
    Log.i("MicroMsg.BaseFingerprintImp", "hy: onOpenFingerprintAuthFailed");
    if ((parampt != null) && (parampt.fOs.fOw != null))
    {
      parampt.fOt = new pt.b();
      parampt.fOt.errCode = paramInt;
      parampt.fOt.fHc = "";
      parampt.fOt.fHd = "";
      parampt.fOt.errMsg = paramString;
      parampt.fOt.fOy = type();
      parampt.fOs.fOw.run();
    }
  }
  
  public final void a(i parami)
  {
    this.BxU = parami;
  }
  
  public final void eom()
  {
    Log.i("MicroMsg.BaseFingerprintImp", "showFingerPrintEntrance");
    if ((eon()) && (!eot())) {
      Log.e("MicroMsg.BaseFingerprintImp", "the fingerprint is open ready, but system has none Finger print ids!");
    }
    do
    {
      return;
      if ((eoq()) && (!eoB()))
      {
        Log.e("MicroMsg.BaseFingerprintImp", "the faceid is open ready, but system has none face ids!");
        return;
      }
    } while (af.juL.jsW == 1);
    Log.e("MicroMsg.BaseFingerprintImp", "hy: device info not support");
  }
  
  public final boolean eon()
  {
    return ((i)h.ae(i.class)).eoM();
  }
  
  public boolean eoo()
  {
    return false;
  }
  
  public boolean eop()
  {
    return false;
  }
  
  public final boolean eoq()
  {
    return ((i)h.ae(i.class)).eoN();
  }
  
  public String eor()
  {
    return "";
  }
  
  public final void rD(boolean paramBoolean)
  {
    Log.i("MicroMsg.BaseFingerprintImp", "hy: set isOpenFp: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ((i)h.ae(i.class)).rJ(paramBoolean);
  }
  
  public final void rE(boolean paramBoolean)
  {
    Log.i("MicroMsg.BaseFingerprintImp", "set is open faceid: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    ((i)h.ae(i.class)).rK(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.a
 * JD-Core Version:    0.7.0.1
 */