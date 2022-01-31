package com.tencent.mm.plugin.freewifi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.sdk.platformtools.ab;

final class m$2$1
  implements f
{
  m$2$1(m.2 param2) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(20625);
    ab.i(this.mJy.mJt, "sessionKey=%s, step=%d, desc=net request [apauth.getBackPage] returns. errType=%d, errCode=%d, errMsg=%s", new Object[] { m.U(this.mJy.val$intent), Integer.valueOf(m.V(this.mJy.val$intent)), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    k.a locala = k.bAc();
    locala.ssid = m.Ow(this.mJy.mJt);
    locala.bssid = m.Ox(this.mJy.mJt);
    locala.coY = m.Oy(this.mJy.mJt);
    locala.coX = this.mJy.mJv;
    locala.kMp = m.U(this.mJy.val$intent);
    locala.mIE = m.W(this.mJy.val$intent);
    locala.mIF = k.b.mIU.mJq;
    locala.mIG = k.b.mIU.name;
    locala.cCy = m.X(this.mJy.val$intent);
    locala.result = paramInt2;
    locala.eev = paramString;
    locala.bAe().c(this.mJy.val$intent, true).bAd();
    this.mJy.mJx.g(paramInt1, paramInt2, paramString, paramm);
    AppMethodBeat.o(20625);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.m.2.1
 * JD-Core Version:    0.7.0.1
 */