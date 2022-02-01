import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.ProgressBar;
import com.dataline.util.DBNetworkUtil;
import com.dataline.util.QualityReportUtil;
import com.tencent.litetransfersdk.ReportItem;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.BaseActionBarDataLineFile;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqdataline.MpFileConstant;
import cooperation.qqdataline.ServerInfo;
import cooperation.qqdataline.ipc.DatalineRemoteManager;

public class ivw
  extends BroadcastReceiver
{
  public ivw(BaseActionBarDataLineFile paramBaseActionBarDataLineFile) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    long l1;
    label379:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              paramContext = paramIntent.getAction();
            } while (paramContext == null);
            if (!paramContext.equals("com.dataline.mpfile.download_progress")) {
              break;
            }
          } while (paramIntent.getLongExtra("token_task_id", 0L) != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
          l1 = paramIntent.getLongExtra("token_current_size", 0L);
          l2 = paramIntent.getLongExtra("token_total_size", 0L);
          this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
          this.a.f();
          this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)l1 / (float)l2);
          BaseActionBarDataLineFile.d(this.a);
          BaseActionBarDataLineFile.a(this.a).setProgress((int)(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress * 100.0F));
          return;
          if (!paramContext.equals("com.dataline.mpfile.download_completed")) {
            break;
          }
          l1 = paramIntent.getLongExtra("token_task_id", 0L);
        } while (l1 != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
        BaseActionBarDataLineFile.a(this.a, NetConnInfoCenter.getServerTimeMillis());
        long l2 = paramIntent.getLongExtra("token_current_size", 0L);
        boolean bool = paramIntent.getBooleanExtra("token_is_success", false);
        int j = paramIntent.getIntExtra("token_http_code", 0);
        paramContext = new ReportItem();
        paramContext.uSessionID = l1;
        paramContext.uChannelType = 6;
        paramContext.bSend = false;
        paramContext.uNotifyTime = BaseActionBarDataLineFile.a(this.a);
        paramContext.uFileSize = l2;
        paramContext.bFileExist = false;
        paramContext.uStartPos = 0L;
        paramContext.uTaskStart = BaseActionBarDataLineFile.a(this.a);
        paramContext.uTaskEnd = BaseActionBarDataLineFile.b(this.a);
        paramContext.uDuration = (BaseActionBarDataLineFile.b(this.a) - BaseActionBarDataLineFile.a(this.a));
        paramContext.bUserRetry = false;
        paramContext.sSuffix = "";
        int i;
        if (bool)
        {
          i = 2;
          paramContext.emResult = i;
          paramContext.nFailCode = 0;
          paramContext.nUserCode = j;
          paramIntent = ((DataLineHandler)this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(8)).a().a();
          if (paramIntent == null) {
            break label540;
          }
          paramContext.dwServerIP = DBNetworkUtil.a(paramIntent.jdField_a_of_type_JavaLangString);
          paramContext.wServerPort = ((short)paramIntent.jdField_a_of_type_Int);
          paramContext.dwClientIP = DBNetworkUtil.a(DBNetworkUtil.b());
          paramIntent = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a();
          if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerDin != 0L) {
            break label553;
          }
          i = QualityReportUtil.b;
          QualityReportUtil.a(paramIntent, paramContext, i);
          this.a.e();
          if (bool) {
            break label575;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 3;
          if (j != 2) {
            break label560;
          }
          FMToastUtil.a(2131362162);
        }
        for (;;)
        {
          this.a.b();
          ((DataLineHandler)this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(8)).a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strDataLineMPFileID);
          this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b();
          return;
          if (BaseActionBarDataLineFile.a(this.a))
          {
            i = 32;
            break;
          }
          i = 41;
          break;
          paramContext.dwServerIP = 0;
          paramContext.wServerPort = 0;
          break label379;
          i = QualityReportUtil.c;
          break label421;
          if (j == 8) {
            FMToastUtil.a(2131362181);
          }
        }
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
        paramContext = ((DataLineHandler)this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(8)).a().a();
        if (paramContext == null) {
          if (QLog.isColorLevel()) {
            QLog.d(BaseActionBarDataLineFile.a(), 2, "doDownload , plugin service not started");
          }
        }
        for (;;)
        {
          this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a());
          break;
          this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath = String.format("%s/%s", new Object[] { paramContext, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName });
        }
      } while (!paramContext.equals(MpFileConstant.d));
      l1 = paramIntent.getLongExtra(MpFileConstant.f, 0L);
    } while (BaseActionBarDataLineFile.c(this.a) != l1);
    label421:
    label553:
    label560:
    label575:
    BaseActionBarDataLineFile.c(this.a);
    label540:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ivw
 * JD-Core Version:    0.7.0.1
 */