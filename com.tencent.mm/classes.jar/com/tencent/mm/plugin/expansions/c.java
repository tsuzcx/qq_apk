package com.tencent.mm.plugin.expansions;

import android.util.Pair;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class c
{
  static final ArrayList<IDKey> vto;
  static final List<Pair<String, Object>> vtp;
  
  static
  {
    AppMethodBeat.i(152978);
    vto = new ArrayList();
    vtp = new ArrayList();
    AppMethodBeat.o(152978);
  }
  
  public static void dbj()
  {
    AppMethodBeat.i(152974);
    h.aHH().a(new g()
    {
      public final void abB()
      {
        AppMethodBeat.i(152973);
        h.aHH().b(this);
        c.access$000();
        AppMethodBeat.o(152973);
      }
      
      public final void dn(boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(152974);
  }
  
  public static void dbk()
  {
    AppMethodBeat.i(152976);
    Iterator localIterator = vtp.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      if ((localPair.second instanceof String)) {
        Log.i((String)localPair.first, "pending log: " + localPair.second);
      }
      if ((localPair.second instanceof Throwable)) {
        Log.printErrStackTrace((String)localPair.first, (Throwable)localPair.second, "pending exception", new Object[0]);
      }
    }
    vtp.clear();
    AppMethodBeat.o(152976);
  }
  
  public static void gx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(152975);
    vtp.add(new Pair(paramString1, paramString2));
    AppMethodBeat.o(152975);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.c
 * JD-Core Version:    0.7.0.1
 */