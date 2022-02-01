package com.tencent.mm.plugin.expansions;

import android.util.Pair;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class d
{
  static final List<Pair<String, Object>> yFA;
  static final ArrayList<IDKey> yFz;
  
  static
  {
    AppMethodBeat.i(152978);
    yFz = new ArrayList();
    yFA = new ArrayList();
    AppMethodBeat.o(152978);
  }
  
  public static void dHv()
  {
    AppMethodBeat.i(152974);
    h.baF().a(new g()
    {
      public final void aDv()
      {
        AppMethodBeat.i(152973);
        h.baF().b(this);
        d.access$000();
        AppMethodBeat.o(152973);
      }
      
      public final void dZ(boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(152974);
  }
  
  public static void dHw()
  {
    AppMethodBeat.i(152976);
    Iterator localIterator = yFA.iterator();
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
    yFA.clear();
    AppMethodBeat.o(152976);
  }
  
  public static String getLastObbErrorInfo()
  {
    AppMethodBeat.i(273675);
    int i = MultiProcessMMKV.getDefault().getInt("expansions_error_reason", -1);
    AppMethodBeat.o(273675);
    return String.valueOf(i);
  }
  
  public static void hb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(152975);
    yFA.add(new Pair(paramString1, paramString2));
    AppMethodBeat.o(152975);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.d
 * JD-Core Version:    0.7.0.1
 */