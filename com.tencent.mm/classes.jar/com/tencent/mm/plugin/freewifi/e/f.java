package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public final class f
  extends e
  implements a
{
  private String foj = this.intent.getStringExtra("free_wifi_passowrd");
  
  public f(FreeWifiFrontPageUI paramFreeWifiFrontPageUI)
  {
    super(paramFreeWifiFrontPageUI);
    y.i("MicroMsg.FreeWifi.ProtocolFour", "sessionKey=%s, step=%d, desc=Data retrieved. password=%s", new Object[] { m.B(this.intent), Integer.valueOf(m.C(this.intent)), this.foj });
  }
  
  public final void connect()
  {
    com.tencent.mm.plugin.freewifi.c localc = new com.tencent.mm.plugin.freewifi.c(this.ssid, this.kps, this.foj);
    j.aUg();
    j.aUl().aTT().post(new f.1(this, localc));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.f
 * JD-Core Version:    0.7.0.1
 */