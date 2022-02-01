package com.tencent.mm.plugin.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.k.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.Arrays;

public final class h
  extends j
{
  private static final byte[] vuz = { 76, 0, 2, 21 };
  private byte[] vuA = null;
  public byte[] vuB = null;
  public short vuC = -1;
  public short vuD = -1;
  public int vuE = 0;
  
  final boolean bj(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22468);
    if (Util.isNullOrNil(paramArrayOfByte))
    {
      Log.e("MicroMsg.exdevice.IBeaconTLVSectionB", "valueByte is null or nil");
      AppMethodBeat.o(22468);
      return false;
    }
    if (26 != this.mLength)
    {
      Log.d("MicroMsg.exdevice.IBeaconTLVSectionB", "IBEACON_TLV_SECTION_B_LENGTH != mLength(%d) ", new Object[] { Integer.valueOf(this.mLength) });
      AppMethodBeat.o(22468);
      return false;
    }
    a locala = new a(paramArrayOfByte.length);
    locala.V(paramArrayOfByte, paramArrayOfByte.length);
    paramArrayOfByte = new byte[4];
    locala.U(paramArrayOfByte, 4);
    if (!Arrays.equals(paramArrayOfByte, vuz))
    {
      Log.d("MicroMsg.exdevice.IBeaconTLVSectionB", "Cannot find ibeacon cookies!!!");
      AppMethodBeat.o(22468);
      return false;
    }
    this.vuA = paramArrayOfByte;
    this.vuB = new byte[16];
    locala.U(this.vuB, 16);
    try
    {
      this.vuC = locala.readShort();
      this.vuD = locala.readShort();
      paramArrayOfByte = new byte[1];
      locala.U(paramArrayOfByte, 1);
      this.vuE = paramArrayOfByte[0];
      AppMethodBeat.o(22468);
      return true;
    }
    catch (IOException paramArrayOfByte)
    {
      Log.d("MicroMsg.exdevice.IBeaconTLVSectionB", "Read major/minor from autobuffer failed!!!");
      Log.printErrStackTrace("MicroMsg.exdevice.IBeaconTLVSectionB", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(22468);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.g.a.a.h
 * JD-Core Version:    0.7.0.1
 */