import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

public class dvl
  implements Runnable
{
  public dvl(DiscussionInfoCardActivity paramDiscussionInfoCardActivity, String paramString) {}
  
  public void run()
  {
    ArrayList localArrayList = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app.getManager(51)).a(this.jdField_a_of_type_JavaLangString);
    if (localArrayList != null) {
      DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity, localArrayList.size());
    }
    Message localMessage = new Message();
    localMessage.what = 18;
    localMessage.obj = localArrayList;
    this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dvl
 * JD-Core Version:    0.7.0.1
 */