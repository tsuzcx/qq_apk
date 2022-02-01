package com.tencent.mm.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class g
  implements aw
{
  private c hqr = null;
  
  private static g azN()
  {
    AppMethodBeat.i(153100);
    g localg = (g)t.ap(g.class);
    AppMethodBeat.o(153100);
    return localg;
  }
  
  public static c azO()
  {
    AppMethodBeat.i(153103);
    com.tencent.mm.kernel.g.agP().afT();
    if (azN().hqr == null) {
      azN().hqr = new c();
    }
    c localc = azN().hqr;
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
    c localc = azO();
    long l = System.currentTimeMillis();
    try
    {
      localc.yG((String)com.tencent.mm.kernel.g.agR().agA().get(328193, null));
      if (localc.azM()) {
        f.yI(localc.hqm.hqi);
      }
      ac.i("MicroMsg.abtest.AbTestManager", "[Abtest] init use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(153101);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.abtest.AbTestManager", "[Abtest] updateAbTestCase exception:%s", new Object[] { localException.toString() });
      }
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(153102);
    c localc = azO();
    localc.hqn = null;
    localc.hqm = null;
    AppMethodBeat.o(153102);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.a.g
 * JD-Core Version:    0.7.0.1
 */