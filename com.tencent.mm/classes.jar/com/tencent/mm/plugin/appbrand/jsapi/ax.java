package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.permission.e;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ax
  extends y<com.tencent.luggage.sdk.b.a.c.c>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "getPluginPermissionBytes";
  
  private String a(com.tencent.luggage.sdk.b.a.c.c paramc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(186881);
    ad.i("MicroMsg.JsApiGetPluginPermissionBytes", "invoke jsapi: %s", new Object[] { "getPluginPermissionBytes" });
    if (paramc == null)
    {
      ad.i("MicroMsg.JsApiGetPluginPermissionBytes", "fail:service is nil");
      paramc = e("fail:service is nil", null);
      AppMethodBeat.o(186881);
      return paramc;
    }
    if (paramJSONObject == null)
    {
      ad.i("MicroMsg.JsApiGetPluginPermissionBytes", "fail:data is nil");
      paramc = e("fail:data is nil", null);
      AppMethodBeat.o(186881);
      return paramc;
    }
    Object localObject = paramc.Dl();
    if (localObject == null)
    {
      ad.i("MicroMsg.JsApiGetPluginPermissionBytes", "fail:runtime is nil");
      paramc = e("fail:runtime is nil", null);
      AppMethodBeat.o(186881);
      return paramc;
    }
    e locale = ((com.tencent.luggage.sdk.d.c)localObject).cif;
    if (locale == null)
    {
      ad.e("MicroMsg.JsApiGetPluginPermissionBytes", "invoke failed, NULL permissionController with appId:%s", new Object[] { ((AppBrandRuntime)localObject).mAppId });
      paramc = e("fail:internal error", null);
      AppMethodBeat.o(186881);
      return paramc;
    }
    for (;;)
    {
      HashMap localHashMap1;
      HashMap localHashMap2;
      int i;
      try
      {
        localObject = new JSONArray(paramJSONObject.optString("pluginList"));
        localHashMap1 = new HashMap();
        localHashMap2 = new HashMap();
        i = 0;
        if (i < ((JSONArray)localObject).length())
        {
          paramJSONObject = ((JSONArray)localObject).optJSONObject(i);
          String str = paramJSONObject.optString("pluginId");
          JSONArray localJSONArray1 = paramJSONObject.optJSONArray("indexes");
          ad.i("MicroMsg.JsApiGetPluginPermissionBytes", "pluginId:%s,indexes:%s", new Object[] { str, localJSONArray1 });
          if (localJSONArray1 == null)
          {
            ad.i("MicroMsg.JsApiGetPluginPermissionBytes", "fail:indexes is nil");
            paramc = e("fail:indexes is nil", null);
            AppMethodBeat.o(186881);
            return paramc;
          }
          j = locale.liM;
          if (j == -1)
          {
            paramJSONObject = new byte[] { 1 };
            if ((paramJSONObject == null) || (paramJSONObject.length <= 0))
            {
              ad.i("MicroMsg.JsApiGetPluginPermissionBytes", "fail:pluginId:%s ctrlBytes is empty", new Object[] { str });
              break label638;
            }
          }
          else
          {
            if (j == -2)
            {
              paramJSONObject = new byte[] { 0 };
              continue;
            }
            if (bt.isNullOrNil(str))
            {
              paramJSONObject = null;
              continue;
            }
            paramJSONObject = locale.Mg(str);
            if (paramJSONObject == null)
            {
              paramJSONObject = null;
              continue;
            }
            if (!(paramc instanceof q)) {}
          }
          switch (com.tencent.mm.plugin.appbrand.permission.e.2.iRi[locale.iGV.iDK.iQP.aQO().ordinal()])
          {
          case 1: 
            paramJSONObject = paramJSONObject.liH;
            break;
          case 2: 
          case 3: 
            paramJSONObject = paramJSONObject.liI;
            break;
            paramJSONObject = paramJSONObject.liH;
            break;
            ad.i("MicroMsg.JsApiGetPluginPermissionBytes", "pluginId:%s ctrlBytes:%d", new Object[] { str, Integer.valueOf(paramJSONObject.length) });
            JSONArray localJSONArray2 = new JSONArray();
            if (localJSONArray1.length() != 0) {
              break label651;
            }
            j = 0;
            if (j < paramJSONObject.length)
            {
              localJSONArray2.put(locale.H(paramJSONObject, j));
              j += 1;
              continue;
              if (j < localJSONArray1.length())
              {
                localJSONArray2.put(locale.H(paramJSONObject, localJSONArray1.optInt(j, -1)));
                j += 1;
                continue;
              }
            }
            localHashMap2.put(str, localJSONArray2);
          }
        }
      }
      catch (Exception paramc)
      {
        ad.e("MicroMsg.JsApiGetPluginPermissionBytes", "parse pluginList error:%s", new Object[] { paramc });
        paramc = e("fail:parse pluginList error", null);
        AppMethodBeat.o(186881);
        return paramc;
      }
      localHashMap1.put("pluginPermissionMap", localHashMap2);
      ad.i("MicroMsg.JsApiGetPluginPermissionBytes", "invoke JsApiGetPluginPermissionBytes ok");
      paramc = k("ok", localHashMap1);
      AppMethodBeat.o(186881);
      return paramc;
      label638:
      i += 1;
      continue;
      continue;
      continue;
      label651:
      int j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ax
 * JD-Core Version:    0.7.0.1
 */