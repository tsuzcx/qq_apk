package com.tencent.mm.plugin.appbrand.jsapi.pay;

import android.app.Activity;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.base.ReportSubmitFormTask;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.c;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.l;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.o;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Map;
import org.json.JSONObject;

public class n
  extends com.tencent.mm.plugin.appbrand.jsapi.a<h>
{
  public static final int CTRL_INDEX = 57;
  public static final String NAME = "requestPayment";
  
  public void a(final h paramh, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(222655);
    if (paramJSONObject == null)
    {
      paramh.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(222655);
      return;
    }
    com.tencent.mm.plugin.appbrand.p localp = (com.tencent.mm.plugin.appbrand.p)paramh.getRuntime();
    Activity localActivity = com.tencent.mm.sdk.f.a.jw(localp.mContext);
    if (localActivity == null)
    {
      paramh.h(paramInt, e("fail:internal error invalid android context", null));
      AppMethodBeat.o(222655);
      return;
    }
    Object localObject = localp.aXy().getCurrentUrl();
    String str = localp.aXx().username;
    try
    {
      paramJSONObject.put("appId", paramh.getAppId());
      paramJSONObject.put("key_appbrand_from_path", localObject);
      paramJSONObject.put("key_appbrand_from_username", str);
      localObject = new PString();
      if (!AppBrandJsApiPayService.lgh.startPay(localActivity, paramh, localp.Fg().cmE, paramJSONObject, new a.c()
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
          AppMethodBeat.i(222654);
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
            paramAnonymousString = n.this.n(paramAnonymousString, paramAnonymousMap);
            localObject = ((l)localObject).lTa;
            paramAnonymousMap = (com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.p)paramh;
            paramAnonymousInt = paramInt;
            d.g.b.p.h(paramAnonymousMap, "component");
            d.g.b.p.h(paramAnonymousString, "callbackStr");
            localObject = ((c)localObject).lSQ;
            if (localObject == null) {
              d.g.b.p.bdF("invokeProcess");
            }
            ((o)localObject).b(paramAnonymousMap, paramAnonymousInt, paramAnonymousString);
            AppMethodBeat.o(222654);
            return;
            AppMethodBeat.o(222654);
            return;
            paramAnonymousString = "ok";
            continue;
            paramAnonymousString = "fail:".concat(String.valueOf(paramAnonymousString));
          }
        }
      }, (PString)localObject))
      {
        paramh.h(paramInt, e("fail", null));
        AppMethodBeat.o(222655);
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      ae.e("MicroMsg.JsApiRequestPayment", paramJSONObject.getMessage());
      paramh.h(paramInt, e("fail", null));
      AppMethodBeat.o(222655);
      return;
    }
    if (paramJSONObject.optBoolean("grantMessageQuota", true)) {
      if (!(paramh instanceof z)) {
        break label305;
      }
    }
    label305:
    for (paramh = (z)paramh;; paramh = ((r)paramh).getCurrentPageView())
    {
      paramJSONObject = ((PString)localObject).value;
      if (paramh != null)
      {
        localObject = new ReportSubmitFormTask(paramh.getRuntime().Fm());
        ((ReportSubmitFormTask)localObject).type = 0;
        ((ReportSubmitFormTask)localObject).kFB = paramJSONObject.replace("prepay_id=", "");
        ((ReportSubmitFormTask)localObject).pageId = paramh.kxv;
        AppBrandMainProcessService.a((MainProcessTask)localObject);
      }
      AppMethodBeat.o(222655);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.pay.n
 * JD-Core Version:    0.7.0.1
 */