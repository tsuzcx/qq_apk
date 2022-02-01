package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.widget.recent.k;
import com.tencent.mm.protocal.protobuf.cco;
import java.util.concurrent.TimeUnit;

public final class y
  extends c<cco>
{
  private static final long nPQ;
  
  static
  {
    AppMethodBeat.i(44638);
    nPQ = TimeUnit.MINUTES.toSeconds(5L);
    AppMethodBeat.o(44638);
  }
  
  public static void bJG()
  {
    AppMethodBeat.i(44635);
    if (!h.aHE().kbT)
    {
      AppMethodBeat.o(44635);
      return;
    }
    h.ae(k.class);
    AppMethodBeat.o(44635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.y
 * JD-Core Version:    0.7.0.1
 */