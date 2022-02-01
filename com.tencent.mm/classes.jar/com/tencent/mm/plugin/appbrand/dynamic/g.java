package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.kernel.b;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.Collection;
import java.util.Iterator;

public final class g
{
  private static n.a jkI;
  
  static
  {
    AppMethodBeat.i(121177);
    jkI = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(121173);
        Bundle localBundle = new Bundle();
        localBundle.putInt("status", paramAnonymousInt);
        Iterator localIterator = i.aVi().aVj().iterator();
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
    if (!aj.cbv())
    {
      AppMethodBeat.o(121175);
      return;
    }
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().a(jkI);
    AppMethodBeat.o(121175);
  }
  
  public static void release()
  {
    AppMethodBeat.i(121176);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().b(jkI);
    AppMethodBeat.o(121176);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.g
 * JD-Core Version:    0.7.0.1
 */