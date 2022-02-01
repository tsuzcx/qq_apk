package com.tencent.mm.plugin.masssend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.c;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class h
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private ck.a EOW;
  private b ESM;
  private c ESN;
  private i ESO;
  private g ESP;
  
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
    this.ESO = new i();
    this.ESP = new g();
    this.EOW = new ck.a()
    {
      public final void a(h.a paramAnonymousa)
      {
        AppMethodBeat.i(26365);
        paramAnonymousa = z.a(paramAnonymousa.jQG.RIF);
        Log.i("MicroMsg.SubCoreMassSend", "MassSendTopConfXml:".concat(String.valueOf(paramAnonymousa)));
        h.eRn().aNW(paramAnonymousa);
        h.eRn().eRi();
        h.eRn();
        c.Op(Util.nowMilliSecond());
        AppMethodBeat.o(26365);
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    AppMethodBeat.o(26366);
  }
  
  private static h eRl()
  {
    AppMethodBeat.i(26367);
    bh.beC();
    h localh2 = (h)ch.RZ("plugin.masssend");
    h localh1 = localh2;
    if (localh2 == null)
    {
      localh1 = new h();
      bh.beC().a("plugin.favorite", localh1);
    }
    AppMethodBeat.o(26367);
    return localh1;
  }
  
  public static b eRm()
  {
    AppMethodBeat.i(26368);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (eRl().ESM == null)
    {
      localObject = eRl();
      bh.beI();
      ((h)localObject).ESM = new b(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = eRl().ESM;
    AppMethodBeat.o(26368);
    return localObject;
  }
  
  public static c eRn()
  {
    AppMethodBeat.i(26369);
    if (eRl().ESN == null) {
      eRl().ESN = new c();
    }
    c localc = eRl().ESN;
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
    bh.getSysCmdMsgExtension().a("masssendapp", this.EOW, false);
    EventCenter.instance.addListener(this.ESO);
    EventCenter.instance.addListener(this.ESP);
    AppMethodBeat.o(26371);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(26370);
    bh.getSysCmdMsgExtension().b("masssendapp", this.EOW, false);
    EventCenter.instance.removeListener(this.ESO);
    EventCenter.instance.removeListener(this.ESP);
    AppMethodBeat.o(26370);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.h
 * JD-Core Version:    0.7.0.1
 */