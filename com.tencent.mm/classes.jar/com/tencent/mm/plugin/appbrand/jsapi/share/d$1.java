package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.jsapi.t.a;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.s;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  d$1(d paramd, p paramp, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt2, boolean paramBoolean1, String paramString7, AppBrandSysConfigWC paramAppBrandSysConfigWC, String paramString8, s params, String paramString9, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString10, String paramString11, int paramInt3, MMActivity paramMMActivity) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 1) {
      y.i("MicroMsg.JsApiShareAppMessageDirectly", "requestCode(%d) not corrected.", new Object[] { Integer.valueOf(paramInt1) });
    }
    label522:
    label597:
    label608:
    label636:
    for (;;)
    {
      return;
      if (paramInt2 != -1)
      {
        y.i("MicroMsg.JsApiShareAppMessageDirectly", "resultCode is not RESULT_OK(%d)", new Object[] { Integer.valueOf(paramInt2) });
        this.gbW.C(this.dIS, this.gBA.h("cancel", null));
        return;
      }
      if (paramIntent == null) {}
      for (String str = null; (str == null) || (str.length() == 0); str = paramIntent.getStringExtra("Select_Conv_User"))
      {
        y.e("MicroMsg.JsApiShareAppMessageDirectly", "mmOnActivityResult fail, toUser is null");
        this.gbW.C(this.dIS, this.gBA.h("fail:selected user is nil", null));
        return;
      }
      y.i("MicroMsg.JsApiShareAppMessageDirectly", "result success toUser : %s ", new Object[] { str });
      paramIntent = paramIntent.getStringExtra("custom_send_text");
      final SendAppMessageTask localSendAppMessageTask = new SendAppMessageTask();
      localSendAppMessageTask.gBE = paramIntent;
      localSendAppMessageTask.toUser = str;
      localSendAppMessageTask.appId = this.val$appId;
      localSendAppMessageTask.userName = this.egy;
      localSendAppMessageTask.title = this.dYK;
      localSendAppMessageTask.description = this.gBn;
      localSendAppMessageTask.url = this.gBo;
      localSendAppMessageTask.path = this.gBl;
      localSendAppMessageTask.type = this.bns;
      localSendAppMessageTask.gpR = this.gBr;
      localSendAppMessageTask.gBF = this.gBp;
      localSendAppMessageTask.iconUrl = this.gpV.fPM;
      localSendAppMessageTask.bOa = this.gpV.fPS.fEM;
      localSendAppMessageTask.fRx = this.gpV.fPS.bIW;
      localSendAppMessageTask.version = this.gpV.fPS.fEN;
      localSendAppMessageTask.nickname = this.gpV.bJw;
      localSendAppMessageTask.caG = this.gBz;
      localSendAppMessageTask.gBH = m.qI(this.val$appId).fzu.getAndIncrement();
      localSendAppMessageTask.gBJ = this.gfM.getURL();
      localSendAppMessageTask.gBK = this.gfM.agX();
      paramIntent = this.gfM.getRuntime().aab();
      if (paramIntent != null)
      {
        if (paramIntent.scene == 0)
        {
          paramInt1 = 1000;
          localSendAppMessageTask.scene = paramInt1;
          localSendAppMessageTask.bFv = bk.pm(paramIntent.bFv);
          localSendAppMessageTask.gBI = bk.pm(this.gfM.getRuntime().aac().fJO);
        }
      }
      else
      {
        localSendAppMessageTask.gBG = k.getRealPath(this.gBs);
        localSendAppMessageTask.withShareTicket = this.gBm;
        localSendAppMessageTask.gBL = this.gBt;
        localSendAppMessageTask.gBM = this.gBu;
        localSendAppMessageTask.dRD = this.gBq;
        localSendAppMessageTask.fWw = this.eal;
        localSendAppMessageTask.dWx = this.gBv;
        paramIntent = this.gfM.ans();
        if (paramIntent != null) {
          break label597;
        }
        paramIntent = "";
        localSendAppMessageTask.gBN = paramIntent;
        if (!this.gBm) {
          break label608;
        }
        localSendAppMessageTask.gfD = new Runnable()
        {
          public final void run()
          {
            y.i("MicroMsg.JsApiShareAppMessageDirectly", "task callback");
            localSendAppMessageTask.ahD();
            HashMap localHashMap = new HashMap();
            JSONArray localJSONArray = new JSONArray();
            try
            {
              if (!bk.dk(localSendAppMessageTask.gBO))
              {
                Iterator localIterator = localSendAppMessageTask.gBO.iterator();
                while (localIterator.hasNext())
                {
                  ShareInfo localShareInfo = (ShareInfo)localIterator.next();
                  JSONObject localJSONObject = new JSONObject();
                  localJSONObject.put("shareKey", localShareInfo.dTX);
                  localJSONObject.put("shareName", localShareInfo.dZN);
                  localJSONArray.put(localJSONObject);
                }
              }
              return;
            }
            catch (JSONException localJSONException)
            {
              y.e("MicroMsg.JsApiShareAppMessageDirectly", Log.getStackTraceString(localJSONException));
              localHashMap.put("shareInfos", localJSONArray);
              d.1.this.gbW.C(d.1.this.dIS, d.1.this.gBA.h("ok", localHashMap));
            }
          }
        };
        localSendAppMessageTask.ahC();
        AppBrandMainProcessService.a(localSendAppMessageTask);
      }
      for (;;)
      {
        if (this.byc == null) {
          break label636;
        }
        h.bC(this.byc, this.byc.getResources().getString(y.j.app_brand_app_msg_shared));
        return;
        paramInt1 = paramIntent.scene;
        break;
        paramIntent = paramIntent.getWebView().getUrl();
        break label522;
        AppBrandMainProcessService.a(localSendAppMessageTask);
        this.gbW.C(this.dIS, this.gBA.h("ok", null));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.d.1
 * JD-Core Version:    0.7.0.1
 */