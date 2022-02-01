package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.s;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.Log;

public final class k
  extends ae
  implements i
{
  private String mDeviceType = null;
  private int rcy = -1;
  private String rzn = null;
  private String rzo = null;
  
  public k(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.rzn = paramString1;
    this.mDeviceType = paramString2;
    this.rzo = paramString3;
    this.rcy = paramInt;
  }
  
  public final boolean a(m paramm, d paramd)
  {
    AppMethodBeat.i(23812);
    Log.i("MicroMsg.exdevice.MMWifiStatusSubscribeTaskExcuter", "execute MMWifiStatusSubscribeTaskExcuter. brandName=" + this.rzn + ",deviceType=" + this.mDeviceType + ",deviceId=" + this.rzo + ",reqType=" + this.rcy);
    bg.azz().a(1090, this);
    paramm = new s(this.rzn, this.mDeviceType, this.rzo, this.rcy);
    bg.azz().a(paramm, 0);
    AppMethodBeat.o(23812);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(23811);
    Log.i("MicroMsg.exdevice.MMWifiStatusSubscribeTaskExcuter", "onSceneEnd. errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    bg.azz().b(1090, this);
    AppMethodBeat.o(23811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.k
 * JD-Core Version:    0.7.0.1
 */