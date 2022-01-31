package com.tencent.mm.plugin.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.j.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.util.Arrays;

public final class h
  extends j
{
  private static final byte[] jNB = { 76, 0, 2, 21 };
  private byte[] jNC = null;
  public byte[] jND = null;
  public short jNE = -1;
  public short jNF = -1;
  public int jNG = 0;
  
  final boolean ar(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(18357);
    if (bo.ce(paramArrayOfByte))
    {
      ab.e("MicroMsg.exdevice.IBeaconTLVSectionB", "valueByte is null or nil");
      AppMethodBeat.o(18357);
      return false;
    }
    if (26 != this.mLength)
    {
      ab.d("MicroMsg.exdevice.IBeaconTLVSectionB", "IBEACON_TLV_SECTION_B_LENGTH != mLength(%d) ", new Object[] { Integer.valueOf(this.mLength) });
      AppMethodBeat.o(18357);
      return false;
    }
    a locala = new a(paramArrayOfByte.length);
    locala.Q(paramArrayOfByte, paramArrayOfByte.length);
    paramArrayOfByte = new byte[4];
    locala.P(paramArrayOfByte, 4);
    if (!Arrays.equals(paramArrayOfByte, jNB))
    {
      ab.d("MicroMsg.exdevice.IBeaconTLVSectionB", "Cannot find ibeacon cookies!!!");
      AppMethodBeat.o(18357);
      return false;
    }
    this.jNC = paramArrayOfByte;
    this.jND = new byte[16];
    locala.P(this.jND, 16);
    try
    {
      this.jNE = locala.readShort();
      this.jNF = locala.readShort();
      paramArrayOfByte = new byte[1];
      locala.P(paramArrayOfByte, 1);
      this.jNG = paramArrayOfByte[0];
      AppMethodBeat.o(18357);
      return true;
    }
    catch (IOException paramArrayOfByte)
    {
      ab.d("MicroMsg.exdevice.IBeaconTLVSectionB", "Read major/minor from autobuffer failed!!!");
      ab.printErrStackTrace("MicroMsg.exdevice.IBeaconTLVSectionB", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(18357);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.a.h
 * JD-Core Version:    0.7.0.1
 */