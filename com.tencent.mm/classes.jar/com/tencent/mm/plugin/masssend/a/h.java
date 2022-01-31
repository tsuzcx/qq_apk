package com.tencent.mm.plugin.masssend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.bz.a;
import java.util.HashMap;

public final class h
  implements at
{
  private static HashMap<Integer, h.d> baseDBFactories;
  private b oBn;
  private c oBo;
  private i oBp;
  private g oBq;
  private bz.a oxY;
  
  static
  {
    AppMethodBeat.i(22751);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("MASSENDINFO_TABLE".hashCode()), new h.1());
    AppMethodBeat.o(22751);
  }
  
  public h()
  {
    AppMethodBeat.i(22745);
    this.oBp = new i();
    this.oBq = new g();
    this.oxY = new h.2(this);
    AppMethodBeat.o(22745);
  }
  
  private static h bPb()
  {
    AppMethodBeat.i(22746);
    aw.aat();
    h localh2 = (h)bw.pF("plugin.masssend");
    h localh1 = localh2;
    if (localh2 == null)
    {
      localh1 = new h();
      aw.aat().a("plugin.favorite", localh1);
    }
    AppMethodBeat.o(22746);
    return localh1;
  }
  
  public static b bPc()
  {
    AppMethodBeat.i(22747);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (bPb().oBn == null)
    {
      localObject = bPb();
      aw.aaz();
      ((h)localObject).oBn = new b(com.tencent.mm.model.c.Rq());
    }
    Object localObject = bPb().oBn;
    AppMethodBeat.o(22747);
    return localObject;
  }
  
  public static c bPd()
  {
    AppMethodBeat.i(22748);
    if (bPb().oBo == null) {
      bPb().oBo = new c();
    }
    c localc = bPb().oBo;
    AppMethodBeat.o(22748);
    return localc;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.d> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(22750);
    aw.getSysCmdMsgExtension().a("masssendapp", this.oxY, false);
    com.tencent.mm.sdk.b.a.ymk.c(this.oBp);
    com.tencent.mm.sdk.b.a.ymk.c(this.oBq);
    AppMethodBeat.o(22750);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(22749);
    aw.getSysCmdMsgExtension().b("masssendapp", this.oxY, false);
    com.tencent.mm.sdk.b.a.ymk.d(this.oBp);
    com.tencent.mm.sdk.b.a.ymk.d(this.oBq);
    AppMethodBeat.o(22749);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.h
 * JD-Core Version:    0.7.0.1
 */