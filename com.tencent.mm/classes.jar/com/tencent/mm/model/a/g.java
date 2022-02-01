package com.tencent.mm.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class g
  implements az
{
  private c hLC = null;
  
  private static g aDg()
  {
    AppMethodBeat.i(153100);
    g localg = (g)u.ap(g.class);
    AppMethodBeat.o(153100);
    return localg;
  }
  
  public static c aDh()
  {
    AppMethodBeat.i(153103);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (aDg().hLC == null) {
      aDg().hLC = new c();
    }
    c localc = aDg().hLC;
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
    c localc = aDh();
    long l = System.currentTimeMillis();
    try
    {
      localc.Ch((String)com.tencent.mm.kernel.g.ajR().ajA().get(328193, null));
      if (localc.aDf()) {
        f.Cj(localc.hLx.hLt);
      }
      ae.i("MicroMsg.abtest.AbTestManager", "[Abtest] init use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(153101);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.abtest.AbTestManager", "[Abtest] updateAbTestCase exception:%s", new Object[] { localException.toString() });
      }
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(153102);
    c localc = aDh();
    localc.hLy = null;
    localc.hLx = null;
    AppMethodBeat.o(153102);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.a.g
 * JD-Core Version:    0.7.0.1
 */