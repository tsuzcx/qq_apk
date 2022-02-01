package cooperation.thirdpay;

import CardPay.Channel;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginInterface;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteResultCallback;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qwallet.plugin.QWalletPayProgressDialog;
import java.math.BigDecimal;
import mei;
import mej;
import mek;
import mel;
import mem;
import men;
import mep;

public class ThirdPayGate
{
  private static final String CARDPAY_IPC_COMMAND_CANCELINSTALLPLUGIN = "cardpay.cancleinstallplugin";
  private static final String CARDPAY_IPC_COMMAND_INSTALLPLUGIN = "cardpay.installplugin";
  private static final String CARDPAY_IPC_COMMAND_OUT = "cardpay.out";
  private static final String CARDPAY_IPC_COMMAND_QUERYPLUGININFO = "cardpay.QueryPluginInfo";
  private static final int CARDPAY_STARTPLUGIN_REQUESTCODE = 4352;
  private static final int FLOW_TIMEOUT = 4097;
  public static final int MAX_QUERY_DL_PLUGIN_TIMEOUT = 5000;
  public static final int MAX_QUERY_INSTALL_PLUGIN_TIMEOUT = 15000;
  private static final String NFCPAY_IPC_COMMAND_REQCHANNEL = "cardpay.reqchannel";
  public static final int PERIOD_QUERY = 1000;
  private QWalletPayProgressDialog startDialog;
  
