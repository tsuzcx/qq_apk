package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.p.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Collection;
import java.util.Iterator;

public final class g
{
  private static p.a rku;
  
  static
  {
    AppMethodBeat.i(121177);
    rku = new p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(121173);
        Bundle localBundle = new Bundle();
        localBundle.putInt("status", paramAnonymousInt);
        Iterator localIterator = i.cnw().cnx().iterator();
        while (localIterator.hasNext()) {
          j.a((String)localIterator.next(), localBundle, g.a.class, null);
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
    h.baF();
    h.baD().a(rku);
    AppMethodBeat.o(121175);
  }
  
  public static void release()
  {
    AppMethodBeat.i(121176);
    h.baF();
    h.baD().b(rku);
    AppMethodBeat.o(121176);
  }
  
  static final class a
    implements d<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.g
 * JD-Core Version:    0.7.0.1
 */