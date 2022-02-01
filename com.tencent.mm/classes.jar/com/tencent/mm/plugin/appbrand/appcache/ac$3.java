package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import java.util.ArrayList;
import java.util.concurrent.Callable;

final class ac$3
  implements Callable<ArrayList<String>>
{
  ac$3(String paramString) {}
  
  private ArrayList<String> cgq()
  {
    AppMethodBeat.i(320284);
    try
    {
      ArrayList localArrayList1 = new ArrayList();
      h.baD().mCm.oun.getHostByName(this.poQ, localArrayList1);
      AppMethodBeat.o(320284);
      return localArrayList1;
    }
    finally
    {
      ArrayList localArrayList2 = new ArrayList(0);
      AppMethodBeat.o(320284);
      return localArrayList2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ac.3
 * JD-Core Version:    0.7.0.1
 */