package com.tencent.mm.plugin.masssend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.c;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class h
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private cc.a tsz;
  private b tvS;
  private c tvT;
  private i tvU;
  private g tvV;
  
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
    this.tvU = new i();
    this.tvV = new g();
    this.tsz = new cc.a()
    {
      public final void a(f.a paramAnonymousa)
      {
        AppMethodBeat.i(26365);
        paramAnonymousa = z.a(paramAnonymousa.fTo.Cxz);
        ad.i("MicroMsg.SubCoreMassSend", "MassSendTopConfXml:".concat(String.valueOf(paramAnonymousa)));
        h.cNT().afF(paramAnonymousa);
        h.cNT().cNO();
        h.cNT();
        c.rk(bt.eGO());
        AppMethodBeat.o(26365);
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    AppMethodBeat.o(26366);
  }
  
  private static h cNR()
  {
    AppMethodBeat.i(26367);
    az.arP();
    h localh2 = (h)bz.ut("plugin.masssend");
    h localh1 = localh2;
    if (localh2 == null)
    {
      localh1 = new h();
      az.arP().a("plugin.favorite", localh1);
    }
    AppMethodBeat.o(26367);
    return localh1;
  }
  
  public static b cNS()
  {
    AppMethodBeat.i(26368);
    com.tencent.mm.kernel.g.afz().aeD();
    if (cNR().tvS == null)
    {
      localObject = cNR();
      az.arV();
      ((h)localObject).tvS = new b(com.tencent.mm.model.c.afg());
    }
    Object localObject = cNR().tvS;
    AppMethodBeat.o(26368);
    return localObject;
  }
  
  public static c cNT()
  {
    AppMethodBeat.i(26369);
    if (cNR().tvT == null) {
      cNR().tvT = new c();
    }
    c localc = cNR().tvT;
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
    az.getSysCmdMsgExtension().a("masssendapp", this.tsz, false);
    com.tencent.mm.sdk.b.a.ESL.c(this.tvU);
    com.tencent.mm.sdk.b.a.ESL.c(this.tvV);
    AppMethodBeat.o(26371);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(26370);
    az.getSysCmdMsgExtension().b("masssendapp", this.tsz, false);
    com.tencent.mm.sdk.b.a.ESL.d(this.tvU);
    com.tencent.mm.sdk.b.a.ESL.d(this.tvV);
    AppMethodBeat.o(26370);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.h
 * JD-Core Version:    0.7.0.1
 */