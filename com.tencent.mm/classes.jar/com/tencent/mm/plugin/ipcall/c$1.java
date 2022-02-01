package com.tencent.mm.plugin.ipcall;

import android.telephony.PhoneStateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class c$1
  extends PhoneStateListener
{
  c$1(c paramc) {}
  
  public final void onCallStateChanged(int paramInt, String paramString)
  {
    AppMethodBeat.i(25288);
    super.onCallStateChanged(paramInt, paramString);
    ad.d("MicroMsg.IPCallManager", "onCallStateChanged ".concat(String.valueOf(paramInt)));
    if (paramInt == 2)
    {
      ad.i("MicroMsg.IPCallManager", "system phone call state offhook, stop call");
      this.szF.fT(0, 0);
    }
    AppMethodBeat.o(25288);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.c.1
 * JD-Core Version:    0.7.0.1
 */