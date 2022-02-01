package com.tencent.mm.plugin.hardwareopt.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bjk;

public class a
{
  private static volatile a tCq = null;
  private bjk tCr = null;
  
  public static a cSQ()
  {
    AppMethodBeat.i(55555);
    if (tCq == null) {
      try
      {
        if (tCq == null) {
          tCq = new a();
        }
        a locala1 = tCq;
        return locala1;
      }
      finally
      {
        AppMethodBeat.o(55555);
      }
    }
    a locala2 = tCq;
    AppMethodBeat.o(55555);
    return locala2;
  }
  
  public final bjk cSR()
  {
    AppMethodBeat.i(55556);
    if (this.tCr == null) {
      this.tCr = new bjk();
    }
    bjk localbjk = this.tCr;
    AppMethodBeat.o(55556);
    return localbjk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.hardwareopt.b.a
 * JD-Core Version:    0.7.0.1
 */