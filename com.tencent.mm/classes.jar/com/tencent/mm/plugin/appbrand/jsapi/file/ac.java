package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.appstorage.z;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public final class ac
  extends a
{
  private static final int CTRL_INDEX = 778;
  private static final String NAME = "private_fileSystemConvert";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(174794);
    ae.i("MicroMsg.AppBrand.JsApiPrivateFileSystem", "hy: %s %s", new Object[] { "private_fileSystemConvert", paramJSONObject.toString() });
    Object localObject1 = paramJSONObject.optString("operationType", "");
    Object localObject2;
    if (((String)localObject1).equalsIgnoreCase("getAbsolutePath"))
    {
      localObject1 = paramJSONObject.optString("localId");
      if (bu.isNullOrNil((String)localObject1))
      {
        paramc.h(paramInt, e(String.format("fail: parmas error %s", new Object[] { paramJSONObject.toString() }), null));
        AppMethodBeat.o(174794);
        return;
      }
      try
      {
        paramJSONObject = new JSONObject();
        paramJSONObject.put("filePath", localObject1);
        if (((String)localObject1).contains("wxfile://"))
        {
          localObject2 = paramc.Fl().MP((String)localObject1);
          if (localObject2 == null)
          {
            paramc.h(paramInt, e("fail:file doesn't exist", null));
            paramc.h(paramInt, e(String.format("fail: %s not exists", new Object[] { localObject1 }), null));
            AppMethodBeat.o(174794);
            return;
          }
          paramJSONObject.put("filePath", w.B(((k)localObject2).fTh()));
        }
        paramc.h(paramInt, paramJSONObject.toString());
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
    label696:
    label842:
    for (;;)
    {
      String str2;
      try
      {
        localObject1 = paramJSONObject.optString("fileName");
        if (!bu.isNullOrNil((String)localObject1)) {
          break label842;
        }
        localObject1 = "private_fileSystemConvert_" + System.currentTimeMillis();
        localObject2 = paramJSONObject.optString("mimeType");
        boolean bool2 = paramJSONObject.optBoolean("autoDeleteIfExists", true);
        if (bu.isNullOrNil((String)localObject2))
        {
          paramc.h(paramInt, e(String.format("fail: parmas error %s", new Object[] { paramJSONObject.toString() }), null));
          AppMethodBeat.o(174794);
          return;
        }
        str2 = (String)localObject1 + "." + (String)localObject2;
        if ((paramc == null) || (bu.isNullOrNil(str2)))
        {
          boolean bool1;
          if (paramc == null)
          {
            bool1 = true;
            ae.w("MicroMsg.AppBrand.JsApiPrivateFileSystem", "hy: param error %b, %s", new Object[] { Boolean.valueOf(bool1), str2 });
            paramJSONObject = null;
            if (bu.isNullOrNil(paramJSONObject))
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
          paramJSONObject = (at)paramc.Fl();
          if (paramJSONObject == null)
          {
            ae.w("MicroMsg.AppBrand.JsApiPrivateFileSystem", "hy: fs is null");
            paramJSONObject = null;
            continue;
          }
          localObject2 = ((z)paramJSONObject.Na("wxfile://clientdata")).jPJ;
          paramJSONObject = (JSONObject)localObject2;
          if (!((String)localObject2).endsWith("/")) {
            paramJSONObject = (String)localObject2 + "/";
          }
          localObject2 = new k(paramJSONObject + ".nomedia");
          if (!((k)localObject2).exists()) {
            ae.i("MicroMsg.AppBrand.JsApiPrivateFileSystem", "hy: no nomedia file. trigger new");
          }
          try
          {
            ((k)localObject2).createNewFile();
            paramJSONObject = paramJSONObject + str2;
          }
          catch (IOException localIOException)
          {
            ae.printErrStackTrace("MicroMsg.AppBrand.JsApiPrivateFileSystem", localIOException, "hy: create no media file failed!", new Object[0]);
            continue;
          }
        }
        if (!bool2) {
          break label696;
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramc.h(paramInt, e(String.format("fail: error %s", new Object[] { paramJSONObject.getMessage() }), null));
        ae.printErrStackTrace("MicroMsg.AppBrand.JsApiPrivateFileSystem", paramJSONObject, "hy: json error!", new Object[0]);
        AppMethodBeat.o(174794);
        return;
      }
      if (o.fB(paramJSONObject)) {
        o.deleteFile(paramJSONObject);
      }
      String str1 = o.aZU(paramJSONObject);
      o.aZI(str1);
      ae.w("MicroMsg.AppBrand.JsApiPrivateFileSystem", "hy: getWxFilePath, fileName: %s, relativeFilePath: %s, relativeFileName: %s, parentAbsolutePath: %s!", new Object[] { localObject1, str2, paramJSONObject, str1 });
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("filePath", paramJSONObject);
      ((JSONObject)localObject1).put("localId", "wxfile://clientdata/".concat(String.valueOf(str2)));
      paramc.h(paramInt, ((JSONObject)localObject1).toString());
      AppMethodBeat.o(174794);
      return;
      ae.e("MicroMsg.AppBrand.JsApiPrivateFileSystem", "hy: invalid operate type: %s", new Object[] { localObject1 });
      paramc.h(paramInt, e(String.format("fail: not valid operate type: %s", new Object[] { localObject1 }), null));
      AppMethodBeat.o(174794);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ac
 * JD-Core Version:    0.7.0.1
 */