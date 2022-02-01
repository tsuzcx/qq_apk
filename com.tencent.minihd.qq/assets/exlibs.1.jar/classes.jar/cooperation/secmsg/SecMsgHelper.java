package cooperation.secmsg;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecMsgHandler;
import com.tencent.mobileqq.app.SecMsgManager;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;

public class SecMsgHelper
{
  public static final int a = 1;
  public static final String a = "SecMsgExtra.MQQ.Receiver";
  public static final int b = 2;
  public static final String b = "com.tencent.mobileqq.secmsg.PushMsg";
  private static final String c = "SecMsgHelper";
  private static final String d = "com.tencent.mobileqq.secmsg.SecMsgRuntime";
  
  public static Dialog a(Activity paramActivity)
  {
    paramActivity = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131492923));
    paramActivity.a("正在加载...");
    return paramActivity;
  }
  
  public static PluginRuntime a(BaseApplicationImpl paramBaseApplicationImpl)
  {
    try
    {
      Class localClass = Class.forName("com.tencent.mobileqq.secmsg.SecMsgRuntime");
      paramBaseApplicationImpl = localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      try
      {
        ClassLoader localClassLoader = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, "secmsg_plugin.apk");
        paramBaseApplicationImpl = localClassLoader.loadClass("com.tencent.mobileqq.secmsg.SecMsgRuntime");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
      }
      catch (ClassNotFoundException paramBaseApplicationImpl)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
      do
      {
        return null;
        paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof PluginRuntime)));
      paramBaseApplicationImpl = (PluginRuntime)paramBaseApplicationImpl;
      return paramBaseApplicationImpl;
    }
    catch (IllegalArgumentException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (IllegalAccessException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InstantiationException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InvocationTargetException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (NoSuchMethodException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    if (paramBaseApplicationImpl == null) {
      return null;
    }
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, int paramInt, Intent paramIntent)
  {
    Object localObject = (SecMsgHandler)paramQQAppInterface.a(42);
    if ((localObject != null) && (SecMsgHandler.a)) {
      QQToast.a(paramActivity, "正在下载插件...", 0).b(paramActivity.getResources().getDimensionPixelSize(2131492923));
    }
    label245:
    do
    {
      return;
      IPluginManager localIPluginManager = (IPluginManager)paramQQAppInterface.getManager(26);
      if ((localIPluginManager != null) && (!localIPluginManager.isPlugininstalled("secmsg_plugin.apk")))
      {
        if (!SecMsgHandler.a)
        {
          SecMsgHandler.l = 3;
          ((SecMsgHandler)localObject).a();
        }
        QQToast.a(paramActivity, "正在下载插件...", 0).b(paramActivity.getResources().getDimensionPixelSize(2131492923));
        return;
      }
      if (paramIntent != null)
      {
        paramIntent = new Intent(paramIntent);
        paramIntent.putExtra("SecMsgExtra.MQQ.Receiver", ((SecMsgManager)paramQQAppInterface.getManager(55)).a);
        paramIntent.putExtra("userQqResources", 2);
        paramIntent.putExtra("useSkinEngine", true);
        localObject = new IPluginManager.PluginParams(1);
        ((IPluginManager.PluginParams)localObject).b = "secmsg_plugin.apk";
        ((IPluginManager.PluginParams)localObject).d = "secmsg_plugin";
        ((IPluginManager.PluginParams)localObject).jdField_a_of_type_JavaLangString = paramQQAppInterface.a();
        if (paramInt != 1) {
          break label245;
        }
      }
      for (((IPluginManager.PluginParams)localObject).e = "com.tencent.mobileqq.secmsg.activity.SecMsgSessionListActivity";; ((IPluginManager.PluginParams)localObject).e = "com.tencent.mobileqq.secmsg.activity.SecMsgSessionCreateActivity")
      {
        if (!a()) {
          ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidAppDialog = a(paramActivity);
        }
        ((IPluginManager.PluginParams)localObject).jdField_a_of_type_JavaLangClass = SecMsgPluginProxyActivity.class;
        ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
        IPluginManager.a(paramActivity, (IPluginManager.PluginParams)localObject);
        return;
        paramIntent = new Intent();
        break;
        if (paramInt != 2) {
          break label260;
        }
      }
    } while (!QLog.isColorLevel());
    label260:
    QLog.e("SecMsgHelper", 2, "Please choose a valid entrace!!!");
  }
  
  public static boolean a()
  {
    Object localObject = ((ActivityManager)BaseApplicationImpl.a().getSystemService("activity")).getRunningAppProcesses();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if ((localRunningAppProcessInfo.processName.startsWith("com.tencent.minihd.qq")) && ("com.tencent.minihd.qq:secmsg".equalsIgnoreCase(localRunningAppProcessInfo.processName))) {
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.secmsg.SecMsgHelper
 * JD-Core Version:    0.7.0.1
 */