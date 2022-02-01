package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;

public final class o
{
  public static void a(a parama, String paramString)
  {
    AppMethodBeat.i(48172);
    e.ywz.f(14750, new Object[] { Integer.valueOf(parama.value), paramString });
    AppMethodBeat.o(48172);
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(48171);
      myT = new a("GUIDE_EXPOSE", 0, 1);
      myU = new a("GUIDE_CLOSE", 1, 2);
      myV = new a("TO_APP_LAUNCHER", 2, 3);
      myW = new a("GUIDE_CLOSE_BY_BACK", 3, 4);
      myX = new a[] { myT, myU, myV, myW };
      AppMethodBeat.o(48171);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.o
 * JD-Core Version:    0.7.0.1
 */