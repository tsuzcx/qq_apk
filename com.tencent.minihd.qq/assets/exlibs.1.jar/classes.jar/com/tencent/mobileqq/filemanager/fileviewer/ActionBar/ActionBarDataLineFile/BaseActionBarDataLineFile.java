package com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dataline.util.DataLineReportUtil;
import com.tencent.device.file.DeviceFileObserver;
import com.tencent.device.msg.data.DevSingleStructMsgProcessor;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarUtil;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseQfileActionBar;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqdataline.MpFileConstant;
import cooperation.qqdataline.ipc.DatalineRemoteManager;
import ivt;
import ivw;
import ivx;
import ivy;
import ivz;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

public abstract class BaseActionBarDataLineFile
  extends BaseQfileActionBar
{
  private static final String jdField_b_of_type_JavaLangString = BaseActionBarDataLineFile.class.getSimpleName();
  private long jdField_a_of_type_Long = 0L;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  private DeviceFileObserver jdField_a_of_type_ComTencentDeviceFileDeviceFileObserver = null;
  private DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = null;
  protected String a;
  private boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long = 0L;
  private boolean jdField_b_of_type_Boolean = false;
  private long c = 0L;
  
  public BaseActionBarDataLineFile(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  private View.OnClickListener a()
  {
    return new ivy(this);
  }
  
  private boolean a()
  {
    if (NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().getApplication().getApplicationContext()) == 1) {
      return true;
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().getPreferences().getBoolean("auto_receive_files", false);
  }
  
  private void g()
  {
    a(1, false);
    a(2, false);
    a(3, false);
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) && (!FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath)))
    {
      a(0, false);
      a(1, false);
      a(2, false);
      a(3, false);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType == 8)) {
        a(2, false);
      }
      return;
      a(0, true);
      a(1, true);
      a(3, true);
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new ivw(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.dataline.mpfile.download_progress");
      localIntentFilter.addAction("com.dataline.mpfile.download_completed");
      localIntentFilter.addAction(MpFileConstant.d);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new ivx(this);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().c(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = null;
  }
  
  private void m()
  {
    long l = ((float)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize * this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType != 8) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType != 1)) {}
    for (localObject = ((Activity)localObject).getString(2131362423) + "(" + FileUtil.a(l) + "/" + FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize) + ")";; localObject = ((Activity)localObject).getString(2131362424) + "(" + FileUtil.a(l) + "/" + FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize) + ")")
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      return;
    }
  }
  
  private void n()
  {
    this.jdField_b_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    this.jdField_a_of_type_Boolean = true;
    long l = ((DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(8)).a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerDin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strDataLineMPFileID, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
    if (l == -1L)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "doDownload , plugin service not started");
      }
      FMToastUtil.a(2131362115);
      e();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq = l;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
  }
  
  private void o()
  {
    DataLineHandler localDataLineHandler;
    DataLineMsgRecord localDataLineMsgRecord;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerDin == 0L)
    {
      localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(8);
      localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a().b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
      if (localDataLineMsgRecord != null) {}
    }
    else
    {
      return;
    }
    if (localDataLineMsgRecord.strMoloKey != null)
    {
      localDataLineHandler.b(111);
      if (localDataLineMsgRecord.fileMsgStatus == 1L)
      {
        if (!DataLineMsgSet.isSingle(localDataLineMsgRecord)) {
          break label168;
        }
        DataLineReportUtil.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a());
      }
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(localDataLineMsgRecord.sessionid));
      if (!localDataLineHandler.a(localArrayList)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      localDataLineMsgRecord.fileMsgStatus = 0L;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a().c(localDataLineMsgRecord.msgId);
      return;
      label168:
      DataLineReportUtil.e(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a());
    }
    FMToastUtil.a(2131362115);
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerDin == 0L)
    {
      ((DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(8)).a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a().b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq), true);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      return;
    }
    RouterHandler localRouterHandler = (RouterHandler)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(50);
    ArrayList localArrayList = new ArrayList();
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.path = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath;
    localDataLineMsgRecord.msgtype = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0) {
      localDataLineMsgRecord.msgtype = 1;
    }
    for (;;)
    {
      localDataLineMsgRecord.sessionid = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq;
      localDataLineMsgRecord.groupId = 0;
      localDataLineMsgRecord.groupSize = 0;
      localDataLineMsgRecord.groupIndex = 0;
      localArrayList.add(localDataLineMsgRecord);
      localRouterHandler.a(localArrayList, true, null, null, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerDin);
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 2) {
        localDataLineMsgRecord.msgtype = 2;
      }
    }
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_ComTencentDeviceFileDeviceFileObserver == null)
    {
      this.jdField_a_of_type_ComTencentDeviceFileDeviceFileObserver = new ivz(this);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(this.jdField_a_of_type_ComTencentDeviceFileDeviceFileObserver);
    }
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_ComTencentDeviceFileDeviceFileObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().c(this.jdField_a_of_type_ComTencentDeviceFileDeviceFileObserver);
    }
    this.jdField_a_of_type_ComTencentDeviceFileDeviceFileObserver = null;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      if (QLog.isDevelopLevel()) {
        throw new NullPointerException("丫的类型是不是搞错了？！");
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType != 6) {
        break label59;
      }
      k();
    }
    label59:
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType == 7)
      {
        i();
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType != 8);
    q();
  }
  
  public void a(Activity paramActivity)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend)
    {
      paramActivity = (TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().findViewById(2131299577);
      if (paramActivity != null) {
        paramActivity.setVisibility(0);
      }
      paramActivity = (Button)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().findViewById(2131299323);
      if (paramActivity != null) {
        paramActivity.setEnabled(true);
      }
      paramActivity = (TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().findViewById(2131299590);
      if (paramActivity != null) {
        paramActivity.setVisibility(0);
      }
      paramActivity = (TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().findViewById(2131299591);
      if (paramActivity != null) {
        paramActivity.setVisibility(0);
      }
    }
    h();
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType == 7) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 1) && (!this.jdField_b_of_type_Boolean)) {
      b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), "重新下载", 2130839635, 2130839636, a());
    }
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    int i;
    DeviceMsgHandle localDeviceMsgHandle;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      if (QLog.isDevelopLevel()) {
        throw new NullPointerException("丫的类型是不是搞错了？！");
      }
    }
    else
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath;
      a(2, "收藏", ActionBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
      a(2, FileManagerUtil.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType == 8) {
        a(2, false);
      }
      a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), "发给好友", 2130839627, 2130839628, ActionBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), 10000, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
      c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a());
      b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a());
      int j = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().e();
      i = j;
      if (j == 1) {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath))
        {
          i = j;
          if (new File(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath).exists()) {}
        }
        else
        {
          i = 0;
        }
      }
      if ((i != 3) && (i != 0) && (i != -1)) {
        break label397;
      }
      b();
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType == 8) && (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) && (!FileUtils.b(this.jdField_a_of_type_JavaLangString)))
      {
        paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.msgSeq);
        if ((paramObject != null) && ((paramObject instanceof MessageForDeviceSingleStruct)))
        {
          paramObject = (MessageForDeviceSingleStruct)paramObject;
          localDeviceMsgHandle = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(51);
          if (!a()) {
            break label461;
          }
          localDeviceMsgHandle.a().a(paramObject);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq = paramObject.nMediaSessionID;
        }
      }
    }
    label397:
    label461:
    while (localDeviceMsgHandle.a().a(paramObject))
    {
      return;
      if (i == 2)
      {
        f();
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) {
          break;
        }
        paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().findViewById(2131299577);
        if (paramObject == null) {
          break;
        }
        paramObject.setVisibility(8);
        break;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a());
      break;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 3;
    e();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) {}
    for (Object localObject2 = "恢复发送";; localObject2 = "恢复下载")
    {
      Object localObject1;
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType != 7) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq != 0L))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType == 6)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend)
          {
            localObject1 = localObject2;
            if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 0)
            {
              localObject1 = localObject2;
              if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress != 0.0F) {}
            }
          }
        }
      }
      else
      {
        localObject1 = "下载原文件";
      }
      localObject2 = localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType == 8)
      {
        localObject2 = localObject1;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress == 0.0F)
        {
          localObject2 = localObject1;
          if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) {
            localObject2 = "下载原文件";
          }
        }
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().findViewById(2131299577);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        g();
      }
      a(0, (String)localObject2, new ivt(this));
      return;
    }
  }
  
  public void b(Activity paramActivity)
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(8);
    if ((localDataLineHandler != null) && (DataLineHandler.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity))) {
      b(paramActivity, "发送到电脑", 2130839623, 2130839624, ActionBarUtil.a(localDataLineHandler, (BaseActivity)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().b() == 0) {
      b(paramActivity, "保存到平板", 2130839625, 2130839626, ActionBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
    }
    b(paramActivity, "存到微云", 2130839637, 2130839638, ActionBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
    super.b(paramActivity);
  }
  
  protected void c()
  {
    Object localObject;
    DataLineMsgRecord localDataLineMsgRecord;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType == 6) {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerDin == 0L)
      {
        localObject = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(8);
        localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a().b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
        if (localDataLineMsgRecord == null) {
          return;
        }
        if ((localDataLineMsgRecord.strMoloKey != null) && (DataLineMsgSet.isSingle(localDataLineMsgRecord)))
        {
          if (!localDataLineMsgRecord.isReportPause)
          {
            localDataLineMsgRecord.isReportPause = true;
            DataLineReportUtil.k(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a());
          }
          ((DataLineHandler)localObject).a(localDataLineMsgRecord.groupId, localDataLineMsgRecord.sessionid, false);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 3;
      return;
      if ((localDataLineMsgRecord.isReportPause) || (localDataLineMsgRecord.msgtype != -2335)) {
        break;
      }
      localDataLineMsgRecord.isReportPause = true;
      DataLineReportUtil.m(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a());
      break;
      ((RouterHandler)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(50)).a(0, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, false);
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType == 7)
      {
        this.jdField_a_of_type_Boolean = true;
        ((DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(8)).a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strDataLineMPFileID);
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType == 8)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.msgSeq);
        if (localObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_b_of_type_JavaLangString, 2, "get mr is null ");
          }
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 3;
          return;
        }
        if (((MessageRecord)localObject).isSendFromLocal())
        {
          if ((localObject instanceof MessageForDeviceFile))
          {
            localObject = (MessageForDeviceFile)localObject;
            ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(51)).a().a((MessageForDeviceFile)localObject);
          }
        }
        else if ((localObject instanceof MessageForDeviceSingleStruct))
        {
          localObject = (MessageForDeviceSingleStruct)localObject;
          ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(51)).a().b((MessageForDeviceSingleStruct)localObject);
        }
      }
    }
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType == 6) {
      l();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType == 7)
      {
        j();
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType != 8);
    r();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.BaseActionBarDataLineFile
 * JD-Core Version:    0.7.0.1
 */