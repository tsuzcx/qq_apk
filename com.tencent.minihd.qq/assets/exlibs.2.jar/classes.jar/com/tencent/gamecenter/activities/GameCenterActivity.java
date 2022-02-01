package com.tencent.gamecenter.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.common.util.ReportInfoManager;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webviewplugin.WebViewPluginEngine;
import com.tencent.open.base.APNUtil;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import dbp;
import java.io.IOException;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.utils.URLEncodedUtils;

public class GameCenterActivity
  extends QQBrowserActivity
  implements Handler.Callback
{
  public static final int a = 2003;
  public static long a = 0L;
  public static final String a;
  public static final int b = 2004;
  public static long b = 0L;
  public static final int c = 2006;
  public static final int d = 3;
  public static final int e = 278;
  public static final int f = 5127;
  public static final int g = 3;
  public static int h;
  public Handler a;
  private AppInterface a;
  protected boolean a;
  private DisplayMetrics b;
  public String b;
  public boolean b;
  public long c;
  protected String c;
  private boolean c;
  public String d;
  private String e = "";
  private String f;
  private long k;
  
  static
  {
    jdField_a_of_type_JavaLangString = GameCenterActivity.class.getSimpleName();
    h = 0;
    jdField_a_of_type_Long = 0L;
    jdField_b_of_type_Long = 0L;
  }
  
  public GameCenterActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("appids", paramString2);
    paramString2 = "vkey=" + paramString3 + ";uin=" + paramString4;
    paramString3 = new Bundle();
    paramString3.putString("Cookie", paramString2);
    try
    {
      paramContext = HttpUtil.a(paramContext, paramString1, "POST", localBundle, paramString3);
      if (QLog.isColorLevel()) {
        QLog.i("GameCenter", 2, "httpRequest: result:" + paramContext);
      }
      return paramContext;
    }
    catch (ClientProtocolException paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GameCenter", 2, "httpRequest:ClientProtocolException");
      }
      return "{'ret': -104, 'data' : 'httpRequest:ClientProtocolException'}";
    }
    catch (IOException paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GameCenter", 2, "httpRequest:" + paramContext.getMessage());
      }
    }
    return "{'ret': -105, 'data' : 'httpRequest::Http no response.'}";
  }
  
  private void b(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_b_of_type_JavaLangString = b();
      }
      bool = TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString);
      if (!bool) {
        break label35;
      }
    }
    finally
    {
      try
      {
        label35:
        do
        {
          boolean bool;
          localObject1 = URLEncodedUtils.parse(new URI(this.e), "UTF-8");
          if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
            break;
          }
          localObject1 = ((List)localObject1).iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject3 = (NameValuePair)((Iterator)localObject1).next();
          } while (!"status".equals(((NameValuePair)localObject3).getName()));
          localObject1 = ((NameValuePair)localObject3).getValue();
        } while (TextUtils.isEmpty((CharSequence)localObject1));
        if (!TextUtils.isEmpty(paramString)) {
          break label236;
        }
        paramString = "0";
        localObject3 = APNUtil.a(getApplicationContext());
        str = this.jdField_b_of_type_AndroidUtilDisplayMetrics.widthPixels + " * " + this.jdField_b_of_type_AndroidUtilDisplayMetrics.heightPixels;
        paramString = ReportInfoManager.a().a(this.jdField_c_of_type_JavaLangString, (String)localObject1, paramString, (String)localObject3, str);
        ReportInfoManager.a().a(paramString, this.jdField_b_of_type_JavaLangString);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      paramString = finally;
    }
    return;
    bool = TextUtils.isEmpty(this.e);
    if (!bool) {}
    for (;;)
    {
      Object localObject1;
      Object localObject3;
      String str;
      Object localObject2 = null;
      continue;
      label236:
      continue;
      localObject2 = null;
    }
  }
  
  private String h()
  {
    String str2 = "https://gamecenter.qq.com/gamecenter/index/index.html?plat=qq&tt=1&sid=" + this.jdField_b_of_type_JavaLangString + "&qappid=" + AppSetting.a + "&osv=" + Build.VERSION.RELEASE + "&_bid=" + 278 + "&_wv=" + 5127;
    String str1 = str2;
    if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
      str1 = str2 + "&" + this.jdField_f_of_type_JavaLangString;
    }
    return str1 + "&st=" + this.jdField_k_of_type_Long;
  }
  
  private void w()
  {
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null)
    {
      if (this.app == null) {
        break label144;
      }
      localObject1 = this.app;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)localObject1);
      this.jdField_c_of_type_JavaLangString = ("" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.a());
      if ((!TextUtils.isEmpty(this.M)) && (this.M.startsWith("https://gamecenter.qq.com/gamecenter/index/index.html"))) {}
      try
      {
        localObject1 = Uri.parse(this.M).getQueryParameter("uin");
        if (localObject1 == null)
        {
          this.M = HtmlOffline.a(this.M, "uin=" + this.jdField_c_of_type_JavaLangString);
          getIntent().putExtra("url", this.M);
        }
        return;
        label144:
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          Object localObject2 = null;
        }
      }
    }
  }
  
  protected String a()
  {
    return "gamecenter";
  }
  
  /* Error */
  protected void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield 314	com/tencent/gamecenter/activities/GameCenterActivity:q	Z
    //   5: aload_0
    //   6: invokestatic 320	java/lang/System:currentTimeMillis	()J
    //   9: putfield 322	com/tencent/gamecenter/activities/GameCenterActivity:jdField_f_of_type_Long	J
    //   12: aload_0
    //   13: iconst_1
    //   14: putfield 62	com/tencent/gamecenter/activities/GameCenterActivity:jdField_c_of_type_Boolean	Z
    //   17: aload_0
    //   18: getfield 325	com/tencent/gamecenter/activities/GameCenterActivity:jdField_a_of_type_ComTencentBizPubaccountCustomWebView	Lcom/tencent/biz/pubaccount/CustomWebView;
    //   21: ifnull +35 -> 56
    //   24: aload_0
    //   25: getfield 52	com/tencent/gamecenter/activities/GameCenterActivity:jdField_a_of_type_Boolean	Z
    //   28: ifne +28 -> 56
    //   31: aload_0
    //   32: getfield 325	com/tencent/gamecenter/activities/GameCenterActivity:jdField_a_of_type_ComTencentBizPubaccountCustomWebView	Lcom/tencent/biz/pubaccount/CustomWebView;
    //   35: iconst_1
    //   36: invokevirtual 331	com/tencent/biz/pubaccount/CustomWebView:clearCache	(Z)V
    //   39: aload_0
    //   40: getfield 325	com/tencent/gamecenter/activities/GameCenterActivity:jdField_a_of_type_ComTencentBizPubaccountCustomWebView	Lcom/tencent/biz/pubaccount/CustomWebView;
    //   43: ldc_w 333
    //   46: invokevirtual 336	com/tencent/biz/pubaccount/CustomWebView:loadUrl	(Ljava/lang/String;)V
    //   49: aload_0
    //   50: getfield 325	com/tencent/gamecenter/activities/GameCenterActivity:jdField_a_of_type_ComTencentBizPubaccountCustomWebView	Lcom/tencent/biz/pubaccount/CustomWebView;
    //   53: invokevirtual 339	com/tencent/biz/pubaccount/CustomWebView:reload	()V
    //   56: return
    //   57: astore_1
    //   58: return
    //   59: astore_1
    //   60: goto -11 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	GameCenterActivity
    //   57	1	1	localException1	Exception
    //   59	1	1	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   17	39	57	java/lang/Exception
    //   49	56	57	java/lang/Exception
    //   39	49	59	java/lang/Exception
  }
  
  protected void a(WebView paramWebView, String paramString)
  {
    super.a(paramWebView, paramString);
    if ((this.jdField_b_of_type_Boolean) && (!this.jdField_k_of_type_Boolean))
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.canGoBack())) {
        break label58;
      }
      this.leftView.setText(2131365114);
    }
    for (;;)
    {
      a(paramString);
      this.jdField_b_of_type_Boolean = false;
      return;
      label58:
      setLeftViewName(getIntent());
    }
  }
  
  public void a(String paramString)
  {
    if ((!this.jdField_c_of_type_Boolean) && (!paramString.startsWith("data")) && (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null))
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(OfflinePlugin.class);
      if ((paramString != null) && ((paramString instanceof OfflinePlugin)))
      {
        if (((OfflinePlugin)paramString).c == 0) {
          b("0");
        }
      }
      else {
        return;
      }
      b(HtmlOffline.c(String.valueOf(278)));
      return;
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  public String b()
  {
    if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)) {
      this.jdField_b_of_type_JavaLangString = ("" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getSid());
    }
    return this.jdField_b_of_type_JavaLangString;
  }
  
  protected void b(WebView paramWebView, String paramString)
  {
    super.b(paramWebView, paramString);
    if ((!this.jdField_c_of_type_Boolean) && (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("https://gamecenter.qq.com/gamecenter/index/index.html"))) {
      jdField_b_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public String c()
  {
    if ((TextUtils.isEmpty(this.d)) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null))
    {
      if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
        break label46;
      }
      this.d = ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).d();
    }
    for (;;)
    {
      return this.d;
      label46:
      if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof BrowserAppInterface)) {
        this.d = ((BrowserAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).b();
      }
    }
  }
  
  protected void c()
  {
    super.c();
    w();
    if (this.centerView != null)
    {
      this.centerView.setVisibility(0);
      this.centerView.setOnClickListener(new dbp(this));
      if ((this.centerView instanceof TextView)) {
        this.centerView.setText(2131364770);
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    h += 1;
    this.jdField_k_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    if (getIntent() != null)
    {
      this.e = getIntent().getStringExtra("url");
      this.jdField_f_of_type_JavaLangString = getIntent().getStringExtra("redTouch");
      if (TextUtils.isEmpty(this.e))
      {
        this.e = h();
        getIntent().putExtra("url", this.e);
      }
      Object localObject;
      if ((!TextUtils.isEmpty(this.e)) && (this.e.startsWith("https://gamecenter.qq.com/gamecenter/index/index.html")))
      {
        jdField_a_of_type_Long = getIntent().getLongExtra("plugin_start_time", 0L);
        if (jdField_a_of_type_Long == 0L) {
          localObject = null;
        }
      }
      try
      {
        String str = Uri.parse(this.e).getQueryParameter("st");
        localObject = str;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      if (!TextUtils.isEmpty(localObject)) {
        jdField_a_of_type_Long = Long.valueOf(localObject).longValue();
      }
    }
    for (;;)
    {
      super.doOnCreate(paramBundle);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(this.jdField_b_of_type_AndroidUtilDisplayMetrics);
      MyAppApi.a().b(this, "ANDROIDQQ.WIFIDLYYB.GAME", 2);
      return true;
      Toast.makeText(getApplicationContext(), 2131364773, 0).show();
      finish();
    }
  }
  
  public void doOnDestroy()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    h -= 1;
    if (h == 0)
    {
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "enterGameCenterTime = " + jdField_a_of_type_Long + " , startLoadGameCenterTime = " + jdField_b_of_type_Long + " , exitGameCenterTime = " + this.jdField_c_of_type_Long);
      }
      VipUtils.a(this.app, "vip", "0X8004BFB", "0X8004BFB", 0, 0, new String[] { String.valueOf(jdField_a_of_type_Long), String.valueOf(jdField_b_of_type_Long), String.valueOf(this.jdField_c_of_type_Long) });
    }
    super.doOnDestroy();
    System.gc();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 3: 
      a();
      return true;
    case 2003: 
      startTitleProgress();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2004, 45000L);
      return true;
    case 2004: 
      stopTitleProgress();
      return true;
    }
    Toast.makeText(getApplicationContext(), (String)paramMessage.obj, 0).show();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.gamecenter.activities.GameCenterActivity
 * JD-Core Version:    0.7.0.1
 */