package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ab;

final class FreewifiActivateWeChatNoAuthStateUI$1
  implements f
{
  FreewifiActivateWeChatNoAuthStateUI$1(FreewifiActivateWeChatNoAuthStateUI paramFreewifiActivateWeChatNoAuthStateUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(21111);
    aw.Rc().b(640, this);
    ab.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ab.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "check ap ok");
      d.a(this.mOT.ssid, 2, this.mOT.getIntent());
      AppMethodBeat.o(21111);
      return;
    }
    ab.e("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "check ap failed ： rssi is :  %d, mac : %s, ssid is : %s", new Object[] { Integer.valueOf(FreewifiActivateWeChatNoAuthStateUI.a(this.mOT)), FreewifiActivateWeChatNoAuthStateUI.b(this.mOT), FreewifiActivateWeChatNoAuthStateUI.c(this.mOT) });
    this.mOT.vc(-2014);
    d.OE(FreewifiActivateWeChatNoAuthStateUI.c(this.mOT));
    AppMethodBeat.o(21111);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreewifiActivateWeChatNoAuthStateUI.1
 * JD-Core Version:    0.7.0.1
 */