package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.appbrand.ipc.e;
import com.tencent.mm.protocal.protobuf.clq;
import com.tencent.mm.protocal.protobuf.hv;
import com.tencent.mm.protocal.protobuf.hw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.List;

public final class j
  implements m
{
  public final void f(List<hw> paramList, List<hv> paramList1)
  {
    AppMethodBeat.i(44760);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = (hw)localIterator.next();
        Object localObject2;
        if ((localObject1 != null) && (!bt.isNullOrNil(((hw)localObject1).username)) && (paramList1 != null) && (!paramList1.isEmpty()))
        {
          localObject2 = paramList1.iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            paramList = (hv)((Iterator)localObject2).next();
          } while (!((hw)localObject1).username.equalsIgnoreCase(paramList.username));
        }
        for (;;)
        {
          if ((((hw)localObject1).dqI == 0) && (paramList != null))
          {
            if ((paramList == null) || (localObject1 == null))
            {
              ad.w("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "handleBackgroundFetchData fail, request item or response item is null");
              break;
              paramList = null;
              continue;
            }
            if ((bt.isNullOrNil(((hw)localObject1).username)) || (bt.isNullOrNil(((hw)localObject1).data)))
            {
              ad.w("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "handleBackgroundFetchData fail, no username or data in response");
              break;
            }
            long l = cf.aCL();
            String str1 = ((hw)localObject1).username;
            String str2 = ((hw)localObject1).data;
            int j = paramList.FAq;
            if (paramList.FAr != null)
            {
              localObject1 = paramList.FAr.path;
              label230:
              if (paramList.FAr == null) {
                break label306;
              }
              localObject2 = paramList.FAr.query;
              label246:
              if (paramList.FAr == null) {
                break label312;
              }
            }
            label306:
            label312:
            for (int i = paramList.FAr.scene;; i = 1000)
            {
              if (((k)g.ab(k.class)).a(str1, j, str2, (String)localObject1, (String)localObject2, i, l)) {
                break label319;
              }
              ad.e("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "handleBackgroundFetchData fail, save data fail");
              break;
              localObject1 = null;
              break label230;
              localObject2 = null;
              break label246;
            }
            label319:
            if (bt.isNullOrNil(paramList.duW)) {
              break;
            }
            AppBrandBackgroundFetchDataParcel localAppBrandBackgroundFetchDataParcel = new AppBrandBackgroundFetchDataParcel();
            localAppBrandBackgroundFetchDataParcel.username = str1;
            localAppBrandBackgroundFetchDataParcel.jRB = j;
            localAppBrandBackgroundFetchDataParcel.data = str2;
            localAppBrandBackgroundFetchDataParcel.path = ((String)localObject1);
            localAppBrandBackgroundFetchDataParcel.query = ((String)localObject2);
            localAppBrandBackgroundFetchDataParcel.scene = i;
            localAppBrandBackgroundFetchDataParcel.fMf = l;
            ad.i("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "handleBackgroundFetchData success, send data event to app(%s), appId:%s", new Object[] { paramList.username, paramList.duW });
            e.b(paramList.duW, localAppBrandBackgroundFetchDataParcel);
            break;
          }
        }
        ad.w("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "cgi success, but app(%s) failed to fetch data", new Object[] { ((hw)localObject1).username });
      }
    }
    AppMethodBeat.o(44760);
  }
  
  public final void onFail(int paramInt)
  {
    AppMethodBeat.i(44761);
    ad.e("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "cgi fail, type(%d)", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(44761);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.j
 * JD-Core Version:    0.7.0.1
 */