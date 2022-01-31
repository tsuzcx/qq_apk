package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.protocal.protobuf.gm;
import com.tencent.mm.sdk.platformtools.ab;

final class FreewifiWeChatNoAuthStateUI$1
  implements f
{
  FreewifiWeChatNoAuthStateUI$1(FreewifiWeChatNoAuthStateUI paramFreewifiWeChatNoAuthStateUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(21116);
    aw.Rc().b(640, this);
    ab.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ab.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "check ap ok");
      paramString = ((a)paramm).bAW();
      if (paramString != null)
      {
        ab.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[] { paramString.woB, paramString.jKG, paramString.jJA, Integer.valueOf(paramString.wsQ), paramString.wsR, paramString.gwS });
        this.mOU.cwc = paramString.woB;
        this.mOU.mLh = paramString.jKG;
        this.mOU.cvr = paramString.jJA;
        this.mOU.mOy = paramString.wsQ;
        this.mOU.mOz = paramString.wsR;
        this.mOU.signature = paramString.gwS;
        this.mOU.mOA = paramString.wsS;
      }
      d.a(this.mOU.ssid, 2, this.mOU.getIntent());
      AppMethodBeat.o(21116);
      return;
    }
    ab.e("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "check ap failed ： rssi is :  %d, mac : %s, ssid is : %s", new Object[] { Integer.valueOf(FreewifiWeChatNoAuthStateUI.a(this.mOU)), FreewifiWeChatNoAuthStateUI.b(this.mOU), FreewifiWeChatNoAuthStateUI.c(this.mOU) });
    d.a(this.mOU.ssid, -2014, this.mOU.getIntent());
    d.OE(FreewifiWeChatNoAuthStateUI.c(this.mOU));
    AppMethodBeat.o(21116);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreewifiWeChatNoAuthStateUI.1
 * JD-Core Version:    0.7.0.1
 */