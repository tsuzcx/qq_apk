package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.plugin.ag.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView;
import com.tencent.mm.plugin.appbrand.y.d;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.protocal.c.art;
import com.tencent.mm.protocal.c.aru;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONStringer;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.a<q>
{
  public static final int CTRL_INDEX = 209;
  public static final String NAME = "getPhoneNumber";
  String aJD;
  private String bFq;
  String bSe = "";
  int gfg;
  q gkh;
  private boolean gki;
  String gkj;
  String gkk;
  String gkl = "";
  boolean gkm = false;
  View gkn;
  EditVerifyCodeView gko;
  TextView gkp;
  c.a gkq;
  com.tencent.mm.plugin.ag.a gkr = null;
  private com.tencent.mm.ui.widget.a.c gks;
  int gkt = 0;
  int gku = 0;
  int gkv = 0;
  a.a gkw = new c.10(this);
  String signature;
  
  final void aie()
  {
    y.i("MicroMsg.JsApiGetPhoneNumber", "requestBindPhoneNumber");
    JSONStringer localJSONStringer = new JSONStringer();
    try
    {
      localJSONStringer.object();
      localJSONStringer.key("api_name");
      localJSONStringer.value(this.bFq);
      localJSONStringer.key("with_credentials");
      localJSONStringer.value(this.gki);
      localJSONStringer.endObject();
      y.i("MicroMsg.JsApiGetPhoneNumber", "getPhoneNumber appId:%s, api_name:%s, with_credentials:%b", new Object[] { this.gkh.mAppId, this.bFq, Boolean.valueOf(this.gki) });
      Object localObject = new b.a();
      ((b.a)localObject).ecH = new art();
      ((b.a)localObject).ecI = new aru();
      ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-getuserwxphone";
      ((b.a)localObject).ecG = 1141;
      ((b.a)localObject).ecJ = 0;
      ((b.a)localObject).ecK = 0;
      localObject = ((b.a)localObject).Kt();
      art localart = (art)((com.tencent.mm.ah.b)localObject).ecE.ecN;
      localart.euK = this.gkh.mAppId;
      localart.hPF = new com.tencent.mm.bv.b(localJSONStringer.toString().getBytes());
      com.tencent.mm.ipcinvoker.wx_extension.b.a((com.tencent.mm.ah.b)localObject, new c.11(this));
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        y.e("MicroMsg.JsApiGetPhoneNumber", "JSONException:%s", new Object[] { localJSONException.getMessage() });
      }
    }
  }
  
  final void aif()
  {
    y.i("MicroMsg.JsApiGetPhoneNumber", "doSuccCallback");
    HashMap localHashMap = new HashMap(5);
    localHashMap.put("encryptedData", this.gkk);
    localHashMap.put("iv", this.aJD);
    this.gkh.C(this.gfg, h("ok", localHashMap));
  }
  
  final void aig()
  {
    y.i("MicroMsg.JsApiGetPhoneNumber", "updateSendText()");
    String str1 = this.gkh.getContentView().getResources().getString(y.j.app_brand_get_phone_number_not_receive_verify_code);
    String str2 = this.gkh.getContentView().getResources().getString(y.j.app_brand_get_phone_number_resend_verify_code);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(str1);
    localSpannableStringBuilder.append(str2);
    int i = str1.length();
    int j = str2.length();
    localSpannableStringBuilder.setSpan(new ClickableSpan()
    {
      public final void onClick(View paramAnonymousView)
      {
        y.i("MicroMsg.JsApiGetPhoneNumber", "click the resend spanBuilder, do resend sms");
        if (c.this.gkm)
        {
          c.b(c.this);
          return;
        }
        y.e("MicroMsg.JsApiGetPhoneNumber", "allow_send_sms is false, show send_verify_code_frequent error");
        c.this.tR(c.this.gkh.getContentView().getResources().getString(y.j.app_brand_get_phone_number_send_verify_code_frequent));
      }
    }, i, i + j, 17);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(this.gkh.mContext.getResources().getColor(y.d.link_color)), i, j + i, 17);
    this.gkp.setText(localSpannableStringBuilder);
    this.gkp.setMovementMethod(LinkMovementMethod.getInstance());
  }
  
  final void aih()
  {
    y.i("MicroMsg.JsApiGetPhoneNumber", "stopSmsListener");
    if (this.gkq != null) {
      this.gkq.cancel();
    }
    if (this.gkr != null)
    {
      this.gkr.stop();
      this.gkr.oiY = null;
    }
  }
  
  final void tR(String paramString)
  {
    aih();
    com.tencent.mm.ui.base.h.a(this.gkh.mContext, paramString, "", false, new c.7(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.c
 * JD-Core Version:    0.7.0.1
 */