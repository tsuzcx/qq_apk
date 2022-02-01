package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;

public final class r
{
  public static void a(a parama, String paramString)
  {
    AppMethodBeat.i(48172);
    f.Ozc.b(14750, new Object[] { Integer.valueOf(parama.value), paramString });
    AppMethodBeat.o(48172);
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(48171);
      tQR = new a("GUIDE_EXPOSE", 0, 1);
      tQS = new a("GUIDE_CLOSE", 1, 2);
      tQT = new a("TO_APP_LAUNCHER", 2, 3);
      tQU = new a("GUIDE_CLOSE_BY_BACK", 3, 4);
      tQV = new a[] { tQR, tQS, tQT, tQU };
      AppMethodBeat.o(48171);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.r
 * JD-Core Version:    0.7.0.1
 */