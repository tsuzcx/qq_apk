package midas.x;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APTools;
import com.pay.ui.common.APPayProgressActivity;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import com.tencent.smtt.sdk.WebView;
import java.net.URLDecoder;
import java.util.HashMap;

public class it
  extends ir
{
  private static final long serialVersionUID = 1L;
  public String f = "";
  public int g = 0;
  private Activity h = null;
  private ib i = null;
  private ProgressDialog j = null;
  
  public it()
  {
    c();
  }
  
  public void a(int paramInt, String paramString)
  {
    APUICommonMethod.a(this.h, "Error: webReceivedError");
    paramString = APDataReportManager.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hu.ap);
    localStringBuilder.append(this.f);
    paramString.insertData(localStringBuilder.toString(), em.b().n().a.saveType, "", "", "error=webReceivedError");
    c(this.h);
  }
  
  public void a(Activity paramActivity, ib paramib, Bundle paramBundle)
  {
    super.a(paramActivity, paramib, paramBundle);
    if (paramBundle != null)
    {
      paramBundle.getString("pageName");
      paramBundle.getString("url");
      this.f = paramBundle.getString("subChannelId");
      this.g = paramBundle.getInt("webSolutionType");
    }
    this.h = paramActivity;
    this.i = paramib;
  }
  
  public void a(ProgressDialog paramProgressDialog)
  {
    super.a(paramProgressDialog);
    Object localObject = (ViewGroup.MarginLayoutParams)this.i.c().getLayoutParams();
    switch (em.b().n().a.saveType)
    {
    default: 
      ((ViewGroup.MarginLayoutParams)localObject).height = APUICommonMethod.a(this.h, 300.0F);
      break;
    case 4: 
    case 5: 
      ((ViewGroup.MarginLayoutParams)localObject).height = APUICommonMethod.a(this.h, 470.0F);
    }
    this.i.c().setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.j = paramProgressDialog;
    if (this.j != null) {
      this.j.show();
    }
    if (this.i != null)
    {
      paramProgressDialog = b();
      if (TextUtils.isEmpty(paramProgressDialog))
      {
        paramProgressDialog = this.h;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("暂不支持话费支付");
        ((StringBuilder)localObject).append(bw.a(24001));
        APUICommonMethod.a(paramProgressDialog, ((StringBuilder)localObject).toString());
        paramProgressDialog = APDataReportManager.getInstance();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(hu.ap);
        ((StringBuilder)localObject).append(this.f);
        paramProgressDialog.insertData(((StringBuilder)localObject).toString(), em.b().n().a.saveType, "", "", "error=url is empty");
        c(this.h);
        return;
      }
      localObject = APDataReportManager.getInstance();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(hu.ak);
      localStringBuilder.append(this.f);
      ((APDataReportManager)localObject).insertData(localStringBuilder.toString(), em.b().n().a.saveType);
      this.i.b(paramProgressDialog);
    }
  }
  
  public void a(Context paramContext)
  {
    APLog.d("APX5WebHFPage", "toSuccess()");
    Activity localActivity = (Activity)paramContext;
    localActivity.finish();
    APUICommonMethod.b(localActivity);
    Intent localIntent = new Intent(paramContext, APPayProgressActivity.class);
    localIntent.putExtra("channel", 9);
    paramContext.startActivity(localIntent);
    localActivity.finish();
  }
  
  public void a(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("webCallBack() message before = ");
    ((StringBuilder)localObject1).append(paramString);
    APLog.d("APX5WebHFPage", ((StringBuilder)localObject1).toString());
    try
    {
      localObject1 = URLDecoder.decode(paramString, "utf-8");
      paramString = (String)localObject1;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("webCallBack() message = ");
    ((StringBuilder)localObject2).append(paramString);
    APLog.d("APX5WebHFPage", ((StringBuilder)localObject2).toString());
    paramString = APTools.p(paramString);
    if (!paramString.startsWith("unipay.sdk.android"))
    {
      APLog.d("APX5WebHFPage", "messageBody.startsWith(BASE_CALLBACK_URL) No, return");
      return;
    }
    paramString = APTools.b(paramString);
    localObject2 = (String)paramString.get("hret");
    boolean bool = TextUtils.isEmpty((CharSequence)localObject2);
    int m = -1;
    int k;
    if (!bool) {
      k = i.a((String)localObject2);
    } else {
      k = -1;
    }
    paramString = (String)paramString.get("midasret");
    if (!TextUtils.isEmpty(paramString)) {
      m = i.a(paramString);
    }
    if (k <= 0) {
      k = m;
    }
    paramString = new StringBuilder();
    paramString.append("webCallBack() retCode = ");
    paramString.append(k);
    APLog.d("APX5WebHFPage", paramString.toString());
    if (k != 0)
    {
      if (k != 2)
      {
        paramString = APDataReportManager.getInstance();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(hu.ao);
        ((StringBuilder)localObject2).append(this.f);
        paramString.insertData(((StringBuilder)localObject2).toString(), em.b().n().a.saveType);
        b(this.h);
        return;
      }
      paramString = APDataReportManager.getInstance();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(hu.al);
      ((StringBuilder)localObject2).append(this.f);
      paramString.insertData(((StringBuilder)localObject2).toString(), em.b().n().a.saveType);
      c(this.h);
      return;
    }
    paramString = APDataReportManager.getInstance();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(hu.an);
    ((StringBuilder)localObject2).append(this.f);
    paramString.insertData(((StringBuilder)localObject2).toString(), em.b().n().a.saveType);
    a(this.h);
  }
  
  public boolean a()
  {
    if ((this.i.c() != null) && (this.i.c().canGoBack()))
    {
      this.i.c().goBack();
    }
    else
    {
      APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(hu.am);
      localStringBuilder.append(this.f);
      localAPDataReportManager.insertData(localStringBuilder.toString(), em.b().n().a.saveType);
      c(this.h);
    }
    return true;
  }
  
  public String b()
  {
    String str = fy.a().ag();
    Object localObject = str;
    if (this.g == 2)
    {
      localObject = new StringBuilder(str);
      ((StringBuilder)localObject).append("&");
      ((StringBuilder)localObject).append("redirectURL");
      ((StringBuilder)localObject).append("=");
      ((StringBuilder)localObject).append("unipay.sdk.android?midasret=0");
      ((StringBuilder)localObject).append("&");
      ((StringBuilder)localObject).append("failRedirectURL");
      ((StringBuilder)localObject).append("=");
      ((StringBuilder)localObject).append("unipay.sdk.android?midasret=1");
      ((StringBuilder)localObject).append("&");
      ((StringBuilder)localObject).append("cancelRedirectURL");
      ((StringBuilder)localObject).append("=");
      ((StringBuilder)localObject).append("unipay.sdk.android?midasret=2");
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public void b(Context paramContext)
  {
    APLog.d("APX5WebHFPage", "toFailure()");
    Activity localActivity = (Activity)paramContext;
    localActivity.finish();
    APUICommonMethod.b(localActivity);
    localActivity.overridePendingTransition(fv.a(paramContext, "unipay_anim_in_from_left"), fv.a(paramContext, "unipay_anim_out_to_right"));
  }
  
  public void c(Context paramContext)
  {
    APLog.d("APX5WebHFPage", "toCancel()");
    Activity localActivity = (Activity)paramContext;
    localActivity.finish();
    APUICommonMethod.b(localActivity);
    localActivity.overridePendingTransition(fv.a(paramContext, "unipay_anim_in_from_left"), fv.a(paramContext, "unipay_anim_out_to_right"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.it
 * JD-Core Version:    0.7.0.1
 */