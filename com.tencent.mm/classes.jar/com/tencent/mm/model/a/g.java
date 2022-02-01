package com.tencent.mm.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class g
  implements bd
{
  private c iGE = null;
  
  private static g aWS()
  {
    AppMethodBeat.i(153100);
    g localg = (g)y.at(g.class);
    AppMethodBeat.o(153100);
    return localg;
  }
  
  public static c aWT()
  {
    AppMethodBeat.i(153103);
    com.tencent.mm.kernel.g.aAf().azk();
    if (aWS().iGE == null) {
      aWS().iGE = new c();
    }
    c localc = aWS().iGE;
    AppMethodBeat.o(153103);
    return localc;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(153101);
    c localc = aWT();
    long l = System.currentTimeMillis();
    try
    {
      localc.KS((String)com.tencent.mm.kernel.g.aAh().azQ().get(328193, null));
      if (localc.aWR()) {
        f.KU(localc.iGz.iGw);
      }
      Log.i("MicroMsg.abtest.AbTestManager", "[Abtest] init use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(153101);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.abtest.AbTestManager", "[Abtest] updateAbTestCase exception:%s", new Object[] { localException.toString() });
      }
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(153102);
    c localc = aWT();
    localc.iGA = null;
    localc.iGz = null;
    AppMethodBeat.o(153102);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.a.g
 * JD-Core Version:    0.7.0.1
 */