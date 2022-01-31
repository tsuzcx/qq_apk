package com.tencent.mm.plugin.hardwareopt.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.auq;

public class a
{
  private static volatile a nGU = null;
  private auq nGV = null;
  
  public static a bHP()
  {
    AppMethodBeat.i(59273);
    if (nGU == null) {
      try
      {
        if (nGU == null) {
          nGU = new a();
        }
        a locala1 = nGU;
        return locala1;
      }
      finally
      {
        AppMethodBeat.o(59273);
      }
    }
    a locala2 = nGU;
    AppMethodBeat.o(59273);
    return locala2;
  }
  
  public final auq bHQ()
  {
    AppMethodBeat.i(59274);
    if (this.nGV == null) {
      this.nGV = new auq();
    }
    auq localauq = this.nGV;
    AppMethodBeat.o(59274);
    return localauq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hardwareopt.b.a
 * JD-Core Version:    0.7.0.1
 */