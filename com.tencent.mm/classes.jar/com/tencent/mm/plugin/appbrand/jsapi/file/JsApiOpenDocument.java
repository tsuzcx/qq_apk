package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import java.io.File;
import org.json.JSONObject;

public final class JsApiOpenDocument
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 99;
  private static final String NAME = "openDocument";
  private static long gqO = -1L;
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    long l = bk.UY();
    if (l - gqO < 1000L)
    {
      paramc.C(paramInt, h("fail:document viewer already starting", null));
      return;
    }
    gqO = l;
    Context localContext = paramc.getContext();
    if ((localContext == null) || (!(localContext instanceof Activity)))
    {
      paramc.C(paramInt, h("fail", null));
      return;
    }
    String str = paramJSONObject.optString("filePath");
    if (bk.bl(str))
    {
      paramc.C(paramInt, h("fail:invalid data", null));
      return;
    }
    File localFile = paramc.Zl().rx(str);
    if (localFile == null)
    {
      paramc.C(paramInt, h("fail:file doesn't exist", null));
      return;
    }
    JsApiOpenDocument.OpenRequest localOpenRequest = new JsApiOpenDocument.OpenRequest();
    localOpenRequest.filePath = localFile.getAbsolutePath();
    localOpenRequest.fGv = org.a.a.a.a.aho(str);
    paramJSONObject = paramJSONObject.optString("fileType");
    if (!bk.bl(paramJSONObject)) {
      localOpenRequest.fGv = paramJSONObject;
    }
    com.tencent.mm.plugin.appbrand.ipc.a.b(localContext, localOpenRequest, new JsApiOpenDocument.1(this, paramc, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.JsApiOpenDocument
 * JD-Core Version:    0.7.0.1
 */