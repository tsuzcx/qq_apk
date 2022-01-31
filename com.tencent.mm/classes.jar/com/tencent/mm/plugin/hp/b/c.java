package com.tencent.mm.plugin.hp.b;

import android.util.Base64;
import com.tencent.mm.h.a.ij;
import com.tencent.mm.h.a.ij.a;
import com.tencent.mm.plugin.hp.d.a;
import com.tencent.mm.plugin.hp.tinker.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  extends com.tencent.mm.sdk.b.c<ij>
  implements com.tencent.mm.sdk.f.c
{
  private static final String erZ = com.tencent.mm.compatible.util.e.dOP + "_temp.hp";
  private a lmM = null;
  
  public c()
  {
    com.tencent.mm.sdk.f.e.a(this);
    this.udX = ij.class.getName().hashCode();
  }
  
  public static void Fr(String paramString)
  {
    y.w("Tinker.HotPatchApplyService", "hp_apply from file %s", new Object[] { paramString });
    d.Fs(paramString);
  }
  
  private boolean a(ij paramij)
  {
    if (this.lmM != null) {
      y.e("Tinker.HotPatchApplyService", "hp_apply processing busy, ignore new event");
    }
    for (;;)
    {
      return false;
      if (1 == paramij.bQz.bHz)
      {
        d.bbj();
        return false;
      }
      if (paramij.bQz.bQE != null)
      {
        Fr(paramij.bQz.bQE);
        return false;
      }
      b.sv(1);
      if (paramij.bQz.bQC != null) {}
      try
      {
        byte[] arrayOfByte = Base64.decode(paramij.bQz.bQC, 0);
        paramij.bQz.bQC = new String(arrayOfByte);
        label95:
        if ((!bk.bl(paramij.bQz.bQC)) && (!bk.bl(paramij.bQz.bQD)))
        {
          y.i("Tinker.HotPatchApplyService", "hp_apply request url=%s, signature=%s", new Object[] { paramij.bQz.bQC, paramij.bQz.bQD });
          this.lmM = new a(paramij.bQz.bQC, erZ, paramij.bQz.bQD);
        }
        do
        {
          com.tencent.mm.sdk.f.e.post(this.lmM, "hp_apply_download");
          return false;
          if (bk.bl(paramij.bQz.bQA)) {
            break;
          }
        } while (!bk.bl(paramij.bQz.bQB));
        return false;
      }
      catch (Error localError)
      {
        break label95;
      }
    }
  }
  
  public final void A(Runnable paramRunnable)
  {
    if (paramRunnable == this.lmM)
    {
      y.d("Tinker.HotPatchApplyService", "hp_apply download url=%s, file=%s, failed=%b", new Object[] { this.lmM.url, this.lmM.eRT, Boolean.valueOf(this.lmM.ebE) });
      if (this.lmM.ebE) {
        break label82;
      }
      b.sw(1);
      Fr(this.lmM.eRT);
    }
    for (;;)
    {
      this.lmM = null;
      return;
      label82:
      b.sx(1);
    }
  }
  
  public final void z(Runnable paramRunnable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.c
 * JD-Core Version:    0.7.0.1
 */