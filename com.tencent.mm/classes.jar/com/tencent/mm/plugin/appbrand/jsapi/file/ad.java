package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.af;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public final class ad
  extends c
{
  private static final int CTRL_INDEX = 778;
  private static final String NAME = "private_fileSystemConvert";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
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
        paramf.callback(paramInt, ZP(String.format("fail: parmas error %s", new Object[] { paramJSONObject.toString() })));
        AppMethodBeat.o(174794);
        return;
      }
      try
      {
        paramJSONObject = new JSONObject();
        paramJSONObject.put("filePath", localObject1);
        if (((String)localObject1).contains("wxfile://"))
        {
          localObject2 = paramf.getFileSystem().Wm((String)localObject1);
          if (localObject2 == null)
          {
            paramf.callback(paramInt, ZP("fail:file doesn't exist"));
            paramf.callback(paramInt, ZP(String.format("fail: %s not exists", new Object[] { localObject1 })));
            AppMethodBeat.o(174794);
            return;
          }
          paramJSONObject.put("filePath", ah.v(((u)localObject2).jKT()));
        }
        paramf.callback(paramInt, paramJSONObject.toString());
        AppMethodBeat.o(174794);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        paramf.callback(paramInt, ZP(String.format("fail: error %s", new Object[] { paramJSONObject.getMessage() })));
        AppMethodBeat.o(174794);
        return;
      }
    }
    if (((String)localObject1).equalsIgnoreCase("getWxFilePath")) {}
    label689:
    label833:
    for (;;)
    {
      String str2;
      try
      {
        localObject1 = paramJSONObject.optString("fileName");
        if (!Util.isNullOrNil((String)localObject1)) {
          break label833;
        }
        localObject1 = "private_fileSystemConvert_" + System.currentTimeMillis();
        localObject2 = paramJSONObject.optString("mimeType");
        boolean bool2 = paramJSONObject.optBoolean("autoDeleteIfExists", true);
        if (Util.isNullOrNil((String)localObject2))
        {
          paramf.callback(paramInt, ZP(String.format("fail: parmas error %s", new Object[] { paramJSONObject.toString() })));
          AppMethodBeat.o(174794);
          return;
        }
        str2 = (String)localObject1 + "." + (String)localObject2;
        if ((paramf == null) || (Util.isNullOrNil(str2)))
        {
          boolean bool1;
          if (paramf == null)
          {
            bool1 = true;
            Log.w("MicroMsg.AppBrand.JsApiPrivateFileSystem", "hy: param error %b, %s", new Object[] { Boolean.valueOf(bool1), str2 });
            paramJSONObject = null;
            if (Util.isNullOrNil(paramJSONObject))
            {
              paramf.callback(paramInt, ZP("fail: getAbsoluteFile failed"));
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
          paramJSONObject = (ax)paramf.getFileSystem();
          if (paramJSONObject == null)
          {
            Log.w("MicroMsg.AppBrand.JsApiPrivateFileSystem", "hy: fs is null");
            paramJSONObject = null;
            continue;
          }
          localObject2 = ((af)paramJSONObject.Wy("wxfile://clientdata")).qMI;
          paramJSONObject = (JSONObject)localObject2;
          if (!((String)localObject2).endsWith("/")) {
            paramJSONObject = (String)localObject2 + "/";
          }
          localObject2 = new u(paramJSONObject + ".nomedia");
          if (!((u)localObject2).jKS()) {
            Log.i("MicroMsg.AppBrand.JsApiPrivateFileSystem", "hy: no nomedia file. trigger new");
          }
          try
          {
            ((u)localObject2).jKZ();
            paramJSONObject = paramJSONObject + str2;
          }
          catch (IOException localIOException)
          {
            Log.printErrStackTrace("MicroMsg.AppBrand.JsApiPrivateFileSystem", localIOException, "hy: create no media file failed!", new Object[0]);
            continue;
          }
        }
        if (!bool2) {
          break label689;
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramf.callback(paramInt, ZP(String.format("fail: error %s", new Object[] { paramJSONObject.getMessage() })));
        Log.printErrStackTrace("MicroMsg.AppBrand.JsApiPrivateFileSystem", paramJSONObject, "hy: json error!", new Object[0]);
        AppMethodBeat.o(174794);
        return;
      }
      if (y.ZC(paramJSONObject)) {
        y.deleteFile(paramJSONObject);
      }
      String str1 = y.bEo(paramJSONObject);
      y.bDX(str1);
      Log.w("MicroMsg.AppBrand.JsApiPrivateFileSystem", "hy: getWxFilePath, fileName: %s, relativeFilePath: %s, relativeFileName: %s, parentAbsolutePath: %s!", new Object[] { localObject1, str2, paramJSONObject, str1 });
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("filePath", paramJSONObject);
      ((JSONObject)localObject1).put("localId", "wxfile://clientdata/".concat(String.valueOf(str2)));
      paramf.callback(paramInt, ((JSONObject)localObject1).toString());
      AppMethodBeat.o(174794);
      return;
      Log.e("MicroMsg.AppBrand.JsApiPrivateFileSystem", "hy: invalid operate type: %s", new Object[] { localObject1 });
      paramf.callback(paramInt, ZP(String.format("fail: not valid operate type: %s", new Object[] { localObject1 })));
      AppMethodBeat.o(174794);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ad
 * JD-Core Version:    0.7.0.1
 */