package cooperation.qwallet.plugin;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qwallet.plugin.ipc.QWalletResultReceiver;
import cooperation.thirdpay.ThirdPayManager;
import cooperation.thirdpay.ThirdPayRemoteCommand;
import java.util.Iterator;
import java.util.List;
import mad;
import org.json.JSONException;
import org.json.JSONObject;

public class QWalletHelper
{
  public static final String A = "QWalletExtra.MQQ.INFO.THR.RedPointId";
  public static final String B = "QWalletExtra.MQQ.INFO.THR.RedPointDesc";
  public static final String C = "QWalletExtra.MQQ.INFO.THR.RedPointContent";
  public static final String D = "QWalletExtra.PayBridge.PayBundle";
  public static final String E = "QWalletExtra.PayBridge.PayTimeStart";
  public static final String F = "QWallet.load.beginTime";
  public static final String G = "QWalletExtra.isFling";
  private static final String H = "Q.qwallet.";
  private static final String I = "com.tencent.minihd.qq:qwallet";
  private static QQAppInterface a;
  public static final String a = "Q.qwallet.pay";
  public static final String b = "Q.qwallet.home";
  public static final String c = "Q.qwallet.realevent";
  public static final String d = "Q.qwallet.open";
  public static final String e = "Q.qwallet.push";
  public static final String f = "Q.qwallet.auth";
  public static final String g = "QWalletExtra.Account.Uin";
  public static final String h = "QWalletExtra.Account.NickName";
  public static final String i = "QWalletExtra.MQQ.APPID";
  public static final String j = "QWalletExtra.MQQ.GUID";
  public static final String k = "QWalletExtra.MQQ.Receiver";
  public static final String l = "QWalletExtra.Plugin.isloading";
  public static final String m = "QWalletExtra.MQQ.App.RedPointPath";
  public static final String n = "QWalletExtra.MQQ.App.RedPointInfo";
  public static final String o = "QWalletExtra.MQQ.App.RedPointBuf";
  public static final String p = "QWalletExtra.MQQ.App.RedPointId";
  public static final String q = "QWalletExtra.MQQ.App.RedPointPathThr";
  public static final String r = "QWalletExtra.MQQ.App.RedPointSubId";
  public static final String s = "QWalletExtra.MQQ.App.RedPointInfoThr";
  public static final String t = "QWalletExtra.MQQ.MSG.RedPointPath";
  public static final String u = "QWalletExtra.MQQ.MSG.RedPointInfo";
  public static final String v = "QWalletExtra.MQQ.MSG.RedPointBuf";
  public static final String w = "QWalletExtra.MQQ.INFO.TWO.RedPointPath";
  public static final String x = "QWalletExtra.MQQ.INFO.TWO.RedPointInfo";
  public static final String y = "QWalletExtra.MQQ.INFO.THR.RedPointPath";
  public static final String z = "QWalletExtra.MQQ.INFO.THR.RedPointInfo";
  
