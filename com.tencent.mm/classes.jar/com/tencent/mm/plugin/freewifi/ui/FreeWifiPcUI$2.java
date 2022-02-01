package com.tencent.mm.plugin.freewifi.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.freewifi.d.l;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;

final class FreeWifiPcUI$2
  implements View.OnClickListener
{
  FreeWifiPcUI$2(FreeWifiPcUI paramFreeWifiPcUI) {}
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(25123);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiPcUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    FreeWifiPcUI.b(this.tBy).setClickable(false);
    paramView = new aw(new FreeWifiPcUI.2.1(this), false);
    paramView.ay(2000L, 2000L);
    localObject = k.cTw();
    ((k.a)localObject).tvW = String.valueOf(FreeWifiPcUI.e(this.tBy));
    ((k.a)localObject).tvX = FreeWifiPcUI.d(this.tBy);
    ((k.a)localObject).pfT = FreeWifiPcUI.c(this.tBy);
    ((k.a)localObject).tvZ = k.b.twG.twK;
    ((k.a)localObject).twa = k.b.twG.name;
    ((k.a)localObject).cTy().cTx();
    ae.i("MicroMsg.FreeWifi.FreeWifiPcUI", "sessionKey=%s, step=%d, method=setOnClickListener, desc=It starts NetSceneSetPcLoginUserInfo.shopid=%d, appid=%s, ticket=%s", new Object[] { m.ap(this.tBy.getIntent()), Integer.valueOf(m.aq(this.tBy.getIntent())), Integer.valueOf(FreeWifiPcUI.e(this.tBy)), FreeWifiPcUI.d(this.tBy), FreeWifiPcUI.c(this.tBy) });
    new l(FreeWifiPcUI.d(this.tBy), FreeWifiPcUI.e(this.tBy), FreeWifiPcUI.c(this.tBy)).c(new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(25122);
        paramView.stopTimer();
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0)) {
          FreeWifiPcUI.2.this.tBy.finish();
        }
        for (;;)
        {
          paramAnonymousString = k.cTw();
          paramAnonymousString.tvW = String.valueOf(FreeWifiPcUI.e(FreeWifiPcUI.2.this.tBy));
          paramAnonymousString.tvX = FreeWifiPcUI.d(FreeWifiPcUI.2.this.tBy);
          paramAnonymousString.pfT = FreeWifiPcUI.c(FreeWifiPcUI.2.this.tBy);
          paramAnonymousString.tvZ = k.b.twH.twK;
          paramAnonymousString.twa = k.b.twH.name;
          paramAnonymousString.result = paramAnonymousInt2;
          paramAnonymousString.cTy().cTx();
          ae.i("MicroMsg.FreeWifi.FreeWifiPcUI", "sessionKey=%s, step=%d, method=setOnClickListener, desc=NetSceneSetPcLoginUserInfo returns.shopid=%d, appid=%s, ticket=%s", new Object[] { m.ap(FreeWifiPcUI.2.this.tBy.getIntent()), Integer.valueOf(m.aq(FreeWifiPcUI.2.this.tBy.getIntent())), Integer.valueOf(FreeWifiPcUI.e(FreeWifiPcUI.2.this.tBy)), FreeWifiPcUI.d(FreeWifiPcUI.2.this.tBy), FreeWifiPcUI.c(FreeWifiPcUI.2.this.tBy) });
          AppMethodBeat.o(25122);
          return;
          if ((m.gd(paramAnonymousInt1, paramAnonymousInt2)) && (!m.ef(paramAnonymousString))) {
            FreeWifiPcUI.a(FreeWifiPcUI.2.this.tBy, paramAnonymousString + "(" + m.a(m.ar(FreeWifiPcUI.2.this.tBy.getIntent()), k.b.twH, paramAnonymousInt2) + ")", "");
          } else {
            FreeWifiPcUI.a(FreeWifiPcUI.2.this.tBy, FreeWifiPcUI.2.this.tBy.getString(2131759621), FreeWifiPcUI.2.this.tBy.getString(2131759622));
          }
        }
      }
    });
    a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiPcUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(25123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiPcUI.2
 * JD-Core Version:    0.7.0.1
 */