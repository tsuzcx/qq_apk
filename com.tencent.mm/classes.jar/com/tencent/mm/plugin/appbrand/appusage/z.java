package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.protocal.protobuf.bid;
import java.util.concurrent.TimeUnit;

public final class z
  extends com.tencent.mm.al.a<bid>
{
  private static final long jPD;
  
  static
  {
    AppMethodBeat.i(44638);
    jPD = TimeUnit.MINUTES.toSeconds(5L);
    AppMethodBeat.o(44638);
  }
  
  public static void bcy()
  {
    AppMethodBeat.i(44635);
    if (!g.ajA().gAD)
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
      jPE = new a("DAILY", 0);
      jPF = new a("SEARCH", 1);
      jPG = new a[] { jPE, jPF };
      AppMethodBeat.o(44634);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.z
 * JD-Core Version:    0.7.0.1
 */