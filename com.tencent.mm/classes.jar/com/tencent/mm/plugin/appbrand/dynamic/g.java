package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.network.p.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Collection;
import java.util.Iterator;

public final class g
{
  private static p.a lme;
  
  static
  {
    AppMethodBeat.i(121177);
    lme = new p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(121173);
        Bundle localBundle = new Bundle();
        localBundle.putInt("status", paramAnonymousInt);
        Iterator localIterator = i.bBL().bBM().iterator();
        while (localIterator.hasNext()) {
          h.a((String)localIterator.next(), localBundle, g.a.class, null);
        }
        AppMethodBeat.o(121173);
      }
    };
    AppMethodBeat.o(121177);
  }
  
  public static void initialize()
  {
    AppMethodBeat.i(121175);
    if (!MMApplicationContext.isMMProcess())
    {
      AppMethodBeat.o(121175);
      return;
    }
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().a(lme);
    AppMethodBeat.o(121175);
  }
  
  public static void release()
  {
    AppMethodBeat.i(121176);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().b(lme);
    AppMethodBeat.o(121176);
  }
  
  static final class a
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.g
 * JD-Core Version:    0.7.0.1
 */