package midas.x;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import com.tencent.mobileqq.openpay.api.IOpenApi;
import com.tencent.mobileqq.openpay.api.IOpenApiListener;
import com.tencent.mobileqq.openpay.api.OpenApiFactory;
import com.tencent.mobileqq.openpay.data.base.BaseResponse;
import com.tencent.mobileqq.openpay.data.pay.PayApi;
import com.tencent.mobileqq.openpay.data.pay.PayResponse;
import java.util.ArrayList;
import java.util.Iterator;

public class lu
  implements IOpenApiListener
{
  private static volatile lu c;
  IOpenApi a = null;
  PayApi b = null;
  private ArrayList<Handler> d = new ArrayList(1);
  
  private lu(Context paramContext, String paramString)
  {
    this.a = OpenApiFactory.getInstance(paramContext, paramString);
    this.b = new PayApi();
  }
  
  public static lu a(Context paramContext)
  {
    return c;
  }
  
  public static lu a(Context paramContext, String paramString)
  {
    APLog.d("APMidasQQWalletHelper", "getInstance called!");
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (c == null) {
      try
      {
        if (c == null) {
          c = new lu(paramContext.getApplicationContext(), paramString);
        }
      }
      finally {}
    }
    return c;
  }
  
  public void a(Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleIntent intent:");
    localStringBuilder.append(paramIntent);
    APLog.i("APMidasQQPayHelper", localStringBuilder.toString());
    this.a.handleIntent(paramIntent, this);
  }
  
  public void a(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("appId");
    String str2 = paramBundle.getString("tokenId");
    String str3 = paramBundle.getString("nonce");
    String str4 = paramBundle.getString("bargainorId");
    String str5 = paramBundle.getString("sig");
    String str6 = paramBundle.getString("sigType");
    long l1 = paramBundle.getLong("timeStamp");
    int i = paramBundle.getInt("serialNumber");
    String str7 = paramBundle.getString("pubAcc");
    paramBundle = paramBundle.getString("pubAccHint");
    long l2 = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toPay tokenId = ");
    ((StringBuilder)localObject).append(str2);
    APLog.i("APMidasQQPayHelper", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toPay appId = ");
    ((StringBuilder)localObject).append(str1);
    APLog.i("APMidasQQPayHelper", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toPay paySerial = ");
    ((StringBuilder)localObject).append(i);
    APLog.i("APMidasQQPayHelper", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toPay pubAcc = ");
    ((StringBuilder)localObject).append(str7);
    APLog.i("APMidasQQPayHelper", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toPay pubAccHint = ");
    ((StringBuilder)localObject).append(paramBundle);
    APLog.i("APMidasQQPayHelper", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toPay sig = ");
    ((StringBuilder)localObject).append(str5);
    APLog.i("APMidasQQPayHelper", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toPay sigType = ");
    ((StringBuilder)localObject).append(str6);
    APLog.i("APMidasQQPayHelper", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toPay nonce = ");
    ((StringBuilder)localObject).append(str3);
    APLog.i("APMidasQQPayHelper", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toPay bargainorId = ");
    ((StringBuilder)localObject).append(str4);
    APLog.i("APMidasQQPayHelper", ((StringBuilder)localObject).toString());
    long l3 = System.currentTimeMillis();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toPay logtime = ");
    ((StringBuilder)localObject).append(l3 - l2);
    APLog.i("APMidasQQPayHelper", ((StringBuilder)localObject).toString());
    this.b = new PayApi();
    this.b.appId = str1;
    localObject = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(i);
    ((PayApi)localObject).serialNumber = localStringBuilder.toString();
    localObject = this.b;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("qwallet");
    localStringBuilder.append(str1);
    ((PayApi)localObject).callbackScheme = localStringBuilder.toString();
    this.b.tokenId = str2;
    this.b.pubAcc = str7;
    this.b.pubAccHint = paramBundle;
    this.b.nonce = str3;
    this.b.timeStamp = l1;
    this.b.bargainorId = str4;
    this.b.sig = str5;
    this.b.sigType = str6;
    this.a.execApi(this.b);
  }
  
  public void a(Handler paramHandler)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("addObserver observer:");
    ((StringBuilder)???).append(paramHandler);
    APLog.i("APMidasQQPayHelper", ((StringBuilder)???).toString());
    synchronized (this.d)
    {
      if (!this.d.contains(paramHandler)) {
        this.d.add(paramHandler);
      }
      return;
    }
  }
  
  public boolean a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isQQPaySupport openApi:");
    localStringBuilder.append(this.a);
    APLog.i("APMidasQQPayHelper", localStringBuilder.toString());
    return this.a.isMobileQQSupportApi("pay");
  }
  
  public void b(Handler paramHandler)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("removeObserver observer:");
    ((StringBuilder)???).append(paramHandler);
    APLog.i("APMidasQQPayHelper", ((StringBuilder)???).toString());
    synchronized (this.d)
    {
      if (this.d.contains(paramHandler)) {
        this.d.remove(paramHandler);
      }
      return;
    }
  }
  
  public void onOpenResponse(BaseResponse paramBaseResponse)
  {
    if (paramBaseResponse == null) {
      return;
    }
    if ((paramBaseResponse instanceof PayResponse))
    {
      PayResponse localPayResponse = (PayResponse)paramBaseResponse;
      paramBaseResponse = new StringBuilder();
      paramBaseResponse.append(" apiName:");
      paramBaseResponse.append(localPayResponse.apiName);
      paramBaseResponse.append(" serialnumber:");
      paramBaseResponse.append(localPayResponse.serialNumber);
      paramBaseResponse.append(" isSucess:");
      paramBaseResponse.append(localPayResponse.isSuccess());
      paramBaseResponse.append(" retCode:");
      paramBaseResponse.append(localPayResponse.retCode);
      paramBaseResponse.append(" retMsg:");
      paramBaseResponse.append(localPayResponse.retMsg);
      ??? = paramBaseResponse.toString();
      paramBaseResponse = (BaseResponse)???;
      if (!localPayResponse.isPayByWeChat())
      {
        paramBaseResponse = new StringBuilder();
        paramBaseResponse.append((String)???);
        paramBaseResponse.append(" transactionId:");
        paramBaseResponse.append(localPayResponse.transactionId);
        paramBaseResponse.append(" payTime:");
        paramBaseResponse.append(localPayResponse.payTime);
        paramBaseResponse.append(" callbackUrl:");
        paramBaseResponse.append(localPayResponse.callbackUrl);
        paramBaseResponse.append(" totalFee:");
        paramBaseResponse.append(localPayResponse.totalFee);
        paramBaseResponse.append(" spData:");
        paramBaseResponse.append(localPayResponse.spData);
        paramBaseResponse = paramBaseResponse.toString();
      }
      synchronized (this.d)
      {
        Iterator localIterator = this.d.iterator();
        while (localIterator.hasNext())
        {
          Handler localHandler = (Handler)localIterator.next();
          Message localMessage = new Message();
          localMessage.what = 10;
          Bundle localBundle = new Bundle();
          localBundle.putBoolean("isSuccess", localPayResponse.isSuccess());
          localBundle.putInt("retCode", localPayResponse.retCode);
          localBundle.putString("retMsg", localPayResponse.retMsg);
          localBundle.putString("apiName", localPayResponse.apiName);
          localBundle.putString("serialNumber", localPayResponse.serialNumber);
          localBundle.putString("transaction", localPayResponse.transactionId);
          localBundle.putString("payTime", localPayResponse.payTime);
          localBundle.putString("callbackUrl", localPayResponse.callbackUrl);
          localBundle.putString("totalFee", localPayResponse.totalFee);
          localBundle.putString("spData", localPayResponse.spData);
          localMessage.setData(localBundle);
          localHandler.sendMessage(localMessage);
        }
      }
    }
    paramBaseResponse = "response is not PayResponse.";
    ??? = new StringBuilder();
    ((StringBuilder)???).append("onOpenResponse message = ");
    ((StringBuilder)???).append(paramBaseResponse);
    APLog.i("APMidasQQPayHelper", ((StringBuilder)???).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.lu
 * JD-Core Version:    0.7.0.1
 */