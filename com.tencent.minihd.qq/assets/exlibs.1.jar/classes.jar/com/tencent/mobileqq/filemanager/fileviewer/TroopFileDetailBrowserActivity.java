package com.tencent.mobileqq.filemanager.fileviewer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.ForwardHandlerActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarManager;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingTroopFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.TroopPhotoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.report.TroopClickReport;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFilePreviewController;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.QLog;
import jag;

public final class TroopFileDetailBrowserActivity
  extends FileBrowserActivity
  implements IFileBrowser
{
  public static final String b = "bisId";
  public static final String c = "from_webview";
  public static final String d = "sender_uin";
  public static final String e = "last_time";
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new jag(this);
  private ForwardFileInfo jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo;
  
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
      super.a(paramIFileViewerAdapter);
    }
    do
    {
      for (;;)
      {
        return;
        if ((!paramIFileViewerAdapter.g()) && (!FileBrowserActivity.a(this.app, paramIFileViewerAdapter)) && ((paramIFileViewerAdapter.f()) || (paramIFileViewerAdapter.e())) && (this.c == 10006)) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = e();
        }
        while ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent instanceof TroopClickReport))
        {
          ((TroopClickReport)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent).d = "1";
          return;
          super.a(paramIFileViewerAdapter);
        }
      }
      if (paramIFileViewerAdapter.g())
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = super.d();
        return;
      }
      if ((!paramIFileViewerAdapter.f()) && (!paramIFileViewerAdapter.e())) {
        break;
      }
      if (FileBrowserActivity.a(this.app, paramIFileViewerAdapter))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = super.d();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = e();
      if (paramIFileViewerAdapter.f())
      {
        ReportController.b(super.a(), "P_CliOper", "Grp_files", "", "in_mid", "nonpic_Clk_onlinepreview", 0, 0, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a() + "", "", "", "");
        return;
      }
    } while (!paramIFileViewerAdapter.e());
    ReportController.b(super.a(), "P_CliOper", "Grp_files", "", "in_mid", "auto_preview", 0, 0, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a() + "", "", "", "");
    return;
    if (paramIFileViewerAdapter.d())
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = super.d();
      return;
    }
    switch (paramIFileViewerAdapter.b())
    {
    default: 
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = super.b();
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = super.a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = super.c();
  }
  
  protected void a(boolean paramBoolean)
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
        if ((paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase == null) || (!PreviewingTroopFileView.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase)))
        {
          super.a().removeAllViews();
          if ((this.c == 10006) && (super.a().f()) && (FileBrowserActivity.a(this.app, super.a())))
          {
            localObject = TroopFileUtils.a(super.a(), super.a().a());
            this.app.a().a(new TroopFilePreviewController(this.app, super.a().a().TroopUin, (TroopFileStatusInfo)localObject));
            super.a().a(false);
            localObject = new Intent(this, FilePreviewActivity.class);
            ((Intent)localObject).putExtra("offline_file_type", 0);
            ((Intent)localObject).putExtra("offline_file_name", super.a().a());
            ((Intent)localObject).putExtra("offline_file_size", super.a().a());
            super.startActivity((Intent)localObject);
            super.overridePendingTransition(2130968603, 2130968605);
          }
          a(super.a());
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener);
          Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a(super.a());
          super.a().addView((View)localObject);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.c();
          super.e();
        }
      }
    }
  }
  
  protected boolean a(Intent paramIntent)
  {
    if (this.app != null) {
      this.app.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    TroopFileViewerParamParser localTroopFileViewerParamParser = new TroopFileViewerParamParser(this.app);
    if (!localTroopFileViewerParamParser.a(paramIntent, this)) {}
    do
    {
      return false;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo = ((ForwardFileInfo)super.getIntent().getParcelableExtra("fileinfo"));
      this.jdField_a_of_type_Int = localTroopFileViewerParamParser.a();
      switch (this.jdField_a_of_type_Int)
      {
      }
    } while (!QLog.isDevelopLevel());
    throw new NullPointerException("未知的mFileViewerType");
    this.jdField_a_of_type_JavaUtilList = localTroopFileViewerParamParser.a();
    this.b = 0;
    a(super.a());
    super.setContentViewNoTitle(2130903780);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener);
    paramIntent = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a(super.a());
    super.a().addView(paramIntent);
    if (this.jdField_a_of_type_Int == 1) {
      ReportController.b(super.a(), "P_CliOper", "Grp_files", "", "in_mid", "pic_enter", 0, 0, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a() + "", "", "", "");
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_JavaUtilList = localTroopFileViewerParamParser.a();
      this.b = 0;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = new TroopPhotoFileView(this, this.app, super.a(), this.b);
      break;
      this.jdField_a_of_type_JavaUtilList = localTroopFileViewerParamParser.a();
      this.b = 0;
      a(super.a());
      break;
      ReportController.b(super.a(), "P_CliOper", "Grp_files", "", "in_mid", "nonpic_enter", 0, 0, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a() + "", "", "", "");
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.getExtras() != null) && (this.c == 10006))
    {
      Intent localIntent = new Intent(this, ForwardHandlerActivity.class);
      localIntent.putExtras(new Bundle(paramIntent.getExtras()));
      super.startActivity(localIntent);
      return;
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
  }
  
  protected FileViewBase e()
  {
    PreviewingTroopFileView localPreviewingTroopFileView = new PreviewingTroopFileView(this, this.app);
    localPreviewingTroopFileView.a(super.a());
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
      label54:
      break label54;
    }
    if (1 == i) {
      super.setRequestedOrientation(-1);
    }
    return localPreviewingTroopFileView;
  }
  
  protected void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent == null) {
      if (super.a().d() != 3) {
        break label53;
      }
    }
    label53:
    for (boolean bool = true;; bool = false)
    {
      TroopClickReport localTroopClickReport = new TroopClickReport(super.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a(), bool);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent = localTroopClickReport;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewReport = localTroopClickReport;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity
 * JD-Core Version:    0.7.0.1
 */