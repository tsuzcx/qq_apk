package midas.x;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.pay.tool.APTools;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.payWeb.jsbridge.APX5WebJSBridgeActivity;
import com.tencent.midas.comm.APLog;
import com.tencent.smtt.sdk.WebView;
import java.net.URLDecoder;
import org.json.JSONObject;

public class ja
  extends ir
{
  private static final long serialVersionUID = 1L;
  private final int f = 0;
  private final int g = -2;
  private final int h = -100;
  private Activity i = null;
  private ib j = null;
  private ProgressDialog k = null;
  private String l = "";
  
  private void g()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("pageName", hu.v);
    Intent localIntent = new Intent();
    localIntent.setClass(this.i, APX5WebJSBridgeActivity.class);
    localIntent.putExtras(localBundle);
    this.i.startActivity(localIntent);
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(Activity paramActivity, ib paramib, Bundle paramBundle)
  {
    super.a(paramActivity, paramib, paramBundle);
    this.i = paramActivity;
    this.j = paramib;
  }
  
  public void a(ProgressDialog paramProgressDialog)
  {
    super.a(paramProgressDialog);
    if (this.k != null) {
      this.k.show();
    }
    if (this.j != null) {
      this.j.b(b());
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
            paramString = new JSONObject(paramString.substring("wsj://".length()));
            int m = i.a(paramString.getString("resultCode"));
            if (m != -100)
            {
              if (m != -2)
              {
                if (m != 0) {
                  return;
                }
                paramString = paramString.getJSONObject("resultMsg");
                if ((paramString != null) && (paramString.has("action")))
                {
                  paramString = paramString.getString("action");
                  if ("succeed".equals(paramString))
                  {
                    this.i.finish();
                    APUICommonMethod.b(this.i);
                    g();
                    return;
                  }
                  if ("cancel".equals(paramString))
                  {
                    APLog.d("resultfromH5", "cancel");
                    this.i.finish();
                    APUICommonMethod.b(this.i);
                  }
                }
              }
              else
              {
                this.j.e();
              }
            }
            else
            {
              Toast.makeText(this.i, "很抱歉,本次支付未成功\n建议更换其他方式进行支付", 0).show();
              this.i.finish();
              APUICommonMethod.b(this.i);
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
  
  public boolean a()
  {
    if (this.j.c().canGoBack())
    {
      this.j.c().goBack();
      return true;
    }
    return false;
  }
  
  public String b()
  {
    APLog.d("WSJUrl", this.l);
    if ((this.l != null) && (this.l.contains("?")))
    {
      if (Build.VERSION.SDK_INT >= 11) {
        str = "https://imgcache.qq.com/bossweb/midas/Midas_js/wsjchannel.shtml";
      } else {
        str = "http://imgcache.qq.com/bossweb/midas/Midas_js/wsjchannel.shtml";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("?params=");
      localStringBuilder.append(APTools.a(this.l, 1));
      String str = localStringBuilder.toString();
      APLog.d("WSJUrl", str);
      return str;
    }
    return "";
  }
  
  public void e(String paramString)
  {
    this.l = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.ja
 * JD-Core Version:    0.7.0.1
 */