  private void _newInstallPlugin(Activity paramActivity, PluginInterface paramPluginInterface, Bundle paramBundle, String paramString)
  {
    if ((this.startDialog != null) && (!this.startDialog.isShowing())) {
      this.startDialog.show();
    }
    long l = System.currentTimeMillis();
    if (paramPluginInterface != null) {}
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.w("CardPay", 2, "installPlugin null == mPluginInterface || TextUtils.isEmpty(pluginId)");
        return;
      }
      localObject1 = (Channel)paramBundle.getSerializable("channel");
      if (localObject1 == null) {
        throw new IllegalAccessException("channel is null");
      }
    }
    catch (Exception paramPluginInterface)
    {
      paramPluginInterface.printStackTrace();
      Toast.makeText(paramActivity.getApplicationContext(), "启动失败，请重试或者选择其他渠道进行支付！", 1).show();
      if (paramBundle.getBoolean("isactivityfinish")) {
        paramActivity.finish();
      }
      ReportController.a(null, "P_CliOper", "cardpay", "", "installPlugin", "download-fail", 0, 0, paramString, "by exception", "", "");
      return;
    }
    if (TextUtils.isEmpty(((Channel)localObject1).pluginName)) {
      throw new IllegalAccessException("pluginname is empty");
    }
    Object localObject2 = new mek(this, paramBundle, paramActivity);
    localObject2 = DialogUtil.a(paramActivity, 0, "下载失败", "当前网络不给力，下载失败", "取消", "继续下载", new mel(this, paramString, paramPluginInterface, paramActivity, paramBundle), (DialogInterface.OnClickListener)localObject2);
    ((QQCustomDialog)localObject2).setCancelable(false);
    Object localObject1 = new men(this, paramPluginInterface, paramString, System.currentTimeMillis(), new mem(this, paramString, l, (Channel)localObject1, paramBundle, paramActivity, (QQCustomDialog)localObject2));
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("pluginid", paramString);
    paramPluginInterface.transfer("cardpay.installplugin", (Bundle)localObject2);
    ThreadManager.b((Runnable)localObject1);
  }
  
  private void _showStartAllTip(Activity paramActivity, PluginInterface paramPluginInterface, Bundle paramBundle, String paramString)
  {
    if ((paramPluginInterface == null) || (paramActivity == null)) {
      if (QLog.isColorLevel()) {
        QLog.w("CardPay", 2, "showDownLoadTip null == mPluginInterface || TextUtils.isEmpty(pluginId)");
      }
    }
    Channel localChannel;
    do
    {
      return;
      localChannel = (Channel)paramBundle.getSerializable("channel");
      if (localChannel != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("CardPay", 2, "showDownLoadTip null == channel");
    return;
    if ((localChannel != null) && (localChannel.pluginSize > 0L))
    {
      float f = new BigDecimal((float)localChannel.pluginSize * 1.0E-006F).setScale(3, 4).floatValue();
      new StringBuilder().append("").append(f).toString();
    }
    this.startDialog.show();
    if (NetworkUtil.f(paramActivity))
    {
      ReportController.a(null, "P_CliOper", "cardpay", "", "installPlugin", "stardownload", 0, 0, paramString, "", "", "");
      _newInstallPlugin(paramActivity, paramPluginInterface, paramBundle, paramString);
      return;
    }
    this.startDialog.dismiss();
    paramActivity = DialogUtil.a(paramActivity, 0, "", "当前网络不可用，请检查网络设置！", "确定", "", null, new mej(this, paramBundle, paramActivity));
    paramActivity.setCancelable(false);
    paramActivity.show();
  }
  
  private void cancelInstallPlugin(PluginInterface paramPluginInterface, String paramString)
  {
    if ((paramPluginInterface == null) || (TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.w("CardPay", 2, "cancelInstallPlugin null == mPluginInterface || TextUtils.isEmpty(pluginId)");
      }
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("pluginid", paramString);
    paramPluginInterface.transfer("cardpay.cancleinstallplugin", localBundle);
  }
  
  public static ThirdPayGate getInstance()
  {
    return mep.a;
  }
  
  private void preStartPlugin(Bundle paramBundle, Activity paramActivity, PluginInterface paramPluginInterface)
  {
    Channel localChannel;
    try
    {
      localChannel = (Channel)paramBundle.getSerializable("channel");
      if (localChannel != null) {
        break label137;
      }
      throw new IllegalAccessException("channel is null");
    }
    catch (Exception paramPluginInterface)
    {
      paramPluginInterface.printStackTrace();
      if (paramBundle.getBoolean("isactivityfinish")) {
        paramActivity.finish();
      }
      if (!(paramPluginInterface instanceof IllegalAccessException)) {
        break label63;
      }
    }
    if (!"channel is null".equals(paramPluginInterface.getMessage())) {
      label63:
      if ("pluginname is empty".equals(paramPluginInterface.getMessage())) {
        paramBundle = "unknown";
      }
    }
    for (;;)
    {
      ReportController.a(null, "P_CliOper", "cardpay", "", "payViaPlugin", "fail", 0, 0, paramBundle + ".apk", "by exception", "", "");
      Toast.makeText(paramActivity.getApplicationContext(), "启动失败，请重试或者选择其他渠道进行支付！", 1).show();
      return;
      label137:
      if (TextUtils.isEmpty(localChannel.pluginName)) {
        throw new IllegalAccessException("pluginname is empty");
      }
      if (this.startDialog == null) {
        this.startDialog = new QWalletPayProgressDialog(paramActivity);
      }
      Object localObject = queryPluginInfo(paramPluginInterface, localChannel.pluginName + ".apk");
      if ((localObject != null) && (((Bundle)localObject).getBoolean("plugininfo", false)))
      {
        int i = ((Bundle)localObject).getInt("pluginstate");
        if (i == 4)
        {
          if (QLog.isColorLevel()) {
            QLog.i("CardPayGate", 2, "has been installed,start it");
          }
          startPlugin(paramBundle, paramActivity, localChannel.pluginName + ".apk");
          return;
        }
        if (i == 1) {
          cancelInstallPlugin(paramPluginInterface, localChannel.pluginName + ".apk");
        }
      }
      ReportController.a(null, "P_CliOper", "cardpay", "", "installPlugin", "showDownLoadTip", 0, 0, localChannel.pluginName + ".apk", "", "", "");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("has not been installed,show tip activity is null?");
        if (paramActivity != null) {
          break label447;
        }
      }
      label447:
      for (boolean bool = true;; bool = false)
      {
        QLog.i("CardPayGate", 2, bool);
        _showStartAllTip(paramActivity, paramPluginInterface, paramBundle, localChannel.pluginName + ".apk");
        return;
      }
      paramBundle = (Channel)paramBundle.getSerializable("channel");
      if (paramBundle != null) {
        paramBundle = paramBundle.pluginName;
      } else {
        paramBundle = "unknown";
      }
    }
  }
  
  private Bundle queryPluginInfo(PluginInterface paramPluginInterface, String paramString)
  {
    if ((paramPluginInterface == null) || (TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.w("CardPay", 2, "queryPluginInfo null == mPluginInterface || TextUtils.isEmpty(pluginId)");
      }
      return null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("pluginid", paramString);
    return paramPluginInterface.transfer("cardpay.QueryPluginInfo", localBundle);
  }
  
  private void startPlugin(Bundle paramBundle, Activity paramActivity, String paramString)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = (Channel)paramBundle.getSerializable("channel");
        if (localObject == null) {
          throw new IllegalAccessException("channel is null");
        }
      }
      catch (Exception localException1)
      {
        str = "";
        if (QLog.isColorLevel()) {
          QLog.e("CardPay", 2, localException1.getMessage());
        }
        localException1.printStackTrace();
        paramBundle = new mei(this, paramBundle, paramActivity);
        ReportController.a(null, "P_CliOper", "cardpay", "", "openplugin", "fail", 0, 0, paramString, "", "", "");
        DialogUtil.a(paramActivity, 0, "", "启动" + str + "支付插件失败", "确定", "", null, paramBundle).show();
        return;
        if (TextUtils.isEmpty(((Channel)localObject).pluginName)) {
          throw new IllegalAccessException("pluginname is empty");
        }
      }
      finally {}
      String str = ((Channel)localObject).channelName;
      try
      {
        IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
        localPluginParams.jdField_b_of_type_JavaLangString = (((Channel)localObject).pluginName + ".apk");
        localPluginParams.d = ((Channel)localObject).pluginName;
        localPluginParams.jdField_a_of_type_JavaLangString = paramBundle.getString("uin");
        Intent localIntent = new Intent();
        localIntent.putExtra("userQqResources", -1);
        localIntent.putExtra("pluginId", ((Channel)localObject).pluginName + ".apk");
        localIntent.putExtra("orderInfo", paramBundle);
        localIntent.putExtra("param_plugin_gesturelock", true);
        localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
        localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
        localPluginParams.e = "com.tencent.mobileqq.thirdpay.PayMainActivity";
        if (((Channel)localObject).isNFC == 1)
        {
          localPluginParams.jdField_a_of_type_JavaLangClass = NFCPayPluginProxyActivity.class;
          label347:
          localPluginParams.jdField_b_of_type_Int = 4352;
          localPluginParams.c = 20000;
          localPluginParams.jdField_a_of_type_Boolean = false;
          localPluginParams.jdField_a_of_type_AndroidAppDialog = this.startDialog;
          localPluginParams.jdField_a_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.i("ThirdPayGate", 2, "startPlugin：" + System.currentTimeMillis());
          }
          localObject = BaseApplication.getContext();
          if (Build.VERSION.SDK_INT <= 10) {
            break label554;
          }
        }
        label554:
        for (int i = 4;; i = 0)
        {
          localObject = ((Context)localObject).getSharedPreferences("mobileQQ", i);
          if (localObject != null) {
            ((SharedPreferences)localObject).edit().putString("nfc_cur_pluginid", paramString).commit();
          }
          IPluginManager.a(paramActivity, localPluginParams);
          ReportController.a(null, "P_CliOper", "cardpay", "", "openplugin", "suc", 0, 0, paramString, "", "", "");
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("ThirdPayGate", 2, "startPlugin end：" + System.currentTimeMillis());
          break;
          localPluginParams.jdField_a_of_type_JavaLangClass = ThirdPayPluginProxyActivity.class;
          break label347;
        }
      }
      catch (Exception localException2) {}
    }
  }
  
  public void getPayMethods(PluginInterface paramPluginInterface, RemoteResultCallback paramRemoteResultCallback)
  {
    if ((paramPluginInterface == null) || (paramRemoteResultCallback == null)) {}
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.w("CardPay", 2, "getPayMethods null == mPluginInterface || null == mRemoteCallback");
        }
        return;
      }
      finally {}
      paramPluginInterface.transferAsync("cardpay.reqchannel", new Bundle(), paramRemoteResultCallback);
    }
  }
  
  public void notifyOut(PluginInterface paramPluginInterface)
  {
    if (paramPluginInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CardPay", 2, "notifyOut null == mPluginInterface");
      }
      return;
    }
    paramPluginInterface.transfer("cardpay.out", new Bundle());
  }
  
  public void payViaPlugin(Bundle paramBundle, Activity paramActivity, PluginInterface paramPluginInterface)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("ThirdPayGate", 2, "payViaPlugin：" + System.currentTimeMillis());
        }
        localObject = (Channel)paramBundle.getSerializable("channel");
        if (localObject != null)
        {
          localObject = ((Channel)localObject).pluginName;
          ReportController.a(null, "P_CliOper", "cardpay", "", "payViaPlugin", "tap", 0, 0, (String)localObject + ".apk", "", "", "");
          preStartPlugin(paramBundle, paramActivity, paramPluginInterface);
          return;
        }
      }
      finally {}
      Object localObject = "unknown";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.thirdpay.ThirdPayGate
 * JD-Core Version:    0.7.0.1
 */