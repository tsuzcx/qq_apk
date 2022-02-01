import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.device.msg.data.DevSingleStructMsgProcessor;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.BaseActionBarDataLineFile;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ivt
  implements View.OnClickListener
{
  public ivt(BaseActionBarDataLineFile paramBaseActionBarDataLineFile) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.e(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a()))
    {
      BaseActionBarDataLineFile.a(this.a, System.currentTimeMillis());
      FMToastUtil.a(2131362551);
      return;
    }
    ivv localivv;
    int j;
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType == 6) {
      if ((FileManagerUtil.a()) && (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize > 5242880L))
      {
        paramView = new ivu(this);
        localivv = new ivv(this);
        if (!this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) {
          break label718;
        }
        j = 2131362055;
      }
    }
    for (int i = 2131362465;; i = 2131362466)
    {
      String str = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().getString(i);
      DialogUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), 230, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().getString(j), str, 2131365736, 2131362063, paramView, localivv).show();
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerDin == 0L)
      {
        paramView = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
        if (paramView != null) {
          paramView.setPaused(false);
        }
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) {
        BaseActionBarDataLineFile.a(this.a);
      }
      for (;;)
      {
        this.a.f();
        return;
        BaseActionBarDataLineFile.b(this.a);
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType == 7)
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize == 0L)
        {
          BaseActionBarDataLineFile.a(this.a, System.currentTimeMillis());
          FMToastUtil.a("'" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName + "'" + BaseApplication.getContext().getResources().getString(2131362117));
          return;
        }
        if ((this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerDin == 0L) && (((RegisterProxySvcPackHandler)this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(9)).a() == 0))
        {
          BaseActionBarDataLineFile.a(this.a, System.currentTimeMillis());
          FMToastUtil.a(2131362155);
          return;
        }
        BaseActionBarDataLineFile.c(this.a);
        this.a.f();
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType != 8) {
        break;
      }
      paramView = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.msgSeq);
      if (paramView == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(BaseActionBarDataLineFile.a(), 2, "get mr is null ");
        return;
      }
      if (paramView.isSendFromLocal()) {
        if ((paramView instanceof MessageForDeviceFile))
        {
          paramView = (MessageForDeviceFile)paramView;
          paramView = ((DeviceMsgHandle)this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(51)).a().a(paramView.strServiceName, paramView);
          this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 0.0F;
          this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq = paramView.uSessionID;
          this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.msgSeq = paramView.uniseq;
          this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
        }
      }
      for (;;)
      {
        this.a.f();
        return;
        if ((paramView instanceof MessageForDeviceSingleStruct))
        {
          paramView = (MessageForDeviceSingleStruct)paramView;
          paramView = ((DeviceMsgHandle)this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(51)).a().a(paramView);
          this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 0.0F;
          this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq = paramView.nMediaSessionID;
          this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.msgSeq = paramView.uniseq;
          this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
        }
      }
      label718:
      j = 2131362058;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ivt
 * JD-Core Version:    0.7.0.1
 */