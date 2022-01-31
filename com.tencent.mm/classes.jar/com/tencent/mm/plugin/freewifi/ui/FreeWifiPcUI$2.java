package com.tencent.mm.plugin.freewifi.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.d.l;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

final class FreeWifiPcUI$2
  implements View.OnClickListener
{
  FreeWifiPcUI$2(FreeWifiPcUI paramFreeWifiPcUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(21064);
    FreeWifiPcUI.b(this.mOu).setClickable(false);
    paramView = new ap(new FreeWifiPcUI.2.1(this), false);
    paramView.ag(2000L, 2000L);
    k.a locala = k.bAc();
    locala.mIB = String.valueOf(FreeWifiPcUI.e(this.mOu));
    locala.mIC = FreeWifiPcUI.d(this.mOu);
    locala.kMp = FreeWifiPcUI.c(this.mOu);
    locala.mIF = k.b.mJm.mJq;
    locala.mIG = k.b.mJm.name;
    locala.bAe().bAd();
    ab.i("MicroMsg.FreeWifi.FreeWifiPcUI", "sessionKey=%s, step=%d, method=setOnClickListener, desc=It starts NetSceneSetPcLoginUserInfo.shopid=%d, appid=%s, ticket=%s", new Object[] { m.U(this.mOu.getIntent()), Integer.valueOf(m.V(this.mOu.getIntent())), Integer.valueOf(FreeWifiPcUI.e(this.mOu)), FreeWifiPcUI.d(this.mOu), FreeWifiPcUI.c(this.mOu) });
    new l(FreeWifiPcUI.d(this.mOu), FreeWifiPcUI.e(this.mOu), FreeWifiPcUI.c(this.mOu)).c(new FreeWifiPcUI.2.2(this, paramView));
    AppMethodBeat.o(21064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiPcUI.2
 * JD-Core Version:    0.7.0.1
 */