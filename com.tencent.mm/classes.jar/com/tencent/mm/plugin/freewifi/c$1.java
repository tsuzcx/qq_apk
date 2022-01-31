package com.tencent.mm.plugin.freewifi;

import android.app.Activity;
import com.tencent.mm.sdk.platformtools.y;

public final class c$1
  implements c.a
{
  public c$1(c paramc, c.a parama) {}
  
  public final void onFail(int paramInt)
  {
    y.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "sessionKey=%s, step=%d, desc=Connect ssid failed. errorcode=%d", new Object[] { m.B(this.kmw.activity.getIntent()), Integer.valueOf(m.C(this.kmw.activity.getIntent())), Integer.valueOf(paramInt) });
    this.kmv.onFail(paramInt);
  }
  
  public final void onSuccess()
  {
    y.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "sessionKey=%s, step=%d, desc=Connect ssid succeeded. ", new Object[] { m.B(this.kmw.activity.getIntent()), Integer.valueOf(m.C(this.kmw.activity.getIntent())) });
    this.kmv.onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.c.1
 * JD-Core Version:    0.7.0.1
 */