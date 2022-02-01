package com.qqreader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.plugin.PluginInfo;
import oi;
import oj;
import ok;
import ol;
import org.json.JSONObject;

public class QRBridgeActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener
{
  public static final int a = 400;
  public static final String a = "action_type";
  public static boolean a = false;
  public static final int b = 1000;
  public static final String b = "action_from_list";
  public static boolean b = false;
  public static final int c = 1001;
  public static final String c = "key_params_qq";
  public static final int d = 1002;
  public static final String d = "qq_adv";
  public static final int e = 1003;
  public static final String e = "qqreaderplugin.apk";
  public static final int f = 90;
  public static final int g = 99;
  public static final int i = 100;
  public long a;
  public View a;
  public Button a;
  public TextView a;
  public QRNumberCircleProgressBar a;
  public QRPluginBooks a;
  public ReaderPluginReport a;
  public URLImageView a;
  MessageObserver a;
  public WeakReferenceHandler a;
  public IPluginManager a;
  public JSONObject a;
  public TextView b;
  public boolean c;
  public boolean d = false;
  public boolean e;
  public String f;
  public boolean f;
  public final String g = "qr_recommend_bookname";
  public int h;
  public final String h;
  public final String i = "qr_recommend_book_type";
  public final String j = "qr_recommend_slogan";
  public String k = "";
  public String l = "";
  public String m = "";
  public String n = "";
  public String o = "";
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
  }
  
  public QRBridgeActivity()
  {
    this.jdField_h_of_type_JavaLangString = "qr_recommend_book_author";
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidWidgetButton = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentImageURLImageView = null;
    this.jdField_h_of_type_Int = -1;
    this.jdField_a_of_type_OrgJsonJSONObject = null;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new oi(this);
  }
  
  public int a()
  {
    int i1 = (int)(Math.random() * 100.0D) + 1;
    if (i1 <= 13) {
      return 0;
    }
    if (i1 <= 35) {
      return 1;
    }
    return 2;
  }
  
  public void a()
  {
    ThreadManager.a(new oj(this));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComQqreaderQRNumberCircleProgressBar.setProgress(paramInt);
  }
  
  public void a(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QPlugin", 4, "QRBridgeActivity start Reader " + paramString);
    }
    if (!jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_CooperationPluginIPluginManager.installPlugin("qqreaderplugin.apk", new ok(this, paramString));
      return;
    }
    b(paramString);
  }
  
  public void a(String paramString, PluginBaseInfo paramPluginBaseInfo)
  {
    if (paramPluginBaseInfo == null)
    {
      if (!this.jdField_a_of_type_CooperationPluginIPluginManager.isReady()) {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1001, 400L);
      }
      return;
    }
    if (paramPluginBaseInfo.mDownloadProgress > 0.95D) {
      this.jdField_a_of_type_ComQqreaderReaderPluginReport.c();
    }
    switch (paramPluginBaseInfo.mState)
    {
    case -1: 
    default: 
      return;
    case -2: 
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(1003);
      return;
    case 0: 
      this.jdField_a_of_type_CooperationPluginIPluginManager.a("qqreaderplugin.apk");
    case 1: 
    case 2: 
      int i1 = (int)(paramPluginBaseInfo.mDownloadProgress * 90.0F);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(1000, i1, 0).sendToTarget();
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1001, 400L);
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(1002);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1001, 400L);
      return;
    }
    this.d = true;
    a(100);
    a(false);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QRUtility.a(this) == -1) {
      QRUtility.a(this, a());
    }
    Object localObject2 = getIntent();
    Object localObject1 = ((Intent)localObject2).getExtras();
    String str = ((Bundle)localObject1).getString("key_params_qq");
    paramBoolean = ((Bundle)localObject1).getBoolean("qq_adv");
    if ("action_from_list".equals(((Bundle)localObject1).get("action_type")))
    {
      ((Intent)localObject2).setClass(this, EditActivity.class);
      ((Intent)localObject2).putExtra("k_source", 3);
      ((Intent)localObject2).setFlags(67108864);
      startActivity((Intent)localObject2);
      finish();
      if (QLog.isDevelopLevel()) {
        QLog.d("QPlugin", 4, "QRBridgeActivity start EditActivity");
      }
      return;
    }
    if ((str != null) && (str.contains("id")) && (str.contains("name")) && (str.contains("uin")))
    {
      localObject1 = str.split("&");
      if (localObject1.length >= 3)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("readtype=3&");
        ((StringBuilder)localObject2).append(localObject1[0]);
        int i1 = localObject1[2].indexOf("=");
        this.f = localObject1[2].substring(i1 + 1);
        a(((StringBuilder)localObject2).toString());
        return;
      }
      a(null);
      return;
    }
    if (paramBoolean)
    {
      localObject2 = new StringBuilder();
      this.f = ((Bundle)localObject1).getString("account");
      ((StringBuilder)localObject2).append("readtype=4");
      a(((StringBuilder)localObject2).toString());
      return;
    }
    a(null);
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 8) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.k);
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.m + "|" + this.l);
      }
      if (this.jdField_a_of_type_ComTencentImageURLImageView != null) {
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(URLDrawable.getDrawable(this.n));
      }
      if ((this.jdField_a_of_type_ComQqreaderQRPluginBooks != null) && (this.jdField_a_of_type_OrgJsonJSONObject != null) && (this.jdField_a_of_type_ComQqreaderQRPluginBooks.a(this.jdField_a_of_type_OrgJsonJSONObject.optInt("id")))) {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      }
      if ((QRUtility.a(this) == -1) && (this.jdField_h_of_type_Int != -1)) {
        QRUtility.a(this, this.jdField_h_of_type_Int);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b(String paramString)
  {
    Intent localIntent = new Intent(this, QRPluginProxyActivity.class);
    localIntent.addFlags(268435456);
    localIntent.putExtras(getIntent());
    localIntent.putExtra("useSkinEngine", true);
    localIntent.putExtra("is_follow_publicaccount", QRUtility.a(this.app));
    boolean bool;
    if ((WXShareHelper.a().a()) && (WXShareHelper.a().b()))
    {
      bool = true;
      localIntent.putExtra("is_support_wx", bool);
      Bundle localBundle = getActivity().getIntent().getExtras();
      if (localBundle != null)
      {
        localIntent.putExtra("redtouch_type", localBundle.getInt("redtouch_type", -1));
        localIntent.putExtra("redtouch_push_ts", localBundle.getInt("redtouch_push_ts", 0));
        localIntent.putExtra("redtouch_pull_ts", localBundle.getInt("redtouch_pull_ts", 0));
        localIntent.putExtra("redtouch_click_ts", localBundle.getInt("redtouch_click_ts", 0));
        localIntent.putStringArrayListExtra("redtouch_taskid", localBundle.getStringArrayList("redtouch_taskid"));
      }
      if (paramString != null)
      {
        localIntent.putExtra("plugin_data", paramString);
        localIntent.putExtra("account", this.f);
        localIntent.putExtra("load_from_third_app", true);
        localIntent.putExtra("param_plugin_gesturelock", true);
        localIntent.putExtra("clsUploader", "com.tencent.mobileqq.statistics.PluginStatisticsCollector");
      }
      if (!jdField_a_of_type_Boolean) {}
      paramString = new IPluginManager.PluginParams(0);
      paramString.b = "qqreaderplugin.apk";
      paramString.d = "阅读中心";
      paramString.jdField_a_of_type_JavaLangString = this.app.a();
      PluginCommunicationHandler.getInstance().register(new QRRemoteCommond());
      paramString.e = "com.qqreader.SplashActivity";
      paramString.jdField_a_of_type_JavaLangClass = QRPluginProxyActivity.class;
      paramString.jdField_a_of_type_AndroidContentIntent = localIntent;
    }
    for (;;)
    {
      try
      {
        IPluginManager.a(this, paramString);
        if (this.d) {
          continue;
        }
        finish();
        if (!this.c) {
          overridePendingTransition(2130968590, 2130968583);
        }
      }
      catch (Exception paramString)
      {
        continue;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("QPlugin", 4, "QRBridgeActivity com.qqreader.SplashActivity");
      }
      return;
      bool = false;
      break;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.postDelayed(new ol(this), 1000L);
    }
  }
  
  public void c()
  {
    if (!jdField_a_of_type_Boolean) {}
    a(true);
  }
  
  public void d()
  {
    setTitle("阅读中心");
    this.jdField_a_of_type_ComQqreaderQRNumberCircleProgressBar = ((QRNumberCircleProgressBar)findViewById(2131300748));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131300750);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131300758));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300755));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300756));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131300753));
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    try
    {
      this.jdField_a_of_type_ComQqreaderQRPluginBooks = new QRPluginBooks(this);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_CooperationPluginIPluginManager = ((IPluginManager)this.app.getManager(26));
    if (QLog.isDevelopLevel()) {
      QLog.d("QPlugin", 4, "QRBridgeActivity onCreate");
    }
    getWindow().setBackgroundDrawableResource(2131427375);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(this);
    this.c = true;
    if (this.app != null) {}
    for (paramBundle = this.app.getSid();; paramBundle = "app null")
    {
      this.jdField_a_of_type_ComQqreaderReaderPluginReport = new ReaderPluginReport(paramBundle, getApplicationContext());
      c();
      return true;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = 99;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      a(paramMessage.arg1);
      continue;
      int i2 = this.jdField_a_of_type_ComQqreaderQRNumberCircleProgressBar.a();
      if (i2 < 99) {}
      for (;;)
      {
        a(i1);
        break;
        i1 = i2 + 1;
      }
      if (!isFinishing())
      {
        a("qqreaderplugin.apk", this.jdField_a_of_type_CooperationPluginIPluginManager.a("qqreaderplugin.apk"));
        continue;
        b();
      }
    }
  }
  
  protected boolean onBackEvent()
  {
    try
    {
      if (this.jdField_a_of_type_CooperationPluginIPluginManager != null)
      {
        PluginInfo localPluginInfo = this.jdField_a_of_type_CooperationPluginIPluginManager.a("qqreaderplugin.apk");
        if (localPluginInfo != null)
        {
          int i1 = (int)(localPluginInfo.mDownloadProgress * 90.0F);
          this.jdField_a_of_type_ComQqreaderReaderPluginReport.a(i1);
        }
      }
    }
    catch (Exception localException)
    {
      label38:
      break label38;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
    } while ((this.jdField_a_of_type_ComQqreaderQRPluginBooks == null) || (this.jdField_a_of_type_OrgJsonJSONObject == null));
    this.jdField_a_of_type_ComQqreaderQRPluginBooks.a(this.jdField_a_of_type_OrgJsonJSONObject);
    this.jdField_a_of_type_ComQqreaderQRPluginBooks.a();
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetButton.setText("已加书架");
    this.jdField_a_of_type_ComQqreaderReaderPluginReport.a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isDevelopLevel()) {
      QLog.d("QPlugin", 4, "QRBridgeActivity onDestroy");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.qqreader.QRBridgeActivity
 * JD-Core Version:    0.7.0.1
 */