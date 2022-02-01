package midas.x;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
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

public class ii
  extends ig
{
  private static final long serialVersionUID = 1L;
  private Activity f = null;
  private hq g = null;
  private ProgressDialog h = null;
  private String i;
  
  public ii(String paramString)
  {
    this.i = paramString;
    c();
  }
  
  public void a(int paramInt, String paramString)
  {
    APUICommonMethod.a(this.f, "Error: webReceivedError");
    paramString = APDataReportManager.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hj.ap);
    localStringBuilder.append(this.i);
    paramString.insertData(localStringBuilder.toString(), ed.b().n().a.saveType, "", "", "error=webReceivedError");
    c(this.f);
  }
  
  public void a(Activity paramActivity, hq paramhq)
  {
    super.a(paramActivity, paramhq);
    this.f = paramActivity;
    this.g = paramhq;
  }
  
  public void a(ProgressDialog paramProgressDialog)
  {
    super.a(paramProgressDialog);
    Object localObject = (ViewGroup.MarginLayoutParams)this.g.c().getLayoutParams();
    int j = ed.b().n().a.saveType;
    if (hj.E.equals(this.i)) {
      switch (j)
      {
      default: 
        ((ViewGroup.MarginLayoutParams)localObject).height = APUICommonMethod.a(this.f, 300.0F);
        break;
      case 4: 
      case 5: 
        ((ViewGroup.MarginLayoutParams)localObject).height = APUICommonMethod.a(this.f, 470.0F);
        break;
      }
    } else {
      ((ViewGroup.MarginLayoutParams)localObject).height = APUICommonMethod.a(this.f, 400.0F);
    }
    this.g.c().setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.h = paramProgressDialog;
    if (this.h != null) {
      this.h.show();
    }
    if (this.g != null)
    {
      paramProgressDialog = b();
      if (TextUtils.isEmpty(paramProgressDialog))
      {
        paramProgressDialog = this.f;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("暂不支持话费支付");
        ((StringBuilder)localObject).append(bq.a(24001));
        APUICommonMethod.a(paramProgressDialog, ((StringBuilder)localObject).toString());
        paramProgressDialog = APDataReportManager.getInstance();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(hj.ap);
        ((StringBuilder)localObject).append(this.i);
        paramProgressDialog.insertData(((StringBuilder)localObject).toString(), ed.b().n().a.saveType, "", "", "error=url is empty");
        c(this.f);
        return;
      }
      localObject = APDataReportManager.getInstance();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(hj.al);
      localStringBuilder.append(this.i);
      ((APDataReportManager)localObject).insertData(localStringBuilder.toString(), ed.b().n().a.saveType);
      this.g.b(paramProgressDialog);
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
    try
    {
      paramString = URLDecoder.decode(paramString, "utf-8");
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("webCallBack() message = ");
      ((StringBuilder)localObject1).append(paramString);
      APLog.d("APX5WebHFPage", ((StringBuilder)localObject1).toString());
      localObject1 = APTools.p(paramString);
      if (((String)localObject1).startsWith("unipay.sdk.android/?page=unicom_callback"))
      {
        paramString = (String)APTools.b(paramString).get("hret");
        if (!TextUtils.isEmpty(paramString))
        {
          if ("0".equals(paramString))
          {
            a(this.f);
            return;
          }
          if ("1".equals(paramString))
          {
            b(this.f);
            return;
          }
          if ("2".equals(paramString))
          {
            c(this.f);
            return;
          }
          b(this.f);
          return;
        }
        b(this.f);
        return;
      }
      if (((String)localObject1).startsWith("unipay.sdk.android/?migu_callback=0"))
      {
        paramString = APDataReportManager.getInstance();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(hj.ao);
        ((StringBuilder)localObject1).append(this.i);
        paramString.insertData(((StringBuilder)localObject1).toString(), ed.b().n().a.saveType);
        a(this.f);
        return;
      }
      if (((String)localObject1).startsWith("unipay.sdk.android/?migu_callback=1"))
      {
        paramString = APDataReportManager.getInstance();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(hj.am);
        ((StringBuilder)localObject1).append(this.i);
        paramString.insertData(((StringBuilder)localObject1).toString(), ed.b().n().a.saveType);
        c(this.f);
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      Object localObject1 = APDataReportManager.getInstance();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(hj.ap);
      ((StringBuilder)localObject2).append(this.i);
      localObject2 = ((StringBuilder)localObject2).toString();
      int j = ed.b().n().a.saveType;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("error=webCallBack try-catch&exception=");
      localStringBuilder.append(paramString.toString());
      ((APDataReportManager)localObject1).insertData((String)localObject2, j, "", "", localStringBuilder.toString());
      c(this.f);
    }
  }
  
  public boolean a()
  {
    if ((this.g.c() != null) && (this.g.c().canGoBack()))
    {
      this.g.c().goBack();
    }
    else
    {
      APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(hj.an);
      localStringBuilder.append(this.i);
      localAPDataReportManager.insertData(localStringBuilder.toString(), ed.b().n().a.saveType);
      c(this.f);
    }
    return true;
  }
  
  public String b()
  {
    return fp.a().ag();
  }
  
  public void b(Context paramContext)
  {
    APLog.d("APX5WebHFPage", "toFailure()");
    Activity localActivity = (Activity)paramContext;
    localActivity.finish();
    APUICommonMethod.b(localActivity);
    localActivity.overridePendingTransition(fm.a(paramContext, "unipay_anim_in_from_left"), fm.a(paramContext, "unipay_anim_out_to_right"));
  }
  
  public void c(Context paramContext)
  {
    APLog.d("APX5WebHFPage", "toCancel()");
    Activity localActivity = (Activity)paramContext;
    localActivity.finish();
    APUICommonMethod.b(localActivity);
    localActivity.overridePendingTransition(fm.a(paramContext, "unipay_anim_in_from_left"), fm.a(paramContext, "unipay_anim_out_to_right"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.ii
 * JD-Core Version:    0.7.0.1
 */