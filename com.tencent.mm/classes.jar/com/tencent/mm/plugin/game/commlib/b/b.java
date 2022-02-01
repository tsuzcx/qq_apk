package com.tencent.mm.plugin.game.commlib.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.io.IOException;

public final class b
  extends MAutoStorage<a>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(89952);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(a.info, "PBCache") };
    AppMethodBeat.o(89952);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.info, "PBCache", null);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString, String[] paramArrayOfString)
  {
    super(paramISQLiteDatabase, paramMAutoDBInfo, paramString, paramArrayOfString);
  }
  
  public final byte[] aIX(String paramString)
  {
    AppMethodBeat.i(89950);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(89950);
      return null;
    }
    a locala = new a();
    locala.field_key = paramString;
    if (super.get(locala, new String[0]))
    {
      paramString = locala.field_value;
      AppMethodBeat.o(89950);
      return paramString;
    }
    AppMethodBeat.o(89950);
    return null;
  }
  
  public final void aIY(String paramString)
  {
    AppMethodBeat.i(184540);
    a locala = new a();
    locala.field_key = paramString;
    super.delete(locala, new String[0]);
    AppMethodBeat.o(184540);
  }
  
  public final boolean b(String paramString, com.tencent.mm.cd.a parama)
  {
    AppMethodBeat.i(89951);
    if ((Util.isNullOrNil(paramString)) || (parama == null))
    {
      AppMethodBeat.o(89951);
      return false;
    }
    try
    {
      parama = parama.toByteArray();
      boolean bool = u(paramString, parama);
      AppMethodBeat.o(89951);
      return bool;
    }
    catch (IOException paramString)
    {
      Log.e("MicroMsg.PBCacheStorage", "Saving Failed: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(89951);
    }
    return false;
  }
  
  public final boolean u(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(184539);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(184539);
      return false;
    }
    a locala = new a();
    locala.field_key = paramString;
    if (super.get(locala, new String[0])) {
      locala.field_value = paramArrayOfByte;
    }
    for (boolean bool = super.update(locala, new String[0]);; bool = super.insert(locala))
    {
      if (!bool) {
        Log.e("MicroMsg.PBCacheStorage", "Saving cache failed (update or insert)");
      }
      AppMethodBeat.o(184539);
      return bool;
      locala.field_value = paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.b.b
 * JD-Core Version:    0.7.0.1
 */