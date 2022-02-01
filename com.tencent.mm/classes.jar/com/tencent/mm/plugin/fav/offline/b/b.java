package com.tencent.mm.plugin.fav.offline.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends j<a>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(73573);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.info, "FavOffline") };
    INDEX_CREATE = new String[0];
    AppMethodBeat.o(73573);
  }
  
  public b(e parame)
  {
    super(parame, a.info, "FavOffline", INDEX_CREATE);
    this.db = parame;
  }
  
  public final boolean Yt(String paramString)
  {
    AppMethodBeat.i(73569);
    if (bt.isNullOrNil(paramString))
    {
      ad.i("MicroMsg.offline.FavOfflineStorage", "url is null!");
      AppMethodBeat.o(73569);
      return true;
    }
    try
    {
      i = this.db.delete("FavOffline", "url=?", new String[] { paramString });
      if (i > 0)
      {
        AppMethodBeat.o(73569);
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.offline.FavOfflineStorage", "deleteByUrl url:%s Exception:%s %s", new Object[] { paramString, localException.getClass().getSimpleName(), localException.getMessage() });
        int i = 0;
      }
      AppMethodBeat.o(73569);
    }
    return false;
  }
  
  public final a Yu(String paramString)
  {
    AppMethodBeat.i(73570);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(73570);
      return null;
    }
    paramString = this.db.query("FavOffline", a.info.columns, "url=?", new String[] { paramString }, null, null, "rowid");
    if (paramString.moveToNext())
    {
      a locala = new a();
      locala.convertFrom(paramString);
      AppMethodBeat.o(73570);
      return locala;
    }
    AppMethodBeat.o(73570);
    return null;
  }
  
  public final boolean b(a parama)
  {
    AppMethodBeat.i(73566);
    if (parama == null)
    {
      AppMethodBeat.o(73566);
      return false;
    }
    boolean bool = super.insert(parama);
    AppMethodBeat.o(73566);
    return bool;
  }
  
  public final boolean c(a parama)
  {
    AppMethodBeat.i(73568);
    if (parama == null)
    {
      ad.e("MicroMsg.offline.FavOfflineStorage", "update() item is null");
      AppMethodBeat.o(73568);
      return false;
    }
    boolean bool = update(parama.systemRowid, parama);
    AppMethodBeat.o(73568);
    return bool;
  }
  
  public final List<a> ciG()
  {
    AppMethodBeat.i(73567);
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.db.query("FavOffline", a.info.columns, "status!=?", new String[] { "0" }, null, null, "updateTime asc");
    while (localCursor.moveToNext())
    {
      a locala = new a();
      locala.convertFrom(localCursor);
      localArrayList.add(locala);
    }
    if (localArrayList.size() == 0)
    {
      AppMethodBeat.o(73567);
      return localArrayList;
    }
    AppMethodBeat.o(73567);
    return localArrayList;
  }
  
  public final List<a> ciH()
  {
    AppMethodBeat.i(73571);
    Cursor localCursor = this.db.query("FavOffline", a.info.columns, "status!=? and failNum<?", new String[] { "2", "5" }, null, null, "rowid");
    if (localCursor == null)
    {
      AppMethodBeat.o(73571);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext())
    {
      a locala = new a();
      locala.convertFrom(localCursor);
      localArrayList.add(locala);
    }
    if (localArrayList.size() == 0)
    {
      AppMethodBeat.o(73571);
      return null;
    }
    AppMethodBeat.o(73571);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.offline.b.b
 * JD-Core Version:    0.7.0.1
 */