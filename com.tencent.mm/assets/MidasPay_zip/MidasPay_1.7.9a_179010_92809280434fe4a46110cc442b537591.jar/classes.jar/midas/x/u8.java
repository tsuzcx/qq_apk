package midas.x;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.Toast;
import com.pay.tool.APTools;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.payWeb.jsbridge.APWebJSBridgeActivity;
import com.tencent.midas.comm.APLog;
import java.net.URLDecoder;
import org.json.JSONObject;

public class u8
  extends k8
{
  public static final long serialVersionUID = 1L;
  public Activity e = null;
  public e8 f = null;
  public ProgressDialog g = null;
  public String h = "";
  
  public void a(int paramInt, String paramString) {}
  
  public void a(Activity paramActivity, e8 parame8, Bundle paramBundle)
  {
    super.a(paramActivity, parame8, paramBundle);
    this.e = paramActivity;
    this.f = parame8;
  }
  
  public void a(ProgressDialog paramProgressDialog)
  {
    super.a(paramProgressDialog);
    paramProgressDialog = this.g;
    if (paramProgressDialog != null) {
      paramProgressDialog.show();
    }
    paramProgressDialog = this.f;
    if (paramProgressDialog != null) {
      paramProgressDialog.b(f());
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = URLDecoder.decode(paramString, "utf-8");
      APLog.d("onJsAlert", paramString);
      if (!TextUtils.isEmpty(paramString))
      {
        boolean bool = paramString.startsWith("wsj://");
        if (bool) {
          try
          {
            paramString = new JSONObject(paramString.substring(6));
            int i = i.b(paramString.getString("resultCode"));
            if (i != -100)
            {
              if (i != -2)
              {
                if (i != 0) {
                  return;
                }
                paramString = paramString.getJSONObject("resultMsg");
                if ((paramString != null) && (paramString.has("action")))
                {
                  paramString = paramString.getString("action");
                  if ("succeed".equals(paramString))
                  {
                    this.e.finish();
                    APUICommonMethod.a(this.e);
                    g();
                    return;
                  }
                  if ("cancel".equals(paramString))
                  {
                    APLog.d("resultfromH5", "cancel");
                    this.e.finish();
                    APUICommonMethod.a(this.e);
                  }
                }
              }
              else
              {
                this.f.i();
              }
            }
            else
            {
              Toast.makeText(this.e, "很抱歉,本次支付未成功\n建议更换其他方式进行支付", 0).show();
              this.e.finish();
              APUICommonMethod.a(this.e);
              return;
            }
          }
          catch (Exception paramString)
          {
            paramString.printStackTrace();
            APLog.d("jsonException", "error");
          }
        }
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void e(String paramString)
  {
    this.h = paramString;
  }
  
  public boolean e()
  {
    if (this.f.e().canGoBack())
    {
      this.f.e().goBack();
      return true;
    }
    return false;
  }
  
  public String f()
  {
    APLog.d("WSJUrl", this.h);
    String str = this.h;
    if ((str != null) && (str.contains("?")))
    {
      if (Build.VERSION.SDK_INT >= 11) {
        str = "https://imgcache.qq.com/bossweb/midas/Midas_js/wsjchannel.shtml";
      } else {
        str = "http://imgcache.qq.com/bossweb/midas/Midas_js/wsjchannel.shtml";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("?params=");
      localStringBuilder.append(APTools.b(this.h, 1));
      str = localStringBuilder.toString();
      APLog.d("WSJUrl", str);
      return str;
    }
    return "";
  }
  
  public final void g()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("pageName", y7.t);
    Intent localIntent = new Intent();
    localIntent.setClass(this.e, APWebJSBridgeActivity.class);
    localIntent.putExtras(localBundle);
    this.e.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.u8
 * JD-Core Version:    0.7.0.1
 */