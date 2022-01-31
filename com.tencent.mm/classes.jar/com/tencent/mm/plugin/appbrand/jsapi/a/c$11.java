package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.y.d;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.protocal.c.aru;
import com.tencent.mm.protocal.c.bna;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import org.json.JSONException;
import org.json.JSONObject;

final class c$11
  implements b.a
{
  c$11(c paramc) {}
  
  public final void a(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ah.b paramb)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramb.ecF.ecN == null))
    {
      y.e("MicroMsg.JsApiGetPhoneNumber", "getPhoneNumber JsOperateWxData cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramb.ecF.ecN });
      this.gkx.gkh.C(this.gkx.gfg, this.gkx.h("fail:JsOperateWxData cgi fail", null));
      return;
    }
    y.i("MicroMsg.JsApiGetPhoneNumber", "JsOperateWxData success");
    paramString = (aru)paramb.ecF.ecN;
    this.gkx.gkh.getContentView().post(new Runnable()
    {
      public final void run()
      {
        c localc = c.11.this.gkx;
        Object localObject1 = paramString;
        y.i("MicroMsg.JsApiGetPhoneNumber", "handleOperateWxData");
        Object localObject2 = "";
        if (((aru)localObject1).hPF != null) {
          localObject2 = ((aru)localObject1).hPF.coM();
        }
        y.i("MicroMsg.JsApiGetPhoneNumber", "resp data:%s", new Object[] { localObject2 });
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          y.e("MicroMsg.JsApiGetPhoneNumber", "resp data is empty");
          localc.gkh.C(localc.gfg, localc.h("fail:resp data is empty", null));
          return;
        }
        String str2 = ((aru)localObject1).suv;
        String str3 = ((aru)localObject1).kVn;
        String str1;
        if (((aru)localObject1).tni != null)
        {
          str1 = ((aru)localObject1).tni.kRN;
          localc.gkl = ((aru)localObject1).tni.gkl;
          localObject1 = ((aru)localObject1).tni.tmA;
        }
        for (;;)
        {
          y.i("MicroMsg.JsApiGetPhoneNumber", "appName:%s, desc:%s, IconUrl:%s, ext_desc:%s", new Object[] { str3, str1, str2, localc.gkl });
          Object localObject4 = null;
          Object localObject3;
          Object localObject6;
          try
          {
            localObject2 = new JSONObject((String)localObject2);
            if (localObject2 == null)
            {
              y.e("MicroMsg.JsApiGetPhoneNumber", "jsonObj is null");
              localc.gkh.C(localc.gfg, localc.h("fail:jsonObj is null", null));
              return;
            }
          }
          catch (JSONException localJSONException1)
          {
            for (;;)
            {
              y.e("MicroMsg.JsApiGetPhoneNumber", "new data json exception:%s", new Object[] { localJSONException1.getMessage() });
              localObject3 = localObject4;
            }
            localc.gkj = ((JSONObject)localObject3).optString("data");
            localObject6 = ((JSONObject)localObject3).optJSONObject("data");
            localObject4 = localObject6;
            if (localObject6 == null)
            {
              localObject4 = localObject6;
              if (TextUtils.isEmpty(localc.gkj)) {}
            }
          }
          for (;;)
          {
            try
            {
              localObject4 = new JSONObject(localc.gkj);
              if (localObject4 != null)
              {
                localc.bSe = ((JSONObject)localObject4).optString("mobile");
                bool = ((JSONObject)localObject4).optBoolean("need_auth", false);
                localc.gkm = ((JSONObject)localObject4).optBoolean("allow_send_sms", false);
                localc.signature = ((JSONObject)localObject3).optString("signature");
                localc.gkk = ((JSONObject)localObject3).optString("encryptedData");
                localc.aJD = ((JSONObject)localObject3).optString("iv");
                y.i("MicroMsg.JsApiGetPhoneNumber", "mobile:%s, need_auth:%b, allow_send_sms:%b", new Object[] { localc.bSe, Boolean.valueOf(bool), Boolean.valueOf(localc.gkm) });
                if (localc.gkt == 0)
                {
                  if (TextUtils.isEmpty(localc.bSe)) {
                    continue;
                  }
                  if (bool) {
                    localc.gkt = 2;
                  }
                }
                else
                {
                  if (TextUtils.isEmpty(localc.bSe)) {
                    continue;
                  }
                  y.i("MicroMsg.JsApiGetPhoneNumber", "show the confirm login dialog");
                  localObject3 = (LayoutInflater)localc.gkh.mContext.getSystemService("layout_inflater");
                  localObject4 = ((LayoutInflater)localObject3).inflate(y.h.app_brand_get_phone_number_do_login, null);
                  localObject6 = (ImageView)((View)localObject4).findViewById(y.g.app_brand_get_phone_number_logo);
                  localTextView1 = (TextView)((View)localObject4).findViewById(y.g.app_brand_get_phone_number_brand_name);
                  ImageView localImageView = (ImageView)((View)localObject4).findViewById(y.g.app_brand_get_phone_number_question);
                  TextView localTextView2 = (TextView)((View)localObject4).findViewById(y.g.app_brand_get_phone_number_desc);
                  localTextView3 = (TextView)((View)localObject4).findViewById(y.g.app_brand_get_phone_number_phone);
                  View localView = ((LayoutInflater)localObject3).inflate(y.h.app_brand_get_phone_number_do_expose, null);
                  TextView localTextView4 = (TextView)localView.findViewById(y.g.app_brand_get_phone_number_expose_url);
                  localObject3 = localObject1;
                  if (bk.bl((String)localObject1)) {
                    localObject3 = localc.gkh.getContentView().getResources().getString(y.j.app_brand_get_phone_number_expose_desc_default);
                  }
                  localObject1 = localc.gkh.getContentView().getResources().getString(y.j.app_brand_get_phone_number_expose_desc_end);
                  Object localObject7 = new WxaExposedParams.a();
                  ((WxaExposedParams.a)localObject7).appId = localc.gkh.mAppId;
                  ((WxaExposedParams.a)localObject7).bUo = localc.gkh.ahc();
                  ((WxaExposedParams.a)localObject7).from = 8;
                  localObject7 = new a(r.a(((WxaExposedParams.a)localObject7).aes()));
                  SpannableString localSpannableString = new SpannableString((String)localObject3 + (String)localObject1);
                  localSpannableString.setSpan(localObject7, ((String)localObject3).length(), ((String)localObject3).length() + ((String)localObject1).length(), 18);
                  localTextView4.setMovementMethod(LinkMovementMethod.getInstance());
                  localTextView4.setText(localSpannableString);
                  if (TextUtils.isEmpty(str3)) {
                    continue;
                  }
                  localTextView1.setText(str3);
                  localTextView1.setVisibility(0);
                  localTextView2.setText(str1);
                  if (TextUtils.isEmpty(localc.gkl)) {
                    continue;
                  }
                  localTextView3.setText(localc.gkl);
                  localTextView3.setVisibility(0);
                  if (TextUtils.isEmpty(str2)) {
                    continue;
                  }
                  com.tencent.mm.modelappbrand.a.b.JD().a((ImageView)localObject6, str2, com.tencent.mm.modelappbrand.a.a.JC(), f.eaL);
                  localImageView.setOnClickListener(new c.12(localc, localView));
                  h.a(localc.gkh.mContext, false, localc.gkh.getContentView().getResources().getString(y.j.app_brand_get_phone_number_has_phone_title), (View)localObject4, localc.gkh.getContentView().getResources().getString(y.j.app_brand_get_phone_number_has_phone_do_login), localc.gkh.getContentView().getResources().getString(y.j.app_cancel), new c.13(localc, bool), new c.14(localc));
                  return;
                }
              }
            }
            catch (JSONException localJSONException2)
            {
              TextView localTextView1;
              TextView localTextView3;
              y.e("MicroMsg.JsApiGetPhoneNumber", "new dataJson exist exception, e:%s", new Object[] { localJSONException2.getMessage() });
              Object localObject5 = localObject6;
              continue;
              localc.gkt = 1;
              continue;
              localc.gkt = 3;
              continue;
              localTextView1.setVisibility(8);
              continue;
              localTextView3.setVisibility(8);
              continue;
              ((ImageView)localObject6).setImageDrawable(com.tencent.mm.modelappbrand.a.a.JC());
              continue;
              y.i("MicroMsg.JsApiGetPhoneNumber", "show the confirm bind phone dialog");
              h.a(localc.gkh.mContext, false, localc.gkh.getContentView().getResources().getString(y.j.app_brand_get_phone_number_no_bind_phone_msg), localc.gkh.getContentView().getResources().getString(y.j.app_brand_get_phone_number_no_bind_phone_title), localc.gkh.getContentView().getResources().getString(y.j.app_brand_get_phone_number_to_bind_phone), localc.gkh.getContentView().getResources().getString(y.j.app_cancel), new c.15(localc), new c.16(localc), y.d.green_text_color, y.d.green_text_color);
              return;
            }
            boolean bool = false;
          }
          localObject1 = "";
          str1 = "";
        }
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.c.11
 * JD-Core Version:    0.7.0.1
 */