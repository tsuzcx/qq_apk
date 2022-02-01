package com.tencent.mm.plugin.masssend.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.ci;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class g
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private cl.a KJu;
  private b KNq;
  private c KNr;
  private UpdateMassSendPlaceTopListener KNs;
  private PostTaskMassSendListener KNt;
  
  static
  {
    AppMethodBeat.i(26372);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("MASSENDINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return b.SQL_CREATE;
      }
    });
    AppMethodBeat.o(26372);
  }
  
  public g()
  {
    AppMethodBeat.i(26366);
    this.KNs = new UpdateMassSendPlaceTopListener();
    this.KNt = new PostTaskMassSendListener();
    this.KJu = new cl.a()
    {
      public final void a(g.a paramAnonymousa)
      {
        AppMethodBeat.i(26365);
        paramAnonymousa = w.a(paramAnonymousa.mpN.YFG);
        Log.i("MicroMsg.SubCoreMassSend", "MassSendTopConfXml:".concat(String.valueOf(paramAnonymousa)));
        g.fZW().aKT(paramAnonymousa);
        g.fZW().fZR();
        g.fZW();
        c.sk(Util.nowMilliSecond());
        AppMethodBeat.o(26365);
      }
      
      public final void a(g.c paramAnonymousc) {}
    };
    AppMethodBeat.o(26366);
  }
  
  private static g fZU()
  {
    AppMethodBeat.i(26367);
    bh.bCt();
    g localg2 = (g)ci.Ka("plugin.masssend");
    g localg1 = localg2;
    if (localg2 == null)
    {
      localg1 = new g();
      bh.bCt().a("plugin.favorite", localg1);
    }
    AppMethodBeat.o(26367);
    return localg1;
  }
  
  public static b fZV()
  {
    AppMethodBeat.i(26368);
    h.baC().aZJ();
    if (fZU().KNq == null)
    {
      localObject = fZU();
      bh.bCz();
      ((g)localObject).KNq = new b(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = fZU().KNq;
    AppMethodBeat.o(26368);
    return localObject;
  }
  
  public static c fZW()
  {
    AppMethodBeat.i(26369);
    if (fZU().KNr == null) {
      fZU().KNr = new c();
    }
    c localc = fZU().KNr;
    AppMethodBeat.o(26369);
    return localc;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(26371);
    bh.getSysCmdMsgExtension().a("masssendapp", this.KJu, false);
    this.KNs.alive();
    this.KNt.alive();
    AppMethodBeat.o(26371);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(26370);
    bh.getSysCmdMsgExtension().b("masssendapp", this.KJu, false);
    this.KNs.dead();
    this.KNt.dead();
    AppMethodBeat.o(26370);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.model.g
 * JD-Core Version:    0.7.0.1
 */