package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.c.a;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiCopyPwdUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.ac;

final class f$1$1
  implements c.a
{
  f$1$1(f.1 param1) {}
  
  public final void onFail(int paramInt)
  {
    AppMethodBeat.i(24878);
    ac.i("MicroMsg.FreeWifi.ProtocolFour", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid failed. ssid=%s, errCode=%d", new Object[] { m.aj(this.srh.srg.intent), Integer.valueOf(m.ak(this.srh.srg.intent)), this.srh.srg.ssid, Integer.valueOf(paramInt) });
    Object localObject1 = k.cIC();
    ((k.a)localObject1).ssid = this.srh.srg.ssid;
    ((k.a)localObject1).bssid = m.afn("MicroMsg.FreeWifi.ProtocolFour");
    ((k.a)localObject1).dbr = m.afo("MicroMsg.FreeWifi.ProtocolFour");
    ((k.a)localObject1).dbq = this.srh.srg.dbq;
    ((k.a)localObject1).soC = this.srh.srg.appId;
    ((k.a)localObject1).ovU = m.aj(this.srh.srg.intent);
    ((k.a)localObject1).soD = m.al(this.srh.srg.intent);
    ((k.a)localObject1).soE = k.b.soP.spp;
    ((k.a)localObject1).soF = k.b.soP.name;
    ((k.a)localObject1).result = paramInt;
    ((k.a)localObject1).channel = m.am(this.srh.srg.intent);
    ((k.a)localObject1).cIE().cID();
    if (paramInt == -16)
    {
      this.srh.srg.intent.setClass(this.srh.srg.srb.getContext(), FreeWifiCopyPwdUI.class);
      this.srh.srg.srb.finish();
      localObject1 = this.srh.srg.srb;
      localObject2 = this.srh.srg.intent;
      localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/freewifi/protocol/ProtocolFour$1$1", "onFail", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((FreeWifiFrontPageUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/freewifi/protocol/ProtocolFour$1$1", "onFail", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(24878);
      return;
    }
    if ((paramInt == -14) || (paramInt == -18))
    {
      localObject1 = this.srh.srg.srb;
      localObject2 = FreeWifiFrontPageUI.d.stu;
      locala = new FreeWifiFrontPageUI.a();
      locala.ssS = 2131759614;
      locala.ssT = m.a(this.srh.srg.srd, k.b.soP, paramInt);
      ((FreeWifiFrontPageUI)localObject1).a((FreeWifiFrontPageUI.d)localObject2, locala);
      AppMethodBeat.o(24878);
      return;
    }
    localObject1 = this.srh.srg.srb;
    Object localObject2 = FreeWifiFrontPageUI.d.stu;
    FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
    locala.ssS = 2131759613;
    locala.ssT = m.a(this.srh.srg.srd, k.b.soP, paramInt);
    ((FreeWifiFrontPageUI)localObject1).a((FreeWifiFrontPageUI.d)localObject2, locala);
    AppMethodBeat.o(24878);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(24877);
    ac.i("MicroMsg.FreeWifi.ProtocolFour", "sessionKey=%s, step=%d, desc=connect ssid succeeded. ", new Object[] { m.aj(this.srh.srg.intent), Integer.valueOf(m.ak(this.srh.srg.intent)) });
    k.a locala = k.cIC();
    locala.ssid = this.srh.srg.ssid;
    locala.bssid = m.afn("MicroMsg.FreeWifi.ProtocolFour");
    locala.dbr = m.afo("MicroMsg.FreeWifi.ProtocolFour");
    locala.dbq = this.srh.srg.dbq;
    locala.soC = this.srh.srg.appId;
    locala.ovU = m.aj(this.srh.srg.intent);
    locala.soD = m.al(this.srh.srg.intent);
    locala.soE = k.b.soP.spp;
    locala.soF = k.b.soP.name;
    locala.result = 0;
    locala.channel = m.am(this.srh.srg.intent);
    locala.cIE().cID();
    m.a(this.srh.srg.intent, this.srh.srg.dbq, this.srh.srg.srd, this.srh.srg.cGY, this.srh.srg.srb, "MicroMsg.FreeWifi.ProtocolFour");
    AppMethodBeat.o(24877);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.f.1.1
 * JD-Core Version:    0.7.0.1
 */