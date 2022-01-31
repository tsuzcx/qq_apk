package com.tencent.mm.plugin.freewifi;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$1
  implements a.a
{
  a$1(a parama, a.a parama1) {}
  
  public final void onFail(int paramInt)
  {
    AppMethodBeat.i(20555);
    ab.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "sessionKey=%s, step=%d, desc=Connect ssid failed. errorcode=%d", new Object[] { m.U(this.mIe.activity.getIntent()), Integer.valueOf(m.V(this.mIe.activity.getIntent())), Integer.valueOf(paramInt) });
    this.mIc.onFail(paramInt);
    AppMethodBeat.o(20555);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(20554);
    ab.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "sessionKey=%s, step=%d, desc=Connect ssid succeeded. ", new Object[] { m.U(this.mIe.activity.getIntent()), Integer.valueOf(m.V(this.mIe.activity.getIntent())) });
    this.mIc.onSuccess();
    AppMethodBeat.o(20554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.a.1
 * JD-Core Version:    0.7.0.1
 */