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
  private static a ObL;
  
  public static a gLt()
  {
    try
    {
      AppMethodBeat.i(90773);
      if (ObL == null) {
        ObL = new a();
      }
      a locala = ObL;
      AppMethodBeat.o(90773);
      return locala;
    }
    finally {}
  }
  
  public static String gLu()
  {
    AppMethodBeat.i(90774);
    String str = h.baE().mCJ + "remark/";
    AppMethodBeat.o(90774);
    return str;
  }
  
  public final List<String> baM()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ah.a
 * JD-Core Version:    0.7.0.1
 */