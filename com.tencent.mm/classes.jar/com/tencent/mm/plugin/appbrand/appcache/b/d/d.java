package com.tencent.mm.plugin.appbrand.appcache.b.d;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends com.tencent.mm.plugin.appbrand.t.c<c>
{
  public static final String[] dUb = { i.a(c.dUa, "PredownloadCmdGetCodePersistentInfo") };
  private final e fCV;
  
  public d(e parame)
  {
    super(parame, c.dUa, "PredownloadCmdGetCodePersistentInfo", c.cqY);
    this.fCV = parame;
  }
  
  public final List<c> c(String paramString, String... paramVarArgs)
  {
    paramString = this.fCV.query("PredownloadCmdGetCodePersistentInfo", null, paramString, paramVarArgs, null, null, null);
    if ((paramString == null) || (paramString.isClosed())) {
      return Collections.emptyList();
    }
    paramVarArgs = new LinkedList();
    if (paramString.moveToFirst()) {
      do
      {
        c localc = new c();
        localc.d(paramString);
        paramVarArgs.add(localc);
      } while (paramString.moveToNext());
    }
    paramString.close();
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.d.d
 * JD-Core Version:    0.7.0.1
 */