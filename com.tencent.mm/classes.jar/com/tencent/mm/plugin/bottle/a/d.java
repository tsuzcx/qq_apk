package com.tencent.mm.plugin.bottle.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cg;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.bw.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class d
  implements bd
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private bw.a iDJ;
  private b pkW;
  
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
    this.iDJ = new bw.a()
    {
      public final void a(az paramAnonymousaz, bw paramAnonymousbw)
      {
        AppMethodBeat.i(22648);
        if (paramAnonymousaz == null)
        {
          AppMethodBeat.o(22648);
          return;
        }
        if ("_USER_FOR_THROWBOTTLE_".equals(paramAnonymousaz.field_username))
        {
          paramAnonymousaz.setUsername("");
          AppMethodBeat.o(22648);
          return;
        }
        if ((1 != paramAnonymousaz.field_isSend) && (as.IG(paramAnonymousaz.field_username)) && (!paramAnonymousbw.ayk(paramAnonymousaz.field_username))) {
          c.ahm(paramAnonymousaz.field_username);
        }
        AppMethodBeat.o(22648);
      }
    };
    AppMethodBeat.o(22649);
  }
  
  private static d ckT()
  {
    AppMethodBeat.i(22650);
    bg.aVz();
    d locald2 = (d)cg.KG("plugin.bottle");
    d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = new d();
      bg.aVz().a("plugin.bottle", locald1);
    }
    AppMethodBeat.o(22650);
    return locald1;
  }
  
  public static b ckU()
  {
    AppMethodBeat.i(22651);
    g.aAf().azk();
    if (ckT().pkW == null)
    {
      localObject = ckT();
      bg.aVF();
      ((d)localObject).pkW = new b(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = ckT().pkW;
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
    c.ckS();
    bg.aVF();
    com.tencent.mm.model.c.aST().c(this.iDJ);
    AppMethodBeat.o(22653);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(22652);
    bg.aVF();
    com.tencent.mm.model.c.aST().d(this.iDJ);
    AppMethodBeat.o(22652);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.a.d
 * JD-Core Version:    0.7.0.1
 */