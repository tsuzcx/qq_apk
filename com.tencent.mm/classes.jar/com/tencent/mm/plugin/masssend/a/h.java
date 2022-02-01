package com.tencent.mm.plugin.masssend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.c;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class h
  implements ax
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private cd.a vDx;
  private b vHl;
  private c vHm;
  private i vHn;
  private g vHo;
  
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
  
  public h()
  {
    AppMethodBeat.i(26366);
    this.vHn = new i();
    this.vHo = new g();
    this.vDx = new cd.a()
    {
      public final void a(e.a paramAnonymousa)
      {
        AppMethodBeat.i(26365);
        paramAnonymousa = z.a(paramAnonymousa.gqE.Fvk);
        ad.i("MicroMsg.SubCoreMassSend", "MassSendTopConfXml:".concat(String.valueOf(paramAnonymousa)));
        h.dkU().apm(paramAnonymousa);
        h.dkU().dkP();
        h.dkU();
        c.xX(bt.flT());
        AppMethodBeat.o(26365);
      }
      
      public final void a(e.c paramAnonymousc) {}
    };
    AppMethodBeat.o(26366);
  }
  
  private static h dkS()
  {
    AppMethodBeat.i(26367);
    ba.aBK();
    h localh2 = (h)ca.By("plugin.masssend");
    h localh1 = localh2;
    if (localh2 == null)
    {
      localh1 = new h();
      ba.aBK().a("plugin.favorite", localh1);
    }
    AppMethodBeat.o(26367);
    return localh1;
  }
  
  public static b dkT()
  {
    AppMethodBeat.i(26368);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dkS().vHl == null)
    {
      localObject = dkS();
      ba.aBQ();
      ((h)localObject).vHl = new b(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = dkS().vHl;
    AppMethodBeat.o(26368);
    return localObject;
  }
  
  public static c dkU()
  {
    AppMethodBeat.i(26369);
    if (dkS().vHm == null) {
      dkS().vHm = new c();
    }
    c localc = dkS().vHm;
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
    ba.getSysCmdMsgExtension().a("masssendapp", this.vDx, false);
    com.tencent.mm.sdk.b.a.IbL.c(this.vHn);
    com.tencent.mm.sdk.b.a.IbL.c(this.vHo);
    AppMethodBeat.o(26371);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(26370);
    ba.getSysCmdMsgExtension().b("masssendapp", this.vDx, false);
    com.tencent.mm.sdk.b.a.IbL.d(this.vHn);
    com.tencent.mm.sdk.b.a.IbL.d(this.vHo);
    AppMethodBeat.o(26370);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.h
 * JD-Core Version:    0.7.0.1
 */