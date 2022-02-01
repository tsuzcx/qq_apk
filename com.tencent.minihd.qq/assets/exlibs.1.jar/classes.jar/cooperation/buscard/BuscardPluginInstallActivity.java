package cooperation.buscard;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.format.Time;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qwallet.plugin.QWalletPayProgressDialog;
import cooperation.qwallet.plugin.proxy.QWalletNFCProxyActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lwx;
import lwz;
import lxa;
import lxb;
import mqq.manager.TicketManager;
import org.json.JSONObject;

public class BuscardPluginInstallActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private static final int jdField_a_of_type_Int = 1;
  private static final String jdField_a_of_type_JavaLangString = BuscardPluginInstallActivity.class.getSimpleName();
  private static final String d = "com.tencent.process.exit";
  private long jdField_a_of_type_Long = 0L;
  private Handler jdField_a_of_type_AndroidOsHandler = null;
  private OnPluginInstallListener jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener = new lxa(this);
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
  private IPluginManager jdField_a_of_type_CooperationPluginIPluginManager;
  protected QWalletPayProgressDialog a;
  private lxb jdField_a_of_type_Lxb;
  private String b;
  private String c = null;
  
  public BuscardPluginInstallActivity()
  {
    this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog = null;
    this.jdField_b_of_type_JavaLangString = null;
  }
  
  private String a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer("com.tenpay.android.qqplugin.activity.");
    if ((paramString == null) && (this.c != null)) {
      localStringBuffer.append("RedepositActivity");
    }
    if (("experience".equals(paramString)) || ("recharge".equals(paramString))) {
      localStringBuffer.append("BusCardActivity");
    }
    for (;;)
    {
      return localStringBuffer.toString();
      if ("load".equals(paramString)) {
        localStringBuffer.append("RedepositActivity");
      } else {
        localStringBuffer.append("BusCardActivity");
      }
    }
  }
  
  private String a(ArrayList paramArrayList, boolean paramBoolean)
  {
    Time localTime = new Time();
    localTime.setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.process.exit");
    localStringBuilder.append(localTime.year).append(localTime.month + 1).append(localTime.monthDay);
    localStringBuilder.append(localTime.hour);
    if (paramBoolean)
    {
      localStringBuilder.append(localTime.minute - 1);
      if (paramArrayList != null) {
        break label142;
      }
    }
    label142:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      localStringBuilder.append(paramArrayList);
      paramArrayList = MD5.toMD5(localStringBuilder.toString());
      return MD5.toMD5(paramArrayList + localStringBuilder.toString());
      localStringBuilder.append(localTime.minute);
      break;
    }
  }
  
  private void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "initPluginManager");
    }
    this.jdField_a_of_type_CooperationPluginIPluginManager = ((IPluginManager)this.app.getManager(26));
    if (QLog.isDevelopLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("mPluginManager.SUPPORT_NETWORKING = ");
      IPluginManager localIPluginManager = this.jdField_a_of_type_CooperationPluginIPluginManager;
      QLog.i(str, 4, false);
    }
    a(true);
    new Thread(new lwx(this)).start();
  }
  
  private void a(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "goPlugin " + paramString);
    }
    boolean bool = this.jdField_a_of_type_CooperationPluginIPluginManager.isPlugininstalled("BuscardPlugin.apk");
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "installed=" + bool);
    }
    if (bool) {
      b();
    }
    do
    {
      return;
      this.jdField_a_of_type_CooperationPluginIPluginManager.installPlugin("BuscardPlugin.apk", this.jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener);
      bool = this.jdField_a_of_type_CooperationPluginIPluginManager.isPlugininstalled("BuscardPlugin.apk");
      if (QLog.isDevelopLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 4, "installed=" + bool);
      }
      if (bool)
      {
        b();
        return;
      }
    } while (!a(getApplicationContext()));
    paramString = new Intent("com.tencent.process.exit");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("com.tencent.minihd.qq:buscard");
    paramString.putStringArrayListExtra("procNameList", localArrayList);
    paramString.putExtra("verify", a(localArrayList, false));
    sendBroadcast(paramString);
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "showProgress : " + paramBoolean);
    }
    if (paramBoolean) {
      if (this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog != null) {
        this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.show();
      }
    }
    while ((this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog == null) || (!this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.isShowing()))
    {
      return;
      this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog = new QWalletPayProgressDialog(this);
      this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.setOnDismissListener(new lwz(this));
      this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.show();
      return;
    }
    this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.dismiss();
    this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog = null;
  }
  
  private boolean a(Context paramContext)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "isBuscardProcessExist() begin");
    }
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramContext.hasNext()) {
      if ("com.tencent.minihd.qq:buscard".compareTo(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName) == 0) {
        return true;
      }
    }
    return false;
  }
  
  private void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "launchBuscardPlugin()");
    }
    PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putLong("KEY_BUSCARD_PLUGIN_CREATE_TIME", System.currentTimeMillis()).commit();
    Object localObject = (TicketManager)this.app.getManager(2);
    if (localObject != null)
    {
      localObject = ((TicketManager)localObject).getSid(this.app.a());
      if (getIntent() == null) {
        break label282;
      }
    }
    label282:
    for (Intent localIntent = getIntent();; localIntent = new Intent())
    {
      localIntent.putExtra("skey", (String)localObject);
      localIntent.putExtra("skey_type", "1");
      if (this.c != null) {
        localIntent.putExtra("pay_result", this.c);
      }
      localIntent.putExtra("param_plugin_gesturelock", true);
      localObject = new IPluginManager.PluginParams(0);
      ((IPluginManager.PluginParams)localObject).jdField_b_of_type_JavaLangString = "BuscardPlugin.apk";
      ((IPluginManager.PluginParams)localObject).d = "BuscardPlugin";
      ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidAppDialog = null;
      ((IPluginManager.PluginParams)localObject).jdField_a_of_type_JavaLangString = this.app.a();
      ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent = localIntent;
      ((IPluginManager.PluginParams)localObject).e = a(this.jdField_b_of_type_JavaLangString);
      ((IPluginManager.PluginParams)localObject).jdField_a_of_type_JavaLangClass = QWalletNFCProxyActivity.class;
      ((IPluginManager.PluginParams)localObject).jdField_b_of_type_Int = 19;
      ((IPluginManager.PluginParams)localObject).c = 15000;
      ((IPluginManager.PluginParams)localObject).jdField_a_of_type_Boolean = false;
      ((IPluginManager.PluginParams)localObject).f = null;
      IPluginManager.a(this, (IPluginManager.PluginParams)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
      a(false);
      localObject = new Intent();
      ((Intent)localObject).putExtra("ret", "ok");
      setResult(-1, (Intent)localObject);
      return;
      localObject = "";
      break;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "BuscardPluginInstallActivity doOnCreate()");
    }
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    paramBundle = new IntentFilter();
    paramBundle.addAction("buscard.plugin.onresume.broadcast");
    this.jdField_a_of_type_Lxb = new lxb(this, null);
    registerReceiver(this.jdField_a_of_type_Lxb, paramBundle);
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      paramBundle = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder().append("app is null = ");
      if (this.app != null) {
        break label163;
      }
    }
    label163:
    for (boolean bool = true;; bool = false)
    {
      QLog.i(paramBundle, 4, bool);
      if (this.app.isLogin()) {
        break;
      }
      paramBundle = new Intent();
      paramBundle.setClass(this, LoginActivity.class);
      paramBundle.addFlags(262144);
      startActivity(paramBundle);
      finish();
      return false;
    }
    this.jdField_b_of_type_JavaLangString = null;
    this.c = null;
    paramBundle = getIntent();
    paramBundle.setFlags(0);
    if (paramBundle != null)
    {
      if ("com.tencent.mobileqq.action.Buscard".equals(paramBundle.getAction())) {}
      localObject = paramBundle.getStringExtra("options");
      if (localObject == null) {}
    }
    try
    {
      this.jdField_b_of_type_JavaLangString = new JSONObject((String)localObject).optString("tag");
      this.c = paramBundle.getDataString();
      if (QLog.isDevelopLevel())
      {
        QLog.i(jdField_a_of_type_JavaLangString, 4, "intent = " + paramBundle.toString());
        QLog.i(jdField_a_of_type_JavaLangString, 4, "options = " + paramBundle.getStringExtra("options"));
        QLog.i(jdField_a_of_type_JavaLangString, 4, "mTag = " + this.jdField_b_of_type_JavaLangString);
        QLog.i(jdField_a_of_type_JavaLangString, 4, "mPayResult = " + this.c);
      }
      a();
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected void doOnDestroy()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "doOnDestroy, ready to unregister receiver,mExitReceiver:" + this.jdField_a_of_type_Lxb);
    }
    try
    {
      if (this.jdField_a_of_type_Lxb != null) {
        unregisterReceiver(this.jdField_a_of_type_Lxb);
      }
      super.doOnDestroy();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "onActivityResult:requestCode=" + paramInt1 + ",resultCode=" + paramInt2);
    }
    if ((paramInt1 != 1) || (paramInt2 == 0)) {}
    for (;;)
    {
      if ((paramInt1 == 19) && ((paramInt2 == 20) || (paramInt2 == 4865))) {
        finish();
      }
      return;
      a("onActivityResult");
    }
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (!ProfileActivity.a(this.jdField_a_of_type_Long, l)) {
      return;
    }
    this.jdField_a_of_type_Long = l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.buscard.BuscardPluginInstallActivity
 * JD-Core Version:    0.7.0.1
 */