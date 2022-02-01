package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import java.util.ArrayList;
import java.util.concurrent.Callable;

final class ab$3
  implements Callable<ArrayList<String>>
{
  ab$3(String paramString) {}
  
  private ArrayList<String> bGU()
  {
    AppMethodBeat.i(206566);
    try
    {
      ArrayList localArrayList1 = new ArrayList();
      h.aHF().kcd.lCD.getHostByName(this.mvr, localArrayList1);
      AppMethodBeat.o(206566);
      return localArrayList1;
    }
    catch (Throwable localThrowable)
    {
      ArrayList localArrayList2 = new ArrayList(0);
      AppMethodBeat.o(206566);
      return localArrayList2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ab.3
 * JD-Core Version:    0.7.0.1
 */