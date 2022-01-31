package com.tencent.mm.plugin.appbrand.appcache.b.d;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;

public class b
  extends i<a>
{
  public static final String[] dUb = { i.a(a.dUa, "PredownloadBlockCgiRequest") };
  private final e fCV;
  
  public b(e parame)
  {
    super(parame, a.dUa, "PredownloadBlockCgiRequest", a.cqY);
    this.fCV = parame;
  }
  
  private Pair<Boolean, Integer> c(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    int i = -1;
    long l = bk.UX();
    paramString1 = "select reportId from PredownloadBlockCgiRequest where " + paramString1 + "=? and startTime<" + l + " and " + l + "<endTime and cgiList like '%;" + paramInt1 + ";%' and sceneList like '%;" + paramInt2 + ";%'";
    paramString1 = this.fCV.rawQuery(paramString1, new String[] { paramString2 });
    if ((paramString1 == null) || (paramString1.isClosed())) {
      return Pair.create(Boolean.valueOf(false), Integer.valueOf(-1));
    }
    boolean bool = paramString1.moveToFirst();
    paramInt1 = i;
    if (bool) {
      paramInt1 = paramString1.getInt(0);
    }
    paramString1.close();
    return Pair.create(Boolean.valueOf(bool), Integer.valueOf(paramInt1));
  }
  
  public final Pair<Boolean, Integer> v(String paramString, int paramInt1, int paramInt2)
  {
    return c("username", paramString, paramInt1, paramInt2);
  }
  
  public final Pair<Boolean, Integer> w(String paramString, int paramInt1, int paramInt2)
  {
    return c("appId", paramString, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.d.b
 * JD-Core Version:    0.7.0.1
 */