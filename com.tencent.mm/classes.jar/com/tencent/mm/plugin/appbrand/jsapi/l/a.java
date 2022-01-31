package com.tencent.mm.plugin.appbrand.jsapi.l;

import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import org.json.JSONObject;

public enum a
  implements b
{
  private a() {}
  
  public final void a(MMActivity paramMMActivity, JSONObject paramJSONObject, b.b paramb)
  {
    paramb = new a.5(this, paramb);
    paramJSONObject = new g(paramJSONObject);
    Intent localIntent = new Intent();
    localIntent.putExtra("appId", paramJSONObject.appId);
    localIntent.putExtra("timeStamp", paramJSONObject.timeStamp);
    localIntent.putExtra("nonceStr", paramJSONObject.nonceStr);
    localIntent.putExtra("packageExt", paramJSONObject.packageExt);
    localIntent.putExtra("signtype", paramJSONObject.signType);
    localIntent.putExtra("paySignature", paramJSONObject.bUT);
    localIntent.putExtra("url", paramJSONObject.url);
    localIntent.putExtra("scene", 1);
    paramMMActivity.gJb = paramb;
    d.a(paramMMActivity, "wallet_core", ".ui.WalletCheckPwdUI", localIntent, 0xFFFF & hashCode(), false);
  }
  
  public final boolean a(MMActivity paramMMActivity, AppBrandStatObject paramAppBrandStatObject, JSONObject paramJSONObject, final b.a parama, PString paramPString)
  {
    paramJSONObject = new g(paramJSONObject);
    if (paramAppBrandStatObject != null)
    {
      paramJSONObject.bIO = g.fc(paramAppBrandStatObject.scene, paramAppBrandStatObject.caA);
      paramJSONObject.soi = g.fb(paramAppBrandStatObject.scene, paramAppBrandStatObject.caA);
    }
    paramJSONObject.bUV = 46;
    paramPString.value = paramJSONObject.packageExt;
    paramAppBrandStatObject = new MMActivity.a()
    {
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        if (paramAnonymousInt1 != (a.this.hashCode() & 0xFFFF)) {}
        do
        {
          do
          {
            do
            {
              return;
              if (paramAnonymousInt2 != -1) {
                break;
              }
            } while (parama == null);
            parama.a(1, null, null);
            return;
            if (paramAnonymousInt2 != 5) {
              break;
            }
            paramAnonymousInt1 = paramAnonymousIntent.getIntExtra("key_jsapi_pay_err_code", 0);
            paramAnonymousIntent = bk.pm(paramAnonymousIntent.getStringExtra("key_jsapi_pay_err_msg"));
            y.e("MicroMsg.AppBrandJsApiPayService", "errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousIntent });
          } while (parama == null);
          parama.a(2, paramAnonymousIntent, null);
          return;
        } while (parama == null);
        parama.a(3, null, null);
      }
    };
    return h.a(paramMMActivity, paramJSONObject, hashCode() & 0xFFFF, paramAppBrandStatObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.a
 * JD-Core Version:    0.7.0.1
 */