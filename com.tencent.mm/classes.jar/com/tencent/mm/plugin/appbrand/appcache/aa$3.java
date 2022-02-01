package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import java.util.ArrayList;
import java.util.concurrent.Callable;

final class aa$3
  implements Callable<ArrayList<String>>
{
  aa$3(String paramString) {}
  
  private ArrayList<String> baA()
  {
    AppMethodBeat.i(212490);
    try
    {
      ArrayList localArrayList1 = new ArrayList();
      g.ajQ().gDv.hRo.getHostByName(this.iIk, localArrayList1);
      AppMethodBeat.o(212490);
      return localArrayList1;
    }
    catch (Throwable localThrowable)
    {
      ArrayList localArrayList2 = new ArrayList(0);
      AppMethodBeat.o(212490);
      return localArrayList2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aa.3
 * JD-Core Version:    0.7.0.1
 */