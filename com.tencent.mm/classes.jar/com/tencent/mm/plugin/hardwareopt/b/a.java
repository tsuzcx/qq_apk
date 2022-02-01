package com.tencent.mm.plugin.hardwareopt.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cbc;

public class a
{
  private static volatile a yjo = null;
  private cbc yjp = null;
  
  public static a dYJ()
  {
    AppMethodBeat.i(55555);
    if (yjo == null) {
      try
      {
        if (yjo == null) {
          yjo = new a();
        }
        a locala1 = yjo;
        return locala1;
      }
      finally
      {
        AppMethodBeat.o(55555);
      }
    }
    a locala2 = yjo;
    AppMethodBeat.o(55555);
    return locala2;
  }
  
  public final cbc dYK()
  {
    AppMethodBeat.i(55556);
    if (this.yjp == null) {
      this.yjp = new cbc();
    }
    cbc localcbc = this.yjp;
    AppMethodBeat.o(55556);
    return localcbc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.hardwareopt.b.a
 * JD-Core Version:    0.7.0.1
 */