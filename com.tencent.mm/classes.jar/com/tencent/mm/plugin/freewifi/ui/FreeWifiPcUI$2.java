package com.tencent.mm.plugin.freewifi.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.freewifi.d.l;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;

final class FreeWifiPcUI$2
  implements View.OnClickListener
{
  FreeWifiPcUI$2(FreeWifiPcUI paramFreeWifiPcUI) {}
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(25123);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiPcUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    FreeWifiPcUI.b(this.wSz).setClickable(false);
    paramView = new MTimerHandler(new FreeWifiPcUI.2.1(this), false);
    paramView.startTimer(2000L);
    localObject = k.dMF();
    ((k.a)localObject).wNa = String.valueOf(FreeWifiPcUI.e(this.wSz));
    ((k.a)localObject).wNb = FreeWifiPcUI.d(this.wSz);
    ((k.a)localObject).quX = FreeWifiPcUI.c(this.wSz);
    ((k.a)localObject).wNd = k.b.wNK.wNO;
    ((k.a)localObject).wNe = k.b.wNK.name;
    ((k.a)localObject).dMH().dMG();
    Log.i("MicroMsg.FreeWifi.FreeWifiPcUI", "sessionKey=%s, step=%d, method=setOnClickListener, desc=It starts NetSceneSetPcLoginUserInfo.shopid=%d, appid=%s, ticket=%s", new Object[] { m.aw(this.wSz.getIntent()), Integer.valueOf(m.ax(this.wSz.getIntent())), Integer.valueOf(FreeWifiPcUI.e(this.wSz)), FreeWifiPcUI.d(this.wSz), FreeWifiPcUI.c(this.wSz) });
    new l(FreeWifiPcUI.d(this.wSz), FreeWifiPcUI.e(this.wSz), FreeWifiPcUI.c(this.wSz)).c(new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(25122);
        paramView.stopTimer();
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0)) {
          FreeWifiPcUI.2.this.wSz.finish();
        }
        for (;;)
        {
          paramAnonymousString = k.dMF();
          paramAnonymousString.wNa = String.valueOf(FreeWifiPcUI.e(FreeWifiPcUI.2.this.wSz));
          paramAnonymousString.wNb = FreeWifiPcUI.d(FreeWifiPcUI.2.this.wSz);
          paramAnonymousString.quX = FreeWifiPcUI.c(FreeWifiPcUI.2.this.wSz);
          paramAnonymousString.wNd = k.b.wNL.wNO;
          paramAnonymousString.wNe = k.b.wNL.name;
          paramAnonymousString.result = paramAnonymousInt2;
          paramAnonymousString.dMH().dMG();
          Log.i("MicroMsg.FreeWifi.FreeWifiPcUI", "sessionKey=%s, step=%d, method=setOnClickListener, desc=NetSceneSetPcLoginUserInfo returns.shopid=%d, appid=%s, ticket=%s", new Object[] { m.aw(FreeWifiPcUI.2.this.wSz.getIntent()), Integer.valueOf(m.ax(FreeWifiPcUI.2.this.wSz.getIntent())), Integer.valueOf(FreeWifiPcUI.e(FreeWifiPcUI.2.this.wSz)), FreeWifiPcUI.d(FreeWifiPcUI.2.this.wSz), FreeWifiPcUI.c(FreeWifiPcUI.2.this.wSz) });
          AppMethodBeat.o(25122);
          return;
          if ((m.gC(paramAnonymousInt1, paramAnonymousInt2)) && (!m.eP(paramAnonymousString))) {
            FreeWifiPcUI.a(FreeWifiPcUI.2.this.wSz, paramAnonymousString + "(" + m.a(m.ay(FreeWifiPcUI.2.this.wSz.getIntent()), k.b.wNL, paramAnonymousInt2) + ")", "");
          } else {
            FreeWifiPcUI.a(FreeWifiPcUI.2.this.wSz, FreeWifiPcUI.2.this.wSz.getString(2131760942), FreeWifiPcUI.2.this.wSz.getString(2131760943));
          }
        }
      }
    });
    a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiPcUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(25123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiPcUI.2
 * JD-Core Version:    0.7.0.1
 */