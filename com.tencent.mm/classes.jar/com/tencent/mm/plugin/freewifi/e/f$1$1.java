package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.freewifi.c.a;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiCopyPwdUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class f$1$1
  implements c.a
{
  f$1$1(f.1 param1) {}
  
  public final void onFail(int paramInt)
  {
    y.i("MicroMsg.FreeWifi.ProtocolFour", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid failed. ssid=%s, errCode=%d", new Object[] { m.B(this.kpy.kpx.intent), Integer.valueOf(m.C(this.kpy.kpx.intent)), this.kpy.kpx.ssid, Integer.valueOf(paramInt) });
    Object localObject = k.aTx();
    ((k.a)localObject).ssid = this.kpy.kpx.ssid;
    ((k.a)localObject).bssid = m.Dp("MicroMsg.FreeWifi.ProtocolFour");
    ((k.a)localObject).bHJ = m.Dq("MicroMsg.FreeWifi.ProtocolFour");
    ((k.a)localObject).bHI = this.kpy.kpx.bHI;
    ((k.a)localObject).kmQ = this.kpy.kpx.appId;
    ((k.a)localObject).iGw = m.B(this.kpy.kpx.intent);
    ((k.a)localObject).kmR = m.D(this.kpy.kpx.intent);
    ((k.a)localObject).kmS = k.b.knd.knD;
    ((k.a)localObject).kmT = k.b.knd.name;
    ((k.a)localObject).result = paramInt;
    ((k.a)localObject).bUR = m.E(this.kpy.kpx.intent);
    ((k.a)localObject).aTz().aTy();
    if (paramInt == -16)
    {
      this.kpy.kpx.intent.setClass(this.kpy.kpx.kps.mController.uMN, FreeWifiCopyPwdUI.class);
      this.kpy.kpx.kps.finish();
      this.kpy.kpx.kps.startActivity(this.kpy.kpx.intent);
      return;
    }
    if ((paramInt == -14) || (paramInt == -18))
    {
      localObject = this.kpy.kpx.kps;
      locald = FreeWifiFrontPageUI.d.krV;
      locala = new FreeWifiFrontPageUI.a();
      locala.gRY = R.l.free_wifi_connect_fail_tips_wrong_password;
      locala.kru = m.a(this.kpy.kpx.kpu, k.b.knd, paramInt);
      ((FreeWifiFrontPageUI)localObject).a(locald, locala);
      return;
    }
    localObject = this.kpy.kpx.kps;
    FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.krV;
    FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
    locala.gRY = R.l.free_wifi_connect_fail_tips;
    locala.kru = m.a(this.kpy.kpx.kpu, k.b.knd, paramInt);
    ((FreeWifiFrontPageUI)localObject).a(locald, locala);
  }
  
  public final void onSuccess()
  {
    y.i("MicroMsg.FreeWifi.ProtocolFour", "sessionKey=%s, step=%d, desc=connect ssid succeeded. ", new Object[] { m.B(this.kpy.kpx.intent), Integer.valueOf(m.C(this.kpy.kpx.intent)) });
    k.a locala = k.aTx();
    locala.ssid = this.kpy.kpx.ssid;
    locala.bssid = m.Dp("MicroMsg.FreeWifi.ProtocolFour");
    locala.bHJ = m.Dq("MicroMsg.FreeWifi.ProtocolFour");
    locala.bHI = this.kpy.kpx.bHI;
    locala.kmQ = this.kpy.kpx.appId;
    locala.iGw = m.B(this.kpy.kpx.intent);
    locala.kmR = m.D(this.kpy.kpx.intent);
    locala.kmS = k.b.knd.knD;
    locala.kmT = k.b.knd.name;
    locala.result = 0;
    locala.bUR = m.E(this.kpy.kpx.intent);
    locala.aTz().aTy();
    m.a(this.kpy.kpx.intent, this.kpy.kpx.bHI, this.kpy.kpx.kpu, this.kpy.kpx.bvj, this.kpy.kpx.kps, "MicroMsg.FreeWifi.ProtocolFour");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.f.1.1
 * JD-Core Version:    0.7.0.1
 */