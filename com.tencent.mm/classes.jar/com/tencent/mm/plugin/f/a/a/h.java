package com.tencent.mm.plugin.f.a.a;

import com.tencent.mm.plugin.exdevice.j.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.util.Arrays;

public final class h
  extends j
{
  private static final byte[] hTH = { 76, 0, 2, 21 };
  private byte[] hTI = null;
  public byte[] hTJ = null;
  public short hTK = -1;
  public short hTL = -1;
  public int hTM = 0;
  
  final boolean Y(byte[] paramArrayOfByte)
  {
    if (bk.bE(paramArrayOfByte))
    {
      y.e("MicroMsg.exdevice.IBeaconTLVSectionB", "valueByte is null or nil");
      return false;
    }
    if (26 != this.mLength)
    {
      y.d("MicroMsg.exdevice.IBeaconTLVSectionB", "IBEACON_TLV_SECTION_B_LENGTH != mLength(%d) ", new Object[] { Integer.valueOf(this.mLength) });
      return false;
    }
    a locala = new a(paramArrayOfByte.length);
    locala.P(paramArrayOfByte, paramArrayOfByte.length);
    paramArrayOfByte = new byte[4];
    locala.O(paramArrayOfByte, 4);
    if (!Arrays.equals(paramArrayOfByte, hTH))
    {
      y.d("MicroMsg.exdevice.IBeaconTLVSectionB", "Cannot find ibeacon cookies!!!");
      return false;
    }
    this.hTI = paramArrayOfByte;
    this.hTJ = new byte[16];
    locala.O(this.hTJ, 16);
    try
    {
      this.hTK = locala.readShort();
      this.hTL = locala.readShort();
      paramArrayOfByte = new byte[1];
      locala.O(paramArrayOfByte, 1);
      this.hTM = paramArrayOfByte[0];
      return true;
    }
    catch (IOException paramArrayOfByte)
    {
      y.d("MicroMsg.exdevice.IBeaconTLVSectionB", "Read major/minor from autobuffer failed!!!");
      y.printErrStackTrace("MicroMsg.exdevice.IBeaconTLVSectionB", paramArrayOfByte, "", new Object[0]);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.a.h
 * JD-Core Version:    0.7.0.1
 */