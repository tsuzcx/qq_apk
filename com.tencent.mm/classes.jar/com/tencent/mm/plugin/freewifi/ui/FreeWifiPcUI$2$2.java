package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

final class FreeWifiPcUI$2$2
  implements f
{
  FreeWifiPcUI$2$2(FreeWifiPcUI.2 param2, ap paramap) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(21063);
    this.mOx.stopTimer();
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      this.mOv.mOu.finish();
    }
    for (;;)
    {
      paramString = k.bAc();
      paramString.mIB = String.valueOf(FreeWifiPcUI.e(this.mOv.mOu));
      paramString.mIC = FreeWifiPcUI.d(this.mOv.mOu);
      paramString.kMp = FreeWifiPcUI.c(this.mOv.mOu);
      paramString.mIF = k.b.mJn.mJq;
      paramString.mIG = k.b.mJn.name;
      paramString.result = paramInt2;
      paramString.bAe().bAd();
      ab.i("MicroMsg.FreeWifi.FreeWifiPcUI", "sessionKey=%s, step=%d, method=setOnClickListener, desc=NetSceneSetPcLoginUserInfo returns.shopid=%d, appid=%s, ticket=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.U(this.mOv.mOu.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(this.mOv.mOu.getIntent())), Integer.valueOf(FreeWifiPcUI.e(this.mOv.mOu)), FreeWifiPcUI.d(this.mOv.mOu), FreeWifiPcUI.c(this.mOv.mOu) });
      AppMethodBeat.o(21063);
      return;
      if ((com.tencent.mm.plugin.freewifi.m.eq(paramInt1, paramInt2)) && (!com.tencent.mm.plugin.freewifi.m.isEmpty(paramString))) {
        FreeWifiPcUI.a(this.mOv.mOu, paramString + "(" + com.tencent.mm.plugin.freewifi.m.a(com.tencent.mm.plugin.freewifi.m.W(this.mOv.mOu.getIntent()), k.b.mJn, paramInt2) + ")", "");
      } else {
        FreeWifiPcUI.a(this.mOv.mOu, this.mOv.mOu.getString(2131300149), this.mOv.mOu.getString(2131300150));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiPcUI.2.2
 * JD-Core Version:    0.7.0.1
 */