import android.os.Handler;
import android.os.Message;
import com.tencent.open.agent.OpenSdkFriendService;
import java.util.ArrayList;

public class lbx
  implements Runnable
{
  public lbx(OpenSdkFriendService paramOpenSdkFriendService, Handler paramHandler) {}
  
  public void run()
  {
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService.a();
    Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 888802, localArrayList).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lbx
 * JD-Core Version:    0.7.0.1
 */