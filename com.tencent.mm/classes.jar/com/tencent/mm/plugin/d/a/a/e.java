package com.tencent.mm.plugin.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class e
{
  private final g mMe;
  public final h mMf;
  
  public e()
  {
    AppMethodBeat.i(22442);
    this.mMe = new g();
    this.mMf = new h();
    AppMethodBeat.o(22442);
  }
  
  public final boolean aF(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22443);
    if (bt.cw(paramArrayOfByte))
    {
      ad.e("MicroMsg.exdevice.IBeaconProtocal", "dataIn is null or nil");
      AppMethodBeat.o(22443);
      return false;
    }
    a locala = new a(paramArrayOfByte.length);
    locala.U(paramArrayOfByte, paramArrayOfByte.length);
    boolean bool = this.mMe.a(locala);
    if (!bool)
    {
      ad.d("MicroMsg.exdevice.IBeaconProtocal", "mSectionA.ParseTLV Failed!!!");
      AppMethodBeat.o(22443);
      return bool;
    }
    bool = this.mMf.a(locala);
    if (!bool)
    {
      ad.d("MicroMsg.exdevice.IBeaconProtocal", "mSectionB.ParseTLV Failed!!!");
      AppMethodBeat.o(22443);
      return bool;
    }
    AppMethodBeat.o(22443);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.a.e
 * JD-Core Version:    0.7.0.1
 */