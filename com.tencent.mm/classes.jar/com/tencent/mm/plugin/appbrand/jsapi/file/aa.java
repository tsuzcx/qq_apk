package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.appstorage.x;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public final class aa
  extends a
{
  private static final int CTRL_INDEX = 778;
  private static final String NAME = "private_fileSystemConvert";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(174794);
    ad.i("MicroMsg.AppBrand.JsApiPrivateFileSystem", "hy: %s %s", new Object[] { "private_fileSystemConvert", paramJSONObject.toString() });
    Object localObject1 = paramJSONObject.optString("operationType", "");
    if (((String)localObject1).equalsIgnoreCase("getAbsolutePath"))
    {
      localObject1 = paramJSONObject.optString("localId");
      if (bt.isNullOrNil((String)localObject1))
      {
        paramc.h(paramInt, e(String.format("fail: parmas error %s", new Object[] { paramJSONObject.toString() }), null));
        AppMethodBeat.o(174794);
        return;
      }
      paramJSONObject = paramc.Ee().EP((String)localObject1);
      if (paramJSONObject == null)
      {
        paramc.h(paramInt, e("fail:file doesn't exist", null));
        paramc.h(paramInt, e(String.format("fail: %s not exists", new Object[] { localObject1 }), null));
        AppMethodBeat.o(174794);
        return;
      }
      try
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("filePath", q.B(paramJSONObject.fhU()));
        paramc.h(paramInt, ((JSONObject)localObject1).toString());
        AppMethodBeat.o(174794);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        paramc.h(paramInt, e(String.format("fail: error %s", new Object[] { paramJSONObject.getMessage() }), null));
        AppMethodBeat.o(174794);
        return;
      }
    }
    if (((String)localObject1).equalsIgnoreCase("getWxFilePath")) {}
    label677:
    label821:
    for (;;)
    {
      String str2;
      try
      {
        localObject1 = paramJSONObject.optString("fileName");
        if (!bt.isNullOrNil((String)localObject1)) {
          break label821;
        }
        localObject1 = "private_fileSystemConvert_" + System.currentTimeMillis();
        Object localObject2 = paramJSONObject.optString("mimeType");
        boolean bool2 = paramJSONObject.optBoolean("autoDeleteIfExists", true);
        if (bt.isNullOrNil((String)localObject2))
        {
          paramc.h(paramInt, e(String.format("fail: parmas error %s", new Object[] { paramJSONObject.toString() }), null));
          AppMethodBeat.o(174794);
          return;
        }
        str2 = (String)localObject1 + "." + (String)localObject2;
        if ((paramc == null) || (bt.isNullOrNil(str2)))
        {
          boolean bool1;
          if (paramc == null)
          {
            bool1 = true;
            ad.w("MicroMsg.AppBrand.JsApiPrivateFileSystem", "hy: param error %b, %s", new Object[] { Boolean.valueOf(bool1), str2 });
            paramJSONObject = null;
            if (bt.isNullOrNil(paramJSONObject))
            {
              paramc.h(paramInt, e("fail: getAbsoluteFile failed", null));
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
          paramJSONObject = (ar)paramc.Ee();
          if (paramJSONObject == null)
          {
            ad.w("MicroMsg.AppBrand.JsApiPrivateFileSystem", "hy: fs is null");
            paramJSONObject = null;
            continue;
          }
          localObject2 = ((x)paramJSONObject.EZ("wxfile://clientdata")).iSI;
          paramJSONObject = (JSONObject)localObject2;
          if (!((String)localObject2).endsWith("/")) {
            paramJSONObject = (String)localObject2 + "/";
          }
          localObject2 = new e(paramJSONObject + ".nomedia");
          if (!((e)localObject2).exists()) {
            ad.i("MicroMsg.AppBrand.JsApiPrivateFileSystem", "hy: no nomedia file. trigger new");
          }
          try
          {
            ((e)localObject2).createNewFile();
            paramJSONObject = paramJSONObject + str2;
          }
          catch (IOException localIOException)
          {
            ad.printErrStackTrace("MicroMsg.AppBrand.JsApiPrivateFileSystem", localIOException, "hy: create no media file failed!", new Object[0]);
            continue;
          }
        }
        if (!bool2) {
          break label677;
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramc.h(paramInt, e(String.format("fail: error %s", new Object[] { paramJSONObject.getMessage() }), null));
        ad.printErrStackTrace("MicroMsg.AppBrand.JsApiPrivateFileSystem", paramJSONObject, "hy: json error!", new Object[0]);
        AppMethodBeat.o(174794);
        return;
      }
      if (i.eK(paramJSONObject)) {
        i.deleteFile(paramJSONObject);
      }
      String str1 = i.aMQ(paramJSONObject);
      i.aMF(str1);
      ad.w("MicroMsg.AppBrand.JsApiPrivateFileSystem", "hy: getWxFilePath, fileName: %s, relativeFilePath: %s, relativeFileName: %s, parentAbsolutePath: %s!", new Object[] { localObject1, str2, paramJSONObject, str1 });
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("filePath", paramJSONObject);
      ((JSONObject)localObject1).put("localId", "wxfile://clientdata/".concat(String.valueOf(str2)));
      paramc.h(paramInt, ((JSONObject)localObject1).toString());
      AppMethodBeat.o(174794);
      return;
      ad.e("MicroMsg.AppBrand.JsApiPrivateFileSystem", "hy: invalid operate type: %s", new Object[] { localObject1 });
      paramc.h(paramInt, e(String.format("fail: not valid operate type: %s", new Object[] { localObject1 }), null));
      AppMethodBeat.o(174794);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.aa
 * JD-Core Version:    0.7.0.1
 */