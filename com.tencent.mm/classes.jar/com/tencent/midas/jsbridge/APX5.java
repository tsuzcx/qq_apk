package com.tencent.midas.jsbridge;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.data.APPluginDataInterface;
import com.tencent.midas.data.APPluginReportManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class APX5
{
  private static String getTbsVersion()
  {
    AppMethodBeat.i(192829);
    try
    {
      Object localObject = Class.forName("com.tencent.smtt.sdk.TbsConfig");
      Field localField = ((Class)localObject).getField("TBS_SDK_VERSIONNAME");
      localField.setAccessible(true);
      localObject = (String)localField.get(localObject);
      AppMethodBeat.o(192829);
      return localObject;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      AppMethodBeat.o(192829);
      return "unknown";
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label40;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label40:
      break label40;
    }
  }
  
  private static boolean hasInitX5Method()
  {
    AppMethodBeat.i(192825);
    try
    {
      if (Class.forName("com.tencent.smtt.sdk.QbSdk").getMethod("initX5Environment", new Class[] { Context.class, Class.forName("com.tencent.smtt.sdk.QbSdk$PreInitCallback") }) != null)
      {
        AppMethodBeat.o(192825);
        return true;
      }
      AppMethodBeat.o(192825);
      return false;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      AppMethodBeat.o(192825);
      return false;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label50:
      break label50;
    }
  }
  
  private static boolean initTbs(Context paramContext)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    AppMethodBeat.i(192823);
    APLog.e("APX5", "init Tbs Start");
    APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), "sdk.plugin.x5.init", "", "");
    for (boolean bool1 = bool3;; bool1 = bool2)
    {
      try
      {
        localObject = getTbsVersion();
        bool1 = bool3;
        APLog.e("APX5", "get tbs version: ".concat(String.valueOf(localObject)));
        bool1 = bool3;
        if (!hasInitX5Method()) {
          break label140;
        }
        bool1 = bool3;
        APLog.e("APX5", "tbs has initX5 method");
        bool1 = bool3;
        initX5Environment(paramContext);
        bool1 = true;
        bool2 = true;
        APLog.e("APX5", "init Tbs Success. use X5 instead of Native WebView");
        bool1 = bool2;
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          Object localObject;
          String str;
          label140:
          APLog.e("APX5", "init tbs failed, use native WebView!");
          APLog.e("APX5", "unsupported tbs: exception: " + paramContext.getMessage());
          continue;
          paramContext = "sdk.plugin.x5.init.fail";
        }
      }
      APLog.e("APX5", "initTbs End");
      localObject = APPluginReportManager.getInstance();
      str = APPluginDataInterface.singleton().getLaunchInterface();
      if (!bool1) {
        break;
      }
      paramContext = "sdk.plugin.x5.init.success";
      ((APPluginReportManager)localObject).insertData(str, paramContext, "", "");
      AppMethodBeat.o(192823);
      return bool1;
      bool1 = bool3;
      APLog.e("APX5", "tbs has no initX5 method");
      bool1 = bool3;
      APLog.e("APX5", "unsupported tbs, version: ".concat(String.valueOf(localObject)));
    }
  }
  
  public static void initX5(Context paramContext)
  {
    AppMethodBeat.i(192822);
    APLog.e("APX5", ">>>>>>> initX5 Start <<<<<<<");
    if (!isX5Enabled(paramContext))
    {
      APLog.e("APX5", ">>>>>>> X5 is missed or disabled, use native WebView");
      AppMethodBeat.o(192822);
      return;
    }
    APLog.e("APX5", ">>>>>>> initX5 End <<<<<<<");
    AppMethodBeat.o(192822);
  }
  
  private static void initX5Environment(Context paramContext)
  {
    AppMethodBeat.i(192826);
    new Thread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(192811);
        try
        {
          Method localMethod = Class.forName("com.tencent.smtt.sdk.QbSdk").getMethod("initX5Environment", new Class[] { Context.class, Class.forName("com.tencent.smtt.sdk.QbSdk$PreInitCallback") });
          if (localMethod != null)
          {
            localMethod.setAccessible(true);
            localMethod.invoke(null, new Object[] { this.val$context.getApplicationContext(), null });
          }
          AppMethodBeat.o(192811);
          return;
        }
        catch (Exception localException)
        {
          AppMethodBeat.o(192811);
        }
      }
    }).start();
    AppMethodBeat.o(192826);
  }
  
  public static boolean isX5Enabled(Context paramContext)
  {
    AppMethodBeat.i(192824);
    paramContext = paramContext.getApplicationContext();
    String str = paramContext.getSharedPreferences("TencentUnipay", 4).getString("enableX5", "1");
    int i;
    if (!TextUtils.isEmpty(str)) {
      if (!str.equals("0")) {
        i = 1;
      }
    }
    for (;;)
    {
      APLog.e("APX5", "is enable X5: ".concat(String.valueOf(str)));
      if ((i != 0) && (initTbs(paramContext)))
      {
        AppMethodBeat.o(192824);
        return true;
        i = 0;
      }
      else
      {
        AppMethodBeat.o(192824);
        return false;
        i = 1;
      }
    }
  }
  
  private static boolean needDownloadTbs(Context paramContext)
  {
    AppMethodBeat.i(192827);
    try
    {
      Method localMethod = Class.forName("com.tencent.smtt.sdk.TbsDownloader").getMethod("needDownload", new Class[] { Context.class });
      if (localMethod != null)
      {
        localMethod.setAccessible(true);
        boolean bool = ((Boolean)localMethod.invoke(null, new Object[] { paramContext })).booleanValue();
        AppMethodBeat.o(192827);
        return bool;
      }
    }
    catch (IllegalAccessException paramContext)
    {
      AppMethodBeat.o(192827);
      return false;
    }
    catch (InvocationTargetException paramContext)
    {
      break label62;
    }
    catch (NoSuchMethodException paramContext)
    {
      break label62;
    }
    catch (ClassNotFoundException paramContext)
    {
      label62:
      break label62;
    }
  }
  
  private static void preInit(Context paramContext)
  {
    AppMethodBeat.i(192828);
    try
    {
      Method localMethod = Class.forName("com.tencent.smtt.sdk.QbSdk").getMethod("preInit", new Class[] { Context.class });
      if (localMethod != null)
      {
        localMethod.setAccessible(true);
        localMethod.invoke(null, new Object[] { paramContext });
      }
      AppMethodBeat.o(192828);
      return;
    }
    catch (ClassNotFoundException paramContext)
    {
      AppMethodBeat.o(192828);
      return;
    }
    catch (NoSuchMethodException paramContext)
    {
      AppMethodBeat.o(192828);
      return;
    }
    catch (InvocationTargetException paramContext)
    {
      AppMethodBeat.o(192828);
      return;
    }
    catch (IllegalAccessException paramContext)
    {
      AppMethodBeat.o(192828);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.midas.jsbridge.APX5
 * JD-Core Version:    0.7.0.1
 */