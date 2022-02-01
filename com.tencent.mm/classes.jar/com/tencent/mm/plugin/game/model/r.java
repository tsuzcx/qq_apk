package com.tencent.mm.plugin.game.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
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
    paramo = bt.nullAsNil(paramo.field_gameMsgId);
    Object localObject = bt.nullAsNil((String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fqe, ""));
    ad.i("MicroMsg.GameMessageService", "filter msgIds:%s", new Object[] { localObject });
    try
    {
      localObject = new JSONArray((String)localObject);
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        if (paramo.equals(((JSONArray)localObject).getString(i)))
        {
          ad.i("MicroMsg.GameMessageService", "filter deleted message. gameMsgId:%s", new Object[] { paramo });
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
  
  public static o cDg()
  {
    AppMethodBeat.i(183863);
    Object localObject2 = cDh();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = cDk();
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = cDm();
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = cDo();
    }
    if (localObject1 != null) {
      ((o)localObject1).cDf();
    }
    AppMethodBeat.o(183863);
    return localObject1;
  }
  
  public static o cDh()
  {
    AppMethodBeat.i(41481);
    long l = ((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fjf, Long.valueOf(0L))).longValue();
    if (l != 0L) {}
    for (o localo = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().qV(l);; localo = null)
    {
      if ((localo == null) || (localo.field_isHidden) || (i(localo)))
      {
        a.acN("");
        AppMethodBeat.o(41481);
        return null;
      }
      AppMethodBeat.o(41481);
      return localo;
    }
  }
  
  public static void cDi()
  {
    AppMethodBeat.i(41482);
    long l = ((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fjf, Long.valueOf(0L))).longValue();
    o localo = null;
    if (l != 0L) {
      localo = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().qV(l);
    }
    if ((localo == null) || (localo.field_isHidden))
    {
      AppMethodBeat.o(41482);
      return;
    }
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fjf, Long.valueOf(0L));
    AppMethodBeat.o(41482);
  }
  
  public static o cDj()
  {
    AppMethodBeat.i(41483);
    long l = ((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fjf, Long.valueOf(0L))).longValue();
    o localo = null;
    if (l != 0L) {
      localo = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().qV(l);
    }
    AppMethodBeat.o(41483);
    return localo;
  }
  
  public static o cDk()
  {
    AppMethodBeat.i(41484);
    long l = ((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fjj, Long.valueOf(0L))).longValue();
    if (l == 0L)
    {
      AppMethodBeat.o(41484);
      return null;
    }
    o localo = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().qV(l);
    if ((localo == null) || (localo.field_isHidden) || (i(localo)))
    {
      AppMethodBeat.o(41484);
      return null;
    }
    AppMethodBeat.o(41484);
    return localo;
  }
  
  public static void cDl()
  {
    AppMethodBeat.i(41485);
    long l = ((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fjj, Long.valueOf(0L))).longValue();
    o localo = null;
    if (l != 0L) {
      localo = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().qV(l);
    }
    if ((localo == null) || (localo.field_isHidden))
    {
      AppMethodBeat.o(41485);
      return;
    }
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fjj, Long.valueOf(0L));
    AppMethodBeat.o(41485);
  }
  
  public static o cDm()
  {
    AppMethodBeat.i(41486);
    long l = ((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fjg, Long.valueOf(0L))).longValue();
    if (l == 0L)
    {
      AppMethodBeat.o(41486);
      return null;
    }
    o localo = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().qV(l);
    if ((localo == null) || (localo.field_isHidden) || (i(localo)))
    {
      AppMethodBeat.o(41486);
      return null;
    }
    AppMethodBeat.o(41486);
    return localo;
  }
  
  public static void cDn()
  {
    AppMethodBeat.i(41487);
    long l = ((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fjg, Long.valueOf(0L))).longValue();
    o localo = null;
    if (l != 0L) {
      localo = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().qV(l);
    }
    if ((localo == null) || (localo.field_isHidden))
    {
      AppMethodBeat.o(41487);
      return;
    }
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fjg, Long.valueOf(0L));
    AppMethodBeat.o(41487);
  }
  
  public static o cDo()
  {
    AppMethodBeat.i(41488);
    long l = ((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fjk, Long.valueOf(0L))).longValue();
    if (l == 0L)
    {
      AppMethodBeat.o(41488);
      return null;
    }
    o localo = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().qV(l);
    if ((localo == null) || (localo.field_isHidden) || (i(localo)))
    {
      AppMethodBeat.o(41488);
      return null;
    }
    AppMethodBeat.o(41488);
    return localo;
  }
  
  public static void cDp()
  {
    AppMethodBeat.i(41489);
    long l = ((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fjk, Long.valueOf(0L))).longValue();
    o localo = null;
    if (l != 0L) {
      localo = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().qV(l);
    }
    if ((localo == null) || (localo.field_isHidden))
    {
      AppMethodBeat.o(41489);
      return;
    }
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fjk, Long.valueOf(0L));
    AppMethodBeat.o(41489);
  }
  
  public static void d(o paramo)
  {
    AppMethodBeat.i(183859);
    if (paramo.rWd)
    {
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fjf, Long.valueOf(paramo.field_msgId));
      AppMethodBeat.o(183859);
      return;
    }
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fjf, Long.valueOf(0L));
    AppMethodBeat.o(183859);
  }
  
  public static void e(o paramo)
  {
    AppMethodBeat.i(183860);
    if (!bt.isNullOrNil(paramo.rWu.url))
    {
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fjj, Long.valueOf(paramo.field_msgId));
      AppMethodBeat.o(183860);
      return;
    }
    cDl();
    AppMethodBeat.o(183860);
  }
  
  public static void f(o paramo)
  {
    AppMethodBeat.i(183861);
    if (paramo.rWf)
    {
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fjg, Long.valueOf(paramo.field_msgId));
      AppMethodBeat.o(183861);
      return;
    }
    cDn();
    AppMethodBeat.o(183861);
  }
  
  public static void g(o paramo)
  {
    AppMethodBeat.i(183862);
    if (!bt.isNullOrNil(paramo.rWL.rWZ))
    {
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fjk, Long.valueOf(paramo.field_msgId));
      AppMethodBeat.o(183862);
      return;
    }
    cDp();
    AppMethodBeat.o(183862);
  }
  
  public static boolean h(o paramo)
  {
    AppMethodBeat.i(196758);
    Object localObject = g.cDa();
    long l = bt.aGK();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      g.a locala = (g.a)((Iterator)localObject).next();
      if ((locala.startTime <= l) && (locala.endTime >= l) && ((paramo.rWe.rXg == locala.rVD) || (locala.rVE.contains(paramo.field_gameMsgId))))
      {
        AppMethodBeat.o(196758);
        return true;
      }
    }
    AppMethodBeat.o(196758);
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
      if ((paramo.rWO.rXB > 1) && (!bt.isNullOrNil(paramo.rWO.rXA)))
      {
        localObject2 = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd();
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
        if (i >= paramo.rWO.rXB)
        {
          paramo.field_hasMergedCount = i;
          paramo = ((List)localObject1).iterator();
          while (paramo.hasNext())
          {
            localObject1 = (o)paramo.next();
            ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().delete((c)localObject1, new String[0]);
          }
        }
        AppMethodBeat.o(41491);
      }
    }
    else
    {
      if (bt.isNullOrNil(paramo.field_mergerId))
      {
        AppMethodBeat.o(41491);
        return;
      }
      localObject2 = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd();
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
        ((o)localObject1).cDf();
        if (!bt.gL(((o)localObject1).rWc))
        {
          paramo.cDf();
          localObject2 = new LinkedList(((o)localObject1).rWc);
          if (!bt.gL(paramo.rWc))
          {
            localObject3 = ((o.i)paramo.rWc.get(0)).userName;
            if (!bt.isNullOrNil((String)localObject3))
            {
              Iterator localIterator = ((o)localObject1).rWc.iterator();
              while (localIterator.hasNext())
              {
                o.i locali = (o.i)localIterator.next();
                if (locali.userName.equals(localObject3)) {
                  ((LinkedList)localObject2).remove(locali);
                }
              }
            }
          }
          if (!bt.gL((List)localObject2)) {
            paramo.field_rawXML = ah.a(paramo.field_rawXML, (LinkedList)localObject2, ((o)localObject1).rWh);
          }
          ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().delete((c)localObject1, new String[0]);
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
    if (paramo.rWe.rXh)
    {
      AppMethodBeat.o(183864);
      return false;
    }
    boolean bool = e.Ey(paramo.rWe.rXg);
    AppMethodBeat.o(183864);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.r
 * JD-Core Version:    0.7.0.1
 */