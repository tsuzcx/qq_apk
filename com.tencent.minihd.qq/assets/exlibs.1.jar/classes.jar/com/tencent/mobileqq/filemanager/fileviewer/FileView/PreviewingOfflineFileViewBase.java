package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FilePreviewDataReporter;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewBase;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.TipsClickedInterface;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.mobileqq.filemanager.widget.FileWebView.JSInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import izf;
import izg;
import izh;
import izi;
import izk;
import izm;
import izp;
import izr;
import izt;
import izu;
import izv;
import izw;
import java.util.Timer;
import mqq.app.AppRuntime;

public abstract class PreviewingOfflineFileViewBase
  extends FileViewBase
{
  private static final String jdField_a_of_type_JavaLangString = "PreviewingOfflineFileViewBase<FileAssistant>";
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FilePreviewDataReporter jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter;
  private FileManagerUtil.TipsClickedInterface jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$TipsClickedInterface = new izf(this);
  private FilePreviewAnimQueue jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue;
  public FileWebView.JSInterface a;
  private FileWebView jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private boolean jdField_a_of_type_Boolean = false;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private FilePreviewAnimQueue jdField_b_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue;
  private Timer jdField_b_of_type_JavaUtilTimer;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private boolean g = false;
  
  public PreviewingOfflineFileViewBase(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$JSInterface = null;
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new izw(this, paramInt));
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
      return;
    }
    int i = 0;
    if (!paramBoolean) {
      i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener.a();
    }
    QLog.i("PreviewingOfflineFileViewBase<FileAssistant>", 1, "updateGetMoreMargin[" + paramBoolean + "],height[" + i + "]");
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, 72);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.bottomMargin = (i + 20);
    localLayoutParams.addRule(12);
    localLayoutParams.addRule(14);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
  }
  
  private void a(boolean paramBoolean, long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_a_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_f_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_c_of_type_Long = (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_f_of_type_Long - this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_e_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_e_of_type_JavaLangString = String.valueOf(paramLong);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.i = paramString;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.e();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_d_of_type_Long = (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_f_of_type_Long - this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.a();
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("PreviewingOfflineFileViewBase<FileAssistant>", 4, "initVarView: but adapter is null");
      }
      return;
    }
    ((AsyncImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299573)).setImageResource(FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()));
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299503)).setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a());
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299574)).setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.c());
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299596));
    Object localObject1 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299575);
    if ((FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a())) && (1 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().cloudType))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      ((TextView)localObject1).setVisibility(0);
      return;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if ((localObject2 != null) && (((FileManagerEntity)localObject2).isFromProcessingForward2c2cOrDiscItem()))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      ((TextView)localObject1).setVisibility(0);
      ((TextView)localObject1).setText(BaseApplicationImpl.getContext().getString(2131362554));
      return;
    }
    ((TextView)localObject1).setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    i();
    localObject1 = FileManagerUtil.a(BaseApplicationImpl.getContext().getString(2131362462), BaseApplicationImpl.getContext().getString(2131362463), this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$TipsClickedInterface);
    localObject2 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299597);
    ((TextView)localObject2).setText((CharSequence)localObject1);
    ((TextView)localObject2).setMovementMethod(LinkMovementMethod.getInstance());
    ((TextView)localObject2).setHighlightColor(17170445);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299559));
    n();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.c(true);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener.d(true);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299552));
    j();
  }
  
  private void i()
  {
    String str = BaseApplicationImpl.getContext().getString(2131362461) + "(" + this.jdField_a_of_type_Int + "%)";
    this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
  }
  
  private void j()
  {
    a().c();
    a().a();
    k();
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter = new FilePreviewDataReporter(BaseApplicationImpl.a().a().getAccount());
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_e_of_type_Long = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.k = String.valueOf(a().a());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.l = "1";
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.h = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.j = FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()).replace(".", "").toLowerCase();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setWebViewClient(new izk(this));
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setOnCustomScroolChangeListener(new izm(this));
  }
  
  private void n()
  {
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimer.scheduleAtFixedRate(new izp(this), 0L, 100L);
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
  }
  
  private void p()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PreviewingOfflineFileViewBase<FileAssistant>", 4, "startTimeoutTimer");
    }
    if (this.jdField_b_of_type_JavaUtilTimer != null) {
      return;
    }
    this.jdField_b_of_type_JavaUtilTimer = new Timer();
    this.jdField_b_of_type_JavaUtilTimer.schedule(new izr(this), 30000L);
  }
  
  private void q()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PreviewingOfflineFileViewBase<FileAssistant>", 4, "stopTimeoutTimer");
    }
    if (this.jdField_b_of_type_JavaUtilTimer != null)
    {
      this.jdField_b_of_type_JavaUtilTimer.cancel();
      this.jdField_b_of_type_JavaUtilTimer = null;
    }
  }
  
  private void r()
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new izt(this));
  }
  
  private void s()
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new izu(this));
  }
  
  private void t()
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new izv(this));
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2130903786, paramViewGroup, false);
    h();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public abstract PreviewingOfflineFileViewBase.IControllProxyInterface a();
  
  public String a()
  {
    if (this.jdField_b_of_type_Boolean) {
      return super.a();
    }
    return BaseApplicationImpl.getContext().getString(2131362410);
  }
  
  public void a()
  {
    this.f = true;
    o();
    q();
    a().b();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setOnCustomScroolChangeListener(null);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.clearCache(false);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.removeAllViews();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.destroy();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView = null;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    FileManagerReporter.fileAssistantReportData localfileAssistantReportData = new FileManagerReporter.fileAssistantReportData();
    localfileAssistantReportData.jdField_b_of_type_JavaLangString = "file_preview_time_stay";
    localfileAssistantReportData.jdField_b_of_type_Long = (l1 - l2);
    localfileAssistantReportData.jdField_a_of_type_Boolean = true;
    localfileAssistantReportData.jdField_c_of_type_JavaLangString = FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a());
    localfileAssistantReportData.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    FileManagerReporter.a(BaseApplicationImpl.a().a().getAccount(), localfileAssistantReportData);
    if ((!this.d) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_f_of_type_Long < this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_e_of_type_Long)) {
      a(false, 9037L, "OnBack Finished[" + this.e + "]");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter = null;
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_f_of_type_Long = System.currentTimeMillis();
    }
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new izg(this, paramBoolean, paramLong, paramString1, paramString2));
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView != null) && (this.jdField_b_of_type_Boolean)) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.a();
    }
    return true;
  }
  
  public void b()
  {
    h();
  }
  
  public void b(long paramLong, String paramString1, String paramString2)
  {
    if (this.f) {
      return;
    }
    this.d = true;
    a().b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.c(false);
    o();
    q();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener.b();
    }
    String str;
    if (paramString2 != null)
    {
      str = paramString2;
      if (paramString2.length() >= 1) {}
    }
    else
    {
      str = this.jdField_a_of_type_AndroidAppActivity.getString(2131367610);
    }
    FMToastUtil.a(str);
    a(false, paramLong, paramString1);
  }
  
  public void b(boolean paramBoolean, long paramLong, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_f_of_type_Long = System.currentTimeMillis();
    }
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new izh(this, paramBoolean, paramLong, paramString1));
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.onResume();
    }
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.onPause();
    }
  }
  
  public void e()
  {
    if (this.f) {
      return;
    }
    this.d = true;
    a().b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.g = a().b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_c_of_type_JavaLangString = a().a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_f_of_type_JavaLangString = a().c();
    a(true, 0L, "");
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView != null)
    {
      QLog.w("PreviewingOfflineFileViewBase<FileAssistant>", 1, "onPreviewSuccess : but mWebView is nut null");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_e_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.l = "2";
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView = new FileWebView(this.jdField_a_of_type_AndroidAppActivity);
    g();
    l();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setWebChromeClient(new WebChromeClient());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setScrollBarStyle(0);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.requestFocus();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setFocusableInTouchMode(false);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.getSettings();
    ((WebSettings)localObject).setJavaScriptEnabled(true);
    ((WebSettings)localObject).setBuiltInZoomControls(true);
    ((WebSettings)localObject).setUseWideViewPort(true);
    ((WebSettings)localObject).setLoadWithOverviewMode(true);
    if (Build.VERSION.SDK_INT >= 21) {
      ((WebSettings)localObject).setMixedContentMode(0);
    }
    if (Build.VERSION.SDK_INT < 16)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView;
      FileWebView.enablePlatformNotifications();
    }
    m();
    localObject = a().c();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.loadUrl((String)localObject);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView, 0, localLayoutParams);
    if (QLog.isDevelopLevel()) {
      QLog.i("PreviewStep_2", 4, "openUrl[" + (String)localObject + "]");
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$JSInterface != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$JSInterface = new izi(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileViewBase
 * JD-Core Version:    0.7.0.1
 */