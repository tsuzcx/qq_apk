package com.tencent.mm.plugin.expansions;

import android.util.Pair;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class c
{
  static final ArrayList<IDKey> qvX;
  static final List<Pair<String, Object>> qvY;
  
  static
  {
    AppMethodBeat.i(152978);
    qvX = new ArrayList();
    qvY = new ArrayList();
    AppMethodBeat.o(152978);
  }
  
  public static void cok()
  {
    AppMethodBeat.i(152974);
    com.tencent.mm.kernel.g.ajS().a(new com.tencent.mm.kernel.api.g()
    {
      public final void ML()
      {
        AppMethodBeat.i(152973);
        com.tencent.mm.kernel.g.ajS().b(this);
        c.access$000();
        AppMethodBeat.o(152973);
      }
      
      public final void ch(boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(152974);
  }
  
  public static void col()
  {
    AppMethodBeat.i(152976);
    Iterator localIterator = qvY.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      if ((localPair.second instanceof String)) {
        ae.i((String)localPair.first, "pending log: " + localPair.second);
      }
      if ((localPair.second instanceof Throwable)) {
        ae.printErrStackTrace((String)localPair.first, (Throwable)localPair.second, "pending exception", new Object[0]);
      }
    }
    qvY.clear();
    AppMethodBeat.o(152976);
  }
  
  public static void fQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(152975);
    qvY.add(new Pair(paramString1, paramString2));
    AppMethodBeat.o(152975);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.c
 * JD-Core Version:    0.7.0.1
 */