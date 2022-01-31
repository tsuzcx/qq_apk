package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bo;

public class g
  extends j<f>
{
  public static final String[] fkl;
  
  static
  {
    AppMethodBeat.i(143072);
    fkl = new String[] { j.getCreateSQLs(f.fkk, "AppBrandBackgroundFetchDataToken") };
    AppMethodBeat.o(143072);
  }
  
  public g(e parame)
  {
    super(parame, f.fkk, "AppBrandBackgroundFetchDataToken", null);
  }
  
  public final boolean bG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(143069);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(143069);
      return true;
    }
    f localf = new f();
    localf.field_username = paramString1;
    localf.field_token = paramString2;
    if (!bo.isNullOrNil(paramString1))
    {
      paramString2 = new f();
      paramString2.field_username = paramString1;
      if (!super.get(paramString2, new String[] { "username" })) {}
    }
    for (paramString1 = paramString2; paramString1 == null; paramString1 = null)
    {
      bool = super.insert(localf);
      AppMethodBeat.o(143069);
      return bool;
    }
    boolean bool = super.update(localf, new String[] { "username", "token" });
    AppMethodBeat.o(143069);
    return bool;
  }
  
  public final boolean qD(String paramString)
  {
    AppMethodBeat.i(143071);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(143071);
      return true;
    }
    f localf = new f();
    localf.field_username = paramString;
    boolean bool = super.delete(localf, new String[] { "username" });
    AppMethodBeat.o(143071);
    return bool;
  }
  
  public final AppBrandBackgroundFetchDataTokenParcel zz(String paramString)
  {
    AppMethodBeat.i(143070);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(143070);
      return null;
    }
    f localf = new f();
    localf.field_username = paramString;
    if (super.get(localf, new String[] { "username" }))
    {
      paramString = new AppBrandBackgroundFetchDataTokenParcel();
      paramString.username = localf.field_username;
      paramString.token = localf.field_token;
      AppMethodBeat.o(143070);
      return paramString;
    }
    AppMethodBeat.o(143070);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.g
 * JD-Core Version:    0.7.0.1
 */