package com.tencent.mm.plugin.account.security.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.b.c;
import java.util.HashMap;

public class g
  implements at
{
  private static HashMap<Integer, h.d> gBl;
  private e gBk;
  private c gBm;
  private c gBn;
  private c gBo;
  
  static
  {
    AppMethodBeat.i(69857);
    HashMap localHashMap = new HashMap();
    gBl = localHashMap;
    localHashMap.put(Integer.valueOf("SAFE_DEVICE_INFO_TABLE".hashCode()), new g.1());
    AppMethodBeat.o(69857);
  }
  
  public g()
  {
    AppMethodBeat.i(69852);
    this.gBm = new g.2(this);
    this.gBn = new g.3(this);
    this.gBo = new g.4(this);
    AppMethodBeat.o(69852);
  }
  
  private static g arc()
  {
    try
    {
      AppMethodBeat.i(69853);
      g localg = (g)q.S(g.class);
      AppMethodBeat.o(69853);
      return localg;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static e ard()
  {
    AppMethodBeat.i(69854);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (arc().gBk == null) {
      arc().gBk = new e(com.tencent.mm.kernel.g.RL().eHS);
    }
    e locale = arc().gBk;
    AppMethodBeat.o(69854);
    return locale;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return gBl;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(69855);
    com.tencent.mm.sdk.b.a.ymk.c(this.gBm);
    com.tencent.mm.sdk.b.a.ymk.c(this.gBn);
    com.tencent.mm.sdk.b.a.ymk.c(this.gBo);
    AppMethodBeat.o(69855);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(69856);
    com.tencent.mm.sdk.b.a.ymk.d(this.gBm);
    com.tencent.mm.sdk.b.a.ymk.d(this.gBn);
    com.tencent.mm.sdk.b.a.ymk.d(this.gBo);
    AppMethodBeat.o(69856);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.a.g
 * JD-Core Version:    0.7.0.1
 */