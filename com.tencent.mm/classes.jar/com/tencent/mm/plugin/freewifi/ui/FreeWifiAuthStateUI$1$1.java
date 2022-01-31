package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.gm;
import com.tencent.mm.sdk.platformtools.ab;

final class FreeWifiAuthStateUI$1$1
  implements f
{
  FreeWifiAuthStateUI$1$1(FreeWifiAuthStateUI.1 param1) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(20908);
    ab.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.mMH.mMG.mMy = false;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramm = (com.tencent.mm.plugin.freewifi.d.a)paramm;
      paramString = paramm.bAS();
      ab.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "authUrl : %s", new Object[] { paramString });
      paramm = paramm.bAW();
      if (paramm != null)
      {
        ab.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[] { paramm.woB, paramm.jKG, paramm.jJA, Integer.valueOf(paramm.wsQ), paramm.wsR, paramm.gwS });
        this.mMH.mMG.cwc = paramm.woB;
        this.mMH.mMG.mLh = paramm.jKG;
        this.mMH.mMG.cvr = paramm.jJA;
        this.mMH.mMG.mOy = paramm.wsQ;
        this.mMH.mMG.mOz = paramm.wsR;
        this.mMH.mMG.signature = paramm.gwS;
        this.mMH.mMG.mOA = paramm.wsS;
      }
      j.bAP().a(this.mMH.mMG.ssid, paramString, this.mMH.mMG.getIntent());
      AppMethodBeat.o(20908);
      return;
    }
    if (paramInt2 == -2014)
    {
      d.a(this.mMH.mMG.ssid, -2014, this.mMH.mMG.getIntent());
      AppMethodBeat.o(20908);
      return;
    }
    d.a(this.mMH.mMG.ssid, 3, this.mMH.mMG.getIntent());
    AppMethodBeat.o(20908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiAuthStateUI.1.1
 * JD-Core Version:    0.7.0.1
 */