package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.appbrand.ipc.e;
import com.tencent.mm.protocal.protobuf.cmk;
import com.tencent.mm.protocal.protobuf.hv;
import com.tencent.mm.protocal.protobuf.hw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
        if ((localObject1 != null) && (!bu.isNullOrNil(((hw)localObject1).username)) && (paramList1 != null) && (!paramList1.isEmpty()))
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
          if ((((hw)localObject1).drN == 0) && (paramList != null))
          {
            if ((paramList == null) || (localObject1 == null))
            {
              ae.w("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "handleBackgroundFetchData fail, request item or response item is null");
              break;
              paramList = null;
              continue;
            }
            if ((bu.isNullOrNil(((hw)localObject1).username)) || (bu.isNullOrNil(((hw)localObject1).data)))
            {
              ae.w("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "handleBackgroundFetchData fail, no username or data in response");
              break;
            }
            long l = ch.aDb();
            String str1 = ((hw)localObject1).username;
            String str2 = ((hw)localObject1).data;
            int j = paramList.FSN;
            if (paramList.FSO != null)
            {
              localObject1 = paramList.FSO.path;
              label230:
              if (paramList.FSO == null) {
                break label306;
              }
              localObject2 = paramList.FSO.query;
              label246:
              if (paramList.FSO == null) {
                break label312;
              }
            }
            label306:
            label312:
            for (int i = paramList.FSO.scene;; i = 1000)
            {
              if (((k)g.ab(k.class)).a(str1, j, str2, (String)localObject1, (String)localObject2, i, l)) {
                break label319;
              }
              ae.e("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "handleBackgroundFetchData fail, save data fail");
              break;
              localObject1 = null;
              break label230;
              localObject2 = null;
              break label246;
            }
            label319:
            if (bu.isNullOrNil(paramList.dwb)) {
              break;
            }
            AppBrandBackgroundFetchDataParcel localAppBrandBackgroundFetchDataParcel = new AppBrandBackgroundFetchDataParcel();
            localAppBrandBackgroundFetchDataParcel.username = str1;
            localAppBrandBackgroundFetchDataParcel.jUT = j;
            localAppBrandBackgroundFetchDataParcel.data = str2;
            localAppBrandBackgroundFetchDataParcel.path = ((String)localObject1);
            localAppBrandBackgroundFetchDataParcel.query = ((String)localObject2);
            localAppBrandBackgroundFetchDataParcel.scene = i;
            localAppBrandBackgroundFetchDataParcel.fOl = l;
            ae.i("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "handleBackgroundFetchData success, send data event to app(%s), appId:%s", new Object[] { paramList.username, paramList.dwb });
            e.b(paramList.dwb, localAppBrandBackgroundFetchDataParcel);
            break;
          }
        }
        ae.w("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "cgi success, but app(%s) failed to fetch data", new Object[] { ((hw)localObject1).username });
      }
    }
    AppMethodBeat.o(44760);
  }
  
  public final void onFail(int paramInt)
  {
    AppMethodBeat.i(44761);
    ae.e("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "cgi fail, type(%d)", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(44761);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.j
 * JD-Core Version:    0.7.0.1
 */