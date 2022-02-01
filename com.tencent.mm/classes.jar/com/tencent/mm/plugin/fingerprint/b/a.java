package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.t;
import com.tencent.mm.g.a.nv;
import com.tencent.mm.g.a.nv.a;
import com.tencent.mm.g.a.nv.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.sdk.platformtools.ac;

public abstract class a
  implements com.tencent.mm.plugin.fingerprint.d.a
{
  protected i sjV;
  
  public final void a(nv paramnv, int paramInt, String paramString)
  {
    ac.i("MicroMsg.BaseFingerprintImp", "hy: onOpenFingerprintAuthFailed");
    if ((paramnv != null) && (paramnv.dqj.dqn != null))
    {
      paramnv.dqk = new nv.b();
      paramnv.dqk.errCode = paramInt;
      paramnv.dqk.djs = "";
      paramnv.dqk.djt = "";
      paramnv.dqk.errMsg = paramString;
      paramnv.dqk.dqp = type();
      paramnv.dqj.dqn.run();
    }
  }
  
  public final void a(i parami)
  {
    this.sjV = parami;
  }
  
  public final void cGY()
  {
    ac.i("MicroMsg.BaseFingerprintImp", "showFingerPrintEntrance");
    if ((cGZ()) && (!cHf())) {
      ac.e("MicroMsg.BaseFingerprintImp", "the fingerprint is open ready, but system has none Finger print ids!");
    }
    do
    {
      return;
      if ((cHc()) && (!cHn()))
      {
        ac.e("MicroMsg.BaseFingerprintImp", "the faceid is open ready, but system has none face ids!");
        return;
      }
    } while (ae.fJh.fHy == 1);
    ac.e("MicroMsg.BaseFingerprintImp", "hy: device info not support");
  }
  
  public final boolean cGZ()
  {
    return ((i)g.ab(i.class)).cHy();
  }
  
  public boolean cHa()
  {
    return false;
  }
  
  public boolean cHb()
  {
    return false;
  }
  
  public final boolean cHc()
  {
    return ((i)g.ab(i.class)).cHz();
  }
  
  public String cHd()
  {
    return "";
  }
  
  public final void mh(boolean paramBoolean)
  {
    ac.i("MicroMsg.BaseFingerprintImp", "hy: set isOpenFp: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ((i)g.ab(i.class)).mn(paramBoolean);
  }
  
  public final void mi(boolean paramBoolean)
  {
    ac.i("MicroMsg.BaseFingerprintImp", "set is open faceid: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    ((i)g.ab(i.class)).mo(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.a
 * JD-Core Version:    0.7.0.1
 */