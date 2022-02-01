package com.tencent.mm.plugin.bottle.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bz;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bk.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class d
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private bk.a hnP;
  private b nty;
  
  static
  {
    AppMethodBeat.i(22654);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("THROWBOTTLEINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return b.SQL_CREATE;
      }
    });
    AppMethodBeat.o(22654);
  }
  
  public d()
  {
    AppMethodBeat.i(22649);
    this.hnP = new bk.a()
    {
      public final void a(ap paramAnonymousap, bk paramAnonymousbk)
      {
        AppMethodBeat.i(22648);
        if (paramAnonymousap == null)
        {
          AppMethodBeat.o(22648);
          return;
        }
        if ("_USER_FOR_THROWBOTTLE_".equals(paramAnonymousap.field_username))
        {
          paramAnonymousap.setUsername("");
          AppMethodBeat.o(22648);
          return;
        }
        if ((1 != paramAnonymousap.field_isSend) && (ai.ww(paramAnonymousap.field_username)) && (!paramAnonymousbk.afK(paramAnonymousap.field_username))) {
          c.Te(paramAnonymousap.field_username);
        }
        AppMethodBeat.o(22648);
      }
    };
    AppMethodBeat.o(22649);
  }
  
  private static d bII()
  {
    AppMethodBeat.i(22650);
    com.tencent.mm.model.az.ayG();
    d locald2 = (d)bz.yz("plugin.bottle");
    d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = new d();
      com.tencent.mm.model.az.ayG().a("plugin.bottle", locald1);
    }
    AppMethodBeat.o(22650);
    return locald1;
  }
  
  public static b bIJ()
  {
    AppMethodBeat.i(22651);
    g.agP().afT();
    if (bII().nty == null)
    {
      localObject = bII();
      com.tencent.mm.model.az.ayM();
      ((d)localObject).nty = new b(com.tencent.mm.model.c.agw());
    }
    Object localObject = bII().nty;
    AppMethodBeat.o(22651);
    return localObject;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(22653);
    c.bIH();
    com.tencent.mm.model.az.ayM();
    com.tencent.mm.model.c.awG().c(this.hnP);
    AppMethodBeat.o(22653);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(22652);
    com.tencent.mm.model.az.ayM();
    com.tencent.mm.model.c.awG().d(this.hnP);
    AppMethodBeat.o(22652);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.a.d
 * JD-Core Version:    0.7.0.1
 */