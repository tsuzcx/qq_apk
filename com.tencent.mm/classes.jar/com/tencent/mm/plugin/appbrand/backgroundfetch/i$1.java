package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

final class i$1
  implements MMToClientEvent.c
{
  i$1(String paramString) {}
  
  public final void aZ(Object paramObject)
  {
    AppMethodBeat.i(129806);
    String str1;
    Object localObject;
    String str2;
    int i;
    HashMap localHashMap;
    if ((paramObject instanceof AppBrandBackgroundFetchDataParcel))
    {
      ab.i("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "app received data, appId:%s", new Object[] { this.val$appId });
      str1 = this.val$appId;
      localObject = (AppBrandBackgroundFetchDataParcel)paramObject;
      if ((localObject == null) || (bo.isNullOrNil(str1)))
      {
        ab.w("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "dispatch, parcel is null or appid is null");
        AppMethodBeat.o(129806);
        return;
      }
      str2 = ((AppBrandBackgroundFetchDataParcel)localObject).username;
      i = ((AppBrandBackgroundFetchDataParcel)localObject).hdX;
      paramObject = ((AppBrandBackgroundFetchDataParcel)localObject).data;
      String str3 = ((AppBrandBackgroundFetchDataParcel)localObject).path;
      String str4 = ((AppBrandBackgroundFetchDataParcel)localObject).query;
      int j = ((AppBrandBackgroundFetchDataParcel)localObject).scene;
      long l = ((AppBrandBackgroundFetchDataParcel)localObject).updateTime;
      if ((bo.isNullOrNil(str2)) || (bo.isNullOrNil(paramObject)))
      {
        ab.w("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "username or data is null");
        AppMethodBeat.o(129806);
        return;
      }
      localObject = a.xL(str1);
      if ((localObject == null) || (!((com.tencent.mm.plugin.appbrand.i)localObject).mInitialized))
      {
        ab.w("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "app(%s) runtime is null or not initialized, appId:%s", new Object[] { str2, str1 });
        AppMethodBeat.o(129806);
        return;
      }
      localObject = ((com.tencent.mm.plugin.appbrand.i)localObject).ws();
      if ((localObject == null) || (((r)localObject).asW() == b.gYh))
      {
        ab.w("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "app(%s) service is null or has destroyed, appId:%s", new Object[] { str2, str1 });
        AppMethodBeat.o(129806);
        return;
      }
      localHashMap = new HashMap();
      localHashMap.put("timeStamp", Long.valueOf(l));
      localHashMap.put("path", str3);
      localHashMap.put("query", str4);
      localHashMap.put("scene", Integer.valueOf(j));
      localHashMap.put("fetchedData", paramObject);
      if (i != 0) {
        break label372;
      }
    }
    label372:
    for (paramObject = "pre";; paramObject = "peroid")
    {
      localHashMap.put("fetchType", paramObject);
      ab.i("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "AppBrandOnBackgroundFetchDataEvent dispatch to app(%s), appId:%s, fetch type:%d", new Object[] { str2, str1, Integer.valueOf(i) });
      new i().w(localHashMap).i((c)localObject).aBz();
      AppMethodBeat.o(129806);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.i.1
 * JD-Core Version:    0.7.0.1
 */