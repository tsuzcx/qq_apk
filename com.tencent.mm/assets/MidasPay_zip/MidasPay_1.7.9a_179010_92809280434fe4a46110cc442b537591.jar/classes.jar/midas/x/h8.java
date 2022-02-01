package midas.x;

import android.content.Context;
import android.text.TextUtils;
import com.pay.data.report.APDataReportManager;
import com.tencent.midas.comm.APLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class h8
{
  public static String a()
    throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException
  {
    Class localClass = Class.forName("com.tencent.smtt.sdk.TbsConfig");
    Field localField = localClass.getField("TBS_SDK_VERSIONNAME");
    localField.setAccessible(true);
    return (String)localField.get(localClass);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    d6 locald6 = new d6();
    APDataReportManager.getInstance().insertData("sdk.x5.configure", -1, "", "", "");
    if (paramString.equals("0"))
    {
      APLog.e("APX5", "X5 was disabled");
      locald6.a(paramContext.getApplicationContext(), "TencentUnipay", "enableX5", "0");
      APDataReportManager.getInstance().insertData("sdk.x5.disabled", -1, "", "", "");
      return;
    }
    if (paramString.equals("1"))
    {
      locald6.a(paramContext.getApplicationContext(), "TencentUnipay", "enableX5", "1");
      APDataReportManager.getInstance().insertData("sdk.x5.enable", -1, "", "", "");
      APLog.e("APX5", "enable X5");
      return;
    }
    if (paramString.equals("2"))
    {
      locald6.a(paramContext.getApplicationContext(), "TencentUnipay", "enableX5", "2");
      APDataReportManager.getInstance().insertData("sdk.x5.force", -1, "", "", "");
      APLog.e("APX5", "force X5");
      return;
    }
    APLog.e("APX5", "invalid command to enable X5");
  }
  
  public static boolean a(Context paramContext)
  {
    APLog.e("APX5", "init Tbs Start");
    APDataReportManager.getInstance().insertData("sdk.x5.init", -1, "", "", "");
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      localObject = a();
      bool1 = bool2;
      StringBuilder localStringBuilder = new StringBuilder();
      bool1 = bool2;
      localStringBuilder.append("get tbs version: ");
      bool1 = bool2;
      localStringBuilder.append((String)localObject);
      bool1 = bool2;
      APLog.e("APX5", localStringBuilder.toString());
      bool1 = bool2;
      if (b())
      {
        bool1 = bool2;
        APLog.e("APX5", "tbs has initX5 method");
        bool1 = bool2;
        c(paramContext);
        bool2 = true;
        bool1 = true;
        APLog.e("APX5", "init Tbs Success. use X5 instead of Native WebView");
        bool1 = bool2;
      }
      else
      {
        bool1 = bool2;
        APLog.e("APX5", "tbs has no initX5 method");
        bool1 = bool2;
        paramContext = new StringBuilder();
        bool1 = bool2;
        paramContext.append("unsupported tbs, version: ");
        bool1 = bool2;
        paramContext.append((String)localObject);
        bool1 = bool2;
        APLog.e("APX5", paramContext.toString());
        bool1 = bool3;
      }
    }
    finally
    {
      APLog.e("APX5", "init tbs failed, use native WebView!");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unsupported tbs: exception: ");
      ((StringBuilder)localObject).append(paramContext.getMessage());
      APLog.e("APX5", ((StringBuilder)localObject).toString());
    }
    APLog.e("APX5", "initTbs End");
    Object localObject = APDataReportManager.getInstance();
    if (bool1) {
      paramContext = "sdk.x5.support";
    } else {
      paramContext = "sdk.x5.not.support";
    }
    ((APDataReportManager)localObject).insertData(paramContext, -1, "", "", "");
    return bool1;
  }
  
  public static void b(Context paramContext)
  {
    APLog.e("APX5", ">>>>>>> init X5 Start <<<<<<<");
    if (!d(paramContext.getApplicationContext()))
    {
      APLog.e("APX5", ">>>>>>> X5 is missed or disabled, use native WebView");
      return;
    }
    APLog.e("APX5", ">>>>>>> init X5 End <<<<<<<");
  }
  
  public static boolean b()
  {
    boolean bool = false;
    try
    {
      Object localObject = Class.forName("com.tencent.smtt.sdk.QbSdk");
      localObject = ((Class)localObject).getMethod("initX5Environment", new Class[] { Context.class, Class.forName("com.tencent.smtt.sdk.QbSdk$PreInitCallback") });
      if (localObject != null) {
        bool = true;
      }
      return bool;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
      return false;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
    }
    return false;
  }
  
  public static void c(Context paramContext)
  {
    new Thread(new a(paramContext)).start();
  }
  
  public static boolean d(Context paramContext)
  {
    String str = new d6().a(paramContext.getApplicationContext(), "TencentUnipay", "enableX5");
    boolean bool;
    if (!TextUtils.isEmpty(str)) {
      bool = str.equals("0") ^ true;
    } else {
      bool = true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("is enable X5: ");
    localStringBuilder.append(str);
    APLog.e("APX5", localStringBuilder.toString());
    return (bool) && (a(paramContext.getApplicationContext()));
  }
  
  public static final class a
    implements Runnable
  {
    public a(Context paramContext) {}
    
    public void run()
    {
      try
      {
        Object localObject = Class.forName("com.tencent.smtt.sdk.QbSdk");
        localObject = ((Class)localObject).getMethod("initX5Environment", new Class[] { Context.class, Class.forName("com.tencent.smtt.sdk.QbSdk$PreInitCallback") });
        if (localObject != null)
        {
          ((Method)localObject).setAccessible(true);
          ((Method)localObject).invoke(null, new Object[] { this.a.getApplicationContext(), null });
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.h8
 * JD-Core Version:    0.7.0.1
 */