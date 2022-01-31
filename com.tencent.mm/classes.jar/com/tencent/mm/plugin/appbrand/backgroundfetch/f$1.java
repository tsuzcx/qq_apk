package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public final class f$1
  implements MMToClientEvent.c
{
  public f$1(String paramString) {}
  
  public final void aG(Object paramObject)
  {
    String str1;
    if ((paramObject instanceof AppBrandBackgroundFetchDataParcel))
    {
      y.i("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent.javayhu", "app received data, appId:%s", new Object[] { this.val$appId });
      str1 = this.val$appId;
      localObject = (AppBrandBackgroundFetchDataParcel)paramObject;
      if ((localObject == null) || (bk.bl(str1))) {
        y.w("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent.javayhu", "dispatch, parcel is null or appid is null");
      }
    }
    else
    {
      return;
    }
    String str2 = ((AppBrandBackgroundFetchDataParcel)localObject).username;
    int i = ((AppBrandBackgroundFetchDataParcel)localObject).fKK;
    paramObject = ((AppBrandBackgroundFetchDataParcel)localObject).data;
    String str3 = ((AppBrandBackgroundFetchDataParcel)localObject).path;
    String str4 = ((AppBrandBackgroundFetchDataParcel)localObject).bVk;
    int j = ((AppBrandBackgroundFetchDataParcel)localObject).scene;
    long l = ((AppBrandBackgroundFetchDataParcel)localObject).updateTime;
    if ((bk.bl(str2)) || (bk.bl(paramObject)))
    {
      y.w("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent.javayhu", "username or data is null");
      return;
    }
    Object localObject = a.qn(str1);
    if ((localObject == null) || (!((i)localObject).dNk))
    {
      y.w("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent.javayhu", "app(%s) runtime is null or not initialized, appId:%s", new Object[] { str2, str1 });
      return;
    }
    localObject = ((i)localObject).Zy();
    if ((localObject == null) || (((o)localObject).Zk() == b.fFL))
    {
      y.w("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent.javayhu", "app(%s) service is null or has destroyed, appId:%s", new Object[] { str2, str1 });
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("timeStamp", Long.valueOf(l));
    localHashMap.put("path", str3);
    localHashMap.put("query", str4);
    localHashMap.put("scene", Integer.valueOf(j));
    localHashMap.put("fetchedData", paramObject);
    if (i == 0) {}
    for (paramObject = "pre";; paramObject = "peroid")
    {
      localHashMap.put("fetchType", paramObject);
      y.i("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent.javayhu", "AppBrandOnBackgroundFetchDataEvent dispatch to app(%s), appId:%s, fetch type:%d", new Object[] { str2, str1, Integer.valueOf(i) });
      new f().o(localHashMap).d((c)localObject).dispatch();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.f.1
 * JD-Core Version:    0.7.0.1
 */