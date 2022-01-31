package com.tencent.mm.plugin.appbrand.backgroundfetch;

import android.database.Cursor;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.appusage.af.a;
import com.tencent.mm.plugin.appbrand.appusage.w;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class b$1
  implements Runnable
{
  public final void run()
  {
    Object localObject1 = ((af)com.tencent.mm.kernel.g.r(af.class)).a(2147483647, af.a.fJV);
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      y.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler.javayhu", "worker:peroidFetchDataWhenAppEnterForground, no star apps");
      return;
    }
    y.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler.javayhu", "worker:peroidFetchDataWhenAppEnterForground, star list size:%d", new Object[] { Integer.valueOf(((List)localObject1).size()) });
    HashMap localHashMap = new HashMap();
    localObject1 = ((List)localObject1).iterator();
    LocalUsageInfo localLocalUsageInfo;
    String str1;
    int j;
    Object localObject2;
    int i;
    while (((Iterator)localObject1).hasNext())
    {
      localLocalUsageInfo = (LocalUsageInfo)((Iterator)localObject1).next();
      if (!localHashMap.containsKey(localLocalUsageInfo.username))
      {
        str1 = localLocalUsageInfo.username;
        j = localLocalUsageInfo.fJy;
        localObject2 = r.sr(str1);
        if ((localObject2 != null) && (((a)localObject2).fKG)) {
          break label244;
        }
        y.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler.javayhu", "canPeriodFetchData, app(%s_v%d) can not period fetch data", new Object[] { str1, Integer.valueOf(j) });
        i = 0;
      }
    }
    label385:
    label402:
    label426:
    for (;;)
    {
      label180:
      if (i != 0)
      {
        localHashMap.put(localLocalUsageInfo.username, localLocalUsageInfo.appId);
        if (localHashMap.size() < 10) {
          break;
        }
        y.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler.javayhu", "worker:peroidFetchDataWhenAppEnterForground, batch list full");
        if (localHashMap.isEmpty()) {
          break label632;
        }
        b.a(localHashMap, new g());
        return;
        label244:
        if (!b.ay(str1, j))
        {
          y.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler.javayhu", "canPeriodFetchData, app(%s_v%d) is not star app", new Object[] { str1, Integer.valueOf(j) });
          i = 0;
        }
        else
        {
          i = ((a)localObject2).fKH;
          if (i >= 2)
          {
            l = ((h)com.tencent.mm.kernel.g.r(h.class)).aA(str1, 1);
            if (l <= 0L) {
              i = 1;
            }
          }
          for (;;)
          {
            if (i != 0) {
              break label385;
            }
            y.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler.javayhu", "canPeriodFetchData, app(%s_v%d) interval(%d) not ok", new Object[] { str1, Integer.valueOf(j), Integer.valueOf(((a)localObject2).fKH) });
            i = 0;
            break;
            if (bk.UY() - l >= i * 3600000L) {
              i = 1;
            } else {
              i = 0;
            }
          }
          localObject2 = e.aaZ();
          if (bk.bl(str1)) {
            l = -1L;
          }
          for (;;)
          {
            if ((l > 0L) && (bk.UY() - l * 1000L <= 604800000L))
            {
              i = 1;
              if (i != 0) {
                break label604;
              }
              y.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler.javayhu", "canPeriodFetchData, app(%s_v%d) recently not used", new Object[] { str1, Integer.valueOf(j) });
              i = 0;
              break;
              localObject2 = ((w)localObject2).fEC;
              String str2 = String.format(Locale.US, "%s=? and %s=? and %s=?", new Object[] { "brandId", "versionType", "scene" });
              String str3 = String.format(Locale.US, " %s desc ", new Object[] { "updateTime" });
              localObject2 = ((com.tencent.mm.cf.h)localObject2).query("AppBrandLauncherLayoutItem", new String[] { "updateTime" }, str2, new String[] { str1, String.valueOf(j), "2" }, null, null, str3);
              if (localObject2 == null) {
                l = -1L;
              } else {
                if (!((Cursor)localObject2).moveToFirst()) {
                  break label640;
                }
              }
            }
          }
        }
      }
    }
    label640:
    for (long l = ((Cursor)localObject2).getLong(0);; l = -1L)
    {
      ((Cursor)localObject2).close();
      break label402;
      i = 0;
      break label426;
      label604:
      y.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler.javayhu", "canPeriodFetchData, app(%s_v%d) can period fetch data", new Object[] { str1, Integer.valueOf(j) });
      i = 1;
      break label180;
      break;
      label632:
      y.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler.javayhu", "worker:peroidFetchDataWhenAppEnterForground, currently no app needs to update period data");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.b.1
 * JD-Core Version:    0.7.0.1
 */