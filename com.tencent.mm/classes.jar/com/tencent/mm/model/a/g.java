package com.tencent.mm.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;
import java.util.HashMap;

public class g
  implements at
{
  private c fop = null;
  
  private static g abv()
  {
    AppMethodBeat.i(118151);
    g localg = (g)q.S(g.class);
    AppMethodBeat.o(118151);
    return localg;
  }
  
  public static c abw()
  {
    AppMethodBeat.i(118154);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (abv().fop == null) {
      abv().fop = new c();
    }
    c localc = abv().fop;
    AppMethodBeat.o(118154);
    return localc;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(118152);
    c localc = abw();
    long l = System.currentTimeMillis();
    try
    {
      localc.pM((String)com.tencent.mm.kernel.g.RL().Ru().get(328193, null));
      if (localc.abu()) {
        f.pO(localc.foj.fof);
      }
      ab.i("MicroMsg.abtest.AbTestManager", "[Abtest] init use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(118152);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.abtest.AbTestManager", "[Abtest] updateAbTestCase exception:%s", new Object[] { localException.toString() });
      }
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(118153);
    c localc = abw();
    localc.fok = null;
    localc.foj = null;
    AppMethodBeat.o(118153);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.a.g
 * JD-Core Version:    0.7.0.1
 */