package com.tencent.mm.plugin.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.j.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class e
{
  private final g jNb;
  public final h jNc;
  
  public e()
  {
    AppMethodBeat.i(18331);
    this.jNb = new g();
    this.jNc = new h();
    AppMethodBeat.o(18331);
  }
  
  public final boolean aq(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(18332);
    if (bo.ce(paramArrayOfByte))
    {
      ab.e("MicroMsg.exdevice.IBeaconProtocal", "dataIn is null or nil");
      AppMethodBeat.o(18332);
      return false;
    }
    a locala = new a(paramArrayOfByte.length);
    locala.Q(paramArrayOfByte, paramArrayOfByte.length);
    boolean bool = this.jNb.a(locala);
    if (!bool)
    {
      ab.d("MicroMsg.exdevice.IBeaconProtocal", "mSectionA.ParseTLV Failed!!!");
      AppMethodBeat.o(18332);
      return bool;
    }
    bool = this.jNc.a(locala);
    if (!bool)
    {
      ab.d("MicroMsg.exdevice.IBeaconProtocal", "mSectionB.ParseTLV Failed!!!");
      AppMethodBeat.o(18332);
      return bool;
    }
    AppMethodBeat.o(18332);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.a.e
 * JD-Core Version:    0.7.0.1
 */