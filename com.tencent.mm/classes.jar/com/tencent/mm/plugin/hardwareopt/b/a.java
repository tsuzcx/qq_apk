package com.tencent.mm.plugin.hardwareopt.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bok;

public class a
{
  private static volatile a uQM = null;
  private bok uQN = null;
  
  public static a deP()
  {
    AppMethodBeat.i(55555);
    if (uQM == null) {
      try
      {
        if (uQM == null) {
          uQM = new a();
        }
        a locala1 = uQM;
        return locala1;
      }
      finally
      {
        AppMethodBeat.o(55555);
      }
    }
    a locala2 = uQM;
    AppMethodBeat.o(55555);
    return locala2;
  }
  
  public final bok deQ()
  {
    AppMethodBeat.i(55556);
    if (this.uQN == null) {
      this.uQN = new bok();
    }
    bok localbok = this.uQN;
    AppMethodBeat.o(55556);
    return localbok;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.hardwareopt.b.a
 * JD-Core Version:    0.7.0.1
 */