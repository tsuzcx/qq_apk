package com.tencent.mm.plugin.appbrand.appcache.b.e;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bu;

public class b
  extends j<a>
{
  public static final String[] hGX;
  private final e jKa;
  
  static
  {
    AppMethodBeat.i(44436);
    hGX = new String[] { j.getCreateSQLs(a.hGW, "PredownloadBlockCgiRequest") };
    AppMethodBeat.o(44436);
  }
  
  public b(e parame)
  {
    super(parame, a.hGW, "PredownloadBlockCgiRequest", a.INDEX_CREATE);
    this.jKa = parame;
  }
  
  private Pair<Boolean, Integer> c(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    int i = -1;
    AppMethodBeat.i(44435);
    long l = bu.aRi();
    paramString1 = "select reportId from PredownloadBlockCgiRequest where " + paramString1 + "=? and startTime<" + l + " and " + l + "<endTime and cgiList like '%;" + paramInt1 + ";%' and sceneList like '%;" + paramInt2 + ";%'";
    paramString1 = this.jKa.rawQuery(paramString1, new String[] { paramString2 });
    if ((paramString1 == null) || (paramString1.isClosed()))
    {
      paramString1 = Pair.create(Boolean.FALSE, Integer.valueOf(-1));
      AppMethodBeat.o(44435);
      return paramString1;
    }
    boolean bool = paramString1.moveToFirst();
    paramInt1 = i;
    if (bool) {
      paramInt1 = paramString1.getInt(0);
    }
    paramString1.close();
    paramString1 = Pair.create(Boolean.valueOf(bool), Integer.valueOf(paramInt1));
    AppMethodBeat.o(44435);
    return paramString1;
  }
  
  public final Pair<Boolean, Integer> F(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44433);
    paramString = c("username", paramString, paramInt1, paramInt2);
    AppMethodBeat.o(44433);
    return paramString;
  }
  
  public final Pair<Boolean, Integer> G(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44434);
    paramString = c("appId", paramString, paramInt1, paramInt2);
    AppMethodBeat.o(44434);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.e.b
 * JD-Core Version:    0.7.0.1
 */