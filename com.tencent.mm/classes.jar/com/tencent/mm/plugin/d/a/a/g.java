package com.tencent.mm.plugin.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class g
  extends j
{
  private byte jNA = 0;
  
  final boolean ar(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(18356);
    if (bo.ce(paramArrayOfByte))
    {
      ab.e("MicroMsg.exdevice.IBeaconTLVSectionA", "valueByte is null or nil");
      AppMethodBeat.o(18356);
      return false;
    }
    if (2 != this.mLength)
    {
      ab.d("MicroMsg.exdevice.IBeaconTLVSectionA", "IBEACON_TLV_SECTION_A_LENGTH != mLength(%d)", new Object[] { Integer.valueOf(this.mLength) });
      AppMethodBeat.o(18356);
      return false;
    }
    this.jNA = paramArrayOfByte[0];
    AppMethodBeat.o(18356);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.a.g
 * JD-Core Version:    0.7.0.1
 */