  private static int a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    int i1;
    if (paramAppInfo == null)
    {
      i1 = -1;
      return i1;
    }
    paramAppInfo = paramAppInfo.red_display_info.red_type_info.get();
    if (paramAppInfo.size() > 0)
    {
      int i2 = 0;
      for (;;)
      {
        if (i2 >= paramAppInfo.size()) {
          break label93;
        }
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)paramAppInfo.get(i2);
        if (localRedTypeInfo != null)
        {
          int i3 = localRedTypeInfo.red_type.get();
          i1 = i3;
          if (i3 == 0) {
            break;
          }
          i1 = i3;
          if (i3 == 3) {
            break;
          }
          i1 = i3;
          if (i3 == 4) {
            break;
          }
        }
        i2 += 1;
      }
    }
    label93:
    return -1;
  }
  
  public static QQAppInterface a()
  {
    return a;
  }
  
  private static String a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    JSONObject localJSONObject2 = null;
    if (paramAppInfo != null)
    {
      paramAppInfo = paramAppInfo.buffer.get();
      if (TextUtils.isEmpty(paramAppInfo)) {}
    }
    for (;;)
    {
      String str;
      try
      {
        JSONObject localJSONObject3 = new JSONObject(paramAppInfo).optJSONObject("msg");
        if (localJSONObject3 == null) {
          return "";
        }
        Iterator localIterator = localJSONObject3.keys();
        localJSONObject1 = null;
        paramAppInfo = localJSONObject2;
        if (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          if (TextUtils.isEmpty(str)) {
            break label203;
          }
          localJSONObject2 = localJSONObject3.getJSONObject(str);
          if (localJSONObject2 == null) {
            break label203;
          }
          if (paramAppInfo == null)
          {
            localJSONObject1 = localJSONObject2;
            paramAppInfo = str;
            continue;
          }
          try
          {
            int i1 = Integer.valueOf(paramAppInfo).intValue();
            int i2 = Integer.valueOf(str).intValue();
            if (i2 <= i1) {
              break label206;
            }
            localJSONObject1 = localJSONObject2;
            paramAppInfo = str;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            if (str.length() > paramAppInfo.length()) {
              break label212;
            }
          }
          if (str.compareTo(paramAppInfo) <= 0) {
            break label203;
          }
          break label212;
        }
        if (localJSONObject1 != null)
        {
          paramAppInfo = localJSONObject1.optString("content");
          return paramAppInfo;
        }
      }
      catch (JSONException paramAppInfo)
      {
        paramAppInfo.printStackTrace();
        return "";
      }
      paramAppInfo = "";
      continue;
      label203:
      continue;
      label206:
      continue;
      return "";
      label212:
      JSONObject localJSONObject1 = localJSONObject2;
      paramAppInfo = str;
    }
  }
  
  public static void a()
  {
    ThreadManager.b().postDelayed(new mad(), 5000L);
  }
  
  public static void a(Activity paramActivity)
  {
    Intent localIntent = new Intent();
    localIntent.setData(Uri.parse("mqqapi://wallet/open?src_type=web&viewtype=0&version=1"));
    localIntent.setAction("android.intent.action.VIEW");
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, Bundle paramBundle, Dialog paramDialog)
  {
    if ((paramActivity == null) || (paramQQAppInterface == null)) {
      return;
    }
    a = paramQQAppInterface;
    b((BaseActivity)paramActivity, paramQQAppInterface);
    if (paramDialog != null) {}
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("userQqResources", 1);
      localIntent.putExtra("useSkinEngine", true);
      localIntent.putExtra("param_plugin_gesturelock", true);
      localIntent.putExtra("QWalletExtra.PayBridge.PayBundle", paramBundle);
      localIntent.putExtra("QWalletExtra.PayBridge.PayTimeStart", System.currentTimeMillis());
      if (paramDialog != null) {}
      for (boolean bool = true;; bool = false)
      {
        a(paramQQAppInterface, localIntent, bool);
        paramBundle = new IPluginManager.PluginParams(0);
        paramBundle.jdField_b_of_type_JavaLangString = "qwallet_plugin.apk";
        paramBundle.d = "QWallet";
        paramBundle.jdField_a_of_type_JavaLangString = paramQQAppInterface.a();
        paramBundle.e = "com.qwallet.activity.QvipPayBridgeActivity";
        paramBundle.jdField_a_of_type_JavaLangClass = QWalletPluginProxyActivity.class;
        paramBundle.jdField_a_of_type_AndroidContentIntent = localIntent;
        paramBundle.jdField_b_of_type_Int = 3001;
        paramBundle.jdField_a_of_type_AndroidAppDialog = paramDialog;
        paramBundle.jdField_a_of_type_Boolean = false;
        paramBundle.c = 10000;
        paramBundle.f = null;
        IPluginManager.a(paramActivity, paramBundle);
        return;
        paramDialog = paramActivity.getIntent().getStringExtra("from_activity");
        bool = paramActivity.getIntent().getBooleanExtra("from_float_aio", false);
        if ((a(paramActivity)) || (SendHbActivity.class.getName().equals(paramDialog)) || (bool)) {
          break label256;
        }
        paramDialog = new QWalletPayProgressDialog(paramActivity);
        paramDialog.show();
        break;
      }
      label256:
      paramDialog = null;
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface)
  {
    if (a(paramBaseActivity))
    {
      a(paramBaseActivity, paramQQAppInterface, null);
      return;
    }
    QWalletLoadingDialog localQWalletLoadingDialog = new QWalletLoadingDialog(paramBaseActivity);
    localQWalletLoadingDialog.show();
    a(paramBaseActivity, paramQQAppInterface, localQWalletLoadingDialog);
  }
  
  private static void a(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, QWalletLoadingDialog paramQWalletLoadingDialog)
  {
    boolean bool = true;
    if ((paramBaseActivity == null) || (paramQQAppInterface == null)) {
      return;
    }
    a = paramQQAppInterface;
    b(paramBaseActivity, paramQQAppInterface);
    Intent localIntent = new Intent();
    localIntent.putExtra("userQqResources", 1);
    localIntent.putExtra("useSkinEngine", true);
    localIntent.putExtra("param_plugin_gesturelock", true);
    localIntent.putExtra("QWallet.load.beginTime", System.currentTimeMillis());
    localIntent.putExtra("QWalletExtra.isFling", true);
    if (paramQWalletLoadingDialog != null) {}
    for (;;)
    {
      a(paramQQAppInterface, localIntent, bool);
      IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
      localPluginParams.jdField_b_of_type_JavaLangString = "qwallet_plugin.apk";
      localPluginParams.d = "QWallet";
      localPluginParams.jdField_a_of_type_JavaLangString = paramQQAppInterface.a();
      localPluginParams.e = "com.qwallet.activity.QvipPayWalletActivity";
      localPluginParams.jdField_a_of_type_JavaLangClass = QWalletPluginProxyActivity.class;
      localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
      localPluginParams.jdField_b_of_type_Int = -1;
      localPluginParams.jdField_a_of_type_AndroidAppDialog = paramQWalletLoadingDialog;
      localPluginParams.jdField_a_of_type_Boolean = false;
      localPluginParams.c = 10000;
      localPluginParams.f = null;
      IPluginManager.a(paramBaseActivity, localPluginParams);
      return;
      bool = false;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if ((a != null) && (a == paramQQAppInterface)) {
      a = null;
    }
    QWalletResultReceiver.a();
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Intent paramIntent, boolean paramBoolean)
  {
    int i6 = 0;
    int i7 = 0;
    int i8 = -1;
    if ((paramQQAppInterface == null) || (paramIntent == null)) {
      return;
    }
    paramIntent.putExtra("QWalletExtra.Account.Uin", paramQQAppInterface.a());
    paramIntent.putExtra("QWalletExtra.Account.NickName", ContactUtils.g(paramQQAppInterface, paramQQAppInterface.a()));
    paramIntent.putExtra("QWalletExtra.MQQ.APPID", AppSetting.a);
    paramIntent.putExtra("QWalletExtra.MQQ.GUID", NetConnInfoCenter.GUID);
    paramIntent.putExtra("QWalletExtra.MQQ.Receiver", QWalletResultReceiver.a());
    paramIntent.putExtra("QWalletExtra.Plugin.isloading", paramBoolean);
    Object localObject = (RedTouchManager)paramQQAppInterface.getManager(35);
    int i1;
    int i4;
    if (localObject != null)
    {
      paramQQAppInterface = ((RedTouchManager)localObject).a("100007.100014");
      if ((paramQQAppInterface != null) && (paramQQAppInterface.iNewFlag.get() != 0))
      {
        i1 = paramQQAppInterface.type.get();
        paramQQAppInterface = ((RedTouchManager)localObject).a("100007.100014.100015");
        if ((paramQQAppInterface != null) && (paramQQAppInterface.iNewFlag.get() != 0))
        {
          i4 = paramQQAppInterface.type.get();
          paramQQAppInterface = a(paramQQAppInterface);
        }
      }
    }
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          continue;
        }
        paramQQAppInterface = new JSONObject(paramQQAppInterface);
        i3 = paramQQAppInterface.getInt("serviceId");
      }
      catch (JSONException paramQQAppInterface)
      {
        BusinessInfoCheckUpdate.AppInfo localAppInfo;
        i3 = 0;
        paramQQAppInterface.printStackTrace();
        i2 = 0;
        int i5 = i1;
        i1 = i4;
        i4 = i5;
        continue;
        if (paramQQAppInterface != null)
        {
          localObject = a(paramQQAppInterface);
          try
          {
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              i3 = new JSONObject((String)localObject).getInt("id");
              if (i2 == 3)
              {
                localObject = paramQQAppInterface.red_display_info.red_type_info.get();
                if (((List)localObject).size() > 0)
                {
                  i4 = i6;
                  if (i4 < ((List)localObject).size())
                  {
                    paramQQAppInterface = (BusinessInfoCheckUpdate.RedTypeInfo)((List)localObject).get(i4);
                    if ((paramQQAppInterface != null) && (paramQQAppInterface.red_type.get() == 3))
                    {
                      localObject = paramQQAppInterface.red_desc.get();
                      paramQQAppInterface = paramQQAppInterface.red_content.get();
                    }
                  }
                }
              }
            }
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
            i3 = 0;
            continue;
            i4 += 1;
            continue;
          }
        }
        String str;
        i2 = 0;
        i3 = 0;
        continue;
      }
      try
      {
        i2 = paramQQAppInterface.getInt("subId");
        i5 = i1;
        i1 = i4;
        i4 = i5;
        paramIntent.putExtra("QWalletExtra.MQQ.App.RedPointPath", "100007.100014");
        paramIntent.putExtra("QWalletExtra.MQQ.App.RedPointInfo", i4);
        paramIntent.putExtra("QWalletExtra.MQQ.App.RedPointId", i3);
        paramIntent.putExtra("QWalletExtra.MQQ.App.RedPointPathThr", "100007.100014.100015");
        paramIntent.putExtra("QWalletExtra.MQQ.App.RedPointInfoThr", i1);
        paramIntent.putExtra("QWalletExtra.MQQ.App.RedPointSubId", i2);
        paramQQAppInterface = "";
        if (localObject == null) {
          continue;
        }
        localAppInfo = ((RedTouchManager)localObject).a("100007.100013");
        if ((localAppInfo == null) || (localAppInfo.iNewFlag.get() == 0)) {
          continue;
        }
        i1 = localAppInfo.type.get();
        paramQQAppInterface = a(localAppInfo);
      }
      catch (JSONException paramQQAppInterface)
      {
        continue;
        paramQQAppInterface = "";
        str = "";
        continue;
        i3 = 0;
        continue;
        paramQQAppInterface = "";
        str = "";
        i3 = i7;
        continue;
        i2 = -1;
        continue;
        i2 = -1;
        continue;
        paramQQAppInterface = "";
        str = "";
        i1 = -1;
        i2 = i8;
        i3 = i7;
        continue;
        i1 = -1;
        continue;
      }
      paramIntent.putExtra("QWalletExtra.MQQ.MSG.RedPointPath", "100007.100013");
      paramIntent.putExtra("QWalletExtra.MQQ.MSG.RedPointInfo", i1);
      paramIntent.putExtra("QWalletExtra.MQQ.MSG.RedPointBuf", paramQQAppInterface);
      if (localObject != null)
      {
        paramQQAppInterface = ((RedTouchManager)localObject).a("100007.100009");
        if (paramQQAppInterface != null)
        {
          i2 = paramQQAppInterface.type.get();
          i1 = i2;
          if (i2 != 0)
          {
            i1 = i2;
            if (i2 != 3) {
              i1 = -1;
            }
          }
          paramQQAppInterface = ((RedTouchManager)localObject).a("100007.100009.100010");
          if (paramQQAppInterface != null)
          {
            i2 = a(paramQQAppInterface);
            if ((i2 != 0) && (i2 != 3))
            {
              paramQQAppInterface = "";
              localObject = "";
              i3 = i7;
              i2 = i8;
              paramIntent.putExtra("QWalletExtra.MQQ.INFO.TWO.RedPointPath", "100007.100009");
              paramIntent.putExtra("QWalletExtra.MQQ.INFO.TWO.RedPointInfo", i1);
              paramIntent.putExtra("QWalletExtra.MQQ.INFO.THR.RedPointPath", "100007.100009.100010");
              paramIntent.putExtra("QWalletExtra.MQQ.INFO.THR.RedPointInfo", i2);
              paramIntent.putExtra("QWalletExtra.MQQ.INFO.THR.RedPointId", i3);
              paramIntent.putExtra("QWalletExtra.MQQ.INFO.THR.RedPointDesc", (String)localObject);
              paramIntent.putExtra("QWalletExtra.MQQ.INFO.THR.RedPointContent", paramQQAppInterface);
              return;
            }
          }
        }
      }
      int i2 = 0;
      int i3 = 0;
      i4 = i1;
      i1 = -1;
      continue;
      i1 = -1;
      break;
      i2 = 0;
      i3 = 0;
      i1 = -1;
      i4 = -1;
    }
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramContext.hasNext()) {
      if ("com.tencent.minihd.qq:qwallet".compareTo(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName) == 0) {
        return true;
      }
    }
    return false;
  }
  
  private static void b(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface)
  {
    paramBaseActivity.addObserver(ThirdPayManager.a());
    ThirdPayRemoteCommand.a(paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qwallet.plugin.QWalletHelper
 * JD-Core Version:    0.7.0.1
 */