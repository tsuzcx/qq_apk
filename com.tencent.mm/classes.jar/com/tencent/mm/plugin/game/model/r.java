package com.tencent.mm.plugin.game.model;

import android.database.Cursor;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class r
{
  private static boolean a(o paramo)
  {
    long l = System.currentTimeMillis() / 1000L;
    return paramo.field_expireTime < l;
  }
  
  public static o aZn()
  {
    long l = ((Long)g.DP().Dz().get(ac.a.uqJ, Long.valueOf(0L))).longValue();
    if (l != 0L) {}
    for (o localo1 = ((com.tencent.mm.plugin.game.a.c)g.r(com.tencent.mm.plugin.game.a.c.class)).aYf().eP(l);; localo1 = null)
    {
      o localo2;
      if ((localo1 != null) && (!localo1.field_isHidden))
      {
        localo2 = localo1;
        if (!a(localo1)) {}
      }
      else
      {
        a.EW("");
        localo2 = null;
      }
      return localo2;
    }
  }
  
  public static void aZo()
  {
    long l = ((Long)g.DP().Dz().get(ac.a.uqJ, Long.valueOf(0L))).longValue();
    o localo = null;
    if (l != 0L) {
      localo = ((com.tencent.mm.plugin.game.a.c)g.r(com.tencent.mm.plugin.game.a.c.class)).aYf().eP(l);
    }
    if ((localo == null) || (localo.field_isHidden)) {
      return;
    }
    g.DP().Dz().c(ac.a.uqJ, Long.valueOf(0L));
  }
  
  public static o aZp()
  {
    long l = ((Long)g.DP().Dz().get(ac.a.uqN, Long.valueOf(0L))).longValue();
    Object localObject;
    if (l == 0L) {
      localObject = null;
    }
    o localo;
    do
    {
      return localObject;
      localo = ((com.tencent.mm.plugin.game.a.c)g.r(com.tencent.mm.plugin.game.a.c.class)).aYf().eP(l);
      if ((localo == null) || (localo.field_isHidden)) {
        break;
      }
      localObject = localo;
    } while (!a(localo));
    return null;
  }
  
  public static void aZq()
  {
    long l = ((Long)g.DP().Dz().get(ac.a.uqN, Long.valueOf(0L))).longValue();
    o localo = null;
    if (l != 0L) {
      localo = ((com.tencent.mm.plugin.game.a.c)g.r(com.tencent.mm.plugin.game.a.c.class)).aYf().eP(l);
    }
    if ((localo == null) || (localo.field_isHidden)) {
      return;
    }
    g.DP().Dz().c(ac.a.uqN, Long.valueOf(0L));
  }
  
  public static o aZr()
  {
    long l = ((Long)g.DP().Dz().get(ac.a.uqK, Long.valueOf(0L))).longValue();
    Object localObject;
    if (l == 0L) {
      localObject = null;
    }
    o localo;
    do
    {
      return localObject;
      localo = ((com.tencent.mm.plugin.game.a.c)g.r(com.tencent.mm.plugin.game.a.c.class)).aYf().eP(l);
      if ((localo == null) || (localo.field_isHidden)) {
        break;
      }
      localObject = localo;
    } while (!a(localo));
    return null;
  }
  
  public static void aZs()
  {
    long l = ((Long)g.DP().Dz().get(ac.a.uqK, Long.valueOf(0L))).longValue();
    o localo = null;
    if (l != 0L) {
      localo = ((com.tencent.mm.plugin.game.a.c)g.r(com.tencent.mm.plugin.game.a.c.class)).aYf().eP(l);
    }
    if ((localo == null) || (localo.field_isHidden)) {
      return;
    }
    g.DP().Dz().c(ac.a.uqK, Long.valueOf(0L));
  }
  
  public static void b(o paramo)
  {
    if (bk.bl(paramo.field_mergerId)) {}
    label278:
    for (;;)
    {
      return;
      Object localObject2 = ((com.tencent.mm.plugin.game.a.c)g.r(com.tencent.mm.plugin.game.a.c.class)).aYf();
      Object localObject1 = paramo.field_mergerId;
      int i = paramo.field_msgType;
      String str = "select * from GameRawMessage where msgType=" + i + " and mergerId= \"" + (String)localObject1 + "\" order by createTime desc limit 1";
      localObject1 = new o();
      localObject2 = ((s)localObject2).rawQuery(str, new String[0]);
      if (localObject2 == null) {
        localObject1 = null;
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label278;
        }
        ((o)localObject1).aZm();
        if (bk.dk(((o)localObject1).kPd)) {
          break;
        }
        paramo.aZm();
        localObject2 = new LinkedList(((o)localObject1).kPd);
        if (!bk.dk(paramo.kPd))
        {
          str = ((o.h)paramo.kPd.get(0)).userName;
          if (!bk.bl(str))
          {
            Iterator localIterator = ((o)localObject1).kPd.iterator();
            while (localIterator.hasNext())
            {
              o.h localh = (o.h)localIterator.next();
              if (localh.userName.equals(str)) {
                ((LinkedList)localObject2).remove(localh);
              }
            }
          }
        }
        if (!bk.dk((List)localObject2)) {
          paramo.field_rawXML = ai.a(paramo.field_rawXML, (LinkedList)localObject2, ((o)localObject1).kPi);
        }
        ((com.tencent.mm.plugin.game.a.c)g.r(com.tencent.mm.plugin.game.a.c.class)).aYf().a((com.tencent.mm.sdk.e.c)localObject1, new String[0]);
        return;
        if (((Cursor)localObject2).moveToFirst()) {
          ((o)localObject1).d((Cursor)localObject2);
        }
        ((Cursor)localObject2).close();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.r
 * JD-Core Version:    0.7.0.1
 */