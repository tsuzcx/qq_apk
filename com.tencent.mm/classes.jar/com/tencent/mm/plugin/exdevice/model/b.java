package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  implements f
{
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.exdevice.ExDeviceMessageService", "onScenend, errType = %d, errCode = %d, errMsg = ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.b
 * JD-Core Version:    0.7.0.1
 */