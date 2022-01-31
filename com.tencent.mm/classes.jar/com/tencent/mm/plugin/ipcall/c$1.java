package com.tencent.mm.plugin.ipcall;

import android.telephony.PhoneStateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class c$1
  extends PhoneStateListener
{
  c$1(c paramc) {}
  
  public final void onCallStateChanged(int paramInt, String paramString)
  {
    AppMethodBeat.i(21665);
    super.onCallStateChanged(paramInt, paramString);
    ab.d("MicroMsg.IPCallManager", "onCallStateChanged ".concat(String.valueOf(paramInt)));
    if (paramInt == 2)
    {
      ab.i("MicroMsg.IPCallManager", "system phone call state offhook, stop call");
      this.nLN.ex(0, 0);
    }
    AppMethodBeat.o(21665);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.c.1
 * JD-Core Version:    0.7.0.1
 */