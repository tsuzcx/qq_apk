package com.tencent.mm.plugin.account.security.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.y;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class g
  implements be
{
  private static HashMap<Integer, h.b> pXO;
  private e pXN;
  private IListener pXP;
  private IListener pXQ;
  private IListener pXR;
  
  static
  {
    AppMethodBeat.i(125539);
    HashMap localHashMap = new HashMap();
    pXO = localHashMap;
    localHashMap.put(Integer.valueOf("SAFE_DEVICE_INFO_TABLE".hashCode()), new g.1());
    AppMethodBeat.o(125539);
  }
  
  public g()
  {
    AppMethodBeat.i(125534);
    this.pXP = new SubCoreSafeDevice.2(this, com.tencent.mm.app.f.hfK);
    this.pXQ = new SubCoreSafeDevice.3(this, com.tencent.mm.app.f.hfK);
    this.pXR = new SubCoreSafeDevice.4(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(125534);
  }
  
  private static g bXR()
  {
    try
    {
      AppMethodBeat.i(125535);
      g localg = (g)y.aL(g.class);
      AppMethodBeat.o(125535);
      return localg;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static e bXS()
  {
    AppMethodBeat.i(125536);
    h.baC().aZJ();
    if (bXR().pXN == null) {
      bXR().pXN = new e(h.baE().mCN);
    }
    e locale = bXR().pXN;
    AppMethodBeat.o(125536);
    return locale;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return pXO;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(125537);
    this.pXP.alive();
    this.pXQ.alive();
    this.pXR.alive();
    AppMethodBeat.o(125537);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(125538);
    this.pXP.dead();
    this.pXQ.dead();
    this.pXR.dead();
    AppMethodBeat.o(125538);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.model.g
 * JD-Core Version:    0.7.0.1
 */