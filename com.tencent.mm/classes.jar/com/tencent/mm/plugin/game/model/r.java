package com.tencent.mm.plugin.game.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public final class r
{
  public static boolean c(o paramo)
  {
    AppMethodBeat.i(41480);
    paramo = bu.nullAsNil(paramo.field_gameMsgId);
    Object localObject = bu.nullAsNil((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IUK, ""));
    ae.i("MicroMsg.GameMessageService", "filter msgIds:%s", new Object[] { localObject });
    try
    {
      localObject = new JSONArray((String)localObject);
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        if (paramo.equals(((JSONArray)localObject).getString(i)))
        {
          ae.i("MicroMsg.GameMessageService", "filter deleted message. gameMsgId:%s", new Object[] { paramo });
          AppMethodBeat.o(41480);
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (JSONException paramo)
    {
      AppMethodBeat.o(41480);
    }
  }
  
  public static void d(o paramo)
  {
    AppMethodBeat.i(183859);
    if (paramo.umN)
    {
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.INI, Long.valueOf(paramo.field_msgId));
      AppMethodBeat.o(183859);
      return;
    }
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.INI, Long.valueOf(0L));
    AppMethodBeat.o(183859);
  }
  
  public static o dbF()
  {
    AppMethodBeat.i(183863);
    Object localObject2 = dbG();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = dbJ();
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = dbL();
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = dbN();
    }
    if (localObject1 != null) {
      ((o)localObject1).dbE();
    }
    AppMethodBeat.o(183863);
    return localObject1;
  }
  
  public static o dbG()
  {
    AppMethodBeat.i(41481);
    long l = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.INI, Long.valueOf(0L))).longValue();
    if (l != 0L) {}
    for (o localo = ((f)com.tencent.mm.kernel.g.ab(f.class)).cZl().xZ(l);; localo = null)
    {
      if ((localo == null) || (localo.field_isHidden) || (i(localo)))
      {
        a.anh("");
        AppMethodBeat.o(41481);
        return null;
      }
      AppMethodBeat.o(41481);
      return localo;
    }
  }
  
  public static void dbH()
  {
    AppMethodBeat.i(41482);
    long l = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.INI, Long.valueOf(0L))).longValue();
    o localo = null;
    if (l != 0L) {
      localo = ((f)com.tencent.mm.kernel.g.ab(f.class)).cZl().xZ(l);
    }
    if ((localo == null) || (localo.field_isHidden))
    {
      AppMethodBeat.o(41482);
      return;
    }
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.INI, Long.valueOf(0L));
    AppMethodBeat.o(41482);
  }
  
  public static o dbI()
  {
    AppMethodBeat.i(41483);
    long l = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.INI, Long.valueOf(0L))).longValue();
    o localo = null;
    if (l != 0L) {
      localo = ((f)com.tencent.mm.kernel.g.ab(f.class)).cZl().xZ(l);
    }
    AppMethodBeat.o(41483);
    return localo;
  }
  
  public static o dbJ()
  {
    AppMethodBeat.i(41484);
    long l = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.INM, Long.valueOf(0L))).longValue();
    if (l == 0L)
    {
      AppMethodBeat.o(41484);
      return null;
    }
    o localo = ((f)com.tencent.mm.kernel.g.ab(f.class)).cZl().xZ(l);
    if ((localo == null) || (localo.field_isHidden) || (i(localo)))
    {
      AppMethodBeat.o(41484);
      return null;
    }
    AppMethodBeat.o(41484);
    return localo;
  }
  
  public static void dbK()
  {
    AppMethodBeat.i(41485);
    long l = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.INM, Long.valueOf(0L))).longValue();
    o localo = null;
    if (l != 0L) {
      localo = ((f)com.tencent.mm.kernel.g.ab(f.class)).cZl().xZ(l);
    }
    if ((localo == null) || (localo.field_isHidden))
    {
      AppMethodBeat.o(41485);
      return;
    }
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.INM, Long.valueOf(0L));
    AppMethodBeat.o(41485);
  }
  
  public static o dbL()
  {
    AppMethodBeat.i(41486);
    long l = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.INJ, Long.valueOf(0L))).longValue();
    if (l == 0L)
    {
      AppMethodBeat.o(41486);
      return null;
    }
    o localo = ((f)com.tencent.mm.kernel.g.ab(f.class)).cZl().xZ(l);
    if ((localo == null) || (localo.field_isHidden) || (i(localo)))
    {
      AppMethodBeat.o(41486);
      return null;
    }
    AppMethodBeat.o(41486);
    return localo;
  }
  
  public static void dbM()
  {
    AppMethodBeat.i(41487);
    long l = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.INJ, Long.valueOf(0L))).longValue();
    o localo = null;
    if (l != 0L) {
      localo = ((f)com.tencent.mm.kernel.g.ab(f.class)).cZl().xZ(l);
    }
    if ((localo == null) || (localo.field_isHidden))
    {
      AppMethodBeat.o(41487);
      return;
    }
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.INJ, Long.valueOf(0L));
    AppMethodBeat.o(41487);
  }
  
  private static o dbN()
  {
    AppMethodBeat.i(41488);
    long l = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.INN, Long.valueOf(0L))).longValue();
    if (l == 0L)
    {
      AppMethodBeat.o(41488);
      return null;
    }
    o localo = ((f)com.tencent.mm.kernel.g.ab(f.class)).cZl().xZ(l);
    if ((localo == null) || (localo.field_isHidden) || (i(localo)))
    {
      AppMethodBeat.o(41488);
      return null;
    }
    AppMethodBeat.o(41488);
    return localo;
  }
  
  public static void dbO()
  {
    AppMethodBeat.i(41489);
    long l = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.INN, Long.valueOf(0L))).longValue();
    o localo = null;
    if (l != 0L) {
      localo = ((f)com.tencent.mm.kernel.g.ab(f.class)).cZl().xZ(l);
    }
    if ((localo == null) || (localo.field_isHidden))
    {
      AppMethodBeat.o(41489);
      return;
    }
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.INN, Long.valueOf(0L));
    AppMethodBeat.o(41489);
  }
  
  public static void e(o paramo)
  {
    AppMethodBeat.i(183860);
    if (!bu.isNullOrNil(paramo.une.url))
    {
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.INM, Long.valueOf(paramo.field_msgId));
      AppMethodBeat.o(183860);
      return;
    }
    dbK();
    AppMethodBeat.o(183860);
  }
  
  public static void f(o paramo)
  {
    AppMethodBeat.i(183861);
    if (paramo.umP)
    {
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.INJ, Long.valueOf(paramo.field_msgId));
      AppMethodBeat.o(183861);
      return;
    }
    dbM();
    AppMethodBeat.o(183861);
  }
  
  public static void g(o paramo)
  {
    AppMethodBeat.i(183862);
    if (!bu.isNullOrNil(paramo.unv.unO))
    {
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.INN, Long.valueOf(paramo.field_msgId));
      AppMethodBeat.o(183862);
      return;
    }
    dbO();
    AppMethodBeat.o(183862);
  }
  
  public static boolean h(o paramo)
  {
    AppMethodBeat.i(195648);
    Object localObject = g.dbz();
    long l = bu.aRi();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      g.a locala = (g.a)((Iterator)localObject).next();
      if ((locala.startTime <= l) && (locala.endTime >= l) && ((paramo.umO.unT == locala.umn) || (locala.umo.contains(paramo.field_gameMsgId))))
      {
        AppMethodBeat.o(195648);
        return true;
      }
    }
    AppMethodBeat.o(195648);
    return false;
  }
  
  private static boolean i(o paramo)
  {
    AppMethodBeat.i(41490);
    long l = System.currentTimeMillis() / 1000L;
    if (paramo.field_expireTime < l)
    {
      AppMethodBeat.o(41490);
      return true;
    }
    AppMethodBeat.o(41490);
    return false;
  }
  
  public static void j(o paramo)
  {
    int i = 1;
    AppMethodBeat.i(41491);
    Object localObject2;
    Object localObject1;
    Object localObject3;
    if (paramo.field_showType != 0)
    {
      if ((paramo.uny.uor > 1) && (!bu.isNullOrNil(paramo.uny.uoq)))
      {
        localObject2 = ((f)com.tencent.mm.kernel.g.ab(f.class)).cZl();
        localObject1 = paramo.field_interactiveMergeId;
        localObject3 = "select * from GameRawMessage where showType=1 and interactiveMergeId= \"" + (String)localObject1 + "\" and isRead=0 order by createTime desc";
        localObject1 = new LinkedList();
        localObject2 = ((s)localObject2).rawQuery((String)localObject3, new String[0]);
        if (localObject2 == null) {}
        for (;;)
        {
          localObject2 = ((List)localObject1).iterator();
          while (((Iterator)localObject2).hasNext()) {
            i = ((o)((Iterator)localObject2).next()).field_hasMergedCount + i;
          }
          if (((Cursor)localObject2).moveToFirst()) {
            do
            {
              localObject3 = new o();
              ((o)localObject3).convertFrom((Cursor)localObject2);
              ((LinkedList)localObject1).add(localObject3);
            } while (((Cursor)localObject2).moveToNext());
          }
          ((Cursor)localObject2).close();
        }
        if (i >= paramo.uny.uor)
        {
          paramo.field_hasMergedCount = i;
          paramo = ((List)localObject1).iterator();
          while (paramo.hasNext())
          {
            localObject1 = (o)paramo.next();
            ((f)com.tencent.mm.kernel.g.ab(f.class)).cZl().delete((c)localObject1, new String[0]);
          }
        }
        AppMethodBeat.o(41491);
      }
    }
    else
    {
      if (bu.isNullOrNil(paramo.field_mergerId))
      {
        AppMethodBeat.o(41491);
        return;
      }
      localObject2 = ((f)com.tencent.mm.kernel.g.ab(f.class)).cZl();
      localObject1 = paramo.field_mergerId;
      i = paramo.field_msgType;
      localObject3 = "select * from GameRawMessage where msgType=" + i + " and mergerId= \"" + (String)localObject1 + "\" order by createTime desc limit 1";
      localObject1 = new o();
      localObject2 = ((s)localObject2).rawQuery((String)localObject3, new String[0]);
      if (localObject2 != null) {
        break label535;
      }
      localObject1 = null;
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        ((o)localObject1).dbE();
        if (!bu.ht(((o)localObject1).umM))
        {
          paramo.dbE();
          localObject2 = new LinkedList(((o)localObject1).umM);
          if (!bu.ht(paramo.umM))
          {
            localObject3 = ((o.k)paramo.umM.get(0)).userName;
            if (!bu.isNullOrNil((String)localObject3))
            {
              Iterator localIterator = ((o)localObject1).umM.iterator();
              while (localIterator.hasNext())
              {
                o.k localk = (o.k)localIterator.next();
                if (localk.userName.equals(localObject3)) {
                  ((LinkedList)localObject2).remove(localk);
                }
              }
            }
          }
          if (!bu.ht((List)localObject2)) {
            paramo.field_rawXML = ah.a(paramo.field_rawXML, (LinkedList)localObject2, ((o)localObject1).umR);
          }
          ((f)com.tencent.mm.kernel.g.ab(f.class)).cZl().delete((c)localObject1, new String[0]);
        }
      }
      AppMethodBeat.o(41491);
      return;
      label535:
      if (((Cursor)localObject2).moveToFirst()) {
        ((o)localObject1).convertFrom((Cursor)localObject2);
      }
      ((Cursor)localObject2).close();
    }
  }
  
  public static boolean k(o paramo)
  {
    AppMethodBeat.i(183864);
    if (paramo == null)
    {
      AppMethodBeat.o(183864);
      return false;
    }
    if (paramo.umO.unU)
    {
      AppMethodBeat.o(183864);
      return false;
    }
    boolean bool = e.Il(paramo.umO.unT);
    AppMethodBeat.o(183864);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.r
 * JD-Core Version:    0.7.0.1
 */