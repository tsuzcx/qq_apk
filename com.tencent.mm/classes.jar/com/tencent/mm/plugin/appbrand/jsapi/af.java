package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.permission.d;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class af
  extends s
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "getPermissionBytes";
  
  public final String a(c paramc, JSONObject paramJSONObject)
  {
    y.i("MicroMsg.JsApiGetPermissionBytes", "invoke jsapi: %s", new Object[] { "getPermissionBytes" });
    if (paramc == null)
    {
      y.i("MicroMsg.JsApiGetPermissionBytes", "fail:service is nil");
      return h("fail:service is nil", null);
    }
    if (paramJSONObject == null)
    {
      y.i("MicroMsg.JsApiGetPermissionBytes", "fail:data is nil");
      return h("fail:data is nil", null);
    }
    paramJSONObject = paramJSONObject.optJSONArray("indexes");
    if (paramJSONObject == null)
    {
      y.i("MicroMsg.JsApiGetPermissionBytes", "fail:indexes is nil");
      return h("fail:indexes is nil", null);
    }
    if (!(paramc instanceof f))
    {
      y.i("MicroMsg.JsApiGetPermissionBytes", "fail:service is not AppBrandComponentWithExtra");
      return h("fail:service invalid", null);
    }
    Object localObject = ((f)paramc).getRuntime();
    if (localObject == null)
    {
      y.i("MicroMsg.JsApiGetPermissionBytes", "fail:runtime is nil");
      return h("fail:runtime is nil", null);
    }
    if (!(localObject instanceof n))
    {
      y.i("MicroMsg.JsApiGetPermissionBytes", "fail:runtime is not AppBrandRuntimeWC");
      return h("fail:runtime invalid", null);
    }
    localObject = ((n)localObject).fzB.r(paramc);
    if ((localObject == null) || (localObject.length <= 0))
    {
      y.i("MicroMsg.JsApiGetPermissionBytes", "fail:ctrlBytes is empty");
      return h("fail:ctrlBytes is empty", null);
    }
    paramc = new JSONArray();
    if (paramJSONObject.length() == 0)
    {
      i = 0;
      while (i < localObject.length)
      {
        paramc.put(d.C((byte[])localObject, i));
        i += 1;
      }
    }
    int i = 0;
    while (i < paramJSONObject.length())
    {
      int j = paramJSONObject.optInt(i, -1);
      if ((j >= 0) && (j < localObject.length))
      {
        paramc.put(d.C((byte[])localObject, j));
        i += 1;
      }
      else
      {
        y.i("MicroMsg.JsApiGetPermissionBytes", "fail:ctrl index(%s) invalid, max len:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(localObject.length) });
        return h("fail:ctrl index invalid", null);
      }
    }
    paramJSONObject = new HashMap();
    paramJSONObject.put("permissionBytes", paramc);
    y.i("MicroMsg.JsApiGetPermissionBytes", "invoke getPermissionBytes ok");
    return h("ok", paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.af
 * JD-Core Version:    0.7.0.1
 */