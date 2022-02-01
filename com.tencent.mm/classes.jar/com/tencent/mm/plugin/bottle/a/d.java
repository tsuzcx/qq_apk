package com.tencent.mm.plugin.bottle.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bz;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bh.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class d
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private bh.a gNp;
  private b mRi;
  
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
    this.gNp = new bh.a()
    {
      public final void a(am paramAnonymousam, bh paramAnonymousbh)
      {
        AppMethodBeat.i(22648);
        if (paramAnonymousam == null)
        {
          AppMethodBeat.o(22648);
          return;
        }
        if ("_USER_FOR_THROWBOTTLE_".equals(paramAnonymousam.field_username))
        {
          paramAnonymousam.setUsername("");
          AppMethodBeat.o(22648);
          return;
        }
        if ((1 != paramAnonymousam.field_isSend) && (af.st(paramAnonymousam.field_username)) && (!paramAnonymousbh.aaS(paramAnonymousam.field_username))) {
          c.OU(paramAnonymousam.field_username);
        }
        AppMethodBeat.o(22648);
      }
    };
    AppMethodBeat.o(22649);
  }
  
  private static d bBK()
  {
    AppMethodBeat.i(22650);
    az.arP();
    d locald2 = (d)bz.ut("plugin.bottle");
    d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = new d();
      az.arP().a("plugin.bottle", locald1);
    }
    AppMethodBeat.o(22650);
    return locald1;
  }
  
  public static b bBL()
  {
    AppMethodBeat.i(22651);
    g.afz().aeD();
    if (bBK().mRi == null)
    {
      localObject = bBK();
      az.arV();
      ((d)localObject).mRi = new b(com.tencent.mm.model.c.afg());
    }
    Object localObject = bBK().mRi;
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
    c.bBJ();
    az.arV();
    com.tencent.mm.model.c.apR().c(this.gNp);
    AppMethodBeat.o(22653);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(22652);
    az.arV();
    com.tencent.mm.model.c.apR().d(this.gNp);
    AppMethodBeat.o(22652);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.a.d
 * JD-Core Version:    0.7.0.1
 */