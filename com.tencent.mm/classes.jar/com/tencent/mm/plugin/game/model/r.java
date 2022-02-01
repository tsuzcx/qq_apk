package com.tencent.mm.plugin.game.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
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
    paramo = bs.nullAsNil(paramo.field_gameMsgId);
    Object localObject = bs.nullAsNil((String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GNU, ""));
    ac.i("MicroMsg.GameMessageService", "filter msgIds:%s", new Object[] { localObject });
    try
    {
      localObject = new JSONArray((String)localObject);
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        if (paramo.equals(((JSONArray)localObject).getString(i)))
        {
          ac.i("MicroMsg.GameMessageService", "filter deleted message. gameMsgId:%s", new Object[] { paramo });
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
  
  public static o cQq()
  {
    AppMethodBeat.i(183863);
    Object localObject2 = cQr();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = cQu();
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = cQw();
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = cQy();
    }
    if (localObject1 != null) {
      ((o)localObject1).cQp();
    }
    AppMethodBeat.o(183863);
    return localObject1;
  }
  
  public static o cQr()
  {
    AppMethodBeat.i(41481);
    long l = ((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GGU, Long.valueOf(0L))).longValue();
    if (l != 0L) {}
    for (o localo = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().vy(l);; localo = null)
    {
      if ((localo == null) || (localo.field_isHidden) || (i(localo)))
      {
        a.ahF("");
        AppMethodBeat.o(41481);
        return null;
      }
      AppMethodBeat.o(41481);
      return localo;
    }
  }
  
  public static void cQs()
  {
    AppMethodBeat.i(41482);
    long l = ((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GGU, Long.valueOf(0L))).longValue();
    o localo = null;
    if (l != 0L) {
      localo = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().vy(l);
    }
    if ((localo == null) || (localo.field_isHidden))
    {
      AppMethodBeat.o(41482);
      return;
    }
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GGU, Long.valueOf(0L));
    AppMethodBeat.o(41482);
  }
  
  public static o cQt()
  {
    AppMethodBeat.i(41483);
    long l = ((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GGU, Long.valueOf(0L))).longValue();
    o localo = null;
    if (l != 0L) {
      localo = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().vy(l);
    }
    AppMethodBeat.o(41483);
    return localo;
  }
  
  public static o cQu()
  {
    AppMethodBeat.i(41484);
    long l = ((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GGY, Long.valueOf(0L))).longValue();
    if (l == 0L)
    {
      AppMethodBeat.o(41484);
      return null;
    }
    o localo = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().vy(l);
    if ((localo == null) || (localo.field_isHidden) || (i(localo)))
    {
      AppMethodBeat.o(41484);
      return null;
    }
    AppMethodBeat.o(41484);
    return localo;
  }
  
  public static void cQv()
  {
    AppMethodBeat.i(41485);
    long l = ((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GGY, Long.valueOf(0L))).longValue();
    o localo = null;
    if (l != 0L) {
      localo = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().vy(l);
    }
    if ((localo == null) || (localo.field_isHidden))
    {
      AppMethodBeat.o(41485);
      return;
    }
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GGY, Long.valueOf(0L));
    AppMethodBeat.o(41485);
  }
  
  public static o cQw()
  {
    AppMethodBeat.i(41486);
    long l = ((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GGV, Long.valueOf(0L))).longValue();
    if (l == 0L)
    {
      AppMethodBeat.o(41486);
      return null;
    }
    o localo = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().vy(l);
    if ((localo == null) || (localo.field_isHidden) || (i(localo)))
    {
      AppMethodBeat.o(41486);
      return null;
    }
    AppMethodBeat.o(41486);
    return localo;
  }
  
  public static void cQx()
  {
    AppMethodBeat.i(41487);
    long l = ((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GGV, Long.valueOf(0L))).longValue();
    o localo = null;
    if (l != 0L) {
      localo = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().vy(l);
    }
    if ((localo == null) || (localo.field_isHidden))
    {
      AppMethodBeat.o(41487);
      return;
    }
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GGV, Long.valueOf(0L));
    AppMethodBeat.o(41487);
  }
  
  public static o cQy()
  {
    AppMethodBeat.i(41488);
    long l = ((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GGZ, Long.valueOf(0L))).longValue();
    if (l == 0L)
    {
      AppMethodBeat.o(41488);
      return null;
    }
    o localo = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().vy(l);
    if ((localo == null) || (localo.field_isHidden) || (i(localo)))
    {
      AppMethodBeat.o(41488);
      return null;
    }
    AppMethodBeat.o(41488);
    return localo;
  }
  
  public static void cQz()
  {
    AppMethodBeat.i(41489);
    long l = ((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GGZ, Long.valueOf(0L))).longValue();
    o localo = null;
    if (l != 0L) {
      localo = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().vy(l);
    }
    if ((localo == null) || (localo.field_isHidden))
    {
      AppMethodBeat.o(41489);
      return;
    }
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GGZ, Long.valueOf(0L));
    AppMethodBeat.o(41489);
  }
  
  public static void d(o paramo)
  {
    AppMethodBeat.i(183859);
    if (paramo.tdV)
    {
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GGU, Long.valueOf(paramo.field_msgId));
      AppMethodBeat.o(183859);
      return;
    }
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GGU, Long.valueOf(0L));
    AppMethodBeat.o(183859);
  }
  
  public static void e(o paramo)
  {
    AppMethodBeat.i(183860);
    if (!bs.isNullOrNil(paramo.tem.url))
    {
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GGY, Long.valueOf(paramo.field_msgId));
      AppMethodBeat.o(183860);
      return;
    }
    cQv();
    AppMethodBeat.o(183860);
  }
  
  public static void f(o paramo)
  {
    AppMethodBeat.i(183861);
    if (paramo.tdX)
    {
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GGV, Long.valueOf(paramo.field_msgId));
      AppMethodBeat.o(183861);
      return;
    }
    cQx();
    AppMethodBeat.o(183861);
  }
  
  public static void g(o paramo)
  {
    AppMethodBeat.i(183862);
    if (!bs.isNullOrNil(paramo.teD.teR))
    {
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GGZ, Long.valueOf(paramo.field_msgId));
      AppMethodBeat.o(183862);
      return;
    }
    cQz();
    AppMethodBeat.o(183862);
  }
  
  public static boolean h(o paramo)
  {
    AppMethodBeat.i(199228);
    Object localObject = g.cQk();
    long l = bs.aNx();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      g.a locala = (g.a)((Iterator)localObject).next();
      if ((locala.startTime <= l) && (locala.endTime >= l) && ((paramo.tdW.teY == locala.tdv) || (locala.tdw.contains(paramo.field_gameMsgId))))
      {
        AppMethodBeat.o(199228);
        return true;
      }
    }
    AppMethodBeat.o(199228);
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
      if ((paramo.teG.tft > 1) && (!bs.isNullOrNil(paramo.teG.tfs)))
      {
        localObject2 = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm();
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
        if (i >= paramo.teG.tft)
        {
          paramo.field_hasMergedCount = i;
          paramo = ((List)localObject1).iterator();
          while (paramo.hasNext())
          {
            localObject1 = (o)paramo.next();
            ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().delete((c)localObject1, new String[0]);
          }
        }
        AppMethodBeat.o(41491);
      }
    }
    else
    {
      if (bs.isNullOrNil(paramo.field_mergerId))
      {
        AppMethodBeat.o(41491);
        return;
      }
      localObject2 = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm();
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
        ((o)localObject1).cQp();
        if (!bs.gY(((o)localObject1).tdU))
        {
          paramo.cQp();
          localObject2 = new LinkedList(((o)localObject1).tdU);
          if (!bs.gY(paramo.tdU))
          {
            localObject3 = ((o.i)paramo.tdU.get(0)).userName;
            if (!bs.isNullOrNil((String)localObject3))
            {
              Iterator localIterator = ((o)localObject1).tdU.iterator();
              while (localIterator.hasNext())
              {
                o.i locali = (o.i)localIterator.next();
                if (locali.userName.equals(localObject3)) {
                  ((LinkedList)localObject2).remove(locali);
                }
              }
            }
          }
          if (!bs.gY((List)localObject2)) {
            paramo.field_rawXML = ah.a(paramo.field_rawXML, (LinkedList)localObject2, ((o)localObject1).tdZ);
          }
          ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().delete((c)localObject1, new String[0]);
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
    if (paramo.tdW.teZ)
    {
      AppMethodBeat.o(183864);
      return false;
    }
    boolean bool = e.Gu(paramo.tdW.teY);
    AppMethodBeat.o(183864);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.r
 * JD-Core Version:    0.7.0.1
 */