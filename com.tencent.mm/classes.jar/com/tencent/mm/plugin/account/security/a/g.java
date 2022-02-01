package com.tencent.mm.plugin.account.security.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class g
  implements ax
{
  private static HashMap<Integer, h.b> jhU;
  private e jhT;
  private c jhV;
  private c jhW;
  private c jhX;
  
  static
  {
    AppMethodBeat.i(125539);
    HashMap localHashMap = new HashMap();
    jhU = localHashMap;
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
    this.jhV = new g.2(this);
    this.jhW = new g.3(this);
    this.jhX = new g.4(this);
    AppMethodBeat.o(125534);
  }
  
  private static g aTF()
  {
    try
    {
      AppMethodBeat.i(125535);
      g localg = (g)t.ap(g.class);
      AppMethodBeat.o(125535);
      return localg;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static e aTG()
  {
    AppMethodBeat.i(125536);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (aTF().jhT == null) {
      aTF().jhT = new e(com.tencent.mm.kernel.g.ajC().gBq);
    }
    e locale = aTF().jhT;
    AppMethodBeat.o(125536);
    return locale;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return jhU;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(125537);
    com.tencent.mm.sdk.b.a.IbL.c(this.jhV);
    com.tencent.mm.sdk.b.a.IbL.c(this.jhW);
    com.tencent.mm.sdk.b.a.IbL.c(this.jhX);
    AppMethodBeat.o(125537);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(125538);
    com.tencent.mm.sdk.b.a.IbL.d(this.jhV);
    com.tencent.mm.sdk.b.a.IbL.d(this.jhW);
    com.tencent.mm.sdk.b.a.IbL.d(this.jhX);
    AppMethodBeat.o(125538);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.a.g
 * JD-Core Version:    0.7.0.1
 */