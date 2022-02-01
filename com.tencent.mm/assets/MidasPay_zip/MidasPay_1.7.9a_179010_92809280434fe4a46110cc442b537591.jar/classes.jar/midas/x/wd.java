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
import com.tencent.mobileqq.openpay.data.base.BaseApi;
import com.tencent.mobileqq.openpay.data.base.BaseResponse;
import com.tencent.mobileqq.openpay.data.pay.PayApi;
import com.tencent.mobileqq.openpay.data.pay.PayResponse;
import java.util.ArrayList;
import java.util.Iterator;

public class wd
  implements IOpenApiListener
{
  public static volatile wd d;
  public IOpenApi a = null;
  public PayApi b = null;
  public ArrayList<Handler> c = new ArrayList(1);
  
  public wd(Context paramContext, String paramString)
  {
    this.a = OpenApiFactory.getInstance(paramContext, paramString);
    this.b = new PayApi();
  }
  
  public static wd a(Context paramContext)
  {
    return d;
  }
  
  public static wd a(Context paramContext, String paramString)
  {
    APLog.d("APMidasQQWalletHelper", "getInstance called!");
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (d == null) {
      try
      {
        if (d == null) {
          d = new wd(paramContext.getApplicationContext(), paramString);
        }
      }
      finally {}
    }
    return d;
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
    Object localObject1 = paramBundle.getString("appId");
    String str1 = paramBundle.getString("tokenId");
    String str2 = paramBundle.getString("nonce");
    String str3 = paramBundle.getString("bargainorId");
    String str4 = paramBundle.getString("sig");
    String str5 = paramBundle.getString("sigType");
    long l1 = paramBundle.getLong("timeStamp");
    int i = paramBundle.getInt("serialNumber");
    String str6 = paramBundle.getString("pubAcc");
    paramBundle = paramBundle.getString("pubAccHint");
    long l2 = System.currentTimeMillis();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("toPay tokenId = ");
    ((StringBuilder)localObject2).append(str1);
    APLog.i("APMidasQQPayHelper", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("toPay appId = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    APLog.i("APMidasQQPayHelper", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("toPay paySerial = ");
    ((StringBuilder)localObject2).append(i);
    APLog.i("APMidasQQPayHelper", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("toPay pubAcc = ");
    ((StringBuilder)localObject2).append(str6);
    APLog.i("APMidasQQPayHelper", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("toPay pubAccHint = ");
    ((StringBuilder)localObject2).append(paramBundle);
    APLog.i("APMidasQQPayHelper", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("toPay sig = ");
    ((StringBuilder)localObject2).append(str4);
    APLog.i("APMidasQQPayHelper", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("toPay sigType = ");
    ((StringBuilder)localObject2).append(str5);
    APLog.i("APMidasQQPayHelper", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("toPay nonce = ");
    ((StringBuilder)localObject2).append(str2);
    APLog.i("APMidasQQPayHelper", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("toPay bargainorId = ");
    ((StringBuilder)localObject2).append(str3);
    APLog.i("APMidasQQPayHelper", ((StringBuilder)localObject2).toString());
    long l3 = System.currentTimeMillis();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("toPay logtime = ");
    ((StringBuilder)localObject2).append(l3 - l2);
    APLog.i("APMidasQQPayHelper", ((StringBuilder)localObject2).toString());
    this.b = new PayApi();
    localObject2 = this.b;
    ((PayApi)localObject2).appId = ((String)localObject1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(i);
    ((PayApi)localObject2).serialNumber = localStringBuilder.toString();
    localObject2 = this.b;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("qwallet");
    localStringBuilder.append((String)localObject1);
    ((PayApi)localObject2).callbackScheme = localStringBuilder.toString();
    localObject1 = this.b;
    ((PayApi)localObject1).tokenId = str1;
    ((PayApi)localObject1).pubAcc = str6;
    ((PayApi)localObject1).pubAccHint = paramBundle;
    ((PayApi)localObject1).nonce = str2;
    ((PayApi)localObject1).timeStamp = l1;
    ((PayApi)localObject1).bargainorId = str3;
    ((PayApi)localObject1).sig = str4;
    ((PayApi)localObject1).sigType = str5;
    this.a.execApi((BaseApi)localObject1);
  }
  
  public void a(Handler paramHandler)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("addObserver observer:");
    ((StringBuilder)???).append(paramHandler);
    APLog.i("APMidasQQPayHelper", ((StringBuilder)???).toString());
    synchronized (this.c)
    {
      if (!this.c.contains(paramHandler)) {
        this.c.add(paramHandler);
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
    synchronized (this.c)
    {
      if (this.c.contains(paramHandler)) {
        this.c.remove(paramHandler);
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
      synchronized (this.c)
      {
        Iterator localIterator = this.c.iterator();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.wd
 * JD-Core Version:    0.7.0.1
 */