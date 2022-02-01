package com.tencent.mm.plugin.masssend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class h
  implements az
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private cf.a vPB;
  private b vTp;
  private c vTq;
  private i vTr;
  private g vTs;
  
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
    this.vTr = new i();
    this.vTs = new g();
    this.vPB = new cf.a()
    {
      public final void a(e.a paramAnonymousa)
      {
        AppMethodBeat.i(26365);
        paramAnonymousa = z.a(paramAnonymousa.gte.FNI);
        ae.i("MicroMsg.SubCoreMassSend", "MassSendTopConfXml:".concat(String.valueOf(paramAnonymousa)));
        h.dnU().aqr(paramAnonymousa);
        h.dnU().dnP();
        h.dnU();
        c.yr(bu.fpO());
        AppMethodBeat.o(26365);
      }
      
      public final void a(e.c paramAnonymousc) {}
    };
    AppMethodBeat.o(26366);
  }
  
  private static h dnS()
  {
    AppMethodBeat.i(26367);
    bc.aCa();
    h localh2 = (h)cc.Ca("plugin.masssend");
    h localh1 = localh2;
    if (localh2 == null)
    {
      localh1 = new h();
      bc.aCa().a("plugin.favorite", localh1);
    }
    AppMethodBeat.o(26367);
    return localh1;
  }
  
  public static b dnT()
  {
    AppMethodBeat.i(26368);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dnS().vTp == null)
    {
      localObject = dnS();
      bc.aCg();
      ((h)localObject).vTp = new b(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = dnS().vTp;
    AppMethodBeat.o(26368);
    return localObject;
  }
  
  public static c dnU()
  {
    AppMethodBeat.i(26369);
    if (dnS().vTq == null) {
      dnS().vTq = new c();
    }
    c localc = dnS().vTq;
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
    bc.getSysCmdMsgExtension().a("masssendapp", this.vPB, false);
    com.tencent.mm.sdk.b.a.IvT.c(this.vTr);
    com.tencent.mm.sdk.b.a.IvT.c(this.vTs);
    AppMethodBeat.o(26371);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(26370);
    bc.getSysCmdMsgExtension().b("masssendapp", this.vPB, false);
    com.tencent.mm.sdk.b.a.IvT.d(this.vTr);
    com.tencent.mm.sdk.b.a.IvT.d(this.vTs);
    AppMethodBeat.o(26370);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.h
 * JD-Core Version:    0.7.0.1
 */