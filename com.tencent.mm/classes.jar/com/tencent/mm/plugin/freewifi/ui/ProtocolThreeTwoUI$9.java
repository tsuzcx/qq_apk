package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.h;
import com.tencent.mm.plugin.freewifi.h.b;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ab;

final class ProtocolThreeTwoUI$9
  implements a.a
{
  ProtocolThreeTwoUI$9(ProtocolThreeTwoUI paramProtocolThreeTwoUI) {}
  
  public final void onFail(int paramInt)
  {
    AppMethodBeat.i(21189);
    ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid failed. ssid=%s, errCode=%d", new Object[] { m.U(this.mPc.getIntent()), Integer.valueOf(m.V(this.mPc.getIntent())), this.mPc.ssid, Integer.valueOf(paramInt) });
    d.a(this.mPc.ssid, 3, this.mPc.getIntent());
    k.a locala = k.bAc();
    locala.ssid = this.mPc.ssid;
    locala.bssid = m.Ox("MicroMsg.FreeWifi.Protocol32UI");
    locala.coY = m.Oy("MicroMsg.FreeWifi.Protocol32UI");
    locala.coX = ProtocolThreeTwoUI.e(this.mPc);
    locala.mIC = this.mPc.cwc;
    locala.kMp = m.U(ProtocolThreeTwoUI.d(this.mPc));
    locala.mIE = m.W(ProtocolThreeTwoUI.d(this.mPc));
    locala.mIF = k.b.mIQ.mJq;
    locala.mIG = k.b.mIQ.name;
    locala.result = paramInt;
    locala.cCy = m.X(ProtocolThreeTwoUI.d(this.mPc));
    locala.mIH = this.mPc.cvr;
    locala.bAe().bAd();
    AppMethodBeat.o(21189);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(21188);
    Object localObject = k.bAc();
    ((k.a)localObject).ssid = this.mPc.ssid;
    ((k.a)localObject).bssid = m.Ox("MicroMsg.FreeWifi.Protocol32UI");
    ((k.a)localObject).coY = m.Oy("MicroMsg.FreeWifi.Protocol32UI");
    ((k.a)localObject).coX = ProtocolThreeTwoUI.e(this.mPc);
    ((k.a)localObject).mIC = this.mPc.cwc;
    ((k.a)localObject).kMp = m.U(ProtocolThreeTwoUI.d(this.mPc));
    ((k.a)localObject).mIE = m.W(ProtocolThreeTwoUI.d(this.mPc));
    ((k.a)localObject).mIF = k.b.mIQ.mJq;
    ((k.a)localObject).mIG = k.b.mIQ.name;
    ((k.a)localObject).result = 0;
    ((k.a)localObject).cCy = m.X(ProtocolThreeTwoUI.d(this.mPc));
    ((k.a)localObject).mIH = this.mPc.cvr;
    ((k.a)localObject).bAe().bAd();
    localObject = h.b.bAa().bzZ();
    ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid succeeded and then tries to access blackUrl. ssid=%s, blackUrl = %s", new Object[] { m.U(this.mPc.getIntent()), Integer.valueOf(m.V(this.mPc.getIntent())), this.mPc.ssid, localObject });
    ProtocolThreeTwoUI.9.1 local1 = new ProtocolThreeTwoUI.9.1(this, (String)localObject);
    a.bAk();
    a.a((String)localObject, local1);
    AppMethodBeat.o(21188);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.9
 * JD-Core Version:    0.7.0.1
 */