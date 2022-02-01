package midas.x;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.midas.comm.APLog;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import java.lang.reflect.Field;

public class n1
{
  public static String c = "unknown";
  public Tencent a;
  public IUiListener b;
  
  public static boolean a()
  {
    boolean bool = false;
    try
    {
      Object localObject = Class.forName("com.tencent.tauth.Tencent");
      localObject = ((Class)localObject).getMethod("login", new Class[] { Activity.class, String.class, Class.forName("com.tencent.tauth.IUiListener") });
      if (localObject != null) {
        bool = true;
      }
      return bool;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      APLog.e("APOpensdk", "can not find <login> method in <com.tencent.tauth.Tencent> class");
      APLog.e("APOpensdk", localNoSuchMethodException.getMessage());
      return false;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      APLog.e("APOpensdk", localClassNotFoundException.getMessage());
    }
    return false;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    try
    {
      Tencent.onActivityResultData(paramInt1, paramInt2, paramIntent, this.b);
      return;
    }
    catch (Exception paramIntent)
    {
      APLog.e("APOpenSDK", paramIntent.getMessage());
      paramIntent.printStackTrace();
      return;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OpenSDK version: ");
      localStringBuilder.append(c);
      localStringBuilder.append(" didn't find onActivityResultData(), try handleResultData()");
      APLog.e("APOpenSDK", localStringBuilder.toString());
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      try
      {
        Tencent.handleResultData(paramIntent, this.b);
        return;
      }
      catch (Exception paramIntent)
      {
        APLog.e("APOpenSDK", paramIntent.getMessage());
        paramIntent.printStackTrace();
        return;
        paramIntent = new StringBuilder();
        paramIntent.append("OpenSDK version: ");
        paramIntent.append(c);
        paramIntent.append(" didn't find handleResultData()");
        APLog.e("APOpenSDK", paramIntent.toString());
        return;
        localNoSuchMethodError = localNoSuchMethodError;
      }
      catch (NoSuchMethodError paramIntent)
      {
        label95:
        break label95;
      }
    }
  }
  
  public void a(Activity paramActivity, l1 paraml1)
  {
    this.b = new o1(paraml1);
    try
    {
      this.a.login(paramActivity, "all", this.b);
      return;
    }
    catch (Exception paramActivity)
    {
      APLog.e("APOpenSDK", paramActivity.getMessage());
    }
  }
  
  public void a(Context paramContext, String paramString)
  {
    if (this.a == null) {
      this.a = Tencent.createInstance(paramString, paramContext);
    }
    try
    {
      paramContext = Class.forName("com.tencent.connect.common.Constants");
      c = paramContext.getField("SDK_VERSION").get(paramContext).toString();
      paramContext = new StringBuilder();
      paramContext.append("OpenSDK version: ");
      paramContext.append(c);
      APLog.e("APOpenSDK", paramContext.toString());
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.n1
 * JD-Core Version:    0.7.0.1
 */