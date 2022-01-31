package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import org.apache.commons.a.b;
import org.json.JSONObject;

public final class JsApiOpenDocument
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 99;
  private static final String NAME = "openDocument";
  private static long hMa = -1L;
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(131076);
    long l = bo.aoy();
    if (l - hMa < 1000L)
    {
      paramc.h(paramInt, j("fail:document viewer already starting", null));
      AppMethodBeat.o(131076);
      return;
    }
    hMa = l;
    Context localContext = paramc.getContext();
    if ((localContext == null) || (!(localContext instanceof Activity)))
    {
      paramc.h(paramInt, j("fail", null));
      AppMethodBeat.o(131076);
      return;
    }
    String str = paramJSONObject.optString("filePath");
    if (bo.isNullOrNil(str))
    {
      paramc.h(paramInt, j("fail:invalid data", null));
      AppMethodBeat.o(131076);
      return;
    }
    File localFile = paramc.wX().zg(str);
    if (localFile == null)
    {
      paramc.h(paramInt, j("fail:file doesn't exist", null));
      AppMethodBeat.o(131076);
      return;
    }
    JsApiOpenDocument.OpenRequest localOpenRequest = new JsApiOpenDocument.OpenRequest();
    localOpenRequest.filePath = localFile.getAbsolutePath();
    localOpenRequest.elt = b.azG(str);
    paramJSONObject = paramJSONObject.optString("fileType");
    if (!bo.isNullOrNil(paramJSONObject)) {
      localOpenRequest.elt = paramJSONObject;
    }
    com.tencent.mm.plugin.appbrand.ipc.a.b(localContext, localOpenRequest, new JsApiOpenDocument.1(this, paramc, paramInt));
    AppMethodBeat.o(131076);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.JsApiOpenDocument
 * JD-Core Version:    0.7.0.1
 */