package com.tencent.mm.plugin.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.k.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class e
{
  private final g noq;
  public final h nor;
  
  public e()
  {
    AppMethodBeat.i(22442);
    this.noq = new g();
    this.nor = new h();
    AppMethodBeat.o(22442);
  }
  
  public final boolean aE(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22443);
    if (bs.cv(paramArrayOfByte))
    {
      ac.e("MicroMsg.exdevice.IBeaconProtocal", "dataIn is null or nil");
      AppMethodBeat.o(22443);
      return false;
    }
    a locala = new a(paramArrayOfByte.length);
    locala.S(paramArrayOfByte, paramArrayOfByte.length);
    boolean bool = this.noq.a(locala);
    if (!bool)
    {
      ac.d("MicroMsg.exdevice.IBeaconProtocal", "mSectionA.ParseTLV Failed!!!");
      AppMethodBeat.o(22443);
      return bool;
    }
    bool = this.nor.a(locala);
    if (!bool)
    {
      ac.d("MicroMsg.exdevice.IBeaconProtocal", "mSectionB.ParseTLV Failed!!!");
      AppMethodBeat.o(22443);
      return bool;
    }
    AppMethodBeat.o(22443);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.a.e
 * JD-Core Version:    0.7.0.1
 */