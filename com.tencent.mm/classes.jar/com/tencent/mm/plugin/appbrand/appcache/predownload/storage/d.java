package com.tencent.mm.plugin.appbrand.appcache.predownload.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends com.tencent.mm.plugin.appbrand.ae.c<c>
{
  public static final String[] nVW;
  private final ISQLiteDatabase qFJ;
  
  static
  {
    AppMethodBeat.i(44439);
    nVW = new String[] { MAutoStorage.getCreateSQLs(c.nVV, "PredownloadCmdGetCodePersistentInfo2"), "DROP TABLE IF EXISTS PredownloadCmdGetCodePersistentInfo" };
    AppMethodBeat.o(44439);
  }
  
  public d(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, c.nVV, "PredownloadCmdGetCodePersistentInfo2", c.INDEX_CREATE);
    this.qFJ = paramISQLiteDatabase;
  }
  
  public final boolean a(c paramc, String... paramVarArgs)
  {
    AppMethodBeat.i(320446);
    boolean bool = super.delete(paramc, paramVarArgs);
    Log.i("MicroMsg.Appbrand.Predownload.CmdGetCodePersistentStorage", "delete(%b) %s", new Object[] { Boolean.valueOf(bool), paramc });
    AppMethodBeat.o(320446);
    return bool;
  }
  
  public final boolean b(c paramc, String... paramVarArgs)
  {
    AppMethodBeat.i(320449);
    boolean bool = super.update(paramc, paramVarArgs);
    Log.i("MicroMsg.Appbrand.Predownload.CmdGetCodePersistentStorage", "update(%b) %s", new Object[] { Boolean.valueOf(bool), paramc });
    AppMethodBeat.o(320449);
    return bool;
  }
  
  public final List<c> c(String paramString, String... paramVarArgs)
  {
    AppMethodBeat.i(44438);
    paramString = this.qFJ.query("PredownloadCmdGetCodePersistentInfo2", null, paramString, paramVarArgs, null, null, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.storage.d
 * JD-Core Version:    0.7.0.1
 */