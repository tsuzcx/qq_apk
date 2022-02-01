package com.tencent.mm.plugin.freewifi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;

final class m$2
  implements Runnable
{
  m$2(String paramString1, String paramString2, Intent paramIntent, int paramInt1, int paramInt2, m.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(24703);
    Object localObject = k.cTw();
    ((k.a)localObject).ssid = m.akI(this.mTR);
    ((k.a)localObject).bssid = m.akJ(this.mTR);
    ((k.a)localObject).dnP = m.akK(this.mTR);
    ((k.a)localObject).dnO = this.twO;
    ((k.a)localObject).pfT = m.ap(this.val$intent);
    ((k.a)localObject).tvY = this.twd;
    ((k.a)localObject).tvZ = k.b.twl.twK;
    ((k.a)localObject).twa = k.b.twl.name;
    ((k.a)localObject).channel = m.as(this.val$intent);
    ((k.a)localObject).result = 0;
    ((k.a)localObject).cTy().cTx();
    localObject = m.akJ(this.mTR);
    String str = m.akI(this.mTR);
    int i = d.cTT();
    ae.i(this.mTR, "NetStatusUtil.getNetType(MMApplicationContext.getContext()) = " + az.getNetType(ak.getContext()));
    ae.i(this.mTR, "sessionKey=%s, step=%d, method=getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPage]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", new Object[] { m.ap(this.val$intent), Integer.valueOf(m.aq(this.val$intent)), this.twO, localObject, str, Integer.valueOf(i) });
    new a(this.twO, (String)localObject, str, i, this.twP, m.ap(this.val$intent)).c(new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(24702);
        ae.i(m.2.this.mTR, "sessionKey=%s, step=%d, desc=net request [apauth.getBackPage] returns. errType=%d, errCode=%d, errMsg=%s", new Object[] { m.ap(m.2.this.val$intent), Integer.valueOf(m.aq(m.2.this.val$intent)), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        k.a locala = k.cTw();
        locala.ssid = m.akI(m.2.this.mTR);
        locala.bssid = m.akJ(m.2.this.mTR);
        locala.dnP = m.akK(m.2.this.mTR);
        locala.dnO = m.2.this.twO;
        locala.pfT = m.ap(m.2.this.val$intent);
        locala.tvY = m.ar(m.2.this.val$intent);
        locala.tvZ = k.b.two.twK;
        locala.twa = k.b.two.name;
        locala.channel = m.as(m.2.this.val$intent);
        locala.result = paramAnonymousInt2;
        locala.fMT = paramAnonymousString;
        locala.cTy().c(m.2.this.val$intent, true).cTx();
        m.2.this.twQ.g(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousn);
        AppMethodBeat.o(24702);
      }
    });
    AppMethodBeat.o(24703);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.m.2
 * JD-Core Version:    0.7.0.1
 */