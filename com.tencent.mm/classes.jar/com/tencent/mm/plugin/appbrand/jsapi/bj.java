package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class bj
  extends ab<com.tencent.luggage.sdk.b.a.c.d>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "getPluginPermissionBytes";
  
  private String a(com.tencent.luggage.sdk.b.a.c.d paramd, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(229887);
    Log.i("MicroMsg.JsApiGetPluginPermissionBytes", "invoke jsapi: %s", new Object[] { "getPluginPermissionBytes" });
    if (paramd == null)
    {
      Log.i("MicroMsg.JsApiGetPluginPermissionBytes", "fail:service is nil");
      paramd = h("fail:service is nil", null);
      AppMethodBeat.o(229887);
      return paramd;
    }
    if (paramJSONObject == null)
    {
      Log.i("MicroMsg.JsApiGetPluginPermissionBytes", "fail:data is nil");
      paramd = h("fail:data is nil", null);
      AppMethodBeat.o(229887);
      return paramd;
    }
    Object localObject = paramd.NP();
    if (localObject == null)
    {
      Log.i("MicroMsg.JsApiGetPluginPermissionBytes", "fail:runtime is nil");
      paramd = h("fail:runtime is nil", null);
      AppMethodBeat.o(229887);
      return paramd;
    }
    com.tencent.mm.plugin.appbrand.permission.d locald = ((com.tencent.luggage.sdk.d.d)localObject).cCn;
    if (locald == null)
    {
      Log.e("MicroMsg.JsApiGetPluginPermissionBytes", "invoke failed, NULL permissionController with appId:%s", new Object[] { ((AppBrandRuntime)localObject).mAppId });
      paramd = h("fail:internal error", null);
      AppMethodBeat.o(229887);
      return paramd;
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
          Log.i("MicroMsg.JsApiGetPluginPermissionBytes", "pluginId:%s,indexes:%s", new Object[] { str, localJSONArray1 });
          if (localJSONArray1 == null)
          {
            Log.i("MicroMsg.JsApiGetPluginPermissionBytes", "fail:indexes is nil");
            paramd = h("fail:indexes is nil", null);
            AppMethodBeat.o(229887);
            return paramd;
          }
          j = locald.nxp;
          if (j == -1)
          {
            paramJSONObject = new byte[] { 1 };
            if ((paramJSONObject == null) || (paramJSONObject.length <= 0))
            {
              Log.i("MicroMsg.JsApiGetPluginPermissionBytes", "fail:pluginId:%s ctrlBytes is empty", new Object[] { str });
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
            if (Util.isNullOrNil(str))
            {
              paramJSONObject = null;
              continue;
            }
            paramJSONObject = locald.aen(str);
            if (paramJSONObject == null)
            {
              paramJSONObject = null;
              continue;
            }
            if (!(paramd instanceof s)) {}
          }
          switch (com.tencent.mm.plugin.appbrand.permission.d.2.kRf[locald.kEc.kAH.kQM.bwY().ordinal()])
          {
          case 1: 
            paramJSONObject = paramJSONObject.nxk;
            break;
          case 2: 
          case 3: 
            paramJSONObject = paramJSONObject.nxl;
            break;
            paramJSONObject = paramJSONObject.nxk;
            break;
            Log.i("MicroMsg.JsApiGetPluginPermissionBytes", "pluginId:%s ctrlBytes:%d", new Object[] { str, Integer.valueOf(paramJSONObject.length) });
            JSONArray localJSONArray2 = new JSONArray();
            if (localJSONArray1.length() != 0) {
              break label651;
            }
            j = 0;
            if (j < paramJSONObject.length)
            {
              localJSONArray2.put(locald.H(paramJSONObject, j));
              j += 1;
              continue;
              if (j < localJSONArray1.length())
              {
                localJSONArray2.put(locald.H(paramJSONObject, localJSONArray1.optInt(j, -1)));
                j += 1;
                continue;
              }
            }
            localHashMap2.put(str, localJSONArray2);
          }
        }
      }
      catch (Exception paramd)
      {
        Log.e("MicroMsg.JsApiGetPluginPermissionBytes", "parse pluginList error:%s", new Object[] { paramd });
        paramd = h("fail:parse pluginList error", null);
        AppMethodBeat.o(229887);
        return paramd;
      }
      localHashMap1.put("pluginPermissionMap", localHashMap2);
      Log.i("MicroMsg.JsApiGetPluginPermissionBytes", "invoke JsApiGetPluginPermissionBytes ok");
      paramd = n("ok", localHashMap1);
      AppMethodBeat.o(229887);
      return paramd;
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bj
 * JD-Core Version:    0.7.0.1
 */