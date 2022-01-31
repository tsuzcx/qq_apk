package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.c;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public final class h
  extends e
  implements a
{
  private String kpE = this.intent.getStringExtra("free_wifi_portal_ap_info_authurl_with_params");
  private int kpF = 0;
  
  public h(FreeWifiFrontPageUI paramFreeWifiFrontPageUI)
  {
    super(paramFreeWifiFrontPageUI);
    y.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, desc=Data retrieved. authUrlWithParams=%s", new Object[] { m.B(this.intent), Integer.valueOf(m.C(this.intent)), this.kpE });
  }
  
  private void an(int paramInt, String paramString)
  {
    Object localObject = k.aTx();
    ((k.a)localObject).ssid = this.ssid;
    ((k.a)localObject).bssid = m.Dp("MicroMsg.FreeWifi.ProtocolThreeOne");
    ((k.a)localObject).bHJ = m.Dq("MicroMsg.FreeWifi.ProtocolThreeOne");
    ((k.a)localObject).bHI = this.bHI;
    ((k.a)localObject).kmQ = this.appId;
    ((k.a)localObject).iGw = m.B(this.intent);
    ((k.a)localObject).kmR = 31;
    ((k.a)localObject).kmS = k.b.knt.knD;
    ((k.a)localObject).kmT = k.b.knt.name;
    ((k.a)localObject).result = paramInt;
    ((k.a)localObject).dmU = paramString;
    ((k.a)localObject).bUR = m.E(this.intent);
    paramString = ((k.a)localObject).aTz();
    localObject = this.intent;
    if (paramInt != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramString.b((Intent)localObject, bool).aTy();
      return;
    }
  }
  
  public final void connect()
  {
    y.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.connect, desc=it starts connecting wifi by protocol 3.1. authUrlWithParams=%s", new Object[] { m.B(this.intent), Integer.valueOf(m.C(this.intent)), this.kpE });
    final String str = this.kpE;
    j.aUl().aTT().post(new Runnable()
    {
      public final void run()
      {
        y.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[] { m.B(h.this.intent), Integer.valueOf(m.C(h.this.intent)), str });
        com.tencent.mm.plugin.freewifi.a.a.aTG();
        com.tencent.mm.plugin.freewifi.a.a.a(str, new h.1.1(this));
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.h
 * JD-Core Version:    0.7.0.1
 */