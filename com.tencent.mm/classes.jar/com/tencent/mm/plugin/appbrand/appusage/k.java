package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bo;

public final class k
  extends j<b>
{
  public static final String[] fkl;
  public final e gVl;
  
  static
  {
    AppMethodBeat.i(129556);
    fkl = new String[] { j.getCreateSQLs(b.fkk, "AppBrandAppLaunchUsernameDuplicateRecord") };
    AppMethodBeat.o(129556);
  }
  
  public k(e parame)
  {
    super(parame, b.fkk, "AppBrandAppLaunchUsernameDuplicateRecord", b.INDEX_CREATE);
    this.gVl = parame;
  }
  
  public final boolean E(String paramString, long paramLong)
  {
    AppMethodBeat.i(129555);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(129555);
      return false;
    }
    b localb = new b();
    localb.field_username = paramString;
    boolean bool = get(localb, new String[0]);
    localb.field_updateTime = paramLong;
    if (bool)
    {
      bool = update(localb, new String[0]);
      AppMethodBeat.o(129555);
      return bool;
    }
    bool = insert(localb);
    AppMethodBeat.o(129555);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.k
 * JD-Core Version:    0.7.0.1
 */