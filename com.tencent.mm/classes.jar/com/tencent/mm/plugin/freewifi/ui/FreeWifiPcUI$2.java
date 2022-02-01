package com.tencent.mm.plugin.freewifi.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.freewifi.d.l;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;

final class FreeWifiPcUI$2
  implements View.OnClickListener
{
  FreeWifiPcUI$2(FreeWifiPcUI paramFreeWifiPcUI) {}
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(25123);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiPcUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    FreeWifiPcUI.b(this.tqH).setClickable(false);
    paramView = new av(new FreeWifiPcUI.2.1(this), false);
    paramView.az(2000L, 2000L);
    localObject = k.cQR();
    ((k.a)localObject).tle = String.valueOf(FreeWifiPcUI.e(this.tqH));
    ((k.a)localObject).tlf = FreeWifiPcUI.d(this.tqH);
    ((k.a)localObject).oZp = FreeWifiPcUI.c(this.tqH);
    ((k.a)localObject).tlh = k.b.tlO.tlS;
    ((k.a)localObject).tli = k.b.tlO.name;
    ((k.a)localObject).cQT().cQS();
    ad.i("MicroMsg.FreeWifi.FreeWifiPcUI", "sessionKey=%s, step=%d, method=setOnClickListener, desc=It starts NetSceneSetPcLoginUserInfo.shopid=%d, appid=%s, ticket=%s", new Object[] { m.ao(this.tqH.getIntent()), Integer.valueOf(m.ap(this.tqH.getIntent())), Integer.valueOf(FreeWifiPcUI.e(this.tqH)), FreeWifiPcUI.d(this.tqH), FreeWifiPcUI.c(this.tqH) });
    new l(FreeWifiPcUI.d(this.tqH), FreeWifiPcUI.e(this.tqH), FreeWifiPcUI.c(this.tqH)).c(new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(25122);
        paramView.stopTimer();
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0)) {
          FreeWifiPcUI.2.this.tqH.finish();
        }
        for (;;)
        {
          paramAnonymousString = k.cQR();
          paramAnonymousString.tle = String.valueOf(FreeWifiPcUI.e(FreeWifiPcUI.2.this.tqH));
          paramAnonymousString.tlf = FreeWifiPcUI.d(FreeWifiPcUI.2.this.tqH);
          paramAnonymousString.oZp = FreeWifiPcUI.c(FreeWifiPcUI.2.this.tqH);
          paramAnonymousString.tlh = k.b.tlP.tlS;
          paramAnonymousString.tli = k.b.tlP.name;
          paramAnonymousString.result = paramAnonymousInt2;
          paramAnonymousString.cQT().cQS();
          ad.i("MicroMsg.FreeWifi.FreeWifiPcUI", "sessionKey=%s, step=%d, method=setOnClickListener, desc=NetSceneSetPcLoginUserInfo returns.shopid=%d, appid=%s, ticket=%s", new Object[] { m.ao(FreeWifiPcUI.2.this.tqH.getIntent()), Integer.valueOf(m.ap(FreeWifiPcUI.2.this.tqH.getIntent())), Integer.valueOf(FreeWifiPcUI.e(FreeWifiPcUI.2.this.tqH)), FreeWifiPcUI.d(FreeWifiPcUI.2.this.tqH), FreeWifiPcUI.c(FreeWifiPcUI.2.this.tqH) });
          AppMethodBeat.o(25122);
          return;
          if ((m.gd(paramAnonymousInt1, paramAnonymousInt2)) && (!m.ea(paramAnonymousString))) {
            FreeWifiPcUI.a(FreeWifiPcUI.2.this.tqH, paramAnonymousString + "(" + m.a(m.aq(FreeWifiPcUI.2.this.tqH.getIntent()), k.b.tlP, paramAnonymousInt2) + ")", "");
          } else {
            FreeWifiPcUI.a(FreeWifiPcUI.2.this.tqH, FreeWifiPcUI.2.this.tqH.getString(2131759621), FreeWifiPcUI.2.this.tqH.getString(2131759622));
          }
        }
      }
    });
    a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiPcUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(25123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiPcUI.2
 * JD-Core Version:    0.7.0.1
 */