package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.recent.l;
import com.tencent.mm.protocal.protobuf.buw;
import java.util.concurrent.TimeUnit;

public final class y
  extends c<buw>
{
  private static final long kVD;
  
  static
  {
    AppMethodBeat.i(44638);
    kVD = TimeUnit.MINUTES.toSeconds(5L);
    AppMethodBeat.o(44638);
  }
  
  public static void bys()
  {
    AppMethodBeat.i(44635);
    if (!g.aAf().hpY)
    {
      AppMethodBeat.o(44635);
      return;
    }
    g.af(l.class);
    AppMethodBeat.o(44635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.y
 * JD-Core Version:    0.7.0.1
 */