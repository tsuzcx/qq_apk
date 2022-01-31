package com.tencent.mm.plugin.f.a.a;

import com.tencent.mm.plugin.exdevice.j.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class e
{
  private final g hTh = new g();
  public final h hTi = new h();
  
  public final boolean X(byte[] paramArrayOfByte)
  {
    boolean bool1;
    if (bk.bE(paramArrayOfByte))
    {
      y.e("MicroMsg.exdevice.IBeaconProtocal", "dataIn is null or nil");
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      a locala = new a(paramArrayOfByte.length);
      locala.P(paramArrayOfByte, paramArrayOfByte.length);
      bool1 = this.hTh.a(locala);
      if (!bool1)
      {
        y.d("MicroMsg.exdevice.IBeaconProtocal", "mSectionA.ParseTLV Failed!!!");
        return bool1;
      }
      bool2 = this.hTi.a(locala);
      bool1 = bool2;
    } while (bool2);
    y.d("MicroMsg.exdevice.IBeaconProtocal", "mSectionB.ParseTLV Failed!!!");
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.a.e
 * JD-Core Version:    0.7.0.1
 */