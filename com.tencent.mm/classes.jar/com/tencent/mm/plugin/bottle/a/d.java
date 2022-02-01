package com.tencent.mm.plugin.bottle.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.ci;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.by.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class d
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private by.a olj;
  private b vzd;
  
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
    this.olj = new by.a()
    {
      public final void a(bb paramAnonymousbb, by paramAnonymousby)
      {
        AppMethodBeat.i(22648);
        if (paramAnonymousbb == null)
        {
          AppMethodBeat.o(22648);
          return;
        }
        if ("_USER_FOR_THROWBOTTLE_".equals(paramAnonymousbb.field_username))
        {
          paramAnonymousbb.setUsername("");
          AppMethodBeat.o(22648);
          return;
        }
        if ((1 != paramAnonymousbb.field_isSend) && (au.bwS(paramAnonymousbb.field_username)) && (!paramAnonymousby.aEb(paramAnonymousbb.field_username))) {
          c.aio(paramAnonymousbb.field_username);
        }
        AppMethodBeat.o(22648);
      }
    };
    AppMethodBeat.o(22649);
  }
  
  private static d dbg()
  {
    AppMethodBeat.i(22650);
    bh.bCt();
    d locald2 = (d)ci.Ka("plugin.bottle");
    d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = new d();
      bh.bCt().a("plugin.bottle", locald1);
    }
    AppMethodBeat.o(22650);
    return locald1;
  }
  
  public static b dbh()
  {
    AppMethodBeat.i(22651);
    h.baC().aZJ();
    if (dbg().vzd == null)
    {
      localObject = dbg();
      bh.bCz();
      ((d)localObject).vzd = new b(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = dbg().vzd;
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
    c.dbf();
    bh.bCz();
    com.tencent.mm.model.c.bzG().b(this.olj);
    AppMethodBeat.o(22653);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(22652);
    bh.bCz();
    com.tencent.mm.model.c.bzG().c(this.olj);
    AppMethodBeat.o(22652);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.a.d
 * JD-Core Version:    0.7.0.1
 */