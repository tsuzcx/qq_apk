package midas.x;

import android.app.Activity;
import android.content.Context;
import com.tencent.midas.comm.APLog;
import com.unionpay.UPPayAssistEx;
import java.lang.reflect.Field;

public class s5
{
  public static int a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("orderInfo:");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("mode:");
    localStringBuilder.append(paramString4);
    APLog.d("APUnionPaySDK", localStringBuilder.toString());
    try
    {
      UPPayAssistEx.startPay(paramActivity, paramString1, paramString2, paramString3, "00");
      return 0;
    }
    finally
    {
      label62:
      break label62;
    }
    APLog.w("APUnionPaySDK", "启动闪付SDK异常");
    return -1;
  }
  
  public static String a()
  {
    try
    {
      Object localObject1 = Class.forName("com.unionpay.UPPayAssistEx");
      localObject1 = ((Class)localObject1).getField("VERSION").get(localObject1).toString();
      return localObject1;
    }
    finally
    {
      label22:
      break label22;
    }
    return "";
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      boolean bool = UPPayAssistEx.checkWalletInstalled(paramContext);
      return bool;
    }
    finally
    {
      label7:
      break label7;
    }
    APLog.w("APUnionPaySDK", "未集成云闪付SDK");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.s5
 * JD-Core Version:    0.7.0.1
 */