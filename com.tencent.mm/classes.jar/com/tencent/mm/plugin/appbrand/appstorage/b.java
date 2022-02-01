package com.tencent.mm.plugin.appbrand.appstorage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public class b
  extends MAutoStorage<a>
{
  public static final String[] lqL;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(44450);
    lqL = new String[] { MAutoStorage.getCreateSQLs(a.info, "AppBrandIdentifierInfo") };
    AppMethodBeat.o(44450);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.info, "AppBrandIdentifierInfo", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final String ads(String paramString)
  {
    AppMethodBeat.i(44448);
    Cursor localCursor = this.db.query("AppBrandIdentifierInfo", new String[] { "appId" }, "username=?", new String[] { paramString }, null, null, null);
    if ((localCursor != null) && (localCursor.moveToFirst())) {}
    for (String str = localCursor.getString(0);; str = "")
    {
      if (localCursor != null) {
        localCursor.close();
      }
      Log.i("MicroMsg.AppBrand.AppBrandIdentifierInfoStorage", "queryAppId: appId = [%s], userName = [%s]", new Object[] { str, paramString });
      AppMethodBeat.o(44448);
      return str;
    }
  }
  
  public final String adt(String paramString)
  {
    AppMethodBeat.i(44449);
    Cursor localCursor = this.db.query("AppBrandIdentifierInfo", new String[] { "username" }, "appId=?", new String[] { paramString }, null, null, null);
    if ((localCursor != null) && (localCursor.moveToFirst())) {}
    for (String str = localCursor.getString(0);; str = "")
    {
      if (localCursor != null) {
        localCursor.close();
      }
      Log.i("MicroMsg.AppBrand.AppBrandIdentifierInfoStorage", "queryAppId: appId = [%s], userName = [%s]", new Object[] { paramString, str });
      AppMethodBeat.o(44449);
      return str;
    }
  }
  
  public final boolean cD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(44447);
    Log.i("MicroMsg.AppBrand.AppBrandIdentifierInfoStorage", "addIdentifierInfo: appId = [%s], userName = [%s]", new Object[] { paramString1, paramString2 });
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(44447);
      return false;
    }
    a locala = new a();
    locala.field_appId = paramString1;
    locala.field_username = paramString2;
    boolean bool = insert(locala);
    AppMethodBeat.o(44447);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.b
 * JD-Core Version:    0.7.0.1
 */