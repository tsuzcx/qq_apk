package com.tencent.mobileqq.activity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsoluteLayout;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebChromeClient;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.CustomWebViewClient;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItem;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItemAdapter;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItemViewHolder;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.webviewplugin.Ad;
import com.tencent.biz.webviewplugin.Hole;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.filemanager.app.UniformDownload;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.ReflectionUtil;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.vas.ColorRingPlayer;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPluginContainer;
import com.tencent.mobileqq.webviewplugin.WebViewPluginEngine;
import com.tencent.mobileqq.widget.IconPopupWindow;
import com.tencent.mobileqq.widget.SlipEdgeLayout;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mtt.spcialcall.sdk.MttLoader;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.PluginState;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.DesUtils;
import com.tencent.util.QQDeviceInfo;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.EmptyTextView;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import cooperation.qzone.QZoneHelper;
import eqt;
import eqv;
import eqx;
import eqy;
import eqz;
import era;
import erb;
import erc;
import erd;
import ere;
import erf;
import erg;
import erh;
import eri;
import erj;
import erl;
import erm;
import ern;
import ero;
import erp;
import erq;
import err;
import ers;
import ert;
import eru;
import erv;
import erw;
import erx;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import mqq.app.MobileQQ;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(7)
public class QQBrowserActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, View.OnTouchListener, AdapterView.OnItemClickListener, WebViewPluginContainer
{
  public static final int A = 254;
  public static final String A = "ba_is_login";
  public static final String B = "is_share_music";
  public static final int C = 1;
  public static final String C = "hide_left_button";
  public static final int D = 2;
  public static final String D = "hide_more_button";
  public static final String E = "show_right_close_button";
  public static final String F = "finish_animation_up_down";
  public static int G = -1;
  public static final String G = "avoidLoginWeb";
  public static int H = 0;
  public static final String H = "ignoreLoginWeb";
  public static final String I = "url";
  public static final String J = "keyAction";
  public static final String K = "actionSelectPicture";
  public static final String L = " WebP/0.3.0";
  public static final String O = "com.tencent.mobileqq.card.modify";
  public static final String P = "com.tencent.mobileqq.view.self.album";
  public static final String Q = "com.tencent.mobileqq.opencenter.vipInfo";
  public static final String R = "broadcastAction";
  public static final String S = "key_pay_action_result";
  public static final String T = "reqType";
  public static final String U = "fromAio";
  public static final String V = "fromPublicAccount";
  public static final String X = "isShowAd";
  private static final int jdField_a_of_type_Int = 20000;
  private static final long jdField_a_of_type_Long = 86400000L;
  public static ValueCallback a;
  private static final String jdField_a_of_type_JavaLangString = "web_report";
  private static final int jdField_b_of_type_Int = 12;
  private static final String jdField_b_of_type_JavaLangString = "utf-8";
  public static ArrayList b;
  private static final int jdField_c_of_type_Int = 100;
  private static final String jdField_c_of_type_JavaLangString = "https://p.mb.qq.com/sdk";
  private static final int jdField_d_of_type_Int = 101;
  private static final String jdField_d_of_type_JavaLangString = "qb_info";
  private static final String jdField_e_of_type_JavaLangString = "https://mqqad.html5.qq.com/adjs?p=";
  private static final String jdField_f_of_type_JavaLangString = "icon_time";
  private static final String jdField_g_of_type_JavaLangString = "icon_url";
  private static final String jdField_h_of_type_JavaLangString = "content_time";
  public static final int i = 4660;
  private static final String jdField_i_of_type_JavaLangString = "content_memo";
  public static final int j = 1;
  private static final String j = "click_icon";
  public static final int k = 2;
  private static final String jdField_k_of_type_JavaLangString = "update_time";
  public static final int l = 3;
  private static final String jdField_l_of_type_JavaLangString = "qb_param_url";
  public static final int m = 4;
  public static final int n = 5;
  public static final int o = 6;
  public static final int p = 16777216;
  private static final String jdField_p_of_type_JavaLangString = "Meizu_M040";
  public static final int q = 1;
  private static final String q = "Xiaomi_MI 2";
  public static final int r = 2;
  public static final int s = 3;
  public static final int t = 4;
  public static final int u = 10000;
  public static final int v = 0;
  public static final int w = 2;
  public static final int x = 3;
  public static final int y = 4;
  static final String jdField_y_of_type_JavaLangString = "QQBrowser";
  public static final int z = 5;
  public static final String z = "webview";
  private boolean A = false;
  int jdField_B_of_type_Int = Build.VERSION.SDK_INT;
  private boolean jdField_B_of_type_Boolean = false;
  private boolean C;
  private boolean D;
  public int E;
  private boolean E;
  public int F;
  private boolean F;
  int I = 0;
  int J;
  int K;
  public int L;
  public int M;
  public String M;
  protected String N;
  public String W = "";
  public String Y;
  public String Z;
  public BroadcastReceiver a;
  public SharedPreferences a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler = null;
  public DisplayMetrics a;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new erh(this);
  public View a;
  protected ViewGroup a;
  WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  WindowManager jdField_a_of_type_AndroidViewWindowManager;
  protected AbsoluteLayout a;
  public FrameLayout a;
  protected ImageView a;
  public ProgressBar a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public AuthorizeConfig a;
  private CustomWebChromeClient jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient;
  public CustomWebView a;
  private CustomWebViewClient jdField_a_of_type_ComTencentBizPubaccountCustomWebViewClient;
  Ad jdField_a_of_type_ComTencentBizWebviewpluginAd;
  Hole jdField_a_of_type_ComTencentBizWebviewpluginHole;
  public OfflinePlugin a;
  public Share a;
  public ElasticHorScrView a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  protected QQBrowserActivity.TopBarBtnClickListener a;
  public BrowserAppInterface a;
  private Client.onRemoteRespObserver jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  private ColorRingPlayer jdField_a_of_type_ComTencentMobileqqVasColorRingPlayer = null;
  public WebViewPluginEngine a;
  protected IconPopupWindow a;
  protected ActionSheet a;
  private Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean jdField_a_of_type_Boolean;
  protected String aa = null;
  private long jdField_b_of_type_Long;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  protected Handler b;
  public View.OnClickListener b;
  public View b;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup = null;
  public FrameLayout b;
  protected ImageView b;
  public ElasticHorScrView b;
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  private Handler jdField_c_of_type_AndroidOsHandler;
  public View c;
  protected ImageView c;
  private boolean jdField_c_of_type_Boolean = false;
  public long d;
  View jdField_d_of_type_AndroidViewView;
  public ImageView d;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = -1;
  public long e;
  private View jdField_e_of_type_AndroidViewView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int = 0;
  public long f;
  private View jdField_f_of_type_AndroidViewView;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private boolean jdField_f_of_type_Boolean = false;
  private int jdField_g_of_type_Int = 50;
  public long g;
  private View jdField_g_of_type_AndroidViewView;
  protected boolean g;
  public long h;
  private View jdField_h_of_type_AndroidViewView;
  protected boolean h;
  public long i;
  private View jdField_i_of_type_AndroidViewView;
  public boolean i;
  public long j;
  public boolean j;
  private long jdField_k_of_type_Long = 0L;
  public boolean k;
  private long jdField_l_of_type_Long = 0L;
  public boolean l;
  private String m;
  public boolean m;
  private String n;
  public boolean n;
  private String o;
  protected boolean o;
  boolean jdField_p_of_type_Boolean;
  public boolean q = true;
  private String r;
  public boolean r = false;
  public boolean s = false;
  public boolean t = false;
  public boolean u = true;
  boolean v;
  private boolean w = false;
  private boolean x = false;
  private boolean jdField_y_of_type_Boolean;
  private boolean z;
  
  static
  {
    jdField_a_of_type_ComTencentSmttSdkValueCallback = null;
    jdField_b_of_type_JavaUtilArrayList = null;
  }
  
