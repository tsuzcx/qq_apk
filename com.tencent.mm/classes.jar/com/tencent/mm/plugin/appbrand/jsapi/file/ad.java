package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ab;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public final class ad
  extends c
{
  private static final int CTRL_INDEX = 778;
  private static final String NAME = "private_fileSystemConvert";
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(174794);
    Log.i("MicroMsg.AppBrand.JsApiPrivateFileSystem", "hy: %s %s", new Object[] { "private_fileSystemConvert", paramJSONObject.toString() });
    Object localObject1 = paramJSONObject.optString("operationType", "");
    Object localObject2;
    if (((String)localObject1).equalsIgnoreCase("getAbsolutePath"))
    {
      localObject1 = paramJSONObject.optString("localId");
      if (Util.isNullOrNil((String)localObject1))
      {
        parame.j(paramInt, h(String.format("fail: parmas error %s", new Object[] { paramJSONObject.toString() }), null));
        AppMethodBeat.o(174794);
        return;
      }
      try
      {
        paramJSONObject = new JSONObject();
        paramJSONObject.put("filePath", localObject1);
        if (((String)localObject1).contains("wxfile://"))
        {
          localObject2 = parame.getFileSystem().adL((String)localObject1);
          if (localObject2 == null)
          {
            parame.j(paramInt, h("fail:file doesn't exist", null));
            parame.j(paramInt, h(String.format("fail: %s not exists", new Object[] { localObject1 }), null));
            AppMethodBeat.o(174794);
            return;
          }
          paramJSONObject.put("filePath", ((q)localObject2).bOF());
        }
        parame.j(paramInt, paramJSONObject.toString());
        AppMethodBeat.o(174794);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        parame.j(paramInt, h(String.format("fail: error %s", new Object[] { paramJSONObject.getMessage() }), null));
        AppMethodBeat.o(174794);
        return;
      }
    }
    if (((String)localObject1).equalsIgnoreCase("getWxFilePath")) {}
    label693:
    label837:
    for (;;)
    {
      String str2;
      try
      {
        localObject1 = paramJSONObject.optString("fileName");
        if (!Util.isNullOrNil((String)localObject1)) {
          break label837;
        }
        localObject1 = "private_fileSystemConvert_" + System.currentTimeMillis();
        localObject2 = paramJSONObject.optString("mimeType");
        boolean bool2 = paramJSONObject.optBoolean("autoDeleteIfExists", true);
        if (Util.isNullOrNil((String)localObject2))
        {
          parame.j(paramInt, h(String.format("fail: parmas error %s", new Object[] { paramJSONObject.toString() }), null));
          AppMethodBeat.o(174794);
          return;
        }
        str2 = (String)localObject1 + "." + (String)localObject2;
        if ((parame == null) || (Util.isNullOrNil(str2)))
        {
          boolean bool1;
          if (parame == null)
          {
            bool1 = true;
            Log.w("MicroMsg.AppBrand.JsApiPrivateFileSystem", "hy: param error %b, %s", new Object[] { Boolean.valueOf(bool1), str2 });
            paramJSONObject = null;
            if (Util.isNullOrNil(paramJSONObject))
            {
              parame.j(paramInt, h("fail: getAbsoluteFile failed", null));
              AppMethodBeat.o(174794);
            }
          }
          else
          {
            bool1 = false;
            continue;
          }
        }
        else
        {
          paramJSONObject = (av)parame.getFileSystem();
          if (paramJSONObject == null)
          {
            Log.w("MicroMsg.AppBrand.JsApiPrivateFileSystem", "hy: fs is null");
            paramJSONObject = null;
            continue;
          }
          localObject2 = ((ab)paramJSONObject.adY("wxfile://clientdata")).nMO;
          paramJSONObject = (JSONObject)localObject2;
          if (!((String)localObject2).endsWith("/")) {
            paramJSONObject = (String)localObject2 + "/";
          }
          localObject2 = new q(paramJSONObject + ".nomedia");
          if (!((q)localObject2).ifE()) {
            Log.i("MicroMsg.AppBrand.JsApiPrivateFileSystem", "hy: no nomedia file. trigger new");
          }
          try
          {
            ((q)localObject2).ifM();
            paramJSONObject = paramJSONObject + str2;
          }
          catch (IOException localIOException)
          {
            Log.printErrStackTrace("MicroMsg.AppBrand.JsApiPrivateFileSystem", localIOException, "hy: create no media file failed!", new Object[0]);
            continue;
          }
        }
        if (!bool2) {
          break label693;
        }
      }
      catch (JSONException paramJSONObject)
      {
        parame.j(paramInt, h(String.format("fail: error %s", new Object[] { paramJSONObject.getMessage() }), null));
        Log.printErrStackTrace("MicroMsg.AppBrand.JsApiPrivateFileSystem", paramJSONObject, "hy: json error!", new Object[0]);
        AppMethodBeat.o(174794);
        return;
      }
      if (u.agG(paramJSONObject)) {
        u.deleteFile(paramJSONObject);
      }
      String str1 = u.bBT(paramJSONObject);
      u.bBD(str1);
      Log.w("MicroMsg.AppBrand.JsApiPrivateFileSystem", "hy: getWxFilePath, fileName: %s, relativeFilePath: %s, relativeFileName: %s, parentAbsolutePath: %s!", new Object[] { localObject1, str2, paramJSONObject, str1 });
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("filePath", paramJSONObject);
      ((JSONObject)localObject1).put("localId", "wxfile://clientdata/".concat(String.valueOf(str2)));
      parame.j(paramInt, ((JSONObject)localObject1).toString());
      AppMethodBeat.o(174794);
      return;
      Log.e("MicroMsg.AppBrand.JsApiPrivateFileSystem", "hy: invalid operate type: %s", new Object[] { localObject1 });
      parame.j(paramInt, h(String.format("fail: not valid operate type: %s", new Object[] { localObject1 }), null));
      AppMethodBeat.o(174794);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ad
 * JD-Core Version:    0.7.0.1
 */