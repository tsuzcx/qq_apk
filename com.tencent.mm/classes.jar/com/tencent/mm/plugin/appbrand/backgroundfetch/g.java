package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.mm.plugin.appbrand.ipc.d;
import com.tencent.mm.protocal.c.bfh;
import com.tencent.mm.protocal.c.fe;
import com.tencent.mm.protocal.c.ff;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

public final class g
  implements i
{
  public final void e(List<ff> paramList, List<fe> paramList1)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = (ff)localIterator.next();
        Object localObject2;
        if ((localObject1 != null) && (!bk.bl(((ff)localObject1).username)) && (paramList1 != null) && (!paramList1.isEmpty()))
        {
          localObject2 = paramList1.iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            paramList = (fe)((Iterator)localObject2).next();
          } while (!((ff)localObject1).username.equalsIgnoreCase(paramList.username));
        }
        for (;;)
        {
          if ((((ff)localObject1).bLB == 0) && (paramList != null))
          {
            if ((paramList == null) || (localObject1 == null))
            {
              y.w("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback.javayhu", "handleBackgroundFetchData fail, request item or response item is null");
              break;
              paramList = null;
              continue;
            }
            if ((bk.bl(((ff)localObject1).username)) || (bk.bl(((ff)localObject1).data)))
            {
              y.w("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback.javayhu", "handleBackgroundFetchData fail, no username or data in response");
              break;
            }
            long l = bk.UY();
            String str1 = ((ff)localObject1).username;
            String str2 = ((ff)localObject1).data;
            int j = paramList.syS;
            if (paramList.syT != null)
            {
              localObject1 = paramList.syT.path;
              label225:
              if (paramList.syT == null) {
                break label301;
              }
              localObject2 = paramList.syT.bVk;
              label241:
              if (paramList.syT == null) {
                break label307;
              }
            }
            label301:
            label307:
            for (int i = paramList.syT.scene;; i = 1000)
            {
              if (((h)com.tencent.mm.kernel.g.r(h.class)).a(str1, j, str2, (String)localObject1, (String)localObject2, i, l)) {
                break label314;
              }
              y.e("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback.javayhu", "handleBackgroundFetchData fail, save data fail");
              break;
              localObject1 = null;
              break label225;
              localObject2 = null;
              break label241;
            }
            label314:
            if (bk.bl(paramList.bOL)) {
              break;
            }
            AppBrandBackgroundFetchDataParcel localAppBrandBackgroundFetchDataParcel = new AppBrandBackgroundFetchDataParcel();
            localAppBrandBackgroundFetchDataParcel.username = str1;
            localAppBrandBackgroundFetchDataParcel.fKK = j;
            localAppBrandBackgroundFetchDataParcel.data = str2;
            localAppBrandBackgroundFetchDataParcel.path = ((String)localObject1);
            localAppBrandBackgroundFetchDataParcel.bVk = ((String)localObject2);
            localAppBrandBackgroundFetchDataParcel.scene = i;
            localAppBrandBackgroundFetchDataParcel.updateTime = l;
            y.i("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback.javayhu", "handleBackgroundFetchData success, send data event to app(%s), appId:%s", new Object[] { paramList.username, paramList.bOL });
            d.a(paramList.bOL, localAppBrandBackgroundFetchDataParcel);
            break;
          }
        }
        y.w("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback.javayhu", "cgi success, but app(%s) failed to fetch data", new Object[] { ((ff)localObject1).username });
      }
    }
  }
  
  public final void onFail(int paramInt)
  {
    y.e("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback.javayhu", "cgi fail, type(%d)", new Object[] { Integer.valueOf(paramInt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.g
 * JD-Core Version:    0.7.0.1
 */