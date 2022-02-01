package com.tencent.mm.plugin.game.commlib.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;

public final class b
  extends j<a>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(89952);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.info, "PBCache") };
    AppMethodBeat.o(89952);
  }
  
  public b(e parame)
  {
    super(parame, a.info, "PBCache", null);
  }
  
  public final byte[] abW(String paramString)
  {
    AppMethodBeat.i(89950);
    if (bt.isNullOrNil(paramString))
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
  
  public final void abX(String paramString)
  {
    AppMethodBeat.i(184540);
    a locala = new a();
    locala.field_key = paramString;
    super.delete(locala, new String[0]);
    AppMethodBeat.o(184540);
  }
  
  public final boolean b(String paramString, com.tencent.mm.bx.a parama)
  {
    AppMethodBeat.i(89951);
    if ((bt.isNullOrNil(paramString)) || (parama == null))
    {
      AppMethodBeat.o(89951);
      return false;
    }
    try
    {
      parama = parama.toByteArray();
      boolean bool = q(paramString, parama);
      AppMethodBeat.o(89951);
      return bool;
    }
    catch (IOException paramString)
    {
      ad.e("MicroMsg.PBCacheStorage", "Saving Failed: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(89951);
    }
    return false;
  }
  
  public final boolean q(String paramString, byte[] paramArrayOfByte)
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
        ad.e("MicroMsg.PBCacheStorage", "Saving cache failed (update or insert)");
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