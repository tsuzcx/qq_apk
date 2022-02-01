package com.tencent.mm.plugin.hardwareopt.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.czg;

public class a
{
  private static volatile a JmG = null;
  private czg JmH = null;
  
  public static a fKi()
  {
    AppMethodBeat.i(55555);
    if (JmG == null) {
      try
      {
        if (JmG == null) {
          JmG = new a();
        }
        a locala1 = JmG;
        return locala1;
      }
      finally
      {
        AppMethodBeat.o(55555);
      }
    }
    a locala2 = JmG;
    AppMethodBeat.o(55555);
    return locala2;
  }
  
  public final czg fKj()
  {
    AppMethodBeat.i(55556);
    if (this.JmH == null) {
      this.JmH = new czg();
    }
    czg localczg = this.JmH;
    AppMethodBeat.o(55556);
    return localczg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.hardwareopt.b.a
 * JD-Core Version:    0.7.0.1
 */