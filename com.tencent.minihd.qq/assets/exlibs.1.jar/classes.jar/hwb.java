import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.qphone.base.util.QLog;

public class hwb
  implements Runnable
{
  public hwb(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public void run()
  {
    Object localObject = ((FriendManager)this.a.app.getManager(8)).a(this.a.app.a());
    if (localObject != null) {}
    while (!QLog.isColorLevel()) {
      try
      {
        localObject = ((Card)localObject).strLocationCodes.split("-");
        localObject[3] = "0";
        String str = this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b((String[])localObject);
        Message localMessage = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(1001);
        localMessage.obj = new Object[] { localObject, str };
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
        return;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d(ConditionSearchFriendActivity.a(), 2, "fillLocationData | exception: ", localException);
        return;
      }
    }
    QLog.d(ConditionSearchFriendActivity.a(), 2, "fillLocationData | card is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hwb
 * JD-Core Version:    0.7.0.1
 */