package com.tencent.mm.plugin.game.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class q
{
  private static boolean b(n paramn)
  {
    AppMethodBeat.i(111325);
    long l = System.currentTimeMillis() / 1000L;
    if (paramn.field_expireTime < l)
    {
      AppMethodBeat.o(111325);
      return true;
    }
    AppMethodBeat.o(111325);
    return false;
  }
  
  public static n bGn()
  {
    AppMethodBeat.i(111317);
    long l = ((Long)g.RL().Ru().get(ac.a.yAJ, Long.valueOf(0L))).longValue();
    if (l != 0L) {}
    for (n localn = ((com.tencent.mm.plugin.game.api.e)g.E(com.tencent.mm.plugin.game.api.e.class)).bES().kl(l);; localn = null)
    {
      if ((localn == null) || (localn.field_isHidden) || (b(localn)))
      {
        a.Qo("");
        AppMethodBeat.o(111317);
        return null;
      }
      AppMethodBeat.o(111317);
      return localn;
    }
  }
  
  public static void bGo()
  {
    AppMethodBeat.i(111318);
    long l = ((Long)g.RL().Ru().get(ac.a.yAJ, Long.valueOf(0L))).longValue();
    n localn = null;
    if (l != 0L) {
      localn = ((com.tencent.mm.plugin.game.api.e)g.E(com.tencent.mm.plugin.game.api.e.class)).bES().kl(l);
    }
    if ((localn == null) || (localn.field_isHidden))
    {
      AppMethodBeat.o(111318);
      return;
    }
    g.RL().Ru().set(ac.a.yAJ, Long.valueOf(0L));
    AppMethodBeat.o(111318);
  }
  
  public static n bGp()
  {
    AppMethodBeat.i(111319);
    long l = ((Long)g.RL().Ru().get(ac.a.yAN, Long.valueOf(0L))).longValue();
    if (l == 0L)
    {
      AppMethodBeat.o(111319);
      return null;
    }
    n localn = ((com.tencent.mm.plugin.game.api.e)g.E(com.tencent.mm.plugin.game.api.e.class)).bES().kl(l);
    if ((localn == null) || (localn.field_isHidden) || (b(localn)))
    {
      AppMethodBeat.o(111319);
      return null;
    }
    AppMethodBeat.o(111319);
    return localn;
  }
  
  public static void bGq()
  {
    AppMethodBeat.i(111320);
    long l = ((Long)g.RL().Ru().get(ac.a.yAN, Long.valueOf(0L))).longValue();
    n localn = null;
    if (l != 0L) {
      localn = ((com.tencent.mm.plugin.game.api.e)g.E(com.tencent.mm.plugin.game.api.e.class)).bES().kl(l);
    }
    if ((localn == null) || (localn.field_isHidden))
    {
      AppMethodBeat.o(111320);
      return;
    }
    g.RL().Ru().set(ac.a.yAN, Long.valueOf(0L));
    AppMethodBeat.o(111320);
  }
  
  public static n bGr()
  {
    AppMethodBeat.i(111321);
    long l = ((Long)g.RL().Ru().get(ac.a.yAK, Long.valueOf(0L))).longValue();
    if (l == 0L)
    {
      AppMethodBeat.o(111321);
      return null;
    }
    n localn = ((com.tencent.mm.plugin.game.api.e)g.E(com.tencent.mm.plugin.game.api.e.class)).bES().kl(l);
    if ((localn == null) || (localn.field_isHidden) || (b(localn)))
    {
      AppMethodBeat.o(111321);
      return null;
    }
    AppMethodBeat.o(111321);
    return localn;
  }
  
  public static void bGs()
  {
    AppMethodBeat.i(111322);
    long l = ((Long)g.RL().Ru().get(ac.a.yAK, Long.valueOf(0L))).longValue();
    n localn = null;
    if (l != 0L) {
      localn = ((com.tencent.mm.plugin.game.api.e)g.E(com.tencent.mm.plugin.game.api.e.class)).bES().kl(l);
    }
    if ((localn == null) || (localn.field_isHidden))
    {
      AppMethodBeat.o(111322);
      return;
    }
    g.RL().Ru().set(ac.a.yAK, Long.valueOf(0L));
    AppMethodBeat.o(111322);
  }
  
  public static n bGt()
  {
    AppMethodBeat.i(111323);
    long l = ((Long)g.RL().Ru().get(ac.a.yAO, Long.valueOf(0L))).longValue();
    if (l == 0L)
    {
      AppMethodBeat.o(111323);
      return null;
    }
    n localn = ((com.tencent.mm.plugin.game.api.e)g.E(com.tencent.mm.plugin.game.api.e.class)).bES().kl(l);
    if ((localn == null) || (localn.field_isHidden) || (b(localn)))
    {
      AppMethodBeat.o(111323);
      return null;
    }
    AppMethodBeat.o(111323);
    return localn;
  }
  
  public static void bGu()
  {
    AppMethodBeat.i(111324);
    long l = ((Long)g.RL().Ru().get(ac.a.yAO, Long.valueOf(0L))).longValue();
    n localn = null;
    if (l != 0L) {
      localn = ((com.tencent.mm.plugin.game.api.e)g.E(com.tencent.mm.plugin.game.api.e.class)).bES().kl(l);
    }
    if ((localn == null) || (localn.field_isHidden))
    {
      AppMethodBeat.o(111324);
      return;
    }
    g.RL().Ru().set(ac.a.yAO, Long.valueOf(0L));
    AppMethodBeat.o(111324);
  }
  
  public static void c(n paramn)
  {
    AppMethodBeat.i(111326);
    if (bo.isNullOrNil(paramn.field_mergerId))
    {
      AppMethodBeat.o(111326);
      return;
    }
    Object localObject2 = ((com.tencent.mm.plugin.game.api.e)g.E(com.tencent.mm.plugin.game.api.e.class)).bES();
    Object localObject1 = paramn.field_mergerId;
    int i = paramn.field_msgType;
    String str = "select * from GameRawMessage where msgType=" + i + " and mergerId= \"" + (String)localObject1 + "\" order by createTime desc limit 1";
    localObject1 = new n();
    localObject2 = ((r)localObject2).rawQuery(str, new String[0]);
    if (localObject2 == null) {
      localObject1 = null;
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        ((n)localObject1).bGm();
        if (!bo.es(((n)localObject1).nmZ))
        {
          paramn.bGm();
          localObject2 = new LinkedList(((n)localObject1).nmZ);
          if (!bo.es(paramn.nmZ))
          {
            str = ((n.i)paramn.nmZ.get(0)).userName;
            if (!bo.isNullOrNil(str))
            {
              Iterator localIterator = ((n)localObject1).nmZ.iterator();
              while (localIterator.hasNext())
              {
                n.i locali = (n.i)localIterator.next();
                if (locali.userName.equals(str)) {
                  ((LinkedList)localObject2).remove(locali);
                }
              }
            }
          }
          if (!bo.es((List)localObject2)) {
            paramn.field_rawXML = ah.a(paramn.field_rawXML, (LinkedList)localObject2, ((n)localObject1).nne);
          }
          ((com.tencent.mm.plugin.game.api.e)g.E(com.tencent.mm.plugin.game.api.e.class)).bES().delete((c)localObject1, new String[0]);
        }
      }
      AppMethodBeat.o(111326);
      return;
      if (((Cursor)localObject2).moveToFirst()) {
        ((n)localObject1).convertFrom((Cursor)localObject2);
      }
      ((Cursor)localObject2).close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.q
 * JD-Core Version:    0.7.0.1
 */