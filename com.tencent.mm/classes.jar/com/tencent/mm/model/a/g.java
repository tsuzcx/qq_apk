package com.tencent.mm.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class g
  implements aw
{
  private c gPR = null;
  
  private static g asW()
  {
    AppMethodBeat.i(153100);
    g localg = (g)t.ap(g.class);
    AppMethodBeat.o(153100);
    return localg;
  }
  
  public static c asX()
  {
    AppMethodBeat.i(153103);
    com.tencent.mm.kernel.g.afz().aeD();
    if (asW().gPR == null) {
      asW().gPR = new c();
    }
    c localc = asW().gPR;
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
    c localc = asX();
    long l = System.currentTimeMillis();
    try
    {
      localc.uA((String)com.tencent.mm.kernel.g.afB().afk().get(328193, null));
      if (localc.asV()) {
        f.uC(localc.gPM.gPI);
      }
      ad.i("MicroMsg.abtest.AbTestManager", "[Abtest] init use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(153101);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.abtest.AbTestManager", "[Abtest] updateAbTestCase exception:%s", new Object[] { localException.toString() });
      }
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(153102);
    c localc = asX();
    localc.gPN = null;
    localc.gPM = null;
    AppMethodBeat.o(153102);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.a.g
 * JD-Core Version:    0.7.0.1
 */