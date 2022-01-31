package com.tencent.mm.plugin.fingerprint.ui;

import android.content.Context;
import com.tencent.mm.plugin.soter.d.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

public final class FingerPrintAuthUI$a
  implements c
{
  private WeakReference<FingerPrintAuthUI> kmj = null;
  
  public FingerPrintAuthUI$a(FingerPrintAuthUI paramFingerPrintAuthUI1, FingerPrintAuthUI paramFingerPrintAuthUI2)
  {
    this.kmj = new WeakReference(paramFingerPrintAuthUI2);
  }
  
  private FingerPrintAuthUI aTk()
  {
    if (this.kmj != null) {
      return (FingerPrintAuthUI)this.kmj.get();
    }
    return null;
  }
  
  public final void aR(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    String str;
    do
    {
      for (;;)
      {
        return;
        y.i("MicroMsg.FingerPrintAuthUI", "identify success");
        if (aTk() != null)
        {
          FingerPrintAuthUI.a(aTk(), paramInt2);
          return;
          y.i("MicroMsg.FingerPrintAuthUI", "identify FingerPrintConst.RESULT_NO_MATCH");
          if (aTk() != null)
          {
            FingerPrintAuthUI.a(aTk());
            FingerPrintAuthUI.a(this.kmg, true);
            return;
            y.i("MicroMsg.FingerPrintAuthUI", "identify timeout");
            if (aTk() != null)
            {
              FingerPrintAuthUI.a(this.kmg, false);
              return;
              y.i("MicroMsg.FingerPrintAuthUI", "hy: on error: %d", new Object[] { Integer.valueOf(paramInt1) });
              str = ae.getContext().getString(a.i.soter_on_error_common);
              if (paramInt1 == 10308)
              {
                str = ae.getContext().getString(a.i.soter_on_error_max_trial);
                a.c(6, -1000223, -1, "too many trial");
              }
              while (aTk() != null)
              {
                FingerPrintAuthUI.a(aTk(), str, -1);
                return;
                a.c(1000, -1000223, paramInt1, "fingerprint error");
              }
            }
          }
        }
      }
      y.i("MicroMsg.FingerPrintAuthUI", "hy: on error: %d", new Object[] { Integer.valueOf(paramInt1) });
      str = ae.getContext().getString(a.i.soter_on_error_common);
      a.c(1000, -1000223, paramInt1, "fingerprint error");
      a.zk(2);
    } while (aTk() == null);
    FingerPrintAuthUI.a(aTk(), str, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthUI.a
 * JD-Core Version:    0.7.0.1
 */