package com.tencent.mm.plugin.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.k.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.Arrays;

public final class h
  extends j
{
  private static final byte[] pgp = { 76, 0, 2, 21 };
  private byte[] pgq = null;
  public byte[] pgr = null;
  public short pgs = -1;
  public short pgt = -1;
  public int pgu = 0;
  
  final boolean aW(byte[] paramArrayOfByte)
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
    locala.U(paramArrayOfByte, paramArrayOfByte.length);
    paramArrayOfByte = new byte[4];
    locala.T(paramArrayOfByte, 4);
    if (!Arrays.equals(paramArrayOfByte, pgp))
    {
      Log.d("MicroMsg.exdevice.IBeaconTLVSectionB", "Cannot find ibeacon cookies!!!");
      AppMethodBeat.o(22468);
      return false;
    }
    this.pgq = paramArrayOfByte;
    this.pgr = new byte[16];
    locala.T(this.pgr, 16);
    try
    {
      this.pgs = locala.readShort();
      this.pgt = locala.readShort();
      paramArrayOfByte = new byte[1];
      locala.T(paramArrayOfByte, 1);
      this.pgu = paramArrayOfByte[0];
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.a.h
 * JD-Core Version:    0.7.0.1
 */