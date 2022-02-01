package com.tencent.mm.plugin.appbrand.jsapi.pay;

import android.app.Activity;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.base.ReportSubmitFormTask;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.l;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.o;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.Map;
import org.apache.commons.b.g;
import org.json.JSONObject;

public class n
  extends com.tencent.mm.plugin.appbrand.jsapi.d<com.tencent.mm.plugin.appbrand.jsapi.k>
{
  public static final int CTRL_INDEX = 57;
  public static final String NAME = "requestPayment";
  
  public void a(final com.tencent.mm.plugin.appbrand.jsapi.k paramk, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(226965);
    if (paramJSONObject == null)
    {
      paramk.i(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(226965);
      return;
    }
    q localq = (q)paramk.getRuntime();
    Activity localActivity = AndroidContextUtil.castActivityOrNull(localq.mContext);
    if (localActivity == null)
    {
      paramk.i(paramInt, h("fail:internal error invalid android context", null));
      AppMethodBeat.o(226965);
      return;
    }
    Object localObject = g.id(localq.bsD().getCurrentUrl(), 1024);
    String str = localq.bsC().username;
    try
    {
      if ((paramJSONObject.optBoolean("useCustomAppId", false)) && ((paramk instanceof com.tencent.mm.plugin.appbrand.service.c)))
      {
        AppBrandJsApiPayUtils localAppBrandJsApiPayUtils = AppBrandJsApiPayUtils.mlZ;
        if (AppBrandJsApiPayUtils.c((com.tencent.mm.plugin.appbrand.service.c)paramk))
        {
          localObject = AppBrandJsApiPayUtils.mlZ;
          if (AppBrandJsApiPayUtils.c((com.tencent.mm.plugin.appbrand.service.c)paramk, paramJSONObject.optString("appId")))
          {
            localObject = (IPCString)XIPCInvoker.a(MainProcessIPCService.dkO, new IPCString(paramJSONObject.optString("appId")), a.class);
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
        localObject = new PString();
        if (AppBrandJsApiPayService.mlD.startPay(localActivity, paramk, localq.ON().cyA, paramJSONObject, new a.c()
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
              paramk.i(paramInt, n.this.h("ok", null));
              AppMethodBeat.o(46732);
              return;
              paramk.i(paramInt, n.this.h("fail:".concat(String.valueOf(paramAnonymousString)), null));
              AppMethodBeat.o(46732);
              return;
              paramk.i(paramInt, n.this.h("fail cancel", null));
            }
          }
          
          public final void b(int paramAnonymousInt, String paramAnonymousString, Map<String, Object> paramAnonymousMap)
          {
            AppMethodBeat.i(226963);
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
              paramAnonymousString = n.this.n(paramAnonymousString, paramAnonymousMap);
              localObject = ((l)localObject).naC;
              paramAnonymousMap = (com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.p)paramk;
              paramAnonymousInt = paramInt;
              kotlin.g.b.p.h(paramAnonymousMap, "component");
              kotlin.g.b.p.h(paramAnonymousString, "callbackStr");
              localObject = ((com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.c)localObject).nar;
              if (localObject == null) {
                kotlin.g.b.p.btv("invokeProcess");
              }
              ((o)localObject).b(paramAnonymousMap, paramAnonymousInt, paramAnonymousString);
              AppMethodBeat.o(226963);
              return;
              AppMethodBeat.o(226963);
              return;
              paramAnonymousString = "ok";
              continue;
              paramAnonymousString = "fail:".concat(String.valueOf(paramAnonymousString));
            }
          }
        }, (PString)localObject)) {
          break label394;
        }
        paramk.i(paramInt, h("fail", null));
        AppMethodBeat.o(226965);
        return;
        localObject = ((IPCString)localObject).value;
        break;
        Log.i("MicroMsg.JsApiRequestPayment", "use custom illegal appId:%s ");
        paramk.i(paramInt, h("fail illegal appId", null));
        AppMethodBeat.o(226965);
        return;
        paramJSONObject.put("appId", paramk.getAppId());
        paramJSONObject.put("key_appbrand_from_path", localObject);
        paramJSONObject.put("key_appbrand_from_username", str);
      }
      if (!paramJSONObject.optBoolean("grantMessageQuota", true)) {
        break label475;
      }
    }
    catch (Exception paramJSONObject)
    {
      Log.e("MicroMsg.JsApiRequestPayment", paramJSONObject.getMessage());
      paramk.i(paramInt, h("fail", null));
      AppMethodBeat.o(226965);
      return;
    }
    label394:
    if ((paramk instanceof ac)) {}
    for (paramk = (ac)paramk;; paramk = ((s)paramk).getCurrentPageView())
    {
      paramJSONObject = ((PString)localObject).value;
      if (paramk != null)
      {
        localObject = new ReportSubmitFormTask(paramk.getRuntime().OT());
        ((ReportSubmitFormTask)localObject).type = 0;
        ((ReportSubmitFormTask)localObject).lKc = paramJSONObject.replace("prepay_id=", "");
        ((ReportSubmitFormTask)localObject).pageId = paramk.lBI;
        AppBrandMainProcessService.a((MainProcessTask)localObject);
      }
      label475:
      AppMethodBeat.o(226965);
      return;
    }
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.k<IPCString, IPCString>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.pay.n
 * JD-Core Version:    0.7.0.1
 */