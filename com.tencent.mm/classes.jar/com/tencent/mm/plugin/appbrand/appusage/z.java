package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.protocal.protobuf.bdv;
import java.util.concurrent.TimeUnit;

public final class z
  extends c<bdv>
{
  private static final long jvJ;
  
  static
  {
    AppMethodBeat.i(44638);
    jvJ = TimeUnit.MINUTES.toSeconds(5L);
    AppMethodBeat.o(44638);
  }
  
  public static void aZa()
  {
    AppMethodBeat.i(44635);
    if (!g.agP().ggT)
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
      jvK = new a("DAILY", 0);
      jvL = new a("SEARCH", 1);
      jvM = new a[] { jvK, jvL };
      AppMethodBeat.o(44634);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.z
 * JD-Core Version:    0.7.0.1
 */