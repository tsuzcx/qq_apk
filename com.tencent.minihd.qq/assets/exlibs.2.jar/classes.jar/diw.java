import android.view.Window;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class diw
  implements Runnable
{
  public diw(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    this.a.b(true);
    this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().clearFlags(128);
    this.a.i(0);
    QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131366442, 1).b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     diw
 * JD-Core Version:    0.7.0.1
 */