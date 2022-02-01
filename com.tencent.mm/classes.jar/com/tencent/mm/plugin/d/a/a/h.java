package com.tencent.mm.plugin.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.k.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.IOException;
import java.util.Arrays;

public final class h
  extends j
{
  private static final byte[] noQ = { 76, 0, 2, 21 };
  private byte[] noR = null;
  public byte[] noS = null;
  public short noT = -1;
  public short noU = -1;
  public int noV = 0;
  
  final boolean aF(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22468);
    if (bs.cv(paramArrayOfByte))
    {
      ac.e("MicroMsg.exdevice.IBeaconTLVSectionB", "valueByte is null or nil");
      AppMethodBeat.o(22468);
      return false;
    }
    if (26 != this.mLength)
    {
      ac.d("MicroMsg.exdevice.IBeaconTLVSectionB", "IBEACON_TLV_SECTION_B_LENGTH != mLength(%d) ", new Object[] { Integer.valueOf(this.mLength) });
      AppMethodBeat.o(22468);
      return false;
    }
    a locala = new a(paramArrayOfByte.length);
    locala.S(paramArrayOfByte, paramArrayOfByte.length);
    paramArrayOfByte = new byte[4];
    locala.R(paramArrayOfByte, 4);
    if (!Arrays.equals(paramArrayOfByte, noQ))
    {
      ac.d("MicroMsg.exdevice.IBeaconTLVSectionB", "Cannot find ibeacon cookies!!!");
      AppMethodBeat.o(22468);
      return false;
    }
    this.noR = paramArrayOfByte;
    this.noS = new byte[16];
    locala.R(this.noS, 16);
    try
    {
      this.noT = locala.readShort();
      this.noU = locala.readShort();
      paramArrayOfByte = new byte[1];
      locala.R(paramArrayOfByte, 1);
      this.noV = paramArrayOfByte[0];
      AppMethodBeat.o(22468);
      return true;
    }
    catch (IOException paramArrayOfByte)
    {
      ac.d("MicroMsg.exdevice.IBeaconTLVSectionB", "Read major/minor from autobuffer failed!!!");
      ac.printErrStackTrace("MicroMsg.exdevice.IBeaconTLVSectionB", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(22468);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.a.h
 * JD-Core Version:    0.7.0.1
 */