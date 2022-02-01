package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.exdevice.model.af;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.Log;

public final class k
  extends af
  implements i
{
  private String mDeviceType = null;
  private int uFD = -1;
  private String veU = null;
  private String veV = null;
  
  public k(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.veU = paramString1;
    this.mDeviceType = paramString2;
    this.veV = paramString3;
    this.uFD = paramInt;
  }
  
  public final boolean a(m paramm, d paramd)
  {
    AppMethodBeat.i(23812);
    Log.i("MicroMsg.exdevice.MMWifiStatusSubscribeTaskExcuter", "execute MMWifiStatusSubscribeTaskExcuter. brandName=" + this.veU + ",deviceType=" + this.mDeviceType + ",deviceId=" + this.veV + ",reqType=" + this.uFD);
    bh.aGY().a(1090, this);
    paramm = new com.tencent.mm.plugin.exdevice.model.t(this.veU, this.mDeviceType, this.veV, this.uFD);
    bh.aGY().a(paramm, 0);
    AppMethodBeat.o(23812);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(23811);
    Log.i("MicroMsg.exdevice.MMWifiStatusSubscribeTaskExcuter", "onSceneEnd. errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    bh.aGY().b(1090, this);
    AppMethodBeat.o(23811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.k
 * JD-Core Version:    0.7.0.1
 */