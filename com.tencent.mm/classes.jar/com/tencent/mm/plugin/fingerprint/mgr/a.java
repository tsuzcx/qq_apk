package com.tencent.mm.plugin.fingerprint.mgr;

import com.tencent.mm.autogen.a.rg;
import com.tencent.mm.autogen.a.rg.a;
import com.tencent.mm.autogen.a.rg.b;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fingerprint.mgr.a.i;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class a
  implements com.tencent.mm.plugin.fingerprint.c.a
{
  protected i Hfx;
  
  public final void a(rg paramrg, int paramInt, String paramString)
  {
    Log.i("MicroMsg.BaseFingerprintImp", "hy: onOpenFingerprintAuthFailed");
    if ((paramrg != null) && (paramrg.hUl.hUp != null))
    {
      paramrg.hUm = new rg.b();
      paramrg.hUm.errCode = paramInt;
      paramrg.hUm.hMz = "";
      paramrg.hUm.hMA = "";
      paramrg.hUm.errMsg = paramString;
      paramrg.hUm.hUr = type();
      paramrg.hUl.hUp.run();
    }
  }
  
  public final void a(i parami)
  {
    this.Hfx = parami;
  }
  
  public final void ftp()
  {
    Log.i("MicroMsg.BaseFingerprintImp", "showFingerPrintEntrance");
    if ((ftq()) && (!ftw())) {
      Log.e("MicroMsg.BaseFingerprintImp", "the fingerprint is open ready, but system has none Finger print ids!");
    }
    do
    {
      return;
      if ((ftt()) && (!ftE()))
      {
        Log.e("MicroMsg.BaseFingerprintImp", "the faceid is open ready, but system has none face ids!");
        return;
      }
    } while (af.lYc.lWo == 1);
    Log.e("MicroMsg.BaseFingerprintImp", "hy: device info not support");
  }
  
  public final boolean ftq()
  {
    return ((i)h.ax(i.class)).ftP();
  }
  
  public boolean ftr()
  {
    return false;
  }
  
  public boolean fts()
  {
    return false;
  }
  
  public final boolean ftt()
  {
    return ((i)h.ax(i.class)).ftQ();
  }
  
  public String ftu()
  {
    return "";
  }
  
  public final void vu(boolean paramBoolean)
  {
    Log.i("MicroMsg.BaseFingerprintImp", "hy: set isOpenFp: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ((i)h.ax(i.class)).vA(paramBoolean);
  }
  
  public final void vv(boolean paramBoolean)
  {
    Log.i("MicroMsg.BaseFingerprintImp", "set is open faceid: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    ((i)h.ax(i.class)).vB(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.mgr.a
 * JD-Core Version:    0.7.0.1
 */