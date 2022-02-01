package com.tencent.mm.plugin.masssend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class h
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private cc.a uAS;
  private b uEl;
  private c uEm;
  private i uEn;
  private g uEo;
  
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
    this.uEn = new i();
    this.uEo = new g();
    this.uAS = new cc.a()
    {
      public final void a(f.a paramAnonymousa)
      {
        AppMethodBeat.i(26365);
        paramAnonymousa = z.a(paramAnonymousa.fXi.DPV);
        ac.i("MicroMsg.SubCoreMassSend", "MassSendTopConfXml:".concat(String.valueOf(paramAnonymousa)));
        h.dbA().akz(paramAnonymousa);
        h.dbA().dbv();
        h.dbA();
        c.vN(bs.eWj());
        AppMethodBeat.o(26365);
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    AppMethodBeat.o(26366);
  }
  
  public static c dbA()
  {
    AppMethodBeat.i(26369);
    if (dby().uEm == null) {
      dby().uEm = new c();
    }
    c localc = dby().uEm;
    AppMethodBeat.o(26369);
    return localc;
  }
  
  private static h dby()
  {
    AppMethodBeat.i(26367);
    az.ayG();
    h localh2 = (h)bz.yz("plugin.masssend");
    h localh1 = localh2;
    if (localh2 == null)
    {
      localh1 = new h();
      az.ayG().a("plugin.favorite", localh1);
    }
    AppMethodBeat.o(26367);
    return localh1;
  }
  
  public static b dbz()
  {
    AppMethodBeat.i(26368);
    com.tencent.mm.kernel.g.agP().afT();
    if (dby().uEl == null)
    {
      localObject = dby();
      az.ayM();
      ((h)localObject).uEl = new b(com.tencent.mm.model.c.agw());
    }
    Object localObject = dby().uEl;
    AppMethodBeat.o(26368);
    return localObject;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(26371);
    az.getSysCmdMsgExtension().a("masssendapp", this.uAS, false);
    com.tencent.mm.sdk.b.a.GpY.c(this.uEn);
    com.tencent.mm.sdk.b.a.GpY.c(this.uEo);
    AppMethodBeat.o(26371);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(26370);
    az.getSysCmdMsgExtension().b("masssendapp", this.uAS, false);
    com.tencent.mm.sdk.b.a.GpY.d(this.uEn);
    com.tencent.mm.sdk.b.a.GpY.d(this.uEo);
    AppMethodBeat.o(26370);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.h
 * JD-Core Version:    0.7.0.1
 */