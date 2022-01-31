package com.tencent.mm.plugin.freewifi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;

final class m$2
  implements Runnable
{
  m$2(String paramString1, String paramString2, Intent paramIntent, int paramInt1, int paramInt2, m.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(20626);
    Object localObject = k.bAc();
    ((k.a)localObject).ssid = m.Ow(this.mJt);
    ((k.a)localObject).bssid = m.Ox(this.mJt);
    ((k.a)localObject).coY = m.Oy(this.mJt);
    ((k.a)localObject).coX = this.mJv;
    ((k.a)localObject).kMp = m.U(this.val$intent);
    ((k.a)localObject).mIE = this.mIJ;
    ((k.a)localObject).mIF = k.b.mIR.mJq;
    ((k.a)localObject).mIG = k.b.mIR.name;
    ((k.a)localObject).cCy = m.X(this.val$intent);
    ((k.a)localObject).result = 0;
    ((k.a)localObject).bAe().bAd();
    localObject = m.Ox(this.mJt);
    String str = m.Ow(this.mJt);
    int i = d.bAz();
    ab.i(this.mJt, "NetStatusUtil.getNetType(MMApplicationContext.getContext()) = " + at.getNetType(ah.getContext()));
    ab.i(this.mJt, "sessionKey=%s, step=%d, method=getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPage]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", new Object[] { m.U(this.val$intent), Integer.valueOf(m.V(this.val$intent)), this.mJv, localObject, str, Integer.valueOf(i) });
    new a(this.mJv, (String)localObject, str, i, this.mJw, m.U(this.val$intent)).c(new m.2.1(this));
    AppMethodBeat.o(20626);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.m.2
 * JD-Core Version:    0.7.0.1
 */