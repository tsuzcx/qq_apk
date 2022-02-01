package com.tencent.mobileqq.filemanager.fileviewer;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.ForwardHandlerActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.DiscOfflinePreviewController;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.OfflinePreviewController;
import com.tencent.mobileqq.filemanager.core.WeiYunPreviewController;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarManager;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseActionBar.IActionBarClickEvent;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.CanPreviewOfflineFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalApkFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalMusicFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalSimpleFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.OfflineMusicFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.OfflineSimpleFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.OfflineVideoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.OnlineSimpleFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PhotoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileView;
import com.tencent.mobileqq.filemanager.fileviewer.report.FileClickReport;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ixr;
import ixs;
import ixt;
import ixu;
import ixv;
import ixw;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class FileBrowserActivity
  extends IphoneTitleBarActivity
  implements IFileBrowser
{
  static final String jdField_a_of_type_JavaLangString = "FileBrowserActivity";
  protected int a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector = null;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public ActionBarManager a;
  protected BaseActionBar.IActionBarClickEvent a;
  public FileViewBase a;
  private ForwardData jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerForwardData = null;
  IFileViewListener jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener = new ixu(this);
  public IFileViewReport a;
  public List a;
  public boolean a;
  public int b;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  protected int c = 10000;
  
  public FileBrowserActivity()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewReport = null;
  }
  
  public static void a(Object paramObject, String paramString, FileBrowserActivity.TypedObject... paramVarArgs)
  {
    int i = 0;
    if (paramObject == null) {
      return;
    }
    if (paramVarArgs == null) {}
    try
    {
      Class[] arrayOfClass = new Class[0];
      if (paramVarArgs == null) {}
      for (Object[] arrayOfObject = new Object[0];; arrayOfObject = new Object[paramVarArgs.length])
      {
        if (paramVarArgs == null) {
          break label89;
        }
        int j = arrayOfClass.length;
        while (i < j)
        {
          arrayOfClass[i] = paramVarArgs[i].a();
          arrayOfObject[i] = paramVarArgs[i].a();
          i += 1;
        }
        arrayOfClass = new Class[paramVarArgs.length];
        break;
      }
      label89:
      paramString = paramObject.getClass().getDeclaredMethod(paramString, arrayOfClass);
      paramString.setAccessible(true);
      paramString.invoke(paramObject, arrayOfObject);
      return;
    }
    catch (Throwable paramObject) {}
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, IFileViewerAdapter paramIFileViewerAdapter)
  {
    paramQQAppInterface = FMConfig.a(paramQQAppInterface, paramIFileViewerAdapter.a(), "PreviewMode");
    int j = -1;
    int i = j;
    if (paramQQAppInterface != null)
    {
      i = j;
      if (paramQQAppInterface.length() <= 0) {}
    }
    try
    {
      i = Integer.parseInt(paramQQAppInterface);
      return FileManagerUtil.a(i);
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  private FileViewBase e()
  {
    LocalApkFileView localLocalApkFileView = new LocalApkFileView(this);
    localLocalApkFileView.a(a());
    return localLocalApkFileView;
  }
  
  private FileViewBase f()
  {
    LocalSimpleFileView localLocalSimpleFileView = new LocalSimpleFileView(this);
    localLocalSimpleFileView.a(a());
    return localLocalSimpleFileView;
  }
  
  private FileViewBase g()
  {
    boolean bool2 = true;
    LocalMusicFileView localLocalMusicFileView = new LocalMusicFileView(this);
    IFileViewerAdapter localIFileViewerAdapter = a();
    boolean bool1;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      if (this.jdField_b_of_type_Int > 0)
      {
        bool1 = true;
        if (this.jdField_b_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size() - 1) {
          break label80;
        }
      }
    }
    for (;;)
    {
      localIFileViewerAdapter.e(bool1);
      localIFileViewerAdapter.f(bool2);
      localLocalMusicFileView.a(localIFileViewerAdapter);
      return localLocalMusicFileView;
      bool1 = false;
      break;
      label80:
      bool2 = false;
      continue;
      bool2 = false;
      bool1 = false;
    }
  }
  
  private boolean g()
  {
    this.jdField_a_of_type_Int = 2;
    Object localObject = FileViewMusicService.a();
    this.jdField_a_of_type_JavaUtilList = ((FileViewMusicService)localObject).a();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return false;
    }
    this.jdField_b_of_type_Int = ((FileViewMusicService)localObject).a();
    a(a());
    setContentViewNoTitle(2130903780);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener);
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a(a());
    a().addView((View)localObject);
    return true;
  }
  
  private FileViewBase h()
  {
    LocalVideoFileView localLocalVideoFileView = new LocalVideoFileView(this);
    localLocalVideoFileView.a(a());
    return localLocalVideoFileView;
  }
  
  private FileViewBase i()
  {
    OnlineSimpleFileView localOnlineSimpleFileView = new OnlineSimpleFileView(this);
    localOnlineSimpleFileView.a(a());
    return localOnlineSimpleFileView;
  }
  
  private FileViewBase j()
  {
    PreviewingOfflineFileView localPreviewingOfflineFileView = new PreviewingOfflineFileView(this, this.app);
    localPreviewingOfflineFileView.a(a());
    String str = FMConfig.a(this.app, "OnlinePreView", "RotateScreen", "FunctionalSwitch");
    int i;
    if (str != null) {
      i = 0;
    }
    try
    {
      int j = Integer.parseInt(str);
      i = j;
    }
    catch (Exception localException)
    {
      label51:
      break label51;
    }
    if (1 == i) {
      setRequestedOrientation(-1);
    }
    return localPreviewingOfflineFileView;
  }
  
  private void k()
  {
    if (((getIntent().getBooleanExtra("my_file_fullscreen", false)) || (isModeleWindow())) && (!this.bActivityToFragment))
    {
      WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
      localLayoutParams.windowAnimations = getModalWindowOpenAnim();
      getWindow().setAttributes(localLayoutParams);
    }
  }
  
  private void l()
  {
    Object localObject = getSystemService("input_method");
    a(localObject, "windowDismissed", new FileBrowserActivity.TypedObject[] { new FileBrowserActivity.TypedObject(getWindow().getDecorView().getWindowToken(), IBinder.class) });
    a(localObject, "startGettingWindowFocus", new FileBrowserActivity.TypedObject[] { new FileBrowserActivity.TypedObject(null, View.class) });
  }
  
  private void m()
  {
    RelativeLayout localRelativeLayout = a();
    if (localRelativeLayout == null) {
      return;
    }
    a(localRelativeLayout.getParent(), "clearChildFocus", new FileBrowserActivity.TypedObject[] { new FileBrowserActivity.TypedObject(localRelativeLayout, View.class) });
  }
  
  private void n()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297348));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a());
    TextView localTextView = (TextView)findViewById(2131299583);
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a.d() == 1) && ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase instanceof PreviewingOfflineFileView)))
    {
      localTextView.setText(FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a.a().srvTime, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a.a().peerType, false) + " " + getString(2131362398));
      localTextView.setVisibility(0);
      return;
    }
    localTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 19.0F);
  }
  
  private void o()
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.w("FileBrowserActivity", 2, "registerQlinkFinishFMReceiver");
      }
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
      {
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = new ixw(this);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.tencent.qlink.destory.fmactivity");
        this.app.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      }
    }
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      this.app.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public Activity a()
  {
    return this;
  }
  
  public RelativeLayout a()
  {
    return (RelativeLayout)findViewById(2131299581);
  }
  
  public QQAppInterface a()
  {
    return this.app;
  }
  
  protected FileViewBase a()
  {
    OfflineMusicFileView localOfflineMusicFileView = new OfflineMusicFileView(this);
    localOfflineMusicFileView.a(a());
    return localOfflineMusicFileView;
  }
  
  public IFileViewerAdapter a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return (IFileViewerAdapter)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int);
    }
    return null;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  protected void a(IFileViewerAdapter paramIFileViewerAdapter)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = null;
    }
    switch (paramIFileViewerAdapter.d())
    {
    default: 
    case 3: 
    case 4: 
    case 5: 
    case 1: 
    case 2: 
      do
      {
        do
        {
          return;
          if (paramIFileViewerAdapter.g())
          {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = d();
            return;
          }
          if ((!paramIFileViewerAdapter.f()) && (!paramIFileViewerAdapter.e())) {
            break;
          }
          if (a(this.app, paramIFileViewerAdapter))
          {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = d();
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = j();
          if (paramIFileViewerAdapter.f())
          {
            FileManagerReporter.a("0X8004BB2");
            return;
          }
        } while (!paramIFileViewerAdapter.e());
        FileManagerReporter.a("0X8004BB1");
        return;
        if (paramIFileViewerAdapter.d())
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = d();
          return;
        }
        switch (paramIFileViewerAdapter.b())
        {
        case 3: 
        case 4: 
        default: 
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = f();
          return;
        case 5: 
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = e();
          return;
        case 1: 
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = g();
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = h();
        return;
        switch (paramIFileViewerAdapter.b())
        {
        case 3: 
        case 4: 
        default: 
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = f();
          return;
        case 5: 
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = e();
          return;
        case 1: 
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = g();
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = h();
        return;
        if (paramIFileViewerAdapter.g())
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = d();
          return;
        }
        if ((!paramIFileViewerAdapter.f()) && (!paramIFileViewerAdapter.e())) {
          break;
        }
        if (a(this.app, paramIFileViewerAdapter))
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = d();
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = j();
        if (paramIFileViewerAdapter.f())
        {
          FileManagerReporter.a("0X8004BB2");
          return;
        }
      } while (!paramIFileViewerAdapter.e());
      FileManagerReporter.a("0X8004BB1");
      return;
      if (paramIFileViewerAdapter.d())
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = d();
        return;
      }
      switch (paramIFileViewerAdapter.b())
      {
      default: 
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = b();
        return;
      case 1: 
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = a();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = c();
      return;
    case 0: 
      switch (paramIFileViewerAdapter.b())
      {
      default: 
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = i();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = a();
      return;
    }
    switch (paramIFileViewerAdapter.b())
    {
    case 3: 
    case 4: 
    default: 
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = f();
      return;
    case 5: 
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = e();
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = g();
      return;
    }
    if (FileUtil.b(paramIFileViewerAdapter.a().strFilePath))
    {
      if ((paramIFileViewerAdapter.a().status != 1) && (!paramIFileViewerAdapter.c()))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = c();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = h();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = c();
  }
  
  public void a(boolean paramBoolean)
  {
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager.c();
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.b();
        continue;
        if ((paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase == null) || (!PreviewingOfflineFileView.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase)))
        {
          int i = a().d();
          a().e();
          Object localObject = a().e();
          String str = a().f();
          if (((1 == i) || (2 == i) || (FileManagerUtil.a(a()))) && (a().f()) && (a(this.app, a())))
          {
            if (i == 1) {
              if (a().c() == 3000) {
                this.app.a().a(new DiscOfflinePreviewController(this.app, a().e(), a().i()));
              }
            }
            for (;;)
            {
              localObject = new Intent(this, FilePreviewActivity.class);
              ((Intent)localObject).putExtra("offline_file_type", 0);
              ((Intent)localObject).putExtra("offline_file_name", a().a());
              ((Intent)localObject).putExtra("offline_file_size", a().a());
              QLog.i("FileBrowserActivity", 1, "open zip file,open new activity");
              startActivity((Intent)localObject);
              overridePendingTransition(2130968603, 2130968605);
              a().a(false);
              return;
              this.app.a().a(new OfflinePreviewController(this.app, a().e()));
              continue;
              if (i == 2) {
                this.app.a().a(new WeiYunPreviewController(this.app, a().f()));
              } else if (FileManagerUtil.a(a())) {
                if (!TextUtils.isEmpty((CharSequence)localObject)) {
                  this.app.a().a(new OfflinePreviewController(this.app, (String)localObject));
                } else {
                  this.app.a().a(new WeiYunPreviewController(this.app, str));
                }
              }
            }
          }
          a().removeAllViews();
          a(a());
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener);
          localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a(a());
          a().addView((View)localObject);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.c();
          e();
        }
      }
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if ((getIntent().getBooleanExtra("from_qlink", false)) || (getIntent().getBooleanExtra("from_qlink_enter_recent", false))) {
      bool = true;
    }
    return bool;
  }
  
  protected boolean a(Intent paramIntent)
  {
    FileViewerParamParser localFileViewerParamParser = new FileViewerParamParser(this.app);
    if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.trim().length() != 0)) {
      localFileViewerParamParser.a(this.jdField_b_of_type_JavaLangString);
    }
    if (!localFileViewerParamParser.a(paramIntent)) {}
    do
    {
      return false;
      this.jdField_a_of_type_Int = localFileViewerParamParser.a();
      switch (this.jdField_a_of_type_Int)
      {
      }
    } while (!QLog.isDevelopLevel());
    throw new NullPointerException("未知的mFileViewerType");
    this.jdField_a_of_type_JavaUtilList = localFileViewerParamParser.a();
    this.jdField_b_of_type_Int = localFileViewerParamParser.b();
    a(a());
    for (;;)
    {
      setContentViewNoTitle(2130903780);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener);
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a(a());
      a().addView(paramIntent);
      return true;
      this.jdField_a_of_type_JavaUtilList = localFileViewerParamParser.a();
      this.jdField_b_of_type_Int = localFileViewerParamParser.b();
      g();
      continue;
      this.jdField_a_of_type_JavaUtilList = new ArrayList(1);
      this.jdField_a_of_type_JavaUtilList.add(localFileViewerParamParser.a());
      this.jdField_b_of_type_Int = 0;
      a(a());
    }
  }
  
  public int b()
  {
    return this.c;
  }
  
  public RelativeLayout b()
  {
    return (RelativeLayout)findViewById(2131299584);
  }
  
  protected FileViewBase b()
  {
    OfflineSimpleFileView localOfflineSimpleFileView = new OfflineSimpleFileView(this);
    localOfflineSimpleFileView.a(a());
    return localOfflineSimpleFileView;
  }
  
  public void b()
  {
    a(false);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected FileViewBase c()
  {
    OfflineVideoFileView localOfflineVideoFileView = new OfflineVideoFileView(this, this.app);
    localOfflineVideoFileView.a(a());
    return localOfflineVideoFileView;
  }
  
  public void c()
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297362));
    }
    if (a().a().d())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_b_of_type_Int > 0);
  }
  
  protected FileViewBase d()
  {
    CanPreviewOfflineFileView localCanPreviewOfflineFileView = new CanPreviewOfflineFileView(this);
    localCanPreviewOfflineFileView.a(a());
    return localCanPreviewOfflineFileView;
  }
  
  public void d()
  {
    ((TextView)findViewById(2131297357)).setOnClickListener(new ixs(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297348));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a());
    ((TextView)findViewById(2131299583)).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 19.0F);
    if (this.jdField_b_of_type_Boolean)
    {
      c();
      ImageView localImageView = (ImageView)findViewById(2131297361);
      localImageView.setOnClickListener(new ixt(this));
      localImageView.setImageResource(2130839762);
      localImageView.setContentDescription(getString(2131362458));
      localImageView.setVisibility(0);
    }
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_b_of_type_Int < this.jdField_a_of_type_JavaUtilList.size() - 1);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_AndroidViewGestureDetector != null) && (this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent))) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Intent localIntent;
    if (paramInt2 == 4)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerForwardData == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerForwardData = new ForwardData();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerForwardData.a(getIntent());
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerForwardData.a()) && (paramIntent != null) && (paramIntent.getExtras() != null))
      {
        localIntent = new Intent(this, ForwardHandlerActivity.class);
        localIntent.putExtras(new Bundle(paramIntent.getExtras()));
        localIntent.addFlags(268435456);
        localIntent.addFlags(67108864);
        startActivity(localIntent);
      }
      setResult(4, paramIntent);
      finish();
      return;
    }
    if (paramInt2 == -1)
    {
      if ((paramIntent != null) && (paramIntent.getExtras() != null))
      {
        localIntent = new Intent(this, ForwardHandlerActivity.class);
        localIntent.putExtras(new Bundle(paramIntent.getExtras()));
        localIntent.addFlags(67108864);
        startActivity(localIntent);
        return;
      }
      setResult(-1, paramIntent);
      finish();
    }
    if (paramInt2 == 10)
    {
      setResult(paramInt2, paramIntent);
      finish();
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    k();
    ForwardFileInfo localForwardFileInfo = (ForwardFileInfo)paramBundle.getParcelableExtra("fileinfo");
    this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("c2c_discussion_recentfile");
    if (localForwardFileInfo == null)
    {
      finish();
      return false;
    }
    this.c = localForwardFileInfo.b();
    if (10004 == this.c)
    {
      this.jdField_b_of_type_Boolean = true;
      FileManagerReporter.a("0X8004BB3");
      if (10008 != this.c) {
        break label110;
      }
    }
    label110:
    for (boolean bool = g();; bool = a(paramBundle))
    {
      if (bool) {
        break label119;
      }
      finish();
      return false;
      FileManagerReporter.a("0X8004BC8");
      break;
    }
    label119:
    if ((this.app.a().getSharedPreferences(this.app.a(), 0) != null) && (!this.app.a().getSharedPreferences(this.app.a(), 0).getBoolean("filemanager_fresheman_guide", false)) && (this.jdField_b_of_type_Boolean))
    {
      h();
      this.app.a().getSharedPreferences(this.app.a(), 0).edit().putBoolean("filemanager_fresheman_guide", true).commit();
    }
    init(paramBundle);
    if (Build.VERSION.SDK_INT <= 11) {
      removeWebViewLayerType();
    }
    d();
    j();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager = new ActionBarManager(this, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent);
    FileManagerReporter.a("0X8004C01");
    o();
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(null, new ixr(this, getResources().getDisplayMetrics().widthPixels / 6));
    this.jdField_a_of_type_AndroidViewGestureDetector.setIsLongpressEnabled(false);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if ((QLog.isColorLevel()) && (!isFinishing())) {
      QLog.i("FileBrowserActivity", 2, "FileBrowserActivity is called doOnDestroy But not finished!");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager.d();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = null;
    }
    m();
    p();
  }
  
  protected void doOnPause()
  {
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.d();
    }
  }
  
  protected void doOnResume()
  {
    AbstractGifImage.resumeAll();
    ApngImage.resumeAll();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.c();
    }
    c();
  }
  
  public void e()
  {
    n();
    if (a().h())
    {
      FileManagerUtil.a(this, this.jdField_a_of_type_AndroidWidgetTextView);
      return;
    }
    FileManagerUtil.a(this.jdField_a_of_type_AndroidWidgetTextView);
  }
  
  public boolean e()
  {
    return getIntent().getBooleanExtra("FromEditBarPreview", false);
  }
  
  public void f()
  {
    if (this.jdField_b_of_type_Boolean) {
      FileManagerReporter.a("0X8004BC7");
    }
    for (;;)
    {
      localObject = getIntent().getExtras().getString("leftViewText");
      if ((localObject == null) || (!((String)localObject).equals(getString(2131362364)))) {
        break;
      }
      finish();
      overridePendingTransition(2130968593, 2130968594);
      return;
      FileManagerReporter.a("0X8004BDD");
    }
    Object localObject = new Intent(getApplicationContext(), FMActivity.class);
    ((Intent)localObject).putExtra("selectMode", false);
    ((Intent)localObject).putExtra("localSdCardfile", 1408041716);
    ((Intent)localObject).putExtra("tab_tab_type", 0);
    ((Intent)localObject).putExtra("from_qlink", a());
    startActivityForResult((Intent)localObject, 103);
  }
  
  public boolean f()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, getModalWindowFinishAnim());
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = new PhotoFileView(this, this.app, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_Int);
  }
  
  protected void h()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = ((ViewStub)findViewById(2131299585)).inflate();
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new ixv(this));
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView = null;
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  protected void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent == null)
    {
      FileClickReport localFileClickReport = new FileClickReport(this.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent = localFileClickReport;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewReport = localFileClickReport;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity
 * JD-Core Version:    0.7.0.1
 */