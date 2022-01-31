package com.tencent.mm.plugin.bottle.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.be.a;
import java.util.HashMap;

public final class d
  implements at
{
  private static HashMap<Integer, h.d> baseDBFactories;
  private be.a fmb;
  private b jRZ;
  
  static
  {
    AppMethodBeat.i(18543);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("THROWBOTTLEINFO_TABLE".hashCode()), new d.1());
    AppMethodBeat.o(18543);
  }
  
  public d()
  {
    AppMethodBeat.i(18538);
    this.fmb = new be.a()
    {
      public final void a(ak paramAnonymousak, be paramAnonymousbe)
      {
        AppMethodBeat.i(18537);
        if (paramAnonymousak == null)
        {
          AppMethodBeat.o(18537);
          return;
        }
        if ("_USER_FOR_THROWBOTTLE_".equals(paramAnonymousak.field_username))
        {
          paramAnonymousak.setUsername("");
          AppMethodBeat.o(18537);
          return;
        }
        if ((1 != paramAnonymousak.field_isSend) && (ad.nM(paramAnonymousak.field_username)) && (!paramAnonymousbe.OU(paramAnonymousak.field_username))) {
          c.GG(paramAnonymousak.field_username);
        }
        AppMethodBeat.o(18537);
      }
    };
    AppMethodBeat.o(18538);
  }
  
  private static d aWi()
  {
    AppMethodBeat.i(18539);
    aw.aat();
    d locald2 = (d)bw.pF("plugin.bottle");
    d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = new d();
      aw.aat().a("plugin.bottle", locald1);
    }
    AppMethodBeat.o(18539);
    return locald1;
  }
  
  public static b aWj()
  {
    AppMethodBeat.i(18540);
    g.RJ().QQ();
    if (aWi().jRZ == null)
    {
      localObject = aWi();
      aw.aaz();
      ((d)localObject).jRZ = new b(com.tencent.mm.model.c.Rq());
    }
    Object localObject = aWi().jRZ;
    AppMethodBeat.o(18540);
    return localObject;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.d> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(18542);
    c.aWh();
    aw.aaz();
    com.tencent.mm.model.c.YF().c(this.fmb);
    AppMethodBeat.o(18542);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(18541);
    aw.aaz();
    com.tencent.mm.model.c.YF().d(this.fmb);
    AppMethodBeat.o(18541);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.a.d
 * JD-Core Version:    0.7.0.1
 */