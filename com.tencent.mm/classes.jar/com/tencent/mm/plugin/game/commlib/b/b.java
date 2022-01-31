package com.tencent.mm.plugin.game.commlib.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;

public final class b
  extends j<a>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(59420);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.info, "PBCache") };
    AppMethodBeat.o(59420);
  }
  
  public b(e parame)
  {
    super(parame, a.info, "PBCache", null);
  }
  
  public final byte[] PN(String paramString)
  {
    AppMethodBeat.i(59418);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(59418);
      return null;
    }
    a locala = new a();
    locala.field_key = paramString;
    if (super.get(locala, new String[0]))
    {
      paramString = locala.field_value;
      AppMethodBeat.o(59418);
      return paramString;
    }
    AppMethodBeat.o(59418);
    return null;
  }
  
  public final boolean b(String paramString, com.tencent.mm.bv.a parama)
  {
    AppMethodBeat.i(59419);
    if ((bo.isNullOrNil(paramString)) || (parama == null))
    {
      AppMethodBeat.o(59419);
      return false;
    }
    try
    {
      parama = parama.toByteArray();
      if ((parama == null) || (parama.length == 0))
      {
        AppMethodBeat.o(59419);
        return false;
      }
    }
    catch (IOException paramString)
    {
      ab.e("MicroMsg.PBCacheStorage", "Saving Failed: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(59419);
      return false;
    }
    a locala = new a();
    locala.field_key = paramString;
    if (super.get(locala, new String[0])) {
      locala.field_value = parama;
    }
    for (boolean bool = super.update(locala, new String[0]);; bool = super.insert(locala))
    {
      if (!bool) {
        ab.e("MicroMsg.PBCacheStorage", "Saving cache failed (update or insert)");
      }
      AppMethodBeat.o(59419);
      return bool;
      locala.field_value = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.b.b
 * JD-Core Version:    0.7.0.1
 */