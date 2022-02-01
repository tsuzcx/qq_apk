package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import java.util.ArrayList;
import java.util.concurrent.Callable;

final class y$3
  implements Callable<ArrayList<String>>
{
  y$3(String paramString) {}
  
  private ArrayList<String> aWE()
  {
    AppMethodBeat.i(206845);
    try
    {
      ArrayList localArrayList1 = new ArrayList();
      g.agQ().ghe.hwg.getHostByName(this.ima, localArrayList1);
      AppMethodBeat.o(206845);
      return localArrayList1;
    }
    catch (Throwable localThrowable)
    {
      ArrayList localArrayList2 = new ArrayList(0);
      AppMethodBeat.o(206845);
      return localArrayList2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.y.3
 * JD-Core Version:    0.7.0.1
 */