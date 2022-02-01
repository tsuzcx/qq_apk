package com.tencent.mm.plugin.hardwareopt.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bfs;

public class a
{
  private static volatile a suB = null;
  private bfs suC = null;
  
  public static a cFG()
  {
    AppMethodBeat.i(55555);
    if (suB == null) {
      try
      {
        if (suB == null) {
          suB = new a();
        }
        a locala1 = suB;
        return locala1;
      }
      finally
      {
        AppMethodBeat.o(55555);
      }
    }
    a locala2 = suB;
    AppMethodBeat.o(55555);
    return locala2;
  }
  
  public final bfs cFH()
  {
    AppMethodBeat.i(55556);
    if (this.suC == null) {
      this.suC = new bfs();
    }
    bfs localbfs = this.suC;
    AppMethodBeat.o(55556);
    return localbfs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hardwareopt.b.a
 * JD-Core Version:    0.7.0.1
 */