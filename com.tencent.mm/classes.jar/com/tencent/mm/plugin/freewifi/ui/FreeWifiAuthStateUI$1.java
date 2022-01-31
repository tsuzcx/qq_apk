package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.g.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class FreeWifiAuthStateUI$1
  implements g.b
{
  FreeWifiAuthStateUI$1(FreeWifiAuthStateUI paramFreeWifiAuthStateUI) {}
  
  public final void cm(String paramString, int paramInt)
  {
    AppMethodBeat.i(20909);
    String str = d.bAy();
    ab.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "get ap auth data : %s, url : %s, mac : %s", new Object[] { paramString, this.mMG.kdt, str });
    if (!bo.isNullOrNil(paramString)) {
      new a(this.mMG.kdt, this.mMG.ssid, str, this.mMG.mMw, paramString, "", paramInt, m.U(this.mMG.getIntent())).c(new FreeWifiAuthStateUI.1.1(this));
    }
    AppMethodBeat.o(20909);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiAuthStateUI.1
 * JD-Core Version:    0.7.0.1
 */