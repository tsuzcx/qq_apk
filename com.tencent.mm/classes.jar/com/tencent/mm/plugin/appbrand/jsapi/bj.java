package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class bj
  extends ab<com.tencent.luggage.sdk.b.a.d.d>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "getPluginPermissionBytes";
  
  private String a(com.tencent.luggage.sdk.b.a.d.d paramd, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(325509);
    Log.i("MicroMsg.JsApiGetPluginPermissionBytes", "invoke jsapi: %s", new Object[] { "getPluginPermissionBytes" });
    if (paramd == null)
    {
      Log.i("MicroMsg.JsApiGetPluginPermissionBytes", "fail:service is nil");
      paramd = ZP("fail:service is nil");
      AppMethodBeat.o(325509);
      return paramd;
    }
    if (paramJSONObject == null)
    {
      Log.i("MicroMsg.JsApiGetPluginPermissionBytes", "fail:data is nil");
      paramd = ZP("fail:data is nil");
      AppMethodBeat.o(325509);
      return paramd;
    }
    Object localObject = paramd.aqZ();
    if (localObject == null)
    {
      Log.i("MicroMsg.JsApiGetPluginPermissionBytes", "fail:runtime is nil");
      paramd = ZP("fail:runtime is nil");
      AppMethodBeat.o(325509);
      return paramd;
    }
    com.tencent.mm.plugin.appbrand.permission.d locald = ((com.tencent.luggage.sdk.e.d)localObject).evw;
    if (locald == null)
    {
      Log.e("MicroMsg.JsApiGetPluginPermissionBytes", "invoke failed, NULL permissionController with appId:%s", new Object[] { ((AppBrandRuntime)localObject).mAppId });
      paramd = ZP("fail:internal error");
      AppMethodBeat.o(325509);
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
            paramd = ZP("fail:indexes is nil");
            AppMethodBeat.o(325509);
            return paramd;
          }
          j = locald.tEo;
          if (j == -1)
          {
            paramJSONObject = new byte[] { 1 };
            if ((paramJSONObject == null) || (paramJSONObject.length <= 0))
            {
              Log.i("MicroMsg.JsApiGetPluginPermissionBytes", "fail:pluginId:%s ctrlBytes is empty", new Object[] { str });
              break label629;
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
            paramJSONObject = locald.afp(str);
            if (paramJSONObject == null)
            {
              paramJSONObject = null;
              continue;
            }
            if (!(paramd instanceof y)) {}
          }
          switch (com.tencent.mm.plugin.appbrand.permission.d.3.qKW[locald.qwG.qsB.qKC.chD().ordinal()])
          {
          case 1: 
            paramJSONObject = paramJSONObject.tEj;
            break;
          case 2: 
          case 3: 
            paramJSONObject = paramJSONObject.tEk;
            break;
            paramJSONObject = paramJSONObject.tEj;
            break;
            Log.i("MicroMsg.JsApiGetPluginPermissionBytes", "pluginId:%s ctrlBytes:%d", new Object[] { str, Integer.valueOf(paramJSONObject.length) });
            JSONArray localJSONArray2 = new JSONArray();
            if (localJSONArray1.length() != 0) {
              break label642;
            }
            j = 0;
            if (j < paramJSONObject.length)
            {
              localJSONArray2.put(locald.F(paramJSONObject, j));
              j += 1;
              continue;
              if (j < localJSONArray1.length())
              {
                localJSONArray2.put(locald.F(paramJSONObject, localJSONArray1.optInt(j, -1)));
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
        paramd = ZP("fail:parse pluginList error");
        AppMethodBeat.o(325509);
        return paramd;
      }
      localHashMap1.put("pluginPermissionMap", localHashMap2);
      Log.i("MicroMsg.JsApiGetPluginPermissionBytes", "invoke JsApiGetPluginPermissionBytes ok");
      paramd = m("ok", localHashMap1);
      AppMethodBeat.o(325509);
      return paramd;
      label629:
      i += 1;
      continue;
      continue;
      continue;
      label642:
      int j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bj
 * JD-Core Version:    0.7.0.1
 */