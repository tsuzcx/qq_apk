package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.c;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class i
  extends s
{
  private static final int CTRL_INDEX = 523;
  private static final String NAME = "onBackgroundFetchData";
  
  public static void z(w paramw)
  {
    AppMethodBeat.i(44759);
    String str = paramw.mAppId;
    MMToClientEvent.c local1 = new MMToClientEvent.c()
    {
      public final void dL(Object paramAnonymousObject)
      {
        AppMethodBeat.i(44757);
        String str1;
        Object localObject;
        String str2;
        int i;
        HashMap localHashMap;
        if ((paramAnonymousObject instanceof AppBrandBackgroundFetchDataParcel))
        {
          Log.i("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "app received data, appId:%s", new Object[] { i.this });
          str1 = i.this;
          localObject = (AppBrandBackgroundFetchDataParcel)paramAnonymousObject;
          if ((localObject == null) || (Util.isNullOrNil(str1)))
          {
            Log.w("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "dispatch, parcel is null or appid is null");
            AppMethodBeat.o(44757);
            return;
          }
          str2 = ((AppBrandBackgroundFetchDataParcel)localObject).username;
          i = ((AppBrandBackgroundFetchDataParcel)localObject).qRL;
          paramAnonymousObject = ((AppBrandBackgroundFetchDataParcel)localObject).data;
          String str3 = ((AppBrandBackgroundFetchDataParcel)localObject).path;
          String str4 = ((AppBrandBackgroundFetchDataParcel)localObject).query;
          int j = ((AppBrandBackgroundFetchDataParcel)localObject).scene;
          long l = ((AppBrandBackgroundFetchDataParcel)localObject).egK;
          if ((Util.isNullOrNil(str2)) || (Util.isNullOrNil(paramAnonymousObject)))
          {
            Log.w("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "username or data is null");
            AppMethodBeat.o(44757);
            return;
          }
          localObject = d.Uc(str1);
          if ((localObject == null) || (!((AppBrandRuntime)localObject).mInitialized))
          {
            Log.w("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "app(%s) runtime is null or not initialized, appId:%s", new Object[] { str2, str1 });
            AppMethodBeat.o(44757);
            return;
          }
          localObject = ((AppBrandRuntime)localObject).ari();
          if ((localObject == null) || (((y)localObject).getAppState() == b.qKz))
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
          new i().K(localHashMap).h((f)localObject).cpV();
          AppMethodBeat.o(44757);
          return;
        }
      }
    };
    MMToClientEvent.a(str, local1);
    Log.i("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "app start listening background fetched data event, appId:%s", new Object[] { str });
    paramw.qsB.a(new c.a()
    {
      public final void onRunningStateChanged(String paramAnonymousString, b paramAnonymousb)
      {
        AppMethodBeat.i(44758);
        if (paramAnonymousb == b.qKz)
        {
          MMToClientEvent.b(paramAnonymousString, i.this);
          Log.i("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "app stop listening background fetched data event, appId:%s", new Object[] { paramAnonymousString });
        }
        AppMethodBeat.o(44758);
      }
    });
    AppMethodBeat.o(44759);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.i
 * JD-Core Version:    0.7.0.1
 */