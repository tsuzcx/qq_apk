package com.tencent.mm.model.c;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.d;
import java.util.HashMap;

public class c
  implements at
{
  @SuppressLint({"UseSparseArrays"})
  private static HashMap<Integer, h.d> baseDBFactories;
  private d foR;
  private com.tencent.mm.storage.b foS;
  private bz.a foT;
  private com.tencent.mm.sdk.b.c foU;
  private k.a foV;
  private com.tencent.mm.vending.b.b foW;
  private final com.tencent.mm.plugin.auth.a.a foX;
  
  static
  {
    AppMethodBeat.i(118187);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("NEW_ABTEST_TABLE".hashCode()), new c.5());
    baseDBFactories.put(Integer.valueOf("NEW_ABTEST_INFO_TABLE".hashCode()), new c.6());
    AppMethodBeat.o(118187);
  }
  
  public c()
  {
    AppMethodBeat.i(118180);
    this.foT = new bz.a()
    {
      public final void a(e.a paramAnonymousa)
      {
        AppMethodBeat.i(118175);
        paramAnonymousa = aa.a(paramAnonymousa.eyJ.woR);
        ab.d("MicroMsg.SubCoreNewABTest", "Message content(abtest): %s".concat(String.valueOf(paramAnonymousa)));
        paramAnonymousa = a.pX(paramAnonymousa);
        if (paramAnonymousa == null)
        {
          AppMethodBeat.o(118175);
          return;
        }
        c.abU().r(paramAnonymousa.items, 1);
        c.abV().r(paramAnonymousa.foQ, 2);
        AppMethodBeat.o(118175);
      }
    };
    this.foU = new c.2(this);
    this.foV = new c.3(this);
    this.foW = null;
    this.foX = new c.4(this);
    AppMethodBeat.o(118180);
  }
  
  private static c abT()
  {
    try
    {
      AppMethodBeat.i(118181);
      c localc = (c)q.S(c.class);
      AppMethodBeat.o(118181);
      return localc;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static d abU()
  {
    AppMethodBeat.i(118182);
    g.RJ().QQ();
    if (abT().foR == null) {
      abT().foR = new d(g.RL().eHS);
    }
    d locald = abT().foR;
    AppMethodBeat.o(118182);
    return locald;
  }
  
  public static com.tencent.mm.storage.b abV()
  {
    AppMethodBeat.i(118183);
    g.RJ().QQ();
    if (abT().foS == null) {
      abT().foS = new com.tencent.mm.storage.b(g.RL().eHS);
    }
    com.tencent.mm.storage.b localb = abT().foS;
    AppMethodBeat.o(118183);
    return localb;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(118184);
    ((p)g.G(p.class)).getSysCmdMsgExtension().a("newabtest", this.foT, true);
    ((p)g.G(p.class)).getSysCmdMsgExtension().a("newabtestinfo", this.foT, true);
    com.tencent.mm.sdk.b.a.ymk.c(this.foU);
    abU().add(this.foV);
    this.foW = ((com.tencent.mm.plugin.auth.a.b)g.G(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(this.foX);
    AppMethodBeat.o(118184);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(118185);
    ((p)g.G(p.class)).getSysCmdMsgExtension().b("newabtest", this.foT, true);
    ((p)g.G(p.class)).getSysCmdMsgExtension().b("newabtestinfo", this.foT, true);
    com.tencent.mm.sdk.b.a.ymk.d(this.foU);
    abU().remove(this.foV);
    if (this.foW != null)
    {
      this.foW.dead();
      this.foW = null;
    }
    AppMethodBeat.o(118185);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.c.c
 * JD-Core Version:    0.7.0.1
 */