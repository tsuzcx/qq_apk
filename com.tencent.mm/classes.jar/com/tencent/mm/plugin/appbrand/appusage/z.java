package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.protocal.protobuf.bad;
import java.util.concurrent.TimeUnit;

public final class z
  extends c<bad>
{
  private static final long iVt;
  
  static
  {
    AppMethodBeat.i(44638);
    iVt = TimeUnit.MINUTES.toSeconds(5L);
    AppMethodBeat.o(44638);
  }
  
  public static void aSd()
  {
    AppMethodBeat.i(44635);
    if (!g.afz().gcn)
    {
      AppMethodBeat.o(44635);
      return;
    }
    g.ab(d.class);
    AppMethodBeat.o(44635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.z
 * JD-Core Version:    0.7.0.1
 */