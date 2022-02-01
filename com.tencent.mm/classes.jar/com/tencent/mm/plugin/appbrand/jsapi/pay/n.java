package com.tencent.mm.plugin.appbrand.jsapi.pay;

import android.app.Activity;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.base.ReportSubmitFormTask;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.l;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.o;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.p;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.Map;
import kotlin.g.b.s;
import org.apache.commons.c.i;
import org.json.JSONObject;

public class n
  extends com.tencent.mm.plugin.appbrand.jsapi.c<k>
{
  public static final int CTRL_INDEX = 57;
  public static final String NAME = "requestPayment";
  
  public void a(final k paramk, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(327840);
    if (paramJSONObject == null)
    {
      paramk.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(327840);
      return;
    }
    w localw = (w)paramk.getRuntime();
    Activity localActivity = AndroidContextUtil.castActivityOrNull(localw.mContext);
    if (localActivity == null)
    {
      paramk.callback(paramInt, ZP("fail:internal error invalid android context"));
      AppMethodBeat.o(327840);
      return;
    }
    Object localObject = i.bD(localw.ccN().getCurrentUrl(), 0, 1024);
    String str = localw.getInitConfig().username;
    try
    {
      if ((paramJSONObject.optBoolean("useCustomAppId", false)) && ((paramk instanceof com.tencent.mm.plugin.appbrand.service.c)))
      {
        AppBrandJsApiPayUtils localAppBrandJsApiPayUtils = AppBrandJsApiPayUtils.sph;
        if (AppBrandJsApiPayUtils.d((com.tencent.mm.plugin.appbrand.service.c)paramk))
        {
          localObject = AppBrandJsApiPayUtils.sph;
          if (AppBrandJsApiPayUtils.c((com.tencent.mm.plugin.appbrand.service.c)paramk, paramJSONObject.optString("appId")))
          {
            localObject = (IPCString)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCString(paramJSONObject.optString("appId")), a.class);
            if (localObject == null)
            {
              localObject = null;
              paramJSONObject.put("key_appbrand_from_username", localObject);
              Log.i("MicroMsg.JsApiRequestPayment", "use custom appId:%s key_appbrand_from_path:%s key_appbrand_from_username:%s", new Object[] { paramJSONObject.optString("appId"), paramJSONObject.optString("key_appbrand_from_path"), localObject });
            }
          }
        }
      }
      for (;;)
      {
        paramJSONObject.put("key_chat_type", localw.getInitConfig().epn.chatType);
        localObject = new PString();
        if (AppBrandJsApiPayService.soM.startPay(localActivity, paramk, localw.asA().epn, paramJSONObject, new a.c()
        {
          public final void a(int paramAnonymousInt, String paramAnonymousString, Map<String, Object> paramAnonymousMap)
          {
            AppMethodBeat.i(46732);
            switch (paramAnonymousInt)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(46732);
              return;
              paramk.callback(paramInt, n.this.ZP("ok"));
              AppMethodBeat.o(46732);
              return;
              paramk.callback(paramInt, n.this.ZP("fail:".concat(String.valueOf(paramAnonymousString))));
              AppMethodBeat.o(46732);
              return;
              paramk.callback(paramInt, n.this.ZP("fail cancel"));
            }
          }
          
          public final void b(int paramAnonymousInt, String paramAnonymousString, Map<String, Object> paramAnonymousMap)
          {
            AppMethodBeat.i(327820);
            Object localObject;
            if ((paramk.getRuntime() instanceof l))
            {
              localObject = (l)paramk.getRuntime();
              switch (paramAnonymousInt)
              {
              default: 
                paramAnonymousString = "fail cancel";
              }
            }
            for (;;)
            {
              String str = n.this.m(paramAnonymousString, paramAnonymousMap);
              paramAnonymousString = ((l)localObject).tfX;
              localObject = (p)paramk;
              paramAnonymousInt = paramInt;
              s.u(localObject, "component");
              s.u(str, "callbackStr");
              paramAnonymousMap = paramAnonymousString.tfO;
              paramAnonymousString = paramAnonymousMap;
              if (paramAnonymousMap == null)
              {
                s.bIx("invokeProcess");
                paramAnonymousString = null;
              }
              paramAnonymousString.b((p)localObject, paramAnonymousInt, str);
              AppMethodBeat.o(327820);
              return;
              AppMethodBeat.o(327820);
              return;
              paramAnonymousString = "ok";
              continue;
              paramAnonymousString = "fail:".concat(String.valueOf(paramAnonymousString));
            }
          }
        }, (PString)localObject)) {
          break label408;
        }
        paramk.callback(paramInt, ZP("fail"));
        AppMethodBeat.o(327840);
        return;
        localObject = ((IPCString)localObject).value;
        break;
        Log.i("MicroMsg.JsApiRequestPayment", "use custom illegal appId:%s ");
        paramk.callback(paramInt, ZP("fail illegal appId"));
        AppMethodBeat.o(327840);
        return;
        paramJSONObject.put("appId", paramk.getAppId());
        paramJSONObject.put("key_appbrand_from_path", localObject);
        paramJSONObject.put("key_appbrand_from_username", str);
      }
      if (!paramJSONObject.optBoolean("grantMessageQuota", true)) {
        break label489;
      }
    }
    catch (Exception paramJSONObject)
    {
      Log.e("MicroMsg.JsApiRequestPayment", paramJSONObject.getMessage());
      paramk.callback(paramInt, ZP("fail"));
      AppMethodBeat.o(327840);
      return;
    }
    label408:
    if ((paramk instanceof ad)) {}
    for (paramk = (ad)paramk;; paramk = ((com.tencent.mm.plugin.appbrand.y)paramk).getCurrentPageView())
    {
      paramJSONObject = ((PString)localObject).value;
      if (paramk != null)
      {
        localObject = new ReportSubmitFormTask(paramk.getRuntime().asG());
        ((ReportSubmitFormTask)localObject).type = 0;
        ((ReportSubmitFormTask)localObject).rJr = paramJSONObject.replace("prepay_id=", "");
        ((ReportSubmitFormTask)localObject).hUf = paramk.cgR();
        ((ReportSubmitFormTask)localObject).bQt();
      }
      label489:
      AppMethodBeat.o(327840);
      return;
    }
  }
  
  static class a
    implements m<IPCString, IPCString>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.pay.n
 * JD-Core Version:    0.7.0.1
 */