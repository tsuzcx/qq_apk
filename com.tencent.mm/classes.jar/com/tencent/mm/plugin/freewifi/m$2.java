package com.tencent.mm.plugin.freewifi;

import android.content.Intent;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;

final class m$2
  implements Runnable
{
  m$2(String paramString1, String paramString2, Intent paramIntent, int paramInt1, int paramInt2, m.a parama) {}
  
  public final void run()
  {
    Object localObject = k.aTx();
    ((k.a)localObject).ssid = m.Do(this.knG);
    ((k.a)localObject).bssid = m.Dp(this.knG);
    ((k.a)localObject).bHJ = m.Dq(this.knG);
    ((k.a)localObject).bHI = this.knI;
    ((k.a)localObject).iGw = m.B(this.val$intent);
    ((k.a)localObject).kmR = this.kmW;
    ((k.a)localObject).kmS = k.b.kne.knD;
    ((k.a)localObject).kmT = k.b.kne.name;
    ((k.a)localObject).bUR = m.E(this.val$intent);
    ((k.a)localObject).result = 0;
    ((k.a)localObject).aTz().aTy();
    localObject = m.Dp(this.knG);
    String str = m.Do(this.knG);
    int i = d.aTW();
    y.i(this.knG, "NetStatusUtil.getNetType(MMApplicationContext.getContext()) = " + aq.getNetType(ae.getContext()));
    y.i(this.knG, "sessionKey=%s, step=%d, method=getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPage]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", new Object[] { m.B(this.val$intent), Integer.valueOf(m.C(this.val$intent)), this.knI, localObject, str, Integer.valueOf(i) });
    new a(this.knI, (String)localObject, str, i, this.knJ, m.B(this.val$intent)).b(new m.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.m.2
 * JD-Core Version:    0.7.0.1
 */