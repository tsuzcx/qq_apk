package com.tencent.mm.plugin.appbrand.game.b.a;

import android.database.Cursor;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class c
  extends j<b>
{
  public static final String[] fkl;
  private final boolean hsO;
  
  static
  {
    AppMethodBeat.i(130120);
    fkl = new String[] { j.getCreateSQLs(b.info, "WxagGameInfo") };
    AppMethodBeat.o(130120);
  }
  
  public c(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, b.info, "WxagGameInfo", null);
    AppMethodBeat.i(130109);
    if (parame != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.hsO = bool;
      if (!this.hsO) {
        ab.e("MicroMsg.MiniGameInfoStorage", "storage can not work!!!");
      }
      AppMethodBeat.o(130109);
      return;
    }
  }
  
  private boolean a(b paramb)
  {
    AppMethodBeat.i(130117);
    if ((!this.hsO) || (paramb == null))
    {
      AppMethodBeat.o(130117);
      return false;
    }
    boolean bool = super.delete(paramb, new String[0]);
    AppMethodBeat.o(130117);
    return bool;
  }
  
  private b bc(String paramString, int paramInt)
  {
    AppMethodBeat.i(130118);
    if (!this.hsO)
    {
      AppMethodBeat.o(130118);
      return null;
    }
    paramString = rawQuery(String.format("select * from %s where %s=? and %s=?", new Object[] { "WxagGameInfo", "AppId", "debugType" }), new String[] { paramString, String.valueOf(paramInt) });
    if (paramString.moveToFirst())
    {
      b localb = new b();
      localb.convertFrom(paramString);
      paramString.close();
      AppMethodBeat.o(130118);
      return localb;
    }
    paramString.close();
    AppMethodBeat.o(130118);
    return null;
  }
  
  private static String bd(String paramString, int paramInt)
  {
    AppMethodBeat.i(130119);
    paramInt = String.format(Locale.US, "%s|%d", new Object[] { paramString, Integer.valueOf(paramInt) }).hashCode();
    AppMethodBeat.o(130119);
    return String.valueOf(paramInt);
  }
  
  public final b Bv(String paramString)
  {
    AppMethodBeat.i(130111);
    if ((!this.hsO) || (bo.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(130111);
      return null;
    }
    Cursor localCursor = rawQuery(String.format("select * from %s where %s=?", new Object[] { "WxagGameInfo", "RecordId" }), new String[] { paramString });
    if (localCursor.moveToFirst())
    {
      paramString = new b();
      paramString.convertFrom(localCursor);
      localCursor.close();
      AppMethodBeat.o(130111);
      return paramString;
    }
    ab.i("MicroMsg.MiniGameInfoStorage", "getMiniGame recordId:%s, no record in DB", new Object[] { paramString });
    localCursor.close();
    AppMethodBeat.o(130111);
    return null;
  }
  
  public final boolean a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(130116);
    if ((!this.hsO) || (parama == null))
    {
      AppMethodBeat.o(130116);
      return false;
    }
    b localb = bc(parama.fKw, parama.gXd);
    if ((localb == null) || (!localb.field_isSync)) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.MiniGameInfoStorage", "needUpdate:%b", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        a(localb);
        localb = new b();
        if (bo.isNullOrNil(parama.ese)) {
          parama.ese = bd(parama.jJA, parama.gXd);
        }
        localb.field_RecordId = parama.ese;
        localb.field_AppId = parama.fKw;
        localb.field_AppName = parama.ntp;
        localb.field_UserName = parama.jJA;
        localb.field_IconUrl = parama.IconUrl;
        localb.field_BriefIntro = parama.nrg;
        localb.field_isSync = false;
        localb.field_createTime = System.currentTimeMillis();
        bool = insert(localb);
        if ((bool) && (paramBoolean)) {
          doNotify("single", 2, localb.field_RecordId);
        }
        AppMethodBeat.o(130116);
        return bool;
      }
      AppMethodBeat.o(130116);
      return false;
    }
  }
  
  public final List<b> aAB()
  {
    AppMethodBeat.i(130110);
    if (!this.hsO)
    {
      AppMethodBeat.o(130110);
      return null;
    }
    Object localObject = String.format("select * from %s", new Object[] { "WxagGameInfo" });
    Cursor localCursor = rawQuery((String)localObject, new String[0]);
    ab.i("MicroMsg.MiniGameInfoStorage", "getMiniGameList queryStr:%s", new Object[] { localObject });
    if (localCursor == null)
    {
      ab.i("MicroMsg.MiniGameInfoStorage", "cursor is null");
      AppMethodBeat.o(130110);
      return null;
    }
    if (localCursor.moveToFirst())
    {
      localObject = new ArrayList();
      do
      {
        b localb = new b();
        localb.convertFrom(localCursor);
        ((List)localObject).add(localb);
      } while (localCursor.moveToNext());
      localCursor.close();
      ab.i("MicroMsg.MiniGameInfoStorage", "record list size:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
      AppMethodBeat.o(130110);
      return localObject;
    }
    localCursor.close();
    ab.i("MicroMsg.MiniGameInfoStorage", "no record");
    AppMethodBeat.o(130110);
    return null;
  }
  
  public final boolean aF(List<String> paramList)
  {
    AppMethodBeat.i(130115);
    if ((!this.hsO) || (bo.es(paramList)))
    {
      AppMethodBeat.o(130115);
      return false;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      ag((String)localIterator.next(), false);
    }
    doNotify("batch", 5, paramList);
    AppMethodBeat.o(130115);
    return true;
  }
  
  public final void add(k.a parama)
  {
    AppMethodBeat.i(130112);
    add(parama, com.tencent.mm.plugin.appbrand.t.e.aNS().oNc.getLooper());
    AppMethodBeat.o(130112);
  }
  
  public final boolean ag(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(130114);
    if ((!this.hsO) || (bo.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(130114);
      return false;
    }
    b localb = new b();
    localb.field_RecordId = paramString;
    boolean bool = super.delete(localb, new String[0]);
    if ((bool) && (paramBoolean)) {
      doNotify("single", 5, paramString);
    }
    AppMethodBeat.o(130114);
    return bool;
  }
  
  public final boolean b(List<a> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(130113);
    if ((!this.hsO) || (bo.es(paramList)))
    {
      AppMethodBeat.o(130113);
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      a(locala, false);
      localArrayList.add(locala.ese);
    }
    if (paramBoolean) {
      doNotify("batch", 2, localArrayList);
    }
    ab.i("MicroMsg.MiniGameInfoStorage", "insert miniGame size:%d,   isSync:%b", new Object[] { Integer.valueOf(paramList.size()), Boolean.FALSE });
    AppMethodBeat.o(130113);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.b.a.c
 * JD-Core Version:    0.7.0.1
 */