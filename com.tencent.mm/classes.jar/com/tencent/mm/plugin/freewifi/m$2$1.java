package com.tencent.mm.plugin.freewifi;

import com.tencent.mm.ah.f;
import com.tencent.mm.sdk.platformtools.y;

final class m$2$1
  implements f
{
  m$2$1(m.2 param2) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i(this.knL.knG, "sessionKey=%s, step=%d, desc=net request [apauth.getBackPage] returns. errType=%d, errCode=%d, errMsg=%s", new Object[] { m.B(this.knL.val$intent), Integer.valueOf(m.C(this.knL.val$intent)), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    k.a locala = k.aTx();
    locala.ssid = m.Do(this.knL.knG);
    locala.bssid = m.Dp(this.knL.knG);
    locala.bHJ = m.Dq(this.knL.knG);
    locala.bHI = this.knL.knI;
    locala.iGw = m.B(this.knL.val$intent);
    locala.kmR = m.D(this.knL.val$intent);
    locala.kmS = k.b.knh.knD;
    locala.kmT = k.b.knh.name;
    locala.bUR = m.E(this.knL.val$intent);
    locala.result = paramInt2;
    locala.dmU = paramString;
    locala.aTz().b(this.knL.val$intent, true).aTy();
    this.knL.knK.i(paramInt1, paramInt2, paramString, paramm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.m.2.1
 * JD-Core Version:    0.7.0.1
 */