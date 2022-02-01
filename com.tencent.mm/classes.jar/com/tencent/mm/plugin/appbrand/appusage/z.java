package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.protocal.protobuf.bit;
import java.util.concurrent.TimeUnit;

public final class z
  extends com.tencent.mm.ak.a<bit>
{
  private static final long jSV;
  
  static
  {
    AppMethodBeat.i(44638);
    jSV = TimeUnit.MINUTES.toSeconds(5L);
    AppMethodBeat.o(44638);
  }
  
  public static void bdd()
  {
    AppMethodBeat.i(44635);
    if (!g.ajP().gDk)
    {
      AppMethodBeat.o(44635);
      return;
    }
    g.ab(d.class);
    AppMethodBeat.o(44635);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(44634);
      jSW = new a("DAILY", 0);
      jSX = new a("SEARCH", 1);
      jSY = new a[] { jSW, jSX };
      AppMethodBeat.o(44634);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.z
 * JD-Core Version:    0.7.0.1
 */