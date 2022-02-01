package com.tencent.mm.plugin.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.b.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import java.util.List;

public final class a
  implements b, c
{
  private static a Ifr;
  
  public static a fzH()
  {
    try
    {
      AppMethodBeat.i(90773);
      if (Ifr == null) {
        Ifr = new a();
      }
      a locala = Ifr;
      AppMethodBeat.o(90773);
      return locala;
    }
    finally {}
  }
  
  public static String fzI()
  {
    AppMethodBeat.i(90774);
    String str = h.aHG().kcB + "remark/";
    AppMethodBeat.o(90774);
    return str;
  }
  
  public final List<String> aHP()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ah.a
 * JD-Core Version:    0.7.0.1
 */