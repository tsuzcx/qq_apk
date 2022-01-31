package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.c.bna;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import org.json.JSONObject;

public final class JsApiAuthorize
  extends c
{
  private static final int CTRL_INDEX = 54;
  private static final String NAME = "authorize";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt, b paramb)
  {
    y.d("MicroMsg.JsApiAuthorize", "stev JsApiAuthorize!");
    JsApiAuthorize.AuthorizeTask localAuthorizeTask = new JsApiAuthorize.AuthorizeTask();
    localAuthorizeTask.appId = paramf.getAppId();
    localAuthorizeTask.gjL = "authorize";
    Object localObject = paramf.getRuntime().ZB();
    if (localObject != null) {
      localAuthorizeTask.fJy = ((com.tencent.mm.plugin.appbrand.config.i)localObject).fPS.fEM;
    }
    localObject = a.qp(paramf.getAppId());
    if (localObject != null) {
      JsApiAuthorize.AuthorizeTask.a(localAuthorizeTask, ((AppBrandStatObject)localObject).scene);
    }
    paramJSONObject = paramJSONObject.toString();
    localAuthorizeTask.gjH = this;
    localAuthorizeTask.gjI = paramf;
    localAuthorizeTask.data = paramJSONObject;
    localAuthorizeTask.gfg = paramInt;
    localAuthorizeTask.gjJ = paramb;
    localAuthorizeTask.gjP = new Bundle();
    if ((paramf instanceof o)) {
      localAuthorizeTask.gjQ = 1;
    }
    for (;;)
    {
      localAuthorizeTask.ahC();
      AppBrandMainProcessService.a(localAuthorizeTask);
      return;
      if ((paramf instanceof q)) {
        localAuthorizeTask.gjQ = 2;
      }
    }
  }
  
  public static abstract interface AuthorizeTask$a
  {
    public abstract void G(int paramInt, String paramString);
    
    public abstract void a(LinkedList<bna> paramLinkedList, String paramString1, String paramString2);
    
    public abstract void onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize
 * JD-Core Version:    0.7.0.1
 */