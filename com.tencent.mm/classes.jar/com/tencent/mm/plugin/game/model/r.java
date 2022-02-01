package com.tencent.mm.plugin.game.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.d.a;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
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
    paramo = Util.nullAsNil(paramo.field_gameMsgId);
    Object localObject = Util.nullAsNil((String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OcY, ""));
    Log.i("MicroMsg.GameMessageService", "filter msgIds:%s", new Object[] { localObject });
    try
    {
      localObject = new JSONArray((String)localObject);
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        if (paramo.equals(((JSONArray)localObject).getString(i)))
        {
          Log.i("MicroMsg.GameMessageService", "filter deleted message. gameMsgId:%s", new Object[] { paramo });
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
    if (paramo.xFf)
    {
      if (!c.aAN(paramo.xFQ.xGN))
      {
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NVL, Long.valueOf(paramo.field_msgId));
        AppMethodBeat.o(183859);
      }
    }
    else {
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NVL, Long.valueOf(0L));
    }
    AppMethodBeat.o(183859);
  }
  
  public static o dVm()
  {
    AppMethodBeat.i(183863);
    Object localObject2 = dVn();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = dVq();
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = dVs();
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = dVu();
    }
    if (localObject1 != null) {
      ((o)localObject1).dVl();
    }
    AppMethodBeat.o(183863);
    return localObject1;
  }
  
  public static o dVn()
  {
    AppMethodBeat.i(41481);
    long l = ((Long)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NVL, Long.valueOf(0L))).longValue();
    if (l != 0L) {}
    for (o localo = ((f)com.tencent.mm.kernel.g.af(f.class)).dSK().GJ(l);; localo = null)
    {
      if ((localo == null) || (localo.field_isHidden) || (i(localo)))
      {
        a.aAy("");
        AppMethodBeat.o(41481);
        return null;
      }
      AppMethodBeat.o(41481);
      return localo;
    }
  }
  
  public static void dVo()
  {
    AppMethodBeat.i(41482);
    long l = ((Long)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NVL, Long.valueOf(0L))).longValue();
    o localo = null;
    if (l != 0L) {
      localo = ((f)com.tencent.mm.kernel.g.af(f.class)).dSK().GJ(l);
    }
    if ((localo == null) || (localo.field_isHidden))
    {
      AppMethodBeat.o(41482);
      return;
    }
    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NVL, Long.valueOf(0L));
    AppMethodBeat.o(41482);
  }
  
  public static o dVp()
  {
    AppMethodBeat.i(41483);
    long l = ((Long)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NVL, Long.valueOf(0L))).longValue();
    o localo = null;
    if (l != 0L) {
      localo = ((f)com.tencent.mm.kernel.g.af(f.class)).dSK().GJ(l);
    }
    AppMethodBeat.o(41483);
    return localo;
  }
  
  public static o dVq()
  {
    AppMethodBeat.i(41484);
    long l = ((Long)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NVP, Long.valueOf(0L))).longValue();
    if (l == 0L)
    {
      AppMethodBeat.o(41484);
      return null;
    }
    o localo = ((f)com.tencent.mm.kernel.g.af(f.class)).dSK().GJ(l);
    if ((localo == null) || (localo.field_isHidden) || (i(localo)))
    {
      AppMethodBeat.o(41484);
      return null;
    }
    AppMethodBeat.o(41484);
    return localo;
  }
  
  public static void dVr()
  {
    AppMethodBeat.i(41485);
    long l = ((Long)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NVP, Long.valueOf(0L))).longValue();
    o localo = null;
    if (l != 0L) {
      localo = ((f)com.tencent.mm.kernel.g.af(f.class)).dSK().GJ(l);
    }
    if ((localo == null) || (localo.field_isHidden))
    {
      AppMethodBeat.o(41485);
      return;
    }
    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NVP, Long.valueOf(0L));
    AppMethodBeat.o(41485);
  }
  
  public static o dVs()
  {
    AppMethodBeat.i(41486);
    long l = ((Long)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NVM, Long.valueOf(0L))).longValue();
    if (l == 0L)
    {
      AppMethodBeat.o(41486);
      return null;
    }
    o localo = ((f)com.tencent.mm.kernel.g.af(f.class)).dSK().GJ(l);
    if ((localo == null) || (localo.field_isHidden) || (i(localo)))
    {
      AppMethodBeat.o(41486);
      return null;
    }
    AppMethodBeat.o(41486);
    return localo;
  }
  
  public static void dVt()
  {
    AppMethodBeat.i(41487);
    long l = ((Long)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NVM, Long.valueOf(0L))).longValue();
    o localo = null;
    if (l != 0L) {
      localo = ((f)com.tencent.mm.kernel.g.af(f.class)).dSK().GJ(l);
    }
    if ((localo == null) || (localo.field_isHidden))
    {
      AppMethodBeat.o(41487);
      return;
    }
    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NVM, Long.valueOf(0L));
    AppMethodBeat.o(41487);
  }
  
  private static o dVu()
  {
    AppMethodBeat.i(41488);
    long l = ((Long)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NVQ, Long.valueOf(0L))).longValue();
    if (l == 0L)
    {
      AppMethodBeat.o(41488);
      return null;
    }
    o localo = ((f)com.tencent.mm.kernel.g.af(f.class)).dSK().GJ(l);
    if ((localo == null) || (localo.field_isHidden) || (i(localo)))
    {
      AppMethodBeat.o(41488);
      return null;
    }
    AppMethodBeat.o(41488);
    return localo;
  }
  
  public static void dVv()
  {
    AppMethodBeat.i(41489);
    long l = ((Long)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NVQ, Long.valueOf(0L))).longValue();
    o localo = null;
    if (l != 0L) {
      localo = ((f)com.tencent.mm.kernel.g.af(f.class)).dSK().GJ(l);
    }
    if ((localo == null) || (localo.field_isHidden))
    {
      AppMethodBeat.o(41489);
      return;
    }
    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NVQ, Long.valueOf(0L));
    AppMethodBeat.o(41489);
  }
  
  public static void e(o paramo)
  {
    AppMethodBeat.i(183860);
    if (!Util.isNullOrNil(paramo.xFw.url))
    {
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NVP, Long.valueOf(paramo.field_msgId));
      AppMethodBeat.o(183860);
      return;
    }
    dVr();
    AppMethodBeat.o(183860);
  }
  
  public static void f(o paramo)
  {
    AppMethodBeat.i(183861);
    if (paramo.xFh)
    {
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NVM, Long.valueOf(paramo.field_msgId));
      AppMethodBeat.o(183861);
      return;
    }
    dVt();
    AppMethodBeat.o(183861);
  }
  
  public static void g(o paramo)
  {
    AppMethodBeat.i(183862);
    if (!Util.isNullOrNil(paramo.xFN.xGf))
    {
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NVQ, Long.valueOf(paramo.field_msgId));
      AppMethodBeat.o(183862);
      return;
    }
    dVv();
    AppMethodBeat.o(183862);
  }
  
  public static boolean h(o paramo)
  {
    AppMethodBeat.i(204167);
    Object localObject = g.dVg();
    long l = Util.nowSecond();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      g.a locala = (g.a)((Iterator)localObject).next();
      if ((locala.startTime <= l) && (locala.endTime >= l) && ((paramo.xFg.xGk == locala.xEF) || (locala.xEG.contains(paramo.field_gameMsgId))))
      {
        AppMethodBeat.o(204167);
        return true;
      }
    }
    AppMethodBeat.o(204167);
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
      if ((paramo.xFQ.xGI > 1) && (!Util.isNullOrNil(paramo.xFQ.xGH)))
      {
        localObject2 = ((f)com.tencent.mm.kernel.g.af(f.class)).dSK();
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
        if (i >= paramo.xFQ.xGI)
        {
          paramo.field_hasMergedCount = i;
          paramo = ((List)localObject1).iterator();
          while (paramo.hasNext())
          {
            localObject1 = (o)paramo.next();
            ((f)com.tencent.mm.kernel.g.af(f.class)).dSK().delete((IAutoDBItem)localObject1, new String[0]);
          }
        }
        AppMethodBeat.o(41491);
      }
    }
    else
    {
      if (Util.isNullOrNil(paramo.field_mergerId))
      {
        AppMethodBeat.o(41491);
        return;
      }
      localObject2 = ((f)com.tencent.mm.kernel.g.af(f.class)).dSK();
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
        ((o)localObject1).dVl();
        if (!Util.isNullOrNil(((o)localObject1).xFe))
        {
          paramo.dVl();
          localObject2 = new LinkedList(((o)localObject1).xFe);
          if (!Util.isNullOrNil(paramo.xFe))
          {
            localObject3 = ((o.k)paramo.xFe.get(0)).userName;
            if (!Util.isNullOrNil((String)localObject3))
            {
              Iterator localIterator = ((o)localObject1).xFe.iterator();
              while (localIterator.hasNext())
              {
                o.k localk = (o.k)localIterator.next();
                if (localk.userName.equals(localObject3)) {
                  ((LinkedList)localObject2).remove(localk);
                }
              }
            }
          }
          if (!Util.isNullOrNil((List)localObject2)) {
            paramo.field_rawXML = ah.a(paramo.field_rawXML, (LinkedList)localObject2, ((o)localObject1).xFj);
          }
          ((f)com.tencent.mm.kernel.g.af(f.class)).dSK().delete((IAutoDBItem)localObject1, new String[0]);
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
    if (paramo.xFg.xGl)
    {
      AppMethodBeat.o(183864);
      return false;
    }
    boolean bool = e.Om(paramo.xFg.xGk);
    AppMethodBeat.o(183864);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.r
 * JD-Core Version:    0.7.0.1
 */