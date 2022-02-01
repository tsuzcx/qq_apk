package com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarTroopFile;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarUtil;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseActionBar;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileError.TroopFileErrorObserver;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.QLog;
import iwo;
import iwp;
import iwq;
import iwr;
import iws;
import iwt;
import iwu;
import iwv;
import java.util.UUID;

public class ActionBarTroopFile
  extends BaseActionBar
{
  public static final String a = "troopFileActionbar";
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver;
  public FileManagerEntity a;
  public IFileBrowser a;
  private TroopFileError.TroopFileErrorObserver jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver;
  private RelativeLayout b;
  public String b;
  
  public ActionBarTroopFile(View paramView)
  {
    super(paramView);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  private View.OnClickListener a()
  {
    return new iwu(this);
  }
  
  private BizTroopObserver a()
  {
    return new iwp(this);
  }
  
  private View.OnClickListener b()
  {
    return new iwv(this);
  }
  
  private void e()
  {
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void f()
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299483));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299487));
    ((Button)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131299486)).setOnClickListener(new iwo(this));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131299485));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131299484));
  }
  
  private void g()
  {
    boolean bool2 = true;
    super.a(2, "收藏", ActionBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
    String str = "发给好友-免流量";
    if (FileUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath)) {
      str = "发给好友";
    }
    super.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), str, 2130839627, 2130839628, b());
    super.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a());
    b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a());
    super.a(0, true);
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isFromProcessingForward2c2cOrDiscItem())
    {
      bool1 = true;
      super.a(1, bool1);
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isFromProcessingForward2c2cOrDiscItem()) || (!FileManagerUtil.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity))) {
        break label201;
      }
      bool1 = true;
      label151:
      super.a(2, bool1);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isFromProcessingForward2c2cOrDiscItem()) {
        break label206;
      }
    }
    label201:
    label206:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      super.a(3, bool1);
      a(TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label151;
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver = new TroopFileError.TroopFileErrorObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a());
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    TroopFileError.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
  }
  
  private void i()
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin);
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (localTroopFileStatusInfo.jdField_b_of_type_Int == 8)) {
      localTroopFileTransferManager.g(UUID.fromString(this.jdField_b_of_type_JavaLangString));
    }
  }
  
  public void a(TroopFileStatusInfo paramTroopFileStatusInfo)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("troopFileActionbar", 4, String.format("update file info: status:%d fileName:%s errorCode:%d", new Object[] { Integer.valueOf(paramTroopFileStatusInfo.jdField_b_of_type_Int), paramTroopFileStatusInfo.jdField_e_of_type_JavaLangString, Integer.valueOf(paramTroopFileStatusInfo.jdField_c_of_type_Int) }));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isFromProcessingForward2c2cOrDiscItem()) {
      super.a(0, "恢复上传", new iwq(this));
    }
    do
    {
      do
      {
        return;
        switch (paramTroopFileStatusInfo.jdField_b_of_type_Int)
        {
        default: 
          return;
        case 7: 
          super.a(0, "下载原文件", new iwr(this));
          b();
          return;
        case 8: 
          e();
          localObject = new StringBuilder(20);
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().getString(2131362424));
          ((StringBuilder)localObject).append(String.format("(%s/%s)", new Object[] { FileUtil.a(paramTroopFileStatusInfo.jdField_c_of_type_Long), FileUtil.a(paramTroopFileStatusInfo.jdField_b_of_type_Long) }));
          this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        }
      } while (paramTroopFileStatusInfo.jdField_b_of_type_Long <= 0L);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramTroopFileStatusInfo.jdField_c_of_type_Long * 100L / paramTroopFileStatusInfo.jdField_b_of_type_Long));
      return;
      super.a(0, "恢复下载", new iws(this));
      b();
      return;
      long l = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().lastTime;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().selfUin;
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().bSend;
      paramTroopFileStatusInfo = FileManagerUtil.a(paramTroopFileStatusInfo);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().copyFrom(paramTroopFileStatusInfo);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().lastTime = l;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().selfUin = ((String)localObject);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().bSend = bool;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().d() == 3)
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.postDelayed(new iwt(this), 10L);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.w("troopFileActionbar", 2, "file download finished, but file not exist.");
    return;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().finish();
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof IFileBrowser)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser = ((IFileBrowser)paramObject);
    }
    while (!QLog.isDevelopLevel())
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a();
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) {
        break;
      }
      if (!QLog.isDevelopLevel()) {
        return;
      }
      throw new NullPointerException("丫的类型是不是搞错了？！");
    }
    throw new NullPointerException("init类型错误,请检查堆栈");
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strTroopFileID;
    f();
    g();
    h();
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  public void b(Activity paramActivity)
  {
    super.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), "存到微云", 2130839637, 2130839638, a());
    super.b(paramActivity);
  }
  
  public void c()
  {
    i();
  }
  
  public void d()
  {
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (localTroopFileStatusInfo.a != null)) {
      this.jdField_b_of_type_JavaLangString = localTroopFileStatusInfo.a.toString();
    }
    TroopFileItemOperation localTroopFileItemOperation = new TroopFileItemOperation(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a());
    if ((localTroopFileStatusInfo.jdField_b_of_type_Int == 10) || (localTroopFileStatusInfo.jdField_b_of_type_Int == 9)) {
      if (localTroopFileStatusInfo.a != null) {
        localTroopFileItemOperation.b(localTroopFileStatusInfo.a);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      return;
      if (localTroopFileStatusInfo.jdField_b_of_type_Int == 7) {
        localTroopFileItemOperation.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strTroopFilePath, localTroopFileStatusInfo.jdField_e_of_type_JavaLangString, localTroopFileStatusInfo.jdField_b_of_type_Long, localTroopFileStatusInfo.jdField_e_of_type_Int);
      }
    }
  }
  
  protected void e_()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().c(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver != null) {
      TroopFileError.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarTroopFile.ActionBarTroopFile
 * JD-Core Version:    0.7.0.1
 */