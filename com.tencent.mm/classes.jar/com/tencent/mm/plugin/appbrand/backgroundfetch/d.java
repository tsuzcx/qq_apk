package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;

public class d
  extends i<c>
{
  public static final String[] dUb = { i.a(c.fKL, "AppBrandBackgroundFetchData") };
  
  public d(e parame)
  {
    super(parame, c.fKL, "AppBrandBackgroundFetchData", null);
  }
  
  private AppBrandBackgroundFetchDataParcel az(String paramString, int paramInt)
  {
    if (bk.bl(paramString)) {}
    c localc;
    do
    {
      return null;
      localc = new c();
      localc.field_username = paramString;
      localc.field_fetchType = paramInt;
    } while (!super.b(localc, new String[] { "username", "fetchType" }));
    paramString = new AppBrandBackgroundFetchDataParcel();
    paramString.username = localc.field_username;
    paramString.fKK = localc.field_fetchType;
    paramString.path = localc.field_path;
    paramString.bVk = localc.field_query;
    paramString.data = localc.field_data;
    paramString.scene = localc.field_scene;
    paramString.updateTime = localc.field_updateTime;
    return paramString;
  }
  
  public final boolean a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, long paramLong)
  {
    if (bk.bl(paramString1)) {
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
    if (!bk.bl(paramString1))
    {
      paramString2 = new c();
      paramString2.field_username = paramString1;
      paramString2.field_fetchType = paramInt1;
      if (!super.b(paramString2, new String[] { "username", "fetchType" })) {}
    }
    for (paramString1 = paramString2; paramString1 == null; paramString1 = null) {
      return super.b(localc);
    }
    return super.c(localc, new String[] { "username", "fetchType" });
  }
  
  public final long aA(String paramString, int paramInt)
  {
    paramString = az(paramString, paramInt);
    if (paramString != null) {
      return paramString.updateTime;
    }
    return 0L;
  }
  
  public final AppBrandBackgroundFetchDataParcel aB(String paramString, int paramInt)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    return az(r.sx(paramString), paramInt);
  }
  
  public final boolean ag(String paramString, int paramInt)
  {
    if (bk.bl(paramString)) {
      return true;
    }
    c localc = new c();
    localc.field_username = paramString;
    localc.field_fetchType = paramInt;
    return super.a(localc, new String[] { "username", "fetchType" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.d
 * JD-Core Version:    0.7.0.1
 */