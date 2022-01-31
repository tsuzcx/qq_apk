package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.c;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public final class h
  extends e
  implements a
{
  private String mLq;
  private int mLr;
  
  public h(FreeWifiFrontPageUI paramFreeWifiFrontPageUI)
  {
    super(paramFreeWifiFrontPageUI);
    AppMethodBeat.i(20829);
    this.mLr = 0;
    this.mLq = this.intent.getStringExtra("free_wifi_portal_ap_info_authurl_with_params");
    ab.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, desc=Data retrieved. authUrlWithParams=%s", new Object[] { m.U(this.intent), Integer.valueOf(m.V(this.intent)), this.mLq });
    AppMethodBeat.o(20829);
  }
  
  private void aH(int paramInt, String paramString)
  {
    AppMethodBeat.i(20831);
    Object localObject = k.bAc();
    ((k.a)localObject).ssid = this.ssid;
    ((k.a)localObject).bssid = m.Ox("MicroMsg.FreeWifi.ProtocolThreeOne");
    ((k.a)localObject).coY = m.Oy("MicroMsg.FreeWifi.ProtocolThreeOne");
    ((k.a)localObject).coX = this.coX;
    ((k.a)localObject).mIC = this.appId;
    ((k.a)localObject).kMp = m.U(this.intent);
    ((k.a)localObject).mIE = 31;
    ((k.a)localObject).mIF = k.b.mJg.mJq;
    ((k.a)localObject).mIG = k.b.mJg.name;
    ((k.a)localObject).result = paramInt;
    ((k.a)localObject).eev = paramString;
    ((k.a)localObject).cCy = m.X(this.intent);
    paramString = ((k.a)localObject).bAe();
    localObject = this.intent;
    if (paramInt != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramString.c((Intent)localObject, bool).bAd();
      AppMethodBeat.o(20831);
      return;
    }
  }
  
  public final void connect()
  {
    AppMethodBeat.i(20830);
    ab.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.connect, desc=it starts connecting wifi by protocol 3.1. authUrlWithParams=%s", new Object[] { m.U(this.intent), Integer.valueOf(m.V(this.intent)), this.mLq });
    final String str = this.mLq;
    j.bAN().bAw().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20826);
        ab.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[] { m.U(h.this.intent), Integer.valueOf(m.V(h.this.intent)), str });
        com.tencent.mm.plugin.freewifi.a.a.bAk();
        com.tencent.mm.plugin.freewifi.a.a.a(str, new h.1.1(this));
        AppMethodBeat.o(20826);
      }
    });
    AppMethodBeat.o(20830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.h
 * JD-Core Version:    0.7.0.1
 */