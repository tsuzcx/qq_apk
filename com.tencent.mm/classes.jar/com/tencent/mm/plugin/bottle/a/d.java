package com.tencent.mm.plugin.bottle.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.ca;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bq.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class d
  implements ax
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private bq.a hGh;
  private b nUu;
  
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
    this.hGh = new bq.a()
    {
      public final void a(at paramAnonymousat, bq paramAnonymousbq)
      {
        AppMethodBeat.i(22648);
        if (paramAnonymousat == null)
        {
          AppMethodBeat.o(22648);
          return;
        }
        if ("_USER_FOR_THROWBOTTLE_".equals(paramAnonymousat.field_username))
        {
          paramAnonymousat.setUsername("");
          AppMethodBeat.o(22648);
          return;
        }
        if ((1 != paramAnonymousat.field_isSend) && (am.zs(paramAnonymousat.field_username)) && (!paramAnonymousbq.aki(paramAnonymousat.field_username))) {
          c.WE(paramAnonymousat.field_username);
        }
        AppMethodBeat.o(22648);
      }
    };
    AppMethodBeat.o(22649);
  }
  
  private static d bMV()
  {
    AppMethodBeat.i(22650);
    com.tencent.mm.model.ba.aBK();
    d locald2 = (d)ca.By("plugin.bottle");
    d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = new d();
      com.tencent.mm.model.ba.aBK().a("plugin.bottle", locald1);
    }
    AppMethodBeat.o(22650);
    return locald1;
  }
  
  public static b bMW()
  {
    AppMethodBeat.i(22651);
    g.ajA().aiF();
    if (bMV().nUu == null)
    {
      localObject = bMV();
      com.tencent.mm.model.ba.aBQ();
      ((d)localObject).nUu = new b(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = bMV().nUu;
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
    c.bMU();
    com.tencent.mm.model.ba.aBQ();
    com.tencent.mm.model.c.azv().c(this.hGh);
    AppMethodBeat.o(22653);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(22652);
    com.tencent.mm.model.ba.aBQ();
    com.tencent.mm.model.c.azv().d(this.hGh);
    AppMethodBeat.o(22652);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.a.d
 * JD-Core Version:    0.7.0.1
 */