package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.exdevice.model.ai;
import com.tencent.mm.plugin.exdevice.model.v;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.Log;

public final class k
  extends ai
  implements h
{
  private String mDeviceType = null;
  private int xOf = -1;
  private String yqR = null;
  private String yqS = null;
  
  public k(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.yqR = paramString1;
    this.mDeviceType = paramString2;
    this.yqS = paramString3;
    this.xOf = paramInt;
  }
  
  public final boolean a(m paramm, d paramd)
  {
    AppMethodBeat.i(23812);
    Log.i("MicroMsg.exdevice.MMWifiStatusSubscribeTaskExcuter", "execute MMWifiStatusSubscribeTaskExcuter. brandName=" + this.yqR + ",deviceType=" + this.mDeviceType + ",deviceId=" + this.yqS + ",reqType=" + this.xOf);
    bh.aZW().a(1090, this);
    paramm = new v(this.yqR, this.mDeviceType, this.yqS, this.xOf);
    bh.aZW().a(paramm, 0);
    AppMethodBeat.o(23812);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(23811);
    Log.i("MicroMsg.exdevice.MMWifiStatusSubscribeTaskExcuter", "onSceneEnd. errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    bh.aZW().b(1090, this);
    AppMethodBeat.o(23811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.k
 * JD-Core Version:    0.7.0.1
 */