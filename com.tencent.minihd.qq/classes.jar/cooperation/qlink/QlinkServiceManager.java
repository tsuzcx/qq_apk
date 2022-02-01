package cooperation.qlink;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.OfflineFileMessageProcessor;
import com.tencent.mobileqq.filemanager.data.FMTransC2CMsgInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import lyg;

public class QlinkServiceManager
{
  private static final String jdField_a_of_type_JavaLangString = "QlinkServiceManager";
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QlinkServiceProxy jdField_a_of_type_CooperationQlinkQlinkServiceProxy;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  
  public QlinkServiceManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
    this.jdField_a_of_type_CooperationQlinkQlinkServiceProxy = new QlinkServiceProxy(paramQQAppInterface);
  }
  
  private int a(String paramString, Bundle paramBundle, Handler paramHandler, long paramLong)
  {
    paramHandler = new SendMsg(paramString);
    paramString = paramBundle;
    if (paramBundle == null) {
      paramString = new Bundle();
    }
    if ((paramString != null) && (paramString.size() > 0)) {
      paramHandler.a.putAll(paramString);
    }
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    paramHandler.a(i);
    if (paramLong > 0L) {
      paramHandler.a(paramLong);
    }
    try
    {
      this.jdField_a_of_type_CooperationQlinkQlinkServiceProxy.a(paramHandler);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      throw new RuntimeException("sendMsg is fail", paramString);
    }
  }
  
  public int a(String paramString, Bundle paramBundle)
  {
    try
    {
      int i = a(paramString, paramBundle, null, 0L);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  public void a()
  {
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler == null)
    {
      QLog.e("QlinkServiceManager", 1, "[QLINK] QQ - PluginCommunicationHandler.getInstance failed");
      return;
    }
    localPluginCommunicationHandler.register(new lyg(this, "qlink.notify"));
  }
  
  public void a(long paramLong) {}
  
  public boolean a(long paramLong1, int paramInt, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return true;
  }
  
  public boolean a(String paramString, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2)
  {
    FMTransC2CMsgInfo localFMTransC2CMsgInfo = new FMTransC2CMsgInfo();
    localFMTransC2CMsgInfo.subCmd = 8;
    localFMTransC2CMsgInfo.sessionId = paramInt2;
    localFMTransC2CMsgInfo.busiType = paramInt1;
    localFMTransC2CMsgInfo.msgSeq = FileManagerUtil.a();
    localFMTransC2CMsgInfo.msgUid = FileManagerUtil.b();
    if (((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(paramString))
    {
      QLog.i("QlinkServiceManager", 1, "[QLINK] QQ - send0x211C2CQlinkMsg to frirend:" + paramString + " transC2CMsgInfo:" + localFMTransC2CMsgInfo.toString());
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramString, 529, paramArrayOfByte1, localFMTransC2CMsgInfo);
    }
    QLog.i("QlinkServiceManager", 1, "[QLINK] QQ - send0x211C2CQlinkMsg to temp frirend:" + paramString + " transC2CMsgInfo:" + localFMTransC2CMsgInfo.toString());
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramString, 529, paramArrayOfByte2, 1, 124, paramArrayOfByte1, localFMTransC2CMsgInfo);
  }
  
  public boolean a(boolean paramBoolean, int paramInt)
  {
    return true;
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    return true;
  }
  
  public void b(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     cooperation.qlink.QlinkServiceManager
 * JD-Core Version:    0.7.0.1
 */