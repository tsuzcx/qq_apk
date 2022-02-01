package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bt;

public class d
  extends j<c>
{
  public static final String[] hEf;
  
  static
  {
    AppMethodBeat.i(44709);
    hEf = new String[] { j.getCreateSQLs(c.jRC, "AppBrandBackgroundFetchData") };
    AppMethodBeat.o(44709);
  }
  
  public d(e parame)
  {
    super(parame, c.jRC, "AppBrandBackgroundFetchData", null);
  }
  
  private AppBrandBackgroundFetchDataParcel bl(String paramString, int paramInt)
  {
    AppMethodBeat.i(44706);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44706);
      return null;
    }
    c localc = new c();
    localc.field_username = paramString;
    localc.field_fetchType = paramInt;
    if (super.get(localc, new String[] { "username", "fetchType" }))
    {
      paramString = new AppBrandBackgroundFetchDataParcel();
      paramString.username = localc.field_username;
      paramString.jRB = localc.field_fetchType;
      paramString.path = localc.field_path;
      paramString.query = localc.field_query;
      paramString.data = localc.field_data;
      paramString.scene = localc.field_scene;
      paramString.fMf = localc.field_updateTime;
      AppMethodBeat.o(44706);
      return paramString;
    }
    AppMethodBeat.o(44706);
    return null;
  }
  
  public final boolean a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(44705);
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(44705);
      return true;
    }
    c localc = new c();
    localc.field_username = paramString1;
    localc.field_fetchType = paramInt1;
    localc.field_data = paramString2;
    localc.field_path = paramString3;
    localc.field_query = paramString4;
    localc.field_scene = paramInt2;
    localc.field_updateTime = paramLong;
    if (!bt.isNullOrNil(paramString1))
    {
      paramString2 = new c();
      paramString2.field_username = paramString1;
      paramString2.field_fetchType = paramInt1;
      if (!super.get(paramString2, new String[] { "username", "fetchType" })) {}
    }
    for (paramString1 = paramString2; paramString1 == null; paramString1 = null)
    {
      bool = super.insert(localc);
      AppMethodBeat.o(44705);
      return bool;
    }
    boolean bool = super.update(localc, new String[] { "username", "fetchType" });
    AppMethodBeat.o(44705);
    return bool;
  }
  
  public final long bm(String paramString, int paramInt)
  {
    AppMethodBeat.i(44707);
    paramString = bl(paramString, paramInt);
    if (paramString != null)
    {
      long l = paramString.fMf;
      AppMethodBeat.o(44707);
      return l;
    }
    AppMethodBeat.o(44707);
    return 0L;
  }
  
  public final AppBrandBackgroundFetchDataParcel bn(String paramString, int paramInt)
  {
    AppMethodBeat.i(44708);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44708);
      return null;
    }
    paramString = bl(v.NG(paramString), paramInt);
    AppMethodBeat.o(44708);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.d
 * JD-Core Version:    0.7.0.1
 */