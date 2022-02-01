package com.tencent.mobileqq.filemanager.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FilePreViewControllerBase;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.data.FMConstants;
import com.tencent.mobileqq.filemanager.data.FilePreviewDataReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.mobileqq.filemanager.widget.FileWebView.JSInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import ijr;
import ijs;
import ijt;
import iju;
import ijx;
import ijz;
import ika;
import ikb;
import ikg;
import ikj;
import ikk;
import ikl;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SuppressLint({"NewApi"})
public class FilePreviewActivity
  extends BaseFileViewerActivity
{
  public int a;
  public long a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = null;
  public ViewGroup a;
  public ImageView a;
  public LinearLayout a;
  public ProgressBar a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  FilePreviewActivity.ControlerCallback jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$ControlerCallback = null;
  FilePreViewControllerBase jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase = null;
  public FilePreviewDataReporter a;
  public FilePreviewAnimQueue a;
  public FileWebView.JSInterface a;
  public FileWebView a;
  final String jdField_a_of_type_JavaLangString = "<FileAssistant>FilePreviewActivity";
  public boolean a;
  public int b;
  long b;
  public LinearLayout b;
  public TextView b;
  public FilePreviewAnimQueue b;
  public String b;
  public boolean b;
  int c;
  public long c;
  public TextView c;
  public FilePreviewAnimQueue c;
  public String c;
  public boolean c;
  public String d;
  public boolean d;
  String e;
  public boolean e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  String k = null;
  
  public FilePreviewActivity()
  {
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetProgressBar = null;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$JSInterface = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue = null;
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue = null;
  }
  
  private boolean a(Intent paramIntent)
  {
    this.jdField_a_of_type_Int = paramIntent.getIntExtra("offline_file_type", -1);
    if (this.jdField_a_of_type_Int == -1) {
      return false;
    }
    this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("offline_file_name");
    if (this.jdField_a_of_type_Int == 1) {
      this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("OfflinePreZipPath");
    }
    this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("offline_file_name");
    String str1 = FMConfig.a(this.app, this.jdField_c_of_type_JavaLangString, "FileType");
    this.j = FMConfig.a(this.app, this.jdField_c_of_type_JavaLangString, "InterfacePage");
    String str2 = FMConfig.a(this.app, this.jdField_c_of_type_JavaLangString, "PreviewMode");
    this.h = paramIntent.getStringExtra("offline_file_domain");
    this.i = paramIntent.getStringExtra("offline_file_port");
    this.f = paramIntent.getStringExtra("offline_file_domain_key");
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("offline_file_type_key", -1);
    if ((str1 != null) && (str1.length() > 0)) {
      this.jdField_b_of_type_Int = Integer.parseInt(str1);
    }
    if ((str2 != null) && (str2.length() > 0)) {
      this.jdField_c_of_type_Int = Integer.parseInt(str2);
    }
    if (this.jdField_a_of_type_Int != 0)
    {
      this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("offline_file_bZip", false);
      if (!a()) {
        break label274;
      }
      setContentViewForImage(2130903773);
    }
    for (;;)
    {
      a();
      if (this.jdField_a_of_type_Int != 0) {
        break label358;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase = this.app.a().a();
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase != null) {
        break label283;
      }
      QLog.e("<FileAssistant>FilePreviewActivity", 1, "controller is null, should finish it!");
      finish();
      return false;
      this.jdField_a_of_type_Boolean = FileManagerUtil.a(this.jdField_c_of_type_Int);
      break;
      label274:
      setContentView(2130903773);
    }
    label283:
    this.k = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase.a());
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$ControlerCallback == null) {
      h();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$ControlerCallback);
    this.leftView.setVisibility(8);
    this.jdField_a_of_type_Long = paramIntent.getLongExtra("offline_file_size", 0L);
    startTitleProgress();
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_e_of_type_Boolean = true;
    }
    for (;;)
    {
      return true;
      label358:
      this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("offline_file_url");
      this.leftView.setVisibility(0);
      this.leftView.setText(2131365114);
      if (this.jdField_b_of_type_JavaLangString != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.loadUrl(this.jdField_b_of_type_JavaLangString);
      }
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "mWebView.loadUrl(" + this.jdField_b_of_type_JavaLangString + ")");
      break;
      paramIntent = FMConfig.a(this.app, "OnlinePreView", "RotateScreen", "FunctionalSwitch");
      if (paramIntent == null) {
        return true;
      }
      if (Integer.parseInt(paramIntent) == 0) {
        return true;
      }
      setRequestedOrientation(-1);
    }
  }
  
  private boolean b()
  {
    QLog.i("<FileAssistant>FilePreviewActivity", 1, "call controller.sendCS()");
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter = new FilePreviewDataReporter(this.app.a());
    FilePreviewDataReporter localFilePreviewDataReporter1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter;
    FilePreviewDataReporter localFilePreviewDataReporter2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter;
    long l = System.currentTimeMillis();
    localFilePreviewDataReporter2.jdField_a_of_type_Long = l;
    localFilePreviewDataReporter1.jdField_e_of_type_Long = l;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.k = String.valueOf(this.k);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.l = "1";
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.h = this.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.j = FileUtil.a(this.jdField_c_of_type_JavaLangString).replace(".", "").toLowerCase();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase.a();
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ijx(this);
  }
  
  private void h()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$ControlerCallback = new ijz(this);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131299552));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView = new FileWebView(getApplicationContext());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView);
    Object localObject = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int m = ((DisplayMetrics)localObject).widthPixels;
    int n = ((DisplayMetrics)localObject).heightPixels;
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = n;
    ((RelativeLayout.LayoutParams)localObject).width = m;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    removeWebViewLayerType();
    f();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setWebViewClient(new ika(this));
    localObject = new Handler();
    if (a()) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setOnCustomScroolChangeListener(new ikb(this, (Handler)localObject));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setWebChromeClient(new WebChromeClient());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setScrollBarStyle(0);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.requestFocus();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setFocusableInTouchMode(false);
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.getSettings();
      ((WebSettings)localObject).setJavaScriptEnabled(true);
      ((WebSettings)localObject).setCacheMode(-1);
      if (this.jdField_a_of_type_Boolean) {
        ((WebSettings)localObject).setCacheMode(2);
      }
      if (Build.VERSION.SDK_INT >= 21) {
        ((WebSettings)localObject).setMixedContentMode(0);
      }
      ((WebSettings)localObject).setBuiltInZoomControls(true);
      ((WebSettings)localObject).setSupportZoom(true);
      ((WebSettings)localObject).setUseWideViewPort(true);
      ((WebSettings)localObject).setLoadWithOverviewMode(true);
      if (Build.VERSION.SDK_INT < 16)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView;
        FileWebView.enablePlatformNotifications();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setOnCustomScroolChangeListener(new ikg(this));
    }
  }
  
  public void a(int paramInt)
  {
    runOnUiThread(new ijt(this, paramInt));
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.f = System.currentTimeMillis();
    }
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setListenSroll();
    }
    stopTitleProgress();
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_c_of_type_Long = (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.f - this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_e_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.i = "";
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.d = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_a_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.a();
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setVisibility(0);
        QLog.i("<FileAssistant>FilePreviewActivity", 1, "js call loadFnish suc[" + paramBoolean + "] retCode[" + paramLong + "]");
        paramLong = System.currentTimeMillis();
        long l = this.jdField_b_of_type_Long;
        paramString = new FileManagerReporter.fileAssistantReportData();
        paramString.jdField_b_of_type_JavaLangString = "file_preview_time_first";
        paramString.jdField_b_of_type_Long = (paramLong - l);
        paramString.jdField_a_of_type_Boolean = paramBoolean;
        paramString.jdField_c_of_type_JavaLangString = FileUtil.a(this.jdField_c_of_type_JavaLangString);
        paramString.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
        FileManagerReporter.a(this.app.a(), paramString);
        return;
      }
      catch (NullPointerException paramString)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setOverrideOnCheckIsTextEditor(false);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setVisibility(0);
        continue;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_c_of_type_Long = (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.f - this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_e_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_e_of_type_JavaLangString = String.valueOf(paramLong);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.i = paramString;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.d = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_a_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.a();
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      String str;
      if (paramString != null)
      {
        str = paramString;
        if (paramString.length() != 0) {}
      }
      else
      {
        str = getString(2131362407);
      }
      paramString = str + getString(2131362408);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setVisibility(4);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_c_of_type_Int != FMConstants.df) && (!FileManagerUtil.a(this.jdField_c_of_type_Int)) && (!this.jdField_a_of_type_Boolean);
  }
  
  public void b()
  {
    runOnUiThread(new ikj(this));
  }
  
  public void b(boolean paramBoolean, long paramLong, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.a();
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setListenSroll();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.f = System.currentTimeMillis();
    }
    stopTitleProgress();
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_c_of_type_Long = (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.f - this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_e_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.i = "";
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.d = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_a_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.a();
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
      a(1000);
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setVisibility(0);
        QLog.i("<FileAssistant>FilePreviewActivity", 1, "js call reportGetmoreTimeV2[" + paramBoolean + "],retCode[" + paramLong + "]");
        stopTitleProgress();
        setTitle(this.jdField_c_of_type_JavaLangString);
        paramLong = System.currentTimeMillis();
        long l = this.jdField_b_of_type_Long;
        paramString = new FileManagerReporter.fileAssistantReportData();
        paramString.jdField_b_of_type_JavaLangString = "file_preview_time_more";
        paramString.jdField_b_of_type_Long = (paramLong - l);
        paramString.jdField_a_of_type_Boolean = paramBoolean;
        paramString.jdField_c_of_type_JavaLangString = FileUtil.a(this.jdField_c_of_type_JavaLangString);
        paramString.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
        FileManagerReporter.a(this.app.a(), paramString);
        return;
      }
      catch (NullPointerException paramString)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setOverrideOnCheckIsTextEditor(false);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setVisibility(0);
        continue;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_c_of_type_Long = (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.f - this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_e_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_e_of_type_JavaLangString = String.valueOf(paramLong);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.i = paramString;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.d = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_a_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.a();
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131367610);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      a(5000);
    }
  }
  
  public void c()
  {
    runOnUiThread(new ikk(this));
  }
  
  public void d()
  {
    runOnUiThread(new ikl(this));
  }
  
  protected boolean dataEquals(Intent paramIntent)
  {
    Intent localIntent = getIntent();
    Iterator localIterator = localIntent.getExtras().keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!localIntent.getExtras().get(str).equals(paramIntent.getExtras().get(str))) {
        return false;
      }
    }
    return true;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      setResult(0, paramIntent);
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    if (!a(paramBundle))
    {
      finish();
      return false;
    }
    setRightButton(2131367454, new ijr(this));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131297347));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131299556));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299559));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299554));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299555));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131299557));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299558));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131299553));
    setTitle(this.jdField_c_of_type_JavaLangString);
    if (this.jdField_a_of_type_Int == 0) {
      b();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setVisibility(4);
      g();
      return true;
      this.jdField_e_of_type_JavaLangString = paramBundle.getStringExtra("OfflinePreZipDirName");
      setTitle(this.jdField_e_of_type_JavaLangString);
    }
  }
  
  public void e()
  {
    runOnUiThread(new ijs(this));
  }
  
  void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$JSInterface != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$JSInterface = new iju(this);
  }
  
  public void finish()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase.b();
    }
    if (this.jdField_c_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue != null) {
      this.jdField_c_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue.b();
    }
    if (this.jdField_b_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue != null) {
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue.b();
    }
    FileManagerReporter.fileAssistantReportData localfileAssistantReportData = new FileManagerReporter.fileAssistantReportData();
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.jdField_b_of_type_Long;
    localfileAssistantReportData.jdField_b_of_type_JavaLangString = "file_preview_time_stay";
    localfileAssistantReportData.jdField_b_of_type_Long = l2;
    localfileAssistantReportData.jdField_a_of_type_Boolean = true;
    localfileAssistantReportData.jdField_c_of_type_JavaLangString = FileUtil.a(this.jdField_c_of_type_JavaLangString);
    localfileAssistantReportData.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    FileManagerReporter.a(this.app.a(), localfileAssistantReportData);
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter != null) && ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.f < this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_e_of_type_Long)))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.d = l2;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.f = l1;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_c_of_type_Long = (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.f - this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_e_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_e_of_type_JavaLangString = String.valueOf(9037);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.i = ("LoadInterface[" + this.jdField_d_of_type_Boolean + "]");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter = null;
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setOnCustomScroolChangeListener(null);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.clearCache(false);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.destroy();
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      }
      super.finish();
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        localNullPointerException.printStackTrace();
      }
    }
  }
  
  public String getInitString(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("domain", paramString1);
    localHashMap.put("fileType", Integer.valueOf(paramInt1));
    localHashMap.put("port", Integer.valueOf(paramInt2));
    localHashMap.put("downloadkey", paramString2);
    if (!TextUtils.isEmpty(paramString3)) {
      localHashMap.put("cookie", paramString3);
    }
    paramString1 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString1 = "";
    }
    localHashMap.put("path", paramString1);
    paramString1 = "javascript:qpreview.onClientResponse('init'," + FileManagerUtil.a(localHashMap) + ")";
    if (QLog.isColorLevel()) {
      QLog.i("<FileAssistant>FilePreviewActivity", 2, "getInitString:" + paramString1);
    }
    return paramString1;
  }
  
  protected boolean isWrapContent()
  {
    return true;
  }
  
  protected boolean onBackEvent()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.canGoBack())
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.goBack();
      return true;
    }
    return super.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity
 * JD-Core Version:    0.7.0.1
 */