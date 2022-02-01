package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.io.IOException;

public final class w
  extends MAutoStorage<v>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(41522);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(v.info, "GamePBCache") };
    AppMethodBeat.o(41522);
  }
  
  public w(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, v.info, "GamePBCache", null);
  }
  
  public final byte[] aFI(String paramString)
  {
    AppMethodBeat.i(41519);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(41519);
      return null;
    }
    if (!LocaleUtil.getApplicationLanguage().equals(e.fGa()))
    {
      AppMethodBeat.o(41519);
      return null;
    }
    v localv = new v();
    localv.field_key = paramString;
    if (super.get(localv, new String[0]))
    {
      paramString = localv.field_value;
      AppMethodBeat.o(41519);
      return paramString;
    }
    AppMethodBeat.o(41519);
    return null;
  }
  
  public final boolean aGM(String paramString)
  {
    AppMethodBeat.i(275421);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(275421);
      return false;
    }
    v localv = new v();
    localv.field_key = paramString;
    boolean bool = super.delete(localv, new String[0]);
    AppMethodBeat.o(275421);
    return bool;
  }
  
  public final void aGN(String paramString)
  {
    AppMethodBeat.i(275422);
    paramString = "delete from GamePBCache where key like '%" + paramString + "'";
    Log.i("MicroMsg.GamePBCacheStorage", "deleteDataWithSuffix, ret:%b, sql: %s", new Object[] { Boolean.valueOf(execSQL("GameHaowanMedia", paramString)), paramString });
    AppMethodBeat.o(275422);
  }
  
  public final boolean b(String paramString, a parama)
  {
    AppMethodBeat.i(41520);
    if ((Util.isNullOrNil(paramString)) || (parama == null))
    {
      AppMethodBeat.o(41520);
      return false;
    }
    try
    {
      parama = parama.toByteArray();
      boolean bool = y(paramString, parama);
      AppMethodBeat.o(41520);
      return bool;
    }
    catch (IOException paramString)
    {
      Log.e("MicroMsg.GamePBCacheStorage", "Saving Failed: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(41520);
    }
    return false;
  }
  
  public final boolean y(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41521);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(41521);
      return false;
    }
    v localv = new v();
    localv.field_key = paramString;
    if (super.get(localv, new String[0])) {
      localv.field_value = paramArrayOfByte;
    }
    for (boolean bool = super.update(localv, new String[0]);; bool = super.insert(localv))
    {
      if (!bool) {
        Log.e("MicroMsg.GamePBCacheStorage", "Saving cache failed (update or insert)");
      }
      AppMethodBeat.o(41521);
      return bool;
      localv.field_value = paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.w
 * JD-Core Version:    0.7.0.1
 */