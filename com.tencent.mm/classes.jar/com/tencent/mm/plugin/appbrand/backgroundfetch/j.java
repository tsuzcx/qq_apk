package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.appbrand.ipc.f;
import com.tencent.mm.protocal.protobuf.egc;
import com.tencent.mm.protocal.protobuf.it;
import com.tencent.mm.protocal.protobuf.iu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;

public final class j
  implements m
{
  public final void m(List<iu> paramList, List<it> paramList1)
  {
    AppMethodBeat.i(44760);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = (iu)localIterator.next();
        Object localObject2;
        if ((localObject1 != null) && (!Util.isNullOrNil(((iu)localObject1).username)) && (paramList1 != null) && (!paramList1.isEmpty()))
        {
          localObject2 = paramList1.iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            paramList = (it)((Iterator)localObject2).next();
          } while (!((iu)localObject1).username.equalsIgnoreCase(paramList.username));
        }
        for (;;)
        {
          if ((((iu)localObject1).hGE == 0) && (paramList != null))
          {
            if ((paramList == null) || (localObject1 == null))
            {
              Log.w("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "handleBackgroundFetchData fail, request item or response item is null");
              break;
              paramList = null;
              continue;
            }
            if ((Util.isNullOrNil(((iu)localObject1).username)) || (Util.isNullOrNil(((iu)localObject1).data)))
            {
              Log.w("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "handleBackgroundFetchData fail, no username or data in response");
              break;
            }
            long l = cn.bDv();
            String str1 = ((iu)localObject1).username;
            String str2 = ((iu)localObject1).data;
            int j = paramList.YKE;
            if (paramList.YKF != null)
            {
              localObject1 = paramList.YKF.path;
              label230:
              if (paramList.YKF == null) {
                break label306;
              }
              localObject2 = paramList.YKF.query;
              label246:
              if (paramList.YKF == null) {
                break label312;
              }
            }
            label306:
            label312:
            for (int i = paramList.YKF.scene;; i = 1000)
            {
              if (((k)h.ax(k.class)).a(str1, j, str2, (String)localObject1, (String)localObject2, i, l)) {
                break label319;
              }
              Log.e("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "handleBackgroundFetchData fail, save data fail");
              break;
              localObject1 = null;
              break label230;
              localObject2 = null;
              break label246;
            }
            label319:
            if (Util.isNullOrNil(paramList.appid)) {
              break;
            }
            AppBrandBackgroundFetchDataParcel localAppBrandBackgroundFetchDataParcel = new AppBrandBackgroundFetchDataParcel();
            localAppBrandBackgroundFetchDataParcel.username = str1;
            localAppBrandBackgroundFetchDataParcel.qRL = j;
            localAppBrandBackgroundFetchDataParcel.data = str2;
            localAppBrandBackgroundFetchDataParcel.path = ((String)localObject1);
            localAppBrandBackgroundFetchDataParcel.query = ((String)localObject2);
            localAppBrandBackgroundFetchDataParcel.scene = i;
            localAppBrandBackgroundFetchDataParcel.egK = l;
            Log.i("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "handleBackgroundFetchData success, send data event to app(%s), appId:%s", new Object[] { paramList.username, paramList.appid });
            f.b(paramList.appid, localAppBrandBackgroundFetchDataParcel);
            break;
          }
        }
        Log.w("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "cgi success, but app(%s) failed to fetch data", new Object[] { ((iu)localObject1).username });
      }
    }
    AppMethodBeat.o(44760);
  }
  
  public final void onFail(int paramInt)
  {
    AppMethodBeat.i(44761);
    Log.e("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "cgi fail, type(%d)", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(44761);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.j
 * JD-Core Version:    0.7.0.1
 */