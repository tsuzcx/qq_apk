package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.s;
import com.tencent.mm.sdk.platformtools.y;

public final class k
  extends ae
  implements f
{
  private int iZz = -1;
  private String jAa = null;
  private String juL = null;
  private String juM = null;
  
  public k(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.juL = paramString1;
    this.jAa = paramString2;
    this.juM = paramString3;
    this.iZz = paramInt;
  }
  
  public final boolean a(com.tencent.mm.plugin.exdevice.service.m paramm, d paramd)
  {
    y.i("MicroMsg.exdevice.MMWifiStatusSubscribeTaskExcuter", "execute MMWifiStatusSubscribeTaskExcuter. brandName=" + this.juL + ",deviceType=" + this.jAa + ",deviceId=" + this.juM + ",reqType=" + this.iZz);
    au.Dk().a(1090, this);
    paramm = new s(this.juL, this.jAa, this.juM, this.iZz);
    au.Dk().a(paramm, 0);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.exdevice.MMWifiStatusSubscribeTaskExcuter", "onSceneEnd. errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    au.Dk().b(1090, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.i.k
 * JD-Core Version:    0.7.0.1
 */