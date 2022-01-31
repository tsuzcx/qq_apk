package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.u.a;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class d$1
  implements MMActivity.a
{
  d$1(d paramd, c paramc, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt2, boolean paramBoolean1, String paramString7, AppBrandSysConfigWC paramAppBrandSysConfigWC, String paramString8, z paramz, String paramString9, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString10, String paramString11, int paramInt3, d.a parama, String paramString12, String paramString13, String paramString14, String paramString15, MMActivity paramMMActivity) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(131444);
    if (paramInt1 != 1)
    {
      ab.i("MicroMsg.JsApiShareAppMessageDirectly", "requestCode(%d) not corrected.", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(131444);
      return;
    }
    if (paramInt2 != -1)
    {
      ab.i("MicroMsg.JsApiShareAppMessageDirectly", "resultCode is not RESULT_OK(%d)", new Object[] { Integer.valueOf(paramInt2) });
      this.hxC.h(this.bAX, this.hZC.j("cancel", null));
      AppMethodBeat.o(131444);
      return;
    }
    if (paramIntent == null) {}
    for (String str = null; (str == null) || (str.length() == 0); str = paramIntent.getStringExtra("Select_Conv_User"))
    {
      ab.e("MicroMsg.JsApiShareAppMessageDirectly", "mmOnActivityResult fail, toUser is null");
      this.hxC.h(this.bAX, this.hZC.j("fail:selected user is nil", null));
      AppMethodBeat.o(131444);
      return;
    }
    ab.i("MicroMsg.JsApiShareAppMessageDirectly", "result success toUser : %s ", new Object[] { str });
    paramIntent = paramIntent.getStringExtra("custom_send_text");
    final SendAppMessageTask localSendAppMessageTask = new SendAppMessageTask();
    localSendAppMessageTask.hZN = paramIntent;
    localSendAppMessageTask.toUser = str;
    localSendAppMessageTask.appId = this.val$appId;
    paramIntent = this.hxC.getRuntime();
    if ((paramIntent != null) && (paramIntent.wZ() != null) && ((paramIntent.wZ() instanceof AppBrandInitConfigWC)))
    {
      localSendAppMessageTask.bDc = ((AppBrandInitConfigWC)paramIntent.wZ()).bDc;
      localSendAppMessageTask.userName = this.fwC;
      localSendAppMessageTask.title = this.cbK;
      localSendAppMessageTask.description = this.hZi;
      localSendAppMessageTask.url = this.hZj;
      localSendAppMessageTask.path = this.hZg;
      localSendAppMessageTask.type = this.bHS;
      localSendAppMessageTask.hKA = this.hZm;
      localSendAppMessageTask.hZO = this.hZk;
      localSendAppMessageTask.iconUrl = this.hKF.hiQ;
      localSendAppMessageTask.cvs = this.hKF.hiX.gXe;
      localSendAppMessageTask.hko = this.hKF.hiX.cqq;
      localSendAppMessageTask.version = this.hKF.hiX.gXf;
      localSendAppMessageTask.nickname = this.hKF.cqQ;
      localSendAppMessageTask.cJg = this.hZw;
      localSendAppMessageTask.hZT = n.yd(this.val$appId).gQW.getAndIncrement();
      localSendAppMessageTask.hZV = this.hKE.hzM;
      localSendAppMessageTask.hZW = this.hKE.aAI();
      paramIntent = this.hKE.getRuntime().wS().bDh;
      if (paramIntent != null)
      {
        if (paramIntent.scene != 0) {
          break label754;
        }
        paramInt1 = 1000;
        label468:
        localSendAppMessageTask.scene = paramInt1;
        localSendAppMessageTask.cmF = bo.nullAsNil(paramIntent.cmF);
        localSendAppMessageTask.hZU = bo.nullAsNil(this.hKE.getRuntime().atS().vZ());
      }
      localSendAppMessageTask.hZP = l.getRealPath(this.hZn);
      localSendAppMessageTask.withShareTicket = this.hZh;
      localSendAppMessageTask.hZX = this.hZo;
      localSendAppMessageTask.hZY = this.hZp;
      localSendAppMessageTask.fhC = this.hZl;
      localSendAppMessageTask.cacheKey = this.cbQ;
      localSendAppMessageTask.fmF = this.hZq;
      paramIntent = this.hKE.aJz();
      if (paramIntent != null) {
        break label762;
      }
      paramIntent = "";
      label589:
      localSendAppMessageTask.iaa = paramIntent;
      if (this.hZx == d.a.hZF)
      {
        localSendAppMessageTask.hZR = 4;
        localSendAppMessageTask.hZZ = true;
        localSendAppMessageTask.videoPath = l.getRealPath(this.hZy);
        localSendAppMessageTask.iaf = l.getRealPath(this.hZz);
        localSendAppMessageTask.cHH = this.hZA;
        localSendAppMessageTask.iag = this.hZB;
        localSendAppMessageTask.hZP = l.getRealPath(this.hZz);
      }
      if (!this.hZh) {
        break label773;
      }
      localSendAppMessageTask.hxp = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(131443);
          ab.i("MicroMsg.JsApiShareAppMessageDirectly", "task callback");
          localSendAppMessageTask.aBk();
          HashMap localHashMap = new HashMap();
          JSONArray localJSONArray = new JSONArray();
          try
          {
            if (!bo.es(localSendAppMessageTask.iah))
            {
              Iterator localIterator = localSendAppMessageTask.iah.iterator();
              while (localIterator.hasNext())
              {
                ShareInfo localShareInfo = (ShareInfo)localIterator.next();
                JSONObject localJSONObject = new JSONObject();
                localJSONObject.put("shareKey", localShareInfo.bCZ);
                localJSONObject.put("shareName", localShareInfo.bCY);
                localJSONArray.put(localJSONObject);
              }
            }
            return;
          }
          catch (JSONException localJSONException)
          {
            ab.e("MicroMsg.JsApiShareAppMessageDirectly", Log.getStackTraceString(localJSONException));
            localHashMap.put("shareInfos", localJSONArray);
            d.1.this.hxC.h(d.1.this.bAX, d.1.this.hZC.j("ok", localHashMap));
            AppMethodBeat.o(131443);
          }
        }
      };
      localSendAppMessageTask.aBj();
      AppBrandMainProcessService.a(localSendAppMessageTask);
    }
    for (;;)
    {
      if (this.cae != null) {
        h.bO(this.cae, this.cae.getResources().getString(2131296571));
      }
      AppMethodBeat.o(131444);
      return;
      ab.w("MicroMsg.JsApiShareAppMessageDirectly", "hy: can not retrieve init config");
      localSendAppMessageTask.bDc = -1;
      break;
      label754:
      paramInt1 = paramIntent.scene;
      break label468;
      label762:
      paramIntent = paramIntent.getWebView().getUrl();
      break label589;
      label773:
      AppBrandMainProcessService.a(localSendAppMessageTask);
      this.hxC.h(this.bAX, this.hZC.j("ok", null));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.d.1
 * JD-Core Version:    0.7.0.1
 */