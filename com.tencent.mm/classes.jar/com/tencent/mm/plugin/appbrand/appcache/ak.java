package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.LinkedList;
import java.util.Locale;

public final class ak
  extends MAutoStorage<aj>
{
  public static final String[] nVW;
  final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(44317);
    nVW = new String[] { MAutoStorage.getCreateSQLs(aj.DB_INFO, "PkgUsageLRURecord") };
    AppMethodBeat.o(44317);
  }
  
  public ak(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, aj.DB_INFO, "PkgUsageLRURecord", aj.INDEX_CREATE);
    this.db = paramISQLiteDatabase;
  }
  
  public final void bB(String paramString, int paramInt)
  {
    AppMethodBeat.i(44316);
    aj localaj = new aj();
    localaj.field_appId = paramString;
    localaj.field_type = paramInt;
    super.delete(localaj, aj.qDJ);
    AppMethodBeat.o(44316);
  }
  
  public final LinkedList<String> cgs()
  {
    AppMethodBeat.i(320258);
    LinkedList localLinkedList = new LinkedList();
    localObject2 = String.format(Locale.US, " %s, %s ASC", new Object[] { "hit", "hitTimeMS" });
    localObject2 = this.db.query("PkgUsageLRURecord", new String[] { "appId" }, null, null, null, null, (String)localObject2, 2);
    if (localObject2 == null)
    {
      AppMethodBeat.o(320258);
      return localLinkedList;
    }
    if (!((Cursor)localObject2).moveToFirst())
    {
      ((Cursor)localObject2).close();
      AppMethodBeat.o(320258);
      return localLinkedList;
    }
    try
    {
      boolean bool;
      do
      {
        localLinkedList.add(((Cursor)localObject2).getString(0));
        bool = ((Cursor)localObject2).moveToNext();
      } while (bool);
      ((Cursor)localObject2).close();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.PkgUsageLRUStorage", "getLRUAppIdList error:%s", new Object[] { localException });
        ((Cursor)localObject2).close();
      }
    }
    finally
    {
      ((Cursor)localObject2).close();
      AppMethodBeat.o(320258);
    }
    AppMethodBeat.o(320258);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ak
 * JD-Core Version:    0.7.0.1
 */