package com.tencent.mm.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class g
  implements ax
{
  private c hIJ = null;
  
  private static g aCQ()
  {
    AppMethodBeat.i(153100);
    g localg = (g)t.ap(g.class);
    AppMethodBeat.o(153100);
    return localg;
  }
  
  public static c aCR()
  {
    AppMethodBeat.i(153103);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (aCQ().hIJ == null) {
      aCQ().hIJ = new c();
    }
    c localc = aCQ().hIJ;
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
    c localc = aCR();
    long l = System.currentTimeMillis();
    try
    {
      localc.BF((String)com.tencent.mm.kernel.g.ajC().ajl().get(328193, null));
      if (localc.aCP()) {
        f.BH(localc.hIE.hIA);
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
    c localc = aCR();
    localc.hIF = null;
    localc.hIE = null;
    AppMethodBeat.o(153102);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.a.g
 * JD-Core Version:    0.7.0.1
 */