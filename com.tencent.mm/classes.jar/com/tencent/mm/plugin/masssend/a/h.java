package com.tencent.mm.plugin.masssend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cg;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class h
  implements bd
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private cj.a zjF;
  private b znv;
  private c znw;
  private i znx;
  private g zny;
  
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
    this.znx = new i();
    this.zny = new g();
    this.zjF = new cj.a()
    {
      public final void a(h.a paramAnonymousa)
      {
        AppMethodBeat.i(26365);
        paramAnonymousa = z.a(paramAnonymousa.heO.KHn);
        Log.i("MicroMsg.SubCoreMassSend", "MassSendTopConfXml:".concat(String.valueOf(paramAnonymousa)));
        h.ehG().aDM(paramAnonymousa);
        h.ehG().ehB();
        h.ehG();
        c.Ha(Util.nowMilliSecond());
        AppMethodBeat.o(26365);
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    AppMethodBeat.o(26366);
  }
  
  private static h ehE()
  {
    AppMethodBeat.i(26367);
    bg.aVz();
    h localh2 = (h)cg.KG("plugin.masssend");
    h localh1 = localh2;
    if (localh2 == null)
    {
      localh1 = new h();
      bg.aVz().a("plugin.favorite", localh1);
    }
    AppMethodBeat.o(26367);
    return localh1;
  }
  
  public static b ehF()
  {
    AppMethodBeat.i(26368);
    com.tencent.mm.kernel.g.aAf().azk();
    if (ehE().znv == null)
    {
      localObject = ehE();
      bg.aVF();
      ((h)localObject).znv = new b(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = ehE().znv;
    AppMethodBeat.o(26368);
    return localObject;
  }
  
  public static c ehG()
  {
    AppMethodBeat.i(26369);
    if (ehE().znw == null) {
      ehE().znw = new c();
    }
    c localc = ehE().znw;
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
    bg.getSysCmdMsgExtension().a("masssendapp", this.zjF, false);
    EventCenter.instance.addListener(this.znx);
    EventCenter.instance.addListener(this.zny);
    AppMethodBeat.o(26371);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(26370);
    bg.getSysCmdMsgExtension().b("masssendapp", this.zjF, false);
    EventCenter.instance.removeListener(this.znx);
    EventCenter.instance.removeListener(this.zny);
    AppMethodBeat.o(26370);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.h
 * JD-Core Version:    0.7.0.1
 */