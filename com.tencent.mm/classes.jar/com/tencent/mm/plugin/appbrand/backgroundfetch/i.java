package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class i
  extends com.tencent.mm.plugin.appbrand.jsapi.s
{
  private static final int CTRL_INDEX = 523;
  private static final String NAME = "onBackgroundFetchData";
  
  public static void s(q paramq)
  {
    AppMethodBeat.i(44759);
    String str = paramq.mAppId;
    MMToClientEvent.c local1 = new MMToClientEvent.c()
    {
      public final void cq(Object paramAnonymousObject)
      {
        AppMethodBeat.i(44757);
        String str1;
        Object localObject;
        String str2;
        int i;
        HashMap localHashMap;
        if ((paramAnonymousObject instanceof AppBrandBackgroundFetchDataParcel))
        {
          Log.i("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "app received data, appId:%s", new Object[] { this.val$appId });
          str1 = this.val$appId;
          localObject = (AppBrandBackgroundFetchDataParcel)paramAnonymousObject;
          if ((localObject == null) || (Util.isNullOrNil(str1)))
          {
            Log.w("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "dispatch, parcel is null or appid is null");
            AppMethodBeat.o(44757);
            return;
          }
          str2 = ((AppBrandBackgroundFetchDataParcel)localObject).username;
          i = ((AppBrandBackgroundFetchDataParcel)localObject).kXP;
          paramAnonymousObject = ((AppBrandBackgroundFetchDataParcel)localObject).data;
          String str3 = ((AppBrandBackgroundFetchDataParcel)localObject).path;
          String str4 = ((AppBrandBackgroundFetchDataParcel)localObject).query;
          int j = ((AppBrandBackgroundFetchDataParcel)localObject).scene;
          long l = ((AppBrandBackgroundFetchDataParcel)localObject).crj;
          if ((Util.isNullOrNil(str2)) || (Util.isNullOrNil(paramAnonymousObject)))
          {
            Log.w("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "username or data is null");
            AppMethodBeat.o(44757);
            return;
          }
          localObject = a.TQ(str1);
          if ((localObject == null) || (!((AppBrandRuntime)localObject).mInitialized))
          {
            Log.w("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "app(%s) runtime is null or not initialized, appId:%s", new Object[] { str2, str1 });
            AppMethodBeat.o(44757);
            return;
          }
          localObject = ((AppBrandRuntime)localObject).NY();
          if ((localObject == null) || (((com.tencent.mm.plugin.appbrand.s)localObject).getAppState() == b.kQK))
          {
            Log.w("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "app(%s) service is null or has destroyed, appId:%s", new Object[] { str2, str1 });
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
          Log.i("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "AppBrandOnBackgroundFetchDataEvent dispatch to app(%s), appId:%s, fetch type:%d", new Object[] { str2, str1, Integer.valueOf(i) });
          new i().K(localHashMap).g((f)localObject).bEo();
          AppMethodBeat.o(44757);
          return;
        }
      }
    };
    MMToClientEvent.a(str, local1);
    Log.i("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "app start listening background fetched data event, appId:%s", new Object[] { str });
    paramq.kAH.a(new c.a()
    {
      public final void a(String paramAnonymousString, b paramAnonymousb)
      {
        AppMethodBeat.i(44758);
        if (paramAnonymousb == b.kQK)
        {
          MMToClientEvent.b(paramAnonymousString, this.kXU);
          Log.i("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "app stop listening background fetched data event, appId:%s", new Object[] { paramAnonymousString });
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