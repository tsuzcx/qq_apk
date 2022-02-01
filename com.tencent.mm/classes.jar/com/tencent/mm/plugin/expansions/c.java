package com.tencent.mm.plugin.expansions;

import android.util.Pair;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class c
{
  static final ArrayList<IDKey> piE;
  static final List<Pair<String, Object>> piF;
  
  static
  {
    AppMethodBeat.i(152978);
    piE = new ArrayList();
    piF = new ArrayList();
    AppMethodBeat.o(152978);
  }
  
  public static void cbh()
  {
    AppMethodBeat.i(152974);
    com.tencent.mm.kernel.g.afC().a(new com.tencent.mm.kernel.api.g()
    {
      public final void Lk()
      {
        AppMethodBeat.i(152973);
        com.tencent.mm.kernel.g.afC().b(this);
        c.access$000();
        AppMethodBeat.o(152973);
      }
      
      public final void ce(boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(152974);
  }
  
  public static void cbi()
  {
    AppMethodBeat.i(152976);
    Iterator localIterator = piF.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      if ((localPair.second instanceof String)) {
        ad.i((String)localPair.first, "pending log: " + localPair.second);
      }
      if ((localPair.second instanceof Throwable)) {
        ad.printErrStackTrace((String)localPair.first, (Throwable)localPair.second, "pending exception", new Object[0]);
      }
    }
    piF.clear();
    AppMethodBeat.o(152976);
  }
  
  public static void fp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(152975);
    piF.add(new Pair(paramString1, paramString2));
    AppMethodBeat.o(152975);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.c
 * JD-Core Version:    0.7.0.1
 */