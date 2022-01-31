package com.tencent.mm.plugin.freewifi;

import android.app.Activity;
import com.tencent.mm.sdk.platformtools.y;

final class a$1
  implements a.a
{
  a$1(a parama, a.a parama1) {}
  
  public final void onFail(int paramInt)
  {
    y.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "sessionKey=%s, step=%d, desc=Connect ssid failed. errorcode=%d", new Object[] { m.B(this.kms.activity.getIntent()), Integer.valueOf(m.C(this.kms.activity.getIntent())), Integer.valueOf(paramInt) });
    this.kmr.onFail(paramInt);
  }
  
  public final void onSuccess()
  {
    y.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "sessionKey=%s, step=%d, desc=Connect ssid succeeded. ", new Object[] { m.B(this.kms.activity.getIntent()), Integer.valueOf(m.C(this.kms.activity.getIntent())) });
    this.kmr.onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.a.1
 * JD-Core Version:    0.7.0.1
 */