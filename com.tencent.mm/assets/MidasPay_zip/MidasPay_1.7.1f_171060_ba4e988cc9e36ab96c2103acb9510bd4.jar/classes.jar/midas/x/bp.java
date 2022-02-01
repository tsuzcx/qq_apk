package midas.x;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.midas.comm.APLog;
import java.lang.reflect.Field;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.WtloginHelper.QuickLoginParam;

public class bp
{
  public static String a = "unknown";
  private static WtloginHelper c;
  private final int b = -1001;
  private long d;
  private bk e;
  
  public static boolean a()
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
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onActivityResult resultCode ");
    localStringBuilder.append(paramInt2);
    APLog.e("APWtloginSDK", localStringBuilder.toString());
    if ((paramInt1 == 1201) || (paramInt1 == 1202)) {
      if (-1 == paramInt2)
      {
        c.SetListener(new bo(this.e));
        paramInt1 = c.onQuickLoginActivityResultData(b(), paramIntent);
        if (-1001 != paramInt1)
        {
          paramIntent = this.e;
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
        this.e.b();
      }
    }
  }
  
  public void a(Activity paramActivity, bk parambk)
  {
    this.e = parambk;
    try
    {
      c.quickLogin(paramActivity, this.d, 1L, "1.0.1", null);
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
    this.d = Long.parseLong(paramString);
    try
    {
      paramContext = Class.forName("oicq.wlogin_sdk.tools.util");
      a = paramContext.getField("SDK_VERSION").get(paramContext).toString();
      paramContext = new StringBuilder();
      paramContext.append("APWtloginSDK version: ");
      paramContext.append(a);
      APLog.i("APWtloginSDK", paramContext.toString());
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public WtloginHelper.QuickLoginParam b()
  {
    WtloginHelper.QuickLoginParam localQuickLoginParam = new WtloginHelper.QuickLoginParam();
    localQuickLoginParam.appid = this.d;
    localQuickLoginParam.sigMap = 4096;
    return localQuickLoginParam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.bp
 * JD-Core Version:    0.7.0.1
 */