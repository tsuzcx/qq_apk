package com.tencent.mm.plugin.hardwareopt.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bns;

public class a
{
  private static volatile a uEZ = null;
  private bns uFa = null;
  
  public static a dbX()
  {
    AppMethodBeat.i(55555);
    if (uEZ == null) {
      try
      {
        if (uEZ == null) {
          uEZ = new a();
        }
        a locala1 = uEZ;
        return locala1;
      }
      finally
      {
        AppMethodBeat.o(55555);
      }
    }
    a locala2 = uEZ;
    AppMethodBeat.o(55555);
    return locala2;
  }
  
  public final bns dbY()
  {
    AppMethodBeat.i(55556);
    if (this.uFa == null) {
      this.uFa = new bns();
    }
    bns localbns = this.uFa;
    AppMethodBeat.o(55556);
    return localbns;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.hardwareopt.b.a
 * JD-Core Version:    0.7.0.1
 */