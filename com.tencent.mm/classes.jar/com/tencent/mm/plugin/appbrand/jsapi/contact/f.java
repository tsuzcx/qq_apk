package com.tencent.mm.plugin.appbrand.jsapi.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class f
  extends a
{
  public static final int CTRL_INDEX = 550;
  public static final String NAME = "privateEnterContact";
  String hKL;
  String hKM;
  String hKN;
  String hKO;
  String hKP;
  private String sessionFrom;
  
  private void a(v paramv, c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(131023);
    a(paramv, paramJSONObject, new f.1(this, paramc, paramInt));
    AppMethodBeat.o(131023);
  }
  
  private void a(v paramv, f.a parama)
  {
    AppMethodBeat.i(131025);
    JsApiChattingTask localJsApiChattingTask = new JsApiChattingTask();
    localJsApiChattingTask.username = this.hKM;
    localJsApiChattingTask.sessionFrom = this.sessionFrom;
    localJsApiChattingTask.hxp = new f.2(this, localJsApiChattingTask, paramv, parama);
    localJsApiChattingTask.aBj();
    AppBrandMainProcessService.a(localJsApiChattingTask);
    AppMethodBeat.o(131025);
  }
  
  private void a(v paramv, JSONObject paramJSONObject, f.a parama)
  {
    AppMethodBeat.i(131024);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact enterChatting fail, data is null");
      parama.a(false, "fail:invalid data", null);
      AppMethodBeat.o(131024);
      return;
    }
    if ((AppBrandSysConfigWC)paramv.getRuntime().wY() == null)
    {
      ab.e("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact enterChatting fail, config is null");
      parama.a(false, "fail:config is null", null);
      AppMethodBeat.o(131024);
      return;
    }
    this.sessionFrom = paramJSONObject.optString("sessionFrom");
    if (this.sessionFrom.length() > 1024)
    {
      this.sessionFrom = this.sessionFrom.substring(0, 1024);
      ab.i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact sessionFrom length is large than 1024!");
    }
    this.hKL = paramJSONObject.optString("appId");
    if (!bo.isNullOrNil(this.hKL))
    {
      this.hKM = paramJSONObject.optString("userName");
      this.hKN = paramJSONObject.optString("title");
      this.hKO = paramJSONObject.optString("subTitle");
      this.hKP = paramJSONObject.optString("headimgUrl");
      a(paramv, parama);
    }
    AppMethodBeat.o(131024);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(131022);
    if ((paramc instanceof r))
    {
      paramc = (r)paramc;
      v localv = paramc.getCurrentPageView();
      if (localv == null)
      {
        ab.i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact enterChatting fail, pageView is null");
        paramc.h(paramInt, j("fail:current page do not exist", null));
        AppMethodBeat.o(131022);
        return;
      }
      a(localv, paramc, paramJSONObject, paramInt);
      AppMethodBeat.o(131022);
      return;
    }
    if ((paramc instanceof v))
    {
      a((v)paramc, paramc, paramJSONObject, paramInt);
      AppMethodBeat.o(131022);
      return;
    }
    ab.w("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact not support");
    AppMethodBeat.o(131022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.f
 * JD-Core Version:    0.7.0.1
 */