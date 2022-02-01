package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.appbrand.ipc.e;
import com.tencent.mm.protocal.protobuf.cgr;
import com.tencent.mm.protocal.protobuf.ho;
import com.tencent.mm.protocal.protobuf.hp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.List;

public final class j
  implements m
{
  public final void f(List<hp> paramList, List<ho> paramList1)
  {
    AppMethodBeat.i(44760);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = (hp)localIterator.next();
        Object localObject2;
        if ((localObject1 != null) && (!bs.isNullOrNil(((hp)localObject1).username)) && (paramList1 != null) && (!paramList1.isEmpty()))
        {
          localObject2 = paramList1.iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            paramList = (ho)((Iterator)localObject2).next();
          } while (!((hp)localObject1).username.equalsIgnoreCase(paramList.username));
        }
        for (;;)
        {
          if ((((hp)localObject1).dfm == 0) && (paramList != null))
          {
            if ((paramList == null) || (localObject1 == null))
            {
              ac.w("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "handleBackgroundFetchData fail, request item or response item is null");
              break;
              paramList = null;
              continue;
            }
            if ((bs.isNullOrNil(((hp)localObject1).username)) || (bs.isNullOrNil(((hp)localObject1).data)))
            {
              ac.w("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "handleBackgroundFetchData fail, no username or data in response");
              break;
            }
            long l = ce.azI();
            String str1 = ((hp)localObject1).username;
            String str2 = ((hp)localObject1).data;
            int j = paramList.DUV;
            if (paramList.DUW != null)
            {
              localObject1 = paramList.DUW.path;
              label230:
              if (paramList.DUW == null) {
                break label306;
              }
              localObject2 = paramList.DUW.query;
              label246:
              if (paramList.DUW == null) {
                break label312;
              }
            }
            label306:
            label312:
            for (int i = paramList.DUW.scene;; i = 1000)
            {
              if (((k)g.ab(k.class)).a(str1, j, str2, (String)localObject1, (String)localObject2, i, l)) {
                break label319;
              }
              ac.e("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "handleBackgroundFetchData fail, save data fail");
              break;
              localObject1 = null;
              break label230;
              localObject2 = null;
              break label246;
            }
            label319:
            if (bs.isNullOrNil(paramList.djj)) {
              break;
            }
            AppBrandBackgroundFetchDataParcel localAppBrandBackgroundFetchDataParcel = new AppBrandBackgroundFetchDataParcel();
            localAppBrandBackgroundFetchDataParcel.username = str1;
            localAppBrandBackgroundFetchDataParcel.jxF = j;
            localAppBrandBackgroundFetchDataParcel.data = str2;
            localAppBrandBackgroundFetchDataParcel.path = ((String)localObject1);
            localAppBrandBackgroundFetchDataParcel.query = ((String)localObject2);
            localAppBrandBackgroundFetchDataParcel.scene = i;
            localAppBrandBackgroundFetchDataParcel.fto = l;
            ac.i("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "handleBackgroundFetchData success, send data event to app(%s), appId:%s", new Object[] { paramList.username, paramList.djj });
            e.b(paramList.djj, localAppBrandBackgroundFetchDataParcel);
            break;
          }
        }
        ac.w("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "cgi success, but app(%s) failed to fetch data", new Object[] { ((hp)localObject1).username });
      }
    }
    AppMethodBeat.o(44760);
  }
  
  public final void onFail(int paramInt)
  {
    AppMethodBeat.i(44761);
    ac.e("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "cgi fail, type(%d)", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(44761);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.j
 * JD-Core Version:    0.7.0.1
 */