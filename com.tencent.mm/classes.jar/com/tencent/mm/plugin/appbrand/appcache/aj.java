package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.LinkedList;
import java.util.Locale;

public final class aj
  extends MAutoStorage<ai>
{
  public static final String[] lqL;
  final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(44317);
    lqL = new String[] { MAutoStorage.getCreateSQLs(ai.nFK, "PkgUsageLRURecord") };
    AppMethodBeat.o(44317);
  }
  
  public aj(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, ai.nFK, "PkgUsageLRURecord", ai.INDEX_CREATE);
    this.db = paramISQLiteDatabase;
  }
  
  public final LinkedList<String> bGW()
  {
    AppMethodBeat.i(271708);
    LinkedList localLinkedList = new LinkedList();
    localObject2 = String.format(Locale.US, " %s, %s ASC", new Object[] { "hit", "hitTimeMS" });
    localObject2 = this.db.query("PkgUsageLRURecord", new String[] { "appId" }, null, null, null, null, (String)localObject2, 2);
    if (localObject2 == null)
    {
      AppMethodBeat.o(271708);
      return localLinkedList;
    }
    if (!((Cursor)localObject2).moveToFirst())
    {
      ((Cursor)localObject2).close();
      AppMethodBeat.o(271708);
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
      AppMethodBeat.o(271708);
    }
    AppMethodBeat.o(271708);
    return localLinkedList;
  }
  
  public final void bk(String paramString, int paramInt)
  {
    AppMethodBeat.i(44316);
    ai localai = new ai();
    localai.field_appId = paramString;
    localai.field_type = paramInt;
    super.delete(localai, ai.nDP);
    AppMethodBeat.o(44316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aj
 * JD-Core Version:    0.7.0.1
 */