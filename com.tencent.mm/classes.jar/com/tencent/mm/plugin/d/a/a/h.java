package com.tencent.mm.plugin.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.util.Arrays;

public final class h
  extends j
{
  private static final byte[] mME = { 76, 0, 2, 21 };
  private byte[] mMF = null;
  public byte[] mMG = null;
  public short mMH = -1;
  public short mMI = -1;
  public int mMJ = 0;
  
  final boolean aG(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22468);
    if (bt.cw(paramArrayOfByte))
    {
      ad.e("MicroMsg.exdevice.IBeaconTLVSectionB", "valueByte is null or nil");
      AppMethodBeat.o(22468);
      return false;
    }
    if (26 != this.mLength)
    {
      ad.d("MicroMsg.exdevice.IBeaconTLVSectionB", "IBEACON_TLV_SECTION_B_LENGTH != mLength(%d) ", new Object[] { Integer.valueOf(this.mLength) });
      AppMethodBeat.o(22468);
      return false;
    }
    a locala = new a(paramArrayOfByte.length);
    locala.U(paramArrayOfByte, paramArrayOfByte.length);
    paramArrayOfByte = new byte[4];
    locala.T(paramArrayOfByte, 4);
    if (!Arrays.equals(paramArrayOfByte, mME))
    {
      ad.d("MicroMsg.exdevice.IBeaconTLVSectionB", "Cannot find ibeacon cookies!!!");
      AppMethodBeat.o(22468);
      return false;
    }
    this.mMF = paramArrayOfByte;
    this.mMG = new byte[16];
    locala.T(this.mMG, 16);
    try
    {
      this.mMH = locala.readShort();
      this.mMI = locala.readShort();
      paramArrayOfByte = new byte[1];
      locala.T(paramArrayOfByte, 1);
      this.mMJ = paramArrayOfByte[0];
      AppMethodBeat.o(22468);
      return true;
    }
    catch (IOException paramArrayOfByte)
    {
      ad.d("MicroMsg.exdevice.IBeaconTLVSectionB", "Read major/minor from autobuffer failed!!!");
      ad.printErrStackTrace("MicroMsg.exdevice.IBeaconTLVSectionB", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(22468);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.a.h
 * JD-Core Version:    0.7.0.1
 */