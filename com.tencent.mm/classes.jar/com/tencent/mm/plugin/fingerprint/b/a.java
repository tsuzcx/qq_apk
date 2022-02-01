package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.t;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.g.a.ow.a;
import com.tencent.mm.g.a.ow.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class a
  implements com.tencent.mm.plugin.fingerprint.d.a
{
  protected i wEX;
  
  public final void a(ow paramow, int paramInt, String paramString)
  {
    Log.i("MicroMsg.BaseFingerprintImp", "hy: onOpenFingerprintAuthFailed");
    if ((paramow != null) && (paramow.dUQ.dUU != null))
    {
      paramow.dUR = new ow.b();
      paramow.dUR.errCode = paramInt;
      paramow.dUR.dNR = "";
      paramow.dUR.dNS = "";
      paramow.dUR.errMsg = paramString;
      paramow.dUR.dUW = type();
      paramow.dUQ.dUU.run();
    }
  }
  
  public final void a(i parami)
  {
    this.wEX = parami;
  }
  
  public final void dJN()
  {
    Log.i("MicroMsg.BaseFingerprintImp", "showFingerPrintEntrance");
    if ((dJO()) && (!dJU())) {
      Log.e("MicroMsg.BaseFingerprintImp", "the fingerprint is open ready, but system has none Finger print ids!");
    }
    do
    {
      return;
      if ((dJR()) && (!dKc()))
      {
        Log.e("MicroMsg.BaseFingerprintImp", "the faceid is open ready, but system has none face ids!");
        return;
      }
    } while (ae.gKx.gIE == 1);
    Log.e("MicroMsg.BaseFingerprintImp", "hy: device info not support");
  }
  
  public final boolean dJO()
  {
    return ((i)g.af(i.class)).dKn();
  }
  
  public boolean dJP()
  {
    return false;
  }
  
  public boolean dJQ()
  {
    return false;
  }
  
  public final boolean dJR()
  {
    return ((i)g.af(i.class)).dKo();
  }
  
  public String dJS()
  {
    return "";
  }
  
  public final void pj(boolean paramBoolean)
  {
    Log.i("MicroMsg.BaseFingerprintImp", "hy: set isOpenFp: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ((i)g.af(i.class)).pp(paramBoolean);
  }
  
  public final void pk(boolean paramBoolean)
  {
    Log.i("MicroMsg.BaseFingerprintImp", "set is open faceid: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    ((i)g.af(i.class)).pq(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.a
 * JD-Core Version:    0.7.0.1
 */