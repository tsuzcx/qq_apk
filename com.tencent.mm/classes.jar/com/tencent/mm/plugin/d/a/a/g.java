package com.tencent.mm.plugin.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class g
  extends j
{
  private byte noP = 0;
  
  final boolean aF(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22467);
    if (bs.cv(paramArrayOfByte))
    {
      ac.e("MicroMsg.exdevice.IBeaconTLVSectionA", "valueByte is null or nil");
      AppMethodBeat.o(22467);
      return false;
    }
    if (2 != this.mLength)
    {
      ac.d("MicroMsg.exdevice.IBeaconTLVSectionA", "IBEACON_TLV_SECTION_A_LENGTH != mLength(%d)", new Object[] { Integer.valueOf(this.mLength) });
      AppMethodBeat.o(22467);
      return false;
    }
    this.noP = paramArrayOfByte[0];
    AppMethodBeat.o(22467);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.a.g
 * JD-Core Version:    0.7.0.1
 */