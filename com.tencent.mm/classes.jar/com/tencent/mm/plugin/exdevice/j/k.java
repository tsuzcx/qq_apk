package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.s;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.ad;

public final class k
  extends ae
  implements g
{
  private String mDeviceType = null;
  private String oUW = null;
  private String oUX = null;
  private int oyr = -1;
  
  public k(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.oUW = paramString1;
    this.mDeviceType = paramString2;
    this.oUX = paramString3;
    this.oyr = paramInt;
  }
  
  public final boolean a(m paramm, d paramd)
  {
    AppMethodBeat.i(23812);
    ad.i("MicroMsg.exdevice.MMWifiStatusSubscribeTaskExcuter", "execute MMWifiStatusSubscribeTaskExcuter. brandName=" + this.oUW + ",deviceType=" + this.mDeviceType + ",deviceId=" + this.oUX + ",reqType=" + this.oyr);
    az.aeS().a(1090, this);
    paramm = new s(this.oUW, this.mDeviceType, this.oUX, this.oyr);
    az.aeS().a(paramm, 0);
    AppMethodBeat.o(23812);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(23811);
    ad.i("MicroMsg.exdevice.MMWifiStatusSubscribeTaskExcuter", "onSceneEnd. errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    az.aeS().b(1090, this);
    AppMethodBeat.o(23811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.k
 * JD-Core Version:    0.7.0.1
 */