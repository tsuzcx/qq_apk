import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberInnerFrame;

public class gxk
  implements Runnable
{
  public gxk(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void run()
  {
    Object localObject = ((SelectMemberInnerFrame)this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).a();
    localObject = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(1000, localObject);
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gxk
 * JD-Core Version:    0.7.0.1
 */