package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bs;

public final class k
  extends j<b>
{
  public static final String[] hlS;
  public final e jnc;
  
  static
  {
    AppMethodBeat.i(44488);
    hlS = new String[] { j.getCreateSQLs(b.hlR, "AppBrandAppLaunchUsernameDuplicateRecord2") };
    AppMethodBeat.o(44488);
  }
  
  public k(e parame)
  {
    super(parame, b.hlR, "AppBrandAppLaunchUsernameDuplicateRecord2", b.INDEX_CREATE);
    this.jnc = parame;
  }
  
  public final boolean I(String paramString, long paramLong)
  {
    AppMethodBeat.i(44487);
    if (bs.isNullOrNil(paramString))
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
  
  public final b Jm(String paramString)
  {
    AppMethodBeat.i(186339);
    b localb = new b();
    localb.field_usernameHash = paramString.hashCode();
    if ((!get(localb, new String[] { "usernameHash" })) || (localb.field_username == null) || (!localb.field_username.equals(paramString)))
    {
      AppMethodBeat.o(186339);
      return null;
    }
    AppMethodBeat.o(186339);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.k
 * JD-Core Version:    0.7.0.1
 */