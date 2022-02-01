package com.tencent.mm.plugin.appbrand.appcache.b.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends com.tencent.mm.plugin.appbrand.y.c<c>
{
  public static final String[] hlS;
  private final e jnc;
  
  static
  {
    AppMethodBeat.i(44439);
    hlS = new String[] { j.getCreateSQLs(c.hlR, "PredownloadCmdGetCodePersistentInfo2"), "DROP TABLE IF EXISTS PredownloadCmdGetCodePersistentInfo" };
    AppMethodBeat.o(44439);
  }
  
  public d(e parame)
  {
    super(parame, c.hlR, "PredownloadCmdGetCodePersistentInfo2", c.INDEX_CREATE);
    this.jnc = parame;
  }
  
  public final List<c> c(String paramString, String... paramVarArgs)
  {
    AppMethodBeat.i(44438);
    paramString = this.jnc.query("PredownloadCmdGetCodePersistentInfo2", null, paramString, paramVarArgs, null, null, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.e.d
 * JD-Core Version:    0.7.0.1
 */