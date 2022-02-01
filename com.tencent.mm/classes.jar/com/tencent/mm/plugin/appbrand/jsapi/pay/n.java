package com.tencent.mm.plugin.appbrand.jsapi.pay;

import android.app.Activity;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.base.ReportSubmitFormTask;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.l;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Map;
import org.json.JSONObject;

public class n
  extends com.tencent.mm.plugin.appbrand.jsapi.a<h>
{
  public static final int CTRL_INDEX = 57;
  public static final String NAME = "requestPayment";
  
  public void a(final h paramh, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(188505);
    if (paramJSONObject == null)
    {
      paramh.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(188505);
      return;
    }
    com.tencent.mm.plugin.appbrand.o localo = (com.tencent.mm.plugin.appbrand.o)paramh.getRuntime();
    Activity localActivity = com.tencent.mm.sdk.f.a.jq(localo.mContext);
    if (localActivity == null)
    {
      paramh.h(paramInt, e("fail:internal error invalid android context", null));
      AppMethodBeat.o(188505);
      return;
    }
    Object localObject = localo.aXd().getCurrentUrl();
    String str = localo.aXc().username;
    try
    {
      paramJSONObject.put("appId", paramh.getAppId());
      paramJSONObject.put("key_appbrand_from_path", localObject);
      paramJSONObject.put("key_appbrand_from_username", str);
      localObject = new PString();
      if (!AppBrandJsApiPayService.lcw.startPay(localActivity, paramh, localo.Fb().cmC, paramJSONObject, new a.c()
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
            paramh.h(paramInt, n.this.e("ok", null));
            AppMethodBeat.o(46732);
            return;
            paramh.h(paramInt, n.this.e("fail:".concat(String.valueOf(paramAnonymousString)), null));
            AppMethodBeat.o(46732);
            return;
            paramh.h(paramInt, n.this.e("fail cancel", null));
          }
        }
        
        public final void b(int paramAnonymousInt, String paramAnonymousString, Map<String, Object> paramAnonymousMap)
        {
          AppMethodBeat.i(188504);
          Object localObject;
          if ((paramh.getRuntime() instanceof l))
          {
            localObject = (l)paramh.getRuntime();
            switch (paramAnonymousInt)
            {
            default: 
              paramAnonymousString = "fail cancel";
            }
          }
          for (;;)
          {
            paramAnonymousString = n.this.m(paramAnonymousString, paramAnonymousMap);
            localObject = ((l)localObject).lOz;
            paramAnonymousMap = (com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.p)paramh;
            paramAnonymousInt = paramInt;
            d.g.b.p.h(paramAnonymousMap, "component");
            d.g.b.p.h(paramAnonymousString, "callbackStr");
            localObject = ((com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.c)localObject).lOp;
            if (localObject == null) {
              d.g.b.p.bcb("invokeProcess");
            }
            ((com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.o)localObject).b(paramAnonymousMap, paramAnonymousInt, paramAnonymousString);
            AppMethodBeat.o(188504);
            return;
            AppMethodBeat.o(188504);
            return;
            paramAnonymousString = "ok";
            continue;
            paramAnonymousString = "fail:".concat(String.valueOf(paramAnonymousString));
          }
        }
      }, (PString)localObject))
      {
        paramh.h(paramInt, e("fail", null));
        AppMethodBeat.o(188505);
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      ad.e("MicroMsg.JsApiRequestPayment", paramJSONObject.getMessage());
      paramh.h(paramInt, e("fail", null));
      AppMethodBeat.o(188505);
      return;
    }
    if (paramJSONObject.optBoolean("grantMessageQuota", true)) {
      if (!(paramh instanceof aa)) {
        break label305;
      }
    }
    label305:
    for (paramh = (aa)paramh;; paramh = ((q)paramh).getCurrentPageView())
    {
      paramJSONObject = ((PString)localObject).value;
      if (paramh != null)
      {
        localObject = new ReportSubmitFormTask(paramh.getRuntime().Fh());
        ((ReportSubmitFormTask)localObject).type = 0;
        ((ReportSubmitFormTask)localObject).kCm = paramJSONObject.replace("prepay_id=", "");
        ((ReportSubmitFormTask)localObject).pageId = paramh.kuf;
        AppBrandMainProcessService.a((MainProcessTask)localObject);
      }
      AppMethodBeat.o(188505);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.pay.n
 * JD-Core Version:    0.7.0.1
 */