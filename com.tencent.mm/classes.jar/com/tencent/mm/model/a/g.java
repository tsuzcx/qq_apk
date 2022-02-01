package com.tencent.mm.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class g
  implements be
{
  private c oof = null;
  
  private static g bDQ()
  {
    AppMethodBeat.i(153100);
    g localg = (g)y.aL(g.class);
    AppMethodBeat.o(153100);
    return localg;
  }
  
  public static c bDR()
  {
    AppMethodBeat.i(153103);
    h.baC().aZJ();
    if (bDQ().oof == null) {
      bDQ().oof = new c();
    }
    c localc = bDQ().oof;
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
    c localc = bDR();
    long l = System.currentTimeMillis();
    try
    {
      localc.Kn((String)h.baE().ban().d(328193, null));
      if (localc.bDP()) {
        f.Kp(localc.ooa.onX);
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
    c localc = bDR();
    localc.oob = null;
    localc.ooa = null;
    AppMethodBeat.o(153102);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.a.g
 * JD-Core Version:    0.7.0.1
 */