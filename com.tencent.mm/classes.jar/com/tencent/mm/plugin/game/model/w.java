package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
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
  
  public final boolean aAl(String paramString)
  {
    AppMethodBeat.i(204178);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(204178);
      return false;
    }
    v localv = new v();
    localv.field_key = paramString;
    boolean bool = super.delete(localv, new String[0]);
    AppMethodBeat.o(204178);
    return bool;
  }
  
  public final byte[] azn(String paramString)
  {
    AppMethodBeat.i(41519);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(41519);
      return null;
    }
    if (!LocaleUtil.getApplicationLanguage().equals(e.dUX()))
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
      boolean bool = r(paramString, parama);
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
  
  public final boolean r(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41521);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.w
 * JD-Core Version:    0.7.0.1
 */