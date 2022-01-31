package com.tencent.mm.plugin.freewifi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.d.f;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ab;

final class i$3
  implements Runnable
{
  i$3(i parami) {}
  
  public final void run()
  {
    AppMethodBeat.i(20840);
    Object localObject = k.bAc();
    ((k.a)localObject).ssid = this.mLz.ssid;
    ((k.a)localObject).bssid = m.Ox("MicroMsg.FreeWifi.Protocol33");
    ((k.a)localObject).coY = m.Oy("MicroMsg.FreeWifi.Protocol33");
    ((k.a)localObject).coX = this.mLz.coX;
    ((k.a)localObject).kMp = m.U(this.mLz.intent);
    ((k.a)localObject).mIE = this.mLz.mLg;
    ((k.a)localObject).mIF = k.b.mIT.mJq;
    ((k.a)localObject).mIG = k.b.mIT.name;
    ((k.a)localObject).cCy = m.X(this.mLz.intent);
    ((k.a)localObject).result = 0;
    ((k.a)localObject).bAe().bAd();
    localObject = d.bAy();
    String str = d.bAC();
    int i = d.bAz();
    ab.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPageFor33]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", new Object[] { m.U(this.mLz.intent), Integer.valueOf(m.V(this.mLz.intent)), "", localObject, str, Integer.valueOf(i) });
    new f(this.mLz.ssid, m.Ox("MicroMsg.FreeWifi.Protocol33"), this.mLz.appId, this.mLz.mLu, this.mLz.mLv, this.mLz.mLw, this.mLz.cqf, this.mLz.sign).c(new i.3.1(this));
    AppMethodBeat.o(20840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.i.3
 * JD-Core Version:    0.7.0.1
 */