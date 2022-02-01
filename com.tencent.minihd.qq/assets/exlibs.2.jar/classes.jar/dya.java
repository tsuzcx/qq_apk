import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.ForwardHandlerActivity;

public class dya
  implements Runnable
{
  public dya(ForwardHandlerActivity paramForwardHandlerActivity, Intent paramIntent) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityForwardHandlerActivity.a(this.jdField_a_of_type_AndroidContentIntent);
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromShare", false))
    {
      this.jdField_a_of_type_AndroidContentIntent.removeExtra("forward_type");
      this.jdField_a_of_type_AndroidContentIntent.getExtras().remove("forward_type");
      this.jdField_a_of_type_AndroidContentIntent.removeExtra("isFromShare");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dya
 * JD-Core Version:    0.7.0.1
 */