package midas.x;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.content.res.Resources;
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

public class ij
  extends ig
{
  private final int f = 0;
  private final int g = 1;
  private final int h = 2;
  private final int i = 3;
  private hq j = null;
  private Activity k = null;
  private boolean l = true;
  private JSONArray m = null;
  
  public ij()
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
    fm.a(-1, 0, -1, i());
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
    localStringBuilder.append(hj.af);
    localStringBuilder.append(hj.z);
    paramString.insertData(localStringBuilder.toString(), 0);
  }
  
  public void a(Activity paramActivity, hq paramhq)
  {
    super.a(paramActivity, paramhq);
    this.k = paramActivity;
    this.j = paramhq;
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
    localStringBuilder.append(hj.ae);
    localStringBuilder.append(".");
    localStringBuilder.append(hj.z);
    paramString.insertData(localStringBuilder.toString(), ed.b().n().a.saveType);
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
      localStringBuilder.append(hj.ac);
      localStringBuilder.append(hj.z);
      localAPDataReportManager.insertData(localStringBuilder.toString(), ed.b().n().a.saveType);
      h();
    }
    return true;
  }
  
  public String b()
  {
    d();
    g();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hj.a);
    localStringBuilder.append(this.c);
    localStringBuilder.append(hj.n);
    localStringBuilder.append("?");
    localStringBuilder.append(APTools.a(this.d));
    this.a = localStringBuilder.toString();
    APLog.d("URL", this.a);
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.ij
 * JD-Core Version:    0.7.0.1
 */