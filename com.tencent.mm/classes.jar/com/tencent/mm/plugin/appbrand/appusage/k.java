package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bt;

public final class k
  extends j<b>
{
  public static final String[] gLs;
  public final e iMV;
  
  static
  {
    AppMethodBeat.i(44488);
    gLs = new String[] { j.getCreateSQLs(b.gLr, "AppBrandAppLaunchUsernameDuplicateRecord2") };
    AppMethodBeat.o(44488);
  }
  
  public k(e parame)
  {
    super(parame, b.gLr, "AppBrandAppLaunchUsernameDuplicateRecord2", b.INDEX_CREATE);
    this.iMV = parame;
  }
  
  public final boolean H(String paramString, long paramLong)
  {
    AppMethodBeat.i(44487);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44487);
      return false;
    }
    b localb = new b();
    localb.field_usernameHash = paramString.hashCode();
    localb.field_username = paramString;
    boolean bool = get(localb, new String[0]);
    localb.field_updateTime = paramLong;
    if (bool)
    {
      bool = update(localb, new String[0]);
      AppMethodBeat.o(44487);
      return bool;
    }
    bool = insert(localb);
    AppMethodBeat.o(44487);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.k
 * JD-Core Version:    0.7.0.1
 */