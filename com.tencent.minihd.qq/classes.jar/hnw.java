import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.log.ReportLog;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.pic.PresendPicMgrService;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.QLog;

public class hnw
  implements INetInfoHandler
{
  private hnw(QQAppInterface paramQQAppInterface) {}
  
  private void a()
  {
    NetworkCenter.a().b();
  }
  
  private void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("raw_photo", 2, "type:" + paramInt + ",logmsg:" + paramString);
    }
    if (1 == paramInt) {
      this.a.F();
    }
    while (2 != paramInt) {
      return;
    }
    this.a.G();
  }
  
  public void onNetMobile2None()
  {
    a(3, "onNetMobile2None");
    ReportLog.a("Network", "onNetMobile2None()");
    Handler localHandler = this.a.a(FileManagerNotifyCenter.class);
    if (localHandler != null) {
      localHandler.obtainMessage(10001, null).sendToTarget();
    }
    localHandler = this.a.a(Conversation.class);
    if (localHandler != null) {
      localHandler.obtainMessage(10001, QQAppInterface.a(this.a).getString(2131365730)).sendToTarget();
    }
    localHandler = this.a.a(ChatHistoryForC2C.class);
    if (localHandler != null) {
      localHandler.obtainMessage(23, null).sendToTarget();
    }
    FMTSrvAddrProvider.a().a();
    QQAppInterface.a(this.a);
    this.a.a().a(1);
    a();
    if (QQAppInterface.a(this.a) != null) {
      QQAppInterface.a(this.a).onNetMobile2None();
    }
  }
  
  public void onNetMobile2Wifi()
  {
    a(2, "onNetMobile2Wifi");
    ReportLog.a("Network", "onNetMobile2Wifi()");
    Object localObject = this.a.a(FileManagerNotifyCenter.class);
    if (localObject != null) {
      ((Handler)localObject).obtainMessage(10001, null).sendToTarget();
    }
    localObject = this.a.a(Conversation.class);
    if (localObject != null) {
      ((Handler)localObject).obtainMessage(10001, null).sendToTarget();
    }
    FMTSrvAddrProvider.a().a();
    QQAppInterface.a(this.a);
    this.a.a().a(1);
    a();
    if (QQAppInterface.a(this.a) != null) {
      QQAppInterface.a(this.a).onNetMobile2Wifi();
    }
    this.a.a();
    localObject = (EarlyDownloadManager)this.a.getManager(73);
    if (localObject != null) {
      ((EarlyDownloadManager)localObject).a();
    }
  }
  
  public void onNetNone2Mobile()
  {
    a(1, "onNetNone2Mobile");
    ReportLog.a("Network", "onNetNone2Mobile()");
    Object localObject = this.a.a(Conversation.class);
    if (localObject != null) {
      ((Handler)localObject).obtainMessage(10001, null).sendToTarget();
    }
    localObject = this.a.a(ChatHistory.class);
    if (localObject != null) {
      ((Handler)localObject).obtainMessage(6, null).sendToTarget();
    }
    localObject = this.a.a(ChatHistoryForC2C.class);
    if (localObject != null) {
      ((Handler)localObject).obtainMessage(22).sendToTarget();
    }
    FMTSrvAddrProvider.a().a();
    QQAppInterface.a(this.a);
    this.a.a().a(2);
    a();
    if (QQAppInterface.a(this.a) != null) {
      QQAppInterface.a(this.a).onNetNone2Mobile();
    }
    localObject = (EarlyDownloadManager)this.a.getManager(73);
    if (localObject != null) {
      ((EarlyDownloadManager)localObject).a();
    }
  }
  
  public void onNetNone2Wifi()
  {
    a(2, "onNetNone2Wifi");
    ReportLog.a("Network", "onNetNone2Wifi()");
    Object localObject = this.a.a(Conversation.class);
    if (localObject != null) {
      ((Handler)localObject).obtainMessage(10001, null).sendToTarget();
    }
    localObject = this.a.a(ChatHistory.class);
    if (localObject != null) {
      ((Handler)localObject).obtainMessage(6, null).sendToTarget();
    }
    localObject = this.a.a(ChatHistoryForC2C.class);
    if (localObject != null) {
      ((Handler)localObject).obtainMessage(22).sendToTarget();
    }
    FMTSrvAddrProvider.a().a();
    QQAppInterface.a(this.a);
    this.a.a().a(1);
    a();
    if (QQAppInterface.a(this.a) != null) {
      QQAppInterface.a(this.a).onNetNone2Wifi();
    }
    this.a.a();
    localObject = (EarlyDownloadManager)this.a.getManager(73);
    if (localObject != null) {
      ((EarlyDownloadManager)localObject).a();
    }
  }
  
  public void onNetWifi2Mobile()
  {
    a(1, "onNetWifi2Mobile");
    Object localObject = PresendPicMgrService.a();
    if (localObject != null) {
      ((PresendPicMgrService)localObject).c();
    }
    ReportLog.a("Network", "onNetWifi2Mobile()");
    localObject = this.a.a(FileManagerNotifyCenter.class);
    if (localObject != null) {
      ((Handler)localObject).obtainMessage(10001, null).sendToTarget();
    }
    localObject = this.a.a(Conversation.class);
    if (localObject != null) {
      ((Handler)localObject).obtainMessage(10001, null).sendToTarget();
    }
    FMTSrvAddrProvider.a().a();
    QQAppInterface.a(this.a);
    this.a.a().a(2);
    a();
    if (QQAppInterface.a(this.a) != null) {
      QQAppInterface.a(this.a).onNetWifi2Mobile();
    }
    localObject = (EarlyDownloadManager)this.a.getManager(73);
    if (localObject != null) {
      ((EarlyDownloadManager)localObject).a();
    }
  }
  
  public void onNetWifi2None()
  {
    a(3, "onNetWifi2None");
    ReportLog.a("Network", "onNetWifi2None()");
    Handler localHandler = this.a.a(FileManagerNotifyCenter.class);
    if (localHandler != null) {
      localHandler.obtainMessage(10001, null).sendToTarget();
    }
    localHandler = this.a.a(Conversation.class);
    if (localHandler != null) {
      localHandler.obtainMessage(10001, QQAppInterface.b(this.a).getString(2131365730)).sendToTarget();
    }
    localHandler = this.a.a(ChatHistoryForC2C.class);
    if (localHandler != null) {
      localHandler.obtainMessage(23, null).sendToTarget();
    }
    FMTSrvAddrProvider.a().a();
    QQAppInterface.a(this.a);
    this.a.a().a(1);
    a();
    if (QQAppInterface.a(this.a) != null) {
      QQAppInterface.a(this.a).onNetWifi2None();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hnw
 * JD-Core Version:    0.7.0.1
 */