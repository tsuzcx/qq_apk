package com.tencent.mm.plugin.freewifi.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.plugin.freewifi.d.l;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

final class FreeWifiPcUI$2
  implements View.OnClickListener
{
  FreeWifiPcUI$2(FreeWifiPcUI paramFreeWifiPcUI) {}
  
  public final void onClick(View paramView)
  {
    FreeWifiPcUI.b(this.ksF).setClickable(false);
    paramView = new am(new FreeWifiPcUI.2.1(this), false);
    paramView.S(2000L, 2000L);
    k.a locala = k.aTx();
    locala.kmP = String.valueOf(FreeWifiPcUI.e(this.ksF));
    locala.kmQ = FreeWifiPcUI.d(this.ksF);
    locala.iGw = FreeWifiPcUI.c(this.ksF);
    locala.kmS = k.b.knz.knD;
    locala.kmT = k.b.knz.name;
    locala.aTz().aTy();
    y.i("MicroMsg.FreeWifi.FreeWifiPcUI", "sessionKey=%s, step=%d, method=setOnClickListener, desc=It starts NetSceneSetPcLoginUserInfo.shopid=%d, appid=%s, ticket=%s", new Object[] { m.B(this.ksF.getIntent()), Integer.valueOf(m.C(this.ksF.getIntent())), Integer.valueOf(FreeWifiPcUI.e(this.ksF)), FreeWifiPcUI.d(this.ksF), FreeWifiPcUI.c(this.ksF) });
    new l(FreeWifiPcUI.d(this.ksF), FreeWifiPcUI.e(this.ksF), FreeWifiPcUI.c(this.ksF)).b(new FreeWifiPcUI.2.2(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiPcUI.2
 * JD-Core Version:    0.7.0.1
 */