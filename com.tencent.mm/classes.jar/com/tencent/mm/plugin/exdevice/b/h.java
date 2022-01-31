package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.exdevice.e.c;
import com.tencent.mm.plugin.exdevice.e.n;
import com.tencent.mm.sdk.platformtools.y;

public final class h
  extends j
{
  public h(int paramInt1, int paramInt2, long paramLong)
  {
    n localn = new n();
    localn.jxA = new c();
    localn.jxE = paramInt1;
    localn.jxF = paramInt2;
    this.jsX = localn;
    this.hXu = paramLong;
    this.jsV = 30002;
  }
  
  public final byte[] aLj()
  {
    try
    {
      byte[] arrayOfByte = this.jsX.toByteArray();
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.exdevice.ExDeviceCmdSwitchViewPush", "mResp.toByteArray() Failed!!! %s", new Object[] { localException.getMessage() });
    }
    return null;
  }
  
  public final int aLl()
  {
    n localn = (n)this.jsX;
    if (localn == null)
    {
      y.e("MicroMsg.exdevice.ExDeviceCmdSwitchViewPush", "null = pushReq");
      return -1;
    }
    return localn.jxE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.b.h
 * JD-Core Version:    0.7.0.1
 */