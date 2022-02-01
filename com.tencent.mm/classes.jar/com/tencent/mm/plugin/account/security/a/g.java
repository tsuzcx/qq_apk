package com.tencent.mm.plugin.account.security.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ka;
import com.tencent.mm.g.a.kb;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class g
  implements bd
{
  private static HashMap<Integer, h.b> kiQ;
  private e kiP;
  private IListener kiR;
  private IListener kiS;
  private IListener kiT;
  
  static
  {
    AppMethodBeat.i(125539);
    HashMap localHashMap = new HashMap();
    kiQ = localHashMap;
    localHashMap.put(Integer.valueOf("SAFE_DEVICE_INFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return e.SQL_CREATE;
      }
    });
    AppMethodBeat.o(125539);
  }
  
  public g()
  {
    AppMethodBeat.i(125534);
    this.kiR = new g.2(this);
    this.kiS = new IListener() {};
    this.kiT = new IListener() {};
    AppMethodBeat.o(125534);
  }
  
  private static g boQ()
  {
    try
    {
      AppMethodBeat.i(125535);
      g localg = (g)y.at(g.class);
      AppMethodBeat.o(125535);
      return localg;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static e boR()
  {
    AppMethodBeat.i(125536);
    com.tencent.mm.kernel.g.aAf().azk();
    if (boQ().kiP == null) {
      boQ().kiP = new e(com.tencent.mm.kernel.g.aAh().hqK);
    }
    e locale = boQ().kiP;
    AppMethodBeat.o(125536);
    return locale;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return kiQ;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(125537);
    EventCenter.instance.addListener(this.kiR);
    EventCenter.instance.addListener(this.kiS);
    EventCenter.instance.addListener(this.kiT);
    AppMethodBeat.o(125537);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(125538);
    EventCenter.instance.removeListener(this.kiR);
    EventCenter.instance.removeListener(this.kiS);
    EventCenter.instance.removeListener(this.kiT);
    AppMethodBeat.o(125538);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.a.g
 * JD-Core Version:    0.7.0.1
 */