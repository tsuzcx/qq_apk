package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.c;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public final class i
  extends e
  implements a
{
  protected String cqf;
  private int mLr;
  protected String mLu;
  protected String mLv;
  protected String mLw;
  private Uri mLx;
  private String mLy;
  protected String sign;
  
  public i(FreeWifiFrontPageUI paramFreeWifiFrontPageUI)
  {
    super(paramFreeWifiFrontPageUI);
    AppMethodBeat.i(20841);
    this.mLr = 0;
    this.mLy = this.intent.getStringExtra("free_wifi_schema_uri");
    this.mLx = Uri.parse(this.mLy);
    this.appId = this.mLx.getQueryParameter("appId");
    this.mLu = this.mLx.getQueryParameter("shopId");
    this.mLv = this.mLx.getQueryParameter("authUrl");
    this.mLw = this.mLx.getQueryParameter("extend");
    this.cqf = this.mLx.getQueryParameter("timestamp");
    this.sign = this.mLx.getQueryParameter("sign");
    ab.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=Data retrieved. schemaUri=%s, appid=%s, shopId=%s, authUrl=%s, extend=%s, timestamp=%s, sign=%s", new Object[] { m.U(this.intent), Integer.valueOf(m.V(this.intent)), this.mLx, this.appId, this.mLu, this.mLv, this.mLw, this.cqf, this.sign });
    AppMethodBeat.o(20841);
  }
  
  protected final void bBi()
  {
    AppMethodBeat.i(20843);
    j.bAN().bAw().post(new i.3(this));
    AppMethodBeat.o(20843);
  }
  
  public final void connect()
  {
    AppMethodBeat.i(20842);
    FreeWifiFrontPageUI.d locald;
    FreeWifiFrontPageUI.a locala;
    if (m.isEmpty(this.ssid))
    {
      ab.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=it cannot get ssid, so it fails. ", new Object[] { m.U(this.intent), Integer.valueOf(m.V(this.intent)) });
      localObject = this.mLf;
      locald = FreeWifiFrontPageUI.d.mNJ;
      locala = new FreeWifiFrontPageUI.a();
      locala.mNi = m.a(this.mLg, k.b.mJj, 32);
      ((FreeWifiFrontPageUI)localObject).a(locald, locala);
      AppMethodBeat.o(20842);
      return;
    }
    if (m.isEmpty(this.mLv))
    {
      ab.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=authurl is empty, so it fails. ", new Object[] { m.U(this.intent), Integer.valueOf(m.V(this.intent)) });
      localObject = this.mLf;
      locald = FreeWifiFrontPageUI.d.mNJ;
      locala = new FreeWifiFrontPageUI.a();
      locala.mNi = m.a(this.mLg, k.b.mJj, 32);
      ((FreeWifiFrontPageUI)localObject).a(locald, locala);
      AppMethodBeat.o(20842);
      return;
    }
    Object localObject = new StringBuilder(this.mLv);
    if (this.mLv.indexOf("?") == -1) {
      ((StringBuilder)localObject).append("?extend=").append(this.mLw);
    }
    for (;;)
    {
      localObject = ((StringBuilder)localObject).toString();
      j.bAN().bAw().post(new i.1(this, (String)localObject));
      AppMethodBeat.o(20842);
      return;
      ((StringBuilder)localObject).append("&extend=").append(this.mLw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.i
 * JD-Core Version:    0.7.0.1
 */