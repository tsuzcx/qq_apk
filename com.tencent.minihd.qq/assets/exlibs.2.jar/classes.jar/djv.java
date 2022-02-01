import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;

public class djv
  implements Runnable
{
  public djv(BaseChatPie paramBaseChatPie, Intent paramIntent1, Intent paramIntent2) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.f(this.jdField_a_of_type_AndroidContentIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.G();
    if (this.b.getBooleanExtra("isFromShare", false))
    {
      this.b.removeExtra("forward_type");
      this.b.getExtras().remove("forward_type");
      this.b.removeExtra("isFromShare");
      String str = this.b.getExtras().getString("leftBackText");
      if ((str == null) || ("".equals(str))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getString(2131366374);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     djv
 * JD-Core Version:    0.7.0.1
 */