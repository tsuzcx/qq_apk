package com.tencent.mm.plugin.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.k.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
{
  private final g vtZ;
  public final h vua;
  
  public e()
  {
    AppMethodBeat.i(22442);
    this.vtZ = new g();
    this.vua = new h();
    AppMethodBeat.o(22442);
  }
  
  public final boolean bi(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22443);
    if (Util.isNullOrNil(paramArrayOfByte))
    {
      Log.e("MicroMsg.exdevice.IBeaconProtocal", "dataIn is null or nil");
      AppMethodBeat.o(22443);
      return false;
    }
    a locala = new a(paramArrayOfByte.length);
    locala.V(paramArrayOfByte, paramArrayOfByte.length);
    boolean bool = this.vtZ.a(locala);
    if (!bool)
    {
      Log.d("MicroMsg.exdevice.IBeaconProtocal", "mSectionA.ParseTLV Failed!!!");
      AppMethodBeat.o(22443);
      return bool;
    }
    bool = this.vua.a(locala);
    if (!bool)
    {
      Log.d("MicroMsg.exdevice.IBeaconProtocal", "mSectionB.ParseTLV Failed!!!");
      AppMethodBeat.o(22443);
      return bool;
    }
    AppMethodBeat.o(22443);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.g.a.a.e
 * JD-Core Version:    0.7.0.1
 */