package cooperation.qqdataline;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import java.util.Iterator;
import java.util.List;
import lyt;
import lyu;

public class DatalinePluginProxyActivity
  extends PluginProxyActivity
{
  private static final String a = "qqdataline";
  
  private static Class a(Intent paramIntent, String paramString)
  {
    if ((paramString != null) && (paramString.equals("com.qqdataline.activity.LiteWifiphotoActivity"))) {
      paramIntent.setFlags(paramIntent.getFlags() | 0x20000000);
    }
    if ((paramIntent.getFlags() & 0x20000000) != 0) {
      return DatalinePluginProxyActivity.SingleTop.class;
    }
    return DatalinePluginProxyActivity.class;
  }
  
  public static void a(Activity paramActivity, String paramString1, Intent paramIntent, String paramString2, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    boolean bool = a(paramActivity);
    if (QLog.isColorLevel()) {
      QLog.d("qqdataline", 2, "launchPluingActivityForResult.isPluginInstalled end: " + bool);
    }
    Object localObject = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131492923));
    if ((!bool) || (paramOnDismissListener != null))
    {
      ((QQProgressDialog)localObject).a("正在加载...");
      ((QQProgressDialog)localObject).setOnDismissListener(new lyt(paramOnDismissListener));
      paramOnDismissListener = (DialogInterface.OnDismissListener)localObject;
      if (bool) {
        ((QQProgressDialog)localObject).setOnShowListener(new lyu((QQProgressDialog)localObject));
      }
    }
    for (paramOnDismissListener = (DialogInterface.OnDismissListener)localObject;; paramOnDismissListener = null)
    {
      paramIntent.putExtra("userQqResources", 1);
      localObject = new IPluginManager.PluginParams(0);
      ((IPluginManager.PluginParams)localObject).jdField_b_of_type_JavaLangString = "qqdataline.apk";
      ((IPluginManager.PluginParams)localObject).d = "数据线";
      ((IPluginManager.PluginParams)localObject).jdField_a_of_type_JavaLangString = paramString1;
      ((IPluginManager.PluginParams)localObject).e = paramString2;
      ((IPluginManager.PluginParams)localObject).jdField_a_of_type_JavaLangClass = a(paramIntent, paramString2);
      ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
      ((IPluginManager.PluginParams)localObject).jdField_b_of_type_Int = paramInt;
      ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidAppDialog = paramOnDismissListener;
      ((IPluginManager.PluginParams)localObject).c = 10000;
      ((IPluginManager.PluginParams)localObject).f = null;
      IPluginManager.a(paramActivity, (IPluginManager.PluginParams)localObject);
      return;
    }
  }
  
  private static boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext()) {
      if ("com.tencent.minihd.qq:dataline".compareTo(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName) == 0) {
        return true;
      }
    }
    return false;
  }
  
  public String getPluginID()
  {
    return "qqdataline.apk";
  }
  
  protected Class getProxyActivity(String paramString)
  {
    if (paramString.equals("com.qqdataline.activity.LiteWifiphotoActivity")) {
      return DatalinePluginProxyActivity.SingleTop.class;
    }
    return super.getProxyActivity(paramString);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!TextUtils.isEmpty(this.mCreateErrorInfo)) {
      if (paramBundle == null) {
        break label65;
      }
    }
    for (;;)
    {
      paramBundle = paramBundle.getString("pluginsdk_launchActivity");
      StringBuffer localStringBuffer = new StringBuffer("[插件Activity启动] ");
      localStringBuffer.append(paramBundle).append(" ").append(this.mCreateErrorInfo);
      QLog.e("qqdataline", 1, localStringBuffer.toString());
      return;
      label65:
      paramBundle = getIntent().getExtras();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qqdataline.DatalinePluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */