package midas.x;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import java.net.URLDecoder;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class n8
  extends k8
{
  public e8 e = null;
  public Activity f = null;
  public boolean g = true;
  public JSONArray h = null;
  
  public n8()
  {
    c();
  }
  
  public void a(int paramInt, String paramString)
  {
    paramString = APDataReportManager.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(y7.V);
    localStringBuilder.append(y7.w);
    paramString.insertData(localStringBuilder.toString(), 0);
  }
  
  public void a(Activity paramActivity, e8 parame8, Bundle paramBundle)
  {
    super.a(paramActivity, parame8, paramBundle);
    this.f = paramActivity;
    this.e = parame8;
  }
  
  public void a(ProgressDialog paramProgressDialog)
  {
    super.a(paramProgressDialog);
    paramProgressDialog = this.e;
    if (paramProgressDialog != null) {
      paramProgressDialog.b(f());
    }
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    try
    {
      paramString = URLDecoder.decode(paramString, "utf-8");
      if ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("midas://"))) {
        break label162;
      }
      paramString = new JSONObject(paramString.substring(8));
      int i = i.b(paramString.getString("resultCode"));
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3) {
              return;
            }
            this.g = true;
            return;
          }
          this.g = false;
          return;
        }
        paramString = APDataReportManager.getInstance();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(y7.U);
        localStringBuilder.append(".");
        localStringBuilder.append(y7.w);
        paramString.insertData(localStringBuilder.toString(), p4.p().e().b.saveType);
        h();
        return;
      }
      b(paramString.optJSONArray("resultMsg"));
      return;
    }
    catch (Exception paramString)
    {
      label155:
      label162:
      break label155;
    }
    APLog.e("webCallBack", "url decode error");
  }
  
  public void a(Throwable paramThrowable)
  {
    super.a(paramThrowable);
    h();
  }
  
  public final void a(JSONArray paramJSONArray)
  {
    if (this.h == null)
    {
      this.h = paramJSONArray;
      return;
    }
    int i = 0;
    while (i < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.opt(i);
      if (localObject != null) {
        this.h.put(localObject);
      }
      i += 1;
    }
  }
  
  public final void b(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null) {
      a(paramJSONArray);
    }
  }
  
  public boolean e()
  {
    if (this.e.e().canGoBack())
    {
      if (this.g) {
        this.e.e().goBack();
      }
    }
    else
    {
      APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(y7.T);
      localStringBuilder.append(y7.w);
      localAPDataReportManager.insertData(localStringBuilder.toString(), p4.p().e().b.saveType);
      h();
    }
    return true;
  }
  
  public String f()
  {
    b();
    i();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(y7.a);
    localStringBuilder.append(this.b);
    localStringBuilder.append(y7.n);
    localStringBuilder.append("?");
    localStringBuilder.append(APTools.a(this.c));
    this.a = localStringBuilder.toString();
    APLog.d("URL", this.a);
    return this.a;
  }
  
  public final String g()
  {
    JSONArray localJSONArray = this.h;
    if (localJSONArray == null) {
      return "";
    }
    return localJSONArray.toString();
  }
  
  public final void h()
  {
    APUICommonMethod.f();
    z5.a(-1, 0, -1, g());
  }
  
  public final void i()
  {
    if (!APAppDataInterface.singleton().h().equals("release")) {
      if (APAppDataInterface.singleton().h().equals("dev")) {
        this.c.put("sandbox", "2");
      } else {
        this.c.put("sandbox", "1");
      }
    }
    if (this.f != null)
    {
      HashMap localHashMap = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.f.getResources().getConfiguration().orientation);
      localHashMap.put("orientation", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.n8
 * JD-Core Version:    0.7.0.1
 */