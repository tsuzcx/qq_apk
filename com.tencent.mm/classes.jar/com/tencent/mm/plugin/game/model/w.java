package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;

public final class w
  extends j<v>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(111357);
    SQL_CREATE = new String[] { j.getCreateSQLs(v.info, "GamePBCache") };
    AppMethodBeat.o(111357);
  }
  
  public w(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, v.info, "GamePBCache", null);
  }
  
  public final byte[] PN(String paramString)
  {
    AppMethodBeat.i(111354);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(111354);
      return null;
    }
    if (!aa.dsG().equals(e.bFY()))
    {
      AppMethodBeat.o(111354);
      return null;
    }
    v localv = new v();
    localv.field_key = paramString;
    if (super.get(localv, new String[0]))
    {
      paramString = localv.field_value;
      AppMethodBeat.o(111354);
      return paramString;
    }
    AppMethodBeat.o(111354);
    return null;
  }
  
  public final boolean b(String paramString, a parama)
  {
    AppMethodBeat.i(111355);
    if ((bo.isNullOrNil(paramString)) || (parama == null))
    {
      AppMethodBeat.o(111355);
      return false;
    }
    try
    {
      parama = parama.toByteArray();
      boolean bool = w(paramString, parama);
      AppMethodBeat.o(111355);
      return bool;
    }
    catch (IOException paramString)
    {
      ab.e("MicroMsg.GamePBCacheStorage", "Saving Failed: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(111355);
    }
    return false;
  }
  
  public final boolean w(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(111356);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(111356);
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
        ab.e("MicroMsg.GamePBCacheStorage", "Saving cache failed (update or insert)");
      }
      AppMethodBeat.o(111356);
      return bool;
      localv.field_value = paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.w
 * JD-Core Version:    0.7.0.1
 */