  public QQBrowserActivity()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = null;
    this.jdField_M_of_type_JavaLangString = null;
    this.jdField_m_of_type_JavaLangString = "";
    this.jdField_n_of_type_JavaLangString = "";
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface = null;
    this.y = false;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = true;
    this.jdField_n_of_type_Boolean = true;
    this.jdField_o_of_type_Boolean = true;
    this.p = false;
    this.jdField_f_of_type_Long = -1L;
    this.jdField_F_of_type_Int = -1;
    this.jdField_b_of_type_AndroidOsHandler = new eqt(this);
    this.jdField_i_of_type_Long = 0L;
    this.jdField_j_of_type_Long = 4L;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new eqz(this);
    this.jdField_F_of_type_Boolean = false;
  }
  
  private void A()
  {
    this.I = 0;
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(254, 500L);
    b(false);
  }
  
  private void B()
  {
    try
    {
      if (this.textBeforeRight == null) {
        return;
      }
      if (!a())
      {
        if ((!isModeleWindow()) && (isNewTaskActivity()) && (SizeMeasure.a(this)))
        {
          this.textBeforeRight.setVisibility(0);
          return;
        }
        this.textBeforeRight.setVisibility(8);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void C()
  {
    if (this.jdField_d_of_type_AndroidViewView == null) {
      this.jdField_d_of_type_AndroidViewView = getLayoutInflater().inflate(2130904080, null);
    }
    if (this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams == null)
    {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.type = 2002;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.flags = 131112;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.gravity = 51;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x = 0;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = 0;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = -1;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = -2;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.format = 1;
    }
    if (this.jdField_a_of_type_AndroidViewWindowManager == null) {
      this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)getSystemService("window"));
    }
    ((Button)this.jdField_d_of_type_AndroidViewView.findViewById(2131300774)).setOnClickListener(new erv(this));
    try
    {
      this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_d_of_type_AndroidViewView);
      label168:
      this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_d_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
      return;
    }
    catch (Exception localException)
    {
      break label168;
    }
  }
  
  private void D()
  {
    this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a();
    this.aa = null;
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginAd != null) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginAd.b();
    }
  }
  
  private void E()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient = new eqv(this);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebViewClient == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebViewClient = new eqx(this, this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine);
    }
  }
  
  private void F()
  {
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
    if (MttLoader.b(this)) {}
    do
    {
      return;
      localObject = getSharedPreferences("qb_info", 0);
    } while ((localObject == null) || (((SharedPreferences)localObject).getBoolean("click_icon", false)));
    Object localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("click_icon", true);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  private void G()
  {
    new erb(this, "HttpUtils").start();
  }
  
  private void H()
  {
    try
    {
      i1 = NetworkUtil.a(getApplicationContext());
      CharSequence localCharSequence = null;
      switch (i1)
      {
      default: 
        if ((!TextUtils.isEmpty(localCharSequence)) && ((jdField_b_of_type_JavaUtilArrayList == null) || (jdField_b_of_type_JavaUtilArrayList.contains(localCharSequence)))) {
          ThreadManager.b(new ere(this, localCharSequence));
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i1 = 0;
        continue;
        String str = "2G";
        continue;
        str = "3G";
        continue;
        str = "4G";
        continue;
        str = "wifi";
      }
    }
  }
  
  private void I()
  {
    if (this.jdField_c_of_type_AndroidViewView != null) {}
    int i1;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() != 0));
      i1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("webview_add_fav_guide_show_count", 0);
    } while (i1 >= 3);
    this.jdField_c_of_type_AndroidViewView = View.inflate(this, 2130903500, null);
    this.jdField_c_of_type_AndroidViewView.setOnTouchListener(this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_c_of_type_AndroidViewView);
    ThreadManager.b(new erp(this, i1));
  }
  
  /* Error */
  private HttpURLConnection a(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 634	java/net/URL
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 637	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 641	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   11: checkcast 643	java/net/HttpURLConnection
    //   14: astore_1
    //   15: aload_1
    //   16: ldc_w 645
    //   19: invokevirtual 648	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   22: aload_1
    //   23: iconst_1
    //   24: invokevirtual 651	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   27: aload_1
    //   28: iconst_1
    //   29: invokevirtual 654	java/net/HttpURLConnection:setDoInput	(Z)V
    //   32: aload_1
    //   33: iconst_0
    //   34: invokevirtual 657	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   37: aload_1
    //   38: sipush 20000
    //   41: invokevirtual 660	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   44: getstatic 283	android/os/Build$VERSION:SDK_INT	I
    //   47: bipush 13
    //   49: if_icmple +13 -> 62
    //   52: aload_1
    //   53: ldc_w 662
    //   56: ldc_w 664
    //   59: invokevirtual 668	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: aload_1
    //   63: ldc_w 670
    //   66: ldc_w 672
    //   69: invokevirtual 668	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: aload_2
    //   73: ifnull +32 -> 105
    //   76: aload_1
    //   77: ldc_w 674
    //   80: aload_2
    //   81: arraylength
    //   82: invokestatic 679	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   85: invokevirtual 668	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload_1
    //   89: invokevirtual 683	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   92: astore 4
    //   94: aload 4
    //   96: aload_2
    //   97: invokevirtual 689	java/io/OutputStream:write	([B)V
    //   100: aload 4
    //   102: invokevirtual 692	java/io/OutputStream:flush	()V
    //   105: aload_1
    //   106: invokevirtual 695	java/net/HttpURLConnection:getResponseCode	()I
    //   109: istore_3
    //   110: iload_3
    //   111: sipush 200
    //   114: if_icmpne +8 -> 122
    //   117: aload_1
    //   118: areturn
    //   119: astore_1
    //   120: aconst_null
    //   121: areturn
    //   122: aconst_null
    //   123: areturn
    //   124: astore_1
    //   125: aconst_null
    //   126: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	QQBrowserActivity
    //   0	127	1	paramString	String
    //   0	127	2	paramArrayOfByte	byte[]
    //   109	6	3	i1	int
    //   92	9	4	localOutputStream	java.io.OutputStream
    // Exception table:
    //   from	to	target	type
    //   0	22	119	java/lang/Exception
    //   76	105	124	java/lang/Throwable
    //   105	110	124	java/lang/Throwable
  }
  
  private void a()
  {
    this.jdField_k_of_type_Boolean = false;
    if ((this.app == null) && ((getAppRuntime() instanceof BrowserAppInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface = ((BrowserAppInterface)getAppRuntime());
    }
    if (this.app != null) {}
    for (Object localObject = this.app;; localObject = this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface)
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)localObject);
      this.jdField_a_of_type_ComTencentBizAuthorizeConfig = AuthorizeConfig.a();
      return;
    }
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    if (k(this)) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
    for (;;)
    {
      try
      {
        new Thread(new erf(this, paramString3)).start();
        return;
      }
      catch (Throwable paramContext)
      {
        return;
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
  }
  
  private void a(WebView paramWebView)
  {
    if (this.u)
    {
      if (this.jdField_e_of_type_Boolean) {
        b(paramWebView);
      }
    }
    else {
      return;
    }
    boolean bool = paramWebView.canGoBack();
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(bool);
    this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(paramWebView.canGoForward());
  }
  
  private void a(String paramString, int paramInt)
  {
    if (paramInt < 12)
    {
      try
      {
        localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
        localHttpURLConnection.setDoInput(true);
        localHttpURLConnection.setConnectTimeout(20000);
        localHttpURLConnection.setRequestMethod("GET");
        localHttpURLConnection.connect();
        i1 = localHttpURLConnection.getResponseCode();
        if ((i1 != 301) && (i1 != 302)) {
          break label200;
        }
        paramString = localHttpURLConnection.getHeaderFields().keySet().iterator();
        do
        {
          if (!paramString.hasNext()) {
            break;
          }
          str = (String)paramString.next();
        } while (!"location".equalsIgnoreCase(str));
        paramString = localHttpURLConnection.getHeaderField(str);
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          HttpURLConnection localHttpURLConnection;
          int i1;
          String str;
          paramString = null;
          continue;
          paramString = null;
          continue;
          paramString = null;
        }
      }
      if (paramString != null)
      {
        a(MsfSdkUtils.insertMtype("Web", paramString), paramInt + 1);
        return;
      }
      paramString = null;
      str = paramString;
    }
    for (;;)
    {
      try
      {
        localHttpURLConnection.disconnect();
        if (this.jdField_a_of_type_AndroidOsHandler == null) {}
        label200:
        try
        {
          if (this.jdField_a_of_type_AndroidOsHandler == null) {
            this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
          }
          Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 101, paramString).sendToTarget();
          return;
        }
        finally {}
        if (i1 == 200)
        {
          paramString = new Bundle();
          str = paramString;
          paramString.putLong("_filesize", localHttpURLConnection.getContentLength());
          str = paramString;
          paramString.putString("qb_param_url", localHttpURLConnection.getURL().toString());
          str = paramString;
          paramString.putString("param_content_des", "");
          str = paramString;
          paramString.putString("param_mime_type", localHttpURLConnection.getContentType());
        }
      }
      catch (Throwable paramString)
      {
        paramString = str;
        continue;
      }
      paramString = null;
    }
  }
  
  private String b()
  {
    if ((this.jdField_m_of_type_JavaLangString != null) && (this.jdField_m_of_type_JavaLangString.indexOf("qqweb.qq.com/m/qunactivity/form.html") > 0)) {
      return "6.3.0";
    }
    return "5.6.0";
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("appids", paramString2);
    paramString3 = "vkey=" + paramString3 + ";uin=" + paramString4;
    if (QLog.isColorLevel()) {
      QLog.d("gamecenter", 2, "<--httpRequest vookies=" + paramString3 + ",appids=" + paramString2);
    }
    paramString2 = new Bundle();
    paramString2.putString("Cookie", paramString3);
    try
    {
      paramContext = HttpUtil.a(paramContext, paramString1, "POST", localBundle, paramString2);
      if (QLog.isColorLevel()) {
        QLog.i("gamecenter", 2, "httpRequest: result:" + paramContext);
      }
      return paramContext;
    }
    catch (ClientProtocolException paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.i("gamecenter", 2, "httpRequest:ClientProtocolException");
      }
      return "{'ret': -104, 'data' : 'httpRequest:ClientProtocolException'}";
    }
    catch (IOException paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.i("gamecenter", 2, "httpRequest:" + paramContext.getMessage());
      }
    }
    return "{'ret': -105, 'data' : 'httpRequest::Http no response.'}";
  }
  
  private void b(WebView paramWebView)
  {
    if (this.u)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences != null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("flash_auto", paramBoolean).commit();
    }
  }
  
  private boolean c()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences != null) {
      return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("flash_auto", true);
    }
    return false;
  }
  
  private boolean d()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.canGoBack())) {
      return false;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.stopLoading();
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.goBack();
    if (e())
    {
      int i1 = this.jdField_f_of_type_Int - 1;
      this.jdField_f_of_type_Int = i1;
      if (i1 == 0) {
        this.leftView.setBackgroundResource(2130838413);
      }
    }
    return true;
  }
  
  private boolean e()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (isModeleWindow())
    {
      bool1 = bool2;
      if (getIntent().getBooleanExtra("is_share_music", false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void w()
  {
    String str;
    int i1;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.jdField_a_of_type_Boolean))
    {
      str = TimeZone.getDefault().getID();
      if (("CN".equals(Locale.getDefault().getCountry())) && (("Asia/Shanghai".equals(str)) || ("Asia/Chongqing".equals(str)) || ("Asia/Beijing".equals(str)) || ("Asia/Hong_Kong".equals(str)))) {
        if (TbsDownloader.needDownload(BaseApplication.getContext(), false))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TBS_update", 2, "tbs need download");
          }
          this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.a();
          i1 = 1;
        }
      }
    }
    for (;;)
    {
      int i2;
      StringBuilder localStringBuilder;
      if ((this.jdField_l_of_type_Boolean) || (QLog.isColorLevel()))
      {
        i2 = QbSdk.getTbsVersion(getApplicationContext());
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder().append("tbs current webview:");
          if (i2 != 0) {
            break label313;
          }
          str = "sys";
          label164:
          QLog.d("TBS_update", 2, str);
        }
        if (this.jdField_l_of_type_Boolean)
        {
          localStringBuilder = new StringBuilder().append("tbs_cover_");
          if (i1 == 0) {
            break label344;
          }
          if (i2 <= 0) {
            break label337;
          }
          str = "tbs";
        }
      }
      for (;;)
      {
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", str, 0, 1, i2, "", "", "", "");
        return;
        if (!QLog.isColorLevel()) {
          break label351;
        }
        QLog.d("TBS_update", 2, "tbs no need download");
        i1 = 1;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("TBS_update", 2, "tbs loc/tz not match");
        }
        i1 = 0;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("TBS_update", 2, "tbs update disabled");
        }
        i1 = 0;
        break;
        label313:
        str = "x5_" + i2;
        break label164;
        label337:
        str = "sys";
        continue;
        label344:
        str = "dis";
      }
      label351:
      i1 = 1;
    }
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {}
    ViewStub localViewStub;
    do
    {
      return;
      localViewStub = (ViewStub)findViewById(2131298918);
    } while (localViewStub == null);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localViewStub.inflate());
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297017));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298174));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298924));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298173));
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131298921);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setEnabled(true);
    this.jdField_a_of_type_AndroidViewView.postDelayed(new erq(this), 200L);
  }
  
  private void y()
  {
    if (a()) {}
    while ((isModeleWindow()) || (!isNewTaskActivity()) || (this.textBeforeRight == null)) {
      return;
    }
    j();
    this.textBeforeRight.setVisibility(8);
    setBeforeRightButton(0, new ert(this));
    ((SlipEdgeLayout)findViewById(2131296993)).setSlipEdgeCallBack(new eru(this));
  }
  
  private void z()
  {
    if (this.textBeforeRight != null)
    {
      if (this.I % 2 != 0) {
        break label59;
      }
      this.textBeforeRight.setBackgroundResource(2130838394);
    }
    for (;;)
    {
      this.I += 1;
      if (this.I > 5) {
        break;
      }
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(254, 500L);
      return;
      label59:
      j();
    }
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(254);
    j();
  }
  
  public int a(WebViewPlugin paramWebViewPlugin, byte paramByte)
  {
    WebViewPluginEngine localWebViewPluginEngine = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine;
    return WebViewPluginEngine.a(paramWebViewPlugin) * 1000 + paramByte + 10000;
  }
  
  public int a(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine == null) {
      return -1;
    }
    WebViewPluginEngine localWebViewPluginEngine = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine;
    paramByte = WebViewPluginEngine.a(paramWebViewPlugin) * 1000 + paramByte + 10000;
    startActivityForResult(paramIntent, paramByte);
    return paramByte;
  }
  
  public Handler a()
  {
    return this.jdField_b_of_type_AndroidOsHandler;
  }
  
  public View.OnClickListener a()
  {
    return this.jdField_b_of_type_AndroidViewView$OnClickListener;
  }
  
  @TargetApi(9)
  protected View a()
  {
    View localView = super.getLayoutInflater().inflate(2130903300, null);
    this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131297604));
    this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131297606));
    GridView localGridView2 = (GridView)localView.findViewById(2131297605);
    GridView localGridView1 = (GridView)localView.findViewById(2131297607);
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
    }
    localGridView1.setSmoothScrollbarEnabled(false);
    Object localObject2 = a();
    Object localObject1;
    if (localObject2.length > 0)
    {
      localObject1 = localObject2[0];
      if (localObject2.length <= 1) {
        break label352;
      }
    }
    label352:
    for (localObject2 = localObject2[1];; localObject2 = new ArrayList(0))
    {
      int i1 = ((List)localObject1).size();
      localGridView2.setNumColumns(i1);
      ViewGroup.LayoutParams localLayoutParams = localGridView2.getLayoutParams();
      localLayoutParams.width = ((int)(((i1 - 1) * 32 + i1 * 48 + 3) * this.mDensity));
      localGridView2.setLayoutParams(localLayoutParams);
      localGridView2.setAdapter(new PublicAccountBrowser.ActionSheetItemAdapter(this, 0, (List)localObject1));
      localGridView2.setSelector(new ColorDrawable(0));
      localGridView2.setOnItemClickListener(this);
      i1 = localLayoutParams.width;
      this.K = i1;
      int i2 = ((List)localObject2).size();
      localObject1 = localGridView1.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = ((int)((48 * i2 + 32 * (i2 - 1) + 3) * this.mDensity));
      localGridView1.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localGridView1.setNumColumns(i2);
      localGridView1.setAdapter(new PublicAccountBrowser.ActionSheetItemAdapter(this, 0, (List)localObject2));
      localGridView1.setSelector(new ColorDrawable(0));
      localGridView1.setOnItemClickListener(this);
      i2 = ((ViewGroup.LayoutParams)localObject1).width;
      this.J = i2;
      localView.post(new erc(this, i1, i2));
      return localView;
      localObject1 = new ArrayList(0);
      break;
    }
  }
  
  public CustomWebView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView;
  }
  
  public Share a()
  {
    return this.jdField_a_of_type_ComTencentBizWebviewpluginShare;
  }
  
  public WebViewPluginEngine a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine;
  }
  
  public String a()
  {
    return "";
  }
  
  public String a(String paramString)
  {
    paramString = b(this, "https://cgi.connect.qq.com/api/get_openids_by_appids", paramString, this.jdField_o_of_type_JavaLangString, this.N);
    if (QLog.isColorLevel()) {
      QLog.d("QQBrowser", 2, "<--getOpenidBatch result" + paramString);
    }
    return paramString;
  }
  
  public void a(int paramInt) {}
  
  protected void a(Intent paramIntent)
  {
    boolean bool;
    if ((this.jdField_B_of_type_Boolean) || (paramIntent.getExtras().getBoolean("isScreenLandscape", false)))
    {
      bool = true;
      this.jdField_B_of_type_Boolean = bool;
      this.v = paramIntent.getBooleanExtra("ba_is_login", true);
      this.jdField_e_of_type_Int = paramIntent.getIntExtra("reqType", -1);
      this.jdField_a_of_type_AndroidContentSharedPreferences = getSharedPreferences(getPackageName() + "_preferences", 4);
      this.jdField_o_of_type_JavaLangString = paramIntent.getStringExtra("vkey");
      if ((!this.jdField_a_of_type_JavaLangBoolean.booleanValue()) && (!paramIntent.getBooleanExtra("portraitOnly", false)) && (!paramIntent.getExtras().getBoolean("isScreenOrientationPortrait", false))) {
        break label418;
      }
      bool = true;
      label130:
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
      this.z = paramIntent.getBooleanExtra("fromAio", false);
      this.jdField_E_of_type_Boolean = paramIntent.getBooleanExtra("fromPublicAccount", false);
      if ((!this.jdField_o_of_type_Boolean) || (!getIntent().getBooleanExtra("isShowAd", true)) || (!this.z) || (this.jdField_E_of_type_Boolean)) {
        break label423;
      }
      bool = true;
      label196:
      this.jdField_o_of_type_Boolean = bool;
      String str = paramIntent.getStringExtra("key_params_qq");
      if ((!paramIntent.getExtras().getBoolean("hide_operation_bar", false)) && (!"noBottomBar".equals(paramIntent.getStringExtra("webStyle")))) {
        break label428;
      }
      bool = true;
      label241:
      this.C = bool;
      if (this.jdField_e_of_type_Int == 6)
      {
        this.C = true;
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
      }
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_M_of_type_JavaLangString = str;
        this.D = true;
        this.C = true;
      }
      if ((!this.C) && (!this.jdField_g_of_type_Boolean)) {
        break label433;
      }
      a(false);
    }
    for (;;)
    {
      if ((this.jdField_e_of_type_Int == 3) || (this.jdField_e_of_type_Int == 1) || (!this.v)) {
        paramIntent.putExtra("hide_more_button", true);
      }
      b(paramIntent, this.jdField_M_of_type_JavaLangString);
      if (paramIntent.getBooleanExtra("reportMsfLog", false))
      {
        if (this.jdField_c_of_type_AndroidOsHandler == null) {
          this.jdField_c_of_type_AndroidOsHandler = new Handler();
        }
        if (this.jdField_a_of_type_JavaLangRunnable == null)
        {
          this.jdField_a_of_type_JavaLangRunnable = new erg(this);
          this.jdField_c_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
        }
      }
      return;
      bool = false;
      break;
      label418:
      bool = false;
      break label130;
      label423:
      bool = false;
      break label196;
      label428:
      bool = false;
      break label241;
      label433:
      x();
      I();
    }
  }
  
  protected void a(Intent paramIntent, String paramString)
  {
    if (paramString != null)
    {
      paramString = Uri.parse(paramString);
      if ((paramString != null) && (paramString.isHierarchical()))
      {
        paramString = paramString.getQueryParameter("_wv");
        if (paramString == null) {}
      }
    }
    try
    {
      this.jdField_j_of_type_Long = Long.parseLong(paramString.trim());
      if ((this.jdField_j_of_type_Long & 0x2) != 0L) {
        paramIntent.putExtra("hide_more_button", true);
      }
      if ((this.jdField_j_of_type_Long & 1L) != 0L) {
        paramIntent.putExtra("webStyle", "noBottomBar");
      }
      if ((this.jdField_j_of_type_Long & 0x400) != 0L) {
        paramIntent.putExtra("isScreenOrientationPortrait", true);
      }
      if ((this.jdField_j_of_type_Long & 0x20000) > 0L) {
        this.jdField_g_of_type_Boolean = true;
      }
      if ((this.jdField_j_of_type_Long & 0x100000) > 0L) {
        paramIntent.putExtra("ignoreLoginWeb", true);
      }
      if ((this.jdField_j_of_type_Long & 0x800) > 0L) {
        this.jdField_B_of_type_Boolean = true;
      }
      if ((this.jdField_j_of_type_Long & 0x400000) > 0L)
      {
        SosoInterface.a(new err(this, 0, false, 0L, false, false, "webview"));
        SosoInterface.a(new ers(this, 0, true, 0L, false, false, "webview"));
      }
      return;
    }
    catch (NumberFormatException paramIntent)
    {
      while (!QLog.isDevelopLevel()) {}
      QLog.d("QQBrowser", 4, "sorry, i can not get rules from QQBrowser url, maybe have more than one '_wv' in the url");
    }
  }
  
  public void a(View paramView)
  {
    if ((isFinishing()) || (this.jdField_k_of_type_Boolean)) {
      return;
    }
    if (paramView == null) {
      paramView = getWindow().getDecorView();
    }
    for (int i1 = 4;; i1 = 1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = new IconPopupWindow(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(true);
        Object localObject = a();
        ArrayList localArrayList;
        if (localObject.length > 0)
        {
          localArrayList = localObject[0];
          if (localObject.length <= 1) {
            break label169;
          }
        }
        label169:
        for (localObject = localObject[1];; localObject = new ArrayList(0))
        {
          i2 = 0;
          while (i2 < localArrayList.size())
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(((PublicAccountBrowser.ActionSheetItem)localArrayList.get(i2)).jdField_a_of_type_JavaLangString, ((PublicAccountBrowser.ActionSheetItem)localArrayList.get(i2)).l, 0, localArrayList.get(i2), a());
            i2 += 1;
          }
          localArrayList = new ArrayList(0);
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a();
        int i2 = 0;
        while (i2 < ((List)localObject).size())
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(((PublicAccountBrowser.ActionSheetItem)((List)localObject).get(i2)).jdField_a_of_type_JavaLangString, ((PublicAccountBrowser.ActionSheetItem)((List)localObject).get(i2)).l, 0, ((List)localObject).get(i2), a());
          i2 += 1;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a())
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(paramView, i1);
      return;
    }
  }
  
  public void a(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine == null) {
      return;
    }
    WebViewPluginEngine localWebViewPluginEngine = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine;
    int i1 = WebViewPluginEngine.a(paramWebViewPlugin);
    paramIntent.putExtra("keyAction", "actionSelectPicture");
    paramIntent.putExtra("requestCode", i1 * 1000 + paramByte + 10000);
    startActivity(paramIntent);
  }
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2) {}
  
  public void a(WebView paramWebView, String paramString)
  {
    this.jdField_n_of_type_JavaLangString = paramString;
    if ((paramWebView != null) && (paramString != null) && ((paramString.indexOf("pad.ac.qq.com/Pad") > 0) || (paramString.indexOf("itunes.apple") > 0))) {
      paramWebView.loadUrl("javascript:document.getElementsByName('viewport')[0].content = 'width=device-width,height=device-height,initial-scale=1.0,minimum-scale=1.0,maximum-scale=2.5,user-scalable=no,minimal-ui'");
    }
    B();
    if ((c()) && (paramString != null) && ((paramString.indexOf("pad.ac.qq.com/Pad/view/id") > 0) || ((paramString.indexOf("bookshelf.html5.qq.com") > 0) && (paramString.indexOf("/detail/") > 0)))) {
      A();
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      this.leftView.setVisibility(4);
      if ((paramString2 != null) && (paramString2.length() != 0)) {
        break label106;
      }
      this.rightViewText.setVisibility(8);
    }
    for (;;)
    {
      if ((paramString3 != null) && (paramString3.length() != 0)) {
        break label134;
      }
      setTitle("");
      return;
      if (paramString1.equals("RETURN")) {
        this.leftView.setText(getIntent().getStringExtra("leftViewText"));
      }
      for (;;)
      {
        this.leftView.setVisibility(0);
        break;
        this.leftView.setText(paramString1);
      }
      label106:
      this.rightViewText.setText(paramString2);
      this.rightViewText.setVisibility(0);
      this.rightViewImg.setVisibility(8);
    }
    label134:
    setTitle(paramString3);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (!e()))
    {
      b(paramString2, paramString3, paramString1);
      if (paramBoolean)
      {
        this.rightViewText.setVisibility(8);
        this.rightViewImg.setVisibility(8);
        if (this.jdField_f_of_type_AndroidWidgetImageView != null) {
          this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
      return;
    }
    this.rightViewText.setVisibility(8);
    this.rightViewImg.setVisibility(0);
    switch (paramInt1)
    {
    default: 
      this.rightViewImg.setVisibility(8);
      label121:
      if (paramInt2 != 0)
      {
        if (this.jdField_f_of_type_AndroidWidgetImageView == null)
        {
          this.jdField_f_of_type_AndroidWidgetImageView = new ImageView(this);
          paramString3 = (RelativeLayout)findViewById(2131297350);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(7, 2131297361);
          localLayoutParams.addRule(6, 2131297361);
          localLayoutParams.setMargins(0, 0, 0, 0);
          this.jdField_f_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
          paramString3.addView(this.jdField_f_of_type_AndroidWidgetImageView);
        }
        this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
        switch (paramInt2)
        {
        default: 
          this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
          label253:
          if (!TextUtils.isEmpty(paramString2)) {
            this.rightViewImg.setContentDescription(paramString2);
          }
          if (paramString1 == null) {}
          break;
        }
      }
      break;
    }
    for (this.aa = paramString1.trim();; this.aa = null)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      break;
      paramString3 = this.rightViewImg;
      if (isModeleWindow()) {}
      for (paramInt1 = 2130839512;; paramInt1 = 2130839511)
      {
        paramString3.setImageResource(paramInt1);
        break;
      }
      this.rightViewImg.setImageResource(2130841681);
      break label121;
      this.rightViewImg.setImageResource(2130838415);
      break label121;
      paramString3 = this.rightViewImg;
      if (isModeleWindow()) {}
      for (paramInt1 = 2130838108;; paramInt1 = 2130838104)
      {
        paramString3.setImageResource(paramInt1);
        break;
      }
      paramString3 = this.rightViewImg;
      if (isModeleWindow()) {}
      for (paramInt1 = 2130839520;; paramInt1 = 2130839519)
      {
        paramString3.setImageResource(paramInt1);
        ((AnimationDrawable)this.rightViewImg.getDrawable()).start();
        break;
      }
      this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130839470);
      break label253;
      if (this.jdField_f_of_type_AndroidWidgetImageView == null) {
        break label253;
      }
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
      break label253;
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3)
  {
    boolean bool = false;
    Object localObject1 = null;
    Object localObject2;
    int i1;
    if (paramString1.equals("left"))
    {
      localObject1 = this.leftView;
      localObject2 = getResources();
      if (paramBoolean2)
      {
        i1 = 2130842089;
        ((View)localObject1).setBackgroundDrawable(((Resources)localObject2).getDrawable(i1));
        i1 = 0;
      }
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        return;
        i1 = 2130842093;
        break;
        if (paramString1.equals("right"))
        {
          localObject1 = this.rightViewText;
          i1 = 1;
          continue;
        }
        if (!paramString1.equals("rightImgBtn")) {
          break label239;
        }
        localObject1 = this.rightViewImg;
        localObject2 = this.rightViewImg;
        if (isModeleWindow()) {}
        for (i1 = 2130838108;; i1 = 2130838104)
        {
          ((ImageView)localObject2).setImageResource(i1);
          i1 = 2;
          break;
        }
      }
      if ((localObject1 instanceof TextView)) {
        ((TextView)localObject1).setText(paramString2);
      }
      if (paramBoolean1) {}
      for (int i2 = 0;; i2 = 8)
      {
        ((View)localObject1).setVisibility(i2);
        paramBoolean1 = bool;
        if (!paramBoolean3) {
          paramBoolean1 = true;
        }
        ((View)localObject1).setEnabled(paramBoolean1);
        ((View)localObject1).setContentDescription(paramString2);
        paramString2 = new QQBrowserActivity.TopBarBtnClickListener(this, i1, paramString3);
        ((View)localObject1).setOnClickListener(paramString2);
        if (!paramString1.equals("left")) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity$TopBarBtnClickListener = paramString2;
        return;
      }
      label239:
      i1 = 0;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a();
    QfavBuilder.a(paramString).c(str).a(this, str, 2, null);
    paramString = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (paramBoolean) {}
    for (int i1 = 42;; i1 = 45)
    {
      QfavReport.a(paramString, i1, 2);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.u == paramBoolean) {}
    int i1;
    label39:
    Object localObject;
    do
    {
      return;
      this.u = paramBoolean;
      if (!paramBoolean) {
        break;
      }
      i1 = 0;
      if (!paramBoolean) {
        break label129;
      }
      if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
        break label122;
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(i1);
      if ((!paramBoolean) && (this.jdField_c_of_type_AndroidViewView != null))
      {
        localObject = this.jdField_c_of_type_AndroidViewView.getParent();
        if ((localObject != null) && ((localObject instanceof ViewGroup))) {
          ((ViewGroup)localObject).removeView(this.jdField_c_of_type_AndroidViewView);
        }
      }
      localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetAbsoluteLayout.getLayoutParams();
    } while (localObject == null);
    if (paramBoolean) {}
    for (((FrameLayout.LayoutParams)localObject).bottomMargin = this.jdField_g_of_type_Int;; ((FrameLayout.LayoutParams)localObject).bottomMargin = 0)
    {
      this.jdField_a_of_type_AndroidWidgetAbsoluteLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      i1 = 8;
      break;
      label122:
      x();
      break label39;
      label129:
      if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
        break label39;
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(i1);
      break label39;
      this.jdField_g_of_type_Int = ((FrameLayout.LayoutParams)localObject).bottomMargin;
    }
  }
  
  public boolean a()
  {
    if (getTabIndex() == 5) {}
    while ((this.jdField_m_of_type_JavaLangString != null) && ((this.jdField_m_of_type_JavaLangString.indexOf("inews.qq") > 0) || (this.jdField_m_of_type_JavaLangString.indexOf("bookshelf.html5.qq") > 0) || (this.jdField_m_of_type_JavaLangString.indexOf("m.ac.qq") > 0))) {
      return false;
    }
    return true;
  }
  
  public boolean a(WebView paramWebView, String paramString)
  {
    return false;
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramString);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramString1, paramString2, paramString3, paramString4);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    return this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8);
  }
  
  public boolean a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      return false;
      paramString2 = new HashMap();
      paramString2.put("KEY_PID", String.valueOf(50079));
      paramString2.put("KEY_EUSESTAT", String.valueOf(5));
      int i1 = MttLoader.a(this, MttLoader.a(this, paramString1), paramString2);
      if (paramBoolean)
      {
        if (4 != i1) {
          break label92;
        }
        paramString1 = DialogUtil.a(this, 230);
        paramString1.setMessage(2131367959);
        paramString1.show();
      }
      while (i1 == 0)
      {
        return true;
        label92:
        if (5 == i1)
        {
          paramString1 = DialogUtil.a(this, 230);
          paramString1.setMessage("QQ浏览器版本过低");
          paramString1.show();
        }
        else if (i1 != 0)
        {
          paramString1 = DialogUtil.a(this, 230);
          paramString1.setMessage(2131367959);
          paramString1.show();
        }
      }
    }
  }
  
  public List[] a()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_j_of_type_Long & 0x8) == 0L)
    {
      localObject = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131363654);
      ((PublicAccountBrowser.ActionSheetItem)localObject).l = 2130837971;
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
      ((PublicAccountBrowser.ActionSheetItem)localObject).m = 2;
      ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
      localArrayList.add(localObject);
    }
    if ((this.jdField_j_of_type_Long & 0x10) == 0L)
    {
      localObject = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131363660);
      ((PublicAccountBrowser.ActionSheetItem)localObject).l = 2130837972;
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
      ((PublicAccountBrowser.ActionSheetItem)localObject).m = 3;
      ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
      localArrayList.add(localObject);
    }
    if ((this.jdField_j_of_type_Long & 0x200) == 0L)
    {
      localObject = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131363659);
      ((PublicAccountBrowser.ActionSheetItem)localObject).l = 2130839264;
      ((PublicAccountBrowser.ActionSheetItem)localObject).m = 5;
      ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
      localArrayList.add(localObject);
    }
    if ((this.jdField_j_of_type_Long & 0x100) == 0L)
    {
      localObject = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131363658);
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
      ((PublicAccountBrowser.ActionSheetItem)localObject).l = 2130839262;
      ((PublicAccountBrowser.ActionSheetItem)localObject).m = 4;
      ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
      localArrayList.add(localObject);
    }
    Object localObject = new ArrayList();
    if ((this.jdField_j_of_type_Long & 0x2000) == 0L)
    {
      localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
      localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131363668);
      localActionSheetItem.jdField_a_of_type_Boolean = true;
      localActionSheetItem.l = 2130839610;
      localActionSheetItem.m = 6;
      localActionSheetItem.b = "";
      ((ArrayList)localObject).add(localActionSheetItem);
    }
    if ((this.jdField_j_of_type_Long & 0x20) == 0L)
    {
      localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
      localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131363656);
      localActionSheetItem.l = 2130837969;
      localActionSheetItem.jdField_a_of_type_Boolean = true;
      localActionSheetItem.m = 1;
      localActionSheetItem.b = "";
      ((ArrayList)localObject).add(localActionSheetItem);
    }
    PublicAccountBrowser.ActionSheetItem localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131363657);
    localActionSheetItem.l = 2130839251;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.m = 11;
    localActionSheetItem.b = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList, localObject };
  }
  
  protected void addTopLayout() {}
  
  public void b()
  {
    Object localObject1;
    Object localObject2;
    if (!this.s)
    {
      this.s = true;
      localObject1 = getIntent();
      this.jdField_M_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("url");
      if (this.jdField_M_of_type_JavaLangString == null)
      {
        this.jdField_M_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("key_params_qq");
        if (this.jdField_M_of_type_JavaLangString == null) {
          this.jdField_M_of_type_JavaLangString = "";
        }
      }
      this.jdField_m_of_type_JavaLangString = this.jdField_M_of_type_JavaLangString;
      this.jdField_g_of_type_Boolean = ((Intent)localObject1).getExtras().getBoolean("isFullScreen", false);
      localObject2 = ((Intent)localObject1).getStringExtra("options");
      if (localObject2 == null) {}
    }
    try
    {
      localObject2 = new JSONObject((String)localObject2);
      this.jdField_M_of_type_JavaLangString = ((JSONObject)localObject2).getString("url");
      if (!((Intent)localObject1).hasExtra("key_isReadModeEnabled")) {
        ((Intent)localObject1).putExtra("key_isReadModeEnabled", true);
      }
      ((Intent)localObject1).putExtra("ba_is_login", ((JSONObject)localObject2).optBoolean("ba_is_login", true));
      ((Intent)localObject1).putExtra("isShowAd", ((JSONObject)localObject2).optBoolean("isShowAd", true));
      ((Intent)localObject1).putExtra("avoidLoginWeb", ((JSONObject)localObject2).optBoolean("avoidLoginWeb", false));
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("QQBrowser", 2, localJSONException.toString());
          continue;
          if (!this.jdField_F_of_type_Boolean) {
            setContentView(2130903130);
          }
          this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)((ViewStub)findViewById(2131296999)).inflate());
          this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
          this.jdField_b_of_type_AndroidViewView = findViewById(2131298498);
          removeWebViewLayerType();
          if (this.vg != null) {
            this.vg.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
          }
        }
      }
    }
    a((Intent)localObject1, this.jdField_M_of_type_JavaLangString);
    if (this.jdField_g_of_type_Boolean)
    {
      if (!this.jdField_F_of_type_Boolean)
      {
        getWindow().setFlags(1024, 1024);
        setContentViewNoTitle(2130903130);
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)((ViewStub)findViewById(2131296999)).inflate());
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131298498);
      v();
      localObject1 = ThemeUtil.getCurrentThemeInfo().getString("themeId");
      this.jdField_a_of_type_AndroidWidgetAbsoluteLayout = ((AbsoluteLayout)findViewById(2131298915));
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = ((CustomWebView)findViewById(2131296450));
      if (!this.jdField_F_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131296735));
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      }
      if ("1103".equals(localObject1)) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      a(getIntent());
      this.Y = this.jdField_M_of_type_JavaLangString;
      return;
      a(getIntent());
      return;
    }
  }
  
  public void b(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    this.leftView.setTextColor(paramInt);
    this.centerView.setTextColor(paramInt);
    this.rightViewText.setTextColor(paramInt);
    this.jdField_b_of_type_AndroidOsHandler.obtainMessage(2, paramInt, 0).sendToTarget();
  }
  
  /* Error */
  public void b(Intent paramIntent, String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: aload_1
    //   4: ifnull +17 -> 21
    //   7: aload_2
    //   8: invokestatic 538	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifne +10 -> 21
    //   14: aload_0
    //   15: getfield 238	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_g_of_type_Boolean	Z
    //   18: ifeq +12 -> 30
    //   21: aload_0
    //   22: getfield 216	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_a_of_type_ComTencentBizPubaccountCustomWebView	Lcom/tencent/biz/pubaccount/CustomWebView;
    //   25: iconst_0
    //   26: invokevirtual 1722	com/tencent/biz/pubaccount/CustomWebView:setVisibility	(I)V
    //   29: return
    //   30: aload_2
    //   31: ifnull +201 -> 232
    //   34: aload_2
    //   35: invokestatic 1298	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   38: astore 8
    //   40: aload 8
    //   42: ldc_w 1724
    //   45: invokevirtual 1306	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   48: astore 7
    //   50: aload 7
    //   52: invokestatic 538	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   55: ifne +68 -> 123
    //   58: aload 7
    //   60: ldc_w 1726
    //   63: invokevirtual 1729	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   66: ifeq +786 -> 852
    //   69: aload 7
    //   71: iconst_2
    //   72: invokevirtual 1732	java/lang/String:substring	(I)Ljava/lang/String;
    //   75: astore 7
    //   77: aload 7
    //   79: bipush 16
    //   81: invokestatic 1735	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   84: l2i
    //   85: istore 4
    //   87: iload 4
    //   89: istore_3
    //   90: aload 7
    //   92: invokevirtual 1423	java/lang/String:length	()I
    //   95: bipush 6
    //   97: if_icmpgt +10 -> 107
    //   100: iload 4
    //   102: ldc_w 1736
    //   105: ior
    //   106: istore_3
    //   107: aload_0
    //   108: getfield 876	com/tencent/mobileqq/activity/QQBrowserActivity:vg	Landroid/view/ViewGroup;
    //   111: iconst_0
    //   112: invokevirtual 1737	android/view/ViewGroup:setBackgroundResource	(I)V
    //   115: aload_0
    //   116: getfield 876	com/tencent/mobileqq/activity/QQBrowserActivity:vg	Landroid/view/ViewGroup;
    //   119: iload_3
    //   120: invokevirtual 1740	android/view/ViewGroup:setBackgroundColor	(I)V
    //   123: aload_0
    //   124: getfield 316	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_j_of_type_Long	J
    //   127: ldc2_w 313
    //   130: land
    //   131: lconst_0
    //   132: lcmp
    //   133: ifne +27 -> 160
    //   136: aload_0
    //   137: getfield 620	com/tencent/mobileqq/activity/QQBrowserActivity:leftView	Landroid/widget/TextView;
    //   140: ifnull +20 -> 160
    //   143: aload_0
    //   144: getfield 620	com/tencent/mobileqq/activity/QQBrowserActivity:leftView	Landroid/widget/TextView;
    //   147: aload_0
    //   148: invokevirtual 1490	com/tencent/mobileqq/activity/QQBrowserActivity:getResources	()Landroid/content/res/Resources;
    //   151: ldc_w 1741
    //   154: invokevirtual 1742	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   157: invokevirtual 1437	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   160: aload 8
    //   162: ldc_w 1744
    //   165: invokevirtual 1306	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   168: astore 7
    //   170: aload 7
    //   172: invokestatic 538	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   175: ifne +57 -> 232
    //   178: aload 7
    //   180: ldc_w 1726
    //   183: invokevirtual 1729	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   186: ifeq +663 -> 849
    //   189: aload 7
    //   191: iconst_2
    //   192: invokevirtual 1732	java/lang/String:substring	(I)Ljava/lang/String;
    //   195: astore 7
    //   197: aload 7
    //   199: bipush 16
    //   201: invokestatic 1735	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   204: l2i
    //   205: istore 4
    //   207: iload 4
    //   209: istore_3
    //   210: aload 7
    //   212: invokevirtual 1423	java/lang/String:length	()I
    //   215: bipush 6
    //   217: if_icmpgt +10 -> 227
    //   220: iload 4
    //   222: ldc_w 1736
    //   225: ior
    //   226: istore_3
    //   227: aload_0
    //   228: iload_3
    //   229: invokevirtual 1746	com/tencent/mobileqq/activity/QQBrowserActivity:b	(I)V
    //   232: aload_0
    //   233: getfield 316	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_j_of_type_Long	J
    //   236: ldc2_w 1747
    //   239: land
    //   240: lconst_0
    //   241: lcmp
    //   242: ifeq +559 -> 801
    //   245: aload_2
    //   246: ldc_w 1750
    //   249: invokevirtual 1729	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   252: ifeq +549 -> 801
    //   255: aload_2
    //   256: invokestatic 1754	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;)Ljava/lang/String;
    //   259: ldc_w 1756
    //   262: invokevirtual 799	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   265: ifeq +536 -> 801
    //   268: aload_0
    //   269: iconst_1
    //   270: putfield 289	com/tencent/mobileqq/activity/QQBrowserActivity:p	Z
    //   273: aload_0
    //   274: invokevirtual 1353	com/tencent/mobileqq/activity/QQBrowserActivity:getWindow	()Landroid/view/Window;
    //   277: ldc_w 1757
    //   280: invokevirtual 1760	android/view/Window:setBackgroundDrawableResource	(I)V
    //   283: aload_0
    //   284: invokevirtual 1763	com/tencent/mobileqq/activity/QQBrowserActivity:hideTitleBar	()V
    //   287: aload_0
    //   288: getfield 216	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_a_of_type_ComTencentBizPubaccountCustomWebView	Lcom/tencent/biz/pubaccount/CustomWebView;
    //   291: invokevirtual 1766	com/tencent/biz/pubaccount/CustomWebView:getView	()Landroid/view/View;
    //   294: iconst_0
    //   295: invokevirtual 1767	android/view/View:setBackgroundColor	(I)V
    //   298: aload_0
    //   299: getfield 216	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_a_of_type_ComTencentBizPubaccountCustomWebView	Lcom/tencent/biz/pubaccount/CustomWebView;
    //   302: invokevirtual 1766	com/tencent/biz/pubaccount/CustomWebView:getView	()Landroid/view/View;
    //   305: invokevirtual 1770	android/view/View:getBackground	()Landroid/graphics/drawable/Drawable;
    //   308: iconst_0
    //   309: invokevirtual 1775	android/graphics/drawable/Drawable:setAlpha	(I)V
    //   312: aload_0
    //   313: getfield 216	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_a_of_type_ComTencentBizPubaccountCustomWebView	Lcom/tencent/biz/pubaccount/CustomWebView;
    //   316: iconst_0
    //   317: invokevirtual 1776	com/tencent/biz/pubaccount/CustomWebView:setBackgroundColor	(I)V
    //   320: aload_0
    //   321: getfield 216	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_a_of_type_ComTencentBizPubaccountCustomWebView	Lcom/tencent/biz/pubaccount/CustomWebView;
    //   324: invokevirtual 1777	com/tencent/biz/pubaccount/CustomWebView:getBackground	()Landroid/graphics/drawable/Drawable;
    //   327: iconst_0
    //   328: invokevirtual 1775	android/graphics/drawable/Drawable:setAlpha	(I)V
    //   331: aload_0
    //   332: getfield 216	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_a_of_type_ComTencentBizPubaccountCustomWebView	Lcom/tencent/biz/pubaccount/CustomWebView;
    //   335: ifnull +11 -> 346
    //   338: aload_0
    //   339: getfield 216	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_a_of_type_ComTencentBizPubaccountCustomWebView	Lcom/tencent/biz/pubaccount/CustomWebView;
    //   342: iconst_0
    //   343: invokevirtual 1722	com/tencent/biz/pubaccount/CustomWebView:setVisibility	(I)V
    //   346: aload_2
    //   347: invokestatic 538	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   350: ifne +22 -> 372
    //   353: aload_2
    //   354: ldc_w 1779
    //   357: invokevirtual 1781	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   360: ifeq +12 -> 372
    //   363: aload_1
    //   364: ldc_w 1252
    //   367: iconst_1
    //   368: invokevirtual 1272	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   371: pop
    //   372: aload_0
    //   373: aload_1
    //   374: ldc_w 1783
    //   377: invokevirtual 1245	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   380: putfield 244	com/tencent/mobileqq/activity/QQBrowserActivity:W	Ljava/lang/String;
    //   383: aload_0
    //   384: aload_1
    //   385: invokevirtual 1227	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   388: ldc_w 1785
    //   391: iconst_0
    //   392: invokevirtual 1230	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   395: putfield 258	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_d_of_type_Boolean	Z
    //   398: aload_0
    //   399: aload_1
    //   400: invokevirtual 1227	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   403: ldc_w 1787
    //   406: iconst_0
    //   407: invokevirtual 1230	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   410: putfield 260	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_e_of_type_Boolean	Z
    //   413: iload 6
    //   415: istore 5
    //   417: aload_0
    //   418: getfield 1266	com/tencent/mobileqq/activity/QQBrowserActivity:D	Z
    //   421: ifne +23 -> 444
    //   424: aload_0
    //   425: invokevirtual 968	com/tencent/mobileqq/activity/QQBrowserActivity:getIntent	()Landroid/content/Intent;
    //   428: invokevirtual 1227	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   431: ldc 34
    //   433: iconst_0
    //   434: invokevirtual 1230	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   437: ifeq +380 -> 817
    //   440: iload 6
    //   442: istore 5
    //   444: aload_0
    //   445: iload 5
    //   447: putfield 1266	com/tencent/mobileqq/activity/QQBrowserActivity:D	Z
    //   450: aload_1
    //   451: invokevirtual 1227	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   454: ldc 30
    //   456: iconst_0
    //   457: invokevirtual 1230	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   460: istore 5
    //   462: aload_0
    //   463: aload_1
    //   464: invokevirtual 1227	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   467: ldc 37
    //   469: iconst_0
    //   470: invokevirtual 1230	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   473: putfield 262	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_f_of_type_Boolean	Z
    //   476: aload_0
    //   477: aload_1
    //   478: invokevirtual 1227	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   481: ldc 40
    //   483: iconst_0
    //   484: invokevirtual 1230	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   487: putfield 264	com/tencent/mobileqq/activity/QQBrowserActivity:w	Z
    //   490: invokestatic 910	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   493: ifeq +36 -> 529
    //   496: ldc 155
    //   498: iconst_2
    //   499: new 895	java/lang/StringBuilder
    //   502: dup
    //   503: invokespecial 896	java/lang/StringBuilder:<init>	()V
    //   506: ldc_w 1789
    //   509: invokevirtual 902	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: aload_2
    //   513: iconst_0
    //   514: anewarray 676	java/lang/String
    //   517: invokestatic 1792	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   520: invokevirtual 902	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: invokevirtual 905	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   526: invokestatic 919	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   529: aload_0
    //   530: getfield 244	com/tencent/mobileqq/activity/QQBrowserActivity:W	Ljava/lang/String;
    //   533: ifnull +290 -> 823
    //   536: aload_0
    //   537: getfield 244	com/tencent/mobileqq/activity/QQBrowserActivity:W	Ljava/lang/String;
    //   540: invokevirtual 1423	java/lang/String:length	()I
    //   543: ifle +280 -> 823
    //   546: aload_0
    //   547: aload_0
    //   548: getfield 244	com/tencent/mobileqq/activity/QQBrowserActivity:W	Ljava/lang/String;
    //   551: invokevirtual 1430	com/tencent/mobileqq/activity/QQBrowserActivity:setTitle	(Ljava/lang/CharSequence;)V
    //   554: aload_0
    //   555: getfield 616	com/tencent/mobileqq/activity/QQBrowserActivity:rightViewImg	Landroid/widget/ImageView;
    //   558: ifnull +72 -> 630
    //   561: aload_0
    //   562: getfield 616	com/tencent/mobileqq/activity/QQBrowserActivity:rightViewImg	Landroid/widget/ImageView;
    //   565: aload_0
    //   566: invokevirtual 1071	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   569: aload_0
    //   570: getfield 1426	com/tencent/mobileqq/activity/QQBrowserActivity:rightViewText	Landroid/widget/TextView;
    //   573: aload_0
    //   574: invokevirtual 1793	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   577: aload_0
    //   578: getfield 616	com/tencent/mobileqq/activity/QQBrowserActivity:rightViewImg	Landroid/widget/ImageView;
    //   581: aload_0
    //   582: invokevirtual 1490	com/tencent/mobileqq/activity/QQBrowserActivity:getResources	()Landroid/content/res/Resources;
    //   585: ldc_w 1794
    //   588: invokevirtual 1742	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   591: invokevirtual 1464	android/widget/ImageView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   594: aload_0
    //   595: getfield 1266	com/tencent/mobileqq/activity/QQBrowserActivity:D	Z
    //   598: ifne +32 -> 630
    //   601: aload_0
    //   602: getfield 616	com/tencent/mobileqq/activity/QQBrowserActivity:rightViewImg	Landroid/widget/ImageView;
    //   605: iconst_0
    //   606: invokevirtual 486	android/widget/ImageView:setVisibility	(I)V
    //   609: aload_0
    //   610: getfield 616	com/tencent/mobileqq/activity/QQBrowserActivity:rightViewImg	Landroid/widget/ImageView;
    //   613: astore_1
    //   614: aload_0
    //   615: invokevirtual 366	com/tencent/mobileqq/activity/QQBrowserActivity:isModeleWindow	()Z
    //   618: ifeq +214 -> 832
    //   621: ldc_w 1472
    //   624: istore_3
    //   625: aload_1
    //   626: iload_3
    //   627: invokevirtual 1468	android/widget/ImageView:setImageResource	(I)V
    //   630: iload 5
    //   632: ifeq +18 -> 650
    //   635: aload_0
    //   636: getfield 620	com/tencent/mobileqq/activity/QQBrowserActivity:leftView	Landroid/widget/TextView;
    //   639: ifnull +11 -> 650
    //   642: aload_0
    //   643: getfield 620	com/tencent/mobileqq/activity/QQBrowserActivity:leftView	Landroid/widget/TextView;
    //   646: iconst_4
    //   647: invokevirtual 380	android/widget/TextView:setVisibility	(I)V
    //   650: aload_0
    //   651: getfield 262	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_f_of_type_Boolean	Z
    //   654: ifeq +67 -> 721
    //   657: aload_0
    //   658: getfield 1426	com/tencent/mobileqq/activity/QQBrowserActivity:rightViewText	Landroid/widget/TextView;
    //   661: ifnull +28 -> 689
    //   664: aload_0
    //   665: getfield 1426	com/tencent/mobileqq/activity/QQBrowserActivity:rightViewText	Landroid/widget/TextView;
    //   668: ldc_w 1795
    //   671: invokevirtual 1797	android/widget/TextView:setText	(I)V
    //   674: aload_0
    //   675: getfield 1426	com/tencent/mobileqq/activity/QQBrowserActivity:rightViewText	Landroid/widget/TextView;
    //   678: iconst_0
    //   679: invokevirtual 380	android/widget/TextView:setVisibility	(I)V
    //   682: aload_0
    //   683: getfield 1426	com/tencent/mobileqq/activity/QQBrowserActivity:rightViewText	Landroid/widget/TextView;
    //   686: invokevirtual 1800	android/widget/TextView:bringToFront	()V
    //   689: aload_0
    //   690: getfield 616	com/tencent/mobileqq/activity/QQBrowserActivity:rightViewImg	Landroid/widget/ImageView;
    //   693: ifnull +28 -> 721
    //   696: aload_0
    //   697: getfield 616	com/tencent/mobileqq/activity/QQBrowserActivity:rightViewImg	Landroid/widget/ImageView;
    //   700: iconst_0
    //   701: invokevirtual 1468	android/widget/ImageView:setImageResource	(I)V
    //   704: aload_0
    //   705: getfield 616	com/tencent/mobileqq/activity/QQBrowserActivity:rightViewImg	Landroid/widget/ImageView;
    //   708: iconst_0
    //   709: invokevirtual 1801	android/widget/ImageView:setBackgroundColor	(I)V
    //   712: aload_0
    //   713: getfield 616	com/tencent/mobileqq/activity/QQBrowserActivity:rightViewImg	Landroid/widget/ImageView;
    //   716: bipush 8
    //   718: invokevirtual 486	android/widget/ImageView:setVisibility	(I)V
    //   721: aload_0
    //   722: getfield 226	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   725: invokestatic 538	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   728: ifeq +8 -> 736
    //   731: aload_0
    //   732: aload_2
    //   733: putfield 226	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   736: aload_0
    //   737: invokespecial 1803	com/tencent/mobileqq/activity/QQBrowserActivity:y	()V
    //   740: return
    //   741: astore 7
    //   743: invokestatic 1346	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   746: ifeq -623 -> 123
    //   749: ldc 155
    //   751: iconst_4
    //   752: ldc_w 1805
    //   755: invokestatic 919	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   758: goto -635 -> 123
    //   761: astore 7
    //   763: invokestatic 1346	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   766: ifeq -534 -> 232
    //   769: ldc 155
    //   771: iconst_4
    //   772: ldc_w 1807
    //   775: invokestatic 919	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   778: goto -546 -> 232
    //   781: astore 7
    //   783: invokestatic 1346	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   786: ifeq -554 -> 232
    //   789: ldc 155
    //   791: iconst_4
    //   792: ldc_w 1809
    //   795: invokestatic 919	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   798: goto -566 -> 232
    //   801: aload_0
    //   802: iconst_0
    //   803: putfield 289	com/tencent/mobileqq/activity/QQBrowserActivity:p	Z
    //   806: aload_0
    //   807: invokevirtual 1353	com/tencent/mobileqq/activity/QQBrowserActivity:getWindow	()Landroid/view/Window;
    //   810: aconst_null
    //   811: invokevirtual 1810	android/view/Window:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   814: goto -483 -> 331
    //   817: iconst_0
    //   818: istore 5
    //   820: goto -376 -> 444
    //   823: aload_0
    //   824: ldc 224
    //   826: invokevirtual 1430	com/tencent/mobileqq/activity/QQBrowserActivity:setTitle	(Ljava/lang/CharSequence;)V
    //   829: goto -275 -> 554
    //   832: ldc_w 1473
    //   835: istore_3
    //   836: goto -211 -> 625
    //   839: astore 7
    //   841: goto -510 -> 331
    //   844: astore 7
    //   846: goto -534 -> 312
    //   849: goto -652 -> 197
    //   852: goto -775 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	855	0	this	QQBrowserActivity
    //   0	855	1	paramIntent	Intent
    //   0	855	2	paramString	String
    //   89	747	3	i1	int
    //   85	141	4	i2	int
    //   415	404	5	bool1	boolean
    //   1	440	6	bool2	boolean
    //   48	163	7	str	String
    //   741	1	7	localNumberFormatException1	NumberFormatException
    //   761	1	7	localUnsupportedOperationException	java.lang.UnsupportedOperationException
    //   781	1	7	localNumberFormatException2	NumberFormatException
    //   839	1	7	localException1	Exception
    //   844	1	7	localException2	Exception
    //   38	123	8	localUri	Uri
    // Exception table:
    //   from	to	target	type
    //   77	87	741	java/lang/NumberFormatException
    //   90	100	741	java/lang/NumberFormatException
    //   107	123	741	java/lang/NumberFormatException
    //   34	77	761	java/lang/UnsupportedOperationException
    //   77	87	761	java/lang/UnsupportedOperationException
    //   90	100	761	java/lang/UnsupportedOperationException
    //   107	123	761	java/lang/UnsupportedOperationException
    //   123	160	761	java/lang/UnsupportedOperationException
    //   160	197	761	java/lang/UnsupportedOperationException
    //   197	207	761	java/lang/UnsupportedOperationException
    //   210	220	761	java/lang/UnsupportedOperationException
    //   227	232	761	java/lang/UnsupportedOperationException
    //   743	758	761	java/lang/UnsupportedOperationException
    //   783	798	761	java/lang/UnsupportedOperationException
    //   197	207	781	java/lang/NumberFormatException
    //   210	220	781	java/lang/NumberFormatException
    //   227	232	781	java/lang/NumberFormatException
    //   312	331	839	java/lang/Exception
    //   287	312	844	java/lang/Exception
  }
  
  public void b(WebView paramWebView, String paramString) {}
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    int i2 = 0;
    if (!TextUtils.isEmpty(paramString1))
    {
      this.rightViewText.setText(paramString1);
      this.rightViewText.setVisibility(0);
      this.rightViewText.bringToFront();
      this.rightViewImg.setImageResource(0);
      this.rightViewImg.setBackgroundColor(0);
      this.rightViewImg.setVisibility(8);
    }
    int i1;
    if (paramString2 != null)
    {
      i1 = i2;
      if (paramString2.length() <= 0) {}
    }
    try
    {
      i1 = Color.parseColor(paramString2);
      this.rightViewImg.setBackgroundColor(i1);
      if (paramString3 != null)
      {
        this.rightViewText.setOnClickListener(this);
        this.aa = paramString3.trim();
        return;
      }
      this.aa = null;
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        i1 = i2;
      }
    }
  }
  
  public boolean b()
  {
    return this.jdField_h_of_type_Boolean;
  }
  
  public void c() {}
  
  protected void checkUnlockForSpecial()
  {
    super.checkUnlockForSpecial();
    if (QLog.isColorLevel()) {
      QLog.d("baseactivity", 2, "QQBrowserActivity.uin=" + this.N);
    }
    if ((!mAppForground) && (this.mCanLock) && (!TextUtils.isEmpty(this.N)) && (GesturePWDUtils.getGesturePWDState(this, this.N) == 2) && (GesturePWDUtils.getGesturePWDMode(this, this.N) == 21)) {
      startUnlockActivity();
    }
  }
  
  public String d()
  {
    if ((this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin == null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) && (this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin == null))
    {
      WebViewPlugin localWebViewPlugin = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(OfflinePlugin.class);
      if ((localWebViewPlugin != null) && ((localWebViewPlugin instanceof OfflinePlugin))) {
        this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin = ((OfflinePlugin)localWebViewPlugin);
      }
    }
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin != null) {
      return this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.a();
    }
    return null;
  }
  
  public void d() {}
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQBrowser", 2, "QQBrowserActivity onActivityResult,requestCode=" + paramInt1 + ",resultCode=" + paramInt2);
    }
    if (paramInt1 > 10000)
    {
      int i1 = (paramInt1 - 10000) / 1000;
      byte b1 = (byte)((paramInt1 - 10000) % 1000);
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(i1);
        if (localObject1 != null)
        {
          ((WebViewPlugin)localObject1).onActivityResult(paramIntent, b1, paramInt2);
          super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
          if ((e()) && (paramInt2 == -1))
          {
            setResult(paramInt2, paramIntent);
            finish();
          }
          return;
        }
      }
    }
    Object localObject1 = new HashMap();
    ((Map)localObject1).put("requestCode", Integer.valueOf(paramInt1));
    ((Map)localObject1).put("resultCode", Integer.valueOf(paramInt2));
    ((Map)localObject1).put("data", paramIntent);
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.jdField_M_of_type_JavaLangString, 9, (Map)localObject1)))
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(this.jdField_M_of_type_JavaLangString)) && (this.jdField_M_of_type_JavaLangString.contains("closeSpecialLogic=1")) && (paramIntent != null) && (paramIntent.getBooleanExtra("closeSpecialLogic", false)))
      {
        setResult(-1, paramIntent);
        finish();
      }
      if ((!TextUtils.isEmpty(this.jdField_M_of_type_JavaLangString)) && (this.jdField_M_of_type_JavaLangString.contains("closeSpecialLogic=1")) && (paramIntent != null) && (paramIntent.getBooleanExtra("closeSpecialLogic", false)))
      {
        setResult(-1, paramIntent);
        finish();
      }
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      if (jdField_a_of_type_ComTencentSmttSdkValueCallback != null)
      {
        if ((paramIntent == null) || (paramInt2 != -1)) {}
        for (localObject1 = null;; localObject1 = paramIntent.getData())
        {
          ReflectionUtil.a(BaseApplication.getContext(), jdField_a_of_type_ComTencentSmttSdkValueCallback, (Uri)localObject1);
          jdField_a_of_type_ComTencentSmttSdkValueCallback = null;
          break;
        }
        localObject1 = new Intent(this, ForwardHandlerActivity.class);
        Object localObject2 = paramIntent.getExtras();
        Bundle localBundle = new Bundle((Bundle)localObject2);
        ((Bundle)localObject2).getString("uin");
        ((Bundle)localObject2).getInt("uintype", 0);
        ((Intent)localObject1).putExtras(localBundle);
        startActivity((Intent)localObject1);
        continue;
        QfavBuilder.a(this, paramIntent);
        continue;
        if (paramIntent != null)
        {
          localObject1 = paramIntent.getStringExtra("callbackSn");
          localObject2 = paramIntent.getStringExtra("result");
          this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl("javascript:window.JsBridge&&JsBridge.callback('" + (String)localObject1 + "',{'r':0,'result':" + (String)localObject2 + "});");
          for (;;)
          {
            try
            {
              if (new JSONObject((String)localObject2).getInt("resultCode") != 0) {
                break label640;
              }
              bool = true;
              this.jdField_h_of_type_Boolean = bool;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("QQBrowser", 2, "onActivityResult: mPayActionSucc=" + this.jdField_h_of_type_Boolean);
            }
            catch (Exception localException) {}
            break;
            label640:
            boolean bool = false;
          }
          if (paramInt2 == 0)
          {
            if (jdField_a_of_type_ComTencentSmttSdkValueCallback != null)
            {
              ReflectionUtil.a(BaseApplication.getContext(), jdField_a_of_type_ComTencentSmttSdkValueCallback, null);
              jdField_a_of_type_ComTencentSmttSdkValueCallback = null;
            }
          }
          else if (paramInt2 == 4660)
          {
            setResult(4660);
            finish();
          }
        }
      }
    }
  }
  
  @TargetApi(11)
  public boolean doOnCreate(Bundle paramBundle)
  {
    H += 1;
    StartupTracker.a(null, "Web_qqbrowser_dooncreate");
    StatisticCollector.a(this, 10000L);
    setTheme(2131559066);
    super.doOnCreate(paramBundle);
    if (!QQBrowserActivity.TbsAccelerator.a()) {
      QQBrowserActivity.TbsAccelerator.b();
    }
    e();
    this.jdField_F_of_type_Int = getIntent().getIntExtra("individuation_url_type", -1);
    if (H == 1) {
      G = this.jdField_F_of_type_Int;
    }
    for (;;)
    {
      StartupTracker.a("Web_qqbrowser_dooncreate", null);
      return true;
      this.jdField_F_of_type_Int = G;
    }
  }
  
  public void doOnDestroy()
  {
    int i3 = 1;
    Object localObject1 = Long.valueOf(getIntent().getLongExtra("Gif_msg_uniseq_key", 0L));
    Object localObject2;
    if (((Long)localObject1).longValue() > 0L)
    {
      localObject2 = new Bundle();
      ((Bundle)localObject2).putLong("Gif_msg_uniseq_key", ((Long)localObject1).longValue());
      localObject1 = DataFactory.makeIPCRequestPacket("close_annimate", null, -1, (Bundle)localObject2);
      WebIPCOperator.getInstance().sendServiceIpcReq((Bundle)localObject1);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver != null) {
      WebIPCOperator.getInstance().unRegisterObserver(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver);
    }
    H -= 1;
    super.doOnDestroy();
    if (H == 0)
    {
      WebIPCOperator.getInstance().getClient().doUnbindService(getApplicationContext());
      G = -1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.jdField_M_of_type_JavaLangString, 4, null);
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a();
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine = null;
    }
    if ((this.jdField_a_of_type_JavaLangRunnable != null) && (this.jdField_c_of_type_AndroidOsHandler != null)) {
      this.jdField_c_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare != null) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVasColorRingPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqVasColorRingPlayer.e();
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    this.jdField_k_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null) || (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getParent() != null)) {}
    try
    {
      ((ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getParent()).removeView(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView);
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.stopLoading();
          if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient != null) {
            this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient.a();
          }
          this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.a("about:blank");
          this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.clearView();
          this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.destroy();
          if (this.jdField_a_of_type_ComTencentBizWebviewpluginAd != null) {
            this.jdField_a_of_type_ComTencentBizWebviewpluginAd.c();
          }
          if (this.jdField_l_of_type_Boolean)
          {
            int i4 = (int)((System.nanoTime() - this.jdField_b_of_type_Long) / 1000000L);
            localObject1 = HttpUtil.a() + "";
            localObject2 = this.Y;
            StringBuilder localStringBuilder = new StringBuilder().append("");
            if (!this.x) {
              break;
            }
            i1 = 1;
            if (!this.y) {
              break label665;
            }
            i2 = 1;
            ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "web_stay_in_url", 0, 1, i4, (String)localObject1, (String)localObject2, "", i2 + (i1 << 1));
            if (QLog.isDevelopLevel()) {
              QLog.d("web_report", 4, "web_stay_in_url, cost = " + (System.nanoTime() - this.jdField_b_of_type_Long) / 1000000L + ", url = " + Util.b(this.Y, new String[0]) + ", isFromLeba = " + this.x + ", hasRedDot = " + this.y);
            }
          }
          localObject1 = d();
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            if (TextUtils.isEmpty(HtmlOffline.c((String)localObject1))) {
              break label670;
            }
            i1 = i3;
            ReportController.b(null, "P_CliOper", "", "", "web", "use_local_src", 0, i1, (String)localObject1, "", "", "");
          }
          return;
          localException1 = localException1;
          if (QLog.isColorLevel()) {
            QLog.d("QQBrowser", 2, "remove webview error");
          }
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          int i1;
          int i2;
          if (QLog.isColorLevel())
          {
            QLog.d("QQBrowser", 2, "onDetachedFromWindow exception : " + String.valueOf(localException2));
            continue;
            i1 = 0;
            continue;
            label665:
            i2 = 0;
            continue;
            label670:
            i1 = 0;
          }
        }
      }
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    int i1 = -1;
    super.doOnNewIntent(paramIntent);
    if (paramIntent.getExtras().getBoolean("fromNotification", false)) {}
    int i2;
    do
    {
      return;
      if (!"actionSelectPicture".equals(paramIntent.getStringExtra("keyAction"))) {
        break;
      }
      i2 = paramIntent.getIntExtra("requestCode", -1);
    } while (i2 <= 10000);
    if (paramIntent.hasExtra("PhotoConst.PHOTO_PATHS")) {}
    for (;;)
    {
      int i3 = (i2 - 10000) / 1000;
      byte b1 = (byte)((i2 - 10000) % 1000);
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine == null) {
        break;
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(i3);
      if (localObject == null) {
        break;
      }
      ((WebViewPlugin)localObject).onActivityResult(paramIntent, b1, i1);
      return;
      this.mStopFlag = 0;
      localObject = paramIntent.getDataString();
      if ((localObject != null) && (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl((String)localObject);
        return;
      }
      a(paramIntent);
      p();
      return;
      i1 = 0;
    }
  }
  
  public void doOnPause()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.jdField_M_of_type_JavaLangString, 6, null);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient != null) && (this.r)) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient.onHideCustomView();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.onPause();
    }
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginAd != null) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginAd.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.onPause();
    }
    if ((this.jdField_a_of_type_ComTencentBizWebviewpluginAd != null) && (this.jdField_a_of_type_ComTencentBizWebviewpluginAd.a())) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginAd.b();
    }
    if ((this.p == true) && (this.jdField_a_of_type_AndroidViewWindowManager != null) && (this.jdField_d_of_type_AndroidViewView != null)) {
      this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_d_of_type_AndroidViewView);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVasColorRingPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqVasColorRingPlayer.f();
    }
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.i("GOTOWEB", 2, "onQQBrowserResume() time = " + System.currentTimeMillis());
    }
    StartupTracker.a(null, "Web_qqbrowser_doonresume");
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.onResume();
    }
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginAd != null) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginAd.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.onResume();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVasColorRingPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqVasColorRingPlayer.g();
    }
    Intent localIntent = new Intent("tencent.notify.foreground");
    localIntent.putExtra("selfuin", this.N);
    localIntent.putExtra("AccountInfoSync", "mobileqq.web");
    localIntent.putExtra("classname", getClass().getName());
    sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify2");
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.jdField_M_of_type_JavaLangString, 5, null);
    }
    if (MyAppApi.d()) {
      MyAppApi.a().a(this);
    }
    if (this.p == true) {
      C();
    }
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.requestFocus();
      if (QLog.isColorLevel()) {
        QLog.d("QQBrowser", 2, "doOnResume requestFocus  ");
      }
      StartupTracker.a("Web_qqbrowser_doonresume", null);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQBrowser", 2, "doOnResume requestFocus error ", localException);
        }
      }
    }
  }
  
  protected void doOnUserLeaveHint()
  {
    Intent localIntent = new Intent("tencent.notify.background");
    localIntent.putExtra("selfuin", this.N);
    localIntent.putExtra("AccountInfoSync", "mobileqq.web");
    localIntent.putExtra("classname", getClass().getName());
    sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify2");
    super.doOnUserLeaveHint();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
  }
  
  public String e()
  {
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginAd != null) {
      return this.jdField_a_of_type_ComTencentBizWebviewpluginAd.a();
    }
    return null;
  }
  
  public void e()
  {
    long l2 = System.currentTimeMillis();
    a();
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("QQBrowser", 2, "init variable, cost = " + (l1 - l2));
    }
    b();
    l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("QQBrowser", 2, "init view, cost = " + (l2 - l1));
    }
    k();
    l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("QQBrowser", 2, "init browser, cost = " + (l1 - l2));
    }
    VipWebViewReportLog.a(getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface);
    p();
    l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("QQBrowser", 2, "init param, cost = " + (l2 - l1));
    }
    if (!WebIPCOperator.getInstance().isServiceClientBinded()) {
      WebIPCOperator.getInstance().getClient().doBindService(getApplicationContext());
    }
    w();
  }
  
  public String f()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getUrl())) {
      return this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getUrl();
    }
    return this.jdField_M_of_type_JavaLangString;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginAd != null) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginAd.a();
    }
  }
  
  public void finish()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.jdField_M_of_type_JavaLangString, 7, null);
    }
    super.finish();
    if (this.w) {
      overridePendingTransition(0, 2130968584);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.jdField_M_of_type_JavaLangString, 8, null);
    }
  }
  
  public String g()
  {
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare == null) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a();
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginAd != null) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginAd.f();
    }
  }
  
  public void h()
  {
    if ((this.jdField_d_of_type_AndroidWidgetImageView != null) && (this.jdField_n_of_type_JavaLangString != null) && (this.jdField_n_of_type_JavaLangString.indexOf("bookshelf.html5.qq.com") > 0) && (this.jdField_n_of_type_JavaLangString.indexOf("/detail/") > 0)) {
      onClick(this.jdField_d_of_type_AndroidWidgetImageView);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100) {
      paramMessage = (String)paramMessage.obj;
    }
    for (;;)
    {
      try
      {
        paramMessage = new JSONObject(paramMessage);
        localObject1 = paramMessage.getJSONObject("icon");
        Object localObject2 = paramMessage.getJSONObject("content");
        paramMessage = ((JSONObject)localObject1).getString("timestamp");
        localObject1 = ((JSONObject)localObject1).getString("url");
        String str = ((JSONObject)localObject2).getString("timestamp");
        localObject2 = ((JSONObject)localObject2).getString("memo");
        Object localObject3 = getSharedPreferences("qb_info", 0);
        if (localObject3 != null)
        {
          localObject3 = ((SharedPreferences)localObject3).edit();
          ((SharedPreferences.Editor)localObject3).putString("icon_time", paramMessage);
          ((SharedPreferences.Editor)localObject3).putString("icon_url", (String)localObject1);
          ((SharedPreferences.Editor)localObject3).putString("content_time", str);
          ((SharedPreferences.Editor)localObject3).putString("content_memo", (String)localObject2);
          ((SharedPreferences.Editor)localObject3).commit();
        }
      }
      catch (Exception paramMessage)
      {
        Object localObject1;
        continue;
      }
      return true;
      if (paramMessage.what == 101)
      {
        if ((!isFinishing()) && (!this.jdField_k_of_type_Boolean))
        {
          paramMessage = (Bundle)paramMessage.obj;
          if (paramMessage != null)
          {
            localObject1 = getSharedPreferences("qb_info", 0);
            if (localObject1 != null)
            {
              paramMessage.putString("param_content_memo", ((SharedPreferences)localObject1).getString("content_memo", null));
              paramMessage.putString("param_icon_path", ((SharedPreferences)localObject1).getString("icon_url", null));
            }
            paramMessage.putString("param_user_agent", this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getSettings().getUserAgentString());
            paramMessage.putString("param_refer_url", this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getUrl());
            localObject1 = paramMessage.getString("qb_param_url");
            if ((localObject1 != null) && (((String)localObject1).length() != 0))
            {
              paramMessage.remove("qb_param_url");
              UniformDownload.a(this, (String)localObject1, paramMessage);
            }
          }
        }
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        this.jdField_c_of_type_Boolean = false;
      }
    }
  }
  
  public void i()
  {
    setNewTaskFullScreen(false);
    j();
    h();
  }
  
  protected boolean isSpecialActivity()
  {
    if ((!TextUtils.isEmpty(this.Y)) && (this.Y.indexOf("hongbao") > 0)) {
      return true;
    }
    return super.isSpecialActivity();
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void j()
  {
    if (this.textBeforeRight == null) {
      return;
    }
    if (isNewTaskFullScreen())
    {
      this.textBeforeRight.setBackgroundResource(2130838410);
      return;
    }
    this.textBeforeRight.setBackgroundResource(2130838396);
  }
  
  @SuppressLint({"NewApi"})
  protected void k()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getView().setOnTouchListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine = new WebViewPluginEngine(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView, this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(getIntent().getExtras().getStringArray("insertPluginsArray"));
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setPluginEngine(this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine);
      E();
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setWebViewClient(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebViewClient);
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setWebChromeClient(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient);
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setScrollBarStyle(0);
      if ((BaseApplicationImpl.a().getSharedPreferences("mobileQQ", 4).getBoolean("enableWebviewDebug", false)) && (Build.VERSION.SDK_INT >= 19)) {
        WebView.setWebContentsDebuggingEnabled(true);
      }
      WebSettings localWebSettings = this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getSettings();
      String str2;
      Object localObject1;
      label235:
      String str1;
      label250:
      Object localObject2;
      if (localWebSettings != null)
      {
        if (!this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a("enable_cache_a", Boolean.valueOf(false)).booleanValue()) {
          localWebSettings.setCacheMode(2);
        }
        str2 = a();
        Object localObject3 = localWebSettings.getUserAgentString();
        switch (HttpUtil.a())
        {
        case 0: 
        default: 
          localObject1 = "";
          str1 = "";
          if (WebpSoLoader.b())
          {
            str1 = " WebP/0.3.1";
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            localObject3 = new StringBuilder((String)localObject2).append(" ").append(QZoneHelper.a());
            if (!TextUtils.isEmpty(str2)) {
              break label870;
            }
            localObject2 = "";
            label298:
            localWebSettings.setUserAgentString((String)localObject2 + " " + "QQ/" + b() + "." + "3468" + (String)localObject1 + str1 + " APAD/" + "5.9.3");
            localWebSettings.setSavePassword(false);
            localWebSettings.setSaveFormData(false);
            localWebSettings.setBuiltInZoomControls(true);
            localWebSettings.setUseWideViewPort(true);
            localWebSettings.setLoadWithOverviewMode(true);
            if (this.jdField_B_of_type_Int >= 8)
            {
              localWebSettings.setPluginState(WebSettings.PluginState.ON);
              localObject1 = getPackageManager();
            }
          }
          break;
        }
      }
      try
      {
        if (((PackageManager)localObject1).hasSystemFeature("android.hardware.touchscreen.multitouch")) {
          break label931;
        }
        if (!((PackageManager)localObject1).hasSystemFeature("android.hardware.faketouch.multitouch.distinct")) {
          break label896;
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        for (;;)
        {
          label440:
          boolean bool;
          label480:
          label870:
          continue;
          label709:
          int i1 = 1;
          label896:
          if (i1 == 0) {
            bool = true;
          }
        }
      }
      localWebSettings.setDisplayZoomControls(bool);
      localWebSettings.setPluginsEnabled(true);
      if (Build.VERSION.SDK_INT >= 21) {
        localWebSettings.setMixedContentMode(0);
      }
      if (1 == this.jdField_e_of_type_Int)
      {
        localWebSettings.setCacheMode(2);
        localWebSettings.setJavaScriptEnabled(true);
        localWebSettings.setAllowContentAccess(true);
        localWebSettings.setDatabaseEnabled(true);
        localObject2 = MobileQQ.getMobileQQ().getProcessName();
        str1 = "";
        localObject1 = str1;
        if (localObject2 != null)
        {
          i1 = ((String)localObject2).lastIndexOf(':');
          localObject1 = str1;
          if (i1 > -1) {
            localObject1 = "_" + ((String)localObject2).substring(i1);
          }
        }
        localWebSettings.setDatabasePath(getApplicationContext().getDir("database" + (String)localObject1, 0).getPath());
        localWebSettings.setDomStorageEnabled(true);
        localWebSettings.setAppCacheEnabled(true);
        localWebSettings.setAppCachePath(getApplicationContext().getDir("appcache" + (String)localObject1, 0).getPath());
        localWebSettings.setAllowFileAccessFromFileURLs(false);
        localWebSettings.setAllowUniversalAccessFromFileURLs(false);
        OpenAppClient.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        if (Build.VERSION.SDK_INT >= 11)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.removeJavascriptInterface("searchBoxJavaBridge_");
          this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.removeJavascriptInterface("accessibility");
          this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.removeJavascriptInterface("accessibilityTraversal");
        }
      }
      try
      {
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.requestFocus();
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setFocusableInTouchMode(true);
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setDownloadListener(new erw(this));
        if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getX5WebViewExtension() == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getX5WebViewExtension().setWebViewClientExtension(new erx(this));
        return;
        localObject1 = " NetType/UNKNOWN";
        break label235;
        localObject1 = " NetType/WIFI";
        break label235;
        localObject1 = " NetType/2G";
        break label235;
        localObject1 = " NetType/3G";
        break label235;
        localObject1 = " NetType/4G";
        break label235;
        localObject2 = WebpSoLoader.a();
        if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getX5WebViewExtension() != null)
        {
          str1 = " WebP/0.3.0";
          break label250;
        }
        if (localObject2 == null) {
          break label250;
        }
        str1 = String.format(" WebP/%d.%d.%d", new Object[] { Integer.valueOf(localObject2[0]), Integer.valueOf(localObject2[1]), Integer.valueOf(localObject2[2]) });
        break label250;
        localObject2 = " " + str2;
        break label298;
        i1 = 0;
        break label933;
        bool = false;
        break label440;
        if (4 != this.jdField_e_of_type_Int) {
          break label480;
        }
        localWebSettings.setCacheMode(0);
      }
      catch (Exception localException)
      {
        break label709;
      }
    }
  }
  
  public void l()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void m()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginAd != null) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginAd.d();
    }
  }
  
  public void o()
  {
    long l1 = 0L;
    Object localObject5 = null;
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298923));
    SharedPreferences localSharedPreferences = getSharedPreferences("qb_info", 0);
    boolean bool2 = MttLoader.b(this);
    boolean bool1;
    if (localSharedPreferences != null)
    {
      bool1 = localSharedPreferences.getBoolean("click_icon", false);
      l1 = localSharedPreferences.getLong("update_time", 0L);
    }
    for (;;)
    {
      if ((bool2) || (bool1)) {
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      for (;;)
      {
        return;
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
        long l2 = System.currentTimeMillis();
        if (l2 - l1 > 86400000L)
        {
          Object localObject1 = localSharedPreferences.edit();
          ((SharedPreferences.Editor)localObject1).putLong("update_time", l2);
          ((SharedPreferences.Editor)localObject1).commit();
          try
          {
            localObject1 = QQDeviceInfo.b("ea6862");
            try
            {
              str1 = QQDeviceInfo.a("master");
              localObject4 = localObject1;
              localObject1 = str1;
              if (localSharedPreferences == null) {
                break label378;
              }
              str2 = localSharedPreferences.getString("icon_time", null);
              str1 = localSharedPreferences.getString("content_time", null);
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                Object localObject4;
                Object localObject2;
                Object localObject3;
                continue;
                String str1 = null;
                String str2 = null;
              }
            }
            localObject4 = "imsi=" + (String)localObject4 + "&paK=" + getApplicationContext().getPackageName() + "&imei=" + (String)localObject1 + "&itime=" + str2 + "&ctime=" + str1;
          }
          catch (Exception localException1)
          {
            try
            {
              localObject1 = "24Xdf8j6".getBytes("utf-8");
              if (localObject1 != null)
              {
                try
                {
                  localObject4 = ((String)localObject4).getBytes("utf-8");
                  if (localObject4 == null) {
                    continue;
                  }
                  localObject1 = DesUtils.a((byte[])localObject1, (byte[])localObject4, 1);
                  new Thread(new era(this, "https://mqqad.html5.qq.com/adjs?p=" + URLEncoder.encode(Base64Util.encodeToString((byte[])localObject1, 2)))).start();
                  return;
                }
                catch (Throwable localThrowable)
                {
                  return;
                }
                localException1 = localException1;
                localObject2 = null;
                str1 = null;
                localObject4 = localObject2;
                localObject2 = str1;
              }
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException)
            {
              for (;;)
              {
                localObject3 = localObject5;
              }
            }
          }
        }
      }
      label378:
      bool1 = true;
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_M_of_type_JavaLangString != null)
    {
      if ((this.jdField_M_of_type_JavaLangString.startsWith("https://xiaoqu.qq.com/mobile")) || (this.jdField_M_of_type_JavaLangString.startsWith("https://ptlogin4.qzone.qq.com/check_sig"))) {
        this.jdField_j_of_type_Long = 4L;
      }
      if ((((this.jdField_j_of_type_Long & 0x4) != 0L) && (!this.jdField_j_of_type_Boolean)) || (!d())) {
        break label118;
      }
    }
    label118:
    do
    {
      return true;
      Object localObject = new HashMap(1);
      ((Map)localObject).put("target", Integer.valueOf(3));
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine == null) || (!this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.jdField_M_of_type_JavaLangString, 12, (Map)localObject))) {
        break;
      }
      return true;
      localObject = (InputMethodManager)getSystemService("input_method");
      if ((localObject != null) && (getCurrentFocus() != null)) {
        ((InputMethodManager)localObject).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient != null) && (this.r))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient.onHideCustomView();
        return true;
      }
      if (this.jdField_l_of_type_Boolean) {
        H();
      }
    } while (super.onBackEvent());
    if (!e()) {
      setResult(-1, new Intent());
    }
    finish();
    return true;
  }
  
  protected boolean onBackEvent2()
  {
    return onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null) {}
    for (;;)
    {
      return;
      if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
      {
        paramView = new HashMap(1);
        paramView.put("target", Integer.valueOf(2));
        if ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.jdField_M_of_type_JavaLangString, 12, paramView))) {
          continue;
        }
        d();
        D();
        return;
      }
      if (paramView == this.jdField_b_of_type_AndroidWidgetImageView)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.jdField_M_of_type_JavaLangString, 13, null))) {
          continue;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.stopLoading();
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.goForward();
        D();
        return;
      }
      if (paramView == this.jdField_d_of_type_AndroidWidgetImageView)
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getUrl()))
        {
          this.q = false;
          this.jdField_f_of_type_Long = System.currentTimeMillis();
          this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.reload();
          this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setOnCustomScroolChangeListener(null);
          this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          return;
        }
        paramView = f();
        if (TextUtils.isEmpty(paramView)) {
          continue;
        }
        this.q = false;
        this.jdField_f_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl(paramView);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        return;
      }
      if (paramView == this.jdField_a_of_type_AndroidViewView) {}
      try
      {
        F();
        G();
        label238:
        a(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getUrl(), true, "https://mdc.html5.qq.com/d/directdown.jsp?channel_id=50079");
        return;
        Intent localIntent;
        if ((paramView == this.rightViewImg) || (paramView == this.rightHighLView))
        {
          localIntent = new Intent();
          localIntent.setAction("SignInSbumited");
          sendBroadcast(localIntent);
          if (!TextUtils.isEmpty(this.aa)) {
            this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.a(this.aa, new String[] { "" });
          }
          while (this.jdField_c_of_type_AndroidViewView != null)
          {
            paramView = this.jdField_c_of_type_AndroidViewView.getParent();
            if ((paramView == null) || (!(paramView instanceof ViewGroup))) {
              break;
            }
            ((ViewGroup)paramView).removeView(this.jdField_c_of_type_AndroidViewView);
            return;
            a(paramView);
          }
        }
        if (paramView == this.rightViewText)
        {
          localIntent = new Intent();
          localIntent.setAction("SignInSbumited");
          sendBroadcast(localIntent);
          if (this.jdField_e_of_type_Int == 5)
          {
            paramView = this.rightViewText.getText().toString();
            this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl("javascript:onRightBtn(\"" + paramView + "\")");
          }
          while (this.jdField_c_of_type_AndroidViewView != null)
          {
            paramView = this.jdField_c_of_type_AndroidViewView.getParent();
            if ((paramView == null) || (!(paramView instanceof ViewGroup))) {
              break;
            }
            ((ViewGroup)paramView).removeView(this.jdField_c_of_type_AndroidViewView);
            return;
            if (!TextUtils.isEmpty(this.aa)) {
              this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.a(this.aa, new String[] { "" });
            } else if (this.jdField_f_of_type_Boolean) {
              onBackPressed();
            } else {
              a(paramView);
            }
          }
        }
        if (paramView == this.leftView)
        {
          paramView = new HashMap(1);
          paramView.put("target", Integer.valueOf(1));
          if (((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.jdField_M_of_type_JavaLangString, 12, paramView))) || (this.jdField_e_of_type_Int != 5)) {
            continue;
          }
          if ((this.leftView instanceof EmptyTextView))
          {
            paramView = ((EmptyTextView)this.leftView).a;
            if (paramView == null) {
              break label681;
            }
          }
          label681:
          for (paramView = paramView.toString();; paramView = "")
          {
            if ((!paramView.equals("")) && (!paramView.equals(getIntent().getStringExtra("leftViewText")))) {
              break label687;
            }
            onBackPressed();
            return;
            paramView = this.leftView.getText();
            break;
          }
          label687:
          this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl("javascript:onLeftBtn(\"" + paramView + "\")");
          return;
        }
        if (paramView != this.jdField_c_of_type_AndroidWidgetImageView) {
          continue;
        }
        a(g(), false);
        if (this.jdField_c_of_type_AndroidViewView == null) {
          continue;
        }
        ThreadManager.b(new eqy(this));
        return;
      }
      catch (Throwable paramView)
      {
        break label238;
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.L = this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels;
    this.jdField_M_of_type_Int = this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels;
    if ((this.jdField_a_of_type_ComTencentBizWebviewpluginHole == null) && (this.jdField_e_of_type_AndroidViewView != null))
    {
      paramConfiguration = (FrameLayout.LayoutParams)this.jdField_e_of_type_AndroidViewView.getLayoutParams();
      paramConfiguration.leftMargin = ((int)(this.L - 50.0F * this.jdField_a_of_type_AndroidUtilDisplayMetrics.density));
      paramConfiguration.topMargin = ((int)(this.jdField_M_of_type_Int - 100.0F * this.jdField_a_of_type_AndroidUtilDisplayMetrics.density));
      this.jdField_e_of_type_AndroidViewView.setLayoutParams(paramConfiguration);
      if ((this.jdField_a_of_type_ComTencentBizWebviewpluginAd != null) && (this.jdField_a_of_type_ComTencentBizWebviewpluginAd.a())) {
        this.jdField_a_of_type_ComTencentBizWebviewpluginAd.g();
      }
    }
    if ((this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView != null) && (this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView != null))
    {
      if (this.L >= this.K) {
        break label213;
      }
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(true);
      if (this.L >= this.J) {
        break label224;
      }
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(true);
    }
    for (;;)
    {
      B();
      h();
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a();
      }
      return;
      label213:
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(false);
      break;
      label224:
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(false);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    this.jdField_b_of_type_Long = System.nanoTime();
    this.jdField_e_of_type_Long = System.currentTimeMillis();
    this.jdField_E_of_type_Int = 1;
    this.jdField_h_of_type_Long = this.jdField_e_of_type_Long;
    this.jdField_g_of_type_Long = getIntent().getLongExtra("startOpenPageTime", -1L);
    this.Z = getIntent().getStringExtra("key_service_id");
    boolean bool;
    int i1;
    label275:
    label320:
    int i3;
    label330:
    long l1;
    long l2;
    if ((int)(Math.random() * 10.0D) == 5)
    {
      bool = true;
      this.jdField_l_of_type_Boolean = bool;
      this.jdField_k_of_type_Long = getIntent().getLongExtra("plugin_start_time", 0L);
      this.jdField_l_of_type_Long = getIntent().getLongExtra("click_start_time", 0L);
      if (this.jdField_k_of_type_Long > 0L) {
        getIntent().putExtra("plugin_start_time", 0L);
      }
      if (this.jdField_l_of_type_Long > 0L) {
        getIntent().putExtra("click_start_time", 0L);
      }
      this.jdField_a_of_type_AndroidUtilDisplayMetrics = getResources().getDisplayMetrics();
      super.onCreate(paramBundle);
      this.x = getIntent().getBooleanExtra("is_from_leba", false);
      this.y = getIntent().getBooleanExtra("has_red_dot", false);
      if (QLog.isColorLevel()) {
        QLog.i("GOTOWEB", 2, "onQQBrowserCreate() time = " + this.jdField_b_of_type_Long);
      }
      if (OpenAppClient.jdField_b_of_type_Boolean) {
        this.t = true;
      }
      if (this.jdField_l_of_type_Boolean)
      {
        if (this.jdField_k_of_type_Long <= 0L) {
          break label699;
        }
        i1 = (int)((this.jdField_b_of_type_Long - this.jdField_k_of_type_Long) / 1000000L);
        paramBundle = HttpUtil.a() + "";
        StringBuilder localStringBuilder = new StringBuilder().append("");
        if (!this.x) {
          break label704;
        }
        i2 = 1;
        if (!this.y) {
          break label709;
        }
        i3 = 1;
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "web_before_create", 0, 1, i1, paramBundle, "", "", i3 + (i2 << 1));
        paramBundle = HttpUtil.a() + "";
        l1 = System.currentTimeMillis();
        l2 = this.jdField_l_of_type_Long;
        if (!WebProcessManager.b()) {
          break label715;
        }
        i1 = 1;
        label411:
        if (!this.t) {
          break label720;
        }
      }
    }
    label699:
    label704:
    label709:
    label715:
    label720:
    for (int i2 = 1;; i2 = 0)
    {
      ReportController.b(null, "P_CliOper", "Vip_SummaryCard", "", "0X8004FFD", "0X8004FFD", 0, 1, 0, paramBundle, String.valueOf(l1 - l2), String.valueOf(i1), String.valueOf(i2));
      if (QLog.isDevelopLevel()) {
        QLog.d("web_report", 4, "web_before_create, cost = " + (this.jdField_b_of_type_Long - this.jdField_k_of_type_Long) / 1000000L + ", url = " + Util.b(this.Y, new String[0]) + ", isFromLeba = " + this.x + ", hasRedDot = " + this.y);
      }
      paramBundle = Build.MANUFACTURER + "_" + Build.MODEL;
      if (("Xiaomi_MI 2".equals(paramBundle)) && (this.jdField_B_of_type_Int == 16))
      {
        this.jdField_i_of_type_Boolean = true;
        if (this.jdField_c_of_type_AndroidOsHandler == null) {
          this.jdField_c_of_type_AndroidOsHandler = new Handler();
        }
      }
      if ((this.jdField_B_of_type_Int > 10) && (!"Meizu_M040".equals(paramBundle))) {
        getWindow().addFlags(16777216);
      }
      getWindow().setFormat(-3);
      paramBundle = new StatFs("/data");
      if ((int)(paramBundle.getAvailableBlocks() * paramBundle.getBlockSize() / 1048576L) < 1) {
        QRUtils.a(0, 2131368384);
      }
      return;
      bool = false;
      break;
      i1 = 0;
      break label275;
      i2 = 0;
      break label320;
      i3 = 0;
      break label330;
      i1 = 0;
      break label411;
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    boolean bool;
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder().append("onItemClick, tag = ");
      if (paramAdapterView != null)
      {
        bool = true;
        QLog.d("QQBrowser", 2, bool);
      }
    }
    else
    {
      if (paramAdapterView != null) {
        break label58;
      }
    }
    label58:
    int i1;
    do
    {
      return;
      bool = false;
      break;
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      i1 = ((PublicAccountBrowser.ActionSheetItemViewHolder)paramAdapterView).a.m;
      paramAdapterView = g();
      if (i1 == 1)
      {
        ((ClipboardManager)getSystemService("clipboard")).setText(paramAdapterView);
        QRUtils.a(2, 2131363593);
        return;
      }
      if (i1 == 11)
      {
        paramView = null;
        try
        {
          paramAdapterView = URLEncoder.encode(paramAdapterView, "UTF-8");
          paramView = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
          paramAdapterView = "https://guanjia.qq.com/online_server/m_report.html?url=" + paramAdapterView + "&qq=" + paramView + "&_wv=7";
          paramView = new Intent(this, QQBrowserActivity.class);
          paramView.putExtra("url", paramAdapterView);
          startActivity(paramView);
          ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_67", "jvbao_click", 0, 1, 0, "", "", "", "");
          return;
        }
        catch (UnsupportedEncodingException paramAdapterView)
        {
          for (;;)
          {
            paramAdapterView = paramView;
            if (QLog.isColorLevel())
            {
              QLog.d("QQBrowser", 2, "encode url failed, because UTF-8 is unknown");
              paramAdapterView = paramView;
            }
          }
        }
      }
      if (i1 == 2)
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_m_of_type_JavaLangString)) {
          this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 1, false, getTextTitle());
        }
        for (;;)
        {
          ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_38", "qq_share", 0, 1, 0, "", "", "", "");
          return;
          this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 1, false);
        }
      }
      if (i1 == 4)
      {
        paramAdapterView = new Intent("android.intent.action.VIEW", Uri.parse(paramAdapterView));
        paramAdapterView.putExtra("normal", true);
        try
        {
          startActivity(paramAdapterView);
          ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_48", "browser_share", 0, 1, 0, "", "", "", "");
          return;
        }
        catch (ActivityNotFoundException paramAdapterView)
        {
          for (;;)
          {
            QRUtils.a(1, 2131363613);
          }
        }
      }
      if (i1 == 5)
      {
        a(paramAdapterView, true, "https://mdc.html5.qq.com/d/directdown.jsp?channel_id=10367");
        ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_46", "qqbrowser_share", 0, 1, 0, "", "", "", "");
        return;
      }
      if (i1 == 3)
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_m_of_type_JavaLangString)) {
          this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 2, false, getTextTitle());
        }
        for (;;)
        {
          ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_44", "qzone_share", 0, 1, 0, "", "", "", "");
          return;
          this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 2, false);
        }
      }
      if (i1 == 6)
      {
        a(paramAdapterView, true);
        return;
      }
    } while ((i1 != 9) && (i1 != 10));
    paramInt = -1;
    if (!WXShareHelper.a().a()) {
      paramInt = 2131367829;
    }
    while (paramInt != -1)
    {
      QRUtils.a(0, paramInt);
      return;
      if (!WXShareHelper.a().b()) {
        paramInt = 2131367830;
      }
    }
    if (i1 == 9)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_m_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 3, true, getTextTitle());
      }
      for (;;)
      {
        ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_40", "weixin_share", 0, 1, 0, "", "", "", "");
        return;
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 3, true);
      }
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_m_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 4, true, getTextTitle());
    }
    for (;;)
    {
      ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_42", "pengyouquan_share", 0, 1, 0, "", "", "", "");
      return;
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 4, true);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return super.onKeyDown(paramInt, paramKeyEvent);
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) {
        return this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.jdField_M_of_type_JavaLangString, 23, null);
      }
      finish();
    }
  }
  
  public void onPostThemeChanged()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.jdField_M_of_type_JavaLangString, 17, null);
    }
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (this.jdField_b_of_type_AndroidViewView != null))
    {
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentCommonAppAppInterface)) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() & 0xFF) == 0)
    {
      this.jdField_i_of_type_Long = System.currentTimeMillis();
      if (paramView.getId() == 2131298533)
      {
        paramMotionEvent = paramView.getParent();
        if ((paramMotionEvent != null) && ((paramMotionEvent instanceof ViewGroup))) {
          ((ViewGroup)paramMotionEvent).removeView(paramView);
        }
      }
    }
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentBizWebviewpluginHole != null))
    {
      this.jdField_a_of_type_ComTencentBizWebviewpluginHole.setHole((this.jdField_e_of_type_AndroidViewView.getLeft() + this.jdField_e_of_type_AndroidViewView.getRight()) / 2 - 1, (this.jdField_e_of_type_AndroidViewView.getTop() + this.jdField_e_of_type_AndroidViewView.getBottom()) / 2 - 1, (int)(30.0F * this.jdField_a_of_type_AndroidUtilDisplayMetrics.density));
      this.jdField_a_of_type_ComTencentBizWebviewpluginHole.invalidate();
    }
  }
  
  void p()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null) {
      return;
    }
    this.N = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
    Object localObject;
    if ((this.jdField_j_of_type_Long & 0x10000) != 0L)
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getSettings();
      if (localObject != null) {
        ((WebSettings)localObject).setCacheMode(2);
      }
    }
    c();
    if ((this.jdField_o_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizWebviewpluginAd == null)) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginAd = new Ad(this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare == null) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare = new Share(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this);
    }
    long l1;
    boolean bool7;
    boolean bool8;
    boolean bool9;
    boolean bool10;
    boolean bool6;
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.jdField_M_of_type_JavaLangString, 3, null)) || (Build.VERSION.SDK_INT < 19))
    {
      l1 = System.currentTimeMillis();
      bool7 = false;
      bool8 = false;
      bool9 = false;
      bool10 = false;
      bool6 = false;
      bool2 = bool6;
      bool3 = bool7;
      bool4 = bool8;
      bool5 = bool9;
    }
    for (;;)
    {
      try
      {
        localObject = Class.forName("android.webkit.WebViewCore");
        bool2 = bool6;
        bool3 = bool7;
        bool4 = bool8;
        bool5 = bool9;
        Field localField = ((Class)localObject).getDeclaredField("sWebCoreHandler");
        bool2 = bool6;
        bool3 = bool7;
        bool4 = bool8;
        bool5 = bool9;
        localField.setAccessible(true);
        bool2 = bool6;
        bool3 = bool7;
        bool4 = bool8;
        bool5 = bool9;
        localObject = (Handler)localField.get(localObject);
        bool1 = bool10;
        if (localObject == null) {
          continue;
        }
        bool2 = bool6;
        bool3 = bool7;
        bool4 = bool8;
        bool5 = bool9;
        localObject = ((Handler)localObject).getLooper();
        bool1 = bool10;
        if (localObject == null) {
          continue;
        }
        bool2 = bool6;
        bool3 = bool7;
        bool4 = bool8;
        bool5 = bool9;
        bool1 = bool10;
        if (((Looper)localObject).getThread().getState() != Thread.State.WAITING) {
          continue;
        }
        bool1 = true;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        bool1 = bool2;
        localClassNotFoundException.printStackTrace();
        continue;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        bool1 = bool3;
        localNoSuchFieldException.printStackTrace();
        continue;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        bool1 = bool4;
        localIllegalAccessException.printStackTrace();
        continue;
      }
      catch (ClassCastException localClassCastException)
      {
        boolean bool1 = bool5;
        localClassCastException.printStackTrace();
        continue;
        this.jdField_f_of_type_Long = System.currentTimeMillis();
        if (TextUtils.isEmpty(this.jdField_M_of_type_JavaLangString)) {
          continue;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl(this.jdField_M_of_type_JavaLangString);
        continue;
        if (!bool1) {
          continue;
        }
        int i1 = 0;
        continue;
      }
      bool2 = bool1;
      bool3 = bool1;
      bool4 = bool1;
      bool5 = bool1;
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "webcore_wait", 0, 1, i1, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("QQBrowser", 2, "check if WebViewCordThread is waiting: " + bool1 + ", cost: " + (System.currentTimeMillis() - l1));
      }
      CookieSyncManager.createInstance(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getContext());
      CookieSyncManager.getInstance().sync();
      if (!this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.jdField_M_of_type_JavaLangString, 21, null))
      {
        if (this.jdField_l_of_type_Boolean)
        {
          if (this.jdField_k_of_type_Long > 0L)
          {
            ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "plugin_start_time", 0, 1, (int)((System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L), "", "", "", "");
            this.jdField_k_of_type_Long = 0L;
          }
          localObject = CookieManager.getInstance();
          ((CookieManager)localObject).setAcceptCookie(true);
          ((CookieManager)localObject).setCookie("https://xiaoqu.qq.com/", "reportData = {'time': " + this.jdField_k_of_type_Long + ", 'isFromLeba': " + this.x + ", 'hasRedDot': " + this.y + "}; domain=xiaoqu.qq.com; path=/");
        }
        this.jdField_E_of_type_Int = 2;
        this.jdField_h_of_type_Long = System.currentTimeMillis();
        if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getWidth() != 0) {
          continue;
        }
        l1 = System.currentTimeMillis();
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getViewTreeObserver().addOnGlobalLayoutListener(new erd(this, l1));
      }
      WebProcessManager.a(true);
      return;
      i1 = 1;
    }
  }
  
  public void q()
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
  }
  
  public void r()
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
  }
  
  protected void receiveScreenOff()
  {
    super.receiveScreenOff();
    if ((this.mCanLock) && (!TextUtils.isEmpty(this.N)) && (GesturePWDUtils.getGesturePWDState(this, this.N) == 2) && (GesturePWDUtils.getGesturePWDMode(this, this.N) == 21)) {
      startUnlockActivity();
    }
  }
  
  protected void s() {}
  
  public boolean showPreview()
  {
    long l1 = System.nanoTime();
    this.jdField_g_of_type_Boolean = getIntent().getExtras().getBoolean("isFullScreen", false);
    if (this.jdField_g_of_type_Boolean)
    {
      getWindow().setFlags(1024, 1024);
      setContentViewNoTitle(2130903130);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQBrowser", 2, "init view 1, cost = " + (System.nanoTime() - l1) / 1000000L);
      }
      this.jdField_F_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131296735));
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297357));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new eri(this));
      return true;
      setContentView(2130903130);
    }
  }
  
  public boolean startTitleProgress()
  {
    return super.startTitleProgress();
  }
  
  public boolean stopTitleProgress()
  {
    return super.stopTitleProgress();
  }
  
  protected void t() {}
  
  public void u()
  {
    this.leftView.setTextColor(getResources().getColorStateList(2131427927));
    this.rightViewText.setTextColor(getResources().getColorStateList(2131427927));
    this.centerView.setTextColor(getResources().getColor(2131427931));
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(2);
    this.leftView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.rightViewImg.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  protected void v()
  {
    this.L = this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels;
    this.jdField_M_of_type_Int = this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels;
    ((ViewStub)findViewById(2131297000)).inflate();
    this.jdField_e_of_type_AndroidViewView = findViewById(2131298929);
    this.jdField_g_of_type_AndroidViewView = findViewById(2131298927);
    this.jdField_f_of_type_AndroidViewView = findViewById(2131298930);
    this.jdField_h_of_type_AndroidViewView = findViewById(2131297128);
    this.jdField_i_of_type_AndroidViewView = findViewById(2131298931);
    Object localObject = getSharedPreferences("secondHandSharePre", 0);
    if (localObject != null) {
      if (((SharedPreferences)localObject).contains("first_float_tip"))
      {
        this.jdField_g_of_type_AndroidViewView.setVisibility(8);
        localObject = (FrameLayout.LayoutParams)this.jdField_e_of_type_AndroidViewView.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).leftMargin = ((int)(this.L - 50.0F * this.jdField_a_of_type_AndroidUtilDisplayMetrics.density));
        ((FrameLayout.LayoutParams)localObject).topMargin = ((int)(this.jdField_M_of_type_Int - 100.0F * this.jdField_a_of_type_AndroidUtilDisplayMetrics.density));
        this.jdField_e_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    for (;;)
    {
      this.jdField_e_of_type_AndroidViewView.setOnTouchListener(new erj(this));
      this.jdField_h_of_type_AndroidViewView.setOnClickListener(new erl(this));
      this.jdField_i_of_type_AndroidViewView.setOnClickListener(new erm(this));
      this.jdField_g_of_type_AndroidViewView.setOnTouchListener(new ern(this));
      this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new ero(this));
      return;
      this.jdField_a_of_type_ComTencentBizWebviewpluginHole = ((Hole)findViewById(2131298928));
      ((SharedPreferences)localObject).edit().putBoolean("first_float_tip", true).commit();
      continue;
      this.jdField_g_of_type_AndroidViewView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBrowserActivity
 * JD-Core Version:    0.7.0.1
 */