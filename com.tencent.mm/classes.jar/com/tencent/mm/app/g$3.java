package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.os.Build;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.blink.c.1;
import com.tencent.mm.cm.k;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.j;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.kiss.a.b.1;
import com.tencent.mm.kiss.a.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.w;

final class g$3
  implements Runnable
{
  g$3(g paramg, com.tencent.mm.kernel.b.g paramg1) {}
  
  public final void run()
  {
    AppMethodBeat.i(154199);
    for (;;)
    {
      try
      {
        localObject3 = g.a(this.bXU);
      }
      catch (Exception localException)
      {
        Object localObject3;
        Object localObject5;
        boolean bool;
        ab.printErrStackTrace("MicroMsg.DefaultBootStep", localException, "", new Object[0]);
        com.tencent.mm.blink.a.u(10L, 1L);
        ab.i("MicroMsg.DefaultBootStep", "found a crash, %s %s %s", new Object[] { ah.getResources(), this.bXV.bX.getResources(), this.bXV.bX.getResources().getAssets() });
        g.a(this.bXU, this.bXV);
        g.b(this.bXU);
        return;
        b.SH().a("R.layout.mm_bottom_tabitem", 4, 2130970153, new LinearLayout(localException), new int[0]);
        continue;
      }
      finally
      {
        g.a(this.bXU).done();
        AppMethodBeat.o(154199);
      }
      synchronized (((k)localObject3).eFQ)
      {
        ((k)localObject3).eFQ[0] = -1;
        j.i("MicroMsg.WxWaitingLock", "markUse %s", new Object[] { localObject3 });
        g.a(this.bXU).done();
        localObject5 = new ContextWrapper(this.bXV.bX);
        ??? = b.SH();
        localObject3 = com.tencent.mm.kiss.a.a.SG().eKP.getLooper();
        localObject5 = w.hM((Context)localObject5);
        if (!((b)???).mInitialized)
        {
          ((b)???).mInitialized = true;
          ((b)???).mInflater = ((LayoutInflater)localObject5);
          ((b)???).eKT = ((Looper)localObject3);
          ((b)???).mMode = 2;
          ((b)???).eKU = new b.1((b)???, ((b)???).eKT);
          if (d.fw(26)) {
            b.eKW = new b.a((Looper)localObject3);
          }
        }
        com.tencent.mm.blink.a.HI();
        ??? = ah.getContext();
        bool = b.SH().a("R.layout.actionbar_title_launcher", 1, 2130968619, new LinearLayout((Context)???), new int[0]);
        b.SH().a("R.layout.main_tab", 1, 2130970070, new int[0]);
        if (com.tencent.mm.cb.a.gu((Context)???))
        {
          b.SH().a("R.layout.mm_bottom_tabitem_large", 4, 2130970154, new LinearLayout((Context)???), new int[0]);
          b.SH().a("R.layout.mm_activity", 4, 2130970138, new int[0]);
          if ((!Build.BRAND.equals("vivo")) || (!d.fw(20)))
          {
            b.SH().a("R.layout.main", 1, 2130970066, new int[0]);
            b.SH().a("R.layout.address", 1, 2130968639, new int[0]);
            b.SH().a("R.layout.mm_preference_fragment_list_content", 2, 2130970229, new int[0]);
          }
          b.SH().a("R.layout.actionview_with_dot_tips", 1, 2130968621, new int[0]);
          if (bool)
          {
            ??? = b.SH();
            localObject3 = new c.1();
            ((b)???).eKU.post((Runnable)localObject3);
          }
          g.a(this.bXU).done();
          AppMethodBeat.o(154199);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.g.3
 * JD-Core Version:    0.7.0.1
 */