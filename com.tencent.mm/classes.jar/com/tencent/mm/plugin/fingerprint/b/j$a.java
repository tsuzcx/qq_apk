package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import com.tencent.mm.h.a.ll;
import com.tencent.mm.h.a.ll.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class j$a
  implements c
{
  public j$a(j paramj) {}
  
  public final void aR(int paramInt1, int paramInt2)
  {
    if (this.klu.kkX)
    {
      y.e("MicroMsg.OpenFingerPrintAuthEventListener", "hy: event already end. ignore");
      return;
    }
    Object localObject2;
    switch (paramInt1)
    {
    default: 
      return;
    case 0: 
      y.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_SUCCESS");
      localObject1 = this.klu;
      y.i("MicroMsg.OpenFingerPrintAuthEventListener", "onSuccess()");
      ((j)localObject1).kkX = true;
      com.tencent.mm.plugin.fingerprint.a.aSf();
      com.tencent.mm.plugin.fingerprint.a.aSg();
      localObject2 = ((j)localObject1).klr;
      ((k)g.r(k.class)).a((ll)localObject2, paramInt2);
      if (((j)localObject1).kkX) {
        ((j)localObject1).klr = null;
      }
      y.i("MicroMsg.OpenFingerPrintAuthEventListener", "callback OpenFingerPrintAuthEvent onSuccess()");
      j.aTc();
      return;
    case 2002: 
      y.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_NO_MATCH");
      this.klu.kkX = false;
      j.aTc();
      this.klu.gk(true);
      this.klu.U(1, "");
      return;
    case 2001: 
      this.klu.gk(false);
      y.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_TIMEOUT");
      return;
    case 2000: 
      y.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify timeout");
      return;
    case 2004: 
    case 2005: 
    case 2007: 
    case 10308: 
      y.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: on error: %d", new Object[] { Integer.valueOf(paramInt1) });
      this.klu.kkX = true;
      localObject2 = ae.getContext().getString(a.i.soter_on_error_common);
      if (paramInt1 == 10308) {
        localObject1 = ae.getContext().getString(a.i.soter_on_error_max_trial);
      }
      for (;;)
      {
        j.aTc();
        this.klu.U(2, (String)localObject1);
        return;
        localObject1 = localObject2;
        if (paramInt1 == 2007)
        {
          s.qyz.klN = true;
          localObject1 = localObject2;
        }
      }
    }
    y.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: on error: %d", new Object[] { Integer.valueOf(paramInt1) });
    if (this.klu.klr != null) {
      com.tencent.mm.plugin.soter.d.a.zk(this.klu.klr.bUv.bUy);
    }
    this.klu.kkX = true;
    Object localObject1 = ae.getContext().getString(a.i.soter_on_error_common);
    j.aTc();
    this.klu.U(paramInt1, (String)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.j.a
 * JD-Core Version:    0.7.0.1
 */