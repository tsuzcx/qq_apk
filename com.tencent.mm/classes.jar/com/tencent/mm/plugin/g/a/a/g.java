package com.tencent.mm.plugin.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
  extends j
{
  private byte vuy = 0;
  
  final boolean bj(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22467);
    if (Util.isNullOrNil(paramArrayOfByte))
    {
      Log.e("MicroMsg.exdevice.IBeaconTLVSectionA", "valueByte is null or nil");
      AppMethodBeat.o(22467);
      return false;
    }
    if (2 != this.mLength)
    {
      Log.d("MicroMsg.exdevice.IBeaconTLVSectionA", "IBEACON_TLV_SECTION_A_LENGTH != mLength(%d)", new Object[] { Integer.valueOf(this.mLength) });
      AppMethodBeat.o(22467);
      return false;
    }
    this.vuy = paramArrayOfByte[0];
    AppMethodBeat.o(22467);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.g.a.a.g
 * JD-Core Version:    0.7.0.1
 */