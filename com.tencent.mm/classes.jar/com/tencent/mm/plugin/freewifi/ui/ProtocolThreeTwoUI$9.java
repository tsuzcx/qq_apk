package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.h;
import com.tencent.mm.plugin.freewifi.h.b;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.y;

final class ProtocolThreeTwoUI$9
  implements a.a
{
  ProtocolThreeTwoUI$9(ProtocolThreeTwoUI paramProtocolThreeTwoUI) {}
  
  public final void onFail(int paramInt)
  {
    y.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid failed. ssid=%s, errCode=%d", new Object[] { m.B(this.kto.getIntent()), Integer.valueOf(m.C(this.kto.getIntent())), this.kto.ssid, Integer.valueOf(paramInt) });
    d.a(this.kto.ssid, 3, this.kto.getIntent());
    k.a locala = k.aTx();
    locala.ssid = this.kto.ssid;
    locala.bssid = m.Dp("MicroMsg.FreeWifi.Protocol32UI");
    locala.bHJ = m.Dq("MicroMsg.FreeWifi.Protocol32UI");
    locala.bHI = ProtocolThreeTwoUI.e(this.kto);
    locala.kmQ = this.kto.bOL;
    locala.iGw = m.B(ProtocolThreeTwoUI.d(this.kto));
    locala.kmR = m.D(ProtocolThreeTwoUI.d(this.kto));
    locala.kmS = k.b.knd.knD;
    locala.kmT = k.b.knd.name;
    locala.result = paramInt;
    locala.bUR = m.E(ProtocolThreeTwoUI.d(this.kto));
    locala.kmU = this.kto.bNZ;
    locala.aTz().aTy();
  }
  
  public final void onSuccess()
  {
    Object localObject = k.aTx();
    ((k.a)localObject).ssid = this.kto.ssid;
    ((k.a)localObject).bssid = m.Dp("MicroMsg.FreeWifi.Protocol32UI");
    ((k.a)localObject).bHJ = m.Dq("MicroMsg.FreeWifi.Protocol32UI");
    ((k.a)localObject).bHI = ProtocolThreeTwoUI.e(this.kto);
    ((k.a)localObject).kmQ = this.kto.bOL;
    ((k.a)localObject).iGw = m.B(ProtocolThreeTwoUI.d(this.kto));
    ((k.a)localObject).kmR = m.D(ProtocolThreeTwoUI.d(this.kto));
    ((k.a)localObject).kmS = k.b.knd.knD;
    ((k.a)localObject).kmT = k.b.knd.name;
    ((k.a)localObject).result = 0;
    ((k.a)localObject).bUR = m.E(ProtocolThreeTwoUI.d(this.kto));
    ((k.a)localObject).kmU = this.kto.bNZ;
    ((k.a)localObject).aTz().aTy();
    localObject = h.b.aTv().aTu();
    y.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid succeeded and then tries to access blackUrl. ssid=%s, blackUrl = %s", new Object[] { m.B(this.kto.getIntent()), Integer.valueOf(m.C(this.kto.getIntent())), this.kto.ssid, localObject });
    ProtocolThreeTwoUI.9.1 local1 = new ProtocolThreeTwoUI.9.1(this, (String)localObject);
    a.aTG();
    a.a((String)localObject, local1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.9
 * JD-Core Version:    0.7.0.1
 */