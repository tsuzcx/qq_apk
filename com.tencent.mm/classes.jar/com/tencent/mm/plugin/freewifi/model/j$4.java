package com.tencent.mm.plugin.freewifi.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.freewifi.c.a;
import com.tencent.mm.plugin.freewifi.d.d;
import com.tencent.mm.plugin.freewifi.i;
import com.tencent.mm.plugin.freewifi.i.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;

final class j$4
  implements bz.a
{
  j$4(j paramj) {}
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(20742);
    e locale = j.bAQ();
    parama = parama.eyJ;
    if (1 != i.a.bAb().getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 0)) {
      i.a.bAb().cl("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 1);
    }
    if ((parama == null) || (parama.woR == null))
    {
      ab.e("MicroMsg.FreeWifi.FreeWifiMessageService", "cmdAddMsg is null");
      AppMethodBeat.o(20742);
      return;
    }
    Object localObject = aa.a(parama.woR);
    ab.i("MicroMsg.FreeWifi.FreeWifiMessageService", "freewifi push message cmdAM.NewMsgId=%d, msgContent=%s", new Object[] { Long.valueOf(parama.pIG), localObject });
    if (m.isEmpty((String)localObject))
    {
      ab.e("MicroMsg.FreeWifi.FreeWifiMessageService", "msgContent is empty. return.");
      AppMethodBeat.o(20742);
      return;
    }
    localObject = a.OA((String)localObject);
    if (localObject == null)
    {
      ab.e("MicroMsg.FreeWifi.FreeWifiMessageService", "parse schemaMsg failed. return.");
      AppMethodBeat.o(20742);
      return;
    }
    String str = m.Oy("MicroMsg.FreeWifi.FreeWifiMessageService");
    new d(m.Ow("MicroMsg.FreeWifi.FreeWifiMessageService"), m.Ox("MicroMsg.FreeWifi.FreeWifiMessageService"), str, ((a)localObject).mJW, ((a)localObject).mJT, ((a)localObject).mJX, ((a)localObject).ssid, ((a)localObject).bssid).c(new e.1(locale, parama));
    AppMethodBeat.o(20742);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.j.4
 * JD-Core Version:    0.7.0.1
 */