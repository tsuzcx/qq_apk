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
import com.tencent.mm.sdk.platformtools.ab;

final class f$1$1
  implements c.a
{
  f$1$1(f.1 param1) {}
  
  public final void onFail(int paramInt)
  {
    AppMethodBeat.i(20808);
    ab.i("MicroMsg.FreeWifi.ProtocolFour", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid failed. ssid=%s, errCode=%d", new Object[] { m.U(this.mLk.mLj.intent), Integer.valueOf(m.V(this.mLk.mLj.intent)), this.mLk.mLj.ssid, Integer.valueOf(paramInt) });
    Object localObject = k.bAc();
    ((k.a)localObject).ssid = this.mLk.mLj.ssid;
    ((k.a)localObject).bssid = m.Ox("MicroMsg.FreeWifi.ProtocolFour");
    ((k.a)localObject).coY = m.Oy("MicroMsg.FreeWifi.ProtocolFour");
    ((k.a)localObject).coX = this.mLk.mLj.coX;
    ((k.a)localObject).mIC = this.mLk.mLj.appId;
    ((k.a)localObject).kMp = m.U(this.mLk.mLj.intent);
    ((k.a)localObject).mIE = m.W(this.mLk.mLj.intent);
    ((k.a)localObject).mIF = k.b.mIQ.mJq;
    ((k.a)localObject).mIG = k.b.mIQ.name;
    ((k.a)localObject).result = paramInt;
    ((k.a)localObject).cCy = m.X(this.mLk.mLj.intent);
    ((k.a)localObject).bAe().bAd();
    if (paramInt == -16)
    {
      this.mLk.mLj.intent.setClass(this.mLk.mLj.mLf.getContext(), FreeWifiCopyPwdUI.class);
      this.mLk.mLj.mLf.finish();
      this.mLk.mLj.mLf.startActivity(this.mLk.mLj.intent);
      AppMethodBeat.o(20808);
      return;
    }
    if ((paramInt == -14) || (paramInt == -18))
    {
      localObject = this.mLk.mLj.mLf;
      locald = FreeWifiFrontPageUI.d.mNJ;
      locala = new FreeWifiFrontPageUI.a();
      locala.mNh = 2131300142;
      locala.mNi = m.a(this.mLk.mLj.mLg, k.b.mIQ, paramInt);
      ((FreeWifiFrontPageUI)localObject).a(locald, locala);
      AppMethodBeat.o(20808);
      return;
    }
    localObject = this.mLk.mLj.mLf;
    FreeWifiFrontPageUI.d locald = FreeWifiFrontPageUI.d.mNJ;
    FreeWifiFrontPageUI.a locala = new FreeWifiFrontPageUI.a();
    locala.mNh = 2131300141;
    locala.mNi = m.a(this.mLk.mLj.mLg, k.b.mIQ, paramInt);
    ((FreeWifiFrontPageUI)localObject).a(locald, locala);
    AppMethodBeat.o(20808);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(20807);
    ab.i("MicroMsg.FreeWifi.ProtocolFour", "sessionKey=%s, step=%d, desc=connect ssid succeeded. ", new Object[] { m.U(this.mLk.mLj.intent), Integer.valueOf(m.V(this.mLk.mLj.intent)) });
    k.a locala = k.bAc();
    locala.ssid = this.mLk.mLj.ssid;
    locala.bssid = m.Ox("MicroMsg.FreeWifi.ProtocolFour");
    locala.coY = m.Oy("MicroMsg.FreeWifi.ProtocolFour");
    locala.coX = this.mLk.mLj.coX;
    locala.mIC = this.mLk.mLj.appId;
    locala.kMp = m.U(this.mLk.mLj.intent);
    locala.mIE = m.W(this.mLk.mLj.intent);
    locala.mIF = k.b.mIQ.mJq;
    locala.mIG = k.b.mIQ.name;
    locala.result = 0;
    locala.cCy = m.X(this.mLk.mLj.intent);
    locala.bAe().bAd();
    m.a(this.mLk.mLj.intent, this.mLk.mLj.coX, this.mLk.mLj.mLg, this.mLk.mLj.bWu, this.mLk.mLj.mLf, "MicroMsg.FreeWifi.ProtocolFour");
    AppMethodBeat.o(20807);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.f.1.1
 * JD-Core Version:    0.7.0.1
 */