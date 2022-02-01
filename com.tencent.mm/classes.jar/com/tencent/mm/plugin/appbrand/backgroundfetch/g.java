package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public class g
  extends MAutoStorage<f>
{
  public static final String[] lqL;
  
  static
  {
    AppMethodBeat.i(44743);
    lqL = new String[] { MAutoStorage.getCreateSQLs(f.lqK, "AppBrandBackgroundFetchDataToken") };
    AppMethodBeat.o(44743);
  }
  
  public g(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, f.lqK, "AppBrandBackgroundFetchDataToken", null);
  }
  
  public final AppBrandBackgroundFetchDataTokenParcel aek(String paramString)
  {
    AppMethodBeat.i(44741);
    if (Util.isNullOrNil(paramString))
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
  
  public final boolean cW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(44740);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(44740);
      return true;
    }
    f localf = new f();
    localf.field_username = paramString1;
    localf.field_token = paramString2;
    if (!Util.isNullOrNil(paramString1))
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
  
  public final boolean ho(String paramString)
  {
    AppMethodBeat.i(44742);
    if (Util.isNullOrNil(paramString))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.g
 * JD-Core Version:    0.7.0.1
 */