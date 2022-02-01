package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.exdevice.model.s;
import com.tencent.mm.plugin.exdevice.service.m;

public final class k
  extends com.tencent.mm.plugin.exdevice.model.ae
  implements f
{
  private String mDeviceType = null;
  private int pMf = -1;
  private String qir = null;
  private String qis = null;
  
  public k(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.qir = paramString1;
    this.mDeviceType = paramString2;
    this.qis = paramString3;
    this.pMf = paramInt;
  }
  
  public final boolean a(m paramm, d paramd)
  {
    AppMethodBeat.i(23812);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.MMWifiStatusSubscribeTaskExcuter", "execute MMWifiStatusSubscribeTaskExcuter. brandName=" + this.qir + ",deviceType=" + this.mDeviceType + ",deviceId=" + this.qis + ",reqType=" + this.pMf);
    bc.ajj().a(1090, this);
    paramm = new s(this.qir, this.mDeviceType, this.qis, this.pMf);
    bc.ajj().a(paramm, 0);
    AppMethodBeat.o(23812);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(23811);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.MMWifiStatusSubscribeTaskExcuter", "onSceneEnd. errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    bc.ajj().b(1090, this);
    AppMethodBeat.o(23811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.k
 * JD-Core Version:    0.7.0.1
 */