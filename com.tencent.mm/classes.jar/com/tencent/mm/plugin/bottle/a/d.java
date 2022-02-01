package com.tencent.mm.plugin.bottle.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.cc;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.br.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class d
  implements az
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private br.a hIZ;
  private b oaa;
  
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
    this.hIZ = new br.a()
    {
      public final void a(au paramAnonymousau, br paramAnonymousbr)
      {
        AppMethodBeat.i(22648);
        if (paramAnonymousau == null)
        {
          AppMethodBeat.o(22648);
          return;
        }
        if ("_USER_FOR_THROWBOTTLE_".equals(paramAnonymousau.field_username))
        {
          paramAnonymousau.setUsername("");
          AppMethodBeat.o(22648);
          return;
        }
        if ((1 != paramAnonymousau.field_isSend) && (an.Ac(paramAnonymousau.field_username)) && (!paramAnonymousbr.alg(paramAnonymousau.field_username))) {
          c.Xq(paramAnonymousau.field_username);
        }
        AppMethodBeat.o(22648);
      }
    };
    AppMethodBeat.o(22649);
  }
  
  private static d bNT()
  {
    AppMethodBeat.i(22650);
    bc.aCa();
    d locald2 = (d)cc.Ca("plugin.bottle");
    d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = new d();
      bc.aCa().a("plugin.bottle", locald1);
    }
    AppMethodBeat.o(22650);
    return locald1;
  }
  
  public static b bNU()
  {
    AppMethodBeat.i(22651);
    g.ajP().aiU();
    if (bNT().oaa == null)
    {
      localObject = bNT();
      bc.aCg();
      ((d)localObject).oaa = new b(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = bNT().oaa;
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
    c.bNS();
    bc.aCg();
    com.tencent.mm.model.c.azL().c(this.hIZ);
    AppMethodBeat.o(22653);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(22652);
    bc.aCg();
    com.tencent.mm.model.c.azL().d(this.hIZ);
    AppMethodBeat.o(22652);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.a.d
 * JD-Core Version:    0.7.0.1
 */