package com.tencent.mm.plugin.game.commlib.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.io.IOException;

public final class c
  extends MAutoStorage<b>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(89952);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(b.info, "PBCache") };
    AppMethodBeat.o(89952);
  }
  
  public c(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, b.info, "PBCache", null);
  }
  
  public final byte[] aFI(String paramString)
  {
    AppMethodBeat.i(89950);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(89950);
      return null;
    }
    b localb = new b();
    localb.field_key = paramString;
    if (super.get(localb, new String[0]))
    {
      paramString = localb.field_value;
      AppMethodBeat.o(89950);
      return paramString;
    }
    AppMethodBeat.o(89950);
    return null;
  }
  
  public final void aFJ(String paramString)
  {
    AppMethodBeat.i(184540);
    b localb = new b();
    localb.field_key = paramString;
    super.delete(localb, new String[0]);
    AppMethodBeat.o(184540);
  }
  
  public final boolean b(String paramString, a parama)
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
      boolean bool = y(paramString, parama);
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
  
  public final boolean y(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(184539);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(184539);
      return false;
    }
    b localb = new b();
    localb.field_key = paramString;
    if (super.get(localb, new String[0])) {
      localb.field_value = paramArrayOfByte;
    }
    for (boolean bool = super.update(localb, new String[0]);; bool = super.insert(localb))
    {
      if (!bool) {
        Log.e("MicroMsg.PBCacheStorage", "Saving cache failed (update or insert)");
      }
      AppMethodBeat.o(184539);
      return bool;
      localb.field_value = paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.b.c
 * JD-Core Version:    0.7.0.1
 */