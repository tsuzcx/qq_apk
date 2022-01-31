package com.tencent.mm.plugin.f.a.a;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class g
  extends j
{
  private byte hTG = 0;
  
  final boolean Y(byte[] paramArrayOfByte)
  {
    if (bk.bE(paramArrayOfByte))
    {
      y.e("MicroMsg.exdevice.IBeaconTLVSectionA", "valueByte is null or nil");
      return false;
    }
    if (2 != this.mLength)
    {
      y.d("MicroMsg.exdevice.IBeaconTLVSectionA", "IBEACON_TLV_SECTION_A_LENGTH != mLength(%d)", new Object[] { Integer.valueOf(this.mLength) });
      return false;
    }
    this.hTG = paramArrayOfByte[0];
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.a.g
 * JD-Core Version:    0.7.0.1
 */