package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.d;
import com.tencent.mm.protocal.protobuf.bnh;
import com.tencent.mm.protocal.protobuf.gn;
import com.tencent.mm.protocal.protobuf.go;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.List;

public final class j
  implements m
{
  public final void e(List<go> paramList, List<gn> paramList1)
  {
    AppMethodBeat.i(129809);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = (go)localIterator.next();
        Object localObject2;
        if ((localObject1 != null) && (!bo.isNullOrNil(((go)localObject1).username)) && (paramList1 != null) && (!paramList1.isEmpty()))
        {
          localObject2 = paramList1.iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            paramList = (gn)((Iterator)localObject2).next();
          } while (!((go)localObject1).username.equalsIgnoreCase(paramList.username));
        }
        for (;;)
        {
          if ((((go)localObject1).csV == 0) && (paramList != null))
          {
            if ((paramList == null) || (localObject1 == null))
            {
              ab.w("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "handleBackgroundFetchData fail, request item or response item is null");
              break;
              paramList = null;
              continue;
            }
            if ((bo.isNullOrNil(((go)localObject1).username)) || (bo.isNullOrNil(((go)localObject1).data)))
            {
              ab.w("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "handleBackgroundFetchData fail, no username or data in response");
              break;
            }
            long l = bo.aoy();
            String str1 = ((go)localObject1).username;
            String str2 = ((go)localObject1).data;
            int j = paramList.wsT;
            if (paramList.wsU != null)
            {
              localObject1 = paramList.wsU.path;
              label230:
              if (paramList.wsU == null) {
                break label306;
              }
              localObject2 = paramList.wsU.query;
              label246:
              if (paramList.wsU == null) {
                break label312;
              }
            }
            label306:
            label312:
            for (int i = paramList.wsU.scene;; i = 1000)
            {
              if (((k)g.E(k.class)).a(str1, j, str2, (String)localObject1, (String)localObject2, i, l)) {
                break label319;
              }
              ab.e("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "handleBackgroundFetchData fail, save data fail");
              break;
              localObject1 = null;
              break label230;
              localObject2 = null;
              break label246;
            }
            label319:
            if (bo.isNullOrNil(paramList.cwc)) {
              break;
            }
            AppBrandBackgroundFetchDataParcel localAppBrandBackgroundFetchDataParcel = new AppBrandBackgroundFetchDataParcel();
            localAppBrandBackgroundFetchDataParcel.username = str1;
            localAppBrandBackgroundFetchDataParcel.hdX = j;
            localAppBrandBackgroundFetchDataParcel.data = str2;
            localAppBrandBackgroundFetchDataParcel.path = ((String)localObject1);
            localAppBrandBackgroundFetchDataParcel.query = ((String)localObject2);
            localAppBrandBackgroundFetchDataParcel.scene = i;
            localAppBrandBackgroundFetchDataParcel.updateTime = l;
            ab.i("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "handleBackgroundFetchData success, send data event to app(%s), appId:%s", new Object[] { paramList.username, paramList.cwc });
            d.a(paramList.cwc, localAppBrandBackgroundFetchDataParcel);
            break;
          }
        }
        ab.w("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "cgi success, but app(%s) failed to fetch data", new Object[] { ((go)localObject1).username });
      }
    }
    AppMethodBeat.o(129809);
  }
  
  public final void onFail(int paramInt)
  {
    AppMethodBeat.i(129810);
    ab.e("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "cgi fail, type(%d)", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(129810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.j
 * JD-Core Version:    0.7.0.1
 */