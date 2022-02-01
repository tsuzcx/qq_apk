package com.tencent.mm.plugin.appbrand.appcache.predownload.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends com.tencent.mm.plugin.appbrand.ab.c<c>
{
  public static final String[] lqL;
  private final ISQLiteDatabase nFQ;
  
  static
  {
    AppMethodBeat.i(44439);
    lqL = new String[] { MAutoStorage.getCreateSQLs(c.lqK, "PredownloadCmdGetCodePersistentInfo2"), "DROP TABLE IF EXISTS PredownloadCmdGetCodePersistentInfo" };
    AppMethodBeat.o(44439);
  }
  
  public d(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, c.lqK, "PredownloadCmdGetCodePersistentInfo2", c.INDEX_CREATE);
    this.nFQ = paramISQLiteDatabase;
  }
  
  public final List<c> b(String paramString, String... paramVarArgs)
  {
    AppMethodBeat.i(44438);
    paramString = this.nFQ.query("PredownloadCmdGetCodePersistentInfo2", null, paramString, paramVarArgs, null, null, null);
    if ((paramString == null) || (paramString.isClosed()))
    {
      paramString = Collections.emptyList();
      AppMethodBeat.o(44438);
      return paramString;
    }
    paramVarArgs = new LinkedList();
    if (paramString.moveToFirst()) {
      do
      {
        c localc = new c();
        localc.convertFrom(paramString);
        paramVarArgs.add(localc);
      } while (paramString.moveToNext());
    }
    paramString.close();
    AppMethodBeat.o(44438);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.e.d
 * JD-Core Version:    0.7.0.1
 */