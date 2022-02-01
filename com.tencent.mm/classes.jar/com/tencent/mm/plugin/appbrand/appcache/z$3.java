package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import java.util.ArrayList;
import java.util.concurrent.Callable;

final class z$3
  implements Callable<ArrayList<String>>
{
  z$3(String paramString) {}
  
  private ArrayList<String> bab()
  {
    AppMethodBeat.i(207429);
    try
    {
      ArrayList localArrayList1 = new ArrayList();
      g.ajB().gAO.hOv.getHostByName(this.iFr, localArrayList1);
      AppMethodBeat.o(207429);
      return localArrayList1;
    }
    catch (Throwable localThrowable)
    {
      ArrayList localArrayList2 = new ArrayList(0);
      AppMethodBeat.o(207429);
      return localArrayList2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.z.3
 * JD-Core Version:    0.7.0.1
 */