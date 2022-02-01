package midas.x;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.midas.comm.APLog;
import java.lang.reflect.Field;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.WtloginHelper.QuickLoginParam;

public class q1
{
  public static WtloginHelper c;
  public static String d = "unknown";
  public long a;
  public l1 b;
  
  public static boolean b()
  {
    try
    {
      Class.forName("oicq.wlogin_sdk.request.WtloginHelper");
      Class.forName("oicq.wlogin_sdk.request.WtloginListener");
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label14:
      break label14;
    }
    APLog.e("APWtloginSDK", "hasWtloginSDK() false");
    return false;
  }
  
  public WtloginHelper.QuickLoginParam a()
  {
    WtloginHelper.QuickLoginParam localQuickLoginParam = new WtloginHelper.QuickLoginParam();
    localQuickLoginParam.appid = this.a;
    localQuickLoginParam.sigMap = 4096;
    return localQuickLoginParam;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onActivityResult resultCode ");
    localStringBuilder.append(paramInt2);
    APLog.e("APWtloginSDK", localStringBuilder.toString());
    if ((paramInt1 == 1201) || (paramInt1 == 1202)) {
      if (-1 == paramInt2)
      {
        c.SetListener(new p1(this.b));
        paramInt1 = c.onQuickLoginActivityResultData(a(), paramIntent);
        if (-1001 != paramInt1)
        {
          paramIntent = this.b;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onQuickLoginActivityResultData failed ");
          localStringBuilder.append(paramInt1);
          paramIntent.a(-1001, localStringBuilder.toString());
          paramIntent = new StringBuilder();
          paramIntent.append("onActivityResult onQuickLoginActivityResultData failed ");
          paramIntent.append(paramInt1);
          APLog.e("APWtloginSDK", paramIntent.toString());
        }
      }
      else
      {
        APLog.i("APWtloginSDK", "onActivityResult onCancel ");
        this.b.b();
      }
    }
  }
  
  public void a(Activity paramActivity, l1 paraml1)
  {
    this.b = paraml1;
    try
    {
      c.quickLogin(paramActivity, this.a, 1L, "1.0.1", null);
      return;
    }
    catch (Exception paramActivity)
    {
      APLog.e("APWtloginSDK", paramActivity.getMessage());
    }
  }
  
  public void a(Context paramContext, String paramString)
  {
    if (c == null) {
      c = new WtloginHelper(paramContext);
    }
    this.a = Long.parseLong(paramString);
    try
    {
      paramContext = Class.forName("oicq.wlogin_sdk.tools.util");
      d = paramContext.getField("SDK_VERSION").get(paramContext).toString();
      paramContext = new StringBuilder();
      paramContext.append("APWtloginSDK version: ");
      paramContext.append(d);
      APLog.i("APWtloginSDK", paramContext.toString());
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.q1
 * JD-Core Version:    0.7.0.1
 */