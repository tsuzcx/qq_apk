package com.tencent.mm.plugin.hardwareopt.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cjd;

public class a
{
  private static volatile a Dtq = null;
  private cjd Dtr = null;
  
  public static a eCh()
  {
    AppMethodBeat.i(55555);
    if (Dtq == null) {
      try
      {
        if (Dtq == null) {
          Dtq = new a();
        }
        a locala1 = Dtq;
        return locala1;
      }
      finally
      {
        AppMethodBeat.o(55555);
      }
    }
    a locala2 = Dtq;
    AppMethodBeat.o(55555);
    return locala2;
  }
  
  public final cjd eCi()
  {
    AppMethodBeat.i(55556);
    if (this.Dtr == null) {
      this.Dtr = new cjd();
    }
    cjd localcjd = this.Dtr;
    AppMethodBeat.o(55556);
    return localcjd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.hardwareopt.b.a
 * JD-Core Version:    0.7.0.1
 */