package midas.x;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import com.tencent.smtt.sdk.WebView;
import java.net.URLDecoder;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class iu
  extends ir
{
  private final int f = 0;
  private final int g = 1;
  private final int h = 2;
  private final int i = 3;
  private ib j = null;
  private Activity k = null;
  private boolean l = true;
  private JSONArray m = null;
  
  public iu()
  {
    c();
  }
  
  private void a(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null) {
      b(paramJSONArray);
    }
  }
  
  private void b(JSONArray paramJSONArray)
  {
    if (this.m == null)
    {
      this.m = paramJSONArray;
      return;
    }
    int n = 0;
    while (n < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.opt(n);
      if (localObject != null) {
        this.m.put(localObject);
      }
      n += 1;
    }
  }
  
  private void g()
  {
    if (!APAppDataInterface.singleton().e().equals("release")) {
      if (APAppDataInterface.singleton().e().equals("dev")) {
        this.d.put("sandbox", "2");
      } else {
        this.d.put("sandbox", "1");
      }
    }
    if (this.k != null)
    {
      HashMap localHashMap = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.k.getResources().getConfiguration().orientation);
      localHashMap.put("orientation", localStringBuilder.toString());
    }
  }
  
  private void h()
  {
    APUICommonMethod.b();
    fv.a(-1, 0, -1, i());
  }
  
  private String i()
  {
    if (this.m == null) {
      return "";
    }
    return this.m.toString();
  }
  
  public void a(int paramInt, String paramString)
  {
    paramString = APDataReportManager.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hu.ae);
    localStringBuilder.append(hu.z);
    paramString.insertData(localStringBuilder.toString(), 0);
  }
  
  public void a(Activity paramActivity, ib paramib, Bundle paramBundle)
  {
    super.a(paramActivity, paramib, paramBundle);
    this.k = paramActivity;
    this.j = paramib;
  }
  
  public void a(ProgressDialog paramProgressDialog)
  {
    super.a(paramProgressDialog);
    if (this.j != null) {
      this.j.b(b());
    }
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    try
    {
      paramString = URLDecoder.decode(paramString, "utf-8");
      if ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("midas://"))) {
        break label174;
      }
      paramString = new JSONObject(paramString.substring("midas://".length()));
      switch (i.a(paramString.getString("resultCode")))
      {
      case 3: 
        this.l = true;
        return;
      }
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder;
      break label167;
    }
    this.l = false;
    return;
    paramString = APDataReportManager.getInstance();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(hu.ad);
    localStringBuilder.append(".");
    localStringBuilder.append(hu.z);
    paramString.insertData(localStringBuilder.toString(), em.b().n().a.saveType);
    h();
    return;
    a(paramString.optJSONArray("resultMsg"));
    return;
    label167:
    APLog.e("webCallBack", "url decode error");
    label174:
    return;
  }
  
  public boolean a()
  {
    if (this.j.c().canGoBack())
    {
      if (this.l) {
        this.j.c().goBack();
      }
    }
    else
    {
      APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(hu.ab);
      localStringBuilder.append(hu.z);
      localAPDataReportManager.insertData(localStringBuilder.toString(), em.b().n().a.saveType);
      h();
    }
    return true;
  }
  
  public String b()
  {
    d();
    g();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hu.a);
    localStringBuilder.append(this.c);
    localStringBuilder.append(hu.n);
    localStringBuilder.append("?");
    localStringBuilder.append(APTools.a(this.d));
    this.a = localStringBuilder.toString();
    APLog.d("URL", this.a);
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.iu
 * JD-Core Version:    0.7.0.1
 */