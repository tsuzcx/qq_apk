package com.tencent.mm.plugin.freewifi.model;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.freewifi.c.a;
import com.tencent.mm.plugin.freewifi.d.d;
import com.tencent.mm.plugin.freewifi.i;
import com.tencent.mm.plugin.freewifi.i.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.y;

final class j$4
  implements bx.a
{
  j$4(j paramj) {}
  
  public final void a(e.a parama)
  {
    e locale = j.aUo();
    parama = parama.dBs;
    if (1 != i.a.aTw().getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 0)) {
      i.a.aTw().bD("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 1);
    }
    if ((parama == null) || (parama.svH == null))
    {
      y.e("MicroMsg.FreeWifi.FreeWifiMessageService", "cmdAddMsg is null");
      return;
    }
    Object localObject = aa.a(parama.svH);
    y.i("MicroMsg.FreeWifi.FreeWifiMessageService", "freewifi push message cmdAM.NewMsgId=%d, msgContent=%s", new Object[] { Long.valueOf(parama.ndp), localObject });
    if (m.isEmpty((String)localObject))
    {
      y.e("MicroMsg.FreeWifi.FreeWifiMessageService", "msgContent is empty. return.");
      return;
    }
    localObject = a.Ds((String)localObject);
    if (localObject == null)
    {
      y.e("MicroMsg.FreeWifi.FreeWifiMessageService", "parse schemaMsg failed. return.");
      return;
    }
    String str = m.Dq("MicroMsg.FreeWifi.FreeWifiMessageService");
    new d(m.Do("MicroMsg.FreeWifi.FreeWifiMessageService"), m.Dp("MicroMsg.FreeWifi.FreeWifiMessageService"), str, ((a)localObject).koj, ((a)localObject).kog, ((a)localObject).kok, ((a)localObject).ssid, ((a)localObject).bssid).b(new e.1(locale, parama));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.j.4
 * JD-Core Version:    0.7.0.1
 */