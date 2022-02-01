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
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.l;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.Map;
import org.apache.commons.b.g;
import org.json.JSONObject;

public class n
  extends com.tencent.mm.plugin.appbrand.jsapi.c<j>
{
  public static final int CTRL_INDEX = 57;
  public static final String NAME = "requestPayment";
  
  public void a(final j paramj, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(268117);
    if (paramJSONObject == null)
    {
      paramj.j(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(268117);
      return;
    }
    t localt = (t)paramj.getRuntime();
    Activity localActivity = AndroidContextUtil.castActivityOrNull(localt.mContext);
    if (localActivity == null)
    {
      paramj.j(paramInt, h("fail:internal error invalid android context", null));
      AppMethodBeat.o(268117);
      return;
    }
    Object localObject = g.bh(localt.bDz().getCurrentUrl(), 0, 1024);
    String str = localt.bDy().username;
    try
    {
      if ((paramJSONObject.optBoolean("useCustomAppId", false)) && ((paramj instanceof com.tencent.mm.plugin.appbrand.service.c)))
      {
        AppBrandJsApiPayUtils localAppBrandJsApiPayUtils = AppBrandJsApiPayUtils.pke;
        if (AppBrandJsApiPayUtils.d((com.tencent.mm.plugin.appbrand.service.c)paramj))
        {
          localObject = AppBrandJsApiPayUtils.pke;
          if (AppBrandJsApiPayUtils.c((com.tencent.mm.plugin.appbrand.service.c)paramj, paramJSONObject.optString("appId")))
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
        paramJSONObject.put("key_chat_type", localt.bDy().cxf.chatType);
        localObject = new PString();
        if (AppBrandJsApiPayService.pjI.startPay(localActivity, paramj, localt.Sk().cxf, paramJSONObject, new a.c()
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
              paramj.j(paramInt, n.this.h("ok", null));
              AppMethodBeat.o(46732);
              return;
              paramj.j(paramInt, n.this.h("fail:".concat(String.valueOf(paramAnonymousString)), null));
              AppMethodBeat.o(46732);
              return;
              paramj.j(paramInt, n.this.h("fail cancel", null));
            }
          }
          
          public final void b(int paramAnonymousInt, String paramAnonymousString, Map<String, Object> paramAnonymousMap)
          {
            AppMethodBeat.i(243134);
            Object localObject;
            if ((paramj.getRuntime() instanceof l))
            {
              localObject = (l)paramj.getRuntime();
              switch (paramAnonymousInt)
              {
              default: 
                paramAnonymousString = "fail cancel";
              }
            }
            for (;;)
            {
              paramAnonymousString = n.this.m(paramAnonymousString, paramAnonymousMap);
              localObject = ((l)localObject).qaR;
              paramAnonymousMap = (com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.p)paramj;
              paramAnonymousInt = paramInt;
              kotlin.g.b.p.k(paramAnonymousMap, "component");
              kotlin.g.b.p.k(paramAnonymousString, "callbackStr");
              localObject = ((com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.c)localObject).qaG;
              if (localObject == null) {
                kotlin.g.b.p.bGy("invokeProcess");
              }
              ((com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.o)localObject).b(paramAnonymousMap, paramAnonymousInt, paramAnonymousString);
              AppMethodBeat.o(243134);
              return;
              AppMethodBeat.o(243134);
              return;
              paramAnonymousString = "ok";
              continue;
              paramAnonymousString = "fail:".concat(String.valueOf(paramAnonymousString));
            }
          }
        }, (PString)localObject)) {
          break label413;
        }
        paramj.j(paramInt, h("fail", null));
        AppMethodBeat.o(268117);
        return;
        localObject = ((IPCString)localObject).value;
        break;
        Log.i("MicroMsg.JsApiRequestPayment", "use custom illegal appId:%s ");
        paramj.j(paramInt, h("fail illegal appId", null));
        AppMethodBeat.o(268117);
        return;
        paramJSONObject.put("appId", paramj.getAppId());
        paramJSONObject.put("key_appbrand_from_path", localObject);
        paramJSONObject.put("key_appbrand_from_username", str);
      }
      if (!paramJSONObject.optBoolean("grantMessageQuota", true)) {
        break label494;
      }
    }
    catch (Exception paramJSONObject)
    {
      Log.e("MicroMsg.JsApiRequestPayment", paramJSONObject.getMessage());
      paramj.j(paramInt, h("fail", null));
      AppMethodBeat.o(268117);
      return;
    }
    label413:
    if ((paramj instanceof ad)) {}
    for (paramj = (ad)paramj;; paramj = ((v)paramj).getCurrentPageView())
    {
      paramJSONObject = ((PString)localObject).value;
      if (paramj != null)
      {
        localObject = new ReportSubmitFormTask(paramj.getRuntime().Sp());
        ((ReportSubmitFormTask)localObject).type = 0;
        ((ReportSubmitFormTask)localObject).oGs = paramJSONObject.replace("prepay_id=", "");
        ((ReportSubmitFormTask)localObject).pageId = paramj.oxe;
        ((ReportSubmitFormTask)localObject).bsM();
      }
      label494:
      AppMethodBeat.o(268117);
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