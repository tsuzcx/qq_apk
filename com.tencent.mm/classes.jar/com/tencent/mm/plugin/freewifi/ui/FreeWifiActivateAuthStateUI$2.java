package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.g.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class FreeWifiActivateAuthStateUI$2
  implements g.b
{
  FreeWifiActivateAuthStateUI$2(FreeWifiActivateAuthStateUI paramFreeWifiActivateAuthStateUI) {}
  
  public final void cm(String paramString, int paramInt)
  {
    AppMethodBeat.i(20891);
    String str = d.bAy();
    ab.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "get ap auth data : %s, url : %s, mac : %s", new Object[] { paramString, this.mMn.kdt, str });
    if (!bo.isNullOrNil(paramString)) {
      new a(this.mMn.kdt, this.mMn.ssid, str, this.mMn.mMw, paramString, "", paramInt, m.U(this.mMn.getIntent())).c(new FreeWifiActivateAuthStateUI.2.1(this));
    }
    AppMethodBeat.o(20891);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateAuthStateUI.2
 * JD-Core Version:    0.7.0.1
 */