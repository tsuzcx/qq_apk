package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bs;

public class g
  extends j<f>
{
  public static final String[] hlS;
  
  static
  {
    AppMethodBeat.i(44743);
    hlS = new String[] { j.getCreateSQLs(f.hlR, "AppBrandBackgroundFetchDataToken") };
    AppMethodBeat.o(44743);
  }
  
  public g(e parame)
  {
    super(parame, f.hlR, "AppBrandBackgroundFetchDataToken", null);
  }
  
  public final AppBrandBackgroundFetchDataTokenParcel Jq(String paramString)
  {
    AppMethodBeat.i(44741);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44741);
      return null;
    }
    f localf = new f();
    localf.field_username = paramString;
    if (super.get(localf, new String[] { "username" }))
    {
      paramString = new AppBrandBackgroundFetchDataTokenParcel();
      paramString.username = localf.field_username;
      paramString.token = localf.field_token;
      AppMethodBeat.o(44741);
      return paramString;
    }
    AppMethodBeat.o(44741);
    return null;
  }
  
  public final boolean cv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(44740);
    if ((bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(44740);
      return true;
    }
    f localf = new f();
    localf.field_username = paramString1;
    localf.field_token = paramString2;
    if (!bs.isNullOrNil(paramString1))
    {
      paramString2 = new f();
      paramString2.field_username = paramString1;
      if (!super.get(paramString2, new String[] { "username" })) {}
    }
    for (paramString1 = paramString2; paramString1 == null; paramString1 = null)
    {
      bool = super.insert(localf);
      AppMethodBeat.o(44740);
      return bool;
    }
    boolean bool = super.update(localf, new String[] { "username" });
    AppMethodBeat.o(44740);
    return bool;
  }
  
  public final boolean zB(String paramString)
  {
    AppMethodBeat.i(44742);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44742);
      return true;
    }
    f localf = new f();
    localf.field_username = paramString;
    boolean bool = super.delete(localf, new String[] { "username" });
    AppMethodBeat.o(44742);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.g
 * JD-Core Version:    0.7.0.1
 */