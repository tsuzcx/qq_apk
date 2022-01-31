package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.R.a;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.plugin.freewifi.d.i;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.sdk.platformtools.y;

final class b$2
  implements f
{
  b$2(b paramb, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo.callback, desc=net request [GetPortalApInfo] returns. errType=%d, errCode=%d, errMsg=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.B(this.krg.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(this.krg.intent)), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Object localObject = k.aTx();
      ((k.a)localObject).bHI = this.krg.bHI;
      ((k.a)localObject).iGw = com.tencent.mm.plugin.freewifi.m.B(this.krg.intent);
      ((k.a)localObject).kmS = k.b.knn.knD;
      ((k.a)localObject).kmT = k.b.knn.name;
      ((k.a)localObject).bUR = this.krg.bUR;
      ((k.a)localObject).result = paramInt2;
      ((k.a)localObject).dmU = paramString;
      ((k.a)localObject).aTz().b(this.krg.intent, false).aTy();
      paramm = (i)paramm;
      paramString = paramm.aUA();
      if (com.tencent.mm.plugin.freewifi.m.isEmpty(paramString))
      {
        y.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=authUrl is empty, so it fails to connect wifi. ", new Object[] { com.tencent.mm.plugin.freewifi.m.B(this.krg.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(this.krg.intent)) });
        this.krg.DE(this.krg.activity.getString(R.l.free_wifi_errmsg_retry));
        paramString = k.aTx();
        paramString.bHI = this.krg.bHI;
        paramString.iGw = com.tencent.mm.plugin.freewifi.m.B(this.krg.intent);
        paramString.kmS = k.b.kno.knD;
        paramString.kmT = k.b.kno.name;
        paramString.bUR = this.krg.bUR;
        paramString.kmR = com.tencent.mm.plugin.freewifi.m.D(this.krg.intent);
        paramString.result = -1;
        paramString.dmU = "31 auth url is empty.";
        paramString.aTz().b(this.krg.intent, true).aTy();
        return;
      }
      paramm = com.tencent.mm.plugin.freewifi.m.Dn(paramm.aUB());
      localObject = com.tencent.mm.plugin.freewifi.m.Dn(this.krh);
      String str = com.tencent.mm.plugin.freewifi.m.Dn(this.kri);
      StringBuilder localStringBuilder = new StringBuilder(paramString);
      if (paramString.indexOf("?") != -1) {
        localStringBuilder.append("&extend=").append(paramm);
      }
      for (;;)
      {
        localStringBuilder.append("&openId=").append((String)localObject).append("&tid=").append(str).append("&timestamp=").append(com.tencent.mm.plugin.freewifi.m.Dn(this.krj)).append("&sign=").append(com.tencent.mm.plugin.freewifi.m.Dn(this.krk));
        y.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it gets authentication url. http url=%s ", new Object[] { com.tencent.mm.plugin.freewifi.m.B(this.krg.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(this.krg.intent)), localStringBuilder.toString() });
        this.krg.intent.putExtra("free_wifi_portal_ap_info_authurl_with_params", localStringBuilder.toString());
        this.krg.intent.setClass(this.krg.activity, FreeWifiFrontPageUI.class);
        this.krg.activity.startActivity(this.krg.intent);
        this.krg.activity.finish();
        this.krg.activity.overridePendingTransition(R.a.slide_right_in, R.a.slide_left_out);
        paramString = k.aTx();
        paramString.bHI = this.krg.bHI;
        paramString.iGw = com.tencent.mm.plugin.freewifi.m.B(this.krg.intent);
        paramString.kmS = k.b.kno.knD;
        paramString.kmT = k.b.kno.name;
        paramString.bUR = this.krg.bUR;
        paramString.kmR = com.tencent.mm.plugin.freewifi.m.D(this.krg.intent);
        paramString.result = 0;
        paramString.dmU = "";
        paramString.aTz().b(this.krg.intent, true).aTy();
        return;
        localStringBuilder.append("?extend=").append(paramm);
      }
    }
    paramm = k.aTx();
    paramm.bHI = this.krg.bHI;
    paramm.iGw = com.tencent.mm.plugin.freewifi.m.B(this.krg.intent);
    paramm.kmS = k.b.knn.knD;
    paramm.kmT = k.b.knn.name;
    paramm.bUR = this.krg.bUR;
    paramm.kmR = com.tencent.mm.plugin.freewifi.m.D(this.krg.intent);
    paramm.result = paramInt2;
    paramm.dmU = paramString;
    paramm.aTz().b(this.krg.intent, true).aTy();
    if ((com.tencent.mm.plugin.freewifi.m.cS(paramInt1, paramInt2)) && (!com.tencent.mm.plugin.freewifi.m.isEmpty(paramString)))
    {
      this.krg.DE(paramString + "(" + com.tencent.mm.plugin.freewifi.m.a(com.tencent.mm.plugin.freewifi.m.D(this.krg.intent), k.b.knn, paramInt2) + ")");
      return;
    }
    if (com.tencent.mm.plugin.freewifi.m.isEmpty(paramString))
    {
      this.krg.DE(this.krg.activity.getString(R.l.free_wifi_errmsg_retry));
      return;
    }
    this.krg.DE(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.b.2
 * JD-Core Version:    0.7.0.1
 */