package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.ab;

final class FreeWifiActivateAuthStateUI$2$1
  implements f
{
  FreeWifiActivateAuthStateUI$2$1(FreeWifiActivateAuthStateUI.2 param2) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(20890);
    ab.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.mMo.mMn.mMy = false;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((com.tencent.mm.plugin.freewifi.d.a)paramm).bAS();
      ab.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "authUrl : %s", new Object[] { paramString });
      j.bAP().a(this.mMo.mMn.ssid, paramString, this.mMo.mMn.getIntent());
      AppMethodBeat.o(20890);
      return;
    }
    if (paramInt2 == -2014)
    {
      d.a(this.mMo.mMn.ssid, -2014, this.mMo.mMn.getIntent());
      AppMethodBeat.o(20890);
      return;
    }
    d.a(this.mMo.mMn.ssid, 3, this.mMo.mMn.getIntent());
    AppMethodBeat.o(20890);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateAuthStateUI.2.1
 * JD-Core Version:    0.7.0.1
 */