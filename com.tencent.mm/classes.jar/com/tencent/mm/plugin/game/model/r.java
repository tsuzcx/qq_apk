package com.tencent.mm.plugin.game.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.c.a;
import com.tencent.mm.plugin.game.d.c;
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
  private static void aJV(String paramString)
  {
    AppMethodBeat.i(208810);
    o localo = eyv();
    if ((localo != null) && (Util.nullAsNil(localo.field_gameMsgId).equals(paramString))) {
      eyw();
    }
    AppMethodBeat.o(208810);
  }
  
  public static boolean c(o paramo)
  {
    AppMethodBeat.i(41480);
    paramo = Util.nullAsNil(paramo.field_gameMsgId);
    Object localObject = Util.nullAsNil((String)h.aHG().aHp().get(ar.a.Vrf, ""));
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
    if (paramo.CJg)
    {
      if (!c.aKz(paramo.CJR.CKQ))
      {
        h.aHG().aHp().set(ar.a.VjL, Long.valueOf(paramo.field_msgId));
        AppMethodBeat.o(183859);
      }
    }
    else {
      h.aHG().aHp().set(ar.a.VjL, Long.valueOf(0L));
    }
    AppMethodBeat.o(183859);
  }
  
  public static o eyA()
  {
    AppMethodBeat.i(41486);
    long l = ((Long)h.aHG().aHp().get(ar.a.VjM, Long.valueOf(0L))).longValue();
    if (l == 0L)
    {
      AppMethodBeat.o(41486);
      return null;
    }
    o localo = ((com.tencent.mm.plugin.game.api.f)h.ae(com.tencent.mm.plugin.game.api.f.class)).evo().NP(l);
    if ((localo == null) || (localo.field_isHidden) || (i(localo)))
    {
      AppMethodBeat.o(41486);
      return null;
    }
    AppMethodBeat.o(41486);
    return localo;
  }
  
  private static o eyC()
  {
    AppMethodBeat.i(41488);
    long l = ((Long)h.aHG().aHp().get(ar.a.VjQ, Long.valueOf(0L))).longValue();
    if (l == 0L)
    {
      AppMethodBeat.o(41488);
      return null;
    }
    o localo = ((com.tencent.mm.plugin.game.api.f)h.ae(com.tencent.mm.plugin.game.api.f.class)).evo().NP(l);
    if ((localo == null) || (localo.field_isHidden) || (i(localo)))
    {
      AppMethodBeat.o(41488);
      return null;
    }
    AppMethodBeat.o(41488);
    return localo;
  }
  
  public static o eyu()
  {
    AppMethodBeat.i(183863);
    Object localObject2 = eyv();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = eyy();
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = eyA();
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = eyC();
    }
    if (localObject1 != null) {
      ((o)localObject1).eyt();
    }
    AppMethodBeat.o(183863);
    return localObject1;
  }
  
  public static o eyv()
  {
    AppMethodBeat.i(41481);
    long l = ((Long)h.aHG().aHp().get(ar.a.VjL, Long.valueOf(0L))).longValue();
    if (l != 0L) {}
    for (o localo = ((com.tencent.mm.plugin.game.api.f)h.ae(com.tencent.mm.plugin.game.api.f.class)).evo().NP(l);; localo = null)
    {
      if ((localo == null) || (localo.field_isHidden) || (i(localo)))
      {
        a.aKk("");
        AppMethodBeat.o(41481);
        return null;
      }
      AppMethodBeat.o(41481);
      return localo;
    }
  }
  
  public static void eyw()
  {
    AppMethodBeat.i(41482);
    long l = ((Long)h.aHG().aHp().get(ar.a.VjL, Long.valueOf(0L))).longValue();
    o localo = null;
    if (l != 0L) {
      localo = ((com.tencent.mm.plugin.game.api.f)h.ae(com.tencent.mm.plugin.game.api.f.class)).evo().NP(l);
    }
    if ((localo == null) || (localo.field_isHidden))
    {
      AppMethodBeat.o(41482);
      return;
    }
    h.aHG().aHp().set(ar.a.VjL, Long.valueOf(0L));
    AppMethodBeat.o(41482);
  }
  
  public static o eyx()
  {
    AppMethodBeat.i(41483);
    long l = ((Long)h.aHG().aHp().get(ar.a.VjL, Long.valueOf(0L))).longValue();
    o localo = null;
    if (l != 0L) {
      localo = ((com.tencent.mm.plugin.game.api.f)h.ae(com.tencent.mm.plugin.game.api.f.class)).evo().NP(l);
    }
    AppMethodBeat.o(41483);
    return localo;
  }
  
  public static o eyy()
  {
    AppMethodBeat.i(41484);
    long l = ((Long)h.aHG().aHp().get(ar.a.VjP, Long.valueOf(0L))).longValue();
    if (l == 0L)
    {
      AppMethodBeat.o(41484);
      return null;
    }
    o localo = ((com.tencent.mm.plugin.game.api.f)h.ae(com.tencent.mm.plugin.game.api.f.class)).evo().NP(l);
    if ((localo == null) || (localo.field_isHidden) || (i(localo)))
    {
      AppMethodBeat.o(41484);
      return null;
    }
    AppMethodBeat.o(41484);
    return localo;
  }
  
  public static boolean h(o paramo)
  {
    AppMethodBeat.i(208804);
    Object localObject = g.eyn();
    long l = Util.nowSecond();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      g.a locala = (g.a)((Iterator)localObject).next();
      if ((locala.startTime <= l) && (locala.endTime >= l) && ((paramo.CJh.CKn == locala.CIG) || (locala.CIH.contains(paramo.field_gameMsgId))))
      {
        AppMethodBeat.o(208804);
        return true;
      }
    }
    AppMethodBeat.o(208804);
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
      if ((paramo.CJR.CKL > 1) && (!Util.isNullOrNil(paramo.CJR.CKK)))
      {
        localObject2 = ((com.tencent.mm.plugin.game.api.f)h.ae(com.tencent.mm.plugin.game.api.f.class)).evo();
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
        if (i >= paramo.CJR.CKL)
        {
          paramo.field_hasMergedCount = i;
          paramo = ((List)localObject1).iterator();
          while (paramo.hasNext())
          {
            localObject1 = (o)paramo.next();
            ((com.tencent.mm.plugin.game.api.f)h.ae(com.tencent.mm.plugin.game.api.f.class)).evo().delete((IAutoDBItem)localObject1, new String[0]);
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
      localObject2 = ((com.tencent.mm.plugin.game.api.f)h.ae(com.tencent.mm.plugin.game.api.f.class)).evo();
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
        ((o)localObject1).eyt();
        if (!Util.isNullOrNil(((o)localObject1).CJf))
        {
          paramo.eyt();
          localObject2 = new LinkedList(((o)localObject1).CJf);
          if (!Util.isNullOrNil(paramo.CJf))
          {
            localObject3 = ((o.l)paramo.CJf.get(0)).userName;
            if (!Util.isNullOrNil((String)localObject3))
            {
              Iterator localIterator = ((o)localObject1).CJf.iterator();
              while (localIterator.hasNext())
              {
                o.l locall = (o.l)localIterator.next();
                if (locall.userName.equals(localObject3)) {
                  ((LinkedList)localObject2).remove(locall);
                }
              }
            }
          }
          if (!Util.isNullOrNil((List)localObject2)) {
            paramo.field_rawXML = ah.a(paramo.field_rawXML, (LinkedList)localObject2, ((o)localObject1).CJk);
          }
          ((com.tencent.mm.plugin.game.api.f)h.ae(com.tencent.mm.plugin.game.api.f.class)).evo().delete((IAutoDBItem)localObject1, new String[0]);
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
    if (paramo.CJh.CKo)
    {
      AppMethodBeat.o(183864);
      return false;
    }
    boolean bool = e.TF(paramo.CJh.CKn);
    AppMethodBeat.o(183864);
    return bool;
  }
  
  public final void e(o paramo)
  {
    AppMethodBeat.i(183860);
    if (!Util.isNullOrNil(paramo.CJx.url))
    {
      h.aHG().aHp().set(ar.a.VjP, Long.valueOf(paramo.field_msgId));
      AppMethodBeat.o(183860);
      return;
    }
    eyz();
    AppMethodBeat.o(183860);
  }
  
  public final void eyB()
  {
    AppMethodBeat.i(41487);
    long l = ((Long)h.aHG().aHp().get(ar.a.VjM, Long.valueOf(0L))).longValue();
    o localo = null;
    if (l != 0L) {
      localo = ((com.tencent.mm.plugin.game.api.f)h.ae(com.tencent.mm.plugin.game.api.f.class)).evo().NP(l);
    }
    if ((localo == null) || (localo.field_isHidden))
    {
      AppMethodBeat.o(41487);
      return;
    }
    h.aHG().aHp().set(ar.a.VjM, Long.valueOf(0L));
    aJV(localo.field_gameMsgId);
    AppMethodBeat.o(41487);
  }
  
  public final void eyD()
  {
    AppMethodBeat.i(41489);
    long l = ((Long)h.aHG().aHp().get(ar.a.VjQ, Long.valueOf(0L))).longValue();
    o localo = null;
    if (l != 0L) {
      localo = ((com.tencent.mm.plugin.game.api.f)h.ae(com.tencent.mm.plugin.game.api.f.class)).evo().NP(l);
    }
    if ((localo == null) || (localo.field_isHidden))
    {
      AppMethodBeat.o(41489);
      return;
    }
    h.aHG().aHp().set(ar.a.VjQ, Long.valueOf(0L));
    aJV(localo.field_gameMsgId);
    AppMethodBeat.o(41489);
  }
  
  public final void eyz()
  {
    AppMethodBeat.i(41485);
    long l = ((Long)h.aHG().aHp().get(ar.a.VjP, Long.valueOf(0L))).longValue();
    o localo = null;
    if (l != 0L) {
      localo = ((com.tencent.mm.plugin.game.api.f)h.ae(com.tencent.mm.plugin.game.api.f.class)).evo().NP(l);
    }
    if ((localo == null) || (localo.field_isHidden))
    {
      AppMethodBeat.o(41485);
      return;
    }
    h.aHG().aHp().set(ar.a.VjP, Long.valueOf(0L));
    aJV(localo.field_gameMsgId);
    AppMethodBeat.o(41485);
  }
  
  public final void f(o paramo)
  {
    AppMethodBeat.i(183861);
    if (paramo.CJi)
    {
      h.aHG().aHp().set(ar.a.VjM, Long.valueOf(paramo.field_msgId));
      AppMethodBeat.o(183861);
      return;
    }
    eyB();
    AppMethodBeat.o(183861);
  }
  
  public final void g(o paramo)
  {
    AppMethodBeat.i(183862);
    if (!Util.isNullOrNil(paramo.CJO.CKi))
    {
      h.aHG().aHp().set(ar.a.VjQ, Long.valueOf(paramo.field_msgId));
      AppMethodBeat.o(183862);
      return;
    }
    eyD();
    AppMethodBeat.o(183862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.r
 * JD-Core Version:    0.7.0.1
 */