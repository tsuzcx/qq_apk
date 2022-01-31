package com.tencent.mm.plugin.freewifi;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class c$1
  implements c.a
{
  public c$1(c paramc, c.a parama) {}
  
  public final void onFail(int paramInt)
  {
    AppMethodBeat.i(20565);
    ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "sessionKey=%s, step=%d, desc=Connect ssid failed. errorcode=%d", new Object[] { m.U(this.mIi.activity.getIntent()), Integer.valueOf(m.V(this.mIi.activity.getIntent())), Integer.valueOf(paramInt) });
    this.mIh.onFail(paramInt);
    AppMethodBeat.o(20565);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(20564);
    ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "sessionKey=%s, step=%d, desc=Connect ssid succeeded. ", new Object[] { m.U(this.mIi.activity.getIntent()), Integer.valueOf(m.V(this.mIi.activity.getIntent())) });
    this.mIh.onSuccess();
    AppMethodBeat.o(20564);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.c.1
 * JD-Core Version:    0.7.0.1
 */