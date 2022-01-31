package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bo;

public class d
  extends j<c>
{
  public static final String[] fkl;
  
  static
  {
    AppMethodBeat.i(129776);
    fkl = new String[] { j.getCreateSQLs(c.hdY, "AppBrandBackgroundFetchData") };
    AppMethodBeat.o(129776);
  }
  
  public d(e parame)
  {
    super(parame, c.hdY, "AppBrandBackgroundFetchData", null);
  }
  
  private AppBrandBackgroundFetchDataParcel aP(String paramString, int paramInt)
  {
    AppMethodBeat.i(129772);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(129772);
      return null;
    }
    c localc = new c();
    localc.field_username = paramString;
    localc.field_fetchType = paramInt;
    if (super.get(localc, new String[] { "username", "fetchType" }))
    {
      paramString = new AppBrandBackgroundFetchDataParcel();
      paramString.username = localc.field_username;
      paramString.hdX = localc.field_fetchType;
      paramString.path = localc.field_path;
      paramString.query = localc.field_query;
      paramString.data = localc.field_data;
      paramString.scene = localc.field_scene;
      paramString.updateTime = localc.field_updateTime;
      AppMethodBeat.o(129772);
      return paramString;
    }
    AppMethodBeat.o(129772);
    return null;
  }
  
  public final boolean a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(129771);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(129771);
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
    if (!bo.isNullOrNil(paramString1))
    {
      paramString2 = new c();
      paramString2.field_username = paramString1;
      paramString2.field_fetchType = paramInt1;
      if (!super.get(paramString2, new String[] { "username", "fetchType" })) {}
    }
    for (paramString1 = paramString2; paramString1 == null; paramString1 = null)
    {
      bool = super.insert(localc);
      AppMethodBeat.o(129771);
      return bool;
    }
    boolean bool = super.update(localc, new String[] { "username", "fetchType" });
    AppMethodBeat.o(129771);
    return bool;
  }
  
  public final long aQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(129774);
    paramString = aP(paramString, paramInt);
    if (paramString != null)
    {
      long l = paramString.updateTime;
      AppMethodBeat.o(129774);
      return l;
    }
    AppMethodBeat.o(129774);
    return 0L;
  }
  
  public final AppBrandBackgroundFetchDataParcel aR(String paramString, int paramInt)
  {
    AppMethodBeat.i(129775);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(129775);
      return null;
    }
    paramString = aP(q.As(paramString), paramInt);
    AppMethodBeat.o(129775);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.d
 * JD-Core Version:    0.7.0.1
 */