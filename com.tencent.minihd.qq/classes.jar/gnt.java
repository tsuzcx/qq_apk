import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;

public class gnt
  implements Runnable
{
  public gnt(MainAssistObserver paramMainAssistObserver, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b();
      if (localRedTypeInfo != null) {
        localRedTypeInfo.red_type.set(0);
      }
      Message localMessage = this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a.obtainMessage(0);
      localMessage.obj = localRedTypeInfo;
      this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a.sendMessage(localMessage);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gnt
 * JD-Core Version:    0.7.0.1
 */