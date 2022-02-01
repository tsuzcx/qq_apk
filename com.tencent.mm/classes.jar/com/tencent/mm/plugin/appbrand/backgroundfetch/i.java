package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;

public final class i
  extends p
{
  private static final int CTRL_INDEX = 523;
  private static final String NAME = "onBackgroundFetchData";
  
  public static void x(o paramo)
  {
    AppMethodBeat.i(44759);
    String str = paramo.mAppId;
    MMToClientEvent.c local1 = new MMToClientEvent.c()
    {
      public final void ch(Object paramAnonymousObject)
      {
        AppMethodBeat.i(44757);
        String str1;
        Object localObject;
        String str2;
        int i;
        HashMap localHashMap;
        if ((paramAnonymousObject instanceof AppBrandBackgroundFetchDataParcel))
        {
          ad.i("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "app received data, appId:%s", new Object[] { this.val$appId });
          str1 = this.val$appId;
          localObject = (AppBrandBackgroundFetchDataParcel)paramAnonymousObject;
          if ((localObject == null) || (bt.isNullOrNil(str1)))
          {
            ad.w("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "dispatch, parcel is null or appid is null");
            AppMethodBeat.o(44757);
            return;
          }
          str2 = ((AppBrandBackgroundFetchDataParcel)localObject).username;
          i = ((AppBrandBackgroundFetchDataParcel)localObject).iXp;
          paramAnonymousObject = ((AppBrandBackgroundFetchDataParcel)localObject).data;
          String str3 = ((AppBrandBackgroundFetchDataParcel)localObject).path;
          String str4 = ((AppBrandBackgroundFetchDataParcel)localObject).query;
          int j = ((AppBrandBackgroundFetchDataParcel)localObject).scene;
          long l = ((AppBrandBackgroundFetchDataParcel)localObject).fpL;
          if ((bt.isNullOrNil(str2)) || (bt.isNullOrNil(paramAnonymousObject)))
          {
            ad.w("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "username or data is null");
            AppMethodBeat.o(44757);
            return;
          }
          localObject = a.CR(str1);
          if ((localObject == null) || (!((AppBrandRuntime)localObject).mInitialized))
          {
            ad.w("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "app(%s) runtime is null or not initialized, appId:%s", new Object[] { str2, str1 });
            AppMethodBeat.o(44757);
            return;
          }
          localObject = ((AppBrandRuntime)localObject).Du();
          if ((localObject == null) || (((q)localObject).aLA() == b.iQN))
          {
            ad.w("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "app(%s) service is null or has destroyed, appId:%s", new Object[] { str2, str1 });
            AppMethodBeat.o(44757);
            return;
          }
          localHashMap = new HashMap();
          localHashMap.put("timeStamp", Long.valueOf(l));
          localHashMap.put("path", str3);
          localHashMap.put("query", str4);
          localHashMap.put("scene", Integer.valueOf(j));
          localHashMap.put("fetchedData", paramAnonymousObject);
          if (i != 0) {
            break label372;
          }
        }
        label372:
        for (paramAnonymousObject = "pre";; paramAnonymousObject = "peroid")
        {
          localHashMap.put("fetchType", paramAnonymousObject);
          ad.i("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "AppBrandOnBackgroundFetchDataEvent dispatch to app(%s), appId:%s, fetch type:%d", new Object[] { str2, str1, Integer.valueOf(i) });
          new i().B(localHashMap).g((com.tencent.mm.plugin.appbrand.jsapi.c)localObject).aXQ();
          AppMethodBeat.o(44757);
          return;
        }
      }
    };
    MMToClientEvent.a(str, local1);
    ad.i("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "app start listening background fetched data event, appId:%s", new Object[] { str });
    paramo.iDK.a(new c.a()
    {
      public final void a(String paramAnonymousString, b paramAnonymousb)
      {
        AppMethodBeat.i(44758);
        if (paramAnonymousb == b.iQN)
        {
          MMToClientEvent.b(paramAnonymousString, this.iXu);
          ad.i("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "app stop listening background fetched data event, appId:%s", new Object[] { paramAnonymousString });
        }
        AppMethodBeat.o(44758);
      }
    });
    AppMethodBeat.o(44759);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.i
 * JD-Core Version:    0.7.0.1
 */