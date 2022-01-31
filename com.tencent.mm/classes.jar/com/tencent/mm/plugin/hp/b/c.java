package com.tencent.mm.plugin.hp.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.iq;
import com.tencent.mm.g.a.iq.a;
import com.tencent.mm.plugin.hp.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class c
  extends com.tencent.mm.sdk.b.c<iq>
  implements com.tencent.mm.sdk.g.a.d
{
  private static final String eQS;
  private a nKe;
  
  static
  {
    AppMethodBeat.i(90583);
    eQS = com.tencent.mm.compatible.util.e.eQv + "_temp.hp";
    AppMethodBeat.o(90583);
  }
  
  public c()
  {
    AppMethodBeat.i(90578);
    this.nKe = null;
    this.__eventId = iq.class.getName().hashCode();
    AppMethodBeat.o(90578);
  }
  
  public static void QO(String paramString)
  {
    AppMethodBeat.i(90579);
    ab.w("Tinker.HotPatchApplyService", "hp_apply from file %s", new Object[] { paramString });
    com.tencent.mm.plugin.hp.tinker.e.QQ(paramString);
    AppMethodBeat.o(90579);
  }
  
  private boolean a(iq paramiq)
  {
    AppMethodBeat.i(90581);
    if (this.nKe != null)
    {
      ab.e("Tinker.HotPatchApplyService", "hp_apply processing busy, ignore new event");
      AppMethodBeat.o(90581);
      return false;
    }
    if (1 == paramiq.cxZ.coO)
    {
      com.tencent.mm.plugin.hp.tinker.e.bIo();
      AppMethodBeat.o(90581);
      return false;
    }
    if (paramiq.cxZ.cye != null)
    {
      QO(paramiq.cxZ.cye);
      AppMethodBeat.o(90581);
      return false;
    }
    b.xu(1);
    if (paramiq.cxZ.cyc != null) {}
    try
    {
      byte[] arrayOfByte = Base64.decode(paramiq.cxZ.cyc, 0);
      paramiq.cxZ.cyc = new String(arrayOfByte);
      label115:
      if ((!bo.isNullOrNil(paramiq.cxZ.cyc)) && (!bo.isNullOrNil(paramiq.cxZ.cyd)))
      {
        ab.i("Tinker.HotPatchApplyService", "hp_apply request url=%s, signature=%s", new Object[] { paramiq.cxZ.cyc, paramiq.cxZ.cyd });
        this.nKe = new a(paramiq.cxZ.cyc, eQS, paramiq.cxZ.cyd);
      }
      while ((!bo.isNullOrNil(paramiq.cxZ.cya)) && (!bo.isNullOrNil(paramiq.cxZ.cyb)))
      {
        com.tencent.mm.sdk.g.d.ysm.a(this.nKe, "hp_apply_download", this);
        AppMethodBeat.o(90581);
        return false;
      }
      AppMethodBeat.o(90581);
      return false;
    }
    catch (Error localError)
    {
      break label115;
    }
  }
  
  public final void a(Runnable paramRunnable, int paramInt) {}
  
  public final void b(Runnable paramRunnable, int paramInt)
  {
    AppMethodBeat.i(90580);
    if (paramRunnable == this.nKe)
    {
      ab.d("Tinker.HotPatchApplyService", "hp_apply download url=%s, file=%s, failed=%b", new Object[] { this.nKe.url, this.nKe.gjO, Boolean.valueOf(this.nKe.frX) });
      if (this.nKe.frX) {
        break label92;
      }
      b.xv(1);
      QO(this.nKe.gjO);
    }
    for (;;)
    {
      this.nKe = null;
      AppMethodBeat.o(90580);
      return;
      label92:
      b.xw(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.c
 * JD-Core Version:    0.7.0.1
 */