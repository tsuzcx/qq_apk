package com.tencent.mm.plugin.exdevice.b;

import android.os.Message;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public final class k
  implements f
{
  public static k jtc = null;
  private final HashMap<Long, k.e> jtb = new HashMap();
  public HashMap<String, Integer> jtd = new HashMap();
  public ah mHandler = null;
  
  public static k aLm()
  {
    if (jtc != null) {
      return jtc;
    }
    k localk = new k();
    jtc = localk;
    return localk;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "******onSceneEnd******\r\n errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    k.b localb = new k.b((byte)0);
    localb.jsT = paramInt2;
    localb.jtf = paramInt1;
    localb.ghs = paramString;
    localb.jtg = paramm;
    this.mHandler.obtainMessage(2, localb).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.b.k
 * JD-Core Version:    0.7.0.1
 */