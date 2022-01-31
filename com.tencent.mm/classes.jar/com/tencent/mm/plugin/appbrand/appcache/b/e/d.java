package com.tencent.mm.plugin.appbrand.appcache.b.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends com.tencent.mm.plugin.appbrand.r.c<c>
{
  public static final String[] fkl;
  private final e gVl;
  
  static
  {
    AppMethodBeat.i(129512);
    fkl = new String[] { j.getCreateSQLs(c.fkk, "PredownloadCmdGetCodePersistentInfo") };
    AppMethodBeat.o(129512);
  }
  
  public d(e parame)
  {
    super(parame, c.fkk, "PredownloadCmdGetCodePersistentInfo", c.INDEX_CREATE);
    this.gVl = parame;
  }
  
  public final List<c> c(String paramString, String... paramVarArgs)
  {
    AppMethodBeat.i(129511);
    paramString = this.gVl.query("PredownloadCmdGetCodePersistentInfo", null, paramString, paramVarArgs, null, null, null);
    if ((paramString == null) || (paramString.isClosed()))
    {
      paramString = Collections.emptyList();
      AppMethodBeat.o(129511);
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
    AppMethodBeat.o(129511);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.e.d
 * JD-Core Version:    0.7.0.1
 */