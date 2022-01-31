package com.tencent.mm.plugin.ipcall;

import android.telephony.PhoneStateListener;
import com.tencent.mm.sdk.platformtools.y;

final class c$1
  extends PhoneStateListener
{
  c$1(c paramc) {}
  
  public final void onCallStateChanged(int paramInt, String paramString)
  {
    super.onCallStateChanged(paramInt, paramString);
    y.d("MicroMsg.IPCallManager", "onCallStateChanged " + paramInt);
    if (paramInt == 2)
    {
      y.i("MicroMsg.IPCallManager", "system phone call state offhook, stop call");
      this.lor.da(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.c.1
 * JD-Core Version:    0.7.0.1
 */